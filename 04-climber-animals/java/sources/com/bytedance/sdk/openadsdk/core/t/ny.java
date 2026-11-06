package com.bytedance.sdk.openadsdk.core.t;

import android.content.Context;
import android.os.Looper;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.re;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ny implements com.bytedance.sdk.component.x.ms.d {
    @Override // com.bytedance.sdk.component.x.ms.d
    public boolean ah() {
        return false;
    }

    @Override // com.bytedance.sdk.component.x.ms.d
    public boolean ch() {
        return true;
    }

    @Override // com.bytedance.sdk.component.x.ms.d
    public String d() {
        return "csj_";
    }

    @Override // com.bytedance.sdk.component.x.ms.d
    public boolean ub() {
        return false;
    }

    @Override // com.bytedance.sdk.component.x.ms.d
    public int x() {
        return 0;
    }

    @Override // com.bytedance.sdk.component.x.ms.d
    public com.bytedance.sdk.component.x.xr.ah zb() {
        return null;
    }

    @Override // com.bytedance.sdk.component.x.ms.d
    public boolean ms() {
        return re.xr().nw();
    }

    @Override // com.bytedance.sdk.component.x.ms.d
    public Looper xr() {
        return com.bytedance.sdk.component.ch.xr.ms.ms().xr().getLooper();
    }

    @Override // com.bytedance.sdk.component.x.ms.d
    public com.bytedance.sdk.component.x.ms.xr ms(JSONObject jSONObject) {
        try {
            jSONObject.put("is_new", true);
            jSONObject.put("sdk_session_id", xr.f3363ms);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
        com.bytedance.sdk.component.x.xr.d.ms.ms msVar = new com.bytedance.sdk.component.x.xr.d.ms.ms(UUID.randomUUID().toString(), com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("new_adlog_monitor").xr(jSONObject.toString()).ms());
        msVar.ah((byte) 0);
        msVar.xr((byte) 2);
        msVar.ms((byte) 1);
        return msVar;
    }

    @Override // com.bytedance.sdk.component.x.ms.d
    public boolean ka() {
        return com.bytedance.sdk.openadsdk.core.g.ny.ms();
    }

    @Override // com.bytedance.sdk.component.x.ms.d
    public boolean ms(Context context) {
        return com.bytedance.sdk.component.utils.u.ms(context);
    }

    @Override // com.bytedance.sdk.component.x.ms.d
    public String hi() {
        return f.ab();
    }

    @Override // com.bytedance.sdk.component.x.ms.d
    public com.bytedance.sdk.component.x.ms.ms.xr sl() {
        return new ch(com.bytedance.sdk.openadsdk.core.re.ka.ms().xr().ah());
    }

    @Override // com.bytedance.sdk.component.x.ms.d
    /* JADX INFO: renamed from: ao, reason: merged with bridge method [inline-methods] */
    public ExecutorService c() {
        return com.bytedance.sdk.component.ch.ab.xr();
    }

    @Override // com.bytedance.sdk.component.x.ms.d
    public Executor ab() {
        return com.bytedance.sdk.component.ch.ab.ms();
    }

    @Override // com.bytedance.sdk.component.x.ms.d
    public String ms(String str) {
        return com.bytedance.sdk.component.utils.ms.ah(str);
    }

    @Override // com.bytedance.sdk.component.x.ms.d
    public String xr(String str) {
        return com.bytedance.sdk.component.utils.ms.xr(str);
    }

    @Override // com.bytedance.sdk.component.x.ms.d
    public boolean ny() {
        return re.xr().b();
    }

    @Override // com.bytedance.sdk.component.x.ms.d
    public com.bytedance.sdk.component.x.ms.x u() {
        return ms.f3314ms;
    }

    @Override // com.bytedance.sdk.component.x.ms.d
    public void ms(JSONObject jSONObject, JSONObject jSONObject2) {
        boolean zJ = re.xr().j();
        boolean z = false;
        if (jSONObject2 != null && jSONObject2.optInt("success") == 1) {
            z = true;
        }
        if (z && zJ) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.zb.ah.ms(jSONObject, jSONObject2);
    }
}
