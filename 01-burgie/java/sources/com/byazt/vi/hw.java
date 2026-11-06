package com.byazt.vi;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 831, 13})
public class hw {

    public interface pr<T> {
        T hw();
    }

    public static <T> T pr(boolean z, String str, pr<T> prVar) {
        try {
            return prVar.hw();
        } catch (Throwable th) {
            if (th instanceof com.byazt.vi.pr) {
                throw th;
            }
            hn.pr().pr(z, th, str);
            if (TextUtils.isEmpty(str)) {
                throw th;
            }
            return null;
        }
    }

    public static <T> T pr(pr<T> prVar) {
        return (T) pr(true, null, prVar);
    }

    public static void pr(final Runnable runnable) {
        pr(new pr<Void>() { // from class: com.byazt.vi.hw.1
            @Override // com.byazt.vi.hw.pr
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Void hw() {
                runnable.run();
                return null;
            }
        });
    }
}
