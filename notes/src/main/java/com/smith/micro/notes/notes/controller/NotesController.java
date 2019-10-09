package com.smith.micro.notes.notes.controller;

import com.smith.micro.notes.notes.entity.Note;
import com.smith.micro.notes.notes.model.DetailNote;
import com.smith.micro.notes.notes.service.NotesManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class NotesController {

    @Autowired
    private NotesManager notesManager;

    /**
     * This Endpoint  will get all the notes for given user
     *
     * @param token
     * @return
     */
    @GetMapping("/userNote")
    public ResponseEntity<List<Note>> userNote(@RequestParam String token){
    log.info("user token from request param : {} ", token);

    if(token == null) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    List<Note> notes = notesManager.getUserNote(token);
    return ResponseEntity.ok(notes);
    }

    /**
     * This post endpoint will save the note for the given user
     *
     * @param token
     * @param note
     * @return
     */
    @PostMapping("/userNote")
    public ResponseEntity saveUserNote(@RequestParam String token,
                                               @RequestParam DetailNote note){
        log.info("user token from request param : {} ", token);

        if(token == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        notesManager.saveNote(note, token);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * This post endpoint will save the note for the given user
     *
     * @param token
     * @param note
     * @return
     */
    @PatchMapping("/userNote")
    public ResponseEntity editUserNote(@RequestParam String token,
                                       @RequestParam DetailNote note){
        log.info("user token from request param : {} ", token);
        if(token == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        notesManager.editNote(note, token);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
