package org.homeapart.controller.request;


import lombok.Data;

@Data
public class ApartChangeRequest extends ApartCreateRequest {
    private Long id;
}
