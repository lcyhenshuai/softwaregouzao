package ui;

public class AdditionOperation extends Equation {
	// 实现抽象方法，算式是加法
	public AdditionOperation() {
		super();
		generateBinaryOperation('+');
	}

	@Override
	public int calculate(int left, int right) {
		// TODO Auto-generated method stub
		return left + right;
	}

	@Override
	public boolean checkingCalculation(int result) {
		// TODO Auto-generated method stub
		return result <= UPPER;
	}

}
