import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PetriSimulation {

    public PetriNet PetriNet;  // Сохраняет сеть Петри
    public int TransitionsCount;  // Задает максимальное количество выполняемых переходов
    public int CurrentTransition;  // Счетчик текущего количества выполеных переходов

    public void SetupAndRunSimulation(boolean printStatistics, int transitionsCount) {  // Конфигурация и запуск имитации
        TransitionsCount = transitionsCount;
        CurrentTransition = 1;  // Обнуляем счетчик
        //SetUpExperiment1();  // Сконфигурировать 1 эксперимент
        //SetUpExperiment2();  // Сконфигурировать 2 эксперимент
        //SetUpExperiment3();  // Сконфигурировать 3 эксперимент
        //SetUpExperiment4();  // Сконфигурировать 4 эксперимент
        SetUpExperiment5();  // Сконфигурировать 5 эксперимент
        Run(printStatistics);
    }

    private void Run(boolean printStatistics) {  // Метод запуска сети, содержащий основной цикл
        List<Transition> transitions = PetriNet.GetListOfAllowedTransitions();  // Получаем список переходов, для которых выполено условие перехода

        while (CurrentTransition <= TransitionsCount && transitions.size() > 0) {  // Основной цикл

            Transition choosenTransition = getRandomTransition(transitions);  // Случайным образом выбираем переход

            choosenTransition.DoIn(PetriNet);  // Делаем вход маркеров
            choosenTransition.DoOut(PetriNet);  // Делаем выход маркеров

            if (printStatistics) {  // Выводим статистику, если true
                printStatistics();
            }

            transitions = PetriNet.GetListOfAllowedTransitions();  // Получаем новый список после выполнения перехода
            CurrentTransition += 1;  // Инкрементируем счетчик переходов
        }
    }
    private void SetUpExperiment1() {  // Конфигурация сети для первого эксперимента
        PetriNet = new PetriNet();
        Transition transition1 = new Transition();
        transition1.Number = 1;

        Arc arc1 = new Arc(1, 1);
        transition1.ArcsToIn = new ArrayList<Arc>();
        transition1.ArcsToIn.add(arc1);

        Arc arc2 = new Arc(2, 1);
        transition1.ArcsToOut = new ArrayList<>();
        transition1.ArcsToOut.add(arc2);

        PetriNet.Transitions.add(transition1);


        Position position1 = new Position();
        position1.Name = "P1";
        position1.Number = 1;
        position1.Mark = 100;
        PetriNet.Positions.add(position1);


        Position position2 = new Position();
        position2.Name = "P2";
        position2.Number = 2;
        position2.Mark = 0;
        PetriNet.Positions.add(position2);
    }

    private void SetUpExperiment2() {  // Конфигурация сети для второго эксперимента
        PetriNet = new PetriNet();
        Transition transition1 = new Transition();
        transition1.Number = 1;

        Arc arc1 = new Arc(1, 1);
        transition1.ArcsToIn = new ArrayList<Arc>();
        transition1.ArcsToIn.add(arc1);


        transition1.ArcsToOut = new ArrayList<>();
        Arc arc2 = new Arc(2, 1);
        transition1.ArcsToOut.add(arc2);
        Arc arc3 = new Arc(3, 1);
        transition1.ArcsToOut.add(arc3);

        PetriNet.Transitions.add(transition1);


        Position position1 = new Position();
        position1.Name = "P1";
        position1.Number = 1;
        position1.Mark = 100;
        PetriNet.Positions.add(position1);


        Position position2 = new Position();
        position2.Name = "P2";
        position2.Number = 2;
        position2.Mark = 0;
        PetriNet.Positions.add(position2);

        Position position3 = new Position();
        position3.Name = "P3";
        position3.Number = 3;
        position3.Mark = 0;
        PetriNet.Positions.add(position3);

    }

    private void SetUpExperiment3() {  // Конфигурация сети для третьего эксперимента
        PetriNet = new PetriNet();
        Transition transition1 = new Transition();
        transition1.Number = 1;
        transition1.ArcsToIn = new ArrayList<>();
        transition1.ArcsToOut = new ArrayList<>();

        transition1.ArcsToIn.add(new Arc(1, 1));
        transition1.ArcsToOut.add(new Arc(2, 1));
        PetriNet.Transitions.add(transition1);


        Transition transition2 = new Transition();
        transition2.Number = 2;
        transition2.ArcsToIn = new ArrayList<>();
        transition2.ArcsToOut = new ArrayList<>();

        transition2.ArcsToIn.add(new Arc(1, 1));
        transition2.ArcsToOut.add(new Arc(3, 1));
        PetriNet.Transitions.add(transition2);


        Position position1 = new Position();
        position1.Name = "P1";
        position1.Number = 1;
        position1.Mark = 100;
        PetriNet.Positions.add(position1);

        Position position2 = new Position();
        position2.Name = "P2";
        position2.Number = 2;
        position2.Mark = 0;
        PetriNet.Positions.add(position2);

        Position position3 = new Position();
        position3.Name = "P3";
        position3.Number = 3;
        position3.Mark = 0;
        PetriNet.Positions.add(position3);
    }

    private void SetUpExperiment4(){
        SetUpExperiment1();
    }  // Конфигурация сети для четвертого эксперимента

    private void SetUpExperiment5() {  // Конфигурация сети для пятого эксперимента
        PetriNet = new PetriNet();
        Transition transition1 = new Transition();
        transition1.Number = 1;
        transition1.ArcsToIn = new ArrayList<>();
        transition1.ArcsToOut = new ArrayList<>();

        transition1.ArcsToIn.add(new Arc(1, 1));
        transition1.ArcsToOut.add(new Arc(1, 1));
        transition1.ArcsToOut.add(new Arc(2, 1));
        transition1.ArcsToOut.add(new Arc(3, 1));
        PetriNet.Transitions.add(transition1);


        Transition transition2 = new Transition();
        transition2.Number = 2;
        transition2.ArcsToIn = new ArrayList<>();
        transition2.ArcsToOut = new ArrayList<>();

        transition2.ArcsToIn.add(new Arc(2, 1));
        transition2.ArcsToOut.add(new Arc(4, 3));
        PetriNet.Transitions.add(transition2);


        Transition transition3 = new Transition();
        transition3.Number = 3;
        transition3.ArcsToIn = new ArrayList<>();
        transition3.ArcsToOut = new ArrayList<>();

        transition3.ArcsToIn.add(new Arc(2, 1));
        transition3.ArcsToOut.add(new Arc(5, 1));
        transition3.ArcsToOut.add(new Arc(6, 1));
        PetriNet.Transitions.add(transition3);


        Position position1 = new Position();
        position1.Name = "P1";
        position1.Number = 1;
        position1.Mark = 1;
        PetriNet.Positions.add(position1);

        Position position2 = new Position();
        position2.Name = "P2";
        position2.Number = 2;
        position2.Mark = 0;
        PetriNet.Positions.add(position2);

        Position position3 = new Position();
        position3.Name = "P3";
        position3.Number = 3;
        position3.Mark = 0;
        PetriNet.Positions.add(position3);

        Position position4 = new Position();
        position4.Name = "P4";
        position4.Number = 4;
        position4.Mark = 0;
        PetriNet.Positions.add(position4);

        Position position5 = new Position();
        position5.Name = "P5";
        position5.Number = 5;
        position5.Mark = 0;
        PetriNet.Positions.add(position5);

        Position position6 = new Position();
        position6.Name = "P6";
        position6.Number = 6;
        position6.Mark = 0;
        PetriNet.Positions.add(position6);
    }

    public void printStatistics() {  // Выводит текущее состояние всех позиций и текущее количество выполненых переходов
        for (Position position : PetriNet.Positions)
        {
            System.out.print(position.Name + ": " + position.Mark + " ");
        }

        System.out.println("\nAt transition: " + CurrentTransition);
    }

    public Transition getRandomTransition(List<Transition> list) {  // Возвращает случайный переход из списка переходов
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
}