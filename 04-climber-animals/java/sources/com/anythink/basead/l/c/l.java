package com.anythink.basead.l.c;

import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class l extends ay {
    private static final String a = "Companion";
    private static final String b = "StaticResource";
    private static final String c = "IFrameResource";
    private static final String d = "HTMLResource";
    private static final String e = "AdParameters";
    private static final String f = "AltText";
    private static final String g = "CompanionClickThrough";
    private static final String h = "CompanionClickTracking";
    private static final String i = "TrackingEvents";
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private ar s;
    private aa t;
    private z u;
    private b v;
    private g w;
    private n x;
    private o y;
    private ArrayList<at> z;

    public l(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, a);
        this.j = xmlPullParser.getAttributeValue(null, "id");
        this.k = xmlPullParser.getAttributeValue(null, "width");
        this.l = xmlPullParser.getAttributeValue(null, "height");
        this.m = xmlPullParser.getAttributeValue(null, "assetWidth");
        this.n = xmlPullParser.getAttributeValue(null, "assetHeight");
        this.o = xmlPullParser.getAttributeValue(null, "expandedWidth");
        this.p = xmlPullParser.getAttributeValue(null, "expandedHeight");
        this.q = xmlPullParser.getAttributeValue(null, "apiFramework");
        this.r = xmlPullParser.getAttributeValue(null, "adSlotID");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (name != null && name.equals(b)) {
                    xmlPullParser.require(2, null, b);
                    this.s = new ar(xmlPullParser);
                    xmlPullParser.require(3, null, b);
                } else if (name != null && name.equals(c)) {
                    xmlPullParser.require(2, null, c);
                    this.t = new aa(xmlPullParser);
                    xmlPullParser.require(3, null, c);
                } else if (name != null && name.equals(d)) {
                    xmlPullParser.require(2, null, d);
                    this.u = new z(xmlPullParser);
                    xmlPullParser.require(3, null, d);
                } else if (name != null && name.equals(e)) {
                    xmlPullParser.require(2, null, e);
                    this.v = new b(xmlPullParser);
                    xmlPullParser.require(3, null, e);
                } else if (name != null && name.equals(f)) {
                    xmlPullParser.require(2, null, f);
                    this.w = new g(xmlPullParser);
                    xmlPullParser.require(3, null, f);
                } else if (name != null && name.equals(g)) {
                    xmlPullParser.require(2, null, g);
                    this.x = new n(xmlPullParser);
                    xmlPullParser.require(3, null, g);
                } else if (name != null && name.equals(h)) {
                    xmlPullParser.require(2, null, h);
                    this.y = new o(xmlPullParser);
                    xmlPullParser.require(3, null, h);
                } else if (name != null && name.equals(i)) {
                    xmlPullParser.require(2, null, i);
                    this.z = new au(xmlPullParser).a();
                    xmlPullParser.require(3, null, i);
                } else {
                    b(xmlPullParser);
                }
            }
        }
    }

    private String i() {
        return this.j;
    }

    public final String a() {
        return this.k;
    }

    public final String b() {
        return this.l;
    }

    private String j() {
        return this.m;
    }

    private String k() {
        return this.n;
    }

    private String l() {
        return this.o;
    }

    private String m() {
        return this.p;
    }

    private String n() {
        return this.q;
    }

    private String o() {
        return this.r;
    }

    public final ar c() {
        return this.s;
    }

    public final aa d() {
        return this.t;
    }

    public final z e() {
        return this.u;
    }

    private b p() {
        return this.v;
    }

    private g q() {
        return this.w;
    }

    public final n f() {
        return this.x;
    }

    public final o g() {
        return this.y;
    }

    public final ArrayList<at> h() {
        return this.z;
    }
}
