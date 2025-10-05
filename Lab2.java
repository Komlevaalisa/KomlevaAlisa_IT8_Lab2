class Name {
    private String familia;
    private String im;
    private String otchestvo;

    public Name() {
    }

    public Name(String im) {
        this.im = im;
    }

    public Name(String familia, String im) {
        this.familia = familia;
        this.im = im;
    }

    public Name(String familia, String im, String otchestvo) {
        this.familia = familia;
        this.im = im;
        this.otchestvo = otchestvo;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        if (familia != null) {
            result.append(familia);
        }

        if (im != null) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(im);
        }

        if (otchestvo != null) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(otchestvo);
        }

        return result.toString();
    }
}

class Time {
    private int seconds;

    // Условие 4.4: Конструкторы
    public Time(int seconds) {

        this.seconds = seconds;
    }

    public Time(int hours, int minutes, int seconds) {

        this.seconds = hours * 3600 + minutes * 60 + seconds;
    }

    public int getSeconds() {

        return seconds;
    }

    // Условие 4.5: Новые методы для получения компонентов времени
    public int getCurrentHour() {

        return (seconds % 86400) / 3600;
    }

    public int getMinutesFromHour() {

        return (seconds % 3600) / 60;
    }

    public int getSecondsFromMinute() {

        return seconds % 60;
    }

    // Условие 1.4: Преобразование в текстовый формат
    @Override
    public String toString() {
        int timeInDay = seconds % 86400;  // Оставляем время в пределах суток
        int hours = timeInDay / 3600;
        int minutes = (timeInDay % 3600) / 60;
        int sec = timeInDay % 60;

        return String.format("%d:%02d:%02d", hours, minutes, sec);
    }
}

class Department {
    private String name;
    private Employee boss;
    private Employee[] employees = new Employee[10]; // добавлен массив для 3.4
    private int employeeCount = 0; // добавлен счетчик

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Employee getBoss() {
        return boss;
    }

    public void setBoss(Employee boss) {
        this.boss = boss;
    }

    // Возвращает только реальных сотрудников (без null)(для 3.4)
    public Employee[] getEmployees() {
        Employee[] result = new Employee[employeeCount];
        for (int i = 0; i < employeeCount; i++) {
            result[i] = employees[i];
        }
        return result;
    }
    // Автоматическое добавление в массив при назначении отдела(для 3.4)
    public void addEmployee(Employee employee) {
        if (employeeCount < employees.length) {
            employees[employeeCount] = employee;
            employeeCount++;
        }
    }
}

class Employee {
    private String name;
    private Department department;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
        if (department != null) {
            department.addEmployee(this); // автоматически добавляет сотрудника в список отдела(для 3.4)
        }
    }

    public boolean isBoss() {
        return department != null && department.getBoss() == this;
    }
    // Позволяет получить список всех коллег сотрудника(Для 3.4)
    public Employee[] getColleagues() {
        if (department == null) {
            return new Employee[0]; // пустой массив
        }
        return department.getEmployees();
    }

    @Override
    public String toString() {
        if (department == null) {
            return name;
        }

        if (isBoss()) {
            return name + " начальник отдела " + department.getName();
        } else {
            String bossName = department.getBoss() != null ? department.getBoss().getName() : "не назначен";
            return name + " работает в отделе " + department.getName() + ", начальник которого " + bossName;
        }
    }
}