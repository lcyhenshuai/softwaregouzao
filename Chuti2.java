import java.util.Random;
public class Chuti2 {
	public static void main(String[] args) {
		Random r=new Random();
		int a[] = new int[50];
		int b[] = new int[50];
		int sum[] = new int[50];
	   String yuSuan[] = new String[50];
		for (int i = 0; i < 50; i++) {
			boolean ziFu;
			ziFu = r.nextBoolean();
           a[i] = r.nextInt(100);
           b[i] = (int) r.nextInt(100);
     if (ziFu) {
			yuSuan[i] = "+";
			sum[i] = a[i] + b[i];
		} else {
			yuSuan[i] = "-";
			sum [i]= a[i] - b[i];
		}
     if(sum[i]>100||sum[i]<0) {i--;continue;}
			
	}
		for(int j=0;j<50;j++)
		{
			System.out.print("题目:"+a[j]+yuSuan[j]+b[j]);
			System.out.print("答案为:"+sum[j]+"\t");
			if ((j+1) % 6== 0)
				System.out.println();
		}
 }
}
