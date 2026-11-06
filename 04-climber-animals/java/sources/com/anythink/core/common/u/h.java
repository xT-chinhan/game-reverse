package com.anythink.core.common.u;

import android.text.TextUtils;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.bv;
import com.anythink.core.common.h.n;
import com.anythink.core.common.h.u;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public final class h {
    private static void a(n nVar, int i, int i2, String str, String str2, int i3, Boolean bool, String str3, boolean z, boolean z2, boolean z3, boolean z4) {
        String str4;
        u uVar = new u(nVar.aK(), null);
        uVar.c = "1004684";
        uVar.a(nVar);
        uVar.d = nVar.aJ();
        uVar.e = nVar.aI();
        uVar.l = String.valueOf(i);
        uVar.p = String.valueOf(i3);
        uVar.q = String.valueOf(nVar.aK());
        uVar.r = z ? "1" : "2";
        uVar.s = String.valueOf(i2);
        if (!TextUtils.isEmpty(str)) {
            uVar.t = str;
        }
        if (!TextUtils.isEmpty(str2)) {
            uVar.u = str2;
        }
        if (bool == null) {
            str4 = "0";
        } else {
            str4 = bool.booleanValue() ? "1" : "2";
        }
        uVar.v = str4;
        uVar.w = str3;
        uVar.x = z2 ? "1" : "2";
        uVar.y = z3 ? "1" : "2";
        uVar.z = String.valueOf(i);
        uVar.A = z4 ? "1" : "2";
        e.b(uVar);
    }

    public static void a(String str, ATBaseAdAdapter aTBaseAdAdapter, BaseAd baseAd) {
        String str2;
        String string;
        try {
            String strR = t.b().r();
            String string2 = AbstractJsonLexerKt.NULL;
            if (aTBaseAdAdapter != null) {
                String string3 = aTBaseAdAdapter.toString();
                n trackingInfo = aTBaseAdAdapter.getTrackingInfo();
                string = trackingInfo != null ? trackingInfo.toString() : AbstractJsonLexerKt.NULL;
                bv unitGroupInfo = aTBaseAdAdapter.getUnitGroupInfo();
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
            e.b("Empty ATAdInfo", str3, strR);
        } catch (Throwable unused) {
        }
    }
}
