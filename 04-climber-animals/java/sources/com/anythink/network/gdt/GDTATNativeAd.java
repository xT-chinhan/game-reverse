package com.anythink.network.gdt;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.anythink.dlopt.api.CustomAdapterDownloadListener;
import com.anythink.nativead.api.ATNativePrepareExInfo;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListenerWithClickInfo;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.util.AdError;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GDTATNativeAd extends CustomNativeAd {
    private static final String m = "GDTATNativeAd";
    WeakReference<Context> a;
    Context b;
    NativeUnifiedADData c;
    int d;
    int e;
    int f;
    boolean h;
    View i;
    MediaView j;
    NativeAdContainer l;
    int g = 0;
    private boolean n = false;
    boolean k = false;

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public boolean isNativeExpress() {
        return false;
    }

    protected GDTATNativeAd(Context context, NativeUnifiedADData nativeUnifiedADData, int i, int i2, int i3, boolean z) {
        String strValueOf;
        this.h = false;
        this.b = context.getApplicationContext();
        this.a = new WeakReference<>(context);
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.c = nativeUnifiedADData;
        setTitle(nativeUnifiedADData.getTitle());
        setDescriptionText(nativeUnifiedADData.getDesc());
        setIconImageUrl(nativeUnifiedADData.getIconUrl());
        setStarRating(Double.valueOf(nativeUnifiedADData.getAppScore()));
        setAppPrice(nativeUnifiedADData.getAppPrice());
        setCallToActionText(getCallToAction(nativeUnifiedADData));
        setMainImageUrl(nativeUnifiedADData.getImgUrl());
        setMainImageWidth(nativeUnifiedADData.getPictureWidth());
        setMainImageHeight(nativeUnifiedADData.getPictureHeight());
        setImageUrlList(nativeUnifiedADData.getImgList());
        setVideoDuration(((double) nativeUnifiedADData.getVideoDuration()) / 1000.0d);
        setNativeInteractionType(nativeUnifiedADData.isAppAd() ? 1 : 0);
        NativeUnifiedADAppMiitInfo appMiitInfo = nativeUnifiedADData.getAppMiitInfo();
        if (nativeUnifiedADData.isAppAd() && appMiitInfo != null) {
            try {
                strValueOf = String.valueOf(nativeUnifiedADData.getDownloadCount());
            } catch (Exception unused) {
                strValueOf = "";
            }
            setAdAppInfo(new GDTATDownloadAppInfo(appMiitInfo, strValueOf));
        }
        if (nativeUnifiedADData.getAdPatternType() == 2) {
            this.mAdSourceType = "1";
        } else {
            this.mAdSourceType = "2";
        }
        nativeUnifiedADData.setNativeAdEventListener(new AnonymousClass2(nativeUnifiedADData));
        setNetworkInfoMap(nativeUnifiedADData.getExtraInfo());
        this.h = z;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd
    public void registerDownloadConfirmListener() {
        this.c.setDownloadConfirmListener(new DownloadConfirmListener() { // from class: com.anythink.network.gdt.GDTATNativeAd.1
            @Override // com.qq.e.comm.compliance.DownloadConfirmListener
            public final void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
                Log.i(GDTATNativeAd.m, "onDownloadConfirm....");
                View view = GDTATNativeAd.this.i;
                GDTATNativeAd.this.i = null;
                GDTDownloadFirmInfo gDTDownloadFirmInfo = new GDTDownloadFirmInfo();
                gDTDownloadFirmInfo.appInfoUrl = str;
                gDTDownloadFirmInfo.scenes = i;
                gDTDownloadFirmInfo.confirmCallBack = downloadConfirmCallBack;
                GDTATNativeAd.this.notifyDownloadConfirm(activity, view, gDTDownloadFirmInfo);
            }
        });
    }

    public String getCallToAction(NativeUnifiedADData nativeUnifiedADData) {
        if (!TextUtils.isEmpty(nativeUnifiedADData.getCTAText())) {
            return nativeUnifiedADData.getCTAText();
        }
        boolean zIsAppAd = nativeUnifiedADData.isAppAd();
        int appStatus = nativeUnifiedADData.getAppStatus();
        if (!zIsAppAd) {
            return "浏览";
        }
        if (appStatus == 0) {
            return "下载";
        }
        if (appStatus == 1) {
            return "启动";
        }
        if (appStatus == 2) {
            return "更新";
        }
        if (appStatus == 4) {
            return "下载";
        }
        if (appStatus != 8) {
            return appStatus != 16 ? "浏览" : "下载";
        }
        return "安装";
    }

    private void a(NativeUnifiedADData nativeUnifiedADData) {
        String strValueOf;
        setTitle(nativeUnifiedADData.getTitle());
        setDescriptionText(nativeUnifiedADData.getDesc());
        setIconImageUrl(nativeUnifiedADData.getIconUrl());
        setStarRating(Double.valueOf(nativeUnifiedADData.getAppScore()));
        setAppPrice(nativeUnifiedADData.getAppPrice());
        setCallToActionText(getCallToAction(nativeUnifiedADData));
        setMainImageUrl(nativeUnifiedADData.getImgUrl());
        setMainImageWidth(nativeUnifiedADData.getPictureWidth());
        setMainImageHeight(nativeUnifiedADData.getPictureHeight());
        setImageUrlList(nativeUnifiedADData.getImgList());
        setVideoDuration(((double) nativeUnifiedADData.getVideoDuration()) / 1000.0d);
        setNativeInteractionType(nativeUnifiedADData.isAppAd() ? 1 : 0);
        NativeUnifiedADAppMiitInfo appMiitInfo = nativeUnifiedADData.getAppMiitInfo();
        if (nativeUnifiedADData.isAppAd() && appMiitInfo != null) {
            try {
                strValueOf = String.valueOf(nativeUnifiedADData.getDownloadCount());
            } catch (Exception unused) {
                strValueOf = "";
            }
            setAdAppInfo(new GDTATDownloadAppInfo(appMiitInfo, strValueOf));
        }
        if (nativeUnifiedADData.getAdPatternType() == 2) {
            this.mAdSourceType = "1";
        } else {
            this.mAdSourceType = "2";
        }
        nativeUnifiedADData.setNativeAdEventListener(new AnonymousClass2(nativeUnifiedADData));
        setNetworkInfoMap(nativeUnifiedADData.getExtraInfo());
    }

    /* JADX INFO: renamed from: com.anythink.network.gdt.GDTATNativeAd$2, reason: invalid class name */
    final class AnonymousClass2 extends NativeADEventListenerWithClickInfo {
        final /* synthetic */ NativeUnifiedADData a;

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public final void onADError(AdError adError) {
        }

        AnonymousClass2(NativeUnifiedADData nativeUnifiedADData) {
            this.a = nativeUnifiedADData;
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public final void onADExposed() {
            GDTATInitManager.getInstance().a(GDTATNativeAd.this.getShowId(), new WeakReference(this.a));
            GDTATNativeAd.this.notifyAdImpression();
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListenerWithClickInfo
        public final void onADClicked(View view) {
            GDTATNativeAd.this.i = view;
            Log.i(GDTATNativeAd.m, "onADClicked....".concat(String.valueOf(view)));
            GDTATNativeAd.this.notifyAdClicked();
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public final void onADStatusChanged() {
            String str;
            long j;
            long downloadProgress;
            if (GDTATNativeAd.this.mDownloadListener == null || GDTATNativeAd.this.c == null) {
                return;
            }
            int appStatus = GDTATNativeAd.this.c.getAppStatus();
            NativeUnifiedADAppMiitInfo appMiitInfo = GDTATNativeAd.this.c.getAppMiitInfo();
            if (!GDTATNativeAd.this.c.isAppAd() || appMiitInfo == null) {
                str = "";
                j = 0;
                downloadProgress = 0;
            } else {
                String appName = appMiitInfo.getAppName();
                long packageSizeBytes = appMiitInfo.getPackageSizeBytes();
                str = appName;
                downloadProgress = (((long) GDTATNativeAd.this.getDownloadProgress()) * packageSizeBytes) / 100;
                j = packageSizeBytes;
            }
            if (appStatus == 1) {
                ((CustomAdapterDownloadListener) GDTATNativeAd.this.mDownloadListener).onInstalled("", str);
                return;
            }
            if (appStatus == 4) {
                if (!GDTATNativeAd.this.n) {
                    ((CustomAdapterDownloadListener) GDTATNativeAd.this.mDownloadListener).onDownloadStart(j, downloadProgress, "", str);
                    GDTATNativeAd.this.n = true;
                    return;
                } else {
                    ((CustomAdapterDownloadListener) GDTATNativeAd.this.mDownloadListener).onDownloadUpdate(j, downloadProgress, "", str);
                    return;
                }
            }
            if (appStatus == 8) {
                ((CustomAdapterDownloadListener) GDTATNativeAd.this.mDownloadListener).onDownloadFinish(j, "", str);
                GDTATNativeAd.this.n = false;
            } else {
                if (appStatus != 16) {
                    if (appStatus == 32 && GDTATNativeAd.this.n) {
                        ((CustomAdapterDownloadListener) GDTATNativeAd.this.mDownloadListener).onDownloadPause(j, downloadProgress, "", str);
                        GDTATNativeAd.this.n = false;
                        return;
                    }
                    return;
                }
                ((CustomAdapterDownloadListener) GDTATNativeAd.this.mDownloadListener).onDownloadFail(j, downloadProgress, "", str);
                GDTATNativeAd.this.n = false;
            }
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdMediaView(Object... objArr) {
        NativeUnifiedADData nativeUnifiedADData = this.c;
        if (nativeUnifiedADData != null) {
            if (nativeUnifiedADData.getAdPatternType() != 2) {
                return super.getAdMediaView(objArr);
            }
            if (this.j == null) {
                MediaView mediaView = new MediaView(this.b);
                this.j = mediaView;
                mediaView.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                ViewGroup.LayoutParams layoutParams = this.j.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(-1, -2);
                }
                this.j.setLayoutParams(layoutParams);
            }
            return this.j;
        }
        return super.getAdMediaView(objArr);
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        List<View> creativeClickViewList;
        if (this.c == null || this.l == null) {
            return;
        }
        List<View> clickViewList = aTNativePrepareInfo.getClickViewList();
        if (clickViewList == null || clickViewList.size() == 0) {
            clickViewList = new ArrayList<>();
            a(view, clickViewList);
        }
        List<View> list = clickViewList;
        FrameLayout.LayoutParams choiceViewLayoutParams = aTNativePrepareInfo.getChoiceViewLayoutParams();
        ArrayList arrayList = new ArrayList();
        if ((aTNativePrepareInfo instanceof ATNativePrepareExInfo) && (creativeClickViewList = ((ATNativePrepareExInfo) aTNativePrepareInfo).getCreativeClickViewList()) != null) {
            arrayList.addAll(creativeClickViewList);
        }
        this.c.bindAdToView(view.getContext(), this.l, choiceViewLayoutParams, list, arrayList);
        try {
            if (this.j == null) {
                return;
            }
            VideoOption.Builder autoPlayPolicy = new VideoOption.Builder().setAutoPlayMuted(this.d == 1).setDetailPageMuted(this.d == 1).setAutoPlayPolicy(this.e);
            if (this.h) {
                autoPlayPolicy.setEnableUserControl(true);
            }
            this.c.bindMediaView(this.j, autoPlayPolicy.build(), new NativeADMediaListener() { // from class: com.anythink.network.gdt.GDTATNativeAd.3
                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public final void onVideoClicked() {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public final void onVideoInit() {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public final void onVideoLoaded(int i) {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public final void onVideoLoading() {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public final void onVideoPause() {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public final void onVideoReady() {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public final void onVideoResume() {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public final void onVideoStop() {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public final void onVideoStart() {
                    GDTATNativeAd.this.notifyAdVideoStart();
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public final void onVideoCompleted() {
                    GDTATNativeAd.this.notifyAdVideoEnd();
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public final void onVideoError(AdError adError) {
                    GDTATNativeAd.this.notifyAdVideoVideoPlayFail(new StringBuilder().append(adError.getErrorCode()).toString(), adError.getErrorMsg());
                }
            });
            int i = this.g;
            if (i > 0) {
                this.c.setVideoMute(i == 1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public ViewGroup getCustomAdContainer() {
        if (this.c != null) {
            this.l = new NativeAdContainer(this.b);
        }
        return this.l;
    }

    private void a(View view, List<View> list) {
        if ((view instanceof ViewGroup) && view != this.j) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(viewGroup.getChildAt(i), list);
            }
            return;
        }
        list.add(view);
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void clear(View view) {
        a(view);
    }

    private void a(View view) {
        if (view == null) {
            return;
        }
        if ((view instanceof ViewGroup) && view != this.j) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(viewGroup.getChildAt(i));
            }
            return;
        }
        view.setOnClickListener(null);
        view.setClickable(false);
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void onResume() {
        NativeUnifiedADData nativeUnifiedADData = this.c;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.resume();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void resumeVideo() {
        NativeUnifiedADData nativeUnifiedADData = this.c;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.resumeVideo();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void pauseVideo() {
        NativeUnifiedADData nativeUnifiedADData = this.c;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.pauseVideo();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void setVideoMute(boolean z) {
        this.g = z ? 1 : 2;
        NativeUnifiedADData nativeUnifiedADData = this.c;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.setVideoMute(z);
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public double getVideoProgress() {
        NativeUnifiedADData nativeUnifiedADData = this.c;
        if (nativeUnifiedADData != null) {
            return ((double) nativeUnifiedADData.getVideoCurrentPosition()) / 1000.0d;
        }
        return super.getVideoProgress();
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        super.destroy();
        NativeUnifiedADData nativeUnifiedADData = this.c;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.setNativeAdEventListener(null);
            this.c.destroy();
            this.c = null;
        }
        this.j = null;
        this.b = null;
        WeakReference<Context> weakReference = this.a;
        if (weakReference != null) {
            weakReference.clear();
            this.a = null;
        }
        NativeAdContainer nativeAdContainer = this.l;
        if (nativeAdContainer != null) {
            nativeAdContainer.removeAllViews();
            this.l = null;
        }
    }

    @Override // com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public int getDownloadStatus() {
        NativeUnifiedADData nativeUnifiedADData = this.c;
        if (nativeUnifiedADData == null) {
            return 0;
        }
        int appStatus = nativeUnifiedADData.getAppStatus();
        if (appStatus == 0) {
            return 1;
        }
        if (appStatus == 1) {
            return 2;
        }
        if (appStatus == 2) {
            return 3;
        }
        if (appStatus == 4) {
            return 4;
        }
        if (appStatus == 8) {
            return 5;
        }
        if (appStatus == 16) {
            return 6;
        }
        if (appStatus != 32) {
            return appStatus != 64 ? 0 : 8;
        }
        return 7;
    }

    @Override // com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public int getDownloadProgress() {
        NativeUnifiedADData nativeUnifiedADData = this.c;
        if (nativeUnifiedADData != null) {
            return nativeUnifiedADData.getProgress();
        }
        return 0;
    }
}
