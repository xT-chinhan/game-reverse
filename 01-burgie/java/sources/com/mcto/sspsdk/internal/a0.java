package com.mcto.sspsdk.internal;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class a0 extends SurfaceView {
    public SurfaceHolder a;
    public final x b;

    public a0(Context context) {
        super(context);
        x xVar = new x();
        this.b = xVar;
        y yVar = new y();
        getHolder().addCallback(new z(this));
        xVar.f = context;
        xVar.a = 0;
        xVar.b = 0;
        xVar.j = yVar;
        setZOrderMediaOverlay(true);
    }

    public final void a(String str) {
        if (lj.b(str)) {
            return;
        }
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                str = Uri.fromFile(file).toString();
            }
        } else if (str.startsWith("android.resource://")) {
            Uri uri = Uri.parse(str);
            str = new Uri.Builder().scheme("res://").authority(uri.getAuthority()).path(uri.getPath()).build().toString();
        }
        Uri uri2 = Uri.parse(str);
        if (uri2 == null) {
            return;
        }
        this.b.a(uri2, this.a);
    }

    @Override // android.view.SurfaceView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.b.b();
    }

    @Override // android.view.SurfaceView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        int i;
        if (z) {
            this.b.b();
            return;
        }
        x xVar = this.b;
        MediaPlayer mediaPlayer = xVar.g;
        if (mediaPlayer != null && (i = xVar.a) != -1 && i != 0 && i != 1 && mediaPlayer.isPlaying()) {
            xVar.g.pause();
            xVar.a = 4;
        }
        xVar.b = 4;
    }

    public final void a() {
        x xVar = this.b;
        xVar.getClass();
        try {
            MediaPlayer mediaPlayer = xVar.g;
            if (mediaPlayer != null) {
                mediaPlayer.reset();
                xVar.g.release();
                xVar.g = null;
                xVar.a = 0;
                xVar.b = 0;
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
