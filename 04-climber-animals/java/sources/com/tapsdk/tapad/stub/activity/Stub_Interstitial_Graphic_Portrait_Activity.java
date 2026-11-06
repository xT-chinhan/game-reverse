package com.tapsdk.tapad.stub.activity;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.tapsdk.tapad.AdRequest;
import com.tapsdk.tapad.R;
import com.tapsdk.tapad.internal.DownloadPresenter;
import com.tapsdk.tapad.internal.RewardPresenter;
import com.tapsdk.tapad.internal.tracker.ExposureTrackerObject;
import com.tapsdk.tapad.internal.tracker.TapADTrackerObject;
import com.tapsdk.tapad.internal.ui.views.HotZoneFrameLayout;
import com.tapsdk.tapad.internal.ui.views.video.VideoSurfaceView;
import com.tapsdk.tapad.internal.utils.TapADLogger;
import com.tapsdk.tapad.model.entities.AdInfo;
import com.tapsdk.tapad.model.entities.AppInfo;
import com.tapsdk.tapad.model.entities.ImageInfo;
import com.tapsdk.tapad.model.entities.InteractionInfo;
import com.tapsdk.tapad.model.entities.MaterialInfo;
import com.tapsdk.tapad.model.entities.VideoInfo;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class Stub_Interstitial_Graphic_Portrait_Activity extends Activity {
    private static final String N = "data";
    private static final String O = "request";
    private static final String P = "c_id";
    private static final String Q = "receiver_action_finish";
    public static final int R = 1;
    public static final int S = 10;
    private static WeakReference<Stub_Interstitial_Graphic_Portrait_Activity> T;
    private FrameLayout A;
    private RelativeLayout B;
    private TextView C;
    private com.tapsdk.tapad.internal.animation.h E;
    private com.tapsdk.tapad.internal.animation.i F;
    private com.tapsdk.tapad.internal.animation.l.b G;
    private com.tapsdk.tapad.internal.animation.l.a H;
    private Drawable J;
    private Drawable K;
    private com.tapsdk.tapad.internal.e.a a;
    private AdInfo b;
    private DownloadPresenter c;
    private RelativeLayout d;
    private VideoSurfaceView e;
    private MediaPlayer f;
    private ImageView h;
    private LinearLayout i;
    private ImageView j;
    private TextView k;
    private ImageView l;
    private TextView m;
    private ImageInfo n;
    private com.tapsdk.tapad.internal.tracker.b t;
    private ViewGroup u;
    private HotZoneFrameLayout v;
    private HotZoneFrameLayout x;
    private TextView y;
    private ProgressBar z;
    private int g = 0;
    private boolean o = true;
    private boolean p = false;
    private boolean q = false;
    private volatile int r = 5;
    private boolean s = false;
    private final Handler w = new k(Looper.myLooper());
    private boolean D = false;
    private boolean I = false;
    int L = 0;
    private Disposable M = null;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Stub_Interstitial_Graphic_Portrait_Activity.this.b.viewInteractionInfo != null) {
                if (Stub_Interstitial_Graphic_Portrait_Activity.this.b.tapADTrackerObject != null) {
                    Stub_Interstitial_Graphic_Portrait_Activity.this.b.tapADTrackerObject.a(3, null);
                } else {
                    com.tapsdk.tapad.internal.tracker.c.a().a(Stub_Interstitial_Graphic_Portrait_Activity.this.b.clickMonitorUrls, Stub_Interstitial_Graphic_Portrait_Activity.this.b.viewInteractionInfo, Stub_Interstitial_Graphic_Portrait_Activity.this.b.getClickMonitorHeaderListWrapper());
                }
                Stub_Interstitial_Graphic_Portrait_Activity stub_Interstitial_Graphic_Portrait_Activity = Stub_Interstitial_Graphic_Portrait_Activity.this;
                com.tapsdk.tapad.internal.s.a.a((Activity) stub_Interstitial_Graphic_Portrait_Activity, true, stub_Interstitial_Graphic_Portrait_Activity.b, Stub_Interstitial_Graphic_Portrait_Activity.this.c);
            }
        }
    }

    class a0 implements View.OnClickListener {
        a0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Stub_Interstitial_Graphic_Portrait_Activity.this.u.setVisibility(8);
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!Stub_Interstitial_Graphic_Portrait_Activity.this.b.isFirstPassiveTransfer || !Stub_Interstitial_Graphic_Portrait_Activity.this.b.isCloseTransferEnable) {
                Stub_Interstitial_Graphic_Portrait_Activity.this.a.onAdClose();
                Stub_Interstitial_Graphic_Portrait_Activity.this.finish();
            } else {
                Stub_Interstitial_Graphic_Portrait_Activity.this.b.isFirstPassiveTransfer = false;
                Stub_Interstitial_Graphic_Portrait_Activity.this.u.setVisibility(8);
                Stub_Interstitial_Graphic_Portrait_Activity stub_Interstitial_Graphic_Portrait_Activity = Stub_Interstitial_Graphic_Portrait_Activity.this;
                stub_Interstitial_Graphic_Portrait_Activity.a((Activity) stub_Interstitial_Graphic_Portrait_Activity, 10);
            }
        }
    }

    class b0 implements Runnable {
        b0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            float f = (Stub_Interstitial_Graphic_Portrait_Activity.this.n.width * 1.0f) / (Stub_Interstitial_Graphic_Portrait_Activity.this.n.height * 1.0f);
            if (com.tapsdk.tapad.internal.utils.a.a((Activity) Stub_Interstitial_Graphic_Portrait_Activity.this)) {
                Glide.with((Activity) Stub_Interstitial_Graphic_Portrait_Activity.this).load(Stub_Interstitial_Graphic_Portrait_Activity.this.n.imageUrl).override(com.tapsdk.tapad.internal.utils.t.a(Stub_Interstitial_Graphic_Portrait_Activity.this, 300.0f), com.tapsdk.tapad.internal.utils.t.a(Stub_Interstitial_Graphic_Portrait_Activity.this, f * 300.0f)).centerCrop().into(Stub_Interstitial_Graphic_Portrait_Activity.this.l);
            }
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Stub_Interstitial_Graphic_Portrait_Activity stub_Interstitial_Graphic_Portrait_Activity = Stub_Interstitial_Graphic_Portrait_Activity.this;
            stub_Interstitial_Graphic_Portrait_Activity.a((Activity) stub_Interstitial_Graphic_Portrait_Activity, 1);
        }
    }

    class c0 implements Runnable {
        c0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.tapsdk.tapad.internal.utils.a.a((Activity) Stub_Interstitial_Graphic_Portrait_Activity.this)) {
                Glide.with((Activity) Stub_Interstitial_Graphic_Portrait_Activity.this).load(Stub_Interstitial_Graphic_Portrait_Activity.this.n.imageUrl).override(Stub_Interstitial_Graphic_Portrait_Activity.this.l.getWidth(), Stub_Interstitial_Graphic_Portrait_Activity.this.l.getHeight()).into(Stub_Interstitial_Graphic_Portrait_Activity.this.l);
            }
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Stub_Interstitial_Graphic_Portrait_Activity.this.u.setVisibility(8);
        }
    }

    class d0 implements View.OnClickListener {
        d0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Stub_Interstitial_Graphic_Portrait_Activity.this.c != null) {
                Stub_Interstitial_Graphic_Portrait_Activity.this.c.a(new DownloadPresenter.g());
            }
        }
    }

    class e implements RequestListener<Drawable> {
        e() {
        }

        @Override // com.bumptech.glide.request.RequestListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
            if (Stub_Interstitial_Graphic_Portrait_Activity.this.t == null) {
                return false;
            }
            Stub_Interstitial_Graphic_Portrait_Activity.this.t.b();
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
            return false;
        }
    }

    class e0 implements View.OnClickListener {
        e0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Stub_Interstitial_Graphic_Portrait_Activity stub_Interstitial_Graphic_Portrait_Activity = Stub_Interstitial_Graphic_Portrait_Activity.this;
            stub_Interstitial_Graphic_Portrait_Activity.a((Activity) stub_Interstitial_Graphic_Portrait_Activity, 0);
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Stub_Interstitial_Graphic_Portrait_Activity.this.b == null || Stub_Interstitial_Graphic_Portrait_Activity.this.b.viewInteractionInfo == null) {
                return;
            }
            if (Stub_Interstitial_Graphic_Portrait_Activity.this.b.tapADTrackerObject != null) {
                Stub_Interstitial_Graphic_Portrait_Activity.this.b.tapADTrackerObject.a(3, null);
            } else {
                com.tapsdk.tapad.internal.tracker.c.a().a(Stub_Interstitial_Graphic_Portrait_Activity.this.b.clickMonitorUrls, Stub_Interstitial_Graphic_Portrait_Activity.this.b.viewInteractionInfo, Stub_Interstitial_Graphic_Portrait_Activity.this.b.getClickMonitorHeaderListWrapper());
            }
            Stub_Interstitial_Graphic_Portrait_Activity stub_Interstitial_Graphic_Portrait_Activity = Stub_Interstitial_Graphic_Portrait_Activity.this;
            com.tapsdk.tapad.internal.s.a.a((Activity) stub_Interstitial_Graphic_Portrait_Activity, true, stub_Interstitial_Graphic_Portrait_Activity.b, Stub_Interstitial_Graphic_Portrait_Activity.this.c);
        }
    }

    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Stub_Interstitial_Graphic_Portrait_Activity stub_Interstitial_Graphic_Portrait_Activity = Stub_Interstitial_Graphic_Portrait_Activity.this;
            stub_Interstitial_Graphic_Portrait_Activity.a((Activity) stub_Interstitial_Graphic_Portrait_Activity, 0);
        }
    }

    class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Stub_Interstitial_Graphic_Portrait_Activity.this.c != null) {
                TapADLogger.e("downloadPresenter.cancel");
                Stub_Interstitial_Graphic_Portrait_Activity.this.c.a(new DownloadPresenter.g());
            }
        }
    }

    class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Stub_Interstitial_Graphic_Portrait_Activity stub_Interstitial_Graphic_Portrait_Activity = Stub_Interstitial_Graphic_Portrait_Activity.this;
            stub_Interstitial_Graphic_Portrait_Activity.a((Activity) stub_Interstitial_Graphic_Portrait_Activity, 1);
        }
    }

    class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Stub_Interstitial_Graphic_Portrait_Activity stub_Interstitial_Graphic_Portrait_Activity = Stub_Interstitial_Graphic_Portrait_Activity.this;
            stub_Interstitial_Graphic_Portrait_Activity.a((Activity) stub_Interstitial_Graphic_Portrait_Activity, 1);
        }
    }

    class k extends Handler {
        k(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                Stub_Interstitial_Graphic_Portrait_Activity.this.r = ((Integer) message.obj).intValue();
                if (Stub_Interstitial_Graphic_Portrait_Activity.this.r < 0) {
                    if (Stub_Interstitial_Graphic_Portrait_Activity.this.u.getVisibility() == 0 && Stub_Interstitial_Graphic_Portrait_Activity.this.b.materialInfo.materialType == 2) {
                        Stub_Interstitial_Graphic_Portrait_Activity.this.u.setVisibility(8);
                        Stub_Interstitial_Graphic_Portrait_Activity.this.b.isFirstPassiveTransfer = false;
                        Stub_Interstitial_Graphic_Portrait_Activity stub_Interstitial_Graphic_Portrait_Activity = Stub_Interstitial_Graphic_Portrait_Activity.this;
                        stub_Interstitial_Graphic_Portrait_Activity.a((Activity) stub_Interstitial_Graphic_Portrait_Activity, 11);
                    }
                    Stub_Interstitial_Graphic_Portrait_Activity.this.finish();
                    return;
                }
                Stub_Interstitial_Graphic_Portrait_Activity.this.k.setText(Stub_Interstitial_Graphic_Portrait_Activity.this.r + "秒");
                Stub_Interstitial_Graphic_Portrait_Activity.this.p();
                if (Stub_Interstitial_Graphic_Portrait_Activity.this.b.materialInfo.materialType == 2) {
                    if (Stub_Interstitial_Graphic_Portrait_Activity.this.u.getVisibility() == 8 && Stub_Interstitial_Graphic_Portrait_Activity.this.r == Stub_Interstitial_Graphic_Portrait_Activity.this.b.bubbleWaitTime && Stub_Interstitial_Graphic_Portrait_Activity.this.b.isFirstPassiveTransfer && Stub_Interstitial_Graphic_Portrait_Activity.this.b.isAutoWaitTransferEnable) {
                        Stub_Interstitial_Graphic_Portrait_Activity.this.u.setVisibility(0);
                        Stub_Interstitial_Graphic_Portrait_Activity.this.u.setAnimation(AnimationUtils.loadAnimation(Stub_Interstitial_Graphic_Portrait_Activity.this, R.anim.tapad_dync_in_from_right));
                    }
                    if (Stub_Interstitial_Graphic_Portrait_Activity.this.u.getVisibility() == 0) {
                        ((TextView) Stub_Interstitial_Graphic_Portrait_Activity.this.u.findViewById(R.id.content)).setText(String.format("%d s%s", Integer.valueOf(Stub_Interstitial_Graphic_Portrait_Activity.this.r), Stub_Interstitial_Graphic_Portrait_Activity.this.b.bubbleContent));
                    }
                }
            }
        }
    }

    class l implements com.tapsdk.tapad.internal.animation.e {
        l() {
        }

        @Override // com.tapsdk.tapad.internal.animation.e
        public void a() {
            Stub_Interstitial_Graphic_Portrait_Activity.this.D = false;
        }

        @Override // com.tapsdk.tapad.internal.animation.e
        public void a(int i) {
            Stub_Interstitial_Graphic_Portrait_Activity stub_Interstitial_Graphic_Portrait_Activity = Stub_Interstitial_Graphic_Portrait_Activity.this;
            stub_Interstitial_Graphic_Portrait_Activity.a((Activity) stub_Interstitial_Graphic_Portrait_Activity, i);
        }
    }

    class m implements SurfaceHolder.Callback {
        m() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (Stub_Interstitial_Graphic_Portrait_Activity.this.f != null) {
                Stub_Interstitial_Graphic_Portrait_Activity.this.f.setDisplay(surfaceHolder);
                if (!Stub_Interstitial_Graphic_Portrait_Activity.this.f.isPlaying()) {
                    TapADLogger.d("surfaceCreated inner");
                }
                Stub_Interstitial_Graphic_Portrait_Activity.this.s = true;
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            Stub_Interstitial_Graphic_Portrait_Activity.this.s = false;
        }
    }

    class n implements MediaPlayer.OnPreparedListener {
        final /* synthetic */ AdInfo a;

        n(AdInfo adInfo) {
            this.a = adInfo;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Stub_Interstitial_Graphic_Portrait_Activity.this.p = true;
            Stub_Interstitial_Graphic_Portrait_Activity.this.o();
            Stub_Interstitial_Graphic_Portrait_Activity.this.k();
            com.tapsdk.tapad.internal.tracker.c cVarA = com.tapsdk.tapad.internal.tracker.c.a();
            AdInfo adInfo = this.a;
            cVarA.a(adInfo.videoViewMonitorUrls, (Map<String, String>) null, adInfo.getVideoViewMonitorHeaderListWrapper());
            Stub_Interstitial_Graphic_Portrait_Activity.this.i.setVisibility(0);
            Stub_Interstitial_Graphic_Portrait_Activity.this.l.setVisibility(8);
            Stub_Interstitial_Graphic_Portrait_Activity.this.f.setLooping(true);
        }
    }

    class o implements MediaPlayer.OnVideoSizeChangedListener {
        o() {
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            if (mediaPlayer == null || mediaPlayer.getVideoWidth() <= 0 || mediaPlayer.getVideoHeight() <= 0) {
                return;
            }
            Stub_Interstitial_Graphic_Portrait_Activity.this.e.adjustSize(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
        }
    }

    class p implements View.OnClickListener {
        final /* synthetic */ AdInfo a;
        final /* synthetic */ Activity b;

        p(AdInfo adInfo, Activity activity) {
            this.a = adInfo;
            this.b = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AdInfo adInfo = this.a;
            if (com.tapsdk.tapad.internal.utils.c.a(adInfo, adInfo.btnInteractionInfo)) {
                Stub_Interstitial_Graphic_Portrait_Activity.this.a(this.b, 1);
                return;
            }
            Stub_Interstitial_Graphic_Portrait_Activity stub_Interstitial_Graphic_Portrait_Activity = Stub_Interstitial_Graphic_Portrait_Activity.this;
            stub_Interstitial_Graphic_Portrait_Activity.o = true ^ stub_Interstitial_Graphic_Portrait_Activity.o;
            if (Stub_Interstitial_Graphic_Portrait_Activity.this.o) {
                Stub_Interstitial_Graphic_Portrait_Activity.this.o();
            } else {
                Stub_Interstitial_Graphic_Portrait_Activity.this.l();
            }
        }
    }

    class q implements View.OnClickListener {
        q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Stub_Interstitial_Graphic_Portrait_Activity.this.g == 0) {
                Stub_Interstitial_Graphic_Portrait_Activity.this.g = 1;
                Stub_Interstitial_Graphic_Portrait_Activity.this.k();
            } else {
                Stub_Interstitial_Graphic_Portrait_Activity.this.g = 0;
                Stub_Interstitial_Graphic_Portrait_Activity.this.b();
            }
            Stub_Interstitial_Graphic_Portrait_Activity.this.t();
        }
    }

    class r implements DownloadPresenter.h {
        final /* synthetic */ AdInfo a;

        r(AdInfo adInfo) {
            this.a = adInfo;
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void a() {
            Stub_Interstitial_Graphic_Portrait_Activity.this.a(true);
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void a(int i) {
            TapADLogger.d("updateDownloadProgress:" + i);
            Stub_Interstitial_Graphic_Portrait_Activity.this.a(false);
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void b() {
            Stub_Interstitial_Graphic_Portrait_Activity.this.a(true);
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void c() {
            TapADLogger.d("downloadStart---");
            Stub_Interstitial_Graphic_Portrait_Activity.this.a(false);
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void d() {
            Stub_Interstitial_Graphic_Portrait_Activity.this.a(false);
            Stub_Interstitial_Graphic_Portrait_Activity.this.c.a(new DownloadPresenter.k(this.a));
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void e() {
            TapADLogger.d("downloadError");
            Stub_Interstitial_Graphic_Portrait_Activity.this.a(true);
        }
    }

    class s extends CountDownTimer {
        s(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (Stub_Interstitial_Graphic_Portrait_Activity.this.u.getVisibility() == 0) {
                Stub_Interstitial_Graphic_Portrait_Activity.this.u.setVisibility(8);
                Stub_Interstitial_Graphic_Portrait_Activity.this.b.isFirstPassiveTransfer = false;
                Stub_Interstitial_Graphic_Portrait_Activity stub_Interstitial_Graphic_Portrait_Activity = Stub_Interstitial_Graphic_Portrait_Activity.this;
                stub_Interstitial_Graphic_Portrait_Activity.a((Activity) stub_Interstitial_Graphic_Portrait_Activity, 11);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            if (Stub_Interstitial_Graphic_Portrait_Activity.this.u.getVisibility() == 8 && j / 1000 == Stub_Interstitial_Graphic_Portrait_Activity.this.b.bubbleWaitTime && Stub_Interstitial_Graphic_Portrait_Activity.this.b.isFirstPassiveTransfer && Stub_Interstitial_Graphic_Portrait_Activity.this.b.isAutoWaitTransferEnable) {
                Stub_Interstitial_Graphic_Portrait_Activity.this.u.setVisibility(0);
                Stub_Interstitial_Graphic_Portrait_Activity.this.u.setAnimation(AnimationUtils.loadAnimation(Stub_Interstitial_Graphic_Portrait_Activity.this, R.anim.tapad_dync_in_from_right));
            }
            if (Stub_Interstitial_Graphic_Portrait_Activity.this.u.getVisibility() == 0) {
                ((TextView) Stub_Interstitial_Graphic_Portrait_Activity.this.u.findViewById(R.id.content)).setText(String.format("%d s%s", Long.valueOf(j / 1000), Stub_Interstitial_Graphic_Portrait_Activity.this.b.bubbleContent));
            }
        }
    }

    class t implements View.OnClickListener {
        t() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!Stub_Interstitial_Graphic_Portrait_Activity.this.b.isFirstPassiveTransfer || !Stub_Interstitial_Graphic_Portrait_Activity.this.b.isCloseTransferEnable) {
                Stub_Interstitial_Graphic_Portrait_Activity.this.a.onAdClose();
                Stub_Interstitial_Graphic_Portrait_Activity.this.finish();
            } else {
                Stub_Interstitial_Graphic_Portrait_Activity.this.b.isFirstPassiveTransfer = false;
                Stub_Interstitial_Graphic_Portrait_Activity.this.u.setVisibility(8);
                Stub_Interstitial_Graphic_Portrait_Activity stub_Interstitial_Graphic_Portrait_Activity = Stub_Interstitial_Graphic_Portrait_Activity.this;
                stub_Interstitial_Graphic_Portrait_Activity.a((Activity) stub_Interstitial_Graphic_Portrait_Activity, 10);
            }
        }
    }

    class u implements View.OnClickListener {
        u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Stub_Interstitial_Graphic_Portrait_Activity stub_Interstitial_Graphic_Portrait_Activity = Stub_Interstitial_Graphic_Portrait_Activity.this;
            com.tapsdk.tapad.internal.s.a.a(stub_Interstitial_Graphic_Portrait_Activity, stub_Interstitial_Graphic_Portrait_Activity.b.appInfo.appDescUrl, Stub_Interstitial_Graphic_Portrait_Activity.this.b);
        }
    }

    class v implements Consumer<com.tapsdk.tapad.stub.activity.a> {
        v() {
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(com.tapsdk.tapad.stub.activity.a aVar) throws Exception {
            Map<String, Object> mapA = aVar.a();
            if (mapA == null || !mapA.containsKey("track_id")) {
                return;
            }
            String str = (String) mapA.get("track_id");
            TapADLogger.d("receive finish Interstitial message:" + str + ", adInfo trackId:" + Stub_Interstitial_Graphic_Portrait_Activity.this.b.trackId);
            if (str == null || str.length() <= 0 || !str.equals(Stub_Interstitial_Graphic_Portrait_Activity.this.b.trackId) || Stub_Interstitial_Graphic_Portrait_Activity.T == null || Stub_Interstitial_Graphic_Portrait_Activity.T.get() == null) {
                return;
            }
            ((Stub_Interstitial_Graphic_Portrait_Activity) Stub_Interstitial_Graphic_Portrait_Activity.T.get()).finish();
        }
    }

    class w implements View.OnClickListener {
        w() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Stub_Interstitial_Graphic_Portrait_Activity stub_Interstitial_Graphic_Portrait_Activity = Stub_Interstitial_Graphic_Portrait_Activity.this;
            com.tapsdk.tapad.internal.s.a.a(stub_Interstitial_Graphic_Portrait_Activity, stub_Interstitial_Graphic_Portrait_Activity.b.appInfo.appPrivacyPolicy, Stub_Interstitial_Graphic_Portrait_Activity.this.b);
        }
    }

    class x implements View.OnClickListener {
        x() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Stub_Interstitial_Graphic_Portrait_Activity stub_Interstitial_Graphic_Portrait_Activity = Stub_Interstitial_Graphic_Portrait_Activity.this;
            com.tapsdk.tapad.internal.s.a.a(stub_Interstitial_Graphic_Portrait_Activity, stub_Interstitial_Graphic_Portrait_Activity.b.appInfo.appPermissionsLink, Stub_Interstitial_Graphic_Portrait_Activity.this.b);
        }
    }

    class y implements Consumer<Throwable> {
        y() {
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            TapADLogger.d("receive finish Interstitial error:" + (th != null ? th.getMessage() : "no error message"));
        }
    }

    class z implements com.tapsdk.tapad.internal.tracker.b.InterfaceC0634b {
        z() {
        }

        @Override // com.tapsdk.tapad.internal.tracker.b.InterfaceC0634b
        public void a() {
            if (Stub_Interstitial_Graphic_Portrait_Activity.this.a != null) {
                Stub_Interstitial_Graphic_Portrait_Activity.this.a.onAdValidShow();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, int i2) {
        DownloadPresenter downloadPresenter;
        com.tapsdk.tapad.internal.b jVar;
        TapADTrackerObject tapADTrackerObject = this.b.tapADTrackerObject;
        if (tapADTrackerObject != null) {
            tapADTrackerObject.a(i2, null);
        } else {
            com.tapsdk.tapad.internal.tracker.c.a().a(com.tapsdk.tapad.internal.utils.s.a(this.b.clickMonitorUrls, i2), (Map<String, String>) null, this.b.getClickMonitorHeaderListWrapper());
        }
        AdInfo adInfo = this.b;
        if (adInfo.btnInteractionInfo.interactionType != 1) {
            com.tapsdk.tapad.internal.s.a.a(activity, false, adInfo, this.c);
            return;
        }
        if (com.tapsdk.tapad.internal.utils.b.a(activity, adInfo.appInfo.packageName)) {
            if (com.tapsdk.tapad.internal.utils.b.b(activity, this.b.appInfo.packageName)) {
                return;
            }
            TapADLogger.d("BottomBannerView 打开异常");
            return;
        }
        DownloadPresenter.DownloadState downloadStateC = this.c.c();
        if (downloadStateC == DownloadPresenter.DownloadState.DEFAULT || downloadStateC == DownloadPresenter.DownloadState.ERROR) {
            a(true);
            downloadPresenter = this.c;
            jVar = new DownloadPresenter.j(this.b);
        } else {
            if (downloadStateC == DownloadPresenter.DownloadState.STARTED) {
                return;
            }
            if (com.tapsdk.tapad.internal.a.a(getApplicationContext(), this.b).exists()) {
                a(false);
                downloadPresenter = this.c;
                jVar = new DownloadPresenter.k(this.b);
            } else {
                downloadPresenter = this.c;
                jVar = new DownloadPresenter.i(this.b);
            }
        }
        downloadPresenter.a(jVar);
    }

    private void a(Activity activity, AdInfo adInfo) {
        this.c = new DownloadPresenter(activity, new r(adInfo));
    }

    private void a(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(getApplicationContext()).inflate(R.layout.tapad_logo_header, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.bottomSquareBannerAdLogoTextView);
        ((ImageView) viewInflate.findViewById(R.id.bottomSquareBannerAdLogoImageView)).setVisibility(this.b.logoInfo.logoStatus == 1 ? 0 : 8);
        String string = getApplicationContext().getResources().getString(R.string.tapad_str_ads);
        String str = this.b.logoInfo.logoTitle;
        if (str != null && str.length() > 0 && this.b.logoInfo.logoTitle.length() < 5) {
            string = this.b.logoInfo.logoTitle;
        }
        textView.setText(string);
        viewGroup.addView(viewInflate);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(20);
        layoutParams.addRule(10);
        layoutParams.setMargins(0, 0, 0, 0);
        layoutParams.height = com.tapsdk.tapad.internal.utils.t.a(getApplicationContext(), 12.0f);
        layoutParams.width = -2;
        viewInflate.setLayoutParams(layoutParams);
    }

    private void a(ViewGroup viewGroup, boolean z2) {
        ViewGroup.LayoutParams layoutParams;
        View viewInflate = LayoutInflater.from(getApplicationContext()).inflate(z2 ? R.layout.tapad_skip : R.layout.tapad_close_button, (ViewGroup) null);
        viewInflate.setOnClickListener(new t());
        if (z2) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 8388661;
            if (viewGroup != null) {
                viewGroup.addView(viewInflate, layoutParams2);
            } else {
                addContentView(viewInflate, layoutParams2);
            }
            layoutParams2.setMargins(0, com.tapsdk.tapad.internal.utils.t.a(getApplicationContext(), 18.0f), com.tapsdk.tapad.internal.utils.t.a(getApplicationContext(), 18.0f), 0);
            layoutParams2.height = com.tapsdk.tapad.internal.utils.t.a(getApplicationContext(), 28.0f);
            layoutParams2.width = com.tapsdk.tapad.internal.utils.t.a(getApplicationContext(), 70.0f);
            layoutParams = layoutParams2;
        } else {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(11);
            layoutParams3.addRule(10);
            viewGroup.addView(viewInflate, layoutParams3);
            layoutParams3.setMargins(0, com.tapsdk.tapad.internal.utils.t.a(getApplicationContext(), 10.0f), com.tapsdk.tapad.internal.utils.t.a(getApplicationContext(), 10.0f), 0);
            layoutParams3.height = com.tapsdk.tapad.internal.utils.t.a(getApplicationContext(), 28.0f);
            layoutParams3.width = com.tapsdk.tapad.internal.utils.t.a(getApplicationContext(), 28.0f);
            layoutParams = layoutParams3;
        }
        viewInflate.setLayoutParams(layoutParams);
    }

    private void a(AdInfo adInfo, String str, Activity activity) {
        j();
        try {
            this.f = new MediaPlayer();
            TapADLogger.d("ad video url:" + str);
            this.f.reset();
            this.f.setDataSource(activity, Uri.parse(str));
            this.e.getHolder().addCallback(new m());
            this.f.prepareAsync();
            this.f.setOnPreparedListener(new n(adInfo));
            this.f.setOnVideoSizeChangedListener(new o());
            this.e.setOnClickListener(new p(adInfo, activity));
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        MediaPlayer mediaPlayer = this.f;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(0.0f, 0.0f);
        }
    }

    private void d() {
        TextView textView = (TextView) findViewById(R.id.describeTextView);
        TextView textView2 = (TextView) findViewById(R.id.privacyTextView);
        TextView textView3 = (TextView) findViewById(R.id.permissionTextView);
        TextView textView4 = (TextView) findViewById(R.id.privacyVersionTextView);
        TextView textView5 = (TextView) findViewById(R.id.supplierTextView);
        textView.setVisibility(TextUtils.isEmpty(this.b.appInfo.appDescUrl) ? 8 : 0);
        textView.setOnClickListener(new u());
        textView2.setVisibility(TextUtils.isEmpty(this.b.appInfo.appPrivacyPolicy) ? 8 : 0);
        textView2.setOnClickListener(new w());
        textView3.setVisibility(TextUtils.isEmpty(this.b.appInfo.appPermissionsLink) ? 8 : 0);
        textView3.setOnClickListener(new x());
        String str = this.b.appInfo.appVersion;
        if (str == null || str.length() <= 0) {
            textView4.setText("");
        } else {
            textView4.setText(String.format(getResources().getString(R.string.tapad_ad_version_title), this.b.appInfo.appVersion));
        }
        String str2 = this.b.appInfo.appDeveloper;
        if (str2 == null || str2.length() <= 0) {
            textView5.setText("");
        } else {
            textView5.setText(this.b.appInfo.appDeveloper);
        }
    }

    private void e() {
        TextView textView = (TextView) findViewById(R.id.bottomSquareBannerAdLogoTextView);
        ((ImageView) findViewById(R.id.bottomSquareBannerAdLogoImageView)).setVisibility(this.b.logoInfo.logoStatus == 1 ? 0 : 8);
        String string = getResources().getString(R.string.tapad_str_ads);
        String str = this.b.logoInfo.logoTitle;
        if (str != null && str.length() > 0 && this.b.logoInfo.logoTitle.length() < 5) {
            string = this.b.logoInfo.logoTitle;
        }
        textView.setText(string);
    }

    private CountDownTimer f() {
        return new s(1000 * ((long) (this.b.bubbleWaitTime + 1)), 1000L);
    }

    private void g() {
        this.u = (ViewGroup) findViewById(R.id.bubbleView);
        InteractionInfo interactionInfo = this.b.btnInteractionInfo;
        if (interactionInfo != null) {
            String strExtractWaitInteractionIconUrl = interactionInfo.extractWaitInteractionIconUrl();
            if (TextUtils.isEmpty(strExtractWaitInteractionIconUrl)) {
                strExtractWaitInteractionIconUrl = this.b.appInfo.appIconImage.imageUrl;
            }
            if (!TextUtils.isEmpty(strExtractWaitInteractionIconUrl)) {
                Glide.with((Activity) this).load(strExtractWaitInteractionIconUrl).into((ImageView) this.u.findViewById(R.id.icon_image));
            }
            String strExtractWaitInteractionDescription = this.b.btnInteractionInfo.extractWaitInteractionDescription();
            if (!TextUtils.isEmpty(strExtractWaitInteractionDescription)) {
                ((TextView) this.u.findViewById(R.id.description)).setText(strExtractWaitInteractionDescription);
            }
        }
        if (this.b.materialInfo.materialType == 1) {
            f().start();
        }
    }

    private void h() throws com.tapsdk.tapad.exceptions.e {
        a((ViewGroup) null, true);
        d();
        e();
        View viewFindViewById = findViewById(R.id.bottomBannerView);
        this.y = (TextView) findViewById(R.id.bottomSquareBannerInteractionTextView);
        this.z = (ProgressBar) findViewById(R.id.bottomSquareBannerDownloadProgressBar);
        this.B = (RelativeLayout) findViewById(R.id.bottomSquareBannerScoreRelativeLayout);
        this.C = (TextView) findViewById(R.id.bottomSquareBannerRealScoreTextView);
        this.A = (FrameLayout) findViewById(R.id.bottomSquareBannerDownloadFrameLayout);
        this.x = (HotZoneFrameLayout) findViewById(R.id.interstitialViewHotZoneFrameLayout);
        this.v = (HotZoneFrameLayout) findViewById(R.id.interstitialFullZoneFrameLayout);
        g();
        this.u.findViewById(R.id.close_btn).setOnClickListener(new d());
        ImageView imageView = (ImageView) findViewById(R.id.backgroundImageView);
        String strB = com.tapsdk.tapad.e.d.d().b();
        if (strB != null && strB.length() > 0) {
            Glide.with((Activity) this).load(strB).into(imageView);
        }
        (!this.b.materialInfo.imageInfoList.isEmpty() ? Glide.with((Activity) this).load(this.b.materialInfo.imageInfoList.get(0).imageUrl).addListener(new e()) : Glide.with((Activity) this).load(this.b.materialInfo.videoInfoList.get(0).coverImage.imageUrl)).into((ImageView) findViewById(R.id.verticalCoverImageView));
        ((TextView) findViewById(R.id.bottomSquareBannerTitleTextView)).setText(this.b.materialInfo.title);
        ((TextView) findViewById(R.id.bottomSquareBannerDescriptionTextView)).setText(this.b.materialInfo.description);
        Glide.with((Activity) this).load(this.b.appInfo.appIconImage.imageUrl).into((ImageView) findViewById(R.id.bottomSquareBannerIconImageView));
        boolean zB = com.tapsdk.tapad.internal.utils.c.b(this.b.btnInteractionInfo);
        this.D = zB;
        if (zB) {
            Drawable drawable = getResources().getDrawable(R.drawable.tapad_anim_shake_01);
            this.J = drawable;
            drawable.setBounds(0, 0, com.tapsdk.tapad.internal.utils.t.a(getApplicationContext(), 20.0f), com.tapsdk.tapad.internal.utils.t.a(getApplicationContext(), 20.0f));
            this.J.setTint(getResources().getColor(R.color.tapad_color_green));
            Drawable drawable2 = getResources().getDrawable(R.drawable.tapad_anim_shake_01);
            this.K = drawable2;
            drawable2.setBounds(0, 0, com.tapsdk.tapad.internal.utils.t.a(getApplicationContext(), 20.0f), com.tapsdk.tapad.internal.utils.t.a(getApplicationContext(), 20.0f));
            this.K.setTint(getResources().getColor(android.R.color.white));
        }
        a(true);
        this.B.setVisibility(this.b.appInfo.tapScore > 0.0f ? 0 : 8);
        if (this.b.appInfo.tapScore > 0.0f) {
            try {
                this.C.setText(new DecimalFormat("#.0").format(this.b.appInfo.tapScore));
            } catch (Exception unused) {
            }
        }
        viewFindViewById.setOnClickListener(new f());
        this.y.setOnClickListener(new g());
        this.A.setOnClickListener(new h());
        boolean zA = com.tapsdk.tapad.internal.utils.c.a(this.b.btnInteractionInfo);
        this.x.setVisibility(zA ? 0 : 8);
        if (zA) {
            this.x.setOnClickListener(new i());
        }
        this.v.setVisibility(zA ? 0 : 8);
        if (zA) {
            this.v.setOnClickListener(new j());
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:26:0x0209  */
    /* JADX WARN: Code duplicated, block: B:27:0x020b  */
    /* JADX WARN: Code duplicated, block: B:34:0x023d  */
    /* JADX WARN: Code duplicated, block: B:37:0x0243  */
    /* JADX WARN: Code duplicated, block: B:40:0x0219 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:? A[RETURN, SYNTHETIC] */
    private void i() {
        ImageInfo imageInfo;
        ImageInfo imageInfo2;
        int i2;
        ImageView imageView;
        Runnable c0Var;
        int i3;
        boolean zA;
        a((ViewGroup) this.d, false);
        d();
        a(this.d);
        this.y = (TextView) findViewById(R.id.bottomSquareBannerInteractionTextView);
        this.z = (ProgressBar) findViewById(R.id.bottomSquareBannerDownloadProgressBar);
        this.B = (RelativeLayout) findViewById(R.id.bottomSquareBannerScoreRelativeLayout);
        this.C = (TextView) findViewById(R.id.bottomSquareBannerRealScoreTextView);
        this.A = (FrameLayout) findViewById(R.id.bottomSquareBannerDownloadFrameLayout);
        this.l = (ImageView) findViewById(R.id.adCoverImage);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.video_surface);
        this.i = linearLayout;
        this.e = (VideoSurfaceView) linearLayout.findViewById(R.id.adsSurfaceView);
        this.j = (ImageView) this.i.findViewById(R.id.volumeImageView);
        this.k = (TextView) this.i.findViewById(R.id.countDownTextView);
        this.m = (TextView) this.i.findViewById(R.id.skipTextView);
        this.i.setVisibility(8);
        this.x = (HotZoneFrameLayout) findViewById(R.id.hotZoneFrameLayout);
        this.h = (ImageView) findViewById(R.id.mediaPlayerImageView);
        g();
        this.u.findViewById(R.id.close_btn).setOnClickListener(new a0());
        boolean zB = com.tapsdk.tapad.internal.utils.c.b(this.b.btnInteractionInfo);
        this.D = zB;
        if (zB) {
            Drawable drawable = getResources().getDrawable(R.drawable.tapad_anim_shake_01);
            this.J = drawable;
            drawable.setBounds(0, 0, com.tapsdk.tapad.internal.utils.t.a(getApplicationContext(), 20.0f), com.tapsdk.tapad.internal.utils.t.a(getApplicationContext(), 20.0f));
            this.J.setTint(getResources().getColor(R.color.tapad_color_green));
            Drawable drawable2 = getResources().getDrawable(R.drawable.tapad_anim_shake_01);
            this.K = drawable2;
            drawable2.setBounds(0, 0, com.tapsdk.tapad.internal.utils.t.a(getApplicationContext(), 20.0f), com.tapsdk.tapad.internal.utils.t.a(getApplicationContext(), 20.0f));
            this.K.setTint(getResources().getColor(android.R.color.white));
        }
        ((TextView) findViewById(R.id.bottomSquareBannerTitleTextView)).setText(this.b.materialInfo.title);
        ((TextView) findViewById(R.id.bottomSquareBannerDescriptionTextView)).setText(this.b.materialInfo.description);
        Glide.with((Activity) this).load(this.b.appInfo.appIconImage.imageUrl).centerCrop().into((ImageView) findViewById(R.id.bottomSquareBannerIconImageView));
        MaterialInfo materialInfo = this.b.materialInfo;
        List<VideoInfo> list = materialInfo.videoInfoList;
        List<ImageInfo> list2 = materialInfo.imageInfoList;
        if (list.isEmpty()) {
            if (!list2.isEmpty()) {
                imageInfo = list2.get(0);
            }
            if (this.f == null && !list.isEmpty()) {
                this.r = list.get(0).duration;
                this.k.setText(String.format("%s秒", Integer.valueOf(this.r)));
            }
            imageInfo2 = this.n;
            i2 = imageInfo2.height;
            if (i2 > imageInfo2.width || i2 <= 0 || this.f != null) {
                imageView = this.l;
                c0Var = new c0();
            } else {
                imageView = this.l;
                c0Var = new b0();
            }
            imageView.post(c0Var);
            a(list, this);
            a(true);
            this.A.setOnClickListener(new d0());
            this.y.setOnClickListener(new e0());
            this.d.setOnClickListener(new a());
            this.m.setOnClickListener(new b());
            RelativeLayout relativeLayout = this.B;
            if (this.b.appInfo.tapScore > 0.0f) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            relativeLayout.setVisibility(i3);
            if (this.b.appInfo.tapScore > 0.0f) {
                try {
                    this.C.setText(new DecimalFormat("#.0").format(this.b.appInfo.tapScore));
                } catch (Exception unused) {
                }
            }
            zA = com.tapsdk.tapad.internal.utils.c.a(this.b.btnInteractionInfo);
            this.x.setVisibility(zA ? 0 : 8);
            if (zA) {
                this.x.setOnClickListener(new c());
            }
        }
        imageInfo = list.get(0).coverImage;
        this.n = imageInfo;
        if (this.f == null) {
            this.r = list.get(0).duration;
            this.k.setText(String.format("%s秒", Integer.valueOf(this.r)));
        }
        imageInfo2 = this.n;
        i2 = imageInfo2.height;
        if (i2 > imageInfo2.width) {
            imageView = this.l;
            c0Var = new c0();
        } else {
            imageView = this.l;
            c0Var = new c0();
        }
        imageView.post(c0Var);
        a(list, this);
        a(true);
        this.A.setOnClickListener(new d0());
        this.y.setOnClickListener(new e0());
        this.d.setOnClickListener(new a());
        this.m.setOnClickListener(new b());
        RelativeLayout relativeLayout2 = this.B;
        if (this.b.appInfo.tapScore > 0.0f) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        relativeLayout2.setVisibility(i3);
        if (this.b.appInfo.tapScore > 0.0f) {
            this.C.setText(new DecimalFormat("#.0").format(this.b.appInfo.tapScore));
        }
        zA = com.tapsdk.tapad.internal.utils.c.a(this.b.btnInteractionInfo);
        this.x.setVisibility(zA ? 0 : 8);
        if (zA) {
            this.x.setOnClickListener(new c());
        }
    }

    private void j() {
        this.j.setOnClickListener(new q());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        MediaPlayer mediaPlayer = this.f;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(0.09f, 0.09f);
        }
    }

    private void m() {
        if (this.M != null) {
            return;
        }
        this.M = com.tapsdk.tapad.internal.utils.n.a().a(com.tapsdk.tapad.stub.activity.a.class).subscribe(new v(), new y());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        messageObtain.obj = Integer.valueOf(this.r - 1);
        this.w.sendMessageDelayed(messageObtain, 1000L);
    }

    private void q() {
        h();
    }

    private void r() {
        i();
    }

    private void s() {
        Disposable disposable = this.M;
        if (disposable == null || disposable.isDisposed()) {
            return;
        }
        this.M.dispose();
        this.M = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        this.j.setImageResource(this.g == 1 ? R.drawable.tapad_ic_audio_open : R.drawable.tapad_ic_audio_mute);
    }

    public void a(InteractionInfo interactionInfo) {
        if (com.tapsdk.tapad.internal.utils.c.b(interactionInfo)) {
            if (this.E == null) {
                this.E = com.tapsdk.tapad.internal.animation.h.a(this, new l());
            }
            if (this.F == null && !this.I) {
                this.F = new com.tapsdk.tapad.internal.animation.i();
                float fExtractShakeAngle = this.b.btnInteractionInfo.extractShakeAngle();
                if (fExtractShakeAngle > 0.0f) {
                    this.F.a(fExtractShakeAngle);
                }
            }
            if (this.H == null && this.I) {
                com.tapsdk.tapad.internal.animation.l.a aVar = new com.tapsdk.tapad.internal.animation.l.a();
                this.H = aVar;
                aVar.a(this.b.btnInteractionInfo.extractXShakeSpeedEnable(), this.b.btnInteractionInfo.extractYShakeSpeedEnable(), this.b.btnInteractionInfo.extractZShakeSpeedEnable(), this.b.btnInteractionInfo.extractXShakeSpeed(), this.b.btnInteractionInfo.extractYShakeSpeed(), this.b.btnInteractionInfo.extractZShakeSpeed());
            }
            if (this.G == null && this.I) {
                com.tapsdk.tapad.internal.animation.l.b bVar = new com.tapsdk.tapad.internal.animation.l.b();
                this.G = bVar;
                bVar.a(this.b.btnInteractionInfo.extractXShakeDegreeEnable(), this.b.btnInteractionInfo.extractYShakeDegreeEnable(), this.b.btnInteractionInfo.extractZShakeDegreeEnable(), this.b.btnInteractionInfo.extractXShakeDegree(), this.b.btnInteractionInfo.extractYShakeDegree(), this.b.btnInteractionInfo.extractZShakeDegree());
            }
            a(true);
        }
    }

    public void a(List<VideoInfo> list, Activity activity) {
        if (list == null || list.isEmpty() || this.f != null) {
            return;
        }
        a(this.b, list.get(0).videoUrl, activity);
    }

    /* JADX WARN: Code duplicated, block: B:42:0x0117  */
    /* JADX WARN: Code duplicated, block: B:56:0x017f  */
    /* JADX WARN: Code duplicated, block: B:60:? A[RETURN, SYNTHETIC] */
    public void a(boolean z2) {
        boolean z3;
        Boolean bool;
        boolean z4;
        com.tapsdk.tapad.internal.animation.h hVar;
        com.tapsdk.tapad.internal.animation.a aVar;
        Drawable drawable = this.K;
        AdInfo adInfo = this.b;
        if (adInfo.btnInteractionInfo.interactionType == 1) {
            DownloadPresenter.DownloadState downloadStateC = this.c.c();
            if (downloadStateC == DownloadPresenter.DownloadState.STARTED || !com.tapsdk.tapad.internal.utils.b.a(getApplicationContext(), this.b.appInfo.packageName)) {
                this.y.setBackgroundResource(R.drawable.tapad_bg_reward_button_green_corner24dp);
                this.y.setTextColor(getResources().getColor(android.R.color.white));
                Drawable drawable2 = this.K;
                int iB = this.c.b();
                if (downloadStateC != DownloadPresenter.DownloadState.DEFAULT && downloadStateC != DownloadPresenter.DownloadState.ERROR) {
                    if (downloadStateC == DownloadPresenter.DownloadState.STARTED) {
                        this.A.setVisibility(0);
                        this.z.setProgress(Math.max(iB, 10));
                        this.y.setVisibility(8);
                        drawable = drawable2;
                        z3 = false;
                    } else {
                        this.A.setVisibility(8);
                        this.y.setVisibility(0);
                        this.y.setText(R.string.tapad_banner_install);
                    }
                    bool = Boolean.TRUE;
                    if (z3 || !this.D || this.b == null || drawable == null) {
                        z4 = false;
                    } else {
                        z4 = true;
                    }
                    if (bool.equals(Boolean.valueOf(z4)) || !com.tapsdk.tapad.internal.utils.c.b(this.b.btnInteractionInfo)) {
                        hVar = this.E;
                        if (hVar != null) {
                            hVar.a();
                        }
                    }
                    com.tapsdk.tapad.internal.animation.j jVar = new com.tapsdk.tapad.internal.animation.j(drawable, 0, com.tapsdk.tapad.internal.utils.t.a(getApplicationContext(), 4.0f));
                    SpannableString spannableString = new SpannableString("$" + this.y.getText().toString());
                    spannableString.setSpan(jVar, 0, 1, 33);
                    this.y.setText(spannableString);
                    com.tapsdk.tapad.internal.animation.h hVar2 = this.E;
                    if (hVar2 != null) {
                        if (this.I) {
                            hVar2.a((com.tapsdk.tapad.internal.animation.a) this.H);
                            hVar2 = this.E;
                            aVar = this.G;
                        } else {
                            aVar = this.F;
                        }
                        hVar2.a(aVar);
                        return;
                    }
                    return;
                }
                AppInfo appInfo = this.b.appInfo;
                if (appInfo.apkSize > 0 && com.tapsdk.tapad.internal.utils.q.a(appInfo.appSize)) {
                    this.y.setText(String.format(getApplicationContext().getString(R.string.tapad_banner_download_with_size), this.b.appInfo.appSize));
                } else {
                    this.y.setText(R.string.tapad_banner_download);
                }
                this.A.setVisibility(8);
                this.y.setVisibility(0);
                drawable = drawable2;
            } else {
                this.y.setText(R.string.tapad_banner_open);
                this.A.setVisibility(8);
                this.y.setBackgroundResource(R.drawable.tapad_bg_reward_button_light_green_corner24dp);
                this.y.setTextColor(getResources().getColor(R.color.tapad_color_green));
                drawable = this.J;
            }
        } else {
            String str = adInfo.btnName;
            if (str == null || str.length() <= 0) {
                this.y.setText(R.string.tapad_banner_open);
            } else {
                this.y.setText(this.b.btnName);
            }
        }
        z3 = true;
        bool = Boolean.TRUE;
        if (z3) {
            z4 = false;
        } else {
            z4 = false;
        }
        if (bool.equals(Boolean.valueOf(z4))) {
        }
        hVar = this.E;
        if (hVar != null) {
            hVar.a();
        }
    }

    public void c() {
        com.tapsdk.tapad.internal.animation.h hVar = this.E;
        if (hVar != null) {
            try {
                hVar.a();
            } catch (Exception unused) {
            }
        }
    }

    public void l() {
        if (this.b.materialInfo.videoInfoList.isEmpty()) {
            return;
        }
        MediaPlayer mediaPlayer = this.f;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.f.pause();
        }
        boolean z2 = !this.s || this.o;
        this.o = z2;
        ImageView imageView = this.h;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(z2 ? 8 : 0);
        Handler handler = this.w;
        if (handler != null) {
            handler.removeMessages(1);
        }
        this.c.a(new RewardPresenter.e());
    }

    public void n() {
        MediaPlayer mediaPlayer = this.f;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.f.release();
            this.f = null;
        }
    }

    public void o() {
        ImageView imageView;
        MediaPlayer mediaPlayer;
        if (this.b.materialInfo.videoInfoList.isEmpty() || (imageView = this.h) == null) {
            return;
        }
        imageView.setVisibility(this.o ? 8 : 0);
        if (!this.p || !this.o || (mediaPlayer = this.f) == null || mediaPlayer.isPlaying()) {
            return;
        }
        this.f.start();
        p();
        if (this.o) {
            this.c.a(new RewardPresenter.g());
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
    }

    /* JADX WARN: Code duplicated, block: B:15:0x004e  */
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        ExposureTrackerObject exposureTrackerObject;
        String str;
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().addFlags(1152);
        if (Build.VERSION.SDK_INT != 26 && getResources().getConfiguration().orientation == 2) {
            setRequestedOrientation(1);
        }
        T = new WeakReference<>(this);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            AdInfo adInfo = (AdInfo) extras.getParcelable("data");
            this.b = adInfo;
            if (adInfo == null) {
                TapADLogger.d("Stub_Standard_Portrait_Activity 未传入广告信息");
            } else {
                m();
                if (((AdRequest) extras.getParcelable("request")) == null) {
                    TapADLogger.d("Stub_Standard_Portrait_Activity 未传入广告信息");
                } else {
                    int i2 = extras.getInt("c_id", Integer.MIN_VALUE);
                    this.L = i2;
                    if (i2 == Integer.MIN_VALUE) {
                        str = "Stub_Standard_Portrait_Activity 未传入callbackId";
                    } else {
                        com.tapsdk.tapad.internal.e.a aVarA = com.tapsdk.tapad.internal.e.a(Integer.valueOf(i2));
                        this.a = aVarA;
                        if (aVarA == null) {
                            str = "Stub_Standard_Portrait_Activity 获取rewardBridge异常";
                        } else {
                            try {
                                a(this, this.b);
                                if (this.b.renderStyles.c == 0) {
                                    setContentView(R.layout.tapad_activity_interstital_graphic_portrait_full);
                                    q();
                                } else {
                                    setContentView(R.layout.tapad_activity_interstital_graphic_portrait_half);
                                    this.d = (RelativeLayout) findViewById(R.id.interstitial_half_portait_inner);
                                    r();
                                }
                                this.a.onAdShow();
                                this.I = com.tapsdk.tapad.internal.utils.c.c(this.b.btnInteractionInfo);
                                TapADTrackerObject tapADTrackerObject = this.b.tapADTrackerObject;
                                if (tapADTrackerObject == null || (exposureTrackerObject = tapADTrackerObject.a) == null || !exposureTrackerObject.a) {
                                    com.tapsdk.tapad.internal.tracker.c cVarA = com.tapsdk.tapad.internal.tracker.c.a();
                                    AdInfo adInfo2 = this.b;
                                    cVarA.a(adInfo2.viewMonitorUrls, (Map<String, String>) null, adInfo2.getViewMonitorHeaderListWrapper());
                                } else {
                                    exposureTrackerObject.b((Map<String, String>) null);
                                }
                                View viewFindViewById = findViewById(android.R.id.content);
                                if (viewFindViewById != null) {
                                    com.tapsdk.tapad.internal.tracker.b bVar = new com.tapsdk.tapad.internal.tracker.b(viewFindViewById, new z());
                                    this.t = bVar;
                                    bVar.a(this.b.tapADTrackerObject.a);
                                    return;
                                }
                                return;
                            } catch (Exception e2) {
                                this.a.a(e2);
                                e2.printStackTrace();
                            }
                        }
                    }
                }
            }
            finish();
        }
        str = "Stub_Standard_Portrait_Activity 未传入额外信息";
        TapADLogger.d(str);
        finish();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.a != null) {
            this.a = null;
        }
        s();
        c();
        n();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        c();
        l();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        a(this.b.btnInteractionInfo);
        o();
        com.tapsdk.tapad.internal.c.b().a(this, this.b, true);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
    }
}
