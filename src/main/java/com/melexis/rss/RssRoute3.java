package com.melexis.rss;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

import static org.apache.camel.builder.script.ScriptBuilder.groovy;

/**
 * Created by IntelliJ IDEA.
 * User: brecht
 * Date: 5-jun-2010
 * Time: 14:28:47
 * To change this template use File | Settings | File Templates.
 */
public class RssRoute3 extends RouteBuilder {

    private final static String SMTP_SERVER = "smtp.pandora.be";

    @Override
    public void configure() throws Exception {
        from("rss:file:src/main/resources/rss?splitEntries=false&consumer.initialDelay=1")
                .split().method("rssSplitter", "splitItems")
                .to("direct:titles");

        from("direct:titles")
                .wireTap("direct:google")
                .setProperty("query", constant("falcon"))
                .filter(groovy("request.body.contains('Falcon')"))
                .to("direct:aggregateAndSend");

        from("direct:google")
                .setProperty("query", constant("google"))
                .filter(groovy("request.body.contains('Google')"))
                .to("direct:aggregateAndSend");

        from("direct:aggregateAndSend")
                .aggregate(property("query"), new AddBodiesStrategy())
                .completionTimeout(500)
                .to("direct:mail");

        from("direct:mail")
                .setHeader("subject", groovy("'Your RSS entries matching ' + exchange.getProperty('query')"))
                .to("smtp://" + SMTP_SERVER + "?to=brecht.hoflack@gmail.com&from=brecht.hoflack@gmail.com");


    }
}
