package com.mcto.sspsdk.internal;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.SurfaceHolder;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class x {
    public Uri c;
    public int d;
    public int e;
    public Context f;
    public MediaPlayer g;
    public MediaPlayer.OnPreparedListener h;
    public MediaPlayer.OnErrorListener i;
    public y j;
    public int a = 0;
    public int b = 0;
    public final r k = new r(this);
    public final s l = new s(this);
    public final t m = new t(this);
    public final u n = new u(this);
    public final v o = new v(this);
    public final w p = new w(this);

    public final void a(Uri uri, SurfaceHolder surfaceHolder) {
        MediaPlayer mediaPlayer;
        System.currentTimeMillis();
        this.c = uri;
        if (surfaceHolder == null) {
            Objects.toString(surfaceHolder);
        }
        if (this.g == null) {
            this.g = new MediaPlayer();
        }
        if (this.a == 1) {
            return;
        }
        try {
            this.g.setOnBufferingUpdateListener(this.k);
            this.g.setOnCompletionListener(this.l);
            this.g.setOnErrorListener(this.o);
            this.g.setOnPreparedListener(this.m);
            this.g.setOnSeekCompleteListener(this.n);
            this.g.setOnVideoSizeChangedListener(this.p);
            if (this.c.toString().startsWith("http")) {
                this.g.setDataSource(this.c.toString());
            } else {
                this.g.setDataSource(this.f, this.c);
            }
            if (surfaceHolder != null) {
                this.g.setDisplay(surfaceHolder);
            }
            this.g.setAudioStreamType(3);
            this.g.prepareAsync();
            this.a = 1;
        } catch (IOException e) {
            r9.a("ssp_splash_m", "IamgeMaxAdVideoView on open video IOException error", null);
            this.o.onError(this.g, -1004, -1004);
            this.a = -1;
        } catch (IllegalArgumentException e2) {
            r9.a("ssp_splash_m", "IamgeMaxAdVideoView on open video IllegalArgumentException error", null);
            if (!"The surface has been released".equals(e2.getMessage()) || (mediaPlayer = this.g) == null) {
                this.a = -1;
            } else {
                try {
                    mediaPlayer.setOnBufferingUpdateListener(this.k);
                    this.g.setOnCompletionListener(this.l);
                    this.g.setOnErrorListener(this.o);
                    this.g.setOnSeekCompleteListener(this.n);
                    this.g.setOnPreparedListener(this.m);
                    this.g.setOnVideoSizeChangedListener(this.p);
                    this.g.reset();
                    this.g.setDataSource(this.f, this.c);
                    this.g.setAudioStreamType(3);
                    this.g.prepareAsync();
                    this.a = 1;
                } catch (IOException e3) {
                    r9.a("ssp_splash_m", "IamgeMaxAdVideoView on reopen video IOException", null);
                    this.a = -1;
                } catch (IllegalArgumentException e4) {
                    r9.a("ssp_splash_m", "IamgeMaxAdVideoView on reopen video IllegalArgumentException", null);
                    this.a = -1;
                } catch (IllegalStateException e5) {
                    r9.a("ssp_splash_m", "IamgeMaxAdVideoView on reopen video IllegalStateException", null);
                    this.a = -1;
                }
            }
        } catch (IllegalStateException e6) {
            r9.a("ssp_splash_m", "IamgeMaxAdVideoView on open video IllegalStateException error", null);
            this.a = -1;
        } catch (NullPointerException e7) {
            r9.a("ssp_splash_m", "IamgeMaxAdVideoView have null point ", null);
            this.a = -1;
        }
        System.currentTimeMillis();
    }

    public final void b() {
        int i = this.a;
        MediaPlayer mediaPlayer = this.g;
        if (mediaPlayer != null && i != -1 && i != 0 && i != 1) {
            mediaPlayer.start();
            this.a = 3;
        }
        this.b = 3;
    }

    public final void a() {
        MediaPlayer mediaPlayer = this.g;
        if (mediaPlayer != null) {
            mediaPlayer.setDisplay(null);
            this.g.setSurface(null);
        }
    }
}
