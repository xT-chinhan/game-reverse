package com.anythink.network.ks;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.anythink.china.api.CustomAdapterDownloadListener;
import com.anythink.core.api.ATCompViewListener;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATShakeViewListener;
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
    FrameLayout e;
    boolean f;
    int h;
    int i;
    long d = 0;
    int g = 0;
    long j = 0;

    class a implements KsNativeAd.AdInteractionListener {
        a() {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
            return false;
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onAdClicked(View view, KsNativeAd ksNativeAd) {
            Log.i("anythink", "KuaiShou onAdClicked");
            KSATNativeAd.this.notifyAdClicked();
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onAdShow(KsNativeAd ksNativeAd) {
            KSATInitManager.getInstance().a(KSATNativeAd.this.getShowId(), new WeakReference(ksNativeAd));
            KSATNativeAd.this.notifyAdImpression();
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onDownloadTipsDialogDismiss() {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onDownloadTipsDialogShow() {
        }
    }

    class b implements KsAppDownloadListener {
        b() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFailed() {
            if (((CustomNativeAd) KSATNativeAd.this).mDownloadListener == null || !(((CustomNativeAd) KSATNativeAd.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            CustomAdapterDownloadListener customAdapterDownloadListener = (CustomAdapterDownloadListener) ((CustomNativeAd) KSATNativeAd.this).mDownloadListener;
            KSATNativeAd kSATNativeAd = KSATNativeAd.this;
            customAdapterDownloadListener.onDownloadFail(kSATNativeAd.d, kSATNativeAd.j, "", kSATNativeAd.getTitle());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFinished() {
            if (((CustomNativeAd) KSATNativeAd.this).mDownloadListener == null || !(((CustomNativeAd) KSATNativeAd.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            CustomAdapterDownloadListener customAdapterDownloadListener = (CustomAdapterDownloadListener) ((CustomNativeAd) KSATNativeAd.this).mDownloadListener;
            KSATNativeAd kSATNativeAd = KSATNativeAd.this;
            customAdapterDownloadListener.onDownloadFinish(kSATNativeAd.d, "", kSATNativeAd.getTitle());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadStarted() {
            if (((CustomNativeAd) KSATNativeAd.this).mDownloadListener == null || !(((CustomNativeAd) KSATNativeAd.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            CustomAdapterDownloadListener customAdapterDownloadListener = (CustomAdapterDownloadListener) ((CustomNativeAd) KSATNativeAd.this).mDownloadListener;
            KSATNativeAd kSATNativeAd = KSATNativeAd.this;
            customAdapterDownloadListener.onDownloadStart(kSATNativeAd.d, 0L, "", kSATNativeAd.getTitle());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onIdle() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onInstalled() {
            if (((CustomNativeAd) KSATNativeAd.this).mDownloadListener == null || !(((CustomNativeAd) KSATNativeAd.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) ((CustomNativeAd) KSATNativeAd.this).mDownloadListener).onInstalled("", KSATNativeAd.this.getTitle());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onProgressUpdate(int i) {
            if (((CustomNativeAd) KSATNativeAd.this).mDownloadListener == null || !(((CustomNativeAd) KSATNativeAd.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            KSATNativeAd kSATNativeAd = KSATNativeAd.this;
            kSATNativeAd.j = (kSATNativeAd.d * ((long) i)) / 100;
            CustomAdapterDownloadListener customAdapterDownloadListener = (CustomAdapterDownloadListener) ((CustomNativeAd) kSATNativeAd).mDownloadListener;
            KSATNativeAd kSATNativeAd2 = KSATNativeAd.this;
            customAdapterDownloadListener.onDownloadUpdate(kSATNativeAd2.d, kSATNativeAd2.j, "", kSATNativeAd2.getTitle());
        }
    }

    class c implements KsNativeAd.VideoPlayListener {
        c() {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public void onVideoPlayComplete() {
            KSATNativeAd.this.notifyAdVideoEnd();
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public void onVideoPlayError(int i, int i2) {
            Log.i("anythink", "KuaiShou Video play error:" + i + " " + i2);
            KSATNativeAd.this.notifyAdVideoVideoPlayFail("" + i, "" + i2);
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public void onVideoPlayPause() {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public void onVideoPlayReady() {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public void onVideoPlayResume() {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public void onVideoPlayStart() {
            KSATNativeAd.this.notifyAdVideoStart();
        }
    }

    public KSATNativeAd(Context context, KsNativeAd ksNativeAd, boolean z, Map<String, Object> map) {
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
        this.i = ATInitMediation.getIntFromMap(map, KSATConst.NATIVE_CONVERT_TYPE_KEY, 2);
        b();
        this.e = new FrameLayout(context.getApplicationContext());
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void clear(View view) {
        a(view);
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

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdMediaView(Object... objArr) {
        if (a()) {
            return this.e;
        }
        return null;
    }

    @Override // com.anythink.nativead.unitgroup.a
    public Object getObject() {
        return this.b;
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

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void setVideoMute(boolean z) {
        super.setVideoMute(z);
        this.g = z ? 1 : 2;
    }

    private void a(List<View> list, View view) {
        if (!(view instanceof ViewGroup) || view == this.c) {
            if (view != this.c) {
                list.add(view);
            }
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(list, viewGroup.getChildAt(i));
            }
        }
    }

    private void b() {
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
        setNetworkInfoMap(KSATInitManager.getInstance().a(this.b.getMediaExtraInfo(), (Map<String, Object>) null));
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

    private void a(ViewGroup viewGroup, List<View> list) {
        a aVar = new a();
        HashMap map = new HashMap();
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                map.put(list.get(i), Integer.valueOf(this.i));
            }
        }
        this.b.setDownloadListener(new b());
        this.b.setVideoPlayListener(new c());
        if (a()) {
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
            this.b.registerViewForInteraction((Activity) viewGroup.getContext(), viewGroup, map, aVar);
        } else {
            this.b.registerViewForInteraction(viewGroup, list, aVar);
        }
        View view = this.c;
        if (view == null || this.e == null || view.getParent() != null) {
            return;
        }
        this.e.addView(this.c);
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

    private boolean a() {
        KsNativeAd ksNativeAd = this.b;
        if (ksNativeAd != null) {
            return ksNativeAd.getMaterialType() == 1 || this.b.getMaterialType() == 8;
        }
        return false;
    }
}
