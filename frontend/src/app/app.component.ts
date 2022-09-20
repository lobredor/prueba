import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AppService } from './app.service';
import { Estudiante } from './estudiante';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  title = 'frontend';
  estudiantes: Estudiante[] = [];
  form!: FormGroup;

  constructor(private appService: AppService,
    public fb: FormBuilder) {  
  }

  ngOnInit(): void {
    this.crearFormulario()
    this.obtenerEstudiantes()
  }

  obtenerEstudiantes() {
    this.appService.getEstudiantes().subscribe(resp => {
      this.estudiantes = resp
    })
  }

  guardarEstudiante() {
    Swal.fire({
      icon: 'info',
      title: 'Espere...',
      text: 'Guardando Informacion!',
      allowOutsideClick: false
    });
    Swal.showLoading();
    try {
      if (this.form.invalid) {
        return;
      } else {
        this.appService.crearEstudiante(this.form.value).subscribe(result => {
          if (result) {
            setTimeout(() => {
              Swal.fire({
                icon: 'success',
                title: 'OK',
                text: 'Guardado Correctamente!',
                allowOutsideClick: false
              });
              this.obtenerEstudiantes()
              this.form.reset();
            }, 1000);
          } else {
            Swal.fire({
              icon: 'error',
              title: 'Upsss..',
              text: 'Ha ocurrido un error, identificación duplicada!',
              allowOutsideClick: false
            });
          }
        }, error => {
          console.error(error);
          Swal.fire({
            icon: 'error',
            title: 'Upsss..',
            text: 'No hay conexion con el servidor!',
            allowOutsideClick: false
          });
          this.form.reset();
        });
      }
    } catch (error) {
      console.error(error);
    }
  }

  crearFormulario() {
    this.form = this.fb.group({
      identificacion: [null, [Validators.required]],
      nombre: [null, [Validators.required]],
      apellido: [null, [Validators.required]],
      edad: [null, [Validators.minLength(1), Validators.maxLength(2), Validators.required]],
      carrera: [null, Validators.required]
    });
  }
}
