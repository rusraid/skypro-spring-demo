package pro.sky.skyprospringdemo.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringdemo.data.Document;
import pro.sky.skyprospringdemo.data.Person;
import pro.sky.skyprospringdemo.service.DocumentService;
import pro.sky.skyprospringdemo.service.PersonService;

import java.util.HashMap;
import java.util.Map;

@Service
public class DocumentServiceImpl implements DocumentService {

    private final Map<Person, Document> personDocumentMap;

    private final PersonService personService;

    public DocumentServiceImpl(PersonService personService) {
        this.personService = personService;
        personDocumentMap = new HashMap<>();
    }

    @Override
    public Document addDocumentToPerson(Integer id, String passportNum, String inn) {
        Person person = personService.getPerson(id);
        if (person != null) {
            Document document = new Document();
            document.setPassportNum(passportNum);
            document.setInn(inn);
            return personDocumentMap.put(person, document);
        } else {
            throw new  IllegalArgumentException("Id неверный");
        }
    }

    @Override
    public Document getDocumentByPersonId(Integer id) {
        Person person = personService.getPerson(id);
        if (person != null) {
            return personDocumentMap.get(person);
        } else {
            throw new  IllegalArgumentException("Id неверный");
        }
    }
}
