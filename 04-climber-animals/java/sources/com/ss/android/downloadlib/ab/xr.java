package com.ss.android.downloadlib.ab;

import android.os.AsyncTask;

/* JADX INFO: loaded from: classes3.dex */
public class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    static final ms f4350ms = new C0533xr();

    private static class ms {
        private ms() {
        }

        public <T> void ms(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.executeOnExecutor(com.bytedance.sdk.component.ch.d.xr.f1215ms, tArr);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: renamed from: com.ss.android.downloadlib.ab.xr$xr, reason: collision with other inner class name */
    private static class C0533xr extends ms {
        private C0533xr() {
            super();
        }

        @Override // com.ss.android.downloadlib.ab.xr.ms
        public <T> void ms(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, tArr);
            } catch (Throwable unused) {
            }
        }
    }

    public static <T> void ms(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
        f4350ms.ms(asyncTask, tArr);
    }
}
