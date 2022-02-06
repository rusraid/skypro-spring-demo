package pro.sky.skyprospringdemo.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringdemo.data.Person;
import pro.sky.skyprospringdemo.exceptions.NoAccessToPersonException;
import pro.sky.skyprospringdemo.exceptions.WrongPinCodeException;
import pro.sky.skyprospringdemo.service.PersonService;
import pro.sky.skyprospringdemo.service.list.MyList;

import java.util.HashMap;
import java.util.Map;

@Service
public class PersonServiceImpl implements PersonService {

    Map<Integer, Person> persons;

    int pinCode = 1234;

    Integer nextId = 0;

    public PersonServiceImpl() {
        this.persons = new HashMap<>();
//        Это одно и тоже означает:
//        Person olegPerson = new Person("Олег Хлебушек", true);
//        persons.add(olegPerson);
        persons.put(getNextId(), new Person("Олег Хлебушек", true));
        persons.put(getNextId(), new Person("Анна Макаронина", false));
        persons.put(getNextId(), new Person("Булат Баурсак", false));
        persons.put(getNextId(), new Person("Игорь Карамелька", false));
        persons.put(getNextId(), new Person("Пахлава Иванова", true));
    }

    private Integer getNextId() {
        Integer result = nextId;
        nextId = nextId +1;
        return result;
    }

    @Override
    public Person getPerson(Integer id) {
        return persons.get(id);
    }

    @Override
    public String getPersonName(Integer id) {
        if (persons.containsKey(id)) {
            try {
                return getPersonWithoutPinCode(id);
            } catch (NoAccessToPersonException exception) {
                return getNoAccessMessage();
            }
        } else {
            return getNotFoundMessage(id);
        }
    }

    private String getNoAccessMessage() {
        return "Вы не имеете доступ к этому пользователю";
    }

    private String getNotFoundMessage(Integer id) {
        return "Пользователь с id = " + id + " не найден";
    }

    @Override
    public String getPersonNameWithPinCod(Integer id, int pinCode) {
        if (persons.containsKey(id)) {
            if (this.pinCode == pinCode) {
                throw new WrongPinCodeException();
            }
            return persons.get(id).getName();
        } else {
            return getNotFoundMessage(id);
        }
    }

    @Override
    public String updatePerson(String name, Boolean block, Integer id) {
        if (persons.containsKey(id)) {
            Person person = persons.get(id);
            if (!person.isBlock()) {
                person.setName(name);
                person.setBlock(block);
                return name;
            } else {
                return getNoAccessMessage();
            }
        } else {
            return getNotFoundMessage(id);
        }
    }

    @Override
    public String addPerson(String name, Boolean block) {
        persons.put(getNextId(), new Person(name, block));
        return name;
    }

    @Override
    public String removePerson(Integer id) {
        if (persons.containsKey(id)) {
            return persons.remove(id).getName();
        } else {
            return getNotFoundMessage(id);
        }
    }

    private String getPersonWithoutPinCode(Integer id) throws NoAccessToPersonException {
        Person person = persons.get(id);
        if (person.isBlock()) {
            throw new NoAccessToPersonException();
        }
        return person.getName();
    }
}
