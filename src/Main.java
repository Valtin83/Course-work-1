public class Main {
    public static void main(String[] args) {

        EmployeeBook employeeBook = new EmployeeBook();

        // Добавляем сотрудников
        employeeBook.addEmployee(new Employee("Иванков Иван Иванович", 1, 50000));
        employeeBook.addEmployee(new Employee("Петрова Анна Сергеевна", 2, 60000));
        employeeBook.addEmployee(new Employee("Сидорков Алексей Викторович", 3, 55000));

        // Выводим всех сотрудников
        System.out.println("Сотрудники:");
        employeeBook.printAllEmployees();

        // Подсчет общей суммы зарплат
        System.out.println("Общая зарплата: " + employeeBook.calculateTotalSalary());

        // Поиск сотрудника с минимальной зарплатой
        Employee minSalaryEmployee = employeeBook.findEmployeeWithMinSalary();
        System.out.println("Сотрудник с минимальной зарплатой: " + minSalaryEmployee);

        // Поиск сотрудника с максимальной зарплатой
        Employee maxSalaryEmployee = employeeBook.findEmployeeWithMaxSalary();
        System.out.println("Сотрудник с максимальной зарплатой: " + maxSalaryEmployee);

        // Подсчет среднего значения зарплат
        System.out.println("Средняя зарплата: " + employeeBook.calculateAverageSalary());

        // Получение сотрудника по ID
        Employee employeeById = employeeBook.getEmployeeById(6);
        System.out.println("Сотрудник с " + employeeById);

        // Попробуем удалить сотрудника
        employeeBook.removeEmployee(3);

        // Распечатать ФИО всех сотрудников
        System.out.println("ФИО всех сотрудников:");
        EmployeeBook.printFullNames(EmployeeBook.employees);


    }

}

