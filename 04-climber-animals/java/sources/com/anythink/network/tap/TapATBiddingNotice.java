package com.anythink.network.tap;

import android.util.Log;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingNotice;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATSDK;
import com.tapsdk.tapad.TapBannerAd;
import com.tapsdk.tapad.TapFeedAd;
import com.tapsdk.tapad.TapInterstitialAd;
import com.tapsdk.tapad.TapRewardVideoAd;
import com.tapsdk.tapad.TapSplashAd;
import com.tapsdk.tapad.constants.Constants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TapATBiddingNotice implements ATBiddingNotice {
    Object a;

    @Override // com.anythink.core.api.ATBiddingNotice
    public void notifyBidDisplay(boolean z, double d) {
    }

    public TapATBiddingNotice(Object obj) {
        this.a = obj;
    }

    @Override // com.anythink.core.api.ATBiddingNotice
    public void notifyBidWin(double d, double d2, Map<String, Object> map) {
        int iRound = (int) Math.round(d);
        int iRound2 = (int) Math.round(d2);
        if (ATSDK.isNetworkLogDebug()) {
            Log.i("TapATBiddingNotice", "adObject is not null:" + (this.a != null) + ": notifyBidWin : win price: " + iRound + ", second price:" + iRound2);
        }
        HashMap map2 = new HashMap();
        map2.put(Constants.Bidding.EXPECT_COST_PRICE, Integer.valueOf(iRound));
        map2.put(Constants.Bidding.HIGHEST_LOSS_PRICE, Integer.valueOf(iRound2));
        Object obj = this.a;
        if (obj instanceof TapFeedAd) {
            ((TapFeedAd) obj).sendWinNotification(map2);
            return;
        }
        if (obj instanceof TapBannerAd) {
            ((TapBannerAd) obj).sendWinNotification(map2);
            return;
        }
        if (obj instanceof TapSplashAd) {
            ((TapSplashAd) obj).sendWinNotification(map2);
        } else if (obj instanceof TapInterstitialAd) {
            ((TapInterstitialAd) obj).sendWinNotification(map2);
        } else if (obj instanceof TapRewardVideoAd) {
            ((TapRewardVideoAd) obj).sendWinNotification(map2);
        }
    }

    @Override // com.anythink.core.api.ATBiddingNotice
    public void notifyBidLoss(String str, double d, Map<String, Object> map) {
        int intFromMap = ATInitMediation.getIntFromMap(map, "adn_id", -1);
        int i = 2;
        String str2 = "1";
        if (intFromMap != 1) {
            if (intFromMap == 2) {
                str2 = "4";
            } else if (intFromMap == 3) {
                str2 = "3";
            } else if (intFromMap == 4) {
                str2 = "2";
            }
        }
        str.hashCode();
        switch (str) {
            case "2":
                break;
            case "5":
                i = 101;
                break;
            case "102":
            case "103":
            case "104":
                i = 1;
                break;
            default:
                i = 10001;
                break;
        }
        int iRound = (int) Math.round(d);
        HashMap map2 = new HashMap();
        map2.put(Constants.Bidding.WIN_PRICE, Integer.valueOf(iRound));
        map2.put(Constants.Bidding.LOSS_REASON, Integer.valueOf(i));
        map2.put("adn_id", str2);
        if (ATSDK.isNetworkLogDebug()) {
            Log.i("TapATBiddingNotice", "adObject is not null:" + (this.a != null) + ": notifyBidLoss lossCode: " + str + ", adnId: " + intFromMap + ", winPrice: " + iRound + ", lossReason: " + i + ", resultAdnId: " + str2);
        }
        Object obj = this.a;
        if (obj instanceof TapFeedAd) {
            ((TapFeedAd) obj).sendLossNotification(map2);
            return;
        }
        if (obj instanceof TapBannerAd) {
            ((TapBannerAd) obj).sendLossNotification(map2);
            return;
        }
        if (obj instanceof TapSplashAd) {
            ((TapSplashAd) obj).sendLossNotification(map2);
        } else if (obj instanceof TapInterstitialAd) {
            ((TapInterstitialAd) obj).sendLossNotification(map2);
        } else if (obj instanceof TapRewardVideoAd) {
            ((TapRewardVideoAd) obj).sendLossNotification(map2);
        }
    }

    @Override // com.anythink.core.api.ATBiddingNotice
    public ATAdConst.CURRENCY getNoticePriceCurrency() {
        return ATAdConst.CURRENCY.RMB_CENT;
    }
}
