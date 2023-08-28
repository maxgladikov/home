import { Component } from '@angular/core';
import { Sensor } from 'src/app/models/sensor.model';
import { ReadSensorService } from 'src/app/service/read-sensor.service';
@Component({
  selector: 'app-sensors',
  templateUrl: './sensors.component.html',
  styleUrls: ['./sensors.component.css']
})
export class SensorsComponent {
  name='Pidor';
  sensor:Sensor;
  foreground='green';
  isHidden=false;
  url='http://localhost:8080/sensor';
  constructor(private sensorService: ReadSensorService) {
    this.sensorService.getSensor(this.url).subscribe(
      (data: Sensor) => this.sensor = { ...data }
      )
  }
}
