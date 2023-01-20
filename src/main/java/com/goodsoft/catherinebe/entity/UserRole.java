package com.goodsoft.catherinebe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRole {
    private Long userId;
    private Long roleId;
}
