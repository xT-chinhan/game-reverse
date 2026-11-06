package com.bytedance.adsdk.ugeno.ah.ms;

import com.bytedance.adsdk.ugeno.ah.ub;
import com.bytedance.adsdk.ugeno.ah.zb;
import com.bytedance.adsdk.ugeno.ka.c;
import com.bytedance.adsdk.ugeno.xr.ah;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class xr implements ub {
    protected JSONObject d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected ub f333ms;
    protected String xr;
    protected boolean ah = true;
    protected boolean ka = false;

    public abstract void ah(zb zbVar, ub.xr xrVar, ub.ms msVar);

    public xr(ub ubVar) {
        this.f333ms = ubVar;
    }

    public void ms(JSONObject jSONObject) {
        this.d = jSONObject;
    }

    public void ms(String str) {
        this.xr = str;
    }

    public void ms(boolean z) {
        this.ah = z;
    }

    public boolean ms() {
        String str;
        return this.ah && (str = this.xr) != null && "3".compareTo(str) <= 0 && this.d != null;
    }

    public void xr(boolean z) {
        this.ka = z;
    }

    @Override // com.bytedance.adsdk.ugeno.ah.ub
    public void ms(zb zbVar, ub.xr xrVar, ub.ms msVar) {
        if (ms()) {
            ah(zbVar, xrVar, msVar);
        } else {
            xr(zbVar, xrVar, msVar);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ah.ub
    public void ms(ah ahVar, String str, c.ms msVar) {
        ub ubVar = this.f333ms;
        if (ubVar == null) {
            return;
        }
        ubVar.ms(ahVar, str, msVar);
    }

    protected void xr(zb zbVar, ub.xr xrVar, ub.ms msVar) {
        ub ubVar = this.f333ms;
        if (ubVar == null) {
            return;
        }
        ubVar.ms(zbVar, xrVar, msVar);
    }
}
