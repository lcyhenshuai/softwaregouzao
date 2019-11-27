package version1;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class BinaryOperationTest {
	BinaryOperation bo = new BinaryOperation();
	BinaryOperation bo1;
	Random r = new Random();

	@Before
	public void setUp() throws Exception {
		bo1 = new BinaryOperation();
	}

	// 测试算式的构造方法，看是否满足条件
	public void testConstruct() {

		bo.construct(20, 30, '+');
		assertEquals(bo.intAnswer, 50);
		// fail("尚未实现");
	}

	@Test
	// 测试加法算式是否满足条件，结果小于100
	public void testGenerateAdditionOperation() {
		// fail("尚未实现");
		bo1 = bo.generateAdditionOperation();
		assertTrue(bo1.intAnswer <= 100);
	}

	@Test
	// 测试减法算式是否满足条件结果大于0
	public void testGenerateSubstractOperation() {
		// fail("尚未实现");
		bo1 = bo.generateSubstractOperation();
		assertTrue(bo1.intAnswer > 0);
	}

	@Test
	// 测试生成的随机算式结果满足大于0和小于100
	public void testGenerateBinaryOperaion() {
		// fail("尚未实现");
		bo1 = bo.generateBinaryOperaion();
		assertTrue(bo1.intAnswer > 0 && bo.intAnswer <= 100);
	}

	// 测试两个算式相等的情况
	public void testEqulas() {
		// fail("尚未实现");
		bo.construct(20, 30, '+');
		bo1.construct(20, 30, '+');
		assertTrue(bo1.equlas(bo));
	}

	public void testToString() {
		// fail("尚未实现");
		bo.construct(20, 30, '+');
		assertEquals(bo.toString(), "20+30" + "\t");
	}

	@Test
	// 测试AsString方法返回的值
	public void testAsString() {
		// fail("尚未实现");
		bo.construct(20, 30, '+');
		assertEquals(bo.asString(), "20+30=" + "\t");
	}

	@Test
	// 测试fullString方法
	public void testFullString() {
		// fail("尚未实现");
		bo.construct(20, 30, '+');
		assertEquals(bo.fullString(), "20+30=50" + "\t");
	}
}
