package com.bytedance.sdk.openadsdk.ny.ms;

import com.bytedance.sdk.component.ms.h;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.pc;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d extends com.bytedance.sdk.component.ms.d<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private WeakReference<pc> f4066ms;

    @Override // com.bytedance.sdk.component.ms.d
    protected void d() {
    }

    public static void ms(h hVar, final pc pcVar) {
        hVar.ms("adInfoDialog", new com.bytedance.sdk.component.ms.d.xr() { // from class: com.bytedance.sdk.openadsdk.ny.ms.d.1
            @Override // com.bytedance.sdk.component.ms.d.xr
            public com.bytedance.sdk.component.ms.d ms() {
                return new d(pcVar);
            }
        });
    }

    public d(pc pcVar) {
        this.f4066ms = new WeakReference<>(pcVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.ms.d
    public void ms(JSONObject jSONObject, com.bytedance.sdk.component.ms.c cVar) throws Exception {
        lm lmVarX;
        ch.ub().fm();
        pc pcVar = this.f4066ms.get();
        if (pcVar == null || (lmVarX = pcVar.x()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.jw.c.ms(cVar.getContext(), lmVarX.zg());
    }
}
