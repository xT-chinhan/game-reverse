package com.byazt.udn;

import com.byazt.edb.fw;
import com.taptap.sdk.update.download.core.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1254, 20})
public class hn implements fw {
    public static final ArrayList<String> c;
    public boolean aj;
    public int fw;
    public List<com.byazt.auw.hn> hn;
    public final long hw;
    public final String pr;
    public boolean vk;
    public fw w;
    public long zo;
    public Map<String, String> uc = null;
    public final Object x = new Object();

    static {
        ArrayList<String> arrayList = new ArrayList<>(6);
        c = arrayList;
        arrayList.add(Util.CONTENT_LENGTH);
        arrayList.add(Util.CONTENT_RANGE);
        arrayList.add(Util.TRANSFER_ENCODING);
        arrayList.add(Util.ACCEPT_RANGES);
        arrayList.add(Util.ETAG);
        arrayList.add(Util.CONTENT_DISPOSITION);
    }

    public hn(String str, List<com.byazt.auw.hn> list, long j) {
        this.pr = str;
        this.hn = list;
        this.hw = j;
    }

    public void pr() throws Exception {
        if (this.uc != null) {
            return;
        }
        try {
            this.vk = true;
            this.w = com.byazt.lj.hn.pr(this.pr, this.hn);
            synchronized (this.x) {
                if (this.w != null) {
                    HashMap map = new HashMap();
                    this.uc = map;
                    pr(this.w, map);
                    this.fw = this.w.hw();
                    this.zo = System.currentTimeMillis();
                    this.aj = pr(this.fw);
                }
                this.vk = false;
                this.x.notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this.x) {
                if (this.w != null) {
                    HashMap map2 = new HashMap();
                    this.uc = map2;
                    pr(this.w, map2);
                    this.fw = this.w.hw();
                    this.zo = System.currentTimeMillis();
                    this.aj = pr(this.fw);
                }
                this.vk = false;
                this.x.notifyAll();
                throw th;
            }
        }
    }

    public boolean pr(int i) {
        return i >= 200 && i < 300;
    }

    private void pr(fw fwVar, Map<String, String> map) {
        if (fwVar == null || map == null) {
            return;
        }
        for (String str : c) {
            map.put(str, fwVar.pr(str));
        }
    }

    public void x() throws InterruptedException {
        synchronized (this.x) {
            if (this.vk && this.uc == null) {
                this.x.wait();
            }
        }
    }

    @Override // com.byazt.edb.fw
    public String pr(String str) {
        Map<String, String> map = this.uc;
        if (map != null) {
            return map.get(str);
        }
        fw fwVar = this.w;
        if (fwVar != null) {
            return fwVar.pr(str);
        }
        return null;
    }

    @Override // com.byazt.edb.fw
    public int hw() throws IOException {
        return this.fw;
    }

    @Override // com.byazt.edb.fw
    public void hn() {
        fw fwVar = this.w;
        if (fwVar != null) {
            fwVar.hn();
        }
    }

    public boolean c() {
        return this.aj;
    }

    public boolean uc() {
        return System.currentTimeMillis() - this.zo < hw.hw;
    }

    public boolean fw() {
        return this.vk;
    }

    public List<com.byazt.auw.hn> zo() {
        return this.hn;
    }

    public Map<String, String> aj() {
        return this.uc;
    }
}
