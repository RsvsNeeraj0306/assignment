package com.learning.servletodometer;

import java.util.ArrayList;
import java.util.List;

public class OdometerController {
	public int n=123;
	
	public int reset() {
		
		return this.n=123;
	}
	
	public int getOdometer() {
		return this.n;
	}
	public  int nextReading(){
		int i=1;
		int count=largestNumber(123);
		while(n<count)
		{
			this.n=this.n+1;
			if(isAscending(n)) {
				break;
			}
		}
		return n;
	}
	
	public int previousOdometer(){
		int small=smallestNumber(123);
		int large=largestNumber(123);
		while(this.n>=small)
		{
			if(this.n==small)
			{
				return this.n=large;
			}
			this.n=this.n-1;
			if(isAscending(n)) {
				break;
			}	
		}
		return n;
	}
	
	public  int largestNumber(int n){
		int count=0,ans=0;
		count=countOfDigit(n);
		for(int i=count;i>0;i--){
			ans=ans*10+(10-i);
		}
		return (ans);
	}
	
	public int smallestNumber(int n){
		int ans=0,count=0;
		count=countOfDigit(n);
		for(int i=1;i<=count;i++){
			ans=ans*10+(i);
		}
		return (ans);
	}
	
	public int countOfDigit(int n){
		int ans=0,c=0;
		List<Integer>numberList=new ArrayList<Integer>();
		while(n!=0){
			ans=n%10;
			numberList.add(ans);
			n=n/10;	
			c+=1;
		}
		return c;
	}
	
	public  boolean isAscending(int n){
		int ans=0,c=0,i=0;
		List<Integer>numberList=new ArrayList<Integer>();
		while(n!=0){
			ans=n%10;
			numberList.add(ans);
			n=n/10;	
		}
		for(i=1;i<numberList.size();i++){
			if(numberList.get(i-1)>numberList.get(i)){
				c+=1; 	
			}
		}
		return (c+1==numberList.size());		
	}
	
	

}
