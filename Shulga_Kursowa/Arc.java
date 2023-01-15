public class Arc {  // Класс дуги
    private final int numberOfPosition;  // Сохраняет номер позиции в сети, с которым связана даная дуга
    private final int quantity;  // Сохраняет
    public Arc(int numberOfPosition, int quantity) {  // Конструктор
        this.numberOfPosition = numberOfPosition;
        this.quantity = quantity;
    }
    public int getNumberOfPosition() {  // Геттер для номера в сети
        return numberOfPosition;
    }
    public int getQuantity() {  // Геттер для кратности дуги
        return quantity;
    }
}
