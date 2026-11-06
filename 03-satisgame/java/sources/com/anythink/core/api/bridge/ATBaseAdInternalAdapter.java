package com.anythink.core.api.bridge;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATCommonImpressionListener;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.ATEventInterface;
import com.anythink.core.common.d.b;
import com.anythink.core.common.h.n;
import com.anythink.core.common.u.o;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class ATBaseAdInternalAdapter extends AnyThinkBaseAdapter implements IATBaseAdAdapter, b.a {
    protected static final int BANNER_FORMAT = 2;
    protected static final int INTERSTITIAL_FORMAT = 3;
    protected static final int NATIVE_FORMAT = 0;
    protected static final int REWARDVIDEO_FORMAT = 1;
    protected static final int SPLASH_FORMAT = 4;
    private static final String TAG = "ATBaseAdInternalAdapter";
    private static final String VERSION_INCOMPATIBLE_ERROR_MSG = "Adapter version and sdk version are incompatible";
    public ATBiddingListener mBiddingListener;
    protected ATEventInterface mDownloadListener;
    protected ATCustomLoadListener mLoadListener;
    private n mTrackingInfo;
    protected com.anythink.core.common.k.d.b serverExtraInfo;
    private final IATBaseAdAdapter mBaseAdAdapterProxy = new com.anythink.core.common.k.a.b(this);
    protected String mUserId = "";
    protected String mUserData = "";
    protected String mScenario = "";
    protected int mDismissType = 0;
    protected int mFetchAdTimeout = 10000;
    protected int mRequestNum = 1;
    protected int carouselShowType = 0;

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public Map<Integer, Class<? extends ATBaseAdAdapter>> getFormatAdapterMap() {
        return null;
    }

    public JSONObject getInnerBidToken(Context context, Map<String, Object> map, Map<String, String> map2) {
        return null;
    }

    public View getMixView() {
        return null;
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2, ATCustomLoadListener aTCustomLoadListener) {
    }

    public void notifyWLInfo(int i, Map<String, Object> map) {
    }

    public final void internalLoad(Context context, Map<String, Object> map, Map<String, Object> map2, ATCustomLoadListener aTCustomLoadListener) {
        this.mBaseAdAdapterProxy.loadCustomNetworkAd(context, map, map2, aTCustomLoadListener);
    }

    public final boolean internalStartBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        boolean zStartBiddingRequest = this.mBaseAdAdapterProxy.startBiddingRequest(context, map, map2, aTBiddingListener);
        if (!zStartBiddingRequest) {
            this.mBiddingListener = null;
        }
        return zStartBiddingRequest;
    }

    public final void internalGetBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        this.mBaseAdAdapterProxy.getBidRequestInfo(context, map, map2, aTBidRequestInfoListener);
    }

    public final boolean internalInitNetworkObjectByPlacementId(Context context, Map<String, Object> map, Map<String, Object> map2) {
        return this.mBaseAdAdapterProxy.initNetworkObjectByPlacementId(context, map, map2);
    }

    public final void internalShow(Activity activity, ViewGroup viewGroup, ATCommonImpressionListener aTCommonImpressionListener) {
        this.mBaseAdAdapterProxy.internalFormatShow(activity, viewGroup, aTCommonImpressionListener);
    }

    public final void internalDestroy() {
        try {
            this.mBaseAdAdapterProxy.destory();
        } catch (Throwable unused) {
        }
    }

    public final boolean internalIsAdReady() {
        return this.mBaseAdAdapterProxy.isAdReady();
    }

    public final boolean internalSetUserDataConsent(Context context, boolean z, boolean z2) {
        return this.mBaseAdAdapterProxy.setUserDataConsent(context, z, z2);
    }

    public final void setScenario(String str) {
        this.mScenario = str;
    }

    public final void setCarouselShowType(int i) {
        this.carouselShowType = i;
    }

    public final String getInternalNetworkPlacementId() {
        return this.mBaseAdAdapterProxy.getNetworkPlacementId();
    }

    public final String getInternalNetworkSDKVersion() {
        return this.mBaseAdAdapterProxy.getNetworkSDKVersion();
    }

    public final String getInternalNetworkName() {
        return this.mBaseAdAdapterProxy.getNetworkName();
    }

    public final Map<String, Object> getInternalNetworkInfoMap() {
        return this.mBaseAdAdapterProxy.getNetworkInfoMap();
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public final void setTrackingInfo(n nVar) {
        this.mTrackingInfo = nVar;
        this.mBaseAdAdapterProxy.setTrackingInfo(nVar);
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public final n getTrackingInfo() {
        return this.mTrackingInfo;
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public void setLoadListener(ATCustomLoadListener aTCustomLoadListener) {
        this.mLoadListener = aTCustomLoadListener;
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public void setBiddingListener(ATBiddingListener aTBiddingListener) {
        this.mBiddingListener = aTBiddingListener;
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public final com.anythink.core.common.k.d.b getServerExtraInfo() {
        return this.serverExtraInfo;
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public void parseGlobalParams(Map<String, Object> map, Map<String, Object> map2) {
        try {
            fillParams(map);
            if (map2 != null) {
                this.mUserId = map2.get("user_id") != null ? map2.get("user_id").toString() : "";
                this.mUserData = map2.get(ATAdConst.KEY.USER_CUSTOM_DATA) != null ? map2.get(ATAdConst.KEY.USER_CUSTOM_DATA).toString() : "";
            }
            if (map != null) {
                this.serverExtraInfo = new com.anythink.core.common.k.d.b(map);
            }
        } catch (Throwable unused) {
        }
    }

    public void setAdDownloadListener(ATEventInterface aTEventInterface) {
        this.mDownloadListener = aTEventInterface;
    }

    private void fillParams(Map<String, Object> map) {
        if (getTrackingInfo() != null) {
            o.a(map, getTrackingInfo().ah());
        }
    }

    public final boolean isMixFormatAd() {
        com.anythink.core.common.k.d.b bVar = this.serverExtraInfo;
        return bVar != null && bVar.k();
    }

    public final boolean isMixInterstitial() {
        com.anythink.core.common.k.d.b bVar = this.serverExtraInfo;
        return bVar != null && bVar.o();
    }

    public final boolean isMixSplash() {
        com.anythink.core.common.k.d.b bVar = this.serverExtraInfo;
        return bVar != null && bVar.m();
    }

    public final boolean isMixNative() {
        com.anythink.core.common.k.d.b bVar = this.serverExtraInfo;
        return bVar != null && bVar.l();
    }

    public final boolean isMixBanner() {
        com.anythink.core.common.k.d.b bVar = this.serverExtraInfo;
        return bVar != null && bVar.n();
    }

    public final boolean isNativeMixToBanner() {
        com.anythink.core.common.k.d.b bVar;
        return isMixNative() && (bVar = this.serverExtraInfo) != null && bVar.f();
    }

    @Deprecated
    public final void thirdPartyLoad(ATBaseAdAdapter aTBaseAdAdapter, Context context, Map<String, Object> map, Map<String, Object> map2) {
        ATCustomLoadListener aTCustomLoadListener = this.mLoadListener;
        if (aTCustomLoadListener != null) {
            aTCustomLoadListener.onAdLoadError("", VERSION_INCOMPATIBLE_ERROR_MSG);
        }
    }

    @Deprecated
    public final boolean thirdPartyStartBiddingRequest(ATBaseAdAdapter aTBaseAdAdapter, Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        if (aTBiddingListener == null) {
            return false;
        }
        aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail(VERSION_INCOMPATIBLE_ERROR_MSG), null);
        return false;
    }

    @Deprecated
    public final int getMixedFormatAdType() {
        com.anythink.core.common.k.d.b bVar = this.serverExtraInfo;
        if (bVar != null) {
            return bVar.b();
        }
        return -1;
    }

    public String internalCloseAd() {
        return this.mBaseAdAdapterProxy.closeAd();
    }

    public int internalBaseOnAdapterBridgeVersion() {
        return this.mBaseAdAdapterProxy.baseOnAdapterBridgeVersion();
    }
}
