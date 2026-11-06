package com.mcto.sspsdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.mcto.sspsdk.IQyNativeAd;
import com.mcto.sspsdk.QyAdSlot;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class ti extends n3 {
    public a0 x;

    public ti(Context context, QyAdSlot qyAdSlot, p pVar) {
        super(context, qyAdSlot, pVar);
    }

    @Override // com.mcto.sspsdk.internal.n3
    public final void a() {
        if ((this.i & 1) == 0 || this.d.m()) {
            return;
        }
        HashMap map = new HashMap(4);
        map.put(v5.KEY_VIEW_COORDINATE, this.k.d);
        map.put(v5.KEY_TOKEN_VIEW_COORDINATE, gj.a(this.h));
        v5 v5Var = v5.KEY_AD_VIEW_RECT;
        d8 d8Var = this.k;
        map.put(v5Var, d8Var.e + "_" + d8Var.f);
        map.put(v5.KEY_IMPRESSION_INTERVAL_TIME, Long.valueOf(System.currentTimeMillis() - this.k.g));
        l lVarA = l.a();
        p pVar = this.d;
        lVarA.getClass();
        l.a(12, pVar, map);
        nh.a(jd.a).a("iad_spa", "csalio", String.valueOf(this.d.w));
        IQyNativeAd.IQyNativeAdInteractionListener iQyNativeAdInteractionListener = this.o;
        if (iQyNativeAdInteractionListener != null) {
            iQyNativeAdInteractionListener.onAdShow(this);
        }
        if (this.b.isSupportPreRequest()) {
            fi.a(this.b, 100);
        }
    }

    @Override // com.mcto.sspsdk.internal.n3, com.mcto.sspsdk.IQyNativeAd
    public final void destroy() {
        super.destroy();
        a0 a0Var = this.x;
        if (a0Var != null) {
            a0Var.a();
        }
    }

    @Override // com.mcto.sspsdk.internal.n3, com.mcto.sspsdk.IQyNativeAd
    public final String getButtonText() {
        boolean zEquals = TextUtils.equals(this.e.optString("checkAppInstalled"), "1");
        JSONObject jSONObject = this.e;
        return jSONObject.optString((zEquals && e1.c(jSONObject.optString("apkName"))) ? "dlButtonTitle" : "buttonTitle", "点击跳转至详情页面或第三方应用");
    }
}
