package com.anythink.basead.l.c;

import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class y extends ay {
    private static final String a = "Extensions";
    private static final String b = "Extension";
    private ArrayList<x> c = new ArrayList<>();

    public y(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, a);
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (name != null && name.equals(b)) {
                    xmlPullParser.require(2, null, b);
                    this.c.add(new x(xmlPullParser));
                    xmlPullParser.require(3, null, b);
                } else {
                    b(xmlPullParser);
                }
            }
        }
    }

    public final ArrayList<x> a() {
        return this.c;
    }
}
