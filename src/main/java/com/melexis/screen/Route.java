package com.melexis.screen;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by IntelliJ IDEA.
 * User: brecht
 * Date: 5-jun-2010
 * Time: 13:12:16
 * To change this template use File | Settings | File Templates.
 */
public class Route extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file://toScreen").process(new ToScreenProcessor());
    }
}
