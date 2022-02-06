package pro.sky.skyprospringdemo.service;

import pro.sky.skyprospringdemo.data.Person;

public interface PersonService {
    Person getPerson(Integer id);
    String getPersonName(Integer id);
    String getPersonNameWithPinCod(Integer id, int pinCode);
    String updatePerson(String name, Boolean block, Integer id);
    String addPerson(String name, Boolean block);
    String removePerson(Integer id);
}
