public class EmployeeBook {
    public static Employee[] employees = new Employee[10];

    public EmployeeBook() {
        employees[0] = new Employee("Иванов Иван Иванович", 1, 50000);
        employees[1] = new Employee("Петров Петр Петрович", 2, 60000);
        employees[2] = new Employee("Сидоров Сидор Сидорович", 3, 55000);
        employees[3] = new Employee("Кузнецов Николай Владимирович", 4, 70000);
        employees[4] = new Employee("Семенов Семен Семенович", 5, 48000);
    }

    private int count = 0; //

    // Добавление нового сотрудника
    public void addEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) { // Если ячейка пуста
                employees[i] = employee; // Добавляем сотрудника
                count++;
                return; // Возвращаем true, если добавление успешно
            }
        }
    }

    // Удаление сотрудника по ID
    public void removeEmployee(int ID) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getId() == ID) {
                employees[i] = null; // Удаляем сотрудника
                reorderArray(); // Пересчитываем массив
                count--;
                return;
            }
        }
    }


    public void reorderArray() {
        for (int i = 0; i < employees.length - 1; i++) {
            if (employees[i] == null && employees[i + 1] != null) {
                employees[i] = employees[i + 1];
                employees[i + 1] = null;
            }
        }
    }

    // Получение сотрудника по ID
    public Employee getEmployeeById(int ID) {
        for (Employee employee : employees) {
            if (employee != null && employee.getId() == ID) {
                return employee;
            }
        }
        return null; // Сотрудник не найден
    }

    // Получение всех сотрудников
    public void printAllEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    // Подсчет общей зарплаты
    public double calculateTotalSalary() {
        double total = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                total += employee.getSalary();
            }
        }
        return total;
    }

    // Поиск сотрудника с минимальной зарплатой
    public Employee findEmployeeWithMinSalary() {
        Employee minEmployee = null;
        for (Employee employee : employees) {
            if (employee != null) {
                if (minEmployee == null || employee.getSalary() < minEmployee.getSalary()) {
                    minEmployee = employee;
                }
            }
        }
        return minEmployee;
    }

    // Поиск сотрудника с максимальной зарплатой
    public Employee findEmployeeWithMaxSalary() {
        Employee maxEmployee = null;
        for (Employee employee : employees) {
            if (employee != null) {
                if (maxEmployee == null || employee.getSalary() > maxEmployee.getSalary()) {
                    maxEmployee = employee;
                }
            }
        }
        return maxEmployee;
    }

    // Подсчет среднего значения зарплат
    public double calculateAverageSalary() {
        double totalSalary = calculateTotalSalary();
        int countValidEmployees = 0;

        for (Employee employee : employees) {
            if (employee != null) {
                countValidEmployees++;
            }
        }
        if (countValidEmployees == 0) return 0;
        return totalSalary / countValidEmployees;
    }

    // Распечатать ФИО всех сотрудников
    public static void printFullNames(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
    }
}
