import java.util.HashMap;

public class StepTracker {

    static HashMap<Integer, MonthData> monthToData = new HashMap<>();
    int purpose;

    public StepTracker() {
        purpose = 10000;
        for (int i = 0; i < 12; i++) {
            monthToData.put(i, new MonthData());
        }
    }

    static class MonthData {
        int[] massiv;
        MonthData(){
            massiv = new int[30];
        }
        void addData(int number, int numberSt){
            massiv[number] = numberSt;
        }
    }

    void saveSteps(int month, int numberDay, int numberSteps) {
        if(monthToData.containsKey(month)){
            if ((numberDay >= 0) && (numberDay < 30)) {
                MonthData data = monthToData.get(month);
                data.addData(numberDay,numberSteps);
                System.out.println((numberDay + 1) + " числа " + (month + 1) + " месяца, добавлено " + numberSteps + " шагов!");
                System.out.println(data.massiv[numberDay]);
            }
            else {
                System.out.println("введено некорректное значение дня");
            }
        }
        else {
            System.out.println("введено некорректное значение месяца");
        }
    }

    void statistic(int monthStat){
        int sum = 0;
        int max = 0;
        int series = 0;
        int bestSeries = 0;
        Converter converter = new Converter();
        for (int i = 0; i < monthToData.get(monthStat).massiv.length; i++) {
            sum += monthToData.get(monthStat).massiv[i]; //сумма
            System.out.println((i+1) + " день: " + monthToData.get(monthStat).massiv[i] + ", "); // список
            if (monthToData.get(monthStat).massiv[i] > max) {
                max = monthToData.get(monthStat).massiv[i];
            } //максимальное количество шагов за месяц
            if(monthToData.get(monthStat).massiv[i] >= purpose){
                series++;
            } else {
                series = 0;
            }// логика лучшей серии
            if(series > bestSeries){
                bestSeries = series;
            }
        }
        System.out.println("Максимальное пройденное количество шагов в месяце: " + max);
        System.out.println("общее количество шагов за месяц: " + sum);
        if(sum != 0) {
            System.out.println("среднее количество шагов за месяц: " + (sum/30));
        } else {
            System.out.println("среднее количество шагов за месяц: 0");
        }
        System.out.println("Пройденная дистанция (в км): " + converter.getDistance(sum)); //Пройденная дистанция (в км)
        System.out.println("Количество сожжённых килокалорий: " + converter.getKallories(sum));//Количество сожжённых килокалорий
        System.out.println("Лучшая серия: " + (bestSeries));
    }
     public void changePurpose(int newPurpose) {
        if (newPurpose >=0) {
            purpose = newPurpose;
            System.out.println("Новое значение " + purpose + " сохранено");
        } else {
            System.out.println("Значение не может быть отрицательным.");
            System.out.println("Текущее целевое значение: " + purpose);
        }
    }
}