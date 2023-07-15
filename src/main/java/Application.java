import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class Application {
    EmployeeDao employee = new EmployeeDao();
    CityDao citydao = new CityDaoImpl();
    Scanner scanner = new Scanner(System.in);
    List<EmployeeDao> employees = List.of(new EmployeeDao("Надежда", "Крылова", "жен", 30),
            new EmployeeDao("Аркадий", "Семёнович", "муж", 60));
    City city = new City( "Москва", employees);
        citydao.createCity(city);
        System.out.println("Введите id города для изменения в базе");
    int id = scanner.nextInt();
    System.out.println("Какого сотрудника будем изменять? Введите id:");
    int idEmployee = scanner.nextInt();
    EmployeeDao employeeCity = employeeDao.getEmployeeById(idEmpl);
    EmployeeDao employee1 = enterInformationWithScanner();
        employee1.setId(employeeCity.getId());
        cityDao.updateCityById(id, employee1);
        System.out.println("Введите id города для удаления в базе");
    id = scanner.nextInt();
    City city11 = cityDAO.getCityById(id);
        cityDAO.deleteCityById(city11);

        System.out.println("Все сотрудники");
    List<EmployeeDao> employees1 = employeedao.getAllEmployees();
        employees1.stream()
                .forEach(System.out::println);
    List<City> cities = cityDao.getAllCities();
        cities.stream()
                .forEach(System.out::println);

        HibernateUtil.closeEntityManagerFactory();
}
    public static EmployeeDao enterInformationWithScanner(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя");
        String first_name = scanner.nextLine();
        System.out.println("Введите фамилию");
        String last_name = scanner.nextLine();
        System.out.println("Введите пол");
        String gender = scanner.nextLine();
        System.out.println("Введите возраст");
        int age = scanner.nextInt();
        EmployeeDao employee = new EmployeeDao(first_name, last_name, gender,age);
        return employee;
    }
}
