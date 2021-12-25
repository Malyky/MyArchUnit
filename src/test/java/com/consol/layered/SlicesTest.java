package com.consol.layered;

import com.consol.MyMainClass;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.Architectures;
import com.tngtech.archunit.library.dependencies.SlicesRuleDefinition;

@AnalyzeClasses(packagesOf = MyMainClass.class, importOptions = ImportOption.DoNotIncludeTests.class)
public class SlicesTest {

    @ArchTest
    public static final ArchRule should_not_have_cycles = SlicesRuleDefinition.slices().matching("com.consol.(*)..").should().beFreeOfCycles();
}
