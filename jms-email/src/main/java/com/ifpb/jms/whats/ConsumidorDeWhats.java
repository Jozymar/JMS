package com.ifpb.jms.whats;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(mappedName = "java:global/jms/Topic",
        activationConfig = {
            @ActivationConfigProperty(propertyName = "destinationType", 
                    propertyValue = "javax.jms.Topic"),
            @ActivationConfigProperty(propertyName = "destinationName",
                    propertyValue = "topic"),
            @ActivationConfigProperty(propertyName = "messageSelector",
                    propertyValue = "categoria='whats'")
        })
public class ConsumidorDeWhats implements MessageListener {

    @Override
    public void onMessage(Message whats) {

        try {
            String body = whats.getBody(String.class);
            Logger.getLogger(ConsumidorDeWhats.class.getName()).log(Level.INFO, "Whats recebido:{0}", body);
                    
        } catch (JMSException ex) {
            Logger.getLogger(ConsumidorDeWhats.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
