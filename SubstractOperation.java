package ui;

public class SubstractOperation extends Equation {
	// 生成减法的算式，实现了Equation类的抽象方法
	public SubstractOperation() {
		super();
		generateBinaryOperation('-');
		// TODO Auto-generated constructor stub
	}

	@Override
	public int calculate(int left, int right) {
		// TODO Auto-generated method stub
		return left - right;
	}

	@Override
	public boolean checkingCalculation(int result) {
		// TODO Auto-generated method stub
		return result >= 0;
	}

	@Override
	// 将算式“3-2”转换为3-2
	public void unsafeConstructor(String eqString) {
		// TODO 自动生成的方法存根
		int a, b, c;
		this.leftOpNum = Integer.parseInt(eqString.substring(0, eqString.indexOf("-")));
		this.righeOpNum = Integer.parseInt(eqString.substring(eqString.indexOf("-") + 1, eqString.indexOf("=")));
		this.intAnswer = leftOpNum - righeOpNum;
		this.oper = '-';
	}
}
