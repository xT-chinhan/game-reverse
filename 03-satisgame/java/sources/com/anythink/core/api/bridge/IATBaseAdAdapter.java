package com.anythink.core.api.bridge;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATCommonImpressionListener;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.common.h.n;
import com.anythink.core.common.k.d.b;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface IATBaseAdAdapter {
    int baseOnAdapterBridgeVersion();

    String closeAd();

    void destory();

    void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener);

    Map<Integer, Class<? extends ATBaseAdAdapter>> getFormatAdapterMap();

    View getMixView();

    Map<String, Object> getNetworkInfoMap();

    String getNetworkName();

    String getNetworkPlacementId();

    String getNetworkSDKVersion();

    b getServerExtraInfo();

    n getTrackingInfo();

    boolean initNetworkObjectByPlacementId(Context context, Map<String, Object> map, Map<String, Object> map2);

    void internalFormatShow(Activity activity, ViewGroup viewGroup, ATCommonImpressionListener aTCommonImpressionListener);

    boolean isAdReady();

    void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2);

    void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2, ATCustomLoadListener aTCustomLoadListener);

    void parseGlobalParams(Map<String, Object> map, Map<String, Object> map2);

    void setBiddingListener(ATBiddingListener aTBiddingListener);

    void setLoadListener(ATCustomLoadListener aTCustomLoadListener);

    void setTrackingInfo(n nVar);

    boolean setUserDataConsent(Context context, boolean z, boolean z2);

    boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener);

    boolean supportImpressionCallback();
}
