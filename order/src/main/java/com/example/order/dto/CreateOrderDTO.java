package com.example.order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderDTO {

    private Long id;
    private Long userId;
    private Long productId;
    private Date createTime;
    private Date updateTime;

}
