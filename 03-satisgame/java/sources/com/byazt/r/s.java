package com.byazt.r;

import com.byazt.m.x;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 889, 8})
public class s implements x {
    public static final ArrayList<String> l;
    public x cp;
    public long fs;
    public final String n;
    public final long qg;
    public boolean rv;
    public List<com.byazt.wm.s> s;
    public boolean tj;
    public int x;
    public Map<String, String> w = null;
    public final Object q = new Object();

    public boolean n(int i) {
        return i >= 200 && i < 300;
    }

    static {
        ArrayList<String> arrayList = new ArrayList<>(6);
        l = arrayList;
        arrayList.add("Content-Length");
        arrayList.add("Content-Range");
        arrayList.add("Transfer-Encoding");
        arrayList.add("Accept-Ranges");
        arrayList.add("Etag");
        arrayList.add("Content-Disposition");
    }

    public s(String str, List<com.byazt.wm.s> list, long j) {
        this.n = str;
        this.s = list;
        this.qg = j;
    }

    public void n() throws Exception {
        if (this.w != null) {
            return;
        }
        try {
            this.tj = true;
            this.cp = com.byazt.xv.s.n(this.n, this.s);
            synchronized (this.q) {
                if (this.cp != null) {
                    HashMap map = new HashMap();
                    this.w = map;
                    n(this.cp, map);
                    this.x = this.cp.qg();
                    this.fs = System.currentTimeMillis();
                    this.rv = n(this.x);
                }
                this.tj = false;
                this.q.notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this.q) {
                if (this.cp != null) {
                    HashMap map2 = new HashMap();
                    this.w = map2;
                    n(this.cp, map2);
                    this.x = this.cp.qg();
                    this.fs = System.currentTimeMillis();
                    this.rv = n(this.x);
                }
                this.tj = false;
                this.q.notifyAll();
                throw th;
            }
        }
    }

    private void n(x xVar, Map<String, String> map) {
        if (xVar == null || map == null) {
            return;
        }
        for (String str : l) {
            map.put(str, xVar.n(str));
        }
    }

    public void q() throws InterruptedException {
        synchronized (this.q) {
            if (this.tj && this.w == null) {
                this.q.wait();
            }
        }
    }

    @Override // com.byazt.m.x
    public String n(String str) {
        Map<String, String> map = this.w;
        if (map != null) {
            return map.get(str);
        }
        x xVar = this.cp;
        if (xVar != null) {
            return xVar.n(str);
        }
        return null;
    }

    @Override // com.byazt.m.x
    public int qg() throws IOException {
        return this.x;
    }

    @Override // com.byazt.m.x
    public void s() {
        x xVar = this.cp;
        if (xVar != null) {
            xVar.s();
        }
    }

    public boolean l() {
        return this.rv;
    }

    public boolean w() {
        return System.currentTimeMillis() - this.fs < qg.qg;
    }

    public boolean x() {
        return this.tj;
    }

    public List<com.byazt.wm.s> fs() {
        return this.s;
    }

    public Map<String, String> rv() {
        return this.w;
    }
}
