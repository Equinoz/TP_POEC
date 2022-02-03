import { Injectable, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http'
import { Subject, Subscription } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class SceanceService{

    private url = "http://localhost:8080/WS/sceance/";
    //private url = window.location.protocol+"/WS/reservation/";
    private sceance:any[] = [];
    private idx:number = 0;

    public sceanceSubject = new Subject();

    constructor(private httpClient:HttpClient){}

    async sceanceSubscribe(resSubscription:Subscription):Promise<any[]>{
        // Récupération de la base de donnée
        this.getAllFromServer();
        // Instanciation du tableau à retourner
        let app:any[] = [];
        // Abonnement et mise à jour du tableau
        resSubscription = this.sceanceSubject.subscribe(
            (p: any) => {
            app = p;
            }
        );
        // Emission de la mise à jour du tableau
        this.emitSceanceSubject();
        return app;
    }

    emitSceanceSubject(){
        this.sceanceSubject.next(this.sceance);
    }

    getAllFromServer(){
      this.httpClient.get<any[]>(this.url,{responseType:'json'}).subscribe(
        response => {
          if(response != undefined){
          for(let o of response){
            this.idx++; 
            this.sceance.push(o);
          }
        }
         this.emitSceanceSubject();  
        }
      );
    }
}