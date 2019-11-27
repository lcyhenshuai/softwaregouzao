package version1;

public class Exerciseversion {
	private static final short OPERATTION_NUMBER = 50;// 生成题目的数量是50个
	private static final short COLUMN_NUMBER = 5;// 每行显示算式的数目
	public BinaryOperation operList[] = new BinaryOperation[OPERATTION_NUMBER];

	// 生成算式算式习题50到
	public void generateBinaryExercise() {
		BinaryOperation anOperation, opCreator = new BinaryOperation();
		for (int i = 0; i < OPERATTION_NUMBER; i++) {
			anOperation = opCreator.generateBinaryOperaion();

			while (contains(anOperation, i - 1)) {
				anOperation = opCreator.generateBinaryOperaion();
			}
			operList[i] = anOperation;
		}
	}

	// 生成加法算式习题50道
	public void generateAdditionExercise() {
		BinaryOperation anOperation, opCreator = new BinaryOperation();
		for (int i = 0; i < OPERATTION_NUMBER; i++) {
			anOperation = opCreator.generateAdditionOperation();

			while (contains(anOperation, i - 1)) {
				anOperation = opCreator.generateAdditionOperation();
			}
			operList[i] = anOperation;
		}
	}

	// 生成加法算式习题50道
	public void generateSubstractExercise() {
		BinaryOperation anOperation, opCreator = new BinaryOperation();
		for (int i = 0; i < OPERATTION_NUMBER; i++) {
			anOperation = opCreator.generateSubstractOperation();

			while (contains(anOperation, i - 1)) {
				anOperation = opCreator.generateSubstractOperation();
			}
			operList[i] = anOperation;
		}
	}

	// 判断习题数组是否包含刚生成的算式
	public boolean contains(BinaryOperation bo, int length) {
		boolean found = false;
		for (int i = 0; i <= length; i++) {
			if ((bo.equals(operList[i])) || ((bo.leftOpNum == operList[i].rightOpNum)
					&& (bo.rightOpNum == operList[i].leftOpNum) && (bo.oper == operList[i].oper) && (bo.oper == '+'))) {
				found = true;
				break;
			}
		}
		return found;
	}

	// 格式化输出
	public void format() {
		for (int i = 1; i < operList.length + 1; i++) {
			System.out.print(operList[i - 1].fullString());
			if (i % 5 == 0)
				System.out.println();
		}
	}

	// main方法，执行程序
	public static void main(String[] args) {
		Exerciseversion e = new Exerciseversion();
		e.generateSubstractExercise();
		e.format();
	}
}
