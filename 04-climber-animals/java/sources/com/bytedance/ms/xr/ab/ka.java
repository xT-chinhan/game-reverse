package com.bytedance.ms.xr.ab;

/* JADX INFO: loaded from: classes2.dex */
public class ka {
    private boolean ah;
    private boolean d;
    private byte[] ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f551ms;
    private String xr;

    public String ms() {
        return this.f551ms;
    }

    public boolean xr() {
        return this.d;
    }

    public byte[] ah() {
        return this.ka;
    }

    public static class ms {
        private boolean ah;
        private boolean d;
        private byte[] ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private String f552ms;
        private String xr;

        public ms ms(String str) {
            this.f552ms = str;
            return this;
        }

        public ms ms(boolean z) {
            this.d = z;
            return this;
        }

        public ms ms(byte[] bArr) {
            this.ka = bArr;
            return this;
        }

        public ka ms() {
            ka kaVar = new ka();
            kaVar.f551ms = this.f552ms;
            kaVar.xr = this.xr;
            kaVar.ah = this.ah;
            kaVar.d = this.d;
            kaVar.ka = this.ka;
            return kaVar;
        }
    }
}
