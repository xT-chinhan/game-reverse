package com.tapsdk.tapad.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.byazt.mg.PluginConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mar.sdk.IAction;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.tapsdk.tapad.AdRequest;
import com.tapsdk.tapad.ComplianceInfo;
import com.tapsdk.tapad.R;
import com.tapsdk.tapad.TapAdNative;
import com.tapsdk.tapad.TapAppDownloadListener;
import com.tapsdk.tapad.TapFeedAd;
import com.tapsdk.tapad.b;
import com.tapsdk.tapad.c;
import com.tapsdk.tapad.constants.ErrorCodeEnum;
import com.tapsdk.tapad.feed.FeedOption;
import com.tapsdk.tapad.feed.VideoOption;
import com.tapsdk.tapad.internal.ionia.IoniaIdentityManager;
import com.tapsdk.tapad.internal.runtime.DirichletRuntime;
import com.tapsdk.tapad.internal.runtime.WasmAdInstance;
import com.tapsdk.tapad.internal.runtime.WasmModule;
import com.tapsdk.tapad.internal.runtime.plugin.AdCallbackListener;
import com.tapsdk.tapad.internal.runtime.plugin.ProviderInteractionViews;
import com.tapsdk.tapad.internal.runtime.plugin.stub.InlineAdSurfaceHost;
import com.tapsdk.tapad.internal.runtime.plugin.stub.WasmAdSurfaceHost;
import com.tapsdk.tapad.model.entities.ImageInfo;
import com.taptap.sdk.compliance.constants.BundleKey;
import com.taptap.sdk.compliance.model.TapLoginModelKt;
import com.umeng.analytics.pro.cc;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class WasmNativeFeedPresenter implements AdCallbackListener {
    private static final int AUTOPLAY_POLICY_ALWAYS = 2;
    private static final int AUTOPLAY_POLICY_WIFI = 1;
    private static final String FN_BIDDING = "ad_native_feed_bidding_instance";
    private static final String FN_EVENT = "ad_native_feed_event_instance";
    private static final String FN_IS_VALID = "ad_native_feed_is_valid_instance";
    private static final String FN_LOAD = "ad_load_instance";
    private static final String FN_PRESENT_MEDIA = "ad_present_native_feed_media_instance";
    private static final String FN_RENDER_MEDIA = "ad_render_native_feed_media";
    private static final String TAG = "WasmNativeFeedPresenter";
    private final Context context;
    private Runnable disposedCallback;
    private boolean loadFinished;
    private TapAdNative.FeedAdListener loadListener;
    private final AdRequest request;
    private final WeakReference<Context> viewContextRef;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final WasmAdnLoadAttempt loadAttempt = new WasmAdnLoadAttempt();
    private final Map<Integer, AdapterFeedAd> items = new LinkedHashMap();
    private final AtomicBoolean disposed = new AtomicBoolean(false);
    private volatile WeakReference<WasmAdInstance> instanceRef = new WeakReference<>(null);

    public final class AdapterFeedAd implements TapFeedAd {
        private final String apkSize;
        private final long apkSizeBytes;
        private final ComplianceInfo compliance;
        private final String description;
        private TapAppDownloadListener downloadListener;
        private boolean fallback;
        private final String iconUrl;
        private final int imageMode;
        private final List<ImageInfo> images;
        private ViewGroup interactionContainer;
        private TapFeedAd.AdInteractionListener interactionListener;
        private final int interactionType;
        private final int itemId;
        private View lastClickView;
        private final Map<String, Object> mediaExtra;
        private FrameLayout mediaRoot;
        private final long price;
        private TapFeedAd.ExpressRenderListener renderListener;
        private final float score;
        private boolean selfVideoController;
        private boolean shown;
        private final int templatePreferredHeightDp;
        private FrameLayout templateRoot;
        private final String title;
        private boolean validShown;
        private TapFeedAd.VideoAdListener videoListener;
        private VideoOption videoOption;
        private VisibilityProbe visibilityProbe;
        private final AtomicBoolean released = new AtomicBoolean(false);
        private final TapFeedAd.AdClickPassiveListener passiveListener = new TapFeedAd.AdClickPassiveListener() { // from class: com.tapsdk.tapad.internal.WasmNativeFeedPresenter.AdapterFeedAd.1
            @Override // com.tapsdk.tapad.TapFeedAd.AdClickPassiveListener
            public void adCreativePassiveClick() {
                AdapterFeedAd.this.m141lambda$bindClicks$3$comtapsdktapadinternalWasmNativeFeedPresenter$AdapterFeedAd(ProviderInteractionViews.ROLE_CREATIVE, null);
            }

            @Override // com.tapsdk.tapad.TapFeedAd.AdClickPassiveListener
            public void adPassiveShow() {
                AdapterFeedAd.this.sendSimpleEvent("passive_show");
            }
        };
        private int mediaToken = -1;
        private int templateToken = -1;

        public AdapterFeedAd(int i, JSONObject jSONObject) {
            this.itemId = i;
            this.iconUrl = jSONObject.optString("icon_url", "");
            this.score = (float) jSONObject.optDouble("score", 0.0d);
            this.title = jSONObject.optString(BundleKey.TITLE, "");
            this.description = jSONObject.optString(BundleKey.DESCRIPTION, "");
            this.apkSize = jSONObject.optString(com.tapsdk.tapad.group.constants.Constants.APK_SIZE_FIELD, "");
            this.apkSizeBytes = jSONObject.optLong("apk_size_bytes", 0L);
            this.interactionType = jSONObject.optInt("interaction_type", 0);
            this.imageMode = jSONObject.optInt("image_mode", 0);
            this.price = jSONObject.optLong(IAction.PurchaseKey.Price, 0L);
            this.templatePreferredHeightDp = Math.max(72, Math.min(600, jSONObject.optInt("template_preferred_height_dp", 162)));
            this.images = WasmNativeFeedPresenter.parseImages(jSONObject.optJSONArray("images"));
            this.compliance = new PublicCompliance(jSONObject.optJSONObject(TapLoginModelKt.COMPLIANCE_SCOPE));
            this.mediaExtra = WasmAdMediaExtraInfo.fromLoadPayload(jSONObject);
        }

        private void activateFallback(FrameLayout frameLayout, boolean z, String str) {
            FrameLayout frameLayoutTakeOverForFallback;
            int i = z ? this.templateToken : this.mediaToken;
            if (i > 0 && (frameLayoutTakeOverForFallback = InlineAdSurfaceHost.takeOverForFallback(i)) != null) {
                frameLayout = frameLayoutTakeOverForFallback;
            }
            if (z) {
                this.templateToken = -1;
            } else {
                this.mediaToken = -1;
            }
            this.fallback = true;
            renderFallback(frameLayout, z);
        }

        private void addFallbackClose(final FrameLayout frameLayout) {
            TextView textView = new TextView(frameLayout.getContext());
            textView.setText("×");
            textView.setTextColor(-1);
            textView.setTextSize(16.0f);
            textView.setGravity(17);
            textView.setBackgroundColor(-1728053248);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tapsdk.tapad.internal.WasmNativeFeedPresenter$AdapterFeedAd$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m140lambda$addFallbackClose$2$comtapsdktapadinternalWasmNativeFeedPresenter$AdapterFeedAd(frameLayout, view);
                }
            });
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(WasmNativeFeedPresenter.dp(frameLayout.getContext(), 28), WasmNativeFeedPresenter.dp(frameLayout.getContext(), 28), 53);
            int iDp = WasmNativeFeedPresenter.dp(frameLayout.getContext(), 8);
            layoutParams.rightMargin = iDp;
            layoutParams.topMargin = iDp;
            frameLayout.addView(textView, layoutParams);
        }

        private void attachPresenter(final FrameLayout frameLayout, final boolean z) {
            refreshVisibilityProbe();
            frameLayout.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.tapsdk.tapad.internal.WasmNativeFeedPresenter.AdapterFeedAd.2
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                    if (AdapterFeedAd.this.fallback) {
                        AdapterFeedAd.this.renderFallback(frameLayout, z);
                    } else {
                        AdapterFeedAd.this.presentSurface(frameLayout, z);
                    }
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                }
            });
        }

        private void bidding(boolean z, Map<String, Object> map) {
            WasmAdInstance wasmAdInstanceInstance;
            if (this.fallback || this.released.get() || (wasmAdInstanceInstance = WasmNativeFeedPresenter.this.instance()) == null) {
                return;
            }
            wasmAdInstanceInstance.module().callInt(WasmNativeFeedPresenter.FN_BIDDING, null, Integer.valueOf(wasmAdInstanceInstance.instanceId()), Integer.valueOf(this.itemId), Integer.valueOf(z ? 1 : 0), (map == null ? new JSONObject() : new JSONObject(map)).toString());
        }

        private void bindClicks(List<View> list, final String str) {
            if (list == null) {
                return;
            }
            for (View view : list) {
                if (view != null) {
                    view.setOnClickListener(new View.OnClickListener() { // from class: com.tapsdk.tapad.internal.WasmNativeFeedPresenter$AdapterFeedAd$$ExternalSyntheticLambda3
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            this.f$0.m141lambda$bindClicks$3$comtapsdktapadinternalWasmNativeFeedPresenter$AdapterFeedAd(str, view2);
                        }
                    });
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isWifiConnected() {
            return WasmNativeFeedPresenter.isWifi(WasmNativeFeedPresenter.this.context);
        }

        private void localShown() {
            FrameLayout frameLayout;
            if (this.shown) {
                return;
            }
            this.shown = true;
            TapFeedAd.AdInteractionListener adInteractionListener = this.interactionListener;
            if (adInteractionListener != null) {
                adInteractionListener.onDistinctAdShow(this);
                this.interactionListener.onAdShow(this);
            }
            TapFeedAd.ExpressRenderListener expressRenderListener = this.renderListener;
            if (expressRenderListener == null || (frameLayout = this.templateRoot) == null) {
                return;
            }
            expressRenderListener.onAdShow(frameLayout);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void localValidShown() {
            FrameLayout frameLayout;
            if (this.validShown || this.released.get()) {
                return;
            }
            this.validShown = true;
            TapFeedAd.AdInteractionListener adInteractionListener = this.interactionListener;
            if (adInteractionListener != null) {
                adInteractionListener.onAdValidView(this);
            }
            TapFeedAd.ExpressRenderListener expressRenderListener = this.renderListener;
            if (expressRenderListener == null || (frameLayout = this.templateRoot) == null) {
                return;
            }
            expressRenderListener.onAdValidShow(frameLayout);
        }

        private void notifyClick(boolean z) {
            TapFeedAd.AdInteractionListener adInteractionListener = this.interactionListener;
            if (adInteractionListener != null) {
                if (z) {
                    adInteractionListener.onAdCreativeClick(this.lastClickView, this);
                } else {
                    adInteractionListener.onAdClicked(this.lastClickView, this);
                }
            }
            TapFeedAd.ExpressRenderListener expressRenderListener = this.renderListener;
            if (expressRenderListener != null) {
                View view = this.lastClickView;
                if (view == null) {
                    view = this.templateRoot;
                }
                expressRenderListener.onAdClicked(view);
            }
        }

        private void notifyDownload(JSONObject jSONObject) {
            TapAppDownloadListener tapAppDownloadListener = this.downloadListener;
            if (tapAppDownloadListener == null) {
            }
            String strOptString = jSONObject.optString("state", "idle");
            strOptString.getClass();
            switch (strOptString) {
                case "completed":
                    tapAppDownloadListener.onDownloadComplete();
                    break;
                case "downloading":
                    tapAppDownloadListener.onDownloadStart();
                    tapAppDownloadListener.onUpdateDownloadProgress(jSONObject.optInt(NotificationCompat.CATEGORY_PROGRESS, 0));
                    break;
                case "paused":
                    tapAppDownloadListener.onDownloadPause();
                    break;
                case "installed":
                    tapAppDownloadListener.onInstalled();
                    break;
                case "error":
                    tapAppDownloadListener.onDownloadError();
                    break;
                default:
                    tapAppDownloadListener.onIdle();
                    break;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public void onCoreCallback(String str, JSONObject jSONObject) {
            byte b;
            FrameLayout frameLayout;
            str.getClass();
            switch (str.hashCode()) {
                case -2036652940:
                    b = !str.equals("onNativeFeedAdShow") ? (byte) -1 : (byte) 0;
                    break;
                case -1697435485:
                    b = !str.equals("onNativeFeedDownloadConfirmRequired") ? (byte) -1 : (byte) 1;
                    break;
                case -1612584312:
                    b = !str.equals("onNativeFeedRenderFail") ? (byte) -1 : (byte) 2;
                    break;
                case -882603518:
                    b = !str.equals("onNativeFeedAdValidShow") ? (byte) -1 : (byte) 3;
                    break;
                case -858645340:
                    b = !str.equals("onNativeFeedVideoPrepared") ? (byte) -1 : (byte) 4;
                    break;
                case -787910869:
                    b = !str.equals("onNativeFeedVideoVolumeOpen") ? (byte) -1 : (byte) 5;
                    break;
                case -153191679:
                    b = !str.equals("onNativeFeedVideoError") ? (byte) -1 : (byte) 6;
                    break;
                case -143536401:
                    b = !str.equals("onNativeFeedVideoPause") ? (byte) -1 : (byte) 7;
                    break;
                case -140219045:
                    b = !str.equals("onNativeFeedVideoStart") ? (byte) -1 : (byte) 8;
                    break;
                case -131416240:
                    b = !str.equals("onNativeFeedAdClicked") ? (byte) -1 : (byte) 9;
                    break;
                case 708565941:
                    b = !str.equals("onNativeFeedDownloadState") ? (byte) -1 : (byte) 10;
                    break;
                case 791627650:
                    b = !str.equals("onNativeFeedAdCreativeClick") ? (byte) -1 : (byte) 11;
                    break;
                case 1273611105:
                    b = !str.equals("onNativeFeedAdClose") ? (byte) -1 : (byte) 12;
                    break;
                case 1333375287:
                    b = !str.equals("onNativeFeedVideoVolumeClose") ? (byte) -1 : cc.k;
                    break;
                default:
                    b = -1;
                    break;
            }
            switch (b) {
                case 0:
                    localShown();
                    break;
                case 1:
                    TapFeedAd.AdInteractionListener adInteractionListener = this.interactionListener;
                    if (adInteractionListener != null) {
                        adInteractionListener.onDownloadWindowConfirm(this);
                    }
                    break;
                case 2:
                    FrameLayout frameLayout2 = this.templateRoot;
                    FrameLayout frameLayout3 = frameLayout2 != null ? frameLayout2 : this.mediaRoot;
                    if (!(frameLayout3 instanceof FrameLayout)) {
                        TapFeedAd.ExpressRenderListener expressRenderListener = this.renderListener;
                        if (expressRenderListener != null) {
                            expressRenderListener.onRenderFail(frameLayout3, this, jSONObject.optInt(PluginConstants.KEY_ERROR_CODE, -1), jSONObject.optString("message", ""));
                        }
                    } else {
                        activateFallback(frameLayout3, frameLayout3 == frameLayout2, "Core render failed");
                    }
                    break;
                case 3:
                    localValidShown();
                    break;
                case 4:
                    TapFeedAd.VideoAdListener videoAdListener = this.videoListener;
                    if (videoAdListener != null) {
                        videoAdListener.onVideoPrepared(this);
                    }
                    break;
                case 5:
                    TapFeedAd.VideoAdListener videoAdListener2 = this.videoListener;
                    if (videoAdListener2 != null) {
                        videoAdListener2.onVideoVolumeOpen(this);
                    }
                    break;
                case 6:
                    TapFeedAd.VideoAdListener videoAdListener3 = this.videoListener;
                    if (videoAdListener3 != null) {
                        videoAdListener3.onVideoError(this, jSONObject.optInt(PluginConstants.KEY_ERROR_CODE, -1), jSONObject.optString("message", ""));
                    }
                    break;
                case 7:
                    TapFeedAd.VideoAdListener videoAdListener4 = this.videoListener;
                    if (videoAdListener4 != null) {
                        videoAdListener4.onVideoPause(this);
                    }
                    break;
                case 8:
                    TapFeedAd.VideoAdListener videoAdListener5 = this.videoListener;
                    if (videoAdListener5 != null) {
                        videoAdListener5.onVideoStart(this);
                    }
                    break;
                case 9:
                    notifyClick(false);
                    break;
                case 10:
                    notifyDownload(jSONObject);
                    break;
                case 11:
                    notifyClick(true);
                    break;
                case 12:
                    TapFeedAd.ExpressRenderListener expressRenderListener2 = this.renderListener;
                    if (expressRenderListener2 != null && (frameLayout = this.templateRoot) != null) {
                        expressRenderListener2.onAdClosed(frameLayout);
                    }
                    dispose();
                    break;
                case 13:
                    TapFeedAd.VideoAdListener videoAdListener6 = this.videoListener;
                    if (videoAdListener6 != null) {
                        videoAdListener6.onVideoVolumeClose(this);
                    }
                    break;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void presentSurface(final FrameLayout frameLayout, final boolean z) {
            if (this.released.get()) {
                return;
            }
            if ((z ? this.templateToken : this.mediaToken) > 0) {
                return;
            }
            WasmAdInstance wasmAdInstanceInstance = WasmNativeFeedPresenter.this.instance();
            if (wasmAdInstanceInstance == null) {
                activateFallback(frameLayout, z, "instance unavailable");
                return;
            }
            int iRegister = InlineAdSurfaceHost.register(frameLayout, AdType.NativeFeedAd);
            if (iRegister <= 0) {
                activateFallback(frameLayout, z, "inline host unavailable");
                return;
            }
            if (z) {
                this.templateToken = iRegister;
            } else {
                this.mediaToken = iRegister;
            }
            if (z) {
                activateFallback(frameLayout, true, "Native Feed has no complete-card template");
            } else {
                wasmAdInstanceInstance.module().callInt(WasmNativeFeedPresenter.FN_PRESENT_MEDIA, new WasmModule.IntCallback() { // from class: com.tapsdk.tapad.internal.WasmNativeFeedPresenter$AdapterFeedAd$$ExternalSyntheticLambda2
                    @Override // com.tapsdk.tapad.internal.runtime.WasmModule.IntCallback
                    public final void onResult(int i) {
                        this.f$0.m143lambda$presentSurface$1$comtapsdktapadinternalWasmNativeFeedPresenter$AdapterFeedAd(frameLayout, z, i);
                    }
                }, Integer.valueOf(wasmAdInstanceInstance.instanceId()), Integer.valueOf(this.itemId), Integer.valueOf(iRegister));
            }
        }

        private void refreshVisibilityProbe() {
            FrameLayout frameLayout = this.mediaRoot;
            if (frameLayout == null) {
                frameLayout = this.templateRoot;
            }
            View viewResolveVisibilityRoot = WasmNativeFeedPresenter.resolveVisibilityRoot(this.interactionContainer, frameLayout);
            VisibilityProbe visibilityProbe = this.visibilityProbe;
            if (visibilityProbe == null || !visibilityProbe.tracks(viewResolveVisibilityRoot)) {
                VisibilityProbe visibilityProbe2 = this.visibilityProbe;
                if (visibilityProbe2 != null) {
                    visibilityProbe2.stop();
                }
                VisibilityProbe visibilityProbe3 = viewResolveVisibilityRoot == null ? null : new VisibilityProbe(this, viewResolveVisibilityRoot);
                this.visibilityProbe = visibilityProbe3;
                if (visibilityProbe3 != null) {
                    visibilityProbe3.start();
                } else {
                    sendVisibility(false, 0, 0, 0, isWifiConnected());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void renderFallback(FrameLayout frameLayout, boolean z) {
            frameLayout.removeAllViews();
            frameLayout.setBackgroundColor(-1);
            ImageView imageView = new ImageView(frameLayout.getContext());
            imageView.setImageResource(R.drawable.tapad_feed_extreme_fallback);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            frameLayout.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
            if (z) {
                addFallbackClose(frameLayout);
            }
            localShown();
            WasmNativeFeedPresenter.this.mainHandler.postDelayed(new Runnable() { // from class: com.tapsdk.tapad.internal.WasmNativeFeedPresenter$AdapterFeedAd$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.localValidShown();
                }
            }, 1000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: sendClickEvent, reason: merged with bridge method [inline-methods] */
        public void m141lambda$bindClicks$3$comtapsdktapadinternalWasmNativeFeedPresenter$AdapterFeedAd(String str, View view) {
            this.lastClickView = view;
            JSONObject jSONObjectEvent = WasmNativeFeedPresenter.event("click");
            WasmNativeFeedPresenter.put(jSONObjectEvent, "role", str);
            sendEvent(jSONObjectEvent);
        }

        private void sendCoreEvent(JSONObject jSONObject) {
            WasmAdInstance wasmAdInstanceInstance;
            if (this.fallback || (wasmAdInstanceInstance = WasmNativeFeedPresenter.this.instance()) == null) {
                return;
            }
            wasmAdInstanceInstance.module().callInt(WasmNativeFeedPresenter.FN_EVENT, null, Integer.valueOf(wasmAdInstanceInstance.instanceId()), Integer.valueOf(this.itemId), jSONObject.toString());
        }

        private void sendEvent(JSONObject jSONObject) {
            if (this.fallback || this.released.get()) {
                return;
            }
            sendCoreEvent(jSONObject);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void sendSimpleEvent(String str) {
            sendEvent(WasmNativeFeedPresenter.event(str));
        }

        private void sendVideoOption() {
            VideoOption videoOption = this.videoOption;
            int i = (videoOption == null || videoOption.autoPlayPolicy != VideoOption.AutoPlayPolicy.WIFI) ? 2 : 1;
            JSONObject jSONObjectEvent = WasmNativeFeedPresenter.event("video_option");
            WasmNativeFeedPresenter.put(jSONObjectEvent, "autoplay_policy", Integer.valueOf(i));
            WasmNativeFeedPresenter.put(jSONObjectEvent, "is_wifi", Boolean.valueOf(WasmNativeFeedPresenter.isWifi(WasmNativeFeedPresenter.this.context)));
            WasmNativeFeedPresenter.put(jSONObjectEvent, "self_video_controller", Boolean.valueOf(this.selfVideoController));
            sendEvent(jSONObjectEvent);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void sendVisibility(boolean z, int i, int i2, int i3, boolean z2) {
            if (this.fallback) {
                if (!z || i <= 0) {
                    return;
                }
                localShown();
                return;
            }
            JSONObject jSONObjectEvent = WasmNativeFeedPresenter.event("visibility");
            WasmNativeFeedPresenter.put(jSONObjectEvent, "attached", Boolean.valueOf(z));
            WasmNativeFeedPresenter.put(jSONObjectEvent, "visible_percent", Integer.valueOf(i));
            WasmNativeFeedPresenter.put(jSONObjectEvent, "width", Integer.valueOf(i2));
            WasmNativeFeedPresenter.put(jSONObjectEvent, "height", Integer.valueOf(i3));
            WasmNativeFeedPresenter.put(jSONObjectEvent, "is_wifi", Boolean.valueOf(z2));
            sendEvent(jSONObjectEvent);
        }

        private void videoControl(String str) {
            JSONObject jSONObjectEvent = WasmNativeFeedPresenter.event("video_control");
            WasmNativeFeedPresenter.put(jSONObjectEvent, "command", str);
            sendEvent(jSONObjectEvent);
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public void cancelDownload() {
            sendSimpleEvent("cancel_download");
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public void closeDownloadFloatingDialog() {
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public void closeVideoVolume() {
            videoControl("mute");
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public void confirmDownload() {
            sendSimpleEvent("confirm_download");
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public void dispose() {
            if (this.released.compareAndSet(false, true)) {
                Runnable runnable = new Runnable() { // from class: com.tapsdk.tapad.internal.WasmNativeFeedPresenter$AdapterFeedAd$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m142lambda$dispose$0$comtapsdktapadinternalWasmNativeFeedPresenter$AdapterFeedAd();
                    }
                };
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    runnable.run();
                } else {
                    WasmNativeFeedPresenter.this.mainHandler.post(runnable);
                }
            }
        }

        public void disposeLocal(boolean z) {
            this.released.set(true);
            VisibilityProbe visibilityProbe = this.visibilityProbe;
            if (visibilityProbe != null) {
                visibilityProbe.stop();
            }
            this.visibilityProbe = null;
            this.interactionContainer = null;
            int i = this.mediaToken;
            if (i > 0) {
                InlineAdSurfaceHost.release(i);
            }
            int i2 = this.templateToken;
            if (i2 > 0) {
                InlineAdSurfaceHost.release(i2);
            }
            this.templateToken = -1;
            this.mediaToken = -1;
            WasmNativeFeedPresenter.detachRoot(this.mediaRoot);
            WasmNativeFeedPresenter.detachRoot(this.templateRoot);
            this.templateRoot = null;
            this.mediaRoot = null;
            this.interactionListener = null;
            this.videoListener = null;
            this.renderListener = null;
            this.downloadListener = null;
            if (z) {
                WasmNativeFeedPresenter.this.releaseItem(this);
            }
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public TapFeedAd.AdClickPassiveListener getAdClickPassiveListener() {
            return this.passiveListener;
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public View getAdView() {
            if (this.released.get()) {
                return null;
            }
            if (this.mediaRoot == null) {
                WasmNativeFeedPresenter wasmNativeFeedPresenter = WasmNativeFeedPresenter.this;
                FrameLayout frameLayoutCreateRoot = wasmNativeFeedPresenter.createRoot(false, -1, WasmNativeFeedPresenter.dp(wasmNativeFeedPresenter.context, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM));
                this.mediaRoot = frameLayoutCreateRoot;
                attachPresenter(frameLayoutCreateRoot, false);
            }
            return this.mediaRoot;
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public String getApkSize() {
            return this.apkSize;
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public long getApkSizeBytes() {
            return this.apkSizeBytes;
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public ComplianceInfo getComplianceInfo() {
            return this.compliance;
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public String getDescription() {
            return this.description;
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public String getIconUrl() {
            return this.iconUrl;
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public List<ImageInfo> getImageInfoList() {
            return new ArrayList(this.images);
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public int getImageMode() {
            return this.imageMode;
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public int getInteractionType() {
            return this.interactionType;
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public Map<String, Object> getMediaExtraInfo() {
            return new HashMap(this.mediaExtra);
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public long getPrice() {
            if (this.fallback) {
                return 0L;
            }
            return this.price;
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public float getScore() {
            return this.score;
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public String getTitle() {
            return this.title;
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public boolean isValid() {
            if (this.released.get()) {
                return false;
            }
            if (this.fallback) {
                return true;
            }
            WasmAdInstance wasmAdInstanceInstance = WasmNativeFeedPresenter.this.instance();
            if (wasmAdInstanceInstance == null) {
                return false;
            }
            try {
                return wasmAdInstanceInstance.module().callIntSync(WasmNativeFeedPresenter.FN_IS_VALID, Integer.valueOf(wasmAdInstanceInstance.instanceId()), Integer.valueOf(this.itemId)) == 1;
            } catch (Throwable th) {
                return false;
            }
        }

        /* JADX INFO: renamed from: lambda$addFallbackClose$2$com-tapsdk-tapad-internal-WasmNativeFeedPresenter$AdapterFeedAd, reason: not valid java name */
        /* synthetic */ void m140lambda$addFallbackClose$2$comtapsdktapadinternalWasmNativeFeedPresenter$AdapterFeedAd(FrameLayout frameLayout, View view) {
            TapFeedAd.ExpressRenderListener expressRenderListener = this.renderListener;
            if (expressRenderListener != null) {
                expressRenderListener.onAdClosed(frameLayout);
            }
            dispose();
        }

        /* JADX INFO: renamed from: lambda$dispose$0$com-tapsdk-tapad-internal-WasmNativeFeedPresenter$AdapterFeedAd, reason: not valid java name */
        /* synthetic */ void m142lambda$dispose$0$comtapsdktapadinternalWasmNativeFeedPresenter$AdapterFeedAd() {
            sendCoreEvent(WasmNativeFeedPresenter.event("release"));
            disposeLocal(true);
        }

        /* JADX INFO: renamed from: lambda$presentSurface$1$com-tapsdk-tapad-internal-WasmNativeFeedPresenter$AdapterFeedAd, reason: not valid java name */
        /* synthetic */ void m143lambda$presentSurface$1$comtapsdktapadinternalWasmNativeFeedPresenter$AdapterFeedAd(FrameLayout frameLayout, boolean z, int i) {
            if (i <= 0) {
                activateFallback(frameLayout, z, b.a("attach failed ", i));
            }
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public void openVideoVolume() {
            videoControl("unmute");
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public void registerViewForInteraction(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, List<View> list5, TapFeedAd.AdInteractionListener adInteractionListener) {
            this.interactionListener = adInteractionListener;
            bindClicks(list, "view");
            bindClicks(list2, ProviderInteractionViews.ROLE_CREATIVE);
            bindClicks(list3, BundleKey.DESCRIPTION);
            bindClicks(list4, "privacy");
            bindClicks(list5, "permission");
            this.interactionContainer = viewGroup;
            refreshVisibilityProbe();
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public void render(FeedOption feedOption) {
            render(null, feedOption);
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public void sendLossNotification(Map<String, Object> map) {
            bidding(false, map);
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public void sendWinNotification(Map<String, Object> map) {
            bidding(true, map);
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public void setDownloadListener(TapAppDownloadListener tapAppDownloadListener) {
            this.downloadListener = tapAppDownloadListener;
            if (tapAppDownloadListener != null) {
                tapAppDownloadListener.onIdle();
            }
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public void setExpressRenderListener(TapFeedAd.ExpressRenderListener expressRenderListener) {
            this.renderListener = expressRenderListener;
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public void setIsSelfDoubleWindow(boolean z) {
            JSONObject jSONObjectEvent = WasmNativeFeedPresenter.event("self_double_window");
            WasmNativeFeedPresenter.put(jSONObjectEvent, "enabled", Boolean.valueOf(z));
            sendEvent(jSONObjectEvent);
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public void setVideoAdListener(TapFeedAd.VideoAdListener videoAdListener) {
            this.videoListener = videoAdListener;
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public void setVideoOption(VideoOption videoOption) {
            this.videoOption = videoOption;
            sendVideoOption();
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public void setVideoPlaySelfController(boolean z) {
            this.selfVideoController = z;
            sendVideoOption();
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public void setVolumeVisible(boolean z) {
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public void startVideoPlay() {
            videoControl("play");
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public void stopVideoPlay() {
            videoControl("pause");
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public void render(Activity activity, FeedOption feedOption) {
            TapFeedAd.ExpressRenderListener expressRenderListener = this.renderListener;
            if (expressRenderListener != null) {
                expressRenderListener.onRenderFail(null, this, -53, "Native Feed is app-composed; call getAdView(), or load Express Feed");
            }
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, List<View> list5, TapFeedAd.AdInteractionListener adInteractionListener) {
            registerViewForInteraction(null, viewGroup, list, list2, list3, list4, list5, adInteractionListener);
        }
    }

    public static final class PublicCompliance implements ComplianceInfo {
        private final JSONObject value;

        public PublicCompliance(JSONObject jSONObject) {
            this.value = jSONObject == null ? new JSONObject() : jSONObject;
        }

        @Override // com.tapsdk.tapad.ComplianceInfo
        public String getAdLogIconUrl() {
            return this.value.optString("ad_logo_url", "");
        }

        @Override // com.tapsdk.tapad.ComplianceInfo
        public String getAppName() {
            return this.value.optString(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, "");
        }

        @Override // com.tapsdk.tapad.ComplianceInfo
        public String getAppVersion() {
            return this.value.optString("app_version", "");
        }

        @Override // com.tapsdk.tapad.ComplianceInfo
        public String getDeveloperName() {
            return this.value.optString("developer_name", "");
        }

        @Override // com.tapsdk.tapad.ComplianceInfo
        public String getFunctionDescUrl() {
            return this.value.optString("function_desc_url", "");
        }

        @Override // com.tapsdk.tapad.ComplianceInfo
        public String getPermissionUrl() {
            return this.value.optString(NativeUnifiedADAppInfoImpl.Keys.PERMISSION_URL, "");
        }

        @Override // com.tapsdk.tapad.ComplianceInfo
        public String getPrivacyUrl() {
            return this.value.optString("privacy_url", "");
        }
    }

    public static final class VisibilityProbe implements Runnable {
        private boolean hasWifiFact;
        private final AdapterFeedAd item;
        private boolean lastAttached;
        private boolean lastWifi;
        private final View root;
        private boolean running;
        private int lastPercent = -1;
        private int lastWidth = -1;
        private int lastHeight = -1;

        public VisibilityProbe(AdapterFeedAd adapterFeedAd, View view) {
            this.item = adapterFeedAd;
            this.root = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.running || this.item.released.get()) {
                return;
            }
            Rect rect = new Rect();
            int iMax = Math.max(0, this.root.getWidth());
            int iMax2 = Math.max(0, this.root.getHeight());
            boolean z = this.root.isAttachedToWindow() && this.root.isShown() && this.root.getWindowVisibility() == 0 && this.root.getGlobalVisibleRect(rect) && iMax > 0 && iMax2 > 0;
            long j = ((long) iMax) * ((long) iMax2);
            int iMin = j <= 0 ? 0 : (int) Math.min(100L, ((z ? ((long) Math.max(0, rect.width())) * ((long) Math.max(0, rect.height())) : 0L) * 100) / j);
            boolean zIsWifiConnected = this.item.isWifiConnected();
            if (z != this.lastAttached || iMin != this.lastPercent || iMax != this.lastWidth || iMax2 != this.lastHeight || !this.hasWifiFact || zIsWifiConnected != this.lastWifi) {
                this.lastAttached = z;
                this.lastPercent = iMin;
                this.lastWidth = iMax;
                this.lastHeight = iMax2;
                this.lastWifi = zIsWifiConnected;
                this.hasWifiFact = true;
                this.item.sendVisibility(z, iMin, iMax, iMax2, zIsWifiConnected);
            }
            this.root.postDelayed(this, 250L);
        }

        public void start() {
            if (this.running) {
                return;
            }
            this.running = true;
            this.root.post(this);
        }

        public void stop() {
            this.running = false;
            this.root.removeCallbacks(this);
        }

        public boolean tracks(View view) {
            return this.root == view;
        }
    }

    public WasmNativeFeedPresenter(Context context, AdRequest adRequest) {
        this.context = context.getApplicationContext();
        this.viewContextRef = new WeakReference<>(context);
        this.request = adRequest;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: completeLoad, reason: merged with bridge method [inline-methods] */
    public void m133lambda$completeLoad$3$comtapsdktapadinternalWasmNativeFeedPresenter(final List<TapFeedAd> list) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.WasmNativeFeedPresenter$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m133lambda$completeLoad$3$comtapsdktapadinternalWasmNativeFeedPresenter(list);
                }
            });
            return;
        }
        if (this.disposed.get() || this.loadFinished) {
            return;
        }
        this.loadFinished = true;
        TapAdNative.FeedAdListener feedAdListener = this.loadListener;
        this.loadListener = null;
        if (feedAdListener != null) {
            feedAdListener.onFeedAdLoad(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout createRoot(boolean z, int i, int i2) {
        Context context = this.viewContextRef.get();
        if (context == null) {
            context = this.context;
        }
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setBackgroundColor(z ? -1 : ViewCompat.MEASURED_STATE_MASK);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(i, i2));
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void detachRoot(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return;
        }
        if (frameLayout.getParent() instanceof ViewGroup) {
            ((ViewGroup) frameLayout.getParent()).removeView(frameLayout);
        }
        frameLayout.removeAllViews();
    }

    private void dispatchItemCallback(String str, String str2) {
        try {
            if (str2 == null) {
                str2 = "{}";
            }
            JSONObject jSONObject = new JSONObject(str2);
            AdapterFeedAd adapterFeedAd = this.items.get(Integer.valueOf(jSONObject.optInt("item_id", 0)));
            if (adapterFeedAd != null) {
                adapterFeedAd.onCoreCallback(str, jSONObject);
            }
        } catch (Throwable th) {
        }
    }

    private void disposeCore() {
        WasmAdInstance wasmAdInstance = this.instanceRef.get();
        this.instanceRef = new WeakReference<>(null);
        if (wasmAdInstance != null) {
            wasmAdInstance.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disposeOnMain() {
        Iterator<AdapterFeedAd> it = snapshotItems().iterator();
        while (it.hasNext()) {
            it.next().disposeLocal(false);
        }
        this.items.clear();
        this.loadListener = null;
        disposeCore();
        Runnable runnable = this.disposedCallback;
        this.disposedCallback = null;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int dp(Context context, int i) {
        float f = context.getResources().getDisplayMetrics().density;
        float f2 = i;
        if (f <= 0.0f) {
            f = 1.0f;
        }
        return Math.round(f2 * f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject event(String str) {
        JSONObject jSONObject = new JSONObject();
        put(jSONObject, "type", str);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void failLoad(final Exception exc) {
        WasmAdnLoadAttempt.FailureTiming failureTimingMarkFailed = this.loadAttempt.markFailed();
        if (failureTimingMarkFailed == WasmAdnLoadAttempt.FailureTiming.ALREADY_FAILED) {
            return;
        }
        final boolean z = failureTimingMarkFailed == WasmAdnLoadAttempt.FailureTiming.BEFORE_AD_LOAD;
        this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.WasmNativeFeedPresenter$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m134lambda$failLoad$4$comtapsdktapadinternalWasmNativeFeedPresenter(exc, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: failLoadOnMain, reason: merged with bridge method [inline-methods] */
    public void m134lambda$failLoad$4$comtapsdktapadinternalWasmNativeFeedPresenter(Exception exc, boolean z) {
        if (this.disposed.get() || this.loadFinished) {
            return;
        }
        disposeCore();
        this.loadFinished = true;
        TapAdNative.FeedAdListener feedAdListener = this.loadListener;
        this.loadListener = null;
        if (feedAdListener == null) {
            return;
        }
        if (z) {
            feedAdListener.onFeedAdLoad(fallbackOnly(this.viewContextRef.get() == null ? this.context : this.viewContextRef.get()));
        } else {
            feedAdListener.onError(WasmRewardPresenter.resolvePublicLoadErrorCode(exc, ErrorCodeEnum.INTERNAL_ERROR.getCode()), WasmRewardPresenter.loadErrorMessage(exc));
        }
    }

    public static List<TapFeedAd> fallbackOnly(Context context) {
        WasmNativeFeedPresenter wasmNativeFeedPresenter = new WasmNativeFeedPresenter(context, new AdRequest.Builder().withSpaceId(0L).build());
        AdapterFeedAd adapterFeedAd = wasmNativeFeedPresenter.new AdapterFeedAd(1, fallbackSnapshot(context));
        adapterFeedAd.fallback = true;
        wasmNativeFeedPresenter.items.put(Integer.valueOf(adapterFeedAd.itemId), adapterFeedAd);
        return Collections.singletonList(adapterFeedAd);
    }

    private static JSONObject fallbackSnapshot(Context context) {
        JSONObject jSONObject = new JSONObject();
        put(jSONObject, "item_id", 1);
        put(jSONObject, BundleKey.TITLE, "精彩内容");
        put(jSONObject, BundleKey.DESCRIPTION, "更多内容即将呈现");
        put(jSONObject, "image_mode", 1);
        put(jSONObject, "interaction_type", 0);
        JSONObject jSONObject2 = new JSONObject();
        put(jSONObject2, "image_url", "android.resource://" + context.getPackageName() + "/" + R.drawable.tapad_feed_extreme_fallback);
        put(jSONObject2, "width", Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL));
        put(jSONObject2, "height", Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA));
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject2);
        put(jSONObject, "images", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        put(jSONObject3, "extreme_fallback", Boolean.TRUE);
        put(jSONObject, "media_extra_info", jSONObject3);
        return jSONObject;
    }

    private void handleLoaded(String str) {
        int iOptInt;
        ArrayList arrayList = new ArrayList();
        try {
            if (str == null) {
                str = "{}";
            }
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("items");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null && (iOptInt = jSONObjectOptJSONObject.optInt("item_id", 0)) > 0 && !this.items.containsKey(Integer.valueOf(iOptInt))) {
                        AdapterFeedAd adapterFeedAd = new AdapterFeedAd(iOptInt, jSONObjectOptJSONObject);
                        this.items.put(Integer.valueOf(iOptInt), adapterFeedAd);
                        arrayList.add(adapterFeedAd);
                    }
                }
            }
            IoniaIdentityManager.getInstance().enrichAfterGetAds(jSONObject.optString(com.tapsdk.tapad.constants.Constants.Bidding.REQ_UUID, ""));
            if (arrayList.isEmpty()) {
                failLoad(new IllegalStateException("Core Native Feed returned an empty batch"));
            } else {
                m133lambda$completeLoad$3$comtapsdktapadinternalWasmNativeFeedPresenter(new ArrayList(arrayList));
            }
        } catch (Throwable th) {
            failLoad(new IllegalArgumentException("Invalid Native Feed callback", th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WasmAdInstance instance() {
        WasmAdInstance wasmAdInstance = this.instanceRef.get();
        if (wasmAdInstance == null || wasmAdInstance.isDisposed()) {
            return null;
        }
        return wasmAdInstance;
    }

    private static boolean isSurfaceOwnedInternalWebView(String str) {
        try {
            if (str == null) {
                str = "{}";
            }
            return new JSONObject(str).optInt("surfaceId", -1) > 0;
        } catch (Throwable th) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isWifi(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager == null ? null : connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 1;
        } catch (Throwable th) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<ImageInfo> parseImages(JSONArray jSONArray) {
        if (jSONArray == null) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                arrayList.add(new ImageInfo(jSONObjectOptJSONObject));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void prepare(final DirichletRuntime dirichletRuntime, final WasmModule wasmModule) {
        if (this.disposed.get() || this.loadFinished) {
            return;
        }
        String[] strArr = {FN_LOAD, FN_EVENT, FN_BIDDING, FN_IS_VALID, FN_PRESENT_MEDIA, FN_RENDER_MEDIA};
        for (int i = 0; i < 6; i++) {
            String str = strArr[i];
            if (!wasmModule.hasFunction(str)) {
                failLoad(new IllegalStateException(c.a("Core Native Feed export missing: ", str)));
                return;
            }
        }
        if (dirichletRuntime.runOnRuntimeQueue(new Runnable() { // from class: com.tapsdk.tapad.internal.WasmNativeFeedPresenter$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m137lambda$prepare$1$comtapsdktapadinternalWasmNativeFeedPresenter(dirichletRuntime, wasmModule);
            }
        })) {
            return;
        }
        failLoad(new IllegalStateException("Core runtime queue unavailable"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: prepareOnRuntime, reason: merged with bridge method [inline-methods] */
    public void m137lambda$prepare$1$comtapsdktapadinternalWasmNativeFeedPresenter(DirichletRuntime dirichletRuntime, WasmModule wasmModule) {
        try {
            if (!AdnRuntimeBootstrap.getInstance().ensurePublisherInstalled(this.context, dirichletRuntime, wasmModule)) {
                failLoad(new IllegalStateException("ADN publisher is not initialized"));
                return;
            }
            WeakReference<WasmAdInstance> weakReferenceCreate = WasmAdInstance.create(wasmModule, new DirichletRuntime.NativeCallback() { // from class: com.tapsdk.tapad.internal.WasmNativeFeedPresenter$$ExternalSyntheticLambda4
                @Override // com.tapsdk.tapad.internal.runtime.DirichletRuntime.NativeCallback
                public final void onCallback(String str, String str2) {
                    this.f$0.m136lambda$onCallback$2$comtapsdktapadinternalWasmNativeFeedPresenter(str, str2);
                }
            });
            WasmAdInstance wasmAdInstance = weakReferenceCreate.get();
            if (wasmAdInstance != null && !this.disposed.get()) {
                this.instanceRef = weakReferenceCreate;
                dirichletRuntime.registerAdSurface(wasmAdInstance.instanceId(), wasmModule, this, this);
                JSONObject jSONObjectCreate = WasmAdnLoadRequest.create(this.request);
                if (this.loadAttempt.tryMarkAdLoadDispatched()) {
                    wasmModule.callVoidSync(FN_LOAD, Integer.valueOf(wasmAdInstance.instanceId()), "native_feed", jSONObjectCreate.toString());
                    return;
                }
                return;
            }
            if (wasmAdInstance != null) {
                wasmAdInstance.dispose();
            }
            failLoad(new IllegalStateException("Core Native Feed instance creation failed"));
        } catch (Throwable th) {
            failLoad(new RuntimeException("Core Native Feed preparation failed", th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void put(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseItem(AdapterFeedAd adapterFeedAd) {
        if (adapterFeedAd == null) {
            return;
        }
        this.items.remove(Integer.valueOf(adapterFeedAd.itemId));
        if (this.items.isEmpty()) {
            dispose();
        }
    }

    public static View resolveVisibilityRoot(ViewGroup viewGroup, View view) {
        return viewGroup != null ? viewGroup : view;
    }

    private List<AdapterFeedAd> snapshotItems() {
        return new ArrayList(this.items.values());
    }

    public void dispose() {
        if (this.disposed.compareAndSet(false, true)) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.WasmNativeFeedPresenter$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.disposeOnMain();
                    }
                });
            } else {
                disposeOnMain();
            }
        }
    }

    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public void m135lambda$load$0$comtapsdktapadinternalWasmNativeFeedPresenter(final TapAdNative.FeedAdListener feedAdListener) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.WasmNativeFeedPresenter$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m135lambda$load$0$comtapsdktapadinternalWasmNativeFeedPresenter(feedAdListener);
                }
            });
            return;
        }
        this.loadListener = feedAdListener;
        final DirichletRuntime dirichletRuntime = DirichletRuntime.getInstance();
        WasmCoreModuleLoader.load(dirichletRuntime, new WasmCoreModuleLoader.Callback() { // from class: com.tapsdk.tapad.internal.WasmNativeFeedPresenter.1
            @Override // com.tapsdk.tapad.internal.WasmCoreModuleLoader.Callback
            public void onError(Exception exc) {
                WasmNativeFeedPresenter.this.failLoad(exc);
            }

            @Override // com.tapsdk.tapad.internal.WasmCoreModuleLoader.Callback
            public void onLoaded(WasmModule wasmModule) {
                WasmNativeFeedPresenter.this.prepare(dirichletRuntime, wasmModule);
            }
        });
    }

    @Override // com.tapsdk.tapad.internal.runtime.plugin.AdCallbackListener
    /* JADX INFO: renamed from: onCallback, reason: merged with bridge method [inline-methods] */
    public void m136lambda$onCallback$2$comtapsdktapadinternalWasmNativeFeedPresenter(final String str, final String str2) {
        if (this.disposed.get()) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.WasmNativeFeedPresenter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m136lambda$onCallback$2$comtapsdktapadinternalWasmNativeFeedPresenter(str, str2);
                }
            });
        }
        str.getClass();
        switch (str) {
            case "onError":
            case "onCoreRuntimeFatal":
                if (!this.loadFinished) {
                    failLoad(WasmRewardPresenter.parseLoadError(str2));
                    break;
                }
                break;
            case "onNativeFeedAdLoaded":
                handleLoaded(str2);
                break;
            case "open_internal_webview":
                if (!isSurfaceOwnedInternalWebView(str2)) {
                    Context context = this.viewContextRef.get();
                    if (context == null) {
                        context = this.context;
                    }
                    WasmAdSurfaceHost.openInternalWebView(context, str2, AdType.NativeFeedAd);
                    break;
                }
                break;
            case "onNativeFeedAdError":
                failLoad(WasmRewardPresenter.parseLoadError(str2));
                break;
            default:
                dispatchItemCallback(str, str2);
                break;
        }
    }

    public void pause() {
        Iterator<AdapterFeedAd> it = snapshotItems().iterator();
        while (it.hasNext()) {
            it.next().sendSimpleEvent("pause");
        }
    }

    public void resume() {
        Iterator<AdapterFeedAd> it = snapshotItems().iterator();
        while (it.hasNext()) {
            it.next().sendSimpleEvent("resume");
        }
    }

    /* JADX INFO: renamed from: setOnDisposed, reason: merged with bridge method [inline-methods] */
    public void m138lambda$setOnDisposed$5$comtapsdktapadinternalWasmNativeFeedPresenter(final Runnable runnable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.WasmNativeFeedPresenter$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m138lambda$setOnDisposed$5$comtapsdktapadinternalWasmNativeFeedPresenter(runnable);
                }
            });
        } else if (!this.disposed.get()) {
            this.disposedCallback = runnable;
        } else if (runnable != null) {
            runnable.run();
        }
    }
}
