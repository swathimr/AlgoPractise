package OODesign.VendingMachine;

import java.util.List;
import java.util.Map;

public interface VendingMachineInterface {
    public long selectItemAndGetPrice(Item item);
    public void insertCoin(Coin coin);
    public Map<Item, List<Coin>> collectItemAndChange();
    public void reset();
}
