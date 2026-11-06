package com.anythink.basead.l.c;

import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class ai extends ay {
    private static final String a = "InLine";
    private static final String b = "AdSystem";
    private static final String c = "AdTitle";
    private static final String d = "Description";
    private static final String e = "Advertiser";
    private static final String f = "Pricing";
    private static final String g = "Survey";
    private static final String h = "Error";
    private static final String i = "Impression";
    private static final String j = "Creatives";
    private static final String k = "Extensions";
    private static final String l = "AdVerifications";
    private c m;
    private d n;
    private u o;
    private f p;
    private aq q;
    private as r;
    private w s;
    private ArrayList<ah> t;
    private ArrayList<p> u;
    private y v;
    private e w;

    public ai(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, a);
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (name != null && name.equals(b)) {
                    xmlPullParser.require(2, null, b);
                    this.m = new c(xmlPullParser);
                    xmlPullParser.require(3, null, b);
                } else if (name != null && name.equals(c)) {
                    xmlPullParser.require(2, null, c);
                    this.n = new d(xmlPullParser);
                    xmlPullParser.require(3, null, c);
                } else if (name != null && name.equals(d)) {
                    xmlPullParser.require(2, null, d);
                    this.o = new u(xmlPullParser);
                    xmlPullParser.require(3, null, d);
                } else if (name != null && name.equals(e)) {
                    xmlPullParser.require(2, null, e);
                    this.p = new f(xmlPullParser);
                    xmlPullParser.require(3, null, e);
                } else if (name != null && name.equals(f)) {
                    xmlPullParser.require(2, null, f);
                    this.q = new aq(xmlPullParser);
                    xmlPullParser.require(3, null, f);
                } else if (name != null && name.equals(g)) {
                    xmlPullParser.require(2, null, g);
                    this.r = new as(xmlPullParser);
                    xmlPullParser.require(3, null, g);
                } else if (name != null && name.equals(h)) {
                    xmlPullParser.require(2, null, h);
                    this.s = new w(xmlPullParser);
                    xmlPullParser.require(3, null, h);
                } else if (name != null && name.equals(i)) {
                    if (this.t == null) {
                        this.t = new ArrayList<>();
                    }
                    xmlPullParser.require(2, null, i);
                    this.t.add(new ah(xmlPullParser));
                    xmlPullParser.require(3, null, i);
                } else if (name != null && name.equals(j)) {
                    xmlPullParser.require(2, null, j);
                    this.u = new s(xmlPullParser).a();
                    xmlPullParser.require(3, null, j);
                } else if (name != null && name.equals(k)) {
                    xmlPullParser.require(2, null, k);
                    this.v = new y(xmlPullParser);
                    xmlPullParser.require(3, null, k);
                } else if (name != null && name.equals(l)) {
                    xmlPullParser.require(2, null, l);
                    this.w = new e(xmlPullParser);
                    xmlPullParser.require(3, null, l);
                } else {
                    b(xmlPullParser);
                }
            }
        }
    }

    private c h() {
        return this.m;
    }

    public final d a() {
        return this.n;
    }

    public final u b() {
        return this.o;
    }

    private f i() {
        return this.p;
    }

    private aq j() {
        return this.q;
    }

    private as k() {
        return this.r;
    }

    public final w c() {
        return this.s;
    }

    public final ArrayList<ah> d() {
        return this.t;
    }

    public final ArrayList<p> e() {
        return this.u;
    }

    private void a(ArrayList<p> arrayList) {
        this.u = arrayList;
    }

    public final y f() {
        return this.v;
    }

    public final e g() {
        return this.w;
    }
}
