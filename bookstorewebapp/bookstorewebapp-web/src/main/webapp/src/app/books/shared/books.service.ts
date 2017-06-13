import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from "@angular/http";

import { Book } from "./book.model";

import { Observable } from "rxjs";
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';


@Injectable()
export class BooksService {

  private booksUrl = 'http://localhost:8080/api/books';

  constructor(private http: Http) {
  }

  getBooks(): Observable<Book[]> {
    return this.http.get(this.booksUrl)
      .map(this.extractData)
      .catch(this.handleError);
  }

  private extractData(res: Response) {
    let body = res.json();
    return body.books || {};
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

  getBook(id: number): Observable<Book> {
    return this.getBooks()
      .map(books => books.find(book => book.id === id));
  }

  deleteBook(id: number): Observable<Response> {
    return this.http.delete(this.booksUrl + '/' + id);
  }

  updateBook(id: number, title: string, author: string, price: number): Observable<Response> {
    let body = { "id": id, "title": title, "author": author, "price": price};
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    return this.http.put(this.booksUrl + '/' + id, JSON.stringify(body), options);
  }

  createBook(title: string, author: string, price: number): Observable<Response> {
    let body = { "title": title, "author": author, "price": parseFloat(price.toString())};
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    return this.http.post(this.booksUrl, JSON.stringify(body), options);
  }
}
