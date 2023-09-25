import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Sensor } from '../models/sensor.model';


@Injectable({
  providedIn: 'root'
})
export class ReadSensorService {
  
  constructor(private http: HttpClient) { }
  
  getSensor(url:string) {
  
    return this.http.get<Sensor>(url);
  }
}


