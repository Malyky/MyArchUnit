package com.consol.dependency;

import com.consol.MyMainClass;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packagesOf = MyMainClass.class)
public class DependencyTest {

/*    @ArchTest
    public static final ArchRule moreComplexDepenendcy = // TODO*/



}
