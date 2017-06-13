import { Component, OnInit, ViewChild } from '@angular/core';

import { Book } from "./shared/book.model";
import { BooksListComponent } from "./books-list/books-list.component";

@Component({
  selector: 'books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {

  @ViewChild('booksList') booksList: BooksListComponent;

  constructor() { }

  ngOnInit() {
  }

  bookCreated(book) {
    this.booksList.addBook(book);
  }
}
