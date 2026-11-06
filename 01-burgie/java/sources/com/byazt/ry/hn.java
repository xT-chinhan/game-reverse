package com.byazt.ry;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 21, 20})
public class hn {
    public boolean pr = false;
    public boolean hw = true;
    public Map<String, Integer> hn = null;
    public Map<String, String> x = null;
    public int c = 10;
    public int uc = 1;
    public int fw = 1;
    public int zo = 10;
    public int aj = 1;
    public int vk = 1;
    public int w = AVMDLDataLoader.KeyIsMaxIpCountEachDomain;
    public int k = 120;
    public String m = null;
    public int g = 0;
    public long ho = 0;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" localEnable: ").append(this.pr);
        sb.append(" probeEnable: ").append(this.hw);
        StringBuilder sbAppend = sb.append(" hostFilter: ");
        Map<String, Integer> map = this.hn;
        sbAppend.append(map != null ? map.size() : 0);
        StringBuilder sbAppend2 = sb.append(" hostMap: ");
        Map<String, String> map2 = this.x;
        sbAppend2.append(map2 != null ? map2.size() : 0);
        sb.append(" reqTo: ").append(this.c).append("#").append(this.uc).append("#").append(this.fw);
        sb.append(" reqErr: ").append(this.zo).append("#").append(this.aj).append("#").append(this.vk);
        sb.append(" updateInterval: ").append(this.w);
        sb.append(" updateRandom: ").append(this.k);
        sb.append(" httpBlack: ").append(this.m);
        return sb.toString();
    }
}
