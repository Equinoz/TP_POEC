import { Injectable, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http'
import { Subject, Subscription } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ClientService{

    private url = "http://localhost:8080/WS/client/";
    //private url = window.location.protocol+"/WS/client/";
    private client:any[] = [];
    private idx:number = 0;

    public clientSubject = new Subject();

    constructor(private httpClient:HttpClient){}

    async clientSubscribe(resSubscription:Subscription):Promise<any[]>{
        // Récupération de la base de donnée
        this.getAllFromServer();
        // Instanciation du tableau à retourner
        let app:any[] = [];
        // Abonnement et mise à jour du tableau
        resSubscription = this.clientSubject.subscribe(
            (p: any) => {
            app = p;
            }
        );
        // Emission de la mise à jour du tableau
        this.emitClientSubject();
        return app;
    }

    emitClientSubject(){
        this.clientSubject.next(this.client);
    }

    getAllFromServer(){
      this.httpClient.get<any[]>(this.url,{responseType:'json'}).subscribe(
        response => {
          if(response != undefined){
          for(let o of response){
            this.idx++; 
            this.client.push(o);
          }
        }
         this.emitClientSubject();  
        }
      );
    }
}