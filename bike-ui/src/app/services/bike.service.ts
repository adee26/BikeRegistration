import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

const httpOption = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})

@Injectable()
export class BikeService {

  constructor(private http: HttpClient) {
  }

  getBikes(){
    return this.http.get('/server/api/v1/bikes');
  }

  getBikeById(id: number){
    return this.http.get('/server/api/v1/bikes/' + id);
  }

  saveBike(bike) {
    // let body = JSON.stringify(bike);
    return this.http.post('/server/api/v1/bikes', bike, httpOption);
  }

  getBikeBySeller(seller: string){
    return this.http.get('/server/api/v1/bikes/seller/' + seller);
  }
}
