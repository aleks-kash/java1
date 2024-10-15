package org.example.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringUtilTest {

    static StringUtil stringUtil;

    @BeforeEach
    void setUp(){
        System.out.println("Before each test");
    }

    @BeforeAll
    static void beforeAll(){
        System.out.println("Before all test");
        stringUtil = new StringUtil();
    }

    @Test
    public void testReverse_InputInNull(){
        System.out.println("testReverse_InputInNull");
        String actual = stringUtil.reverse(null);
        assertNull(actual);
    }

    @Test
    public void testReverse_InputIsEmptyString() {
        System.out.println("testReverse_InputIsEmptyString");
        String actual = stringUtil.reverse("");
        String expected = "";
        assertEquals(expected, actual);
    }
}
