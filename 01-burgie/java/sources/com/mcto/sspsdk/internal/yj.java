package com.mcto.sspsdk.internal;

import android.net.Uri;
import com.byazt.mg.PluginConstants;
import com.umeng.analytics.pro.an;
import java.util.HashMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class yj implements i7 {
    public final /* synthetic */ p a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ int d;
    public final /* synthetic */ zj e;

    public yj(zj zjVar, p pVar, String str, String str2, int i) {
        this.e = zjVar;
        this.a = pVar;
        this.b = str;
        this.c = str2;
        this.d = i;
    }

    @Override // com.mcto.sspsdk.internal.i7
    public final void a(String str, h7 h7Var) {
        String strOptString;
        int i = this.a.a;
        HashMap map = new HashMap(4);
        map.put(v5.KEY_TRACKING_URL, this.b);
        map.put(v5.KEY_REQUEST_COUNT, Integer.valueOf(h7Var.b));
        map.put(v5.KEY_REQUEST_DURATION, Integer.valueOf(h7Var.a));
        if ("cupidTracking".equals(this.c)) {
            if (str.toLowerCase().contains("ok")) {
                za.d().c(10, this.a, map);
                return;
            } else {
                za.d().c(13, this.a, map);
                return;
            }
        }
        if ("adxTracking".equals(this.c)) {
            if (str.toLowerCase().contains("ok")) {
                za.d().c(14, this.a, map);
                return;
            } else {
                za.d().c(17, this.a, map);
                return;
            }
        }
        if ("qilinTracking".equals(this.c)) {
            if (str.toLowerCase().contains("ok")) {
                za.d().c(18, this.a, map);
                return;
            } else {
                za.d().c(21, this.a, map);
                return;
            }
        }
        if ("thirdParty".equals(this.c)) {
            mh mhVarC = this.a.c();
            boolean z = mhVarC != null && "qxt".equals(mhVarC.a(this.b, an.ax));
            boolean z2 = (z || mhVarC == null || !"awd".equals(mhVarC.a(this.b, "fesdk"))) ? false : true;
            p pVar = this.a;
            if (pVar.q0 == 1) {
                p9.a.a(Integer.valueOf(pVar.a), "sent success", this.b);
            }
            if (!z2) {
                if (!z || str.toLowerCase().contains("ok")) {
                    za.d().c(18, this.a, map);
                    return;
                } else {
                    za.d().c(21, this.a, map);
                    return;
                }
            }
            HashMap map2 = new HashMap(2);
            this.e.getClass();
            if (str == null) {
                strOptString = AbstractJsonLexerKt.NULL;
            } else {
                try {
                    strOptString = new JSONObject(str).optString(PluginConstants.KEY_ERROR_CODE);
                } catch (Exception e) {
                    strOptString = "jsonError";
                }
            }
            Uri.parse(this.b);
            if ("A00000".equals(strOptString) || "0".equals(strOptString)) {
                map2.put("extCustom", "type:fe_awd;s:1;tt:".concat(ak.b(this.d)));
            } else {
                map2.put("extCustom", "type:fe_awd;s:0;tt:".concat(ak.b(this.d)));
                map2.put("errMsg", "errCode:" + strOptString + ";errMsg:" + gj.f(str));
            }
            za.d().b(53, this.a, map2);
        }
    }

    @Override // com.mcto.sspsdk.internal.i7
    public final void a(h7 h7Var) {
        int i = this.a.a;
        HashMap map = new HashMap(4);
        map.put(v5.KEY_REQUEST_COUNT, Integer.valueOf(h7Var.b));
        map.put(v5.KEY_REQUEST_DURATION, Integer.valueOf(h7Var.a));
        map.put(v5.KEY_TRACKING_URL, this.b);
        if ("cupidTracking".equals(this.c)) {
            if (h7Var.c == -4) {
                za.d().c(12, this.a, map);
                return;
            } else {
                za.d().c(11, this.a, map);
                return;
            }
        }
        if ("qilinTracking".equals(this.c)) {
            if (h7Var.c == -4) {
                za.d().c(20, this.a, map);
                return;
            } else {
                za.d().c(19, this.a, map);
                return;
            }
        }
        if ("adxTracking".equals(this.c)) {
            if (h7Var.c == -4) {
                za.d().c(16, this.a, map);
                return;
            } else {
                za.d().c(15, this.a, map);
                return;
            }
        }
        if ("thirdParty".equals(this.c)) {
            mh mhVarC = this.a.c();
            boolean z = mhVarC != null && "awd".equals(mhVarC.a(this.b, "fesdk"));
            p pVar = this.a;
            if (pVar.q0 == 1) {
                p9.a.a(Integer.valueOf(pVar.a), "sent error", Integer.valueOf(h7Var.c), this.b);
            }
            if (z) {
                HashMap map2 = new HashMap();
                Uri.parse(this.b);
                map2.put("extCustom", "type:fe_awd;s:0;tt:".concat(ak.b(this.d)));
                map2.put("errMsg", "errCode:" + h7Var.c);
                za.d().b(53, this.a, map2);
                return;
            }
            if (h7Var.c == -4) {
                za.d().c(20, this.a, map);
            } else {
                za.d().c(19, this.a, map);
            }
        }
    }
}
