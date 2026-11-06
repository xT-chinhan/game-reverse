package com.bytedance.sdk.openadsdk.core.jw;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    public interface ms {
        void ms();

        void ms(com.bytedance.sdk.openadsdk.core.re.ms.xr xrVar, com.bytedance.sdk.component.c.hi hiVar);
    }

    public static void ms(com.bytedance.sdk.openadsdk.zb.xr xrVar, int i, int i2, final ms msVar, String str, int i3, com.bytedance.sdk.component.c.u uVar, boolean z) {
        com.bytedance.sdk.component.utils.sl.d("splashLoadAd", " getImageBytes url ".concat(String.valueOf(xrVar)));
        com.bytedance.sdk.openadsdk.core.re.ka.ms().ah().ms(xrVar, new com.bytedance.sdk.openadsdk.core.re.ms.ms.xr() { // from class: com.bytedance.sdk.openadsdk.core.jw.h.1
            @Override // com.bytedance.sdk.openadsdk.core.re.ms.ms.xr
            public void ms(com.bytedance.sdk.component.c.hi hiVar, com.bytedance.sdk.openadsdk.core.re.ms.xr xrVar2) {
                ms msVar2;
                if (xrVar2.d() && (msVar2 = msVar) != null) {
                    msVar2.ms(xrVar2, hiVar);
                    return;
                }
                ms msVar3 = msVar;
                if (msVar3 != null) {
                    msVar3.ms();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.re.ms.ms.xr
            public void ms(int i4, String str2, Throwable th) {
                ms msVar2 = msVar;
                if (msVar2 != null) {
                    msVar2.ms();
                }
            }
        }, i, i2, str, i3, uVar, z);
    }

    public static Drawable ms(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return new ColorDrawable(0);
        }
        try {
            return new BitmapDrawable(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
        } catch (Throwable unused) {
            return new ColorDrawable(0);
        }
    }
}
