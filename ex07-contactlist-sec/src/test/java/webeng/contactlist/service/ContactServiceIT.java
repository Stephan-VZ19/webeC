package webeng.contactlist.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import webeng.contactlist.SampleContactsAdder;
import webeng.contactlist.model.ContactListEntry;
import webeng.contactlist.model.ContactRepository;

import java.io.IOException;
import java.util.Set;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.IntStream.rangeClosed;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class ContactServiceIT {

    ContactService service;

    ContactServiceIT(@Autowired ContactRepository repo) throws IOException {
        var mapper = new ObjectMapper().configure(FAIL_ON_UNKNOWN_PROPERTIES, false);
        service = new ContactService(repo);
        new SampleContactsAdder(mapper, service).onApplicationEvent(null);
    }

    @Test
    void contactListCount() {
        var contactList = service.getContactList(null);
        assertNotNull(contactList);
        assertEquals(30, contactList.size());
    }

    @Test
    void contactListName() {
        var contactList = service.getContactList(null);
        assertNotNull(contactList);
        assertFalse(contactList.isEmpty());
        assertEquals("Mabel Guppy", contactList.get(0).getName());
    }

    @Test
    void search() {
        var results = service.getContactList("Engineer");
        assertEquals(Set.of("Graeme Impett", "Chilton Treversh"),
                results.stream().map(ContactListEntry::getName).collect(toSet()));
    }

    @Test
    void searchIgnoresCase() {
        var results = service.getContactList("mO");
        assertEquals(Set.of("Moll Mullarkey", "Seana Burberye"), // one in name, one in email
                results.stream().map(ContactListEntry::getName).collect(toSet()));
    }
}

