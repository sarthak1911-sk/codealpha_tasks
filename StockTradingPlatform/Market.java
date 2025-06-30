package StockTradingPlatform;

import java.io.*;
import java.util.*;

public class Market {
  private HashMap<String, Stock> stockList = new HashMap<>();

  public void loadStocks(String filename) {
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] parts = line.split(",");
        Stock stock = new Stock(parts[0], parts[1], Double.parseDouble(parts[2]));
        stockList.put(parts[0], stock);
      }
    } catch (IOException e) {
      System.out.println("Error loading market data.");
    }
  }

  public void displayMarket() {
    System.out.println("\n--- Market Stocks ---");
    for (Stock s : stockList.values()) {
      System.out.println(s);
    }
  }

  public Stock getStock(String symbol) {
    return stockList.get(symbol);
  }
}
