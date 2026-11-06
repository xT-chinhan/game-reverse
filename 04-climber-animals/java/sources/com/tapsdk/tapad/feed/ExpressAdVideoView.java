package com.tapsdk.tapad.feed;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.tapsdk.tapad.R;
import com.tapsdk.tapad.TapFeedAd;
import com.tapsdk.tapad.internal.utils.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class ExpressAdVideoView extends FrameLayout {
    private static WeakHashMap<ExpressAdVideoView, Boolean> q = new WeakHashMap<>();
    private TextureView a;
    private ImageView b;
    private ImageView c;
    private MediaPlayer d;
    private FrameLayout e;
    private com.tapsdk.tapad.internal.l.a f;
    private volatile boolean g;
    private volatile boolean h;
    private volatile int i;
    private Surface j;
    private TapFeedAd.VideoAdListener k;
    private VideoOption l;
    private BroadcastReceiver m;
    private int n;
    private int o;
    private com.tapsdk.tapad.internal.tracker.b p;

    class a implements MediaPlayer.OnPreparedListener {
        final /* synthetic */ com.tapsdk.tapad.internal.l.a a;

        a(com.tapsdk.tapad.internal.l.a aVar) {
            this.a = aVar;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            ExpressAdVideoView.this.h = true;
            if (ExpressAdVideoView.this.g) {
                ExpressAdVideoView.this.g();
                if (ExpressAdVideoView.this.c.getVisibility() == 0) {
                    ExpressAdVideoView.this.l();
                }
                if (ExpressAdVideoView.this.k != null) {
                    ExpressAdVideoView.this.k.onVideoPrepared(this.a);
                }
            }
        }
    }

    class b implements MediaPlayer.OnErrorListener {
        b() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            Log.d("ExpressAdVideoView", i + "" + i2);
            return false;
        }
    }

    class c implements MediaPlayer.OnVideoSizeChangedListener {
        c() {
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ExpressAdVideoView expressAdVideoView;
            int i;
            if (ExpressAdVideoView.this.i == 0) {
                expressAdVideoView = ExpressAdVideoView.this;
                i = 1;
            } else {
                expressAdVideoView = ExpressAdVideoView.this;
                i = 0;
            }
            expressAdVideoView.i = i;
            ExpressAdVideoView.this.l();
            ExpressAdVideoView.this.k();
        }
    }

    class e implements ViewTreeObserver.OnScrollChangedListener {
        e() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            Rect rect = new Rect();
            boolean localVisibleRect = ExpressAdVideoView.this.getLocalVisibleRect(rect);
            Rect rect2 = new Rect(0, 0, ExpressAdVideoView.this.getWidth(), ExpressAdVideoView.this.getHeight());
            if (localVisibleRect && rect.width() >= rect2.width() && rect.height() >= rect2.height()) {
                ExpressAdVideoView.d(ExpressAdVideoView.this, true);
            } else {
                ExpressAdVideoView.d(ExpressAdVideoView.this, false);
            }
        }
    }

    class f implements ViewTreeObserver.OnGlobalLayoutListener {
        f() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ExpressAdVideoView expressAdVideoView;
            boolean z;
            Rect rect = new Rect();
            ExpressAdVideoView.this.getHitRect(rect);
            if (ExpressAdVideoView.this.getLocalVisibleRect(rect)) {
                expressAdVideoView = ExpressAdVideoView.this;
                z = true;
            } else {
                expressAdVideoView = ExpressAdVideoView.this;
                z = false;
            }
            ExpressAdVideoView.d(expressAdVideoView, z);
        }
    }

    class g implements TextureView.SurfaceTextureListener {
        g() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            if (ExpressAdVideoView.this.j != null) {
                ExpressAdVideoView.this.j.release();
            }
            ExpressAdVideoView.this.j = new Surface(surfaceTexture);
            if (ExpressAdVideoView.this.d == null) {
                ExpressAdVideoView.this.d = new MediaPlayer();
                ExpressAdVideoView.this.d.setSurface(ExpressAdVideoView.this.j);
                ExpressAdVideoView expressAdVideoView = ExpressAdVideoView.this;
                expressAdVideoView.b(expressAdVideoView.f);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            if (ExpressAdVideoView.this.d != null) {
                ExpressAdVideoView.this.d.release();
                surfaceTexture.release();
                ExpressAdVideoView.this.d = null;
            }
            ExpressAdVideoView.this.g = false;
            ExpressAdVideoView.this.h = false;
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    static class h implements Comparator<ExpressAdVideoView> {
        h() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ExpressAdVideoView expressAdVideoView, ExpressAdVideoView expressAdVideoView2) {
            int y = (int) (expressAdVideoView.getY() - expressAdVideoView2.getY());
            return y != 0 ? y : (int) (expressAdVideoView.getX() - expressAdVideoView2.getX());
        }
    }

    class i extends BroadcastReceiver {
        final /* synthetic */ com.tapsdk.tapad.internal.l.a a;

        i(com.tapsdk.tapad.internal.l.a aVar) {
            this.a = aVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) {
                return;
            }
            ExpressAdVideoView.this.b(this.a);
        }
    }

    public ExpressAdVideoView(Context context) {
        this(context, null);
    }

    public ExpressAdVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ExpressAdVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.d = null;
        this.f = null;
        this.g = false;
        this.h = false;
        this.i = 0;
        this.k = null;
        this.l = new VideoOption.Builder().build();
        this.m = null;
        this.n = 16;
        this.o = 9;
        removeAllViews();
        LayoutInflater.from(context).inflate(R.layout.tapad_view_feed_video, this);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.tapad_ExpressAdVideoView);
        this.n = typedArrayObtainStyledAttributes.getInt(R.styleable.tapad_ExpressAdVideoView_tapad_video_aspectRatioWidth, 16);
        this.o = typedArrayObtainStyledAttributes.getInt(R.styleable.tapad_ExpressAdVideoView_tapad_video_aspectRatioHeight, 9);
        try {
            d();
        } catch (Throwable unused) {
        }
    }

    private static void a() {
        ExpressAdVideoView key;
        synchronized (ExpressAdVideoView.class) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<ExpressAdVideoView, Boolean> entry : q.entrySet()) {
                if (entry.getValue().booleanValue() && (key = entry.getKey()) != null && key.isAttachedToWindow()) {
                    arrayList.add(entry.getKey());
                }
            }
            Collections.sort(arrayList, new h());
            if (arrayList.size() > 0) {
                ((ExpressAdVideoView) arrayList.get(0)).h();
                for (int i2 = 1; i2 < arrayList.size(); i2++) {
                    ((ExpressAdVideoView) arrayList.get(i2)).i();
                }
            }
        }
    }

    private void a(com.tapsdk.tapad.internal.l.a aVar) {
        if (this.m == null) {
            this.m = new i(aVar);
            getContext().registerReceiver(this.m, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    private void b() {
        if (this.d == null || this.i != 0) {
            return;
        }
        this.d.setVolume(0.0f, 0.0f);
    }

    private void c() {
        this.a.setSurfaceTextureListener(new g());
    }

    private void d() {
        this.a = (TextureView) findViewById(R.id.feedAdVideoView);
        this.b = (ImageView) findViewById(R.id.coverImageView);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.videoBlackFrameLayout);
        this.e = frameLayout;
        frameLayout.setAlpha(0.0f);
        ImageView imageView = (ImageView) findViewById(R.id.feedVolumeImageView);
        this.c = imageView;
        imageView.setOnClickListener(new d());
        c();
        getViewTreeObserver().addOnScrollChangedListener(new e());
        getViewTreeObserver().addOnGlobalLayoutListener(new f());
        d(this, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(ExpressAdVideoView expressAdVideoView, boolean z) {
        synchronized (ExpressAdVideoView.class) {
            q.put(expressAdVideoView, Boolean.valueOf(z));
            if (z) {
                a();
            } else {
                expressAdVideoView.i();
            }
        }
    }

    private void e() {
        if (this.d == null || this.i != 1) {
            return;
        }
        this.d.setVolume(0.09f, 0.09f);
    }

    private void f() {
        MediaPlayer mediaPlayer;
        if (this.f == null || !this.h || (mediaPlayer = this.d) == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.e.setAlpha(1.0f);
        this.e.animate().alpha(0.0f).setDuration(380L).setListener(null);
        this.d.pause();
        TapFeedAd.VideoAdListener videoAdListener = this.k;
        if (videoAdListener != null) {
            videoAdListener.onVideoPause(this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        MediaPlayer mediaPlayer;
        if (this.f == null || !this.h || (mediaPlayer = this.d) == null || mediaPlayer.isPlaying()) {
            return;
        }
        this.e.setAlpha(0.0f);
        this.e.animate().alpha(1.0f).setDuration(380L).setListener(null);
        this.d.start();
        TapFeedAd.VideoAdListener videoAdListener = this.k;
        if (videoAdListener != null) {
            videoAdListener.onVideoStart(this.f);
        }
        com.tapsdk.tapad.internal.tracker.b bVar = this.p;
        if (bVar != null) {
            bVar.a();
        }
    }

    private void h() {
        synchronized (ExpressAdVideoView.class) {
            this.g = true;
            g();
        }
    }

    private void i() {
        synchronized (ExpressAdVideoView.class) {
            this.g = false;
            f();
        }
    }

    private void j() {
        if (this.m != null) {
            getContext().unregisterReceiver(this.m);
            this.m = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.c.setImageResource(this.i == 1 ? R.drawable.tapad_ic_audio_open : R.drawable.tapad_ic_audio_mute);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.c.getVisibility() == 0 && this.i == 1) {
            e();
        } else {
            b();
        }
    }

    public void b(com.tapsdk.tapad.internal.l.a aVar) {
        if (aVar == null) {
            return;
        }
        this.f = aVar;
        if (this.d == null) {
            return;
        }
        l();
        k();
        try {
            Glide.with(this).load(aVar.getImageInfoList().get(0).imageUrl).into(this.b);
            if (this.l.autoPlayPolicy == VideoOption.AutoPlayPolicy.WIFI && !k.b(getContext())) {
                a(aVar);
                return;
            }
            j();
            this.d.reset();
            this.d.setDataSource(getContext(), Uri.parse(aVar.a().materialInfo.videoInfoList.get(0).videoUrl));
            this.d.prepareAsync();
            this.d.setLooping(true);
            this.d.setOnPreparedListener(new a(aVar));
            this.d.setOnErrorListener(new b());
            this.d.setOnVideoSizeChangedListener(new c());
        } catch (Exception e2) {
            Log.d("ExpressAdVideoView", e2.getMessage());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (i3 == 0) {
            i3 = View.MeasureSpec.makeMeasureSpec((size * this.o) / this.n, mode);
        }
        if (i2 == 0) {
            i2 = View.MeasureSpec.makeMeasureSpec((size2 * this.n) / this.o, mode2);
        }
        super.onMeasure(i2, i3);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        d(this, i2 != 8);
    }

    public void setExposureHandler(com.tapsdk.tapad.internal.tracker.b bVar) {
        this.p = bVar;
    }

    public void setVideoAdListener(TapFeedAd.VideoAdListener videoAdListener) {
        this.k = videoAdListener;
    }

    protected void setVideoOption(VideoOption videoOption) {
        this.l = videoOption;
    }

    protected void setVolumeImageViewVisible(int i2) {
        this.c.setVisibility(i2);
        k();
        l();
    }
}
