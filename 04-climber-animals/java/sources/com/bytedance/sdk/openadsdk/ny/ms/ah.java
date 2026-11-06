package com.bytedance.sdk.openadsdk.ny.ms;

import com.bytedance.sdk.component.ms.h;
import com.bytedance.sdk.openadsdk.core.pc;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends com.bytedance.sdk.component.ms.ka<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private WeakReference<pc> f4064ms;

    public static void ms(h hVar, pc pcVar) {
        hVar.ms("rewardPlayAgain", (com.bytedance.sdk.component.ms.ka<?, ?>) new ah(pcVar));
    }

    @Override // com.bytedance.sdk.component.ms.ka
    public JSONObject ms(JSONObject jSONObject, com.bytedance.sdk.component.ms.c cVar) throws Exception {
        pc pcVar;
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<pc> weakReference = this.f4064ms;
        if (weakReference == null || weakReference.get() == null || (pcVar = this.f4064ms.get()) == null) {
            return jSONObject2;
        }
        pcVar.h();
        return jSONObject2;
    }

    public ah(pc pcVar) {
        this.f4064ms = new WeakReference<>(pcVar);
    }
}
