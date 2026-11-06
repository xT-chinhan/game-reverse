package com.bytedance.sdk.openadsdk.core.xr.ms.xr;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.op;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.nw;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.u;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.yu;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    private String ah;
    private final AtomicBoolean d = new AtomicBoolean(true);
    private xr ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final lm f3784ms;
    private final Context xr;

    public interface ms {
        void ms();
    }

    public interface xr {
        void ms();

        void ms(String str, boolean z);
    }

    public d(lm lmVar, Context context) {
        this.f3784ms = lmVar;
        this.xr = context;
    }

    public d ms(String str) {
        this.ah = str;
        return this;
    }

    public void ms(xr xrVar) {
        this.ka = xrVar;
    }

    public static boolean ms(lm lmVar, boolean z) {
        u uVarRn = lmVar != null ? lmVar.rn() : null;
        return uVarRn != null && uVarRn.ms(z);
    }

    public int ms(final ms msVar) {
        lm lmVar = this.f3784ms;
        u uVarRn = lmVar != null ? lmVar.rn() : null;
        ms(uVarRn);
        xr(uVarRn);
        nw.c().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xr.ms.xr.d.1
            @Override // java.lang.Runnable
            public void run() {
                ms msVar2 = msVar;
                if (msVar2 != null) {
                    msVar2.ms();
                }
            }
        }, 500L);
        return 1;
    }

    private void ms(u uVar) {
        if (uVar == null || TextUtils.isEmpty(uVar.d())) {
            return;
        }
        final String strD = uVar.d();
        com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xr.ms.xr.d.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    op.xr(d.this.xr.getApplicationContext(), strD, 0, 17, 0, 0);
                } catch (Throwable th) {
                    sl.ms(th);
                }
            }
        });
    }

    private void xr(final u uVar) {
        if (uVar == null) {
            return;
        }
        try {
            re.ms().ms(uVar.xr(), new yu.ah<com.bytedance.sdk.component.ny.xr>() { // from class: com.bytedance.sdk.openadsdk.core.xr.ms.xr.d.3
                @Override // com.bytedance.sdk.openadsdk.core.yu.ah
                public void ms(int i, String str) {
                    d.this.ms();
                    d.this.ah(uVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.yu.ah
                public void ms(com.bytedance.sdk.component.ny.xr xrVar) {
                    if (xrVar == null || !xrVar.x() || TextUtils.isEmpty(xrVar.d())) {
                        d.this.ms();
                        d.this.ah(uVar);
                    } else {
                        try {
                            d.this.ms(new JSONObject(xrVar.d()));
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
        } catch (Throwable th) {
            sl.ms(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms() {
        com.bytedance.sdk.openadsdk.core.zb.ah.xr(this.f3784ms, this.ah, 4);
        xr xrVar = this.ka;
        if (xrVar != null) {
            xrVar.ms("net_fail", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(JSONObject jSONObject) {
        try {
            if (jSONObject.has("is_apply_coupon")) {
                xr(jSONObject);
            }
        } catch (Throwable unused) {
            ms();
        }
    }

    private void xr(JSONObject jSONObject) {
        boolean zOptBoolean = jSONObject.optBoolean("is_apply_coupon");
        String strOptString = jSONObject.optString("error_type");
        if (zOptBoolean && "success".equals(strOptString)) {
            com.bytedance.sdk.openadsdk.core.zb.ah.xr(this.f3784ms, this.ah, 1);
        } else if (zOptBoolean && "has_applied".equals(strOptString)) {
            com.bytedance.sdk.openadsdk.core.zb.ah.xr(this.f3784ms, this.ah, 2);
        } else if (!zOptBoolean) {
            com.bytedance.sdk.openadsdk.core.zb.ah.xr(this.f3784ms, this.ah, 3);
        }
        if (this.ka != null) {
            if (zOptBoolean && "success".equals(strOptString)) {
                this.ka.ms();
            } else {
                this.ka.ms(strOptString, zOptBoolean);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(u uVar) {
        if (this.d.getAndSet(false)) {
            xr(uVar);
        }
    }
}
