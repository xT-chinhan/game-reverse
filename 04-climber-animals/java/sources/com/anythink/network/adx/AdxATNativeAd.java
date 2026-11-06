package com.anythink.network.adx;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.basead.d;
import com.anythink.basead.f.a;
import com.anythink.basead.g.e;
import com.anythink.basead.g.f;
import com.anythink.basead.g.j;
import com.anythink.basead.ui.BaseMediaATView;
import com.anythink.core.api.ATShakeViewListener;
import com.anythink.core.common.f.b;
import com.anythink.core.common.f.c;
import com.anythink.core.common.h.bj;
import com.anythink.core.common.h.x;
import com.anythink.nativead.api.ATNativePrepareExInfo;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class AdxATNativeAd extends CustomNativeAd {
    a a;
    x b;
    Context c;
    boolean d;
    boolean e;
    View f;
    e g;

    /* JADX WARN: Code duplicated, block: B:25:0x00c5  */
    public AdxATNativeAd(final Context context, a aVar, x xVar, boolean z, boolean z2) {
        this.c = context.getApplicationContext();
        this.a = aVar;
        this.b = xVar;
        setNetworkInfoMap(d.a(aVar.a()));
        f fVar = new f(this.a.a(), null) { // from class: com.anythink.network.adx.AdxATNativeAd.1
            @Override // com.anythink.basead.g.a
            public final void onShowFailed(com.anythink.basead.d.f fVar2) {
            }

            @Override // com.anythink.basead.g.f
            public final void onATImproveClickViewRenderFail(int i) {
                if (AdxATNativeAd.this.a.a() != null && AdxATNativeAd.this.a.a().b() == 2 && (AdxATNativeAd.this.a.a() instanceof bj)) {
                    com.anythink.core.common.u.e.a(AdxATNativeAd.this.getDetail(), ((bj) AdxATNativeAd.this.a.a()).aC(), AdxATNativeAd.this.a.a().v(), i);
                }
            }

            @Override // com.anythink.basead.g.e, com.anythink.basead.g.a
            public final void onAdShow(j jVar) {
                super.onAdShow(jVar);
                AdxATNativeAd.this.notifyAdImpression();
                if (AdxATNativeAd.this.a.a().t() == 67) {
                    if (AdxATNativeAd.this.a.a(true, true)) {
                        c.a(context).a(AdxATNativeAd.this.a.a().v(), 0, 1);
                    }
                    if (AdxATNativeAd.this.a.a(false, true)) {
                        b.a(context).a(AdxATNativeAd.this.a.a().v(), 0, 1);
                    }
                }
            }

            @Override // com.anythink.basead.g.a
            public final void onAdClosed() {
                AdxATNativeAd.this.notifyAdDislikeClick();
            }

            @Override // com.anythink.basead.g.e, com.anythink.basead.g.a
            public final void onAdClick(j jVar) {
                super.onAdClick(jVar);
                AdxATNativeAd.this.notifyAdClicked();
                if (AdxATNativeAd.this.a.a().t() == 67) {
                    if (AdxATNativeAd.this.a.a(true, false)) {
                        c.a(context).a(AdxATNativeAd.this.a.a().v(), 1, 0);
                    }
                    if (AdxATNativeAd.this.a.a(false, false)) {
                        b.a(context).a(AdxATNativeAd.this.a.a().v(), 1, 0);
                    }
                }
            }

            @Override // com.anythink.basead.g.a
            public final void onDeeplinkCallback(boolean z3) {
                if (AdxATNativeAd.this.b == null || AdxATNativeAd.this.b.o == null || AdxATNativeAd.this.b.o.bF() <= 0) {
                    AdxATNativeAd.this.notifyDeeplinkCallback(z3);
                }
            }
        };
        this.g = fVar;
        this.a.a(fVar);
        this.a.a(new com.anythink.basead.ui.a.InterfaceC0052a() { // from class: com.anythink.network.adx.AdxATNativeAd.2
            @Override // com.anythink.basead.ui.a.InterfaceC0052a
            public final void onVideoAdStartPlay(long j) {
                AdxATNativeAd.this.setVideoDuration(j / 1000.0d);
                AdxATNativeAd.this.notifyAdVideoStart();
            }

            @Override // com.anythink.basead.ui.a.InterfaceC0052a
            public final void onVideoAdComplete() {
                AdxATNativeAd.this.notifyAdVideoEnd();
            }

            @Override // com.anythink.basead.ui.a.InterfaceC0052a
            public final void onVideoError(String str, String str2) {
                AdxATNativeAd.this.notifyAdVideoVideoPlayFail(str, str2);
            }

            @Override // com.anythink.basead.ui.a.InterfaceC0052a
            public final void onProgressUpdate(long j, long j2) {
                if (AdxATNativeAd.this.getVideoDuration() == 0.0d) {
                    AdxATNativeAd.this.setVideoDuration(j2 / 1000.0d);
                }
                AdxATNativeAd.this.notifyAdVideoPlayProgress((int) (j / 1000.0d));
            }
        });
        this.d = z;
        this.e = z2;
        int iW = this.a.w();
        if (iW == 1) {
            this.mAdSourceType = "1";
        } else if (iW == 2) {
            this.mAdSourceType = "2";
        }
        if (this.a.p()) {
            return;
        }
        setAdChoiceIconUrl(this.a.h());
        setTitle(this.a.c());
        setDescriptionText(this.a.d());
        setIconImageUrl(this.a.f());
        String strG = this.a.g();
        setMainImageUrl(strG);
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(strG)) {
            arrayList.add(strG);
        }
        setImageUrlList(arrayList);
        setCallToActionText(this.a.e());
        if (this.a.o()) {
            setAdAppInfo(new AdxAppInfo(this.a));
        }
        int iZ = this.a.z();
        if (iZ == 1) {
            setNativeInteractionType(1);
        } else if (iZ == 2 || iZ == 3) {
            setNativeInteractionType(2);
        } else if (iZ == 4) {
            setNativeInteractionType(1);
        }
        setMainImageWidth(this.a.x());
        setMainImageHeight(this.a.y());
        setVideoWidth(this.a.D());
        setVideoHeight(this.a.E());
        setVideoDuration(this.a.F() / 1000.0d);
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public boolean isNativeExpress() {
        return this.a.p();
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdMediaView(Object... objArr) {
        if (this.f == null) {
            this.f = this.a.a(this.c, this.e, new BaseMediaATView.a() { // from class: com.anythink.network.adx.AdxATNativeAd.3
                @Override // com.anythink.basead.ui.BaseMediaATView.a
                public final void onClickCloseView() {
                    AdxATNativeAd.this.notifyAdDislikeClick();
                }
            });
        }
        return this.f;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public ViewGroup getCustomAdContainer() {
        return this.a.b();
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        e eVar = this.g;
        if (eVar != null) {
            eVar.updateTrackingInfo(getDetail());
            AdxATInitManager.getInstance();
            AdxATInitManager.a(getDetail(), this.b);
        }
        a aVar = this.a;
        if (aVar != null) {
            aVar.s();
        }
        if (this.a != null) {
            this.a.a(view, aTNativePrepareInfo.getClickViewList(), aTNativePrepareInfo instanceof ATNativePrepareExInfo ? ((ATNativePrepareExInfo) aTNativePrepareInfo).getCreativeClickViewList() : null, aTNativePrepareInfo.getChoiceViewLayoutParams(), aTNativePrepareInfo.getCloseView());
            if (this.d || this.a.a() == null || this.a.a().b() != 2 || !(this.a.a() instanceof bj)) {
                return;
            }
            View view2 = this.f;
            com.anythink.core.common.u.e.a(getDetail(), ((bj) this.a.a()).aC(), this.a.a().v(), (view2 == null || view2.getParent() == null) ? false : true);
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void onResume() {
        a aVar = this.a;
        if (aVar != null) {
            aVar.s();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void onPause() {
        a aVar = this.a;
        if (aVar != null) {
            aVar.t();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void clear(View view) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.q();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a((com.anythink.basead.g.a) null);
            this.a.r();
        }
    }

    @Override // com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public int getDownloadStatus() {
        int iA;
        a aVar = this.a;
        if (aVar == null || (iA = aVar.A()) < 0) {
            return 0;
        }
        return iA;
    }

    @Override // com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getShakeView(int i, int i2, ATShakeViewListener aTShakeViewListener) {
        return this.a.B();
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void resumeVideo() {
        this.a.u();
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void pauseVideo() {
        this.a.v();
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void setVideoMute(boolean z) {
        this.a.b(z);
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public double getVideoProgress() {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.C() / 1000.0d;
        }
        return super.getVideoProgress();
    }
}
