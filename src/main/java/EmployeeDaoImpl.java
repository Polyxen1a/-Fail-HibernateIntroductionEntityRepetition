import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;


public class EmployeeDaoImpl EmployeeDao {
    @Override
    public void createEmployee(EmployeeDao employee) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    @Override
    public EmployeeDao getEmployeeById(int id) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EmployeeDao employee = null;
        entityManager.getTransaction().begin();
        employee = entityManager.find(EmployeeDao.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return employee;
    }
    @Override
    public List<EmployeeDao> getAllEmployees() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        String jpqlQuery = "SELECT e FROM Employee e";
        TypedQuery<EmployeeDao> query = entityManager.createQuery(jpqlQuery, EmployeeDao.class);
        List<EmployeeDao> employeeList =query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return employeeList;
    }
    @Override
    public void updateEmployeeById(EmployeeDao employee) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        EmployeeDao employeeId = entityManager.find(EmployeeDao.class, employee.getId());
        employeeId.setFirstName(employee.getFirstName());
        employeeId.setLastName(employee.getLastName());
        employeeId.setGender(employee.getGender());
        employeeId.setAge(employee.getAge());
        employeeId.setCity(employee.getCity());
        entityManager.merge(employeeId);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
    @Override
    public void deleteEmployeeById(EmployeeDao employee) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        EmployeeDao employee1 = entityManager.find(EmployeeDao.class, employee.getId());
        entityManager.remove(employee1);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}