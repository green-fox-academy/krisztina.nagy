package com.greenfoxacademy.lib.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.greenfoxacademy.lib.Models.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BookController {

    private List<Book> books = new ArrayList<>();

    public BookController() {
        books.add(new Book("Cat's Cradle", "Kurt Vonnegut", 1963));
        books.add(new Book("Do Androids Dream of Electric Sheep?", "Philip K. Dick", 1968));
    }

    @GetMapping(path = "/books")
    public String showBooks(Model model) {
        model.addAttribute("books", books);
        return "index";
    }

    @GetMapping(path = "/books/{id}/details")
    public String getBookById(Model model, @PathVariable(name="id") Integer id) {
        Book bookById = null;

        for(Book book : books) {
            if (book.getId() == id) {
                bookById = book;
            }
        }

        if (bookById != null) {
            model.addAttribute("book", bookById);
        } else {
            model.addAttribute("error", "No book found");
        }

        return "details";
    }

    @GetMapping(path = "/books")
    public String queryBooks(Model model, @RequestParam(name = "author", required = false) String author) {

        List<Book> queriedBooks;

        if (author != null) {
            queriedBooks = filterBooksByAuthor(author);
        } else {
            queriedBooks = books;
        }

        model.addAttribute("books", queriedBooks);
        return "index";
    }

    private List<Book> filterBooksByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/books/add")
    public String addBookForm(Model model, @ModelAttribute(name="book") Book book) {
        model.addAttribute("book", book);
        return "create";
    }

    @PostMapping(path = "/books/add")
    public String addBook(@ModelAttribute(name="book") Book book) {
        books.add(book);
        return "redirect:/books";
    }



}