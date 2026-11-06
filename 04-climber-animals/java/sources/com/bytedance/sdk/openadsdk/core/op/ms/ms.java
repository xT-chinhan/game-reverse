package com.bytedance.sdk.openadsdk.core.op.ms;

import com.bytedance.sdk.openadsdk.core.re;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms {
    protected boolean ah(int i) {
        return i == 2 || i == 3;
    }

    protected boolean xr(int i) {
        return i == 0 || i == 1;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    public int ms(int i) {
        int iOptInt;
        JSONObject jSONObjectQr = re.xr().qr();
        if (jSONObjectQr == null) {
            iOptInt = -1;
        } else if (xr(i)) {
            iOptInt = jSONObjectQr.optInt("explicit_interval", 0);
        } else if (ah(i)) {
            iOptInt = jSONObjectQr.optInt("ambiguous_interval", 0);
        } else {
            iOptInt = -1;
        }
        if (iOptInt > 86400000) {
            return 86400000;
        }
        return iOptInt;
    }

    protected void ms(int i, long j, long j2) {
        com.bytedance.sdk.openadsdk.core.op.ms msVarMs = com.bytedance.sdk.openadsdk.core.op.ms.ms();
        msVarMs.ms(i);
        msVarMs.ms(j, j2);
    }

    protected int ms(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optInt("delay", 200);
        }
        return 200;
    }
}
