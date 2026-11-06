package com.anythink.network.gdt;

import android.util.Log;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingNotice;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATSDK;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.comm.pi.IBidding;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class GDTATBiddingNotice implements ATBiddingNotice {
    Object a;

    protected GDTATBiddingNotice(Object obj) {
        this.a = obj;
    }

    @Override // com.anythink.core.api.ATBiddingNotice
    public ATAdConst.CURRENCY getNoticePriceCurrency() {
        return ATAdConst.CURRENCY.RMB_CENT;
    }

    @Override // com.anythink.core.api.ATBiddingNotice
    public void notifyBidDisplay(boolean z, double d) {
    }

    @Override // com.anythink.core.api.ATBiddingNotice
    public void notifyBidLoss(String str, double d, Map<String, Object> map) {
        int i;
        int i2 = 4;
        HashMap map2 = new HashMap(4);
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "2":
                i = 2;
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
        map2.put(IBidding.WIN_PRICE, Integer.valueOf((int) Math.round(d)));
        map2.put(IBidding.LOSS_REASON, Integer.valueOf(i));
        try {
            int intFromMap = ATInitMediation.getIntFromMap(map, ATBiddingNotice.ADN_ID, -1);
            if (intFromMap == 1) {
                i2 = 1;
            } else if (intFromMap != 2) {
                if (intFromMap != 3) {
                    i2 = intFromMap != 4 ? intFromMap : 2;
                } else {
                    i2 = 3;
                }
            }
            if (i2 != -1) {
                map2.put(IBidding.ADN_ID, Integer.valueOf(i2));
            }
        } catch (Throwable unused) {
        }
        if (ATSDK.isNetworkLogDebug()) {
            StringBuilder sb = new StringBuilder();
            Object obj = this.a;
            Log.i("GDTATBiddingNotice", sb.append(obj != null ? obj.toString() : "").append(": notifyBidLoss lossCode:").append(str).append(",lossReason:").append(i).append("\n").append(map2.toString()).toString());
        }
        Object obj2 = this.a;
        if (obj2 instanceof RewardVideoAD) {
            ((RewardVideoAD) obj2).sendLossNotification(map2);
            return;
        }
        Object obj3 = this.a;
        if (obj3 instanceof UnifiedInterstitialAD) {
            ((UnifiedInterstitialAD) obj3).sendLossNotification(map2);
            return;
        }
        Object obj4 = this.a;
        if (obj4 instanceof SplashAD) {
            ((SplashAD) obj4).sendLossNotification(map2);
            return;
        }
        Object obj5 = this.a;
        if (obj5 instanceof UnifiedBannerView) {
            ((UnifiedBannerView) obj5).sendLossNotification(map2);
            return;
        }
        try {
            Object obj6 = this.a;
            if (obj6 instanceof GDTATNativeExpressAd) {
                ((GDTATNativeExpressAd) obj6).b.sendLossNotification(map2);
                return;
            }
            if (obj6 instanceof GDTATNativePatchAd) {
                ((GDTATNativePatchAd) obj6).c.sendLossNotification(map2);
                return;
            }
            if (obj6 instanceof GDTATNativeAd) {
                ((GDTATNativeAd) obj6).c.sendLossNotification(map2);
                return;
            }
            this.a = null;
        } catch (Throwable unused2) {
        }
    }

    @Override // com.anythink.core.api.ATBiddingNotice
    public void notifyBidWin(double d, double d2, Map<String, Object> map) {
        HashMap map2 = new HashMap(4);
        map2.put(IBidding.HIGHEST_LOSS_PRICE, Integer.valueOf((int) Math.round(d2)));
        try {
            Object obj = this.a;
            if (obj instanceof RewardVideoAD) {
                RewardVideoAD rewardVideoAD = (RewardVideoAD) obj;
                map2.put(IBidding.EXPECT_COST_PRICE, Integer.valueOf(rewardVideoAD.getECPM()));
                if (ATSDK.isNetworkLogDebug()) {
                    StringBuilder sb = new StringBuilder();
                    Object obj2 = this.a;
                    Log.i("GDTATBiddingNotice", sb.append(obj2 != null ? obj2.toString() : "").append(": notifyBidWin: ").append(map2.toString()).toString());
                }
                rewardVideoAD.sendWinNotification(map2);
                return;
            }
        } catch (Throwable unused) {
        }
        try {
            Object obj3 = this.a;
            if (obj3 instanceof UnifiedInterstitialAD) {
                UnifiedInterstitialAD unifiedInterstitialAD = (UnifiedInterstitialAD) obj3;
                map2.put(IBidding.EXPECT_COST_PRICE, Integer.valueOf(unifiedInterstitialAD.getECPM()));
                if (ATSDK.isNetworkLogDebug()) {
                    StringBuilder sb2 = new StringBuilder();
                    Object obj4 = this.a;
                    Log.i("GDTATBiddingNotice", sb2.append(obj4 != null ? obj4.toString() : "").append(": notifyBidWin: ").append(map2.toString()).toString());
                }
                unifiedInterstitialAD.sendWinNotification(map2);
                return;
            }
        } catch (Throwable unused2) {
        }
        try {
            Object obj5 = this.a;
            if (obj5 instanceof SplashAD) {
                SplashAD splashAD = (SplashAD) obj5;
                map2.put(IBidding.EXPECT_COST_PRICE, Integer.valueOf(splashAD.getECPM()));
                if (ATSDK.isNetworkLogDebug()) {
                    StringBuilder sb3 = new StringBuilder();
                    Object obj6 = this.a;
                    Log.i("GDTATBiddingNotice", sb3.append(obj6 != null ? obj6.toString() : "").append(": notifyBidWin: ").append(map2.toString()).toString());
                }
                splashAD.sendWinNotification(map2);
                return;
            }
        } catch (Throwable unused3) {
        }
        try {
            Object obj7 = this.a;
            if (obj7 instanceof UnifiedBannerView) {
                UnifiedBannerView unifiedBannerView = (UnifiedBannerView) obj7;
                map2.put(IBidding.EXPECT_COST_PRICE, Integer.valueOf(unifiedBannerView.getECPM()));
                if (ATSDK.isNetworkLogDebug()) {
                    StringBuilder sb4 = new StringBuilder();
                    Object obj8 = this.a;
                    Log.i("GDTATBiddingNotice", sb4.append(obj8 != null ? obj8.toString() : "").append(": notifyBidWin: ").append(map2.toString()).toString());
                }
                unifiedBannerView.sendWinNotification(map2);
                return;
            }
        } catch (Throwable unused4) {
        }
        try {
            Object obj9 = this.a;
            if (obj9 instanceof GDTATNativeExpressAd) {
                GDTATNativeExpressAd gDTATNativeExpressAd = (GDTATNativeExpressAd) obj9;
                map2.put(IBidding.EXPECT_COST_PRICE, Integer.valueOf(gDTATNativeExpressAd.b.getECPM()));
                if (ATSDK.isNetworkLogDebug()) {
                    StringBuilder sb5 = new StringBuilder();
                    Object obj10 = this.a;
                    Log.i("GDTATBiddingNotice", sb5.append(obj10 != null ? obj10.toString() : "").append(": notifyBidWin: ").append(map2.toString()).toString());
                }
                gDTATNativeExpressAd.b.sendWinNotification(map2);
                return;
            }
            if (obj9 instanceof GDTATNativePatchAd) {
                GDTATNativePatchAd gDTATNativePatchAd = (GDTATNativePatchAd) obj9;
                map2.put(IBidding.EXPECT_COST_PRICE, Integer.valueOf(gDTATNativePatchAd.c.getECPM()));
                if (ATSDK.isNetworkLogDebug()) {
                    StringBuilder sb6 = new StringBuilder();
                    Object obj11 = this.a;
                    Log.i("GDTATBiddingNotice", sb6.append(obj11 != null ? obj11.toString() : "").append(": notifyBidWin: ").append(map2.toString()).toString());
                }
                gDTATNativePatchAd.c.sendWinNotification(map2);
                return;
            }
            if (obj9 instanceof GDTATNativeAd) {
                GDTATNativeAd gDTATNativeAd = (GDTATNativeAd) obj9;
                map2.put(IBidding.EXPECT_COST_PRICE, Integer.valueOf(gDTATNativeAd.c.getECPM()));
                if (ATSDK.isNetworkLogDebug()) {
                    StringBuilder sb7 = new StringBuilder();
                    Object obj12 = this.a;
                    Log.i("GDTATBiddingNotice", sb7.append(obj12 != null ? obj12.toString() : "").append(": notifyBidWin: ").append(map2.toString()).toString());
                }
                gDTATNativeAd.c.sendWinNotification(map2);
                return;
            }
            this.a = null;
        } catch (Throwable unused5) {
        }
    }
}
