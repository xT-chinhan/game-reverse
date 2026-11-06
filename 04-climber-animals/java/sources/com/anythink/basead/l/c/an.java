package com.anythink.basead.l.c;

import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class an extends ay {
    private static final String a = "NonLinearAds";
    private static final String b = "NonLinear";
    private static final String c = "TrackingEvents";
    private ArrayList<am> d = new ArrayList<>();
    private ArrayList<at> e;

    public an(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, a);
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (name != null && name.equals(b)) {
                    xmlPullParser.require(2, null, b);
                    this.d.add(new am(xmlPullParser));
                    xmlPullParser.require(3, null, b);
                } else if (name != null && name.equals(c)) {
                    xmlPullParser.require(2, null, c);
                    this.e = new au(xmlPullParser).a();
                    xmlPullParser.require(3, null, c);
                } else {
                    b(xmlPullParser);
                }
            }
        }
    }

    private ArrayList<am> b() {
        return this.d;
    }

    public final ArrayList<at> a() {
        return this.e;
    }
}
