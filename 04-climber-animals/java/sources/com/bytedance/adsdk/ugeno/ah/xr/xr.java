package com.bytedance.adsdk.ugeno.ah.xr;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.ah.ch;
import com.bytedance.adsdk.ugeno.ah.ub;
import com.bytedance.adsdk.ugeno.ah.zb;
import com.bytedance.adsdk.ugeno.c.ny;
import com.bytedance.sdk.component.utils.sl;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements ny.ms {
    private Context ah;
    private Handler c = new ny(Looper.getMainLooper(), this);
    private zb d;
    private com.bytedance.adsdk.ugeno.xr.ah ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f345ms;
    private ub xr;

    public xr(Context context, zb zbVar, com.bytedance.adsdk.ugeno.xr.ah ahVar) {
        this.ah = context;
        this.d = zbVar;
        this.ka = ahVar;
    }

    public void ms(ub ubVar) {
        this.xr = ubVar;
    }

    public void ms() {
        zb zbVar = this.d;
        if (zbVar == null) {
            return;
        }
        try {
            int i = Integer.parseInt(com.bytedance.adsdk.ugeno.d.xr.ms(zbVar.ah().optString("delay"), this.ka.ch()));
            this.f345ms = i;
            this.c.sendEmptyMessageDelayed(1001, i);
        } catch (NumberFormatException e) {
            sl.ms(e);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.c.ny.ms
    public void ms(Message message) {
        if (message.what != 1001) {
            return;
        }
        JSONObject jSONObjectAh = this.d.ah();
        if (TextUtils.equals(jSONObjectAh.optString("type"), "onAnimation")) {
            String strOptString = jSONObjectAh.optString("nodeId");
            com.bytedance.adsdk.ugeno.xr.ah ahVar = this.ka;
            com.bytedance.adsdk.ugeno.xr.ah ahVarAh = ahVar.xr(ahVar).ah(strOptString);
            new ch(ahVarAh.ny(), com.bytedance.adsdk.ugeno.ah.ms.ms(jSONObjectAh.optJSONObject("animatorSet"), ahVarAh)).ms();
        } else {
            ub ubVar = this.xr;
            if (ubVar != null) {
                zb zbVar = this.d;
                com.bytedance.adsdk.ugeno.xr.ah ahVar2 = this.ka;
                ubVar.ms(zbVar, ahVar2, ahVar2);
            }
        }
        this.c.removeMessages(1001);
    }
}
