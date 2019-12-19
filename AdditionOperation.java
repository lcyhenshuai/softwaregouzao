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

	@Override
	// 将算式“3+2”转换为3+2
	public void unsafeConstructor(String eqString) {
		// TODO 自动生成的方法存根
		this.leftOpNum=Integer.parseInt(eqString.substring(0,eqString.indexOf("+")));
		this.righeOpNum=Integer.parseInt(eqString.substring(eqString.indexOf("+")+1,eqString.indexOf("=")));
		this.intAnswer=leftOpNum+righeOpNum;
	}

}
