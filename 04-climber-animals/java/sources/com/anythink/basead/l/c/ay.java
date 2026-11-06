package com.anythink.basead.l.c;

import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class ay {
    public static String a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String text;
        if (xmlPullParser.next() == 4) {
            text = xmlPullParser.getText();
            xmlPullParser.nextTag();
        } else {
            text = "";
        }
        return text.trim();
    }

    public static void b(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (xmlPullParser.getEventType() != 2) {
            throw new IllegalStateException();
        }
        int i = 1;
        while (i != 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }
}
