import { Injectable } from '@angular/core';
import { Http, Response } from "@angular/http";
import { Headers, RequestOptions } from '@angular/http';

import { Client } from "./client.model";

import { Observable } from "rxjs";
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';


@Injectable()
export class ClientsService {

  private clientsUrl = 'http://localhost:8080/api/clients';

  constructor(private http: Http) {
  }

  getClients(): Observable<Client[]> {
    return this.http.get(this.clientsUrl)
      .map(this.extractData)
      .catch(this.handleError);
  }

  private extractData(res: Response) {
    let body = res.json();
    return body.clients || {};
  }

  private handleError(error: Response | any) {
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Observable.throw(errMsg);
  }

  getClient(id: number): Observable<Client> {
    return this.getClients()
      .map(clients => clients.find(client => client.id === id));
  }

  deleteClient(id: number): Observable<Response> {
    return this.http.delete(this.clientsUrl + '/' + id);
  }

  updateClient(id: number, name: string): Observable<Response> {
    let body = { "id": id, "name": name };
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    return this.http.put(this.clientsUrl + '/' + id, JSON.stringify(body), options);
  }

  createClient(name: string): Observable<Response> {
    let body = { "name": name };
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    return this.http.post(this.clientsUrl, JSON.stringify(body), options);
  }
}
