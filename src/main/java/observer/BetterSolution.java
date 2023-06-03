package observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class BetterSolution {
    static class Inventory{

        Map<Item, Integer> quantities = new HashMap<>();
        List<Consumer<Item>> observers = new ArrayList<>();

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
            observers.forEach(observer -> observer.accept(item));
        }

        public void addObserver(Consumer<Item> observer){
            observers.add(observer);
        }

    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addObserver(item -> System.out.println("Inventory for "+item +" is empty"));

        Item rice = new Item();
        inventory.restock(rice, 2);
        inventory.restock(rice, 4);
        inventory.supply(rice, 5);
        inventory.supply(rice, 1);
    }

}
