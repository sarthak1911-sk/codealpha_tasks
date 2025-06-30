package StockTradingPlatform;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Market market = new Market();
    User user = new User("Sarthak");
    Portfolio portfolio = new Portfolio(user);
    Scanner sc = new Scanner(System.in);

    market.loadStocks("data/stocks.txt");
    portfolio.loadPortfolio("data/portfolio.txt");

    int choice;
    do {
      System.out.println("\n--- Stock Trading Platform ---");
      System.out.println("1. View Market");
      System.out.println("2. Buy Stock");
      System.out.println("3. Sell Stock");
      System.out.println("4. View Portfolio");
      System.out.println("5. Exit");
      System.out.print("Enter your choice: ");
      choice = sc.nextInt();

      switch (choice) {
        case 1 -> market.displayMarket();
        case 2 -> {
          System.out.print("Enter stock symbol: ");
          String symbol = sc.next();
          System.out.print("Enter quantity: ");
          int qty = sc.nextInt();
          portfolio.buyStock(symbol, qty, market);
        }
        case 3 -> {
          System.out.print("Enter stock symbol: ");
          String symbol = sc.next();
          System.out.print("Enter quantity: ");
          int qty = sc.nextInt();
          portfolio.sellStock(symbol, qty, market);
        }
        case 4 -> portfolio.viewPortfolio();
        case 5 -> {
          portfolio.savePortfolio("data/portfolio.txt");
          System.out.println("Exiting... Data saved.");
        }
        default -> System.out.println("Invalid choice.");
      }
    } while (choice != 5);

    sc.close();
  }
}
