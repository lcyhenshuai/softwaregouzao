
import java.util.Random;
public class Chuti3 {
	public static void main(String[] args) {
		int a[] = new int[50];
		int b[] = new int[50];
		int sum[] = new int[50];
		Random r=new Random();
	   String yuSuan[] = new String[50];
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
     if(sum[i]>100||sum[i]<0) {i--;continue;}
    	 
      for (int j = 0; j<i; j++) {
				if ((sum[i] > 100) || (sum[i]< 0)
							|| (a[i] == a[j] && b[i] == b[j] && yuSuan[i] == yuSuan[j])
							|| (a[i] == b[j] && b[i] == a[j] && yuSuan[i] == yuSuan[j])) 
				{ i=i-1;break;}
				}
		}
		for(int j=0;j<50;j++)
		{
			System.out.print("题目:"+a[j]+yuSuan[j]+b[j]);
			System.out.print("答案为:"+sum[j]+"\t");
			if ((j + 1) % 6 == 0)
				System.out.println();
		}
	}
}
