package com.ss.android.socialbase.downloader.network.ms;

import com.ss.android.socialbase.downloader.network.ab;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ah implements ab {
    private static final ArrayList<String> ka;
    private int ab;
    protected List<com.ss.android.socialbase.downloader.model.ah> ah;
    private boolean ch;
    private ab hi;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected final String f4729ms;
    private boolean ny;
    private long x;
    protected final long xr;
    private Map<String, String> c = null;
    protected final Object d = new Object();

    public boolean ms(int i) {
        return i >= 200 && i < 300;
    }

    static {
        ArrayList<String> arrayList = new ArrayList<>(6);
        ka = arrayList;
        arrayList.add("Content-Length");
        arrayList.add("Content-Range");
        arrayList.add("Transfer-Encoding");
        arrayList.add("Accept-Ranges");
        arrayList.add("Etag");
        arrayList.add("Content-Disposition");
    }

    public ah(String str, List<com.ss.android.socialbase.downloader.model.ah> list, long j) {
        this.f4729ms = str;
        this.ah = list;
        this.xr = j;
    }

    public void ms() throws Exception {
        if (this.c != null) {
            return;
        }
        try {
            this.ch = true;
            this.hi = com.ss.android.socialbase.downloader.downloader.ah.ms(this.f4729ms, this.ah);
            synchronized (this.d) {
                if (this.hi != null) {
                    HashMap map = new HashMap();
                    this.c = map;
                    ms(this.hi, map);
                    this.ab = this.hi.xr();
                    this.x = System.currentTimeMillis();
                    this.ny = ms(this.ab);
                }
                this.ch = false;
                this.d.notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this.d) {
                if (this.hi != null) {
                    HashMap map2 = new HashMap();
                    this.c = map2;
                    ms(this.hi, map2);
                    this.ab = this.hi.xr();
                    this.x = System.currentTimeMillis();
                    this.ny = ms(this.ab);
                }
                this.ch = false;
                this.d.notifyAll();
                throw th;
            }
        }
    }

    private void ms(ab abVar, Map<String, String> map) {
        if (abVar == null || map == null) {
            return;
        }
        for (String str : ka) {
            map.put(str, abVar.ms(str));
        }
    }

    public void d() throws InterruptedException {
        synchronized (this.d) {
            if (this.ch && this.c == null) {
                this.d.wait();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.ab
    public String ms(String str) {
        Map<String, String> map = this.c;
        if (map != null) {
            return map.get(str);
        }
        ab abVar = this.hi;
        if (abVar != null) {
            return abVar.ms(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.network.ab
    public int xr() throws IOException {
        return this.ab;
    }

    @Override // com.ss.android.socialbase.downloader.network.ab
    public void ah() {
        ab abVar = this.hi;
        if (abVar != null) {
            abVar.ah();
        }
    }

    public boolean ka() {
        return this.ny;
    }

    public boolean c() {
        return System.currentTimeMillis() - this.x < xr.xr;
    }

    public boolean ab() {
        return this.ch;
    }

    public List<com.ss.android.socialbase.downloader.model.ah> x() {
        return this.ah;
    }

    public Map<String, String> ny() {
        return this.c;
    }
}
