package com.mcto.sspsdk.internal;

import android.media.MediaPlayer;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class ri implements MediaPlayer.OnErrorListener {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ ji c;

    public ri(String str, String str2, ji jiVar) {
        this.a = str;
        this.b = str2;
        this.c = jiVar;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        File file = new File(this.a);
        n4.a().b(file, this.b);
        p4.a(file);
        ji jiVar = this.c;
        jiVar.c.a(jiVar.b, 9, "video err:" + i + "," + i2);
        return false;
    }
}
