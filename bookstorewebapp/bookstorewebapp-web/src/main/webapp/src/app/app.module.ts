import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { BooksComponent } from './books/books.component';
import { AppRoutingModule } from "./app-routing.module";
import { ClientsComponent } from './clients/clients.component';
import { BooksListComponent } from './books/books-list/books-list.component';
import { BookDetailComponent } from './books/book-detail/book-detail.component';
import { ClientsListComponent } from './clients/clients-list/clients-list.component';
import { ClientDetailsComponent } from './clients/client-details/client-details.component';

import { BooksService } from './books/shared/books.service';
import { ClientsService } from './clients/shared/clients.service';
import { OrdersService } from './orders/shared/orders.service';
import { CreateClientComponent } from './clients/create-client/create-client.component';
import { CreateBookComponent } from './books/create-book/create-book.component';
import { OrdersComponent } from './orders/orders.component';
import { OrdersListComponent } from './orders/orders-list/orders-list.component';
import { CreateOrderComponent } from './orders/create-order/create-order.component';
import { OrderDetailsComponent } from './orders/order-details/order-details.component';

@NgModule({
  declarations: [
    AppComponent,
    BooksComponent,
    ClientsComponent,
    BooksListComponent,
    BookDetailComponent,
    ClientsListComponent,
    ClientDetailsComponent,
    CreateClientComponent,
    CreateBookComponent,
    OrdersComponent,
    OrdersListComponent,
    CreateOrderComponent,
    OrderDetailsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule
  ],
  providers: [BooksService, ClientsService, OrdersService],
  bootstrap: [AppComponent]
})
export class AppModule { }
