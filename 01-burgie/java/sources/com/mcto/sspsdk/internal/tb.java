package com.mcto.sspsdk.internal;

import android.media.MediaPlayer;
import android.net.Uri;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class tb implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;
    public final /* synthetic */ zb c;

    public tb(zb zbVar, String str, int i) {
        this.c = zbVar;
        this.a = str;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            zb zbVar = this.c;
            MediaPlayer mediaPlayer = zbVar.b;
            if (mediaPlayer == null) {
                zbVar.onError(mediaPlayer, -1, 0);
                return;
            }
            String strC = gj.c(this.a);
            HashMap map = new HashMap();
            StringBuilder sb = new StringBuilder();
            y4 y4Var = y4.r;
            map.put("User-Agent", sb.append(y4Var.f()).append(";QYPlayer/Android/").append(y4Var.c()).toString());
            this.c.b.setDataSource(jd.a, Uri.parse(strC), map);
            this.c.b.prepareAsync();
            this.c.e.set(false);
            this.c.f.removeMessages(110);
            this.c.f.sendEmptyMessageDelayed(110, zb.g);
        } catch (Exception e) {
            r9.a("ssp_media", this.b + ", setDataSource: ", e);
            zb zbVar2 = this.c;
            zbVar2.onError(zbVar2.b, -1, 0);
        }
    }
}
