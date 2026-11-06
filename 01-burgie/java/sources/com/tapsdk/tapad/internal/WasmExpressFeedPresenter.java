package com.tapsdk.tapad.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
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
import com.tapsdk.tapad.internal.utils.AdnDeviceManager;
import com.tapsdk.tapad.model.entities.ImageInfo;
import com.taptap.sdk.compliance.constants.BundleKey;
import com.taptap.sdk.compliance.model.TapLoginModelKt;
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
public final class WasmExpressFeedPresenter implements AdCallbackListener {
    private static final String FN_BIDDING = "ad_express_feed_bidding_instance";
    private static final String FN_EVENT = "ad_express_feed_event_instance";
    private static final String FN_IS_VALID = "ad_express_feed_is_valid_instance";
    private static final String FN_LOAD = "ad_load_instance";
    private static final String FN_PRESENT = "ad_present_express_feed_template_instance";
    private static final String FN_RENDER = "ad_render_express_feed_template";
    private static final String TAG = "WasmExpressFeedPresenter";
    private final Context context;
    private Runnable disposedCallback;
    private boolean loadFinished;
    private TapAdNative.FeedAdListener loadListener;
    private final AdRequest request;
    private final WeakReference<Context> viewContextRef;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final WasmAdnLoadAttempt loadAttempt = new WasmAdnLoadAttempt();
    private final Map<Integer, ExpressFeedAd> items = new LinkedHashMap();
    private final AtomicBoolean disposed = new AtomicBoolean(false);
    private volatile WeakReference<WasmAdInstance> instanceRef = new WeakReference<>(null);

    public static final class AdaptiveExpressFeedRoot extends FrameLayout {
        private final int preferredHeightPx;
        private final int preferredWidthPx;

