package com.anythink.basead.l.c;

import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class m extends ay {
    private static final String a = "CompanionAds";
    private static final String b = "Companion";
    private ArrayList<l> c = new ArrayList<>();

    public m(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, a);
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (name != null && name.equals(b)) {
                    xmlPullParser.require(2, null, b);
                    this.c.add(new l(xmlPullParser));
                    xmlPullParser.require(3, null, b);
                } else {
                    b(xmlPullParser);
                }
            }
        }
    }

    public final ArrayList<l> a() {
        return this.c;
    }
}
