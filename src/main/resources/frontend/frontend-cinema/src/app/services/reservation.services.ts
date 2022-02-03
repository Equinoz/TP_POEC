import { Injectable, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http'
import { Subject, Subscription } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ReservationService{
  
 

    private url = "http://localhost:8080/WS/reservation/";
    //private url = window.location.protocol+"/WS/reservation/";
    private reservation:any[] = [];
    private idx:number = 0;

    public reservationSubject = new Subject();

    constructor(private httpClient:HttpClient){}

    addReservation(sceanceSelect: number, clientSelect: number, nbPlaces: number) {
      const headers = { 'content-type': 'application/json'}  
      let r ={
        "client": {"clientId": clientSelect},
        "sceance": {"sceanceId": sceanceSelect},
        "nombrePlaces": nbPlaces,
        "reduction": "0"
      } 
      this.httpClient.post(this.url,r).subscribe(
        (response) =>{
          this.getAllFromServer();
          console.log (response)}
      );
    }

    async reservationSubscribe(resSubscription:Subscription):Promise<any[]>{
        // Récupération de la base de donnée
        this.getAllFromServer();
        // Instanciation du tableau à retourner
        let app:any[] = [];
        // Abonnement et mise à jour du tableau
        resSubscription = this.reservationSubject.subscribe(
            (p: any) => {
            app = p;
            }
        );
        // Emission de la mise à jour du tableau
        this.emitReservationSubject();
        return app;
    }

    emitReservationSubject(){
        this.reservationSubject.next(this.reservation);
    }

    getAllFromServer(){
      this.httpClient.get<any[]>(this.url,{responseType:'json'}).subscribe(
        response => {
          if(response != undefined){
            this.idx=0;
            this.reservation = [];
          for(let o of response){
            this.idx++; 
            this.reservation.push(o);
          }
        }
         this.emitReservationSubject();  
         console.log(this.reservation);
        }
      );
    }
}