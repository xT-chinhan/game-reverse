package com.bytedance.sdk.openadsdk.core.ka.d;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    private final ka ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final d f2777ms = new d(7);
    private static final d xr = new d(8);
    private static final d ah = new d(3);
    private static final d d = new d(0);

    private d(int i) {
        this.ka = new ka(i);
    }

    public static d ms(int i) {
        if (i == 3) {
            return ah;
        }
        if (i == 7) {
            return f2777ms;
        }
        if (i == 8) {
            return xr;
        }
        return d;
    }

    public void ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, lm lmVar, boolean z) {
        if (xrVar == null || lmVar == null) {
            return;
        }
        if ((lmVar.br() != null ? lmVar.br().optInt("save_type") : 0) == 1) {
            return;
        }
        String strD = xrVar.d();
        String strXr = com.bytedance.sdk.component.utils.ms.xr(lmVar.rm().toString());
        this.ka.ms(strD, new ka.xr(strXr, lmVar.bk(), lmVar.no() * 1000, lmVar.wg()), z, ((((System.currentTimeMillis() / 1000) / 60) / 60) / 3) + ((long) f.ub(lmVar)));
    }

    public lm ms(String str, boolean z, long j) {
        System.currentTimeMillis();
        ka.xr xrVarMs = this.ka.ms(str, z, j);
        if (xrVarMs == null) {
            System.currentTimeMillis();
            return null;
        }
        System.currentTimeMillis();
        try {
            lm lmVarMs = com.bytedance.sdk.openadsdk.core.ms.ms(new JSONObject(com.bytedance.sdk.component.utils.ms.ah(xrVarMs.ah)));
            lmVarMs.x(true);
            lmVarMs.az(101);
            lmVarMs.c(xrVarMs.f2784ms);
            lmVarMs.i(xrVarMs.ka);
            return lmVarMs;
        } catch (Exception unused) {
            return null;
        }
    }

    public void ms(String str) {
        this.ka.ms(str);
    }

    public void xr(String str) {
        this.ka.xr(str);
    }

    public void ah(String str) {
        this.ka.ah(str);
    }

    public void ms(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.ka.ms(str, str2);
    }

    public void ms(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.ka.ms(str, str2, z);
    }

    public void ms() {
        this.ka.ms();
    }

    public static boolean ms(lm lmVar) {
        if (lmVar == null) {
            return false;
        }
        return (lmVar.br() != null ? lmVar.br().optInt("save_type") : 0) != 1;
    }
}
