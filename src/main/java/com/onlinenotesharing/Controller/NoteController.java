package com.onlinenotesharing.Controller;


import com.onlinenotesharing.entity.*;
import com.onlinenotesharing.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    // Handler for GET requests to the root URL ("/")
    @GetMapping("/")
    public String index(Model model) {
        // Retrieve all notes from the database
        List<Note> notes = noteRepository.findAll();
        // Add the list of notes to the model
        model.addAttribute("notes", notes);
        return "index"; // Return the name of the HTML template to render
    }

    // Handler for POST requests to add a new note ("/add")
    @PostMapping("/add")
    public String add(Note note) {
        // Save the new note to the database
        noteRepository.save(note);
        // Redirect to the root URL to display all notes
        return "redirect:/";
    }

    // Handler for GET requests to view all notes ("/view")
    @GetMapping("/view")
    public String viewAll(Model model) {
        // Retrieve all notes from the database
        List<Note> notes = noteRepository.findAll();
        // Add the list of notes to the model
        model.addAttribute("notes", notes);
        return "view"; // Return the name of the HTML template to render
    }
}