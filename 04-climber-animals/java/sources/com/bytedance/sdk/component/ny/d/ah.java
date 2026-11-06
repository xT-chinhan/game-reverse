package com.bytedance.sdk.component.ny.d;

/* JADX INFO: loaded from: classes2.dex */
public class ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ms f1284ms;
    private xr xr;

    public enum ms {
        DEBUG,
        INFO,
        ERROR,
        OFF
    }

    public interface xr {
        void ms(String str, String str2);
    }

    private ah() {
        this.f1284ms = ms.OFF;
        this.xr = new com.bytedance.sdk.component.ny.d.xr();
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.ny.d.ah$ah, reason: collision with other inner class name */
    private static class C0248ah {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private static final ah f1285ms = new ah();
    }

    public static void ms(ms msVar) {
        synchronized (ah.class) {
            C0248ah.f1285ms.f1284ms = msVar;
        }
    }

    public static void ms(String str, String str2) {
        if (C0248ah.f1285ms.f1284ms.compareTo(ms.ERROR) <= 0) {
            C0248ah.f1285ms.xr.ms(str, str2);
        }
    }

    public static void xr(String str, String str2) {
        if (C0248ah.f1285ms.f1284ms.compareTo(ms.DEBUG) <= 0) {
            ah unused = C0248ah.f1285ms;
        }
    }
}
