package com.tapsdk.tapad.stub.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
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
import com.tapsdk.tapad.R;
import com.tapsdk.tapad.TapAdManager;
import com.tapsdk.tapad.constants.Constants;
import com.tapsdk.tapad.internal.DownloadPresenter;
import com.tapsdk.tapad.internal.RewardPresenter;
import com.tapsdk.tapad.internal.tracker.ExposureTrackerObject;
import com.tapsdk.tapad.internal.tracker.TapADTrackerObject;
import com.tapsdk.tapad.internal.ui.views.banner.LandscapeBannerView;
import com.tapsdk.tapad.internal.ui.views.banner.RightBannerView;
import com.tapsdk.tapad.internal.ui.views.permissions.AdPermissionsDialogFragment;
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
public class Stub_Standard_Landscape_Activity extends Activity {
    private static final String EXTRA_PARAMS_AD_REQUEST = "request";
    private static final String EXTRA_PARAMS_CALLBACK_ID = "c_id";
    private static final String EXTRA_PARAMS_DATA = "data";
    private ImageView backgroundImageView;
    private ViewGroup bubbleView;
    private TextView countDownTextView;
    private ImageView coverImageView;
    private DownloadPresenter downloadPresenter;
    private ImageView horizontalCoverImageView;
    private RelativeLayout horizontalRewardCompleteRelativeLayout;
    private LandscapeBannerView landscapeBannerView;
    private MediaPlayer mediaPlayer;
    private ImageView mediaPlayerImageView;
    private com.tapsdk.tapad.internal.f.a rewardBridge;
    private RewardPresenter rewardPresenter;
    private LinearLayout rewardSkipLinearLayout;
    private RightBannerView rightBannerView;
    private View skipDividerView;
    private TextView skipTextView;
    private VideoSurfaceView surfaceView;
    private String videoUri;
    private ImageView volumeImageView;
    private int volumeState;
    private boolean mediaOpened = true;
    private boolean isMediaReady = false;
    private boolean gotoComplete = false;
    private boolean isAbortRewardUIShowed = false;
    int callbackId = Integer.MIN_VALUE;
    private AdInfo adInfo = null;
    private com.tapsdk.tapad.internal.tracker.b exposureHandler = null;
    private final com.tapsdk.tapad.internal.r.a rewardAdInnerBannerEventCallback = new j();

    class a implements MediaPlayer.OnVideoSizeChangedListener {
        a() {
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            if (mediaPlayer == null || mediaPlayer.getVideoWidth() <= 0 || mediaPlayer.getVideoHeight() <= 0) {
                return;
            }
            Stub_Standard_Landscape_Activity.this.surfaceView.adjustSize(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
        }
    }

    class b implements View.OnClickListener {
        final /* synthetic */ AdInfo a;

        b(AdInfo adInfo) {
            this.a = adInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Stub_Standard_Landscape_Activity.this.videoAndImageCanTransfer()) {
                TapADTrackerObject tapADTrackerObject = this.a.tapADTrackerObject;
                if (tapADTrackerObject != null) {
                    tapADTrackerObject.a(3, null);
                } else {
                    com.tapsdk.tapad.internal.tracker.c cVarA = com.tapsdk.tapad.internal.tracker.c.a();
                    AdInfo adInfo = this.a;
                    cVarA.a(adInfo.clickMonitorUrls, adInfo.viewInteractionInfo, adInfo.getClickMonitorHeaderListWrapper());
                }
                Stub_Standard_Landscape_Activity stub_Standard_Landscape_Activity = Stub_Standard_Landscape_Activity.this;
                com.tapsdk.tapad.internal.s.a.a((Activity) stub_Standard_Landscape_Activity, true, this.a, stub_Standard_Landscape_Activity.downloadPresenter);
                return;
            }
            if (Stub_Standard_Landscape_Activity.this.rewardPresenter.c().equals(RewardPresenter.RewardState.COMPLETE)) {
                return;
            }
            Stub_Standard_Landscape_Activity stub_Standard_Landscape_Activity2 = Stub_Standard_Landscape_Activity.this;
            stub_Standard_Landscape_Activity2.mediaOpened = true ^ stub_Standard_Landscape_Activity2.mediaOpened;
            if (Stub_Standard_Landscape_Activity.this.mediaOpened) {
                Stub_Standard_Landscape_Activity.this.resumeMedia();
            } else {
                Stub_Standard_Landscape_Activity.this.pauseMedia();
            }
        }
    }

