import { Component } from '@angular/core';
import { ReadSensorService } from 'src/app/service/read-sensor.service';
import {Observable,of} from 'rxjs';
import {
  tap,
  map,
  finalize,
  mergeMap,
  catchError,
  flatMap,
  toArray,
  timeout
} from "rxjs/operators";
import { SensorRecord } from 'src/app/models/sensorRecord.model';

@Component({
  selector: 'app-sensors',
  templateUrl: './sensors.component.html',
  styleUrls: ['./sensors.component.css'],
})
export class SensorsComponent {
  displayedColumns = [ 'name', 'temperature', 'pressure', 'humidity'];
  sensorRecords$:Observable<SensorRecord[]>;
  dataSource:SensorRecord[];
  
  constructor(private sensorService: ReadSensorService) {
  //   this.sensorService.getSensors().subscribe( 
  //     (data: Sensor[]) => this.sensors=data,
  //     err => console.error(err),
  //     () => console.log(this.sensors),
  // );

  const sensors$=this.sensorService.getSensors();
  // const sensorRecords$=this.sensorService.getSensorRecord();
  // this.sensorService.getSensors()
  //       .pipe(
  //         // tap(sensors => this.sensors=sensors),
  //         // map(sensors => this.sensors.map),
  //         // map(sensor => console.error("* "+sensor)),
  //       )
  //       .subscribe( {
  //       next(data:Sensor[]){console.log(data);},
  //       error(msg){console.error(msg);}
  // });
  //   this.sensors.forEach(x => this.sensorService.getSensorRecord(x.name).subscribe( 
  //     (data: SensorRecord) => this.sensorRecords.add(data),
  //     err => this.sensorRecords.add(new SensorRecord()),
  //     () => console.log()
  //     )
  //   );
  // this.sensorService.getSensors().pipe(
  //       map((res:Sensor[])  => this.sensors=res)
  //       , mergeMap(() => this.sensors.forEach(x => this.sensorService.getSensorRecord(x.name) )
  //       , map((res) => console.log(res))
  //   ).subscribe(() => console.log('Chain executed successfully. Good job :)'));

     this.sensorRecords$= this.sensorService.getSensors()
                              .pipe(
                                flatMap(sensors => sensors),
                                mergeMap(sensor=>{return this.sensorService.getSensorRecord(sensor.name) }),
                                timeout(1000),
                                tap((sensor:SensorRecord)=>console.log(sensor)),
                                catchError(error => of(new SensorRecord())),
                                toArray<SensorRecord>(),
                                
                                finalize(()=>{})
                              );
      this.sensorRecords$.pipe(
        map(array=>{this.dataSource=array})
      ).subscribe();

    // sensorRecords$.subscribe({ next(records:SensorRecord[]){console.log(records);},
    //                           error(msg){console.error("*******ERROR*******");},        
    //                           complete() {}
    //                           });
  }
  ngOnInit() {}
}
