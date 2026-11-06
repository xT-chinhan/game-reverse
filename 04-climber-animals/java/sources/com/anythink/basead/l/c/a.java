package com.anythink.basead.l.c;

import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class a extends ay {
    private static final String a = "Ad";
    private static final String b = "InLine";
    private static final String c = "Wrapper";
    private ai d;
    private bc e;
    private String f;
    private String g;

    public a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, a);
        this.f = xmlPullParser.getAttributeValue(null, "id");
        this.g = xmlPullParser.getAttributeValue(null, "sequence");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (name != null && name.equals(b)) {
                    xmlPullParser.require(2, null, b);
                    this.d = new ai(xmlPullParser);
                    xmlPullParser.require(3, null, b);
                } else if (name != null && name.equals(c)) {
                    xmlPullParser.require(2, null, c);
                    this.e = new bc(xmlPullParser);
                    xmlPullParser.require(3, null, c);
                } else {
                    b(xmlPullParser);
                }
            }
        }
    }

    public final ai a() {
        return this.d;
    }

    public final bc b() {
        return this.e;
    }

    private String c() {
        return this.f;
    }

    private String d() {
        return this.g;
    }
}
