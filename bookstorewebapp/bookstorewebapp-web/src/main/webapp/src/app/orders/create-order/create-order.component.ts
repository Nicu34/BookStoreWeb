import {Component, OnInit, Input, Output, EventEmitter} from '@angular/core';
import {Router} from "@angular/router";
import {OrdersService} from "../shared/orders.service";
import {ClientsService} from "../../clients/shared/clients.service";
import {Order} from "../shared/order.model";
import {BooksService} from "../../books/shared/books.service";
import { Location } from '@angular/common'
import {Book} from "../../books/shared/book.model";
import {Client} from "../../clients/shared/client.model";

@Component({
  selector: 'create-order',
  templateUrl: './create-order.component.html',
  styleUrls: ['./create-order.component.css']
})
export class CreateOrderComponent implements OnInit {
  errorMessage: string;
  @Input() order: Order;
  clients: Client[];
  books: Book[];

  constructor(private router: Router,
              private orderService: OrdersService,
              private clientService: ClientsService,
              private bookService: BooksService,
              private location: Location) { }

  ngOnInit() {
    this.clientService.getClients()
      .subscribe(
        clients => this.clients = clients,
        error => this.errorMessage = <any>error
      );
    this.bookService.getBooks()
      .subscribe(
        books => this.books = books,
        error => this.errorMessage = <any>error
      );
  }

  goBack(): void {
    this.location.back();
  }

  save(client, book): void {
    console.log("saving order: client=" + client + ", book=" + book);
    if(!this.isValid(client.id, book.id)) {
      console.log("Invalid input");
      alert("Invalid input");
      return ;
    }
    this.orderService.createOrder(client.id, book.id)
      .subscribe(_ => console.log('created'));
  }

  private isValid(clientId, bookId): boolean {
    if(!clientId || !bookId)
      return false;
    return true;
  }

}
