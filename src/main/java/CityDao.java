import java.util.List;

public class CityDao {
    void createCity (City city);
    City getCityById(int id);
    List<City> getAllCities();
    void updateCityById(int cityId, EmployeeDao employee);
    void deleteCityById(City city);
}