package com.consol.service;

import com.consol.ArchitectureUtil;
import com.consol.controller.WrongController;
import com.consol.persistence.User;
import org.springframework.stereotype.Service;
@Service
public class BookService {

    User user;
    public void doSomething(){
      //   new WrongController(); // 4.1 // remove this for cycles

        new WrongController().getEmptyControllerField();
        User user;
    }

    ;
}
