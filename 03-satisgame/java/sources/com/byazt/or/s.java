package com.byazt.or;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1717, 8})
public final class s {
    public final String l;
    public final String n;
    public final int q;
    public final String qg;
    public final int s;

    public s(String str, String str2, int i, int i2, String str3) {
        this.n = str;
        this.qg = str2;
        this.s = i;
        this.q = i2;
        this.l = str3;
    }

    public SparseArray<Object> n() {
        com.byazt.of.qg qgVarN = com.byazt.of.qg.n();
        qgVarN.n(AVMDLDataLoader.KeyIsLiveGetPlayCacheSec, this.n);
        qgVarN.n(2, this.qg);
        qgVarN.n(AVMDLDataLoader.KeyIsLiveMaxTrySwitchP2pTimes, Integer.valueOf(this.s));
        qgVarN.n(8094, Integer.valueOf(this.q));
        qgVarN.n(8547, this.l);
        if (com.byazt.qt.n.d().f() != null) {
            HashMap map = new HashMap();
            map.put("live_ad_custom_config", com.byazt.qt.n.d().f());
            qgVarN.n(8075, map);
        }
        return qgVarN.qg();
    }

    public int qg() {
        return this.s;
    }
}
