package com.kwad.components.ad.feed.widget;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kwad.components.ad.widget.DownloadProgressView;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.model.FeedType;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.widget.KSRelativeLayout;
import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c extends a implements View.OnClickListener, com.kwad.sdk.widget.d {
    private KsAdVideoPlayConfig bU;
    private com.kwad.components.core.video.a.b cA;
    private OfflineOnAudioConflictListener cB;
    private List<Integer> ck;
    private boolean cp;
    private com.kwad.sdk.core.video.videoview.a cq;
    private com.kwad.sdk.core.video.videoview.a.InterfaceC0502a cz;
    private volatile boolean eE;
    private com.kwad.sdk.widget.l eF;
    private TextView ee;
    private final AdLivePlayStateListener eh;
    private com.kwad.components.core.k.a.b fD;
    private View fF;
    private IAdLiveOfflineView fq;
    private com.kwad.components.core.o.a.b.a fr;
    private TextView gD;
    private ImageView gw;
    private TextView hA;
    private ImageView hC;
    private TextView hE;
    private TextView hF;
    private View hG;
    private DownloadProgressView hH;
    private boolean hI;
    private int hJ;
    protected KSRelativeLayout hL;
    private ImageView hM;
    private com.kwad.components.core.video.e hN;
    private d hO;
    private TextView hP;
    private final com.kwad.components.core.video.a.InterfaceC0445a hQ;
    private IAdLivePlayModule hR;
    private boolean hS;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private boolean mIsAudioEnable;
    private KsLogoView mLogoView;

    static /* synthetic */ boolean b(c cVar, boolean z) {
        cVar.cp = false;
        return false;
    }

    public void setVideoPlayConfig(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        com.kwad.components.core.video.e eVar;
        IAdLivePlayModule iAdLivePlayModule;
        this.bU = ksAdVideoPlayConfig;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0) {
                this.mIsAudioEnable = kSAdVideoPlayConfigImpl.isVideoSoundEnable();
            } else {
                this.mIsAudioEnable = com.kwad.sdk.core.response.b.a.ca(this.mAdInfo);
            }
            this.mAdTemplate.mIsAudioEnable = this.mIsAudioEnable;
            IAdLiveOfflineView iAdLiveOfflineView = this.fq;
            if (iAdLiveOfflineView != null && iAdLiveOfflineView.getView() != null && (iAdLivePlayModule = this.hR) != null) {
                iAdLivePlayModule.setAudioEnabled(h(this.mIsAudioEnable), false);
            } else {
                com.kwad.sdk.core.video.videoview.a aVar = this.cq;
                if (aVar != null) {
                    aVar.setVideoSoundEnable(h(this.mIsAudioEnable));
                }
            }
            if (this.mIsAudioEnable) {
                com.kwad.components.core.t.a.aC(this.mContext).a(this.cB);
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() == 0 || (eVar = this.hN) == null) {
                return;
            }
            eVar.setDataAutoStart(kSAdVideoPlayConfigImpl.isDataFlowAutoStart());
        }
    }

    public c(Context context) {
        super(context);
        this.mIsAudioEnable = false;
        this.eE = false;
        this.hI = true;
        this.hJ = 8;
        this.eF = new com.kwad.sdk.widget.l() { // from class: com.kwad.components.ad.feed.widget.c.1
            @Override // com.kwad.sdk.widget.l
            public final void aT() {
                com.kwad.sdk.utils.n.eM(c.this.mAdTemplate);
            }
        };
        this.hQ = new com.kwad.components.core.video.a.InterfaceC0445a() { // from class: com.kwad.components.ad.feed.widget.c.4
            @Override // com.kwad.components.core.video.a.InterfaceC0445a
            public final void a(int i, aj.a aVar) {
                int i2;
                int i3 = 2;
                boolean z = false;
                if (i == 1) {
                    i2 = 15;
                } else if (i == 2) {
                    i2 = 16;
                } else if (i != 3) {
                    i2 = 35;
                } else {
                    i2 = 39;
                    i3 = 1;
                    z = true;
                }
                c.this.cj();
                com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C0426a(c.this.getContext()).aB(c.this.mAdTemplate).b(c.this.mApkDownloadHelper).aB(i3).aq(z).as(true).az(5).aA(i2).d(aVar).au(true).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.feed.widget.c.4.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        c.this.vV();
                    }
                }));
            }
        };
        this.eh = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.feed.widget.c.8
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayProgress(long j) {
                super.onLivePlayProgress(j);
                c.this.c(j);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayEnd() {
                super.onLivePlayEnd();
                c.this.hP.setVisibility(0);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayStart() {
                super.onLivePlayStart();
                if (c.this.hR != null) {
                    com.kwad.components.core.k.a.qp().a(c.this.getCurrentVoiceItem());
                    IAdLivePlayModule iAdLivePlayModule = c.this.hR;
                    c cVar = c.this;
                    iAdLivePlayModule.setAudioEnabled(cVar.h(cVar.mIsAudioEnable), false);
                }
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayResume() {
                super.onLivePlayResume();
                if (c.this.hR != null) {
                    com.kwad.components.core.k.a.qp().a(c.this.getCurrentVoiceItem());
                    IAdLivePlayModule iAdLivePlayModule = c.this.hR;
                    c cVar = c.this;
                    iAdLivePlayModule.setAudioEnabled(cVar.h(cVar.mIsAudioEnable), false);
                }
            }
        };
        this.cB = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.feed.widget.c.10
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                c.b(c.this, false);
                if (c.this.cq != null) {
                    c.this.cq.setVideoSoundEnable(false);
                }
                if (c.this.hR != null) {
                    c.this.hR.setAudioEnabled(false, false);
                }
            }
        };
        this.cA = new com.kwad.components.core.video.a.b() { // from class: com.kwad.components.ad.feed.widget.c.2
            @Override // com.kwad.components.core.video.a.c
            public final void d(long j) {
                c.this.c(j);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                com.kwad.components.core.k.a.qp().a(c.this.getCurrentVoiceItem());
                if (c.this.hO != null && (c.this.hO.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) c.this.hO.getParent()).removeView(c.this.hO);
                    c.this.hO.cz();
                    c.this.hO = null;
                }
                com.kwad.components.ad.feed.monitor.b.a(c.this.mAdTemplate, 1, 1, com.kwad.sdk.core.response.b.a.K(c.this.mAdInfo), null, SystemClock.elapsedRealtime() - c.this.ht);
                com.kwad.sdk.core.adlog.c.bX(c.this.mAdTemplate);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void aq() {
                com.kwad.sdk.core.video.videoview.a aVar = c.this.cq;
                c cVar = c.this;
                aVar.setVideoSoundEnable(cVar.h(cVar.mIsAudioEnable));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void ar() {
                if (com.kwad.components.ad.feed.a.b.cf() && c.this.hO == null) {
                    c.this.hO = new d(c.this.getContext());
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    c cVar = c.this;
                    cVar.addView(cVar.hO, layoutParams);
                    c.this.hO.cy();
                }
                if (c.this.hN.Zy != null && c.this.cw()) {
                    ((ViewGroup) c.this.hN.Zy.getParent()).removeView(c.this.hN.Zy);
                    c.this.hL.addView(c.this.hN.Zy);
                }
                com.kwad.sdk.core.adlog.c.bY(c.this.mAdTemplate);
            }

            @Override // com.kwad.components.core.video.a.b
            public final void onVideoPlayError(int i, int i2) {
                com.kwad.components.ad.feed.monitor.b.a(c.this.mAdTemplate, 2, 1, com.kwad.sdk.core.response.b.a.K(c.this.mAdInfo), i + " " + i2, SystemClock.elapsedRealtime() - c.this.ht);
            }
        };
    }

    @Override // com.kwad.components.core.widget.b
    public void bw() {
        this.hA = (TextView) findViewById(R.id.ksad_ad_desc);
        this.hL = (KSRelativeLayout) findViewById(R.id.ksad_feed_ad_video_container);
        cr();
        this.hC = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.hM = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_ad_dislike_logo);
        this.hH = (DownloadProgressView) findViewById(R.id.ksad_app_download_btn);
        this.hP = (TextView) findViewById(R.id.ksad_live_end_text);
        this.fF = findViewById(R.id.ksad_live_end_bg_mantle);
    }

    protected void cr() {
        this.hL.setRatio(0.56f);
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.j.c
    public final void bt() {
        super.bt();
        com.kwad.components.core.video.e eVar = this.hN;
        if (eVar != null) {
            eVar.setVideoPlayCallback(this.cA);
        }
        com.kwad.components.core.k.a.qp().a(getCurrentVoiceItem());
        if (this.hS) {
            IAdLivePlayModule iAdLivePlayModule = this.hR;
            if (iAdLivePlayModule == null) {
                this.hR = cu();
            } else {
                iAdLivePlayModule.onResume();
            }
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.j.c
    public final void bu() {
        super.bu();
        IAdLivePlayModule iAdLivePlayModule = this.hR;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onPause();
        }
        com.kwad.components.core.k.a.qp().c(this.fD);
    }

    @Override // com.kwad.components.core.widget.b
    public final void cq() {
        super.cq();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this.hH.getAppDownloadListener());
        }
        if (this.mIsAudioEnable) {
            com.kwad.components.core.t.a.aC(this.mContext).b(this.cB);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void d(AdResultData adResultData) {
        super.d(adResultData);
        this.hA.setText(com.kwad.components.ad.feed.f.l(this.mAdTemplate));
        this.mLogoView.aP(this.mAdTemplate);
        cs();
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            findViewById(R.id.ksad_ad_download_container).setVisibility(0);
            findViewById(R.id.ksad_ad_h5_container).setVisibility(8);
            cn();
            cx();
        } else {
            findViewById(R.id.ksad_ad_h5_container).setVisibility(0);
            findViewById(R.id.ksad_ad_download_container).setVisibility(8);
            if (cw()) {
                cn();
            }
            cm();
        }
        this.hA.setOnClickListener(this);
        this.hL.setOnClickListener(this);
        this.hC.setOnClickListener(this);
        new com.kwad.sdk.widget.h(getContext(), this.hA, this);
        new com.kwad.sdk.widget.h(getContext(), this.hL, this);
        new com.kwad.sdk.widget.h(getContext(), this.hC, this);
        setOnClickListener(this);
    }

    private void cs() {
        com.kwad.components.core.o.a.b.a aVar = (com.kwad.components.core.o.a.b.a) com.kwad.sdk.components.d.f(com.kwad.components.core.o.a.b.a.class);
        this.fr = aVar;
        if (aVar != null && aVar.qu() && com.kwad.sdk.core.response.b.a.cR(this.mAdInfo)) {
            this.hS = true;
            cv();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.View
    public void onWindowFocusChanged(boolean z) {
        IAdLivePlayModule iAdLivePlayModule;
        try {
            if (this.mAdInfo == null) {
                return;
            }
            super.onWindowFocusChanged(z);
            if (z) {
                if (ct()) {
                    return;
                }
                com.kwad.sdk.core.video.videoview.a aVar = this.cq;
                if (aVar != null && this.hN != null) {
                    ViewGroup viewGroup = (ViewGroup) aVar.getParent();
                    if (this.cq.getParent() != this.hL) {
                        viewGroup.removeView(this.cq);
                        if (this.hL.getTag() != null) {
                            KSRelativeLayout kSRelativeLayout = this.hL;
                            kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
                            this.hL.setTag(null);
                        }
                        this.hL.addView(this.cq);
                        this.hL.setTag(this.cq);
                        this.cq.setVideoSoundEnable(this.mIsAudioEnable);
                        this.mAdTemplate.mIsAudioEnable = this.mIsAudioEnable;
                        this.hN.setAdClickListener(this.hQ);
                        this.hN.getAdTemplate().mAdWebVideoPageShowing = false;
                        this.hN.tU();
                        this.hN.setAutoRelease(true);
                    }
                }
                if (this.mAdInfo != null) {
                    AdVideoPlayerViewCache.getInstance().remove(com.kwad.sdk.core.response.b.a.K(this.mAdInfo));
                    return;
                }
                return;
            }
            IAdLiveOfflineView iAdLiveOfflineView = this.fq;
            if (iAdLiveOfflineView == null || iAdLiveOfflineView.getView() == null || (iAdLivePlayModule = this.hR) == null) {
                return;
            }
            iAdLivePlayModule.onPause();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private boolean ct() {
        IAdLiveOfflineView iAdLiveOfflineView = this.fq;
        if (iAdLiveOfflineView == null || iAdLiveOfflineView.getView() == null || !this.hS) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) this.fq.getView().getParent();
        if (viewGroup != this.hL) {
            viewGroup.removeView(this.fq.getView());
            if (this.hL.getTag() != null) {
                KSRelativeLayout kSRelativeLayout = this.hL;
                kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
                this.hL.setTag(null);
            }
            this.hL.addView(this.fq.getView());
            this.hL.setTag(this.fq.getView());
            IAdLivePlayModule adLivePlayModule = this.fr.getAdLivePlayModule(this.fq, ServiceProvider.getAppId(), String.valueOf(com.kwad.sdk.core.response.b.a.cp(this.mAdInfo)), com.kwad.sdk.core.response.b.a.cq(this.mAdInfo), com.kwad.sdk.core.response.b.a.cr(this.mAdInfo));
            this.hR = adLivePlayModule;
            adLivePlayModule.setAudioEnabled(this.mIsAudioEnable, false);
            this.hR.registerAdLivePlayStateListener(this.eh);
        }
        IAdLivePlayModule iAdLivePlayModule = this.hR;
        if (iAdLivePlayModule == null) {
            return true;
        }
        iAdLivePlayModule.onResume();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IAdLivePlayModule cu() {
        IAdLiveOfflineView iAdLiveOfflineViewA = com.kwad.components.ad.j.c.a(this.fr, this.mContext, 3);
        this.fq = iAdLiveOfflineViewA;
        if (iAdLiveOfflineViewA == null) {
            return null;
        }
        IAdLivePlayModule adLivePlayModule = this.fr.getAdLivePlayModule(iAdLiveOfflineViewA, ServiceProvider.getSDKConfig().appId, String.valueOf(com.kwad.sdk.core.response.b.a.cp(this.mAdInfo)), com.kwad.sdk.core.response.b.a.cq(this.mAdInfo), com.kwad.sdk.core.response.b.a.cr(this.mAdInfo));
        adLivePlayModule.setAudioEnabled(h(this.mIsAudioEnable), false);
        adLivePlayModule.registerAdLivePlayStateListener(this.eh);
        final View view = this.fq.getView();
        if (this.hL.getTag() != null) {
            KSRelativeLayout kSRelativeLayout = this.hL;
            kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
            this.hL.setTag(null);
        }
        this.hL.addView(view);
        this.hL.setTag(view);
        bw.postOnUiThread(new bg() { // from class: com.kwad.components.ad.feed.widget.c.5
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                c.this.d(view);
            }
        });
        if (this.mIsAudioEnable) {
            com.kwad.components.core.t.a.aC(this.mContext).a(this.cB);
        }
        return adLivePlayModule;
    }

    private void cv() {
        String url = com.kwad.sdk.core.response.b.a.bu(this.mAdInfo).getUrl();
        this.hM.setVisibility(0);
        this.fF.setVisibility(0);
        if (!TextUtils.isEmpty(url)) {
            this.hM.setImageDrawable(null);
            KSImageLoader.loadImage(this.hM, url, this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.feed.widget.c.6
                @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                    decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                    return true;
                }
            });
        } else {
            this.hM.setImageResource(R.drawable.ksad_ad_live_end);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final View view) {
        view.post(new bg() { // from class: com.kwad.components.ad.feed.widget.c.7
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                int width = c.this.hL.getWidth();
                int height = c.this.hL.getHeight();
                if (width == 0 || height == 0) {
                    return;
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (height * 0.5625f), height);
                layoutParams.addRule(13, -1);
                view.setLayoutParams(layoutParams);
            }
        });
    }

    public final void b(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        String strEJ;
        this.bU = ksAdVideoPlayConfig;
        if ((ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) && ((KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig).getVideoSoundValue() != 0) {
            this.mIsAudioEnable = ksAdVideoPlayConfig.isVideoSoundEnable();
        } else {
            this.mIsAudioEnable = com.kwad.sdk.core.response.b.a.ca(this.mAdInfo);
        }
        this.mAdTemplate.mIsAudioEnable = this.mIsAudioEnable;
        this.ck = com.kwad.sdk.core.response.b.a.bp(this.mAdInfo);
        if (this.hS) {
            return;
        }
        String url = com.kwad.sdk.core.response.b.a.bu(this.mAdInfo).getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.hM.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.hM.setImageDrawable(null);
            KSImageLoader.loadImage(this.hM, url, this.mAdTemplate);
            this.hM.setVisibility(0);
        } else {
            this.hM.setVisibility(8);
        }
        com.kwad.sdk.core.video.videoview.a aVar = new com.kwad.sdk.core.video.videoview.a(this.mContext);
        this.cq = aVar;
        aVar.setVisibleListener(this.eF);
        this.cq.setOnClickListener(this);
        new com.kwad.sdk.widget.h(getContext(), this.cq, this);
        this.cq.setTag(this.ck);
        int iBQ = com.kwad.sdk.core.config.e.BQ();
        String strK = com.kwad.sdk.core.response.b.a.K(this.mAdInfo);
        if (TextUtils.isEmpty(strK)) {
            return;
        }
        if (iBQ < 0) {
            File fileCf = com.kwad.sdk.core.diskcache.b.a.GP().cf(strK);
            if (fileCf == null || !fileCf.exists()) {
                strK = null;
            } else {
                strEJ = fileCf.getAbsolutePath();
                strK = strEJ;
            }
        } else if (iBQ != 0) {
            com.kwad.sdk.core.videocache.f fVarBR = com.kwad.sdk.core.videocache.c.a.bR(this.mContext);
            if (com.kwad.sdk.core.config.e.ES()) {
                int iBQ2 = com.kwad.sdk.core.config.e.BQ();
                if (!fVarBR.eL(strK)) {
                    if (fVarBR.a(strK, iBQ2 * 1024, new com.kwad.sdk.core.network.a.a.C0498a(), null)) {
                        strEJ = fVarBR.eJ(strK);
                    }
                } else {
                    strEJ = fVarBR.eJ(strK);
                }
                strK = strEJ;
            } else {
                strK = fVarBR.eJ(strK);
            }
        }
        if (TextUtils.isEmpty(strK)) {
            return;
        }
        this.cq.a(new com.kwad.sdk.contentalliance.a.a.b.a(this.mAdTemplate).dg(strK).dh(com.kwad.sdk.core.response.b.h.b(com.kwad.sdk.core.response.b.e.em(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).b(com.kwad.sdk.contentalliance.a.a.a.bQ(this.mAdTemplate)).El(), null);
        com.kwad.sdk.core.video.videoview.a.InterfaceC0502a interfaceC0502a = new com.kwad.sdk.core.video.videoview.a.InterfaceC0502a() { // from class: com.kwad.components.ad.feed.widget.c.9
            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0502a
            public final com.kwad.sdk.core.video.a.c a(com.kwad.sdk.contentalliance.a.a.b bVar) {
                if (!((Boolean) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aBS)).booleanValue() || !((Boolean) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aBT)).booleanValue()) {
                    return null;
                }
                com.kwad.components.core.video.g gVar = new com.kwad.components.core.video.g(bVar, c.this.mAdTemplate);
                if (com.kwad.components.core.video.g.isWaynePlayerReady()) {
                    return gVar;
                }
                return null;
            }
        };
        this.cz = interfaceC0502a;
        this.cq.setExternalPlayerListener(interfaceC0502a);
        this.cq.setVideoSoundEnable(h(this.mIsAudioEnable));
        com.kwad.components.core.video.e eVar = new com.kwad.components.core.video.e(this.mContext, this.mAdTemplate, this.cq, ksAdVideoPlayConfig);
        this.hN = eVar;
        eVar.setAdClickListener(this.hQ);
        this.ht = SystemClock.elapsedRealtime();
        this.hN.setVideoPlayCallback(this.cA);
        this.cq.setController(this.hN);
        if (this.hL.getTag() != null) {
            KSRelativeLayout kSRelativeLayout = this.hL;
            kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
            this.hL.setTag(null);
        }
        this.hL.addView(this.cq);
        this.hL.setTag(this.cq);
        if (cw()) {
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_feed_bottombar_container);
            ((ViewGroup) viewGroup.getParent()).removeView(viewGroup);
            this.hL.addView(viewGroup);
        }
        this.hL.setClickable(true);
        this.hL.setOnClickListener(this);
        new com.kwad.sdk.widget.h(getContext(), this.hL, this);
        if (this.mIsAudioEnable) {
            com.kwad.components.core.t.a.aC(this.mContext).a(this.cB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(boolean z) {
        if (!z) {
            return false;
        }
        if (!com.kwad.sdk.core.config.e.hC()) {
            if (com.kwad.components.core.t.a.aC(this.mContext).sX()) {
                return !com.kwad.components.core.t.a.aC(this.mContext).sW();
            }
            return com.kwad.components.core.t.a.aC(this.mContext).aQ(false);
        }
        if (!this.cp) {
            this.cp = com.kwad.components.core.t.a.aC(this.mContext).aQ(true);
        }
        return this.cp;
    }

    protected final boolean cw() {
        if (FeedType.isNewVerticalType(com.kwad.sdk.core.response.b.e.eG(this.mAdTemplate))) {
            return com.kwad.sdk.core.response.b.e.eH(this.mAdTemplate) == FeedType.FeedDefaultType.FEED_VERTICAL_NOVEL_DEFAULT.getDefaultType() || com.kwad.sdk.core.response.b.e.eH(this.mAdTemplate) == FeedType.FeedDefaultType.FEED_VERTICAL_BISERIAL_DEFAULT.getDefaultType();
        }
        return false;
    }

    private void cm() {
        this.hF = (TextView) findViewById(R.id.ksad_h5_desc);
        this.gD = (TextView) findViewById(R.id.ksad_h5_open_btn);
        this.hG = findViewById(R.id.ksad_h5_open_cover);
        this.hF.setText(com.kwad.components.ad.feed.f.l(this.mAdTemplate));
        this.gD.setText(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo));
        this.hG.setOnClickListener(this);
        this.hF.setOnClickListener(this);
        this.gD.setOnClickListener(this);
        new com.kwad.sdk.widget.h(getContext(), this.hG, this);
        new com.kwad.sdk.widget.h(getContext(), this.hF, this);
        new com.kwad.sdk.widget.h(getContext(), this.gD, this);
    }

    private void cn() {
        this.gw = (ImageView) findViewById(R.id.ksad_app_icon);
        this.ee = (TextView) findViewById(R.id.ksad_app_title);
        TextView textView = (TextView) findViewById(R.id.ksad_app_desc);
        this.hE = textView;
        com.kwad.sdk.c.a.a.a(this, this.gw, this.ee, textView);
        new com.kwad.sdk.widget.h(getContext(), this.gw, this);
        new com.kwad.sdk.widget.h(getContext(), this.ee, this);
        new com.kwad.sdk.widget.h(getContext(), this.hE, this);
        if (cw()) {
            this.ee.setText(com.kwad.sdk.core.response.b.a.cl(this.mAdInfo));
        } else {
            this.ee.setText(com.kwad.sdk.core.response.b.a.av(this.mAdInfo));
        }
        this.gw.setImageResource(R.drawable.ksad_default_app_icon);
        KSImageLoader.loadAppIcon(this.gw, com.kwad.sdk.core.response.b.a.co(this.mAdInfo), this.mAdTemplate, this.hJ);
        this.hE.setText(com.kwad.components.ad.feed.f.l(this.mAdTemplate));
        if (this.hI) {
            ck();
        }
    }

    private void cx() {
        this.hH.at(this.mAdTemplate);
        this.hH.setOnClickListener(this);
        new com.kwad.sdk.widget.h(getContext(), this.hH, this);
        com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate, null, this.hH.getAppDownloadListener());
        this.mApkDownloadHelper = cVar;
        cVar.d(this.hH.getAppDownloadListener());
        this.mApkDownloadHelper.setOnShowListener(this);
        this.mApkDownloadHelper.setOnDismissListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        int iCeil = (int) Math.ceil(j / 1000.0f);
        List<Integer> list = this.ck;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.ck.iterator();
        while (it.hasNext()) {
            if (iCeil >= it.next().intValue()) {
                com.kwad.sdk.core.adlog.c.a((AdTemplate) this.mAdTemplate, iCeil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        onClick(view);
    }

    @Override // com.kwad.sdk.widget.d
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.ea(this.mAdTemplate)) {
            a(this.cq, view == this.hH, 153);
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003a  */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        com.kwad.sdk.core.video.videoview.a aVar;
        if (view == this.hC) {
            vW();
            return;
        }
        if (view == this.hL && (aVar = this.cq) != null && aVar.isIdle()) {
            com.kwad.sdk.utils.n.eL(this.mAdTemplate);
            this.cq.setKsPlayLogParam(com.kwad.sdk.contentalliance.a.a.a.bQ(this.mAdTemplate));
            this.cq.start();
            return;
        }
        if (view == this.hA) {
            i = 25;
        } else if (view == this.hL) {
            i = 100;
        } else if (view == this.hH || view == this.gD || view == this.hG) {
            i = 1;
        } else if (view == this.gw) {
            i = 13;
        } else if (view == this.ee) {
            i = 14;
        } else if (view == this.hE || view == this.hF) {
            i = 101;
        } else if (view == this.cq) {
            i = 100;
        } else {
            i = 35;
        }
        a(this.cq, view == this.hH, i);
    }

    private void a(com.kwad.sdk.core.video.videoview.a aVar, boolean z, final int i) {
        com.kwad.components.core.video.e eVar;
        if (aVar != null || this.hS) {
            String strK = com.kwad.sdk.core.response.b.a.K(this.mAdInfo);
            if (!this.hS && (eVar = this.hN) != null) {
                eVar.setAutoRelease(false);
            }
            int i2 = z ? 1 : 2;
            if (!this.hS) {
                AdVideoPlayerViewCache.getInstance().a(strK, this.cq);
            }
            cj();
            com.kwad.components.core.e.d.a.C0426a c0426aAq = new com.kwad.components.core.e.d.a.C0426a(getContext()).aB(this.mAdTemplate).b(this.mApkDownloadHelper).aq(z);
            IAdLivePlayModule iAdLivePlayModule = this.hR;
            com.kwad.components.core.e.d.a.a(c0426aAq.A(iAdLivePlayModule == null ? 0L : iAdLivePlayModule.getPlayDuration()).aB(i2).au(true).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.feed.widget.c.11
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    c.this.ba(i);
                }
            }));
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void aa() {
        DownloadProgressView downloadProgressView;
        super.aa();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar == null || (downloadProgressView = this.hH) == null) {
            return;
        }
        cVar.b(downloadProgressView.getAppDownloadListener());
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void ab() {
        super.ab();
        com.kwad.sdk.utils.n.eK(this.mAdTemplate);
        IAdLivePlayModule iAdLivePlayModule = this.hR;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onDestroy();
            this.hR = null;
        }
        IAdLiveOfflineView iAdLiveOfflineView = this.fq;
        if (iAdLiveOfflineView != null) {
            iAdLiveOfflineView.onDestroy();
            this.fq = null;
        }
        com.kwad.components.core.k.a.qp().c(this.fD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.kwad.components.core.k.a.b getCurrentVoiceItem() {
        if (this.fD == null) {
            this.fD = new com.kwad.components.core.k.a.b(new com.kwad.components.core.k.a.c() { // from class: com.kwad.components.ad.feed.widget.c.3
                @Override // com.kwad.components.core.k.a.c
                public final void bF() {
                    if (c.this.hS) {
                        if (c.this.hR == null) {
                            c cVar = c.this;
                            cVar.hR = cVar.cu();
                        }
                        if (c.this.hR != null) {
                            IAdLivePlayModule iAdLivePlayModule = c.this.hR;
                            c cVar2 = c.this;
                            iAdLivePlayModule.setAudioEnabled(cVar2.h(cVar2.mIsAudioEnable), false);
                            return;
                        }
                        return;
                    }
                    if (c.this.cq != null) {
                        com.kwad.sdk.core.video.videoview.a aVar = c.this.cq;
                        c cVar3 = c.this;
                        aVar.setVideoSoundEnable(cVar3.h(cVar3.mIsAudioEnable));
                    }
                }
            });
        }
        return this.fD;
    }

    public void setmIsShowComplianceView(boolean z) {
        this.hI = z;
    }

    public void setRadiusDp(int i) {
        this.hJ = i;
    }
}
