package com.restful.booker.model;



public class BookerPojo {

    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private BookingDatePojo bookingdates;
    private String additionalneeds;


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public BookingDatePojo getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(BookingDatePojo bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    public static BookerPojo getBookingPojo(String firstname, String lastname, int totalprice, boolean depositpaid, String checkin, String checkout, String additionalneeds) {
        BookingDatePojo bookingDatePojo = new BookingDatePojo();
        bookingDatePojo.setCheckin(checkin);
        bookingDatePojo.setCheckout(checkout);

        BookerPojo bookerPojo = new BookerPojo();
        bookerPojo.setFirstname(firstname);
        bookerPojo.setLastname(lastname);
        bookerPojo.setTotalprice(totalprice);
        bookerPojo.setDepositpaid(depositpaid);
        bookerPojo.setBookingdates(bookingDatePojo);
        bookerPojo.setAdditionalneeds(additionalneeds);

        return bookerPojo;
    }
    }













