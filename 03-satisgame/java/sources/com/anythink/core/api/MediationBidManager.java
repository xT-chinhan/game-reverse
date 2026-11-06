package com.anythink.core.api;

import com.anythink.core.api.bridge.ATBaseAdAdapter;
import com.anythink.core.common.h.a;
import com.anythink.core.common.h.by;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class MediationBidManager {
    public static final String NO_BID_TOKEN_ERROR = "NO_BID_TOKEN";
    protected String mRequestUrl;

    public interface BidListener {
        void onBidFail(String str);

        void onBidStart(by byVar, ATBaseAdAdapter aTBaseAdAdapter);

        void onBidSuccess(List<by> list);
    }

    public abstract void notifyWinnerDisplay(String str, by byVar);

    public abstract void startBid(a aVar, BidListener bidListener);

    public void setBidRequestUrl(String str) {
        this.mRequestUrl = str;
    }
}
