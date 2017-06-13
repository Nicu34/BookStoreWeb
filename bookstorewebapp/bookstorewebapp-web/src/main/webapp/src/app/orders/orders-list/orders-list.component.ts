import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

import {Order} from "../shared/order.model";
import {OrdersService} from "../shared/orders.service";

@Component({
  selector: 'orders-list',
  templateUrl: './orders-list.component.html',
  styleUrls: ['./orders-list.component.css']
})
export class OrdersListComponent implements OnInit {

  errorMessage: string;
  orders: Order[];
  selectedOrder: Order;

  constructor(private ordersService: OrdersService,
              private router: Router) { }

  ngOnInit() {
    this.getOrders();
  }

  onSelect(order: Order) {
    this.selectedOrder = order;
  }

  deleteOrder(): void {
      this.ordersService.deleteOrder(this.selectedOrder.id).subscribe(
        (res) => {
          console.log("order deleted");
          this.getOrders();
        }
      );
      this.selectedOrder = null;
    }

  gotoDetail(): void {
      this.router.navigate(['/orders/detail', this.selectedOrder.id]);
  }

  getOrders() {
    this.ordersService.getOrders()
      .subscribe(
        orders => this.orders = orders,
        error => this.errorMessage = <any>error
      );
  }

  public addOrder(order: Order): void {
    this.orders.push(order);
  }
}
