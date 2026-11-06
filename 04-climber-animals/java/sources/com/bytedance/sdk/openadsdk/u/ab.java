package com.bytedance.sdk.openadsdk.u;

/* JADX INFO: loaded from: classes2.dex */
public class ab {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static ms f4133ms;

    public interface ms {
        void ms(String str, String str2, Throwable th);
    }

    public static void ms(ms msVar) {
        f4133ms = msVar;
    }

    public static boolean ms() {
        return f4133ms != null;
    }

    public static void ms(String str, String str2, Throwable th) {
        if (f4133ms == null) {
            return;
        }
        if (th == null) {
            th = new Throwable();
        }
        f4133ms.ms(str, str2, th);
    }
}
