package com.melexis.screen;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

/**
 * Created by IntelliJ IDEA.
 * User: brecht
 * Date: 5-jun-2010
 * Time: 12:49:11
 * To change this template use File | Settings | File Templates.
 */
public class ToScreenProcessor implements Processor {
    public void process(Exchange exchange) throws Exception {
        final Message in = exchange.getIn();

        System.out.println(in.getBody(String.class));
    }
}
