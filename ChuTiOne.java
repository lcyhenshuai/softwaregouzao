import java.util.Random;


public class ChuTiOne {

	public static void main(String[] args) {
		int a[]=new int[50];//存放第一个数的数组
		int b[]=new int[50];//存放第二个数的数组
		int sum[]=new int [50];//存放运算结果的数组
		String yuSuan[]=new String[50];//存放运算符的数组
		Random r=new Random();
		for(int i=0;i<50;i++){
			a[i]=r.nextInt(100);
			b[i]=r.nextInt(100);
			boolean ziFu;
			ziFu=r.nextBoolean();//随机生成运算符
			if(ziFu){yuSuan[i]="+";sum[i]=a[i]+b[i];}
			else {yuSuan[i]="-";sum[i]=a[i]-b[i];}
			System.out.println(a[i]+yuSuan[i]+b[i]);
		}

	}

}
