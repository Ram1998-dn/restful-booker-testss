package com.restful.booker.bookerinfo;

import com.restful.booker.bookeinfo.BookerSteps;
import com.restful.booker.testbase.TestBase;
import com.restful.booker.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.equalTo;


@RunWith(SerenityRunner.class)
public class BookerCRUDTest extends TestBase {
    static int bookingId;

    static String firstName = "TestName" + TestUtils.getRandomValue();
    static String lastName = "TesLastNamet" + TestUtils.getRandomValue();
    static int totalPrice = 890;
    static boolean depositPaid = true;
    static String checkin = "2025-02-04";
    static String checkout = "2025-02-05";
    static String additionalNeeds = "Dinner";

    @Steps
    BookerSteps bookerSteps;

    @Title("This method will create a new Booking")
    @Test
    public void test001() {

        ValidatableResponse response = bookerSteps.createBooking(firstName, lastName, totalPrice, depositPaid, checkin, checkout, additionalNeeds);

        response.log().ifValidationFails().statusCode(200);

        bookingId = response.extract().path("bookingid");
        System.out.println("Booking id is : "+bookingId);
    }

    @Title("Get booking details by id was added successfully")
    @Test
    public void test002() {
        ValidatableResponse response = bookerSteps.getBookingInfoById(bookingId);
        response.statusCode(200);
        System.out.println("firstName is: " + response.extract().path("firstname"));

        response.body("firstname", equalTo(firstName));
    }

    @Title("Update booking info and verify updated details")
    @Test
    public void test003() {
        firstName = firstName + "Updated" + TestUtils.getRandomValue();
        String checkIn = "2025-03-30";
        String checkOut = "2025-04-28";

        ValidatableResponse response = bookerSteps.updateBookingInfoById(bookingId, firstName, lastName, totalPrice, depositPaid, checkIn, checkOut, additionalNeeds);
        response.statusCode(200);
        System.out.println("firstName is : " + response.extract().path("firstname"));
        System.out.println("checkin date is :" + response.extract().path("bookingdates.checkin"));

        response.body("firstname", equalTo(firstName));
    }

    @Title("Delete booking and verify if booking is deleted")
    @Test
    public void test004() {
        bookerSteps.deleteBooking(bookingId).statusCode(201);
        bookerSteps.getBookingInfoById(bookingId).statusCode(404);
    }



}




