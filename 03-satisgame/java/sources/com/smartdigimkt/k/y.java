package com.smartdigimkt.k;

import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.SparseIntArray;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class y implements w {
    public final AtomicInteger a = new AtomicInteger(0);
    public final AtomicInteger b = new AtomicInteger(0);
    public final AtomicInteger c = new AtomicInteger(0);
    public final AtomicInteger d = new AtomicInteger(0);
    public final AtomicInteger e = new AtomicInteger(0);
    public final AtomicInteger f = new AtomicInteger(0);
    public final AtomicInteger g = new AtomicInteger(0);
    public final SparseIntArray h = new SparseIntArray();
    public final HandlerThread i;
    public final x j;
    public final /* synthetic */ z k;

    public y(z zVar) {
        this.k = zVar;
        try {
            HandlerThread handlerThread = new HandlerThread("sdm_download_apk");
            this.i = handlerThread;
            handlerThread.start();
            this.j = new x(this, handlerThread.getLooper());
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public final void a(int i) {
        c0 c0Var;
        r rVar;
        int iAddAndGet = this.g.addAndGet(i);
        int iIncrementAndGet = this.c.incrementAndGet();
        z zVar = this.k;
        if (iIncrementAndGet != zVar.e || (c0Var = zVar.j) == null) {
            return;
        }
        zVar.i = 3;
        c0Var.a(3);
        z zVar2 = this.k;
        c0 c0Var2 = zVar2.j;
        long j = iAddAndGet;
        long j2 = zVar2.f;
        int i2 = zVar2.e;
        d0 d0Var = c0Var2.a;
        r rVar2 = d0Var.a;
        if (rVar2 != null) {
            if (rVar2.A <= 0) {
                d0Var.e = System.currentTimeMillis();
                d0 d0Var2 = c0Var2.a;
                d0Var2.a.A = d0Var2.e;
            }
            d0 d0Var3 = c0Var2.a;
            r rVar3 = d0Var3.a;
            rVar3.h = j2;
            rVar3.x = i2;
            rVar3.z = d0Var3.c.d;
        }
        d0 d0Var4 = c0Var2.a;
        a aVar = d0Var4.d;
        if (aVar != null) {
            aVar.b(d0Var4.a, j, j2);
        }
        d0 d0Var5 = c0Var2.a;
        o oVar = d0Var5.f;
        if (oVar == null || (rVar = d0Var5.a) == null) {
            return;
        }
        try {
            oVar.a(rVar.b, (int) j2, d0Var5.c.d);
        } catch (Throwable unused) {
        }
    }

    public final void b() {
        try {
            x xVar = this.j;
            if (xVar != null) {
                xVar.removeCallbacksAndMessages(null);
            }
            HandlerThread handlerThread = this.i;
            if (handlerThread != null) {
                handlerThread.quitSafely();
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public final void a(int i, int i2, long j) {
        x xVar;
        synchronized (this.h) {
            this.h.put(i, (int) (((long) i2) + j));
        }
        if (this.d.get() == 1 || this.d.incrementAndGet() != 1 || (xVar = this.j) == null) {
            return;
        }
        this.j.sendMessageDelayed(xVar.obtainMessage(100), 500L);
    }

    public final void a() {
        String str;
        int iIncrementAndGet = this.e.incrementAndGet();
        z zVar = this.k;
        int i = zVar.e;
        if (iIncrementAndGet == i) {
            String str2 = zVar.c;
            try {
                File file = new File(str2);
                if (!file.exists()) {
                    file.createNewFile();
                } else {
                    file.delete();
                    file.createNewFile();
                }
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                for (int i2 = 0; i2 < i; i2++) {
                    this.k.getClass();
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(com.smartdigimkt.n.c.a(i2, str2)));
                    byte[] bArr = new byte[1048576];
                    while (true) {
                        int i3 = bufferedInputStream.read(bArr);
                        if (i3 != -1) {
                            bufferedOutputStream.write(bArr, 0, i3);
                        }
                    }
                    bufferedInputStream.close();
                }
                bufferedOutputStream.close();
                str = "";
            } catch (Throwable th) {
                th.getMessage();
                str = "mergeFiles() >>> failed: " + th.getMessage();
            }
            if (this.k.j != null) {
                if (TextUtils.isEmpty(str)) {
                    z zVar2 = this.k;
                    zVar2.i = 6;
                    zVar2.j.a(6);
                    z zVar3 = this.k;
                    int i4 = zVar3.e;
                    String str3 = zVar3.c;
                    for (int i5 = 0; i5 < i4; i5++) {
                        this.k.getClass();
                        File file2 = new File(com.smartdigimkt.n.c.a(i5, str3));
                        if (file2.exists()) {
                            file2.delete();
                        }
                    }
                    c0 c0Var = this.k.j;
                    c0Var.getClass();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    d0 d0Var = c0Var.a;
                    long j = jCurrentTimeMillis - d0Var.e;
                    r rVar = d0Var.a;
                    if (rVar != null) {
                        rVar.B = jCurrentTimeMillis;
                        rVar.i = j;
                    }
                    a aVar = d0Var.d;
                    if (aVar != null) {
                        aVar.a(rVar, j);
                    }
                } else {
                    z zVar4 = this.k;
                    zVar4.i = 7;
                    zVar4.j.a(7);
                    this.k.j.a(3, str);
                }
            }
            b();
        }
    }

    public final void a(int i, String str) {
        if (this.f.incrementAndGet() == 1) {
            z zVar = this.k;
            zVar.i = 7;
            zVar.a(i, str);
            b();
        }
    }
}
