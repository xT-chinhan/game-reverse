package com.byazt.dl;

import android.os.Environment;
import android.os.StatFs;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 202, 19})
public class n implements com.byazt.si.qg, Cloneable {
    public static volatile com.byazt.si.qg x;
    public boolean l;
    public long n;
    public boolean q;
    public int qg;
    public int s;
    public File w;

    @Override // com.byazt.si.qg
    public boolean w() {
        return true;
    }

    public n(int i, long j, File file) {
        this(i, 524288, j, i != 0, j != 0, file);
    }

    public n(int i, int i2, long j, boolean z, boolean z2, File file) {
        this.n = j;
        this.qg = i;
        this.s = i2;
        this.q = z;
        this.l = z2;
        this.w = file;
    }

    @Override // com.byazt.si.qg
    public long n() {
        return this.n;
    }

    @Override // com.byazt.si.qg
    public int qg() {
        return this.qg;
    }

    @Override // com.byazt.si.qg
    public boolean s() {
        return this.q;
    }

    @Override // com.byazt.si.qg
    public boolean q() {
        return this.l;
    }

    @Override // com.byazt.si.qg
    public File l() {
        return this.w;
    }

    @Override // com.byazt.si.qg
    public boolean x() {
        return this.s > 0;
    }

    @Override // com.byazt.si.qg
    public int fs() {
        return this.s;
    }

    public static void n(com.byazt.si.qg qgVar) {
        if (qgVar != null) {
            x = qgVar;
            return;
        }
        throw new IllegalStateException("CacheConfig defaultConfig cannot be null");
    }

    public static com.byazt.si.qg n(File file) {
        int iMin;
        long jMin;
        file.mkdirs();
        if (x == null) {
            iMin = Math.min(Long.valueOf(Runtime.getRuntime().maxMemory()).intValue() / 16, 10485760);
            jMin = Math.min(tj() / 16, 31457280L);
        } else {
            iMin = Math.min(x.qg() / 2, 10485760);
            jMin = Math.min(x.n() / 2, 31457280L);
        }
        return new n(Math.max(iMin, AVMDLDataLoaderConfigure.DEFAULT_MAX_FACTORY_MEMORY_SIZE), Math.max(jMin, 10485760L), file);
    }

    public static com.byazt.si.qg rv() {
        return x;
    }

    private static long tj() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }
}
