package com.consol.custom;


import com.consol.MyMainClass;
import com.consol.service.Payload;
import com.consol.service.Secured;
import com.tngtech.archunit.base.DescribedPredicate;
import com.tngtech.archunit.core.domain.*;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;

import java.util.Set;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packagesOf = MyMainClass.class, importOptions = ImportOption.DoNotIncludeTests.class)
public class CustomTest {
    /*
    @ArchTest
    public static final ArchRule classes_with_fields_annotated_with_payloud_should_be_secured = todo*/


}
