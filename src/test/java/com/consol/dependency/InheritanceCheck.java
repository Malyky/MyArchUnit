package com.consol.dependency;

import com.consol.inheritance.connection.Connection;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.consol.inheritance.connection")
public class InheritanceCheck {

    @ArchTest
    public static final ArchRule connection_inheritance_check = classes().that().areAssignableTo(Connection.class)
            .should().haveSimpleNameEndingWith("Connection");


}
