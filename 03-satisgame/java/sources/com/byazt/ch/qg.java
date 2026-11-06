package com.byazt.ch;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1600, 26})
public class qg {

    public interface n<T> {
        T qg();
    }

    public static <T> T n(boolean z, String str, n<T> nVar) {
        try {
            return nVar.qg();
        } catch (Throwable th) {
            if (th instanceof com.byazt.ch.n) {
                throw th;
            }
            s.n().n(z, th, str);
            if (TextUtils.isEmpty(str)) {
                throw th;
            }
            return null;
        }
    }

    public static <T> T n(n<T> nVar) {
        return (T) n(true, null, nVar);
    }

    public static void n(final Runnable runnable) {
        n(new n<Void>() { // from class: com.byazt.ch.qg.1
            @Override // com.byazt.ch.qg.n
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Void qg() {
                runnable.run();
                return null;
            }
        });
    }
}
