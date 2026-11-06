package com.mcto.sspsdk.internal;

import com.mar.sdk.IAction;
import com.mcto.sspsdk.QyRewardProperty;
import com.mcto.unionsdk.QiAdnAd;
import com.tapsdk.tapad.internal.runtime.view.ImageViewManager;
import com.taptap.sdk.compliance.constants.BundleKey;
import java.util.HashMap;
import java.util.Locale;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class bl {
    public final QiAdnAd a;
    public final String b;
    public final double c;
    public final int d;
    public final int e;
    public final String f;
    public final int g;
    public final Long h;
    public final HashMap i;
    public final al j;
    public final long k;
    public final String l;
    public int m;
    public String n;
    public String o;

    public bl(cl clVar, QiAdnAd qiAdnAd, JSONObject jSONObject, long j) {
        HashMap map = new HashMap();
        this.i = map;
        this.m = 6;
        this.e = ((gj.a.addAndGet(1) % 524287) << 12) >> 12;
        double d = clVar.b;
        this.c = d;
        int i = clVar.c;
        this.d = i;
        this.f = clVar.f;
        this.a = qiAdnAd;
        this.g = clVar.a;
        this.h = Long.valueOf(j);
        this.k = j + ((long) clVar.d);
        this.j = new al(jSONObject);
        this.b = clVar.g;
        String strA = gj.a(qiAdnAd.getCreativeString());
        this.l = strA;
        map.put("orderItemType", "" + i);
        map.put(IAction.PurchaseKey.Price, "" + d);
        map.put(QyRewardProperty.VERIFY_IMPRESSIONID, strA);
    }

    public final String a() {
        String str = this.o;
        if (str != null) {
            return str;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", this.l);
            jSONObject.put("adnType", this.d);
            jSONObject.put(IAction.PurchaseKey.Price, this.c);
            jSONObject.put("adnCodeId", this.f);
            int i = 1;
            jSONObject.put("cardIndex", 1);
            String str2 = this.j.a;
            if (!ImageViewManager.NAME.equals(str2)) {
                i = "video".equals(str2) ? 2 : 3;
            }
            jSONObject.put("creativeType", i);
            jSONObject.put("apkName", this.j.k);
            jSONObject.put("appName", this.j.f);
            jSONObject.put("source", this.j.f);
            jSONObject.put(BundleKey.TITLE, this.j.g);
        } catch (Exception e) {
        }
        String string = jSONObject.toString();
        this.o = string;
        return string;
    }

    public final String b() {
        StringBuilder sb = new StringBuilder("at:");
        sb.append(this.d).append(";ap:");
        sb.append(String.format(Locale.CHINA, "%.1f", Double.valueOf(this.c))).append(";aName:");
        sb.append(this.j.f).append(";apName:");
        sb.append(this.j.k).append(";acid:");
        sb.append(this.f).append(";rdt:");
        sb.append(this.j.a).append(";");
        return sb.toString();
    }

    public final String toString() {
        return "WaterfallAdImp{, mAdId=" + this.e + ", mPrice=" + this.c + ", mAdnType=" + this.d + ", mActionType=" + this.m + ", mCodeId='" + this.f + "', mPriority='" + this.g + "', mRequestTime=" + this.h + ", mImpressionId='" + this.l + '\'' + this.j + AbstractJsonLexerKt.END_OBJ;
    }
}
