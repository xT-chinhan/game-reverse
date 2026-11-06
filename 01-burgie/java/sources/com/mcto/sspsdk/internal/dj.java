package com.mcto.sspsdk.internal;

import android.media.MediaPlayer;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class dj implements MediaPlayer.OnErrorListener {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ fj c;

    public dj(fj fjVar, String str, String str2) {
        this.c = fjVar;
        this.a = str;
        this.b = str2;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        File file = new File(this.a);
        n4.a().b(file, this.b);
        p4.a(file);
        li liVar = this.c.o;
        if (liVar != null) {
            liVar.a(0);
        }
        return false;
    }
}
