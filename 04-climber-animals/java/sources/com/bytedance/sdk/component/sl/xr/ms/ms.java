package com.bytedance.sdk.component.sl.xr.ms;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.DataLoaderHelper;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
import com.bykv.vk.openvk.component.video.api.ah.d;
import com.bykv.vk.openvk.component.video.api.ms.xr;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private long f1335ms;
    private String xr = "tt_video_reward_full";
    private String ah = "tt_video_brand";
    private String d = "tt_video_splash";
    private String ka = "tt_video_default";
    private String c = null;
    private String ab = null;
    private String x = null;
    private String ny = null;
    private String ch = null;
    private String hi = null;

    @Override // com.bykv.vk.openvk.component.video.api.ms.xr
    public void ka() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms.xr
    public void ms(String str) {
        if (!TextUtils.isEmpty(this.hi) && !this.hi.equals(str)) {
            this.c = null;
            this.ab = null;
            this.x = null;
            this.ny = null;
            this.ch = null;
        }
        this.hi = str;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms.xr
    public String d() {
        if (this.ch == null) {
            this.ch = this.hi + File.separator + this.ka;
            File file = new File(this.ch);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.ch;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms.xr
    public String ms() {
        if (this.ab == null) {
            this.ab = this.hi + File.separator + this.xr;
            File file = new File(this.ab);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.ab;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms.xr
    public String xr() {
        if (this.x == null) {
            this.x = this.hi + File.separator + this.ah;
            File file = new File(this.x);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.x;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms.xr
    public String ah() {
        if (this.ny == null) {
            this.ny = this.hi + File.separator + this.d;
            File file = new File(this.ny);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.ny;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms.xr
    public boolean ms(d dVar) {
        DataLoaderHelper.DataLoaderCacheInfo cacheInfoByFilePath = TTVideoEngine.getCacheInfoByFilePath(dVar.h(), dVar.ka());
        if (cacheInfoByFilePath != null) {
            boolean zZb = dVar.zb();
            this.f1335ms = cacheInfoByFilePath.mCacheSizeFromZero;
            int iXr = dVar.xr() > 0 ? dVar.xr() : dVar.c();
            if (zZb) {
                iXr = (int) dVar.sl();
            }
            if (cacheInfoByFilePath.mCacheSizeFromZero >= iXr) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms.xr
    public long xr(d dVar) {
        return this.f1335ms;
    }
}
