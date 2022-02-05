package pro.sky.skyprospringdemo.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringdemo.data.Person;
import pro.sky.skyprospringdemo.exceptions.NoAccessToPersonException;
import pro.sky.skyprospringdemo.exceptions.WrongPinCodeException;
import pro.sky.skyprospringdemo.service.PersonService;
import pro.sky.skyprospringdemo.service.list.MyList;

@Service
public class PersonServiceImpl implements PersonService {

    MyList<Person> persons;

    int pinCode = 1234;

    public PersonServiceImpl() {
        this.persons = new MyList<>();
        persons.add(new Person("Олег Хлебушек", true));
//        Это одно и тоже означает:
//        Person olegPerson = new Person("Олег Хлебушек", true);
//        persons.add(olegPerson);
        persons.add(new Person("Анна Макаронина", false));
        persons.add(new Person("Булат Баурсак", false));
        persons.add(new Person("Игорь Карамелька", false));
        persons.add(new Person("Пахлава Иванова", true));
    }

    @Override
    public String getPerson(Integer id) {
        if (persons.size() > id) {
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
    public String getPersonWithPinCod(Integer id, int pinCode) {
        if (this.pinCode == pinCode) {
            return persons.get(id).getName();
        } else {
            throw new WrongPinCodeException();
        }
    }

    @Override
    public String updatePerson(String name, Boolean block, Integer id) {
        if (persons.size() > id) {
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
        persons.add(new Person(name, block));
        return name;
    }

    @Override
    public String removePerson(Integer id) {
        if (persons.size() > id) {
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
