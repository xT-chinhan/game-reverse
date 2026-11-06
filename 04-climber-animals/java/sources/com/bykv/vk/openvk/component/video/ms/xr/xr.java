package com.bykv.vk.openvk.component.video.ms.xr;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class xr extends com.bykv.vk.openvk.component.video.ms.xr.ms {
    private final InterfaceC0185xr ao;
    private volatile x.ms h;
    private volatile com.bykv.vk.openvk.component.video.ms.xr.ah.xr qv;
    final Object u;
    private final int ub;
    final Object zb;

    /* JADX INFO: renamed from: com.bykv.vk.openvk.component.video.ms.xr.xr$xr, reason: collision with other inner class name */
    public interface InterfaceC0185xr {
        void ms(xr xrVar);
    }

    xr(ms msVar) {
        super(msVar.d, msVar.ka);
        this.ub = msVar.ab;
        this.ao = msVar.ny;
        this.zb = this;
        this.ab = msVar.f107ms;
        this.x = msVar.xr;
        this.c = msVar.c;
        this.ch = msVar.ah;
        this.ny = msVar.x;
        this.u = msVar.ch;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f88ms.ms(this.x);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            ch();
        } catch (Throwable unused) {
        }
        this.d.set(SystemClock.elapsedRealtime() - jElapsedRealtime);
        this.f88ms.xr(this.x);
        InterfaceC0185xr interfaceC0185xr = this.ao;
        if (interfaceC0185xr != null) {
            interfaceC0185xr.ms(this);
        }
    }

    x.ms x() {
        return this.h;
    }

    com.bykv.vk.openvk.component.video.ms.xr.ah.xr ny() {
        return this.qv;
    }

    private boolean ch() throws com.bykv.vk.openvk.component.video.ms.xr.ah.ms {
        while (this.ch.ms()) {
            ka();
            sl.ms msVarXr = this.ch.xr();
            try {
                ms(msVarXr);
                return true;
            } catch (com.bykv.vk.openvk.component.video.ms.xr.ah.ah unused) {
                msVarXr.ms();
                Boolean.valueOf(ab());
                String str = this.ab;
            } catch (com.bykv.vk.openvk.component.video.ms.xr.ah.xr e) {
                this.qv = e;
                return false;
            } catch (x.ms e2) {
                this.h = e2;
                Boolean.valueOf(ab());
                String str2 = this.ab;
                return false;
            } catch (IOException e3) {
                if (e3 instanceof SocketTimeoutException) {
                    msVarXr.xr();
                }
                if (!xr()) {
                    Boolean.valueOf(ab());
                    String str3 = this.ab;
                }
            } catch (Throwable unused2) {
                return false;
            }
        }
        return false;
    }

    private void ms(sl.ms msVar) throws Throwable {
        File fileAh = this.f88ms.ah(this.x);
        long length = fileAh.length();
        int i = this.ub;
        if (i > 0 && length >= i) {
            if (ka.ah) {
                com.bytedance.sdk.component.utils.sl.ms("TAG_PROXY_DownloadTask", "no necessary to download for " + this.x + ", cache file size: " + length + ", max: " + this.ub);
                return;
            }
            return;
        }
        int iC = c();
        com.bykv.vk.openvk.component.video.ms.xr.xr.ms msVarQuery = this.xr.query(this.x, iC);
        if (msVarQuery != null && length >= msVarQuery.ah) {
            if (ka.ah) {
                com.bytedance.sdk.component.utils.sl.ms("TAG_PROXY_DownloadTask", "file download complete, key: " + this.x);
                return;
            }
            return;
        }
        ka();
        int i2 = (int) length;
        com.bykv.vk.openvk.component.video.ms.xr.ka.ms msVarMs = ms(msVar, i2, this.ub, "GET");
        if (msVarMs == null) {
            return;
        }
        boolean z = true;
        x xVar = null;
        try {
            ka();
            String strMs = com.bykv.vk.openvk.component.video.ms.ah.ms.ms(msVarMs, this.ny == null && ka.ka, true);
            if (strMs != null) {
                throw new com.bykv.vk.openvk.component.video.ms.xr.ah.ah(strMs + ", rawKey: " + this.ab + ", url: " + msVar);
            }
            int iMs = com.bykv.vk.openvk.component.video.ms.ah.ms.ms(msVarMs);
            if (msVarQuery != null && msVarQuery.ah != iMs) {
                if (ka.ah) {
                    com.bytedance.sdk.component.utils.sl.d("TAG_PROXY_DownloadTask", "Content-Length not match, old: " + msVarQuery.ah + ", " + iMs + ", key: " + this.x);
                }
                throw new com.bykv.vk.openvk.component.video.ms.xr.ah.xr("Content-Length not match, old length: " + msVarQuery.ah + ", new length: " + iMs + ", rawKey: " + this.ab + ", currentUrl: " + msVar + ", previousInfo: " + msVarQuery.ka);
            }
            com.bykv.vk.openvk.component.video.ms.ah.ms.ms(msVarMs, this.xr, this.x, iC);
            com.bykv.vk.openvk.component.video.ms.xr.xr.ms msVarQuery2 = this.xr.query(this.x, iC);
            int i3 = msVarQuery2 == null ? 0 : msVarQuery2.ah;
            InputStream inputStreamD = msVarMs.d();
            x xVar2 = new x(fileAh, ka.d ? "rwd" : "rw");
            try {
                xVar2.ms(length);
                if (ka.ah) {
                    com.bytedance.sdk.component.utils.sl.ms("TAG_PROXY_DownloadTask", "preload start from: ".concat(String.valueOf(length)));
                }
                byte[] bArr = new byte[8192];
                while (true) {
                    int i4 = inputStreamD.read(bArr);
                    if (i4 >= 0) {
                        ka();
                        if (i4 > 0) {
                            xVar2.ms(bArr, 0, i4);
                            i2 += i4;
                            if (this.ny != null) {
                                synchronized (this.zb) {
                                    this.zb.notifyAll();
                                }
                            }
                            this.ah.addAndGet(i4);
                            ms(i3, i2);
                        }
                        int i5 = this.ub;
                        if (i5 > 0 && i2 >= i5) {
                            if (ka.ah) {
                                com.bytedance.sdk.component.utils.sl.xr("TAG_PROXY_DownloadTask", "download, more data received, currentCacheFileSize: " + i2 + ", max: " + this.ub);
                            }
                            com.bykv.vk.openvk.component.video.ms.ah.ms.ms(msVarMs.d());
                            xVar2.ms();
                            ms();
                            if (ka.ah) {
                                com.bytedance.sdk.component.utils.sl.xr("TAG_PROXY_DownloadTask", "cancel call");
                                return;
                            }
                            return;
                        }
                        ka();
                    } else {
                        try {
                            ah();
                            if (ka.ah) {
                                com.bytedance.sdk.component.utils.sl.ms("TAG_PROXY_DownloadTask", "download succeed, no need to cancel call");
                            }
                            com.bykv.vk.openvk.component.video.ms.ah.ms.ms(msVarMs.d());
                            xVar2.ms();
                            return;
                        } catch (Throwable th) {
                            th = th;
                            xVar = xVar2;
                            z = false;
                        }
                    }
                    com.bykv.vk.openvk.component.video.ms.ah.ms.ms(msVarMs.d());
                    if (xVar != null) {
                        xVar.ms();
                    }
                    if (z) {
                        ms();
                        if (ka.ah) {
                            com.bytedance.sdk.component.utils.sl.xr("TAG_PROXY_DownloadTask", "cancel call");
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                xVar = xVar2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    static final class ms {
        int ab;
        sl ah;
        List<ny.xr> c;
        Object ch;
        com.bykv.vk.openvk.component.video.ms.xr.ms.ms d;
        com.bykv.vk.openvk.component.video.ms.xr.xr.ah ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        String f107ms;
        InterfaceC0185xr ny;
        ny x;
        String xr;

        ms() {
        }

        ms ms(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("rawKey == null");
            }
            this.f107ms = str;
            return this;
        }

        ms xr(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("key == null");
            }
            this.xr = str;
            return this;
        }

        ms ms(sl slVar) {
            if (slVar == null) {
                throw new IllegalArgumentException("urls is empty");
            }
            this.ah = slVar;
            return this;
        }

        ms ms(com.bykv.vk.openvk.component.video.ms.xr.ms.ms msVar) {
            if (msVar == null) {
                throw new IllegalArgumentException("cache == null");
            }
            this.d = msVar;
            return this;
        }

        ms ms(com.bykv.vk.openvk.component.video.ms.xr.xr.ah ahVar) {
            if (ahVar == null) {
                throw new IllegalArgumentException("db == null");
            }
            this.ka = ahVar;
            return this;
        }

        ms ms(List<ny.xr> list) {
            this.c = list;
            return this;
        }

        ms ms(int i) {
            this.ab = i;
            return this;
        }

        ms ms(InterfaceC0185xr interfaceC0185xr) {
            this.ny = interfaceC0185xr;
            return this;
        }

        ms ms(ny nyVar) {
            this.x = nyVar;
            return this;
        }

        ms ms(Object obj) {
            this.ch = obj;
            return this;
        }

        xr ms() {
            if (this.d == null || this.ka == null || TextUtils.isEmpty(this.f107ms) || TextUtils.isEmpty(this.xr) || this.ah == null) {
                throw new IllegalArgumentException();
            }
            return new xr(this);
        }
    }
}
