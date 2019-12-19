package ui;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.csvreader.CsvWriter;

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

	// 将生成一定数目地加减混合法算式的习题以CSV的格式写到在习题文件下里，有count道算式题
	public void writeCSVBinaryExercise(int count, int liuShui) {

		String order = null;
		Exercise e = new Exercise();
		e.generateBinaryExericise(count);
		if (liuShui >= 0 && liuShui <= 9)
			order = "00" + String.valueOf(liuShui);
		if (liuShui >= 10 && liuShui <= 99)
			order = "0" + String.valueOf(liuShui);
		if (liuShui >= 100 && liuShui <= 999)
			order = String.valueOf(liuShui);
		String pathCSVWrite = "d:\\习题\\binary_exercise_" + count + "_" + order + ".csv";
		ArrayList<Equation> lstFile = (ArrayList<Equation>) e.getOperationList();
		try {
			CsvWriter csvWriter = new CsvWriter(pathCSVWrite, ',', Charset.forName("utf-8"));
			for (int i = 0; i < lstFile.size(); i = i + 5) {
				String[] csvContent = { lstFile.get(i).asString(), lstFile.get(i + 1).asString(),
						lstFile.get(i + 2).asString(), lstFile.get(i + 3).asString(), lstFile.get(i + 4).asString(),

				};
				csvWriter.writeRecord(csvContent);
			}
			csvWriter.close();
			System.out.println("--------------------已完成写入操作--------------");

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	// 生成习题文件，用来将存放总的习题,这里面既有加法习题，又有减法习题，也有混合加减法习题
	public void writeCSVBinaryExericises(int number, int count) {
		// 看d盘下加减法混合习题是否存在，如果不存在，就创建一个习题文件
		File f = new File("d:\\习题");
		if (!f.exists() && !f.isDirectory()) {
			System.out.println("//不存在");
			f.mkdirs();
		} else {
			System.out.println("//目录存在");
		}
		int liuShui = 0;
		for (int i = 0; i < number; i++) {
			liuShui++;
			this.writeCSVBinaryExercise(count, liuShui);
		}
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

	// 将生成一定数目地加法算式的习题以CSV的格式写到在习题文件下加法文件夹里，有count道算式题
	public void writeCSVAdditionExercise(int count, int liuShui) {

		String order = null;
		Exercise e = new Exercise();
		e.generateAdditionExercise(count);
		if (liuShui >= 0 && liuShui <= 9)
			order = "00" + String.valueOf(liuShui);
		if (liuShui >= 10 && liuShui <= 99)
			order = "0" + String.valueOf(liuShui);
		if (liuShui >= 100 && liuShui <= 999)
			order = String.valueOf(liuShui);
		String pathCSVWrite = "d:\\习题\\addtion_exercise_" + count + "_" + order + ".csv";
		ArrayList<Equation> lstFile = (ArrayList<Equation>) e.getOperationList();
		try {
			CsvWriter csvWriter = new CsvWriter(pathCSVWrite, ',', Charset.forName("utf-8"));
			for (int i = 0; i < lstFile.size(); i = i + 5) {
				String[] csvContent = { lstFile.get(i).asString(), lstFile.get(i + 1).asString(),
						lstFile.get(i + 2).asString(), lstFile.get(i + 3).asString(), lstFile.get(i + 4).asString(),

				};
				csvWriter.writeRecord(csvContent);
			}
			csvWriter.close();
			System.out.println("--------------------已完成写入操作--------------");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	// 生成习题文件，用来将存放总的习题,这里面既有加法习题，又有减法习题，也有混合加减法习题，这里写入number个加法习题
	public void writeCSVAdditionExercises(int number, int count) {
		// 看d盘下加法习题是否存在，如果不存在，就创建，里面存在加法习题
		File f = new File("d:\\习题");
		if (!f.exists() && !f.isDirectory()) {
			System.out.println("//不存在");
			f.mkdirs();
		} else {
			System.out.println("//目录存在");
		}
		int liuShui = 0;
		for (int i = 0; i < number; i++) {
			liuShui++;
			this.writeCSVAdditionExercise(count, liuShui);
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

	// 将生成一定数目地减法算式的习题以CSV的格式写到在习题文件里，有count道算式题
	public void writeCSVSubstractExercise(int count, int liuShui) {

		String order = null;
		Exercise e = new Exercise();
		e.generateSubstractExercise(count);
		if (liuShui >= 0 && liuShui <= 9)
			order = "00" + String.valueOf(liuShui);
		if (liuShui >= 10 && liuShui <= 99)
			order = "0" + String.valueOf(liuShui);
		if (liuShui >= 100 && liuShui <= 999)
			order = String.valueOf(liuShui);
		String pathCSVWrite = "d:\\习题\\substract_exercise_" + count + "_" + order + ".csv";
		ArrayList<Equation> lstFile = (ArrayList<Equation>) e.getOperationList();
		try {
			CsvWriter csvWriter = new CsvWriter(pathCSVWrite, ',', Charset.forName("utf-8"));
			for (int i = 0; i < lstFile.size(); i = i + 5) {
				String[] csvContent = { lstFile.get(i).asString(), lstFile.get(i + 1).asString(),
						lstFile.get(i + 2).asString(), lstFile.get(i + 3).asString(), lstFile.get(i + 4).asString(),

				};
				csvWriter.writeRecord(csvContent);
			}
			csvWriter.close();
			System.out.println("--------------------已完成写入操作--------------");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	// 生成习题文件，用来将存放总的习题,这里面既有加法习题，又有减法习题，也有混合加减法习题，这里写入number个减法习题
	public void writeCSVSubstractExercises(int number, int count) {
		// 看d盘下减法习题是否存在，如果不存在，就创建，里面存在减法习题
		File f = new File("d:\\习题");
		if (!f.exists() && !f.isDirectory()) {
			System.out.println("//不存在");
			// 创建路径，如果父路径和子路径都不存在就全部创建
			f.mkdirs();
		} else {
			System.out.println("//目录存在");
		}
		int liuShui = 0;
		for (int i = 0; i < number; i++) {
			liuShui++;
			this.writeCSVSubstractExercise(count, liuShui);
		}
	}

	// 判断随机生成的习题中是否包含刚生成的习题
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

	// 遍历习题类的存放习题的ArrayList类型operaionList里面存放的习题
	public void bianLi() {
		for (int i = 0; i < operationList.size(); i++) {
			System.out.println(operationList.get(i).fullString());
		}
	}
}
