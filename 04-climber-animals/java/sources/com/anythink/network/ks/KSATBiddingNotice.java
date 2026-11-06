package com.anythink.network.ks;

import android.util.Log;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingNotice;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATSDK;
import com.anythink.core.common.d.j;
import com.kwad.sdk.api.KsBannerAd;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.api.model.AdnName;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class KSATBiddingNotice implements ATBiddingNotice {
    Object a;

    @Override // com.anythink.core.api.ATBiddingNotice
    public void notifyBidDisplay(boolean z, double d) {
    }

    protected KSATBiddingNotice(Object obj) {
        this.a = obj;
    }

    @Override // com.anythink.core.api.ATBiddingNotice
    public synchronized void notifyBidWin(double d, double d2, Map<String, Object> map) {
        int iRound = (int) Math.round(d);
        int iRound2 = (int) Math.round(d2);
        if (ATSDK.isNetworkLogDebug()) {
            StringBuilder sb = new StringBuilder();
            Object obj = this.a;
            Log.i("KSATBiddingNotice", sb.append(obj != null ? obj.getClass().getSimpleName() : "").append(": notifyBidWin : win price: ").append(iRound).append(", second price:").append(iRound2).toString());
        }
        if (this.a instanceof KsRewardVideoAd) {
            if (ATSDK.isNetworkLogDebug()) {
                Log.i("KSATBiddingNotice", "Origin price:" + ((KsRewardVideoAd) this.a).getECPM());
            }
            ((KsRewardVideoAd) this.a).setBidEcpm(iRound, iRound2);
            return;
        }
        if (this.a instanceof KsInterstitialAd) {
            if (ATSDK.isNetworkLogDebug()) {
                Log.i("KSATBiddingNotice", "Origin price:" + ((KsInterstitialAd) this.a).getECPM());
            }
            ((KsInterstitialAd) this.a).setBidEcpm(iRound, iRound2);
            return;
        }
        if (this.a instanceof KsFullScreenVideoAd) {
            if (ATSDK.isNetworkLogDebug()) {
                Log.i("KSATBiddingNotice", "Origin price:" + ((KsFullScreenVideoAd) this.a).getECPM());
            }
            ((KsFullScreenVideoAd) this.a).setBidEcpm(iRound, iRound2);
            return;
        }
        if (this.a instanceof KsDrawAd) {
            if (ATSDK.isNetworkLogDebug()) {
                Log.i("KSATBiddingNotice", "Origin price:" + ((KsDrawAd) this.a).getECPM());
            }
            ((KsDrawAd) this.a).setBidEcpm(iRound, iRound2);
            return;
        }
        if (this.a instanceof KsFeedAd) {
            if (ATSDK.isNetworkLogDebug()) {
                Log.i("KSATBiddingNotice", "Origin price:" + ((KsFeedAd) this.a).getECPM());
            }
            ((KsFeedAd) this.a).setBidEcpm(iRound, iRound2);
            return;
        }
        if (this.a instanceof KsNativeAd) {
            if (ATSDK.isNetworkLogDebug()) {
                Log.i("KSATBiddingNotice", "Origin price:" + ((KsNativeAd) this.a).getECPM());
            }
            ((KsNativeAd) this.a).setBidEcpm(iRound, iRound2);
            return;
        }
        if (this.a instanceof KsSplashScreenAd) {
            if (ATSDK.isNetworkLogDebug()) {
                Log.i("KSATBiddingNotice", "Origin price:" + ((KsSplashScreenAd) this.a).getECPM());
            }
            ((KsSplashScreenAd) this.a).setBidEcpm(iRound, iRound2);
            return;
        }
        try {
            if (this.a instanceof KsBannerAd) {
                if (ATSDK.isNetworkLogDebug()) {
                    Log.i("KSATBiddingNotice", "Origin price:" + ((KsBannerAd) this.a).getECPM());
                }
                ((KsBannerAd) this.a).setBidEcpm(iRound, iRound2);
                return;
            }
        } catch (Throwable unused) {
        }
        this.a = null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.anythink.core.api.ATBiddingNotice
    public synchronized void notifyBidLoss(String str, double d, Map<String, Object> map) {
        byte b = -1;
        int intFromMap = ATInitMediation.getIntFromMap(map, "adn_id", -1);
        int i = 3;
        int i2 = (intFromMap == 1 || intFromMap == 2) ? 1 : (intFromMap == 3 || intFromMap == 4) ? 2 : 3;
        String str2 = AdnName.OTHER;
        int intFromMap2 = KSATInitManager.getIntFromMap(map, ATBiddingNotice.ADN_EXTRA_NW_FIRM_ID, 0);
        if (intFromMap2 > 0) {
            if (intFromMap2 == 15) {
                str2 = AdnName.CHUANSHANJIA;
            } else if (intFromMap2 == 22) {
                str2 = "baidu";
            }
        }
        int iRound = (int) Math.round(d);
        AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
        adExposureFailedReason.winEcpm = iRound;
        adExposureFailedReason.adnType = i2;
        adExposureFailedReason.adnName = str2;
        int iHashCode = str.hashCode();
        if (iHashCode != 50) {
            if (iHashCode != 53) {
                switch (iHashCode) {
                    case 48627:
                        if (str.equals("102")) {
                            b = 1;
                        }
                        break;
                    case 48628:
                        if (str.equals("103")) {
                            b = 2;
                        }
                        break;
                    case 48629:
                        if (str.equals(ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_FLOOR)) {
                            b = 0;
                        }
                        break;
                }
            } else if (str.equals("5")) {
                b = 3;
            }
        } else if (str.equals("2")) {
            b = 4;
        }
        if (b == 0) {
            i = 1;
        } else if (b == 1 || b == 2) {
            i = 2;
        } else if (b != 3) {
            i = 0;
        }
        String stringFromMap = "";
        String stringFromMap2 = "";
        Object obj = map.get(ATBiddingNotice.ADN_EXTRA_NATIVE_MATERIAL_INFO);
        if (obj != null) {
            try {
                stringFromMap = ATInitMediation.getStringFromMap((Map) obj, j.w.A, "");
                stringFromMap2 = ATInitMediation.getStringFromMap((Map) obj, j.w.B, "");
            } catch (Throwable unused) {
            }
        }
        adExposureFailedReason.adTitle = stringFromMap;
        adExposureFailedReason.adUserName = stringFromMap2;
        String stringFromMap3 = ATInitMediation.getStringFromMap(map, ATBiddingNotice.ADN_REQUEST_ID, "");
        adExposureFailedReason.adRequestId = stringFromMap3;
        int intFromMap3 = ATInitMediation.getIntFromMap(map, ATBiddingNotice.ADN_REQUEST_IS_SHOW, 2);
        adExposureFailedReason.isShow = intFromMap3;
        int intFromMap4 = ATInitMediation.getIntFromMap(map, ATBiddingNotice.ADN_REQUEST_IS_CLICK, 2);
        adExposureFailedReason.isClick = intFromMap4;
        if (ATSDK.isNetworkLogDebug()) {
            StringBuilder sb = new StringBuilder();
            Object obj2 = this.a;
            Log.i("KSATBiddingNotice", sb.append(obj2 != null ? obj2.getClass().getSimpleName() : "").append(": notifyBidLoss lossCode: ").append(str).append(", winPrice: ").append(iRound).append(", lossReason: ").append(i).append(", adnType: ").append(i2).append(", adnName: ").append(str2).append(", adTitle: ").append(stringFromMap).append(", adUserName: ").append(stringFromMap2).append(", adRequestId: ").append(stringFromMap3).append(", isShow: ").append(intFromMap3).append(", isClick: ").append(intFromMap4).toString());
        }
        Object obj3 = this.a;
        if (obj3 instanceof KsRewardVideoAd) {
            ((KsRewardVideoAd) obj3).reportAdExposureFailed(i, adExposureFailedReason);
            return;
        }
        Object obj4 = this.a;
        if (obj4 instanceof KsInterstitialAd) {
            ((KsInterstitialAd) obj4).reportAdExposureFailed(i, adExposureFailedReason);
            return;
        }
        Object obj5 = this.a;
        if (obj5 instanceof KsFullScreenVideoAd) {
            ((KsFullScreenVideoAd) obj5).reportAdExposureFailed(i, adExposureFailedReason);
            return;
        }
        Object obj6 = this.a;
        if (obj6 instanceof KsDrawAd) {
            ((KsDrawAd) obj6).reportAdExposureFailed(i, adExposureFailedReason);
            return;
        }
        Object obj7 = this.a;
        if (obj7 instanceof KsFeedAd) {
            ((KsFeedAd) obj7).reportAdExposureFailed(i, adExposureFailedReason);
            return;
        }
        Object obj8 = this.a;
        if (obj8 instanceof KsNativeAd) {
            ((KsNativeAd) obj8).reportAdExposureFailed(i, adExposureFailedReason);
            return;
        }
        Object obj9 = this.a;
        if (obj9 instanceof KsSplashScreenAd) {
            ((KsSplashScreenAd) obj9).reportAdExposureFailed(i, adExposureFailedReason);
            return;
        }
        try {
            Object obj10 = this.a;
            if (obj10 instanceof KsBannerAd) {
                ((KsBannerAd) obj10).reportAdExposureFailed(i, adExposureFailedReason);
                return;
            }
        } catch (Throwable unused2) {
        }
        this.a = null;
    }

    @Override // com.anythink.core.api.ATBiddingNotice
    public ATAdConst.CURRENCY getNoticePriceCurrency() {
        return ATAdConst.CURRENCY.RMB_CENT;
    }
}
