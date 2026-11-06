package com.bytedance.sdk.openadsdk.core.y;

import com.bytedance.sdk.openadsdk.core.pc;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ka implements com.bytedance.sdk.openadsdk.u.ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    pc f3798ms;

    public ka(pc pcVar) {
        this.f3798ms = pcVar;
    }

    @Override // com.bytedance.sdk.openadsdk.u.ah
    public void ms(String str, JSONObject jSONObject) {
        pc pcVar = this.f3798ms;
        if (pcVar != null) {
            pcVar.ms(str, jSONObject);
        }
    }
}
