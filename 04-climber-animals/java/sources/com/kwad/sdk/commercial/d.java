package com.kwad.sdk.commercial;

import android.text.TextUtils;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.bp;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static int cu(int i) {
        if (i == -1) {
            return 100010;
        }
        if (i == -2) {
            return 100011;
        }
        return i;
    }

    public static BusinessType be(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return BusinessType.OTHER;
        }
        return ct(e.ef(adTemplate));
    }

    public static BusinessType ct(int i) {
        if (i == 3) {
            return BusinessType.AD_FULLSCREEN;
        }
        if (i == 2) {
            return BusinessType.AD_REWARD;
        }
        if (i == 4) {
            return BusinessType.AD_SPLASH;
        }
        if (i == 13 || i == 23) {
            return BusinessType.AD_INTERSTITIAL;
        }
        if (i == 1) {
            return BusinessType.AD_FEED;
        }
        if (i == 10000) {
            return BusinessType.AD_NATIVE;
        }
        return BusinessType.OTHER;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0038  */
    public static AdMatrixInfo.MatrixTemplate bf(AdTemplate adTemplate) {
        String str;
        AdMatrixInfo.MatrixTemplate matrixTemplateK = null;
        if (adTemplate.mAdScene == null) {
            return null;
        }
        AdMatrixInfo.AdDataV2 adDataV2 = com.kwad.sdk.core.response.b.b.cp(adTemplate).adDataV2;
        int iEf = e.ef(adTemplate);
        if (iEf == 2) {
            str = adDataV2.neoTKInfo.templateId;
        } else if (iEf == 3) {
            str = adDataV2.fullScreenInfo.templateId;
        } else if (iEf == 4) {
            str = adDataV2.splashPlayCardTKInfo.templateId;
        } else if (iEf == 6) {
            str = adDataV2.drawTKCardInfo.templateId;
        } else if (iEf == 13) {
            str = adDataV2.interstitialCardInfo.templateId;
        } else if (iEf == 23) {
            int iED = e.eD(adTemplate);
            if (iED == 1) {
                str = adDataV2.fullScreenInfo.templateId;
            } else if (iED == 2) {
                str = adDataV2.interstitialCardInfo.templateId;
            } else {
                str = "";
            }
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (AdMatrixInfo.MatrixTemplate matrixTemplate : com.kwad.sdk.core.response.b.b.cq(adTemplate)) {
            if (bp.isEquals(str, matrixTemplate.templateId)) {
                matrixTemplateK = matrixTemplate;
                break;
            }
        }
        if (matrixTemplateK == null) {
            matrixTemplateK = com.kwad.sdk.core.response.b.b.k(adTemplate, str);
        }
        if (matrixTemplateK != null) {
            matrixTemplateK.publishType = ((h) ServiceProvider.get(h.class)).ci(a(matrixTemplateK));
        }
        return matrixTemplateK;
    }

    private static String a(AdMatrixInfo.MatrixTemplate matrixTemplate) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(matrixTemplate.templateId).append("#").append(matrixTemplate.templateVersionCode);
        return stringBuffer.toString();
    }
}
