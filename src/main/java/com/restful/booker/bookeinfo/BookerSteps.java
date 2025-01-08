package com.restful.booker.bookeinfo;


import com.restful.booker.constant.EndPoints;
import com.restful.booker.constant.Path;
import com.restful.booker.model.BookerPojo;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

public class BookerSteps {

    @Step("Create Booking with firstName : {0}, lastName : {1}, totalPrice :{2}, depositPaid : {3}, checkin : {4}, checkOut :{5}, additionalNeeds :{6}")
    public ValidatableResponse createBooking(String firstName, String lastName, int totalPrice, boolean depositPaid, String checkin, String checkout, String additionalNeeds) {

        BookerPojo bookerPojo = BookerPojo.getBookingPojo(firstName, lastName, totalPrice, depositPaid, checkin, checkout, additionalNeeds);

        return SerenityRest.given().
                header("Content-Type", "application/json")
                .when()
                .body(bookerPojo)
                .post(Path.BOOKING)
                .then();
    }

    @Step("Get booking info by bookingId :{0}")
    public ValidatableResponse getBookingInfoById(int bookingId) {
        return SerenityRest.given()
                .pathParam("bookingId", bookingId)
                .when()
                .get(EndPoints.GET_BOOKING_BY_ID)
                .then();
    }

    @Step("Update booking info with bookingId :{0}, firstName : {1}, lastName : {2}, totalPrice :{3}, depositPaid : {4}, checkin : {5}, checkOut :{6}, additionalNeeds :{7}")
    public ValidatableResponse updateBookingInfoById(int bookingId, String firstName, String lastName, int totalPrice, boolean depositPaid, String checkin, String checkout, String additionalNeeds) {

        BookerPojo bookerPojo = BookerPojo.getBookingPojo(firstName, lastName, totalPrice, depositPaid, checkin, checkout, additionalNeeds);

        return SerenityRest.given()
                .pathParam("bookingId", bookingId)
                .auth().preemptive().basic("admin", "password123")
                .contentType("application/json")
                .accept("application/json")
                .when()
                .body(bookerPojo)
                .put(EndPoints.UPDATE_BOOKING_BY_ID)
                .then();
    }

    @Step("Delete booking info by bookingId :{0}")
    public ValidatableResponse deleteBooking(int bookingId) {
        return SerenityRest.given()
                .pathParam("bookingId", bookingId)
                .auth().preemptive().basic("admin", "password123")
                .header("Content-Type", "application/json")
                .when()
                .delete(EndPoints.DELETE_BOOKING_BY_ID)
                .then();
    }


}


