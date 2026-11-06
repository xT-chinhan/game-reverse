package com.bytedance.sdk.component.xr.ms.ms.ms;

import com.bytedance.sdk.component.ah.xr.i;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements ms {
    @Override // com.bytedance.sdk.component.xr.ms.ms.ms.ms
    public void ms(com.bytedance.sdk.component.ah.xr.ka kaVar, InetSocketAddress inetSocketAddress, Proxy proxy, i iVar, IOException iOException) {
        try {
            ((com.bytedance.sdk.component.d.ms) AutoService.ms(com.bytedance.sdk.component.d.ms.class)).ms("okhttp_connectFailed", ms(kaVar), iOException);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.xr.ms.ms.ms.ms
    public void ms(com.bytedance.sdk.component.ah.xr.ka kaVar, IOException iOException) {
        try {
            ((com.bytedance.sdk.component.d.ms) AutoService.ms(com.bytedance.sdk.component.d.ms.class)).ms("okhttp_callFailed", ms(kaVar), iOException);
        } catch (Exception unused) {
        }
    }

    private JSONObject ms(com.bytedance.sdk.component.ah.xr.ka kaVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("url", xr(kaVar));
        return jSONObject;
    }

    private String xr(com.bytedance.sdk.component.ah.xr.ka kaVar) throws NullPointerException {
        return kaVar.ms().ms().toString();
    }
}
