package com.ss.android.downloadlib.ka;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public class xr {

    public interface ms<T> {
        T xr();
    }

    public static <T> T ms(boolean z, String str, ms<T> msVar) {
        try {
            return msVar.xr();
        } catch (Throwable th) {
            if (th instanceof com.ss.android.downloadlib.ka.ms) {
                throw th;
            }
            ah.ms().ms(z, th, str);
            if (TextUtils.isEmpty(str)) {
                throw th;
            }
            return null;
        }
    }

    public static <T> T ms(ms<T> msVar) {
        return (T) ms(true, null, msVar);
    }

    public static void ms(final Runnable runnable) {
        ms(new ms<Void>() { // from class: com.ss.android.downloadlib.ka.xr.1
            @Override // com.ss.android.downloadlib.ka.xr.ms
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Void xr() {
                runnable.run();
                return null;
            }
        });
    }
}
