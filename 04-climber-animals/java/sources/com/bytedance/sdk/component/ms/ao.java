package com.bytedance.sdk.component.ms;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ao {
    public final String ab;
    public final String ah;
    public final String c;
    public final String d;
    public final String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public final int f1251ms;
    public final String x;
    public final String xr;

    public static ms ms() {
        return new ms();
    }

    public static ao ms(String str, int i) {
        return new ao(str, i);
    }

    private ao(String str, int i) {
        this.xr = null;
        this.ah = null;
        this.d = null;
        this.ka = null;
        this.c = str;
        this.ab = null;
        this.f1251ms = i;
        this.x = null;
    }

    private ao(ms msVar) {
        this.xr = msVar.f1252ms;
        this.ah = msVar.xr;
        this.d = msVar.ah;
        this.ka = msVar.d;
        this.c = msVar.ka;
        this.ab = msVar.c;
        this.f1251ms = 1;
        this.x = msVar.ab;
    }

    public static boolean ms(ao aoVar) {
        return aoVar == null || aoVar.f1251ms != 1 || TextUtils.isEmpty(aoVar.d) || TextUtils.isEmpty(aoVar.ka);
    }

    public String toString() {
        return "methodName: " + this.d + ", params: " + this.ka + ", callbackId: " + this.c + ", type: " + this.ah + ", version: " + this.xr + ", ";
    }

    public static final class ms {
        private String ab;
        private String ah;
        private String c;
        private String d;
        private String ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private String f1252ms;
        private String xr;

        private ms() {
        }

        public ms ms(String str) {
            this.f1252ms = str;
            return this;
        }

        public ms xr(String str) {
            this.xr = str;
            return this;
        }

        public ms ah(String str) {
            this.ah = str;
            return this;
        }

        public ms d(String str) {
            this.d = str;
            return this;
        }

        public ms ka(String str) {
            this.ka = str;
            return this;
        }

        public ms c(String str) {
            this.c = str;
            return this;
        }

        public ms ab(String str) {
            this.ab = str;
            return this;
        }

        public ao ms() {
            return new ao(this);
        }
    }
}
