package com.bytedance.sdk.component.c.ah.ms;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements com.bytedance.sdk.component.c.xr, Cloneable {
    private static volatile com.bytedance.sdk.component.c.xr ab;
    private int ah;
    private File c;
    private boolean d;
    private boolean ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private long f1167ms;
    private int xr;

    @Override // com.bytedance.sdk.component.c.xr
    @ATSMethod(6)
    public boolean c() {
        return true;
    }

    public ms(int i, long j, File file) {
        this(i, 0, j, i != 0, j != 0, file);
    }

    public ms(int i, int i2, long j, boolean z, boolean z2, File file) {
        this.f1167ms = j;
        this.xr = i;
        this.ah = i2;
        this.d = z;
        this.ka = z2;
        this.c = file;
    }

    @Override // com.bytedance.sdk.component.c.xr
    @ATSMethod(1)
    public long ms() {
        return this.f1167ms;
    }

    @Override // com.bytedance.sdk.component.c.xr
    @ATSMethod(2)
    public int xr() {
        return this.xr;
    }

    @Override // com.bytedance.sdk.component.c.xr
    @ATSMethod(3)
    public boolean ah() {
        return this.d;
    }

    @Override // com.bytedance.sdk.component.c.xr
    @ATSMethod(4)
    public boolean d() {
        return this.ka;
    }

    @Override // com.bytedance.sdk.component.c.xr
    @ATSMethod(5)
    public File ka() {
        return this.c;
    }

    @Override // com.bytedance.sdk.component.c.xr
    @ATSMethod(8)
    public boolean ab() {
        return this.ah > 0;
    }

    @Override // com.bytedance.sdk.component.c.xr
    @ATSMethod(7)
    public int x() {
        return this.ah;
    }

    public static void ms(Context context, com.bytedance.sdk.component.c.xr xrVar) {
        if (xrVar != null) {
            ab = xrVar;
        } else {
            ab = ms(new File(com.bytedance.sdk.openadsdk.api.plugin.xr.xr(context), "image"));
        }
    }

    public static com.bytedance.sdk.component.c.xr ms(File file) {
        int iMin;
        long jMin;
        file.mkdirs();
        if (ab == null) {
            iMin = Math.min(Long.valueOf(Runtime.getRuntime().maxMemory()).intValue() / 16, 10485760);
            jMin = Math.min(ch() / 16, 31457280L);
        } else {
            iMin = Math.min(ab.xr() / 2, 10485760);
            jMin = Math.min(ab.ms() / 2, 31457280L);
        }
        return new ms(Math.max(iMin, AVMDLDataLoaderConfigure.DEFAULT_MAX_FACTORY_MEMORY_SIZE), Math.max(jMin, 10485760L), file);
    }

    public static com.bytedance.sdk.component.c.xr ny() {
        return ab;
    }

    private static long ch() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }
}
