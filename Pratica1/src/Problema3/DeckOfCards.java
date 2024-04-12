package Problema3;

// Fig. 7.10: DeckOfCards.java
// DeckOfCards class represents a deck of playing cards.
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Comparator;

public class DeckOfCards
{
   private Card[] deck; // array of Card objects
   private int currentCard; // index of next Card to be dealt (0-51)
   private static final int NUMBER_OF_CARDS = 52; // constant # of Cards
   // random number generator
   private static final SecureRandom randomNumbers = new SecureRandom();

   // constructor fills deck of Cards
   public DeckOfCards()
   {
      String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six", 
         "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
      String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

      deck = new Card[NUMBER_OF_CARDS]; // create array of Card objects
      currentCard = 0; // first Card dealt will be deck[0]

      // populate deck with Card objects
      for (int count = 0; count < deck.length; count++) 
         deck[count] = 
            new Card(faces[count % 13], suits[count / 13]);
   } 

   // shuffle deck of Cards with one-pass algorithm
   public void shuffle()
   {
      // next call to method dealCard should start at deck[0] again
      currentCard = 0; 

      // for each Card, pick another random Card (0-51) and swap them
      for (int first = 0; first < deck.length; first++) 
      {
         // select a random number between 0 and 51 
         int second =  randomNumbers.nextInt(NUMBER_OF_CARDS);
         
         // swap current Card with randomly selected Card
         Card temp = deck[first];        
         deck[first] = deck[second];   
         deck[second] = temp;            
      } 
   } 

   // deal one Card
   public Card dealCard()
   {
      // determine whether Cards remain to be dealt
      if (currentCard < deck.length)
         return deck[currentCard++]; // return current Card in array
      else        
         return null; // return null to indicate that all Cards were dealt
   } 
   
   // Um par
   public boolean hasPair(Card[] deck) {
      for (int i = 0; i < deck.length; i++) {
         for (int j = 0; j < deck.length; j++) {
             if (i!=j && deck[i].hasSameFace(deck[j])) {
                 return true;
             }
         }
     }
     return false;
  }

  // Dois pares
  public boolean hasTwoPairs(Card[] deck) {
   int count = 0;
   for (int i = 0; i < deck.length; i++) {
       for (int j = i+1; j < deck.length; j++) {
           if (deck[i].hasSameFace(deck[j])) {
               count++;
           }
       }
   }
   return count == 2;
  }

  public boolean hasThreeSame(Card[] deck) {
   for (int i = 0; i < deck.length; i++) {
      int count = 0;
      for (int j = 0; j < deck.length; j++) {
          if (i!=j && deck[i].hasSameFace(deck[j])) {
              count++;
          }
      }
      if (count == 3) {
          return true;
      }
  }
  return false;
  }

  // Quadra
  public boolean hasFourSame(Card[] deck) {
      for (int i = 0; i < deck.length; i++) {
          int count = 1;
          for (int j = 0; j < deck.length; j++) {
              if (i != j && deck[i].hasSameFace(deck[j])) {
                  count++;
              }
          }
          if (count == 4) {
              return true;
          }
      }
      return false;
  }


  // Flush
  public boolean hasFlush(Card[] deck) {
   int heartsCount = 0;
   int diamondsCount = 0;
   int clubsCount = 0;
   int spadesCount = 0;

   for (Card card : deck) {
         String suit = card.getSuit();
         if (suit.equals("Hearts")) {
            heartsCount++;
         } else if (suit.equals("Diamonds")) {
            diamondsCount++;
         } else if (suit.equals("Clubs")) {
            clubsCount++;
         } else if (suit.equals("Spades")) {
            spadesCount++;
         }
      }

      if (heartsCount == 5 || diamondsCount == 5 || clubsCount == 5 || spadesCount == 5) {
         return true;
      }

      return false;
   }


   // Verifica se a mão contém um straight
   public boolean hasStraight(Card[] deck) {
   Arrays.sort(deck, Comparator.comparingInt(c -> Arrays.asList("Ace", "Deuce", "Three", "Four", "Five", "Six", 
         "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King").indexOf(c.getFace())));
   for (int i = 1; i < deck.length; i++) {
         if (Arrays.asList("Ace", "Deuce", "Three", "Four", "Five", "Six", 
         "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King").indexOf(deck[i].getFace()) != Arrays.asList("Ace", "Deuce", "Three", "Four", "Five", "Six", 
         "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King").indexOf(deck[i - 1].getFace()) + 1) {
            return false;
         }
   }
   return true;
}

// Verifica se a mão contém um full house
public boolean hasFullHouse(Card[] deck) {
   int[] faceCount = new int[13];
   for (Card card : deck) {
       faceCount[Arrays.asList("Ace", "Deuce", "Three", "Four", "Five", "Six", 
         "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King").indexOf(card.getFace())]++;
   }
   boolean hasThree = false;
   boolean hasPair = false;
   for (int count : faceCount) {
       if (count == 3) {
           hasThree = true;
       } else if (count == 2) {
           hasPair = true;
       }
   }
   return hasThree && hasPair;
   }
}
