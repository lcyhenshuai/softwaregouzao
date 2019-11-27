package ui;

public class ExerciseSheet {
	private static final int COLUMN_NUMBER = 6;

	// 每行打印指定数目的算式
	public void formatdisplay(Exercise ex, int column) {
		for (int i = 1; i < ex.getOperationList().size() + 1; i++) {

			System.out.print(ex.getOperationList().get(i - 1).fullString());
			if (i % column == 0)
				System.out.println();

		}
	}

	// 格式化方法重载，如果未设置每行输出几个，默认每行输出5个
	public void formatdisplay(Exercise ex) {
		for (int i = 1; i < ex.getOperationList().size() + 1; i++) {
			if (i % COLUMN_NUMBER == 0)
				System.out.println();
			System.out.print(ex.getOperationList().get(i - 1).fullString());

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExerciseSheet sheet = new ExerciseSheet();
		Exercise e = new Exercise();
		e.generateAdditionExercise(28);
		System.out.println("习题");
		sheet.formatdisplay(e);
	}

}
