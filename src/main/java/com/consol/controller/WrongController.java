package com.consol.controller;

import com.consol.service.BookService;
import org.springframework.stereotype.Controller;

@Controller
public class WrongController {

    String t;

    public void doSth(){
        BookService bookService = new BookService(); //for cycles

    }

    private void foo() {

    }

    public String getT() {
        return t;
    }
}
