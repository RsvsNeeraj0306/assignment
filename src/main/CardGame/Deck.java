package com.learning.CardGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;


public class Deck {
    Stack<Card> deck = new Stack<Card>();
    Stack<Card> userdeck = new Stack<Card>();
    
    public List<Optional<Card>> inpiles = new ArrayList<>();
    public List<Optional<Card>> outpiles = new ArrayList<>();
    
    public Card usercard;
    public Card incard;
    public Card outcard;
    int inpileIndex = 0;
    int outpileIndex = 0;
    private Random random = new Random();
    public Deck() {
        for (int i = 0; i < Card.suits.length; i++) {
            for (int j = 0; j < Card.ranks.length; j++) {
                deck.push(new Card(Card.suits[i], Card.ranks[j]));
            }
        }
        deck.shuffleStack();
        for (int i = 0; i < Card.suits.length; i++) {
            for (int j = 0; j < Card.ranks.length; j++) {
                userdeck.push(new Card(Card.suits[i], Card.ranks[j]));
            }
        }
        userdeck.shuffleStack();
        
    }
 

    public Card getRandomCard() {
    	this.usercard=userdeck.getTop();
         return this.usercard;
         
     }
    
    public boolean getInpileResult() {
    	if((this.usercard).equals(incard)) {
    		
    		return true;
    	}
		return false;
    }
    
    public boolean getOutpileResult() {
    	if((this.usercard).equals(outcard)) {
    		
    		return true;
    	}
		return false;
    }
    
    
   
    public boolean empty() {
        return deck.isEmpty();
    }
    
    public Card removeCardFromDeck() {
        return deck.pop();
    }
    
    public void setpile() {
        int count = 0;
        
        while (!empty()) {
            Optional<Card> card = Optional.ofNullable(removeCardFromDeck());
            
            if (count % 2 == 0) {
                inpiles.add(card);
            } else {
                outpiles.add(card);
            }
            
            count++;
        }
    }
    
    public Card getInpile() {
        setpile();
        
        if (inpileIndex < inpiles.size()) {
            this.inpileIndex++;
            this.incard=inpiles.get(inpileIndex - 1).orElse(null);
            return this.incard;
        }
        return null;
    }
    
    public Card getOutpile() {
        setpile();
        
        if (outpileIndex < outpiles.size()) {
            this.outpileIndex++;
            this.outcard=inpiles.get(outpileIndex - 1).orElse(null);
            return this.outcard;
        }
        return null;
    }


	
	public static void main(String[] args) {
		Deck d = new Deck();
		//System.out.println(d.getRandomCard());
		System.out.println(d.getOutpile());
		System.out.println(d.getOutpile());
	
	}
}

		

