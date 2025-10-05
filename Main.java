public class Main {
    public static void main(String[] args) {
        System.out.println("===Задача 1.3 Работа с именами.===");
        Name name1 = new Name("Клеопатра");
        Name name2 = new Name("Пушкин", "Александр", "Сергеевич");
        Name name3 = new Name("Маяковский", "Владимир");

        System.out.println("1. " + name1);
        System.out.println("2. " + name2);
        System.out.println("3. " + name3);


        System.out.println("\n=== Задача 1.4/4.4/5.4 ===");
        System.out.println("\nУСЛОВИЕ 1.4: Базовое преобразование времени.");
        Time time1 = new Time(10);
        Time time2 = new Time(10000);
        Time time3 = new Time(100000);

        System.out.println("10 секунд: " + time1);
        System.out.println("10000 секунд: " + time2);
        System.out.println("100000 секунд: " + time3);
        Time timeOver24h = new Time(91800); // 25:30:00 => 1:30:00
        System.out.println("91800 секунд (>24ч): " + timeOver24h);

        System.out.println("\nУСЛОВИЕ 4.4: Создание времени разными способами.");
        Time time4 = new Time(10000); // через секунды
        Time time5 = new Time(2, 3, 5); // через часы, минуты, секунды

        System.out.println("10000 секунд: " + time4);
        System.out.println("2 часа, 3 минуты, 5 секунд: " + time5);

        System.out.println("\nУСЛОВИЕ 4.5: Получение компонентов времени.");
        // Задача 1: Сколько часов в 34056 секундах
        Time task1 = new Time(34056);
        System.out.println("1. Время 34056 секунд: " + task1);
        System.out.println("   Сейчас " + task1.getCurrentHour() + " час(ов)");

        // Задача 2: Сколько минут в 4532 секундах
        Time task2 = new Time(4532);
        System.out.println("2. Время 4532 секунд: " + task2);
        System.out.println("   С начала часа прошло " + task2.getMinutesFromHour() + " минут(ы)");

        // Задача 3: Сколько секунд в 123 секундах от начала минуты
        Time task3 = new Time(123);
        System.out.println("3. Время 123 секунд: " + task3);
        System.out.println("   С начала минуты прошло " + task3.getSecondsFromMinute() + " секунд(ы)");

        System.out.println("\n=== Задача 2.4/3.4 Сотрудники и отделы ===\n");
        System.out.println("УСЛОВИЕ 2.4. Текстовое представление всех сотрудников:");
        Employee petrov = new Employee("Петров");
        Employee kozlov = new Employee("Козлов");
        Employee sidorov = new Employee("Сидоров");

        Department itDepartment = new Department("IT");

        petrov.setDepartment(itDepartment);
        kozlov.setDepartment(itDepartment);
        sidorov.setDepartment(itDepartment);

        itDepartment.setBoss(kozlov);

        System.out.println("1. " + petrov);
        System.out.println("2. " + kozlov);
        System.out.println("3. " + sidorov);

        System.out.println("\nУСЛОВИЕ 3.4. Получение списка сотрудников отдела:");
        System.out.println("Список сотрудников отдела IT (через Петрова):");
        Employee[] colleagues = petrov.getColleagues();
        for (int i = 0; i < colleagues.length; i++) {
            System.out.println(" - " + colleagues[i].getName());
        }

        System.out.println("\nСписок сотрудников отдела IT (через Козлова):");
        Employee[] colleagues2 = kozlov.getColleagues();
        for (int i = 0; i < colleagues2.length; i++) {
            System.out.println(" - " + colleagues2[i].getName());
        }
    }
}


