package com.company;

import java.util.Scanner;

//Adham Ayman Farouk                         21100782
public class BlackJack {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int card1, card2, cardd1, cardd2, cardtotal1, cardtotald1;
        String hos, hol;
        int lc = 0, wc = 0, dc = 0, deck = 52, cc = 0;
        while (deck >= 4) {
            System.out.println(ANSI_YELLOW + "Press 1 To Play Press 0 To Exit" + ANSI_RESET);
            int game = sc.nextInt();
            if (game == 1) {
                card1 = 1 + (int) (Math.random() * 13);
                card2 = 1 + (int) (Math.random() * 13);
                cardd1 = 1 + (int) (Math.random() * 13);
                cardd2 = 1 + (int) (Math.random() * 13);

                if (card1 != 13) {
                    if (card1 == 12) card1 = 10;
                    else if (card1 == 11) card1 = 10;
                } else {
                    card1 = 10;
                }

                if (card2 != 13) {
                    if (card2 == 12) card2 = 10;
                    else if (card2 == 11) card2 = 10;
                } else {
                    card2 = 10;
                }

                if (cardd1 != 13) {
                    if (cardd1 == 12) cardd1 = 10;
                    else if (cardd1 == 11) cardd1 = 10;
                } else {
                    cardd1 = 10;
                }

                if (cardd2 != 12) {
                    if (cardd2 == 13) cardd2 = 10;
                    else if (cardd2 == 11) cardd2 = 10;
                } else {
                    cardd2 = 10;
                }

                if (card1 == 1) {
                    System.out.println(ANSI_BLUE + ("First Card : " + card2) + ANSI_RESET);
                    System.out.println("You Draw An Ace Press      X for High      Y for Low");
                    hol = sc.next();
                    if (hol.equalsIgnoreCase("x")) card1 = 11;
                    if (hol.equalsIgnoreCase("y")) card1 = 1;
                }

                if (card2 == 1) {
                    System.out.println("First Card : " + card1);
                    System.out.println("You Draw An Ace Press      X for High      Y for Low");
                    hol = sc.next();
                    if (hol.equalsIgnoreCase("x")) card2 = 11;
                    if (hol.equalsIgnoreCase("y")) card2 = 1;
                }

                if (cardd1 == 1) {
                    cardd1 = 11;
                }

                if (cardd2 == 1) {
                    cardd1 = 11;
                }

                deck -= 4;

                cardtotal1 = card1 + card2;

                cardtotald1 = cardd1 + cardd2;

                if (cardtotal1 == 21) {
                    System.out.println("Player BlackJack");
                    if (cardtotald1 < cardtotal1) {
                        System.out.println("Dealer Total : " + cardtotald1 + "\nPlayer Wins");
                        wc++;
                        System.out.println("Cards In Deck : " + deck + "\nwins : " + wc + "\nDraws : " + dc + "\nLoses : " + lc);
                    }
                    continue;

                } else {
                    System.out.println(ANSI_BLUE + ("Player Drew : " + card1 + " And " + card2) + ANSI_RESET + ANSI_PURPLE + '\n' + ("Dealer Drew : " + cardd1) + ANSI_RESET);
                    System.out.println(ANSI_BLUE + ("Player Total : " + cardtotal1) + ANSI_RESET);
                }

                while (true) {
                    System.out.println("Press H to hit \t\t\t Press S to stand");
                    hos = sc.next();
                    if (hos.equalsIgnoreCase("h")) {

                        card1 = 1 + (int) (Math.random() * 13);
                        if (card1 != 13) {
                            if (card1 == 12) card1 = 10;
                            else if (card1 == 11) card1 = 10;
                        } else {
                            card1 = 10;
                        }

                        if (card1 == 1) {
                            System.out.println("You Draw An Ace Press      X for High      Y for Low");
                            hol = sc.next();
                            if (hol.equalsIgnoreCase("x")) card1 = 11;
                            if (hol.equalsIgnoreCase("y")) card1 = 1;
                        }

                        deck--;
                        cardtotal1 += card1;
                        System.out.println(ANSI_BLUE + ("Player drew : " + card1 + "\nPlayer Total : " + cardtotal1) + ANSI_RESET);


                        if (cardtotal1 == 21) {
                            System.out.println("BlackJack");
                            if (cardtotald1 < cardtotal1) {
                                System.out.println("Dealer Total : " + cardtotald1 + "\nPlayer Wins");
                                wc++;
                                System.out.println("Cards In Deck : " + deck + "\nwins : " + wc + "\nDraws : " + dc + "\nLoses : " + lc);
                            }
                            break;

                        }

                        if (cardtotal1 > 21) {
                            lc++;
                            System.out.println(ANSI_RED + "Player Bust Dealer Won" + ANSI_RESET);
                            System.out.println("Dealer Total : " + cardtotald1 + "\nCards In Deck : " + deck + "\nwins : " + wc + "\nDraws : " + dc + "\nLoses : " + lc);

                            break;
                        }

                    } else if (hos.equalsIgnoreCase("s")) {
                        if (cardtotald1 > cardtotal1) {
                            System.out.println(ANSI_RED + ("Player Total : " + cardtotal1 + "\nDealer Total : " + cardtotald1 + "\nDealer Won" + ANSI_RESET));
                            lc++;
                            System.out.println("wins : " + wc + "\nDraws : " + dc + "\nLoses : " + lc);
                            break;
                        } else {
                            System.out.println("Dealer Total : " + cardtotald1);

                            do {
                                if (cardtotald1 < 17) {
                                    cardd1 = 1 + (int) (Math.random() * 13);
                                    if (cardd1 != 13) {
                                        if (cardd1 == 12) cardd1 = 10;
                                        else if (cardd1 == 11) cardd1 = 10;
                                    } else {
                                        cardd1 = 10;
                                    }
                                    if (cardd1 == 1) {
                                        if (cardtotald1 <= 10) cardd1 = 11;
                                    }
                                    cc++;
                                    deck--;
                                    cardtotald1 += cardd1;
                                    System.out.println("Dealer Drew : " + cardd1);
                                }

                                if (cardtotald1 > 21) {
                                    System.out.println("Dealer Busted     Player Won");
                                    wc++;
                                    break;
                                }

                                if (cardtotald1 > cardtotal1) break;
                                if (cardtotald1 >= 17) break;


                            }
                            while (cardtotald1 <= cardtotal1 || cc >= 3);


                        }
                        if (cardtotald1 == cardtotal1) {
                            System.out.println(ANSI_WHITE + ("Player Total : " + cardtotal1 + "\nDealer Total : " + cardtotald1 + "\nDraw") + ANSI_RESET);
                            dc++;
                        } else if (cardtotald1 > cardtotal1 && cardtotald1 <= 21) {
                            System.out.println(ANSI_RED + ("Player Total : " + cardtotal1 + "\nDealer Total : " + cardtotald1 + "\nDealer Won" + ANSI_RESET));
                            lc++;
                        } else if (cardtotald1 < cardtotal1) {
                            System.out.println(ANSI_GREEN + ("Player Total : " + cardtotal1 + "\nDealer Total : " + cardtotald1 + "\nPlayer Wins ") + ANSI_RESET);
                            wc++;
                        }
                        System.out.println("Cards In Deck : " + deck + "\nwins : " + wc + "\nDraws : " + dc + "\nLoses : " + lc);
                        break;


                    }

                }

            } else {
                System.out.println("Goodbye");
                break;
            }
        }
        System.out.println("Not Enough Cards In Deck");
    }
}




