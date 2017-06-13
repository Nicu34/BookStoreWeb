import {Component, Input, OnInit} from '@angular/core';

import {ActivatedRoute, Params} from "@angular/router";
import {Location} from '@angular/common';

import 'rxjs/add/operator/switchMap';
import {Client} from "../shared/client.model";
import {ClientsService} from "../shared/clients.service";


@Component({
    selector: 'client-detail',
    templateUrl: './client-details.component.html',
    styleUrls: ['./client-details.component.css'],
})

export class ClientDetailsComponent implements OnInit {

    @Input()
    client: Client;

    constructor(private clientsService: ClientsService,
                private route: ActivatedRoute,
                private location: Location) {
    }

    ngOnInit(): void {
        this.route.params
            .switchMap((params: Params) => this.clientsService.getClient(+params['id']))
            .subscribe(client => this.client = client);
    }

    update(): void {
        this.clientsService.updateClient(this.client.id, this.client.name)
            .subscribe(function(res) {
              console.log(res);
            });
    }

    goBack(): void {
        this.location.back();
    }
}
