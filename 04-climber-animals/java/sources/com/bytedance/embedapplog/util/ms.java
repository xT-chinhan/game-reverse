package com.bytedance.embedapplog.util;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    private final String ab;
    private final String[] ah;
    private final String c;
    private final String d;
    private final String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final String f533ms;
    private final String[] xr;

    private ms(C0212ms c0212ms) {
        this.f533ms = c0212ms.f534ms;
        this.xr = c0212ms.xr;
        this.ah = c0212ms.ah;
        this.d = c0212ms.d;
        this.ka = c0212ms.ka;
        this.c = c0212ms.c;
        this.ab = c0212ms.ab;
    }

    /* JADX INFO: renamed from: com.bytedance.embedapplog.util.ms$ms, reason: collision with other inner class name */
    public static class C0212ms {
        private String ab;
        private String[] ah;
        private String c;
        private String d;
        private String ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private String f534ms;
        private String[] xr;

        public C0212ms ms(String str) {
            this.f534ms = str;
            return this;
        }

        public C0212ms ms(String[] strArr) {
            this.xr = strArr;
            return this;
        }

        public C0212ms xr(String[] strArr) {
            this.ah = strArr;
            return this;
        }

        public C0212ms xr(String str) {
            this.d = str;
            return this;
        }

        public C0212ms ah(String str) {
            this.ka = str;
            return this;
        }

        public C0212ms d(String str) {
            this.ab = str;
            return this;
        }

        public ms ms() {
            return new ms(this);
        }
    }

    public String ms() {
        return this.f533ms;
    }

    public String[] xr() {
        return this.xr;
    }

    public String ah() {
        return this.d;
    }

    public String d() {
        return this.ka;
    }

    public static ms ms(int i) {
        return xr.ms(i);
    }
}
