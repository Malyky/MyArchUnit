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


    private static DescribedPredicate<JavaClass> haveFieldAnnotatedWithPayload =
            new DescribedPredicate<JavaClass>("Have a field with Annotation Payload") {
                @Override
                public boolean apply(JavaClass input) {
                    for (JavaField field : input.getAllFields()) {
                        if (field.isAnnotatedWith(Payload.class)) {
                            return true;
                        }
                    }

                    return false;
                }
            };



    private static ArchCondition<? super JavaClass> onlyBeAccesedBySecureMethods = new ArchCondition<JavaClass>("only be accesed by secure methods") {
        @Override
        public void check(JavaClass item, ConditionEvents events) {
            Set<JavaMethodCall> methodCallsToSelf = item.getMethodCallsToSelf();
            for (JavaMethodCall javaMethodCall : methodCallsToSelf) {
                if (!javaMethodCall.getOrigin().isAnnotatedWith(Secured.class)) {
                    String message = String.format(
                            "Method %s is not @Secured", javaMethodCall.getOrigin().getFullName());
                    events.add(SimpleConditionEvent.violated(javaMethodCall, message));
                }
            }

        }
    }
            ;
    @ArchTest
    public static final ArchRule ww = classes().that(haveFieldAnnotatedWithPayload).should(onlyBeAccesedBySecureMethods);


}
