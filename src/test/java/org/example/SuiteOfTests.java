package org.example;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({HelloWorldTest.class , MyClassTest.class})
public class SuiteOfTests {
}