package com.bytedance.sdk.openadsdk.ny.ms;

import com.bytedance.sdk.component.ms.h;
import com.bytedance.sdk.openadsdk.core.pc;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c extends com.bytedance.sdk.component.ms.ka<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private WeakReference<pc> f4065ms;

    public static void ms(h hVar, pc pcVar) {
        hVar.ms("startVideoTransform", (com.bytedance.sdk.component.ms.ka<?, ?>) new c(pcVar));
    }

    @Override // com.bytedance.sdk.component.ms.ka
    public JSONObject ms(JSONObject jSONObject, com.bytedance.sdk.component.ms.c cVar) throws Exception {
        pc pcVar;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<pc> weakReference = this.f4065ms;
        if (weakReference == null || weakReference.get() == null || jSONObject == null || (pcVar = this.f4065ms.get()) == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("videoInfo")) == null) {
            return jSONObject2;
        }
        pcVar.ms((float) jSONObjectOptJSONObject.optDouble("toX"), (float) jSONObjectOptJSONObject.optDouble("toY"), (float) jSONObjectOptJSONObject.optDouble("pivotX"), (float) jSONObjectOptJSONObject.optDouble("pivotY"), jSONObject.optInt("duration"));
        return jSONObject2;
    }

    public c(pc pcVar) {
        this.f4065ms = new WeakReference<>(pcVar);
    }
}
