package com.bytedance.sdk.openadsdk.core.ugeno.ah;

import android.content.Context;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.adsdk.ugeno.ah.ao;
import com.bytedance.adsdk.ugeno.ah.sl;
import com.bytedance.adsdk.ugeno.ah.ub;
import com.bytedance.adsdk.ugeno.ah.zb;
import com.bytedance.adsdk.ugeno.ka.c;
import com.bytedance.sdk.openadsdk.core.nw;
import com.bytedance.sdk.openadsdk.core.ugeno.ab.ab;
import com.bytedance.sdk.openadsdk.core.zb.ka;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements ao, ub {
    private int ab;
    private com.bytedance.adsdk.ugeno.xr.ah<View> ah;
    private String c;
    private ms d;
    private ao ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Context f3410ms;
    private ka xr;

    interface ms {
        void ms(zb zbVar);
    }

    @Override // com.bytedance.adsdk.ugeno.ah.ub
    public void ms(com.bytedance.adsdk.ugeno.xr.ah ahVar, String str, c.ms msVar) {
    }

    public xr(Context context, ka kaVar, String str, int i) {
        this.f3410ms = context;
        this.xr = kaVar;
        this.c = str;
        this.ab = i;
    }

    public void ms(ms msVar) {
        this.d = msVar;
    }

    public void ms(ao aoVar) {
        this.ka = aoVar;
    }

    public void ms(final JSONObject jSONObject, final JSONObject jSONObject2, final ab abVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            xr(jSONObject, jSONObject2, abVar);
        } else {
            nw.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ah.xr.1
                @Override // java.lang.Runnable
                public void run() {
                    xr.this.xr(jSONObject, jSONObject2, abVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(JSONObject jSONObject, JSONObject jSONObject2, ab abVar) {
        sl slVar = new sl(this.f3410ms);
        com.bytedance.adsdk.ugeno.xr.ah<View> ahVarMs = slVar.ms(jSONObject);
        this.ah = ahVarMs;
        if (ahVarMs == null) {
            ka kaVar = this.xr;
            if (kaVar != null) {
                kaVar.ms(-1, "ugeno render fail");
            }
            if (abVar != null) {
                abVar.ms(-1, "");
                return;
            }
            return;
        }
        slVar.ms((ao) this);
        slVar.ms((ub) this);
        slVar.xr(jSONObject2);
        this.xr.ms(0L);
        if (abVar != null) {
            abVar.ms(this.ah);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ah.ub
    public void ms(zb zbVar, ub.xr xrVar, ub.ms msVar) {
        ms msVar2;
        if (zbVar == null || zbVar.xr() != 1 || (msVar2 = this.d) == null) {
            return;
        }
        msVar2.ms(zbVar);
    }

    @Override // com.bytedance.adsdk.ugeno.ah.ao
    public void ms(com.bytedance.adsdk.ugeno.xr.ah ahVar, MotionEvent motionEvent) {
        ao aoVar = this.ka;
        if (aoVar != null) {
            aoVar.ms(ahVar, motionEvent);
        }
    }
}
