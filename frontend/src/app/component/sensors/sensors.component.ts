import { Component } from '@angular/core';
import { Sensor } from 'src/app/models/sensor.model';
import { ReadSensorService } from 'src/app/service/read-sensor.service';
@Component({
  selector: 'app-sensors',
  templateUrl: './sensors.component.html',
  styleUrls: ['./sensors.component.css']
})
export class SensorsComponent {
  title = 'sensors';
  foreground='grey';
  isHidden=false;
  
  sensors=new Set<string>(['bedroom','basement','masterbedroom','livingroom']);
  sensorRecords=new Set<Sensor>;
  constructor(private sensorService: ReadSensorService) {
    this.sensors.forEach(x => this.sensorService.getSensor(x).subscribe( 
      (data: Sensor) => this.sensorRecords.add(data),
      err => this.sensorRecords.add(new Sensor()),
      () => console.log('Observer got a complete notification')
      )
    );
  }

}
