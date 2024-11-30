package com.tonyhotel.tony_is_hotel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BookedRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long bookingId;
    @Column(name="check_In")
    private LocalDate checkInDATE;
    @Column(name="check_Out")
    private LocalDate checkOutDate;
    @Column(name="Guest_FullName")
    private String guestFullName;
    @Column(name="GuestEmail")
    private  String guestEmail;

    @Column(name="Adults")
    private int NumOfAdults;
    @Column(name="Children")
    private int NUmOfChildern;
    @Column(name="total_num_guest")
    private int totalNumOfGuest;
    @Column(name="booking_conf_code")
    private String bookingConfirmationCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="room_id")
    private Room room;

    public void calculateTotalNumberOfGuest(){
        this.totalNumOfGuest = this.NumOfAdults +  NUmOfChildern;
    }

    public void setNumOfAdults(int numOfAdults) {
        NumOfAdults = numOfAdults;
        calculateTotalNumberOfGuest();

    }

    public void setNUmOfChildern(int NUmOfChildern) {
        this.NUmOfChildern = NUmOfChildern;
        calculateTotalNumberOfGuest();
    }

    public BookedRoom(String bookingConfirmationCode) {
        this.bookingConfirmationCode = bookingConfirmationCode;
    }
}
