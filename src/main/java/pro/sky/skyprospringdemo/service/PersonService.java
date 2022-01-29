package pro.sky.skyprospringdemo.service;

public interface PersonService {
    String getPerson(Integer id);
    String getPersonWithPinCod(Integer id, int pinCode);
    String updatePerson(String name, Boolean block, Integer id);
    String addPerson(String name, Boolean block);
    String removePerson(Integer id);
}
