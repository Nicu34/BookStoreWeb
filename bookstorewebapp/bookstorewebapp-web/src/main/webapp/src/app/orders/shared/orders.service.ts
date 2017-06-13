import { Injectable } from '@angular/core';
import { Http, Response } from "@angular/http";
import { Headers, RequestOptions } from '@angular/http';

import { Order } from "./order.model";

import { Observable } from "rxjs";
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';


@Injectable()
export class OrdersService {

  private ordersUrl = 'http://localhost:8080/api/orders';

  constructor(private http: Http) {
  }

  getOrders(): Observable<Order[]> {
    return this.http.get(this.ordersUrl)
      .map(this.extractData)
      .catch(this.handleError);
  }

  private extractData(res: Response) {
    let body = res.json();
    console.log(body);
    return body.orders || {};
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

  getOrder(id: number): Observable<Order> {
    return this.getOrders()
      .map(orders => orders.find(order => order.id === id));
  }

  deleteOrder(id: number): Observable<Response> {
    return this.http.delete(this.ordersUrl + '/' + id);
  }

  createOrder(clientId: number, bookId: number): Observable<Response> {
    let body = { "clientId": clientId, "bookId": bookId };
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    return this.http.post(this.ordersUrl, JSON.stringify(body), options);
  }

  updateOrder(orderId: number, clientId: number, bookId: number): Observable<Response> {
    let body = { "orderId": orderId, "bookId": bookId, "clientId": clientId };
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    return this.http.put(this.ordersUrl + '/' + orderId, JSON.stringify(body), options);
  }
}
