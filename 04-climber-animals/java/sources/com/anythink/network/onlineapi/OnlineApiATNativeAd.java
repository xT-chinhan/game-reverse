package com.anythink.network.onlineapi;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.basead.d;
import com.anythink.basead.d.f;
import com.anythink.basead.f.a;
import com.anythink.basead.g.j;
import com.anythink.basead.ui.OwnNativeATView;
import com.anythink.core.common.h.n;
import com.anythink.nativead.api.ATNativePrepareExInfo;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.anythink.network.adx.AdxAppInfo;

/* JADX INFO: loaded from: classes.dex */
public class OnlineApiATNativeAd extends CustomNativeAd {
    a a;
    Context b;
    View c;

    /* JADX WARN: Code duplicated, block: B:15:0x007f  */
    public OnlineApiATNativeAd(Context context, a aVar) {
        this.b = context.getApplicationContext();
        this.a = aVar;
        aVar.a(new com.anythink.basead.g.a() { // from class: com.anythink.network.onlineapi.OnlineApiATNativeAd.1
            @Override // com.anythink.basead.g.a
            public final void onAdClosed() {
            }

            @Override // com.anythink.basead.g.a
            public final void onShowFailed(f fVar) {
            }

            @Override // com.anythink.basead.g.a
            public final void onAdShow(j jVar) {
                OnlineApiATNativeAd.this.notifyAdImpression();
            }

            @Override // com.anythink.basead.g.a
            public final void onAdClick(j jVar) {
                n detail = OnlineApiATNativeAd.this.getDetail();
                if (detail != null) {
                    detail.I(jVar.a);
                    detail.J(jVar.b);
                }
                OnlineApiATNativeAd.this.notifyAdClicked();
            }

            @Override // com.anythink.basead.g.a
            public final void onDeeplinkCallback(boolean z) {
                OnlineApiATNativeAd.this.notifyDeeplinkCallback(z);
            }
        });
        setNetworkInfoMap(d.a(this.a.a()));
        setAdChoiceIconUrl(this.a.h());
        setTitle(this.a.c());
        setDescriptionText(this.a.d());
        setIconImageUrl(this.a.f());
        setMainImageUrl(this.a.g());
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
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public ViewGroup getCustomAdContainer() {
        if (this.a != null) {
            return new OwnNativeATView(this.b);
        }
        return null;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdMediaView(Object... objArr) {
        if (this.c == null) {
            this.c = this.a.a(this.b, false, null);
        }
        return this.c;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        if (this.a != null) {
            this.a.a(view, aTNativePrepareInfo.getClickViewList(), aTNativePrepareInfo instanceof ATNativePrepareExInfo ? ((ATNativePrepareExInfo) aTNativePrepareInfo).getCreativeClickViewList() : null, aTNativePrepareInfo.getChoiceViewLayoutParams(), aTNativePrepareInfo.getCloseView());
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
}
