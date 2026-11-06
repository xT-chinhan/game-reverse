package com.anythink.basead.l.c;

import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class bb extends ay {
    private static final String a = "VideoClicks";
    private static final String b = "ClickThrough";
    private static final String c = "ClickTracking";
    private static final String d = "CustomClick";
    private j e;
    private ArrayList<k> f = new ArrayList<>();
    private ArrayList<t> g = new ArrayList<>();

    public bb(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, a);
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (name != null && name.equals(b)) {
                    xmlPullParser.require(2, null, b);
                    this.e = new j(xmlPullParser);
                    xmlPullParser.require(3, null, b);
                } else if (name != null && name.equals(c)) {
                    xmlPullParser.require(2, null, c);
                    this.f.add(new k(xmlPullParser));
                    xmlPullParser.require(3, null, c);
                } else if (name != null && name.equals(d)) {
                    xmlPullParser.require(2, null, d);
                    this.g.add(new t(xmlPullParser));
                    xmlPullParser.require(3, null, d);
                } else {
                    b(xmlPullParser);
                }
            }
        }
    }

    public final j a() {
        return this.e;
    }

    public final ArrayList<k> b() {
        return this.f;
    }

    private ArrayList<t> c() {
        return this.g;
    }
}
