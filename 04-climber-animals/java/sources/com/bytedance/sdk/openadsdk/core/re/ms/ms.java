package com.bytedance.sdk.openadsdk.core.re.ms;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.sdk.component.c.ao;
import com.bytedance.sdk.component.c.hi;
import com.bytedance.sdk.component.c.u;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    public interface xr {
        void ms(int i, String str, Throwable th);

        void ms(hi hiVar, com.bytedance.sdk.openadsdk.core.re.ms.xr xrVar);
    }

    protected void ms() {
    }

    public void ms(com.bytedance.sdk.openadsdk.zb.xr xrVar, xr xrVar2, int i, int i2, String str) {
        ms(xrVar, xrVar2, i, i2, ImageView.ScaleType.CENTER_INSIDE, str);
    }

    public void ms(com.bytedance.sdk.openadsdk.zb.xr xrVar, xr xrVar2, int i, int i2, String str, int i3, u uVar, boolean z) {
        ms(xrVar, xrVar2, i, i2, ImageView.ScaleType.CENTER_INSIDE, str, i3, uVar, z);
    }

    public void ms(com.bytedance.sdk.openadsdk.zb.xr xrVar, final xr xrVar2, int i, int i2, ImageView.ScaleType scaleType, String str) {
        com.bytedance.sdk.openadsdk.x.xr.ms(xrVar.f4318ms).xr(xrVar.xr).ms(i).xr(i2).ah(str).ms(Bitmap.Config.RGB_565).ms(scaleType).xr(!TextUtils.isEmpty(str)).ms(new ao() { // from class: com.bytedance.sdk.openadsdk.core.re.ms.ms.1
            @Override // com.bytedance.sdk.component.c.ao
            @ATSMethod(1)
            public void ms(hi hiVar) {
                ms.this.ms(hiVar, xrVar2);
            }

            @Override // com.bytedance.sdk.component.c.ao
            @ATSMethod(2)
            public void ms(int i3, String str2, Throwable th) {
                ms.this.ms(i3, str2, th, xrVar2);
            }
        });
        ms();
    }

    public void ms(com.bytedance.sdk.openadsdk.zb.xr xrVar, final xr xrVar2, int i, int i2, ImageView.ScaleType scaleType, String str, int i3, u uVar, boolean z) {
        com.bytedance.sdk.openadsdk.x.xr.ms(xrVar.f4318ms).xr(xrVar.xr).ms(i).xr(i2).ah(str).ms(Bitmap.Config.RGB_565).ms(scaleType).ms(uVar).ms(z).xr(!TextUtils.isEmpty(str)).ms(new ao() { // from class: com.bytedance.sdk.openadsdk.core.re.ms.ms.2
            @Override // com.bytedance.sdk.component.c.ao
            @ATSMethod(1)
            public void ms(hi hiVar) {
                ms.this.ms(hiVar, xrVar2);
            }

            @Override // com.bytedance.sdk.component.c.ao
            @ATSMethod(2)
            public void ms(int i4, String str2, Throwable th) {
                ms.this.ms(i4, str2, th, xrVar2);
            }
        }, i3);
        ms();
    }

    protected void ms(hi hiVar, xr xrVar) {
        if (xrVar != null) {
            Object objAh = hiVar.ah();
            int iMs = ms(hiVar);
            if (objAh instanceof byte[]) {
                xrVar.ms(hiVar, new com.bytedance.sdk.openadsdk.core.re.ms.xr((byte[]) objAh, iMs));
            } else if (objAh instanceof Bitmap) {
                xrVar.ms(hiVar, new com.bytedance.sdk.openadsdk.core.re.ms.xr((Bitmap) objAh, iMs));
            } else {
                xrVar.ms(0, "not bitmap or gif result!", null);
            }
        }
    }

    private int ms(hi hiVar) {
        Map<String, String> mapAb = hiVar.ab();
        if (mapAb == null) {
            return 0;
        }
        try {
            String str = mapAb.get("image_size");
            if (str == null || !(str instanceof String)) {
                return 0;
            }
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            return 0;
        }
    }

    protected void ms(int i, String str, Throwable th, xr xrVar) {
        if (xrVar != null) {
            xrVar.ms(i, str, th);
        }
    }

    public static C0305ms xr() {
        return new C0305ms();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.re.ms.ms$ms, reason: collision with other inner class name */
    public static class C0305ms implements xr {
        @Override // com.bytedance.sdk.openadsdk.core.re.ms.ms.xr
        public void ms(int i, String str, Throwable th) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.re.ms.ms.xr
        public void ms(hi hiVar, com.bytedance.sdk.openadsdk.core.re.ms.xr xrVar) {
        }

        C0305ms() {
        }
    }
}
