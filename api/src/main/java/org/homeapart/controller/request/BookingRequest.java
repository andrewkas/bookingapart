package org.homeapart.controller.request;

import lombok.Data;

import java.util.Date;
import java.util.Locale;
@Data
public class BookingRequest {

    private Long apartId;

    private Long userId;

    private Date dateFrom;

    private Date dateTo;


}
