package com.bytedance.sdk.openadsdk.core.component.splash.ah.ms;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.g;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import com.bytedance.sdk.openadsdk.core.nw.rt;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends ms {
    private int ab;
    private int c;
    private boolean ch;
    private int d;
    private com.bytedance.sdk.openadsdk.core.nw.ms hi;
    private com.bytedance.sdk.openadsdk.zb.xr ka;
    private int ny;
    private boolean sl;
    private com.bykv.vk.openvk.component.video.api.ah.ah x;
    private boolean zb;

    public xr(lm lmVar, boolean z) {
        if (lmVar == null) {
            return;
        }
        this.xr = lmVar;
        this.zb = z;
        this.sl = lmVar.fm() == 2;
        xr(lmVar);
    }

    private void xr(lm lmVar) {
        int iVl = lmVar.vl();
        lm.ms msVarSi = lmVar.si();
        rt rtVarPl = lmVar.pl();
        if (TextUtils.isEmpty(qr.ms(lmVar))) {
            this.d = 1;
        } else if (ah(lmVar)) {
            if (ms(msVarSi) || ms(rtVarPl)) {
                this.d = 2;
            } else {
                if (xr(msVarSi) || xr(rtVarPl)) {
                    lmVar.zb(1);
                }
                this.d = 1;
            }
        } else if (iVl == 1) {
            this.d = 1;
        } else {
            this.d = 2;
        }
        d(lmVar);
    }

    public boolean d() {
        return this.d == 2;
    }

    private boolean ms(lm.ms msVar) {
        return msVar != null && ms(msVar.x()) == 2;
    }

    private boolean ms(rt rtVar) {
        return rtVar != null && rtVar.ab() == 2;
    }

    private boolean xr(lm.ms msVar) {
        return msVar != null && ms(msVar.x()) == 0;
    }

    private boolean xr(rt rtVar) {
        return rtVar != null && rtVar.ab() == 0;
    }

    private int ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            return 0;
        }
    }

    private boolean ah(lm lmVar) {
        return lmVar.fm() == 2;
    }

    private void d(lm lmVar) {
        ka(lmVar);
        c(lmVar);
    }

    private void ka(lm lmVar) {
        g gVar;
        if (lmVar.fk() == null || (gVar = lmVar.fk().get(0)) == null) {
            return;
        }
        String strMs = gVar.ms();
        if (TextUtils.isEmpty(strMs)) {
            return;
        }
        this.c = gVar.xr();
        this.ab = gVar.ah();
        this.ka = new com.bytedance.sdk.openadsdk.zb.xr(strMs, gVar.ab());
    }

    private void c(lm lmVar) {
        this.x = qr.u(lmVar);
        this.ny = f.ny(lmVar);
        this.ch = lmVar.gx();
    }

    public com.bytedance.sdk.openadsdk.zb.xr ka() {
        return this.ka;
    }

    public int c() {
        return this.c;
    }

    public int ab() {
        return this.ab;
    }

    public com.bykv.vk.openvk.component.video.api.ah.ah x() {
        return this.x;
    }

    public int ny() {
        return this.ny;
    }

    public boolean ch() {
        return this.ch;
    }

    public int hi() {
        return this.d;
    }

    public com.bytedance.sdk.openadsdk.core.nw.ms sl() {
        return this.hi;
    }

    public void ms(com.bytedance.sdk.openadsdk.core.nw.ms msVar) {
        this.hi = msVar;
    }

    public boolean zb() {
        return this.sl;
    }

    public boolean u() {
        return this.zb;
    }

    public void ms(boolean z) {
        this.zb = z;
    }
}
