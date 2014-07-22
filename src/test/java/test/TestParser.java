package test;

import static org.junit.Assert.*;

import org.junit.Test;
import calculator.Parser;

public class TestParser {

	@Test
	public void test1() {
		Parser parser = new Parser();
		double result = Double.parseDouble(parser.equalsSolution("log(100)"));
		assertEquals(4.605, result, 0.05);
	}
	
	@Test
	public void test2() {
		Parser parser = new Parser();
		double result = Double.parseDouble(parser.equalsSolution("tg(5)-sin(5)/cos(5)"));
		assertEquals(0, result, 0.05);
	}
	
	@Test
	public void test3() {
		Parser parser = new Parser();
		double result = Double.parseDouble(parser.equalsSolution("pow((3-sin(30)),2)*sqrt(4)"));
		assertEquals(12.5, result, 0.05);
	}

}
