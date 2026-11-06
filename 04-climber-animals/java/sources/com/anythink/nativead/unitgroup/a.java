package com.anythink.nativead.unitgroup;

import android.content.Context;
import android.view.View;
import com.anythink.core.api.ATCompViewListener;
import com.anythink.core.api.ATEventInterface;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.ATShakeViewListener;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.IATAdvertiserInfoOperate;
import com.anythink.core.common.d.o;
import com.anythink.core.common.d.p;
import com.anythink.core.common.h.n;
import com.anythink.nativead.api.ATNativePrepareInfo;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends BaseAd {
    private static final String TAG = "a";
    protected n mAdTrackingInfo;
    protected ATEventInterface mDownloadListener;
    private o mNativeEventListener;
    private ATNativePrepareInfo nativePrepareInfo;
    public final int NETWORK_UNKNOW = -1;
    protected String mAdSourceType = "0";
    protected int mNetworkType = -1;

    public abstract void bindDislikeListener(View.OnClickListener onClickListener);

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public abstract View getAdIconView();

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public abstract View getAdMediaView(Object... objArr);

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public IATAdvertiserInfoOperate getAdvertiserInfoOperate() {
        return null;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public int getDownloadProgress() {
        return 0;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public int getDownloadStatus() {
        return 0;
    }

    public Object getObject() {
        return null;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public View getRoateView(Map<String, Object> map, ATCompViewListener aTCompViewListener) {
        return null;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public View getShakeView(int i, int i2, ATShakeViewListener aTShakeViewListener) {
        return null;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public View getSlideView(int i, int i2, int i3, ATShakeViewListener aTShakeViewListener) {
        return null;
    }

    public final void notifyCountDown(int i) {
    }

    public abstract void onPause();

    public abstract void onResume();

    public abstract void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo);

    @Override // com.anythink.core.api.BaseAd
    public void setDevParams(Map<String, Object> map) {
    }

    protected a() {
    }

    @Override // com.anythink.core.api.BaseAd
    public final void setTrackingInfo(n nVar) {
        this.mAdTrackingInfo = nVar;
    }

    @Override // com.anythink.core.api.BaseAd
    public final n getDetail() {
        return this.mAdTrackingInfo;
    }

    @Override // com.anythink.core.api.BaseAd
    public void setNativeEventListener(o oVar) {
        this.mNativeEventListener = oVar;
    }

    public final void notifyAdClicked() {
        o oVar = this.mNativeEventListener;
        if (oVar != null) {
            oVar.onAdClicked(null);
        }
    }

    public final void notifyAdImpression() {
        o oVar = this.mNativeEventListener;
        if (oVar != null) {
            oVar.onAdImpressed();
        }
    }

    public final void notifyAdVideoStart() {
        o oVar = this.mNativeEventListener;
        if (oVar != null) {
            oVar.onAdVideoStart();
        }
    }

    public final void notifyAdVideoEnd() {
        o oVar = this.mNativeEventListener;
        if (oVar != null) {
            oVar.onAdVideoEnd();
        }
    }

    public final void notifyAdVideoVideoPlayFail(String str, String str2) {
        o oVar = this.mNativeEventListener;
        if (oVar == null || !(oVar instanceof p)) {
            return;
        }
        ((p) oVar).a(str, str2);
    }

    public final void notifyDeeplinkCallback(boolean z) {
        o oVar = this.mNativeEventListener;
        if (oVar != null) {
            oVar.onDeeplinkCallback(z);
        }
    }

    public final void notifyAdVideoPlayProgress(int i) {
        o oVar = this.mNativeEventListener;
        if (oVar != null) {
            oVar.onAdVideoProgress(i);
        }
    }

    public final void notifyAdDislikeClick() {
        o oVar = this.mNativeEventListener;
        if (oVar != null) {
            oVar.onAdDislikeButtonClick();
        }
    }

    public final void notifyDownloadConfirm(Context context, View view, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
        o oVar = this.mNativeEventListener;
        if (oVar != null) {
            oVar.onDownloadConfirmCallback(context, view, aTNetworkConfirmInfo);
        }
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final String getAdType() {
        return this.mAdSourceType;
    }

    public final void setDownloadListener(ATEventInterface aTEventInterface) {
        this.mDownloadListener = aTEventInterface;
    }

    public final void setNativePrepareInfo(ATNativePrepareInfo aTNativePrepareInfo) {
        this.nativePrepareInfo = aTNativePrepareInfo;
    }

    public final ATNativePrepareInfo getNativePrepareInfo() {
        return this.nativePrepareInfo;
    }
}
