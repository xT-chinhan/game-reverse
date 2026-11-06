package com.kwad.sdk.core.track;

import android.text.TextUtils;
import com.kwad.components.ad.reward.monitor.FraudVerifyCode;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.g;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.bw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static boolean dK(int i) {
        return i >= 200 && i < 300;
    }

    public static void e(com.kwad.sdk.core.adlog.c.a aVar) {
        AdTemplate adTemplate = aVar.adTemplate;
        AdInfo adInfoEl = e.el(adTemplate);
        int i = aVar.awx;
        List<String> listA = a(adTemplate, i, aVar);
        if (ap.L(listA)) {
            return;
        }
        boolean zDw = com.kwad.sdk.core.response.b.a.dw(adInfoEl);
        boolean zDx = com.kwad.sdk.core.response.b.a.dx(adInfoEl);
        for (String str : listA) {
            com.kwad.sdk.commercial.j.a.o(adTemplate, i, str);
            if (adTemplate.isCheatingFlow()) {
                com.kwad.sdk.commercial.j.a.n(adTemplate, i, str);
                return;
            }
            if (bw.hA(str)) {
                com.kwad.sdk.commercial.j.a.a(adTemplate, i, str, "", FraudVerifyCode.RerwardFraudUnknown, "", 0);
                return;
            }
            HashMap map = null;
            String strA = ai.a(ServiceProvider.getContext(), str, i == 2 ? aVar.mK : null, com.kwad.sdk.core.response.b.a.aB(e.el(adTemplate)));
            ai.f(adTemplate, str, strA);
            AdHttpProxy adHttpProxyAI = g.AI();
            int i2 = adHttpProxyAI instanceof com.kwad.sdk.core.network.c.a ? 2 : 1;
            c.d("AdTrackUtil", "handleTrackUrl useKwaiUA: " + zDw);
            if (zDw) {
                com.kwad.sdk.core.i.c cVarJ = com.kwad.sdk.core.i.a.j(zDw, zDx);
                c.d("AdTrackUtil", "handleTrackUrl uaGetter: " + cVarJ);
                if (cVarJ != null) {
                    map = new HashMap();
                    map.put("User-Agent", cVarJ.JS());
                }
            }
            com.kwad.sdk.core.network.c cVarDoGetWithoutResponse = adHttpProxyAI.doGetWithoutResponse(strA, map, !zDw);
            if (dK(cVarDoGetWithoutResponse.code)) {
                c.d("AdTrackUtil", "trackUrl request success actionType: " + i);
                com.kwad.sdk.commercial.j.a.a(adTemplate, i, str, cVarDoGetWithoutResponse.code, i2);
            } else {
                com.kwad.sdk.commercial.j.a.a(adTemplate, i, str, strA, d.cu(cVarDoGetWithoutResponse.code), cVarDoGetWithoutResponse.aEk, i2);
            }
        }
    }

    private static List<String> a(AdTemplate adTemplate, int i, com.kwad.sdk.core.adlog.c.a aVar) {
        ArrayList arrayList = new ArrayList();
        AdInfo adInfoEl = e.el(adTemplate);
        List<AdInfo.AdTrackInfo> list = adInfoEl.adTrackInfoList;
        if (ap.L(list)) {
            return arrayList;
        }
        List<String> listA = a(i, aVar, arrayList, adInfoEl, list);
        if (listA != null) {
            return listA;
        }
        for (AdInfo.AdTrackInfo adTrackInfo : list) {
            if (adTrackInfo.type == i && adTrackInfo.urls != null) {
                arrayList.addAll(adTrackInfo.urls);
                break;
            }
        }
        return arrayList;
    }

    private static List<String> a(int i, com.kwad.sdk.core.adlog.c.a aVar, List<String> list, AdInfo adInfo, List<AdInfo.AdTrackInfo> list2) {
        int iOptInt;
        if (i != 402 || !com.kwad.sdk.core.response.b.a.bo(adInfo)) {
            return null;
        }
        try {
            if (!TextUtils.isEmpty(aVar.Pj)) {
                iOptInt = new JSONObject(aVar.Pj).optInt("photoPlaySecond");
            } else {
                iOptInt = aVar.axJ;
            }
            JSONObject jSONObject = new JSONObject(adInfo.adBaseInfo.videoPlayedNSConfig);
            for (AdInfo.AdTrackInfo adTrackInfo : list2) {
                if (adTrackInfo.type == jSONObject.optInt(String.valueOf(iOptInt)) && adTrackInfo.urls != null) {
                    list.addAll(adTrackInfo.urls);
                    break;
                }
            }
        } catch (Throwable unused) {
        }
        return list;
    }
}
