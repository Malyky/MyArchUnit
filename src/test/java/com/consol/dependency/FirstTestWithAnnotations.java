package com.consol.dependency;

import com.consol.MyMainClass;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packagesOf = MyMainClass.class)
public class FirstTestWithAnnotations {

    @ArchTest
    public static final ArchRule services_should_have_service_in_name = classes().that(

    ).resideInAnyPackage("..service..").should().haveNameMatching(".*Service")
            .because("Naming should be precise ");

    @ArchTest
    public static final ArchRule services_should_not_access_controllers = noClasses().that(

    ).resideInAnyPackage("..service..").should().dependOnClassesThat().resideInAnyPackage("..controller..")
            .because("4.1 dependency check");
}
