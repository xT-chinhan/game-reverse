package com.tapsdk.tapad.stub.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.tapsdk.tapad.AdRequest;
import com.tapsdk.tapad.InterstitialPresenter;
import com.tapsdk.tapad.R;
import com.tapsdk.tapad.internal.DownloadPresenter;
import com.tapsdk.tapad.internal.RewardPresenter;
import com.tapsdk.tapad.internal.tracker.ExposureTrackerObject;
import com.tapsdk.tapad.internal.tracker.TapADTrackerObject;
import com.tapsdk.tapad.internal.ui.views.banner.LandscapeBannerView;
import com.tapsdk.tapad.internal.ui.views.banner.RightBannerView;
import com.tapsdk.tapad.internal.ui.views.video.VideoSurfaceView;
import com.tapsdk.tapad.internal.utils.TapADLogger;
import com.tapsdk.tapad.model.entities.AdInfo;
import com.tapsdk.tapad.model.entities.AppInfo;
import com.tapsdk.tapad.model.entities.InteractionInfo;
import com.tapsdk.tapad.model.entities.UninstalledAdInfo;
import com.tapsdk.tapad.model.entities.VideoInfo;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class Stub_Interstitial_Video_Landscape_Activity extends Activity {
    private static final String EXTRA_PARAMS_AD_REQUEST = "request";
    private static final String EXTRA_PARAMS_CALLBACK_ID = "c_id";
    private static final String EXTRA_PARAMS_DATA = "data";
    private ImageView backgroundImageView;
    private String bubbleContent;
    private ViewGroup bubbleView;
    private TextView countDownTextView;
    private ImageView coverImageView;
    private DownloadPresenter downloadPresenter;
    private ImageView horizontalCoverImageView;
    private RelativeLayout horizontalRewardCompleteRelativeLayout;
    private InterstitialPresenter interstitialPresenter;
    private LandscapeBannerView landscapeBannerView;
    private MediaPlayer mediaPlayer;
    private ImageView mediaPlayerImageView;
    private com.tapsdk.tapad.internal.e.a rewardBridge;
    private LinearLayout rewardSkipLinearLayout;
    private RightBannerView rightBannerView;
    private View skipDividerView;
    private TextView skipTextView;
    private VideoSurfaceView surfaceView;
    private String videoUri;
    private ImageView volumeImageView;
    private int volumeState = 0;
    private boolean mediaOpened = true;
    private boolean isMediaReady = false;
    private boolean gotoComplete = false;
    private int callbackId = 0;
    private AdInfo adInfo = null;
    private com.tapsdk.tapad.internal.tracker.b exposureHandler = null;

    class a implements View.OnClickListener {
        final /* synthetic */ AdInfo a;

        a(AdInfo adInfo) {
            this.a = adInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AdInfo adInfo = this.a;
            if (adInfo != null && adInfo.videoAndImageCanTransfer()) {
                AdInfo adInfo2 = this.a;
                if (adInfo2.viewInteractionInfo != null) {
                    TapADTrackerObject tapADTrackerObject = adInfo2.tapADTrackerObject;
                    if (tapADTrackerObject != null) {
                        tapADTrackerObject.a(3, null);
                    } else {
                        com.tapsdk.tapad.internal.tracker.c cVarA = com.tapsdk.tapad.internal.tracker.c.a();
                        AdInfo adInfo3 = this.a;
                        cVarA.a(adInfo3.clickMonitorUrls, adInfo3.viewInteractionInfo, adInfo3.getClickMonitorHeaderListWrapper());
                    }
                    Stub_Interstitial_Video_Landscape_Activity stub_Interstitial_Video_Landscape_Activity = Stub_Interstitial_Video_Landscape_Activity.this;
                    com.tapsdk.tapad.internal.s.a.a((Activity) stub_Interstitial_Video_Landscape_Activity, true, this.a, stub_Interstitial_Video_Landscape_Activity.downloadPresenter);
                    return;
                }
            }
            Stub_Interstitial_Video_Landscape_Activity stub_Interstitial_Video_Landscape_Activity2 = Stub_Interstitial_Video_Landscape_Activity.this;
            stub_Interstitial_Video_Landscape_Activity2.mediaOpened = true ^ stub_Interstitial_Video_Landscape_Activity2.mediaOpened;
            if (Stub_Interstitial_Video_Landscape_Activity.this.mediaOpened) {
                Stub_Interstitial_Video_Landscape_Activity.this.resumeMedia();
            } else {
                Stub_Interstitial_Video_Landscape_Activity.this.pauseMedia();
            }
        }
    }

    class b extends ViewOutlineProvider {
        final /* synthetic */ int a;

        b(int i) {
            this.a = i;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.a);
        }
    }

    class c implements RequestListener<Drawable> {
        c() {
        }

        @Override // com.bumptech.glide.request.RequestListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
            if (Stub_Interstitial_Video_Landscape_Activity.this.exposureHandler == null) {
                return false;
            }
            Stub_Interstitial_Video_Landscape_Activity.this.exposureHandler.b();
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
            return false;
        }
    }

    class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
        }
    }

    class e implements View.OnClickListener {
        final /* synthetic */ AdInfo a;

        e(AdInfo adInfo) {
            this.a = adInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AdInfo adInfo = this.a;
            if (!adInfo.isFirstPassiveTransfer || !adInfo.isCloseTransferEnable) {
                Stub_Interstitial_Video_Landscape_Activity.this.gotoComplete = true;
                Stub_Interstitial_Video_Landscape_Activity.this.finish();
                return;
            }
            adInfo.isFirstPassiveTransfer = false;
            Stub_Interstitial_Video_Landscape_Activity.this.bubbleView.setVisibility(8);
            Activity activityA = com.tapsdk.tapad.internal.utils.a.a((Context) Stub_Interstitial_Video_Landscape_Activity.this);
            Stub_Interstitial_Video_Landscape_Activity.this.rightBannerView.onInteractionButtonClick(activityA, 1);
            Stub_Interstitial_Video_Landscape_Activity.this.landscapeBannerView.onInteractionButtonClick(activityA, 1, false);
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity activityA = com.tapsdk.tapad.internal.utils.a.a((Context) Stub_Interstitial_Video_Landscape_Activity.this);
            Stub_Interstitial_Video_Landscape_Activity.this.rightBannerView.onInteractionButtonClick(activityA, 1);
            Stub_Interstitial_Video_Landscape_Activity.this.landscapeBannerView.onInteractionButtonClick(activityA, 1, false);
        }
    }

    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tapsdk.tapad.internal.utils.j.c(Stub_Interstitial_Video_Landscape_Activity.this.getWindow());
        }
    }

    class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Stub_Interstitial_Video_Landscape_Activity.this.bubbleView.setVisibility(8);
        }
    }

    class i implements com.tapsdk.tapad.internal.tracker.b.InterfaceC0634b {
        i() {
        }

        @Override // com.tapsdk.tapad.internal.tracker.b.InterfaceC0634b
        public void a() {
            if (Stub_Interstitial_Video_Landscape_Activity.this.rewardBridge != null) {
                Stub_Interstitial_Video_Landscape_Activity.this.rewardBridge.onAdValidShow();
            }
        }
    }

    class j implements DownloadPresenter.h {
        final /* synthetic */ AdInfo a;

        j(AdInfo adInfo) {
            this.a = adInfo;
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void a() {
            Stub_Interstitial_Video_Landscape_Activity.this.landscapeBannerView.updateInteractionLayout();
            Stub_Interstitial_Video_Landscape_Activity.this.rightBannerView.updateInteractionLayout();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void a(int i) {
            TapADLogger.d("updateDownloadProgress:" + i);
            Stub_Interstitial_Video_Landscape_Activity.this.landscapeBannerView.updateInteractionLayout();
            Stub_Interstitial_Video_Landscape_Activity.this.rightBannerView.updateInteractionLayout();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void b() {
            Stub_Interstitial_Video_Landscape_Activity.this.landscapeBannerView.updateInteractionLayout();
            Stub_Interstitial_Video_Landscape_Activity.this.rightBannerView.updateInteractionLayout();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void c() {
            Stub_Interstitial_Video_Landscape_Activity.this.landscapeBannerView.updateInteractionLayout();
            Stub_Interstitial_Video_Landscape_Activity.this.rightBannerView.updateInteractionLayout();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void d() {
            Stub_Interstitial_Video_Landscape_Activity.this.landscapeBannerView.updateInteractionLayout();
            Stub_Interstitial_Video_Landscape_Activity.this.rightBannerView.updateInteractionLayout();
            Stub_Interstitial_Video_Landscape_Activity.this.downloadPresenter.a(new DownloadPresenter.k(this.a));
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void e() {
            TapADLogger.d("downloadError");
            Stub_Interstitial_Video_Landscape_Activity.this.landscapeBannerView.updateInteractionLayout();
            Stub_Interstitial_Video_Landscape_Activity.this.rightBannerView.updateInteractionLayout();
        }
    }

    class k implements InterstitialPresenter.c {
        final /* synthetic */ AdInfo a;

        k(AdInfo adInfo) {
            this.a = adInfo;
        }

        @Override // com.tapsdk.tapad.InterstitialPresenter.c
        public void a(long j) {
            Stub_Interstitial_Video_Landscape_Activity.this.updateCountDownTime();
            if (Stub_Interstitial_Video_Landscape_Activity.this.bubbleView.getVisibility() == 8) {
                long j2 = j / 1000;
                AdInfo adInfo = this.a;
                if (j2 == adInfo.bubbleWaitTime && adInfo.isFirstPassiveTransfer && adInfo.isAutoWaitTransferEnable) {
                    Stub_Interstitial_Video_Landscape_Activity.this.bubbleView.setVisibility(0);
                    Stub_Interstitial_Video_Landscape_Activity.this.bubbleView.setAnimation(AnimationUtils.loadAnimation(Stub_Interstitial_Video_Landscape_Activity.this, R.anim.tapad_dync_in_from_right));
                }
            }
        }

        @Override // com.tapsdk.tapad.InterstitialPresenter.c
        public void b(long j) {
            Stub_Interstitial_Video_Landscape_Activity.this.updateCountDownTime();
            Stub_Interstitial_Video_Landscape_Activity.this.releaseMediaPlayer();
            if (Stub_Interstitial_Video_Landscape_Activity.this.bubbleView.getVisibility() == 0) {
                Stub_Interstitial_Video_Landscape_Activity.this.bubbleView.setVisibility(8);
                Activity activityA = com.tapsdk.tapad.internal.utils.a.a((Context) Stub_Interstitial_Video_Landscape_Activity.this);
                AdInfo adInfo = this.a;
                if (adInfo.isFirstPassiveTransfer) {
                    adInfo.isFirstPassiveTransfer = false;
                    Stub_Interstitial_Video_Landscape_Activity.this.rightBannerView.onInteractionButtonClick(activityA, 11);
                }
                AdInfo adInfo2 = this.a;
                if (adInfo2.isFirstPassiveTransfer) {
                    adInfo2.isFirstPassiveTransfer = false;
                    Stub_Interstitial_Video_Landscape_Activity.this.landscapeBannerView.onInteractionButtonClick(activityA, 11, false);
                }
            }
            Stub_Interstitial_Video_Landscape_Activity.this.finish();
        }

        @Override // com.tapsdk.tapad.InterstitialPresenter.c
        public void onError(int i, String str) {
        }
    }

    class l implements View.OnClickListener {
        l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Stub_Interstitial_Video_Landscape_Activity.this.volumeState == 0) {
                Stub_Interstitial_Video_Landscape_Activity.this.volumeState = 1;
                Stub_Interstitial_Video_Landscape_Activity.this.openVolume();
            } else {
                Stub_Interstitial_Video_Landscape_Activity.this.volumeState = 0;
                Stub_Interstitial_Video_Landscape_Activity.this.closeVolume();
            }
            Stub_Interstitial_Video_Landscape_Activity.this.updateVolumeImage();
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
            TapADLogger.d("surfaceCreated");
            if (Stub_Interstitial_Video_Landscape_Activity.this.mediaPlayer != null) {
                Stub_Interstitial_Video_Landscape_Activity.this.mediaPlayer.setDisplay(surfaceHolder);
                if (Stub_Interstitial_Video_Landscape_Activity.this.mediaPlayer.isPlaying()) {
                    return;
                }
                TapADLogger.d("surfaceCreated inner");
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        }
    }

    class n implements MediaPlayer.OnPreparedListener {
        final /* synthetic */ AdInfo a;

        class a extends AnimatorListenerAdapter {
            a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                Stub_Interstitial_Video_Landscape_Activity.this.coverImageView.setVisibility(8);
            }
        }

        class b implements MediaPlayer.OnCompletionListener {
            b() {
            }

            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
            }
        }

        n(AdInfo adInfo) {
            this.a = adInfo;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            TapADLogger.d("mediaPlayer OnPreparedListener");
            Stub_Interstitial_Video_Landscape_Activity.this.isMediaReady = true;
            Stub_Interstitial_Video_Landscape_Activity.this.resumeMedia();
            Stub_Interstitial_Video_Landscape_Activity.this.openVolume();
            Stub_Interstitial_Video_Landscape_Activity.this.surfaceView.setVisibility(0);
            com.tapsdk.tapad.internal.tracker.c cVarA = com.tapsdk.tapad.internal.tracker.c.a();
            AdInfo adInfo = this.a;
            cVarA.a(adInfo.videoViewMonitorUrls, (Map<String, String>) null, adInfo.getVideoViewMonitorHeaderListWrapper());
            Stub_Interstitial_Video_Landscape_Activity.this.coverImageView.animate().alpha(0.0f).setDuration(500L).setListener(new a());
            Stub_Interstitial_Video_Landscape_Activity.this.mediaPlayer.setOnCompletionListener(new b());
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
            Stub_Interstitial_Video_Landscape_Activity.this.surfaceView.adjustSize(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeVolume() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(0.0f, 0.0f);
        }
    }

    private void configurationMediaPlayer(AdInfo adInfo) {
        try {
            this.mediaPlayer = new MediaPlayer();
            TapADLogger.d("ad video url:" + this.videoUri);
            this.mediaPlayer.reset();
            this.mediaPlayer.setDataSource(this, Uri.parse(this.videoUri));
            this.surfaceView.getHolder().addCallback(new m());
            this.mediaPlayer.prepareAsync();
            this.mediaPlayer.setOnPreparedListener(new n(adInfo));
            this.mediaPlayer.setOnVideoSizeChangedListener(new o());
            this.surfaceView.setOnClickListener(new a(adInfo));
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private void initDownloadPresenter(AdInfo adInfo) {
        this.downloadPresenter = new DownloadPresenter(this, new j(adInfo));
    }

    private void initRewardPresenter(int i2, AdInfo adInfo) {
        this.interstitialPresenter = new InterstitialPresenter(this, new k(adInfo), i2, adInfo);
    }

    private void initView() {
        LandscapeBannerView landscapeBannerView = (LandscapeBannerView) findViewById(R.id.landscapeBannerView);
        this.landscapeBannerView = landscapeBannerView;
        landscapeBannerView.findViewById(R.id.landscapeAdsRelativeLayout).setAlpha(0.95f);
        this.volumeImageView = (ImageView) findViewById(R.id.volumeImageView);
        this.coverImageView = (ImageView) findViewById(R.id.coverImageView);
        VideoSurfaceView videoSurfaceView = (VideoSurfaceView) findViewById(R.id.adsSurfaceView);
        this.surfaceView = videoSurfaceView;
        videoSurfaceView.setVisibility(4);
        this.horizontalRewardCompleteRelativeLayout = (RelativeLayout) findViewById(R.id.horizontalRewardCompleteRelativeLayout);
        this.horizontalCoverImageView = (ImageView) findViewById(R.id.horizontalCoverImageView);
        this.rightBannerView = (RightBannerView) findViewById(R.id.rightBannerView);
        this.mediaPlayerImageView = (ImageView) findViewById(R.id.mediaPlayerImageView);
        this.rewardSkipLinearLayout = (LinearLayout) findViewById(R.id.rewardSkipLinearLayout);
        this.countDownTextView = (TextView) findViewById(R.id.countDownTextView);
        this.skipDividerView = findViewById(R.id.skipDividerView);
        this.skipTextView = (TextView) findViewById(R.id.skipTextView);
        this.backgroundImageView = (ImageView) findViewById(R.id.backgroundImageView);
        this.bubbleView = (ViewGroup) findViewById(R.id.bubbleView);
        View viewFindViewById = findViewById(android.R.id.content);
        if (viewFindViewById == null || this.adInfo.tapADTrackerObject == null) {
            return;
        }
        com.tapsdk.tapad.internal.tracker.b bVar = new com.tapsdk.tapad.internal.tracker.b(viewFindViewById, new i());
        this.exposureHandler = bVar;
        bVar.a(this.adInfo.tapADTrackerObject.a);
    }

    private void initVolume() {
        this.volumeImageView.setOnClickListener(new l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openVolume() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(0.09f, 0.09f);
        }
    }

    private void pauseBannerView() {
        LandscapeBannerView landscapeBannerView = this.landscapeBannerView;
        if (landscapeBannerView != null) {
            landscapeBannerView.onPause();
        }
        RightBannerView rightBannerView = this.rightBannerView;
        if (rightBannerView != null) {
            rightBannerView.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pauseMedia() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.mediaPlayer.pause();
        }
        this.mediaPlayerImageView.setVisibility(this.mediaOpened ? 8 : 0);
        this.interstitialPresenter.a(new RewardPresenter.e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseMediaPlayer() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.mediaPlayer = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x003f  */
    /* JADX WARN: Code duplicated, block: B:32:0x0105  */
    /* JADX WARN: Code duplicated, block: B:34:? A[RETURN, SYNTHETIC] */
    private void renderAdLayout(AdInfo adInfo) {
        String str;
        List<VideoInfo> list;
        String strA;
        renderBanner(adInfo);
        this.horizontalRewardCompleteRelativeLayout.setVisibility(8);
        this.videoUri = "";
        String str2 = adInfo.cachedVideoUri;
        if (str2 == null || str2.length() <= 0) {
            List<VideoInfo> list2 = adInfo.materialInfo.videoInfoList;
            if (list2 != null && list2.size() > 0) {
                str = adInfo.materialInfo.videoInfoList.get(0).videoUrl;
            }
            if (this.videoUri.length() == 0) {
                TapADLogger.e("video info not corrected");
                finish();
            }
            list = adInfo.materialInfo.videoInfoList;
            if (list != null && list.size() > 0 && adInfo.materialInfo.videoInfoList.get(0).coverImage != null && adInfo.materialInfo.videoInfoList.get(0).coverImage.imageUrl != null) {
                Glide.with((Activity) this).load(adInfo.materialInfo.videoInfoList.get(0).coverImage.imageUrl).into(this.horizontalCoverImageView);
                Glide.with((Activity) this).load(adInfo.materialInfo.videoInfoList.get(0).coverImage.imageUrl).addListener(new c()).into(this.coverImageView);
                this.coverImageView.setAlpha(0.0f);
                this.coverImageView.animate().alpha(1.0f).setDuration(500L).setListener(new d());
            }
            configurationMediaPlayer(adInfo);
            updateCountDownTime();
            this.rewardSkipLinearLayout.setOnClickListener(new e(adInfo));
            strA = com.tapsdk.tapad.e.d.d().a();
            if (strA != null && strA.length() > 0) {
                Glide.with((Activity) this).load(strA).into(this.backgroundImageView);
            }
            if (com.tapsdk.tapad.internal.utils.c.a(adInfo.btnInteractionInfo)) {
                this.horizontalCoverImageView.setOnClickListener(new f());
            }
        }
        str = adInfo.cachedVideoUri;
        this.videoUri = str;
        if (this.videoUri.length() == 0) {
            TapADLogger.e("video info not corrected");
            finish();
        }
        list = adInfo.materialInfo.videoInfoList;
        if (list != null) {
            Glide.with((Activity) this).load(adInfo.materialInfo.videoInfoList.get(0).coverImage.imageUrl).into(this.horizontalCoverImageView);
            Glide.with((Activity) this).load(adInfo.materialInfo.videoInfoList.get(0).coverImage.imageUrl).addListener(new c()).into(this.coverImageView);
            this.coverImageView.setAlpha(0.0f);
            this.coverImageView.animate().alpha(1.0f).setDuration(500L).setListener(new d());
        }
        configurationMediaPlayer(adInfo);
        updateCountDownTime();
        this.rewardSkipLinearLayout.setOnClickListener(new e(adInfo));
        strA = com.tapsdk.tapad.e.d.d().a();
        if (strA != null) {
            Glide.with((Activity) this).load(strA).into(this.backgroundImageView);
        }
        if (com.tapsdk.tapad.internal.utils.c.a(adInfo.btnInteractionInfo)) {
            this.horizontalCoverImageView.setOnClickListener(new f());
        }
    }

    private void renderBanner(AdInfo adInfo) {
        this.landscapeBannerView.setVisibility(0);
        this.landscapeBannerView.render(this, adInfo, this.downloadPresenter, null, true);
        this.landscapeBannerView.setOutlineProvider(new b((int) ((getResources().getDisplayMetrics().density * 12.0f) + 0.5f)));
        this.landscapeBannerView.setClipToOutline(true);
        this.rightBannerView.render(this, adInfo, this.downloadPresenter, false);
    }

    private void resumeBannerView() {
        LandscapeBannerView landscapeBannerView = this.landscapeBannerView;
        if (landscapeBannerView != null && landscapeBannerView.getVisibility() == 0) {
            this.landscapeBannerView.updateInteractionLayout();
        }
        RightBannerView rightBannerView = this.rightBannerView;
        if (rightBannerView == null || rightBannerView.getVisibility() != 0) {
            return;
        }
        this.rightBannerView.updateInteractionLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resumeMedia() {
        MediaPlayer mediaPlayer;
        if (this.gotoComplete) {
            return;
        }
        if (this.isMediaReady && this.mediaOpened && (mediaPlayer = this.mediaPlayer) != null && !mediaPlayer.isPlaying()) {
            this.mediaPlayer.start();
            com.tapsdk.tapad.internal.tracker.b bVar = this.exposureHandler;
            if (bVar != null) {
                bVar.a();
            }
        }
        this.mediaPlayerImageView.setVisibility(this.mediaOpened ? 8 : 0);
        if (this.mediaOpened) {
            this.interstitialPresenter.a(new RewardPresenter.g());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCountDownTime() {
        String str = (String) this.interstitialPresenter.a().first;
        if (str == null || str.length() <= 0) {
            this.countDownTextView.setVisibility(8);
        } else {
            this.countDownTextView.setVisibility(0);
            this.countDownTextView.setText(str);
            if (this.bubbleView.getVisibility() == 0) {
                try {
                    ((TextView) this.bubbleView.findViewById(R.id.content)).setText(String.format("%s s%s", Integer.valueOf(str.substring(0, str.length() - 2)), this.bubbleContent));
                } catch (Exception unused) {
                }
            }
        }
        String str2 = (String) this.interstitialPresenter.a().second;
        if (str2 == null || str2.length() <= 0) {
            this.skipTextView.setVisibility(8);
        } else {
            this.skipTextView.setVisibility(0);
            this.skipTextView.setText(str2);
        }
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            this.skipDividerView.setVisibility(8);
        } else {
            this.skipDividerView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVolumeImage() {
        this.volumeImageView.setImageResource(this.volumeState == 1 ? R.drawable.tapad_ic_audio_open : R.drawable.tapad_ic_audio_mute);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        AppInfo appInfo;
        ExposureTrackerObject exposureTrackerObject;
        int i2;
        String str;
        super.onCreate(bundle);
        getWindow().addFlags(1152);
        setContentView(R.layout.tapad_activity_landscape);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            AdInfo adInfo = (AdInfo) extras.getParcelable("data");
            if (adInfo != null) {
                this.adInfo = adInfo;
                if (((AdRequest) extras.getParcelable("request")) != null) {
                    this.callbackId = extras.getInt("c_id", Integer.MIN_VALUE);
                    TapADLogger.d("output callback_Id:" + this.callbackId);
                    if (this.callbackId == Integer.MIN_VALUE) {
                        str = "Stub_Standard_Landscape_Activity 未传入callbackId";
                    } else if (adInfo.materialInfo.videoInfoList.isEmpty()) {
                        str = "Stub_Standard_Landscape_Activity 获取视频资源异常";
                    } else {
                        this.mediaOpened = true;
                        com.tapsdk.tapad.internal.e.a aVarA = com.tapsdk.tapad.internal.e.a(Integer.valueOf(this.callbackId));
                        this.rewardBridge = aVarA;
                        if (aVarA != null) {
                            initView();
                            initDownloadPresenter(adInfo);
                            initRewardPresenter(adInfo.interstitialAdKeepTime * 1000, adInfo);
                            initVolume();
                            renderAdLayout(adInfo);
                            resumeBannerView();
                            UninstalledAdInfo uninstalledAdInfoC = com.tapsdk.tapad.e.f.c();
                            if (uninstalledAdInfoC != null && ((i2 = uninstalledAdInfoC.adInfo.renderStyles.b) == 2 || i2 == 3)) {
                                this.downloadPresenter.a(new DownloadPresenter.k(uninstalledAdInfoC.adInfo));
                            }
                            this.surfaceView.postDelayed(new g(), 200L);
                            this.rewardBridge.onAdShow();
                            TapADTrackerObject tapADTrackerObject = adInfo.tapADTrackerObject;
                            if (tapADTrackerObject == null || (exposureTrackerObject = tapADTrackerObject.a) == null || !exposureTrackerObject.a) {
                                com.tapsdk.tapad.internal.tracker.c.a().a(adInfo.viewMonitorUrls, (Map<String, String>) null, adInfo.getViewMonitorHeaderListWrapper());
                            } else {
                                exposureTrackerObject.b((Map<String, String>) null);
                            }
                            this.bubbleContent = adInfo.bubbleContent;
                            InteractionInfo interactionInfo = adInfo.btnInteractionInfo;
                            if (interactionInfo != null) {
                                String strExtractWaitInteractionIconUrl = interactionInfo.extractWaitInteractionIconUrl();
                                if (TextUtils.isEmpty(strExtractWaitInteractionIconUrl) && (appInfo = adInfo.appInfo) != null) {
                                    strExtractWaitInteractionIconUrl = appInfo.appIconImage.imageUrl;
                                }
                                if (!TextUtils.isEmpty(strExtractWaitInteractionIconUrl)) {
                                    Glide.with((Activity) this).load(strExtractWaitInteractionIconUrl).into((ImageView) this.bubbleView.findViewById(R.id.icon_image));
                                }
                                String strExtractWaitInteractionDescription = adInfo.btnInteractionInfo.extractWaitInteractionDescription();
                                if (!TextUtils.isEmpty(strExtractWaitInteractionDescription)) {
                                    ((TextView) this.bubbleView.findViewById(R.id.description)).setText(strExtractWaitInteractionDescription);
                                }
                                this.bubbleView.findViewById(R.id.close_btn).setOnClickListener(new h());
                                return;
                            }
                            return;
                        }
                        str = "Stub_Standard_Landscape_Activity 获取rewardBridge异常";
                    }
                }
                finish();
            }
            TapADLogger.d("Stub_Standard_Landscape_Activity 未传入广告信息");
            finish();
        }
        str = "Stub_Standard_Landscape_Activity 未传入额外信息";
        TapADLogger.d(str);
        finish();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        com.tapsdk.tapad.internal.e.a aVar = this.rewardBridge;
        if (aVar != null) {
            aVar.onAdClose();
            this.rewardBridge = null;
        }
        releaseMediaPlayer();
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return i2 == 4;
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        pauseMedia();
        pauseBannerView();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        resumeMedia();
        resumeBannerView();
        com.tapsdk.tapad.internal.c.b().a(this, this.adInfo, true);
    }
}
