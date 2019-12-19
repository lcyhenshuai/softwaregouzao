package ui;

import java.util.Random;

public abstract class Equation {
	final int UPPER = 100;// 加法结果上限
	final int LOWER = 0;// 减法结果下限
	int leftOpNum;// 左加数
	int righeOpNum;// 右加数
	char oper = '+';// 运算符
	int intAnswer;// 算式的结果

	public abstract boolean checkingCalculation(int result);// 抽象的检查算式结果的方法

	public abstract int calculate(int left, int right);// 抽象的计算方法
	// 生成算式的方法

	protected void generateBinaryOperation(char o) {
		oper = o;
		int left, right, result;
		Random r = new Random();
		left = r.nextInt(UPPER + 1);
		do {
			right = r.nextInt(UPPER + 1);
			result = calculate(left, right);
		} while (!(checkingCalculation(result)));
		leftOpNum = left;
		righeOpNum = right;
		intAnswer = result;
	}

	// 获得算式左操作数的方法
	public int getLeftOpNum() {
		return leftOpNum;
	}

	// 获得算式右操作数的方法
	public int getRigheOpNum() {
		return righeOpNum;
	}

	// 获得算式的运算符
	public char getOper() {
		return oper;
	}

	// 获得算式的结果
	public int getIntAnswer() {
		return intAnswer;
	}

	// 判断先生成的算式是否和原来的相等
	public boolean equlas(Equation eq) {
		return leftOpNum == eq.getLeftOpNum() && righeOpNum == eq.getRigheOpNum() & oper == eq.getOper();
	}

	@Override
	public String toString() {
		return leftOpNum + String.valueOf(oper) + righeOpNum + "\t";
	}

	public String asString() {
		return leftOpNum + String.valueOf(oper) + righeOpNum + "=" + "\t";
	}

	public String fullString() {
		return leftOpNum + String.valueOf(oper) + righeOpNum + "=" + intAnswer + "\t";
	}

	// 抽象方法将"3+2"转为3+2，这个方法是新增的
	public abstract void unsafeConstructor(String eqString);

}
