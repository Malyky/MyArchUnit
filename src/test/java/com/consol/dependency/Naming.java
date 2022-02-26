package com.consol.dependency;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.springframework.stereotype.Controller;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.consol.controller" )
public class Naming {

    @ArchTest
    public static final ArchRule someRule = classes().that().resideInAPackage("..controller..")
            .should().resideInAnyPackage("..rofl..") ;

    @ArchTest
    public static final ArchRule controller_naming_convention =
            ArchRuleDefinition.classes().that().resideInAnyPackage("..controller..").and().areAnnotatedWith(Controller.class)
                    .should().haveNameMatching(".*Controller");

}
