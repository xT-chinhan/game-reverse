package com.anythink.network.baidu;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.core.api.ATShakeViewListener;
import com.anythink.dlopt.api.CustomAdapterDownloadListener;
import com.anythink.nativead.api.ATNativePrepareExInfo;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.anythink.network.baidu.impression.BDImpressionController;
import com.anythink.network.baidu.impression.BDImpressionTracker;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.XNativeView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class BaiduATNativeAd extends CustomNativeAd {
    private static final String f = "BaiduATNativeAd";
    protected NativeResponse a;
    protected Context b;
    BDImpressionTracker c;
    boolean d;
    private Map<String, Object> h;
    private XNativeView i;
    private boolean g = false;
    boolean e = true;

    protected BaiduATNativeAd() {
    }

    public BaiduATNativeAd(Context context, NativeResponse nativeResponse, boolean z, boolean z2) {
        a(context, nativeResponse);
        this.d = z;
        if (z2) {
            if (this.h == null) {
                this.h = new HashMap();
            }
            this.h.put(BaiduATConst.EN_P_KEY, nativeResponse.getPECPM());
            setNetworkInfoMap(this.h);
        }
    }

    protected final void a(Context context, NativeResponse nativeResponse) {
        this.b = context.getApplicationContext();
        this.c = new BDImpressionTracker(this.b, 50);
        this.a = nativeResponse;
        setData(nativeResponse);
    }

    public void setData(NativeResponse nativeResponse) {
        setIconImageUrl(nativeResponse.getIconUrl());
        if (TextUtils.isEmpty(nativeResponse.getImageUrl())) {
            List<String> multiPicUrls = nativeResponse.getMultiPicUrls();
            if (multiPicUrls != null && multiPicUrls.size() > 0) {
                setMainImageUrl(multiPicUrls.get(0));
                setMainImageWidth(nativeResponse.getMainPicWidth());
                setMainImageHeight(nativeResponse.getMainPicHeight());
            }
        } else {
            setMainImageUrl(nativeResponse.getImageUrl());
            setMainImageWidth(nativeResponse.getMainPicWidth());
            setMainImageHeight(nativeResponse.getMainPicHeight());
        }
        setMainImageWidth(nativeResponse.getMainPicWidth());
        setMainImageHeight(nativeResponse.getMainPicHeight());
        setImageUrlList(nativeResponse.getMultiPicUrls());
        setVideoUrl(nativeResponse.getVideoUrl());
        setVideoDuration(nativeResponse.getDuration());
        setAdChoiceIconUrl(nativeResponse.getBaiduLogoUrl());
        setTitle(nativeResponse.getTitle());
        setDescriptionText(nativeResponse.getDesc());
        setCallToActionText(nativeResponse.getActButtonString());
        setAdvertiserName(nativeResponse.getBrandName());
        int i = nativeResponse.getAdActionType() == 1 ? 2 : 0;
        if (nativeResponse.getAdActionType() == 2) {
            i = 1;
        }
        if (nativeResponse.getAdActionType() == 3) {
            i = 3;
        }
        setNativeInteractionType(i);
        if (nativeResponse.getAdActionType() == 2) {
            setAdAppInfo(new BaiduATDownloadAppInfo(nativeResponse));
        }
        if (TextUtils.equals(nativeResponse.getAdMaterialType(), NativeResponse.MaterialType.VIDEO.getValue())) {
            this.mAdSourceType = "1";
        } else {
            this.mAdSourceType = "2";
        }
        int adActionType = this.a.getAdActionType();
        if (adActionType == 1) {
            setNativeInteractionType(2);
        } else if (adActionType == 2) {
            setNativeInteractionType(1);
        } else {
            if (adActionType != 3) {
                return;
            }
            setNativeInteractionType(3);
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        List<View> creativeClickViewList;
        if (this.a != null) {
            List<View> arrayList = new ArrayList<>();
            if ((aTNativePrepareInfo instanceof ATNativePrepareExInfo) && (creativeClickViewList = ((ATNativePrepareExInfo) aTNativePrepareInfo).getCreativeClickViewList()) != null) {
                arrayList = creativeClickViewList;
            }
            List<View> clickViewList = aTNativePrepareInfo.getClickViewList();
            if (clickViewList == null || clickViewList.size() == 0) {
                clickViewList = a(view);
            }
            this.a.registerViewForInteraction(view, clickViewList, arrayList, new NativeResponse.AdInteractionListener() { // from class: com.anythink.network.baidu.BaiduATNativeAd.1
                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                public final void onAdUnionClick() {
                }

                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                public final void onAdClick() {
                    BaiduATNativeAd.this.notifyAdClicked();
                }

                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                public final void onADExposed() {
                    if (BaiduATNativeAd.this.c != null) {
                        BaiduATNativeAd.this.c.clear();
                        BaiduATNativeAd.this.c = null;
                    }
                    BaiduATNativeAd.this.notifyAdImpression();
                }

                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                public final void onADExposureFailed(int i) {
                    Log.e(BaiduATNativeAd.f, "Baidu Native onADExposureFailed:".concat(String.valueOf(i)));
                }

                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                public final void onADStatusChanged() {
                    if (BaiduATNativeAd.this.mDownloadListener == null || BaiduATNativeAd.this.a == null) {
                        return;
                    }
                    long appSize = BaiduATNativeAd.this.a.getAppSize();
                    String title = BaiduATNativeAd.this.a.getTitle();
                    String appPackage = BaiduATNativeAd.this.a.getAppPackage();
                    long downloadProgress = (((long) BaiduATNativeAd.this.getDownloadProgress()) * appSize) / 100;
                    int downloadStatus = BaiduATNativeAd.this.getDownloadStatus();
                    if (downloadStatus != 1) {
                        if (downloadStatus == 2) {
                            ((CustomAdapterDownloadListener) BaiduATNativeAd.this.mDownloadListener).onInstalled(appPackage, title);
                            return;
                        }
                        if (downloadStatus == 4) {
                            if (!BaiduATNativeAd.this.g) {
                                ((CustomAdapterDownloadListener) BaiduATNativeAd.this.mDownloadListener).onDownloadStart(appSize, downloadProgress, appPackage, title);
                                BaiduATNativeAd.this.g = true;
                                return;
                            } else {
                                ((CustomAdapterDownloadListener) BaiduATNativeAd.this.mDownloadListener).onDownloadUpdate(appSize, downloadProgress, appPackage, title);
                                return;
                            }
                        }
                        if (downloadStatus == 5) {
                            ((CustomAdapterDownloadListener) BaiduATNativeAd.this.mDownloadListener).onDownloadFinish(appSize, appPackage, title);
                            BaiduATNativeAd.this.g = false;
                            return;
                        } else if (downloadStatus == 6) {
                            ((CustomAdapterDownloadListener) BaiduATNativeAd.this.mDownloadListener).onDownloadFail(appSize, downloadProgress, appPackage, title);
                            BaiduATNativeAd.this.g = false;
                            return;
                        } else if (downloadStatus != 7) {
                            return;
                        }
                    }
                    if (BaiduATNativeAd.this.g) {
                        ((CustomAdapterDownloadListener) BaiduATNativeAd.this.mDownloadListener).onDownloadPause(appSize, downloadProgress, appPackage, title);
                        BaiduATNativeAd.this.g = false;
                    }
                }
            });
        }
        XNativeView xNativeView = this.i;
        if (xNativeView != null) {
            xNativeView.render();
        }
        try {
            BDImpressionTracker bDImpressionTracker = this.c;
            if (bDImpressionTracker != null) {
                bDImpressionTracker.addView(view, new BDImpressionController() { // from class: com.anythink.network.baidu.BaiduATNativeAd.2
                    @Override // com.anythink.network.baidu.impression.BDImpressionController, com.anythink.network.baidu.impression.BDImpressionInterface
                    public final void recordImpression(View view2) {
                        try {
                            if (BaiduATNativeAd.this.a == null || view2 == null) {
                                return;
                            }
                            BaiduATNativeAd.this.a.recordImpression(view2);
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }

    private void a(View view, View.OnClickListener onClickListener) {
        if ((view instanceof ViewGroup) && view != this.i) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(viewGroup.getChildAt(i), onClickListener);
            }
            return;
        }
        view.setOnClickListener(onClickListener);
    }

    private List<View> a(View view) {
        ArrayList arrayList = new ArrayList();
        if ((view instanceof ViewGroup) && view != this.i) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                arrayList.addAll(a(viewGroup.getChildAt(i)));
            }
        } else {
            arrayList.add(view);
        }
        return arrayList;
    }

    private void b(View view) {
        if (view == null) {
            return;
        }
        if ((view instanceof ViewGroup) && view != this.i) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                b(viewGroup.getChildAt(i));
            }
            return;
        }
        view.setOnClickListener(null);
        view.setClickable(false);
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void clear(View view) {
        b(view);
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdMediaView(Object... objArr) {
        NativeResponse nativeResponse = this.a;
        if (nativeResponse == null || nativeResponse.getMaterialType() != NativeResponse.MaterialType.VIDEO) {
            return null;
        }
        if (this.i == null) {
            XNativeView xNativeView = new XNativeView(this.b);
            this.i = xNativeView;
            xNativeView.setNativeItem(this.a);
            this.i.setVideoMute(this.e);
            if (!this.d) {
                this.i.setNativeViewClickListener(new XNativeView.INativeViewClickListener() { // from class: com.anythink.network.baidu.BaiduATNativeAd.3
                    @Override // com.baidu.mobads.sdk.api.XNativeView.INativeViewClickListener
                    public final void onNativeViewClick(XNativeView xNativeView2) {
                        BaiduATNativeAd.this.notifyAdClicked();
                    }
                });
            }
        }
        return this.i;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public int getMainImageWidth() {
        NativeResponse nativeResponse = this.a;
        if (nativeResponse != null) {
            return nativeResponse.getMainPicWidth();
        }
        return 0;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public int getMainImageHeight() {
        NativeResponse nativeResponse = this.a;
        if (nativeResponse != null) {
            return nativeResponse.getMainPicHeight();
        }
        return 0;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        this.a = null;
        XNativeView xNativeView = this.i;
        if (xNativeView != null) {
            xNativeView.setNativeItem(null);
            this.i.setNativeViewClickListener(null);
            this.i = null;
        }
        this.b = null;
        BDImpressionTracker bDImpressionTracker = this.c;
        if (bDImpressionTracker != null) {
            bDImpressionTracker.clear();
            this.c = null;
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd
    public void impressionTrack(View view) {
        NativeResponse nativeResponse = this.a;
        if (nativeResponse == null || view == null) {
            return;
        }
        nativeResponse.recordImpression(view);
        notifyAdImpression();
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void setVideoMute(boolean z) {
        this.e = z;
        XNativeView xNativeView = this.i;
        if (xNativeView != null) {
            xNativeView.setVideoMute(z);
        }
    }

    @Override // com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getShakeView(int i, int i2, final ATShakeViewListener aTShakeViewListener) {
        NativeResponse nativeResponse = this.a;
        if (nativeResponse != null) {
            return nativeResponse.renderShakeView(i, i2, new NativeResponse.AdShakeViewListener() { // from class: com.anythink.network.baidu.BaiduATNativeAd.4
                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdShakeViewListener
                public final void onDismiss() {
                    ATShakeViewListener aTShakeViewListener2 = aTShakeViewListener;
                    if (aTShakeViewListener2 != null) {
                        aTShakeViewListener2.onDismiss();
                    }
                }
            });
        }
        return null;
    }

    @Override // com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getSlideView(int i, int i2, int i3, final ATShakeViewListener aTShakeViewListener) {
        NativeResponse nativeResponse = this.a;
        if (nativeResponse != null) {
            return nativeResponse.renderSlideView(i, i2, i3, new NativeResponse.AdShakeViewListener() { // from class: com.anythink.network.baidu.BaiduATNativeAd.5
                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdShakeViewListener
                public final void onDismiss() {
                    ATShakeViewListener aTShakeViewListener2 = aTShakeViewListener;
                    if (aTShakeViewListener2 != null) {
                        aTShakeViewListener2.onDismiss();
                    }
                }
            });
        }
        return null;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public int getNativeAdInteractionType() {
        NativeResponse nativeResponse = this.a;
        if (nativeResponse == null) {
            return 0;
        }
        int adActionType = nativeResponse.getAdActionType();
        if (adActionType == 1) {
            return 2;
        }
        if (adActionType != 2) {
            return adActionType != 3 ? 0 : 3;
        }
        return 1;
    }

    @Override // com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public int getDownloadStatus() {
        NativeResponse nativeResponse = this.a;
        if (nativeResponse == null) {
            return 0;
        }
        int downloadStatus = nativeResponse.getDownloadStatus();
        if (downloadStatus == -1) {
            return 1;
        }
        if (downloadStatus >= 0 && downloadStatus <= 100) {
            return 4;
        }
        switch (downloadStatus) {
            case 101:
                return 5;
            case 102:
                return 7;
            case 103:
                return 2;
            case 104:
                return 6;
            default:
                return 0;
        }
    }

    @Override // com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public int getDownloadProgress() {
        int downloadStatus;
        NativeResponse nativeResponse = this.a;
        if (nativeResponse == null || (downloadStatus = nativeResponse.getDownloadStatus()) < 0 || downloadStatus > 100) {
            return 0;
        }
        return downloadStatus;
    }

    @Override // com.anythink.nativead.unitgroup.a
    public Object getObject() {
        return this.a;
    }
}
