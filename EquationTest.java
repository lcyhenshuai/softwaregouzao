package ui;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class EquationTest {
	Equation eq, eq1;
	Random r = new Random();

	@Before
	public void setUp() throws Exception {
		eq = new AdditionOperation();
		eq1 = new SubstractOperation();
	}

	@Test
	// 检测结果是否大于0，小于100
	public void testCheckingCalculation() {
		// fail("尚未实现");
		assertTrue(eq.intAnswer <= 100);
		assertTrue(eq1.intAnswer >= 0);
	}

	@Test
	// 检测加法的运算符是加法，减法的运算符是减法
	public void testCalculate() {
		// fail("尚未实现");
		assertTrue(eq.oper == '+');
		assertTrue(eq1.oper == '-');
	}

	@Test
	// 检测加法算式的结果小于0，减法算式结果小于100，
	public void testGenerateBinaryOperation() {
		// fail("尚未实现");
		eq.generateBinaryOperation('+');
		eq1.generateBinaryOperation('-');
		assertTrue(eq.intAnswer <= 100);
		assertTrue(eq1.intAnswer >= 0);
	}

	@Test
	// 测试加法，减法的相等的情况下的返回值
	public void testEqulas() {
		// fail("尚未实现");
		Equation eq3 = new AdditionOperation();
		Equation eq4 = new AdditionOperation();
		Equation eq5 = new SubstractOperation();
		Equation eq6 = new SubstractOperation();
		eq3.leftOpNum = 2;
		eq3.righeOpNum = 3;
		eq3.oper = '+';
		eq3.intAnswer = 5;
		eq4.leftOpNum = 2;
		eq4.righeOpNum = 3;
		eq4.oper = '+';
		eq4.intAnswer = 5;
		eq5.leftOpNum = 2;
		eq5.righeOpNum = 3;
		eq5.oper = '-';
		eq5.intAnswer = 5;
		eq6.leftOpNum = 2;
		eq6.righeOpNum = 3;
		eq6.oper = '-';
		eq6.intAnswer = 5;
		assertTrue(eq3.equlas(eq4));
		assertTrue(eq5.equlas(eq6));
	}

}
