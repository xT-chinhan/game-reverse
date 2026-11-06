package com.byazt.bbo;

import android.os.Environment;
import android.os.StatFs;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2017, 37})
public class pr implements com.byazt.ld.hw, Cloneable {
    public static volatile com.byazt.ld.hw fw;
    public boolean c;
    public int hn;
    public int hw;
    public long pr;
    public File uc;
    public boolean x;

    public pr(int i, long j, File file) {
        this(i, 524288, j, i != 0, j != 0, file);
    }

    public pr(int i, int i2, long j, boolean z, boolean z2, File file) {
        this.pr = j;
        this.hw = i;
        this.hn = i2;
        this.x = z;
        this.c = z2;
        this.uc = file;
    }

    @Override // com.byazt.ld.hw
    public long pr() {
        return this.pr;
    }

    @Override // com.byazt.ld.hw
    public int hw() {
        return this.hw;
    }

    @Override // com.byazt.ld.hw
    public boolean hn() {
        return this.x;
    }

    @Override // com.byazt.ld.hw
    public boolean x() {
        return this.c;
    }

    @Override // com.byazt.ld.hw
    public File c() {
        return this.uc;
    }

    @Override // com.byazt.ld.hw
    public boolean uc() {
        return true;
    }

    @Override // com.byazt.ld.hw
    public boolean fw() {
        return this.hn > 0;
    }

    @Override // com.byazt.ld.hw
    public int zo() {
        return this.hn;
    }

    public static void pr(com.byazt.ld.hw hwVar) {
        if (hwVar != null) {
            fw = hwVar;
            return;
        }
        throw new IllegalStateException("CacheConfig defaultConfig cannot be null");
    }

    public static com.byazt.ld.hw pr(File file) {
        int iMin;
        long jMin;
        file.mkdirs();
        if (fw == null) {
            iMin = Math.min(Long.valueOf(Runtime.getRuntime().maxMemory()).intValue() / 16, 10485760);
            jMin = Math.min(vk() / 16, 31457280L);
        } else {
            iMin = Math.min(fw.hw() / 2, 10485760);
            jMin = Math.min(fw.pr() / 2, 31457280L);
        }
        return new pr(Math.max(iMin, AVMDLDataLoaderConfigure.DEFAULT_MAX_FACTORY_MEMORY_SIZE), Math.max(jMin, 10485760L), file);
    }

    public static com.byazt.ld.hw aj() {
        return fw;
    }

    private static long vk() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }
}
