package com.melexis.file;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by IntelliJ IDEA.
 * User: brecht
 * Date: 5-jun-2010
 * Time: 12:45:50
 * To change this template use File | Settings | File Templates.
 */
public class Route extends RouteBuilder {


    @Override
    public void configure() throws Exception {
        from("jms:queue:test.queue").to("file://test");
    }
}
