package com.ss.android.download.api.model;

/* JADX INFO: loaded from: classes3.dex */
public class d {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f4325ms;
    private String xr;

    public d(ms msVar) {
        this.f4325ms = msVar.f4326ms;
        this.xr = msVar.xr;
    }

    public String ms() {
        return this.f4325ms;
    }

    public static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private String f4326ms;
        private String xr;

        public ms ms(String str) {
            this.f4326ms = str;
            return this;
        }

        public ms xr(String str) {
            this.xr = str;
            return this;
        }

        public d ms() {
            return new d(this);
        }
    }
}
