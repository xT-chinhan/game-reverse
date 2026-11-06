package com.bykv.vk.openvk.component.video.ms.d;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bytedance.sdk.component.utils.sl;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class xr extends com.bykv.vk.openvk.component.video.ms.d.ms {
    private volatile boolean ab;
    private final ms ah;
    private final Object c;
    private com.bykv.vk.openvk.component.video.ms.ms.ms d;
    private Surface ka;
    private final MediaPlayer xr;

    public xr() {
        MediaPlayer mediaPlayer;
        Object obj = new Object();
        this.c = obj;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.xr = mediaPlayer;
        }
        ms(mediaPlayer);
        try {
            mediaPlayer.setAudioStreamType(3);
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.c.ah.ah("CSJ_VIDEO", "setAudioStreamType error: ", th);
        }
        this.ah = new ms(this);
        ao();
    }

    private void ms(MediaPlayer mediaPlayer) {
        if (Build.VERSION.SDK_INT >= 28) {
            return;
        }
        try {
            Class<?> cls = Class.forName("android.media.MediaTimeProvider");
            Class<?> cls2 = Class.forName("android.media.SubtitleController");
            Class<?> cls3 = Class.forName("android.media.SubtitleController$Anchor");
            Object objNewInstance = cls2.getConstructor(Context.class, cls, Class.forName("android.media.SubtitleController$Listener")).newInstance(com.bykv.vk.openvk.component.video.api.ah.getContext(), null, null);
            Field declaredField = cls2.getDeclaredField("mHandler");
            declaredField.setAccessible(true);
            try {
                declaredField.set(objNewInstance, new Handler());
                declaredField.setAccessible(false);
                mediaPlayer.getClass().getMethod("setSubtitleAnchor", cls2, cls3).invoke(mediaPlayer, objNewInstance, null);
            } catch (Throwable th) {
                try {
                    com.bykv.vk.openvk.component.video.api.c.ah.ah("CSJ_VIDEO", "subtitleInstance error: ", th);
                } finally {
                    declaredField.setAccessible(false);
                }
            }
        } catch (Throwable th2) {
            com.bykv.vk.openvk.component.video.api.c.ah.ah("CSJ_VIDEO", "setSubtitleController error: ", th2);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.ms.d.ah
    public void ms(SurfaceHolder surfaceHolder) throws Throwable {
        synchronized (this.c) {
            try {
                if (!this.ab && surfaceHolder != null && surfaceHolder.getSurface() != null && this.f49ms) {
                    this.xr.setDisplay(surfaceHolder);
                }
            } catch (Throwable th) {
                sl.ms(th);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.ms.d.ah
    public void ms(Surface surface) {
        h();
        this.ka = surface;
        this.xr.setSurface(surface);
    }

    @Override // com.bykv.vk.openvk.component.video.ms.d.ah
    public void ms(com.bykv.vk.openvk.component.video.api.xr xrVar) throws Throwable {
        this.xr.setPlaybackParams(this.xr.getPlaybackParams().setSpeed(xrVar.ms()));
    }

    @Override // com.bykv.vk.openvk.component.video.ms.d.ah
    public void ms(String str) throws Throwable {
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        if (!TextUtils.isEmpty(scheme) && scheme.equalsIgnoreCase("file")) {
            this.xr.setDataSource(uri.getPath());
        } else {
            this.xr.setDataSource(str);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.ms.d.ah
    public void ms(FileDescriptor fileDescriptor) throws Throwable {
        this.xr.setDataSource(fileDescriptor);
    }

    @Override // com.bykv.vk.openvk.component.video.ms.d.ah
    public synchronized void ms(com.bykv.vk.openvk.component.video.api.ah.d dVar) {
        this.d = com.bykv.vk.openvk.component.video.ms.ms.ms.ms(com.bykv.vk.openvk.component.video.api.ah.getContext(), dVar);
        com.bykv.vk.openvk.component.video.ms.ms.xr.ah.ms(dVar);
        this.xr.setDataSource(this.d);
    }

    private void ub() {
        com.bykv.vk.openvk.component.video.ms.ms.ms msVar = this.d;
        if (msVar != null) {
            try {
                msVar.close();
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.c.ah.ah("CSJ_VIDEO", "releaseMediaDataSource error: ", th);
            }
            this.d = null;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.ms.d.ah
    public void ka() throws Throwable {
        this.xr.start();
    }

    @Override // com.bykv.vk.openvk.component.video.ms.d.ah
    public void c() throws Throwable {
        this.xr.stop();
    }

    @Override // com.bykv.vk.openvk.component.video.ms.d.ah
    public void ab() throws Throwable {
        this.xr.pause();
    }

    @Override // com.bykv.vk.openvk.component.video.ms.d.ah
    public void x() {
        MediaPlayer mediaPlayer = this.xr;
        if (mediaPlayer != null) {
            mediaPlayer.prepareAsync();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.ms.d.ah
    public void xr(boolean z) throws Throwable {
        this.xr.setScreenOnWhilePlaying(z);
    }

    @Override // com.bykv.vk.openvk.component.video.ms.d.ah
    public void ms(long j, int i) throws Throwable {
        if (i == 0) {
            this.xr.seekTo((int) j, 0);
            return;
        }
        if (i == 1) {
            this.xr.seekTo((int) j, 1);
            return;
        }
        if (i == 2) {
            this.xr.seekTo((int) j, 2);
        } else if (i == 3) {
            this.xr.seekTo((int) j, 3);
        } else {
            this.xr.seekTo((int) j);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.ms.d.ah
    public long ny() {
        try {
            return this.xr.getCurrentPosition();
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.c.ah.ah("CSJ_VIDEO", "getCurrentPosition error: ", th);
            return 0L;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.ms.d.ah
    public long ch() {
        try {
            return this.xr.getDuration();
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.c.ah.ah("CSJ_VIDEO", "getDuration error: ", th);
            return 0L;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.ms.d.ah
    public void hi() throws Throwable {
        synchronized (this.c) {
            if (!this.ab) {
                this.xr.release();
                this.ab = true;
                h();
                ub();
                ms();
                ao();
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.ms.d.ah
    public void sl() throws Throwable {
        try {
            this.xr.reset();
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.c.ah.ah("CSJ_VIDEO", "reset error: ", th);
        }
        ub();
        ms();
        ao();
    }

    @Override // com.bykv.vk.openvk.component.video.ms.d.ah
    public void ah(boolean z) throws Throwable {
        this.xr.setLooping(z);
    }

    @Override // com.bykv.vk.openvk.component.video.ms.d.ah
    public void d(boolean z) throws Throwable {
        MediaPlayer mediaPlayer = this.xr;
        if (mediaPlayer == null) {
            return;
        }
        if (z) {
            mediaPlayer.setVolume(0.0f, 0.0f);
        } else {
            mediaPlayer.setVolume(1.0f, 1.0f);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.ms.d.ah
    public int zb() {
        MediaPlayer mediaPlayer = this.xr;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.bykv.vk.openvk.component.video.ms.d.ah
    public int u() {
        MediaPlayer mediaPlayer = this.xr;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.bykv.vk.openvk.component.video.ms.d.ah
    public void ka(boolean z) {
        try {
            MediaPlayer mediaPlayer = this.xr;
            if (mediaPlayer != null) {
                mediaPlayer.setLooping(z);
            }
        } catch (Throwable th) {
            sl.ms(th);
        }
    }

    private void ao() {
        this.xr.setOnPreparedListener(this.ah);
        this.xr.setOnBufferingUpdateListener(this.ah);
        this.xr.setOnCompletionListener(this.ah);
        this.xr.setOnSeekCompleteListener(this.ah);
        this.xr.setOnVideoSizeChangedListener(this.ah);
        this.xr.setOnErrorListener(this.ah);
        this.xr.setOnInfoListener(this.ah);
    }

    private static class ms implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final WeakReference<xr> f50ms;

        public ms(xr xrVar) {
            this.f50ms = new WeakReference<>(xrVar);
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO", "onInfo: ");
                xr xrVar = this.f50ms.get();
                return xrVar != null && xrVar.xr(i, i2);
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.c.ah.ah("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onInfo error: ", th);
                return false;
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO", "onError: ", Integer.valueOf(i), Integer.valueOf(i2));
                xr xrVar = this.f50ms.get();
                return xrVar != null && xrVar.ms(i, i2);
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.c.ah.ah("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onError error: ", th);
                return false;
            }
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                xr xrVar = this.f50ms.get();
                if (xrVar != null) {
                    xrVar.ms(i, i2, 1, 1);
                }
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.c.ah.ah("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onVideoSizeChanged error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            try {
                xr xrVar = this.f50ms.get();
                if (xrVar != null) {
                    xrVar.d();
                }
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.c.ah.ah("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onSeekComplete error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                xr xrVar = this.f50ms.get();
                if (xrVar != null) {
                    xrVar.ms(i);
                }
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.c.ah.ah("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onBufferingUpdate error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            try {
                xr xrVar = this.f50ms.get();
                if (xrVar != null) {
                    xrVar.ah();
                }
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.c.ah.ah("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onCompletion error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            try {
                xr xrVar = this.f50ms.get();
                if (xrVar != null) {
                    xrVar.xr();
                }
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.c.ah.ah("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onPrepared error: ", th);
            }
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        h();
    }

    private void h() {
        try {
            Surface surface = this.ka;
            if (surface != null) {
                surface.release();
                this.ka = null;
            }
        } catch (Throwable unused) {
        }
    }
}
