package com.smith.micro.notes.notes.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private String name;
    private String userLogonId;
}
