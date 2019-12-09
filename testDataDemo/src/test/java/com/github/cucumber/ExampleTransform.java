package com.github.cucumber;

import cucumber.api.Transform;
import cucumber.api.Transformer;

public class ExampleTransform extends Transformer<Example> {
    @Override
    public Example transform(String s) {
        return  Example.valueOf(s.toUpperCase());
    }
}
