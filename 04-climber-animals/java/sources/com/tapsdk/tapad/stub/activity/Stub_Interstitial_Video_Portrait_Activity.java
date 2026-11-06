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
import com.tapsdk.tapad.InterstitialPresenter;
import com.tapsdk.tapad.R;
import com.tapsdk.tapad.internal.DownloadPresenter;
import com.tapsdk.tapad.internal.RewardPresenter;
import com.tapsdk.tapad.internal.tracker.ExposureTrackerObject;
import com.tapsdk.tapad.internal.tracker.TapADTrackerObject;
import com.tapsdk.tapad.internal.ui.views.banner.BottomBannerView;
import com.tapsdk.tapad.internal.ui.views.banner.PortraitBannerView;
import com.tapsdk.tapad.internal.ui.views.banner.PortraitBannerWithoutTagView;
import com.tapsdk.tapad.internal.ui.views.video.VideoSurfaceView;
import com.tapsdk.tapad.internal.utils.TapADLogger;
import com.tapsdk.tapad.model.entities.AdInfo;
import com.tapsdk.tapad.model.entities.InteractionInfo;
import com.tapsdk.tapad.model.entities.RenderStyles;
import com.tapsdk.tapad.model.entities.UninstalledAdInfo;
import com.tapsdk.tapad.model.entities.VideoInfo;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class Stub_Interstitial_Video_Portrait_Activity extends Activity {
    private static final String C = "data";
    private static final String D = "request";
    private static final String E = "c_id";
    private MediaPlayer a;
    private VideoSurfaceView b;
    private ImageView c;
    private PortraitBannerView d;
    private PortraitBannerWithoutTagView e;
    private ImageView f;
    private RelativeLayout g;
    private ImageView h;
    private BottomBannerView i;
    private TextView j;
    private LinearLayout k;
    private ImageView l;
    private View m;
    private TextView n;
    private String o;
    private DownloadPresenter q;
    private InterstitialPresenter r;
    private com.tapsdk.tapad.internal.e.a s;
    private ImageView t;
    private ViewGroup x;
    private String y;
    private int p = 0;
    private boolean u = true;
    private boolean v = false;
    private boolean w = false;
    private int z = 0;
    private AdInfo A = null;
    com.tapsdk.tapad.internal.tracker.b B = null;

    class a implements MediaPlayer.OnVideoSizeChangedListener {
        a() {
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            if (mediaPlayer == null || mediaPlayer.getVideoWidth() <= 0 || mediaPlayer.getVideoHeight() <= 0) {
                return;
            }
            Stub_Interstitial_Video_Portrait_Activity.this.b.adjustSize(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
        }
    }

    class b implements View.OnClickListener {
        final /* synthetic */ AdInfo a;

        b(AdInfo adInfo) {
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
                    Stub_Interstitial_Video_Portrait_Activity stub_Interstitial_Video_Portrait_Activity = Stub_Interstitial_Video_Portrait_Activity.this;
                    com.tapsdk.tapad.internal.s.a.a((Activity) stub_Interstitial_Video_Portrait_Activity, true, this.a, stub_Interstitial_Video_Portrait_Activity.q);
                    return;
                }
            }
            Stub_Interstitial_Video_Portrait_Activity stub_Interstitial_Video_Portrait_Activity2 = Stub_Interstitial_Video_Portrait_Activity.this;
            stub_Interstitial_Video_Portrait_Activity2.u = true ^ stub_Interstitial_Video_Portrait_Activity2.u;
            if (Stub_Interstitial_Video_Portrait_Activity.this.u) {
                Stub_Interstitial_Video_Portrait_Activity.this.h();
            } else {
                Stub_Interstitial_Video_Portrait_Activity.this.e();
            }
        }
    }

    class c extends ViewOutlineProvider {
        final /* synthetic */ int a;

        c(int i) {
            this.a = i;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.a);
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
            com.tapsdk.tapad.internal.tracker.b bVar = Stub_Interstitial_Video_Portrait_Activity.this.B;
            if (bVar == null) {
                return false;
            }
            bVar.b();
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
            if (!adInfo.isFirstPassiveTransfer || !adInfo.isCloseTransferEnable) {
                Stub_Interstitial_Video_Portrait_Activity.this.w = true;
                Stub_Interstitial_Video_Portrait_Activity.this.finish();
                return;
            }
            adInfo.isFirstPassiveTransfer = false;
            Stub_Interstitial_Video_Portrait_Activity.this.x.setVisibility(8);
            Activity activityA = com.tapsdk.tapad.internal.utils.a.a(view.getContext());
            if (Stub_Interstitial_Video_Portrait_Activity.this.i != null) {
                Stub_Interstitial_Video_Portrait_Activity.this.i.onInteractionButtonClick(activityA, 10);
            }
            if (Stub_Interstitial_Video_Portrait_Activity.this.d != null) {
                Stub_Interstitial_Video_Portrait_Activity.this.d.onInteractionButtonClick(activityA, 10, false);
            }
            if (Stub_Interstitial_Video_Portrait_Activity.this.e != null) {
                Stub_Interstitial_Video_Portrait_Activity.this.e.onInteractionButtonClick(activityA, 10, false);
            }
        }
    }

    class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity activityA = com.tapsdk.tapad.internal.utils.a.a(view.getContext());
            if (Stub_Interstitial_Video_Portrait_Activity.this.i != null) {
                Stub_Interstitial_Video_Portrait_Activity.this.i.onInteractionButtonClick(activityA, 1);
            }
            if (Stub_Interstitial_Video_Portrait_Activity.this.d != null) {
                Stub_Interstitial_Video_Portrait_Activity.this.d.onInteractionButtonClick(activityA, 1, false);
            }
            if (Stub_Interstitial_Video_Portrait_Activity.this.e != null) {
                Stub_Interstitial_Video_Portrait_Activity.this.e.onInteractionButtonClick(activityA, 1, false);
            }
        }
    }

    class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tapsdk.tapad.internal.utils.j.c(Stub_Interstitial_Video_Portrait_Activity.this.getWindow());
        }
    }

    class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Stub_Interstitial_Video_Portrait_Activity.this.x.setVisibility(8);
        }
    }

    class k implements com.tapsdk.tapad.internal.tracker.b.InterfaceC0634b {
        k() {
        }

        @Override // com.tapsdk.tapad.internal.tracker.b.InterfaceC0634b
        public void a() {
            if (Stub_Interstitial_Video_Portrait_Activity.this.s != null) {
                Stub_Interstitial_Video_Portrait_Activity.this.s.onAdValidShow();
            }
        }
    }

    class l implements DownloadPresenter.h {
        final /* synthetic */ AdInfo a;

        l(AdInfo adInfo) {
            this.a = adInfo;
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void a() {
            if (Stub_Interstitial_Video_Portrait_Activity.this.d != null) {
                Stub_Interstitial_Video_Portrait_Activity.this.d.updateInteractionLayout();
            } else if (Stub_Interstitial_Video_Portrait_Activity.this.e != null) {
                Stub_Interstitial_Video_Portrait_Activity.this.e.updateInteractionLayout();
            }
            Stub_Interstitial_Video_Portrait_Activity.this.i.updateInteractionLayout();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void a(int i) {
            TapADLogger.d("updateDownloadProgress:" + i);
            if (Stub_Interstitial_Video_Portrait_Activity.this.d != null) {
                Stub_Interstitial_Video_Portrait_Activity.this.d.updateInteractionLayout();
            } else if (Stub_Interstitial_Video_Portrait_Activity.this.e != null) {
                Stub_Interstitial_Video_Portrait_Activity.this.e.updateInteractionLayout();
            }
            Stub_Interstitial_Video_Portrait_Activity.this.i.updateInteractionLayout();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void b() {
            if (Stub_Interstitial_Video_Portrait_Activity.this.d != null) {
                Stub_Interstitial_Video_Portrait_Activity.this.d.updateInteractionLayout();
            } else if (Stub_Interstitial_Video_Portrait_Activity.this.e != null) {
                Stub_Interstitial_Video_Portrait_Activity.this.e.updateInteractionLayout();
            }
            Stub_Interstitial_Video_Portrait_Activity.this.i.updateInteractionLayout();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void c() {
            if (Stub_Interstitial_Video_Portrait_Activity.this.d != null) {
                Stub_Interstitial_Video_Portrait_Activity.this.d.updateInteractionLayout();
            } else if (Stub_Interstitial_Video_Portrait_Activity.this.e != null) {
                Stub_Interstitial_Video_Portrait_Activity.this.e.updateInteractionLayout();
            }
            Stub_Interstitial_Video_Portrait_Activity.this.i.updateInteractionLayout();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void d() {
            if (Stub_Interstitial_Video_Portrait_Activity.this.d != null) {
                Stub_Interstitial_Video_Portrait_Activity.this.d.updateInteractionLayout();
            } else if (Stub_Interstitial_Video_Portrait_Activity.this.e != null) {
                Stub_Interstitial_Video_Portrait_Activity.this.e.updateInteractionLayout();
            }
            Stub_Interstitial_Video_Portrait_Activity.this.i.updateInteractionLayout();
            Stub_Interstitial_Video_Portrait_Activity.this.q.a(new DownloadPresenter.k(this.a));
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void e() {
            TapADLogger.d("downloadError");
            if (Stub_Interstitial_Video_Portrait_Activity.this.d != null) {
                Stub_Interstitial_Video_Portrait_Activity.this.d.updateInteractionLayout();
            } else if (Stub_Interstitial_Video_Portrait_Activity.this.e != null) {
                Stub_Interstitial_Video_Portrait_Activity.this.e.updateInteractionLayout();
            }
            Stub_Interstitial_Video_Portrait_Activity.this.i.updateInteractionLayout();
        }
    }

    class m implements InterstitialPresenter.c {
        final /* synthetic */ AdInfo a;

        m(AdInfo adInfo) {
            this.a = adInfo;
        }

        @Override // com.tapsdk.tapad.InterstitialPresenter.c
        public void a(long j) {
            Stub_Interstitial_Video_Portrait_Activity.this.i();
            if (Stub_Interstitial_Video_Portrait_Activity.this.x.getVisibility() == 8) {
                long j2 = j / 1000;
                AdInfo adInfo = this.a;
                if (j2 == adInfo.bubbleWaitTime && adInfo.isFirstPassiveTransfer && adInfo.isAutoWaitTransferEnable) {
                    Stub_Interstitial_Video_Portrait_Activity.this.x.setVisibility(0);
                    Stub_Interstitial_Video_Portrait_Activity.this.x.setAnimation(AnimationUtils.loadAnimation(Stub_Interstitial_Video_Portrait_Activity.this, R.anim.tapad_dync_in_from_right));
                }
            }
        }

        @Override // com.tapsdk.tapad.InterstitialPresenter.c
        public void b(long j) {
            Stub_Interstitial_Video_Portrait_Activity.this.i();
            Stub_Interstitial_Video_Portrait_Activity.this.f();
            if (Stub_Interstitial_Video_Portrait_Activity.this.x.getVisibility() == 0) {
                Stub_Interstitial_Video_Portrait_Activity.this.x.setVisibility(8);
                Stub_Interstitial_Video_Portrait_Activity stub_Interstitial_Video_Portrait_Activity = Stub_Interstitial_Video_Portrait_Activity.this;
                if (stub_Interstitial_Video_Portrait_Activity.i != null) {
                    AdInfo adInfo = this.a;
                    if (adInfo.isFirstPassiveTransfer) {
                        adInfo.isFirstPassiveTransfer = false;
                        Stub_Interstitial_Video_Portrait_Activity.this.i.onInteractionButtonClick(stub_Interstitial_Video_Portrait_Activity, 11);
                    }
                }
                if (Stub_Interstitial_Video_Portrait_Activity.this.d != null) {
                    AdInfo adInfo2 = this.a;
                    if (adInfo2.isFirstPassiveTransfer) {
                        adInfo2.isFirstPassiveTransfer = false;
                        Stub_Interstitial_Video_Portrait_Activity.this.d.onInteractionButtonClick(stub_Interstitial_Video_Portrait_Activity, 11, false);
                    }
                }
                if (Stub_Interstitial_Video_Portrait_Activity.this.e != null) {
                    AdInfo adInfo3 = this.a;
                    if (adInfo3.isFirstPassiveTransfer) {
                        adInfo3.isFirstPassiveTransfer = false;
                        Stub_Interstitial_Video_Portrait_Activity.this.e.onInteractionButtonClick(stub_Interstitial_Video_Portrait_Activity, 11, false);
                    }
                }
            }
            Stub_Interstitial_Video_Portrait_Activity.this.finish();
        }

        @Override // com.tapsdk.tapad.InterstitialPresenter.c
        public void onError(int i, String str) {
        }
    }

    class n implements View.OnClickListener {
        n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Stub_Interstitial_Video_Portrait_Activity.this.p == 0) {
                Stub_Interstitial_Video_Portrait_Activity.this.p = 1;
                Stub_Interstitial_Video_Portrait_Activity.this.c();
            } else {
                Stub_Interstitial_Video_Portrait_Activity.this.p = 0;
                Stub_Interstitial_Video_Portrait_Activity.this.a();
            }
            Stub_Interstitial_Video_Portrait_Activity.this.j();
        }
    }

    class o implements SurfaceHolder.Callback {
        o() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            TapADLogger.d("surfaceCreated");
            if (Stub_Interstitial_Video_Portrait_Activity.this.a != null) {
                Stub_Interstitial_Video_Portrait_Activity.this.a.setDisplay(surfaceHolder);
                if (Stub_Interstitial_Video_Portrait_Activity.this.a.isPlaying()) {
                    return;
                }
                TapADLogger.d("surfaceCreated inner");
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        }
    }

    class p implements MediaPlayer.OnPreparedListener {
        final /* synthetic */ AdInfo a;

        class a extends AnimatorListenerAdapter {
            a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                Stub_Interstitial_Video_Portrait_Activity.this.c.setVisibility(8);
            }
        }

        class b implements MediaPlayer.OnCompletionListener {
            b() {
            }

            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
            }
        }

        p(AdInfo adInfo) {
            this.a = adInfo;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            TapADLogger.d("mediaPlayer OnPreparedListener");
            Stub_Interstitial_Video_Portrait_Activity.this.v = true;
            Stub_Interstitial_Video_Portrait_Activity.this.h();
            Stub_Interstitial_Video_Portrait_Activity.this.c();
            com.tapsdk.tapad.internal.tracker.c cVarA = com.tapsdk.tapad.internal.tracker.c.a();
            AdInfo adInfo = this.a;
            cVarA.a(adInfo.videoViewMonitorUrls, (Map<String, String>) null, adInfo.getVideoViewMonitorHeaderListWrapper());
            Stub_Interstitial_Video_Portrait_Activity.this.b.setVisibility(0);
            Stub_Interstitial_Video_Portrait_Activity.this.c.animate().alpha(0.0f).setDuration(500L).setListener(new a());
            Stub_Interstitial_Video_Portrait_Activity.this.a.setOnCompletionListener(new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        MediaPlayer mediaPlayer = this.a;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(0.0f, 0.0f);
        }
    }

    private void a(int i2, AdRequest adRequest, AdInfo adInfo) {
        this.r = new InterstitialPresenter(this, new m(adInfo), i2, adInfo);
    }

    private void a(AdInfo adInfo) {
        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.a = mediaPlayer;
            mediaPlayer.reset();
            this.a.setDataSource(this, Uri.parse(this.o));
            this.b.getHolder().addCallback(new o());
            this.a.prepareAsync();
            this.a.setOnPreparedListener(new p(adInfo));
            this.a.setOnVideoSizeChangedListener(new a());
            this.b.setOnClickListener(new b(adInfo));
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private void b() {
        this.f.setOnClickListener(new n());
    }

    private void b(AdInfo adInfo) {
        this.q = new DownloadPresenter(this, new l(adInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        MediaPlayer mediaPlayer = this.a;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(0.09f, 0.09f);
        }
    }

    private void c(AdInfo adInfo) {
        if (adInfo.highlightTags.isEmpty()) {
            PortraitBannerWithoutTagView portraitBannerWithoutTagView = (PortraitBannerWithoutTagView) findViewById(R.id.portraitBannerWithoutTagView);
            this.e = portraitBannerWithoutTagView;
            portraitBannerWithoutTagView.findViewById(R.id.portraitAdsRelativeLayout).setAlpha(0.95f);
            this.e.setVisibility(0);
            findViewById(R.id.portraitBannerView).setVisibility(8);
            TapADLogger.d("no tag, go to portraitBannerWithoutTagView");
        } else {
            PortraitBannerView portraitBannerView = (PortraitBannerView) findViewById(R.id.portraitBannerView);
            this.d = portraitBannerView;
            portraitBannerView.findViewById(R.id.portraitAdsRelativeLayout).setAlpha(0.95f);
            findViewById(R.id.portraitBannerWithoutTagView).setVisibility(8);
        }
        this.f = (ImageView) findViewById(R.id.volumeImageView);
        this.c = (ImageView) findViewById(R.id.coverImageView);
        VideoSurfaceView videoSurfaceView = (VideoSurfaceView) findViewById(R.id.adsSurfaceView);
        this.b = videoSurfaceView;
        videoSurfaceView.setVisibility(4);
        this.g = (RelativeLayout) findViewById(R.id.verticalRewardCompleteRelativeLayout);
        this.h = (ImageView) findViewById(R.id.verticalCoverImageView);
        this.i = (BottomBannerView) findViewById(R.id.bottomBannerView);
        this.t = (ImageView) findViewById(R.id.mediaPlayerImageView);
        this.k = (LinearLayout) findViewById(R.id.rewardSkipLinearLayout);
        this.j = (TextView) findViewById(R.id.countDownTextView);
        this.m = findViewById(R.id.skipDividerView);
        this.n = (TextView) findViewById(R.id.skipTextView);
        this.l = (ImageView) findViewById(R.id.backgroundImageView);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.bubbleView);
        this.x = viewGroup;
        viewGroup.findViewById(R.id.close_btn).setOnClickListener(new j());
        InteractionInfo interactionInfo = adInfo.btnInteractionInfo;
        if (interactionInfo != null) {
            String strExtractWaitInteractionIconUrl = interactionInfo.extractWaitInteractionIconUrl();
            if (TextUtils.isEmpty(strExtractWaitInteractionIconUrl)) {
                strExtractWaitInteractionIconUrl = adInfo.appInfo.appIconImage.imageUrl;
            }
            if (!TextUtils.isEmpty(strExtractWaitInteractionIconUrl)) {
                Glide.with((Activity) this).load(strExtractWaitInteractionIconUrl).into((ImageView) this.x.findViewById(R.id.icon_image));
            }
            String strExtractWaitInteractionDescription = adInfo.btnInteractionInfo.extractWaitInteractionDescription();
            if (!TextUtils.isEmpty(strExtractWaitInteractionDescription)) {
                ((TextView) this.x.findViewById(R.id.description)).setText(strExtractWaitInteractionDescription);
            }
        }
        View viewFindViewById = findViewById(android.R.id.content);
        if (viewFindViewById == null || adInfo.tapADTrackerObject == null) {
            return;
        }
        com.tapsdk.tapad.internal.tracker.b bVar = new com.tapsdk.tapad.internal.tracker.b(viewFindViewById, new k());
        this.B = bVar;
        bVar.a(adInfo.tapADTrackerObject.a);
    }

    private void d() {
        PortraitBannerView portraitBannerView = this.d;
        if (portraitBannerView != null) {
            portraitBannerView.onPause();
        }
        PortraitBannerWithoutTagView portraitBannerWithoutTagView = this.e;
        if (portraitBannerWithoutTagView != null) {
            portraitBannerWithoutTagView.onPause();
        }
        BottomBannerView bottomBannerView = this.i;
        if (bottomBannerView != null) {
            bottomBannerView.onPause();
        }
    }

    private void d(AdInfo adInfo) {
        e(adInfo);
        this.g.setVisibility(8);
        this.o = "";
        String str = adInfo.cachedVideoUri;
        if (str == null || str.length() <= 0) {
            List<VideoInfo> list = adInfo.materialInfo.videoInfoList;
            if (list != null && list.size() > 0) {
                this.o = adInfo.materialInfo.videoInfoList.get(0).videoUrl;
                TapADLogger.d("videoUrl:" + this.o);
            }
        } else {
            this.o = adInfo.cachedVideoUri;
        }
        if (this.o.length() == 0) {
            TapADLogger.e("video info not corrected");
            finish();
        }
        Glide.with((Activity) this).load(adInfo.appInfo.appIconImage.imageUrl).into((ImageView) findViewById(R.id.portraitIconImageView));
        List<VideoInfo> list2 = adInfo.materialInfo.videoInfoList;
        if (list2 != null && list2.size() > 0 && adInfo.materialInfo.videoInfoList.get(0).coverImage != null && adInfo.materialInfo.videoInfoList.get(0).coverImage.imageUrl != null) {
            Glide.with((Activity) this).load(adInfo.materialInfo.videoInfoList.get(0).coverImage.imageUrl).into(this.h);
            Glide.with((Activity) this).load(adInfo.materialInfo.videoInfoList.get(0).coverImage.imageUrl).addListener(new e()).into(this.c);
            this.c.setAlpha(0.0f);
            this.c.animate().alpha(1.0f).setDuration(500L).setListener(new f());
        }
        a(adInfo);
        i();
        this.k.setOnClickListener(new g(adInfo));
        String strB = com.tapsdk.tapad.e.d.d().b();
        if (strB != null && strB.length() > 0) {
            Glide.with((Activity) this).load(strB).into(this.l);
        }
        if (com.tapsdk.tapad.internal.utils.c.a(adInfo.btnInteractionInfo)) {
            this.h.setOnClickListener(new h());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        MediaPlayer mediaPlayer = this.a;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.a.pause();
        }
        this.t.setVisibility(this.u ? 8 : 0);
        this.r.a(new RewardPresenter.e());
    }

    private void e(AdInfo adInfo) {
        RelativeLayout relativeLayout;
        PortraitBannerView portraitBannerView = this.d;
        if (portraitBannerView == null) {
            PortraitBannerWithoutTagView portraitBannerWithoutTagView = this.e;
            if (portraitBannerWithoutTagView != null) {
                portraitBannerWithoutTagView.setVisibility(0);
                this.e.render(this, adInfo, this.q, null, true);
                this.e.setOutlineProvider(new d((int) ((getResources().getDisplayMetrics().density * 12.0f) + 0.5f)));
                relativeLayout = this.e;
            }
            this.i.render(this, adInfo, this.q, false);
        }
        portraitBannerView.setVisibility(0);
        this.d.render(this, adInfo, this.q, null, true);
        this.d.setOutlineProvider(new c((int) ((getResources().getDisplayMetrics().density * 12.0f) + 0.5f)));
        relativeLayout = this.d;
        relativeLayout.setClipToOutline(true);
        this.i.render(this, adInfo, this.q, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        MediaPlayer mediaPlayer = this.a;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.a = null;
        }
    }

    private void g() {
        PortraitBannerView portraitBannerView = this.d;
        if (portraitBannerView != null && portraitBannerView.getVisibility() == 0) {
            this.d.updateInteractionLayout();
        }
        PortraitBannerWithoutTagView portraitBannerWithoutTagView = this.e;
        if (portraitBannerWithoutTagView != null && portraitBannerWithoutTagView.getVisibility() == 0) {
            this.e.updateInteractionLayout();
        }
        BottomBannerView bottomBannerView = this.i;
        if (bottomBannerView == null || bottomBannerView.getVisibility() != 0) {
            return;
        }
        this.i.updateInteractionLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        MediaPlayer mediaPlayer;
        if (this.w) {
            return;
        }
        this.t.setVisibility(this.u ? 8 : 0);
        if (this.v && this.u && (mediaPlayer = this.a) != null && !mediaPlayer.isPlaying()) {
            this.a.start();
            com.tapsdk.tapad.internal.tracker.b bVar = this.B;
            if (bVar != null) {
                bVar.a();
            }
        }
        if (this.u) {
            this.r.a(new RewardPresenter.g());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        String str = (String) this.r.a().first;
        if (str == null || str.length() <= 0) {
            this.j.setVisibility(8);
        } else {
            this.j.setVisibility(0);
            this.j.setText(str);
            if (this.x.getVisibility() == 0) {
                try {
                    ((TextView) this.x.findViewById(R.id.content)).setText(String.format("%s s%s", Integer.valueOf(str.substring(0, str.length() - 2)), this.y));
                } catch (Exception unused) {
                }
            }
        }
        String str2 = (String) this.r.a().second;
        if (str2 == null || str2.length() <= 0) {
            this.n.setVisibility(8);
        } else {
            this.n.setVisibility(0);
            this.n.setText(str2);
        }
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            this.m.setVisibility(8);
        } else {
            this.m.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.f.setImageResource(this.p == 1 ? R.drawable.tapad_ic_audio_open : R.drawable.tapad_ic_audio_mute);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        ExposureTrackerObject exposureTrackerObject;
        RenderStyles renderStyles;
        int i2;
        super.onCreate(bundle);
        getWindow().addFlags(1152);
        setContentView(R.layout.tapad_activity_portrait);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            TapADLogger.d("Stub_Standard_Portrait_Activity 未传入额外信息");
            finish();
            return;
        }
        AdInfo adInfo = (AdInfo) extras.getParcelable("data");
        if (adInfo == null) {
            TapADLogger.d("Stub_Standard_Portrait_Activity 未传入广告信息");
            finish();
            return;
        }
        this.A = adInfo;
        AdRequest adRequest = (AdRequest) extras.getParcelable("request");
        if (adRequest == null) {
            TapADLogger.d("Stub_Standard_Portrait_Activity 未传入广告信息");
            finish();
            return;
        }
        int i3 = extras.getInt("c_id", Integer.MIN_VALUE);
        this.z = i3;
        if (i3 == Integer.MIN_VALUE) {
            TapADLogger.d("Stub_Standard_Portrait_Activity 未传入callbackId");
            finish();
            return;
        }
        if (adInfo.materialInfo.videoInfoList.size() < 1) {
            TapADLogger.d("Stub_Standard_Portrait_Activity 获取视频资源异常");
            finish();
            return;
        }
        this.u = true;
        com.tapsdk.tapad.internal.e.a aVarA = com.tapsdk.tapad.internal.e.a(Integer.valueOf(this.z));
        this.s = aVarA;
        if (aVarA == null) {
            TapADLogger.d("Stub_Standard_Portrait_Activity 获取rewardBridge异常");
            finish();
            return;
        }
        c(adInfo);
        b(adInfo);
        a(adInfo.interstitialAdKeepTime * 1000, adRequest, adInfo);
        b();
        d(adInfo);
        g();
        UninstalledAdInfo uninstalledAdInfoC = com.tapsdk.tapad.e.f.c();
        if (uninstalledAdInfoC != null && (renderStyles = uninstalledAdInfoC.adInfo.renderStyles) != null && ((i2 = renderStyles.b) == 2 || i2 == 3)) {
            this.q.a(new DownloadPresenter.k(uninstalledAdInfoC.adInfo));
        }
        this.b.postDelayed(new i(), 200L);
        this.s.onAdShow();
        TapADTrackerObject tapADTrackerObject = adInfo.tapADTrackerObject;
        if (tapADTrackerObject == null || (exposureTrackerObject = tapADTrackerObject.a) == null || !exposureTrackerObject.a) {
            com.tapsdk.tapad.internal.tracker.c.a().a(adInfo.viewMonitorUrls, (Map<String, String>) null, adInfo.getViewMonitorHeaderListWrapper());
        } else {
            exposureTrackerObject.b((Map<String, String>) null);
        }
        this.y = adInfo.bubbleContent;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        com.tapsdk.tapad.internal.e.a aVar = this.s;
        if (aVar != null) {
            aVar.onAdClose();
            this.s = null;
        }
        f();
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return i2 == 4;
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        e();
        d();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        h();
        g();
        com.tapsdk.tapad.internal.c.b().a(this, this.A, true);
    }
}
