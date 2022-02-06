package pro.sky.skyprospringdemo.service;

import pro.sky.skyprospringdemo.data.Document;

import javax.print.Doc;

public interface DocumentService {
    Document addDocumentToPerson(Integer id, String passportNum, String inn);
    Document getDocumentByPersonId(Integer id);
}
