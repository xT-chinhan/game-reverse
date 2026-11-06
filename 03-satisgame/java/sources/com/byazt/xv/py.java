package com.byazt.xv;

import com.byazt.m.IDownloadHttpService;

/* JADX INFO: loaded from: classes2.dex */
public interface py {

    @com.byazt.cp.n(n = {0, 1, 41, 1863})
    public static class n implements py {
        @Override // com.byazt.xv.py
        public com.byazt.qx.x n(Throwable th, String str) {
            return null;
        }

        @Override // com.byazt.xv.py
        public boolean n() {
            return false;
        }

        @Override // com.byazt.xv.py
        public boolean n(Throwable th) {
            return false;
        }

        @Override // com.byazt.xv.py
        public IDownloadHttpService qg() {
            return null;
        }

        @Override // com.byazt.xv.py
        public com.byazt.m.fs s() {
            return null;
        }
    }

    com.byazt.qx.x n(Throwable th, String str);

    boolean n();

    boolean n(Throwable th);

    IDownloadHttpService qg();

    com.byazt.m.fs s();
}
