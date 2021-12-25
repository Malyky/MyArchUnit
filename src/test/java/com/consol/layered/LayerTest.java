package com.consol.layered;

import com.consol.MyMainClass;
import com.consol.inheritance.SuperConnection;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.Architectures;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packagesOf = MyMainClass.class, importOptions = ImportOption.DoNotIncludeTests.class)
public class LayerTest {


   @ArchTest
    public static final ArchRule should_have_layers =
            Architectures.layeredArchitecture()
                    .layer("controller").definedBy("..controller..")
                    .layer("service").definedBy("..service..")
                    .layer("persistence").definedBy("..persistence..")
                    .whereLayer("controller").mayNotBeAccessedByAnyLayer()
                    .whereLayer("service").mayOnlyBeAccessedByLayers("controller")
                    .whereLayer("persistence").mayOnlyBeAccessedByLayers("service");

}
