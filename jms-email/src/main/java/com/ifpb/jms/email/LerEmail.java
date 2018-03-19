package com.ifpb.jms.email;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.TextMessage;

@Stateless
public class LerEmail {

    @Resource(lookup = "java:global/jms/Fila")
    private Queue fila;

    @Inject
    private JMSContext context;

    public String ler() {
        JMSConsumer createConsumer = context.createConsumer(fila);
        TextMessage receive = (TextMessage) createConsumer.receive();
        try {
            return fila.getQueueName() + " - " + receive.getText();
        } catch (JMSException ex) {
            Logger.getLogger(LerEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "sem email";
    }
}
