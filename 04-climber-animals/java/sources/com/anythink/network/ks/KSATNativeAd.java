package com.anythink.network.ks;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.anythink.core.api.ATCompViewListener;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATShakeViewListener;
import com.anythink.dlopt.api.CustomAdapterDownloadListener;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class KSATNativeAd extends CustomNativeAd {
    private static final String k = "KSATNativeAd";
    Context a;
    KsNativeAd b;
    View c;
    long d;
    FrameLayout e;
    boolean f;
    int h;
    int i;
    int g = 0;
    long j = 0;

    public KSATNativeAd(Context context, KsNativeAd ksNativeAd, boolean z, Map<String, Object> map) {
        this.d = 0L;
        this.h = 0;
        this.a = context.getApplicationContext();
        this.b = ksNativeAd;
        this.f = z;
        try {
            if (ATInitMediation.getIntFromMap(map, KSATConst.NATIVE_AD_SOURCE_LOGO_TYPE, 0) == 1) {
                this.h = 1;
            }
        } catch (Throwable unused) {
        }
        int intFromMap = ATInitMediation.getIntFromMap(map, KSATConst.NATIVE_CONVERT_TYPE_KEY, 2);
        this.i = intFromMap;
        Object[] objArr = new Object[1];
        Integer.valueOf(intFromMap);
        if (this.b.getInteractionType() == 1) {
            setTitle(this.b.getAppName());
        } else {
            setTitle(this.b.getProductName());
        }
        setIconImageUrl(this.b.getAppIconUrl());
        setAdFrom(this.b.getAdSource());
        setStarRating(Double.valueOf(this.b.getAppScore()));
        setDescriptionText(this.b.getAdDescription());
        setAdChoiceIconUrl(this.b.getAdSourceLogoUrl(this.h));
        setNativeInteractionType(this.b.getInteractionType() == 2 ? 2 : this.b.getInteractionType() == 1 ? 1 : 0);
        ArrayList arrayList = new ArrayList();
        List<KsImage> imageList = this.b.getImageList();
        if (imageList != null && imageList.size() > 0) {
            for (int i = 0; i < imageList.size(); i++) {
                KsImage ksImage = imageList.get(i);
                if (ksImage != null) {
                    arrayList.add(ksImage.getImageUrl());
                    if (i == 0) {
                        setMainImageUrl(ksImage.getImageUrl());
                        setMainImageWidth(ksImage.getWidth());
                        setMainImageHeight(ksImage.getHeight());
                    }
                }
            }
        }
        setImageUrlList(arrayList);
        setCallToActionText(this.b.getActionDescription());
        setVideoDuration(this.b.getVideoDuration());
        setVideoUrl(this.b.getVideoUrl());
        setVideoWidth(this.b.getVideoWidth());
        setVideoHeight(this.b.getVideoHeight());
        this.d = this.b.getAppPackageSize();
        if (this.b.getInteractionType() == 1) {
            setAdAppInfo(new KSATDownloadAppInfo(this.b));
        }
        if (this.b.getMaterialType() == 1) {
            this.mAdSourceType = "1";
        } else if (this.b.getMaterialType() == 8) {
            this.mAdSourceType = "3";
        } else if (this.b.getMaterialType() == 3 || this.b.getMaterialType() == 2 || this.b.getMaterialType() == 5) {
            this.mAdSourceType = "2";
        }
        this.e = new FrameLayout(context.getApplicationContext());
    }

    private void a() {
        if (this.b.getInteractionType() == 1) {
            setTitle(this.b.getAppName());
        } else {
            setTitle(this.b.getProductName());
        }
        setIconImageUrl(this.b.getAppIconUrl());
        setAdFrom(this.b.getAdSource());
        setStarRating(Double.valueOf(this.b.getAppScore()));
        setDescriptionText(this.b.getAdDescription());
        setAdChoiceIconUrl(this.b.getAdSourceLogoUrl(this.h));
        int i = this.b.getInteractionType() == 1 ? 1 : 0;
        if (this.b.getInteractionType() == 2) {
            i = 2;
        }
        setNativeInteractionType(i);
        ArrayList arrayList = new ArrayList();
        List<KsImage> imageList = this.b.getImageList();
        if (imageList != null && imageList.size() > 0) {
            for (int i2 = 0; i2 < imageList.size(); i2++) {
                KsImage ksImage = imageList.get(i2);
                if (ksImage != null) {
                    arrayList.add(ksImage.getImageUrl());
                    if (i2 == 0) {
                        setMainImageUrl(ksImage.getImageUrl());
                        setMainImageWidth(ksImage.getWidth());
                        setMainImageHeight(ksImage.getHeight());
                    }
                }
            }
        }
        setImageUrlList(arrayList);
        setCallToActionText(this.b.getActionDescription());
        setVideoDuration(this.b.getVideoDuration());
        setVideoUrl(this.b.getVideoUrl());
        setVideoWidth(this.b.getVideoWidth());
        setVideoHeight(this.b.getVideoHeight());
        this.d = this.b.getAppPackageSize();
        if (this.b.getInteractionType() == 1) {
            setAdAppInfo(new KSATDownloadAppInfo(this.b));
        }
        if (this.b.getMaterialType() == 1) {
            this.mAdSourceType = "1";
            return;
        }
        if (this.b.getMaterialType() == 8) {
            this.mAdSourceType = "3";
        } else if (this.b.getMaterialType() == 3 || this.b.getMaterialType() == 2 || this.b.getMaterialType() == 5) {
            this.mAdSourceType = "2";
        }
    }

    private void a(List<View> list, View view) {
        if ((view instanceof ViewGroup) && view != this.c) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(list, viewGroup.getChildAt(i));
            }
            return;
        }
        if (view != this.c) {
            list.add(view);
        }
    }

    @Override // com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getShakeView(int i, int i2, ATShakeViewListener aTShakeViewListener) {
        try {
            KsNativeAd ksNativeAd = this.b;
            if (ksNativeAd != null && ksNativeAd.enableRotate()) {
                return this.b.getRotateView(this.a);
            }
            if (this.b == null) {
                return null;
            }
            Log.i(k, "Does not support shake function.");
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        List<View> clickViewList = aTNativePrepareInfo.getClickViewList();
        if (clickViewList == null || clickViewList.isEmpty()) {
            clickViewList = new ArrayList<>();
            a(clickViewList, view);
        }
        a((ViewGroup) view, clickViewList);
    }

    private void a(ViewGroup viewGroup, List<View> list) {
        KsNativeAd.AdInteractionListener adInteractionListener = new KsNativeAd.AdInteractionListener() { // from class: com.anythink.network.ks.KSATNativeAd.1
            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public final boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                return false;
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public final void onDownloadTipsDialogDismiss() {
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public final void onDownloadTipsDialogShow() {
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public final void onAdClicked(View view, KsNativeAd ksNativeAd) {
                Log.i("anythink", "KuaiShou onAdClicked");
                KSATNativeAd.this.notifyAdClicked();
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public final void onAdShow(KsNativeAd ksNativeAd) {
                KSATInitManager.getInstance().a(KSATNativeAd.this.getShowId(), new WeakReference(ksNativeAd));
                KSATNativeAd.this.notifyAdImpression();
            }
        };
        HashMap map = new HashMap();
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                map.put(list.get(i), Integer.valueOf(this.i));
            }
        }
        this.b.setDownloadListener(new KsAppDownloadListener() { // from class: com.anythink.network.ks.KSATNativeAd.2
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadStarted() {
                if (KSATNativeAd.this.mDownloadListener == null || !(KSATNativeAd.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                ((CustomAdapterDownloadListener) KSATNativeAd.this.mDownloadListener).onDownloadStart(KSATNativeAd.this.d, 0L, "", KSATNativeAd.this.getTitle());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i2) {
                if (KSATNativeAd.this.mDownloadListener == null || !(KSATNativeAd.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                KSATNativeAd kSATNativeAd = KSATNativeAd.this;
                kSATNativeAd.j = (kSATNativeAd.d * ((long) i2)) / 100;
                ((CustomAdapterDownloadListener) KSATNativeAd.this.mDownloadListener).onDownloadUpdate(KSATNativeAd.this.d, KSATNativeAd.this.j, "", KSATNativeAd.this.getTitle());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                if (KSATNativeAd.this.mDownloadListener == null || !(KSATNativeAd.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                ((CustomAdapterDownloadListener) KSATNativeAd.this.mDownloadListener).onDownloadFinish(KSATNativeAd.this.d, "", KSATNativeAd.this.getTitle());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                if (KSATNativeAd.this.mDownloadListener == null || !(KSATNativeAd.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                ((CustomAdapterDownloadListener) KSATNativeAd.this.mDownloadListener).onDownloadFail(KSATNativeAd.this.d, KSATNativeAd.this.j, "", KSATNativeAd.this.getTitle());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                if (KSATNativeAd.this.mDownloadListener == null || !(KSATNativeAd.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                ((CustomAdapterDownloadListener) KSATNativeAd.this.mDownloadListener).onInstalled("", KSATNativeAd.this.getTitle());
            }
        });
        this.b.setVideoPlayListener(new KsNativeAd.VideoPlayListener() { // from class: com.anythink.network.ks.KSATNativeAd.3
            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public final void onVideoPlayPause() {
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public final void onVideoPlayReady() {
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public final void onVideoPlayResume() {
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public final void onVideoPlayStart() {
                KSATNativeAd.this.notifyAdVideoStart();
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public final void onVideoPlayComplete() {
                KSATNativeAd.this.notifyAdVideoEnd();
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public final void onVideoPlayError(int i2, int i3) {
                Log.i("anythink", "KuaiShou Video play error:" + i2 + " " + i3);
                KSATNativeAd.this.notifyAdVideoVideoPlayFail(String.valueOf(i2), String.valueOf(i3));
            }
        });
        if (b()) {
            KsAdVideoPlayConfig.Builder builder = new KsAdVideoPlayConfig.Builder();
            builder.videoSoundEnable(this.f);
            int i2 = this.g;
            if (i2 > 0) {
                builder.videoSoundEnable(i2 != 1);
            }
            View videoView = this.b.getVideoView(viewGroup.getContext(), builder.build());
            this.c = videoView;
            if (videoView != null) {
                map.put(videoView, Integer.valueOf(this.i));
            }
        }
        if (viewGroup.getContext() instanceof Activity) {
            this.b.registerViewForInteraction((Activity) viewGroup.getContext(), viewGroup, map, adInteractionListener);
        } else {
            this.b.registerViewForInteraction(viewGroup, list, adInteractionListener);
        }
        View view = this.c;
        if (view == null || this.e == null || view.getParent() != null) {
            return;
        }
        this.e.addView(this.c);
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdMediaView(Object... objArr) {
        if (b()) {
            return this.e;
        }
        return null;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void setVideoMute(boolean z) {
        super.setVideoMute(z);
        this.g = z ? 1 : 2;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void clear(View view) {
        a(view);
    }

    private void a(View view) {
        if (view == null) {
            return;
        }
        if ((view instanceof ViewGroup) && view != this.c) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(viewGroup.getChildAt(i));
            }
            return;
        }
        view.setOnClickListener(null);
        view.setClickable(false);
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        KsNativeAd ksNativeAd = this.b;
        if (ksNativeAd != null) {
            ksNativeAd.setDownloadListener(null);
            try {
                this.b.registerViewForInteraction(null, null, null);
            } catch (Exception unused) {
            }
        }
        this.a = null;
        this.e = null;
    }

    private boolean b() {
        KsNativeAd ksNativeAd = this.b;
        if (ksNativeAd != null) {
            return ksNativeAd.getMaterialType() == 1 || this.b.getMaterialType() == 8;
        }
        return false;
    }

    @Override // com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getRoateView(Map<String, Object> map, ATCompViewListener aTCompViewListener) {
        try {
            KsNativeAd ksNativeAd = this.b;
            if (ksNativeAd == null || this.a == null || !ksNativeAd.enableRotate()) {
                return null;
            }
            return this.b.getRotateView(this.a);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.anythink.nativead.unitgroup.a
    public Object getObject() {
        return this.b;
    }
}
