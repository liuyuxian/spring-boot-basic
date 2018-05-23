package com.example.demo.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by LIUAL8 on 5/23/2018.
 */
public class AnagramsTests {
    @Test
    public void return_emptyarray_given_emptystring() throws Exception {
        List<String> list = Anagrams.run("");
        assertTrue(list.size() == 0);
    }

    @Test
    public void return_one_char_given_one_char() throws Exception {
        List<String> list = Anagrams.run("a");
        assertEquals(Arrays.asList("a"),list);
    }

    @Test
    public void return_two_char_given_two_char() throws Exception {
        List<String> list = Anagrams.run("ab");
        assertEquals(Arrays.asList("ab","ba"),list);
    }

    @Test
    public void return_over_two_char_given_over_two_char_str() throws Exception {
        List<String> list = Anagrams.run("abc");
        assertEquals(Arrays.asList("abc","acb","bac","bca","cab","cba"), list);
    }
}
