import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Sensor } from '../models/sensor.model';


@Injectable({
  providedIn: 'root'
})
export class ReadSensorService {
  // url='http://localhost:8080/api/v1/sensors/sensor/';
  urn='http://192.168.0.100:9000/api/v1/sensors/';
  constructor(private http: HttpClient) { }
  
  getSensor(uri:string) {
    const options = {responseType: 'json' as const,};
    return this.http.get<Sensor>(this.urn.concat(uri.toString()),options);
  }
}


