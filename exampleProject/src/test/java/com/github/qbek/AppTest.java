package com.github.qbek;

import static org.junit.Assert.assertTrue;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Unit test for simple App.
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "classpath:features", tags = "@mock")
public class AppTest 
{}
