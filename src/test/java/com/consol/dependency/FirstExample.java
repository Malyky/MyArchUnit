package com.consol.dependency;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.consol.controller" )
public class FirstExample {

    @ArchTest
    public static final ArchRule someRule = classes().that().resideInAPackage("..controller..").should().resideInAnyPackage("..rofl..") ;

    @ArchTest
    public final ArchRule t2 =
            ArchRuleDefinition.classes().that().resideInAnyPackage("..controller..")
                    .should().haveNameMatching(".*Configurationte");

}
