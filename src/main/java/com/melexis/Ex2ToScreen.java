package com.melexis;

import com.melexis.screen.Route;

/**
 * Created by IntelliJ IDEA.
 * User: brecht
 * Date: 5-jun-2010
 * Time: 13:13:29
 * To change this template use File | Settings | File Templates.
 */
public class Ex2ToScreen extends AbstractCamel {

    protected Ex2ToScreen() throws Exception {
        super(new Route());

        Thread.sleep(100000);
    }
    
    public static void main(String[] args) throws Exception {
        new Ex2ToScreen();
    }
}
