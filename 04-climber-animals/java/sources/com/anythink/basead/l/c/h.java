package com.anythink.basead.l.c;

import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class h extends ay {
    private String a;
    private String b;

    public h(XmlPullParser xmlPullParser) {
        this.a = xmlPullParser.getAttributeValue(null, "id");
        this.b = a(xmlPullParser);
    }

    private String b() {
        return this.a;
    }

    public final String a() {
        return this.b;
    }
}
