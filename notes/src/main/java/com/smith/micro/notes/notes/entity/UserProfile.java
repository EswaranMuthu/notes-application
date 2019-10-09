package com.smith.micro.notes.notes.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Builder
public class UserProfile {

    @Id
    @Column(name = "USER_ID", unique = true, nullable = false)
    private Long userId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "LOGON_ID")
    private String logonId;

}
