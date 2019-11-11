import java.util.Random;
public class ChuTiSecond {
	public static void main(String[] args) {
		Random r=new Random();
		int a[] = new int[50];//存放第一个数的数组
		int b[] = new int[50];//存放第二个数的数组
		int sum[] = new int[50];//存放运算结果的数组
	   String yuSuan[] = new String[50];//存放运算符的数组
		for (int i = 0; i < 50; i++) {
			boolean ziFu;
			ziFu = r.nextBoolean();
           a[i] = r.nextInt(100);
           b[i] = (int) r.nextInt(100);
     if (ziFu) {
			yuSuan[i] = "+";//随机产生的运算符
			sum[i] = a[i] + b[i];
		} else {
			yuSuan[i] = "-";
			sum [i]= a[i] - b[i];
		}
     if(sum[i]>100||sum[i]<0) {i--;continue;}//判断和大于100,差小于0
			
	}
		for(int j=0;j<50;j++)
		{
			System.out.print("题目:"+a[j]+yuSuan[j]+b[j]);
			System.out.print("答案为:"+sum[j]+"\t");
			if ((j+1) % 6== 0)//每行输出6个
				System.out.println();
		}
 }
}
