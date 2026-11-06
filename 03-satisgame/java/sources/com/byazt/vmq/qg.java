package com.byazt.vmq;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.byazt.ej.oa;
import com.byazt.zsl.l;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1122, 26})
public class qg extends com.byazt.vmq.n {
    public Surface l;
    public com.byazt.vje.n q;
    public final MediaPlayer qg;
    public final n s;
    public final Object w;
    public volatile boolean x;

    public qg() {
        MediaPlayer mediaPlayer;
        Object obj = new Object();
        this.w = obj;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.qg = mediaPlayer;
        }
        n(mediaPlayer);
        try {
            mediaPlayer.setAudioStreamType(3);
        } catch (Throwable th) {
            com.byazt.nl.qg.n("CSJ_VIDEO", "setAudioStreamType error: ", th);
        }
        this.s = new n(this);
        hd();
    }

    private void n(MediaPlayer mediaPlayer) {
        if (Build.VERSION.SDK_INT >= 28) {
            return;
        }
        try {
            Class<?> cls = Class.forName("android.media.MediaTimeProvider");
            Class<?> cls2 = Class.forName("android.media.SubtitleController");
            Class<?> cls3 = Class.forName("android.media.SubtitleController$Anchor");
            Object objNewInstance = cls2.getConstructor(Context.class, cls, Class.forName("android.media.SubtitleController$Listener")).newInstance(com.byazt.iza.qg.getContext(), null, null);
            Field declaredField = cls2.getDeclaredField("mHandler");
            declaredField.setAccessible(true);
            try {
                declaredField.set(objNewInstance, new Handler());
                declaredField.setAccessible(false);
                mediaPlayer.getClass().getMethod("setSubtitleAnchor", cls2, cls3).invoke(mediaPlayer, objNewInstance, null);
            } catch (Throwable th) {
                try {
                    com.byazt.nl.qg.n("CSJ_VIDEO", "subtitleInstance error: ", th);
                } finally {
                    declaredField.setAccessible(false);
                }
            }
        } catch (Throwable th2) {
            com.byazt.nl.qg.n("CSJ_VIDEO", "setSubtitleController error: ", th2);
        }
    }

    @Override // com.byazt.vmq.s
    public void n(SurfaceHolder surfaceHolder) throws Throwable {
        synchronized (this.w) {
            try {
                if (!this.x && surfaceHolder != null && surfaceHolder.getSurface() != null && this.n) {
                    this.qg.setDisplay(surfaceHolder);
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.byazt.vmq.s
    public void n(Surface surface) {
        cd();
        this.l = surface;
        this.qg.setSurface(surface);
    }

    @Override // com.byazt.vmq.s
    public void n(com.byazt.iza.n nVar) throws Throwable {
        this.qg.setPlaybackParams(this.qg.getPlaybackParams().setSpeed(nVar.n()));
    }

    @Override // com.byazt.vmq.s
    public void n(String str) throws Throwable {
        Uri uri = Uri.parse(str);
        if ("file".equalsIgnoreCase(uri.getScheme())) {
            this.qg.setDataSource(uri.getPath());
        } else {
            this.qg.setDataSource(str);
        }
    }

    @Override // com.byazt.vmq.s
    public void n(FileDescriptor fileDescriptor) throws Throwable {
        this.qg.setDataSource(fileDescriptor);
    }

    @Override // com.byazt.vmq.s
    public synchronized void n(l lVar, oa oaVar) {
        this.q = com.byazt.vje.n.n(com.byazt.iza.qg.getContext(), oaVar, lVar);
        com.byazt.nkg.s.n(lVar);
        this.qg.setDataSource(this.q);
    }

    private void cy() {
        com.byazt.vje.n nVar = this.q;
        if (nVar != null) {
            try {
                nVar.close();
            } catch (Throwable th) {
                com.byazt.nl.qg.n("CSJ_VIDEO", "releaseMediaDataSource error: ", th);
            }
            this.q = null;
        }
    }

    @Override // com.byazt.vmq.s
    public void l() throws Throwable {
        this.qg.start();
    }

    @Override // com.byazt.vmq.s
    public void w() throws Throwable {
        this.qg.stop();
    }

    @Override // com.byazt.vmq.s
    public void x() throws Throwable {
        this.qg.pause();
    }

    @Override // com.byazt.vmq.s
    public void fs() {
        MediaPlayer mediaPlayer = this.qg;
        if (mediaPlayer != null) {
            mediaPlayer.prepareAsync();
        }
    }

    @Override // com.byazt.vmq.s
    public void qg(boolean z) throws Throwable {
        this.qg.setScreenOnWhilePlaying(z);
    }

    @Override // com.byazt.vmq.s
    public void n(long j, int i) throws Throwable {
        if (Build.VERSION.SDK_INT < 26) {
            this.qg.seekTo((int) j);
            return;
        }
        if (i == 0) {
            this.qg.seekTo((int) j, 0);
            return;
        }
        if (i == 1) {
            this.qg.seekTo((int) j, 1);
            return;
        }
        if (i == 2) {
            this.qg.seekTo((int) j, 2);
        } else if (i == 3) {
            this.qg.seekTo((int) j, 3);
        } else {
            this.qg.seekTo((int) j);
        }
    }

    @Override // com.byazt.vmq.s
    public long rv() {
        try {
            return this.qg.getCurrentPosition();
        } catch (Throwable th) {
            com.byazt.nl.qg.n("CSJ_VIDEO", "getCurrentPosition error: ", th);
            return 0L;
        }
    }

    @Override // com.byazt.vmq.s
    public long tj() {
        try {
            return this.qg.getDuration();
        } catch (Throwable th) {
            com.byazt.nl.qg.n("CSJ_VIDEO", "getDuration error: ", th);
            return 0L;
        }
    }

    @Override // com.byazt.vmq.s
    public void cp() throws Throwable {
        synchronized (this.w) {
            if (!this.x) {
                this.qg.release();
                this.x = true;
                cd();
                cy();
                n();
                hd();
            }
        }
    }

    @Override // com.byazt.vmq.s
    public void d() throws Throwable {
        try {
            this.qg.reset();
        } catch (Throwable th) {
            com.byazt.nl.qg.n("CSJ_VIDEO", "reset error: ", th);
        }
        cy();
        n();
        hd();
    }

    @Override // com.byazt.vmq.s
    public void s(boolean z) throws Throwable {
        this.qg.setLooping(z);
    }

    @Override // com.byazt.vmq.s
    public void q(boolean z) throws Throwable {
        MediaPlayer mediaPlayer = this.qg;
        if (mediaPlayer == null) {
            return;
        }
        if (z) {
            mediaPlayer.setVolume(0.0f, 0.0f);
        } else {
            mediaPlayer.setVolume(1.0f, 1.0f);
        }
    }

    @Override // com.byazt.vmq.s
    public int oa() {
        MediaPlayer mediaPlayer = this.qg;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.byazt.vmq.s
    public int sz() {
        MediaPlayer mediaPlayer = this.qg;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.byazt.vmq.s
    public void l(boolean z) {
        try {
            MediaPlayer mediaPlayer = this.qg;
            if (mediaPlayer != null) {
                mediaPlayer.setLooping(z);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.vmq.s
    public boolean k() {
        MediaPlayer mediaPlayer = this.qg;
        if (mediaPlayer != null) {
            return mediaPlayer.isLooping();
        }
        return false;
    }

    private void hd() {
        this.qg.setOnPreparedListener(this.s);
        this.qg.setOnBufferingUpdateListener(this.s);
        this.qg.setOnCompletionListener(this.s);
        this.qg.setOnSeekCompleteListener(this.s);
        this.qg.setOnVideoSizeChangedListener(this.s);
        this.qg.setOnErrorListener(this.s);
        this.qg.setOnInfoListener(this.s);
    }

    @com.byazt.cp.n(n = {0, 1, 1122, 48})
    private static class n implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {
        public final WeakReference<qg> n;

        public n(qg qgVar) {
            this.n = new WeakReference<>(qgVar);
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                qg qgVar = this.n.get();
                return qgVar != null && qgVar.qg(i, i2);
            } catch (Throwable th) {
                com.byazt.nl.qg.n("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onInfo error: ", th);
                return false;
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                Object[] objArr = new Object[3];
                Integer.valueOf(i);
                Integer.valueOf(i2);
                qg qgVar = this.n.get();
                return qgVar != null && qgVar.n(i, i2);
            } catch (Throwable th) {
                com.byazt.nl.qg.n("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onError error: ", th);
                return false;
            }
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                qg qgVar = this.n.get();
                if (qgVar != null) {
                    qgVar.n(i, i2, 1, 1);
                }
            } catch (Throwable th) {
                com.byazt.nl.qg.n("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onVideoSizeChanged error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            try {
                qg qgVar = this.n.get();
                if (qgVar != null) {
                    qgVar.q();
                }
            } catch (Throwable th) {
                com.byazt.nl.qg.n("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onSeekComplete error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                qg qgVar = this.n.get();
                if (qgVar != null) {
                    qgVar.n(i);
                }
            } catch (Throwable th) {
                com.byazt.nl.qg.n("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onBufferingUpdate error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            try {
                qg qgVar = this.n.get();
                if (qgVar != null) {
                    qgVar.s();
                }
            } catch (Throwable th) {
                com.byazt.nl.qg.n("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onCompletion error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            try {
                qg qgVar = this.n.get();
                if (qgVar != null) {
                    qgVar.qg();
                }
            } catch (Throwable th) {
                com.byazt.nl.qg.n("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onPrepared error: ", th);
            }
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
        cd();
    }

    private void cd() {
        try {
            Surface surface = this.l;
            if (surface != null) {
                surface.release();
                this.l = null;
            }
        } catch (Throwable unused) {
        }
    }
}
