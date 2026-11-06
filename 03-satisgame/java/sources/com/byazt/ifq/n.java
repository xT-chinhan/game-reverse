package com.byazt.ifq;

import android.text.TextUtils;
import com.byazt.ej.k;
import com.bykv.vk.component.ttvideo.DataLoaderHelper;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 885, 19})
public class n implements com.byazt.ej.n {
    public long n;
    public String qg = "tt_video_reward_full";
    public String s = "tt_video_brand";
    public String q = "tt_video_splash";
    public String l = "tt_video_default";
    public String w = null;
    public String x = null;
    public String fs = null;
    public String rv = null;
    public String tj = null;
    public String cp = null;

    @Override // com.byazt.ej.n
    public void l() {
    }

    @Override // com.byazt.ej.n
    public void n(String str) {
        if (!TextUtils.isEmpty(this.cp) && !this.cp.equals(str)) {
            this.w = null;
            this.x = null;
            this.fs = null;
            this.rv = null;
            this.tj = null;
        }
        this.cp = str;
    }

    @Override // com.byazt.ej.n
    public String n() {
        if (this.tj == null) {
            this.tj = this.cp + File.separator + this.l;
            File file = new File(this.tj);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.tj;
    }

    @Override // com.byazt.ej.n
    public String qg() {
        if (this.x == null) {
            this.x = this.cp + File.separator + this.qg;
            File file = new File(this.x);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.x;
    }

    @Override // com.byazt.ej.n
    public String s() {
        if (this.fs == null) {
            this.fs = this.cp + File.separator + this.s;
            File file = new File(this.fs);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.fs;
    }

    @Override // com.byazt.ej.n
    public String q() {
        if (this.rv == null) {
            this.rv = this.cp + File.separator + this.q;
            File file = new File(this.rv);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.rv;
    }

    @Override // com.byazt.ej.n
    public boolean n(k kVar) {
        DataLoaderHelper.DataLoaderCacheInfo cacheInfoByFilePath = TTVideoEngine.getCacheInfoByFilePath(kVar.wm(), kVar.l());
        if (cacheInfoByFilePath != null) {
            boolean zHd = kVar.hd();
            this.n = cacheInfoByFilePath.mCacheSizeFromZero;
            int iX = kVar.x();
            if (zHd) {
                iX = (int) kVar.cy();
            }
            if (cacheInfoByFilePath.mCacheSizeFromZero >= iX) {
                return true;
            }
        }
        return false;
    }

    @Override // com.byazt.ej.n
    public long qg(k kVar) {
        return this.n;
    }
}
