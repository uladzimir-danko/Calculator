package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import calculator.PrefixPolishNotation;

public class TestPPN {
	private double answer;
	String equals;
	
	@Before public void setUpTestPPn()
	{
		this.answer = 15;
		this.equals = "(4+8)/3*(6-1)-5";
	}

	@Test
	public void testEval1() {
		double result = PrefixPolishNotation.eval(equals);
		assertEquals(answer, result, 0.05);
	}
	
	@Test
	public void testEval2() {
		double result = PrefixPolishNotation.eval("7*3-14/25");
		assertEquals(20.44, result, 0.05);
	}
	
	

}
