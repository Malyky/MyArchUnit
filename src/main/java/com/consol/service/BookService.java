package com.consol.service;

import com.consol.ArchitectureUtil;
import com.consol.persistence.User;
import org.springframework.stereotype.Service;
@Service
public class BookService {

    User user;
    public void doSomething(){
      //   new WrongController(); // 4.1 // remove this for cycles
   //     ArchitectureUtil.callWrongController();

        User user;
        ArchitectureUtil.callWrongController();
    }

    ;
}
