package Chuti1;

import java.util.Random;

public class ChuTiFour {
	int a[] = new int[50];//存放第一个数的数组
	int b[] = new int[50];//存放第二个数的数组
	int sum[] = new int[50];//存放运算结果的数组
	Random r=new Random();
	String yuSuan[] = new String[50];//存放运算符的数组

   
	public void shengChengFivtySuanShi(){//生成50道随机算式的方法
		for (int i = 0; i < 50; i++) {
	    ShengChengSuanShi(i);//调用生成算式的方法
	   }
	}
	public void  shuChu(){  //输出算式的方法
		for(int j=0;j<50;j++)
		{
			System.out.print("题目:"+a[j]+yuSuan[j]+b[j]);
			System.out.print("答案为:"+sum[j]+"\t");
			if ((j + 1) % 6 == 0)
				System.out.println();
		}
	}
	public void jianYan(){  //检验结果大于100，小于0，以及算式相等，1+2与2+1的情况的方法
		for (int i = 0; i < 50; i++) {
			
     if(sum[i]>100||sum[i]<0) {//确保第一个运算结果满足小于100,大于0，所以写的
    	 ShengChengSuanShi(i);
    	 i--;continue;}
    	 
      for (int j = 0; j<i; j++) {
    	  //保证除第一个的每一个运算结果都小于100，大于0，且出去算式相等，1+2，2+1的情况
				if ((sum[i] > 100) || (sum[i]< 0)
							|| (a[i] == a[j] && b[i] == b[j] && yuSuan[i] == yuSuan[j])
							|| (a[i] == b[j] && b[i] == a[j] && yuSuan[i] == yuSuan[j])) 
				{ 
					 ShengChengSuanShi(i);
					
					
					i=i-1;break;}
				}
		}
		
			
	}
	public void ShengChengSuanShi(int j){//生成每一个算式的方法
		 boolean ziFu;
		 int i=0;
		 i=j;
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
	}
}
