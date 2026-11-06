package com.mcto.sspsdk.internal;

import android.media.MediaPlayer;
import com.mcto.sspsdk.component.imageview.QYNiceImageView;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class ud implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnVideoSizeChangedListener {
    public final /* synthetic */ vd a;

    public ud(vd vdVar) {
        this.a = vdVar;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        vd vdVar = this.a;
        int i2 = vdVar.d;
        xe xeVar = vdVar.b;
        xeVar.a.getClass();
        p7 p7Var = xeVar.a.D;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        vd vdVar = this.a;
        int i = vdVar.d;
        xe xeVar = vdVar.b;
        QYNiceImageView qYNiceImageView = xeVar.a.v;
        if (qYNiceImageView != null) {
            qYNiceImageView.setVisibility(0);
        }
        xeVar.a.a(8);
        gf gfVar = xeVar.a;
        gfVar.a = 5;
        gfVar.f();
        gf gfVar2 = xeVar.a;
        p7 p7Var = gfVar2.D;
        if (p7Var != null) {
            p7Var.a(gfVar2.B);
        }
        if (this.a.j) {
            mediaPlayer.start();
            this.a.b.a();
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        vd vdVar = this.a;
        int i3 = vdVar.d;
        if (i == -38) {
            return true;
        }
        xe xeVar = vdVar.b;
        QYNiceImageView qYNiceImageView = xeVar.a.v;
        if (qYNiceImageView != null) {
            qYNiceImageView.setVisibility(0);
        }
        xeVar.a.a(8);
        gf gfVar = xeVar.a;
        gfVar.a = -1;
        gfVar.f();
        p7 p7Var = xeVar.a.D;
        if (p7Var != null) {
            p7Var.a(i, i2);
        }
        gf gfVar2 = xeVar.a;
        if (gfVar2.e == 1) {
            gfVar2.e = 2;
            HashMap map = new HashMap(2);
            map.put("pec", String.valueOf(i));
            map.put("pem", String.valueOf(i2));
            map.put(BreakpointSQLiteKey.URL, xeVar.a.q);
            l lVarA = l.a();
            p pVar = xeVar.a.B;
            lVarA.getClass();
            l.b(6, pVar, map);
        }
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        vd vdVar = this.a;
        int i3 = vdVar.d;
        if (i == 3) {
            vdVar.b.a();
            return true;
        }
        if (i == 701) {
            xe xeVar = vdVar.b;
            xeVar.a.a(0);
            p7 p7Var = xeVar.a.D;
            return true;
        }
        if (i != 702) {
            return true;
        }
        xe xeVar2 = vdVar.b;
        xeVar2.a.a(8);
        p7 p7Var2 = xeVar2.a.D;
        return true;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        vd vdVar = this.a;
        int i = vdVar.d;
        xe xeVar = vdVar.b;
        gf gfVar = xeVar.a;
        gfVar.getClass();
        gfVar.C = gfVar.s.a.getDuration();
        gf gfVar2 = xeVar.a;
        gfVar2.a = 2;
        if (gfVar2.d) {
            gfVar2.s.a.setVolume(0.0f, 0.0f);
        }
        p7 p7Var = xeVar.a.D;
        if (p7Var != null) {
            p7Var.b();
        }
        gf gfVar3 = xeVar.a;
        if (gfVar3.m) {
            gfVar3.s.j = true;
        }
        if (gfVar3.b == 3) {
            vd vdVar2 = gfVar3.s;
            vdVar2.a.start();
            if (vdVar2.i && vdVar2.a.isPlaying()) {
                vdVar2.b.a();
            }
        }
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        vd vdVar = this.a;
        int i3 = vdVar.d;
        xe xeVar = vdVar.b;
        xeVar.a.getClass();
        xeVar.a.getClass();
        ia iaVar = xeVar.a.o;
        if (iaVar != null) {
            iaVar.a(i, i2);
        }
    }
}
