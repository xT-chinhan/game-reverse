package com.bytedance.sdk.openadsdk.core.h.ms;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class op extends com.bytedance.sdk.component.ms.d<JSONObject, JSONObject> {
    private com.bytedance.sdk.openadsdk.core.qv.ka ah;
    private long d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private WeakReference<com.bytedance.sdk.openadsdk.core.pc> f2548ms;
    private lm xr;

    @Override // com.bytedance.sdk.component.ms.d
    protected void d() {
    }

    public static void ms(com.bytedance.sdk.component.ms.h hVar, final com.bytedance.sdk.openadsdk.core.pc pcVar, final lm lmVar) {
        hVar.ms("requestVideoDelayCallback", new com.bytedance.sdk.component.ms.d.xr() { // from class: com.bytedance.sdk.openadsdk.core.h.ms.op.1
            @Override // com.bytedance.sdk.component.ms.d.xr
            public com.bytedance.sdk.component.ms.d ms() {
                return new op(pcVar, lmVar);
            }
        });
    }

    public op(com.bytedance.sdk.openadsdk.core.pc pcVar, lm lmVar) {
        this.f2548ms = new WeakReference<>(pcVar);
        this.xr = lmVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.ms.d
    public void ms(JSONObject jSONObject, com.bytedance.sdk.component.ms.c cVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.pc pcVar = this.f2548ms.get();
        if (pcVar == null || jSONObject == null) {
            ah();
            return;
        }
        this.ah = new com.bytedance.sdk.openadsdk.core.qv.ka() { // from class: com.bytedance.sdk.openadsdk.core.h.ms.op.2
            @Override // com.bytedance.sdk.openadsdk.core.qv.ka
            public void ms() {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.h.ms.op.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            op.this.ms(new JSONObject());
                        } catch (Exception e) {
                            com.bytedance.sdk.component.utils.sl.d("requestVideoDelay", e.getMessage());
                        }
                    }
                }, op.this.d);
            }
        };
        int iOptInt = jSONObject.optInt("delay", -1);
        if (iOptInt < 0) {
            return;
        }
        this.d = iOptInt;
        if (pcVar.ah() != null && pcVar.ah().F_()) {
            this.ah.ms();
        } else {
            pcVar.ms(this.ah);
        }
    }
}
