package com.consol.dependency;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

import java.util.Collections;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.GeneralCodingRules.ACCESS_STANDARD_STREAMS;

@AnalyzeClasses(packages = "de.consol.controller" )
public class ArchunitTests {

    @ArchTest
    public static final ArchRule someRule = classes().that().resideInAPackage("..controller..").should().resideInAnyPackage("..rofl..") ;

    @ArchTest
    public final ArchRule t2 =
            ArchRuleDefinition.classes().that().resideInAnyPackage("..controller..")
                    .should().haveNameMatching(".*Configurationte");

}
