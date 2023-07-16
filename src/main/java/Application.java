import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
    Employee employee = new Employee() {
        @Override
        public void createEmployee(Employee employee) {

        }

        @Override
        public Employee getEmployeeById(int id) {
            return null;
        }

        @Override
        public List<Employee> getAllEmployees() {
            return null;
        }

        @Override
        public void updateEmployeeById(Employee employee) {

        }

        @Override
        public void deleteEmployeeById(Employee employee) {

        }
    };
    CityDao citydao = new CityDaoImpl();
    Scanner scanner = new Scanner(System.in);
    List<Employee> employees = List.of(new Employee("Надежда", "Крылова", "жен", 30) {
                                           @Override
                                           public void createEmployee(Employee employee) {

                                           }

                                           @Override
                                           public Employee getEmployeeById(int id) {
                                               return null;
                                           }

                                           @Override
                                           public List<Employee> getAllEmployees() {
                                               return null;
                                           }

                                           @Override
                                           public void updateEmployeeById(Employee employee) {

                                           }

                                           @Override
                                           public void deleteEmployeeById(Employee employee) {

                                           }
                                       },
            new Employee("Аркадий", "Семёнович", "муж", 60) {
                @Override
                public void createEmployee(Employee employee) {

                }

                @Override
                public Employee getEmployeeById(int id) {
                    return null;
                }

                @Override
                public List<Employee> getAllEmployees() {
                    return null;
                }

                @Override
                public void updateEmployeeById(Employee employee) {

                }

                @Override
                public void deleteEmployeeById(Employee employee) {

                }
            });
    City city = new City( "Москва", employees);
        citydao.createCity(city);
        System.out.println("Введите id города для изменения в базе");
    int id = scanner.nextInt();
    System.out.println("Какого сотрудника будем изменять? Введите id:");
    int idEmployee = scanner.nextInt();
    Employee employeeCity = employee.getEmployeeById(idEmployee);
    Employee employee1 = enterInformationWithScanner();
        employee1.setId(employeeCity.getId());
        citydao.updateCityById(id, employee1);
        System.out.println("Введите id города для удаления в базе");
    id = scanner.nextInt();
    City city11 = citydao.getCityById(id);
        citydao.deleteCityById(city11);

        System.out.println("Все сотрудники");
    List<Employee> employees1 = employee.getAllEmployees();
        employees1.stream()
                .forEach(System.out::println);
    List<City> cities = citydao.getAllCities();
        cities.stream()
                .forEach(System.out::println);

        HibernateUtil.closeEntityManagerFactory();
}
    public static Employee enterInformationWithScanner(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя");
        String first_name = scanner.nextLine();
        System.out.println("Введите фамилию");
        String last_name = scanner.nextLine();
        System.out.println("Введите пол");
        String gender = scanner.nextLine();
        System.out.println("Введите возраст");
        int age = scanner.nextInt();
        Employee employee = new Employee(first_name, last_name, gender, age) {
            @Override
            public void createEmployee(Employee employee) {

            }

            @Override
            public Employee getEmployeeById(int id) {
                return null;
            }

            @Override
            public List<Employee> getAllEmployees() {
                return null;
            }

            @Override
            public void updateEmployeeById(Employee employee) {

            }

            @Override
            public void deleteEmployeeById(Employee employee) {

            }
        };
        return employee;
    }

    private static class HibernateUtil {
        public static void closeEntityManagerFactory() {
        }
    }
}
