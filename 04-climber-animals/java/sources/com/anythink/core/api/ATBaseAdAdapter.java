package com.anythink.core.api;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class ATBaseAdAdapter extends ATBaseAdInternalAdapter {
    public String closeAd() {
        return "";
    }

    public Map<String, Object> getAdExtraInfoMap() {
        return null;
    }

    public BaseAd getBaseAdObject(Context context) {
        return null;
    }

    public MediationBidManager getBidManager() {
        return null;
    }

    public String getILRD() {
        return null;
    }

    public ATInitMediation getMediationInitManager() {
        return null;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return null;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public boolean initNetworkObjectByPlacementId(Context context, Map<String, Object> map, Map<String, Object> map2) {
        return false;
    }

    public void internalFormatShow(Activity activity, ViewGroup viewGroup, ATCommonImpressionListener aTCommonImpressionListener) {
    }

    @Override // com.anythink.core.common.d.b.a
    public void onCreate(Activity activity) {
    }

    @Override // com.anythink.core.common.d.b.a
    public void onDestroy(Activity activity) {
    }

    @Override // com.anythink.core.common.d.b.a
    public void onPause(Activity activity) {
    }

    @Override // com.anythink.core.common.d.b.a
    public void onResume(Activity activity) {
    }

    @Override // com.anythink.core.common.d.b.a
    public void onStart(Activity activity) {
    }

    @Override // com.anythink.core.common.d.b.a
    public void onStop(Activity activity) {
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public boolean setUserDataConsent(Context context, boolean z, boolean z2) {
        return false;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        return false;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public boolean supportImpressionCallback() {
        return true;
    }

    public final String getUserCustomData() {
        return this.mUserData;
    }

    public final String getUserId() {
        return this.mUserId;
    }

    public final int getDismissType() {
        return this.mDismissType;
    }

    public final void notifyATLoadFail(String str, String str2) {
        if (this.mBiddingListener != null) {
            this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail(!TextUtils.isEmpty(str) ? str + "|" + str2 : str2), null);
        }
        if (this.mLoadListener != null) {
            this.mLoadListener.onAdLoadError(str, str2);
        }
    }

    public final void notifyATLoadFail(String str, String str2, ATBiddingNotice aTBiddingNotice, ATAdConst.CURRENCY currency) {
        if (this.mBiddingListener != null) {
            this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail(!TextUtils.isEmpty(str) ? str + "|" + str2 : str2, aTBiddingNotice, currency), null);
        }
        if (this.mLoadListener != null) {
            this.mLoadListener.onAdLoadError(str, str2);
        }
    }

    public final void setFetchAdTimeout(int i) {
        this.mFetchAdTimeout = i;
    }

    public final void setRequestNum(int i) {
        if (i > 0) {
            this.mRequestNum = i;
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        if (aTBidRequestInfoListener != null) {
            aTBidRequestInfoListener.onFailed(ATBidRequestInfo.NO_SUPPORT_BIDDING_TYPE);
        }
    }

    public void releaseLoadResource() {
        cleanLoadListener();
    }

    public String getAdCustomExt() {
        return this.serverExtraInfo != null ? this.serverExtraInfo.d() : "";
    }

    private void cleanLoadListener() {
        this.mBiddingListener = null;
        this.mLoadListener = null;
    }
}
