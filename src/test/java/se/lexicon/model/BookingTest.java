package se.lexicon.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BookingTest {

    @Test
    @DisplayName("Setting the dateTime correctly")
    public void setDateTime_successfully(){

        //Arrange
        LocalDate timestamp = LocalDate.now();

        // Act
        Booking testObject = new Booking(timestamp, 0,"Stefan", "Pfizer", new Premises());

        //Assert
        assertEquals(timestamp,testObject.getDateTime());
    }



}