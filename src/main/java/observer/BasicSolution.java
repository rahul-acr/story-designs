package observer;

import java.util.HashMap;
import java.util.Map;

public class BasicSolution {

    static class Inventory{

        Map<Item, Integer> quantities = new HashMap<>();

        void supply(Item item, int quantity){
            int currentQuantity = quantities.getOrDefault(item, 0);
            int newQuantity = currentQuantity - quantity;
            quantities.put(item, newQuantity);
            if (newQuantity == 0) {
                notifyForEmptyInventory(item);
            }

        }

        void restock(Item item, int quantity){
            quantities.compute(item, (__, prevQuantity) -> {
               if(prevQuantity == null)
                   return quantity;
               return prevQuantity + quantity;
            });
        }

        private void notifyForEmptyInventory(Item item) {
            System.out.println("Inventory for "+item +" is empty");
        }
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Item rice = new Item();
        inventory.restock(rice, 2);
        inventory.restock(rice, 4);
        inventory.supply(rice, 5);
        inventory.supply(rice, 1);
    }

}
