package com.smartdigimkt.i;

import android.content.Intent;
import com.bykv.vk.component.ttvideo.player.C;
import com.smartdigimkt.dlopt.activity.ApkConfirmDialogActivity;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ b b;

    public a(b bVar, boolean z) {
        this.b = bVar;
        this.a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar = this.b;
        ApkConfirmDialogActivity.c = bVar.b;
        ApkConfirmDialogActivity.d = bVar.a;
        Intent intent = new Intent(this.b.c, (Class<?>) ApkConfirmDialogActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra("flag_apk_exists", this.a);
        this.b.c.startActivity(intent);
    }
}
