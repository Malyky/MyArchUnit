package com.consol.service;

import com.consol.controller.BookController;
import com.consol.persistence.User;
import org.springframework.stereotype.Service;
@Service
public class BookService {

    User user;
    public void doSomething(){

        new BookController().getSomeField();
        user.doSth();
    }

    ;
}
