package com.bykv.vk.openvk.component.video.ms.ms;

import android.content.Context;
import android.media.MediaDataSource;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.ah.d;
import com.bykv.vk.openvk.component.video.ms.ms.ms.ah;
import com.bykv.vk.openvk.component.video.ms.ms.ms.xr;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class ms extends MediaDataSource {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final ConcurrentHashMap<String, ms> f53ms = new ConcurrentHashMap<>();
    private long ah = -2147483648L;
    private final Context d;
    private final d ka;
    private final ah xr;

    public ms(Context context, d dVar) {
        this.d = context;
        this.ka = dVar;
        this.xr = new xr(context, dVar);
    }

    @Override // android.media.MediaDataSource
    public int readAt(long j, byte[] bArr, int i, int i2) throws IOException {
        return this.xr.ms(j, bArr, i, i2);
    }

    @Override // android.media.MediaDataSource
    public long getSize() throws IOException {
        if (this.ah == -2147483648L) {
            if (this.d == null || TextUtils.isEmpty(this.ka.ao())) {
                return -1L;
            }
            this.ah = this.xr.d();
            com.bykv.vk.openvk.component.video.api.c.ah.ms("SdkMediaDataSource", "getSize: " + this.ah);
        }
        return this.ah;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        com.bykv.vk.openvk.component.video.api.c.ah.ms("SdkMediaDataSource", "close: ", this.ka.ao());
        ah ahVar = this.xr;
        if (ahVar != null) {
            ahVar.ah();
        }
        f53ms.remove(this.ka.h());
    }

    public d ms() {
        return this.ka;
    }

    public static ms ms(Context context, d dVar) {
        ms msVar = new ms(context, dVar);
        f53ms.put(dVar.h(), msVar);
        return msVar;
    }
}
