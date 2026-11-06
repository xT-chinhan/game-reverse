package com.bykv.vk.openvk.component.video.ms.xr;

import android.os.SystemClock;
import android.util.Log;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;

/* JADX INFO: loaded from: classes.dex */
class ab extends com.bykv.vk.openvk.component.video.ms.xr.ms {
    private volatile com.bykv.vk.openvk.component.video.ms.xr.xr ao;
    private volatile boolean h;
    private final ah u;
    private final d ub;
    private final Socket zb;

    public interface ah {
        void ms(ab abVar);

        void xr(ab abVar);
    }

    ab(ms msVar) {
        super(msVar.f62ms, msVar.xr);
        this.h = true;
        this.zb = msVar.ah;
        this.u = msVar.d;
        this.ub = d.ah();
    }

    private xr x() {
        try {
            this.ny = ny.ms(this.zb.getInputStream());
            OutputStream outputStream = this.zb.getOutputStream();
            com.bykv.vk.openvk.component.video.ms.xr.ms.ms msVar = this.ny.ah.f102ms == 1 ? ka.f83ms : ka.xr;
            if (msVar == null) {
                if (ka.ah) {
                    com.bytedance.sdk.component.utils.sl.d("TAG_PROXY_ProxyTask", "cache is null");
                }
                return null;
            }
            this.f88ms = msVar;
            this.ab = this.ny.ah.xr;
            this.x = this.ny.ah.ah;
            this.ch = new sl(this.ny.ah.ab);
            this.c = this.ny.xr;
            if (ka.ah) {
                com.bytedance.sdk.component.utils.sl.ms("TAG_PROXY_ProxyTask", "request from MediaPlayer:    " + this.ny.toString());
            }
            return new xr(outputStream, this.ny.ah.d);
        } catch (ny.d e) {
            com.bykv.vk.openvk.component.video.ms.ah.ms.ms(this.zb);
            if (ka.ah) {
                com.bytedance.sdk.component.utils.sl.d("TAG_PROXY_ProxyTask", Log.getStackTraceString(e));
            }
            if (this.f88ms != null) {
                Boolean.valueOf(ab());
            }
            String str = this.ab;
            return null;
        } catch (IOException e2) {
            com.bykv.vk.openvk.component.video.ms.ah.ms.ms(this.zb);
            if (ka.ah) {
                com.bytedance.sdk.component.utils.sl.d("TAG_PROXY_ProxyTask", Log.getStackTraceString(e2));
            }
            if (this.f88ms != null) {
                Boolean.valueOf(ab());
            }
            String str2 = this.ab;
            return null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        com.bykv.vk.openvk.component.video.ms.xr.xr.ms msVarQuery;
        xr xrVarX = x();
        if (xrVarX == null) {
            return;
        }
        ah ahVar = this.u;
        if (ahVar != null) {
            ahVar.ms(this);
        }
        this.f88ms.ms(this.x);
        if (ka.x != 0 && ((msVarQuery = this.xr.query(this.x, this.ny.ah.f102ms)) == null || this.f88ms.ah(this.x).length() < msVarQuery.ah)) {
            this.ub.ms(ab(), this.x);
        }
        try {
            ms(xrVarX);
        } catch (com.bykv.vk.openvk.component.video.ms.xr.ah.ms e) {
            if (ka.ah) {
                com.bytedance.sdk.component.utils.sl.d("TAG_PROXY_ProxyTask", Log.getStackTraceString(e));
            }
        } catch (Throwable th) {
            if (ka.ah) {
                com.bytedance.sdk.component.utils.sl.d("TAG_PROXY_ProxyTask", Log.getStackTraceString(th));
            }
        }
        this.f88ms.xr(this.x);
        this.ub.ms(ab(), null);
        ms();
        com.bykv.vk.openvk.component.video.ms.ah.ms.ms(this.zb);
        ah ahVar2 = this.u;
        if (ahVar2 != null) {
            ahVar2.xr(this);
        }
    }

    private boolean ms(xr xrVar) throws Throwable {
        while (this.ch.ms()) {
            ka();
            sl.ms msVarXr = this.ch.xr();
            try {
                ms(xrVar, msVarXr);
                return true;
            } catch (com.bykv.vk.openvk.component.video.ms.xr.ah.ah unused) {
                msVarXr.ms();
                Boolean.valueOf(ab());
                String str = this.ab;
            } catch (com.bykv.vk.openvk.component.video.ms.xr.ah.d e) {
                if (ka.ah) {
                    com.bytedance.sdk.component.utils.sl.d("TAG_PROXY_ProxyTask", Log.getStackTraceString(e));
                }
                return true;
            } catch (com.bykv.vk.openvk.component.video.ms.xr.ah.xr e2) {
                if (ka.ah) {
                    com.bytedance.sdk.component.utils.sl.d("TAG_PROXY_ProxyTask", Log.getStackTraceString(e2));
                }
                return false;
            } catch (x.ms e3) {
                if (ka.ah) {
                    com.bytedance.sdk.component.utils.sl.d("TAG_PROXY_ProxyTask", Log.getStackTraceString(e3));
                }
                this.h = false;
                Boolean.valueOf(ab());
                String str2 = this.ab;
            } catch (IOException e4) {
                if (e4 instanceof SocketTimeoutException) {
                    msVarXr.xr();
                }
                if (xr()) {
                    if (ka.ah) {
                        if ("Canceled".equalsIgnoreCase(e4.getMessage())) {
                            com.bytedance.sdk.component.utils.sl.xr("TAG_PROXY_ProxyTask", "okhttp call canceled");
                        } else {
                            com.bytedance.sdk.component.utils.sl.d("TAG_PROXY_ProxyTask", Log.getStackTraceString(e4));
                        }
                    }
                } else {
                    Boolean.valueOf(ab());
                    String str3 = this.ab;
                }
            } catch (Exception e5) {
                if (ka.ah) {
                    com.bytedance.sdk.component.utils.sl.d("TAG_PROXY_ProxyTask", Log.getStackTraceString(e5));
                }
            }
        }
        return false;
    }

    private void ms(xr xrVar, sl.ms msVar) throws Throwable {
        if ("HEAD".equalsIgnoreCase(this.ny.f100ms.f101ms)) {
            xr(xrVar, msVar);
        } else {
            ah(xrVar, msVar);
        }
    }

    private void xr(xr xrVar, sl.ms msVar) throws com.bykv.vk.openvk.component.video.ms.xr.ah.d, IOException {
        byte[] bArrMs = ms(this.xr.query(this.x, this.ny.ah.f102ms), xrVar, msVar);
        if (bArrMs == null) {
            return;
        }
        xrVar.ms(bArrMs, 0, bArrMs.length);
    }

    private void ah(xr xrVar, sl.ms msVar) throws Throwable {
        if (this.h) {
            File fileAh = this.f88ms.ah(this.x);
            long length = fileAh.length();
            com.bykv.vk.openvk.component.video.ms.xr.xr.ms msVarQuery = this.xr.query(this.x, this.ny.ah.f102ms);
            int iXr = xrVar.xr();
            if (length > xrVar.xr()) {
                if (ka.ah) {
                    com.bytedance.sdk.component.utils.sl.ms("TAG_PROXY_ProxyTask", "cache hit, remainSize: " + (length - ((long) iXr)));
                }
                ms(msVarQuery, fileAh, xrVar, msVar);
                return;
            }
        }
        d(xrVar, msVar);
    }

    private byte[] ms(com.bykv.vk.openvk.component.video.ms.xr.xr.ms msVar, xr xrVar, sl.ms msVar2) throws IOException {
        if (msVar != null) {
            if (ka.ah) {
                com.bytedance.sdk.component.utils.sl.ms("TAG_PROXY_ProxyTask", "get header from db");
            }
            return com.bykv.vk.openvk.component.video.ms.ah.ms.ms(msVar, xrVar.xr()).getBytes(com.bykv.vk.openvk.component.video.ms.ah.ms.f28ms);
        }
        com.bykv.vk.openvk.component.video.ms.xr.ka.ms msVarMs = ms(msVar2, 0, -1, "HEAD");
        if (msVarMs == null) {
            return null;
        }
        try {
            String strMs = com.bykv.vk.openvk.component.video.ms.ah.ms.ms(msVarMs, false, false);
            if (strMs != null) {
                throw new com.bykv.vk.openvk.component.video.ms.xr.ah.ah(strMs + ", rawKey: " + this.ab + ", url: " + msVar2);
            }
            com.bykv.vk.openvk.component.video.ms.xr.xr.ms msVarMs2 = com.bykv.vk.openvk.component.video.ms.ah.ms.ms(msVarMs, this.xr, this.x, this.ny.ah.f102ms);
            if (ka.ah) {
                com.bytedance.sdk.component.utils.sl.xr("TAG_PROXY_ProxyTask", "get header from network");
            }
            byte[] bytes = com.bykv.vk.openvk.component.video.ms.ah.ms.ms(msVarMs2, xrVar.xr()).getBytes(com.bykv.vk.openvk.component.video.ms.ah.ms.f28ms);
            com.bykv.vk.openvk.component.video.ms.ah.ms.ms(msVarMs.d());
            return bytes;
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.ms.ah.ms.ms(msVarMs.d());
            throw th;
        }
    }

    private void ms(com.bykv.vk.openvk.component.video.ms.xr.xr.ms msVar, File file, xr xrVar, sl.ms msVar2) throws Throwable {
        final com.bytedance.sdk.component.ch.x xVar;
        com.bykv.vk.openvk.component.video.ms.xr.xr xrVar2;
        if (!xrVar.ms()) {
            byte[] bArrMs = ms(msVar, xrVar, msVar2);
            ka();
            if (bArrMs == null) {
                return;
            } else {
                xrVar.ms(bArrMs, 0, bArrMs.length);
            }
        }
        x xVar2 = null;
        if (msVar == null && (msVar = this.xr.query(this.x, this.ny.ah.f102ms)) == null) {
            if (ka.ah) {
                com.bytedance.sdk.component.utils.sl.d("TAG_PROXY_ProxyTask", "failed to get video header info from db");
            }
            ms(null, xrVar, msVar2);
            msVar = this.xr.query(this.x, this.ny.ah.f102ms);
            if (msVar == null) {
                throw new com.bykv.vk.openvk.component.video.ms.xr.ah.ah("failed to get header, rawKey: " + this.ab + ", url: " + msVar2);
            }
        }
        if (file.length() >= msVar.ah || !((xrVar2 = this.ao) == null || xrVar2.xr() || xrVar2.d())) {
            xVar = null;
        } else {
            com.bykv.vk.openvk.component.video.ms.xr.xr xrVarMs = new com.bykv.vk.openvk.component.video.ms.xr.xr.ms().ms(this.f88ms).ms(this.xr).ms(this.ab).xr(this.x).ms(new sl(msVar2.f105ms)).ms(this.c).ms(this.ny).ms(new com.bykv.vk.openvk.component.video.ms.xr.xr.InterfaceC0185xr() { // from class: com.bykv.vk.openvk.component.video.ms.xr.ab.1
                @Override // com.bykv.vk.openvk.component.video.ms.xr.xr.InterfaceC0185xr
                public void ms(com.bykv.vk.openvk.component.video.ms.xr.xr xrVar3) {
                    ab.this.ah.addAndGet(xrVar3.ah.get());
                    ab.this.d.addAndGet(xrVar3.d.get());
                    synchronized (xrVar3.zb) {
                        xrVar3.zb.notifyAll();
                    }
                    if (xrVar3.d()) {
                        ab.this.ub.ms(ab.this.ab(), null);
                    }
                }
            }).ms();
            this.ao = xrVarMs;
            xVar = new com.bytedance.sdk.component.ch.x(xrVarMs, null, 10, 1);
            com.bytedance.sdk.component.ch.ab.xr(new com.bytedance.sdk.component.ch.ny("processCacheNetWorkConcurrent") { // from class: com.bykv.vk.openvk.component.video.ms.xr.ab.2
                @Override // java.lang.Runnable
                public void run() {
                    xVar.run();
                }
            });
            if (ka.ah) {
                com.bytedance.sdk.component.utils.sl.d("TAG_PROXY_ProxyTask", "fire download in process cache task");
            }
        }
        byte[] bArr = new byte[8192];
        try {
            x xVar3 = new x(file, t.k);
            try {
                xVar3.ms(xrVar.xr());
                int iMin = this.ny.ah.ka > 0 ? Math.min(msVar.ah, this.ny.ah.ka) : msVar.ah;
                while (xrVar.xr() < iMin) {
                    ka();
                    int iMs = xVar3.ms(bArr);
                    if (iMs <= 0) {
                        com.bykv.vk.openvk.component.video.ms.xr.xr xrVar3 = this.ao;
                        if (xrVar3 != null) {
                            com.bykv.vk.openvk.component.video.ms.xr.ah.xr xrVarNy = xrVar3.ny();
                            if (xrVarNy != null) {
                                throw xrVarNy;
                            }
                            x.ms msVarX = xrVar3.x();
                            if (msVarX != null) {
                                throw msVarX;
                            }
                        }
                        if (xrVar3 != null && !xrVar3.xr() && !xrVar3.d()) {
                            ka();
                            synchronized (xrVar3.zb) {
                                try {
                                    xrVar3.zb.wait(1000L);
                                } catch (InterruptedException e) {
                                    com.bytedance.sdk.component.utils.sl.ms(e);
                                }
                            }
                        }
                        if (ka.ah) {
                            com.bytedance.sdk.component.utils.sl.d("TAG_PROXY_ProxyTask", "download task has finished!!!");
                        }
                        throw new com.bykv.vk.openvk.component.video.ms.xr.ah.ah("illegal state download task has finished, rawKey: " + this.ab + ", url: " + msVar2);
                    }
                    xrVar.xr(bArr, 0, iMs);
                    ka();
                }
                if (ka.ah) {
                    com.bytedance.sdk.component.utils.sl.ms("TAG_PROXY_ProxyTask", "read cache file complete: " + xrVar.xr() + ", " + iMin);
                }
                ah();
                xVar3.ms();
                if (xVar != null) {
                    try {
                        xVar.get();
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.sl.ms(th);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                xVar2 = xVar3;
                if (xVar2 != null) {
                    xVar2.ms();
                }
                if (xVar != null) {
                    try {
                        xVar.get();
                    } catch (Throwable th3) {
                        com.bytedance.sdk.component.utils.sl.ms(th3);
                    }
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    private void d(xr xrVar, sl.ms msVar) throws Throwable {
        x xVar;
        ny();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int iXr = xrVar.xr();
        com.bykv.vk.openvk.component.video.ms.xr.ka.ms msVarMs = ms(msVar, iXr, this.ny.ah.ka, "GET");
        if (msVarMs == null) {
            return;
        }
        x xVar2 = null;
        int i = 0;
        try {
            String strMs = com.bykv.vk.openvk.component.video.ms.ah.ms.ms(msVarMs, false, true);
            if (strMs != null) {
                throw new com.bykv.vk.openvk.component.video.ms.xr.ah.ah(strMs + ", rawKey: " + this.ab + ", url: " + msVar);
            }
            com.bykv.vk.openvk.component.video.ms.xr.xr.ms msVarQuery = this.xr.query(this.x, c());
            int iMs = com.bykv.vk.openvk.component.video.ms.ah.ms.ms(msVarMs);
            if (msVarQuery != null && msVarQuery.ah != iMs) {
                if (ka.ah) {
                    com.bytedance.sdk.component.utils.sl.d("TAG_PROXY_ProxyTask", "Content-Length not match, old: " + msVarQuery.ah + ", " + iMs + ", key: " + this.x);
                }
                throw new com.bykv.vk.openvk.component.video.ms.xr.ah.xr("Content-Length not match, old length: " + msVarQuery.ah + ", new length: " + iMs + ", rawKey: " + this.ab + ", currentUrl: " + msVar + ", previousInfo: " + msVarQuery.ka);
            }
            if (!xrVar.ms()) {
                String strMs2 = com.bykv.vk.openvk.component.video.ms.ah.ms.ms(msVarMs, iXr);
                ka();
                byte[] bytes = strMs2.getBytes(com.bykv.vk.openvk.component.video.ms.ah.ms.f28ms);
                xrVar.ms(bytes, 0, bytes.length);
            }
            ka();
            File fileD = this.f88ms.d(this.x);
            if (this.h && fileD != null && fileD.length() >= xrVar.xr()) {
                com.bykv.vk.openvk.component.video.ms.ah.ms.ms(msVarMs, this.xr, this.x, this.ny.ah.f102ms);
                try {
                    xVar = new x(fileD, "rwd");
                    try {
                        try {
                            xVar.ms(xrVar.xr());
                        } catch (x.ms e) {
                            e = e;
                            com.bytedance.sdk.component.utils.sl.ms(e);
                            xVar = null;
                        }
                        if (ka.ah) {
                            com.bytedance.sdk.component.utils.sl.ms("TAG_PROXY_ProxyTask", "can write to cache file in network task, cache file size: " + fileD.length() + ", from: " + xrVar.xr());
                        }
                    } catch (Throwable th) {
                        th = th;
                        xVar2 = xVar;
                    }
                } catch (x.ms e2) {
                    e = e2;
                }
            } else {
                if (ka.ah) {
                    com.bytedance.sdk.component.utils.sl.xr("TAG_PROXY_ProxyTask", "can't write to cache file in network task, cache file size: " + fileD.length() + ", from: " + xrVar.xr());
                }
                xVar = null;
            }
            com.bykv.vk.openvk.component.video.ms.xr.xr.ms msVarQuery2 = this.xr.query(this.x, c());
            int i2 = msVarQuery2 == null ? 0 : msVarQuery2.ah;
            byte[] bArr = new byte[8192];
            InputStream inputStreamD = msVarMs.d();
            int i3 = 0;
            while (true) {
                try {
                    int i4 = inputStreamD.read(bArr);
                    if (i4 < 0) {
                        break;
                    }
                    ka();
                    if (i4 > 0) {
                        xrVar.xr(bArr, 0, i4);
                        i3 += i4;
                        if (xVar != null) {
                            try {
                                xVar.ms(bArr, 0, i4);
                            } catch (Throwable th2) {
                                xVar.ms();
                                try {
                                    if (ka.ah) {
                                        com.bytedance.sdk.component.utils.sl.d("TAG_PROXY_ProxyTask", "append to cache file error in network task!!! " + Log.getStackTraceString(th2));
                                    }
                                    xVar = null;
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            }
                        }
                        ms(i2, xrVar.xr());
                    }
                    ka();
                } catch (Throwable th4) {
                    th = th4;
                    xVar2 = xVar;
                }
                th = th4;
                xVar2 = xVar;
                i = i3;
                com.bykv.vk.openvk.component.video.ms.ah.ms.ms(msVarMs.d());
                if (xVar2 != null) {
                    xVar2.ms();
                }
                this.ah.addAndGet(i);
                this.d.addAndGet(SystemClock.elapsedRealtime() - jElapsedRealtime);
                throw th;
            }
            if (ka.ah) {
                com.bytedance.sdk.component.utils.sl.ms("TAG_PROXY_ProxyTask", "read from net complete!");
            }
            ah();
            com.bykv.vk.openvk.component.video.ms.ah.ms.ms(msVarMs.d());
            if (xVar != null) {
                xVar.ms();
            }
            this.ah.addAndGet(i3);
            this.d.addAndGet(SystemClock.elapsedRealtime() - jElapsedRealtime);
        } catch (Throwable th5) {
            th = th5;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.ms.xr.ms
    public void ms() {
        super.ms();
        ny();
    }

    private void ny() {
        com.bykv.vk.openvk.component.video.ms.xr.xr xrVar = this.ao;
        this.ao = null;
        if (xrVar != null) {
            xrVar.ms();
        }
    }

    private static class xr {
        private boolean ah;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final OutputStream f63ms;
        private int xr;

        xr(OutputStream outputStream, int i) {
            this.f63ms = outputStream;
            this.xr = i;
        }

        boolean ms() {
            return this.ah;
        }

        void ms(byte[] bArr, int i, int i2) throws com.bykv.vk.openvk.component.video.ms.xr.ah.d {
            if (this.ah) {
                return;
            }
            try {
                this.f63ms.write(bArr, i, i2);
                this.ah = true;
            } catch (IOException e) {
                throw new com.bykv.vk.openvk.component.video.ms.xr.ah.d(e);
            }
        }

        void xr(byte[] bArr, int i, int i2) throws com.bykv.vk.openvk.component.video.ms.xr.ah.d {
            try {
                this.f63ms.write(bArr, i, i2);
                this.xr += i2;
            } catch (IOException e) {
                throw new com.bykv.vk.openvk.component.video.ms.xr.ah.d(e);
            }
        }

        int xr() {
            return this.xr;
        }
    }

    static final class ms {
        Socket ah;
        ah d;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        com.bykv.vk.openvk.component.video.ms.xr.ms.ms f62ms;
        com.bykv.vk.openvk.component.video.ms.xr.xr.ah xr;

        ms() {
        }

        ms ms(com.bykv.vk.openvk.component.video.ms.xr.xr.ah ahVar) {
            if (ahVar == null) {
                throw new IllegalArgumentException("db == null");
            }
            this.xr = ahVar;
            return this;
        }

        ms ms(Socket socket) {
            if (socket == null) {
                throw new IllegalArgumentException("socket == null");
            }
            this.ah = socket;
            return this;
        }

        ms ms(ah ahVar) {
            this.d = ahVar;
            return this;
        }

        ab ms() {
            if (this.xr == null || this.ah == null) {
                throw new IllegalArgumentException();
            }
            return new ab(this);
        }
    }
}
