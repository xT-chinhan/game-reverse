package com.tapsdk.tapad.internal.feed.views;

import android.app.Activity;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.tapsdk.tapad.R;
import com.tapsdk.tapad.TapFeedAd;

/* JADX INFO: loaded from: classes3.dex */
public class FeedAdVideoView extends FrameLayout {
    public static final int t = 80;
    public static final int u = 1;
    private volatile MediaState a;
    private volatile PlayState b;
    private TextureView c;
    private ImageView d;
    private ImageView e;
    private MediaPlayer f;
    private FrameLayout g;
    private com.tapsdk.tapad.internal.l.a h;
    private volatile boolean i;
    private com.tapsdk.tapad.internal.l.b.a j;
    private volatile int k;
    private volatile boolean l;
    private Surface m;
    private boolean n;
    private volatile boolean o;
    private volatile boolean p;
    Handler q;
    private TapFeedAd.VideoAdListener r;
    private com.tapsdk.tapad.internal.tracker.b s;

    public enum MediaState {
        IDLE,
        SURFACE_PREPARING,
        SURFACE_PREPARED,
        RESET,
        MEDIA_PREPARING,
        MEDIA_PREPARED
    }

    public enum PlayState {
        DEFAULT,
        PLAYING,
        PAUSE
    }

    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 1) {
                return;
            }
            if (FeedAdVideoView.this.a.equals(MediaState.SURFACE_PREPARED)) {
                FeedAdVideoView.this.i();
                return;
            }
            int iIntValue = ((Integer) message.obj).intValue() - 1;
            if (iIntValue > 0) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 1;
                messageObtain.obj = Integer.valueOf(iIntValue);
                FeedAdVideoView.this.q.sendMessageDelayed(messageObtain, 80L);
            }
        }
    }

    class b implements Runnable {
        final /* synthetic */ com.tapsdk.tapad.internal.l.a a;

        b(com.tapsdk.tapad.internal.l.a aVar) {
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Activity activityA = com.tapsdk.tapad.internal.utils.a.a(FeedAdVideoView.this.getContext());
            if (activityA == null || activityA.isDestroyed()) {
                return;
            }
            Glide.with(activityA).load(this.a.getImageInfoList().get(0).imageUrl).into(FeedAdVideoView.this.d);
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FeedAdVideoView.this.k == 0) {
                FeedAdVideoView.this.k = 1;
            } else {
                FeedAdVideoView.this.k = 0;
            }
            if (FeedAdVideoView.this.r != null && FeedAdVideoView.this.h != null) {
                if (FeedAdVideoView.this.k == 1) {
                    FeedAdVideoView.this.r.onVideoVolumeOpen(FeedAdVideoView.this.h);
                } else {
                    FeedAdVideoView.this.r.onVideoVolumeClose(FeedAdVideoView.this.h);
                }
            }
            FeedAdVideoView.this.j.a(FeedAdVideoView.this.k == 1);
            FeedAdVideoView.this.o();
            FeedAdVideoView.this.n();
        }
    }

    class d implements TextureView.SurfaceTextureListener {
        d() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            if (FeedAdVideoView.this.m != null) {
                FeedAdVideoView.this.m.release();
            }
            FeedAdVideoView.this.m = new Surface(surfaceTexture);
            if (FeedAdVideoView.this.f != null) {
                FeedAdVideoView.this.f.setSurface(FeedAdVideoView.this.m);
                FeedAdVideoView.this.a = MediaState.SURFACE_PREPARED;
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    class e implements MediaPlayer.OnPreparedListener {
        e() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            FeedAdVideoView.this.a = MediaState.MEDIA_PREPARED;
            if (FeedAdVideoView.this.i) {
                FeedAdVideoView.this.j();
                FeedAdVideoView.this.o();
            }
            if (FeedAdVideoView.this.r == null || FeedAdVideoView.this.h == null) {
                return;
            }
            FeedAdVideoView.this.r.onVideoPrepared(FeedAdVideoView.this.h);
        }
    }

    class f implements MediaPlayer.OnVideoSizeChangedListener {
        f() {
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            if (mediaPlayer == null || mediaPlayer.getVideoWidth() <= 0 || mediaPlayer.getVideoHeight() <= 0) {
                return;
            }
            mediaPlayer.getVideoWidth();
            mediaPlayer.getVideoHeight();
        }
    }

    class g implements MediaPlayer.OnErrorListener {
        g() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            FeedAdVideoView.this.m();
            return false;
        }
    }

    public FeedAdVideoView(Context context) {
        this(context, null);
    }

    public FeedAdVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FeedAdVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = MediaState.IDLE;
        this.b = PlayState.DEFAULT;
        this.f = null;
        this.h = null;
        this.i = false;
        this.k = 0;
        this.l = false;
        this.n = false;
        this.o = true;
        this.p = false;
        this.q = new a(Looper.getMainLooper());
        this.r = null;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.tapad_view_feed_video, this);
        viewInflate.setId(R.id.tapad_feedAdVideoContainerView);
        try {
            a(viewInflate);
        } catch (Throwable unused) {
        }
    }

    private void a(View view) {
        this.c = (TextureView) view.findViewById(R.id.feedAdVideoView);
        this.d = (ImageView) view.findViewById(R.id.coverImageView);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.videoBlackFrameLayout);
        this.g = frameLayout;
        frameLayout.setAlpha(0.0f);
        ImageView imageView = (ImageView) view.findViewById(R.id.feedVolumeImageView);
        this.e = imageView;
        imageView.setOnClickListener(new c());
        c();
    }

    private void b() {
        if (this.f == null || this.k != 0) {
            return;
        }
        this.f.setVolume(0.0f, 0.0f);
    }

    private void c() {
        if (this.a.equals(MediaState.SURFACE_PREPARING)) {
            return;
        }
        this.f = new MediaPlayer();
        this.a = MediaState.SURFACE_PREPARING;
        this.c.setSurfaceTextureListener(new d());
    }

    private void e() {
        if (this.f == null || this.k != 1) {
            return;
        }
        this.f.setVolume(0.09f, 0.09f);
    }

    private void f() {
        MediaPlayer mediaPlayer;
        com.tapsdk.tapad.internal.l.a aVar;
        if (this.a.equals(MediaState.MEDIA_PREPARED) && this.b.equals(PlayState.PLAYING) && (mediaPlayer = this.f) != null && mediaPlayer.isPlaying()) {
            this.g.setAlpha(1.0f);
            this.g.animate().alpha(0.0f).setDuration(380L).setListener(null);
            this.f.pause();
            this.b = PlayState.PAUSE;
            TapFeedAd.VideoAdListener videoAdListener = this.r;
            if (videoAdListener == null || (aVar = this.h) == null) {
                return;
            }
            videoAdListener.onVideoPause(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.a.equals(MediaState.MEDIA_PREPARING) || this.a.equals(MediaState.MEDIA_PREPARED)) {
            return;
        }
        try {
            this.a = MediaState.MEDIA_PREPARING;
            this.f.reset();
            Activity activityA = com.tapsdk.tapad.internal.utils.a.a(getContext());
            this.k = this.j.a();
            if (this.r != null && this.h != null) {
                if (this.k == 1) {
                    this.r.onVideoVolumeOpen(this.h);
                } else {
                    this.r.onVideoVolumeClose(this.h);
                }
            }
            this.f.setDataSource(activityA, Uri.parse(this.h.a().materialInfo.videoInfoList.get(0).videoUrl));
            this.f.prepareAsync();
            this.f.setLooping(true);
            this.f.setOnPreparedListener(new e());
            this.f.setOnVideoSizeChangedListener(new f());
            this.f.setOnErrorListener(new g());
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        MediaPlayer mediaPlayer;
        com.tapsdk.tapad.internal.l.a aVar;
        if (this.a.equals(MediaState.MEDIA_PREPARED)) {
            if ((!this.b.equals(PlayState.DEFAULT) && !this.b.equals(PlayState.PAUSE)) || (mediaPlayer = this.f) == null || mediaPlayer.isPlaying()) {
                return;
            }
            this.g.setAlpha(0.0f);
            this.g.animate().alpha(1.0f).setDuration(380L).setListener(null);
            this.f.start();
            this.b = PlayState.PLAYING;
            TapFeedAd.VideoAdListener videoAdListener = this.r;
            if (videoAdListener != null && (aVar = this.h) != null) {
                videoAdListener.onVideoStart(aVar);
            }
            com.tapsdk.tapad.internal.tracker.b bVar = this.s;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.e.setImageResource(this.k == 1 ? R.drawable.tapad_ic_audio_open : R.drawable.tapad_ic_audio_mute);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.k == 1) {
            e();
        } else {
            b();
        }
    }

    public void a() {
        com.tapsdk.tapad.internal.l.a aVar;
        if (this.j.a() != 1) {
            return;
        }
        this.j.a(false);
        this.k = this.j.a();
        TapFeedAd.VideoAdListener videoAdListener = this.r;
        if (videoAdListener != null && (aVar = this.h) != null) {
            videoAdListener.onVideoVolumeClose(aVar);
        }
        try {
            MediaPlayer mediaPlayer = this.f;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                return;
            }
            n();
            o();
        } catch (Exception unused) {
        }
    }

    public void a(com.tapsdk.tapad.internal.l.a aVar) {
        ImageView imageView = this.d;
        if (imageView != null) {
            imageView.post(new b(aVar));
        }
        com.tapsdk.tapad.internal.l.a aVar2 = this.h;
        if (aVar2 == null || aVar == null || aVar2.a().materialInfo.videoInfoList.size() == 0 || aVar.a().materialInfo.videoInfoList.size() == 0 || !this.h.a().materialInfo.videoInfoList.get(0).videoUrl.equals(aVar.a().materialInfo.videoInfoList.get(0).videoUrl)) {
            this.h = aVar;
            if (this.a != MediaState.SURFACE_PREPARING) {
                i();
                return;
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 1;
            messageObtain.obj = 3;
            this.q.sendMessageDelayed(messageObtain, 80L);
        }
    }

    public void a(com.tapsdk.tapad.internal.l.b.a aVar) {
        this.j = aVar;
    }

    public void d() {
        com.tapsdk.tapad.internal.l.a aVar;
        if (this.j.a() == 1) {
            return;
        }
        this.j.a(true);
        this.k = this.j.a();
        TapFeedAd.VideoAdListener videoAdListener = this.r;
        if (videoAdListener != null && (aVar = this.h) != null) {
            videoAdListener.onVideoVolumeOpen(aVar);
        }
        try {
            MediaPlayer mediaPlayer = this.f;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                return;
            }
            n();
            o();
        } catch (Exception unused) {
        }
    }

    public void g() {
        if (this.p) {
            return;
        }
        this.i = true;
        if (this.l) {
            k();
        } else {
            this.l = true;
        }
    }

    public boolean getForbiddenPlay() {
        return this.p;
    }

    public boolean getInUserController() {
        return this.n;
    }

    public boolean getPreChecked() {
        return this.l;
    }

    public void h() {
        MediaPlayer mediaPlayer = this.f;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.f = null;
            Surface surface = this.m;
            if (surface != null) {
                surface.release();
            }
            this.m = null;
        }
    }

    public void k() {
        if (this.p) {
            return;
        }
        try {
            this.i = true;
            this.k = this.j.a();
            n();
            if (this.a.equals(MediaState.MEDIA_PREPARED)) {
                j();
                o();
            } else if (this.a.equals(MediaState.SURFACE_PREPARED)) {
                this.q.removeMessages(1);
                i();
            }
            if (this.o) {
                this.e.setVisibility(0);
            }
        } catch (Throwable unused) {
        }
    }

    public void l() {
        try {
            this.k = this.j.a();
            n();
            o();
            f();
            b();
            this.i = false;
            this.e.setVisibility(8);
        } catch (Throwable unused) {
        }
    }

    public void m() {
        try {
            this.k = this.j.a();
            if (this.e != null) {
                n();
            }
            o();
            f();
            b();
            this.i = false;
            ImageView imageView = this.e;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            this.l = false;
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m();
    }

    public void setExposureHandler(com.tapsdk.tapad.internal.tracker.b bVar) {
        this.s = bVar;
    }

    public void setFobiddenPlay(boolean z) {
        this.p = z;
    }

    public void setInUserController(boolean z) {
        this.n = z;
    }

    public void setVideoAdListener(TapFeedAd.VideoAdListener videoAdListener) {
        this.r = videoAdListener;
    }

    public void setVolumeVisible(boolean z) {
        this.o = z;
        try {
            MediaPlayer mediaPlayer = this.f;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                return;
            }
            this.e.setVisibility(z ? 0 : 8);
        } catch (Exception unused) {
        }
    }
}
