package com.smith.micro.notes.notes.service;

import com.smith.micro.notes.notes.entity.Note;
import com.smith.micro.notes.notes.entity.UserProfile;
import com.smith.micro.notes.notes.model.DetailNote;
import com.smith.micro.notes.notes.model.User;
import com.smith.micro.notes.notes.repository.NoteRepository;
import com.smith.micro.notes.notes.repository.UserRepository;
import com.smith.micro.notes.notes.repository.UserSessionRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class NotesManager {

    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserSessionRepo userSessionRepo;


    /**
     * This method will get all notes from the given user token
     *
     * @param token
     * @return
     */
    public List<Note> getUserNote(String token){
        log.info("Fetching user from given token : {}", token);
        User user = userSessionRepo.getRedisData(token);
        log.debug("User logon for given token : {} ", user.getUserLogonId());
        UserProfile userProfile = userRepository.findUserByUserLogon(user.getUserLogonId());
        return noteRepository.findNoteByUserId(userProfile.getUserId());
    }


    /**
     * This method will save the note for the given user token
     *
     * @param detailNote
     * @param token
     */
    public void saveNote(DetailNote detailNote, String token){
        log.info("Fetching user from given token : {}", token);
        User user = userSessionRepo.getRedisData(token);
        log.debug("User logon for given token : {} ", user.getUserLogonId());
        UserProfile userProfile = userRepository.findUserByUserLogon(user.getUserLogonId());
        Note note = Note.builder()
                        .userProfile(userProfile)
                        .note(detailNote.getNote())
                        .Name(detailNote.getNoteName())
                        .build();
        noteRepository.save(note);
    }

    /**
     * This method will edit the notes for the given user
     */
    public void editNote(DetailNote detailNote, String token){
        log.info("Fetching user from given token : {}", token);
        User user = userSessionRepo.getRedisData(token);
        log.debug("User logon for given token : {} ", user.getUserLogonId());
        UserProfile userProfile = userRepository.findUserByUserLogon(user.getUserLogonId());
        Note note = Note.builder()
                .userProfile(userProfile)
                .note(detailNote.getNote())
                .Name(detailNote.getNoteName())
                .build();
        noteRepository.save(note);
    }


}
