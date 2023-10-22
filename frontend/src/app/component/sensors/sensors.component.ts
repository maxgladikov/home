import { Component } from '@angular/core';
import { Sensor } from 'src/app/models/sensor.model';
import { ReadSensorService } from 'src/app/service/read-sensor.service';
@Component({
  selector: 'app-sensors',
  templateUrl: './sensors.component.html',
  styleUrls: ['./sensors.component.css']
})
export class SensorsComponent {

  sensor:Sensor;
  foreground='grey';
  isHidden=false;
  url='basment';
  constructor(private sensorService: ReadSensorService) {
    this.sensorService.getSensor(this.url).subscribe(
      (data: Sensor) => this.sensor = { ...data }
      )
  }
}
