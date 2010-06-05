package com.melexis;

import com.melexis.rss.RssRoute3;

/**
 * Created by IntelliJ IDEA.
 * User: brecht
 * Date: 5-jun-2010
 * Time: 13:25:53
 * To change this template use File | Settings | File Templates.
 */
public class Ex5RssReader extends AbstractCamel {

    protected Ex5RssReader() throws Exception {
        super(new RssRoute3());



        Thread.sleep(100000);
    }

    public static void main(String[] args) throws Exception {
        new Ex5RssReader();
    }
}