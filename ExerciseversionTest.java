package version1;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class ExerciseversionTest {
	Exerciseversion e = new Exerciseversion();
	Random r = new Random();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	// 测试生成习题类方法，长度位50，且每个算式的结果满足大于0，小于100，任意算式不重复
	public void testGenerateBinaryExercise() {
		// fail("尚未实现");
		int i;
		i = r.nextInt(50);

		e.generateBinaryExercise();
		assertTrue(e.operList.length == 50);
		assertTrue(!e.operList[5].equals(e.operList[1]));
		assertTrue(e.operList[i].intAnswer >= 0 && e.operList[i].intAnswer <= 100);

	}

	@Test
	// 测试生成加法习题类方法，长度位50，且每个算式的结果满足小于100，任意算式不重复
	public void testGenerateAdditionExercise() {
		// fail("尚未实现");
		int i;
		i = r.nextInt(50);

		e.generateAdditionExercise();
		assertTrue(e.operList.length == 50);
		assertTrue(!e.operList[1].equals(e.operList[5]));
		assertTrue(e.operList[i].intAnswer <= 100);
	}

	@Test
	// 测试生成减法习题类方法，长度位50，且每个算式的结果满足大于0，任意算式不重复
	public void testGenerateSubstractExercise() {
		// fail("尚未实现");
		int i;
		i = r.nextInt(50);

		e.generateSubstractExercise();
		assertTrue(e.operList.length == 50);
		assertTrue(!e.operList[1].equals(e.operList[6]));
		assertTrue(e.operList[i].intAnswer >= 0);
	}

	@Test
	// 测试习题类数组中是否包含了相同的算式
	public void testContains() {
		// fail("尚未实现");
		BinaryOperation bo1 = new BinaryOperation();
		BinaryOperation bo2 = new BinaryOperation();
		bo1.construct(2, 2, '+');
		bo2.construct(2, 2, '+');
		e.operList[0] = bo1;
		e.operList[1] = bo2;
		assertTrue(e.contains(bo2, 0));
	}

}
