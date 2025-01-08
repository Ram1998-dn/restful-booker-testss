package com.restful.booker.bookerinfo;

import com.restful.booker.bookeinfo.AuthSteps;
import com.restful.booker.constant.EndPoints;
import com.restful.booker.model.AuthPojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(SerenityRunner.class)
public class CreateToken extends TestBase {

    private static String token;

    @Steps
    AuthSteps steps;



    @Test
    public void createToken(){
        AuthPojo authPojo = AuthPojo.getAuthPojo("admin", "password123");
        Response response = SerenityRest.given().log().all()
                .when()
                .header("Content-Type", "application/json")
                .body(authPojo)
                .post(EndPoints.AUTH);
        response.then().log().all().statusCode(200);
        token = response.jsonPath().getString("token");
    }



    @Test
    public void test001(){
        String token = steps.generateToken("admin", "password123");
        System.out.println(token);
    }
}
