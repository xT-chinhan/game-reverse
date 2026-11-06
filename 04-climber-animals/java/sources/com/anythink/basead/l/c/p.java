package com.anythink.basead.l.c;

import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class p extends ay {
    private static final String a = "Creative";
    private static final String b = "CreativeExtensions";
    private static final String c = "Linear";
    private static final String d = "CompanionAds";
    private static final String e = "NonLinearAds";
    private String f;
    private String g;
    private String h;
    private String i;
    private ArrayList<q> j;
    private aj k;
    private ArrayList<l> l;
    private an m;

    public p(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, a);
        this.f = xmlPullParser.getAttributeValue(null, "id");
        this.g = xmlPullParser.getAttributeValue(null, "sequence");
        this.h = xmlPullParser.getAttributeValue(null, "adID");
        this.i = xmlPullParser.getAttributeValue(null, "apiFramework");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (name == null || !name.equals(b)) {
                    if (name != null && name.equals(c)) {
                        xmlPullParser.require(2, null, c);
                        this.k = new aj(xmlPullParser);
                        xmlPullParser.require(3, null, c);
                    } else if (name != null && name.equals(d)) {
                        xmlPullParser.require(2, null, d);
                        this.l = new m(xmlPullParser).a();
                        xmlPullParser.require(3, null, d);
                    } else if (name != null && name.equals(e)) {
                        xmlPullParser.require(2, null, e);
                        this.m = new an(xmlPullParser);
                        xmlPullParser.require(3, null, e);
                    }
                }
                b(xmlPullParser);
            }
        }
    }

    private String d() {
        return this.f;
    }

    private String e() {
        return this.g;
    }

    private String f() {
        return this.h;
    }

    private String g() {
        return this.i;
    }

    public final aj a() {
        return this.k;
    }

    public final ArrayList<l> b() {
        return this.l;
    }

    private void a(ArrayList<l> arrayList) {
        this.l = arrayList;
    }

    public final an c() {
        return this.m;
    }
}
