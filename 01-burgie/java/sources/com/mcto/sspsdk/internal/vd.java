package com.mcto.sspsdk.internal;

import android.media.MediaPlayer;
import android.net.Uri;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class vd {
    public final MediaPlayer a;
    public final xe b;
    public final ud c;
    public int d;
    public String e;
    public String f;
    public HashMap g;
    public int h = 0;
    public boolean i = false;
    public boolean j = false;

    public vd(xe xeVar) {
        this.b = xeVar;
        ud udVar = new ud(this);
        this.c = udVar;
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.a = mediaPlayer;
        mediaPlayer.setAudioStreamType(3);
        mediaPlayer.setScreenOnWhilePlaying(true);
        mediaPlayer.setOnPreparedListener(udVar);
        mediaPlayer.setOnCompletionListener(udVar);
        mediaPlayer.setOnBufferingUpdateListener(udVar);
        mediaPlayer.setOnErrorListener(udVar);
        mediaPlayer.setOnInfoListener(udVar);
        mediaPlayer.setOnVideoSizeChangedListener(udVar);
    }

    public final void a() {
        if (this.e != null) {
            try {
                this.a.prepareAsync();
            } catch (Exception e) {
                this.c.onError(this.a, -999, -1);
            }
        }
    }

    public final void b() {
        try {
            int i = this.h;
            this.h = i + 1;
            if (i == 0) {
                this.a.setDataSource(jd.a, Uri.parse(this.e), this.g);
                return;
            }
            this.a.reset();
            this.a.setDataSource(jd.a, Uri.parse(this.f), this.g);
            a();
        } catch (Exception e) {
            r9.a("ssp_media", this.d + " setUrl", e);
            this.c.onError(this.a, -999, -1);
        }
    }
}
