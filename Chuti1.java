import java.util.Random;


public class Chuti1 {

	public static void main(String[] args) {
		int a[]=new int[50];
		int b[]=new int[50];
		int sum[]=new int [50];
		String yuSuan[]=new String[50];
		Random r=new Random();
		for(int i=0;i<50;i++){
			a[i]=r.nextInt(100);
			b[i]=r.nextInt(100);
			boolean ziFu;
			ziFu=r.nextBoolean();
			if(ziFu){yuSuan[i]="+";sum[i]=a[i]+b[i];}
			else {yuSuan[i]="-";sum[i]=a[i]-b[i];}
			System.out.println(a[i]+yuSuan[i]+b[i]);
		}

	}

}
