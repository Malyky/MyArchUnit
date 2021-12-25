package com.consol;

import com.consol.controller.WrongController;
import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "de.consol", importOptions = ImportOption.DoNotIncludeTests.class)
public class NoobTest {

    @ArchTest
    public static final ArchRule service_should_be_private = classes().should().bePrivate();


    @ArchTest
    public static final ArchRule someRule =
            classes().that().areAnnotatedWith(ArchTest.class)
                    .should().haveNameMatching(".*Configurationte");

    @Test
    public void testMe(){
        JavaClasses importedClasses = new ClassFileImporter().importPackages("de.consol");
        //new ClassFileImporter().withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
        JavaClass next = new ClassFileImporter().withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS).importPackagesOf(WrongController.class).stream().iterator().next();

        ArchRule archRule = classes().that().resideInAPackage("..consol..").should().bePrivate();

        archRule.check(importedClasses);
    }

}
