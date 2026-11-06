package com.bytedance.sdk.openadsdk.core.dislike;

import android.content.Context;
import com.bytedance.sdk.openadsdk.ao.xr.xr.c;
import com.bytedance.sdk.openadsdk.core.dislike.ms.d;
import com.bytedance.sdk.openadsdk.core.jw.ul;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static com.bytedance.sdk.openadsdk.core.dislike.ms.ah f2470ms;
    private static d xr;

    public static void ms() {
        if (xr == null) {
            xr = new d() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ms.1
                @Override // com.bytedance.sdk.openadsdk.core.dislike.ms.d
                public int ms(Context context, float f) {
                    return ul.ah(context, f);
                }
            };
        }
        if (f2470ms == null) {
            f2470ms = new com.bytedance.sdk.openadsdk.core.dislike.ms.ah() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ms.2
                @Override // com.bytedance.sdk.openadsdk.core.dislike.ms.ah
                public void ms(com.bytedance.sdk.openadsdk.core.dislike.ah.xr xrVar, c cVar) {
                    com.bytedance.sdk.openadsdk.core.zb.ah.ms(xrVar, cVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.dislike.ms.ah
                public void ms(Context context, com.bytedance.sdk.openadsdk.core.dislike.ah.xr xrVar, String str) {
                    com.bytedance.sdk.openadsdk.core.zb.ah.ms(xrVar.ah(), xrVar.d(), xrVar.ab(), str);
                }
            };
        }
        com.bytedance.sdk.openadsdk.core.dislike.ms.ms.ms(f2470ms, xr);
    }
}
