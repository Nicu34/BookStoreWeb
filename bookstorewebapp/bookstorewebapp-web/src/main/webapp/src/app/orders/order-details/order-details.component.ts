import { Component, OnInit, Input } from '@angular/core';

import { ActivatedRoute, Params } from '@angular/router'
import { Location } from '@angular/common'

import 'rxjs/add/operator/switchMap';
import {Order} from "../shared/order.model";
import {OrdersService} from "../shared/orders.service";

import {Client} from "../../clients/shared/client.model";
import {ClientsService} from "../../clients/shared/clients.service";

import {Book} from "../../books/shared/book.model";
import {BooksService} from "../../books/shared/books.service";

@Component({
  selector: 'order-details',
  templateUrl: './order-details.component.html',
  styleUrls: ['./order-details.component.css']
})
export class OrderDetailsComponent implements OnInit {

  errorMessage: string;
  @Input()
  order: Order;
  clients: Client[];
  books: Book[];

  constructor(private ordersService: OrdersService,
           private clientService: ClientsService,
           private bookService: BooksService,
           private route: ActivatedRoute,
           private location: Location) { }

  ngOnInit(): void {
    this.route.params
            .switchMap((params: Params) => this.ordersService.getOrder(+params['id']))
            .subscribe(order => this.order = order);

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

  update(): void {
        this.ordersService.updateOrder(this.order.id, this.order.client.id, this.order.book.id)
            .subscribe(function(res) {
              console.log(res);
            });
    }

    goBack(): void {
        this.location.back();
    }

}
