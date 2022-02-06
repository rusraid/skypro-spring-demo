package pro.sky.skyprospringdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprospringdemo.data.Document;
import pro.sky.skyprospringdemo.service.DocumentService;

@RestController
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

@GetMapping("/get/person/{id}/document")
    public Document getPersonDocument(@PathVariable("id") Integer id) {
        return documentService.getDocumentByPersonId(id);
    }
    @GetMapping("post/person/{id}/document")
    public Document addDocumentToPerson(
            @PathVariable("id") Integer id,
            @RequestParam("passportNum") String passportNum,
            @RequestParam("inn") String inn) {
        return documentService.addDocumentToPerson(id, passportNum, inn);
    }
}
