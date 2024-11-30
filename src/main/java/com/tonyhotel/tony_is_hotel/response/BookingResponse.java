package com.tonyhotel.tony_is_hotel.response;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {
    private Long Id;
    private LocalDate checkInDATE;
    private LocalDate checkOutDate;
    private String guestFullName;
    private  String guestEmail;
    private int NumOfAdults;
    private int NUmOfChildern;
    private int totalNumOfGuest;
    private String bookingConfirmationCode;
    private RoomResponse rooom;

    public BookingResponse(Long id, LocalDate checkInDATE, String bookingConfirmationCode) {
        Id = id;
        this.checkInDATE = checkInDATE;
        this.bookingConfirmationCode = bookingConfirmationCode;
    }
}
