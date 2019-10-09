package com.smith.micro.notes.notes;

import com.smith.micro.notes.notes.entity.UserProfile;
import com.smith.micro.notes.notes.repository.NoteRepository;
import com.smith.micro.notes.notes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotesApplication.class, args);
	}

}
