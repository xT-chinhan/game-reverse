package com.anythink.basead.l.c;

import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public final class c extends ay {
    private String a;
    private String b;

    public c(XmlPullParser xmlPullParser) {
        this.a = xmlPullParser.getAttributeValue(null, "version");
        this.b = a(xmlPullParser);
    }

    private String a() {
        return this.a;
    }

    private String b() {
        return this.b;
    }
}
