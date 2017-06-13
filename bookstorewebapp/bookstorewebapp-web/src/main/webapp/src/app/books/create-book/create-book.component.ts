import { Component, OnInit, Output, EventEmitter } from '@angular/core';

import { Book} from "../shared/book.model"
import {BooksService} from "../shared/books.service"

@Component({
  selector: 'create-book',
  templateUrl: './create-book.component.html',
  styleUrls: ['./create-book.component.css']
})
export class CreateBookComponent implements OnInit {

  @Output()
  bookCreated = new EventEmitter();

  constructor(private booksService: BooksService) { }

  ngOnInit() {
  }


  create(title:string, author: string, price:number): void {
    this.booksService.createBook(title, author, price).subscribe(
      (res) => {
        let book = new Book();
        let body = res.json();
        console.log(body);
        book.id = body['id'];
        book.title = body['title'];
        book.author = body['author'];
        book.price = body['price'];
        this.bookCreated.emit(book);
      }
    );
  }
}
