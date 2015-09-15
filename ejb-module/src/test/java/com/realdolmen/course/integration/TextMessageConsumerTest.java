package com.realdolmen.course.integration;

import com.realdolmen.course.domain.Ticket;
import org.junit.Test;

public class TextMessageConsumerTest extends RemoteJmsTest {
    @Test
    public void produceTextMessage() throws Exception {
        producer.send(session.createTextMessage("1000,10\n30"));
    }
}
