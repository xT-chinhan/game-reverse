package com.bykv.vk.openvk.component.video.ms.xr.ka;

import android.text.TextUtils;
import com.bytedance.sdk.component.xr.ms.ao;
import com.bytedance.sdk.component.xr.ms.sl;
import com.bytedance.sdk.component.xr.ms.u;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class d implements xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private sl f85ms;

    public d() {
        this.f85ms = null;
        this.f85ms = com.bykv.vk.openvk.component.video.api.ah.ah();
    }

    @Override // com.bykv.vk.openvk.component.video.ms.xr.ka.xr
    public ms ms(ka kaVar) throws IOException {
        u.ms msVar = new u.ms();
        try {
            if (kaVar.ka != null) {
                for (Map.Entry<String, String> entry : kaVar.ka.entrySet()) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        String value = entry.getValue();
                        if (value == null) {
                            value = "";
                        }
                        msVar.xr(key, value);
                    }
                }
            }
            ao aoVarMs = this.f85ms.ms(msVar.ms(kaVar.xr).ms().xr()).ms();
            com.bykv.vk.openvk.component.video.api.c.ah.ms("NetworkSoureVolleyImpl", "response code = ", Integer.valueOf(aoVarMs.ah()));
            return new c(aoVarMs, kaVar);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
            return null;
        }
    }
}
