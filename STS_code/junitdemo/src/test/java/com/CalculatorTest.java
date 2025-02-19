package com;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

@DisplayName("Testing Arithmetic Operations")
@TestInstance(Lifecycle.PER_CLASS )
class CalculatorTest {
    
	CalculatorTest(){
		System.out.println("<<----------- CalculatorTest object created -------->>");
	}
	static Calculator c1 ;
	static int x=2;
	static boolean condition = false;
	
	@BeforeAll 
	static void createCalculator() {
		c1 = new Calculator ();
		System.out.println("------------Started-----------");
	}
	 
	@AfterAll
	static void removeCalculator() {
		c1 = null ;
		System.out.println("---------- Finished -----------");
	}
	
	
	@BeforeEach
	void abc(){
		System.out.println("Before each test case ....");
	}
	
	@AfterEach
	void xyz(){
		System.out.println("After each test case ....");
	}
	
	
	@Test
	@Disabled
	void test() {
		assertTrue(true);
	}
   
	@Test
	void testAdd() {
		Calculator c1 = new Calculator();
		assertEquals(30,c1.add(10, 20),()->"Sum result is not right");
		assertEquals(50,c1.add(30, 20),()->"Sum result is not right");
		assertEquals(-10,c1.add(10, -20),()->"Sum result is not right");
	}
	@Test
	void  testDiv() {
		Calculator c1 = new Calculator();
		assertEquals(2,c1.div(10,5));
		assertThrows(ArithmeticException.class ,()->c1.div(90, 0));
	}
	
	@Test
	@DisplayName("Testing Multiply Operations")
	void testMul() {
		System.out.println("From testMulStart() method");
		
		
		assertAll(
	            ()->assertEquals(50,c1.mul(10, 5)),		
	            ()->assertEquals(100,c1.mul(20, 5)),
	            ()->assertEquals(40,c1.mul(10, 4)),
	            ()->assertEquals(90,c1.mul(10, 9)),
	            ()->assertEquals(30,c1.mul(10, 3)),
	            ()->assertEquals(30,c1.mul(6, 5))
				
				);
//		assertEquals(50,c1.mul(10, 5));
//		assertEquals(100,c1.mul(20, 5));
//		assertEquals(40,c1.mul(10, 6));
//		assertEquals(90,c1.mul(10, 9));
//		assertEquals(30,c1.mul(20, 5));
//		assertEquals(30,c1.mul(6, 5));
//		
		System.out.println("From testMulEnd() method");
	}
	
	@Test
	void testMod(){
		assertAll(
			  ()->assertEquals(2, c1.mod(10, 4)),	
			  ()->assertEquals(0, c1.mod(15, 5)),
			  ()->assertEquals(1, c1.mod(10, 3)),
			  ()->assertEquals(10, c1.mod(22, 12)),
			  ()->assertEquals(5, c1.mod(17, 6)),
			  ()->assertEquals(0, c1.mod(100, 4))
				
			);
		
	}
	
	@Test
	@EnabledForJreRange(min=JRE.JAVA_11,max=JRE.JAVA_15)
	void testLambda() {
		System.out.println("Testing for Lambda Expressions");
	}
	
	@Test
	@EnabledOnOs(value = {OS.WINDOWS})
	
	void testDll()
	{
		System.out.println("Testing for Dll files");
	}
	
	@Test
	@EnabledOnOs(value = {OS.LINUX,OS.MAC})
	void testShellScripts()
	{
		System.out.println("Testing Shell Scripts");
	}
	
	@Test
	@Tag("demo")
	@Tag("math")
	void testDynamically()
	{
		System.out.println("Test Dynamically Started");

		
		assertEquals(2,c1.div(10,5));
		
		assumeTrue(condition);
		assertEquals(15,c1.div(30,x));
		assertEquals(20,c1.div(40,x));
		
		System.out.println("Test Dynamically Finished");
	}
	
	@Test
	@Tag("db")
	void testInsertEmp() {
		System.out.println("Testing emp record Insertion ");
	}
	
	@Test
	@Tag("db")
	void testUpdateEmp() {
		System.out.println("Testing emp record Updation ");
	}
	
	@Test
	@Tag("db")
	void testDeleteEmp() {
		System.out.println("Testing emp record Deletion ");
	}
	
	@Test
	@Tag("db")
	
	void testSelectEmp() {
		System.out.println("Testing emp record Selection");
	}
}
