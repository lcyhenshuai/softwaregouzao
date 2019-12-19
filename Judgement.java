package ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class Judgement {
	// 用来写入CSV批改文件
	ArrayList<String> lstFile = new ArrayList<String>();
	// 用来读取CSV批改文件
	ArrayList<String[]> listFile = new ArrayList<String[]>();
	Practice p = new Practice();
	String path;
	Exercise e;
	private int correct = 0;
	private int wrong = 0;

	// 获得习题中的答案
	public int[] getResult(File f) throws IOException {

		path = f.getName().substring(f.getName().indexOf("_") + 1);
		path = "d:\\习题\\" + path;
		// 获得对应练习文件的习题
		e = p.readCSVExercise(new File(path));
		int CorrectAnswer[] = new int[e.getOperationList().size()];
		for (int i = 0; i < e.getOperationList().size(); i++) {
			CorrectAnswer[i] = e.getOperationList().get(i).intAnswer;
		}
		return CorrectAnswer;
	}

	// 获得练习中的答案,读取练习文件,方法重载，s并没有实际意义，区分两个方法而已
	public int[] getResult(File f, String ss) throws IOException {
		String[][] data = new String[1024][1024];
		int j = 0;
		ArrayList<Integer> opResults = new ArrayList<Integer>();
		BufferedReader br = new BufferedReader(new FileReader(f));
		String s = null;
		s = br.readLine();
		while (s != null) {
			// 利用截取字符串的方法，将算式字符串读入到data二位数组中
			String s1 = s.substring(s.indexOf(",") + 1);
			String s2 = s1.substring(s1.indexOf(",") + 1);
			String s3 = s2.substring(s2.indexOf(",") + 1);
			String s4 = s3.substring(s3.indexOf(",") + 1);
			data[j][0] = s.substring(0, s.indexOf(","));
			data[j][1] = s1.substring(0, s1.indexOf(","));
			data[j][2] = s2.substring(0, s2.indexOf(","));
			data[j][3] = s3.substring(0, s3.indexOf(","));
			data[j][4] = s4;
			for (int i = 0; i < 5; i++) {
				// 将data[j][i]添加到opResults中，强制类型转换为整型
				opResults.add(Integer.valueOf(data[j][i]));
			}
			s = br.readLine();
			j += 1;
		}
		br.close();

		int[] b = new int[opResults.size()];
		// 获得对应练习文件的习题
		for (int i = 0; i < opResults.size(); i++) {
			b[i] = opResults.get(i);
		}
		return b;
	}

	// 比较两个结果是否正确，并写入批改文件中
	public void evaluateWriteCSV(File f) {
		int[] answers = null;
		int[] results = null;
		try {
			answers = getResult(f);
			results = getResult(f, "lianxi");
		} catch (IOException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		// 进行比较，看做对了几道题，做错了几道题
		for (int index = 0; index < answers.length; index++) {
			if (answers[index] == results[index])
				correct++;
			else {
				wrong++;
			}
		}
		File f1 = new File("d:\\批改文件");
		if (!f1.exists() && !f1.isDirectory()) {
			System.out.println("//不存在");
			// 创建路径，如果父路径和子路径都不存在就全部创建
			f1.mkdirs();
		} else {
			System.out.println("//目录存在");
		}

		String pathCSVWrite = "d:\\批改文件\\" + "judge_" + new File(path).getName();
		CsvWriter csvWriter = new CsvWriter(pathCSVWrite, ',', Charset.forName("utf-8"));
		lstFile.add("答案：" + f.getName());
		lstFile.add("算式总数：" + answers.length);
		lstFile.add("正确：" + correct);
		lstFile.add("错误：" + wrong);
		for (int i = 0; i < lstFile.size(); i++) {
			String[] csvContent = { lstFile.get(i) };
			try {
				csvWriter.writeRecord(csvContent);
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		csvWriter.close();
		System.out.println("--------------------已完成写入操作--------------");
	}

	// 读取批改CSV文件
	public void readCSVjudge(File f) {
		int col = 0;
		String pathCSV = f.getPath();
		try {
			CsvReader reader = new CsvReader(pathCSV, ',', Charset.forName("utf-8"));
			reader.readHeaders();
			while (reader.readRecord()) {
				// System.out.println(reader.getRawRecord());
				listFile.add(reader.getValues());
			}

			reader.close();
			// 总共有几行
			System.out.println(listFile.size());
			for (int row = 0; row < listFile.size(); row++) {
				for (col = 0; col < listFile.get(row).length; col++) {
					String cell = listFile.get(row)[col];
					System.out.print(cell);
				}
				System.out.println();
			}
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}
//下面的代码用来测试的
//	public static void main(String[] args) {
//		Judgement jd = new Judgement();
//		jd.evaluateWriteCSV(new File("D:\\练习文件\\practice_substract_exercise_count_001.csv"));
//		jd.readCSVjudge(new File("D:\\批改文件\\judge_substract_exercise_count_001.csv"));
//	}

}
