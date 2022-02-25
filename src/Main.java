import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        printMenu();
        int userInput = scanner.nextInt();
        while (userInput != 0) {
            switch (userInput) {
                case 1 :
                    System.out.println("Введите номер месяца.(от 1 до 12)");
                    int month = scanner.nextInt() - 1;
                    System.out.println("Введите число месяца. (от 1 до 30)");
                    int numberDay = scanner.nextInt() - 1; // аналогично
                    System.out.println("Введите количество шагов");
                    int numberSteps = scanner.nextInt();
                    stepTracker.saveSteps(month, numberDay,numberSteps);
                    break;
                case 2 :
                    System.out.println("Введите номер месяца.(от 1 до 12)");
                    int monthStat = scanner.nextInt() - 1;
                    stepTracker.statistic(monthStat);
                    break;
                case 3 :
                    System.out.println("Введите новое значение целевого количества шагов в месяц");
                    int newPurpose = scanner.nextInt();
                    stepTracker.changePurpose(newPurpose);
                    break;
                default:
                    System.out.println("Такой команды нет!"); //
            }
            printMenu();
            userInput = scanner.nextInt();
        }
        System.out.println("Программа завершена");
    }

    private static void printMenu() {
        System.out.println("1 - Ввести количество шагов за определённый день;");
        System.out.println("2 - Напечатать статистику за определённый месяц;");
        System.out.println("3 - Изменить цель по количеству шагов в день;");
        System.out.println("0 - Выйти из приложения.");
    }
}