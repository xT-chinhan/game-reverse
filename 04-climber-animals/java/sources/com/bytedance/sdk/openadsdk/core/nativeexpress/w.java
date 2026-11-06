package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.nw.lm;

/* JADX INFO: loaded from: classes2.dex */
public class w extends re {
    public w(Context context, lm lmVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        super(context, lmVar, xrVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.re
    public void ms(Context context, lm lmVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        this.f2987ms = new NativeExpressVideoView(context, lmVar, xrVar, "embeded_ad");
        ms(this.f2987ms, this.ah);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xr, com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public void ms(final com.bytedance.sdk.openadsdk.w.ms.xr.ms.ah ahVar) {
        if (this.f2987ms != null) {
            this.f2987ms.setVideoAdListener(new com.bykv.vk.openvk.component.video.api.d.ah.d() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.w.1
                @Override // com.bykv.vk.openvk.component.video.api.d.ah.d
                public void D_() {
                    com.bytedance.sdk.openadsdk.w.ms.xr.ms.ah ahVar2 = ahVar;
                    if (ahVar2 != null) {
                        ahVar2.ms();
                    }
                }

                @Override // com.bykv.vk.openvk.component.video.api.d.ah.d
                public void ms(int i, int i2) {
                    com.bytedance.sdk.openadsdk.w.ms.xr.ms.ah ahVar2 = ahVar;
                    if (ahVar2 != null) {
                        ahVar2.ms(i, i2);
                    }
                }
            });
            this.f2987ms.setVideoAdInteractionListener(new com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.w.2
                @Override // com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah
                public void o_() {
                    com.bytedance.sdk.openadsdk.w.ms.xr.ms.ah ahVar2 = ahVar;
                    if (ahVar2 != null) {
                        ahVar2.xr();
                    }
                }

                @Override // com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah
                public void p_() {
                    com.bytedance.sdk.openadsdk.w.ms.xr.ms.ah ahVar2 = ahVar;
                    if (ahVar2 != null) {
                        ahVar2.ah();
                    }
                }

                @Override // com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah
                public void q_() {
                    com.bytedance.sdk.openadsdk.w.ms.xr.ms.ah ahVar2 = ahVar;
                    if (ahVar2 != null) {
                        ahVar2.d();
                    }
                }

                @Override // com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah
                public void ms(long j, long j2) {
                    com.bytedance.sdk.openadsdk.w.ms.xr.ms.ah ahVar2 = ahVar;
                    if (ahVar2 != null) {
                        ahVar2.ms(j, j2);
                    }
                }

                @Override // com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah
                public void C_() {
                    com.bytedance.sdk.openadsdk.w.ms.xr.ms.ah ahVar2 = ahVar;
                    if (ahVar2 != null) {
                        ahVar2.ka();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xr
    public com.bytedance.sdk.openadsdk.core.multipro.xr.ms hi() {
        if (this.ka != null && this.ka.get() != null) {
            return this.ka.get().getVideoModel();
        }
        if (!(this.f2987ms instanceof NativeExpressVideoView)) {
            return null;
        }
        ((NativeExpressVideoView) this.f2987ms).ub();
        return ((NativeExpressVideoView) this.f2987ms).getVideoModel();
    }
}
