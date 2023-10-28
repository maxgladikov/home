import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { SensorRecord } from '../models/sensorRecord.model';
import { Sensor } from '../models/sensor.model';

@Injectable({
  providedIn: 'root'
})
export class ReadSensorService {
  // url='http://localhost:8080/api/v1/sensors/sensor/';
  urn='http://192.168.0.100:9000/api/v1/sensors/';
  constructor(private http: HttpClient) { }
  
  getSensorRecord(uri:string):Observable<SensorRecord> {
    const options = {responseType: 'json' as const,};
    return this.http.get<SensorRecord>(this.urn.concat(uri.toString()),options);
  }

  getSensors():Observable<Sensor[]>{
    const options = {responseType: 'json' as const,};
    return this.http.get<Sensor[]>(this.urn,options);
  }


}


