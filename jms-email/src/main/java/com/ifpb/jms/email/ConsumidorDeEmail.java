package com.ifpb.jms.email;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(mappedName = "java:global/jms/Fila",
        activationConfig = {
            @ActivationConfigProperty(propertyName = "destinationType",
                    propertyValue = "javax.jms.Queue"),
            @ActivationConfigProperty(propertyName = "destinationName",
                    propertyValue = "queue")
        })
public class ConsumidorDeEmail implements MessageListener {

    @Override
    public void onMessage(Message email) {
        try {
            String body = email.getBody(String.class);
            Logger.getLogger(ConsumidorDeEmail.class.getName())
                    .log(Level.INFO, "Email recebido:{0}", body);
        } catch (JMSException ex) {
            Logger.getLogger(ConsumidorDeEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
