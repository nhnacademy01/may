//package day9.class1;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Scanner;
//
//public class CardGame {
//    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        System.out.print("게임 참여자 수 > ");
//        int numHands = s.nextInt();
//        System.out.print("참여자 당 카드 수 > ");
//        int cardsPerHand = s.nextInt();
//
//        List<Card> deck = new ArrayList<>();
//        Card.Suit[] values = Card.Suit.values();
//        for (Card.Suit suit : values) {
//            for (Card.Rank rank : Card.Rank.values()) {
//                deck.add(new Card(suit, rank));
//            }
//        }
//
//        Collections.shuffle(deck);
//
//        if (numHands * cardsPerHand > deck.size()) {
//            System.out.println("Not enough cards.");
//            return;
//        }
//        for (int i = 0; i < numHands; i++)
//            System.out.println(dealHand(deck, cardsPerHand));
//    }
//
//    public static <E> List<E> dealHand(List<E> deck, int n) {
//        int deckSize = deck.size();
//        List<E> handView = deck.subList(deckSize - n, deckSize);
//        List<E> hand = new ArrayList<E>(handView);
//        handView.clear();
//        return hand;
//    }
//}
////
////interface  Displayable {
////    String getDisplay();
////}
////
////class Card {
////    private Suit suit;
////    private Rank rank;
////
////    private Card(Suit suit, Rank rank) {
////        this.suit = suit;
////        this.rank = rank;
////    }
////
////    enum Suit implements  Displayable{
////        SPADES("스페이드"), DIAMONDS("다이아"), CLUBS("클로바"), HARTS("하트");
////
////        @Override
////        public  final String display;
////
////        @Override
////        public String getDisplay() {
////            return null;
////        }
////    }
////
////
////    enum Rank implements  Displayable{
////
////        Ace, _2, _3, _4, _5, _6, _7, _8, _9, _10,
////        Jack, Queen, King
////
////        @Override
////        private  final String dispaly;
////
////        @Override
////        public  String toString() {
////            return null;
////        }
////    }
////
////}
