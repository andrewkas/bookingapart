package org.homeapart.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.homeapart.domain.Apart;
import org.homeapart.domain.User;

import java.util.Date;

@Data
@AllArgsConstructor
public class BookingResponce {

    private Apart apart;

    private User user;

    private Double price;

    private Date dateFrom;

    private Date dateTo;

}
