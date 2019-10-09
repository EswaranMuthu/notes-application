package com.smith.micro.notes.notes.model;

import com.smith.micro.notes.notes.entity.Note;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class DetailNote {
    private String note;
    private String noteName;
}
