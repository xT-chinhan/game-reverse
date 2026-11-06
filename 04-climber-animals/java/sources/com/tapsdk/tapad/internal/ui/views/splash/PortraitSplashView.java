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
import android.util.Log;
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
import com.tapsdk.tapad.internal.ui.views.PortraitSplashFixedAspectRatioFrameLayout;
import com.tapsdk.tapad.internal.ui.views.video.VideoSurfaceView;
import com.tapsdk.tapad.internal.utils.TapADLogger;
import com.tapsdk.tapad.internal.utils.q;
import com.tapsdk.tapad.internal.utils.s;
import com.tapsdk.tapad.model.entities.AdInfo;
import com.tapsdk.tapad.model.entities.AppInfo;
import com.tapsdk.tapad.model.entities.ImageInfo;
import com.tapsdk.tapad.model.entities.InteractionInfo;
import com.tapsdk.tapad.model.entities.VideoInfo;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class PortraitSplashView extends RelativeLayout {
    private static final int MIN_PROGRESS = 10;
    private AdInfo adInfo;
    private TapSplashAd.AdInteractionListener adInteractionListener;
    private ImageView adLogoImageView;
    private TextView adLogoTextView;
    private final AtomicBoolean countDownTimerOver;
    private Button downloadBtn;
    private final DownloadPresenter downloadPresenter;
    private long endTime;
    private final com.tapsdk.tapad.internal.tracker.b exposureHandler;
    private HotZoneFrameLayout hotZoneFrameLayout;
    private boolean isAttachedToWindow;
    private boolean isPrepared;
    private final AtomicBoolean isTimerOverInterfaceCalled;
    private final AtomicBoolean isViewVisible;
    private AtomicBoolean isWindowVisibility;
    private MediaPlayer mediaPlayer;
    private ImageView portraitSplashBackgroundImageView;
    private TextView portraitSplashCountDownTextView;
    private ImageView portraitSplashCoverImageView;
    private VideoSurfaceView portraitSplashCoverSurfaceView;
    private PortraitSplashFixedAspectRatioFrameLayout portraitSplashFixedAspectRatioFrameLayout;
    private FrameLayout portraitSplashInteractionFrameLayout;
    private TextView portraitSplashInteractionTextView;
    private FrameLayout portraitSplashSkipFrameLayout;
    private ProgressBar progressBar;
    private com.tapsdk.tapad.internal.animation.h shakeController;
    private AtomicBoolean shakeIsRegister;
    private com.tapsdk.tapad.internal.animation.b shakeView;
    private ViewGroup shakeViewContainer;
    com.tapsdk.tapad.internal.g splashPresenter;
    private long startTime;

    class a implements com.tapsdk.tapad.internal.l.d.a.d {
        final /* synthetic */ AdInfo a;

        a(AdInfo adInfo) {
            this.a = adInfo;
        }

        @Override // com.tapsdk.tapad.internal.l.d.a.d
        public void a() {
            com.tapsdk.tapad.internal.g gVar = PortraitSplashView.this.splashPresenter;
            if (gVar != null) {
                gVar.a(this.a);
            }
        }

        @Override // com.tapsdk.tapad.internal.l.d.a.d
        public void b() {
            com.tapsdk.tapad.internal.g gVar = PortraitSplashView.this.splashPresenter;
            if (gVar != null) {
                gVar.a(this.a);
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
                PortraitSplashView.this.exposureHandler.b();
                return false;
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
                return false;
            }
        }

        /* JADX INFO: renamed from: com.tapsdk.tapad.internal.ui.views.splash.PortraitSplashView$b$b, reason: collision with other inner class name */
        class ViewOnClickListenerC0638b implements View.OnClickListener {
            ViewOnClickListenerC0638b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PortraitSplashView.this.adInfo != null && PortraitSplashView.this.adInfo.isFirstPassiveTransfer && PortraitSplashView.this.adInfo.isCloseTransferEnable) {
                    PortraitSplashView.this.adInfo.isFirstPassiveTransfer = false;
                    if (PortraitSplashView.this.adInfo.tapADTrackerObject != null) {
                        PortraitSplashView.this.adInfo.tapADTrackerObject.a(10, null);
                    } else {
                        com.tapsdk.tapad.internal.tracker.c.a().a(s.a(PortraitSplashView.this.adInfo.clickMonitorUrls, 10), (Map<String, String>) null, PortraitSplashView.this.adInfo.getClickMonitorHeaderListWrapper());
                    }
                    PortraitSplashView.this.onInteractionClick(com.tapsdk.tapad.internal.utils.a.a(PortraitSplashView.this.getContext()));
                    if (PortraitSplashView.this.adInteractionListener != null) {
                        PortraitSplashView.this.adInteractionListener.onAdClick();
                    }
                }
                PortraitSplashView.this.tryToRemoveSelf();
                if (PortraitSplashView.this.adInteractionListener != null) {
                    PortraitSplashView.this.adInteractionListener.onAdSkip();
                }
            }
        }

        class c implements View.OnClickListener {
            c() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PortraitSplashView.this.adInfo.tapADTrackerObject != null) {
                    PortraitSplashView.this.adInfo.tapADTrackerObject.a(0, null);
                } else {
                    com.tapsdk.tapad.internal.tracker.c.a().a(s.a(PortraitSplashView.this.adInfo.clickMonitorUrls, 0), (Map<String, String>) null, PortraitSplashView.this.adInfo.getClickMonitorHeaderListWrapper());
                }
                PortraitSplashView.this.onInteractionClick(com.tapsdk.tapad.internal.utils.a.a(PortraitSplashView.this.getContext()));
                if (PortraitSplashView.this.adInteractionListener != null) {
                    PortraitSplashView.this.adInteractionListener.onAdClick();
                }
            }
        }

        class d implements View.OnClickListener {
            d() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PortraitSplashView.this.adInfo.tapADTrackerObject != null) {
                    PortraitSplashView.this.adInfo.tapADTrackerObject.a(1, null);
                } else {
                    com.tapsdk.tapad.internal.tracker.c.a().a(s.a(PortraitSplashView.this.adInfo.clickMonitorUrls, 1), (Map<String, String>) null, PortraitSplashView.this.adInfo.getClickMonitorHeaderListWrapper());
                }
                PortraitSplashView.this.onInteractionClick(com.tapsdk.tapad.internal.utils.a.a(PortraitSplashView.this.getContext()));
                if (PortraitSplashView.this.adInteractionListener != null) {
                    PortraitSplashView.this.adInteractionListener.onAdClick();
                }
            }
        }

        class e implements View.OnClickListener {
            e() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Activity activityA = com.tapsdk.tapad.internal.utils.a.a(PortraitSplashView.this.getContext());
                if (PortraitSplashView.this.adInfo.viewInteractionInfo != null) {
                    if (PortraitSplashView.this.adInfo.tapADTrackerObject != null) {
                        PortraitSplashView.this.adInfo.tapADTrackerObject.a(3, null);
                    } else {
                        com.tapsdk.tapad.internal.tracker.c.a().a(PortraitSplashView.this.adInfo.clickMonitorUrls, PortraitSplashView.this.adInfo.viewInteractionInfo, PortraitSplashView.this.adInfo.getClickMonitorHeaderListWrapper());
                    }
                    com.tapsdk.tapad.internal.s.a.a(activityA, true, PortraitSplashView.this.adInfo, (DownloadPresenter) null);
                    if (PortraitSplashView.this.adInteractionListener != null) {
                        PortraitSplashView.this.adInteractionListener.onAdClick();
                    }
                }
            }
        }

        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageInfo imageInfo;
            int i;
            Context context = PortraitSplashView.this.getContext();
            if (context == null || !PortraitSplashView.this.isAttachedToWindow() || com.tapsdk.tapad.internal.utils.a.b(com.tapsdk.tapad.internal.utils.a.a(context))) {
                return;
            }
            PortraitSplashView.this.initPresenter();
            if (PortraitSplashView.this.adInfo.tapADTrackerObject == null || PortraitSplashView.this.adInfo.tapADTrackerObject.a == null || !PortraitSplashView.this.adInfo.tapADTrackerObject.a.a) {
                com.tapsdk.tapad.internal.tracker.c.a().a(PortraitSplashView.this.adInfo.viewMonitorUrls, (Map<String, String>) null, PortraitSplashView.this.adInfo.getViewMonitorHeaderListWrapper());
            } else {
                PortraitSplashView.this.adInfo.tapADTrackerObject.a.b((Map<String, String>) null);
            }
            if (PortraitSplashView.this.adInteractionListener != null) {
                PortraitSplashView.this.adInteractionListener.onAdShow();
            }
            if (PortraitSplashView.this.portraitSplashCoverSurfaceView.getVisibility() == 8 && PortraitSplashView.this.adInfo.materialInfo.imageInfoList != null && PortraitSplashView.this.adInfo.materialInfo.imageInfoList.size() > 0 && (imageInfo = PortraitSplashView.this.adInfo.materialInfo.imageInfoList.get(0)) != null) {
                int i2 = imageInfo.width;
                if (i2 > 0 && (i = imageInfo.height) > 0 && i > i2) {
                    PortraitSplashView.this.portraitSplashCoverImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                Glide.with(PortraitSplashView.this).load(imageInfo.imageUrl).addListener(new a()).into(PortraitSplashView.this.portraitSplashCoverImageView);
            }
            PortraitSplashView.this.portraitSplashCountDownTextView.setText(R.string.tapad_btn_skip);
            PortraitSplashView.this.portraitSplashSkipFrameLayout.setOnClickListener(new ViewOnClickListenerC0638b());
            PortraitSplashView.this.initInteractionBtn();
            PortraitSplashView.this.portraitSplashInteractionFrameLayout.setOnClickListener(new c());
            PortraitSplashView.this.hotZoneFrameLayout.setOnClickListener(new d());
            PortraitSplashView.this.portraitSplashFixedAspectRatioFrameLayout.setOnClickListener(new e());
            PortraitSplashView.this.adLogoImageView.setVisibility(PortraitSplashView.this.adInfo.logoInfo.logoStatus != 1 ? 8 : 0);
            String string = PortraitSplashView.this.getResources().getString(R.string.tapad_str_ads);
            if (PortraitSplashView.this.adInfo.logoInfo.logoTitle != null && PortraitSplashView.this.adInfo.logoInfo.logoTitle.length() > 0 && PortraitSplashView.this.adInfo.logoInfo.logoTitle.length() < 5) {
                string = PortraitSplashView.this.adInfo.logoInfo.logoTitle;
            }
            if (PortraitSplashView.this.adInfo.logoInfo.logoImage != null && !TextUtils.isEmpty(PortraitSplashView.this.adInfo.logoInfo.logoImage.imageUrl)) {
                Glide.with(PortraitSplashView.this.adLogoImageView.getContext()).load(PortraitSplashView.this.adInfo.logoInfo.logoImage.imageUrl).into(PortraitSplashView.this.adLogoImageView);
            }
            PortraitSplashView.this.adLogoTextView.setText(string);
            String strB = com.tapsdk.tapad.e.d.d().b();
            if (strB == null || strB.length() <= 0) {
                return;
            }
            Glide.with(PortraitSplashView.this.getContext()).load(strB).into(PortraitSplashView.this.portraitSplashBackgroundImageView);
        }
    }

    class c implements com.tapsdk.tapad.internal.tracker.b.InterfaceC0634b {
        c() {
        }

        @Override // com.tapsdk.tapad.internal.tracker.b.InterfaceC0634b
        public void a() {
            if (PortraitSplashView.this.adInteractionListener != null) {
                PortraitSplashView.this.adInteractionListener.onAdValidShow();
            }
        }
    }

    class d implements DownloadPresenter.h {
        d() {
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void a() {
            PortraitSplashView.this.initInteractionBtn();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void a(int i) {
            TapADLogger.d("updateDownloadProgress:" + i);
            if (i <= 10 || PortraitSplashView.this.progressBar == null) {
                return;
            }
            PortraitSplashView.this.progressBar.setProgress(i);
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void b() {
            PortraitSplashView.this.initInteractionBtn();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void c() {
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void d() {
            PortraitSplashView.this.initInteractionBtn();
            PortraitSplashView.this.downloadPresenter.a(new DownloadPresenter.k(PortraitSplashView.this.adInfo));
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void e() {
            PortraitSplashView.this.initInteractionBtn();
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PortraitSplashView.this.adInfo == null) {
                return;
            }
            if (PortraitSplashView.this.adInfo.tapADTrackerObject != null) {
                PortraitSplashView.this.adInfo.tapADTrackerObject.a(0, null);
            } else {
                com.tapsdk.tapad.internal.tracker.c.a().a(s.a(PortraitSplashView.this.adInfo.clickMonitorUrls, 0), (Map<String, String>) null, PortraitSplashView.this.adInfo.getClickMonitorHeaderListWrapper());
            }
            PortraitSplashView portraitSplashView = PortraitSplashView.this;
            portraitSplashView.onInteractionClick(portraitSplashView.getContext() instanceof Activity ? (Activity) PortraitSplashView.this.getContext() : null);
            if (PortraitSplashView.this.adInteractionListener != null) {
                PortraitSplashView.this.adInteractionListener.onAdClick();
            }
        }
    }

    class f implements com.tapsdk.tapad.internal.g.c {
        f() {
        }

        @Override // com.tapsdk.tapad.internal.g.c
        public void a() {
            PortraitSplashView.this.countDownTimerOver.set(true);
            PortraitSplashView.this.justifyCanCallTimeOver();
            PortraitSplashView.this.tryToRemoveSelf();
        }

        @Override // com.tapsdk.tapad.internal.g.c
        public void a(long j) {
            PortraitSplashView.this.portraitSplashCountDownTextView.setText(PortraitSplashView.this.splashPresenter.a());
        }

        @Override // com.tapsdk.tapad.internal.g.c
        public void onError(int i, String str) {
            PortraitSplashView.this.tryToRemoveSelf();
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
            PortraitSplashView.this.shakeIsRegister.set(false);
            if (PortraitSplashView.this.shakeController != null) {
                PortraitSplashView.this.shakeController.a();
            }
            AdInfo adInfo = PortraitSplashView.this.adInfo;
            if (adInfo != null) {
                HashMap map = new HashMap();
                if (!PortraitSplashView.this.isWindowVisibility.get()) {
                    map.put("is_in_back_trigger", "1");
                }
                TapADTrackerObject tapADTrackerObject = this.a.tapADTrackerObject;
                if (tapADTrackerObject != null) {
                    tapADTrackerObject.a(i, null);
                } else {
                    com.tapsdk.tapad.internal.tracker.c.a().a(s.a(adInfo.clickMonitorUrls, i), map, this.a.getClickMonitorHeaderListWrapper());
                }
                PortraitSplashView portraitSplashView = PortraitSplashView.this;
                portraitSplashView.onInteractionClick(portraitSplashView.getContext() instanceof Activity ? (Activity) PortraitSplashView.this.getContext() : null);
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
            PortraitSplashView.this.startTime = System.currentTimeMillis();
            PortraitSplashView.this.isAttachedToWindow = true;
            PortraitSplashView.this.mediaPlayer.setDisplay(surfaceHolder);
            PortraitSplashView.this.startPlayMedia();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            PortraitSplashView.this.isAttachedToWindow = false;
            if (PortraitSplashView.this.mediaPlayer == null || !PortraitSplashView.this.mediaPlayer.isPlaying()) {
                return;
            }
            PortraitSplashView.this.mediaPlayer.pause();
        }
    }

    class i implements MediaPlayer.OnPreparedListener {
        i() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            PortraitSplashView.this.isPrepared = true;
            PortraitSplashView.this.startPlayMedia();
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
            PortraitSplashView.this.portraitSplashCoverSurfaceView.adjustSize(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
        }
    }

    class k extends AnimatorListenerAdapter {
        k() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            PortraitSplashView.this.portraitSplashCoverImageView.setVisibility(8);
        }
    }

    public PortraitSplashView(Context context) {
        super(context);
        this.exposureHandler = new com.tapsdk.tapad.internal.tracker.b(this, new c());
        this.countDownTimerOver = new AtomicBoolean(false);
        this.isViewVisible = new AtomicBoolean(false);
        this.isTimerOverInterfaceCalled = new AtomicBoolean(false);
        this.downloadPresenter = new DownloadPresenter(getContext(), new d());
        this.isAttachedToWindow = false;
        this.isPrepared = false;
        this.startTime = 0L;
        this.endTime = 0L;
        this.shakeIsRegister = new AtomicBoolean(false);
        this.isWindowVisibility = new AtomicBoolean(false);
        initView();
    }

    public PortraitSplashView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.exposureHandler = new com.tapsdk.tapad.internal.tracker.b(this, new c());
        this.countDownTimerOver = new AtomicBoolean(false);
        this.isViewVisible = new AtomicBoolean(false);
        this.isTimerOverInterfaceCalled = new AtomicBoolean(false);
        this.downloadPresenter = new DownloadPresenter(getContext(), new d());
        this.isAttachedToWindow = false;
        this.isPrepared = false;
        this.startTime = 0L;
        this.endTime = 0L;
        this.shakeIsRegister = new AtomicBoolean(false);
        this.isWindowVisibility = new AtomicBoolean(false);
        initView();
    }

    public PortraitSplashView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.exposureHandler = new com.tapsdk.tapad.internal.tracker.b(this, new c());
        this.countDownTimerOver = new AtomicBoolean(false);
        this.isViewVisible = new AtomicBoolean(false);
        this.isTimerOverInterfaceCalled = new AtomicBoolean(false);
        this.downloadPresenter = new DownloadPresenter(getContext(), new d());
        this.isAttachedToWindow = false;
        this.isPrepared = false;
        this.startTime = 0L;
        this.endTime = 0L;
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
            this.portraitSplashInteractionTextView.setVisibility(0);
            this.portraitSplashInteractionTextView.setText(getBtnString(this.adInfo));
            return;
        }
        this.portraitSplashInteractionTextView.setVisibility(8);
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
        View viewInflate = RelativeLayout.inflate(getContext(), R.layout.tapad_view_splash_portrait, this);
        this.portraitSplashCountDownTextView = (TextView) viewInflate.findViewById(R.id.portraitSplashCountDownTextView);
        this.portraitSplashCoverImageView = (ImageView) viewInflate.findViewById(R.id.portraitSplashCoverImageView);
        this.portraitSplashInteractionFrameLayout = (FrameLayout) viewInflate.findViewById(R.id.portraitSplashInteractionFrameLayout);
        this.portraitSplashInteractionTextView = (TextView) viewInflate.findViewById(R.id.portraitSplashInteractionTextView);
        this.portraitSplashSkipFrameLayout = (FrameLayout) viewInflate.findViewById(R.id.portraitSplashSkipFrameLayout);
        this.adLogoTextView = (TextView) viewInflate.findViewById(R.id.adLogoTextView);
        this.portraitSplashBackgroundImageView = (ImageView) viewInflate.findViewById(R.id.portraitSplashBackgroundImageView);
        this.adLogoImageView = (ImageView) viewInflate.findViewById(R.id.adLogoImageView);
        this.portraitSplashFixedAspectRatioFrameLayout = (PortraitSplashFixedAspectRatioFrameLayout) viewInflate.findViewById(R.id.portraitSplashFixedAspectRatioFrameLayout);
        this.shakeViewContainer = (ViewGroup) viewInflate.findViewById(R.id.shakeViewContainer);
        this.shakeView = (com.tapsdk.tapad.internal.animation.b) viewInflate.findViewById(R.id.shakeImageView);
        this.hotZoneFrameLayout = (HotZoneFrameLayout) viewInflate.findViewById(R.id.hotZoneFrameLayout);
        this.portraitSplashCoverSurfaceView = (VideoSurfaceView) viewInflate.findViewById(R.id.portraitSplashCoverSurfaceView);
        this.downloadBtn = (Button) viewInflate.findViewById(R.id.portraitSplashDownloadBtn);
        this.progressBar = (ProgressBar) viewInflate.findViewById(R.id.portraitSplashInteractionProgressBar);
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
            Log.i("LandscapeSplashView", (System.currentTimeMillis() - this.startTime) + ":::");
            this.portraitSplashCoverImageView.animate().alpha(0.0f).setDuration(500L).setListener(new k());
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
        Activity activityA = com.tapsdk.tapad.internal.utils.a.a(getContext());
        com.tapsdk.tapad.internal.tracker.b bVar = this.exposureHandler;
        TapADTrackerObject tapADTrackerObject = adInfo.tapADTrackerObject;
        bVar.a(tapADTrackerObject == null ? null : tapADTrackerObject.a);
        boolean[] zArr = {com.tapsdk.tapad.internal.utils.c.b(adInfo.btnInteractionInfo)};
        this.shakeController = com.tapsdk.tapad.internal.animation.h.a(activityA, new g(adInfo, adInteractionListener, zArr));
        this.shakeViewContainer.setVisibility(zArr[0] ? 0 : 8);
        this.portraitSplashInteractionFrameLayout.setVisibility(zArr[0] ? 8 : 0);
        if (zArr[0]) {
            resumeShake();
        }
        this.hotZoneFrameLayout.setVisibility(com.tapsdk.tapad.internal.utils.c.a(adInfo.btnInteractionInfo) ? 0 : 8);
        List<VideoInfo> list = adInfo.materialInfo.videoInfoList;
        if (list == null || list.size() <= 0 || adInfo.materialInfo.videoInfoList.get(0) == null) {
            return;
        }
        this.portraitSplashCoverSurfaceView.setVisibility(0);
        Glide.with(this).load(adInfo.materialInfo.videoInfoList.get(0).coverImage.imageUrl).into(this.portraitSplashCoverImageView);
        VideoInfo videoInfo = adInfo.materialInfo.videoInfoList.get(0);
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.mediaPlayer = mediaPlayer;
        try {
            mediaPlayer.setDataSource(getContext(), Uri.parse(videoInfo.videoUrl));
        } catch (IOException e2) {
            TapADLogger.d(e2.getMessage());
        }
        this.portraitSplashCoverSurfaceView.getHolder().addCallback(new h());
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
            this.portraitSplashCoverImageView.setVisibility(0);
        }
        this.portraitSplashCoverImageView.post(new b());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        TapADLogger.d("PortraitSplashView onDetachedFromWindow");
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
        this.isViewVisible.set(i2 == 0);
        this.isWindowVisibility.set(i2 == 0);
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

    public void resetExpectedAspectRatio(int i2, int i3) {
        if (i2 == -1 || i3 == -1) {
            return;
        }
        this.portraitSplashFixedAspectRatioFrameLayout.resetExpectedSize(i2, i3);
    }

    public void resumeShake() {
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
}
