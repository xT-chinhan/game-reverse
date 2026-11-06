package com.bytedance.sdk.openadsdk.ny.ms;

import com.bytedance.sdk.component.ms.h;
import com.bytedance.sdk.openadsdk.core.pc;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class xr extends com.bytedance.sdk.component.ms.d<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static WeakReference<ms> f4072ms;
    private WeakReference<pc> xr;

    public interface ms {
        void ms();

        void ms(int i);
    }

    @Override // com.bytedance.sdk.component.ms.d
    protected void d() {
    }

    private xr(pc pcVar) {
        this.xr = new WeakReference<>(pcVar);
    }

    public static void ms(h hVar, final pc pcVar) {
        hVar.ms("onClickBrowseCloseCallback", new com.bytedance.sdk.component.ms.d.xr() { // from class: com.bytedance.sdk.openadsdk.ny.ms.xr.1
            @Override // com.bytedance.sdk.component.ms.d.xr
            public com.bytedance.sdk.component.ms.d ms() {
                return new xr(pcVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.ms.d
    public void ms(JSONObject jSONObject, com.bytedance.sdk.component.ms.c cVar) throws Exception {
        WeakReference<ms> weakReference = f4072ms;
        ms msVar = weakReference != null ? weakReference.get() : null;
        if (this.xr == null || jSONObject == null) {
            if (msVar != null) {
                msVar.ms();
                return;
            }
            return;
        }
        int iOptInt = jSONObject.optInt("remainTime", Integer.MIN_VALUE);
        if (iOptInt == Integer.MIN_VALUE) {
            if (msVar != null) {
                msVar.ms();
            }
        } else if (msVar != null) {
            msVar.ms(iOptInt);
        }
    }

    public static void ms(ms msVar) {
        f4072ms = new WeakReference<>(msVar);
    }
}
