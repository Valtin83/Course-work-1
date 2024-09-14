import java.util.Objects;

public class Employee {
    private static int idCounter = 1; // Статическая переменная-счетчик
    private final int ID;

    private final String FULL_NAME;  // Поле ФИО
    private int department;   // Поле отдел
    private double salary;    // Поле зарплата


    // Конструктор
    public Employee(String FULL_NAME, int department, double salary) {
        ID = idCounter++; //Присвоение ID из счетчика и увеличение счетчика
        this.FULL_NAME = FULL_NAME;
        this.department = department;
        this.salary = salary;
    }

    // Геттеры
    public int  getID() {
        return ID;
    }
    public String getFullName() {
        return this.FULL_NAME;
    }

    public int getDepartment() {
        return this.department;
    }

    public double getSalary() {
        return this.salary;
    }

    // Сеттеры
    public void setDepartment(int department) {
        if (department > 0 && department <= 5) {
            this.department = department;
        } else {
            throw new IllegalArgumentException("Отдел должен быть от 1 до 5.");
        }
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException("Зарплата не может быть отрицательной.");
        }
    }

    // Переопределение equals и hashCode
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return department == employee.department && Double.compare(salary, employee.salary) == 0 && ID == employee.ID && Objects.equals(FULL_NAME, employee.FULL_NAME);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FULL_NAME, department, salary, ID);
    }

    //  Метод toString
    @Override
    public String toString() {
        return "Сотрудник {" + "id=" + ID + ". Ф.И.О.: '" + FULL_NAME + '\'' +
                ", отдел = " + department + ", зарплата = " + salary + " руб.}";
    }
}
