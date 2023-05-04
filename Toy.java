public class Toy {
    private static long count = 1;
    private final long id;
    public final String title;
    private int quantity;

    private int frequency;

    public Toy(String title) {
        this.id = Toy.count++;
        this.title = title;
        this.quantity = 0;
        this.frequency = 50;

    }

    public Toy(String title, int quantity) {
        this.id = Toy.count++;
        this.title = title;
        this.quantity = quantity;
        this.frequency = 50;
    }

    public Toy(String title, int quantity, int frequency) {
        this.id = Toy.count++;
        this.title = title;
        this.quantity = quantity;
        this.frequency = frequency;
    }

    public void increaseQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void decreaseQuantity(int quantity) {
        if (quantity <= this.quantity) {
            this.quantity -= quantity;
        } else {
            System.out.println("Не хватает количества " +
                    "игрушек для уменьшения на " + quantity +
                    ". Всего на складе - " + this.quantity + ".");
        }
    }

    public void setFrequency(int frequency) {
        if (frequency > 0 && frequency <= 100) {
            this.frequency = frequency;
        }
    }

    public int getFrequency() {
        return this.frequency;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", quantity=" + quantity +
                ", frequency=" + frequency +
                '}';
    }

    public int getQuantity() {
        return this.quantity;
    }
}
