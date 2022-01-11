package com.msj.devbiblico.controller;

import com.msj.devbiblico.model.Profile;
import com.msj.devbiblico.model.ProfileEnum;
import com.msj.devbiblico.model.User;
import com.msj.devbiblico.payload.request.LoginRequest;
import com.msj.devbiblico.payload.request.SignupRequest;
import com.msj.devbiblico.payload.response.JwtResponse;
import com.msj.devbiblico.payload.response.MessageResponse;
import com.msj.devbiblico.repository.ProfileRepository;
import com.msj.devbiblico.repository.UserRepository;
import com.msj.devbiblico.security.jwt.JwtUtils;
import com.msj.devbiblico.security.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> profiles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                                                 userDetails.getId(),
                                                 userDetails.getUsername(),
                                                 userDetails.getEmail(),
                                                 profiles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest) {

        if (userRepository.existsByUsername(signupRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        //Criar novo usuário
        User user = new User(signupRequest.getUsername(),
                             signupRequest.getEmail(),
                             passwordEncoder.encode(signupRequest.getPassword()));

        Set<String> strProfiles = signupRequest.getProfile();
        Set<Profile> profiles = new HashSet<>();

        if (strProfiles == null) {
            Profile userProfile = profileRepository.findByName(ProfileEnum.PERFIL_USUARIO)
                    .orElseThrow(() -> new RuntimeException("Error: Profile is not found"));
            profiles.add(userProfile);
        } else {

            strProfiles.forEach(profile -> {

                switch (profile) {
                    case "admin":
                        Profile adminProfile = profileRepository.findByName(ProfileEnum.PERFIL_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Profile is not found"));
                        profiles.add(adminProfile);
                        break;

                    case "mod":
                        Profile modProfile = profileRepository.findByName(ProfileEnum.PERFIL_MODERADOR)
                                .orElseThrow(() -> new RuntimeException("Error: Profile is not found"));
                        profiles.add(modProfile);
                        break;

                    default:
                        Profile userProfile = profileRepository.findByName(ProfileEnum.PERFIL_USUARIO)
                                .orElseThrow(() -> new RuntimeException("Error: Profile is not found"));
                        profiles.add(userProfile);
                }
            });
        }

        user.setProfiles(profiles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registred sucessfully"));
    }
}
