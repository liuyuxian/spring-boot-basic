package com.example.demo.domain;

import com.example.demo.controller.FizzBuzzController;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTests {
    FizzBuzzController fb;
    @Before
    public void before(){
        fb=new FizzBuzzController();
    }

    @Test
    public void should_return_fizz_when_input_3() {
        String result = fb.getResult(3);
        assertThat(result).isEqualTo("fizz");
    }

    @Test
    public void should_return_buzz_when_input_5() {
        String result = fb.getResult(5);
        assertThat(result).isEqualTo("buzz");
    }

    @Test
    public void should_return_fizzbuzz_when_input_15() {
        String result = fb.getResult(15);
        assertThat(result).isEqualTo("fizzbuzz");
    }

    @Test
    public void should_return_7_when_input_7() {
        String result = fb.getResult(7);
        assertThat(result).isEqualTo("7");
    }

    @Test
    public void should_return_unsupport_0_when_input_0() {
        String result = fb.getResult(0);
        assertThat(result).isEqualTo("Unsupport 0!");
    }


}
