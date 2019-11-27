package ui;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class ExerciseTest {
	Exercise e = new Exercise();
	Random r = new Random();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	// 主要测试generateBinaryExericise()方法，两个算式否相等，以及结果是否符合要求>0，<100
	public void testGenerateBinaryExericise() {
		// fail("尚未实现");
		int i = r.nextInt(3);
		e.generateBinaryExericise(3);
		assertTrue(!e.getOperationList().get(1).equals(e.getOperationList().get(2)));
		assertTrue(e.getOperationList().get(i).intAnswer >= 0 && e.getOperationList().get(i).intAnswer <= 100);
	}

	@Test
	// 测试generateAdditionExercise()方法，两个算式相等同，生成的加法算式是加法，结果小于100
	public void testGenerateAdditionExercise() {
		// fail("尚未实现");
		int i = r.nextInt(3);
		e.generateAdditionExercise(3);
		assertTrue(!e.getOperationList().get(1).equals(e.getOperationList().get(2)));
		assertTrue(e.getOperationList().get(i).intAnswer <= 100);
		assertTrue(e.getOperationList().get(i).oper == '+');
	}

	@Test
	// 测试generateSubstractExercise()方法，两个算式相同，生成的减法算式是减法，结果大于0
	public void testGenerateSubstractExercise() {
		// fail("尚未实现");
		int i = r.nextInt(3);
		e.generateSubstractExercise(3);
		assertTrue(!e.getOperationList().get(1).equals(e.getOperationList().get(2)));
		assertTrue(e.getOperationList().get(i).intAnswer >= 0);
		assertTrue(e.getOperationList().get(i).oper == '-');
	}

	@Test
	// 测试contains()方法，两个算式相同
	public void testContains() {
		// fail("尚未实现");
		Equation eq3 = new AdditionOperation();
		Equation eq4 = new AdditionOperation();
		eq3.leftOpNum = 2;
		eq3.righeOpNum = 3;
		eq3.oper = '+';
		eq3.intAnswer = 5;
		eq4.leftOpNum = 3;
		eq4.righeOpNum = 2;
		eq4.oper = '+';
		eq4.intAnswer = 5;
		e.getOperationList().add(eq3);
		assertTrue(e.contains(eq4));

	}

	
}
