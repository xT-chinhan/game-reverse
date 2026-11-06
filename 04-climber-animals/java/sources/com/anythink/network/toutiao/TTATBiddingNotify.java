package com.anythink.network.toutiao;

import android.util.Log;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingNotice;
import com.anythink.core.api.ATSDK;
import com.bytedance.sdk.openadsdk.TTClientBidding;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TTATBiddingNotify implements ATBiddingNotice {
    TTClientBidding a;

    protected TTATBiddingNotify(TTClientBidding tTClientBidding) {
        this.a = tTClientBidding;
    }

    @Override // com.anythink.core.api.ATBiddingNotice
    public void notifyBidWin(double d, double d2, Map<String, Object> map) {
        if (ATSDK.isNetworkLogDebug()) {
            Log.i("TTATBiddingNotify", "notifyBidWin : second price:".concat(String.valueOf(d2)));
        }
        try {
            this.a.win(Double.valueOf(d2));
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.anythink.core.api.ATBiddingNotice
    public void notifyBidLoss(String str, double d, Map<String, Object> map) {
        str.hashCode();
        String str2 = "102";
        byte b = -1;
        switch (str.hashCode()) {
            case 50:
                if (str.equals("2")) {
                    b = 0;
                }
                break;
            case 53:
                if (str.equals("5")) {
                    b = 1;
                }
                break;
            case 48627:
                if (str.equals("102")) {
                    b = 2;
                }
                break;
            case 48628:
                if (str.equals("103")) {
                    b = 3;
                }
                break;
            case 48629:
                if (str.equals(ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_FLOOR)) {
                    b = 4;
                }
                break;
        }
        switch (b) {
            case 0:
                str2 = "2";
                break;
            case 1:
            default:
                str2 = "201";
                break;
            case 2:
            case 3:
            case 4:
                break;
        }
        if (ATSDK.isNetworkLogDebug()) {
            Log.i("TTATBiddingNotify", "notifyBidLoss :  price: " + d + ", lossCode: " + str + ", lossReason: " + str2);
        }
        try {
            this.a.loss(Double.valueOf(d), str2, null);
        } catch (Throwable unused) {
        }
        this.a = null;
    }

    @Override // com.anythink.core.api.ATBiddingNotice
    public void notifyBidDisplay(boolean z, double d) {
        if (ATSDK.isNetworkLogDebug()) {
            Log.i("TTATBiddingNotify", "notifyBidDisplay :  price:" + d + ",isWinner:" + z);
        }
        try {
            this.a.setPrice(Double.valueOf(d));
        } catch (Throwable unused) {
        }
        this.a = null;
    }

    @Override // com.anythink.core.api.ATBiddingNotice
    public ATAdConst.CURRENCY getNoticePriceCurrency() {
        return ATAdConst.CURRENCY.RMB_CENT;
    }
}
