package com.bytedance.sdk.openadsdk.core.nw;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private int ah;
    private String c;
    private double d;
    private boolean ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f3052ms;
    private int xr;

    public String ms() {
        return this.f3052ms;
    }

    public void ms(String str) {
        this.f3052ms = str;
    }

    public int xr() {
        return this.xr;
    }

    public void ms(int i) {
        this.xr = i;
    }

    public int ah() {
        return this.ah;
    }

    public void xr(int i) {
        this.ah = i;
    }

    public double d() {
        return this.d;
    }

    public void ms(double d) {
        this.d = d;
    }

    public boolean ka() {
        return !TextUtils.isEmpty(this.f3052ms) && this.xr > 0 && this.ah > 0;
    }

    public boolean c() {
        return this.ka;
    }

    public void ms(boolean z) {
        this.ka = z;
    }

    public String ab() {
        return this.c;
    }

    public void xr(String str) {
        this.c = str;
    }

    public static com.bytedance.sdk.openadsdk.ao.xr.xr.sl ms(g gVar) {
        if (gVar == null || !gVar.ka()) {
            return null;
        }
        return new ms(gVar.ah(), gVar.xr(), gVar.ms(), gVar.d());
    }

    public static final com.bytedance.sdk.openadsdk.ao.xr.xr.sl ms(int i, int i2, String str, double d) {
        return new ms(i, i2, str, d);
    }

    private static final class ms extends com.bytedance.sdk.openadsdk.ao.xr.xr.sl {
        private String ah;
        private double d;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private int f3053ms;
        private int xr;

        public ms(int i, int i2, String str, double d) {
            this.f3053ms = i;
            this.xr = i2;
            this.ah = str;
            this.d = d;
        }

        @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.sl
        public int ms() {
            return this.f3053ms;
        }

        @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.sl
        public int xr() {
            return this.xr;
        }

        @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.sl
        public String ah() {
            return this.ah;
        }

        @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.sl
        public double d() {
            return this.d;
        }

        @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.sl
        public boolean ka() {
            String str;
            return this.f3053ms > 0 && this.xr > 0 && (str = this.ah) != null && str.length() > 0;
        }
    }
}
