package com.ronaldceballos.liststudents.liststudents.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ronaldceballos.liststudents.liststudents.Models.Contact;
import com.ronaldceballos.liststudents.liststudents.Repsositories.ContactRepository;

@Service
public class ContactService {
    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public Contact findContact(Long id) {
        Optional<Contact> optionalContact = contactRepository.findById(id);
        if (optionalContact.isPresent()) {
            return optionalContact.get();
        } else {
            return null;
        }
    }
}
