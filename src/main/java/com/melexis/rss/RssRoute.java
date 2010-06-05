package com.melexis.rss;

import com.melexis.screen.ToScreenProcessor;
import org.apache.camel.builder.RouteBuilder;

/**
 * Created by IntelliJ IDEA.
 * User: brecht
 * Date: 5-jun-2010
 * Time: 13:27:12
 * To change this template use File | Settings | File Templates.
 */
public class RssRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("rss:file:src/main/resources/rss?splitEntries=false&consumer.initialDelay=1").marshal().rss()
                .process(new ToScreenProcessor());
    }
}
