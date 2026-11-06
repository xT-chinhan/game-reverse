package com.anythink.basead.l.c;

import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class ba extends ay {
    private static final String a = "JavaScriptResource";
    private static final String b = "VerificationParameters";
    private String c;
    private String d;
    private String e;
    private String f;

    public ba(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        this.c = xmlPullParser.getAttributeValue(null, "vendor");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (name != null && name.equals(a)) {
                    xmlPullParser.require(2, null, a);
                    this.f = xmlPullParser.getAttributeValue(null, "apiFramework");
                    this.d = a(xmlPullParser);
                    xmlPullParser.require(3, null, a);
                } else if (name != null && name.equals(b)) {
                    xmlPullParser.require(2, null, b);
                    this.e = a(xmlPullParser);
                    xmlPullParser.require(3, null, b);
                } else {
                    b(xmlPullParser);
                }
            }
        }
    }

    private String a() {
        return this.c;
    }

    private String b() {
        return this.d;
    }

    private String c() {
        return this.e;
    }

    private String d() {
        return this.f;
    }
}
