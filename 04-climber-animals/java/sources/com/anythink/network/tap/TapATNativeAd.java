package com.anythink.network.tap;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.anythink.dlopt.api.CustomAdapterDownloadListener;
import com.anythink.nativead.api.ATNativePrepareExInfo;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.tapsdk.tapad.ComplianceInfo;
import com.tapsdk.tapad.TapAdNative;
import com.tapsdk.tapad.TapAppDownloadListener;
import com.tapsdk.tapad.TapFeedAd;
import com.tapsdk.tapad.model.entities.ImageInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class TapATNativeAd extends CustomNativeAd {
    private static final int a = 0;
    public static boolean isAutoControlVideo = true;
    private Context b;
    private TapAdNative c;
    private TapFeedAd d;
    private FrameLayout e;
    private View f;
    private View g;
    private int h;

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public boolean supportSetPermissionClickViewList() {
        return true;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public boolean supportSetPrivacyClickViewList() {
        return true;
    }

    public TapATNativeAd(Context context, TapFeedAd tapFeedAd, TapAdNative tapAdNative) {
        this.b = context.getApplicationContext();
        this.d = tapFeedAd;
        this.c = tapAdNative;
        if (tapFeedAd != null) {
            setIconImageUrl(tapFeedAd.getIconUrl());
            setTitle(this.d.getTitle());
            setDescriptionText(this.d.getDescription());
            try {
                setStarRating(Double.valueOf(this.d.getScore()));
            } catch (Throwable unused) {
            }
            setCallToActionText(b());
            int imageMode = this.d.getImageMode();
            if (imageMode == 1) {
                this.mAdSourceType = "2";
            } else if (imageMode == 2) {
                this.mAdSourceType = "1";
            }
            List<ImageInfo> imageInfoList = this.d.getImageInfoList();
            if (imageInfoList != null && imageInfoList.size() > 0) {
                ImageInfo imageInfo = imageInfoList.get(0);
                if (imageInfo != null) {
                    setMainImageUrl(imageInfo.imageUrl);
                    if (imageInfo.width > 0 && imageInfo.height > 0) {
                        setMainImageWidth(imageInfo.width);
                        setMainImageHeight(imageInfo.height);
                    }
                }
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < imageInfoList.size(); i++) {
                    ImageInfo imageInfo2 = imageInfoList.get(i);
                    if (imageInfo2 != null) {
                        arrayList.add(imageInfo2.imageUrl);
                    }
                }
                setImageUrlList(arrayList);
            }
            ComplianceInfo complianceInfo = this.d.getComplianceInfo();
            if (complianceInfo != null && (!TextUtils.isEmpty(complianceInfo.getAppName()) || !TextUtils.isEmpty(complianceInfo.getAppVersion()) || !TextUtils.isEmpty(complianceInfo.getDeveloperName()) || !TextUtils.isEmpty(complianceInfo.getPermissionUrl()) || !TextUtils.isEmpty(complianceInfo.getPrivacyUrl()) || !TextUtils.isEmpty(complianceInfo.getFunctionDescUrl()))) {
                setAdAppInfo(new TapATAdAppInfo(complianceInfo));
            }
            int interactionType = this.d.getInteractionType();
            if (interactionType == 1) {
                setNativeInteractionType(1);
                return;
            }
            if (interactionType == 2) {
                setNativeInteractionType(3);
            } else if (interactionType == 3) {
                setNativeInteractionType(2);
            } else {
                setNativeInteractionType(0);
            }
        }
    }

    private void a() {
        TapFeedAd tapFeedAd = this.d;
        if (tapFeedAd == null) {
            return;
        }
        setIconImageUrl(tapFeedAd.getIconUrl());
        setTitle(this.d.getTitle());
        setDescriptionText(this.d.getDescription());
        try {
            setStarRating(Double.valueOf(this.d.getScore()));
        } catch (Throwable unused) {
        }
        setCallToActionText(b());
        int imageMode = this.d.getImageMode();
        if (imageMode == 1) {
            this.mAdSourceType = "2";
        } else if (imageMode == 2) {
            this.mAdSourceType = "1";
        }
        List<ImageInfo> imageInfoList = this.d.getImageInfoList();
        if (imageInfoList != null && imageInfoList.size() > 0) {
            ImageInfo imageInfo = imageInfoList.get(0);
            if (imageInfo != null) {
                setMainImageUrl(imageInfo.imageUrl);
                if (imageInfo.width > 0 && imageInfo.height > 0) {
                    setMainImageWidth(imageInfo.width);
                    setMainImageHeight(imageInfo.height);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < imageInfoList.size(); i++) {
                ImageInfo imageInfo2 = imageInfoList.get(i);
                if (imageInfo2 != null) {
                    arrayList.add(imageInfo2.imageUrl);
                }
            }
            setImageUrlList(arrayList);
        }
        ComplianceInfo complianceInfo = this.d.getComplianceInfo();
        if (complianceInfo != null && (!TextUtils.isEmpty(complianceInfo.getAppName()) || !TextUtils.isEmpty(complianceInfo.getAppVersion()) || !TextUtils.isEmpty(complianceInfo.getDeveloperName()) || !TextUtils.isEmpty(complianceInfo.getPermissionUrl()) || !TextUtils.isEmpty(complianceInfo.getPrivacyUrl()) || !TextUtils.isEmpty(complianceInfo.getFunctionDescUrl()))) {
            setAdAppInfo(new TapATAdAppInfo(complianceInfo));
        }
        int interactionType = this.d.getInteractionType();
        if (interactionType == 1) {
            setNativeInteractionType(1);
            return;
        }
        if (interactionType == 2) {
            setNativeInteractionType(3);
        } else if (interactionType == 3) {
            setNativeInteractionType(2);
        } else {
            setNativeInteractionType(0);
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdMediaView(Object... objArr) {
        TapFeedAd tapFeedAd;
        if (this.e == null && (tapFeedAd = this.d) != null && tapFeedAd.getImageMode() == 2 && this.b != null) {
            this.e = new FrameLayout(this.b) { // from class: com.anythink.network.tap.TapATNativeAd.1
                @Override // android.view.View
                protected final void onWindowVisibilityChanged(int i) {
                    if (TapATNativeAd.this.c == null || !TapATNativeAd.isAutoControlVideo) {
                        return;
                    }
                    if (i == 0) {
                        TapATNativeAd.this.c.resume();
                    } else {
                        TapATNativeAd.this.c.pause();
                    }
                }

                @Override // android.view.ViewGroup, android.view.View
                protected final void onDetachedFromWindow() {
                    super.onDetachedFromWindow();
                    if (TapATNativeAd.this.c == null || !TapATNativeAd.isAutoControlVideo) {
                        return;
                    }
                    TapATNativeAd.this.c.pause();
                }
            };
        }
        return this.e;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        ViewGroup viewGroup;
        if (this.d != null) {
            this.f = aTNativePrepareInfo.getCtaView();
            this.d.setDownloadListener(new TapAppDownloadListener() { // from class: com.anythink.network.tap.TapATNativeAd.2
                @Override // com.tapsdk.tapad.TapAppDownloadListener
                public final void onIdle() {
                    TapATNativeAd.this.h = 0;
                    TapATNativeAd tapATNativeAd = TapATNativeAd.this;
                    TapATNativeAd.a(tapATNativeAd, tapATNativeAd.f);
                }

                @Override // com.tapsdk.tapad.TapAppDownloadListener
                public final void onDownloadStart() {
                    TapATNativeAd.this.h = 1;
                    TapATNativeAd tapATNativeAd = TapATNativeAd.this;
                    TapATNativeAd.a(tapATNativeAd, tapATNativeAd.f);
                    if (TapATNativeAd.this.mDownloadListener == null || !(TapATNativeAd.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                        return;
                    }
                    ((CustomAdapterDownloadListener) TapATNativeAd.this.mDownloadListener).onDownloadStart(0L, 0L, "", TapATNativeAd.this.getTitle());
                }

                @Override // com.tapsdk.tapad.TapAppDownloadListener
                public final void onDownloadComplete() {
                    TapATNativeAd.this.h = 2;
                    TapATNativeAd tapATNativeAd = TapATNativeAd.this;
                    TapATNativeAd.a(tapATNativeAd, tapATNativeAd.f);
                    if (TapATNativeAd.this.mDownloadListener == null || !(TapATNativeAd.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                        return;
                    }
                    ((CustomAdapterDownloadListener) TapATNativeAd.this.mDownloadListener).onDownloadFinish(0L, "", TapATNativeAd.this.getTitle());
                }

                @Override // com.tapsdk.tapad.TapAppDownloadListener
                public final void onUpdateDownloadProgress(int i) {
                    TapATNativeAd.this.h = 1;
                    TapATNativeAd tapATNativeAd = TapATNativeAd.this;
                    TapATNativeAd.a(tapATNativeAd, tapATNativeAd.f);
                }

                @Override // com.tapsdk.tapad.TapAppDownloadListener
                public final void onDownloadError() {
                    TapATNativeAd.this.h = -1;
                    TapATNativeAd tapATNativeAd = TapATNativeAd.this;
                    TapATNativeAd.a(tapATNativeAd, tapATNativeAd.f);
                    if (TapATNativeAd.this.mDownloadListener == null || !(TapATNativeAd.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                        return;
                    }
                    ((CustomAdapterDownloadListener) TapATNativeAd.this.mDownloadListener).onDownloadFail(0L, 0L, "", TapATNativeAd.this.getTitle());
                }

                @Override // com.tapsdk.tapad.TapAppDownloadListener
                public final void onInstalled() {
                    TapATNativeAd.this.h = 3;
                    TapATNativeAd tapATNativeAd = TapATNativeAd.this;
                    TapATNativeAd.a(tapATNativeAd, tapATNativeAd.f);
                    if (TapATNativeAd.this.mDownloadListener == null || !(TapATNativeAd.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                        return;
                    }
                    ((CustomAdapterDownloadListener) TapATNativeAd.this.mDownloadListener).onInstalled("", TapATNativeAd.this.getTitle());
                }
            });
            if (view instanceof ViewGroup) {
                viewGroup = (ViewGroup) view;
            } else {
                viewGroup = view.getParent() != null ? (ViewGroup) view.getParent() : null;
            }
            List<View> clickViewList = aTNativePrepareInfo.getClickViewList();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            if (aTNativePrepareInfo instanceof ATNativePrepareExInfo) {
                ATNativePrepareExInfo aTNativePrepareExInfo = (ATNativePrepareExInfo) aTNativePrepareInfo;
                List<View> creativeClickViewList = aTNativePrepareExInfo.getCreativeClickViewList();
                List<View> privacyClickViewList = aTNativePrepareExInfo.getPrivacyClickViewList();
                List<View> permissionClickViewList = aTNativePrepareExInfo.getPermissionClickViewList();
                List<View> appInfoClickViewList = aTNativePrepareExInfo.getAppInfoClickViewList();
                if (creativeClickViewList != null && creativeClickViewList.size() > 0) {
                    arrayList.addAll(creativeClickViewList);
                }
                if (privacyClickViewList != null && privacyClickViewList.size() > 0) {
                    arrayList2.addAll(privacyClickViewList);
                }
                if (permissionClickViewList != null && permissionClickViewList.size() > 0) {
                    arrayList3.addAll(permissionClickViewList);
                }
                if (appInfoClickViewList != null && appInfoClickViewList.size() > 0) {
                    arrayList4.addAll(appInfoClickViewList);
                }
            }
            if (clickViewList != null && clickViewList.size() > 0) {
                arrayList.addAll(clickViewList);
            }
            TapFeedAd.AdInteractionListener adInteractionListener = new TapFeedAd.AdInteractionListener() { // from class: com.anythink.network.tap.TapATNativeAd.3
                @Override // com.tapsdk.tapad.TapFeedAd.AdInteractionListener
                public final void onAdValidView(TapFeedAd tapFeedAd) {
                }

                @Override // com.tapsdk.tapad.TapFeedAd.AdInteractionListener
                public final void onDistinctAdShow(TapFeedAd tapFeedAd) {
                }

                @Override // com.tapsdk.tapad.TapFeedAd.AdInteractionListener
                public final void onAdClicked(View view2, TapFeedAd tapFeedAd) {
                    TapATNativeAd.this.notifyAdClicked();
                }

                @Override // com.tapsdk.tapad.TapFeedAd.AdInteractionListener
                public final void onAdCreativeClick(View view2, TapFeedAd tapFeedAd) {
                    TapATNativeAd.this.notifyAdClicked();
                }

                @Override // com.tapsdk.tapad.TapFeedAd.AdInteractionListener
                public final void onAdShow(TapFeedAd tapFeedAd) {
                    TapATNativeAd.this.notifyAdImpression();
                }
            };
            if (view.getContext() instanceof Activity) {
                this.d.registerViewForInteraction((Activity) view.getContext(), viewGroup, clickViewList, arrayList, arrayList4, arrayList2, arrayList3, adInteractionListener);
            } else {
                this.d.registerViewForInteraction(viewGroup, clickViewList, arrayList, arrayList4, arrayList2, arrayList3, adInteractionListener);
            }
            if (TextUtils.equals(this.mAdSourceType, "1")) {
                this.d.setVideoAdListener(new TapFeedAd.VideoAdListener() { // from class: com.anythink.network.tap.TapATNativeAd.4
                    @Override // com.tapsdk.tapad.TapFeedAd.VideoAdListener
                    public final void onVideoPause(TapFeedAd tapFeedAd) {
                    }

                    @Override // com.tapsdk.tapad.TapFeedAd.VideoAdListener
                    public final void onVideoPrepared(TapFeedAd tapFeedAd) {
                    }

                    @Override // com.tapsdk.tapad.TapFeedAd.VideoAdListener
                    public final void onVideoVolumeClose(TapFeedAd tapFeedAd) {
                    }

                    @Override // com.tapsdk.tapad.TapFeedAd.VideoAdListener
                    public final void onVideoVolumeOpen(TapFeedAd tapFeedAd) {
                    }

                    @Override // com.tapsdk.tapad.TapFeedAd.VideoAdListener
                    public final void onVideoStart(TapFeedAd tapFeedAd) {
                        TapATNativeAd.this.notifyAdVideoStart();
                    }

                    @Override // com.tapsdk.tapad.TapFeedAd.VideoAdListener
                    public final void onVideoError(TapFeedAd tapFeedAd, int i, int i2) {
                        TapATNativeAd.this.notifyAdVideoVideoPlayFail(String.valueOf(i), String.valueOf(i2));
                    }
                });
            }
            FrameLayout frameLayout = this.e;
            if (frameLayout == null || this.d == null) {
                return;
            }
            frameLayout.removeAllViews();
            View adView = this.d.getAdView();
            this.g = adView;
            if (adView == null) {
                return;
            }
            if (adView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.g.getParent()).removeView(this.g);
            }
            this.e.addView(this.g);
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void onResume() {
        TapAdNative tapAdNative = this.c;
        if (tapAdNative != null) {
            tapAdNative.resume();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void onPause() {
        TapAdNative tapAdNative = this.c;
        if (tapAdNative != null) {
            tapAdNative.pause();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void resumeVideo() {
        TapAdNative tapAdNative = this.c;
        if (tapAdNative != null) {
            tapAdNative.resume();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void pauseVideo() {
        TapAdNative tapAdNative = this.c;
        if (tapAdNative != null) {
            tapAdNative.pause();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        super.destroy();
        TapAdNative tapAdNative = this.c;
        if (tapAdNative != null) {
            tapAdNative.pause();
            this.c.dispose();
            this.c = null;
        }
        TapFeedAd tapFeedAd = this.d;
        if (tapFeedAd != null) {
            tapFeedAd.dispose();
            this.d = null;
        }
        this.g = null;
        this.e = null;
        this.b = null;
        this.f = null;
    }

    private String b() {
        int i = this.h;
        if (i == -1) {
            return "重新下载";
        }
        if (i == 1) {
            return "下载中";
        }
        if (i != 2) {
            return i != 3 ? "立即下载" : "打开";
        }
        return "安装";
    }

    private void a(View view) {
        if (view instanceof TextView) {
            ((TextView) view).setText(b());
        }
    }

    static /* synthetic */ void a(TapATNativeAd tapATNativeAd, View view) {
        if (view instanceof TextView) {
            ((TextView) view).setText(tapATNativeAd.b());
        }
    }
}