    class c implements View.OnClickListener {
        final /* synthetic */ AdInfo a;

        c(AdInfo adInfo) {
            this.a = adInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Stub_Standard_Landscape_Activity.this.videoAndImageCanTransfer()) {
                TapADTrackerObject tapADTrackerObject = this.a.tapADTrackerObject;
                if (tapADTrackerObject != null) {
                    tapADTrackerObject.a(3, null);
                } else {
                    com.tapsdk.tapad.internal.tracker.c cVarA = com.tapsdk.tapad.internal.tracker.c.a();
                    AdInfo adInfo = this.a;
                    cVarA.a(adInfo.clickMonitorUrls, adInfo.viewInteractionInfo, adInfo.getClickMonitorHeaderListWrapper());
                }
                Stub_Standard_Landscape_Activity stub_Standard_Landscape_Activity = Stub_Standard_Landscape_Activity.this;
                com.tapsdk.tapad.internal.s.a.a((Activity) stub_Standard_Landscape_Activity, true, this.a, stub_Standard_Landscape_Activity.downloadPresenter);
            }
        }
    }

    class d extends ViewOutlineProvider {
        final /* synthetic */ int a;

        d(int i) {
            this.a = i;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.a);
        }
    }

    class e implements RequestListener<Drawable> {
        e() {
        }

        @Override // com.bumptech.glide.request.RequestListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
            Stub_Standard_Landscape_Activity.this.exposureHandler.b();
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
            return false;
        }
    }

    class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
        }
    }

    class g implements View.OnClickListener {
        final /* synthetic */ AdInfo a;

        g(AdInfo adInfo) {
            this.a = adInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AdInfo adInfo = this.a;
            if (adInfo.isFirstPassiveTransfer && adInfo.isCloseTransferEnable) {
                adInfo.isFirstPassiveTransfer = false;
                Stub_Standard_Landscape_Activity.this.bubbleView.setVisibility(8);
                Activity activityA = com.tapsdk.tapad.internal.utils.a.a(view.getContext());
                if (Stub_Standard_Landscape_Activity.this.rightBannerView != null) {
                    Stub_Standard_Landscape_Activity.this.rightBannerView.onInteractionButtonClick(activityA, 10);
                }
                if (Stub_Standard_Landscape_Activity.this.landscapeBannerView != null) {
                    Stub_Standard_Landscape_Activity.this.landscapeBannerView.onInteractionButtonClick(activityA, 10, false);
                }
                Stub_Standard_Landscape_Activity.this.exposeAdClick(10);
                return;
            }
            if (this.a.renderStyles.a == 0) {
                if (Stub_Standard_Landscape_Activity.this.rewardPresenter.c() != RewardPresenter.RewardState.COMPLETE) {
                    if (Stub_Standard_Landscape_Activity.this.rewardPresenter.c() != RewardPresenter.RewardState.SKIPPABLE) {
                        if (Stub_Standard_Landscape_Activity.this.rewardPresenter.c() != RewardPresenter.RewardState.END) {
                            return;
                        }
                        Stub_Standard_Landscape_Activity.this.finish();
                        return;
                    } else {
                        Stub_Standard_Landscape_Activity.this.rewardPresenter.d();
                        Stub_Standard_Landscape_Activity.this.gotoComplete = true;
                        if (Stub_Standard_Landscape_Activity.this.rewardBridge == null) {
                            return;
                        }
                        Stub_Standard_Landscape_Activity.this.rewardBridge.onSkippedVideo();
                        return;
                    }
                }
                Stub_Standard_Landscape_Activity.this.rewardPresenter.e();
            }
            if (Stub_Standard_Landscape_Activity.this.rewardPresenter.c() != RewardPresenter.RewardState.COMPLETE) {
                if (Stub_Standard_Landscape_Activity.this.rewardPresenter.c() == RewardPresenter.RewardState.SKIPPABLE) {
                    Stub_Standard_Landscape_Activity.this.showAbortRewardDialog();
                    return;
                }
                if (Stub_Standard_Landscape_Activity.this.rewardPresenter.c() != RewardPresenter.RewardState.SKIPPABLE_REWARDED) {
                    if (Stub_Standard_Landscape_Activity.this.rewardPresenter.c() != RewardPresenter.RewardState.END) {
                        return;
                    }
                    Stub_Standard_Landscape_Activity.this.finish();
                    return;
                } else {
                    Stub_Standard_Landscape_Activity.this.rewardPresenter.d();
                    Stub_Standard_Landscape_Activity.this.gotoComplete = true;
                    if (Stub_Standard_Landscape_Activity.this.rewardBridge == null) {
                        return;
                    }
                    Stub_Standard_Landscape_Activity.this.rewardBridge.onSkippedVideo();
                    return;
                }
            }
            Stub_Standard_Landscape_Activity.this.rewardPresenter.e();
        }
    }

    class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity activityA = com.tapsdk.tapad.internal.utils.a.a(view.getContext());
            if (Stub_Standard_Landscape_Activity.this.rightBannerView != null) {
                Stub_Standard_Landscape_Activity.this.rightBannerView.onInteractionButtonClick(activityA, 1);
            }
            if (Stub_Standard_Landscape_Activity.this.landscapeBannerView != null) {
                Stub_Standard_Landscape_Activity.this.landscapeBannerView.onInteractionButtonClick(activityA, 1, false);
            }
            Stub_Standard_Landscape_Activity.this.exposeAdClick(1);
        }
    }

    class i implements com.tapsdk.tapad.internal.r.b.a.d {
        i() {
        }

        @Override // com.tapsdk.tapad.internal.r.b.a.d
        public void a() {
            Stub_Standard_Landscape_Activity.this.finish();
        }

        @Override // com.tapsdk.tapad.internal.r.b.a.d
        public void b() {
            Stub_Standard_Landscape_Activity.this.onAbortRewardDialogDismiss();
        }
    }

    class j implements com.tapsdk.tapad.internal.r.a {
        j() {
        }

        @Override // com.tapsdk.tapad.internal.r.a
        public void a(int i) {
            Stub_Standard_Landscape_Activity.this.exposeAdClick(i);
        }
    }

    class k implements Runnable {
        k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tapsdk.tapad.internal.utils.j.c(Stub_Standard_Landscape_Activity.this.getWindow());
        }
    }

    class l implements View.OnClickListener {
        l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Stub_Standard_Landscape_Activity.this.bubbleView.setVisibility(8);
        }
    }

    class m implements com.tapsdk.tapad.internal.tracker.b.InterfaceC0634b {
        m() {
        }

        @Override // com.tapsdk.tapad.internal.tracker.b.InterfaceC0634b
        public void a() {
            if (Stub_Standard_Landscape_Activity.this.rewardBridge != null) {
                Stub_Standard_Landscape_Activity.this.rewardBridge.onAdValidShow();
            }
        }
    }

    class n implements DownloadPresenter.h {
        final /* synthetic */ AdInfo a;

        n(AdInfo adInfo) {
            this.a = adInfo;
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void a() {
            Stub_Standard_Landscape_Activity.this.landscapeBannerView.updateInteractionLayout();
            Stub_Standard_Landscape_Activity.this.rightBannerView.updateInteractionLayout();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void a(int i) {
            TapADLogger.d("updateDownloadProgress:" + i);
            Stub_Standard_Landscape_Activity.this.landscapeBannerView.updateInteractionLayout();
            Stub_Standard_Landscape_Activity.this.rightBannerView.updateInteractionLayout();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void b() {
            Stub_Standard_Landscape_Activity.this.landscapeBannerView.updateInteractionLayout();
            Stub_Standard_Landscape_Activity.this.rightBannerView.updateInteractionLayout();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void c() {
            Stub_Standard_Landscape_Activity.this.landscapeBannerView.updateInteractionLayout();
            Stub_Standard_Landscape_Activity.this.rightBannerView.updateInteractionLayout();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void d() {
            Stub_Standard_Landscape_Activity.this.landscapeBannerView.updateInteractionLayout();
            Stub_Standard_Landscape_Activity.this.rightBannerView.updateInteractionLayout();
            Stub_Standard_Landscape_Activity.this.downloadPresenter.a(new DownloadPresenter.k(this.a));
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void e() {
            TapADLogger.d("downloadError");
            Stub_Standard_Landscape_Activity.this.landscapeBannerView.updateInteractionLayout();
            Stub_Standard_Landscape_Activity.this.rightBannerView.updateInteractionLayout();
        }
    }

    class o implements RewardPresenter.d {
        final /* synthetic */ AdInfo a;
        final /* synthetic */ AdRequest b;

        o(AdInfo adInfo, AdRequest adRequest) {
            this.a = adInfo;
            this.b = adRequest;
        }

        @Override // com.tapsdk.tapad.internal.RewardPresenter.d
        public void a() {
            if (Stub_Standard_Landscape_Activity.this.rewardBridge != null) {
                Stub_Standard_Landscape_Activity.this.rewardBridge.onVideoComplete();
            }
        }

        @Override // com.tapsdk.tapad.internal.RewardPresenter.d
        public void a(long j) {
            Stub_Standard_Landscape_Activity.this.updateCountDownTime();
            if (Stub_Standard_Landscape_Activity.this.bubbleView.getVisibility() == 8) {
                long j2 = j / 1000;
                AdInfo adInfo = this.a;
                if (j2 == adInfo.bubbleWaitTime && adInfo.isFirstPassiveTransfer && adInfo.isAutoWaitTransferEnable) {
                    Stub_Standard_Landscape_Activity.this.bubbleView.setVisibility(0);
                    Stub_Standard_Landscape_Activity.this.bubbleView.setAnimation(AnimationUtils.loadAnimation(Stub_Standard_Landscape_Activity.this, R.anim.tapad_dync_in_from_right));
                }
            }
            if (Stub_Standard_Landscape_Activity.this.bubbleView.getVisibility() == 0) {
                ((TextView) Stub_Standard_Landscape_Activity.this.bubbleView.findViewById(R.id.content)).setText(String.format("%d s%s", Long.valueOf(j / 1000), this.a.bubbleContent));
            }
        }

        @Override // com.tapsdk.tapad.internal.RewardPresenter.d
        public void b() {
            if (Stub_Standard_Landscape_Activity.this.rewardBridge != null) {
                com.tapsdk.tapad.internal.f.a aVar = Stub_Standard_Landscape_Activity.this.rewardBridge;
                AdRequest adRequest = this.b;
                aVar.onRewardVerify(true, adRequest.rewardAmount, adRequest.rewardName, 0, "");
            }
        }

        @Override // com.tapsdk.tapad.internal.RewardPresenter.d
        public void b(long j) {
            Stub_Standard_Landscape_Activity.this.updateCountDownTime();
        }

        /* JADX WARN: Code duplicated, block: B:15:0x005b  */
        /* JADX WARN: Code duplicated, block: B:9:0x0040  */
        @Override // com.tapsdk.tapad.internal.RewardPresenter.d
        public void c() {
            boolean z;
            Stub_Standard_Landscape_Activity.this.updateCountDownTime();
            Stub_Standard_Landscape_Activity.this.releaseMediaPlayer();
            if (Stub_Standard_Landscape_Activity.this.bubbleView.getVisibility() == 0) {
                Stub_Standard_Landscape_Activity.this.bubbleView.setVisibility(8);
                Stub_Standard_Landscape_Activity stub_Standard_Landscape_Activity = Stub_Standard_Landscape_Activity.this;
                boolean z2 = true;
                if (stub_Standard_Landscape_Activity.rightBannerView != null) {
                    AdInfo adInfo = this.a;
                    if (adInfo.isFirstPassiveTransfer) {
                        adInfo.isFirstPassiveTransfer = false;
                        Stub_Standard_Landscape_Activity.this.rightBannerView.onInteractionButtonClick(stub_Standard_Landscape_Activity, 11);
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                }
                if (Stub_Standard_Landscape_Activity.this.landscapeBannerView != null) {
                    AdInfo adInfo2 = this.a;
                    if (adInfo2.isFirstPassiveTransfer) {
                        adInfo2.isFirstPassiveTransfer = false;
                        Stub_Standard_Landscape_Activity.this.landscapeBannerView.onInteractionButtonClick(stub_Standard_Landscape_Activity, 11, false);
                    } else {
                        z2 = z;
                    }
                } else {
                    z2 = z;
                }
                if (z2) {
                    Stub_Standard_Landscape_Activity.this.exposeAdClick(11);
                }
            }
            Stub_Standard_Landscape_Activity.this.landscapeBannerView.setVisibility(8);
            Stub_Standard_Landscape_Activity.this.horizontalRewardCompleteRelativeLayout.setVisibility(0);
            Stub_Standard_Landscape_Activity.this.volumeImageView.setVisibility(8);
            Stub_Standard_Landscape_Activity.this.landscapeBannerView.updateInteractionLayout();
            Stub_Standard_Landscape_Activity.this.rightBannerView.setVisibility(0);
            Stub_Standard_Landscape_Activity.this.rightBannerView.updateInteractionLayout();
            Stub_Standard_Landscape_Activity.this.rightBannerView.startTags(this.a.highlightTags);
            Stub_Standard_Landscape_Activity.this.resumeBannerView();
        }

        @Override // com.tapsdk.tapad.internal.RewardPresenter.d
        public void d() {
            Stub_Standard_Landscape_Activity.this.updateCountDownTime();
        }

        @Override // com.tapsdk.tapad.internal.RewardPresenter.d
        public void onError(int i, String str) {
        }
    }

    class p implements View.OnClickListener {
        p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Stub_Standard_Landscape_Activity.this.changeVolumeState();
            Stub_Standard_Landscape_Activity.this.switchVolume();
            Stub_Standard_Landscape_Activity.this.updateVolumeImage();
        }
    }

    class q implements SurfaceHolder.Callback {
        q() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            TapADLogger.d("surfaceCreated");
            if (Stub_Standard_Landscape_Activity.this.mediaPlayer != null) {
                Stub_Standard_Landscape_Activity.this.mediaPlayer.setDisplay(surfaceHolder);
                if (Stub_Standard_Landscape_Activity.this.mediaPlayer.isPlaying()) {
                    return;
                }
                TapADLogger.d("surfaceCreated inner");
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        }
    }

    class r implements MediaPlayer.OnPreparedListener {
        final /* synthetic */ AdInfo a;

        class a extends AnimatorListenerAdapter {
            a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                Stub_Standard_Landscape_Activity.this.coverImageView.setVisibility(8);
            }
        }

        class b implements MediaPlayer.OnCompletionListener {
            b() {
            }

            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
            }
        }

        r(AdInfo adInfo) {
            this.a = adInfo;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            TapADLogger.d("mediaPlayer OnPreparedListener");
            Stub_Standard_Landscape_Activity.this.isMediaReady = true;
            Stub_Standard_Landscape_Activity.this.resumeMedia();
            Stub_Standard_Landscape_Activity.this.switchVolume();
            Stub_Standard_Landscape_Activity.this.updateVolumeImage();
            Stub_Standard_Landscape_Activity.this.surfaceView.setVisibility(0);
            com.tapsdk.tapad.internal.tracker.c cVarA = com.tapsdk.tapad.internal.tracker.c.a();
            AdInfo adInfo = this.a;
            cVarA.a(adInfo.videoViewMonitorUrls, (Map<String, String>) null, adInfo.getVideoViewMonitorHeaderListWrapper());
            Stub_Standard_Landscape_Activity.this.coverImageView.animate().alpha(0.0f).setDuration(500L).setListener(new a());
            Stub_Standard_Landscape_Activity.this.mediaPlayer.setOnCompletionListener(new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeVolumeState() {
        this.volumeState = this.volumeState == 0 ? 1 : 0;
    }

    private void closeVolume() {
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
            if (getEnableCustomPlayTimeController()) {
                this.mediaPlayer.setLooping(true);
            }
            this.surfaceView.getHolder().addCallback(new q());
            this.mediaPlayer.prepareAsync();
            this.mediaPlayer.setOnPreparedListener(new r(adInfo));
            this.mediaPlayer.setOnVideoSizeChangedListener(new a());
            this.surfaceView.setOnClickListener(new b(adInfo));
            this.coverImageView.setOnClickListener(new c(adInfo));
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private int customControllerLeftTime(int i2) {
        int iCeil;
        return (i2 < 30 && (iCeil = (int) Math.ceil((double) (30.0f / ((float) i2)))) > 0) ? i2 * iCeil : i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void exposeAdClick(int i2) {
        if (this.rewardBridge != null) {
            TapADLogger.d("onAdClick:" + i2);
            this.rewardBridge.onAdClick();
        }
    }

    private boolean getEnableCustomPlayTimeController() {
        return ((Integer) com.tapsdk.tapad.internal.k.a.a(Constants.f.c, Integer.class, -1)).intValue() == 1;
    }

    private void initDownloadPresenter(AdInfo adInfo) {
        this.downloadPresenter = new DownloadPresenter(this, new n(adInfo));
    }

    private void initRewardPresenter(int i2, AdRequest adRequest, AdInfo adInfo) {
        if (getEnableCustomPlayTimeController()) {
            i2 = customControllerLeftTime(i2);
        }
        this.rewardPresenter = new RewardPresenter(this, new o(adInfo, adRequest), i2, adRequest, adInfo, TapAdManager.get().tapAdConfig);
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
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.bubbleView);
        this.bubbleView = viewGroup;
        viewGroup.findViewById(R.id.close_btn).setOnClickListener(new l());
        View viewFindViewById = findViewById(android.R.id.content);
        if (viewFindViewById != null) {
            com.tapsdk.tapad.internal.tracker.b bVar = new com.tapsdk.tapad.internal.tracker.b(viewFindViewById, new m());
            this.exposureHandler = bVar;
            bVar.a(this.adInfo.tapADTrackerObject.a);
        }
    }

    private void initVolume(AdInfo adInfo) {
        List<VideoInfo> list = adInfo.materialInfo.videoInfoList;
        if (list != null && list.size() > 0) {
            if (adInfo.materialInfo.videoInfoList.get(0).volumeDefaultState == Constants.s.a) {
                this.volumeState = 1;
            } else {
                this.volumeState = 0;
            }
        }
        updateVolumeImage();
        this.volumeImageView.setOnClickListener(new p());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAbortRewardDialogDismiss() {
        this.isAbortRewardUIShowed = false;
        if (this.isMediaReady) {
            this.mediaOpened = true;
        }
        resumeMedia();
    }

    private void openVolume() {
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
        this.rewardPresenter.a(new RewardPresenter.e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseMediaPlayer() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.mediaPlayer = null;
        }
    }

    private void renderAdLayout(AdInfo adInfo) {
        renderBanner(adInfo);
        this.horizontalRewardCompleteRelativeLayout.setVisibility(8);
        this.rightBannerView.setVisibility(8);
        resumeBannerView();
        this.videoUri = "";
        String str = adInfo.cachedVideoUri;
        if (str == null || str.length() <= 0) {
            List<VideoInfo> list = adInfo.materialInfo.videoInfoList;
            if (list != null && list.size() > 0) {
                this.videoUri = adInfo.materialInfo.videoInfoList.get(0).videoUrl;
                TapADLogger.d("videoUrl:" + this.videoUri);
            }
        } else {
            this.videoUri = adInfo.cachedVideoUri;
        }
        List<VideoInfo> list2 = adInfo.materialInfo.videoInfoList;
        if (list2 != null && list2.size() > 0 && adInfo.materialInfo.videoInfoList.get(0).coverImage != null && adInfo.materialInfo.videoInfoList.get(0).coverImage.imageUrl != null) {
            TapADLogger.d("cover image:" + adInfo.materialInfo.videoInfoList.get(0).coverImage.imageUrl);
            Glide.with((Activity) this).load(adInfo.materialInfo.videoInfoList.get(0).coverImage.imageUrl).into(this.horizontalCoverImageView);
            Glide.with((Activity) this).load(adInfo.materialInfo.videoInfoList.get(0).coverImage.imageUrl).addListener(new e()).into(this.coverImageView);
            this.coverImageView.setAlpha(0.0f);
            this.coverImageView.animate().alpha(1.0f).setDuration(500L).setListener(new f());
        }
        configurationMediaPlayer(adInfo);
        updateCountDownTime();
        this.rewardSkipLinearLayout.setOnClickListener(new g(adInfo));
        String strA = com.tapsdk.tapad.e.d.d().a();
        if (strA != null && strA.length() > 0) {
            Glide.with((Activity) this).load(strA).into(this.backgroundImageView);
        }
        if (com.tapsdk.tapad.internal.utils.c.a(adInfo.btnInteractionInfo)) {
            this.horizontalCoverImageView.setOnClickListener(new h());
        }
    }

    private void renderBanner(AdInfo adInfo) {
        this.landscapeBannerView.setVisibility(0);
        this.landscapeBannerView.render(this, adInfo, this.downloadPresenter, null, true, this.rewardAdInnerBannerEventCallback);
        this.landscapeBannerView.setOutlineProvider(new d((int) ((getResources().getDisplayMetrics().density * 12.0f) + 0.5f)));
        this.landscapeBannerView.setClipToOutline(true);
        this.rightBannerView.render(this, adInfo, this.downloadPresenter, true, this.rewardAdInnerBannerEventCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resumeBannerView() {
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
        if (this.gotoComplete || this.isAbortRewardUIShowed) {
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
            this.rewardPresenter.a(new RewardPresenter.g());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAbortRewardDialog() {
        this.isAbortRewardUIShowed = true;
        pauseMedia();
        try {
            com.tapsdk.tapad.internal.r.b.a.a(this.rewardPresenter.b(), new i()).show(getFragmentManager(), AdPermissionsDialogFragment.TAG);
        } catch (Exception unused) {
        }
    }

    private void showApkOpenDialog() {
        AppInfo appInfo;
        String str;
        AdInfo adInfo = this.adInfo;
        if (adInfo == null || (appInfo = adInfo.appInfo) == null || (str = appInfo.packageName) == null || !com.tapsdk.tapad.internal.utils.b.a(this, str)) {
            return;
        }
        com.tapsdk.tapad.internal.c.b().a(this, this.adInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchVolume() {
        if (this.volumeState == 1) {
            openVolume();
        } else {
            closeVolume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCountDownTime() {
        String str = (String) this.rewardPresenter.a().first;
        if (str == null || str.length() <= 0) {
            this.countDownTextView.setVisibility(8);
        } else {
            this.countDownTextView.setVisibility(0);
            this.countDownTextView.setText(str);
        }
        String str2 = (String) this.rewardPresenter.a().second;
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

    /* JADX INFO: Access modifiers changed from: private */
    public boolean videoAndImageCanTransfer() {
        AdInfo adInfo = this.adInfo;
        if (adInfo == null || adInfo.viewInteractionInfo == null) {
            return false;
        }
        return adInfo.videoAndImageCanTransfer();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
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
                AdRequest adRequest = (AdRequest) extras.getParcelable("request");
                if (adRequest != null) {
                    this.callbackId = extras.getInt("c_id", Integer.MIN_VALUE);
                    TapADLogger.d("output callback_Id:" + this.callbackId);
                    int i3 = this.callbackId;
                    if (i3 == Integer.MIN_VALUE) {
                        str = "Stub_Standard_Landscape_Activity 未传入callbackId";
                    } else {
                        this.mediaOpened = true;
                        com.tapsdk.tapad.internal.f.a aVarA = com.tapsdk.tapad.internal.f.a(Integer.valueOf(i3));
                        this.rewardBridge = aVarA;
                        if (aVarA == null) {
                            str = "Stub_Standard_Landscape_Activity 获取rewardBridge异常";
                        } else {
                            if (adInfo.materialInfo.videoInfoList.size() != 0) {
                                initView();
                                initDownloadPresenter(adInfo);
                                initRewardPresenter((adInfo.materialInfo.videoInfoList.get(0).duration * 1000) + 1000, adRequest, adInfo);
                                initVolume(adInfo);
                                renderAdLayout(adInfo);
                                UninstalledAdInfo uninstalledAdInfoC = com.tapsdk.tapad.e.f.c();
                                if (uninstalledAdInfoC != null && ((i2 = uninstalledAdInfoC.adInfo.renderStyles.b) == 2 || i2 == 3)) {
                                    this.downloadPresenter.a(new DownloadPresenter.k(uninstalledAdInfoC.adInfo));
                                }
                                this.surfaceView.postDelayed(new k(), 200L);
                                this.rewardBridge.onAdShow();
                                TapADTrackerObject tapADTrackerObject = adInfo.tapADTrackerObject;
                                if (tapADTrackerObject == null || (exposureTrackerObject = tapADTrackerObject.a) == null || !exposureTrackerObject.a) {
                                    com.tapsdk.tapad.internal.tracker.c.a().a(adInfo.viewMonitorUrls, (Map<String, String>) null, adInfo.getViewMonitorHeaderListWrapper());
                                } else {
                                    exposureTrackerObject.b((Map<String, String>) null);
                                }
                                InteractionInfo interactionInfo = adInfo.btnInteractionInfo;
                                if (interactionInfo != null) {
                                    String strExtractWaitInteractionIconUrl = interactionInfo.extractWaitInteractionIconUrl();
                                    if (TextUtils.isEmpty(strExtractWaitInteractionIconUrl)) {
                                        strExtractWaitInteractionIconUrl = adInfo.appInfo.appIconImage.imageUrl;
                                    }
                                    if (!TextUtils.isEmpty(strExtractWaitInteractionIconUrl)) {
                                        Glide.with((Activity) this).load(strExtractWaitInteractionIconUrl).into((ImageView) this.bubbleView.findViewById(R.id.icon_image));
                                    }
                                    String strExtractWaitInteractionDescription = adInfo.btnInteractionInfo.extractWaitInteractionDescription();
                                    if (TextUtils.isEmpty(strExtractWaitInteractionDescription)) {
                                        return;
                                    }
                                    ((TextView) this.bubbleView.findViewById(R.id.description)).setText(strExtractWaitInteractionDescription);
                                    return;
                                }
                                return;
                            }
                            str = "Stub_Standard_Landscape_Activity 获取视频资源异常";
                        }
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
        com.tapsdk.tapad.internal.f.a aVar = this.rewardBridge;
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
        RightBannerView rightBannerView = this.rightBannerView;
        if (rightBannerView != null) {
            rightBannerView.updateInteractionLayout();
        }
        LandscapeBannerView landscapeBannerView = this.landscapeBannerView;
        if (landscapeBannerView != null) {
            landscapeBannerView.updateInteractionLayout();
        }
        showApkOpenDialog();
    }
}
