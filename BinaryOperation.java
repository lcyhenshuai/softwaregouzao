package version1;

import java.util.Random;

import ui.Equation;

public class BinaryOperation {
	static final int UPPER = 100;// 加法结果上限
	static final int LOWER = 0;// 减法结果下限
	int leftOpNum;// 左加数
	int rightOpNum;// 右加数
	char oper = '+';// 运算符
	int intAnswer;// 算式的结果
	// 构造一个算式

	public void construct(int left, int right, char op) {
		leftOpNum = left;
		rightOpNum = right;
		oper = op;
		if (op == '+') {
			this.intAnswer = left + right;
		} else {
			intAnswer = left - right;
		}
	}

	// 生成加法算式
	public BinaryOperation generateAdditionOperation() {
		Random r = new Random();
		int left, right, result;
		left = r.nextInt(UPPER + 1);
		do {
			right = r.nextInt(UPPER + 1);
			result = left + right;
		} while (result > UPPER);
		BinaryOperation bo = new BinaryOperation();
		bo.construct(left, right, '+');
		return bo;
	}

	// 生成减法算式
	public BinaryOperation generateSubstractOperation() {
		Random r = new Random();
		int left, right, result;
		left = r.nextInt(UPPER + 1);
		do {
			right = r.nextInt(UPPER + 1);
			result = left - right;
		} while (result < LOWER);
		BinaryOperation bo = new BinaryOperation();
		bo.construct(left, right, '-');
		return bo;
	}

	// 生成随机的加减法算式
	public BinaryOperation generateBinaryOperaion() {
		Random r = new Random();
		BinaryOperation bo = new BinaryOperation();
		int left, right, result;
		char op;
		left = r.nextInt(UPPER + 1);
		do {
			right = r.nextInt(UPPER + 1);
			if (r.nextBoolean()) {
				bo.construct(left, right, '+');
			} else {
				bo.construct(left, right, '-');
			}
		} while (bo.intAnswer > UPPER || bo.intAnswer < LOWER);
		return bo;
	}

	// 获得算式的左加数
	public int getLeftOpNum() {
		return leftOpNum;
	}

	// 获得算是的右加数
	public int getRigheOpNum() {
		return rightOpNum;
	}

	// 获得算式的操作符
	public char getOper() {
		return oper;
	}

	// 获得算式的结果
	public int getIntAnswer() {
		return intAnswer;
	}

	// 判断两个算式是否相等
	public boolean equlas(BinaryOperation bo) {
		return leftOpNum == bo.getLeftOpNum() && rightOpNum == bo.getRigheOpNum() && oper == bo.getOper();
	}

	@Override

	public String toString() {
		return leftOpNum + String.valueOf(oper) + rightOpNum + "\t";
	}

	public String asString() {
		return leftOpNum + String.valueOf(oper) + rightOpNum + "=" + "\t";
	}

	public String fullString() {
		return leftOpNum + String.valueOf(oper) + rightOpNum + "=" + intAnswer + "\t";
	}

}