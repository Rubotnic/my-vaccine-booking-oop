package se.lexicon.model;

import java.util.Objects;
import java.util.UUID;

public class ContactInformation {

    private String id;
    private String email;
    private String phone;
    private String address;

    public ContactInformation(String id, String email, String phone, String address) {
        this.id = id;
        setEmail(email);
        setPhone(phone);
        this.address = address;
    }

    public ContactInformation(String email, String phone, String address){
        this(UUID.randomUUID().toString(), email, phone, address);
    }

    public ContactInformation(){
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        if(email == null) throw new IllegalArgumentException("Email not allowed to be null!"); // check 1
        this.email = email; //check 2
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if(phone == null) throw new IllegalArgumentException("Phone not allowed to be null!"); // check 1
        this.phone = phone; // check 2
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactInformation that = (ContactInformation) o;
        return Objects.equals(id, that.id) && Objects.equals(email, that.email) && Objects.equals(phone, that.phone) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, phone, address);
    }

    @Override
    public String toString() {
        return "ContactInformation{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
