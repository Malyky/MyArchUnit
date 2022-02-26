package com.consol.controller;

import com.consol.service.BookService;
import org.springframework.stereotype.Controller;

@Controller
public class WrongController {

    String emptyControllerField;

    public void doSth(){
        BookService bookService = new BookService(); //for cycles
        if (!emptyControllerField.isEmpty()) {
            setEmptyControllerField("");
        }

    }

    private void foo() {

    }

    public String getEmptyControllerField() {
        return emptyControllerField;
    }

    public void setEmptyControllerField(String emptyControllerField) {
        this.emptyControllerField = emptyControllerField;
    }
}
