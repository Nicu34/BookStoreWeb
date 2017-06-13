import {Component, Input, OnInit} from '@angular/core';

import {ActivatedRoute, Params} from "@angular/router";
import {Location} from '@angular/common';


import 'rxjs/add/operator/switchMap';
import {Book} from "../shared/book.model";
import {BooksService} from "../shared/books.service";


@Component({
    selector: 'book-detail',
    templateUrl: './book-detail.component.html',
    styleUrls: ['./book-detail.component.css'],
})

export class BookDetailComponent implements OnInit {

    @Input()
    book: Book;

    constructor(private booksService: BooksService,
                private route: ActivatedRoute,
                private location: Location) {
    }

    ngOnInit(): void {
        this.route.params
            .switchMap((params: Params) => this.booksService.getBook(+params['id']))
            .subscribe(book => this.book = book);
    }

    update(): void {
        this.booksService.updateBook(this.book.id, this.book.title, this.book.author, this.book.price)
            .subscribe(function(res) {
              console.log(res);
            });
    }

    goBack(): void {
        this.location.back();
    }
}
