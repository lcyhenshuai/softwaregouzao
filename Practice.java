package ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import com.csvreader.CsvWriter;
public class Practice {
	//用来存放当前文件的名称，方便查看时哪一个练习
	String exerciseName = null;
	String exercisePath = null;
 public Exercise readCSVExercise(File aFile) throws IOException {
	 int j=0;
	 exerciseName=aFile.getName();
	 exercisePath=aFile.getPath();
	 String [][]data=new String[1024][1024];
	 Exercise e=new Exercise();
	 String eqString;
	 Equation eq = null;
	 try {
	
		BufferedReader br = new BufferedReader(new FileReader(aFile));
		String s = null;
		s = br.readLine();
		while (s != null) {
			//利用截取字符串的方法，将算式字符串读入到data二位数组中
			String s1 = s.substring(s.indexOf(",") + 1);
			String s2 = s1.substring(s1.indexOf(",") + 1);
			String s3 = s2.substring(s2.indexOf(",") + 1);
			String s4 = s3.substring(s3.indexOf(",") + 1);
			data[j][0] = s.substring(0, s.indexOf(","));
			data[j][1] = s1.substring(0, s1.indexOf(","));
			data[j][2] = s2.substring(0, s2.indexOf(","));
			data[j][3] = s3.substring(0, s3.indexOf(","));
			data[j][4] = s4;
			for(int i=0;i<5;i++) {
				eqString=data[j][i];
				//如果字串中包含"+"号，构造加法算式eq,否则，构造减法
				if(eqString.contains("+")) {eq=new AdditionOperation();}
				else if(eqString.contains("-")) {eq=new SubstractOperation();}
				eq.unsafeConstructor(eqString);
				e.getOperationList().add(eq);
			}
			s = br.readLine();
			j += 1;
		}
		br.close();
	} catch (Exception e1) {
		// TODO 自动生成的 catch 块
		e1.printStackTrace();
	}
	 return e;
 }
 //将本次的练习结果保存在对应的练习文件中
 public void storeAdditionPraticeResult() {
	 ArrayList<String> lstFile = new ArrayList<String>();
	
	 File f=new File("d:\\练习文件");
	 if  (!f .exists()  && !f .isDirectory())      
		{       
		    System.out.println("//不存在");
		    //创建路径，如果父路径和子路径都不存在就全部创建
		    f.mkdirs();    
		} else   
		{  
		    System.out.println("//目录存在");  
		} 
	 System.out.println("请输入本次练习的结果：");// 提示用户输入字符串
	 String pathCSVWrite = "d:\\练习文件\\"+"practice_"+exerciseName;
     
     try{
    	 //利用输入流将输入的结果放在lstFile中
    	 for(int i=0;;i++){
    	 InputStream input = System.in;
    	 BufferedReader buf = new BufferedReader(new InputStreamReader(input));
    	 String str = buf.readLine();
        if(str.equals("-")) {System.out.println("输入完成，控制台输入结束");buf.close();break;}
    	 lstFile.add(str);
    	
    	 }
    	 
 		CsvWriter csvWriter = new CsvWriter(pathCSVWrite,',',Charset.forName("utf-8"));
 	  //写入csv文件，每行写5个
 		for(int i=0;i<lstFile.size();i=i+5){
			String[] csvContent = {lstFile.get(i),
					lstFile.get(i+1),
					lstFile.get(i+2),
					lstFile.get(i+3),
					lstFile.get(i+4),
			
			};
			csvWriter.writeRecord(csvContent);
		}
		csvWriter.close();
		System.out.println("--------------------已完成写入操作--------------");
 		
 		csvWriter.close();
 		System.out.println("--------------------已完成写入操作--------------");
 	}
 	catch(IOException e){
 		e.printStackTrace();
 	}
 }
 //下面代码用来测试的
//public static void main(String[] args) throws IOException {
//	File f=new File("d:\\习题\\substract_exercise_count_001.csv");
//	Practice p=new Practice();
//	
//	ExerciseSheet es=new ExerciseSheet();
//	es.formatdisplay(p.readCSVExercise(f));
//	 p.storeAdditionPraticeResult();
//}
}
