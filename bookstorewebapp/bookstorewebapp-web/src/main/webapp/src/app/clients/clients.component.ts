import { Component, OnInit, ViewChild } from '@angular/core';

import { Client } from "./shared/client.model";
import { ClientsListComponent } from "./clients-list/clients-list.component";

@Component({
  selector: 'clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.css']
})
export class ClientsComponent implements OnInit {

  @ViewChild('clientsList') clientsList: ClientsListComponent;

  constructor() { }

  ngOnInit() {
  }

  clientCreated(client) {
    this.clientsList.addClient(client);
  }

}
