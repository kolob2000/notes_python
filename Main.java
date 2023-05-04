import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ToyShop toys = new ToyShop();
        toys.addOne("Мишка", 3, 17);
        toys.addOne("Тюля", 9, 43);
        toys.addOne("Муля", 2, 11);
        toys.addOne("Паля", 5, 57);
        toys.addOne("Кукла", 1, 12);
        toys.addOne("Кран", 4, 32);
        toys.addOne("Барабан", 8, 27);
        toys.addOne("Лего", 15, 77);
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("1 - Вывести все игрушки; 2 - Сыграть в лотерею; 3 - Выход;\n");
            String in = scanner.nextLine().strip();
            switch (in) {
                case "1" -> toys.printAll();
                case "2" -> {
                    boolean inGame = true;
                    ToysLottery lottery = new ToysLottery(toys);
                    while (inGame) {
                        if (lottery.size() == 0) {
                            System.out.println("Нет игрушек для розыгрыша. Попробуйте позже.");
                            break;
                        }
                        System.out.println("1 - Сделать попытку; 2 - Получить игрушку; 3 - Вернуться в магазин;\n");
                        String inp = scanner.nextLine().strip();
                        switch (inp) {
                            case "1" -> lottery.LetsPlay();
                            case "2" -> lottery.delivery();
                            case "3" -> inGame = false;
                            default -> System.out.println("Не верная команда.");
                        }
                        if (lottery.size() == 0) {
                            while (lottery.getToysListSize() > 0) {
                                lottery.delivery();
                            }
                            System.out.println("Все игрушки выданы. Пока.");
                            inGame = false;
                        }
                    }
                }
                case "3" -> flag = false;
                default -> System.out.println("Не верная команда.");
            }

        }
    }
}
