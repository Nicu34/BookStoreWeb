import { Component, OnInit, ViewChild } from '@angular/core';

import { Order } from "./shared/order.model";
import { OrdersListComponent } from "./orders-list/orders-list.component";

@Component({
  selector: 'orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  @ViewChild('ordersList') ordersList: OrdersListComponent;

  constructor() { }

  ngOnInit() {
  }

  orderCreated(order) {
    this.ordersList.addOrder(order);
  }

}
