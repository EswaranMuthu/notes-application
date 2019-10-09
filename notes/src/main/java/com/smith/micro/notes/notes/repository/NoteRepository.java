package com.smith.micro.notes.notes.repository;

import com.smith.micro.notes.notes.entity.Note;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NoteRepository extends CrudRepository<Note, Long> {

    List<Note> findNoteByUserId(Long userId);

}
