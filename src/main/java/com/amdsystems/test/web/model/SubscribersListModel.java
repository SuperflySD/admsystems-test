package com.amdsystems.test.web.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Setter
@NoArgsConstructor
public class SubscribersListModel {


    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;

    @NotNull
    private String UUID;

    @NotNull
    private Long major;

    @NotNull
    private Long minor;

    @NotNull(message = "not null planId")
    @Min(value = 1, message = "plan id can't be less than 1")
    private Integer planId;

}
