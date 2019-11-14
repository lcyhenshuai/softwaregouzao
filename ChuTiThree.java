
import java.util.Random;
public class ChuTiThree {
	public static void main(String[] args) {
		int a[] = new int[50];//存放第一个数的数组
		int b[] = new int[50];//存放第二个数的数组
		int sum[] = new int[50];//存放运算结果的数组
		Random r=new Random();
	   String yuSuan[] = new String[50];//存放运算符的数组
		for (int i = 0; i < 50; i++) {
			boolean ziFu;
          ziFu = r.nextBoolean();
           a[i] = r.nextInt(100);
           b[i] = r.nextInt(100);
     if (ziFu) {
			yuSuan[i] = "+";
			sum[i] = a[i] + b[i];
		} else {
			yuSuan[i] = "-";
			sum [i]= a[i] - b[i];
		}
     if(sum[i]>100||sum[i]<0) {i--;continue;}//判断和大于100,差小于0单独写，是因为下面的无法判断第一个，所以单独写
    	 
      for (int j = 0; j<i; j++) {//检验结果除第一算式外大于100，小于0，以及算式相等，1+2与2+1的情况
				if ((sum[i] > 100) || (sum[i]< 0)
							|| (a[i] == a[j] && b[i] == b[j] && yuSuan[i] == yuSuan[j])
							|| (a[i] == b[j] && b[i] == a[j] && yuSuan[i] == yuSuan[j])) 
				{ i=i-1;break;}
				}
		}
		for(int j=0;j<50;j++)//输出
		{
			System.out.print("题目:"+a[j]+yuSuan[j]+b[j]);
			System.out.print("答案为:"+sum[j]+"\t");
			if ((j + 1) % 6 == 0)//每行显示6个
				System.out.println();
		}
	}
}
