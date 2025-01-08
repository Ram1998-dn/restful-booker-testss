package com.restful.booker.bookeinfo;

import com.restful.booker.constant.Path;
import com.restful.booker.model.AuthPojo;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;


public class AuthSteps {

    @Step
    public String generateToken(String username, String password){
        AuthPojo authPojo = AuthPojo.getAuthPojo(username, password);
        return SerenityRest.given().log().all()
                .when()
                .header("Content-Type", "application/json")
                .body(authPojo)
                .post(Path.AUTH)
                .then().log().all().extract().path("token");
    }
}
