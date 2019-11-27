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

}
