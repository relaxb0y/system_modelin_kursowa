import java.util.ArrayList;
import java.util.List;

public class PetriNet {  // Класс сети Петри
    public List<Position> Positions = new ArrayList<>();  // Сохраняет список позиций
    public List<Transition> Transitions = new ArrayList<>();  // Сохраняет список переходов

    public Transition GetTransitionByNumber(int number) {  // Возвращает переход по номеру в сети
        for (Transition transition : Transitions) {
            if (transition.Number == number) {
                return transition;
            }
        }
        return null;
    }

    public Position GetPositionByNumber(int number) {  // Возвращает позицию по номеру в сети
        for (Position position : Positions) {
            if (position.Number == number) {
                return position;
            }
        }
        return null;
    }

    public List<Transition> GetListOfAllowedTransitions() {  // Возвращает список переходов, для которых выполнено условие перехода
        List<Transition> resultList = new ArrayList<>();
        for (Transition transition : Transitions) {
            if (transition.TransitionAllowed(this)) {
                resultList.add(transition);
            }
        }
        return resultList;
    }
}
