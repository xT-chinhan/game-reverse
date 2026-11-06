package com.smartdigimkt.j;

import android.content.Intent;
import com.smartdigimkt.dlopt.common.service.ApkDownloadService;

/* JADX INFO: loaded from: classes3.dex */
public final class r implements Runnable {
    public final /* synthetic */ com.smartdigimkt.k.r a;
    public final /* synthetic */ String b;
    public final /* synthetic */ u c;

    public r(u uVar, com.smartdigimkt.k.r rVar, String str) {
        this.c = uVar;
        this.a = rVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.a.s = com.smartdigimkt.k.c.IDLE;
            com.smartdigimkt.o.b bVar = this.c.m;
            if (bVar != null) {
                String str = this.b;
                ApkDownloadService apkDownloadService = bVar.a;
                int i = ApkDownloadService.b;
                apkDownloadService.a(str);
                return;
            }
            Intent intent = new Intent();
            intent.setClass(this.c.a, ApkDownloadService.class);
            intent.putExtra("extra_unique_id", this.b);
            u uVar = this.c;
            uVar.a.bindService(intent, uVar.n, 1);
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
