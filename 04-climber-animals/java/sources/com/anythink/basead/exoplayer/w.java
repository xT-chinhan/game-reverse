package com.anythink.basead.exoplayer;

import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.anythink.basead.exoplayer.h.af;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public interface w {
    public static final int h = 1;
    public static final int i = 2;
    public static final int j = 3;
    public static final int k = 4;
    public static final int l = 0;
    public static final int m = 1;
    public static final int n = 2;
    public static final int o = 0;
    public static final int p = 1;
    public static final int q = 2;
    public static final int r = 3;
    public static final int s = 4;
    public static final int t = 0;
    public static final int u = 1;
    public static final int v = 2;

    public static abstract class a implements c {
        @Deprecated
        private static void a() {
        }

        @Override // com.anythink.basead.exoplayer.w.c
        public void onLoadingChanged(boolean z) {
        }

        @Override // com.anythink.basead.exoplayer.w.c
        public void onPlaybackParametersChanged(v vVar) {
        }

        @Override // com.anythink.basead.exoplayer.w.c
        public void onPlayerError(com.anythink.basead.exoplayer.g gVar) {
        }

        @Override // com.anythink.basead.exoplayer.w.c
        public void onPlayerStateChanged(boolean z, int i) {
        }

        @Override // com.anythink.basead.exoplayer.w.c
        public void onPositionDiscontinuity(int i) {
        }

        @Override // com.anythink.basead.exoplayer.w.c
        public void onRepeatModeChanged(int i) {
        }

        @Override // com.anythink.basead.exoplayer.w.c
        public void onSeekProcessed() {
        }

        @Override // com.anythink.basead.exoplayer.w.c
        public void onShuffleModeEnabledChanged(boolean z) {
        }

        @Override // com.anythink.basead.exoplayer.w.c
        public void onTimelineChanged(ae aeVar, Object obj, int i) {
        }

        @Override // com.anythink.basead.exoplayer.w.c
        public void onTracksChanged(af afVar, com.anythink.basead.exoplayer.i.g gVar) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    public interface c {
        void onLoadingChanged(boolean z);

        void onPlaybackParametersChanged(v vVar);

        void onPlayerError(com.anythink.basead.exoplayer.g gVar);

        void onPlayerStateChanged(boolean z, int i);

        void onPositionDiscontinuity(int i);

        void onRepeatModeChanged(int i);

        void onSeekProcessed();

        void onShuffleModeEnabledChanged(boolean z);

        void onTimelineChanged(ae aeVar, Object obj, int i);

        void onTracksChanged(af afVar, com.anythink.basead.exoplayer.i.g gVar);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface d {
    }

    public interface e {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface f {
    }

    public interface g {
        int H();

        void I();

        void a(Surface surface);

        void a(SurfaceHolder surfaceHolder);

        void a(SurfaceView surfaceView);

        void a(TextureView textureView);

        void a(com.anythink.basead.exoplayer.l.g gVar);

        void b(Surface surface);

        void b(SurfaceHolder surfaceHolder);

        void b(SurfaceView surfaceView);

        void b(TextureView textureView);

        void b(com.anythink.basead.exoplayer.l.g gVar);

        void d(int i);
    }

    int A();

    long B();

    int C();

    af D();

    com.anythink.basead.exoplayer.i.g E();

    ae F();

    Object G();

    void a(int i2);

    void a(int i2, long j2);

    void a(long j2);

    void a(v vVar);

    void a(c cVar);

    void a(boolean z);

    g b();

    void b(int i2);

    void b(c cVar);

    void b(boolean z);

    int c(int i2);

    e c();

    void c(boolean z);

    int d();

    com.anythink.basead.exoplayer.g e();

    boolean f();

    int g();

    boolean h();

    boolean i();

    void j();

    v k();

    Object l();

    void m();

    void n();

    int o();

    int p();

    int q();

    int r();

    long s();

    long t();

    long u();

    int v();

    boolean w();

    boolean x();

    boolean y();

    int z();
}
