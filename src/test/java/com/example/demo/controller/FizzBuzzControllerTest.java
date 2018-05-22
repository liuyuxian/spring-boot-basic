package com.example.demo.controller;

import com.example.demo.controller.FizzBuzzController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FizzBuzzControllerTest {
    FizzBuzzController fb;
    @Before
    public void before(){
        fb=new FizzBuzzController();
        System.out.println("Test start!");
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

    @After
    public void after(){
        System.out.println("Test end!");
    }

}
