package com.mycompany.app;
import org.junit.Test;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * Unit test for simple App.
 */

public class AppTest extends TestCase
{
    @Test
    public void testFound() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        assertTrue(new App().search(array, 4));
      }
    @Test
      public void testNotFound() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        assertFalse(new App().search(array, 5));
      }
    @Test
      public void testEmptyArray() {
        ArrayList<Integer> array = new ArrayList<>();
        assertFalse(new App().search(array, 1));
      }
    @Test
      public void testNull() {
        assertFalse(new App().search(null, 1));
      }

}