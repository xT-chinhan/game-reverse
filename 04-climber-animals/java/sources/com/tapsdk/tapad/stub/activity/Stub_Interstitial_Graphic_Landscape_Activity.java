package com.tapsdk.tapad.stub.activity;

import android.app.Activity;
import android.content.Context;
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
import android.view.ViewTreeObserver;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
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
public class Stub_Interstitial_Graphic_Landscape_Activity extends Activity {
    private static final String P = "data";
    private static final String Q = "request";
    private static final String R = "c_id";
    private static final String S = "receiver_action_finish";
    public static final int T = 1;
    public static final int U = 10;
    private static WeakReference<Stub_Interstitial_Graphic_Landscape_Activity> V;
    private LinearLayout A;
    private ImageView B;
    private TextView C;
    private TextView D;
    private ImageInfo I;
    private ViewGroup K;
    private com.tapsdk.tapad.internal.e.a a;
    private AdInfo b;
    private DownloadPresenter c;
    private com.tapsdk.tapad.internal.animation.h e;
    private com.tapsdk.tapad.internal.animation.i f;
    private com.tapsdk.tapad.internal.animation.l.b g;
    private com.tapsdk.tapad.internal.animation.l.a h;
    private Drawable j;
    private Drawable k;
    private RelativeLayout l;
    private TextView m;
    private RelativeLayout n;
    private TextView o;
    private ProgressBar p;
    private FrameLayout q;
    private FrameLayout r;
    private LinearLayout s;
    private HotZoneFrameLayout t;
    private HotZoneFrameLayout u;
    private ImageView v;
    private VideoSurfaceView w;
    private MediaPlayer x;
    private ImageView z;
    private boolean d = false;
    private boolean i = false;
    private int y = 0;
    private boolean E = true;
    private boolean F = false;
    private boolean G = false;
    private volatile int H = 5;
    private boolean J = false;
    private com.tapsdk.tapad.internal.tracker.b L = null;
    private final Handler M = new k(Looper.myLooper());
    int N = 0;
    private Disposable O = null;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Stub_Interstitial_Graphic_Landscape_Activity.this.s.getHeight() > 0) {
                Stub_Interstitial_Graphic_Landscape_Activity.this.s.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (Stub_Interstitial_Graphic_Landscape_Activity.this.s.getHeight() < Stub_Interstitial_Graphic_Landscape_Activity.this.r.getTop() + Stub_Interstitial_Graphic_Landscape_Activity.this.r.getHeight()) {
                    Stub_Interstitial_Graphic_Landscape_Activity.this.n.setVisibility(8);
                }
            }
        }
    }

    class a0 implements View.OnClickListener {
        a0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Stub_Interstitial_Graphic_Landscape_Activity.this.K.setVisibility(8);
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Stub_Interstitial_Graphic_Landscape_Activity stub_Interstitial_Graphic_Landscape_Activity = Stub_Interstitial_Graphic_Landscape_Activity.this;
            stub_Interstitial_Graphic_Landscape_Activity.a((Activity) stub_Interstitial_Graphic_Landscape_Activity, 1);
        }
    }

    class b0 implements RequestListener<Drawable> {
        b0() {
        }

        @Override // com.bumptech.glide.request.RequestListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
            if (Stub_Interstitial_Graphic_Landscape_Activity.this.L == null) {
                return false;
            }
            Stub_Interstitial_Graphic_Landscape_Activity.this.L.b();
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
            return false;
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Stub_Interstitial_Graphic_Landscape_Activity stub_Interstitial_Graphic_Landscape_Activity = Stub_Interstitial_Graphic_Landscape_Activity.this;
            stub_Interstitial_Graphic_Landscape_Activity.a((Activity) stub_Interstitial_Graphic_Landscape_Activity, 1);
        }
    }

    class c0 implements View.OnClickListener {
        c0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Stub_Interstitial_Graphic_Landscape_Activity.this.c != null) {
                Stub_Interstitial_Graphic_Landscape_Activity.this.c.a(new DownloadPresenter.g());
            }
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Stub_Interstitial_Graphic_Landscape_Activity.this.K.setVisibility(8);
        }
    }

    class d0 implements View.OnClickListener {
        d0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Stub_Interstitial_Graphic_Landscape_Activity stub_Interstitial_Graphic_Landscape_Activity = Stub_Interstitial_Graphic_Landscape_Activity.this;
            stub_Interstitial_Graphic_Landscape_Activity.a((Activity) stub_Interstitial_Graphic_Landscape_Activity, 0);
        }
    }

    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            float f = (Stub_Interstitial_Graphic_Landscape_Activity.this.I.width * 1.0f) / (Stub_Interstitial_Graphic_Landscape_Activity.this.I.height * 1.0f);
            if (com.tapsdk.tapad.internal.utils.a.a((Activity) Stub_Interstitial_Graphic_Landscape_Activity.V.get())) {
                Glide.with((Activity) Stub_Interstitial_Graphic_Landscape_Activity.V.get()).load(Stub_Interstitial_Graphic_Landscape_Activity.this.I.imageUrl).override(com.tapsdk.tapad.internal.utils.t.a((Context) Stub_Interstitial_Graphic_Landscape_Activity.V.get(), 425.0f), com.tapsdk.tapad.internal.utils.t.a((Context) Stub_Interstitial_Graphic_Landscape_Activity.V.get(), f * 425.0f)).centerCrop().into(Stub_Interstitial_Graphic_Landscape_Activity.this.v);
            }
        }
    }

    class e0 implements View.OnClickListener {
        e0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Stub_Interstitial_Graphic_Landscape_Activity.this.b == null || Stub_Interstitial_Graphic_Landscape_Activity.this.b.viewInteractionInfo == null) {
                return;
            }
            if (Stub_Interstitial_Graphic_Landscape_Activity.this.b.tapADTrackerObject != null) {
                Stub_Interstitial_Graphic_Landscape_Activity.this.b.tapADTrackerObject.a(3, null);
            } else {
                com.tapsdk.tapad.internal.tracker.c.a().a(Stub_Interstitial_Graphic_Landscape_Activity.this.b.clickMonitorUrls, Stub_Interstitial_Graphic_Landscape_Activity.this.b.viewInteractionInfo, Stub_Interstitial_Graphic_Landscape_Activity.this.b.getClickMonitorHeaderListWrapper());
            }
            Stub_Interstitial_Graphic_Landscape_Activity stub_Interstitial_Graphic_Landscape_Activity = Stub_Interstitial_Graphic_Landscape_Activity.this;
            com.tapsdk.tapad.internal.s.a.a((Activity) stub_Interstitial_Graphic_Landscape_Activity, true, stub_Interstitial_Graphic_Landscape_Activity.b, Stub_Interstitial_Graphic_Landscape_Activity.this.c);
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Stub_Interstitial_Graphic_Landscape_Activity.this.c != null) {
                Stub_Interstitial_Graphic_Landscape_Activity.this.c.a(new DownloadPresenter.g());
            }
        }
    }

    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Stub_Interstitial_Graphic_Landscape_Activity stub_Interstitial_Graphic_Landscape_Activity = Stub_Interstitial_Graphic_Landscape_Activity.this;
            stub_Interstitial_Graphic_Landscape_Activity.a((Activity) stub_Interstitial_Graphic_Landscape_Activity, 0);
        }
    }

    class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Stub_Interstitial_Graphic_Landscape_Activity.this.b == null || Stub_Interstitial_Graphic_Landscape_Activity.this.b.viewInteractionInfo == null) {
                return;
            }
            if (Stub_Interstitial_Graphic_Landscape_Activity.this.b.tapADTrackerObject != null) {
                Stub_Interstitial_Graphic_Landscape_Activity.this.b.tapADTrackerObject.a(3, null);
            } else {
                com.tapsdk.tapad.internal.tracker.c.a().a(Stub_Interstitial_Graphic_Landscape_Activity.this.b.clickMonitorUrls, Stub_Interstitial_Graphic_Landscape_Activity.this.b.viewInteractionInfo, Stub_Interstitial_Graphic_Landscape_Activity.this.b.getClickMonitorHeaderListWrapper());
            }
            Stub_Interstitial_Graphic_Landscape_Activity stub_Interstitial_Graphic_Landscape_Activity = Stub_Interstitial_Graphic_Landscape_Activity.this;
            com.tapsdk.tapad.internal.s.a.a((Activity) stub_Interstitial_Graphic_Landscape_Activity, true, stub_Interstitial_Graphic_Landscape_Activity.b, Stub_Interstitial_Graphic_Landscape_Activity.this.c);
        }
    }

    class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!Stub_Interstitial_Graphic_Landscape_Activity.this.b.isFirstPassiveTransfer || !Stub_Interstitial_Graphic_Landscape_Activity.this.b.isCloseTransferEnable) {
                Stub_Interstitial_Graphic_Landscape_Activity.this.a.onAdClose();
                Stub_Interstitial_Graphic_Landscape_Activity.this.finish();
            } else {
                Stub_Interstitial_Graphic_Landscape_Activity.this.b.isFirstPassiveTransfer = false;
                Stub_Interstitial_Graphic_Landscape_Activity.this.K.setVisibility(8);
                Stub_Interstitial_Graphic_Landscape_Activity stub_Interstitial_Graphic_Landscape_Activity = Stub_Interstitial_Graphic_Landscape_Activity.this;
                stub_Interstitial_Graphic_Landscape_Activity.a((Activity) stub_Interstitial_Graphic_Landscape_Activity, 10);
            }
        }
    }

    class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Stub_Interstitial_Graphic_Landscape_Activity stub_Interstitial_Graphic_Landscape_Activity = Stub_Interstitial_Graphic_Landscape_Activity.this;
            stub_Interstitial_Graphic_Landscape_Activity.a((Activity) stub_Interstitial_Graphic_Landscape_Activity, 1);
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
                Stub_Interstitial_Graphic_Landscape_Activity.this.H = ((Integer) message.obj).intValue();
                if (Stub_Interstitial_Graphic_Landscape_Activity.this.H < 0) {
                    if (Stub_Interstitial_Graphic_Landscape_Activity.this.K.getVisibility() == 0 && Stub_Interstitial_Graphic_Landscape_Activity.this.b.materialInfo.materialType == 2) {
                        Stub_Interstitial_Graphic_Landscape_Activity.this.K.setVisibility(8);
                        Stub_Interstitial_Graphic_Landscape_Activity.this.b.isFirstPassiveTransfer = false;
                        Stub_Interstitial_Graphic_Landscape_Activity stub_Interstitial_Graphic_Landscape_Activity = Stub_Interstitial_Graphic_Landscape_Activity.this;
                        stub_Interstitial_Graphic_Landscape_Activity.a((Activity) stub_Interstitial_Graphic_Landscape_Activity, 11);
                    }
                    Stub_Interstitial_Graphic_Landscape_Activity.this.finish();
                    return;
                }
                Stub_Interstitial_Graphic_Landscape_Activity.this.C.setText(Stub_Interstitial_Graphic_Landscape_Activity.this.H + "秒");
                Stub_Interstitial_Graphic_Landscape_Activity.this.o();
                if (Stub_Interstitial_Graphic_Landscape_Activity.this.b.materialInfo.materialType == 2) {
                    if (Stub_Interstitial_Graphic_Landscape_Activity.this.K.getVisibility() == 8 && Stub_Interstitial_Graphic_Landscape_Activity.this.H == Stub_Interstitial_Graphic_Landscape_Activity.this.b.bubbleWaitTime && Stub_Interstitial_Graphic_Landscape_Activity.this.b.isFirstPassiveTransfer && Stub_Interstitial_Graphic_Landscape_Activity.this.b.isAutoWaitTransferEnable) {
                        Stub_Interstitial_Graphic_Landscape_Activity.this.K.setVisibility(0);
                        Stub_Interstitial_Graphic_Landscape_Activity.this.K.setAnimation(AnimationUtils.loadAnimation(Stub_Interstitial_Graphic_Landscape_Activity.this, R.anim.tapad_dync_in_from_right));
                    }
                    if (Stub_Interstitial_Graphic_Landscape_Activity.this.K.getVisibility() == 0) {
                        ((TextView) Stub_Interstitial_Graphic_Landscape_Activity.this.K.findViewById(R.id.content)).setText(String.format("%d s%s", Integer.valueOf(Stub_Interstitial_Graphic_Landscape_Activity.this.H), Stub_Interstitial_Graphic_Landscape_Activity.this.b.bubbleContent));
                    }
                }
            }
        }
    }

    class l implements SurfaceHolder.Callback {
        l() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (Stub_Interstitial_Graphic_Landscape_Activity.this.x != null) {
                Stub_Interstitial_Graphic_Landscape_Activity.this.x.setDisplay(surfaceHolder);
                if (!Stub_Interstitial_Graphic_Landscape_Activity.this.x.isPlaying()) {
                    TapADLogger.d("surfaceCreated inner");
                }
                Stub_Interstitial_Graphic_Landscape_Activity.this.J = true;
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            Stub_Interstitial_Graphic_Landscape_Activity.this.J = false;
        }
    }

    class m implements MediaPlayer.OnPreparedListener {
        final /* synthetic */ AdInfo a;

        m(AdInfo adInfo) {
            this.a = adInfo;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Stub_Interstitial_Graphic_Landscape_Activity.this.F = true;
            Stub_Interstitial_Graphic_Landscape_Activity.this.n();
            Stub_Interstitial_Graphic_Landscape_Activity.this.j();
            com.tapsdk.tapad.internal.tracker.c cVarA = com.tapsdk.tapad.internal.tracker.c.a();
            AdInfo adInfo = this.a;
            cVarA.a(adInfo.videoViewMonitorUrls, (Map<String, String>) null, adInfo.getVideoViewMonitorHeaderListWrapper());
            Stub_Interstitial_Graphic_Landscape_Activity.this.A.setVisibility(0);
            Stub_Interstitial_Graphic_Landscape_Activity.this.v.setVisibility(8);
            Stub_Interstitial_Graphic_Landscape_Activity.this.x.setLooping(true);
        }
    }

    class n implements MediaPlayer.OnVideoSizeChangedListener {
        n() {
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            if (mediaPlayer == null || mediaPlayer.getVideoWidth() <= 0 || mediaPlayer.getVideoHeight() <= 0) {
                return;
            }
            Stub_Interstitial_Graphic_Landscape_Activity.this.w.adjustSize(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
        }
    }

    class o implements View.OnClickListener {
        final /* synthetic */ AdInfo a;

        o(AdInfo adInfo) {
            this.a = adInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AdInfo adInfo = this.a;
            if (com.tapsdk.tapad.internal.utils.c.a(adInfo, adInfo.btnInteractionInfo)) {
                Stub_Interstitial_Graphic_Landscape_Activity stub_Interstitial_Graphic_Landscape_Activity = Stub_Interstitial_Graphic_Landscape_Activity.this;
                stub_Interstitial_Graphic_Landscape_Activity.a((Activity) stub_Interstitial_Graphic_Landscape_Activity, 1);
                return;
            }
            Stub_Interstitial_Graphic_Landscape_Activity stub_Interstitial_Graphic_Landscape_Activity2 = Stub_Interstitial_Graphic_Landscape_Activity.this;
            stub_Interstitial_Graphic_Landscape_Activity2.E = true ^ stub_Interstitial_Graphic_Landscape_Activity2.E;
            if (Stub_Interstitial_Graphic_Landscape_Activity.this.E) {
                Stub_Interstitial_Graphic_Landscape_Activity.this.n();
            } else {
                Stub_Interstitial_Graphic_Landscape_Activity.this.k();
            }
        }
    }

    class p implements View.OnClickListener {
        p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Stub_Interstitial_Graphic_Landscape_Activity.this.y == 0) {
                Stub_Interstitial_Graphic_Landscape_Activity.this.y = 1;
                Stub_Interstitial_Graphic_Landscape_Activity.this.j();
            } else {
                Stub_Interstitial_Graphic_Landscape_Activity.this.y = 0;
                Stub_Interstitial_Graphic_Landscape_Activity.this.b();
            }
            Stub_Interstitial_Graphic_Landscape_Activity.this.s();
        }
    }

    class q implements com.tapsdk.tapad.internal.animation.e {
        q() {
        }

        @Override // com.tapsdk.tapad.internal.animation.e
        public void a() {
            Stub_Interstitial_Graphic_Landscape_Activity.this.d = false;
        }

        @Override // com.tapsdk.tapad.internal.animation.e
        public void a(int i) {
            Stub_Interstitial_Graphic_Landscape_Activity stub_Interstitial_Graphic_Landscape_Activity = Stub_Interstitial_Graphic_Landscape_Activity.this;
            stub_Interstitial_Graphic_Landscape_Activity.a((Activity) stub_Interstitial_Graphic_Landscape_Activity, i);
        }
    }

    class r implements DownloadPresenter.h {
        final /* synthetic */ AdInfo a;

        r(AdInfo adInfo) {
            this.a = adInfo;
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void a() {
            Stub_Interstitial_Graphic_Landscape_Activity.this.a(true);
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void a(int i) {
            TapADLogger.d("updateDownloadProgress:" + i);
            Stub_Interstitial_Graphic_Landscape_Activity.this.a(false);
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void b() {
            Stub_Interstitial_Graphic_Landscape_Activity.this.a(true);
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void c() {
            TapADLogger.d("downloadStart---");
            Stub_Interstitial_Graphic_Landscape_Activity.this.a(false);
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void d() {
            Stub_Interstitial_Graphic_Landscape_Activity.this.a(false);
            Stub_Interstitial_Graphic_Landscape_Activity.this.c.a(new DownloadPresenter.k(this.a));
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void e() {
            TapADLogger.d("downloadError");
            Stub_Interstitial_Graphic_Landscape_Activity.this.a(true);
        }
    }

    class s extends CountDownTimer {
        s(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (Stub_Interstitial_Graphic_Landscape_Activity.this.K.getVisibility() == 0) {
                Stub_Interstitial_Graphic_Landscape_Activity.this.K.setVisibility(8);
                Stub_Interstitial_Graphic_Landscape_Activity.this.b.isFirstPassiveTransfer = false;
                Stub_Interstitial_Graphic_Landscape_Activity stub_Interstitial_Graphic_Landscape_Activity = Stub_Interstitial_Graphic_Landscape_Activity.this;
                stub_Interstitial_Graphic_Landscape_Activity.a((Activity) stub_Interstitial_Graphic_Landscape_Activity, 11);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            if (Stub_Interstitial_Graphic_Landscape_Activity.this.K.getVisibility() == 8 && j / 1000 == Stub_Interstitial_Graphic_Landscape_Activity.this.b.bubbleWaitTime && Stub_Interstitial_Graphic_Landscape_Activity.this.b.isFirstPassiveTransfer && Stub_Interstitial_Graphic_Landscape_Activity.this.b.isAutoWaitTransferEnable) {
                Stub_Interstitial_Graphic_Landscape_Activity.this.K.setVisibility(0);
                Stub_Interstitial_Graphic_Landscape_Activity.this.K.setAnimation(AnimationUtils.loadAnimation(Stub_Interstitial_Graphic_Landscape_Activity.this, R.anim.tapad_dync_in_from_right));
            }
            if (Stub_Interstitial_Graphic_Landscape_Activity.this.K.getVisibility() == 0) {
                ((TextView) Stub_Interstitial_Graphic_Landscape_Activity.this.K.findViewById(R.id.content)).setText(String.format("%d s%s", Long.valueOf(j / 1000), Stub_Interstitial_Graphic_Landscape_Activity.this.b.bubbleContent));
            }
        }
    }

    class t implements View.OnClickListener {
        t() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!Stub_Interstitial_Graphic_Landscape_Activity.this.b.isFirstPassiveTransfer || !Stub_Interstitial_Graphic_Landscape_Activity.this.b.isCloseTransferEnable) {
                Stub_Interstitial_Graphic_Landscape_Activity.this.a.onAdClose();
                Stub_Interstitial_Graphic_Landscape_Activity.this.finish();
            } else {
                Stub_Interstitial_Graphic_Landscape_Activity.this.b.isFirstPassiveTransfer = false;
                Stub_Interstitial_Graphic_Landscape_Activity.this.K.setVisibility(8);
                Stub_Interstitial_Graphic_Landscape_Activity stub_Interstitial_Graphic_Landscape_Activity = Stub_Interstitial_Graphic_Landscape_Activity.this;
                stub_Interstitial_Graphic_Landscape_Activity.a((Activity) stub_Interstitial_Graphic_Landscape_Activity, 10);
            }
        }
    }

    class u implements View.OnClickListener {
        u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Stub_Interstitial_Graphic_Landscape_Activity stub_Interstitial_Graphic_Landscape_Activity = Stub_Interstitial_Graphic_Landscape_Activity.this;
            com.tapsdk.tapad.internal.s.a.a(stub_Interstitial_Graphic_Landscape_Activity, stub_Interstitial_Graphic_Landscape_Activity.b.appInfo.appDescUrl, Stub_Interstitial_Graphic_Landscape_Activity.this.b);
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
            TapADLogger.d("receiver finish Interstitial message:" + str + ", adInfo trackId:" + Stub_Interstitial_Graphic_Landscape_Activity.this.b.trackId);
            if (str == null || str.length() <= 0 || !str.equals(Stub_Interstitial_Graphic_Landscape_Activity.this.b.trackId) || Stub_Interstitial_Graphic_Landscape_Activity.V == null || Stub_Interstitial_Graphic_Landscape_Activity.V.get() == null) {
                return;
            }
            ((Stub_Interstitial_Graphic_Landscape_Activity) Stub_Interstitial_Graphic_Landscape_Activity.V.get()).finish();
        }
    }

    class w implements View.OnClickListener {
        w() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Stub_Interstitial_Graphic_Landscape_Activity stub_Interstitial_Graphic_Landscape_Activity = Stub_Interstitial_Graphic_Landscape_Activity.this;
            com.tapsdk.tapad.internal.s.a.a(stub_Interstitial_Graphic_Landscape_Activity, stub_Interstitial_Graphic_Landscape_Activity.b.appInfo.appPrivacyPolicy, Stub_Interstitial_Graphic_Landscape_Activity.this.b);
        }
    }

    class x implements View.OnClickListener {
        x() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Stub_Interstitial_Graphic_Landscape_Activity stub_Interstitial_Graphic_Landscape_Activity = Stub_Interstitial_Graphic_Landscape_Activity.this;
            com.tapsdk.tapad.internal.s.a.a(stub_Interstitial_Graphic_Landscape_Activity, stub_Interstitial_Graphic_Landscape_Activity.b.appInfo.appPermissionsLink, Stub_Interstitial_Graphic_Landscape_Activity.this.b);
        }
    }

    class y implements Consumer<Throwable> {
        y() {
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            TapADLogger.d("receiver finish Interstitial error:" + (th != null ? th.getMessage() : "no error message"));
        }
    }

    class z implements com.tapsdk.tapad.internal.tracker.b.InterfaceC0634b {
        z() {
        }

        @Override // com.tapsdk.tapad.internal.tracker.b.InterfaceC0634b
        public void a() {
            if (Stub_Interstitial_Graphic_Landscape_Activity.this.a != null) {
                Stub_Interstitial_Graphic_Landscape_Activity.this.a.onAdValidShow();
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
            TapADLogger.d("RightBannerView 打开异常");
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

    private void a(AdInfo adInfo, String str) {
        i();
        try {
            this.x = new MediaPlayer();
            TapADLogger.d("ad video url:" + str);
            this.x.reset();
            this.x.setDataSource(this, Uri.parse(str));
            this.w.getHolder().addCallback(new l());
            this.x.prepareAsync();
            this.x.setOnPreparedListener(new m(adInfo));
            this.x.setOnVideoSizeChangedListener(new n());
            this.w.setOnClickListener(new o(adInfo));
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        MediaPlayer mediaPlayer = this.x;
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
        TextView textView = (TextView) findViewById(R.id.rightSquareAdLogoTextView);
        ((ImageView) findViewById(R.id.rightSquareAdLogoImageView)).setVisibility(this.b.logoInfo.logoStatus == 1 ? 0 : 8);
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
        this.K = (ViewGroup) findViewById(R.id.bubbleView);
        InteractionInfo interactionInfo = this.b.btnInteractionInfo;
        if (interactionInfo != null) {
            String strExtractWaitInteractionIconUrl = interactionInfo.extractWaitInteractionIconUrl();
            if (TextUtils.isEmpty(strExtractWaitInteractionIconUrl)) {
                strExtractWaitInteractionIconUrl = this.b.appInfo.appIconImage.imageUrl;
            }
            if (!TextUtils.isEmpty(strExtractWaitInteractionIconUrl)) {
                Glide.with((Activity) this).load(strExtractWaitInteractionIconUrl).into((ImageView) this.K.findViewById(R.id.icon_image));
            }
            String strExtractWaitInteractionDescription = this.b.btnInteractionInfo.extractWaitInteractionDescription();
            if (!TextUtils.isEmpty(strExtractWaitInteractionDescription)) {
                ((TextView) this.K.findViewById(R.id.description)).setText(strExtractWaitInteractionDescription);
            }
        }
        if (this.b.materialInfo.materialType == 1) {
            f().start();
        }
    }

    private void h() {
        this.m = (TextView) findViewById(R.id.bottomSquareBannerInteractionTextView);
        this.p = (ProgressBar) findViewById(R.id.bottomSquareBannerDownloadProgressBar);
        this.q = (FrameLayout) findViewById(R.id.bottomSquareBannerDownloadFrameLayout);
        this.v = (ImageView) findViewById(R.id.adCoverImage);
        this.t = (HotZoneFrameLayout) findViewById(R.id.hotZoneFrameLayout);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.video_surface);
        this.A = linearLayout;
        this.w = (VideoSurfaceView) linearLayout.findViewById(R.id.adsSurfaceView);
        this.B = (ImageView) this.A.findViewById(R.id.volumeImageView);
        this.C = (TextView) this.A.findViewById(R.id.countDownTextView);
        this.D = (TextView) this.A.findViewById(R.id.skipTextView);
        this.A.setVisibility(8);
        this.z = (ImageView) findViewById(R.id.mediaPlayerImageView);
        boolean zB = com.tapsdk.tapad.internal.utils.c.b(this.b.btnInteractionInfo);
        this.d = zB;
        if (zB) {
            Drawable drawable = getResources().getDrawable(R.drawable.tapad_anim_shake_01);
            this.j = drawable;
            drawable.setBounds(0, 0, com.tapsdk.tapad.internal.utils.t.a(getApplicationContext(), 20.0f), com.tapsdk.tapad.internal.utils.t.a(getApplicationContext(), 20.0f));
            this.j.setTint(getResources().getColor(R.color.tapad_color_green));
            Drawable drawable2 = getResources().getDrawable(R.drawable.tapad_anim_shake_01);
            this.k = drawable2;
            drawable2.setBounds(0, 0, com.tapsdk.tapad.internal.utils.t.a(getApplicationContext(), 20.0f), com.tapsdk.tapad.internal.utils.t.a(getApplicationContext(), 20.0f));
            this.k.setTint(getResources().getColor(android.R.color.white));
        }
    }

    private void i() {
        this.B.setOnClickListener(new p());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        MediaPlayer mediaPlayer = this.x;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(0.09f, 0.09f);
        }
    }

    private void l() {
        if (this.O != null) {
            return;
        }
        this.O = com.tapsdk.tapad.internal.utils.n.a().a(com.tapsdk.tapad.stub.activity.a.class).subscribe(new v(), new y());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        messageObtain.obj = Integer.valueOf(this.H - 1);
        this.M.sendMessageDelayed(messageObtain, 1000L);
    }

    private void p() {
        a((ViewGroup) null, true);
        d();
        e();
        this.t = (HotZoneFrameLayout) findViewById(R.id.interstitialFullZoneFrameLayout);
        this.u = (HotZoneFrameLayout) findViewById(R.id.rightSquareBannerHotZoneFrameLayout);
        this.m = (TextView) findViewById(R.id.rightSquareBannerInteractionTextView);
        this.p = (ProgressBar) findViewById(R.id.rightSquareBannerDownloadProgressBar);
        this.n = (RelativeLayout) findViewById(R.id.rightSquareBannerScoreRelativeLayout);
        this.o = (TextView) findViewById(R.id.rightSquareBannerRealScoreTextView);
        this.q = (FrameLayout) findViewById(R.id.rightSquareBannerDownloadFrameLayout);
        this.s = (LinearLayout) findViewById(R.id.rightBannerMasterLinearLayout);
        this.r = (FrameLayout) findViewById(R.id.rightSquareBannerInteractionFrameLayout);
        g();
        this.K.findViewById(R.id.close_btn).setOnClickListener(new a0());
        boolean zB = com.tapsdk.tapad.internal.utils.c.b(this.b.btnInteractionInfo);
        this.d = zB;
        if (zB) {
            Drawable drawable = getResources().getDrawable(R.drawable.tapad_anim_shake_01);
            this.j = drawable;
            drawable.setBounds(0, 0, com.tapsdk.tapad.internal.utils.t.a(getApplicationContext(), 20.0f), com.tapsdk.tapad.internal.utils.t.a(getApplicationContext(), 20.0f));
            this.j.setTint(getResources().getColor(R.color.tapad_color_green));
            Drawable drawable2 = getResources().getDrawable(R.drawable.tapad_anim_shake_01);
            this.k = drawable2;
            drawable2.setBounds(0, 0, com.tapsdk.tapad.internal.utils.t.a(getApplicationContext(), 20.0f), com.tapsdk.tapad.internal.utils.t.a(getApplicationContext(), 20.0f));
            this.k.setTint(getResources().getColor(android.R.color.white));
        }
        ImageView imageView = (ImageView) findViewById(R.id.backgroundImageView);
        String strB = com.tapsdk.tapad.e.d.d().b();
        if (strB != null && strB.length() > 0) {
            Glide.with((Activity) this).load(strB).into(imageView);
        }
        ImageView imageView2 = (ImageView) findViewById(R.id.horizontalCoverImageView);
        List<ImageInfo> list = this.b.materialInfo.imageInfoList;
        (!list.isEmpty() ? Glide.with((Activity) this).load(list.get(0).imageUrl).addListener(new b0()) : Glide.with((Activity) this).load(this.b.materialInfo.videoInfoList.get(0).coverImage.imageUrl)).into(imageView2);
        ((TextView) findViewById(R.id.rightSquareBannerTitleTextView)).setText(this.b.materialInfo.title);
        ((TextView) findViewById(R.id.rightSquareBannerDescriptionTextView)).setText(this.b.materialInfo.description);
        Glide.with((Activity) this).load(this.b.appInfo.appIconImage.imageUrl).into((ImageView) findViewById(R.id.rightSquareBannerIconImageView));
        a(true);
        this.q.setOnClickListener(new c0());
        this.m.setOnClickListener(new d0());
        this.l.setOnClickListener(new e0());
        this.s.getViewTreeObserver().addOnGlobalLayoutListener(new a());
        this.n.setVisibility(this.b.appInfo.tapScore > 0.0f ? 0 : 8);
        if (this.b.appInfo.tapScore > 0.0f) {
            try {
                this.o.setText(new DecimalFormat("#.0").format(this.b.appInfo.tapScore));
            } catch (Exception unused) {
            }
        }
        boolean zA = com.tapsdk.tapad.internal.utils.c.a(this.b.btnInteractionInfo);
        this.t.setVisibility(zA ? 0 : 8);
        this.u.setVisibility(zA ? 0 : 8);
        if (zA) {
            this.t.setOnClickListener(new b());
            this.u.setOnClickListener(new c());
        }
    }

    private void q() {
        ImageInfo imageInfo;
        h();
        a((ViewGroup) this.l, false);
        d();
        a(this.l);
        g();
        this.K.findViewById(R.id.close_btn).setOnClickListener(new d());
        ((TextView) findViewById(R.id.bottomSquareBannerDescriptionTextView)).setText(this.b.materialInfo.description);
        MaterialInfo materialInfo = this.b.materialInfo;
        List<ImageInfo> list = materialInfo.imageInfoList;
        List<VideoInfo> list2 = materialInfo.videoInfoList;
        if (!list2.isEmpty()) {
            imageInfo = list2.get(0).coverImage;
        } else if (list.isEmpty()) {
            return;
        } else {
            imageInfo = list.get(0);
        }
        this.I = imageInfo;
        if (this.x == null && !list2.isEmpty()) {
            this.H = list2.get(0).duration;
            this.C.setText(String.format("%s秒", Integer.valueOf(this.H)));
        }
        ImageInfo imageInfo2 = this.I;
        int i2 = imageInfo2.height;
        if (i2 <= imageInfo2.width || i2 <= 0) {
            RequestBuilder<Drawable> requestBuilderLoad = Glide.with((Activity) this).load(this.I.imageUrl);
            ImageInfo imageInfo3 = this.I;
            requestBuilderLoad.override(imageInfo3.width, imageInfo3.height).into(this.v);
        } else {
            this.v.post(new e());
        }
        a(list2);
        a(true);
        this.q.setOnClickListener(new f());
        this.m.setOnClickListener(new g());
        this.l.setOnClickListener(new h());
        this.D.setOnClickListener(new i());
        boolean zA = com.tapsdk.tapad.internal.utils.c.a(this.b.btnInteractionInfo);
        this.t.setVisibility(zA ? 0 : 8);
        if (zA) {
            this.t.setOnClickListener(new j());
        }
    }

    private void r() {
        Disposable disposable = this.O;
        if (disposable != null && !disposable.isDisposed()) {
            this.O.dispose();
        }
        this.O = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        this.B.setImageResource(this.y == 1 ? R.drawable.tapad_ic_audio_open : R.drawable.tapad_ic_audio_mute);
    }

    public void a(InteractionInfo interactionInfo) {
        if (com.tapsdk.tapad.internal.utils.c.b(interactionInfo)) {
            if (this.e == null) {
                this.e = com.tapsdk.tapad.internal.animation.h.a(this, new q());
            }
            if (this.f == null && !this.i) {
                this.f = new com.tapsdk.tapad.internal.animation.i();
                float fExtractShakeAngle = this.b.btnInteractionInfo.extractShakeAngle();
                if (fExtractShakeAngle > 0.0f) {
                    this.f.a(fExtractShakeAngle);
                }
            }
            if (this.h == null && this.i) {
                com.tapsdk.tapad.internal.animation.l.a aVar = new com.tapsdk.tapad.internal.animation.l.a();
                this.h = aVar;
                aVar.a(this.b.btnInteractionInfo.extractXShakeSpeedEnable(), this.b.btnInteractionInfo.extractYShakeSpeedEnable(), this.b.btnInteractionInfo.extractZShakeSpeedEnable(), this.b.btnInteractionInfo.extractXShakeSpeed(), this.b.btnInteractionInfo.extractYShakeSpeed(), this.b.btnInteractionInfo.extractZShakeSpeed());
            }
            if (this.g == null && this.i) {
                com.tapsdk.tapad.internal.animation.l.b bVar = new com.tapsdk.tapad.internal.animation.l.b();
                this.g = bVar;
                bVar.a(this.b.btnInteractionInfo.extractXShakeDegreeEnable(), this.b.btnInteractionInfo.extractYShakeDegreeEnable(), this.b.btnInteractionInfo.extractZShakeDegreeEnable(), this.b.btnInteractionInfo.extractXShakeDegree(), this.b.btnInteractionInfo.extractYShakeDegree(), this.b.btnInteractionInfo.extractZShakeDegree());
            }
            a(true);
        }
    }

    public void a(List<VideoInfo> list) {
        if (list == null || list.isEmpty() || this.x != null) {
            return;
        }
        a(this.b, list.get(0).videoUrl);
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
        Drawable drawable = this.k;
        AdInfo adInfo = this.b;
        if (adInfo.btnInteractionInfo.interactionType == 1) {
            DownloadPresenter.DownloadState downloadStateC = this.c.c();
            if (downloadStateC == DownloadPresenter.DownloadState.STARTED || !com.tapsdk.tapad.internal.utils.b.a(getApplicationContext(), this.b.appInfo.packageName)) {
                this.m.setBackgroundResource(R.drawable.tapad_bg_reward_button_green_corner24dp);
                this.m.setTextColor(getResources().getColor(android.R.color.white));
                Drawable drawable2 = this.k;
                int iB = this.c.b();
                if (downloadStateC != DownloadPresenter.DownloadState.DEFAULT && downloadStateC != DownloadPresenter.DownloadState.ERROR) {
                    if (downloadStateC == DownloadPresenter.DownloadState.STARTED) {
                        this.q.setVisibility(0);
                        this.p.setProgress(Math.max(iB, 10));
                        this.m.setVisibility(8);
                        drawable = drawable2;
                        z3 = false;
                    } else {
                        this.q.setVisibility(8);
                        this.m.setVisibility(0);
                        this.m.setText(R.string.tapad_banner_install);
                    }
                    bool = Boolean.TRUE;
                    if (z3 || !this.d || this.b == null || drawable == null) {
                        z4 = false;
                    } else {
                        z4 = true;
                    }
                    if (bool.equals(Boolean.valueOf(z4)) || !com.tapsdk.tapad.internal.utils.c.b(this.b.btnInteractionInfo)) {
                        hVar = this.e;
                        if (hVar != null) {
                            hVar.a();
                        }
                    }
                    com.tapsdk.tapad.internal.animation.j jVar = new com.tapsdk.tapad.internal.animation.j(drawable, 0, com.tapsdk.tapad.internal.utils.t.a(getApplicationContext(), 4.0f));
                    SpannableString spannableString = new SpannableString("$" + this.m.getText().toString());
                    spannableString.setSpan(jVar, 0, 1, 33);
                    this.m.setText(spannableString);
                    com.tapsdk.tapad.internal.animation.h hVar2 = this.e;
                    if (hVar2 != null) {
                        if (this.i) {
                            hVar2.a((com.tapsdk.tapad.internal.animation.a) this.h);
                            hVar2 = this.e;
                            aVar = this.g;
                        } else {
                            aVar = this.f;
                        }
                        hVar2.a(aVar);
                        return;
                    }
                    return;
                }
                AppInfo appInfo = this.b.appInfo;
                if (appInfo.apkSize > 0 && com.tapsdk.tapad.internal.utils.q.a(appInfo.appSize)) {
                    this.m.setText(String.format(getApplicationContext().getString(R.string.tapad_banner_download_with_size), this.b.appInfo.appSize));
                } else {
                    this.m.setText(R.string.tapad_banner_download);
                }
                this.q.setVisibility(8);
                this.m.setVisibility(0);
                drawable = drawable2;
            } else {
                this.m.setText(R.string.tapad_banner_open);
                this.q.setVisibility(8);
                this.m.setBackgroundResource(R.drawable.tapad_bg_reward_button_light_green_corner24dp);
                this.m.setTextColor(getResources().getColor(R.color.tapad_color_green));
                drawable = this.j;
            }
        } else {
            String str = adInfo.btnName;
            if (str == null || str.length() <= 0) {
                this.m.setText(R.string.tapad_banner_open);
            } else {
                this.m.setText(this.b.btnName);
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
        hVar = this.e;
        if (hVar != null) {
            hVar.a();
        }
    }

    public void c() {
        com.tapsdk.tapad.internal.animation.h hVar = this.e;
        if (hVar != null) {
            try {
                hVar.a();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void k() {
        if (this.b.materialInfo.videoInfoList.isEmpty()) {
            return;
        }
        MediaPlayer mediaPlayer = this.x;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.x.pause();
        }
        boolean z2 = !this.J || this.E;
        this.E = z2;
        ImageView imageView = this.z;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(z2 ? 8 : 0);
        this.M.removeMessages(1);
        this.c.a(new RewardPresenter.e());
    }

    public void m() {
        MediaPlayer mediaPlayer = this.x;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.x.release();
            this.x = null;
        }
    }

    public void n() {
        ImageView imageView;
        MediaPlayer mediaPlayer;
        if (this.b.materialInfo.videoInfoList.isEmpty() || this.G || (imageView = this.z) == null) {
            return;
        }
        imageView.setVisibility(this.E ? 8 : 0);
        if (!this.F || !this.E || (mediaPlayer = this.x) == null || mediaPlayer.isPlaying()) {
            return;
        }
        this.x.start();
        o();
        if (this.E) {
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
        if (Build.VERSION.SDK_INT != 26 && getResources().getConfiguration().orientation == 1) {
            setRequestedOrientation(0);
        }
        V = new WeakReference<>(this);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            AdInfo adInfo = (AdInfo) extras.getParcelable("data");
            this.b = adInfo;
            if (adInfo == null) {
                TapADLogger.d("Stub_Standard_Portrait_Activity 未传入广告信息");
            } else {
                l();
                if (((AdRequest) extras.getParcelable("request")) == null) {
                    TapADLogger.d("Stub_Standard_Portrait_Activity 未传入广告信息");
                } else {
                    int i2 = extras.getInt("c_id", Integer.MIN_VALUE);
                    this.N = i2;
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
                                    setContentView(R.layout.tapad_activity_interstitial_graphic_landscape_full);
                                    this.l = (RelativeLayout) findViewById(R.id.interstitial_full_landscape);
                                    p();
                                } else {
                                    setContentView(R.layout.tapad_activity_interstitial_graphic_landscape_half);
                                    this.l = (RelativeLayout) findViewById(R.id.interstitial_half_landscape_inner);
                                    q();
                                }
                                this.a.onAdShow();
                                this.i = com.tapsdk.tapad.internal.utils.c.c(this.b.btnInteractionInfo);
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
                                    this.L = bVar;
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
        r();
        c();
        m();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        c();
        k();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        a(this.b.btnInteractionInfo);
        n();
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
