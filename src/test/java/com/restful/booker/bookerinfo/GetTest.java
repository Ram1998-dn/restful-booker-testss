package com.restful.booker.bookerinfo;

import com.restful.booker.constant.EndPoints;
import com.restful.booker.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(SerenityRunner.class)
public class GetTest extends TestBase {

    @Test
    public void getAllBookings(){
        SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_BOOKING_BY_ID)
                .then().log().all().statusCode(200);
    }
}
