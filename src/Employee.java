import java.util.Objects;

public class Employee {
    private static int idCounter = 1; // Статическая переменная-счетчик
    private final int id;

    private final String fullName;  // Поле ФИО
    private int department;   // Поле отдел
    private double salary;    // Поле зарплата


    // Конструктор
    public Employee(String fullName, int department, double salary) {
        id = idCounter++; //Присвоение ID из счетчика и увеличение счетчика
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

    // Геттеры
    public int  getID() {
        return id;
    }
    public String getFullName() {
        return this.fullName;
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
        return department == employee.department && Double.compare(salary,
                employee.salary) == 0 && id == employee.id && Objects.equals(fullName,
                employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, department, salary, id);
    }

    //  Метод toString
    @Override
    public String toString() {
        return "Сотрудник {" + "id=" + id + ". Ф.И.О.: '" + fullName + '\'' +
                ", отдел = " + department + ", зарплата = " + salary + " руб.}";
    }
}
