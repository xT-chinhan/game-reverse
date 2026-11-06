package com.bytedance.sdk.component.ab;

import android.content.Context;
import com.bytedance.sdk.openadsdk.ats.AutoService;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    public static class ms {
        private volatile int ah;
        private volatile int c;
        private volatile boolean d;
        private volatile boolean ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private volatile Context f749ms;
        private volatile String xr;

        public ms ms(Context context) {
            if (context == null) {
                return this;
            }
            this.f749ms = context.getApplicationContext();
            ah.ms(this.f749ms);
            return this;
        }

        public ms ms(String str) {
            this.xr = str;
            return this;
        }

        public ms ms(int i) {
            this.ah = i;
            return this;
        }

        public ms ms(boolean z) {
            this.d = z;
            return this;
        }

        public ms xr(int i) {
            this.c = i;
            return this;
        }

        public com.bytedance.sdk.component.d.ms.xr ms() {
            if (this.ah == 2) {
                return ah();
            }
            return xr();
        }

        private com.bytedance.sdk.component.d.ms.xr xr() {
            if (this.d) {
                return com.bytedance.sdk.component.ab.ah.ms.ms.xr(this.xr);
            }
            return ((com.bytedance.sdk.component.d.xr) AutoService.ms(com.bytedance.sdk.component.d.xr.class)).ms(this.xr);
        }

        private com.bytedance.sdk.component.d.ms.xr ah() {
            com.bytedance.sdk.component.d.ms.xr xrVarMs = com.bytedance.sdk.component.ab.xr.ms.ms.ms(this.f749ms, this.xr, this.d, this.c);
            this.ka = true;
            if (xrVarMs != null) {
                return xrVarMs;
            }
            this.ka = false;
            return xr();
        }
    }
}
