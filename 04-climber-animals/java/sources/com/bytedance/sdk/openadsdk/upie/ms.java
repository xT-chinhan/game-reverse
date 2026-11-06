package com.bytedance.sdk.openadsdk.upie;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    private JSONObject ab;
    private String ah;
    private long c;
    private int d;
    private int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f4235ms;
    private String xr;

    public String ms() {
        return this.f4235ms;
    }

    public String xr() {
        return this.xr;
    }

    public String ah() {
        return this.ah;
    }

    public int d() {
        return this.d;
    }

    public int ka() {
        return this.ka;
    }

    public long c() {
        return this.c;
    }

    public JSONObject ab() {
        return this.ab;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.upie.ms$ms, reason: collision with other inner class name */
    public static class C0340ms {
        private JSONObject ab;
        private String ah;
        private long c;
        private int d;
        private int ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private String f4236ms;
        private String xr;

        public C0340ms ms(String str) {
            this.f4236ms = str;
            return this;
        }

        public C0340ms xr(String str) {
            this.xr = str;
            return this;
        }

        public C0340ms ah(String str) {
            this.ah = str;
            return this;
        }

        public C0340ms ms(int i) {
            this.d = i;
            return this;
        }

        public C0340ms xr(int i) {
            this.ka = i;
            return this;
        }

        public C0340ms ms(long j) {
            this.c = j;
            return this;
        }

        public C0340ms ms(JSONObject jSONObject) {
            this.ab = jSONObject;
            return this;
        }

        public ms ms() {
            ms msVar = new ms();
            msVar.f4235ms = this.f4236ms;
            msVar.xr = this.xr;
            msVar.ah = this.ah;
            msVar.d = this.d;
            msVar.ka = this.ka;
            msVar.c = this.c;
            msVar.ab = this.ab;
            return msVar;
        }
    }
}
