package com.consol.dependency;

import com.consol.controller.WrongController;
import com.tngtech.archunit.core.domain.JavaAccess;
import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import com.tngtech.archunit.lang.syntax.elements.ClassesShouldConjunction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packages = "com.consol")
public class FirstTest {


    @ArchTest
    public static final ArchRule serviceControllerDependencyTest = noClasses().that().resideInAPackage("..service..").should().accessClassesThat().resideInAPackage("..controller..");

    @ArchTest
    public static final ArchRule controllerShouldOnlyBeAccessedByUI = classes().that().resideInAPackage("..controller..").should().onlyBeAccessed().byAnyPackage("..ui..", "..controller..");

}