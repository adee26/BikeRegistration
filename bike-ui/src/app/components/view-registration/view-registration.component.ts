import { Component, OnInit } from '@angular/core';
import {BikeService} from '../../services/bike.service';
import {ActivatedRoute} from '@angular/router';
import {formatDate} from '@angular/common';

@Component({
  selector: 'app-view-registration',
  templateUrl: './view-registration.component.html',
  styleUrls: ['./view-registration.component.scss']
})
export class ViewRegistrationComponent implements OnInit {
  public bikeReg;

  constructor(private bikeService: BikeService, private activatedRoute: ActivatedRoute) { }


  ngOnInit(): void {
    this.getBikeReg(this.activatedRoute.snapshot.params.id);
  }

  getBikeReg(id: number){
    this.bikeService.getBikeById(id).subscribe(
    data => {
      this.bikeReg = data;
    }, error => console.log());
  }

  getDateFormatted(myDate){
    const format = 'dd/MM/yyyy';
    return formatDate(this.bikeReg.purchaseDate, format, 'en-US');
  }

}
