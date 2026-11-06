package com.byazt.p;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.byazt.n.uc;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 581, 13})
public class hw extends com.byazt.p.pr {
    public Surface c;
    public volatile boolean fw;
    public final pr hn;
    public final MediaPlayer hw;
    public final Object uc;
    public com.byazt.k.pr x;

    public hw() {
        MediaPlayer mediaPlayer;
        Object obj = new Object();
        this.uc = obj;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.hw = mediaPlayer;
        }
        pr(mediaPlayer);
        try {
            mediaPlayer.setAudioStreamType(3);
        } catch (Throwable th) {
            com.byazt.o.hw.pr("CSJ_VIDEO", "setAudioStreamType error: ", th);
        }
        this.hn = new pr(this);
        yb();
    }

    private void pr(MediaPlayer mediaPlayer) {
        if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT >= 28) {
            return;
        }
        try {
            Class<?> cls = Class.forName("android.media.MediaTimeProvider");
            Class<?> cls2 = Class.forName("android.media.SubtitleController");
            Class<?> cls3 = Class.forName("android.media.SubtitleController$Anchor");
            Object objNewInstance = cls2.getConstructor(Context.class, cls, Class.forName("android.media.SubtitleController$Listener")).newInstance(com.byazt.y.hw.getContext(), null, null);
            Field declaredField = cls2.getDeclaredField("mHandler");
            declaredField.setAccessible(true);
            try {
                declaredField.set(objNewInstance, new Handler());
                declaredField.setAccessible(false);
                mediaPlayer.getClass().getMethod("setSubtitleAnchor", cls2, cls3).invoke(mediaPlayer, objNewInstance, null);
            } catch (Throwable th) {
                try {
                    com.byazt.o.hw.pr("CSJ_VIDEO", "subtitleInstance error: ", th);
                } finally {
                    declaredField.setAccessible(false);
                }
            }
        } catch (Throwable th2) {
            com.byazt.o.hw.pr("CSJ_VIDEO", "setSubtitleController error: ", th2);
        }
    }

    @Override // com.byazt.p.hn
    public void pr(SurfaceHolder surfaceHolder) throws Throwable {
        synchronized (this.uc) {
            try {
                if (!this.fw && surfaceHolder != null && surfaceHolder.getSurface() != null && this.pr) {
                    this.hw.setDisplay(surfaceHolder);
                }
            } catch (Throwable th) {
            }
        }
    }

    @Override // com.byazt.p.hn
    public void pr(Surface surface) {
        lb();
        this.c = surface;
        this.hw.setSurface(surface);
    }

    @Override // com.byazt.p.hn
    public void pr(com.byazt.y.pr prVar) throws Throwable {
        if (Build.VERSION.SDK_INT >= 23) {
            this.hw.setPlaybackParams(this.hw.getPlaybackParams().setSpeed(prVar.pr()));
        }
    }

    @Override // com.byazt.p.hn
    public void pr(String str) throws Throwable {
        Uri uri = Uri.parse(str);
        if ("file".equalsIgnoreCase(uri.getScheme())) {
            this.hw.setDataSource(uri.getPath());
        } else {
            this.hw.setDataSource(str);
        }
    }

    @Override // com.byazt.p.hn
    public void pr(FileDescriptor fileDescriptor) throws Throwable {
        this.hw.setDataSource(fileDescriptor);
    }

    @Override // com.byazt.p.hn
    public synchronized void pr(uc ucVar, com.byazt.n.hw hwVar) {
        this.x = com.byazt.k.pr.pr(com.byazt.y.hw.getContext(), hwVar, ucVar);
        com.byazt.u.hn.pr(ucVar);
        this.hw.setDataSource(this.x);
    }

    private void nt() {
        com.byazt.k.pr prVar;
        if (Build.VERSION.SDK_INT >= 23 && (prVar = this.x) != null) {
            try {
                prVar.close();
            } catch (Throwable th) {
                com.byazt.o.hw.pr("CSJ_VIDEO", "releaseMediaDataSource error: ", th);
            }
            this.x = null;
        }
    }

    @Override // com.byazt.p.hn
    public void c() throws Throwable {
        this.hw.start();
    }

    @Override // com.byazt.p.hn
    public void uc() throws Throwable {
        this.hw.stop();
    }

    @Override // com.byazt.p.hn
    public void fw() throws Throwable {
        this.hw.pause();
    }

    @Override // com.byazt.p.hn
    public void zo() {
        MediaPlayer mediaPlayer = this.hw;
        if (mediaPlayer != null) {
            mediaPlayer.prepareAsync();
        }
    }

    @Override // com.byazt.p.hn
    public void hw(boolean z) throws Throwable {
        this.hw.setScreenOnWhilePlaying(z);
    }

    @Override // com.byazt.p.hn
    public void pr(long j, int i) throws Throwable {
        if (Build.VERSION.SDK_INT >= 26) {
            switch (i) {
                case 0:
                    this.hw.seekTo((int) j, 0);
                    break;
                case 1:
                    this.hw.seekTo((int) j, 1);
                    break;
                case 2:
                    this.hw.seekTo((int) j, 2);
                    break;
                case 3:
                    this.hw.seekTo((int) j, 3);
                    break;
                default:
                    this.hw.seekTo((int) j);
                    break;
            }
            return;
        }
        this.hw.seekTo((int) j);
    }

    @Override // com.byazt.p.hn
    public long aj() {
        try {
            return this.hw.getCurrentPosition();
        } catch (Throwable th) {
            com.byazt.o.hw.pr("CSJ_VIDEO", "getCurrentPosition error: ", th);
            return 0L;
        }
    }

    @Override // com.byazt.p.hn
    public long vk() {
        try {
            return this.hw.getDuration();
        } catch (Throwable th) {
            com.byazt.o.hw.pr("CSJ_VIDEO", "getDuration error: ", th);
            return 0L;
        }
    }

    @Override // com.byazt.p.hn
    public void w() throws Throwable {
        synchronized (this.uc) {
            if (!this.fw) {
                this.hw.release();
                this.fw = true;
                lb();
                nt();
                pr();
                yb();
            }
        }
    }

    @Override // com.byazt.p.hn
    public void k() throws Throwable {
        try {
            this.hw.reset();
        } catch (Throwable th) {
            com.byazt.o.hw.pr("CSJ_VIDEO", "reset error: ", th);
        }
        nt();
        pr();
        yb();
    }

    @Override // com.byazt.p.hn
    public void hn(boolean z) throws Throwable {
        this.hw.setLooping(z);
    }

    @Override // com.byazt.p.hn
    public void x(boolean z) throws Throwable {
        MediaPlayer mediaPlayer = this.hw;
        if (mediaPlayer == null) {
            return;
        }
        if (z) {
            mediaPlayer.setVolume(0.0f, 0.0f);
        } else {
            mediaPlayer.setVolume(1.0f, 1.0f);
        }
    }

    @Override // com.byazt.p.hn
    public int m() {
        MediaPlayer mediaPlayer = this.hw;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.byazt.p.hn
    public int g() {
        MediaPlayer mediaPlayer = this.hw;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.byazt.p.hn
    public void c(boolean z) {
        try {
            MediaPlayer mediaPlayer = this.hw;
            if (mediaPlayer != null) {
                mediaPlayer.setLooping(z);
            }
        } catch (Throwable th) {
        }
    }

    @Override // com.byazt.p.hn
    public boolean ho() {
        MediaPlayer mediaPlayer = this.hw;
        if (mediaPlayer != null) {
            return mediaPlayer.isLooping();
        }
        return false;
    }

    private void yb() {
        this.hw.setOnPreparedListener(this.hn);
        this.hw.setOnBufferingUpdateListener(this.hn);
        this.hw.setOnCompletionListener(this.hn);
        this.hw.setOnSeekCompleteListener(this.hn);
        this.hw.setOnVideoSizeChangedListener(this.hn);
        this.hw.setOnErrorListener(this.hn);
        this.hw.setOnInfoListener(this.hn);
    }

    @com.byazt.vzx.pr(pr = {0, 1, 581, com.bykv.vk.component.ttvideo.player.MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    private static class pr implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {
        public final WeakReference<hw> pr;

        public pr(hw hwVar) {
            this.pr = new WeakReference<>(hwVar);
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                hw hwVar = this.pr.get();
                return hwVar != null && hwVar.hw(i, i2);
            } catch (Throwable th) {
                com.byazt.o.hw.pr("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onInfo error: ", th);
                return false;
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                Object[] objArr = {"onError: ", Integer.valueOf(i), Integer.valueOf(i2)};
                hw hwVar = this.pr.get();
                return hwVar != null && hwVar.pr(i, i2);
            } catch (Throwable th) {
                com.byazt.o.hw.pr("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onError error: ", th);
                return false;
            }
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                hw hwVar = this.pr.get();
                if (hwVar != null) {
                    hwVar.pr(i, i2, 1, 1);
                }
            } catch (Throwable th) {
                com.byazt.o.hw.pr("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onVideoSizeChanged error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            try {
                hw hwVar = this.pr.get();
                if (hwVar != null) {
                    hwVar.x();
                }
            } catch (Throwable th) {
                com.byazt.o.hw.pr("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onSeekComplete error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                hw hwVar = this.pr.get();
                if (hwVar != null) {
                    hwVar.pr(i);
                }
            } catch (Throwable th) {
                com.byazt.o.hw.pr("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onBufferingUpdate error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            try {
                hw hwVar = this.pr.get();
                if (hwVar != null) {
                    hwVar.hn();
                }
            } catch (Throwable th) {
                com.byazt.o.hw.pr("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onCompletion error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            try {
                hw hwVar = this.pr.get();
                if (hwVar != null) {
                    hwVar.hw();
                }
            } catch (Throwable th) {
                com.byazt.o.hw.pr("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onPrepared error: ", th);
            }
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
        lb();
    }

    private void lb() {
        try {
            Surface surface = this.c;
            if (surface != null) {
                surface.release();
                this.c = null;
            }
        } catch (Throwable th) {
        }
    }
}
