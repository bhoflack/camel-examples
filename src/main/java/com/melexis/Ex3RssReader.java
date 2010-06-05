package com.melexis;

import com.melexis.rss.RssRoute;

/**
 * Created by IntelliJ IDEA.
 * User: brecht
 * Date: 5-jun-2010
 * Time: 13:25:53
 * To change this template use File | Settings | File Templates.
 */
public class Ex3RssReader extends AbstractCamel {

    protected Ex3RssReader() throws Exception {
        super(new RssRoute());

        Thread.sleep(100000);
    }

    public static void main(String[] args) throws Exception {
        new Ex3RssReader();
    }
}
