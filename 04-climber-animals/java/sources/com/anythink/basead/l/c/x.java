package com.anythink.basead.l.c;

import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class x extends ay {
    private static final String c = "AdVerifications";
    private static final String d = "Extension";
    private String a;
    private e b;

    public x(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        this.a = xmlPullParser.getAttributeValue(null, "type");
        xmlPullParser.require(2, null, d);
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (name != null && name.equals(c)) {
                    xmlPullParser.require(2, null, c);
                    this.b = new e(xmlPullParser);
                    xmlPullParser.require(3, null, c);
                } else {
                    b(xmlPullParser);
                }
            }
        }
    }

    private String b() {
        return this.a;
    }

    public final e a() {
        return this.b;
    }
}
