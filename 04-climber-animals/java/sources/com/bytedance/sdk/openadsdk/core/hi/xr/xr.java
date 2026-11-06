package com.bytedance.sdk.openadsdk.core.hi.xr;

import android.os.Looper;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.openadsdk.core.nw;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends ny {
    private long ah;
    private String c;
    private long d;
    private String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f2654ms;
    private com.bytedance.sdk.openadsdk.core.hi.xr.ms xr;

    public xr(String str) {
        super(str);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.xr == null) {
        }
        String str = this.f2654ms;
        str.hashCode();
        switch (str) {
            case "onIdle":
                this.xr.ms();
                break;
            case "onInstalled":
                this.xr.ms(this.ka, this.c);
                break;
            case "onDownloadActive":
                this.xr.ms(this.ah, this.d, this.ka, this.c);
                break;
            case "onDownloadFailed":
                this.xr.ah(this.ah, this.d, this.ka, this.c);
                break;
            case "onDownloadPaused":
                this.xr.xr(this.ah, this.d, this.ka, this.c);
                break;
            case "onDownloadFinished":
                this.xr.ms(this.ah, this.ka, this.c);
                break;
        }
    }

    static class ms {
        private long ah;
        private com.bytedance.sdk.openadsdk.core.hi.xr.ms c;
        private String d;
        private String ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private String f2655ms;
        private long xr;

        ms() {
        }

        public ms ms(String str) {
            this.f2655ms = str;
            return this;
        }

        public ms ms(com.bytedance.sdk.openadsdk.core.hi.xr.ms msVar) {
            this.c = msVar;
            return this;
        }

        public ms ms(long j) {
            this.xr = j;
            return this;
        }

        public ms xr(long j) {
            this.ah = j;
            return this;
        }

        public ms xr(String str) {
            this.d = str;
            return this;
        }

        public ms ah(String str) {
            this.ka = str;
            return this;
        }

        public void ms() {
            xr xrVar = new xr("tt_csj_download_thread");
            xrVar.c = this.ka;
            xrVar.ka = this.d;
            xrVar.d = this.ah;
            xrVar.ah = this.xr;
            xrVar.f2654ms = this.f2655ms;
            xrVar.xr = this.c;
            xr.xr(xrVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xr(Runnable runnable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            nw.c().post(runnable);
        } else {
            runnable.run();
        }
    }
}
