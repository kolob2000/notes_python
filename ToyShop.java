import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ToyShop {
    Map<String, Toy> Toys = new HashMap<>();

    public int productCount() {
        return Toys.size();
    }

    public int totalCount() {
        int count = 0;
        for (Map.Entry<String, Toy> entry : Toys.entrySet()) {
            count += entry.getValue().getQuantity();
        }
        return count;
    }

    public Map<String, Toy> getToys() {
        return this.Toys;
    }

    public void addOne(String title) {
        if (!this.Toys.containsKey(title)) {
            this.Toys.put(title, new Toy(title));
        } else {
            System.out.println("Такая игрушка уже существует.");
        }
    }

    public void addOne(String title, int quantity) {
        if (!this.Toys.containsKey(title)) {
            this.Toys.put(title, new Toy(title, quantity));
        } else {
            System.out.println("Такая игрушка уже существует.");
        }
    }

    public void addOne(String title, int quantity, int frequency) {
        if (!this.Toys.containsKey(title)) {
            this.Toys.put(title, new Toy(title, quantity, frequency));
        } else {
            System.out.println("Такая игрушка уже существует.");
        }
    }

    public void increaseQuantity(String title, int quantity) {
        if (quantity > 0) {
            Toys.get(title).increaseQuantity(quantity);
        } else {
            System.out.println("Нельзя уменьшить на число меньше единцы.");
        }
    }

    public void decreaseQuantity(String title, int quantity) {
        if (quantity > 0) {
            Toys.get(title).decreaseQuantity(quantity);
        } else {
            System.out.println("Нельзя уменьшить на число меньше единцы.");
        }
    }

    public void printAll() {
        if (this.Toys.size() == 0) {
            System.out.println("В магазин еще не завезли игрушек.");
        } else {
            for (Map.Entry<String, Toy> entry : Toys.entrySet()) {
                System.out.println(entry.getValue().toString());
            }
        }
    }

    @Override
    public String toString() {
        return "Приветствуем вас в магазине \"Плюша\"" +
                "\nКоличество наименований - " + this.productCount() +
                "\nОбщее количество игрушек - " + this.totalCount();
    }
}
