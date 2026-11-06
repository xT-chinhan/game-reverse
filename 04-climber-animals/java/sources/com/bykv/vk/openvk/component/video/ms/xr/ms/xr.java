package com.bykv.vk.openvk.component.video.ms.xr.ms;

import android.content.Context;
import com.bykv.vk.openvk.component.video.ms.xr.d;
import com.bykv.vk.openvk.component.video.ms.xr.ka;
import com.bytedance.sdk.component.ch.ny;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class xr extends ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public final File f98ms;

    public void ms() {
        com.bykv.vk.openvk.component.video.ms.ah.ms.ms(new ny("clear") { // from class: com.bykv.vk.openvk.component.video.ms.xr.ms.xr.1
            @Override // java.lang.Runnable
            public void run() {
                xr.this.xr();
            }
        });
    }

    public void xr() {
        d.ah().d();
        Context context = ka.getContext();
        if (context != null) {
            com.bykv.vk.openvk.component.video.ms.xr.xr.ah.ms(context).ms(1);
        }
        for (File file : this.f98ms.listFiles()) {
            try {
                file.delete();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.ms.xr.ms.ms
    public File ah(String str) {
        return ka(str);
    }

    @Override // com.bykv.vk.openvk.component.video.ms.xr.ms.ms
    public File d(String str) {
        return ka(str);
    }

    File ka(String str) {
        return new File(this.f98ms, str);
    }
}
