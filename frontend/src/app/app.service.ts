import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Estudiante } from './estudiante';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  constructor(private http: HttpClient) { }

  getEstudiantes():Observable<Estudiante[]>{
      return this.http.get<Estudiante[]>('escuela/estudiantes');
  }

  crearEstudiante(est:Estudiante){   
    return this.http.post(`/escuela/estudiante`, est);
  }

}
