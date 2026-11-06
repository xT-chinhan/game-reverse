package com.anythink.basead.mixad.e;

import android.util.Log;
import com.anythink.core.api.ATAdAppInfo;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.y;
import com.anythink.core.common.l.g.d;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a extends w implements Serializable {
    final String a = "a";

    @Override // com.anythink.core.common.h.w
    public final String a() {
        return "";
    }

    @Override // com.anythink.core.common.h.w
    public final int b() {
        return 10;
    }

    @Override // com.anythink.core.common.h.w
    public final boolean c() {
        return true;
    }

    public a(d dVar) {
        o(dVar.getIconImageUrl());
        Double starRating = dVar.getStarRating();
        if (starRating != null) {
            i(starRating.intValue());
        }
        q(dVar.getMainImageUrl());
        m(dVar.getTitle());
        s(dVar.getCallToActionText());
        n(dVar.getDescriptionText());
        r(dVar.getAdChoiceIconUrl());
        a(dVar.getAdLogo());
        G(dVar.getAdFrom());
        F(dVar.getWarning());
        E(dVar.getDomain());
        ATAdAppInfo adAppInfo = dVar.getAdAppInfo();
        if (adAppInfo != null) {
            if (t.b().F()) {
                Log.i("a", "AdAppInfo:" + dVar.getAdAppInfo().toString());
            }
            z(adAppInfo.getPublisher());
            A(adAppInfo.getAppVersion());
            B(adAppInfo.getAppPrivacyUrl());
            C(adAppInfo.getAppPermissonUrl());
            c(adAppInfo.getFunctionUrl());
        }
        c(new c(dVar));
    }

    @Override // com.anythink.core.common.h.w
    public final List<String> a(y yVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(B());
        return arrayList;
    }

    @Override // com.anythink.core.common.h.w
    public final List<String> b(y yVar) {
        return new ArrayList();
    }

    public String toString() {
        return "ThirdPartyAdContent{, offerId='" + this.m + "', creativeId='" + this.n + "', title='" + this.o + "', desc='" + this.p + "', iconUrl='" + this.q + "', mainImageUrl='" + this.r + "', endCardImageUrl='" + this.s + "', adChoiceUrl='" + this.t + "', ctaText='" + this.u + "', videoUrl='" + this.v + "', previewUrl='" + this.w + "', deeplinkUrl='" + this.x + "', clickUrl='" + this.y + "', pkgName='" + this.z + "', unitType=" + this.A + ", clickType=" + this.D + ", rating=" + this.E + ", adLogoTitle='" + this.F + "', offerNetworkFirmId=" + this.G + ", jumpUrl='" + this.H + "', publisher='" + this.I + "', appVersion='" + this.J + "', privacyUrl='" + this.K + "', permissionUrl='" + this.L + "', functionUrl='" + this.M + "', templateVersion='" + this.N + "', adLogo=" + this.O + ", baseAdSetting=" + this.P + ", requestId='" + this.Q + "', webControlObject='" + this.R + "', protocolType=" + this.S + ", offerHtml='" + this.T + "', offerUrl='" + this.U + "', wxUserName='" + this.V + "', wxPath='" + this.W + "', offerWidth=" + this.X + ", offerHeight=" + this.Y + ", mApkDownloadStatus=" + this.Z + ", mNativeMainImageWidth=" + this.aa + ", mNativeMainImageHeight=" + this.ab + ", mVideoWidth=" + this.ac + ", mVideoHeight=" + this.ad + ", mVideoDuration=" + this.ae + ", deeplinkPackageInstallState=" + this.af + ", mraidJSUrl='" + this.ah + "'}";
    }
}
