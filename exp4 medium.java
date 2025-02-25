import java.util.*;

class Card {
    String symbol;
    int number;
    public Card(String symbol, int number) {
        this.symbol = symbol;
        this.number = number;
    }
}

public class CardCollection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of Cards: ");
        int n = sc.nextInt();
        sc.nextLine();
        Map<String, List<Card>> cardMap = new TreeMap<>();
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter card " + i + " symbol: ");
            String symbol = sc.nextLine().trim();
            System.out.print("Enter card " + i + " number: ");
            int number = sc.nextInt();
            sc.nextLine();
            Card card = new Card(symbol, number);
            cardMap.putIfAbsent(symbol, new ArrayList<>());
            cardMap.get(symbol).add(card);
        }
        System.out.println("Distinct Symbols are :");
        for (String symbol : cardMap.keySet()) {
            System.out.print(symbol + " ");
        }
        System.out.println();
        for (String symbol : cardMap.keySet()) {
            List<Card> cards = cardMap.get(symbol);
            System.out.println("Cards in " + symbol + " Symbol");
            int sum = 0;
            for (Card card : cards) {
                System.out.println(card.symbol + " " + card.number);
                sum += card.number;
            }
            System.out.println("Number of cards: " + cards.size());
            System.out.println("Sum of Numbers: " + sum);
        }
        sc.close();
    }
}
