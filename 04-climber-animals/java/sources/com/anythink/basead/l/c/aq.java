package com.anythink.basead.l.c;

import com.umeng.commonsdk.deeplink.DeepLinkPresetEvent;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public final class aq extends ay {
    private String a;
    private String b;
    private String c;

    public aq(XmlPullParser xmlPullParser) {
        this.a = xmlPullParser.getAttributeValue(null, "model");
        this.b = xmlPullParser.getAttributeValue(null, DeepLinkPresetEvent.UMEventParamCurrency);
        this.c = a(xmlPullParser);
    }

    private String a() {
        return this.a;
    }

    private String b() {
        return this.b;
    }

    private String c() {
        return this.c;
    }
}
