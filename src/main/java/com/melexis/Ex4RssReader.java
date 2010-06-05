package com.melexis;

import com.melexis.rss.RssRoute;
import com.melexis.rss.RssRoute2;

/**
 * Created by IntelliJ IDEA.
 * User: brecht
 * Date: 5-jun-2010
 * Time: 13:25:53
 * To change this template use File | Settings | File Templates.
 */
public class Ex4RssReader extends AbstractCamel {

    protected Ex4RssReader() throws Exception {
        super(new RssRoute2());

        

        Thread.sleep(100000);
    }

    public static void main(String[] args) throws Exception {
        new Ex4RssReader();
    }
}