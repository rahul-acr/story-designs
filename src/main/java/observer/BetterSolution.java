package observer;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class BetterSolution {
    static class Inventory{

        Map<Item, Integer> quantities = new HashMap<>();

        void supply(Item item, int quantity){
            int currentQuantity = quantities.getOrDefault(item, 0);
            int newQuantity = currentQuantity - quantity;
            if (newQuantity == 0) {
                notifyForEmptyInventory(item);
            }
        }

        private void notifyForEmptyInventory(Item item) {
            System.out.println("Inventory for "+item +" is empty");
        }
    }

}
