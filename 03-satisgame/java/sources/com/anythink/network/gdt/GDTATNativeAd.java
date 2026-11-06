package com.anythink.network.gdt;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.anythink.china.api.CustomAdapterDownloadListener;
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
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class GDTATNativeAd extends CustomNativeAd {
    private static final String n = "GDTATNativeAd";
    WeakReference<Context> a;
    Context b;
    NativeUnifiedADData c;
    int d;
    int e;
    int f;
    boolean h;
    View j;
    MediaView k;
    NativeAdContainer m;
    int g = 0;
    private boolean i = false;
    boolean l = false;

    class a implements DownloadConfirmListener {
        a() {
        }

        @Override // com.qq.e.comm.compliance.DownloadConfirmListener
        public void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
            Log.i(GDTATNativeAd.n, "onDownloadConfirm....");
            GDTATNativeAd gDTATNativeAd = GDTATNativeAd.this;
            View view = gDTATNativeAd.j;
            gDTATNativeAd.j = null;
            GDTDownloadFirmInfo gDTDownloadFirmInfo = new GDTDownloadFirmInfo();
            gDTDownloadFirmInfo.appInfoUrl = str;
            gDTDownloadFirmInfo.scenes = i;
            gDTDownloadFirmInfo.confirmCallBack = downloadConfirmCallBack;
            GDTATNativeAd.this.notifyDownloadConfirm(activity, view, gDTDownloadFirmInfo);
        }
    }

    class b extends NativeADEventListenerWithClickInfo {
        final /* synthetic */ NativeUnifiedADData a;

        b(NativeUnifiedADData nativeUnifiedADData) {
            this.a = nativeUnifiedADData;
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListenerWithClickInfo
        public void onADClicked(View view) {
            GDTATNativeAd.this.j = view;
            Log.i(GDTATNativeAd.n, "onADClicked...." + view);
            GDTATNativeAd.this.notifyAdClicked();
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADError(AdError adError) {
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADExposed() {
            GDTATInitManager.getInstance().a(GDTATNativeAd.this.getShowId(), new WeakReference(this.a));
            GDTATNativeAd.this.notifyAdImpression();
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADStatusChanged() {
            NativeUnifiedADData nativeUnifiedADData;
            String str;
            long j;
            long downloadProgress;
            if (((CustomNativeAd) GDTATNativeAd.this).mDownloadListener == null || (nativeUnifiedADData = GDTATNativeAd.this.c) == null) {
                return;
            }
            int appStatus = nativeUnifiedADData.getAppStatus();
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
                ((CustomAdapterDownloadListener) ((CustomNativeAd) GDTATNativeAd.this).mDownloadListener).onInstalled("", str);
                return;
            }
            if (appStatus == 4) {
                if (GDTATNativeAd.this.i) {
                    ((CustomAdapterDownloadListener) ((CustomNativeAd) GDTATNativeAd.this).mDownloadListener).onDownloadUpdate(j, downloadProgress, "", str);
                    return;
                } else {
                    ((CustomAdapterDownloadListener) ((CustomNativeAd) GDTATNativeAd.this).mDownloadListener).onDownloadStart(j, downloadProgress, "", str);
                    GDTATNativeAd.this.i = true;
                    return;
                }
            }
            if (appStatus == 8) {
                ((CustomAdapterDownloadListener) ((CustomNativeAd) GDTATNativeAd.this).mDownloadListener).onDownloadFinish(j, "", str);
                GDTATNativeAd.this.i = false;
            } else if (appStatus == 16) {
                ((CustomAdapterDownloadListener) ((CustomNativeAd) GDTATNativeAd.this).mDownloadListener).onDownloadFail(j, downloadProgress, "", str);
                GDTATNativeAd.this.i = false;
            } else if (appStatus == 32 && GDTATNativeAd.this.i) {
                ((CustomAdapterDownloadListener) ((CustomNativeAd) GDTATNativeAd.this).mDownloadListener).onDownloadPause(j, downloadProgress, "", str);
                GDTATNativeAd.this.i = false;
            }
        }
    }

    class c implements NativeADMediaListener {
        c() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoClicked() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoCompleted() {
            GDTATNativeAd.this.notifyAdVideoEnd();
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoError(AdError adError) {
            GDTATNativeAd.this.notifyAdVideoVideoPlayFail("" + adError.getErrorCode(), adError.getErrorMsg());
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoInit() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoLoaded(int i) {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoLoading() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoPause() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoReady() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoResume() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoStart() {
            GDTATNativeAd.this.notifyAdVideoStart();
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoStop() {
        }
    }

    protected GDTATNativeAd(Context context, NativeUnifiedADData nativeUnifiedADData, int i, int i2, int i3, boolean z) {
        this.h = false;
        this.b = context.getApplicationContext();
        this.a = new WeakReference<>(context);
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.c = nativeUnifiedADData;
        a(nativeUnifiedADData);
        this.h = z;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void clear(View view) {
        a(view);
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
        this.k = null;
        this.b = null;
        WeakReference<Context> weakReference = this.a;
        if (weakReference != null) {
            weakReference.clear();
            this.a = null;
        }
        NativeAdContainer nativeAdContainer = this.m;
        if (nativeAdContainer != null) {
            nativeAdContainer.removeAllViews();
            this.m = null;
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdMediaView(Object... objArr) {
        NativeUnifiedADData nativeUnifiedADData = this.c;
        if (nativeUnifiedADData == null) {
            return super.getAdMediaView(objArr);
        }
        if (nativeUnifiedADData.getAdPatternType() != 2) {
            return super.getAdMediaView(objArr);
        }
        if (this.k == null) {
            MediaView mediaView = new MediaView(this.b);
            this.k = mediaView;
            mediaView.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            ViewGroup.LayoutParams layoutParams = this.k.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -2);
            }
            this.k.setLayoutParams(layoutParams);
        }
        return this.k;
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

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public ViewGroup getCustomAdContainer() {
        if (this.c != null) {
            this.m = new NativeAdContainer(this.b);
        }
        return this.m;
    }

    @Override // com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public int getDownloadProgress() {
        NativeUnifiedADData nativeUnifiedADData = this.c;
        if (nativeUnifiedADData != null) {
            return nativeUnifiedADData.getProgress();
        }
        return 0;
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

    @Override // com.anythink.nativead.unitgroup.a
    public Object getObject() {
        return this.c;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public double getVideoProgress() {
        NativeUnifiedADData nativeUnifiedADData = this.c;
        return nativeUnifiedADData != null ? ((double) nativeUnifiedADData.getVideoCurrentPosition()) / 1000.0d : super.getVideoProgress();
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public boolean isNativeExpress() {
        return false;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void onResume() {
        NativeUnifiedADData nativeUnifiedADData = this.c;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.resume();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void pauseVideo() {
        NativeUnifiedADData nativeUnifiedADData = this.c;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.pauseVideo();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        boolean zIsPlayMute;
        List<View> creativeClickViewList;
        if (this.c == null || this.m == null) {
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
        this.c.bindAdToView(view.getContext(), this.m, choiceViewLayoutParams, list, arrayList);
        try {
            if (this.k == null) {
                return;
            }
            int i = this.g;
            if (i > 0) {
                zIsPlayMute = i == 1;
            } else {
                zIsPlayMute = GDTATInitManager.getInstance().isPlayMute(this.d);
            }
            VideoOption.Builder autoPlayPolicy = new VideoOption.Builder().setAutoPlayMuted(zIsPlayMute).setDetailPageMuted(zIsPlayMute).setAutoPlayPolicy(this.e);
            if (this.h) {
                autoPlayPolicy.setEnableUserControl(true);
            }
            this.c.bindMediaView(this.k, autoPlayPolicy.build(), new c());
            this.c.setVideoMute(zIsPlayMute);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd
    public void registerDownloadConfirmListener() {
        this.c.setDownloadConfirmListener(new a());
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void resumeVideo() {
        NativeUnifiedADData nativeUnifiedADData = this.c;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.resumeVideo();
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
        nativeUnifiedADData.setNativeAdEventListener(new b(nativeUnifiedADData));
        setNetworkInfoMap(GDTATInitManager.getInstance().a(nativeUnifiedADData.getExtraInfo(), (Map<String, Object>) null));
    }

    private void a(View view, List<View> list) {
        if ((view instanceof ViewGroup) && view != this.k) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(viewGroup.getChildAt(i), list);
            }
            return;
        }
        list.add(view);
    }

    private void a(View view) {
        if (view == null) {
            return;
        }
        if ((view instanceof ViewGroup) && view != this.k) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(viewGroup.getChildAt(i));
            }
            return;
        }
        view.setOnClickListener(null);
        view.setClickable(false);
    }
}
