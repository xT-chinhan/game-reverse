package com.anythink.core.common.t;

import com.anythink.core.api.BaseAd;
import com.anythink.core.api.bridge.ATBaseAdAdapter;
import com.anythink.core.common.d.s;
import com.anythink.core.common.h.by;
import com.anythink.core.common.h.n;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public final class g {
    public static void a(String str, ATBaseAdAdapter aTBaseAdAdapter, BaseAd baseAd) {
        String str2;
        String string;
        try {
            String strR = s.b().r();
            String string2 = AbstractJsonLexerKt.NULL;
            if (aTBaseAdAdapter != null) {
                String string3 = aTBaseAdAdapter.toString();
                n trackingInfo = aTBaseAdAdapter.getTrackingInfo();
                string = trackingInfo != null ? trackingInfo.toString() : AbstractJsonLexerKt.NULL;
                by unitGroupInfo = aTBaseAdAdapter.getUnitGroupInfo();
                if (unitGroupInfo != null) {
                    string2 = unitGroupInfo.toString();
                }
                str2 = string2;
                string2 = string3;
            } else {
                str2 = AbstractJsonLexerKt.NULL;
                string = str2;
            }
            String str3 = "format: " + str + " | adapter: " + string2 + " | tracking: " + string + " | unitGroupInfo: " + str2;
            if (baseAd != null) {
                str3 = str3 + " | baseAd: " + baseAd.toString();
            }
            f.b("Empty ATAdInfo", str3, strR);
        } catch (Throwable unused) {
        }
    }
}
