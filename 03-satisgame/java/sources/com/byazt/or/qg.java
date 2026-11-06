package com.byazt.or;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1717, 26})
public class qg {
    public final String cp;
    public final String d;
    public final String fs;
    public final String l;
    public final String n;
    public final String q;
    public final String qg;
    public final String rv;
    public final String s;
    public final String tj;
    public final String w;
    public final String x;

    public qg() {
        this.s = "";
        this.n = "";
        this.qg = "";
        this.q = "";
        this.l = "";
        this.w = "";
        this.x = "";
        this.fs = "";
        this.rv = "";
        this.tj = "";
        this.cp = "";
        this.d = "";
    }

    public qg(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        this.s = str;
        this.n = str2;
        this.qg = str3;
        this.q = str4;
        this.l = str5;
        this.w = str6;
        this.x = str7;
        this.fs = str8;
        this.rv = str9;
        this.tj = str10;
        this.cp = str11;
        this.d = str12;
    }

    public SparseArray<Object> n() {
        com.byazt.of.qg qgVarN = com.byazt.of.qg.n();
        qgVarN.n(AVMDLDataLoader.KeyIsLiveGetPlayCacheSec, this.s);
        qgVarN.n(8534, this.n);
        qgVarN.n(8535, this.qg);
        qgVarN.n(8536, this.q);
        qgVarN.n(8537, this.l);
        qgVarN.n(8538, this.w);
        qgVarN.n(8539, this.x);
        qgVarN.n(8540, this.fs);
        qgVarN.n(8541, this.rv);
        qgVarN.n(8542, this.tj);
        qgVarN.n(8543, this.cp);
        qgVarN.n(8544, this.d);
        return qgVarN.qg();
    }

    public String qg() {
        return this.s;
    }

    public String s() {
        return this.q;
    }

    public n n(int i, int i2) {
        switch (i) {
            case 1:
                return new n(this.l, com.byazt.ik.n.class);
            case 2:
                return new n(this.w, com.byazt.ac.n.class);
            case 3:
                return new n(this.rv, com.byazt.od.n.class);
            case 4:
            case 6:
            default:
                return null;
            case 5:
                if (i2 == 4) {
                    return new n(this.tj, com.byazt.fl.n.class);
                }
                if (i2 == 5) {
                    return new n(this.cp, com.byazt.bu.n.class);
                }
                if (i2 == 3) {
                    return new n(this.l, com.byazt.ik.n.class);
                }
                return new n(this.tj, com.byazt.fl.n.class);
            case 7:
                if (i2 == 6) {
                    return new n(this.x, com.byazt.gb.n.class);
                }
                if (i2 == 7) {
                    return new n(this.fs, com.byazt.pc.n.class);
                }
                if (i2 == 8) {
                    return new n(this.w, com.byazt.ac.n.class);
                }
                return new n(this.x, com.byazt.gb.n.class);
            case 8:
                return new n(this.fs, com.byazt.pc.n.class);
            case 9:
                break;
            case 10:
                if (i2 == 1) {
                    return new n(this.w, com.byazt.ac.n.class);
                }
                if (i2 == 2) {
                    return new n(this.fs, com.byazt.pc.n.class);
                }
                break;
        }
        return new n(this.cp, com.byazt.bu.n.class);
    }

    public boolean q() {
        return TextUtils.equals(this.d, "1");
    }

    public String toString() {
        return "GMCustomInitConfig{mAppId='" + this.n + "', mAppKey='" + this.qg + "', mADNName='" + this.s + "', mAdnInitClassName='" + this.q + "', mBannerClassName='" + this.l + "', mInterstitialClassName='" + this.w + "', mRewardClassName='" + this.x + "', mFullVideoClassName='" + this.fs + "', mSplashClassName='" + this.rv + "', mDrawClassName='" + this.cp + "', mFeedClassName='" + this.tj + "'}";
    }
}
