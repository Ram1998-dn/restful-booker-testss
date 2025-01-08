package com.restful.booker.cucumber.steps;

import com.restful.booker.bookeinfo.BookerSteps;
import com.restful.booker.utils.TestUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Steps;

import static org.hamcrest.Matchers.equalTo;

public class BookingStepsDef {
    static int bookingId;

    ValidatableResponse response;

    static String firstName = null;

    @Steps
    BookerSteps bookerSteps;


    @Given("I am on Home Page")
    public void iAmOnHomePage() {

    }

    @When("I create a new booking with firstname {string} lastname {string} totalprice {string} depositpaid {string} checkin {string} checkout {string} additionalNeeds {string}")
    public void iCreateANewBookingWithFirstnameLastnameTotalpriceDepositpaidCheckinCheckoutAdditionalNeeds
            (String _firstname, String lastName, String totalPrice, String depositPaid, String checkin, String checkout, String additionalNeeds) {
        firstName = _firstname + TestUtils.getRandomValue();

        ValidatableResponse response = bookerSteps.createBooking(firstName, lastName, Integer.parseInt(totalPrice), Boolean.parseBoolean(depositPaid), checkin, checkout, additionalNeeds);

        response.log().ifValidationFails().statusCode(200);

        bookingId = response.extract().path("bookingid");
        System.out.println("Booking id is : " + bookingId);
    }

    @Then("I verify that the booking with firstname {string} is created successfully")
    public void iVerifyThatTheBookingWithFirstnameIsCreatedSuccessfully(String _firstname) {
        ValidatableResponse response = bookerSteps.getBookingInfoById(bookingId);
        response.statusCode(200);
        System.out.println("firstName is: " + response.extract().path("firstname"));

        response.body("firstname", equalTo(firstName));
    }

    @And("I update the booking with firstname {string} lastname {string} totalprice {string} depositpaid {string} checkin {string} checkout {string}, additionalNeeds {string}")
    public void iUpdateTheBookingWithFirstnameToNewFirstnameLastnameTotalpriceDepositpaidCheckinCheckoutAdditionalNeeds
            (String _firstname, String lastName, String totalPrice, String depositPaid, String checkin, String checkout, String additionalNeeds) {

        firstName = _firstname + "Updated" + TestUtils.getRandomValue();
        String bcheckin = "2025-01-08";
        String bcheckout = "2025-01-09";

        response = bookerSteps.updateBookingInfoById(bookingId, firstName, lastName, Integer.parseInt(totalPrice), Boolean.parseBoolean(depositPaid), bcheckin, bcheckout, additionalNeeds);
        response.statusCode(200);
        System.out.println("firstName is : " + response.extract().path("firstname"));
        System.out.println("checkin date is :" + response.extract().path("bookingdates.checkin"));


    }

    @Then("I verify that the booking with firstname {string} is updated successfully")
    public void iVerifyThatTheBookingWithFirstnameIsUpdatedSuccessfully(String _firstname) {
        response.body("firstname", equalTo(firstName));
    }

    @And("I delete the booking with firstname {string}")
    public void iDeleteTheBookingWithFirstname(String _firstname) {
        bookerSteps.deleteBooking(bookingId).statusCode(201);
    }

    @Then("The booking is deleted successfully from the API")
    public void theBookingIsDeletedSuccessfullyFromTheAPI() {
        bookerSteps.getBookingInfoById(bookingId).statusCode(404);
    }
}
