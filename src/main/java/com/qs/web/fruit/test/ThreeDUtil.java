package com.qs.web.fruit.test;

import java.util.Arrays;

import com.sun.swing.internal.plaf.basic.resources.basic;

public class ThreeDUtil {

	
	public static void main(String[] args) {
		int[] t = {100,23,456,12,564,78,102,56};
		
		Arrays.sort(t);
		
		
		
		int[] TD = {687,634,643,955,755,992,283,590,432,645,319,368,613,945,742,224,
				57,474,610,87,875,969,303,344,683,300,774,805,618,488,204,256,444,335,
				723,630,809,4,478,68,702,156,854,585,236,248,903,214,392,757,310,793,700,257,761,386,502,210,
				871,977,819,300,742,361,208,693,72,968,652,911,537,662,36,921,146,559,712,630,206,670,544,934,
				521,558,623,56,30,404,506,482,495,303,998,285,553,738,389,548,
				286,170,892,352,250,957,613,970,669,960,965,768,487,429,124,243,645,910,829,182,383,758,743,
				499,315,701,852,588,341,780,145,211,870,139,650,85,409,840};
		Arrays.sort(TD);
		System.out.println(TD.toString());

		System.out.println("here=="+new Integer("098"));
		/*for (int i = 100; i < 1000; i++) {
			if (i==840) {
				int cc=Arrays.binarySearch(TD, i);
				System.out.println("此数不在数组中"+cc);
			}
			if (Arrays.binarySearch(TD, i)<0) {
				System.out.println("此数不在数组中"+i);
			}
		}*/
		
		int a,b,c;
		for (int i = 0; i < 10; i++) {
			a=i;/*if(a==9)break;*/
			for (int j = 0; j < 10; j++) {
				b=j;/*if(b==9)break;*/
				for (int z = 0; z < 10; z++) {
					c=z;/*if(c==9)break;*/
					int total = 100*a+10*b+c;
					int total1 = 100*a+10*c+b;
					int total2 = 100*c+10*a+b;
					int total3 = 100*c+10*b+a;
					int total4 = 100*b+10*c+a;
					int total5 = 100*b+10*a+c;
					int[] tt = {total,total1,total2,total3,total4,total5};
					if (a==b||a==c||b==c) {
						break;
					}
					if(Arrays.binarySearch(TD, tt[0])<0&&Arrays.binarySearch(TD, tt[1])<0&&Arrays.binarySearch(TD, tt[2])<0
							&&Arrays.binarySearch(TD, tt[3])<0&&Arrays.binarySearch(TD, tt[4])<0
							&&Arrays.binarySearch(TD, tt[5])<0&&a!=8&&b!=4&&c!=0){
						System.out.println("此数不在数组中"+a+b+c);
					}					 
					
				}
			}
		}
	}

}
