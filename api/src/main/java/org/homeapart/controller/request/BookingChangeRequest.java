package org.homeapart.controller.request;

import lombok.Data;

@Data
public class BookingChangeRequest extends BookingRequest {
    private Long id;
}
