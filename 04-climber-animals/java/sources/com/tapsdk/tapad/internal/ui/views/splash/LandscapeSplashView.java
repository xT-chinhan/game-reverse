package com.tapsdk.tapad.internal.ui.views.splash;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.tapsdk.tapad.R;
import com.tapsdk.tapad.TapSplashAd;
import com.tapsdk.tapad.internal.DownloadPresenter;
import com.tapsdk.tapad.internal.tracker.TapADTrackerObject;
import com.tapsdk.tapad.internal.ui.views.HotZoneFrameLayout;
import com.tapsdk.tapad.internal.ui.views.video.VideoSurfaceView;
import com.tapsdk.tapad.internal.utils.TapADLogger;
import com.tapsdk.tapad.internal.utils.q;
import com.tapsdk.tapad.internal.utils.s;
import com.tapsdk.tapad.model.entities.AdInfo;
import com.tapsdk.tapad.model.entities.AppInfo;
import com.tapsdk.tapad.model.entities.InteractionInfo;
import com.tapsdk.tapad.model.entities.VideoInfo;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class LandscapeSplashView extends RelativeLayout {
    private static final int MIN_PROGRESS = 10;
    private AdInfo adInfo;
    private TapSplashAd.AdInteractionListener adInteractionListener;
    private ImageView adLogoImageView;
    private TextView adLogoTextView;
    private final AtomicBoolean countDownTimerOver;
    private Button downloadBtn;
    private final DownloadPresenter downloadPresenter;
    private final com.tapsdk.tapad.internal.tracker.b exposureHandler;
    private HotZoneFrameLayout hotZoneFrameLayout;
    private boolean isAttachedToWindow;
    private boolean isPrepared;
    private final AtomicBoolean isTimerOverInterfaceCalled;
    private final AtomicBoolean isViewVisible;
    private AtomicBoolean isWindowVisibility;
    private RelativeLayout landscapeSplashAdsRelativeLayout;
    private ImageView landscapeSplashBackgroundImageView;
    private TextView landscapeSplashCountDownTextView;
    private ImageView landscapeSplashCoverImageView;
    private VideoSurfaceView landscapeSplashCoverSurfaceView;
    private FrameLayout landscapeSplashInteractionFrameLayout;
    private TextView landscapeSplashInteractionTextView;
    private FrameLayout landscapeSplashSkipFrameLayout;
    private MediaPlayer mediaPlayer;
    private ProgressBar progressBar;
    private com.tapsdk.tapad.internal.animation.h shakeController;
    private AtomicBoolean shakeIsRegister;
    private com.tapsdk.tapad.internal.animation.b shakeView;
    private ViewGroup shakeViewContainer;
    private com.tapsdk.tapad.internal.g splashPresenter;

    class a implements com.tapsdk.tapad.internal.l.d.a.d {
        final /* synthetic */ AdInfo a;

        a(AdInfo adInfo) {
            this.a = adInfo;
        }

        @Override // com.tapsdk.tapad.internal.l.d.a.d
        public void a() {
            if (LandscapeSplashView.this.splashPresenter != null) {
                LandscapeSplashView.this.splashPresenter.a(this.a);
            }
        }

        @Override // com.tapsdk.tapad.internal.l.d.a.d
        public void b() {
            if (LandscapeSplashView.this.splashPresenter != null) {
                LandscapeSplashView.this.splashPresenter.a(this.a);
            }
        }
    }

    class b implements Runnable {

        class a implements RequestListener<Drawable> {
            a() {
            }

            @Override // com.bumptech.glide.request.RequestListener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
                LandscapeSplashView.this.exposureHandler.b();
                return false;
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
                return false;
            }
        }

        /* JADX INFO: renamed from: com.tapsdk.tapad.internal.ui.views.splash.LandscapeSplashView$b$b, reason: collision with other inner class name */
        class ViewOnClickListenerC0637b implements View.OnClickListener {
            ViewOnClickListenerC0637b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandscapeSplashView.this.adInfo == null || !LandscapeSplashView.this.adInfo.isFirstPassiveTransfer || !LandscapeSplashView.this.adInfo.isCloseTransferEnable) {
                    if (LandscapeSplashView.this.adInteractionListener != null) {
                        LandscapeSplashView.this.adInteractionListener.onAdSkip();
                    }
                    LandscapeSplashView.this.tryToRemoveSelf();
                    return;
                }
                LandscapeSplashView.this.adInfo.isFirstPassiveTransfer = false;
                if (LandscapeSplashView.this.adInfo.tapADTrackerObject != null) {
                    LandscapeSplashView.this.adInfo.tapADTrackerObject.a(10, null);
                } else {
                    com.tapsdk.tapad.internal.tracker.c.a().a(s.a(LandscapeSplashView.this.adInfo.clickMonitorUrls, 10), (Map<String, String>) null, LandscapeSplashView.this.adInfo.getClickMonitorHeaderListWrapper());
                }
                LandscapeSplashView.this.onInteractionClick(com.tapsdk.tapad.internal.utils.a.a(LandscapeSplashView.this.getContext()));
                if (LandscapeSplashView.this.adInteractionListener != null) {
                    LandscapeSplashView.this.adInteractionListener.onAdClick();
                }
            }
        }

        class c implements View.OnClickListener {
            c() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandscapeSplashView.this.adInfo.tapADTrackerObject != null) {
                    LandscapeSplashView.this.adInfo.tapADTrackerObject.a(0, null);
                } else {
                    com.tapsdk.tapad.internal.tracker.c.a().a(s.a(LandscapeSplashView.this.adInfo.clickMonitorUrls, 0), (Map<String, String>) null, LandscapeSplashView.this.adInfo.getClickMonitorHeaderListWrapper());
                }
                LandscapeSplashView.this.onInteractionClick(com.tapsdk.tapad.internal.utils.a.a(LandscapeSplashView.this.getContext()));
                if (LandscapeSplashView.this.adInteractionListener != null) {
                    LandscapeSplashView.this.adInteractionListener.onAdClick();
                }
            }
        }

        class d implements View.OnClickListener {
            d() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandscapeSplashView.this.adInfo.tapADTrackerObject != null) {
                    LandscapeSplashView.this.adInfo.tapADTrackerObject.a(1, null);
                } else {
                    com.tapsdk.tapad.internal.tracker.c.a().a(s.a(LandscapeSplashView.this.adInfo.clickMonitorUrls, 1), (Map<String, String>) null, LandscapeSplashView.this.adInfo.getClickMonitorHeaderListWrapper());
                }
                LandscapeSplashView.this.onInteractionClick(com.tapsdk.tapad.internal.utils.a.a(LandscapeSplashView.this.getContext()));
                if (LandscapeSplashView.this.adInteractionListener != null) {
                    LandscapeSplashView.this.adInteractionListener.onAdClick();
                }
            }
        }

        class e implements View.OnClickListener {
            e() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Activity activityA = com.tapsdk.tapad.internal.utils.a.a(LandscapeSplashView.this.getContext());
                if (LandscapeSplashView.this.adInfo.viewInteractionInfo != null) {
                    if (LandscapeSplashView.this.adInfo.tapADTrackerObject != null) {
                        LandscapeSplashView.this.adInfo.tapADTrackerObject.a(3, null);
                    } else {
                        com.tapsdk.tapad.internal.tracker.c.a().a(LandscapeSplashView.this.adInfo.clickMonitorUrls, LandscapeSplashView.this.adInfo.viewInteractionInfo, LandscapeSplashView.this.adInfo.getClickMonitorHeaderListWrapper());
                    }
                    com.tapsdk.tapad.internal.s.a.a(activityA, true, LandscapeSplashView.this.adInfo, (DownloadPresenter) null);
                    if (LandscapeSplashView.this.adInteractionListener != null) {
                        LandscapeSplashView.this.adInteractionListener.onAdClick();
                    }
                }
            }
        }

        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context = LandscapeSplashView.this.getContext();
            if (context == null || !LandscapeSplashView.this.isAttachedToWindow() || com.tapsdk.tapad.internal.utils.a.b(com.tapsdk.tapad.internal.utils.a.a(context))) {
                return;
            }
            LandscapeSplashView.this.initPresenter();
            if (LandscapeSplashView.this.adInfo.tapADTrackerObject == null || LandscapeSplashView.this.adInfo.tapADTrackerObject.a == null || !LandscapeSplashView.this.adInfo.tapADTrackerObject.a.a) {
                com.tapsdk.tapad.internal.tracker.c.a().a(LandscapeSplashView.this.adInfo.viewMonitorUrls, (Map<String, String>) null, LandscapeSplashView.this.adInfo.getViewMonitorHeaderListWrapper());
            } else {
                LandscapeSplashView.this.adInfo.tapADTrackerObject.a.b((Map<String, String>) null);
            }
            if (LandscapeSplashView.this.adInteractionListener != null) {
                LandscapeSplashView.this.adInteractionListener.onAdShow();
            }
            if (LandscapeSplashView.this.landscapeSplashCoverSurfaceView.getVisibility() == 8 && LandscapeSplashView.this.adInfo.materialInfo.imageInfoList != null && LandscapeSplashView.this.adInfo.materialInfo.imageInfoList.size() > 0) {
                Glide.with(LandscapeSplashView.this.getContext()).load(LandscapeSplashView.this.adInfo.materialInfo.imageInfoList.get(0).imageUrl).addListener(new a()).into(LandscapeSplashView.this.landscapeSplashCoverImageView);
            }
            LandscapeSplashView.this.landscapeSplashCountDownTextView.setText(R.string.tapad_btn_skip);
            LandscapeSplashView.this.landscapeSplashSkipFrameLayout.setOnClickListener(new ViewOnClickListenerC0637b());
            LandscapeSplashView.this.initInteractionBtn();
            LandscapeSplashView.this.landscapeSplashInteractionFrameLayout.setOnClickListener(new c());
            LandscapeSplashView.this.hotZoneFrameLayout.setOnClickListener(new d());
            LandscapeSplashView.this.landscapeSplashAdsRelativeLayout.setOnClickListener(new e());
            LandscapeSplashView.this.adLogoImageView.setVisibility(LandscapeSplashView.this.adInfo.logoInfo.logoStatus != 1 ? 8 : 0);
            String string = LandscapeSplashView.this.getResources().getString(R.string.tapad_str_ads);
            if (LandscapeSplashView.this.adInfo.logoInfo.logoTitle != null && LandscapeSplashView.this.adInfo.logoInfo.logoTitle.length() > 0 && LandscapeSplashView.this.adInfo.logoInfo.logoTitle.length() < 5) {
                string = LandscapeSplashView.this.adInfo.logoInfo.logoTitle;
            }
            if (LandscapeSplashView.this.adInfo.logoInfo.logoImage != null && !TextUtils.isEmpty(LandscapeSplashView.this.adInfo.logoInfo.logoImage.imageUrl)) {
                Glide.with(LandscapeSplashView.this.adLogoImageView.getContext()).load(LandscapeSplashView.this.adInfo.logoInfo.logoImage.imageUrl).into(LandscapeSplashView.this.adLogoImageView);
            }
            LandscapeSplashView.this.adLogoTextView.setText(string);
            String strA = com.tapsdk.tapad.e.d.d().a();
            if (strA == null || strA.length() <= 0) {
                return;
            }
            Glide.with(LandscapeSplashView.this.getContext()).load(strA).into(LandscapeSplashView.this.landscapeSplashBackgroundImageView);
        }
    }

    class c implements com.tapsdk.tapad.internal.tracker.b.InterfaceC0634b {
        c() {
        }

        @Override // com.tapsdk.tapad.internal.tracker.b.InterfaceC0634b
        public void a() {
            if (LandscapeSplashView.this.adInteractionListener != null) {
                LandscapeSplashView.this.adInteractionListener.onAdValidShow();
            }
        }
    }

    class d implements DownloadPresenter.h {
        d() {
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void a() {
            LandscapeSplashView.this.initInteractionBtn();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void a(int i) {
            TapADLogger.d("updateDownloadProgress:" + i);
            if (i <= 10 || LandscapeSplashView.this.progressBar == null) {
                return;
            }
            LandscapeSplashView.this.progressBar.setProgress(i);
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void b() {
            LandscapeSplashView.this.initInteractionBtn();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void c() {
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void d() {
            LandscapeSplashView.this.initInteractionBtn();
            LandscapeSplashView.this.downloadPresenter.a(new DownloadPresenter.k(LandscapeSplashView.this.adInfo));
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void e() {
            LandscapeSplashView.this.initInteractionBtn();
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LandscapeSplashView.this.adInfo == null) {
                return;
            }
            if (LandscapeSplashView.this.adInfo.tapADTrackerObject != null) {
                LandscapeSplashView.this.adInfo.tapADTrackerObject.a(0, null);
            } else {
                com.tapsdk.tapad.internal.tracker.c.a().a(s.a(LandscapeSplashView.this.adInfo.clickMonitorUrls, 0), (Map<String, String>) null, LandscapeSplashView.this.adInfo.getClickMonitorHeaderListWrapper());
            }
            LandscapeSplashView landscapeSplashView = LandscapeSplashView.this;
            landscapeSplashView.onInteractionClick(landscapeSplashView.getContext() instanceof Activity ? (Activity) LandscapeSplashView.this.getContext() : null);
            if (LandscapeSplashView.this.adInteractionListener != null) {
                LandscapeSplashView.this.adInteractionListener.onAdClick();
            }
        }
    }

    class f implements com.tapsdk.tapad.internal.g.c {
        f() {
        }

        @Override // com.tapsdk.tapad.internal.g.c
        public void a() {
            LandscapeSplashView.this.countDownTimerOver.set(true);
            LandscapeSplashView.this.justifyCanCallTimeOver();
            LandscapeSplashView.this.tryToRemoveSelf();
        }

        @Override // com.tapsdk.tapad.internal.g.c
        public void a(long j) {
            LandscapeSplashView.this.landscapeSplashCountDownTextView.setText(LandscapeSplashView.this.splashPresenter.a());
        }

        @Override // com.tapsdk.tapad.internal.g.c
        public void onError(int i, String str) {
            LandscapeSplashView.this.tryToRemoveSelf();
        }
    }

    class g implements com.tapsdk.tapad.internal.animation.e {
        final /* synthetic */ AdInfo a;
        final /* synthetic */ TapSplashAd.AdInteractionListener b;
        final /* synthetic */ boolean[] c;

        g(AdInfo adInfo, TapSplashAd.AdInteractionListener adInteractionListener, boolean[] zArr) {
            this.a = adInfo;
            this.b = adInteractionListener;
            this.c = zArr;
        }

        @Override // com.tapsdk.tapad.internal.animation.e
        public void a() {
            this.c[0] = false;
        }

        @Override // com.tapsdk.tapad.internal.animation.e
        public void a(int i) {
            LandscapeSplashView.this.shakeIsRegister.set(false);
            if (LandscapeSplashView.this.shakeController != null) {
                LandscapeSplashView.this.shakeController.a();
            }
            AdInfo adInfo = LandscapeSplashView.this.adInfo;
            if (adInfo != null) {
                HashMap map = new HashMap();
                if (!LandscapeSplashView.this.isWindowVisibility.get()) {
                    map.put("is_in_back_trigger", "1");
                }
                TapADTrackerObject tapADTrackerObject = this.a.tapADTrackerObject;
                if (tapADTrackerObject != null) {
                    tapADTrackerObject.a(i, null);
                } else {
                    com.tapsdk.tapad.internal.tracker.c.a().a(s.a(adInfo.clickMonitorUrls, i), map, this.a.getClickMonitorHeaderListWrapper());
                }
                LandscapeSplashView landscapeSplashView = LandscapeSplashView.this;
                landscapeSplashView.onInteractionClick(landscapeSplashView.getContext() instanceof Activity ? (Activity) LandscapeSplashView.this.getContext() : null);
            }
            TapSplashAd.AdInteractionListener adInteractionListener = this.b;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClick();
            }
        }
    }

    class h implements SurfaceHolder.Callback {
        h() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            LandscapeSplashView.this.isAttachedToWindow = true;
            LandscapeSplashView.this.mediaPlayer.setDisplay(surfaceHolder);
            LandscapeSplashView.this.startPlayMedia();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            LandscapeSplashView.this.isAttachedToWindow = false;
            if (LandscapeSplashView.this.mediaPlayer == null || !LandscapeSplashView.this.mediaPlayer.isPlaying()) {
                return;
            }
            LandscapeSplashView.this.mediaPlayer.pause();
        }
    }

    class i implements MediaPlayer.OnPreparedListener {
        i() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            LandscapeSplashView.this.isPrepared = true;
            LandscapeSplashView.this.startPlayMedia();
        }
    }

    class j implements MediaPlayer.OnVideoSizeChangedListener {
        j() {
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            if (mediaPlayer == null || mediaPlayer.getVideoWidth() <= 0 || mediaPlayer.getVideoHeight() <= 0) {
                return;
            }
            LandscapeSplashView.this.landscapeSplashCoverSurfaceView.adjustSize(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
        }
    }

    class k extends AnimatorListenerAdapter {
        k() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            LandscapeSplashView.this.landscapeSplashCoverImageView.setVisibility(8);
        }
    }

    public LandscapeSplashView(Context context) {
        super(context);
        this.exposureHandler = new com.tapsdk.tapad.internal.tracker.b(this, new c());
        this.countDownTimerOver = new AtomicBoolean(false);
        this.isViewVisible = new AtomicBoolean(false);
        this.isTimerOverInterfaceCalled = new AtomicBoolean(false);
        this.downloadPresenter = new DownloadPresenter(getContext(), new d());
        this.isAttachedToWindow = false;
        this.isPrepared = false;
        this.shakeIsRegister = new AtomicBoolean(false);
        this.isWindowVisibility = new AtomicBoolean(false);
        initView();
    }

    public LandscapeSplashView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.exposureHandler = new com.tapsdk.tapad.internal.tracker.b(this, new c());
        this.countDownTimerOver = new AtomicBoolean(false);
        this.isViewVisible = new AtomicBoolean(false);
        this.isTimerOverInterfaceCalled = new AtomicBoolean(false);
        this.downloadPresenter = new DownloadPresenter(getContext(), new d());
        this.isAttachedToWindow = false;
        this.isPrepared = false;
        this.shakeIsRegister = new AtomicBoolean(false);
        this.isWindowVisibility = new AtomicBoolean(false);
        initView();
    }

    public LandscapeSplashView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.exposureHandler = new com.tapsdk.tapad.internal.tracker.b(this, new c());
        this.countDownTimerOver = new AtomicBoolean(false);
        this.isViewVisible = new AtomicBoolean(false);
        this.isTimerOverInterfaceCalled = new AtomicBoolean(false);
        this.downloadPresenter = new DownloadPresenter(getContext(), new d());
        this.isAttachedToWindow = false;
        this.isPrepared = false;
        this.shakeIsRegister = new AtomicBoolean(false);
        this.isWindowVisibility = new AtomicBoolean(false);
        initView();
    }

    private String getBtnString(AdInfo adInfo) {
        String str;
        return (adInfo == null || (str = adInfo.btnName) == null || str.length() == 0) ? getResources().getString(R.string.tapad_str_goto_taptap_download) : adInfo.btnName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initInteractionBtn() {
        InteractionInfo interactionInfo;
        AdInfo adInfo = this.adInfo;
        if (adInfo == null || (interactionInfo = adInfo.btnInteractionInfo) == null) {
            return;
        }
        if (interactionInfo.interactionType != 1) {
            this.progressBar.setVisibility(8);
            this.downloadBtn.setVisibility(8);
            this.landscapeSplashInteractionTextView.setVisibility(0);
            this.landscapeSplashInteractionTextView.setText(getBtnString(this.adInfo));
            return;
        }
        this.landscapeSplashInteractionTextView.setVisibility(8);
        DownloadPresenter.DownloadState downloadStateC = this.downloadPresenter.c();
        if (downloadStateC != DownloadPresenter.DownloadState.STARTED && com.tapsdk.tapad.internal.utils.b.a(getContext(), this.adInfo.appInfo.packageName)) {
            this.downloadBtn.setText(R.string.tapad_banner_open);
            this.progressBar.setVisibility(8);
            this.downloadBtn.setVisibility(0);
            return;
        }
        int iB = this.downloadPresenter.b();
        if (downloadStateC == DownloadPresenter.DownloadState.DEFAULT || downloadStateC == DownloadPresenter.DownloadState.ERROR) {
            AppInfo appInfo = this.adInfo.appInfo;
            if (appInfo.apkSize > 0 && q.a(appInfo.appSize)) {
                this.downloadBtn.setText(String.format(getContext().getString(R.string.tapad_banner_download_with_size), this.adInfo.appInfo.appSize));
            } else {
                this.downloadBtn.setText(R.string.tapad_banner_download);
            }
            this.downloadBtn.setVisibility(0);
            this.progressBar.setVisibility(8);
            return;
        }
        if (downloadStateC == DownloadPresenter.DownloadState.STARTED) {
            this.progressBar.setProgress(Math.max(iB, 10));
            this.progressBar.setVisibility(0);
            this.downloadBtn.setVisibility(8);
        } else {
            this.progressBar.setVisibility(8);
            this.downloadBtn.setVisibility(0);
            this.downloadBtn.setText(R.string.tapad_banner_install);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initPresenter() {
        com.tapsdk.tapad.internal.g gVar = new com.tapsdk.tapad.internal.g(new f());
        this.splashPresenter = gVar;
        gVar.a(new com.tapsdk.tapad.internal.g.d(this.adInfo));
    }

    private void initView() {
        View viewInflate = RelativeLayout.inflate(getContext(), R.layout.tapad_view_splash_landscape, this);
        this.landscapeSplashCountDownTextView = (TextView) viewInflate.findViewById(R.id.landscapeSplashCountDownTextView);
        this.landscapeSplashCoverImageView = (ImageView) viewInflate.findViewById(R.id.landscapeSplashCoverImageView);
        this.landscapeSplashCoverSurfaceView = (VideoSurfaceView) viewInflate.findViewById(R.id.landscapeSplashSurfaceView);
        this.landscapeSplashInteractionTextView = (TextView) viewInflate.findViewById(R.id.landscapeSplashInteractionTextView);
        this.landscapeSplashInteractionFrameLayout = (FrameLayout) viewInflate.findViewById(R.id.landscapeSplashInteractionFrameLayout);
        this.landscapeSplashSkipFrameLayout = (FrameLayout) viewInflate.findViewById(R.id.landscapeSplashSkipFrameLayout);
        this.adLogoTextView = (TextView) viewInflate.findViewById(R.id.adLogoTextView);
        this.landscapeSplashBackgroundImageView = (ImageView) viewInflate.findViewById(R.id.landscapeSplashBackgroundImageView);
        this.adLogoImageView = (ImageView) viewInflate.findViewById(R.id.adLogoImageView);
        this.landscapeSplashAdsRelativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.landscapeSplashAdsRelativeLayout);
        this.shakeViewContainer = (ViewGroup) findViewById(R.id.shakeViewContainer);
        this.shakeView = (com.tapsdk.tapad.internal.animation.b) findViewById(R.id.shakeImageView);
        this.hotZoneFrameLayout = (HotZoneFrameLayout) viewInflate.findViewById(R.id.hotZoneFrameLayout);
        this.downloadBtn = (Button) viewInflate.findViewById(R.id.landscapeSplashDownloadBtn);
        this.progressBar = (ProgressBar) viewInflate.findViewById(R.id.landscapeSplashDownloadProgress);
        this.downloadBtn.setOnClickListener(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void justifyCanCallTimeOver() {
        if (this.countDownTimerOver.get() && this.isViewVisible.get() && !this.isTimerOverInterfaceCalled.get()) {
            TapSplashAd.AdInteractionListener adInteractionListener = this.adInteractionListener;
            if (adInteractionListener != null) {
                adInteractionListener.onAdTimeOver();
            }
            this.isTimerOverInterfaceCalled.set(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onInteractionClick(Activity activity) {
        InteractionInfo interactionInfo;
        AdInfo adInfo = this.adInfo;
        if (adInfo == null || activity == null || (interactionInfo = adInfo.btnInteractionInfo) == null) {
            return;
        }
        if (interactionInfo.interactionType != 1) {
            com.tapsdk.tapad.internal.s.a.a(activity, false, adInfo, (DownloadPresenter) null);
        } else {
            if (this.downloadPresenter == null) {
                return;
            }
            showFloatingInteractionWindow(adInfo);
        }
    }

    private void resumeShake() {
        if (this.shakeIsRegister.get() || this.shakeView == null || this.adInfo == null || this.shakeController == null) {
            return;
        }
        this.shakeIsRegister.set(true);
        if (com.tapsdk.tapad.internal.utils.c.b(this.adInfo.btnInteractionInfo)) {
            this.shakeView.a();
            this.shakeController.a(this.shakeView);
            if (!com.tapsdk.tapad.internal.utils.c.c(this.adInfo.btnInteractionInfo)) {
                com.tapsdk.tapad.internal.animation.i iVar = new com.tapsdk.tapad.internal.animation.i();
                float fExtractShakeAngle = this.adInfo.btnInteractionInfo.extractShakeAngle();
                if (fExtractShakeAngle > 0.0f) {
                    iVar.a(fExtractShakeAngle);
                }
                this.shakeController.a((com.tapsdk.tapad.internal.animation.a) iVar);
                return;
            }
            com.tapsdk.tapad.internal.animation.l.a aVar = new com.tapsdk.tapad.internal.animation.l.a();
            aVar.a(this.adInfo.btnInteractionInfo.extractXShakeSpeedEnable(), this.adInfo.btnInteractionInfo.extractYShakeSpeedEnable(), this.adInfo.btnInteractionInfo.extractZShakeSpeedEnable(), this.adInfo.btnInteractionInfo.extractXShakeSpeed(), this.adInfo.btnInteractionInfo.extractYShakeSpeed(), this.adInfo.btnInteractionInfo.extractZShakeSpeed());
            com.tapsdk.tapad.internal.animation.l.b bVar = new com.tapsdk.tapad.internal.animation.l.b();
            bVar.a(this.adInfo.btnInteractionInfo.extractXShakeDegreeEnable(), this.adInfo.btnInteractionInfo.extractYShakeDegreeEnable(), this.adInfo.btnInteractionInfo.extractZShakeDegreeEnable(), this.adInfo.btnInteractionInfo.extractXShakeDegree(), this.adInfo.btnInteractionInfo.extractYShakeDegree(), this.adInfo.btnInteractionInfo.extractZShakeDegree());
            this.shakeController.a((com.tapsdk.tapad.internal.animation.a) aVar);
            this.shakeController.a((com.tapsdk.tapad.internal.animation.a) bVar);
        }
    }

    private void showFloatingInteractionWindow(AdInfo adInfo) {
        if (this.downloadPresenter == null || adInfo == null) {
            return;
        }
        Activity activityA = com.tapsdk.tapad.internal.utils.a.a(getContext());
        if (com.tapsdk.tapad.internal.utils.a.b(activityA)) {
            return;
        }
        com.tapsdk.tapad.internal.l.d.a aVarA = com.tapsdk.tapad.internal.l.d.a.a(adInfo);
        aVarA.a(this.downloadPresenter);
        try {
            aVarA.show(activityA.getFragmentManager(), com.tapsdk.tapad.internal.l.d.a.i);
        } catch (Throwable unused) {
        }
        if (adInfo.btnInteractionInfo.canStartDownloadInFloatingLayer()) {
            this.downloadPresenter.a((com.tapsdk.tapad.internal.b) new DownloadPresenter.j(adInfo));
        }
        com.tapsdk.tapad.internal.g gVar = this.splashPresenter;
        if (gVar != null) {
            gVar.b();
        }
        aVarA.a(new a(adInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlayMedia() {
        if (this.isPrepared && this.isAttachedToWindow) {
            this.mediaPlayer.setVolume(0.0f, 0.0f);
            this.mediaPlayer.start();
            this.landscapeSplashCoverImageView.animate().alpha(0.0f).setDuration(500L).setListener(new k());
            this.exposureHandler.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryToRemoveSelf() {
        this.shakeIsRegister.set(false);
        com.tapsdk.tapad.internal.animation.h hVar = this.shakeController;
        if (hVar != null) {
            hVar.a();
        }
    }

    public void config(AdInfo adInfo, TapSplashAd.AdInteractionListener adInteractionListener) {
        this.adInfo = adInfo;
        this.adInteractionListener = adInteractionListener;
        com.tapsdk.tapad.internal.tracker.b bVar = this.exposureHandler;
        TapADTrackerObject tapADTrackerObject = adInfo.tapADTrackerObject;
        bVar.a(tapADTrackerObject == null ? null : tapADTrackerObject.a);
        Activity activityA = com.tapsdk.tapad.internal.utils.a.a(getContext());
        boolean[] zArr = {com.tapsdk.tapad.internal.utils.c.b(adInfo.btnInteractionInfo)};
        this.shakeController = com.tapsdk.tapad.internal.animation.h.a(activityA, new g(adInfo, adInteractionListener, zArr));
        this.shakeViewContainer.setVisibility(zArr[0] ? 0 : 8);
        this.hotZoneFrameLayout.setVisibility(com.tapsdk.tapad.internal.utils.c.a(adInfo.btnInteractionInfo) ? 0 : 8);
        this.landscapeSplashInteractionFrameLayout.setVisibility(zArr[0] ? 8 : 0);
        resumeShake();
        List<VideoInfo> list = adInfo.materialInfo.videoInfoList;
        if (list == null || list.size() <= 0 || adInfo.materialInfo.videoInfoList.get(0) == null) {
            return;
        }
        this.landscapeSplashCoverSurfaceView.setVisibility(0);
        Glide.with(this).load(adInfo.materialInfo.videoInfoList.get(0).coverImage.imageUrl).into(this.landscapeSplashCoverImageView);
        VideoInfo videoInfo = adInfo.materialInfo.videoInfoList.get(0);
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.mediaPlayer = mediaPlayer;
        try {
            mediaPlayer.setDataSource(getContext(), Uri.parse(videoInfo.videoUrl));
        } catch (IOException e2) {
            TapADLogger.d(e2.getMessage());
        }
        this.landscapeSplashCoverSurfaceView.getHolder().addCallback(new h());
        this.mediaPlayer.setOnPreparedListener(new i());
        this.mediaPlayer.setOnVideoSizeChangedListener(new j());
        this.mediaPlayer.prepareAsync();
        this.mediaPlayer.setLooping(true);
    }

    public void destroy() {
        try {
            MediaPlayer mediaPlayer = this.mediaPlayer;
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                this.mediaPlayer.stop();
            }
            MediaPlayer mediaPlayer2 = this.mediaPlayer;
            if (mediaPlayer2 != null) {
                mediaPlayer2.release();
            }
            this.mediaPlayer = null;
        } catch (Exception e2) {
            TapADLogger.d(e2.getMessage());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.isPrepared) {
            this.landscapeSplashCoverImageView.setVisibility(0);
        }
        this.landscapeSplashCoverImageView.postDelayed(new b(), 200L);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        TapADLogger.d("LandscapeSplashView onDetachedFromWindow");
        super.onDetachedFromWindow();
        com.tapsdk.tapad.internal.g gVar = this.splashPresenter;
        if (gVar != null) {
            gVar.a(new com.tapsdk.tapad.internal.d());
        }
        this.shakeIsRegister.set(false);
        com.tapsdk.tapad.internal.animation.h hVar = this.shakeController;
        if (hVar != null) {
            hVar.a();
        }
        destroy();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i2) {
        AdInfo adInfo;
        super.onWindowVisibilityChanged(i2);
        this.isWindowVisibility.set(i2 == 0);
        this.isViewVisible.set(i2 == 0);
        if (i2 == 8 && (adInfo = this.adInfo) != null && !adInfo.splashCanShakeInBack() && this.shakeController != null) {
            this.shakeIsRegister.set(false);
            this.shakeController.a();
        }
        if (i2 == 0) {
            resumeShake();
        }
        if (i2 == 0) {
            com.tapsdk.tapad.internal.c.b().a(com.tapsdk.tapad.internal.utils.a.a(getContext()), this.adInfo);
        }
        justifyCanCallTimeOver();
    }
}
