package com.consol.controller;

import com.consol.service.BookService;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    String someField;

    public void doSth(){
        BookService bookService = new BookService();//for cycles
        bookService.doSomething();

        if (!someField.isEmpty()) {
            setSomeField("blub");
        }

    }

    private void foo() {

    }

    public String getSomeField() {
        return someField;
    }

    public void setSomeField(String someField) {
        this.someField = someField;
    }
}
