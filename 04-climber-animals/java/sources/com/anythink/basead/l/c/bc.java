package com.anythink.basead.l.c;

import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class bc extends ay {
    private static final String a = "Wrapper";
    private static final String b = "AdSystem";
    private static final String c = "Impression";
    private static final String d = "VASTAdTagURI";
    private static final String e = "Error";
    private static final String f = "Creatives";
    private static final String g = "Extensions";
    private String h;
    private String i;
    private String j;
    private c k;
    private az l;
    private w m;
    private ArrayList<ah> n;
    private ArrayList<p> o;
    private y p;

    public bc(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, a);
        this.h = xmlPullParser.getAttributeValue(null, "followAdditionalWrappers");
        this.i = xmlPullParser.getAttributeValue(null, "allowMultipleAds");
        this.j = xmlPullParser.getAttributeValue(null, "fallbackOnNoAd");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (name != null && name.equals(b)) {
                    xmlPullParser.require(2, null, b);
                    this.k = new c(xmlPullParser);
                    xmlPullParser.require(3, null, b);
                } else if (name != null && name.equals(e)) {
                    xmlPullParser.require(2, null, e);
                    this.m = new w(xmlPullParser);
                    xmlPullParser.require(3, null, e);
                } else if (name != null && name.equals(d)) {
                    xmlPullParser.require(2, null, d);
                    this.l = new az(xmlPullParser);
                    xmlPullParser.require(3, null, d);
                } else if (name != null && name.equals(c)) {
                    if (this.n == null) {
                        this.n = new ArrayList<>();
                    }
                    xmlPullParser.require(2, null, c);
                    this.n.add(new ah(xmlPullParser));
                    xmlPullParser.require(3, null, c);
                } else if (name != null && name.equals(f)) {
                    xmlPullParser.require(2, null, f);
                    this.o = new s(xmlPullParser).a();
                    xmlPullParser.require(3, null, f);
                } else if (name != null && name.equals(g)) {
                    xmlPullParser.require(2, null, g);
                    this.p = new y(xmlPullParser);
                    xmlPullParser.require(3, null, g);
                } else {
                    b(xmlPullParser);
                }
            }
        }
    }

    private String d() {
        return this.i;
    }

    private String e() {
        return this.j;
    }

    private c f() {
        return this.k;
    }

    public final az a() {
        return this.l;
    }

    private w g() {
        return this.m;
    }

    public final ArrayList<ah> b() {
        return this.n;
    }

    public final ArrayList<p> c() {
        return this.o;
    }

    private y h() {
        return this.p;
    }
}
