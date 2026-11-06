package com.byazt.gn;

import android.text.TextUtils;
import com.byazt.ihe.m;
import com.bykv.vk.component.ttvideo.DataLoaderHelper;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1460, 37})
public class pr implements com.byazt.ihe.pr {
    public long pr;
    public String hw = "tt_video_reward_full";
    public String hn = "tt_video_brand";
    public String x = "tt_video_splash";
    public String c = "tt_video_default";
    public String uc = null;
    public String fw = null;
    public String zo = null;
    public String aj = null;
    public String vk = null;
    public String w = null;

    @Override // com.byazt.ihe.pr
    public void pr(String str) {
        if (!TextUtils.isEmpty(this.w) && !this.w.equals(str)) {
            this.uc = null;
            this.fw = null;
            this.zo = null;
            this.aj = null;
            this.vk = null;
        }
        this.w = str;
    }

    @Override // com.byazt.ihe.pr
    public String pr() {
        if (this.vk == null) {
            this.vk = this.w + File.separator + this.c;
            File file = new File(this.vk);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.vk;
    }

    @Override // com.byazt.ihe.pr
    public String hw() {
        if (this.fw == null) {
            this.fw = this.w + File.separator + this.hw;
            File file = new File(this.fw);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.fw;
    }

    @Override // com.byazt.ihe.pr
    public String hn() {
        if (this.zo == null) {
            this.zo = this.w + File.separator + this.hn;
            File file = new File(this.zo);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.zo;
    }

    @Override // com.byazt.ihe.pr
    public String x() {
        if (this.aj == null) {
            this.aj = this.w + File.separator + this.x;
            File file = new File(this.aj);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.aj;
    }

    @Override // com.byazt.ihe.pr
    public void c() {
    }

    @Override // com.byazt.ihe.pr
    public boolean pr(m mVar) {
        DataLoaderHelper.DataLoaderCacheInfo cacheInfoByFilePath = TTVideoEngine.getCacheInfoByFilePath(mVar.fo(), mVar.c());
        if (cacheInfoByFilePath == null) {
            return false;
        }
        boolean zYb = mVar.yb();
        this.pr = cacheInfoByFilePath.mCacheSizeFromZero;
        int iFw = mVar.fw();
        if (zYb) {
            iFw = (int) mVar.nt();
        }
        return cacheInfoByFilePath.mCacheSizeFromZero >= ((long) iFw);
    }

    @Override // com.byazt.ihe.pr
    public long hw(m mVar) {
        return this.pr;
    }
}
