import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";

import {Book} from "../shared/book.model";
import {BooksService} from "../shared/books.service";


@Component({
    moduleId: module.id,
    selector: 'books-list',
    templateUrl: './books-list.component.html',
    styleUrls: ['./books-list.component.css'],
})
export class BooksListComponent implements OnInit {
    errorMessage: string;
    books: Book[];
    selectedBook: Book;

    constructor(private booksService: BooksService,
                private router: Router) {
    }

    ngOnInit(): void {
        this.getBooks();
    }

    getBooks() {
        this.booksService.getBooks()
            .subscribe(
                books => this.books = books,
                error => this.errorMessage = <any>error
            );
    }

    onSelect(book: Book): void {
        this.selectedBook = book;
    }

    gotoDetail(): void {
        this.router.navigate(['/books/detail', this.selectedBook.id]);
    }

    deleteBook(): void {
      this.booksService.deleteBook(this.selectedBook.id).subscribe(
        (res) => {
          console.log("book deleted");
          this.getBooks();
        }
      );
      this.selectedBook = null;
    }

    public addBook(book: Book): void {
      this.books.push(book);
    }
}
