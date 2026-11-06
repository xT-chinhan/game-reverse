package com.anythink.basead.l.c;

import androidx.core.app.NotificationCompat;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public final class at extends ay {
    private String a;
    private String b;

    public at(XmlPullParser xmlPullParser) {
        this.a = xmlPullParser.getAttributeValue(null, NotificationCompat.CATEGORY_EVENT);
        this.b = a(xmlPullParser);
    }

    public final String a() {
        return this.a;
    }

    private void a(String str) {
        this.a = str;
    }

    public final String b() {
        return this.b;
    }
}
