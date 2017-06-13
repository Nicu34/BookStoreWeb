import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { BooksComponent }       from "./books/books.component";
import { BookDetailComponent }  from "./books/book-detail/book-detail.component";

import { ClientsComponent }       from "./clients/clients.component";
import { ClientDetailsComponent }  from "./clients/client-details/client-details.component";

import { OrdersComponent }       from "./orders/orders.component";
import { OrderDetailsComponent }       from "./orders/order-details/order-details.component";

const routes: Routes = [
    // { path: '', redirectTo: '/home', pathMatch: 'full' },
    { path: 'books',     component: BooksComponent },
    { path: 'books/detail/:id', component: BookDetailComponent},

    { path: 'clients',     component: ClientsComponent },
    { path: 'clients/detail/:id', component: ClientDetailsComponent},

    { path: 'orders',     component: OrdersComponent },
    { path: 'orders/detail/:id',     component: OrderDetailsComponent },
];

@NgModule({
    imports: [ RouterModule.forRoot(routes) ],
    exports: [ RouterModule ]
})
export class AppRoutingModule {}
