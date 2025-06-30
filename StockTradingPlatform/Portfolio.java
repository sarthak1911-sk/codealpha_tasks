package StockTradingPlatform;

import java.io.*;
import java.util.*;

public class Portfolio {
  private User user;
  private HashMap<String, Integer> holdings = new HashMap<>();

  public Portfolio(User user) {
    this.user = user;
  }

  public void buyStock(String symbol, int qty, Market market) {
    Stock stock = market.getStock(symbol);
    if (stock != null) {
      holdings.put(symbol, holdings.getOrDefault(symbol, 0) + qty);
      System.out.println("Bought " + qty + " shares of " + symbol);
    } else {
      System.out.println("Stock not found.");
    }
  }

  public void sellStock(String symbol, int qty, Market market) {
    if (!holdings.containsKey(symbol) || holdings.get(symbol) < qty) {
      System.out.println("Not enough shares to sell.");
      return;
    }
    holdings.put(symbol, holdings.get(symbol) - qty);
    System.out.println("Sold " + qty + " shares of " + symbol);
  }

  public void viewPortfolio() {
    System.out.println("\n--- Portfolio of " + user.getName() + " ---");
    if (holdings.isEmpty()) {
      System.out.println("No holdings yet.");
    } else {
      for (String symbol : holdings.keySet()) {
        System.out.println(symbol + ": " + holdings.get(symbol) + " shares");
      }
    }
  }

  public void savePortfolio(String filename) {
    try (PrintWriter pw = new PrintWriter(filename)) {
      for (String symbol : holdings.keySet()) {
        pw.println(symbol + "," + holdings.get(symbol));
      }
    } catch (IOException e) {
      System.out.println("Error saving portfolio.");
    }
  }

  public void loadPortfolio(String filename) {
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] parts = line.split(",");
        holdings.put(parts[0], Integer.parseInt(parts[1]));
      }
    } catch (IOException e) {
      System.out.println("No existing portfolio found.");
    }
  }
}
