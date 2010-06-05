package com.melexis.rss;

import com.google.common.base.Function;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;

import java.util.List;

import static com.google.common.collect.ImmutableList.copyOf;
import static com.google.common.collect.Iterables.transform;

/**
 * Created by IntelliJ IDEA.
 * User: brecht
 * Date: 5-jun-2010
 * Time: 14:10:22
 * To change this template use File | Settings | File Templates.
 */
public class RssSplitter {

    public List<String> splitItems(SyndFeed feed) {
        return copyOf(transform(feed.getEntries(), new Function<SyndEntry, String>() {

            public String apply(SyndEntry o) {
                return o.getTitle();
            }
        }));
    }

}
