package OODesign.VendingMachine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachineImpl implements VendingMachineInterface {

  private Item currentItem;
  private long currentBalance;
  private Inventory<Coin> cashInventory = new Inventory<Coin>();
  private Inventory<Item> itemInventory = new Inventory<Item>();

  public VendingMachineImpl() {
    initialize();
  }

  private void initialize() {
    // initialize machine with 5 coins of each denomination
    // and 5 cans of each Item
    for (Coin c : Coin.values()) {
      cashInventory.put(c, 5);
    }
    for (Item i : Item.values()) {
      itemInventory.put(i, 5);
    }
  }

  @Override
  public long selectItemAndGetPrice(Item item) {
    if (itemInventory.hasItem(item)) {
      currentItem = item;
      return currentItem.getPrice();
    }
    return 0L;
  }

  @Override
  public void insertCoin(Coin coin) {
    currentBalance = currentBalance + coin.getDenomination();
    cashInventory.add(coin);
  }

  @Override
  public Map<Item, List<Coin>> collectItemAndChange() {
    Item item = collectItem();
    totalSales = totalSales + currentItem.getPrice();
    List<Coin> change = collectChange();
    return new HashMap<>(item, change);
  }

  private List<Coin> collectChange() {
    long changeAmount = currentBalance - currentItem.getPrice();
    List<Coin> change = getChange(changeAmount);
    updateCashInventory(change);
    currentBalance = 0;
    currentItem = null;
    return change;
  }

  @Override
  public List<Coin> refund() {
    List<Coin> refund = getChange(currentBalance);
    updateCashInventory(refund);
    currentBalance = 0;
    currentItem = null;
    return refund;
  }

  @Override
  public void reset() {
    cashInventory.clear();
    itemInventory.clear();
    totalSales = 0;
    currentItem = null;
    currentBalance = 0;
  }
}
