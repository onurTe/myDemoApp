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
  public void testReturnedNegThird() {
    ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
    ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
assertEquals(new App().search(array, array2, 5, 3), -3);
  }
@Test
  public void testReturnedZero() {
  ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
    ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
assertEquals(new App().search(array, array2, 3, 3), 0);
  }
@Test
  public void testReturnedPozOne() {
  ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
    ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
assertEquals(new App().search(array, array2, 3, 2), 1);
  }
@Test
public void testReturnedNegOne() {
ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
assertEquals(new App().search(array, array2, 2, 3), -1);
}
@Test
public void nullTest() {
  assertEquals(new App().search(null,null,3,4),-3);
}
@Test
public void emptyArrayTest() {
  ArrayList<Integer> array = new ArrayList<>();
  ArrayList<Integer> array2 = new ArrayList<>();
  assertEquals(new App().search(array,array2,3,4),-3);
}
}