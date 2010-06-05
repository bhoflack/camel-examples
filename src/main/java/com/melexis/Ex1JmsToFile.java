package com.melexis;

import com.melexis.file.Route;

/**
 * Created by IntelliJ IDEA.
 * User: brecht
 * Date: 5-jun-2010
 * Time: 12:35:32
 * To change this template use File | Settings | File Templates.
 */
public class Ex1JmsToFile extends AbstractCamel {

    public Ex1JmsToFile() throws Exception {
        super(new Route());
        send10Messages(context);
        context.stop();
    }

    public static void main(String[] args) throws Exception {
        new Ex1JmsToFile();
    }

}
