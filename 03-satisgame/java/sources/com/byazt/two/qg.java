package com.byazt.two;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 802, 26})
public class qg {
    public boolean n = false;
    public boolean qg = true;
    public Map<String, Integer> s = null;
    public Map<String, String> q = null;
    public int l = 10;
    public int w = 1;
    public int x = 1;
    public int fs = 10;
    public int rv = 1;
    public int tj = 1;
    public int cp = AVMDLDataLoader.KeyIsMaxIpCountEachDomain;
    public int d = 120;
    public String oa = null;
    public int sz = 0;
    public long k = 0;

    public String toString() {
        StringBuilder sb = new StringBuilder(" localEnable: ");
        sb.append(this.n);
        sb.append(" probeEnable: ").append(this.qg);
        StringBuilder sbAppend = sb.append(" hostFilter: ");
        Map<String, Integer> map = this.s;
        sbAppend.append(map != null ? map.size() : 0);
        StringBuilder sbAppend2 = sb.append(" hostMap: ");
        Map<String, String> map2 = this.q;
        sbAppend2.append(map2 != null ? map2.size() : 0);
        sb.append(" reqTo: ").append(this.l).append("#").append(this.w).append("#").append(this.x);
        sb.append(" reqErr: ").append(this.fs).append("#").append(this.rv).append("#").append(this.tj);
        sb.append(" updateInterval: ").append(this.cp);
        sb.append(" updateRandom: ").append(this.d);
        sb.append(" httpBlack: ").append(this.oa);
        return sb.toString();
    }
}
