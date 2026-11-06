package com.bytedance.sdk.component.ny.ah;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public boolean f1275ms = false;
    public boolean xr = true;
    public Map<String, Integer> ah = null;
    public Map<String, String> d = null;
    public int ka = 10;
    public int c = 1;
    public int ab = 1;
    public int x = 10;
    public int ny = 1;
    public int ch = 1;
    public int hi = 900;
    public int sl = 120;
    public String zb = null;
    public int u = 0;
    public long ub = 0;

    public String toString() {
        StringBuilder sb = new StringBuilder(" localEnable: ");
        sb.append(this.f1275ms);
        sb.append(" probeEnable: ").append(this.xr);
        StringBuilder sbAppend = sb.append(" hostFilter: ");
        Map<String, Integer> map = this.ah;
        sbAppend.append(map != null ? map.size() : 0);
        StringBuilder sbAppend2 = sb.append(" hostMap: ");
        Map<String, String> map2 = this.d;
        sbAppend2.append(map2 != null ? map2.size() : 0);
        sb.append(" reqTo: ").append(this.ka).append("#").append(this.c).append("#").append(this.ab);
        sb.append(" reqErr: ").append(this.x).append("#").append(this.ny).append("#").append(this.ch);
        sb.append(" updateInterval: ").append(this.hi);
        sb.append(" updateRandom: ").append(this.sl);
        sb.append(" httpBlack: ").append(this.zb);
        return sb.toString();
    }
}
