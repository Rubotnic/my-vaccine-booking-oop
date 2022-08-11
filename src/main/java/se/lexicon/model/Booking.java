package se.lexicon.model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Booking {

    private String id;
    private LocalDate dateTime; // top prio, not null = when
    private double price;
    private String administrator;
    private String vaccineType;
    private boolean vacant;
    private Premises premises; // top prio, not null = where
    private Patient patient;


    public Booking(String id, LocalDate dateTime, double price, String administrator, String vaccineType, boolean vacant, Premises premises, Patient patient) {
        this.id = id;
        setDateTime(dateTime); // Don't write same code twice. Use setter.
        this.price = price;
        this.administrator = administrator;
        this.vaccineType = vaccineType;
        this.vacant = vacant;
        setPremises(premises); // Don't write same code twice. Use setter.
        this.patient = patient;
    }

    public Booking(LocalDate dateTime, double price, String administrator, String vaccineType, Premises premises) {

        this(UUID.randomUUID().toString(), dateTime, price, administrator, vaccineType, true, premises, null);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDate dateTime) {

        if(dateTime == null) throw new IllegalArgumentException("DateTime n ot allowed to be null!"); // check 1

        this.dateTime = dateTime;// check 2
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAdministrator() {
        return administrator;
    }

    public void setAdministrator(String administrator) {
        this.administrator = administrator;
    }

    public String getVaccineType() {
        return vaccineType;
    }

    public void setVaccineType(String vaccineType) {
        this.vaccineType = vaccineType;
    }

    public boolean isVacant() {
        return vacant;
    }

    public void setVacant(boolean vacant) {
        this.vacant = vacant;
    }

    public Premises getPremises() {
        return premises;
    }

    public void setPremises(Premises premises) {

        if(premises == null) throw new IllegalArgumentException("Premises not allowed to be null!"); // check 1

        this.premises = premises; // check 2
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Double.compare(booking.price, price) == 0 && vacant == booking.vacant && Objects.equals(id, booking.id) && Objects.equals(dateTime, booking.dateTime) && Objects.equals(administrator, booking.administrator) && Objects.equals(vaccineType, booking.vaccineType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateTime, price, administrator, vaccineType, vacant);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id='" + id + '\'' +
                ", dateTime=" + dateTime +
                ", price=" + price +
                ", administrator='" + administrator + '\'' +
                ", vaccineType='" + vaccineType + '\'' +
                ", vacant=" + vacant +
                ", premises=" + premises +
                ", patient=" + patient +
                '}';
    }
}
