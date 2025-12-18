package com.example.journalApp.controller;


import com.example.journalApp.entitiy.journalentry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {



    private Map<Long, journalentry> journalentries  = new HashMap<>();



    @GetMapping
    public List<journalentry> getAll() {
        return new ArrayList<>(journalentries.values());
    }

    @PostMapping
    public  boolean addJournalEntry(@RequestBody journalentry myEntry) {
        journalentries.put(myEntry.getId(), myEntry);
        return true;
    }
    @GetMapping("")
    public journalentry getJournalEntry(@RequestParam long id) {
        return journalentries.get(id);

    }
    @DeleteMapping("id/{myId}")
    public boolean deleteJournalEntry(@RequestParam long id) {
        journalentries.remove(id);
        return false;
    }
      @PutMapping
    public journalentry updateJournalEntry(@RequestBody journalentry myEntry) {
        journalentries.put(myEntry.getId(), myEntry);
        return journalentries.get(myEntry.getId());
    }

}

/*
Controllers are special type of components which handle the HTTP request
@RestController is annotation used to initialize Controller
 */
