package com.learning.CardGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Stack<T> {
	private List<T> stack = new ArrayList<T>();
	private int top=-1;
	
	public void push(T element)
	{
		stack.add(element);
		top++;
	}
	
	public T pop()
	{
		return stack.remove(top--);
	}
	
	public T getTop()
	{ 
		return stack.get(top);
	}
	
	public int getSize()
	{
		return(top+1);
	}
	
	@Override
	public String toString()
	{
		String s = "";
		for(T i: stack)
		{
			s = s+i;
		}
		return s;
	}
	
	public void shuffleStack() {
		Collections.shuffle(stack);
	}
	
	public boolean isEmpty()
	{
		return(top==-1);	
	}

	public Card getCardAt(int randomIndex) {
		// TODO Auto-generated method stub
		return (Card) stack.get(randomIndex);
		
	}
}