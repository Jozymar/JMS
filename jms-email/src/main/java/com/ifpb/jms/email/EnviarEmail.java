package com.ifpb.jms.email;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSProducer;
import javax.jms.Queue;

@JMSDestinationDefinition(name = "java:global/jms/Fila", interfaceName = "javax.jms.Queue", resourceAdapter = "jmsra", destinationName = "email")
@Stateless
public class EnviarEmail {

    @Resource(lookup = "java:global/jms/Fila")
    private Queue fila;

    @Inject
    private JMSContext context;

    public void enviar(String email) {
        JMSProducer createProducer = context.createProducer();
        createProducer.send(fila, email);
        System.out.println("email enviado.. " + email);
    }
}
