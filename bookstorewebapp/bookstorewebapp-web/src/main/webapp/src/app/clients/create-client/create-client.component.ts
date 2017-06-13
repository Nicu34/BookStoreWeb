import { Component, OnInit, Output, EventEmitter } from '@angular/core';

import {Client} from "../shared/client.model";
import {ClientsService} from "../shared/clients.service";

@Component({
  selector: 'create-client',
  templateUrl: './create-client.component.html',
  styleUrls: ['./create-client.component.css']
})
export class CreateClientComponent implements OnInit {

  @Output()
  clientCreated = new EventEmitter();

  constructor(private clientsService: ClientsService) { }

  ngOnInit() {
  }

  create(name:string): void {
    this.clientsService.createClient(name).subscribe(
      (res) => {
        let client = new Client();
        let body = res.json();
        console.log(body);
        client.id = body['id'];
        client.name = body['name'];
        this.clientCreated.emit(client);
      }
    );
  }
}
