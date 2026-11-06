package com.bytedance.adsdk.ugeno.ah.xr;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.adsdk.ugeno.ah.ub;
import com.bytedance.adsdk.ugeno.ah.zb;
import com.bytedance.adsdk.ugeno.c.ny;
import com.bytedance.sdk.component.utils.sl;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c implements ny.ms {
    private Handler ab = new ny(Looper.getMainLooper(), this);
    private ub ah;
    private com.bytedance.adsdk.ugeno.xr.ah c;
    private Context d;
    private zb ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private boolean f341ms;
    private int xr;

    public c(Context context, zb zbVar, com.bytedance.adsdk.ugeno.xr.ah ahVar) {
        this.d = context;
        this.ka = zbVar;
        this.c = ahVar;
    }

    public void ms(ub ubVar) {
        this.ah = ubVar;
    }

    public void ms() {
        zb zbVar = this.ka;
        if (zbVar == null) {
            return;
        }
        JSONObject jSONObjectAh = zbVar.ah();
        try {
            this.xr = Integer.parseInt(com.bytedance.adsdk.ugeno.d.xr.ms(jSONObjectAh.optString("interval", "8000"), this.c.ch()));
            this.f341ms = jSONObjectAh.optBoolean("repeat");
            this.ab.sendEmptyMessageDelayed(1001, this.xr);
        } catch (NumberFormatException e) {
            sl.ms(e);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.c.ny.ms
    public void ms(Message message) {
        if (message.what != 1001) {
            return;
        }
        ub ubVar = this.ah;
        if (ubVar != null) {
            zb zbVar = this.ka;
            com.bytedance.adsdk.ugeno.xr.ah ahVar = this.c;
            ubVar.ms(zbVar, ahVar, ahVar);
        }
        if (this.f341ms) {
            this.ab.sendEmptyMessageDelayed(1001, this.xr);
        } else {
            this.ab.removeMessages(1001);
        }
    }
}
