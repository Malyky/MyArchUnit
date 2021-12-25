package com.consol;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packagesOf = MyMainClass.class)
public class GeneralCodingRules {

    @ArchTest
    public final static ArchRule should_not_use_system_out_calls = noClasses().should(com.tngtech.archunit.library.GeneralCodingRules.ACCESS_STANDARD_STREAMS);
}
