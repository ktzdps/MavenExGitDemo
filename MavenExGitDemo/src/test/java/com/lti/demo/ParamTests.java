package com.lti.demo;

import static org.junit.jupiter.api.Assertions.*;


import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.lti.entity.Calculator;

class ParamTests {

	@Disabled
	@ParameterizedTest
	@ValueSource(ints= {8,10,20,50,100})
	public void testArrays(int arg)
	{
		System.out.println("arg : "+ arg);
		Assertions.assertTrue(arg%2==0);
	}
	
	@Disabled
	@ParameterizedTest(name = "#{index} = {0}")
	@DisplayName("Should Pass all non-null arguments methods")
	//@ValueSource(strings= {"Hello","World","Hello World","Hi","Hello GET1024"})
	@ValueSource(strings= {"Hello","Hello World","Hello GET1024"})
	public void testParam(String msg)
	{
		String searchKey ="Hello";
		Assertions.assertTrue(msg.contains(searchKey));
	}
	
	//login 3 attempts - same code
	
	@RepeatedTest(3)
	public void shouldRepeat()
	{
		int x=10,y=20;
		assertEquals(200, x*y);
	}
	
	
	//Junit 5 supports Lambda
	
	@Test
	public void testLambda()
	{
		Integer[] intAry = {2,3,7,5,10};
		List<Integer> numbers = Arrays.asList(intAry);
		
		Assertions.assertAll( 
				() -> assertEquals(2,numbers.get(0)),
				() -> assertEquals(3,numbers.get(1)),
				() -> assertEquals(7,numbers.get(2)),
				() -> assertEquals(5,numbers.get(3)),
				() -> assertEquals(10,numbers.get(4))
				);
	
	}
	
	@Test
	void testException()
	{
		Assertions.assertThrows(IllegalArgumentException.class,() -> {
			Integer.parseInt("One");
		});
	}
	
	  @Test
	  void testException1() {

		  Calculator c= new Calculator();
		  
		  final Exception e = assertThrows(ArithmeticException.class, () -> {
			  c.searchEmpId(0);
	    
	    });
	    Assertions.assertEquals("u enetered zero",e.getMessage());
	  }

}
