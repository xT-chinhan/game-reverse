package com.anythink.network.myoffer;

import android.content.Context;
import android.view.View;
import com.anythink.basead.d;
import com.anythink.basead.d.f;
import com.anythink.basead.g.a;
import com.anythink.basead.g.j;
import com.anythink.basead.h.e;
import com.anythink.core.common.h.n;
import com.anythink.nativead.api.ATNativePrepareExInfo;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;

/* JADX INFO: loaded from: classes.dex */
public class MyOfferATNativeAd extends CustomNativeAd {
    e a;
    Context b;
    View c;

    /* JADX WARN: Code duplicated, block: B:12:0x006d  */
    public MyOfferATNativeAd(Context context, e eVar) {
        this.b = context.getApplicationContext();
        this.a = eVar;
        eVar.a(new a() { // from class: com.anythink.network.myoffer.MyOfferATNativeAd.1
            @Override // com.anythink.basead.g.a
            public final void onAdClosed() {
            }

            @Override // com.anythink.basead.g.a
            public final void onDeeplinkCallback(boolean z) {
            }

            @Override // com.anythink.basead.g.a
            public final void onShowFailed(f fVar) {
            }

            @Override // com.anythink.basead.g.a
            public final void onAdShow(j jVar) {
                MyOfferATNativeAd.this.notifyAdImpression();
            }

            @Override // com.anythink.basead.g.a
            public final void onAdClick(j jVar) {
                n detail = MyOfferATNativeAd.this.getDetail();
                if (detail != null) {
                    detail.I(jVar.a);
                    detail.J(jVar.b);
                }
                MyOfferATNativeAd.this.notifyAdClicked();
            }
        });
        setNetworkInfoMap(d.a(this.a.e()));
        setAdChoiceIconUrl(this.a.k());
        setTitle(this.a.b());
        setDescriptionText(this.a.g());
        setIconImageUrl(this.a.i());
        setMainImageUrl(this.a.j());
        setCallToActionText(this.a.h());
        int iQ = this.a.q();
        if (iQ == 1) {
            setNativeInteractionType(1);
        } else if (iQ == 2 || iQ == 3) {
            setNativeInteractionType(2);
        } else if (iQ == 4) {
            setNativeInteractionType(1);
        }
        setMainImageWidth(this.a.m());
        setMainImageHeight(this.a.n());
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdMediaView(Object... objArr) {
        if (this.c == null) {
            this.c = e.l();
        }
        return this.c;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        if (this.a != null) {
            this.a.a(view, aTNativePrepareInfo.getClickViewList(), aTNativePrepareInfo instanceof ATNativePrepareExInfo ? ((ATNativePrepareExInfo) aTNativePrepareInfo).getCreativeClickViewList() : null);
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void clear(View view) {
        e eVar = this.a;
        if (eVar != null) {
            eVar.o();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        e eVar = this.a;
        if (eVar != null) {
            eVar.a((a) null);
            this.a.p();
        }
    }

    @Override // com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public int getDownloadStatus() {
        int iR;
        e eVar = this.a;
        if (eVar == null || (iR = eVar.r()) < 0) {
            return 0;
        }
        return iR;
    }
}
