package com.kwad.components.ad.interstitial.a;

import android.text.TextUtils;
import com.kwad.components.ad.interstitial.report.b;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.videocache.f;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.w;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static boolean s(AdTemplate adTemplate) {
        boolean zA;
        f fVarBR;
        String strK = com.kwad.sdk.core.response.b.a.K(e.el(adTemplate));
        if (TextUtils.isEmpty(strK)) {
            b.eQ().b(adTemplate, "empty videoUrl");
            return false;
        }
        b.eQ().x(adTemplate);
        int iBQ = com.kwad.sdk.core.config.e.BQ();
        String str = "";
        if (iBQ < 0) {
            File fileCf = com.kwad.sdk.core.diskcache.b.a.GP().cf(strK);
            if (w.O(fileCf)) {
                zA = true;
            } else {
                com.kwad.sdk.core.network.a.a.C0498a c0498a = new com.kwad.sdk.core.network.a.a.C0498a();
                zA = com.kwad.sdk.core.diskcache.b.a.GP().a(strK, c0498a);
                str = c0498a.msg;
            }
            adTemplate.setDownloadSize(fileCf != null ? fileCf.length() : 0L);
            adTemplate.setDownloadType(2);
        } else if (iBQ > 0) {
            com.kwad.sdk.core.network.a.a.C0498a c0498a2 = new com.kwad.sdk.core.network.a.a.C0498a();
            if (com.kwad.sdk.core.config.e.Ge() == 1) {
                fVarBR = com.kwad.sdk.core.videocache.c.a.b(ServiceProvider.getContext(), 1, 0);
            } else if (com.kwad.sdk.core.config.e.Ge() == 2) {
                fVarBR = com.kwad.sdk.core.videocache.c.a.b(ServiceProvider.getContext(), 1, 1);
            } else {
                fVarBR = com.kwad.sdk.core.videocache.c.a.bR(ServiceProvider.getContext());
            }
            zA = !fVarBR.eL(strK) ? fVarBR.a(strK, iBQ * 1024, c0498a2, null) : true;
            str = c0498a2.msg;
            adTemplate.setDownloadSize(((long) iBQ) * 1024);
            adTemplate.setDownloadType(3);
        } else {
            adTemplate.setDownloadSize(0L);
            adTemplate.setDownloadType(1);
            zA = true;
        }
        if (!zA) {
            adTemplate.setDownloadStatus(2);
            b.eQ().b(adTemplate, str);
            com.kwad.components.ad.interstitial.report.realtime.a.eW();
            com.kwad.components.ad.interstitial.report.realtime.a.b(str, adTemplate);
        } else {
            adTemplate.setDownloadStatus(1);
        }
        return zA;
    }
}
