import { Component, OnInit } from '@angular/core';
import {BikeService} from '../../services/bike.service';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Observable} from 'rxjs';
import {Router} from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  models: string[] = [
    'Globo MTB 29 Full Suspension',
    'Globo Carbon Fiber Race Series',
    'Globo Time Trial Blade',
  ];
  sellers: string[] = [
    'Emag',
    'Decathlon'
  ];
  bikeform: FormGroup;
  validMessage = '';
  constructor(private bikeService: BikeService, private router: Router) { }

  ngOnInit(): void {
    this.bikeform = new FormGroup({
      name : new FormControl('', Validators.required),
      email : new FormControl('', Validators.required),
      phone : new FormControl('', Validators.required),
      model : new FormControl('', Validators.required),
      serialNumber : new FormControl('', Validators.required),
      purchasePrice : new FormControl('', Validators.required),
      purchaseDate : new FormControl('', Validators.required),
      seller: new FormControl('', Validators.required),
      contact : new FormControl(),
    });
  }


  submitRegistration(){
    if (this.bikeform.valid){
      this.validMessage = 'Registration succesfull';
      this.bikeService.saveBike(this.bikeform.value).subscribe(
        data => {
          console.log(data);
          /** if you want to redirect after save*/
          this.router.navigate(['/admin']);
          this.bikeform.reset();
          return true;
        },
        error => {
          return Observable.throw(error);
        }
      );
    } else {
      this.validMessage = 'Please fill out the form before submitting!';
    }
  }


}
