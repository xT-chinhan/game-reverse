package com.anythink.basead.l.c;

import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class am extends ay {
    private static final String a = "NonLinear";
    private static final String b = "StaticResource";
    private static final String c = "IFrameResource";
    private static final String d = "HTMLResource";
    private static final String e = "AdParameters";
    private static final String f = "NonLinearClickThrough";
    private static final String g = "NonLinearClickTracking";
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private ar q;
    private aa r;
    private z s;
    private b t;
    private ao u;
    private ap v;

    public am(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, a);
        this.h = xmlPullParser.getAttributeValue(null, "id");
        this.i = xmlPullParser.getAttributeValue(null, "width");
        this.j = xmlPullParser.getAttributeValue(null, "height");
        this.k = xmlPullParser.getAttributeValue(null, "expandedWidth");
        this.l = xmlPullParser.getAttributeValue(null, "expandedHeight");
        this.m = xmlPullParser.getAttributeValue(null, "scalable");
        this.n = xmlPullParser.getAttributeValue(null, "maintainAspectRatio");
        this.o = xmlPullParser.getAttributeValue(null, "minSuggestedDuration");
        this.p = xmlPullParser.getAttributeValue(null, "apiFramework");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (name != null && name.equals(b)) {
                    xmlPullParser.require(2, null, b);
                    this.q = new ar(xmlPullParser);
                    xmlPullParser.require(3, null, b);
                } else if (name != null && name.equals(c)) {
                    xmlPullParser.require(2, null, c);
                    this.r = new aa(xmlPullParser);
                    xmlPullParser.require(3, null, c);
                } else if (name != null && name.equals(d)) {
                    xmlPullParser.require(2, null, d);
                    this.s = new z(xmlPullParser);
                    xmlPullParser.require(3, null, d);
                } else if (name != null && name.equals(e)) {
                    xmlPullParser.require(2, null, e);
                    this.t = new b(xmlPullParser);
                    xmlPullParser.require(3, null, e);
                } else if (name != null && name.equals(f)) {
                    xmlPullParser.require(2, null, f);
                    this.u = new ao(xmlPullParser);
                    xmlPullParser.require(3, null, f);
                } else if (name != null && name.equals(g)) {
                    xmlPullParser.require(2, null, g);
                    this.v = new ap(xmlPullParser);
                    xmlPullParser.require(3, null, g);
                } else {
                    b(xmlPullParser);
                }
            }
        }
    }

    private String a() {
        return this.h;
    }

    private String b() {
        return this.i;
    }

    private String c() {
        return this.j;
    }

    private String d() {
        return this.k;
    }

    private String e() {
        return this.l;
    }

    private String f() {
        return this.m;
    }

    private String g() {
        return this.n;
    }

    private String h() {
        return this.o;
    }

    private String i() {
        return this.p;
    }

    private ar j() {
        return this.q;
    }

    private aa k() {
        return this.r;
    }

    private z l() {
        return this.s;
    }

    private b m() {
        return this.t;
    }

    private ao n() {
        return this.u;
    }

    private ap o() {
        return this.v;
    }
}
