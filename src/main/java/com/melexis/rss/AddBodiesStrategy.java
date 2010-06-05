package com.melexis.rss;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

/**
 * Created by IntelliJ IDEA.
 * User: brecht
 * Date: 5-jun-2010
 * Time: 15:11:15
 * To change this template use File | Settings | File Templates.
 */
public class AddBodiesStrategy implements AggregationStrategy {

    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        if (oldExchange == null) {
            return newExchange;
        }

        String first = oldExchange.getIn().getBody(String.class);
        String second = newExchange.getIn().getBody(String.class);
        oldExchange.getIn().setBody(first + "\n" + second);
        return oldExchange;
    }
}
