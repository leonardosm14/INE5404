package Problema3;

// Fig. 7.11: DeckOfCardsTest.java
// Card shuffling and dealing.

public class DeckOfCardsTest
{
   // execute application
   public static void main(String[] args)
   {
      DeckOfCards myDeckOfCards = new DeckOfCards();
      myDeckOfCards.shuffle(); // place Cards in random order
      
      // Array para armazenar a mão de cartas
      Card[] hand = new Card[5];

      // Distribuir cinco cartas para formar uma mão
      for (int i = 0; i < 5; i++) {
         hand[i] = myDeckOfCards.dealCard();
      }

      // Imprimir a mão
      System.out.println("Hand:");
      for (Card card : hand) {
         System.out.printf("%-19s", card);
      }

      // Exibir relatório das combinações de cartas na mão
      System.out.println("\n\nHand contains:");
      System.out.println("Pair: " + myDeckOfCards.hasPair(hand));
      System.out.println("Two Pairs: " + myDeckOfCards.hasTwoPairs(hand));
      System.out.println("Three of a Kind: " + myDeckOfCards.hasThreeSame(hand));
      System.out.println("Four of a Kind: " + myDeckOfCards.hasFourSame(hand));
      System.out.println("Flush: " + myDeckOfCards.hasFlush(hand));
      System.out.println("Straight: " + myDeckOfCards.hasStraight(hand));
      System.out.println("Full House: " + myDeckOfCards.hasFullHouse(hand));
   } 
} // end class DeckOfCardsTest