package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.ref.SoftReference;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: classes3.dex */
public class x {
    private Runnable ab;
    private long ah;
    private Handler c;
    private long d;
    private SoftReference<JumpUnknownSourceActivity> ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Queue<Integer> f4600ms;
    private boolean xr;

    private x() {
        this.f4600ms = new ArrayDeque();
        this.xr = false;
        this.c = new Handler(Looper.getMainLooper());
        this.ab = new Runnable() { // from class: com.ss.android.socialbase.appdownloader.x.1
            @Override // java.lang.Runnable
            public void run() {
                x.this.ah();
            }
        };
        com.ss.android.socialbase.downloader.ms.ms.ms().ms(new com.ss.android.socialbase.downloader.ms.ms.InterfaceC0570ms() { // from class: com.ss.android.socialbase.appdownloader.x.2
            @Override // com.ss.android.socialbase.downloader.ms.ms.InterfaceC0570ms
            public void ah() {
            }

            @Override // com.ss.android.socialbase.downloader.ms.ms.InterfaceC0570ms
            public void xr() {
                if (x.this.f4600ms.isEmpty()) {
                    return;
                }
                long jMs = com.ss.android.socialbase.downloader.ab.ms.ah().ms("install_on_resume_install_interval", 120000L);
                long jCurrentTimeMillis = System.currentTimeMillis() - x.this.d;
                if (jCurrentTimeMillis < jMs) {
                    if (x.this.c.hasCallbacks(x.this.ab)) {
                        return;
                    }
                    x.this.c.postDelayed(x.this.ab, jMs - jCurrentTimeMillis);
                } else {
                    x.this.d = System.currentTimeMillis();
                    x.this.ah();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah() {
        final Integer numPoll;
        if (Build.VERSION.SDK_INT < 29 || com.ss.android.socialbase.downloader.ms.ms.ms().xr()) {
            synchronized (this.f4600ms) {
                numPoll = this.f4600ms.poll();
            }
            this.c.removeCallbacks(this.ab);
            if (numPoll != null) {
                final Context contextK = com.ss.android.socialbase.downloader.downloader.ah.k();
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    this.c.post(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.x.3
                        @Override // java.lang.Runnable
                        public void run() {
                            x.this.xr(contextK, numPoll.intValue(), false);
                        }
                    });
                } else {
                    xr(contextK, numPoll.intValue(), false);
                }
                this.c.postDelayed(this.ab, 20000L);
                return;
            }
            this.xr = false;
        }
    }

    void ms(DownloadInfo downloadInfo, String str) {
        if (downloadInfo == null || TextUtils.isEmpty(str)) {
            return;
        }
        ah();
    }

    private static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private static final x f4605ms = new x();
    }

    public static x ms() {
        return ms.f4605ms;
    }

    public int ms(final Context context, final int i, final boolean z) {
        if (z) {
            return xr(context, i, z);
        }
        if (d()) {
            this.c.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.x.4
                @Override // java.lang.Runnable
                public void run() {
                    x.this.ms(context, i, z);
                }
            }, 1000L);
            return 1;
        }
        if (com.ss.android.socialbase.downloader.ms.ms.ms().xr()) {
            com.ss.android.socialbase.downloader.ah.ms.ah("leaves", "on Foreground");
            return xr(context, i, z);
        }
        if (xr.ms()) {
            return 1;
        }
        boolean z2 = Build.VERSION.SDK_INT < 29;
        if (this.f4600ms.isEmpty() && !this.xr && z2) {
            return xr(context, i, z);
        }
        int iMs = com.ss.android.socialbase.downloader.ab.ms.ah().ms("install_queue_size", 3);
        synchronized (this.f4600ms) {
            while (this.f4600ms.size() > iMs) {
                this.f4600ms.poll();
            }
        }
        if (z2) {
            this.c.removeCallbacks(this.ab);
            this.c.postDelayed(this.ab, com.ss.android.socialbase.downloader.ab.ms.ms(i).ms("install_queue_timeout", 20000L));
        }
        synchronized (this.f4600ms) {
            if (!this.f4600ms.contains(Integer.valueOf(i))) {
                this.f4600ms.offer(Integer.valueOf(i));
            }
        }
        return 1;
    }

    private boolean d() {
        return System.currentTimeMillis() - this.ah < 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int xr(Context context, int i, boolean z) {
        int iXr = ah.xr(context, i, z);
        if (iXr == 1) {
            this.xr = true;
        }
        this.ah = System.currentTimeMillis();
        return iXr;
    }

    public void ms(JumpUnknownSourceActivity jumpUnknownSourceActivity) {
        this.ka = new SoftReference<>(jumpUnknownSourceActivity);
    }

    public JumpUnknownSourceActivity xr() {
        SoftReference<JumpUnknownSourceActivity> softReference = this.ka;
        JumpUnknownSourceActivity jumpUnknownSourceActivity = softReference == null ? null : softReference.get();
        this.ka = null;
        return jumpUnknownSourceActivity;
    }
}
