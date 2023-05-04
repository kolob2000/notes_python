import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

public class ToysLottery {


    private int totalWeight = 0;
    private final LinkedList<Toy> toysList = new LinkedList<>();
    private LinkedList<Toy> toysListForDelivery = new LinkedList<>();

    public ToysLottery(ToyShop toyShop) {
        Map<String, Toy> toys = toyShop.getToys();
        for (Map.Entry<String, Toy> entry : toys.entrySet()) {
            Toy toy = entry.getValue();
            if (toy.getQuantity() > 0) {
                this.toysList.add(toy);
                this.totalWeight += toy.getFrequency();
            }

        }
    }

    private void setCurrentTotalWeight() {
        this.totalWeight = 0;
        for (Toy t : toysList
        ) {
            this.totalWeight += t.getFrequency();
        }
    }

    public int size() {
        return toysList.size();
    }

    public int getToysListSize() {
        return this.toysListForDelivery.size();
    }

    public void LetsPlay() {
        int randomWeight = new Random().nextInt(this.totalWeight);
        for (int i = 0; i < toysList.size(); i++) {
            randomWeight -= toysList.get(i).getFrequency();
            if (randomWeight < 0) {
                System.out.println("Ваша игрушка - " + toysList.get(i).title);
                toysListForDelivery.add(toysList.get(i));
                toysList.remove(i);
                break;
            }
        }
        setCurrentTotalWeight();
    }

    public void delivery() {
        if (toysListForDelivery.size() != 0) {
            System.out.println("Игрушка " + toysListForDelivery.get(0).title + " выдана.");
            toysListForDelivery.get(0).increaseQuantity(1);
            toysListForDelivery.remove(0);

        } else {
            System.out.println("У вас не игрушек для получения.");
        }
    }

}
