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

public class FirstTest {

    @Test
    public void firstTest(){
        JavaClasses importedClasses = new ClassFileImporter().importPackages("com.consol");
        //new ClassFileImporter().withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
        JavaClass next = new ClassFileImporter().withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS).importPackagesOf(WrongController.class).stream().iterator().next();

        for (JavaClass importedClass : importedClasses) {
            if (importedClass.getName().contains(".service")) {
                for (JavaAccess<?> javaAccess : importedClass.getAccessesFromSelf()) {
                    if (javaAccess.getTargetOwner().getName().contains(".controller")) {
                        Assertions.fail("Class " + importedClass.getName() + " should not access Controller " + javaAccess.getTargetOwner().getName()); //WrongCOntroller
                    }
                }

            }
        }


    }




}