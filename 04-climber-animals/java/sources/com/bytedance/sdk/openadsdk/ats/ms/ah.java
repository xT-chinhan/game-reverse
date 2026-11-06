package com.bytedance.sdk.openadsdk.ats.ms;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;

/* JADX INFO: loaded from: classes2.dex */
public class ah implements com.bytedance.sdk.component.d.ah {
    private xr xr = new xr();
    private ms ah = new ms();

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private boolean f1833ms = !this.xr.ms();

    @Override // com.bytedance.sdk.component.d.ah
    @ATSMethod(1)
    public String ms(String str) {
        String strMs = this.xr.ms() ? this.xr.ms(str) : "";
        return (this.f1833ms && TextUtils.isEmpty(strMs)) ? this.ah.ms(str) : strMs;
    }

    @Override // com.bytedance.sdk.component.d.ah
    @ATSMethod(2)
    public int xr(String str) {
        int iXr = this.xr.ms() ? this.xr.xr(str) : Integer.MAX_VALUE;
        return (this.f1833ms && iXr == Integer.MAX_VALUE) ? this.ah.xr(str) : iXr;
    }

    @Override // com.bytedance.sdk.component.d.ah
    @ATSMethod(3)
    public long ah(String str) {
        long jAh = this.xr.ms() ? this.xr.ah(str) : Long.MAX_VALUE;
        return (this.f1833ms && jAh == 2147483647L) ? this.ah.ah(str) : jAh;
    }

    @Override // com.bytedance.sdk.component.d.ah
    @ATSMethod(4)
    public boolean d(String str) {
        boolean zD = this.xr.ms() ? this.xr.d(str) : false;
        return (!this.f1833ms || zD) ? zD : this.ah.d(str);
    }

    @Override // com.bytedance.sdk.component.d.ah
    @ATSMethod(5)
    public void ms(String str, String str2) {
        if (this.xr.ms()) {
            this.xr.ms(str, str2);
        }
    }
}
