package com.realdolmen.course.consumer;


import com.realdolmen.course.domain.Ticket;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:jboss/exported/jms/queue/MyQueue"),
})
public class TextMessageConsumer implements MessageListener {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void onMessage(Message message) {
        try {
            TextMessage textMessage = (TextMessage) message;
            String[] messages = textMessage.getText().split("\n");

            for (String oneMessage : messages) {
                String[] splittedMessage = oneMessage.split(",");
                if (splittedMessage.length == 1) {
                    Ticket ticket = new Ticket(Integer.parseInt(splittedMessage[0]));
                    em.persist(ticket);
                }
                if (splittedMessage.length == 2) {
                    Ticket ticket = em.find(Ticket.class, Integer.parseInt(splittedMessage[0]));
                    ticket.setPrice(Integer.parseInt(splittedMessage[1]));
                    em.persist(ticket);
                }
            }

        } catch (JMSException e) {
            throw new RuntimeException("Deal with this", e);
        }
    }
}
