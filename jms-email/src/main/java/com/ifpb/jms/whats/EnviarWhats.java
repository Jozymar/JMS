package com.ifpb.jms.whats;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSProducer;
import javax.jms.Topic;

@JMSDestinationDefinition(name = "java:global/jms/Topic",
        interfaceName = "javax.jms.Topic",
        resourceAdapter = "jmsra",
        destinationName = "topic")
@Stateless
public class EnviarWhats {
    
    @Resource(lookup = "java:global/jms/Topic")
    private Topic topic;
    
    @Inject
    private JMSContext context;
    
    public void enviar(String categoria, String whats) {
        JMSProducer createProducer = context.createProducer();
        String enviar = whats;
        createProducer.setProperty("categoria", categoria).send(topic, enviar);
        Logger.getGlobal().log(Level.INFO, "Whats enviado:{0}", enviar);
    }
    
}
