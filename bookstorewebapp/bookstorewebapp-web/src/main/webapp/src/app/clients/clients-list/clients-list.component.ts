import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";

import {Client} from "../shared/client.model";
import {ClientsService} from "../shared/clients.service";


@Component({
    moduleId: module.id,
    selector: 'clients-list',
    templateUrl: './clients-list.component.html',
    styleUrls: ['./clients-list.component.css'],
})
export class ClientsListComponent implements OnInit {

    clients: Client[];

    errorMessage: string;
    selectedClient: Client;


    constructor(private clientsService: ClientsService,
                private router: Router) {
    }

    ngOnInit(): void {
        this.getClients();
    }

    getClients() {
        this.clientsService.getClients()
            .subscribe(
                clients => this.clients = clients,
                error => this.errorMessage = <any>error
            );
    }

    onSelect(client: Client): void {
        this.selectedClient = client;
    }

    gotoDetail(): void {
        this.router.navigate(['/clients/detail', this.selectedClient.id]);
    }

    deleteClient(): void {
      this.clientsService.deleteClient(this.selectedClient.id).subscribe(
        (res) => {
          console.log("client deleted");
          this.getClients();
        }
      );
      this.selectedClient = null;
    }

    public addClient(client: Client): void {
      this.clients.push(client);
    }
}
