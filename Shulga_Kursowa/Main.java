public class Main {
    public static void main(String[] args) {
        PetriSimulation petriSimulation = new PetriSimulation();  // Создаём новый экземпляр класса PetriSimulation
        petriSimulation.SetupAndRunSimulation(true, 1000);  // Конфигурируем и запускаем её работу
    }
}