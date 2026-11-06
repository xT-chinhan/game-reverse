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
import com.tapsdk.tapad.internal.ui.views.banner.BottomBannerView;
import com.tapsdk.tapad.internal.ui.views.banner.PortraitBannerView;
import com.tapsdk.tapad.internal.ui.views.banner.PortraitBannerWithoutTagView;
import com.tapsdk.tapad.internal.ui.views.permissions.AdPermissionsDialogFragment;
import com.tapsdk.tapad.internal.ui.views.video.VideoSurfaceView;
import com.tapsdk.tapad.internal.utils.TapADLogger;
import com.tapsdk.tapad.model.entities.AdInfo;
import com.tapsdk.tapad.model.entities.AppInfo;
import com.tapsdk.tapad.model.entities.InteractionInfo;
import com.tapsdk.tapad.model.entities.RenderStyles;
import com.tapsdk.tapad.model.entities.UninstalledAdInfo;
import com.tapsdk.tapad.model.entities.VideoInfo;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class Stub_Standard_Portrait_Activity extends Activity {
    private static final String EXTRA_PARAMS_AD_REQUEST = "request";
    private static final String EXTRA_PARAMS_CALLBACK_ID = "c_id";
    private static final String EXTRA_PARAMS_DATA = "data";
    private ImageView backgroundImageView;
    private BottomBannerView bottomBannerView;
    private ViewGroup bubbleView;
    private TextView countDownTextView;
    private ImageView coverImageView;
    private DownloadPresenter downloadPresenter;
    private com.tapsdk.tapad.internal.tracker.b exposureHandler;
    private MediaPlayer mediaPlayer;
    private ImageView mediaPlayerImageView;
    private PortraitBannerView portraitBannerView;
    private PortraitBannerWithoutTagView portraitBannerWithoutTagView;
    private com.tapsdk.tapad.internal.f.a rewardBridge;
    private RewardPresenter rewardPresenter;
    private LinearLayout rewardSkipLinearLayout;
    private View skipDividerView;
    private TextView skipTextView;
    private VideoSurfaceView surfaceView;
    private ImageView verticalCoverImageView;
    private RelativeLayout verticalRewardCompleteRelativeLayout;
    private String videoUri;
    private ImageView volumeImageView;
    private int volumeState = 0;
    private boolean mediaOpened = true;
    private boolean isMediaReady = false;
    private boolean gotoComplete = false;
    private boolean isAbortRewardUIShowed = false;
    private int callbackId = Integer.MIN_VALUE;
    private final com.tapsdk.tapad.internal.r.a rewardAdInnerBannerEventCallback = new k();
    AdInfo adInfo = null;

    class a implements MediaPlayer.OnVideoSizeChangedListener {
        a() {
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            if (mediaPlayer == null || mediaPlayer.getVideoWidth() <= 0 || mediaPlayer.getVideoHeight() <= 0) {
                return;
            }
            Stub_Standard_Portrait_Activity.this.surfaceView.adjustSize(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
        }
    }

    class b implements View.OnClickListener {
        final /* synthetic */ AdInfo a;

        b(AdInfo adInfo) {
            this.a = adInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Stub_Standard_Portrait_Activity.this.videoAndImageCanTransfer()) {
                TapADTrackerObject tapADTrackerObject = this.a.tapADTrackerObject;
                if (tapADTrackerObject != null) {
                    tapADTrackerObject.a(3, null);
                } else {
                    com.tapsdk.tapad.internal.tracker.c cVarA = com.tapsdk.tapad.internal.tracker.c.a();
                    AdInfo adInfo = this.a;
                    cVarA.a(adInfo.clickMonitorUrls, adInfo.viewInteractionInfo, adInfo.getClickMonitorHeaderListWrapper());
                }
                Stub_Standard_Portrait_Activity stub_Standard_Portrait_Activity = Stub_Standard_Portrait_Activity.this;
                com.tapsdk.tapad.internal.s.a.a((Activity) stub_Standard_Portrait_Activity, true, this.a, stub_Standard_Portrait_Activity.downloadPresenter);
                return;
            }
            if (Stub_Standard_Portrait_Activity.this.rewardPresenter.c().equals(RewardPresenter.RewardState.COMPLETE) || Stub_Standard_Portrait_Activity.this.rewardPresenter.c().equals(RewardPresenter.RewardState.END)) {
                return;
            }
            Stub_Standard_Portrait_Activity stub_Standard_Portrait_Activity2 = Stub_Standard_Portrait_Activity.this;
            stub_Standard_Portrait_Activity2.mediaOpened = true ^ stub_Standard_Portrait_Activity2.mediaOpened;
            if (Stub_Standard_Portrait_Activity.this.mediaOpened) {
                Stub_Standard_Portrait_Activity.this.resumeMedia();
            } else {
                Stub_Standard_Portrait_Activity.this.pauseMedia();
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
            if (Stub_Standard_Portrait_Activity.this.videoAndImageCanTransfer()) {
                TapADTrackerObject tapADTrackerObject = this.a.tapADTrackerObject;
                if (tapADTrackerObject != null) {
                    tapADTrackerObject.a(3, null);
                } else {
                    com.tapsdk.tapad.internal.tracker.c cVarA = com.tapsdk.tapad.internal.tracker.c.a();
                    AdInfo adInfo = this.a;
                    cVarA.a(adInfo.clickMonitorUrls, adInfo.viewInteractionInfo, adInfo.getClickMonitorHeaderListWrapper());
                }
                Stub_Standard_Portrait_Activity stub_Standard_Portrait_Activity = Stub_Standard_Portrait_Activity.this;
                com.tapsdk.tapad.internal.s.a.a((Activity) stub_Standard_Portrait_Activity, true, this.a, stub_Standard_Portrait_Activity.downloadPresenter);
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

    class e extends ViewOutlineProvider {
        final /* synthetic */ int a;

        e(int i) {
            this.a = i;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.a);
        }
    }

    class f implements RequestListener<Drawable> {
        f() {
        }

        @Override // com.bumptech.glide.request.RequestListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
            Stub_Standard_Portrait_Activity.this.exposureHandler.b();
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
            return false;
        }
    }

    class g extends AnimatorListenerAdapter {
        g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
        }
    }

    class h implements View.OnClickListener {
        final /* synthetic */ AdInfo a;

        h(AdInfo adInfo) {
            this.a = adInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AdInfo adInfo = this.a;
            if (adInfo.isFirstPassiveTransfer && adInfo.isCloseTransferEnable) {
                adInfo.isFirstPassiveTransfer = false;
                Stub_Standard_Portrait_Activity.this.bubbleView.setVisibility(8);
                Activity activityA = com.tapsdk.tapad.internal.utils.a.a(view.getContext());
                if (Stub_Standard_Portrait_Activity.this.bottomBannerView != null) {
                    Stub_Standard_Portrait_Activity.this.bottomBannerView.onInteractionButtonClick(activityA, 10);
                }
                if (Stub_Standard_Portrait_Activity.this.portraitBannerView != null) {
                    Stub_Standard_Portrait_Activity.this.portraitBannerView.onInteractionButtonClick(activityA, 10, false);
                }
                if (Stub_Standard_Portrait_Activity.this.portraitBannerWithoutTagView != null) {
                    Stub_Standard_Portrait_Activity.this.portraitBannerWithoutTagView.onInteractionButtonClick(activityA, 10, false);
                }
                Stub_Standard_Portrait_Activity.this.exposeAdClick(10);
                return;
            }
            if (this.a.renderStyles.a == 0) {
                if (Stub_Standard_Portrait_Activity.this.rewardPresenter.c() != RewardPresenter.RewardState.COMPLETE) {
                    if (Stub_Standard_Portrait_Activity.this.rewardPresenter.c() != RewardPresenter.RewardState.SKIPPABLE) {
                        if (Stub_Standard_Portrait_Activity.this.rewardPresenter.c() != RewardPresenter.RewardState.END) {
                            return;
                        }
                        Stub_Standard_Portrait_Activity.this.finish();
                        return;
                    } else {
                        Stub_Standard_Portrait_Activity.this.rewardPresenter.d();
                        Stub_Standard_Portrait_Activity.this.gotoComplete = true;
                        if (Stub_Standard_Portrait_Activity.this.rewardBridge == null) {
                            return;
                        }
                        Stub_Standard_Portrait_Activity.this.rewardBridge.onSkippedVideo();
                        return;
                    }
                }
                Stub_Standard_Portrait_Activity.this.rewardPresenter.e();
            }
            if (Stub_Standard_Portrait_Activity.this.rewardPresenter.c() != RewardPresenter.RewardState.COMPLETE) {
                if (Stub_Standard_Portrait_Activity.this.rewardPresenter.c() == RewardPresenter.RewardState.SKIPPABLE) {
                    Stub_Standard_Portrait_Activity.this.showAbortRewardDialog();
                    return;
                }
                if (Stub_Standard_Portrait_Activity.this.rewardPresenter.c() != RewardPresenter.RewardState.SKIPPABLE_REWARDED) {
                    if (Stub_Standard_Portrait_Activity.this.rewardPresenter.c() != RewardPresenter.RewardState.END) {
                        return;
                    }
                    Stub_Standard_Portrait_Activity.this.finish();
                    return;
                } else {
                    Stub_Standard_Portrait_Activity.this.rewardPresenter.d();
                    Stub_Standard_Portrait_Activity.this.gotoComplete = true;
                    if (Stub_Standard_Portrait_Activity.this.rewardBridge == null) {
                        return;
                    }
                    Stub_Standard_Portrait_Activity.this.rewardBridge.onSkippedVideo();
                    return;
                }
            }
            Stub_Standard_Portrait_Activity.this.rewardPresenter.e();
        }
    }

    class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity activityA = com.tapsdk.tapad.internal.utils.a.a(view.getContext());
            if (Stub_Standard_Portrait_Activity.this.bottomBannerView != null) {
                Stub_Standard_Portrait_Activity.this.bottomBannerView.onInteractionButtonClick(activityA, 1);
            }
            if (Stub_Standard_Portrait_Activity.this.portraitBannerView != null) {
                Stub_Standard_Portrait_Activity.this.portraitBannerView.onInteractionButtonClick(activityA, 1, false);
            }
            if (Stub_Standard_Portrait_Activity.this.portraitBannerWithoutTagView != null) {
                Stub_Standard_Portrait_Activity.this.portraitBannerWithoutTagView.onInteractionButtonClick(activityA, 1, false);
            }
            Stub_Standard_Portrait_Activity.this.exposeAdClick(1);
        }
    }

    class j implements com.tapsdk.tapad.internal.r.b.a.d {
        j() {
        }

        @Override // com.tapsdk.tapad.internal.r.b.a.d
        public void a() {
            Stub_Standard_Portrait_Activity.this.finish();
        }

        @Override // com.tapsdk.tapad.internal.r.b.a.d
        public void b() {
            Stub_Standard_Portrait_Activity.this.onAbortRewardDialogDismiss();
        }
    }

    class k implements com.tapsdk.tapad.internal.r.a {
        k() {
        }

        @Override // com.tapsdk.tapad.internal.r.a
        public void a(int i) {
            Stub_Standard_Portrait_Activity.this.exposeAdClick(i);
        }
    }

    class l implements Runnable {
        l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tapsdk.tapad.internal.utils.j.c(Stub_Standard_Portrait_Activity.this.getWindow());
        }
    }

    class m implements View.OnClickListener {
        m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Stub_Standard_Portrait_Activity.this.bubbleView.setVisibility(8);
        }
    }

    class n implements com.tapsdk.tapad.internal.tracker.b.InterfaceC0634b {
        n() {
        }

        @Override // com.tapsdk.tapad.internal.tracker.b.InterfaceC0634b
        public void a() {
            if (Stub_Standard_Portrait_Activity.this.rewardBridge != null) {
                Stub_Standard_Portrait_Activity.this.rewardBridge.onAdValidShow();
            }
        }
    }

    class o implements DownloadPresenter.h {
        final /* synthetic */ AdInfo a;

        o(AdInfo adInfo) {
            this.a = adInfo;
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void a() {
            if (Stub_Standard_Portrait_Activity.this.portraitBannerView != null) {
                Stub_Standard_Portrait_Activity.this.portraitBannerView.updateInteractionLayout();
            } else if (Stub_Standard_Portrait_Activity.this.portraitBannerWithoutTagView != null) {
                Stub_Standard_Portrait_Activity.this.portraitBannerWithoutTagView.updateInteractionLayout();
            }
            Stub_Standard_Portrait_Activity.this.bottomBannerView.updateInteractionLayout();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void a(int i) {
            TapADLogger.d("updateDownloadProgress:" + i);
            if (Stub_Standard_Portrait_Activity.this.portraitBannerView != null) {
                Stub_Standard_Portrait_Activity.this.portraitBannerView.updateInteractionLayout();
            } else if (Stub_Standard_Portrait_Activity.this.portraitBannerWithoutTagView != null) {
                Stub_Standard_Portrait_Activity.this.portraitBannerWithoutTagView.updateInteractionLayout();
            }
            Stub_Standard_Portrait_Activity.this.bottomBannerView.updateInteractionLayout();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void b() {
            if (Stub_Standard_Portrait_Activity.this.portraitBannerView != null) {
                Stub_Standard_Portrait_Activity.this.portraitBannerView.updateInteractionLayout();
            } else if (Stub_Standard_Portrait_Activity.this.portraitBannerWithoutTagView != null) {
                Stub_Standard_Portrait_Activity.this.portraitBannerWithoutTagView.updateInteractionLayout();
            }
            Stub_Standard_Portrait_Activity.this.bottomBannerView.updateInteractionLayout();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void c() {
            if (Stub_Standard_Portrait_Activity.this.portraitBannerView != null) {
                Stub_Standard_Portrait_Activity.this.portraitBannerView.updateInteractionLayout();
            } else if (Stub_Standard_Portrait_Activity.this.portraitBannerWithoutTagView != null) {
                Stub_Standard_Portrait_Activity.this.portraitBannerWithoutTagView.updateInteractionLayout();
            }
            Stub_Standard_Portrait_Activity.this.bottomBannerView.updateInteractionLayout();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void d() {
            if (Stub_Standard_Portrait_Activity.this.portraitBannerView != null) {
                Stub_Standard_Portrait_Activity.this.portraitBannerView.updateInteractionLayout();
            } else if (Stub_Standard_Portrait_Activity.this.portraitBannerWithoutTagView != null) {
                Stub_Standard_Portrait_Activity.this.portraitBannerWithoutTagView.updateInteractionLayout();
            }
            Stub_Standard_Portrait_Activity.this.bottomBannerView.updateInteractionLayout();
            Stub_Standard_Portrait_Activity.this.downloadPresenter.a(new DownloadPresenter.k(this.a));
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void e() {
            TapADLogger.d("downloadError");
            if (Stub_Standard_Portrait_Activity.this.portraitBannerView != null) {
                Stub_Standard_Portrait_Activity.this.portraitBannerView.updateInteractionLayout();
            } else if (Stub_Standard_Portrait_Activity.this.portraitBannerWithoutTagView != null) {
                Stub_Standard_Portrait_Activity.this.portraitBannerWithoutTagView.updateInteractionLayout();
            }
            Stub_Standard_Portrait_Activity.this.bottomBannerView.updateInteractionLayout();
        }
    }

    class p implements RewardPresenter.d {
        final /* synthetic */ AdInfo a;
        final /* synthetic */ AdRequest b;

        p(AdInfo adInfo, AdRequest adRequest) {
            this.a = adInfo;
            this.b = adRequest;
        }

        @Override // com.tapsdk.tapad.internal.RewardPresenter.d
        public void a() {
            if (Stub_Standard_Portrait_Activity.this.rewardBridge != null) {
                Stub_Standard_Portrait_Activity.this.rewardBridge.onVideoComplete();
            }
        }

        @Override // com.tapsdk.tapad.internal.RewardPresenter.d
        public void a(long j) {
            Stub_Standard_Portrait_Activity.this.updateCountDownTime();
            if (Stub_Standard_Portrait_Activity.this.bubbleView.getVisibility() == 8) {
                long j2 = j / 1000;
                AdInfo adInfo = this.a;
                if (j2 == adInfo.bubbleWaitTime && adInfo.isFirstPassiveTransfer && adInfo.isAutoWaitTransferEnable) {
                    Stub_Standard_Portrait_Activity.this.bubbleView.setVisibility(0);
                    Stub_Standard_Portrait_Activity.this.bubbleView.setAnimation(AnimationUtils.loadAnimation(Stub_Standard_Portrait_Activity.this, R.anim.tapad_dync_in_from_right));
                }
            }
            if (Stub_Standard_Portrait_Activity.this.bubbleView.getVisibility() == 0) {
                ((TextView) Stub_Standard_Portrait_Activity.this.bubbleView.findViewById(R.id.content)).setText(String.format("%d s%s", Long.valueOf(j / 1000), this.a.bubbleContent));
            }
        }

        @Override // com.tapsdk.tapad.internal.RewardPresenter.d
        public void b() {
            if (Stub_Standard_Portrait_Activity.this.rewardBridge != null) {
                com.tapsdk.tapad.internal.f.a aVar = Stub_Standard_Portrait_Activity.this.rewardBridge;
                AdRequest adRequest = this.b;
                aVar.onRewardVerify(true, adRequest.rewardAmount, adRequest.rewardName, 0, "");
            }
        }

        @Override // com.tapsdk.tapad.internal.RewardPresenter.d
        public void b(long j) {
            Stub_Standard_Portrait_Activity.this.updateCountDownTime();
        }

        /* JADX WARN: Code duplicated, block: B:20:0x0075  */
        /* JADX WARN: Code duplicated, block: B:9:0x0040  */
        @Override // com.tapsdk.tapad.internal.RewardPresenter.d
        public void c() {
            boolean z;
            Stub_Standard_Portrait_Activity.this.updateCountDownTime();
            Stub_Standard_Portrait_Activity.this.releaseMediaPlayer();
            if (Stub_Standard_Portrait_Activity.this.bubbleView.getVisibility() == 0) {
                Stub_Standard_Portrait_Activity.this.bubbleView.setVisibility(8);
                Stub_Standard_Portrait_Activity stub_Standard_Portrait_Activity = Stub_Standard_Portrait_Activity.this;
                boolean z2 = true;
                if (stub_Standard_Portrait_Activity.bottomBannerView != null) {
                    AdInfo adInfo = this.a;
                    if (adInfo.isFirstPassiveTransfer) {
                        adInfo.isFirstPassiveTransfer = false;
                        Stub_Standard_Portrait_Activity.this.bottomBannerView.onInteractionButtonClick(stub_Standard_Portrait_Activity, 11);
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                }
                if (Stub_Standard_Portrait_Activity.this.portraitBannerView != null) {
                    AdInfo adInfo2 = this.a;
                    if (adInfo2.isFirstPassiveTransfer) {
                        adInfo2.isFirstPassiveTransfer = false;
                        Stub_Standard_Portrait_Activity.this.portraitBannerView.onInteractionButtonClick(stub_Standard_Portrait_Activity, 11, false);
                        z = true;
                    }
                }
                if (Stub_Standard_Portrait_Activity.this.portraitBannerWithoutTagView != null) {
                    AdInfo adInfo3 = this.a;
                    if (adInfo3.isFirstPassiveTransfer) {
                        adInfo3.isFirstPassiveTransfer = false;
                        Stub_Standard_Portrait_Activity.this.portraitBannerWithoutTagView.onInteractionButtonClick(stub_Standard_Portrait_Activity, 11, false);
                    } else {
                        z2 = z;
                    }
                } else {
                    z2 = z;
                }
                if (z2) {
                    Stub_Standard_Portrait_Activity.this.exposeAdClick(11);
                }
            }
            if (Stub_Standard_Portrait_Activity.this.portraitBannerView != null) {
                Stub_Standard_Portrait_Activity.this.portraitBannerView.setVisibility(8);
                Stub_Standard_Portrait_Activity.this.portraitBannerView.updateInteractionLayout();
            }
            if (Stub_Standard_Portrait_Activity.this.portraitBannerWithoutTagView != null) {
                Stub_Standard_Portrait_Activity.this.portraitBannerWithoutTagView.setVisibility(8);
                Stub_Standard_Portrait_Activity.this.portraitBannerWithoutTagView.updateInteractionLayout();
            }
            Stub_Standard_Portrait_Activity.this.verticalRewardCompleteRelativeLayout.setVisibility(0);
            Stub_Standard_Portrait_Activity.this.bottomBannerView.setVisibility(0);
            Stub_Standard_Portrait_Activity.this.bottomBannerView.updateInteractionLayout();
            Stub_Standard_Portrait_Activity.this.volumeImageView.setVisibility(8);
            Stub_Standard_Portrait_Activity.this.bottomBannerView.setTagData(this.a.highlightTags, 10);
            Stub_Standard_Portrait_Activity.this.resumeBannerView();
        }

        @Override // com.tapsdk.tapad.internal.RewardPresenter.d
        public void d() {
            Stub_Standard_Portrait_Activity.this.updateCountDownTime();
        }

        @Override // com.tapsdk.tapad.internal.RewardPresenter.d
        public void onError(int i, String str) {
        }
    }

    class q implements View.OnClickListener {
        q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Stub_Standard_Portrait_Activity.this.changeVolumeState();
            Stub_Standard_Portrait_Activity.this.switchVolume();
            Stub_Standard_Portrait_Activity.this.updateVolumeImage();
        }
    }

    class r implements SurfaceHolder.Callback {
        r() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            TapADLogger.d("surfaceCreated");
            if (Stub_Standard_Portrait_Activity.this.mediaPlayer != null) {
                Stub_Standard_Portrait_Activity.this.mediaPlayer.setDisplay(surfaceHolder);
                if (Stub_Standard_Portrait_Activity.this.mediaPlayer.isPlaying()) {
                    return;
                }
                TapADLogger.d("surfaceCreated inner");
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        }
    }

    class s implements MediaPlayer.OnPreparedListener {
        final /* synthetic */ AdInfo a;

        class a extends AnimatorListenerAdapter {
            a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                Stub_Standard_Portrait_Activity.this.coverImageView.setVisibility(8);
            }
        }

        s(AdInfo adInfo) {
            this.a = adInfo;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            TapADLogger.d("mediaPlayer OnPreparedListener");
            Stub_Standard_Portrait_Activity.this.isMediaReady = true;
            Stub_Standard_Portrait_Activity.this.resumeMedia();
            Stub_Standard_Portrait_Activity.this.switchVolume();
            Stub_Standard_Portrait_Activity.this.updateVolumeImage();
            com.tapsdk.tapad.internal.tracker.c cVarA = com.tapsdk.tapad.internal.tracker.c.a();
            AdInfo adInfo = this.a;
            cVarA.a(adInfo.videoViewMonitorUrls, (Map<String, String>) null, adInfo.getVideoViewMonitorHeaderListWrapper());
            Stub_Standard_Portrait_Activity.this.surfaceView.setVisibility(0);
            Stub_Standard_Portrait_Activity.this.coverImageView.animate().alpha(0.0f).setDuration(500L).setListener(new a());
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
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.mediaPlayer = mediaPlayer;
            mediaPlayer.reset();
            this.mediaPlayer.setDataSource(this, Uri.parse(this.videoUri));
            if (getEnableCustomPlayTimeController()) {
                this.mediaPlayer.setLooping(true);
            }
            this.surfaceView.getHolder().addCallback(new r());
            this.mediaPlayer.prepareAsync();
            this.mediaPlayer.setOnPreparedListener(new s(adInfo));
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
        this.downloadPresenter = new DownloadPresenter(this, new o(adInfo));
    }

    private void initRewardPresenter(int i2, AdRequest adRequest, AdInfo adInfo) {
        if (getEnableCustomPlayTimeController()) {
            i2 = customControllerLeftTime(i2);
        }
        this.rewardPresenter = new RewardPresenter(this, new p(adInfo, adRequest), i2, adRequest, adInfo, TapAdManager.get().tapAdConfig);
    }

    private void initView(AdInfo adInfo) {
        if (adInfo.highlightTags.isEmpty()) {
            PortraitBannerWithoutTagView portraitBannerWithoutTagView = (PortraitBannerWithoutTagView) findViewById(R.id.portraitBannerWithoutTagView);
            this.portraitBannerWithoutTagView = portraitBannerWithoutTagView;
            portraitBannerWithoutTagView.findViewById(R.id.portraitAdsRelativeLayout).setAlpha(0.95f);
            this.portraitBannerWithoutTagView.setVisibility(0);
            findViewById(R.id.portraitBannerView).setVisibility(8);
            TapADLogger.d("no tag, go to portraitBannerWithoutTagView");
        } else {
            PortraitBannerView portraitBannerView = (PortraitBannerView) findViewById(R.id.portraitBannerView);
            this.portraitBannerView = portraitBannerView;
            portraitBannerView.findViewById(R.id.portraitAdsRelativeLayout).setAlpha(0.95f);
            findViewById(R.id.portraitBannerWithoutTagView).setVisibility(8);
        }
        this.volumeImageView = (ImageView) findViewById(R.id.volumeImageView);
        this.coverImageView = (ImageView) findViewById(R.id.coverImageView);
        VideoSurfaceView videoSurfaceView = (VideoSurfaceView) findViewById(R.id.adsSurfaceView);
        this.surfaceView = videoSurfaceView;
        videoSurfaceView.setVisibility(4);
        this.verticalRewardCompleteRelativeLayout = (RelativeLayout) findViewById(R.id.verticalRewardCompleteRelativeLayout);
        this.verticalCoverImageView = (ImageView) findViewById(R.id.verticalCoverImageView);
        this.bottomBannerView = (BottomBannerView) findViewById(R.id.bottomBannerView);
        this.mediaPlayerImageView = (ImageView) findViewById(R.id.mediaPlayerImageView);
        this.rewardSkipLinearLayout = (LinearLayout) findViewById(R.id.rewardSkipLinearLayout);
        this.countDownTextView = (TextView) findViewById(R.id.countDownTextView);
        this.skipDividerView = findViewById(R.id.skipDividerView);
        this.skipTextView = (TextView) findViewById(R.id.skipTextView);
        this.backgroundImageView = (ImageView) findViewById(R.id.backgroundImageView);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.bubbleView);
        this.bubbleView = viewGroup;
        viewGroup.findViewById(R.id.close_btn).setOnClickListener(new m());
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
            if (!TextUtils.isEmpty(strExtractWaitInteractionDescription)) {
                ((TextView) this.bubbleView.findViewById(R.id.description)).setText(strExtractWaitInteractionDescription);
            }
        }
        View viewFindViewById = findViewById(android.R.id.content);
        if (viewFindViewById != null) {
            com.tapsdk.tapad.internal.tracker.b bVar = new com.tapsdk.tapad.internal.tracker.b(viewFindViewById, new n());
            this.exposureHandler = bVar;
            bVar.a(adInfo.tapADTrackerObject.a);
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
        this.volumeImageView.setOnClickListener(new q());
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
        PortraitBannerView portraitBannerView = this.portraitBannerView;
        if (portraitBannerView != null) {
            portraitBannerView.onPause();
        }
        PortraitBannerWithoutTagView portraitBannerWithoutTagView = this.portraitBannerWithoutTagView;
        if (portraitBannerWithoutTagView != null) {
            portraitBannerWithoutTagView.onPause();
        }
        BottomBannerView bottomBannerView = this.bottomBannerView;
        if (bottomBannerView != null) {
            bottomBannerView.onPause();
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
        this.verticalRewardCompleteRelativeLayout.setVisibility(8);
        this.bottomBannerView.setVisibility(8);
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
        Glide.with((Activity) this).load(adInfo.appInfo.appIconImage.imageUrl).into((ImageView) findViewById(R.id.portraitIconImageView));
        List<VideoInfo> list2 = adInfo.materialInfo.videoInfoList;
        if (list2 != null && list2.size() > 0 && adInfo.materialInfo.videoInfoList.get(0).coverImage != null && adInfo.materialInfo.videoInfoList.get(0).coverImage.imageUrl != null) {
            Glide.with((Activity) this).load(adInfo.materialInfo.videoInfoList.get(0).coverImage.imageUrl).into(this.verticalCoverImageView);
            Glide.with((Activity) this).load(adInfo.materialInfo.videoInfoList.get(0).coverImage.imageUrl).addListener(new f()).into(this.coverImageView);
            this.coverImageView.setAlpha(0.0f);
            this.coverImageView.animate().alpha(1.0f).setDuration(500L).setListener(new g());
        }
        configurationMediaPlayer(adInfo);
        updateCountDownTime();
        this.rewardSkipLinearLayout.setOnClickListener(new h(adInfo));
        String strB = com.tapsdk.tapad.e.d.d().b();
        if (strB != null && strB.length() > 0) {
            Glide.with((Activity) this).load(strB).into(this.backgroundImageView);
        }
        if (com.tapsdk.tapad.internal.utils.c.a(adInfo.btnInteractionInfo)) {
            this.verticalCoverImageView.setOnClickListener(new i());
        }
    }

    private void renderBanner(AdInfo adInfo) {
        RelativeLayout relativeLayout;
        this.bottomBannerView.render(this, adInfo, this.downloadPresenter, true, this.rewardAdInnerBannerEventCallback);
        PortraitBannerView portraitBannerView = this.portraitBannerView;
        if (portraitBannerView != null) {
            portraitBannerView.setVisibility(0);
            this.portraitBannerView.render(this, adInfo, this.downloadPresenter, null, true, this.rewardAdInnerBannerEventCallback);
            this.portraitBannerView.setOutlineProvider(new d((int) ((getResources().getDisplayMetrics().density * 12.0f) + 0.5f)));
            relativeLayout = this.portraitBannerView;
        } else {
            PortraitBannerWithoutTagView portraitBannerWithoutTagView = this.portraitBannerWithoutTagView;
            if (portraitBannerWithoutTagView == null) {
                return;
            }
            portraitBannerWithoutTagView.setVisibility(0);
            this.portraitBannerWithoutTagView.render(this, adInfo, this.downloadPresenter, null, true, this.rewardAdInnerBannerEventCallback);
            this.portraitBannerWithoutTagView.setOutlineProvider(new e((int) ((getResources().getDisplayMetrics().density * 12.0f) + 0.5f)));
            relativeLayout = this.portraitBannerWithoutTagView;
        }
        relativeLayout.setClipToOutline(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resumeBannerView() {
        PortraitBannerView portraitBannerView = this.portraitBannerView;
        if (portraitBannerView != null && portraitBannerView.getVisibility() == 0) {
            this.portraitBannerView.updateInteractionLayout();
        }
        PortraitBannerWithoutTagView portraitBannerWithoutTagView = this.portraitBannerWithoutTagView;
        if (portraitBannerWithoutTagView != null && portraitBannerWithoutTagView.getVisibility() == 0) {
            this.portraitBannerWithoutTagView.updateInteractionLayout();
        }
        BottomBannerView bottomBannerView = this.bottomBannerView;
        if (bottomBannerView == null || bottomBannerView.getVisibility() != 0) {
            return;
        }
        this.bottomBannerView.updateInteractionLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resumeMedia() {
        MediaPlayer mediaPlayer;
        if (this.gotoComplete || this.isAbortRewardUIShowed) {
            return;
        }
        ImageView imageView = this.mediaPlayerImageView;
        if (imageView != null) {
            imageView.setVisibility(this.mediaOpened ? 8 : 0);
        }
        if (this.isMediaReady && this.mediaOpened && (mediaPlayer = this.mediaPlayer) != null && !mediaPlayer.isPlaying()) {
            this.mediaPlayer.start();
            com.tapsdk.tapad.internal.tracker.b bVar = this.exposureHandler;
            if (bVar != null) {
                bVar.a();
            }
        }
        if (this.mediaOpened) {
            this.rewardPresenter.a(new RewardPresenter.g());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAbortRewardDialog() {
        this.isAbortRewardUIShowed = true;
        pauseMedia();
        try {
            com.tapsdk.tapad.internal.r.b.a.a(this.rewardPresenter.b(), new j()).show(getFragmentManager(), AdPermissionsDialogFragment.TAG);
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
    protected void onCreate(Bundle bundle) {
        ExposureTrackerObject exposureTrackerObject;
        RenderStyles renderStyles;
        int i2;
        String str;
        super.onCreate(bundle);
        getWindow().addFlags(1152);
        setContentView(R.layout.tapad_activity_portrait);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            AdInfo adInfo = (AdInfo) extras.getParcelable("data");
            if (adInfo != null) {
                this.adInfo = adInfo;
                AdRequest adRequest = (AdRequest) extras.getParcelable("request");
                if (adRequest != null) {
                    int i3 = extras.getInt("c_id", Integer.MIN_VALUE);
                    this.callbackId = i3;
                    if (i3 == Integer.MIN_VALUE) {
                        str = "Stub_Standard_Portrait_Activity 未传入callbackId";
                    } else {
                        this.mediaOpened = true;
                        com.tapsdk.tapad.internal.f.a aVarA = com.tapsdk.tapad.internal.f.a(Integer.valueOf(i3));
                        this.rewardBridge = aVarA;
                        if (aVarA == null) {
                            str = "Stub_Standard_Portrait_Activity 获取rewardBridge异常";
                        } else {
                            if (adInfo.materialInfo.videoInfoList.size() != 0) {
                                initView(adInfo);
                                initDownloadPresenter(adInfo);
                                initRewardPresenter(adInfo.materialInfo.videoInfoList.get(0).duration * 1000, adRequest, adInfo);
                                initVolume(adInfo);
                                renderAdLayout(adInfo);
                                UninstalledAdInfo uninstalledAdInfoC = com.tapsdk.tapad.e.f.c();
                                if (uninstalledAdInfoC != null && (renderStyles = uninstalledAdInfoC.adInfo.renderStyles) != null && ((i2 = renderStyles.b) == 2 || i2 == 3)) {
                                    this.downloadPresenter.a(new DownloadPresenter.k(uninstalledAdInfoC.adInfo));
                                }
                                this.surfaceView.postDelayed(new l(), 200L);
                                this.rewardBridge.onAdShow();
                                TapADTrackerObject tapADTrackerObject = adInfo.tapADTrackerObject;
                                if (tapADTrackerObject == null || (exposureTrackerObject = tapADTrackerObject.a) == null || !exposureTrackerObject.a) {
                                    com.tapsdk.tapad.internal.tracker.c.a().a(adInfo.viewMonitorUrls, (Map<String, String>) null, adInfo.getViewMonitorHeaderListWrapper());
                                    return;
                                } else {
                                    exposureTrackerObject.b((Map<String, String>) null);
                                    return;
                                }
                            }
                            str = "Stub_Standard_Portrait_Activity 获取视频资源异常";
                        }
                    }
                }
                finish();
            }
            TapADLogger.d("Stub_Standard_Portrait_Activity 未传入广告信息");
            finish();
        }
        str = "Stub_Standard_Portrait_Activity 未传入额外信息";
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
        resumeBannerView();
        showApkOpenDialog();
    }
}
