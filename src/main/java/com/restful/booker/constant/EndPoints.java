package com.restful.booker.constant;

/**
 * Created by Jay Vaghani
 */
public class EndPoints {

    /**
     * This is Endpoints of student api
     */
    public static final String BOOKING = "/booking";

    public static final String GET_BOOKING_BY_ID = Path.BOOKING +"/{bookingId}";
    public static final String UPDATE_BOOKING_BY_ID = Path.BOOKING +"/{bookingId}";
    public static final String DELETE_BOOKING_BY_ID = Path.BOOKING +"/{bookingId}";
}
