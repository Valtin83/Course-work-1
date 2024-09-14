public class Main {
    private static Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        employees[0] = new Employee("Иванов Иван Иванович", 1, 50000);
        employees[1] = new Employee("Петров Петр Петрович", 2, 60000);
        employees[2] = new Employee("Сидоров Сидор Сидорович", 3, 55000);
        employees[3] = new Employee("Кузнецов Николай Владимирович", 4, 70000);
        employees[4] = new Employee("Семенов Семен Семенович", 5, 48000);

        // Вызовы методов
        printAllEmployees(employees);
        System.out.println("Сумма затрат на ЗП в месяц: " +
                calculateTotalSalary(employees));
        System.out.println("Сотрудник с минимальной ЗП: " +
                findEmployeeWithMinSalary(employees));
        System.out.println("Сотрудник с максимальной ЗП: " +
                findEmployeeWithMaxSalary(employees));
        System.out.println("Средняя ЗП: " + calculateAverageSalary(employees));
        printFullNames(employees);
    }

    // Список всех сотрудников со всеми имеющимися по ним данными
    public static void printAllEmployees(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    // Общая сумма затрат на зарплату сотрудников
    public static double calculateTotalSalary(Employee[] employees) {
        double total = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                total += employee.getSalary();
            }
        }
        return total;
    }

    // Сотрудник с минимальной зарплатой
    public static Employee findEmployeeWithMinSalary(Employee[] employees) {
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

    // Сотрудник с максимальной зарплатой
    public static Employee findEmployeeWithMaxSalary(Employee[] employees) {
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

    // Среднее значение зарплат
    public static double calculateAverageSalary(Employee[] employees) {
        double totalSalary = calculateTotalSalary(employees);
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                count++;
            }
        }
        if (count != 0) return totalSalary / count;
        return 0;
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
