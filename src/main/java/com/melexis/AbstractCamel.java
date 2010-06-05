package com.melexis;

import com.melexis.rss.RssSplitter;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.util.jndi.JndiContext;

import javax.jms.ConnectionFactory;

/**
 * Created by IntelliJ IDEA.
 * User: brecht
 * Date: 5-jun-2010
 * Time: 13:02:56
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractCamel {

    protected CamelContext context;

    protected AbstractCamel(final RouteBuilder routeBuilder) throws Exception {
        JndiContext jndi = new JndiContext();
        jndi.bind("rssSplitter", new RssSplitter());

        CamelContext context = new DefaultCamelContext(jndi);
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("vm://localhost?broker.persistent=false");
        context.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));

        context.addRoutes(routeBuilder);
        context.start();
    }

    protected void send10Messages(CamelContext context) {
        ProducerTemplate template = context.createProducerTemplate();

        for (int i=0; i<10; i++) {
            template.sendBody("jms:queue:test.queue", "Message " + i);
        }
    }
}
