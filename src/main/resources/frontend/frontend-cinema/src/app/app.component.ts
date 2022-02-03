import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, NgForm } from '@angular/forms';
import { Subscription } from 'rxjs';
import { ClientService } from './services/client.services';
import { ReservationService } from './services/reservation.services';
import { SceanceService } from './services/sceance.services';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit,OnDestroy {
  title = 'frontend-cinema';

  clientSelect:number = 0;
  sceanceSelect:number = 0;
  nbPlaces:number = 0;
  reservationList:any[] = [];
  reservationSubscription!:Subscription;
  clientList:any[] = [];
  clientSubscription!:Subscription;
  sceanceList:any[] = [];
  sceanceSubscription!:Subscription;

  constructor(private reservationService:ReservationService,private sceanceService:SceanceService,private formBuilder: FormBuilder,private clientService:ClientService){}

  ngOnDestroy(): void {
    this.reservationSubscription.unsubscribe();
    this.clientSubscription.unsubscribe();
    this.sceanceSubscription.unsubscribe();
  }
  onSubmitForm(form:NgForm) {
    this.reservationService.addReservation(this.sceanceSelect,this.clientSelect,this.nbPlaces)
    console.log(this.clientSelect);
    console.log(this.sceanceSelect);
    console.log(this.nbPlaces);
    }

  async ngOnInit(){
    this.reservationList = await this.reservationService.reservationSubscribe(this.reservationSubscription);
    this.clientList = await this.clientService.clientSubscribe(this.clientSubscription);
    this.sceanceList = await this.sceanceService.sceanceSubscribe(this.sceanceSubscription);
  }
}
