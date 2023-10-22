import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Sensor } from '../models/sensor.model';


@Injectable({
  providedIn: 'root'
})
export class ReadSensorService {
  url='http://localhost:8080/api/v1/sensors/sensor/';
  constructor(private http: HttpClient) { }
  
  getSensor(uri:string) {
  
const options = {responseType: 'json' as const,};
    return this.http.get<Sensor>(this.url.concat(uri.toString()),options);
  }
}


