package com.consol.dependency;

import com.consol.connection.Connection;
import com.consol.inheritance.SuperConnection;
import com.sun.tools.javac.Main;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.consol.connection")
public class InheritanceCheck {

    @ArchTest
    public static final ArchRule connection_inheritance_check = classes().that().areAssignableTo(Connection.class)
            .should().haveSimpleNameEndingWith("Connection");


/*   @ArchTest
    public static final ArchRule connection_inheritance_check = classes().that().areAssignableFrom(SuperConnection.class)
            .should().haveSimpleNameEndingWith("SuperConnection");*/



   // assignableTo => Extended


}
