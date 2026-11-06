package com.anythink.basead.l.c;

import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public final class b extends ay {
    private final String a;
    private String b;

    public b(XmlPullParser xmlPullParser) {
        this.a = xmlPullParser.getAttributeValue(null, "xmlEncoded");
        this.b = a(xmlPullParser);
    }

    private String a() {
        return this.a;
    }

    private String b() {
        return this.b;
    }
}
