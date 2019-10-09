package com.smith.micro.notes.notes.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Data
@Builder
@Entity
public class Note {

    @Id
    @Column(name = "NOTE_ID", unique = true, nullable = false)
    private Long noteId;

    @Column(name="NOTE")
    private String note;

    @Column(name="NOTE_NAME")
    private String Name;

    @Column(name="LAST_UPDATED")
    private ZonedDateTime lastUpdated;

    @Column(name="CREATED")
    private ZonedDateTime created;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = false)
    private UserProfile userProfile;
}
