package com.anythink.basead.l.c;

import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class av extends ay {
    private static final String a = "VAST";
    private static final String b = "Error";
    private static final String c = "Ad";
    private w d;
    private ArrayList<a> e;
    private String f;

    public av(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, a);
        this.f = xmlPullParser.getAttributeValue(null, "version");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (name != null && name.equals(b)) {
                    xmlPullParser.require(2, null, b);
                    this.d = new w(xmlPullParser);
                    xmlPullParser.require(3, null, b);
                } else if (name != null && name.equals(c)) {
                    if (this.e == null) {
                        this.e = new ArrayList<>();
                    }
                    xmlPullParser.require(2, null, c);
                    this.e.add(new a(xmlPullParser));
                    xmlPullParser.require(3, null, c);
                } else {
                    b(xmlPullParser);
                }
            }
        }
    }

    private w b() {
        return this.d;
    }

    public final ArrayList<a> a() {
        return this.e;
    }

    private String c() {
        return this.f;
    }
}
