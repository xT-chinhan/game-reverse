package com.mcto.sspsdk.internal;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class zb implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnVideoSizeChangedListener {
    public static int g = 20000;
    public final Handler c;
    public final la d;
    public final qb f;
    public int a = 0;
    public MediaPlayer b = null;
    public final AtomicBoolean e = new AtomicBoolean(false);

    public zb(la laVar) {
        Looper looper;
        this.d = null;
        synchronized (s9.class) {
            if (s9.b == null) {
                HandlerThread handlerThread = new HandlerThread("ssp_player_callback");
                s9.b = handlerThread;
                handlerThread.start();
            }
            looper = s9.b.getLooper();
        }
        this.f = new qb(this, looper);
        this.d = laVar;
        Handler handler = new Handler(s9.a());
        this.c = handler;
        handler.post(new rb(this));
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        if (this.d != null) {
            bh.a.a(new mb(this, i));
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        if (this.d != null) {
            bh.a.a(new lb(this));
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        if (this.d == null) {
            return true;
        }
        bh.a.a(new nb(this, i, i2));
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        if (this.d != null) {
            bh.a.a(new ob(this, i, i2));
        }
        if (i == 701) {
            this.f.sendEmptyMessageDelayed(110, g);
            return false;
        }
        if (i != 702) {
            return false;
        }
        this.f.removeMessages(110);
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        if (this.d == null || this.e.get()) {
            return;
        }
        this.f.removeMessages(110);
        bh.a.a(new kb(this));
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        if (this.d != null) {
            bh.a.a(new pb(this, i, i2));
        }
    }
}
