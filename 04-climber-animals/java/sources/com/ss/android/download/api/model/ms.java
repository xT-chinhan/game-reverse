package com.ss.android.download.api.model;

/* JADX INFO: loaded from: classes3.dex */
public class ms {
    public String ah;
    public String d;
    public String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public String f4327ms;
    public String xr;

    public ms(C0530ms c0530ms) {
        this.xr = "";
        this.f4327ms = c0530ms.f4328ms;
        this.xr = c0530ms.xr;
        this.ah = c0530ms.ah;
        this.d = c0530ms.d;
        this.ka = c0530ms.ka;
    }

    /* JADX INFO: renamed from: com.ss.android.download.api.model.ms$ms, reason: collision with other inner class name */
    public static class C0530ms {
        private String ah;
        private String d;
        private String ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private String f4328ms;
        private String xr;

        public C0530ms ms(String str) {
            this.f4328ms = str;
            return this;
        }

        public C0530ms xr(String str) {
            this.xr = str;
            return this;
        }

        public C0530ms ah(String str) {
            this.d = str;
            return this;
        }

        public C0530ms d(String str) {
            this.ka = str;
            return this;
        }

        public ms ms() {
            return new ms(this);
        }
    }
}
