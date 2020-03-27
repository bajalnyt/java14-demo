package com.mohbajal.java14demo;

import com.mohbajal.java14demo.model.EmotionalState;
import com.mohbajal.java14demo.service.PeopleService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
class Runner {

    private final PeopleService peopleService;

    Runner(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void exercise() throws Exception {
        var elizabeth = this.peopleService.create("Elizabeth", EmotionalState.SAD);
        System.out.println(elizabeth);
    }
}

