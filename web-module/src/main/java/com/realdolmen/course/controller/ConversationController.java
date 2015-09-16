package com.realdolmen.course.controller;

import com.realdolmen.course.domain.Passenger;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by SVCAX33 on 16/09/2015.
 */

@Named
@RequestScoped
public class ConversationController implements Serializable {
    @Inject
    private PassengerController passengerController;

    @Inject Event<String> event;

    @Inject
    private Conversation conversation;

    public String passengerInfoEntry(){
        conversation.begin();
        return "passengerForm";
    }

    public String navigateToTicket(){
        passengerController.addPassenger();
        return "bookTicket";
    }

    public String navigateToConfirm(){
        event.fire("Wizard ended");
        conversation.end();
        return "confirm";
    }



}
