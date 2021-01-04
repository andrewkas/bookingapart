package org.homeapart.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class BookingResponce {

    private Long apartId;

    private Long userId;

    private Double price;

    private Date dateFrom;

    private Date dateTo;

}
