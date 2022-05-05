package webeng.contactlist.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webeng.contactlist.model.Contact;
import webeng.contactlist.service.ContactService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contacts")
public class ContactRestController {

    private final ContactService service;

    public ContactRestController(ContactService service) {
        this.service = service;
    }

    @GetMapping
    public List<Contact> getAll() {
        return service.getAllContacts();
    }

    @GetMapping("{id}")
    public ResponseEntity<Contact> get(@PathVariable int id) {
        return ResponseEntity.of(service.findContact(id));
    }
}
