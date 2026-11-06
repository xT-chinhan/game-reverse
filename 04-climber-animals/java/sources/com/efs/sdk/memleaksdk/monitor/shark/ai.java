package com.efs.sdk.memleaksdk.monitor.shark;

/* JADX INFO: loaded from: classes2.dex */
public class ai {
    public static final ai a;
    public static final ai b;
    public static final ai c;

    public float a(long j) {
        return 0.0f;
    }

    public float b(long j) {
        return 0.0f;
    }

    /* synthetic */ ai(byte b2) {
        this();
    }

    public float a(int i) {
        return a(i);
    }

    static {
        byte b2 = 0;
        a = new a(b2);
        b = new b(b2);
        c = new c(b2);
    }

    private ai() {
    }

    static class a extends ai {
        @Override // com.efs.sdk.memleaksdk.monitor.shark.ai
        public float a(long j) {
            return j;
        }

        @Override // com.efs.sdk.memleaksdk.monitor.shark.ai
        public float b(long j) {
            return (j / 1024.0f) / 1024.0f;
        }

        private a() {
            super((byte) 0);
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    static class b extends ai {
        @Override // com.efs.sdk.memleaksdk.monitor.shark.ai
        public float a(long j) {
            return j * 1024.0f;
        }

        @Override // com.efs.sdk.memleaksdk.monitor.shark.ai
        public float b(long j) {
            return j / 1024.0f;
        }

        private b() {
            super((byte) 0);
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    static class c extends ai {
        @Override // com.efs.sdk.memleaksdk.monitor.shark.ai
        public float a(long j) {
            return j * 1024.0f * 1024.0f;
        }

        @Override // com.efs.sdk.memleaksdk.monitor.shark.ai
        public float b(long j) {
            return j;
        }

        private c() {
            super((byte) 0);
        }

        /* synthetic */ c(byte b) {
            this();
        }
    }
}
