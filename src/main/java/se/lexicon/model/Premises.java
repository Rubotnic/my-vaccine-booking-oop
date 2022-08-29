package se.lexicon.model;

import java.util.Objects;
import java.util.UUID;

public class Premises {

    private String id;
    private String name;
    private ContactInformation contactInformation;

    public Premises(String id, String name, ContactInformation contactInformation) {
        this.id = id;
        setName(name);
        setContactInformation(contactInformation);
    }

    public Premises(String name, ContactInformation contactInformation) {
        this(UUID.randomUUID().toString(), name, contactInformation);
    }

    public Premises() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        if(name == null) throw new IllegalArgumentException("Name not allowed to be null!"); // check 1
        this.name = name;// check 2
    }

    public ContactInformation getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(ContactInformation contactInformation) {
        if(contactInformation == null) throw new IllegalArgumentException("Contactinformation not allowed to bu null");
        this.contactInformation = contactInformation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Premises premises = (Premises) o;
        return Objects.equals(id, premises.id) && Objects.equals(name, premises.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Premises{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", contactInformation=" + contactInformation +
                '}';
    }
}
