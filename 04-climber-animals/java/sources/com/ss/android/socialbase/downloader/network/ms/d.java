package com.ss.android.socialbase.downloader.network.ms;

import com.bytedance.sdk.openadsdk.api.ab;
import com.ss.android.socialbase.downloader.network.ny;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class d implements ny {
    private ny ah;
    private InputStream c;
    private boolean d;
    private long ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected final Object f4730ms;
    private final List<com.ss.android.socialbase.downloader.model.ah> xr;

    public boolean ms(int i) {
        return i >= 200 && i < 300;
    }

    public void ka() throws InterruptedException {
        synchronized (this.f4730ms) {
            if (this.d && this.ah == null) {
                this.f4730ms.wait();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.ny
    public InputStream ms() throws IOException {
        InputStream inputStream = this.c;
        if (inputStream != null) {
            return inputStream;
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.network.ny
    public void d() {
        ny nyVar = this.ah;
        if (nyVar != null) {
            nyVar.d();
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.ab
    public String ms(String str) {
        ny nyVar = this.ah;
        if (nyVar != null) {
            return nyVar.ms(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.network.ab
    public int xr() throws IOException {
        ny nyVar = this.ah;
        if (nyVar != null) {
            return nyVar.xr();
        }
        return 0;
    }

    public List<com.ss.android.socialbase.downloader.model.ah> c() {
        return this.xr;
    }

    @Override // com.ss.android.socialbase.downloader.network.ab
    public void ah() {
        ny nyVar = this.ah;
        if (nyVar != null) {
            nyVar.ah();
        }
    }

    public boolean ab() {
        try {
            ny nyVar = this.ah;
            return nyVar != null && ms(nyVar.xr());
        } catch (IOException e) {
            ab.ms(e);
            return false;
        }
    }

    public boolean x() {
        return System.currentTimeMillis() - this.ka < xr.f4733ms;
    }
}
