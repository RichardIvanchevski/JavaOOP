package cardSuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Card Suits");
//           System.out.println("Card Ranks");
//        for (CardRank rank : CardRank.values()) {
//            System.out.printf("Ordinal value: %d; Name value: %s%n",rank.ordinal(),rank.name());
//        }
        Scanner scanner = new Scanner(System.in);
        CardRank cardRank = CardRank.valueOf(scanner.nextLine());
        CardType cardType = CardType.valueOf(scanner.nextLine());

        System.out.printf("Card name: %s of %s; Card power: %d",cardRank,cardType,cardRank.getPower() + cardType.getPower());


    }
}
