package com.anythink.basead.l.c;

import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class e extends ay {
    private static final String a = "Verification";
    private final ArrayList<ba> b = new ArrayList<>();

    public e(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (name != null && name.equals(a)) {
                    xmlPullParser.require(2, null, a);
                    this.b.add(new ba(xmlPullParser));
                    xmlPullParser.require(3, null, a);
                } else {
                    b(xmlPullParser);
                }
            }
        }
    }

    private ArrayList<ba> a() {
        return this.b;
    }
}
