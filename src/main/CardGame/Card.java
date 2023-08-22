package com.learning.CardGame;

public class Card {
	public static String suits[] = {"club", "spade", "diamond", "heart"};
	public static String ranks[] = {"2","3","4","5","6","7","8","9",
			"10","J","Q","K","A"};
	public String suit;
	public String rank;
	
	public Card(String suit, String rank)
	{
		this.suit = suit;
		this.rank = rank;
	}
	
	public boolean equalsTo(Card other)
	{
		return this.suit.equals(other.suit) && this.rank.equals(other.rank);
	}
	
	@Override
	public String toString()
	{
		return suit+"  "+rank;
	}

}