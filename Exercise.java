package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Exercise {

	private List<Equation> operationList = new ArrayList<Equation>();// 存放习题的数据结构ArryList类型的对象 operationList
	// 生成一定数目的随机加减法算式

	public void generateBinaryExericise(int number) {
		Equation eq;
		for (; number > 0; number--) {
			eq = generateOperation();
			if (contains(eq))
				number++;
			else {
				operationList.add(eq);
			}
		}
	}

	// 生成随机的加法减法
	private Equation generateOperation() {
		Random r = new Random();
		int opValue = r.nextInt(2);
		if (opValue == 1) {
			return new AdditionOperation();
		}
		return new SubstractOperation();
	}

	// 生成一定数目的加法算式
	public void generateAdditionExercise(int number) {
		Equation eq;
		for (; number > 0; number--) {
			eq = new AdditionOperation();
			if (contains(eq))
				number++;
			else {
				operationList.add(eq);
			}
		}
	}

	// 生成一定数目的减法算式
	public void generateSubstractExercise(int number) {
		Equation eq;
		for (; number > 0; number--) {
			eq = new SubstractOperation();
			if (contains(eq))
				number++;
			else {
				operationList.add(eq);
			}
		}
	}

	// 判断医生称的习题中是否包含刚生成的习题
	public boolean contains(Equation eq) {
		boolean found = false;
		for (int i = 0; i < operationList.size(); i++) {
			if ((operationList.get(i).toString().equals(eq.toString()))
					|| ((operationList.get(i).leftOpNum == (eq.righeOpNum))
							&& (operationList.get(i).righeOpNum == (eq.leftOpNum))
							&& ((operationList.get(i).oper == eq.oper) && (String.valueOf(eq.oper).equals("+"))))) {

				found = true;
				break;
			} else
				found = false;
		}

		return found;
	}

	// 返回该习题类的私有属性operationList
	public List<Equation> getOperationList() {
		return operationList;
	}

	// 遍历习题类的存放50道习题的ArrayList类型operaionList里面存放的习题
	public void bianLi() {
		for (int i = 0; i < operationList.size(); i++) {
			System.out.println(operationList.get(i).fullString());
		}
	}
}
