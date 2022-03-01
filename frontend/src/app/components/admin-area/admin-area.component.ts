import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-area',
  templateUrl: './admin-area.component.html',
  styleUrls: ['./admin-area.component.css']
})
export class AdminAreaComponent implements OnInit{


  data: any;

  chartOptions: any;

  // subscription: Subscription;

  config: any;

  constructor() {

  }

  ngOnInit() {

    this.data = {
      labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
      datasets: [{
          type: 'line',
          label: 'Dataset 1',
          borderColor: '#42A5F5',
          borderWidth: 2,
          fill: false,
          data: [
              50,
              25,
              12,
              48,
              56,
              76,
              42
          ]
      }, {
          type: 'bar',
          label: 'Dataset 2',
          backgroundColor: '#66BB6A',
          data: [
              21,
              84,
              24,
              75,
              37,
              65,
              34
          ],
          borderColor: 'white',
          borderWidth: 2
      }, {
          type: 'bar',
          label: 'Dataset 3',
          backgroundColor: '#FFA726',
          data: [
              41,
              52,
              24,
              74,
              23,
              21,
              32
          ]
      }]
  };

}

updateChartOptions() {
  if (this.config.dark)
      this.applyDarkTheme();
  else
      this.applyLightTheme();
}

applyLightTheme() {
  this.chartOptions = {
      plugins: {
          legend: {
              labels: {
                  color: '#495057'
              }
          }
      },
      scales: {
          x: {
              ticks: {
                  color: '#495057'
              },
              grid: {
                  color: '#ebedef'
              }
          },
          y: {
              ticks: {
                  color: '#495057'
              },
              grid: {
                  color: '#ebedef'
              }
          }
      }
  }
}

applyDarkTheme() {
  this.chartOptions = {
      plugins: {
          legend: {
              labels: {
                  color: '#ebedef'
              }
          }
      },
      scales: {
          x: {
              ticks: {
                  color: '#ebedef'
              },
              grid: {
                  color: 'rgba(255,255,255,0.2)'
              }
          },
          y: {
              ticks: {
                  color: '#ebedef'
              },
              grid: {
                  color: 'rgba(255,255,255,0.2)'
              }
          }
      }
  };
}

}
