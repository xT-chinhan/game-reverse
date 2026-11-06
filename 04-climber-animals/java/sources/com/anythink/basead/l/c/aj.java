package com.anythink.basead.l.c;

import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class aj extends ay {
    private static final String a = "Linear";
    private static final String b = "AdParameters";
    private static final String c = "Duration";
    private static final String d = "MediaFiles";
    private static final String e = "TrackingEvents";
    private static final String f = "VideoClicks";
    private static final String g = "Icons";
    private String h;
    private b i;
    private v j;
    private ArrayList<ak> k;
    private ArrayList<at> l;
    private bb m;
    private ArrayList<ab> n;

    public aj(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, a);
        this.h = xmlPullParser.getAttributeValue(null, "skipoffset");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (name != null && name.equals(b)) {
                    xmlPullParser.require(2, null, b);
                    this.i = new b(xmlPullParser);
                    xmlPullParser.require(3, null, b);
                } else if (name != null && name.equals(c)) {
                    xmlPullParser.require(2, null, c);
                    this.j = new v(xmlPullParser);
                    xmlPullParser.require(3, null, c);
                } else if (name != null && name.equals(d)) {
                    xmlPullParser.require(2, null, d);
                    this.k = new al(xmlPullParser).a();
                    xmlPullParser.require(3, null, d);
                } else if (name != null && name.equals(e)) {
                    xmlPullParser.require(2, null, e);
                    this.l = new au(xmlPullParser).a();
                    xmlPullParser.require(3, null, e);
                } else if (name != null && name.equals(f)) {
                    xmlPullParser.require(2, null, f);
                    this.m = new bb(xmlPullParser);
                    xmlPullParser.require(3, null, f);
                } else if (name != null && name.equals(g)) {
                    xmlPullParser.require(2, null, g);
                    this.n = new ag(xmlPullParser).a();
                    xmlPullParser.require(3, null, g);
                } else {
                    b(xmlPullParser);
                }
            }
        }
    }

    public final String a() {
        return this.h;
    }

    private b f() {
        return this.i;
    }

    public final v b() {
        return this.j;
    }

    public final ArrayList<ak> c() {
        return this.k;
    }

    public final ArrayList<at> d() {
        return this.l;
    }

    public final bb e() {
        return this.m;
    }

    private ArrayList<ab> g() {
        return this.n;
    }
}
