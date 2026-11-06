package com.kwad.components.ad.interstitial.f;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.h;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.widget.KSFrameLayout;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends b implements com.kwad.sdk.widget.d {
    private KsAdVideoPlayConfig bU;
    private List<Integer> ck;
    private com.kwad.sdk.core.video.videoview.a cq;
    private com.kwad.sdk.core.video.videoview.a.InterfaceC0502a cz;
    private KSFrameLayout fC;
    private ImageView hM;
    protected AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    protected Context mContext;
    private c mj;
    private KSFrameLayout ni;
    private com.kwad.components.core.video.f nj;
    private boolean mIsAudioEnable = false;
    private final com.kwad.components.core.video.a.InterfaceC0445a hQ = new com.kwad.components.core.video.a.InterfaceC0445a() { // from class: com.kwad.components.ad.interstitial.f.f.4
        /* JADX WARN: Code duplicated, block: B:15:0x0024  */
        @Override // com.kwad.components.core.video.a.InterfaceC0445a
        public final void a(int i, aj.a aVar) {
            final int i2;
            int i3;
            boolean z = false;
            if (i == 1) {
                i2 = 13;
            } else {
                if (i != 2) {
                    if (i != 3) {
                        i2 = 108;
                    } else {
                        i2 = 83;
                        z = true;
                        i3 = 1;
                    }
                    f.this.getContext();
                    int i4 = aq.QW() ? 2 : 1;
                    com.kwad.components.ad.interstitial.report.a.eO().a(f.this.mAdTemplate, 1L, i2);
                    com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C0426a(f.this.getContext()).aB(f.this.mAdTemplate).b(f.this.mApkDownloadHelper).aB(i3).aq(z).as(true).aA(i2).d(aVar).aC(i4).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.interstitial.f.f.4.1
                        @Override // com.kwad.components.core.e.d.a.b
                        public final void onAdClicked() {
                            f.this.l(i2);
                        }
                    }));
                }
                i2 = 82;
            }
            i3 = 2;
            f.this.getContext();
            if (aq.QW()) {
            }
            com.kwad.components.ad.interstitial.report.a.eO().a(f.this.mAdTemplate, 1L, i2);
            com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C0426a(f.this.getContext()).aB(f.this.mAdTemplate).b(f.this.mApkDownloadHelper).aB(i3).aq(z).as(true).aA(i2).d(aVar).aC(i4).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.interstitial.f.f.4.1
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    f.this.l(i2);
                }
            }));
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ni = (KSFrameLayout) getRootView().findViewById(R.id.ksad_container);
        this.fC = (KSFrameLayout) getRootView().findViewById(R.id.ksad_video_container);
        this.hM = (ImageView) getRootView().findViewById(R.id.ksad_video_first_frame_container);
        this.fC.setVisibility(4);
        this.mContext = getContext();
    }

    @Override // com.kwad.components.ad.interstitial.f.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        c cVar = (c) NN();
        this.mj = cVar;
        this.bU = cVar.bU;
        AdTemplate adTemplate = this.mj.mAdTemplate;
        this.mAdTemplate = adTemplate;
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        this.mAdInfo = adInfoEl;
        this.ck = com.kwad.sdk.core.response.b.a.bp(adInfoEl);
        com.kwad.sdk.core.video.videoview.a aVar = this.mj.cq;
        this.cq = aVar;
        aVar.setTag(this.ck);
        com.kwad.components.core.video.f fVar = new com.kwad.components.core.video.f(this.mContext, this.mAdTemplate, this.cq);
        this.nj = fVar;
        fVar.setDataFlowAutoStart(this.bU.isDataFlowAutoStart());
        this.nj.setAdClickListener(this.hQ);
        this.nj.ty();
        this.mApkDownloadHelper = this.mj.mApkDownloadHelper;
        ex();
        float dimension = getContext().getResources().getDimension(R.dimen.ksad_interstitial_card_radius);
        this.fC.setRadius(dimension, dimension, 0.0f, 0.0f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mj.mr = null;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
    }

    private void ex() {
        String strEJ;
        this.mIsAudioEnable = this.bU.isVideoSoundEnable();
        String url = com.kwad.sdk.core.response.b.a.bu(this.mAdInfo).getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.hM.setImageDrawable(null);
            KSImageLoader.loadImage(this.hM, url, this.mAdTemplate);
            this.hM.setVisibility(0);
        } else {
            this.hM.setVisibility(8);
        }
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
            if (com.kwad.sdk.core.config.e.EU()) {
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
        this.cq.a(new com.kwad.sdk.contentalliance.a.a.b.a(this.mAdTemplate).dg(strK).dh(h.b(com.kwad.sdk.core.response.b.e.em(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).b(new com.kwad.sdk.contentalliance.a.a.a(this.mAdTemplate, System.currentTimeMillis())).El(), null);
        com.kwad.sdk.core.video.videoview.a.InterfaceC0502a interfaceC0502a = new com.kwad.sdk.core.video.videoview.a.InterfaceC0502a() { // from class: com.kwad.components.ad.interstitial.f.f.1
            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0502a
            public final com.kwad.sdk.core.video.a.c a(com.kwad.sdk.contentalliance.a.a.b bVar) {
                if (!((Boolean) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aBS)).booleanValue() || !((Boolean) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aBT)).booleanValue()) {
                    return null;
                }
                com.kwad.components.core.video.g gVar = new com.kwad.components.core.video.g(bVar, f.this.mAdTemplate);
                if (com.kwad.components.core.video.g.isWaynePlayerReady()) {
                    return gVar;
                }
                return null;
            }
        };
        this.cz = interfaceC0502a;
        this.cq.setExternalPlayerListener(interfaceC0502a);
        this.cq.setVideoSoundEnable(this.mIsAudioEnable);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.kwad.components.ad.interstitial.report.d.eU().E(this.mAdTemplate);
        this.nj.setVideoPlayCallback(new com.kwad.components.core.video.f.a() { // from class: com.kwad.components.ad.interstitial.f.f.2
            private boolean eE = false;

            @Override // com.kwad.components.core.video.a.c
            public final void d(long j) {
                f.this.c(j);
                Iterator<com.kwad.components.core.video.a.c> it = f.this.mj.mt.iterator();
                while (it.hasNext()) {
                    it.next().d(j);
                }
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                com.kwad.sdk.core.adlog.c.bX(f.this.mAdTemplate);
                com.kwad.components.ad.interstitial.report.d.eU().b(f.this.mAdTemplate, System.currentTimeMillis() - jCurrentTimeMillis);
                com.kwad.components.ad.interstitial.report.b.eQ().x(f.this.mAdTemplate);
                if (!f.this.mj.mn && f.this.mj.kQ != null) {
                    f.this.mj.kQ.onVideoPlayStart();
                }
                Iterator<com.kwad.components.core.video.a.c> it = f.this.mj.mt.iterator();
                while (it.hasNext()) {
                    it.next().onVideoPlayStart();
                }
                f.this.mj.mv = false;
            }

            @Override // com.kwad.components.core.video.f.a
            public final void onVideoPlayError(int i, int i2) {
                com.kwad.components.ad.interstitial.report.d.eU().b(f.this.mAdTemplate, i, String.valueOf(i2));
                if (f.this.mj.kQ != null) {
                    f.this.mj.kQ.onVideoPlayError(i, i2);
                }
            }

            @Override // com.kwad.components.core.video.a.c
            public final void aq() {
                if (!this.eE) {
                    this.eE = true;
                    com.kwad.components.core.p.a.se().a(f.this.mAdTemplate, System.currentTimeMillis(), 0);
                }
                Iterator<com.kwad.components.core.video.a.c> it = f.this.mj.mt.iterator();
                while (it.hasNext()) {
                    it.next().aq();
                }
            }

            @Override // com.kwad.components.core.video.a.c
            public final void ar() {
                com.kwad.sdk.core.adlog.c.bY(f.this.mAdTemplate);
                if (!f.this.mj.mn && f.this.mj.kQ != null) {
                    f.this.mj.kQ.onVideoPlayEnd();
                }
                Iterator<com.kwad.components.core.video.a.c> it = f.this.mj.mt.iterator();
                while (it.hasNext()) {
                    it.next().ar();
                }
                f.this.mj.mv = true;
            }
        });
        this.cq.setController(this.nj);
        this.fC.setClickable(true);
        new com.kwad.sdk.widget.h(this.fC.getContext(), this.fC, this);
        this.fC.addView(this.cq);
        this.mj.mr = new c.e() { // from class: com.kwad.components.ad.interstitial.f.f.3
            @Override // com.kwad.components.ad.interstitial.f.c.e
            public final void ec() {
                if (f.this.cq != null) {
                    f.this.cq.restart();
                }
            }
        };
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
                com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, iCeil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(long j) {
        this.mj.ml = true;
        this.mj.c(1L, j);
    }

    private c.C0377c c(View view, boolean z) {
        return new c.C0377c(view.getContext()).l(z).a(this.ni.getTouchCoords()).L(3).M(85);
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        this.mj.a(c(view, true));
    }

    @Override // com.kwad.sdk.widget.d
    public final void b(View view) {
        this.mj.a(c(view, false));
    }
}