        public AdaptiveExpressFeedRoot(Context context, int i, int i2) {
            super(context);
            this.preferredWidthPx = Math.max(1, i);
            this.preferredHeightPx = Math.max(1, i2);
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int i, int i2) {
            int iResolveSizeAndState = FrameLayout.resolveSizeAndState(Math.max(getSuggestedMinimumWidth(), this.preferredWidthPx), i, 0);
            int i3 = iResolveSizeAndState & ViewCompat.MEASURED_SIZE_MASK;
            int iResolveSizeAndState2 = FrameLayout.resolveSizeAndState(Math.max(getSuggestedMinimumHeight(), Math.max(1, (int) Math.round((((double) i3) * ((double) this.preferredHeightPx)) / ((double) this.preferredWidthPx)))), i2, 0);
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(16777215 & iResolveSizeAndState2, 1073741824));
            setMeasuredDimension(iResolveSizeAndState, iResolveSizeAndState2);
        }
    }

    public final class ExpressFeedAd implements TapFeedAd {
        private final String apkSize;
        private final long apkSizeBytes;
        private final ComplianceInfo compliance;
        private final String description;
        private TapAppDownloadListener downloadListener;
        private boolean fallback;
        private final String iconUrl;
        private final int imageMode;
        private final List<ImageInfo> images;
        private TapFeedAd.AdInteractionListener interactionListener;
        private final int interactionType;
        private final int itemId;
        private View lastClickView;
        private final Map<String, Object> mediaExtra;
        private final int preferredHeightDp;
        private final int preferredWidthDp;
        private final long price;
        private TapFeedAd.ExpressRenderListener renderListener;
        private boolean renderSuccessDelivered;
        private FrameLayout root;
        private final float score;
        private boolean shown;
        private final String title;
        private boolean validShown;
        private TapFeedAd.VideoAdListener videoListener;
        private VideoOption videoOption;
        private final AtomicBoolean released = new AtomicBoolean(false);
        private final TapFeedAd.AdClickPassiveListener passiveListener = new TapFeedAd.AdClickPassiveListener() { // from class: com.tapsdk.tapad.internal.WasmExpressFeedPresenter.ExpressFeedAd.1
            @Override // com.tapsdk.tapad.TapFeedAd.AdClickPassiveListener
            public void adCreativePassiveClick() {
                ExpressFeedAd.this.m118lambda$bindClicks$4$comtapsdktapadinternalWasmExpressFeedPresenter$ExpressFeedAd(ProviderInteractionViews.ROLE_CREATIVE, null);
            }

            @Override // com.tapsdk.tapad.TapFeedAd.AdClickPassiveListener
            public void adPassiveShow() {
                ExpressFeedAd.this.sendSimpleEvent("passive_show");
            }
        };
        private int hostToken = -1;

        public ExpressFeedAd(int i, JSONObject jSONObject) {
            this.itemId = i;
            this.iconUrl = jSONObject.optString("icon_url", "");
            this.score = (float) jSONObject.optDouble("score", 0.0d);
            this.images = WasmExpressFeedPresenter.parseImages(jSONObject.optJSONArray("images"));
            this.title = jSONObject.optString(BundleKey.TITLE, "");
            this.description = jSONObject.optString(BundleKey.DESCRIPTION, "");
            this.apkSize = jSONObject.optString(com.tapsdk.tapad.group.constants.Constants.APK_SIZE_FIELD, "");
            this.apkSizeBytes = jSONObject.optLong("apk_size_bytes", 0L);
            this.interactionType = jSONObject.optInt("interaction_type", 0);
            this.imageMode = jSONObject.optInt("image_mode", 0);
            this.compliance = new PublicCompliance(jSONObject.optJSONObject(TapLoginModelKt.COMPLIANCE_SCOPE));
            this.mediaExtra = WasmAdMediaExtraInfo.fromLoadPayload(jSONObject);
            this.price = jSONObject.optLong(IAction.PurchaseKey.Price, 0L);
            int i2 = MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS;
            int iOptInt = jSONObject.optInt("preferred_width_dp", MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS);
            if (iOptInt > 0 && iOptInt <= 2000) {
                i2 = iOptInt;
            }
            this.preferredWidthDp = i2;
            this.preferredHeightDp = Math.max(72, Math.min(600, jSONObject.optInt("preferred_height_dp", 162)));
        }

        private void attachPresenter(final FrameLayout frameLayout) {
            frameLayout.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.tapsdk.tapad.internal.WasmExpressFeedPresenter.ExpressFeedAd.2
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                    if (ExpressFeedAd.this.fallback) {
                        ExpressFeedAd.this.renderFallback(frameLayout);
                    } else {
                        ExpressFeedAd.this.presentSurface(frameLayout);
                    }
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                }
            });
            if (frameLayout.isAttachedToWindow()) {
                if (this.fallback) {
                    renderFallback(frameLayout);
                } else {
                    presentSurface(frameLayout);
                }
            }
        }

        private void bidding(boolean z, Map<String, Object> map) {
            WasmAdInstance wasmAdInstanceInstance = WasmExpressFeedPresenter.this.instance();
            if (this.fallback || this.released.get() || wasmAdInstanceInstance == null) {
                return;
            }
            wasmAdInstanceInstance.module().callInt(WasmExpressFeedPresenter.FN_BIDDING, null, Integer.valueOf(wasmAdInstanceInstance.instanceId()), Integer.valueOf(this.itemId), Integer.valueOf(z ? 1 : 0), (map == null ? new JSONObject() : new JSONObject(map)).toString());
        }

        private void bindClicks(List<View> list, final String str) {
            if (list == null) {
                return;
            }
            for (View view : list) {
                if (view != null) {
                    view.setOnClickListener(new View.OnClickListener() { // from class: com.tapsdk.tapad.internal.WasmExpressFeedPresenter$ExpressFeedAd$$ExternalSyntheticLambda2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            this.f$0.m118lambda$bindClicks$4$comtapsdktapadinternalWasmExpressFeedPresenter$ExpressFeedAd(str, view2);
                        }
                    });
                }
            }
        }

        private void deliverRenderSuccess(FrameLayout frameLayout) {
            if (this.renderSuccessDelivered || this.released.get() || frameLayout == null) {
                return;
            }
            this.renderSuccessDelivered = true;
            TapFeedAd.ExpressRenderListener expressRenderListener = this.renderListener;
            if (expressRenderListener != null) {
                expressRenderListener.onRenderSuccess(frameLayout);
            }
        }

        private void failRender(View view, int i, String str) {
            int i2 = this.hostToken;
            if (i2 > 0) {
                InlineAdSurfaceHost.release(i2);
            }
            this.hostToken = -1;
            TapFeedAd.ExpressRenderListener expressRenderListener = this.renderListener;
            if (expressRenderListener != null) {
                expressRenderListener.onRenderFail(view, this, i, str);
            }
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
            if (expressRenderListener == null || (frameLayout = this.root) == null) {
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
            if (expressRenderListener == null || (frameLayout = this.root) == null) {
                return;
            }
            expressRenderListener.onAdValidShow(frameLayout);
        }

        private void notifyClick() {
            TapFeedAd.AdInteractionListener adInteractionListener = this.interactionListener;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClicked(this.lastClickView, this);
            }
            TapFeedAd.ExpressRenderListener expressRenderListener = this.renderListener;
            if (expressRenderListener != null) {
                View view = this.lastClickView;
                if (view == null) {
                    view = this.root;
                }
                expressRenderListener.onAdClicked(view);
            }
        }

        private void notifyDownload(JSONObject jSONObject) {
            if (this.downloadListener == null) {
            }
            String strOptString = jSONObject.optString("state", "idle");
            strOptString.getClass();
            switch (strOptString) {
                case "completed":
                    this.downloadListener.onDownloadComplete();
                    break;
                case "downloading":
                    this.downloadListener.onDownloadStart();
                    this.downloadListener.onUpdateDownloadProgress(jSONObject.optInt(NotificationCompat.CATEGORY_PROGRESS, 0));
                    break;
                case "paused":
                    this.downloadListener.onDownloadPause();
                    break;
                case "installed":
                    this.downloadListener.onInstalled();
                    break;
                case "error":
                    this.downloadListener.onDownloadError();
                    break;
                default:
                    this.downloadListener.onIdle();
                    break;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onCoreCallback(String str, JSONObject jSONObject) {
            FrameLayout frameLayout;
            str.getClass();
            switch (str) {
                case "onExpressFeedAdClicked":
                    notifyClick();
                    break;
                case "onExpressFeedAdValidShow":
                    localValidShown();
                    break;
                case "onExpressFeedDownloadState":
                    notifyDownload(jSONObject);
                    break;
                case "onExpressFeedRenderFail":
                    failRender(this.root, jSONObject.optInt(PluginConstants.KEY_ERROR_CODE, -1), jSONObject.optString("message", ""));
                    break;
                case "onExpressFeedAdShow":
                    localShown();
                    break;
                case "onExpressFeedRenderSuccess":
                    deliverRenderSuccess(this.root);
                    break;
                case "onExpressFeedAdClose":
                    TapFeedAd.ExpressRenderListener expressRenderListener = this.renderListener;
                    if (expressRenderListener != null && (frameLayout = this.root) != null) {
                        expressRenderListener.onAdClosed(frameLayout);
                    }
                    dispose();
                    break;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void presentSurface(final FrameLayout frameLayout) {
            if (this.released.get() || this.hostToken > 0) {
                return;
            }
            WasmAdInstance wasmAdInstanceInstance = WasmExpressFeedPresenter.this.instance();
            if (wasmAdInstanceInstance == null) {
                failRender(frameLayout, -1, "Express Feed instance unavailable");
                return;
            }
            int iRegister = InlineAdSurfaceHost.register(frameLayout, AdType.ExpressFeedAd);
            if (iRegister <= 0) {
                failRender(frameLayout, -1, "Express Feed inline host unavailable");
            } else {
                this.hostToken = iRegister;
                wasmAdInstanceInstance.module().callInt(WasmExpressFeedPresenter.FN_PRESENT, new WasmModule.IntCallback() { // from class: com.tapsdk.tapad.internal.WasmExpressFeedPresenter$ExpressFeedAd$$ExternalSyntheticLambda0
                    @Override // com.tapsdk.tapad.internal.runtime.WasmModule.IntCallback
                    public final void onResult(int i) {
                        this.f$0.m121lambda$presentSurface$2$comtapsdktapadinternalWasmExpressFeedPresenter$ExpressFeedAd(frameLayout, i);
                    }
                }, Integer.valueOf(wasmAdInstanceInstance.instanceId()), Integer.valueOf(this.itemId), Integer.valueOf(iRegister));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void renderFallback(final FrameLayout frameLayout) {
            if (frameLayout.getChildCount() > 0) {
                return;
            }
            frameLayout.setBackgroundColor(-1);
            ImageView imageView = new ImageView(frameLayout.getContext());
            imageView.setImageResource(R.drawable.tapad_feed_extreme_fallback);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            frameLayout.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
            TextView textView = new TextView(frameLayout.getContext());
            textView.setText("×");
            textView.setTextColor(-1);
            textView.setTextSize(16.0f);
            textView.setGravity(17);
            textView.setBackgroundColor(-1728053248);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tapsdk.tapad.internal.WasmExpressFeedPresenter$ExpressFeedAd$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m122lambda$renderFallback$3$comtapsdktapadinternalWasmExpressFeedPresenter$ExpressFeedAd(frameLayout, view);
                }
            });
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(WasmExpressFeedPresenter.dp(frameLayout.getContext(), 28), WasmExpressFeedPresenter.dp(frameLayout.getContext(), 28), 53);
            int iDp = WasmExpressFeedPresenter.dp(frameLayout.getContext(), 8);
            layoutParams.rightMargin = iDp;
            layoutParams.topMargin = iDp;
            frameLayout.addView(textView, layoutParams);
            TapFeedAd.ExpressRenderListener expressRenderListener = this.renderListener;
            if (expressRenderListener != null) {
                expressRenderListener.onRenderSuccess(frameLayout);
            }
            localShown();
            WasmExpressFeedPresenter.this.mainHandler.postDelayed(new Runnable() { // from class: com.tapsdk.tapad.internal.WasmExpressFeedPresenter$ExpressFeedAd$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.localValidShown();
                }
            }, 1000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: sendClick, reason: merged with bridge method [inline-methods] */
        public void m118lambda$bindClicks$4$comtapsdktapadinternalWasmExpressFeedPresenter$ExpressFeedAd(String str, View view) {
            this.lastClickView = view;
            JSONObject jSONObjectEvent = WasmExpressFeedPresenter.event("click");
            WasmExpressFeedPresenter.put(jSONObjectEvent, "role", str);
            sendEvent(jSONObjectEvent);
        }

        private void sendCoreEvent(JSONObject jSONObject) {
            WasmAdInstance wasmAdInstanceInstance = WasmExpressFeedPresenter.this.instance();
            if (this.fallback || wasmAdInstanceInstance == null) {
                return;
            }
            wasmAdInstanceInstance.module().callInt(WasmExpressFeedPresenter.FN_EVENT, null, Integer.valueOf(wasmAdInstanceInstance.instanceId()), Integer.valueOf(this.itemId), jSONObject.toString());
        }

        private void sendEvent(JSONObject jSONObject) {
            if (this.fallback || this.released.get()) {
                return;
            }
            sendCoreEvent(jSONObject);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void sendSimpleEvent(String str) {
            sendEvent(WasmExpressFeedPresenter.event(str));
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
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public void confirmDownload() {
            sendSimpleEvent("confirm_download");
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public void dispose() {
            if (this.released.compareAndSet(false, true)) {
                Runnable runnable = new Runnable() { // from class: com.tapsdk.tapad.internal.WasmExpressFeedPresenter$ExpressFeedAd$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m119lambda$dispose$0$comtapsdktapadinternalWasmExpressFeedPresenter$ExpressFeedAd();
                    }
                };
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    runnable.run();
                } else {
                    WasmExpressFeedPresenter.this.mainHandler.post(runnable);
                }
            }
        }

        public void disposeLocal(boolean z) {
            this.released.set(true);
            int i = this.hostToken;
            if (i > 0) {
                InlineAdSurfaceHost.release(i);
            }
            this.hostToken = -1;
            WasmExpressFeedPresenter.detachRoot(this.root);
            this.root = null;
            this.interactionListener = null;
            this.videoListener = null;
            this.renderListener = null;
            this.downloadListener = null;
            if (z) {
                WasmExpressFeedPresenter.this.releaseItem(this);
            }
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public TapFeedAd.AdClickPassiveListener getAdClickPassiveListener() {
            return this.passiveListener;
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public View getAdView() {
            if (this.root == null && !this.released.get()) {
                render(new FeedOption.Builder().build());
            }
            return this.root;
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
            WasmAdInstance wasmAdInstanceInstance = WasmExpressFeedPresenter.this.instance();
            if (wasmAdInstanceInstance == null) {
                return false;
            }
            try {
                return wasmAdInstanceInstance.module().callIntSync(WasmExpressFeedPresenter.FN_IS_VALID, Integer.valueOf(wasmAdInstanceInstance.instanceId()), Integer.valueOf(this.itemId)) == 1;
            } catch (Throwable th) {
                return false;
            }
        }

        /* JADX INFO: renamed from: lambda$dispose$0$com-tapsdk-tapad-internal-WasmExpressFeedPresenter$ExpressFeedAd, reason: not valid java name */
        /* synthetic */ void m119lambda$dispose$0$comtapsdktapadinternalWasmExpressFeedPresenter$ExpressFeedAd() {
            sendCoreEvent(WasmExpressFeedPresenter.event("release"));
            disposeLocal(true);
        }

        /* JADX INFO: renamed from: lambda$presentSurface$1$com-tapsdk-tapad-internal-WasmExpressFeedPresenter$ExpressFeedAd, reason: not valid java name */
        /* synthetic */ void m120lambda$presentSurface$1$comtapsdktapadinternalWasmExpressFeedPresenter$ExpressFeedAd(FrameLayout frameLayout, int i) {
            if (this.released.get() || frameLayout != this.root) {
                return;
            }
            if (i <= 0) {
                failRender(frameLayout, i, "Express Feed attach failed");
            } else {
                deliverRenderSuccess(frameLayout);
            }
        }

        /* JADX INFO: renamed from: lambda$presentSurface$2$com-tapsdk-tapad-internal-WasmExpressFeedPresenter$ExpressFeedAd, reason: not valid java name */
        /* synthetic */ void m121lambda$presentSurface$2$comtapsdktapadinternalWasmExpressFeedPresenter$ExpressFeedAd(final FrameLayout frameLayout, final int i) {
            WasmExpressFeedPresenter.this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.WasmExpressFeedPresenter$ExpressFeedAd$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m120lambda$presentSurface$1$comtapsdktapadinternalWasmExpressFeedPresenter$ExpressFeedAd(frameLayout, i);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$renderFallback$3$com-tapsdk-tapad-internal-WasmExpressFeedPresenter$ExpressFeedAd, reason: not valid java name */
        /* synthetic */ void m122lambda$renderFallback$3$comtapsdktapadinternalWasmExpressFeedPresenter$ExpressFeedAd(FrameLayout frameLayout, View view) {
            TapFeedAd.ExpressRenderListener expressRenderListener = this.renderListener;
            if (expressRenderListener != null) {
                expressRenderListener.onAdClosed(frameLayout);
            }
            dispose();
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public void openVideoVolume() {
        }

        public void pauseSurface() {
            int i = this.hostToken;
            if (i > 0) {
                InlineAdSurfaceHost.pause(i);
            }
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public void registerViewForInteraction(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, List<View> list5, TapFeedAd.AdInteractionListener adInteractionListener) {
            this.interactionListener = adInteractionListener;
            bindClicks(list, "cta");
            bindClicks(list2, ProviderInteractionViews.ROLE_CREATIVE);
            bindClicks(list4, "privacy");
            bindClicks(list5, "permission");
            bindClicks(list3, "function");
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public void render(FeedOption feedOption) {
            render(null, feedOption);
        }

        public void resumeSurface() {
            int i = this.hostToken;
            if (i > 0) {
                InlineAdSurfaceHost.resume(i);
            }
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
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public void setVideoAdListener(TapFeedAd.VideoAdListener videoAdListener) {
            this.videoListener = videoAdListener;
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public void setVideoOption(VideoOption videoOption) {
            this.videoOption = videoOption;
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public void setVideoPlaySelfController(boolean z) {
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public void setVolumeVisible(boolean z) {
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public void startVideoPlay() {
            resumeSurface();
        }

        @Override // com.tapsdk.tapad.TapFeedAd
        public void stopVideoPlay() {
            pauseSurface();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tapsdk.tapad.TapFeedAd
        public void render(Activity activity, FeedOption feedOption) {
            if (this.released.get()) {
                return;
            }
            if (feedOption == null) {
                feedOption = new FeedOption.Builder().build();
            }
            VideoOption videoOption = feedOption.videoOption;
            if (videoOption != null) {
                this.videoOption = videoOption;
            }
            if (activity == 0) {
                activity = (Context) WasmExpressFeedPresenter.this.viewContextRef.get();
            }
            if (activity == 0) {
                activity = WasmExpressFeedPresenter.this.context;
            }
            int i = this.hostToken;
            if (i > 0) {
                InlineAdSurfaceHost.release(i);
            }
            WasmExpressFeedPresenter.detachRoot(this.root);
            FrameLayout frameLayoutCreateRoot = WasmExpressFeedPresenter.createRoot(activity, feedOption.expressWidth, feedOption.expressHeight, this.preferredWidthDp, this.preferredHeightDp);
            this.root = frameLayoutCreateRoot;
            this.renderSuccessDelivered = false;
            attachPresenter(frameLayoutCreateRoot);
            if (this.fallback) {
                renderFallback(this.root);
            } else {
                presentSurface(this.root);
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

    public WasmExpressFeedPresenter(Context context, AdRequest adRequest) {
        this.context = context.getApplicationContext();
        this.viewContextRef = new WeakReference<>(context);
        this.request = adRequest;
    }

    private void completeLoad(List<TapFeedAd> list) {
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
    public static FrameLayout createRoot(Context context, int i, int i2, int i3, int i4) {
        FrameLayout adaptiveExpressFeedRoot = i2 == -2 ? new AdaptiveExpressFeedRoot(context, dp(context, i3), dp(context, i4)) : new FrameLayout(context);
        adaptiveExpressFeedRoot.setBackgroundColor(-1);
        adaptiveExpressFeedRoot.setLayoutParams(new FrameLayout.LayoutParams(i, i2));
        return adaptiveExpressFeedRoot;
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
            ExpressFeedAd expressFeedAd = this.items.get(Integer.valueOf(jSONObject.optInt("item_id", 0)));
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (expressFeedAd != null) {
                if (jSONObjectOptJSONObject == null) {
                    jSONObjectOptJSONObject = new JSONObject();
                }
                expressFeedAd.onCoreCallback(str, jSONObjectOptJSONObject);
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
        Iterator<ExpressFeedAd> it = snapshotItems().iterator();
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
        this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.WasmExpressFeedPresenter$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m112lambda$failLoad$3$comtapsdktapadinternalWasmExpressFeedPresenter(exc, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: failLoadOnMain, reason: merged with bridge method [inline-methods] */
    public void m112lambda$failLoad$3$comtapsdktapadinternalWasmExpressFeedPresenter(Exception exc, boolean z) {
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
        if (!z) {
            feedAdListener.onError(WasmRewardPresenter.resolvePublicLoadErrorCode(exc, ErrorCodeEnum.INTERNAL_ERROR.getCode()), WasmRewardPresenter.loadErrorMessage(exc));
            return;
        }
        Context context = this.viewContextRef.get();
        if (context == null) {
            context = this.context;
        }
        feedAdListener.onFeedAdLoad(fallbackOnly(context));
    }

    public static List<TapFeedAd> fallbackOnly(Context context) {
        WasmExpressFeedPresenter wasmExpressFeedPresenter = new WasmExpressFeedPresenter(context, new AdRequest.Builder().withSpaceId(0L).build());
        ExpressFeedAd expressFeedAd = wasmExpressFeedPresenter.new ExpressFeedAd(1, fallbackSnapshot(context));
        expressFeedAd.fallback = true;
        wasmExpressFeedPresenter.items.put(Integer.valueOf(expressFeedAd.itemId), expressFeedAd);
        return Collections.singletonList(expressFeedAd);
    }

    private static JSONObject fallbackSnapshot(Context context) {
        JSONObject jSONObject = new JSONObject();
        put(jSONObject, "item_id", 1);
        put(jSONObject, BundleKey.TITLE, "精彩内容");
        put(jSONObject, BundleKey.DESCRIPTION, "更多内容即将呈现");
        put(jSONObject, "image_mode", 1);
        put(jSONObject, "interaction_type", 0);
        put(jSONObject, "preferred_width_dp", Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS));
        put(jSONObject, "preferred_height_dp", 162);
        JSONObject jSONObject2 = new JSONObject();
        put(jSONObject2, "image_url", "android.resource://" + context.getPackageName() + "/" + R.drawable.tapad_feed_extreme_fallback);
        put(jSONObject2, "width", Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL));
        put(jSONObject2, "height", 162);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject2);
        put(jSONObject, "images", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        put(jSONObject3, "extreme_fallback", Boolean.TRUE);
        put(jSONObject3, "render_owner", "sdk");
        put(jSONObject, "media_extra_info", jSONObject3);
        return jSONObject;
    }

    private void handleAdnDidUpdated(String str) {
        try {
            if (str == null) {
                str = "{}";
            }
            String strOptString = new JSONObject(str).optString("adn_did", "");
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            AdnDeviceManager.getInstance(this.context).saveAdnDid(strOptString);
        } catch (Throwable th) {
        }
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
                        ExpressFeedAd expressFeedAd = new ExpressFeedAd(iOptInt, jSONObjectOptJSONObject);
                        this.items.put(Integer.valueOf(iOptInt), expressFeedAd);
                        arrayList.add(expressFeedAd);
                    }
                }
            }
            IoniaIdentityManager.getInstance().enrichAfterGetAds(jSONObject.optString(com.tapsdk.tapad.constants.Constants.Bidding.REQ_UUID, ""));
            if (arrayList.isEmpty()) {
                failLoad(new IllegalStateException("Core Express Feed returned an empty batch"));
            } else {
                completeLoad(arrayList);
            }
        } catch (Throwable th) {
            failLoad(new IllegalArgumentException("Invalid Express Feed callback", th));
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
        String[] strArr = {FN_LOAD, FN_EVENT, FN_BIDDING, FN_IS_VALID, FN_PRESENT, FN_RENDER};
        for (int i = 0; i < 6; i++) {
            String str = strArr[i];
            if (!wasmModule.hasFunction(str)) {
                failLoad(new IllegalStateException(c.a("Core Express Feed export missing: ", str)));
                return;
            }
        }
        if (dirichletRuntime.runOnRuntimeQueue(new Runnable() { // from class: com.tapsdk.tapad.internal.WasmExpressFeedPresenter$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m115lambda$prepare$1$comtapsdktapadinternalWasmExpressFeedPresenter(dirichletRuntime, wasmModule);
            }
        })) {
            return;
        }
        failLoad(new IllegalStateException("Core runtime queue unavailable"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: prepareOnRuntime, reason: merged with bridge method [inline-methods] */
    public void m115lambda$prepare$1$comtapsdktapadinternalWasmExpressFeedPresenter(DirichletRuntime dirichletRuntime, WasmModule wasmModule) {
        try {
            if (!AdnRuntimeBootstrap.getInstance().ensurePublisherInstalled(this.context, dirichletRuntime, wasmModule)) {
                failLoad(new IllegalStateException("ADN publisher is not initialized"));
                return;
            }
            WeakReference<WasmAdInstance> weakReferenceCreate = WasmAdInstance.create(wasmModule, new DirichletRuntime.NativeCallback() { // from class: com.tapsdk.tapad.internal.WasmExpressFeedPresenter$$ExternalSyntheticLambda3
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
                    wasmModule.callVoidSync(FN_LOAD, Integer.valueOf(wasmAdInstance.instanceId()), "express_feed", jSONObjectCreate.toString());
                    return;
                }
                return;
            }
            if (wasmAdInstance != null) {
                wasmAdInstance.dispose();
            }
            failLoad(new IllegalStateException("Core Express Feed instance creation failed"));
        } catch (Throwable th) {
            failLoad(new RuntimeException("Core Express Feed preparation failed", th));
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
    public void releaseItem(ExpressFeedAd expressFeedAd) {
        this.items.remove(Integer.valueOf(expressFeedAd.itemId));
        if (this.items.isEmpty()) {
            dispose();
        }
    }

    private List<ExpressFeedAd> snapshotItems() {
        return new ArrayList(this.items.values());
    }

    public void dispose() {
        if (this.disposed.compareAndSet(false, true)) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.WasmExpressFeedPresenter$$ExternalSyntheticLambda5
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
    public void m113lambda$load$0$comtapsdktapadinternalWasmExpressFeedPresenter(final TapAdNative.FeedAdListener feedAdListener) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.WasmExpressFeedPresenter$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m113lambda$load$0$comtapsdktapadinternalWasmExpressFeedPresenter(feedAdListener);
                }
            });
            return;
        }
        this.loadListener = feedAdListener;
        final DirichletRuntime dirichletRuntime = DirichletRuntime.getInstance();
        WasmCoreModuleLoader.load(dirichletRuntime, new WasmCoreModuleLoader.Callback() { // from class: com.tapsdk.tapad.internal.WasmExpressFeedPresenter.1
            @Override // com.tapsdk.tapad.internal.WasmCoreModuleLoader.Callback
            public void onError(Exception exc) {
                WasmExpressFeedPresenter.this.failLoad(exc);
            }

            @Override // com.tapsdk.tapad.internal.WasmCoreModuleLoader.Callback
            public void onLoaded(WasmModule wasmModule) {
                WasmExpressFeedPresenter.this.prepare(dirichletRuntime, wasmModule);
            }
        });
    }

    @Override // com.tapsdk.tapad.internal.runtime.plugin.AdCallbackListener
    /* JADX INFO: renamed from: onCallback, reason: merged with bridge method [inline-methods] */
    public void m114lambda$onCallback$2$comtapsdktapadinternalWasmExpressFeedPresenter(final String str, final String str2) {
        if (this.disposed.get()) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.WasmExpressFeedPresenter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m114lambda$onCallback$2$comtapsdktapadinternalWasmExpressFeedPresenter(str, str2);
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
            case "onExpressFeedAdLoaded":
                handleLoaded(str2);
                break;
            case "onAdnDidUpdated":
                handleAdnDidUpdated(str2);
                break;
            case "onExpressFeedAdError":
                failLoad(WasmRewardPresenter.parseLoadError(str2));
                break;
            default:
                dispatchItemCallback(str, str2);
                break;
        }
    }

    public void pause() {
        Iterator<ExpressFeedAd> it = snapshotItems().iterator();
        while (it.hasNext()) {
            it.next().pauseSurface();
        }
    }

    public void resume() {
        Iterator<ExpressFeedAd> it = snapshotItems().iterator();
        while (it.hasNext()) {
            it.next().resumeSurface();
        }
    }

    /* JADX INFO: renamed from: setOnDisposed, reason: merged with bridge method [inline-methods] */
    public void m116lambda$setOnDisposed$4$comtapsdktapadinternalWasmExpressFeedPresenter(final Runnable runnable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.WasmExpressFeedPresenter$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m116lambda$setOnDisposed$4$comtapsdktapadinternalWasmExpressFeedPresenter(runnable);
                }
            });
        } else if (!this.disposed.get()) {
            this.disposedCallback = runnable;
        } else if (runnable != null) {
            runnable.run();
        }
    }
}
