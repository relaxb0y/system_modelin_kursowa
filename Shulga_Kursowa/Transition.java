import java.util.List;

public class Transition {  // Класс перехода
    public int Number;  // Сохраняет номер перехода в сети
    public List<Arc> ArcsToIn;  // Сохраняет список дуг на вход
    public List<Arc> ArcsToOut;  // Сохраняет список дуг на выход
    public void DoIn(PetriNet petriNet) {  // Провести вход маркеров
        for (var arc : ArcsToIn) {
            Position position = petriNet.GetPositionByNumber(arc.getNumberOfPosition());
            position.Mark -= arc.getQuantity();
        }
    }

    public void DoOut(PetriNet petriNet) {  // Провести выход маркеров
        for (var arc : ArcsToOut) {
            Position position = petriNet.GetPositionByNumber(arc.getNumberOfPosition());
            position.Mark += arc.getQuantity();
        }
    }
    public boolean TransitionAllowed(PetriNet petriNet) {  // Возвращает true/false выполения условия перехода
        for (Arc arc : ArcsToIn) {
            Position position = petriNet.GetPositionByNumber(arc.getNumberOfPosition());

            if (position.Mark < arc.getQuantity()) {
                return false;
            }
        }
        return true;
    }
}

