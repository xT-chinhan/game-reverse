package com.tapsdk.tapad.internal.runtime.plugin;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.view.ViewCompat;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Property;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.load.Key;
import com.byazt.eyv.AdBaseConstants;
import com.tapsdk.tapad.R;
import com.tapsdk.tapad.c;
import com.tapsdk.tapad.group.constants.Constants;
import com.tapsdk.tapad.internal.runtime.DirichletRuntime;
import com.tapsdk.tapad.internal.runtime.RustResolvedAsset;
import com.tapsdk.tapad.internal.runtime.ViewRenderer;
import com.tapsdk.tapad.internal.runtime.image.MechanicalImageLoader;
import com.tapsdk.tapad.internal.runtime.plugin.utils.SystemBarUtils;
import com.tapsdk.tapad.internal.runtime.view.CanvasView;
import com.tapsdk.tapad.internal.runtime.view.CanvasViewManager;
import com.tapsdk.tapad.internal.runtime.view.ContainerViewManager;
import com.tapsdk.tapad.internal.runtime.view.DirichletLottieView;
import com.tapsdk.tapad.internal.runtime.view.ImageViewManager;
import com.tapsdk.tapad.internal.runtime.view.LinearContainerViewManager;
import com.tapsdk.tapad.internal.runtime.view.RewardExitGuardNativeSurface;
import com.tapsdk.tapad.internal.runtime.view.TextViewManager;
import com.tapsdk.tapad.internal.runtime.view.VideoContainerViewManager;
import com.tapsdk.tapad.internal.runtime.view.ViewManager;
import com.tapsdk.tapad.internal.runtime.view.ViewManagerRegistry;
import com.tapsdk.tapad.internal.runtime.web.DirichletCreativeView;
import com.tapsdk.tapad.internal.selfrender.RewardCapsuleHost;
import com.tapsdk.tapad.internal.ui.views.playable.GameLifeCircleInterface;
import com.tapsdk.tapad.internal.ui.views.playable.MRAIDWebView;
import com.tapsdk.tapad.internal.utils.AsyncExecutor;
import com.umeng.analytics.pro.cc;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultViewRenderer implements ViewRenderer {
    private static final String EXPRESS_AUGUST_TITLE_ENTER = "express_august_benefit_title_enter_320";
    private static final String EXPRESS_AUGUST_TITLE_TRANSITION = "crossfade_translate_y_2dp_scale_0.98_to_1";
    private static final String IMAGE_TAG = "DirichletImage";
    private static final String INTERSTITIAL_AUGUST_CTA_BREATHE = "interstitial_august_cta_breathe_2400";
    private static final String INTERSTITIAL_AUGUST_REWARD_CLOSE_ENTER = "interstitial_august_reward_close_enter_380";
    private static final String INTERSTITIAL_AUGUST_REWARD_HEADING_ENTER = "interstitial_august_reward_heading_enter_380";
    private static final String REWARD_EXIT_GUARD_NATIVE_CLASS = "com.tapsdk.tapad.internal.selfrender.RewardCapsuleHost$ExitGuardView";
    private static final String REWARD_EXIT_GUARD_NATIVE_ID = "reward_provider_exit_guard_native";
    private static final String SPLASH_AUGUST_HAND_FADE = "splash_august_hand_fade_on_action";
    private static final String SPLASH_AUGUST_HAND_LIFT = "splash_august_hand_lift_2800";
    private static final String SPLASH_AUGUST_LAUNCH_ENTER = "splash_august_launch_enter_1320";
    private static final String SPLASH_AUGUST_RING_BREATHE = "splash_august_ring_breathe_2200";
    private static final String SPLASH_AUGUST_RING_EXPAND = "splash_august_ring_expand_850";
    private static final String SPLASH_AUGUST_SOURCE_EXIT = "splash_august_source_exit_1320";
    private static final String TAG = "ViewRenderer";
    private final CanvasViewManager mCanvasManager;
    private final ContainerViewManager mContainerManager;
    private final Context mContext;
    private final float mDensity;
    private final AtomicInteger mHandleGenerator;
    private final SparseArray<ImageBinding> mImageBindings;
    private final ImageViewManager mImageManager;
    private final int mInstanceId;
    private final LinearContainerViewManager mLinearManager;
    private final TextPaint mMeasurePaint;
    private final SparseArray<MountedNativeView> mMountedNativeViews;
    private final SparseArray<OverlayInfo> mOverlays;
    private final SparseArray<DialogInfo> mPopups;
    private final ProviderActionSlots mProviderActionSlots;
    private final ProviderAttributionSlots mProviderAttributionSlots;
    private final ProviderMediaSlots mProviderMediaSlots;
    private ProviderModalLayerOrder mProviderModalLayerOrder;
    private final ViewGroup mRootView;
    private final Map<String, ObjectAnimator> mRunningAnimators;
    private final DirichletRuntime mRuntime;
    private final int mSurfaceId;
    private final TextViewManager mTextManager;
    private final VideoContainerViewManager mVideoManager;
    private final SparseArray<View> mViewHandles;
    private final Map<String, View> mViewIds;
    private final SparseArray<ViewInfo> mViewInfos;
    private final SparseIntArray mViewTypes;

    public static final class CriticalDampedSpringInterpolator implements Interpolator {
        private static final float OMEGA = 8.0f;
        private final float endValue = raw(1.0f);
        private final float initialVelocity;

        public CriticalDampedSpringInterpolator(float f) {
            this.initialVelocity = f;
        }

        private float raw(float f) {
            return (float) (1.0d - ((((double) ((OMEGA - this.initialVelocity) * f)) + 1.0d) * Math.exp((-8.0f) * f)));
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            if (f <= 0.0f) {
                return 0.0f;
            }
            if (f >= 1.0f) {
                return 1.0f;
            }
            return Math.max(0.0f, Math.min(1.0f, raw(f) / this.endValue));
        }
    }

    public static class DialogInfo {
        final int content;
        final Dialog dialog;
        final int dismissCb;
        boolean programmaticDismiss;

        public DialogInfo(Dialog dialog, int i, int i2) {
            this.dialog = dialog;
            this.content = i;
            this.dismissCb = i2;
        }
    }

    public final class ImageBinding implements View.OnAttachStateChangeListener {
        boolean cleared;
        final int handle;
        int onReadyCallback;
        final MechanicalImageLoader.Options options;
        boolean preload;
        boolean readyDispatched;
        MechanicalImageLoader.Request request;
        final String source;
        final ImageView target;

        public ImageBinding(int i, ImageView imageView, String str, MechanicalImageLoader.Options options, int i2, boolean z) {
            this.handle = i;
            this.target = imageView;
            this.source = str;
            this.options = options;
            this.onReadyCallback = i2;
            this.preload = z;
        }

        public void bind() {
            this.target.addOnAttachStateChangeListener(this);
            startIfEligible();
        }

        public void clear() {
            if (this.cleared) {
                return;
            }
            this.cleared = true;
            this.target.removeOnAttachStateChangeListener(this);
            MechanicalImageLoader.clear(this.target);
            this.request = null;
        }

        /* JADX INFO: renamed from: lambda$startIfEligible$0$com-tapsdk-tapad-internal-runtime-plugin-DefaultViewRenderer$ImageBinding, reason: not valid java name */
        /* synthetic */ void m296lambda$startIfEligible$0$comtapsdktapadinternalruntimepluginDefaultViewRenderer$ImageBinding(MechanicalImageLoader.Request request, Bitmap bitmap, Exception exc) {
            if (DefaultViewRenderer.this.mImageBindings.get(this.handle) != this || this.request != request || this.readyDispatched || bitmap == null || exc != null || this.onReadyCallback < 0) {
                return;
            }
            this.readyDispatched = true;
            DefaultViewRenderer.this.mRuntime.triggerCallback(this.onReadyCallback, "{}");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            startIfEligible();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            suspend();
        }

        public void startIfEligible() {
            if (this.cleared || DefaultViewRenderer.this.mImageBindings.get(this.handle) != this) {
                return;
            }
            Object obj = DefaultViewRenderer.this.mViewHandles.get(this.handle);
            ImageView imageView = this.target;
            if (obj == imageView && this.request == null) {
                if (this.preload || DefaultViewRenderer.this.isEffectivelyVisible(imageView)) {
                    MechanicalImageLoader.BitmapCallback bitmapCallback = new MechanicalImageLoader.BitmapCallback() { // from class: com.tapsdk.tapad.internal.runtime.plugin.DefaultViewRenderer$ImageBinding$$ExternalSyntheticLambda0
                        @Override // com.tapsdk.tapad.internal.runtime.image.MechanicalImageLoader.BitmapCallback
                        public final void onResult(MechanicalImageLoader.Request request, Bitmap bitmap, Exception exc) {
                            this.f$0.m296lambda$startIfEligible$0$comtapsdktapadinternalruntimepluginDefaultViewRenderer$ImageBinding(request, bitmap, exc);
                        }
                    };
                    DefaultViewRenderer.this.traceImageVisibility("visibility_start", this.handle, this.source);
                    if (!this.source.startsWith("asset://")) {
                        this.request = MechanicalImageLoader.load(this.target, this.source, this.options, bitmapCallback);
                        return;
                    }
                    String strSubstring = this.source.substring(8);
                    byte[] bundleAsset = DirichletRuntime.getInstance().readBundleAsset("core", strSubstring);
                    if (bundleAsset == null) {
                        return;
                    }
                    this.request = MechanicalImageLoader.load(this.target, c.a("bundle:core:", strSubstring), bundleAsset, this.options, bitmapCallback);
                }
            }
        }

        public void suspend() {
            if (this.preload || this.request == null) {
                return;
            }
            DefaultViewRenderer.this.traceImageVisibility("visibility_suspend", this.handle, this.source);
            MechanicalImageLoader.clear(this.target);
            this.request = null;
        }
    }

    public static class MountedNativeView {
        boolean containerWasClickable;
        int nativeHandle;
        Runnable onUnmount;
        boolean restoreClickable;
        View view;

        private MountedNativeView() {
        }
    }

    public static class OverlayConfig {
        String presentation = "fullscreen";
        boolean modal = true;
        boolean touchThrough = false;
        boolean outsideCancelable = false;
        boolean backCancelable = false;
        float dimAmount = 0.0f;
        int backgroundBlurRadius = 0;
        int windowBackgroundColor = 0;
        String systemBars = "hide";
        int xDp10 = -1;
        int yDp10 = -1;
        String coordinateSpace = "anchor_local";
        String placement = "above_touch_center";

        private OverlayConfig() {
        }

        public static OverlayConfig parse(String str) {
            OverlayConfig overlayConfig = new OverlayConfig();
            if (TextUtils.isEmpty(str)) {
                return overlayConfig;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                overlayConfig.presentation = jSONObject.optString("presentation", overlayConfig.presentation);
                overlayConfig.modal = jSONObject.optBoolean("modal", overlayConfig.modal);
                overlayConfig.touchThrough = jSONObject.optBoolean("touch_through", jSONObject.optBoolean("touchThrough", overlayConfig.touchThrough));
                overlayConfig.outsideCancelable = jSONObject.optBoolean("outside_cancelable", jSONObject.optBoolean("outsideCancelable", overlayConfig.outsideCancelable));
                overlayConfig.backCancelable = jSONObject.optBoolean("back_cancelable", jSONObject.optBoolean("backCancelable", overlayConfig.backCancelable));
                overlayConfig.dimAmount = (float) jSONObject.optDouble("dim_amount", jSONObject.optDouble("dimAmount", overlayConfig.dimAmount));
                overlayConfig.backgroundBlurRadius = Math.max(0, (int) Math.round(jSONObject.optDouble("background_blur_radius", jSONObject.optDouble("backgroundBlurRadius", overlayConfig.backgroundBlurRadius))));
                overlayConfig.systemBars = jSONObject.optString("system_bars", jSONObject.optString("systemBars", overlayConfig.systemBars));
                String strOptString = jSONObject.optString("window_background_color", jSONObject.optString("windowBackgroundColor", ""));
                if (!TextUtils.isEmpty(strOptString)) {
                    overlayConfig.windowBackgroundColor = Color.parseColor(strOptString);
                }
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("position");
                if (jSONObjectOptJSONObject != null) {
                    jSONObject = jSONObjectOptJSONObject;
                }
                overlayConfig.xDp10 = jSONObject.optInt("x_dp10", jSONObject.optInt("xDp10", overlayConfig.xDp10));
                overlayConfig.yDp10 = jSONObject.optInt("y_dp10", jSONObject.optInt("yDp10", overlayConfig.yDp10));
                overlayConfig.coordinateSpace = jSONObject.optString("coordinate_space", jSONObject.optString("coordinateSpace", overlayConfig.coordinateSpace));
                overlayConfig.placement = jSONObject.optString("placement", overlayConfig.placement);
                return overlayConfig;
            } catch (Throwable th) {
                return overlayConfig;
            }
        }
    }

    public static class OverlayInfo {
        OverlayConfig config;
        Dialog dialog;
        final int dismissCb;
        final int overlayId;
        boolean programmaticDismiss;
        int content = -1;
        int dismissReason = 1;

        public OverlayInfo(int i, OverlayConfig overlayConfig, int i2) {
            this.overlayId = i;
            this.config = overlayConfig;
            this.dismissCb = i2;
        }
    }

    public static final class PlayableWebViewBinding implements GameLifeCircleInterface {
        String htmlUrl;
        boolean muted;
        int onGameEnd;
        int onGameInstalled;
        int onGameReady;
        int onRenderFailed;
        boolean readyDispatched;
        MRAIDWebView webView;

        private PlayableWebViewBinding() {
            this.onGameReady = -1;
            this.onGameEnd = -1;
            this.onGameInstalled = -1;
            this.onRenderFailed = -1;
            this.muted = true;
            this.htmlUrl = null;
            this.webView = null;
            this.readyDispatched = false;
        }

        private void dispatch(int i) {
            if (i >= 0) {
                DirichletRuntime.getInstance().triggerCallback(i, "{}");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dispatchReady() {
            final MRAIDWebView mRAIDWebView = this.webView;
            if (!this.readyDispatched) {
                this.readyDispatched = true;
                dispatch(this.onGameReady);
            }
            if (mRAIDWebView == null) {
                return;
            }
            mRAIDWebView.getGameSoundState(new MRAIDWebView.SoundStateCallback() { // from class: com.tapsdk.tapad.internal.runtime.plugin.DefaultViewRenderer$PlayableWebViewBinding$$ExternalSyntheticLambda4
                @Override // com.tapsdk.tapad.internal.ui.views.playable.MRAIDWebView.SoundStateCallback
                public final void onStateReceived(boolean z) {
                    this.f$0.m297lambda$dispatchReady$3$comtapsdktapadinternalruntimepluginDefaultViewRenderer$PlayableWebViewBinding(mRAIDWebView, z);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: failLocalLoad, reason: merged with bridge method [inline-methods] */
        public void m298lambda$loadHtml$4$comtapsdktapadinternalruntimepluginDefaultViewRenderer$PlayableWebViewBinding(String str) {
            if (TextUtils.equals(this.htmlUrl, str)) {
                dispatch(this.onRenderFailed);
            }
        }

        private void runOnWebViewThread(Runnable runnable) {
            MRAIDWebView mRAIDWebView = this.webView;
            if (mRAIDWebView == null) {
                runnable.run();
            } else {
                mRAIDWebView.post(runnable);
            }
        }

        public void applyMute(MRAIDWebView mRAIDWebView) {
            if (mRAIDWebView == null) {
                return;
            }
            if (this.muted) {
                mRAIDWebView.muteGameSound();
            } else {
                mRAIDWebView.unMuteGameSound();
            }
        }

        /* JADX INFO: renamed from: lambda$dispatchReady$3$com-tapsdk-tapad-internal-runtime-plugin-DefaultViewRenderer$PlayableWebViewBinding, reason: not valid java name */
        /* synthetic */ void m297lambda$dispatchReady$3$comtapsdktapadinternalruntimepluginDefaultViewRenderer$PlayableWebViewBinding(MRAIDWebView mRAIDWebView, boolean z) {
            this.muted = z;
            applyMute(mRAIDWebView);
            if (this.onGameReady >= 0) {
                DirichletRuntime.getInstance().triggerCallbackWithCoords(this.onGameReady, z ? 1 : 0, 2);
            }
        }

        /* JADX INFO: renamed from: lambda$loadHtml$5$com-tapsdk-tapad-internal-runtime-plugin-DefaultViewRenderer$PlayableWebViewBinding, reason: not valid java name */
        /* synthetic */ void m299lambda$loadHtml$5$comtapsdktapadinternalruntimepluginDefaultViewRenderer$PlayableWebViewBinding(String str, String str2) {
            MRAIDWebView mRAIDWebView = this.webView;
            if (mRAIDWebView == null || !TextUtils.equals(this.htmlUrl, str)) {
                return;
            }
            mRAIDWebView.loadDataWithBaseURL(str, str2, "text/html", Key.STRING_CHARSET_NAME, null);
        }

        /* JADX INFO: renamed from: lambda$loadHtml$6$com-tapsdk-tapad-internal-runtime-plugin-DefaultViewRenderer$PlayableWebViewBinding, reason: not valid java name */
        /* synthetic */ void m300lambda$loadHtml$6$comtapsdktapadinternalruntimepluginDefaultViewRenderer$PlayableWebViewBinding(final String str) {
            try {
                final String utf8Bounded = RustResolvedAsset.readUtf8Bounded(str, RustResolvedAsset.MAX_HTML_BYTES);
                AsyncExecutor.runOnMain(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.DefaultViewRenderer$PlayableWebViewBinding$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m299lambda$loadHtml$5$comtapsdktapadinternalruntimepluginDefaultViewRenderer$PlayableWebViewBinding(str, utf8Bounded);
                    }
                });
            } catch (IOException e) {
                AsyncExecutor.runOnMain(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.DefaultViewRenderer$PlayableWebViewBinding$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m298lambda$loadHtml$4$comtapsdktapadinternalruntimepluginDefaultViewRenderer$PlayableWebViewBinding(str);
                    }
                });
            }
        }

        /* JADX INFO: renamed from: lambda$onGameEnd$2$com-tapsdk-tapad-internal-runtime-plugin-DefaultViewRenderer$PlayableWebViewBinding, reason: not valid java name */
        /* synthetic */ void m301lambda$onGameEnd$2$comtapsdktapadinternalruntimepluginDefaultViewRenderer$PlayableWebViewBinding() {
            dispatch(this.onGameEnd);
        }

        /* JADX INFO: renamed from: lambda$onGameInstalled$0$com-tapsdk-tapad-internal-runtime-plugin-DefaultViewRenderer$PlayableWebViewBinding, reason: not valid java name */
        /* synthetic */ void m302lambda$onGameInstalled$0$comtapsdktapadinternalruntimepluginDefaultViewRenderer$PlayableWebViewBinding() {
            dispatch(this.onGameInstalled);
        }

        /* JADX INFO: renamed from: lambda$onRenderFailed$1$com-tapsdk-tapad-internal-runtime-plugin-DefaultViewRenderer$PlayableWebViewBinding, reason: not valid java name */
        /* synthetic */ void m303lambda$onRenderFailed$1$comtapsdktapadinternalruntimepluginDefaultViewRenderer$PlayableWebViewBinding() {
            dispatch(this.onRenderFailed);
        }

        public void loadHtml(final String str) {
            MRAIDWebView mRAIDWebView = this.webView;
            if (mRAIDWebView == null) {
                return;
            }
            if (!RustResolvedAsset.isLocalFileUri(str)) {
                mRAIDWebView.loadUrl(str);
                return;
            }
            try {
                if (AsyncExecutor.tryExecuteIO(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.DefaultViewRenderer$PlayableWebViewBinding$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m300lambda$loadHtml$6$comtapsdktapadinternalruntimepluginDefaultViewRenderer$PlayableWebViewBinding(str);
                    }
                })) {
                    return;
                }
                m298lambda$loadHtml$4$comtapsdktapadinternalruntimepluginDefaultViewRenderer$PlayableWebViewBinding(str);
            } catch (RuntimeException e) {
                m298lambda$loadHtml$4$comtapsdktapadinternalruntimepluginDefaultViewRenderer$PlayableWebViewBinding(str);
            }
        }

        @Override // com.tapsdk.tapad.internal.ui.views.playable.GameLifeCircleInterface
        public void onGameEnd() {
            runOnWebViewThread(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.DefaultViewRenderer$PlayableWebViewBinding$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m301lambda$onGameEnd$2$comtapsdktapadinternalruntimepluginDefaultViewRenderer$PlayableWebViewBinding();
                }
            });
        }

        @Override // com.tapsdk.tapad.internal.ui.views.playable.GameLifeCircleInterface
        public void onGameInstalled() {
            runOnWebViewThread(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.DefaultViewRenderer$PlayableWebViewBinding$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m302lambda$onGameInstalled$0$comtapsdktapadinternalruntimepluginDefaultViewRenderer$PlayableWebViewBinding();
                }
            });
        }

        @Override // com.tapsdk.tapad.internal.ui.views.playable.GameLifeCircleInterface
        public void onGameReady() {
            runOnWebViewThread(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.DefaultViewRenderer$PlayableWebViewBinding$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.dispatchReady();
                }
            });
        }

        @Override // com.tapsdk.tapad.internal.ui.views.playable.GameLifeCircleInterface
        public void onRenderFailed() {
            runOnWebViewThread(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.DefaultViewRenderer$PlayableWebViewBinding$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m303lambda$onRenderFailed$1$comtapsdktapadinternalruntimepluginDefaultViewRenderer$PlayableWebViewBinding();
                }
            });
        }
    }

    public static class ViewInfo {
        int backgroundColor;
        float blurRadius;
        int borderColor;
        float borderWidth;
        boolean clipChildren;
        float cornerRadius;
        float cornerRadiusBottomLeft;
        float cornerRadiusBottomRight;
        float cornerRadiusTopLeft;
        float cornerRadiusTopRight;
        int[] gradientColors;
        int gradientOrientation;
        int imageOnReady;
        boolean inputBarrier;
        boolean modalLayer;
        boolean preloadImage;
        String scaleType;

        private ViewInfo() {
            this.cornerRadius = 0.0f;
            this.cornerRadiusTopLeft = -1.0f;
            this.cornerRadiusTopRight = -1.0f;
            this.cornerRadiusBottomRight = -1.0f;
            this.cornerRadiusBottomLeft = -1.0f;
            this.backgroundColor = 0;
            this.borderColor = 0;
            this.borderWidth = 0.0f;
            this.gradientColors = null;
            this.gradientOrientation = 0;
            this.blurRadius = 0.0f;
            this.imageOnReady = -1;
            this.preloadImage = false;
            this.scaleType = null;
            this.clipChildren = true;
            this.inputBarrier = false;
            this.modalLayer = false;
        }

        public boolean hasIndividualCorners() {
            return this.cornerRadiusTopLeft >= 0.0f || this.cornerRadiusTopRight >= 0.0f || this.cornerRadiusBottomRight >= 0.0f || this.cornerRadiusBottomLeft >= 0.0f;
        }
    }

    public DefaultViewRenderer(Context context, ViewGroup viewGroup) {
        this(context, viewGroup, DirichletRuntime.getInstance(), -1, -1);
    }

    private void activateVisibleImages(View view) {
        for (int i = 0; i < this.mImageBindings.size(); i++) {
            int iKeyAt = this.mImageBindings.keyAt(i);
            View view2 = this.mViewHandles.get(iKeyAt);
            if (view2 != null && isDescendantOrSame(view2, view)) {
                startImageIfEligible(iKeyAt);
            }
        }
    }

    private void appendDebugDumpLine(StringBuilder sb, int i, int i2) {
        View view = this.mViewHandles.get(i);
        if (view == null) {
            return;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append("  ");
        }
        Object tag = view.getTag(R.id.tapad_dirichlet_view_id_tag);
        Object tag2 = view.getTag(R.id.tapad_dirichlet_debug_key_tag);
        Object tag3 = view.getTag(R.id.tapad_dirichlet_named_animation_tag);
        int i4 = this.mViewTypes.get(i, -1);
        ViewInfo viewInfo = this.mViewInfos.get(i);
        StringBuilder sbAppend = sb.append("handle=").append(i).append(" type=").append(i4).append(" id=");
        if (tag == null) {
            tag = "";
        }
        StringBuilder sbAppend2 = sbAppend.append(tag).append(" key=");
        if (tag2 == null) {
            tag2 = "";
        }
        sbAppend2.append(tag2).append(" bounds=").append(pxToDp(view.getLeft())).append(AbstractJsonLexerKt.COMMA).append(pxToDp(view.getTop())).append(AbstractJsonLexerKt.COMMA).append(pxToDp(view.getWidth())).append(AbstractJsonLexerKt.COMMA).append(pxToDp(view.getHeight())).append(" visible=").append(view.getVisibility() == 0).append(" alpha=").append(view.getAlpha());
        if (tag3 != null) {
            sb.append(" animation=").append(tag3);
        }
        if (viewInfo != null) {
            StringBuilder sbAppend3 = sb.append(" bg=#").append(String.format("%08X", Integer.valueOf(viewInfo.backgroundColor))).append(" radius=").append(viewInfo.cornerRadius).append(" scaleType=");
            String str = viewInfo.scaleType;
            sbAppend3.append(str != null ? str : "");
        }
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            sb.append(" textAlign=").append(textView.getGravity()).append(" textSizePx=").append(textView.getTextSize()).append(" text=\"").append(textView.getText()).append("\"");
        }
        sb.append('\n');
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i5 = 0; i5 < viewGroup.getChildCount(); i5++) {
                View childAt = viewGroup.getChildAt(i5);
                int iFindHandleForView = findHandleForView(childAt);
                if (iFindHandleForView >= 0) {
                    appendDebugDumpLine(sb, iFindHandleForView, i2 + 1);
                } else {
                    for (int i6 = 0; i6 <= i2; i6++) {
                        sb.append("  ");
                    }
                    sb.append("nativeChild=").append(childAt.getClass().getSimpleName()).append(" bounds=").append(pxToDp(childAt.getLeft())).append(AbstractJsonLexerKt.COMMA).append(pxToDp(childAt.getTop())).append(AbstractJsonLexerKt.COMMA).append(pxToDp(childAt.getWidth())).append(AbstractJsonLexerKt.COMMA).append(pxToDp(childAt.getHeight())).append('\n');
                }
            }
        }
    }

    private void applyNamedAnimation(View view, String str) {
        if (view == null) {
            return;
        }
        if (EXPRESS_AUGUST_TITLE_ENTER.equals(str) && !areMotionAnimationsEnabled()) {
            applyReducedMotionEndState(view, str);
            return;
        }
        Object tag = view.getTag(R.id.tapad_dirichlet_named_animation_tag);
        if (str == null || !str.equals(tag)) {
            if ("breathing_glow".equals(str)) {
                startBreathingGlowAnimation(view);
                view.setTag(R.id.tapad_dirichlet_named_animation_tag, str);
                return;
            }
            if ("breathing".equals(str)) {
                startBreathingAnimation(view);
                view.setTag(R.id.tapad_dirichlet_named_animation_tag, str);
                return;
            }
            if ("ylh_hand_tap".equals(str)) {
                startYlhHandTapAnimation(view);
                view.setTag(R.id.tapad_dirichlet_named_animation_tag, str);
                return;
            }
            if ("cover_fade_out".equals(str)) {
                view.setTag(R.id.tapad_dirichlet_named_animation_tag, str);
                startCoverFadeOutAnimation(view);
                return;
            }
            if ("banner_wave_bob".equals(str)) {
                startBannerWaveBobAnimation(view);
                view.setTag(R.id.tapad_dirichlet_named_animation_tag, str);
                return;
            }
            if ("banner_train_door_left".equals(str)) {
                startBannerTrainDoorAnimation(view, -1.0f);
                view.setTag(R.id.tapad_dirichlet_named_animation_tag, str);
                return;
            }
            if ("banner_train_door_right".equals(str)) {
                startBannerTrainDoorAnimation(view, 1.0f);
                view.setTag(R.id.tapad_dirichlet_named_animation_tag, str);
                return;
            }
            if ("banner_train_lead_enter".equals(str)) {
                startBannerTrainEnterAnimation(view, true);
                view.setTag(R.id.tapad_dirichlet_named_animation_tag, str);
                return;
            }
            if ("banner_train_body_enter".equals(str)) {
                startBannerTrainEnterAnimation(view, false);
                view.setTag(R.id.tapad_dirichlet_named_animation_tag, str);
                return;
            }
            if ("interstitial_popover_content_enter_600ms".equals(str)) {
                startInterstitialPopoverContentEnter(view);
                view.setTag(R.id.tapad_dirichlet_named_animation_tag, str);
                return;
            }
            if ("interstitial_popover_backdrop_enter_600ms".equals(str)) {
                startInterstitialPopoverBackdropEnter(view);
                view.setTag(R.id.tapad_dirichlet_named_animation_tag, str);
                return;
            }
            if (INTERSTITIAL_AUGUST_CTA_BREATHE.equals(str)) {
                startInterstitialAugustCtaBreathe(view);
                view.setTag(R.id.tapad_dirichlet_named_animation_tag, str);
                return;
            }
            if (INTERSTITIAL_AUGUST_REWARD_HEADING_ENTER.equals(str)) {
                startInterstitialAugustRewardHeadingEnter(view);
                view.setTag(R.id.tapad_dirichlet_named_animation_tag, str);
                return;
            }
            if (INTERSTITIAL_AUGUST_REWARD_CLOSE_ENTER.equals(str)) {
                startInterstitialAugustRewardCloseEnter(view);
                view.setTag(R.id.tapad_dirichlet_named_animation_tag, str);
                return;
            }
            if (SPLASH_AUGUST_SOURCE_EXIT.equals(str)) {
                startSplashAugustSourceExit(view);
                view.setTag(R.id.tapad_dirichlet_named_animation_tag, str);
                return;
            }
            if (SPLASH_AUGUST_RING_BREATHE.equals(str)) {
                startSplashAugustRingBreathe(view);
                view.setTag(R.id.tapad_dirichlet_named_animation_tag, str);
                return;
            }
            if (SPLASH_AUGUST_RING_EXPAND.equals(str)) {
                startSplashAugustRingExpand(view);
                view.setTag(R.id.tapad_dirichlet_named_animation_tag, str);
                return;
            }
            if (SPLASH_AUGUST_HAND_LIFT.equals(str)) {
                startSplashAugustHandLift(view);
                view.setTag(R.id.tapad_dirichlet_named_animation_tag, str);
                return;
            }
            if (SPLASH_AUGUST_HAND_FADE.equals(str)) {
                startSplashAugustHandFade(view);
                view.setTag(R.id.tapad_dirichlet_named_animation_tag, str);
            } else if (SPLASH_AUGUST_LAUNCH_ENTER.equals(str)) {
                startSplashAugustLaunchEnter(view);
                view.setTag(R.id.tapad_dirichlet_named_animation_tag, str);
            } else if (EXPRESS_AUGUST_TITLE_ENTER.equals(str)) {
                startExpressAugustTitleEnter(view);
            } else {
                stopNamedAnimation(view);
            }
        }
    }

    private void applyOverlayWindow(Window window, OverlayConfig overlayConfig, int i, int i2, int i3) {
        applyOverlayWindowBase(window, overlayConfig);
        if ("centered".equals(overlayConfig.presentation)) {
            window.setGravity(17);
            window.setLayout(i2, i3);
            return;
        }
        if (!"anchored".equals(overlayConfig.presentation)) {
            window.setGravity(51);
            window.setLayout(-1, -1);
            return;
        }
        View view = this.mViewHandles.get(i);
        int[] iArr = {0, 0};
        if (view != null) {
            view.getLocationOnScreen(iArr);
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 51;
        attributes.x = iArr[0];
        attributes.y = iArr[1];
        attributes.width = i2;
        attributes.height = i3;
        window.setAttributes(attributes);
    }

    private void applyOverlayWindowBase(Window window, OverlayConfig overlayConfig) {
        configureDialogWindow(window);
        window.setBackgroundDrawable(new ColorDrawable(overlayConfig.windowBackgroundColor));
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = Math.max(0.0f, Math.min(1.0f, overlayConfig.dimAmount));
        window.setAttributes(attributes);
        if (overlayConfig.dimAmount > 0.0f) {
            window.addFlags(2);
        } else {
            window.clearFlags(2);
        }
        if (Build.VERSION.SDK_INT >= 31) {
            window.setBackgroundBlurRadius(overlayConfig.backgroundBlurRadius);
        }
        if (!overlayConfig.modal || overlayConfig.touchThrough) {
            window.addFlags(32);
            if (overlayConfig.touchThrough) {
                window.addFlags(16);
            }
        } else {
            window.clearFlags(48);
        }
        if ("show".equals(overlayConfig.systemBars)) {
            window.getDecorView().setSystemUiVisibility(0);
        }
    }

    private void applyPadding(View view, String str) {
        try {
            String[] strArrSplit = str.split(",");
            if (strArrSplit.length == 4) {
                view.setPadding(dp2px(Float.parseFloat(strArrSplit[0].trim())), dp2px(Float.parseFloat(strArrSplit[1].trim())), dp2px(Float.parseFloat(strArrSplit[2].trim())), dp2px(Float.parseFloat(strArrSplit[3].trim())));
            }
        } catch (NumberFormatException e) {
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:29:0x0052  */
    private void applyPlayableWebViewStyle(final MRAIDWebView mRAIDWebView, String str, String str2) {
        final PlayableWebViewBinding playableWebViewBindingBindingFor = bindingFor(mRAIDWebView);
        str.getClass();
        switch (str) {
            case "playableOnGameEnd":
                playableWebViewBindingBindingFor.onGameEnd = parseCallbackToken(str2);
                break;
            case "playableHtmlUrl":
                if (TextUtils.isEmpty(str2)) {
                    if (!TextUtils.isEmpty(playableWebViewBindingBindingFor.htmlUrl)) {
                        playableWebViewBindingBindingFor.htmlUrl = null;
                        playableWebViewBindingBindingFor.readyDispatched = false;
                        mRAIDWebView.loadUrl("about:blank");
                    }
                    break;
                } else {
                    if (!TextUtils.equals(playableWebViewBindingBindingFor.htmlUrl, str2)) {
                        playableWebViewBindingBindingFor.htmlUrl = str2;
                        playableWebViewBindingBindingFor.readyDispatched = false;
                        playableWebViewBindingBindingFor.loadHtml(str2);
                    }
                    break;
                }
                break;
            case "playableOnGameInstalled":
                playableWebViewBindingBindingFor.onGameInstalled = parseCallbackToken(str2);
                break;
            case "playableOnGameReady":
                playableWebViewBindingBindingFor.onGameReady = parseCallbackToken(str2);
                break;
            case "playableOnRenderFailed":
                playableWebViewBindingBindingFor.onRenderFailed = parseCallbackToken(str2);
                break;
            case "playableMuted":
                playableWebViewBindingBindingFor.muted = parsePlayableBoolean(str2);
                mRAIDWebView.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.DefaultViewRenderer$$ExternalSyntheticLambda15
                    @Override // java.lang.Runnable
                    public final void run() {
                        playableWebViewBindingBindingFor.applyMute(mRAIDWebView);
                    }
                });
                break;
        }
    }

    private void applyPropertyAnimation(View view, String str, String str2) {
        try {
            String[] strArrSplit = str2.split(",");
            if (strArrSplit.length < 3) {
                return;
            }
            float f = Float.parseFloat(strArrSplit[0].trim());
            float f2 = Float.parseFloat(strArrSplit[1].trim());
            long j = Long.parseLong(strArrSplit[2].trim());
            String strTrim = strArrSplit.length > 3 ? strArrSplit[3].trim() : "ease_out";
            if ("translationX".equals(str) || "translationY".equals(str)) {
                float f3 = this.mDensity;
                f *= f3;
                f2 *= f3;
            }
            String str3 = System.identityHashCode(view) + ":" + str;
            ObjectAnimator objectAnimator = this.mRunningAnimators.get(str3);
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, str, f, f2);
            objectAnimatorOfFloat.setDuration(j);
            objectAnimatorOfFloat.setInterpolator(getInterpolator(strTrim));
            this.mRunningAnimators.put(str3, objectAnimatorOfFloat);
            objectAnimatorOfFloat.start();
        } catch (NumberFormatException e) {
        }
    }

    private void applyReducedMotionEndState(View view, String str) {
        stopNamedAnimation(view);
        view.setVisibility(0);
    }

    private void applyRelayout(View view, String str) {
        try {
            String[] strArrSplit = str.split(",");
            if (strArrSplit.length == 4) {
                FrameLayout.LayoutParams layoutParams = view.getLayoutParams() instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) view.getLayoutParams() : new FrameLayout.LayoutParams(-2, -2);
                layoutParams.leftMargin = dp2px(Float.parseFloat(strArrSplit[0].trim()));
                layoutParams.topMargin = dp2px(Float.parseFloat(strArrSplit[1].trim()));
                layoutParams.width = dp2px(Float.parseFloat(strArrSplit[2].trim()));
                layoutParams.height = dp2px(Float.parseFloat(strArrSplit[3].trim()));
                view.setLayoutParams(layoutParams);
                notifyBoundsChanged(view);
            }
        } catch (NumberFormatException e) {
        }
    }

    private void applyResize(View view, String str) {
        ViewGroup.LayoutParams layoutParams;
        try {
            String[] strArrSplit = str.split(",");
            if (strArrSplit.length != 2 || (layoutParams = view.getLayoutParams()) == null) {
                return;
            }
            layoutParams.width = dp2px(Float.parseFloat(strArrSplit[0].trim()));
            layoutParams.height = dp2px(Float.parseFloat(strArrSplit[1].trim()));
            view.setLayoutParams(layoutParams);
            notifyBoundsChanged(view);
        } catch (NumberFormatException e) {
        }
    }

    private void applyScaleType(View view, String str) {
        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            str.getClass();
            switch (str) {
                case "centerInside":
                    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    break;
                case "fitXY":
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    break;
                case "fitCenter":
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    break;
                case "fillWidthTopCrop":
                    imageView.setScaleType(ImageView.ScaleType.MATRIX);
                    break;
                case "centerCrop":
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    break;
                default:
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    break;
            }
        }
    }

    private void applySizeComponent(View view, String str, String str2) {
        try {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            }
            int iDp2px = dp2px(Float.parseFloat(str2.trim()));
            if ("width".equals(str)) {
                layoutParams.width = iDp2px;
            } else {
                layoutParams.height = iDp2px;
            }
            view.setLayoutParams(layoutParams);
            notifyBoundsChanged(view);
        } catch (NumberFormatException e) {
        }
    }

    private void applyTransition(View view, String str) {
        if (view instanceof ViewGroup) {
            try {
                int i = Integer.parseInt(str.trim());
                if (i <= 0) {
                    return;
                }
                ChangeBounds changeBounds = new ChangeBounds();
                changeBounds.setDuration(i);
                changeBounds.setInterpolator(transitionInterpolator(view));
                TransitionManager.beginDelayedTransition((ViewGroup) view, changeBounds);
            } catch (NumberFormatException e) {
            }
        }
    }

    private void applyTransitionStyle(View view, String str) {
        if (EXPRESS_AUGUST_TITLE_TRANSITION.equals(str)) {
            startExpressAugustTitleEnter(view);
            return;
        }
        if (EXPRESS_AUGUST_TITLE_ENTER.equals(view.getTag(R.id.tapad_dirichlet_named_animation_tag))) {
            stopNamedAnimation(view);
        }
        applyTransition(view, str);
    }

    private boolean areMotionAnimationsEnabled() {
        try {
            if (Settings.Global.getFloat(this.mContext.getContentResolver(), "animator_duration_scale", 1.0f) <= 0.0f) {
                return false;
            }
        } catch (RuntimeException e) {
        }
        return Build.VERSION.SDK_INT < 26 || ValueAnimator.areAnimatorsEnabled();
    }

    private PlayableWebViewBinding bindingFor(final MRAIDWebView mRAIDWebView) {
        Object tag = mRAIDWebView.getTag(R.id.tapad_dirichlet_playable_webview_binding_tag);
        if (tag instanceof PlayableWebViewBinding) {
            PlayableWebViewBinding playableWebViewBinding = (PlayableWebViewBinding) tag;
            playableWebViewBinding.webView = mRAIDWebView;
            return playableWebViewBinding;
        }
        final PlayableWebViewBinding playableWebViewBinding2 = new PlayableWebViewBinding();
        playableWebViewBinding2.webView = mRAIDWebView;
        mRAIDWebView.setTag(R.id.tapad_dirichlet_playable_webview_binding_tag, playableWebViewBinding2);
        mRAIDWebView.setGameLifeCircleInterface(playableWebViewBinding2);
        mRAIDWebView.setOnPageFinishedListener(new MRAIDWebView.OnPageFinishedListener() { // from class: com.tapsdk.tapad.internal.runtime.plugin.DefaultViewRenderer$$ExternalSyntheticLambda0
            @Override // com.tapsdk.tapad.internal.ui.views.playable.MRAIDWebView.OnPageFinishedListener
            public final void onPageFinished() {
                playableWebViewBinding2.applyMute(mRAIDWebView);
            }
        });
        return playableWebViewBinding2;
    }

    private void cancelPropertyAnimations(View view) {
        Iterator<Map.Entry<String, ObjectAnimator>> it = this.mRunningAnimators.entrySet().iterator();
        while (it.hasNext()) {
            ObjectAnimator value = it.next().getValue();
            if (value != null && value.getTarget() == view) {
                value.cancel();
                it.remove();
            }
        }
    }

    private void clearImageBinding(int i, View view, boolean z) {
        ImageBinding imageBinding = this.mImageBindings.get(i);
        if (imageBinding != null) {
            imageBinding.clear();
        } else if ((view instanceof ImageView) && z) {
            MechanicalImageLoader.clear((ImageView) view);
        }
        if (z) {
            this.mImageBindings.remove(i);
        }
    }

    private static void configureDialogWindow(Window window) {
        window.addFlags(1024);
        window.clearFlags(2048);
        consumeDialogInsets(window);
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.layoutInDisplayCutoutMode = i >= 30 ? 3 : 1;
            window.setAttributes(attributes);
        }
        SystemBarUtils.setupFullscreenDialog(window);
        consumeDialogInsets(window);
    }

    private static void consumeDialogInsets(Window window) {
        View decorView = window.getDecorView();
        if (decorView == null) {
            return;
        }
        decorView.setFitsSystemWindows(false);
        decorView.setPadding(0, 0, 0, 0);
        if (Build.VERSION.SDK_INT >= 30) {
            window.setDecorFitsSystemWindows(false);
        }
        decorView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.tapsdk.tapad.internal.runtime.plugin.DefaultViewRenderer$$ExternalSyntheticLambda14
            @Override // android.view.View.OnApplyWindowInsetsListener
            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                return DefaultViewRenderer.lambda$consumeDialogInsets$10(view, windowInsets);
            }
        });
        decorView.requestApplyInsets();
        View viewFindViewById = decorView.findViewById(android.R.id.content);
        if (viewFindViewById != null) {
            viewFindViewById.setFitsSystemWindows(false);
            viewFindViewById.setPadding(0, 0, 0, 0);
        }
    }

    private ImageView createImageView(String str) {
        return this.mImageManager.createView(this.mContext, str);
    }

    private View createLottieView() {
        return new DirichletLottieView(this.mContext);
    }

    private MRAIDWebView createPlayableWebView(String str) {
        MRAIDWebView mRAIDWebView = new MRAIDWebView(this.mContext);
        mRAIDWebView.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        mRAIDWebView.setLayerType(2, null);
        mRAIDWebView.setOverScrollMode(2);
        mRAIDWebView.setTelemetryListener(new MRAIDWebView.TelemetryListener() { // from class: com.tapsdk.tapad.internal.runtime.plugin.DefaultViewRenderer.1
            @Override // com.tapsdk.tapad.internal.ui.views.playable.MRAIDWebView.TelemetryListener
            public void onMraidApiCall(String str2, String str3) {
                String str4;
                if ("open".equals(str2)) {
                    str4 = AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL;
                } else if ("expand".equals(str2)) {
                    str4 = "expand_url";
                } else {
                    str4 = "playVideo".equals(str2) ? "video_url" : null;
                }
                DefaultViewRenderer.this.reportPlayableWebViewFact(23, "api_method", str2, str4, str3);
            }

            @Override // com.tapsdk.tapad.internal.ui.views.playable.MRAIDWebView.TelemetryListener
            public void onMraidAudioVolumeChange(double d, double d2) {
                DefaultViewRenderer.this.reportPlayableWebViewFact(25, "volume_percentage", Double.valueOf(d), "previous_volume", Double.valueOf(d2));
            }

            @Override // com.tapsdk.tapad.internal.ui.views.playable.MRAIDWebView.TelemetryListener
            public void onMraidExposureChange(double d, double d2) {
                DefaultViewRenderer.this.reportPlayableWebViewFact(24, "exposed_percentage", Double.valueOf(d), "previous_percentage", Double.valueOf(d2));
            }

            @Override // com.tapsdk.tapad.internal.ui.views.playable.MRAIDWebView.TelemetryListener
            public void onMraidReady(String str2) {
                DefaultViewRenderer.this.reportPlayableWebViewFact(22, "mraid_version", str2);
            }

            @Override // com.tapsdk.tapad.internal.ui.views.playable.MRAIDWebView.TelemetryListener
            public void onPageError(int i, String str2, String str3) {
                DefaultViewRenderer.this.reportPlayableWebViewFact(21, Constants.ERROR_CODE_FIELD, Integer.valueOf(i), "error_description", str2, "failing_url", str3);
            }

            @Override // com.tapsdk.tapad.internal.ui.views.playable.MRAIDWebView.TelemetryListener
            public void onPageFinished(String str2, long j) {
                DefaultViewRenderer.this.reportPlayableWebViewFact(20, "page_url", str2, "load_duration", Long.valueOf(j));
            }

            @Override // com.tapsdk.tapad.internal.ui.views.playable.MRAIDWebView.TelemetryListener
            public void onPageStarted(String str2) {
                DefaultViewRenderer.this.reportPlayableWebViewFact(19, "page_url", str2);
            }
        });
        bindingFor(mRAIDWebView);
        return mRAIDWebView;
    }

    private View createRewardExitGuardNativeView() {
        try {
            int i = RewardCapsuleHost.ExitGuardView.a;
            Object objNewInstance = RewardCapsuleHost.ExitGuardView.class.getConstructor(Context.class).newInstance(this.mContext);
            if ((objNewInstance instanceof View) && (objNewInstance instanceof RewardExitGuardNativeSurface)) {
                return (View) objNewInstance;
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    private View createViewByType(int i, String str) {
        View viewCreateRewardExitGuardNativeView;
        if (i == 0 && REWARD_EXIT_GUARD_NATIVE_ID.equals(str) && (viewCreateRewardExitGuardNativeView = createRewardExitGuardNativeView()) != null) {
            return viewCreateRewardExitGuardNativeView;
        }
        if (i == 5) {
            return createLottieView();
        }
        if (i == 6) {
            return this.mCanvasManager.createView(this.mContext, str);
        }
        if (i == 103) {
            return this.mLinearManager.createView(this.mContext, str);
        }
        if (i == 105) {
            return createPlayableWebView(str);
        }
        if (i == 106) {
            return new DirichletCreativeView(this.mContext, this.mRuntime, this.mInstanceId, this.mSurfaceId);
        }
        switch (i) {
            case 0:
                return this.mContainerManager.createView(this.mContext, str);
            case 1:
                TextView textViewCreateView = this.mTextManager.createView(this.mContext, str);
                textViewCreateView.setTextColor(-1);
                return textViewCreateView;
            case 2:
                return createImageView(str);
            case 3:
                return this.mVideoManager.createView(this.mContext, str);
            default:
                return new View(this.mContext);
        }
    }

    private void delegateSetStyle(View view, int i, String str, String str2) {
        if (i == 6) {
            if (view instanceof CanvasView) {
                this.mCanvasManager.setStyle((CanvasView) view, str, str2);
                return;
            }
            return;
        }
        if (i == 103) {
            if (view instanceof LinearLayout) {
                this.mLinearManager.setStyle((LinearLayout) view, str, str2);
                return;
            }
            return;
        }
        if (i == 105) {
            if (view instanceof MRAIDWebView) {
                applyPlayableWebViewStyle((MRAIDWebView) view, str, str2);
                return;
            }
            return;
        }
        if (i == 106) {
            if (view instanceof DirichletCreativeView) {
                if ("webCreativePackageConfig".equals(str)) {
                    ((DirichletCreativeView) view).setPackageConfig(str2);
                    return;
                } else {
                    if ("webCreativeMediaMuted".equals(str)) {
                        ((DirichletCreativeView) view).setWebMediaMuted(Boolean.parseBoolean(str2));
                        return;
                    }
                    return;
                }
            }
            return;
        }
        switch (i) {
            case 0:
                if (view instanceof FrameLayout) {
                    this.mContainerManager.setStyle((FrameLayout) view, str, str2);
                }
                break;
            case 1:
                if (view instanceof TextView) {
                    this.mTextManager.setStyle((TextView) view, str, str2);
                }
                break;
            case 2:
                if (view instanceof ImageView) {
                    this.mImageManager.setStyle((ImageView) view, str, str2);
                }
                break;
            case 3:
                if (view instanceof FrameLayout) {
                    this.mVideoManager.setStyle((FrameLayout) view, str, str2);
                }
                break;
        }
    }

    private static void dismissDialogWithoutCallback(Dialog dialog) {
        if (dialog == null) {
            return;
        }
        dialog.setOnCancelListener(null);
        dialog.setOnDismissListener(null);
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    private int dp2px(float f) {
        return (int) ((f * this.mDensity) + 0.5f);
    }

    private int findHandleForView(View view) {
        for (int i = 0; i < this.mViewHandles.size(); i++) {
            int iKeyAt = this.mViewHandles.keyAt(i);
            if (this.mViewHandles.valueAt(i) == view) {
                return iKeyAt;
            }
        }
        return -1;
    }

    private int findMountedNativeContainer(int i) {
        for (int i2 = 0; i2 < this.mMountedNativeViews.size(); i2++) {
            MountedNativeView mountedNativeViewValueAt = this.mMountedNativeViews.valueAt(i2);
            if (mountedNativeViewValueAt != null && mountedNativeViewValueAt.nativeHandle == i) {
                return this.mMountedNativeViews.keyAt(i2);
            }
        }
        return -1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:29:0x004d  */
    private static Interpolator getInterpolator(String str) {
        str.getClass();
        switch (str) {
            case "ease_in":
                return new AccelerateInterpolator();
            case "linear":
                return new LinearInterpolator();
            case "ease_out":
                return new DecelerateInterpolator();
            case "ease_in_out":
                return new AccelerateDecelerateInterpolator();
            case "august_popup":
                return new PathInterpolator(0.2f, 0.9f, 0.2f, 1.0f);
            case "august_wheel":
                return new PathInterpolator(0.12f, 0.68f, 0.12f, 1.0f);
            default:
                return new DecelerateInterpolator();
        }
    }

    private GradientDrawable.Orientation gradientOrientation(int i) {
        if (i == 1) {
            return GradientDrawable.Orientation.LEFT_RIGHT;
        }
        return i == 2 ? GradientDrawable.Orientation.BL_TR : GradientDrawable.Orientation.TOP_BOTTOM;
    }

    private static boolean hasDialogWindowFocus(Dialog dialog) {
        Window window;
        return dialog != null && dialog.isShowing() && (window = dialog.getWindow()) != null && hasViewWindowFocus(window.getDecorView());
    }

    private static boolean hasViewWindowFocus(View view) {
        if (view == null) {
            return false;
        }
        if (view.hasWindowFocus()) {
            return true;
        }
        View rootView = view.getRootView();
        return (rootView == null || rootView == view || !rootView.hasWindowFocus()) ? false : true;
    }

    private boolean isDescendantOrSame(View view, View view2) {
        while (view != null) {
            if (view == view2) {
                return true;
            }
            if (!(view.getParent() instanceof View)) {
                return false;
            }
            view = (View) view.getParent();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isEffectivelyVisible(View view) {
        while (view.getVisibility() == 0) {
            if (view == this.mRootView) {
                return true;
            }
            Object parent = view.getParent();
            if (!(parent instanceof View)) {
                return view.isAttachedToWindow();
            }
            view = (View) parent;
        }
        return false;
    }

    private boolean isImageLoadDeferred(int i) {
        ImageBinding imageBinding = this.mImageBindings.get(i);
        return imageBinding != null && imageBinding.request == null;
    }

    static /* synthetic */ WindowInsets lambda$consumeDialogInsets$10(View view, WindowInsets windowInsets) {
        view.setPadding(0, 0, 0, 0);
        View viewFindViewById = view.findViewById(android.R.id.content);
        if (viewFindViewById != null) {
            viewFindViewById.setFitsSystemWindows(false);
            viewFindViewById.setPadding(0, 0, 0, 0);
        }
        return Build.VERSION.SDK_INT >= 30 ? WindowInsets.CONSUMED : windowInsets.replaceSystemWindowInsets(0, 0, 0, 0);
    }

    static /* synthetic */ void lambda$refreshTextLayoutAfterBoundsChange$11(TextView textView) {
        textView.setText(textView.getText());
        textView.requestLayout();
        textView.invalidate();
    }

    static /* synthetic */ void lambda$setOnClick$3(Runnable runnable, View view) {
        if (runnable != null) {
            runnable.run();
        }
    }

    static /* synthetic */ boolean lambda$setOnTouch$4(float[] fArr, boolean[] zArr, int i, ViewRenderer.TouchCallback touchCallback, boolean z, View view, MotionEvent motionEvent) {
        int i2;
        int pointerId = -1;
        switch (motionEvent.getActionMasked()) {
            case 0:
                fArr[0] = motionEvent.getX();
                fArr[1] = motionEvent.getY();
                zArr[0] = false;
                i2 = 0;
                break;
            case 1:
                i2 = 2;
                break;
            case 2:
                float f = i;
                if (Math.abs(motionEvent.getX() - fArr[0]) > f || Math.abs(motionEvent.getY() - fArr[1]) > f) {
                    zArr[0] = true;
                }
                i2 = 1;
                break;
            case 3:
                i2 = 3;
                break;
            default:
                i2 = -1;
                break;
        }
        if (touchCallback != null && i2 >= 0) {
            int actionIndex = motionEvent.getActionIndex();
            if (actionIndex >= 0 && actionIndex < motionEvent.getPointerCount()) {
                pointerId = motionEvent.getPointerId(actionIndex);
            }
            touchCallback.onTouch(i2, motionEvent.getX(), motionEvent.getY(), motionEvent.getRawX(), motionEvent.getRawY(), pointerId, actionIndex, motionEvent.getPointerCount(), motionEvent.getEventTime());
        }
        if (!z) {
            return false;
        }
        if (i2 == 2) {
            boolean z2 = zArr[0];
            zArr[0] = false;
            if (!z2) {
                view.performClick();
            }
        }
        return true;
    }

    static /* synthetic */ void lambda$startBreathingAnimation$12(View view, Runnable[] runnableArr) {
        if (view.isAttachedToWindow()) {
            view.animate().alpha(1.0f).setDuration(1500L).withEndAction(runnableArr[0]).start();
        }
    }

    static /* synthetic */ void lambda$startBreathingAnimation$14(final View view, final Runnable[] runnableArr) {
        if (view.isAttachedToWindow()) {
            view.animate().alpha(0.0f).setDuration(1500L).withEndAction(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.DefaultViewRenderer$$ExternalSyntheticLambda16
                @Override // java.lang.Runnable
                public final void run() {
                    View view2 = view;
                    view2.postDelayed(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.DefaultViewRenderer$$ExternalSyntheticLambda18
                        @Override // java.lang.Runnable
                        public final void run() {
                            DefaultViewRenderer.lambda$startBreathingAnimation$12(view2, runnableArr);
                        }
                    }, 150L);
                }
            }).start();
        }
    }

    static /* synthetic */ void lambda$startCoverFadeOutAnimation$16(View view) {
        if ("cover_fade_out".equals(view.getTag(R.id.tapad_dirichlet_named_animation_tag))) {
            view.setAlpha(0.0f);
            view.setVisibility(4);
        }
    }

    private void logDebugDump(int i, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("View debug dump");
        if (str != null && !str.isEmpty()) {
            sb.append(" [").append(str).append("]");
        }
        sb.append('\n');
        appendDebugDumpLine(sb, i, 0);
    }

    private void notifyBoundsChanged(View view) {
        view.requestLayout();
        view.invalidate();
        if (view instanceof TextView) {
            refreshTextLayoutAfterBoundsChange((TextView) view);
        }
    }

    private void notifyViewDestroy(int i, View view) {
        int i2 = this.mViewTypes.get(i, -1);
        if (i2 < 0 || view == null) {
            return;
        }
        if (view instanceof MRAIDWebView) {
            MRAIDWebView mRAIDWebView = (MRAIDWebView) view;
            try {
                mRAIDWebView.stopLoading();
                mRAIDWebView.clearHistory();
                mRAIDWebView.removeAllViews();
                mRAIDWebView.setOnPageFinishedListener(null);
                mRAIDWebView.setGameLifeCircleInterface(null);
                mRAIDWebView.onDestroy();
                return;
            } catch (Throwable th) {
                return;
            }
        }
        if (view instanceof DirichletCreativeView) {
            ((DirichletCreativeView) view).destroy();
            return;
        }
        if (view instanceof DirichletLottieView) {
            ((DirichletLottieView) view).release();
            return;
        }
        ViewManager byType = ViewManagerRegistry.getInstance().getByType(i2);
        if (byType == null) {
            return;
        }
        try {
            byType.onViewDestroy(view);
        } catch (Throwable th2) {
        }
    }

    private static int parseCallbackToken(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return Integer.parseInt(str.trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private int parseColor(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                return Color.parseColor(str);
            } catch (Exception e) {
            }
        }
        return 0;
    }

    private static float parseFiniteFloatOrDefault(String str, float f) {
        if (str != null && !str.isEmpty()) {
            try {
                float f2 = Float.parseFloat(str);
                if (!Float.isNaN(f2) && !Float.isInfinite(f2)) {
                    return f2;
                }
            } catch (NumberFormatException e) {
            }
        }
        return f;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x005e  */
    private void parseGradient(String str, ViewInfo viewInfo) {
        String[] strArrSplit = str.split(",");
        int i = 2;
        if (strArrSplit.length >= 2) {
            viewInfo.gradientColors = new int[]{parseColor(strArrSplit[0].trim()), parseColor(strArrSplit[1].trim())};
            if (strArrSplit.length >= 3) {
                String strTrim = strArrSplit[2].trim();
                if ("tb".equals(strTrim) || "vertical".equals(strTrim)) {
                    i = 0;
                } else if (!"bl_tr".equals(strTrim)) {
                    if ("horizontal".equals(strTrim) || "lr".equals(strTrim)) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                }
                viewInfo.gradientOrientation = i;
            }
        }
    }

    private static boolean parsePlayableBoolean(String str) {
        return "1".equals(str) || "true".equalsIgnoreCase(str);
    }

    private int pxToDp(int i) {
        return Math.round(i / this.mDensity);
    }

    private void raiseRendererModalBranch(View view) {
        if (isDescendantOrSame(view, this.mRootView)) {
            ViewParent parent = view.getParent();
            View view2 = view;
            while ((parent instanceof ViewGroup) && parent != this.mRootView) {
                ViewGroup viewGroup = (ViewGroup) parent;
                viewGroup.bringChildToFront(view2);
                viewGroup.requestLayout();
                viewGroup.invalidate();
                parent = viewGroup.getParent();
                view2 = viewGroup;
            }
        }
    }

    private void refreshTextLayoutAfterBoundsChange(final TextView textView) {
        textView.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.DefaultViewRenderer$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                DefaultViewRenderer.lambda$refreshTextLayoutAfterBoundsChange$11(textView);
            }
        });
    }

    private void releaseAllMountedNativeViews(boolean z) {
        int size = this.mMountedNativeViews.size();
        int[] iArr = new int[size];
        for (int i = 0; i < this.mMountedNativeViews.size(); i++) {
            iArr[i] = this.mMountedNativeViews.keyAt(i);
        }
        for (int i2 = 0; i2 < size; i2++) {
            releaseMountedNativeView(iArr[i2], z);
        }
    }

    private void releaseDialogWindowsForDestroyedContent(int i) {
        releasePopupDialogForContent(i);
        for (int i2 = 0; i2 < this.mOverlays.size(); i2++) {
            OverlayInfo overlayInfoValueAt = this.mOverlays.valueAt(i2);
            if (overlayInfoValueAt != null && overlayInfoValueAt.content == i) {
                releaseOverlayDialogWindow(overlayInfoValueAt);
            }
        }
    }

    private void releaseMountedNativeView(int i, boolean z) {
        Runnable runnable;
        MountedNativeView mountedNativeView = this.mMountedNativeViews.get(i);
        if (mountedNativeView == null) {
            return;
        }
        this.mMountedNativeViews.remove(i);
        if (z && (runnable = mountedNativeView.onUnmount) != null) {
            runnable.run();
        }
        View view = mountedNativeView.view;
        if (view != null) {
            view.setOnClickListener(null);
            mountedNativeView.view.setOnTouchListener(null);
            if (mountedNativeView.view.getParent() instanceof ViewGroup) {
                ((ViewGroup) mountedNativeView.view.getParent()).removeView(mountedNativeView.view);
            }
        }
        View view2 = this.mViewHandles.get(i);
        if (view2 == null || !mountedNativeView.restoreClickable) {
            return;
        }
        view2.setClickable(mountedNativeView.containerWasClickable);
    }

    private void releaseMountedNativeViewsUnder(int i, View view, boolean z) {
        releaseMountedNativeView(i, z);
        if (view == null) {
            return;
        }
        int[] iArr = new int[this.mMountedNativeViews.size()];
        int i2 = 0;
        for (int i3 = 0; i3 < this.mMountedNativeViews.size(); i3++) {
            int iKeyAt = this.mMountedNativeViews.keyAt(i3);
            View view2 = this.mViewHandles.get(iKeyAt);
            if (view2 != null && isDescendantOrSame(view2, view)) {
                iArr[i2] = iKeyAt;
                i2++;
            }
        }
        for (int i4 = 0; i4 < i2; i4++) {
            releaseMountedNativeView(iArr[i4], z);
        }
    }

    private static void releaseOverlayDialogWindow(OverlayInfo overlayInfo) {
        if (overlayInfo == null) {
            return;
        }
        overlayInfo.programmaticDismiss = true;
        dismissDialogWithoutCallback(overlayInfo.dialog);
        overlayInfo.dialog = null;
        overlayInfo.content = -1;
    }

    private void releasePopupDialogForContent(int i) {
        DialogInfo dialogInfo = this.mPopups.get(i);
        if (dialogInfo == null) {
            return;
        }
        dialogInfo.programmaticDismiss = true;
        dismissDialogWithoutCallback(dialogInfo.dialog);
        this.mPopups.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportPlayableWebViewFact(int i, Object... objArr) {
        JSONObject jSONObject = new JSONObject();
        if (objArr != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i3 >= objArr.length) {
                    break;
                }
                Object obj = objArr[i2];
                Object obj2 = objArr[i3];
                if ((obj instanceof String) && obj2 != null) {
                    try {
                        jSONObject.put((String) obj, obj2);
                    } catch (Throwable th) {
                    }
                }
                i2 += 2;
            }
        }
        this.mRuntime.dispatchAndroidWebViewFact(this.mInstanceId, this.mSurfaceId, i, jSONObject.toString());
    }

    private void showPositionedOverlay(final OverlayInfo overlayInfo, int i, final View view, final int i2, final int i3, final Window window) {
        final View view2 = this.mViewHandles.get(i);
        if (view2 == null) {
            return;
        }
        applyOverlayWindowBase(window, overlayInfo.config);
        view2.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.DefaultViewRenderer$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m294lambda$showPositionedOverlay$9$comtapsdktapadinternalruntimepluginDefaultViewRenderer(overlayInfo, i2, i3, view, view2, window);
            }
        });
    }

    private void startBannerTrainDoorAnimation(View view, float f) {
        stopNamedAnimation(view);
        view.setVisibility(0);
        view.setAlpha(1.0f);
        view.setTranslationX(0.0f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_X, 0.0f, f * dp2px(34.0f));
        objectAnimatorOfFloat.setStartDelay(1300L);
        objectAnimatorOfFloat.setDuration(500L);
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        view.setTag(R.id.tapad_dirichlet_breathing_animator_tag, objectAnimatorOfFloat);
        objectAnimatorOfFloat.start();
    }

    private void startBannerTrainEnterAnimation(final View view, final boolean z) {
        stopNamedAnimation(view);
        final String str = z ? "banner_train_lead_enter" : "banner_train_body_enter";
        view.setTag(R.id.tapad_dirichlet_named_animation_tag, str);
        view.setVisibility(0);
        view.setAlpha(0.0f);
        view.setTranslationX(0.0f);
        view.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.DefaultViewRenderer$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m295lambda$startBannerTrainEnterAnimation$18$comtapsdktapadinternalruntimepluginDefaultViewRenderer(str, view, z);
            }
        });
    }

    private void startBannerWaveBobAnimation(final View view) {
        stopNamedAnimation(view);
        view.setVisibility(0);
        view.setAlpha(1.0f);
        view.setTranslationY(0.0f);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(-1.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tapsdk.tapad.internal.runtime.plugin.DefaultViewRenderer$$ExternalSyntheticLambda10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                view.setTranslationY(valueAnimator.getAnimatedFraction() * 15.0f);
            }
        });
        valueAnimatorOfFloat.setDuration(3000L);
        valueAnimatorOfFloat.setRepeatCount(-1);
        valueAnimatorOfFloat.setInterpolator(new CycleInterpolator(1.0f));
        view.setTag(R.id.tapad_dirichlet_breathing_animator_tag, valueAnimatorOfFloat);
        valueAnimatorOfFloat.start();
    }

    private void startBreathingAnimation(final View view) {
        stopNamedAnimation(view);
        view.setAlpha(1.0f);
        final Runnable[] runnableArr = {runnable};
        Runnable runnable = new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.DefaultViewRenderer$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                View view2 = view;
                view2.postDelayed(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.DefaultViewRenderer$$ExternalSyntheticLambda17
                    @Override // java.lang.Runnable
                    public final void run() {
                        DefaultViewRenderer.lambda$startBreathingAnimation$14(view2, runnableArr);
                    }
                }, 150L);
            }
        };
        runnable.run();
    }

    private void startBreathingGlowAnimation(View view) {
        stopNamedAnimation(view);
        view.setVisibility(0);
        view.setAlpha(0.1f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 0.1f, 0.4f);
        objectAnimatorOfFloat.setDuration(1500L);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        view.setTag(R.id.tapad_dirichlet_breathing_animator_tag, objectAnimatorOfFloat);
        objectAnimatorOfFloat.start();
    }

    private void startCoverFadeOutAnimation(final View view) {
        Object tag = view.getTag(R.id.tapad_dirichlet_breathing_animator_tag);
        if (tag instanceof Animator) {
            ((Animator) tag).cancel();
        }
        view.setTag(R.id.tapad_dirichlet_breathing_animator_tag, null);
        view.animate().cancel();
        view.clearAnimation();
        view.setVisibility(0);
        if (view.getAlpha() <= 0.0f) {
            view.setAlpha(1.0f);
        }
        view.animate().alpha(0.0f).setDuration(180L).setInterpolator(new DecelerateInterpolator()).withEndAction(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.DefaultViewRenderer$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                DefaultViewRenderer.lambda$startCoverFadeOutAnimation$16(view);
            }
        }).start();
    }

    private void startExpressAugustTitleEnter(View view) {
        if (!areMotionAnimationsEnabled()) {
            applyReducedMotionEndState(view, EXPRESS_AUGUST_TITLE_ENTER);
            return;
        }
        stopNamedAnimation(view);
        view.setVisibility(0);
        view.setAlpha(0.0f);
        view.setTranslationY(dp2px(2.0f));
        view.setScaleX(0.98f);
        view.setScaleY(0.98f);
        view.setTag(R.id.tapad_dirichlet_named_animation_tag, EXPRESS_AUGUST_TITLE_ENTER);
        view.animate().alpha(1.0f).translationY(0.0f).scaleX(1.0f).scaleY(1.0f).setDuration(320L).setInterpolator(new DecelerateInterpolator()).start();
    }

    private void startImageIfEligible(int i) {
        ImageBinding imageBinding = this.mImageBindings.get(i);
        if (imageBinding != null) {
            imageBinding.startIfEligible();
        }
    }

    private void startInterstitialAugustCtaBreathe(View view) {
        stopNamedAnimation(view);
        view.setVisibility(0);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 1.0f, 0.84f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_X, 1.0f, 0.96f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_Y, 1.0f, 0.96f);
        ObjectAnimator[] objectAnimatorArr = {objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3};
        for (int i = 0; i < 3; i++) {
            ObjectAnimator objectAnimator = objectAnimatorArr[i];
            objectAnimator.setDuration(1200L);
            objectAnimator.setRepeatCount(-1);
            objectAnimator.setRepeatMode(2);
            objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        view.setTag(R.id.tapad_dirichlet_breathing_animator_tag, animatorSet);
        animatorSet.start();
    }

    private void startInterstitialAugustRewardCloseEnter(View view) {
        stopNamedAnimation(view);
        view.setVisibility(0);
        view.setAlpha(0.0f);
        view.animate().alpha(1.0f).setStartDelay(160L).setDuration(220L).setInterpolator(new DecelerateInterpolator()).start();
    }

    private void startInterstitialAugustRewardHeadingEnter(View view) {
        stopNamedAnimation(view);
        view.setVisibility(0);
        view.setAlpha(0.0f);
        view.setTranslationY(dp2px(10.0f));
        view.animate().alpha(1.0f).translationY(0.0f).setStartDelay(80L).setDuration(300L).setInterpolator(new DecelerateInterpolator()).start();
    }

    private void startInterstitialPopoverBackdropEnter(View view) {
        stopNamedAnimation(view);
        view.setVisibility(0);
        view.setAlpha(0.0f);
        view.animate().alpha(1.0f).setDuration(600L).setInterpolator(new DecelerateInterpolator()).start();
    }

    private void startInterstitialPopoverContentEnter(View view) {
        stopNamedAnimation(view);
        view.setVisibility(0);
        view.setAlpha(0.0f);
        view.setScaleX(0.8f);
        view.setScaleY(0.8f);
        view.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(600L).setInterpolator(new CriticalDampedSpringInterpolator(0.0f)).start();
    }

    private void startSplashAugustHandFade(View view) {
        stopNamedAnimation(view);
        view.setVisibility(0);
        view.setAlpha(1.0f);
        view.animate().alpha(0.0f).translationY(-dp2px(8.0f)).setDuration(360L).setInterpolator(new DecelerateInterpolator()).start();
    }

    private void startSplashAugustHandLift(View view) {
        stopNamedAnimation(view);
        view.setVisibility(0);
        Keyframe[] keyframeArr = {Keyframe.ofFloat(0.0f, dp2px(12.0f)), Keyframe.ofFloat(0.42f, 0.0f), Keyframe.ofFloat(0.48f, 0.0f), Keyframe.ofFloat(0.55f, 0.0f), Keyframe.ofFloat(1.0f, dp2px(7.0f))};
        Keyframe[] keyframeArr2 = {Keyframe.ofFloat(0.0f, dp2px(14.0f)), Keyframe.ofFloat(0.42f, 0.0f), Keyframe.ofFloat(0.48f, 0.0f), Keyframe.ofFloat(0.55f, 0.0f), Keyframe.ofFloat(1.0f, dp2px(9.0f))};
        Keyframe[] keyframeArr3 = {Keyframe.ofFloat(0.0f, 0.96f), Keyframe.ofFloat(0.42f, 1.0f), Keyframe.ofFloat(0.48f, 0.9f), Keyframe.ofFloat(0.55f, 1.0f), Keyframe.ofFloat(1.0f, 0.97f)};
        Keyframe[] keyframeArr4 = {Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.18f, 1.0f), Keyframe.ofFloat(0.72f, 1.0f), Keyframe.ofFloat(0.88f, 0.0f), Keyframe.ofFloat(1.0f, 0.0f)};
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofKeyframe(View.TRANSLATION_X, keyframeArr));
        ObjectAnimator objectAnimatorOfPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofKeyframe(View.TRANSLATION_Y, keyframeArr2));
        ObjectAnimator objectAnimatorOfPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofKeyframe(View.SCALE_X, keyframeArr3));
        ObjectAnimator objectAnimatorOfPropertyValuesHolder4 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofKeyframe(View.SCALE_Y, keyframeArr3));
        ObjectAnimator objectAnimatorOfPropertyValuesHolder5 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofKeyframe(View.ALPHA, keyframeArr4));
        ObjectAnimator[] objectAnimatorArr = {objectAnimatorOfPropertyValuesHolder, objectAnimatorOfPropertyValuesHolder2, objectAnimatorOfPropertyValuesHolder3, objectAnimatorOfPropertyValuesHolder4, objectAnimatorOfPropertyValuesHolder5};
        int i = 0;
        for (int i2 = 5; i < i2; i2 = 5) {
            ObjectAnimator objectAnimator = objectAnimatorArr[i];
            objectAnimator.setDuration(2800L);
            objectAnimator.setRepeatCount(-1);
            objectAnimator.setInterpolator(new PathInterpolator(0.22f, 0.72f, 0.22f, 1.0f));
            i++;
            objectAnimatorOfPropertyValuesHolder4 = objectAnimatorOfPropertyValuesHolder4;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfPropertyValuesHolder, objectAnimatorOfPropertyValuesHolder2, objectAnimatorOfPropertyValuesHolder3, objectAnimatorOfPropertyValuesHolder4, objectAnimatorOfPropertyValuesHolder5);
        view.setTag(R.id.tapad_dirichlet_breathing_animator_tag, animatorSet);
        animatorSet.start();
    }

    private void startSplashAugustLaunchEnter(View view) {
        stopNamedAnimation(view);
        view.setVisibility(0);
        view.setAlpha(0.0f);
        view.setTranslationY(dp2px(34.0f));
        view.setScaleX(1.075f);
        view.setScaleY(1.075f);
        Keyframe[] keyframeArr = {Keyframe.ofFloat(0.0f, dp2px(34.0f)), Keyframe.ofFloat(0.55f, -dp2px(2.0f)), Keyframe.ofFloat(1.0f, 0.0f)};
        Keyframe[] keyframeArr2 = {Keyframe.ofFloat(0.0f, 1.075f), Keyframe.ofFloat(0.55f, 0.994f), Keyframe.ofFloat(1.0f, 1.0f)};
        Keyframe[] keyframeArr3 = {Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.55f, 1.0f), Keyframe.ofFloat(1.0f, 1.0f)};
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofKeyframe(View.TRANSLATION_Y, keyframeArr));
        ObjectAnimator objectAnimatorOfPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofKeyframe(View.SCALE_X, keyframeArr2));
        ObjectAnimator objectAnimatorOfPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofKeyframe(View.SCALE_Y, keyframeArr2));
        ObjectAnimator objectAnimatorOfPropertyValuesHolder4 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofKeyframe(View.ALPHA, keyframeArr3));
        ObjectAnimator[] objectAnimatorArr = {objectAnimatorOfPropertyValuesHolder, objectAnimatorOfPropertyValuesHolder2, objectAnimatorOfPropertyValuesHolder3, objectAnimatorOfPropertyValuesHolder4};
        int i = 0;
        while (i < 4) {
            ObjectAnimator objectAnimator = objectAnimatorArr[i];
            objectAnimator.setStartDelay(700L);
            objectAnimator.setDuration(620L);
            objectAnimator.setInterpolator(new PathInterpolator(0.18f, 0.72f, 0.22f, 1.0f));
            i++;
            objectAnimatorArr = objectAnimatorArr;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfPropertyValuesHolder, objectAnimatorOfPropertyValuesHolder2, objectAnimatorOfPropertyValuesHolder3, objectAnimatorOfPropertyValuesHolder4);
        view.setTag(R.id.tapad_dirichlet_breathing_animator_tag, animatorSet);
        animatorSet.start();
    }

    private void startSplashAugustRingBreathe(View view) {
        stopNamedAnimation(view);
        view.setVisibility(0);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 0.78f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_X, 0.96f, 1.04f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_Y, 0.96f, 1.04f);
        ObjectAnimator[] objectAnimatorArr = {objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3};
        for (int i = 0; i < 3; i++) {
            ObjectAnimator objectAnimator = objectAnimatorArr[i];
            objectAnimator.setDuration(1100L);
            objectAnimator.setRepeatCount(-1);
            objectAnimator.setRepeatMode(2);
            objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        view.setTag(R.id.tapad_dirichlet_breathing_animator_tag, animatorSet);
        animatorSet.start();
    }

    private void startSplashAugustRingExpand(View view) {
        stopNamedAnimation(view);
        view.setVisibility(0);
        view.setAlpha(1.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.animate().alpha(0.0f).scaleX(4.2f).scaleY(4.2f).setDuration(850L).setInterpolator(new PathInterpolator(0.18f, 0.62f, 0.22f, 1.0f)).start();
    }

    private void startSplashAugustSourceExit(View view) {
        stopNamedAnimation(view);
        view.setVisibility(0);
        view.setAlpha(1.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        Keyframe[] keyframeArr = {Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(0.45f, 0.965f), Keyframe.ofFloat(1.0f, 0.86f)};
        Keyframe[] keyframeArr2 = {Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(0.45f, 0.92f), Keyframe.ofFloat(1.0f, 0.0f)};
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofKeyframe(View.SCALE_X, keyframeArr));
        ObjectAnimator objectAnimatorOfPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofKeyframe(View.SCALE_Y, keyframeArr));
        ObjectAnimator objectAnimatorOfPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofKeyframe(View.ALPHA, keyframeArr2));
        ObjectAnimator[] objectAnimatorArr = {objectAnimatorOfPropertyValuesHolder, objectAnimatorOfPropertyValuesHolder2, objectAnimatorOfPropertyValuesHolder3};
        for (int i = 0; i < 3; i++) {
            ObjectAnimator objectAnimator = objectAnimatorArr[i];
            objectAnimator.setStartDelay(360L);
            objectAnimator.setDuration(560L);
            objectAnimator.setInterpolator(new PathInterpolator(0.4f, 0.0f, 0.25f, 1.0f));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfPropertyValuesHolder, objectAnimatorOfPropertyValuesHolder2, objectAnimatorOfPropertyValuesHolder3);
        view.setTag(R.id.tapad_dirichlet_breathing_animator_tag, animatorSet);
        animatorSet.start();
    }

    private void startYlhHandTapAnimation(View view) {
        stopNamedAnimation(view);
        view.setVisibility(0);
        view.setAlpha(1.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setTranslationY(0.0f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_X, 1.0f, 0.92f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_Y, 1.0f, 0.92f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, 0.0f, dp2px(2.0f), 0.0f);
        ObjectAnimator[] objectAnimatorArr = {objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3};
        for (int i = 0; i < 3; i++) {
            ObjectAnimator objectAnimator = objectAnimatorArr[i];
            objectAnimator.setDuration(900L);
            objectAnimator.setRepeatCount(-1);
            objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        view.setTag(R.id.tapad_dirichlet_breathing_animator_tag, animatorSet);
        animatorSet.start();
    }

    private void stopNamedAnimation(View view) {
        if (view == null) {
            return;
        }
        Object tag = view.getTag(R.id.tapad_dirichlet_breathing_animator_tag);
        if (tag instanceof Animator) {
            ((Animator) tag).cancel();
        }
        view.setTag(R.id.tapad_dirichlet_breathing_animator_tag, null);
        view.setTag(R.id.tapad_dirichlet_named_animation_tag, null);
        view.animate().cancel();
        view.clearAnimation();
        view.setAlpha(1.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
        view.setRotation(0.0f);
    }

    private void suspendImages(View view) {
        for (int i = 0; i < this.mImageBindings.size(); i++) {
            View view2 = this.mViewHandles.get(this.mImageBindings.keyAt(i));
            if ((view2 instanceof ImageView) && isDescendantOrSame(view2, view)) {
                ImageBinding imageBindingValueAt = this.mImageBindings.valueAt(i);
                if (!imageBindingValueAt.preload) {
                    imageBindingValueAt.suspend();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void traceImageVisibility(String str, int i, String str2) {
        if (Log.isLoggable(IMAGE_TAG, 3)) {
            MechanicalImageLoader.debugSourceId(str2);
        }
    }

    private Interpolator transitionInterpolator(View view) {
        Object tag = view.getTag(R.id.tapad_dirichlet_transition_motion_tag);
        if (tag instanceof String) {
            String str = (String) tag;
            if (str.startsWith("spring:")) {
                float f = 0.35f;
                String[] strArrSplit = str.split(":");
                if (strArrSplit.length >= 3) {
                    try {
                        f = Float.parseFloat(strArrSplit[2]);
                    } catch (NumberFormatException e) {
                    }
                }
                return new CriticalDampedSpringInterpolator(f);
            }
        }
        return new AccelerateDecelerateInterpolator();
    }

    private void updateBackground(View view, ViewInfo viewInfo) {
        boolean z;
        final float fDp2px;
        GradientDrawable gradientDrawable = new GradientDrawable();
        int[] iArr = viewInfo.gradientColors;
        if (iArr == null || iArr.length < 2) {
            gradientDrawable.setColor(viewInfo.backgroundColor);
        } else {
            gradientDrawable.setColors(iArr);
            gradientDrawable.setOrientation(gradientOrientation(viewInfo.gradientOrientation));
        }
        if (viewInfo.hasIndividualCorners()) {
            float f = viewInfo.cornerRadiusTopLeft;
            fDp2px = f >= 0.0f ? dp2px(f) : 0.0f;
            float f2 = viewInfo.cornerRadiusTopRight;
            float fDp2px2 = f2 >= 0.0f ? dp2px(f2) : 0.0f;
            float f3 = viewInfo.cornerRadiusBottomRight;
            float fDp2px3 = f3 >= 0.0f ? dp2px(f3) : 0.0f;
            float f4 = viewInfo.cornerRadiusBottomLeft;
            float fDp2px4 = f4 >= 0.0f ? dp2px(f4) : 0.0f;
            gradientDrawable.setCornerRadii(new float[]{fDp2px, fDp2px, fDp2px2, fDp2px2, fDp2px3, fDp2px3, fDp2px4, fDp2px4});
            if (fDp2px == fDp2px2 && fDp2px2 == fDp2px3 && fDp2px3 == fDp2px4) {
                z = false;
            } else {
                z = true;
                fDp2px = 0.0f;
            }
        } else {
            float f5 = viewInfo.cornerRadius;
            if (f5 > 0.0f) {
                fDp2px = dp2px(f5);
                gradientDrawable.setCornerRadius(fDp2px);
                z = false;
            } else {
                z = false;
                fDp2px = 0.0f;
            }
        }
        if (fDp2px > 0.0f) {
            view.setClipToOutline(true);
            view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.tapsdk.tapad.internal.runtime.plugin.DefaultViewRenderer.2
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view2, Outline outline) {
                    outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), fDp2px);
                }
            });
        } else if (z) {
            view.setClipToOutline(false);
            view.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        }
        float f6 = viewInfo.borderWidth;
        if (f6 > 0.0f && viewInfo.borderColor != 0) {
            gradientDrawable.setStroke(dp2px(f6), viewInfo.borderColor);
        }
        view.setBackground(gradientDrawable);
    }

    @Override // com.tapsdk.tapad.internal.runtime.ViewRenderer
    public void addChild(int i, int i2) {
        KeyEvent.Callback callback = (View) this.mViewHandles.get(i);
        View view = this.mViewHandles.get(i2);
        if ((callback instanceof RewardExitGuardNativeSurface) && view != null) {
            ((RewardExitGuardNativeSurface) callback).addExitGuardFallbackChild(view);
        } else if ((callback instanceof ViewGroup) && view != null) {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            ViewGroup viewGroup = (ViewGroup) callback;
            viewGroup.addView(view);
            this.mProviderAttributionSlots.refresh(viewGroup);
        } else if (i == 0 && view != null) {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.mRootView.addView(view);
        }
        if (view != null) {
            activateVisibleImages(view);
        }
        ProviderModalLayerOrder providerModalLayerOrder = this.mProviderModalLayerOrder;
        if (providerModalLayerOrder != null) {
            providerModalLayerOrder.reconcile();
        }
    }

    @Override // com.tapsdk.tapad.internal.runtime.ViewRenderer
    public int allocateHandle() {
        return this.mHandleGenerator.getAndIncrement();
    }

    @Override // com.tapsdk.tapad.internal.runtime.ViewRenderer
    public boolean attachVideoView(int i, int i2, View view, ViewGroup.LayoutParams layoutParams, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener, boolean z, Runnable runnable) {
        View view2 = this.mViewHandles.get(i);
        if (!(view2 instanceof ViewGroup) || view == null) {
            return false;
        }
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        }
        int iFindMountedNativeContainer = findMountedNativeContainer(i2);
        if (iFindMountedNativeContainer == i) {
            MountedNativeView mountedNativeView = this.mMountedNativeViews.get(i);
            view.setOnTouchListener(onTouchListener);
            view.setOnClickListener(onClickListener);
            view.setClickable(z);
            if (view.getParent() != view2) {
                if (view.getParent() instanceof ViewGroup) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                ((ViewGroup) view2).addView(view, 0, layoutParams);
            } else {
                view.setLayoutParams(layoutParams);
            }
            if (mountedNativeView != null) {
                mountedNativeView.view = view;
                mountedNativeView.onUnmount = runnable;
                mountedNativeView.restoreClickable = z;
                if (z) {
                    view2.setClickable(false);
                } else {
                    view2.setClickable(mountedNativeView.containerWasClickable);
                }
            }
            return true;
        }
        if (iFindMountedNativeContainer >= 0) {
            releaseMountedNativeView(iFindMountedNativeContainer, false);
        }
        releaseMountedNativeView(i, true);
        if (view.getParent() instanceof ViewGroup) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        view.setOnTouchListener(onTouchListener);
        view.setOnClickListener(onClickListener);
        view.setClickable(z);
        ((ViewGroup) view2).addView(view, 0, layoutParams);
        MountedNativeView mountedNativeView2 = new MountedNativeView();
        mountedNativeView2.nativeHandle = i2;
        mountedNativeView2.view = view;
        mountedNativeView2.onUnmount = runnable;
        mountedNativeView2.restoreClickable = z;
        mountedNativeView2.containerWasClickable = view2.isClickable();
        this.mMountedNativeViews.put(i, mountedNativeView2);
        if (z) {
            view2.setClickable(false);
        }
        return true;
    }

    @Override // com.tapsdk.tapad.internal.runtime.ViewRenderer
    public int createView(int i, String str) {
        View viewCreateViewByType = createViewByType(i, str);
        if (viewCreateViewByType == null) {
            return -1;
        }
        viewCreateViewByType.setVisibility(4);
        int andIncrement = this.mHandleGenerator.getAndIncrement();
        this.mViewHandles.put(andIncrement, viewCreateViewByType);
        this.mViewInfos.put(andIncrement, new ViewInfo());
        this.mViewTypes.put(andIncrement, i);
        this.mViewIds.put(str, viewCreateViewByType);
        viewCreateViewByType.setTag(R.id.tapad_dirichlet_view_id_tag, str);
        if ("root".equals(str)) {
            this.mRootView.addView(viewCreateViewByType, new FrameLayout.LayoutParams(-1, -1));
        }
        return andIncrement;
    }

    @Override // com.tapsdk.tapad.internal.runtime.ViewRenderer
    public void createViewForHandle(int i, int i2, String str) {
        View viewCreateViewByType = createViewByType(i2, str);
        if (viewCreateViewByType == null) {
            return;
        }
        viewCreateViewByType.setVisibility(4);
        this.mViewHandles.put(i, viewCreateViewByType);
        this.mViewInfos.put(i, new ViewInfo());
        this.mViewTypes.put(i, i2);
        this.mViewIds.put(str, viewCreateViewByType);
        viewCreateViewByType.setTag(R.id.tapad_dirichlet_view_id_tag, str);
        if ("root".equals(str)) {
            this.mRootView.addView(viewCreateViewByType, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void destroy() {
        ProviderModalLayerOrder providerModalLayerOrder = this.mProviderModalLayerOrder;
        if (providerModalLayerOrder != null) {
            providerModalLayerOrder.close();
            this.mProviderModalLayerOrder = null;
        }
        releaseAllMountedNativeViews(true);
        overlayDestroyAll();
        for (int i = 0; i < this.mPopups.size(); i++) {
            DialogInfo dialogInfoValueAt = this.mPopups.valueAt(i);
            dialogInfoValueAt.programmaticDismiss = true;
            if (dialogInfoValueAt.dialog.isShowing()) {
                dialogInfoValueAt.dialog.dismiss();
            }
        }
        this.mPopups.clear();
        Iterator<ObjectAnimator> it = this.mRunningAnimators.values().iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
        this.mRunningAnimators.clear();
        for (int i2 = 0; i2 < this.mViewHandles.size(); i2++) {
            int iKeyAt = this.mViewHandles.keyAt(i2);
            View viewValueAt = this.mViewHandles.valueAt(i2);
            stopNamedAnimation(viewValueAt);
            clearImageBinding(iKeyAt, viewValueAt, true);
            notifyViewDestroy(iKeyAt, viewValueAt);
        }
        this.mRootView.removeAllViews();
        this.mViewHandles.clear();
        this.mViewInfos.clear();
        this.mViewTypes.clear();
        this.mImageBindings.clear();
        this.mViewIds.clear();
        this.mProviderMediaSlots.clear();
        this.mProviderActionSlots.clear();
        this.mProviderAttributionSlots.clear();
    }

    @Override // com.tapsdk.tapad.internal.runtime.ViewRenderer
    public void destroyView(int i) {
        View view = this.mViewHandles.get(i);
        if (view == null) {
            return;
        }
        releaseDialogWindowsForDestroyedContent(i);
        releaseMountedNativeViewsUnder(i, view, true);
        int[] iArr = new int[this.mViewHandles.size()];
        int i2 = 0;
        for (int i3 = 0; i3 < this.mViewHandles.size(); i3++) {
            View viewValueAt = this.mViewHandles.valueAt(i3);
            if (viewValueAt != null && isDescendantOrSame(viewValueAt, view)) {
                iArr[i2] = this.mViewHandles.keyAt(i3);
                i2++;
            }
        }
        for (int i4 = i2 - 1; i4 >= 0; i4--) {
            int i5 = iArr[i4];
            View view2 = this.mViewHandles.get(i5);
            if (view2 != null) {
                this.mProviderMediaSlots.unregister(view2);
                this.mProviderActionSlots.unregister(view2);
                this.mProviderAttributionSlots.unregister(view2);
                ProviderModalLayerOrder providerModalLayerOrder = this.mProviderModalLayerOrder;
                if (providerModalLayerOrder != null) {
                    providerModalLayerOrder.register(view2, false);
                }
                String str = (String) view2.getTag(R.id.tapad_dirichlet_view_id_tag);
                if (str != null && this.mViewIds.get(str) == view2) {
                    this.mViewIds.remove(str);
                }
                cancelPropertyAnimations(view2);
                stopNamedAnimation(view2);
                clearImageBinding(i5, view2, true);
                notifyViewDestroy(i5, view2);
                this.mViewHandles.remove(i5);
                this.mViewInfos.remove(i5);
                this.mViewTypes.delete(i5);
            }
        }
        if (view.getParent() instanceof ViewGroup) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    @Override // com.tapsdk.tapad.internal.runtime.ViewRenderer
    public void detachVideoView(int i) {
        int iFindMountedNativeContainer = findMountedNativeContainer(i);
        if (iFindMountedNativeContainer >= 0) {
            releaseMountedNativeView(iFindMountedNativeContainer, false);
        }
    }

    public void enableProviderContentModalOrdering() {
        View view;
        if (this.mProviderModalLayerOrder != null) {
            return;
        }
        this.mProviderModalLayerOrder = new ProviderModalLayerOrder(this.mRootView);
        for (int i = 0; i < this.mViewInfos.size(); i++) {
            if (this.mViewInfos.valueAt(i).modalLayer && (view = this.mViewHandles.get(this.mViewInfos.keyAt(i))) != null) {
                this.mProviderModalLayerOrder.register(view, true);
            }
        }
    }

    public View findViewByDebugKey(String str) {
        if (str != null && !str.isEmpty()) {
            for (int i = 0; i < this.mViewHandles.size(); i++) {
                View viewValueAt = this.mViewHandles.valueAt(i);
                if (viewValueAt != null && str.equals(viewValueAt.getTag(R.id.tapad_dirichlet_debug_key_tag))) {
                    return viewValueAt;
                }
            }
        }
        return null;
    }

    public ProviderActionSlots getProviderActionSlots() {
        return this.mProviderActionSlots;
    }

    public ProviderAttributionSlots getProviderAttributionSlots() {
        return this.mProviderAttributionSlots;
    }

    public ProviderMediaSlots getProviderMediaSlots() {
        return this.mProviderMediaSlots;
    }

    @Override // com.tapsdk.tapad.internal.runtime.ViewRenderer
    public View getView(int i) {
        return this.mViewHandles.get(i);
    }

    @Override // com.tapsdk.tapad.internal.runtime.ViewRenderer
    public int getViewByID(String str) {
        View view = this.mViewIds.get(str);
        if (view == null) {
            return -1;
        }
        for (int i = 0; i < this.mViewHandles.size(); i++) {
            if (this.mViewHandles.valueAt(i) == view) {
                return this.mViewHandles.keyAt(i);
            }
        }
        return -1;
    }

    public boolean hasActiveWindowFocus() {
        for (int i = 0; i < this.mPopups.size(); i++) {
            DialogInfo dialogInfoValueAt = this.mPopups.valueAt(i);
            if (dialogInfoValueAt != null && hasDialogWindowFocus(dialogInfoValueAt.dialog)) {
                return true;
            }
        }
        for (int i2 = 0; i2 < this.mOverlays.size(); i2++) {
            OverlayInfo overlayInfoValueAt = this.mOverlays.valueAt(i2);
            if (overlayInfoValueAt != null && hasDialogWindowFocus(overlayInfoValueAt.dialog)) {
                return true;
            }
        }
        return hasViewWindowFocus(this.mRootView);
    }

    public boolean hasOverlayForTesting(int i) {
        return this.mOverlays.get(i) != null;
    }

    @Override // com.tapsdk.tapad.internal.runtime.ViewRenderer
    public void hideView(int i) {
        View view = this.mViewHandles.get(i);
        if (view != null) {
            view.setVisibility(8);
            ProviderModalLayerOrder providerModalLayerOrder = this.mProviderModalLayerOrder;
            if (providerModalLayerOrder != null) {
                providerModalLayerOrder.reconcile();
            }
            this.mProviderActionSlots.onVisibilityChanged(view);
            suspendImages(view);
        }
    }

    public boolean isImageLoadDeferredForTesting(int i) {
        return isImageLoadDeferred(i);
    }

    public boolean isImageLoadStartedForTesting(int i) {
        ImageBinding imageBinding = this.mImageBindings.get(i);
        return (imageBinding == null || imageBinding.request == null) ? false : true;
    }

    /* JADX INFO: renamed from: lambda$overlayShow$8$com-tapsdk-tapad-internal-runtime-plugin-DefaultViewRenderer, reason: not valid java name */
    /* synthetic */ void m290lambda$overlayShow$8$comtapsdktapadinternalruntimepluginDefaultViewRenderer(OverlayInfo overlayInfo, Dialog dialog, DialogInterface dialogInterface) {
        if (overlayInfo.dialog != dialog) {
            return;
        }
        if (!overlayInfo.programmaticDismiss && overlayInfo.dismissCb >= 0) {
            DirichletRuntime.getInstance().triggerOverlayDismiss(overlayInfo.dismissCb, overlayInfo.overlayId, overlayInfo.dismissReason);
        }
        overlayInfo.dialog = null;
        overlayInfo.content = -1;
        if (this.mOverlays.get(overlayInfo.overlayId) == overlayInfo) {
            this.mOverlays.remove(overlayInfo.overlayId);
        }
    }

    /* JADX INFO: renamed from: lambda$popupShow$5$com-tapsdk-tapad-internal-runtime-plugin-DefaultViewRenderer, reason: not valid java name */
    /* synthetic */ void m291lambda$popupShow$5$comtapsdktapadinternalruntimepluginDefaultViewRenderer(DialogInfo dialogInfo, DialogInterface dialogInterface) {
        if (this.mPopups.get(dialogInfo.content) != dialogInfo) {
            return;
        }
        if (!dialogInfo.programmaticDismiss && dialogInfo.dismissCb >= 0) {
            DirichletRuntime.getInstance().triggerCallback(dialogInfo.dismissCb, "{}");
        }
        this.mPopups.remove(dialogInfo.content);
    }

    /* JADX INFO: renamed from: lambda$popupShow$6$com-tapsdk-tapad-internal-runtime-plugin-DefaultViewRenderer, reason: not valid java name */
    /* synthetic */ void m292lambda$popupShow$6$comtapsdktapadinternalruntimepluginDefaultViewRenderer(int i, int i2, View view, View view2, int i3, int i4, int i5, int i6, Window window, Dialog dialog) {
        view.measure(i > 0 ? View.MeasureSpec.makeMeasureSpec(i, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0), i2 > 0 ? View.MeasureSpec.makeMeasureSpec(i2, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int width = view2.getWidth();
        int[] iArr = new int[2];
        view2.getLocationOnScreen(iArr);
        float f = view2.getResources().getDisplayMetrics().density;
        int iMax = iArr[0] + Math.max(0, Math.min(((int) ((i3 / 10.0f) * f)) - (measuredWidth / 2), width - measuredWidth));
        int i7 = (iArr[1] + ((int) ((i4 / 10.0f) * f))) - measuredHeight;
        window.setGravity(51);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = iMax;
        attributes.y = i7;
        attributes.width = measuredWidth;
        attributes.height = measuredHeight;
        window.setAttributes(attributes);
        try {
            dialog.show();
        } catch (Exception e) {
            e.getMessage();
            this.mPopups.remove(i6);
        }
    }

    /* JADX INFO: renamed from: lambda$setStyle$2$com-tapsdk-tapad-internal-runtime-plugin-DefaultViewRenderer, reason: not valid java name */
    /* synthetic */ void m293lambda$setStyle$2$comtapsdktapadinternalruntimepluginDefaultViewRenderer(int i) {
        this.mRuntime.triggerCallback(i, "{}");
    }

    /* JADX INFO: renamed from: lambda$showPositionedOverlay$9$com-tapsdk-tapad-internal-runtime-plugin-DefaultViewRenderer, reason: not valid java name */
    /* synthetic */ void m294lambda$showPositionedOverlay$9$comtapsdktapadinternalruntimepluginDefaultViewRenderer(OverlayInfo overlayInfo, int i, int i2, View view, View view2, Window window) {
        int iMax;
        int i3;
        if (this.mOverlays.get(overlayInfo.overlayId) != overlayInfo) {
            return;
        }
        view.measure(i > 0 ? View.MeasureSpec.makeMeasureSpec(i, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0), i2 > 0 ? View.MeasureSpec.makeMeasureSpec(i2, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int[] iArr = {0, 0};
        view2.getLocationOnScreen(iArr);
        OverlayConfig overlayConfig = overlayInfo.config;
        float f = overlayConfig.xDp10 / 10.0f;
        float f2 = this.mDensity;
        int i4 = (int) (f * f2);
        int i5 = (int) ((overlayConfig.yDp10 / 10.0f) * f2);
        if ("screen".equals(overlayConfig.coordinateSpace)) {
            iMax = i4 - (measuredWidth / 2);
            i3 = i5 - measuredHeight;
        } else {
            iMax = iArr[0] + Math.max(0, Math.min(i4 - (measuredWidth / 2), view2.getWidth() - measuredWidth));
            i3 = (iArr[1] + i5) - measuredHeight;
        }
        if ("below_touch_center".equals(overlayInfo.config.placement)) {
            i3 += measuredHeight;
        }
        window.setGravity(51);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 51;
        attributes.x = iMax;
        attributes.y = i3;
        attributes.width = measuredWidth;
        attributes.height = measuredHeight;
        window.setAttributes(attributes);
        try {
            overlayInfo.dialog.show();
        } catch (Throwable th) {
            this.mOverlays.remove(overlayInfo.overlayId);
        }
    }

    /* JADX INFO: renamed from: lambda$startBannerTrainEnterAnimation$18$com-tapsdk-tapad-internal-runtime-plugin-DefaultViewRenderer, reason: not valid java name */
    /* synthetic */ void m295lambda$startBannerTrainEnterAnimation$18$comtapsdktapadinternalruntimepluginDefaultViewRenderer(String str, final View view, boolean z) {
        if (str.equals(view.getTag(R.id.tapad_dirichlet_named_animation_tag))) {
            Object parent = view.getParent();
            if (parent instanceof View) {
                float width = ((View) parent).getWidth();
                if (width <= 0.0f) {
                    width = view.getResources().getDisplayMetrics().widthPixels;
                }
                float fDp2px = dp2px(54.0f);
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_X, width + (z ? 0.0f : fDp2px), z ? -fDp2px : 0.0f);
                objectAnimatorOfFloat.setStartDelay(300L);
                objectAnimatorOfFloat.setDuration(1000L);
                objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f);
                objectAnimatorOfFloat2.setStartDelay(300L);
                objectAnimatorOfFloat2.setDuration(1L);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
                animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.tapsdk.tapad.internal.runtime.plugin.DefaultViewRenderer.3
                    private boolean canceled;

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        this.canceled = true;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (this.canceled) {
                            return;
                        }
                        view.setTranslationX(0.0f);
                        view.setAlpha(1.0f);
                    }
                });
                view.setTag(R.id.tapad_dirichlet_breathing_animator_tag, animatorSet);
                animatorSet.start();
            }
        }
    }

    @Override // com.tapsdk.tapad.internal.runtime.ViewRenderer
    public float[] measureText(String str, float f, float f2, boolean z) {
        if (str == null || str.isEmpty()) {
            return new float[]{0.0f, 0.0f};
        }
        float fApplyDimension = TypedValue.applyDimension(2, f, this.mContext.getResources().getDisplayMetrics());
        this.mMeasurePaint.density = this.mContext.getResources().getDisplayMetrics().density;
        this.mMeasurePaint.setTextSize(fApplyDimension);
        this.mMeasurePaint.setTypeface(z ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
        float fMax = 0.0f;
        int iMax = Math.max(1, Math.min((int) Math.ceil(Layout.getDesiredWidth(str, this.mMeasurePaint)), f2 > 0.0f ? dp2px(f2) : Integer.MAX_VALUE));
        int i = Build.VERSION.SDK_INT;
        StaticLayout staticLayoutBuild = i >= 28 ? StaticLayout.Builder.obtain(str, 0, str.length(), this.mMeasurePaint, iMax).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(0.0f, 1.0f).setIncludePad(false).setUseLineSpacingFromFallbacks(true).build() : i >= 23 ? StaticLayout.Builder.obtain(str, 0, str.length(), this.mMeasurePaint, iMax).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(0.0f, 1.0f).setIncludePad(false).build() : new StaticLayout(str, this.mMeasurePaint, iMax, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        for (int i2 = 0; i2 < staticLayoutBuild.getLineCount(); i2++) {
            fMax = Math.max(fMax, staticLayoutBuild.getLineWidth(i2));
        }
        int lineBottom = staticLayoutBuild.getLineBottom(staticLayoutBuild.getLineCount() - 1);
        float f3 = this.mDensity;
        return new float[]{fMax / f3, lineBottom / f3};
    }

    @Override // com.tapsdk.tapad.internal.runtime.ViewRenderer
    public void overlayCreate(int i, String str, int i2) {
        if (i <= 0) {
            return;
        }
        if (this.mOverlays.get(i) != null) {
            overlayDestroy(i);
        }
        this.mOverlays.put(i, new OverlayInfo(i, OverlayConfig.parse(str), i2));
    }

    @Override // com.tapsdk.tapad.internal.runtime.ViewRenderer
    public void overlayDestroy(int i) {
        OverlayInfo overlayInfo = this.mOverlays.get(i);
        if (overlayInfo == null) {
            return;
        }
        overlayInfo.programmaticDismiss = true;
        Dialog dialog = overlayInfo.dialog;
        if (dialog != null && dialog.isShowing()) {
            overlayInfo.dialog.dismiss();
        }
        this.mOverlays.remove(i);
    }

    @Override // com.tapsdk.tapad.internal.runtime.ViewRenderer
    public void overlayDestroyAll() {
        for (int size = this.mOverlays.size() - 1; size >= 0; size--) {
            overlayDestroy(this.mOverlays.keyAt(size));
        }
    }

    public Dialog overlayDialogForTesting(int i) {
        OverlayInfo overlayInfo = this.mOverlays.get(i);
        if (overlayInfo != null) {
            return overlayInfo.dialog;
        }
        return null;
    }

    @Override // com.tapsdk.tapad.internal.runtime.ViewRenderer
    public void overlayDismiss(int i, int i2) {
        OverlayInfo overlayInfo = this.mOverlays.get(i);
        if (overlayInfo == null) {
            return;
        }
        overlayInfo.programmaticDismiss = true;
        overlayInfo.dismissReason = i2;
        if (overlayInfo.dismissCb >= 0) {
            DirichletRuntime.getInstance().triggerOverlayDismiss(overlayInfo.dismissCb, i, i2);
        }
        Dialog dialog = overlayInfo.dialog;
        if (dialog != null && dialog.isShowing()) {
            overlayInfo.dialog.dismiss();
        }
        this.mOverlays.remove(i);
    }

    @Override // com.tapsdk.tapad.internal.runtime.ViewRenderer
    public void overlayShow(int i, int i2, int i3) {
        View view;
        int i4;
        int i5;
        final OverlayInfo overlayInfo = this.mOverlays.get(i);
        if (overlayInfo == null || (view = this.mViewHandles.get(i3)) == null) {
            return;
        }
        releaseOverlayDialogWindow(overlayInfo);
        if (view.getParent() instanceof ViewGroup) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int i6 = (layoutParams == null || (i5 = layoutParams.width) <= 0) ? -2 : i5;
        int i7 = (layoutParams == null || (i4 = layoutParams.height) <= 0) ? -2 : i4;
        final Dialog dialog = new Dialog(this.mContext, R.style.tapad_dirichlet_full_screen_dialog);
        overlayInfo.dialog = dialog;
        overlayInfo.content = i3;
        overlayInfo.programmaticDismiss = false;
        overlayInfo.dismissReason = 1;
        dialog.setContentView(view, new ViewGroup.LayoutParams(i6, i7));
        dialog.setCanceledOnTouchOutside(overlayInfo.config.outsideCancelable);
        dialog.setCancelable(overlayInfo.config.backCancelable);
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tapsdk.tapad.internal.runtime.plugin.DefaultViewRenderer$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                DefaultViewRenderer.OverlayInfo overlayInfo2 = overlayInfo;
                overlayInfo2.dismissReason = overlayInfo2.config.outsideCancelable ? 2 : 1;
            }
        });
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tapsdk.tapad.internal.runtime.plugin.DefaultViewRenderer$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f$0.m290lambda$overlayShow$8$comtapsdktapadinternalruntimepluginDefaultViewRenderer(overlayInfo, dialog, dialogInterface);
            }
        });
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        if ("positioned".equals(overlayInfo.config.presentation)) {
            showPositionedOverlay(overlayInfo, i2, view, i6, i7, window);
            return;
        }
        applyOverlayWindow(window, overlayInfo.config, i2, i6, i7);
        try {
            dialog.show();
            consumeDialogInsets(window);
            if ("fullscreen".equals(overlayInfo.config.presentation)) {
                window.setLayout(-1, -1);
            }
        } catch (Throwable th) {
            this.mOverlays.remove(i);
        }
    }

    @Override // com.tapsdk.tapad.internal.runtime.ViewRenderer
    public void overlayUpdate(int i, String str) {
        OverlayInfo overlayInfo = this.mOverlays.get(i);
        if (overlayInfo == null) {
            return;
        }
        overlayInfo.config = OverlayConfig.parse(str);
        Dialog dialog = overlayInfo.dialog;
        if (dialog == null || dialog.getWindow() == null) {
            return;
        }
        applyOverlayWindow(overlayInfo.dialog.getWindow(), overlayInfo.config, -1, -2, -2);
    }

    public void pauseWebCreatives() {
        for (int i = 0; i < this.mViewHandles.size(); i++) {
            View viewValueAt = this.mViewHandles.valueAt(i);
            if (viewValueAt instanceof DirichletCreativeView) {
                ((DirichletCreativeView) viewValueAt).onHostPause();
            }
        }
    }

    @Override // com.tapsdk.tapad.internal.runtime.ViewRenderer
    public void popupDismiss(int i) {
        DialogInfo dialogInfo = this.mPopups.get(i);
        if (dialogInfo == null || !dialogInfo.dialog.isShowing()) {
            return;
        }
        dialogInfo.programmaticDismiss = true;
        dialogInfo.dialog.dismiss();
    }

    @Override // com.tapsdk.tapad.internal.runtime.ViewRenderer
    public void popupShow(final int i, final int i2, int i3, final int i4, final int i5) {
        final int i6;
        int i7;
        final View view = this.mViewHandles.get(i);
        final View view2 = this.mViewHandles.get(i2);
        if (view == null || view2 == null) {
            return;
        }
        releasePopupDialogForContent(i2);
        if (view2.getParent() instanceof ViewGroup) {
            ((ViewGroup) view2.getParent()).removeView(view2);
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams == null || (i6 = layoutParams.width) <= 0) {
            i6 = -2;
        }
        final int i8 = (layoutParams == null || (i7 = layoutParams.height) <= 0) ? -2 : i7;
        final Dialog dialog = new Dialog(this.mContext, R.style.tapad_dirichlet_full_screen_dialog);
        dialog.setContentView(view2, new ViewGroup.LayoutParams(i6, i8));
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(i3 >= 0);
        final DialogInfo dialogInfo = new DialogInfo(dialog, i2, i3);
        this.mPopups.put(i2, dialogInfo);
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tapsdk.tapad.internal.runtime.plugin.DefaultViewRenderer$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f$0.m291lambda$popupShow$5$comtapsdktapadinternalruntimepluginDefaultViewRenderer(dialogInfo, dialogInterface);
            }
        });
        final Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        configureDialogWindow(window);
        if (i4 >= 0) {
            window.addFlags(32);
            view.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.DefaultViewRenderer$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m292lambda$popupShow$6$comtapsdktapadinternalruntimepluginDefaultViewRenderer(i6, i8, view2, view, i4, i5, i, i2, window, dialog);
                }
            });
            return;
        }
        window.setLayout(-1, -1);
        try {
            dialog.show();
            consumeDialogInsets(window);
            window.setLayout(-1, -1);
        } catch (Exception e) {
            e.getMessage();
            this.mPopups.remove(i2);
        }
    }

    @Override // com.tapsdk.tapad.internal.runtime.ViewRenderer
    public float queryView(int i, int i2) {
        if (i2 < 0 || i2 >= 7) {
            return 0.0f;
        }
        float[] fArr = new float[7];
        queryViewAll(i, fArr);
        return fArr[i2];
    }

    @Override // com.tapsdk.tapad.internal.runtime.ViewRenderer
    public void queryViewAll(int i, float[] fArr) {
        int i2;
        int i3;
        if (fArr == null || fArr.length < 7) {
            return;
        }
        int i4 = 0;
        while (true) {
            if (i4 >= 7) {
                break;
            }
            fArr[i4] = 0.0f;
            i4++;
        }
        View view = this.mViewHandles.get(i);
        if (view == null) {
            return;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        Rect rect = new Rect();
        boolean z = view.isShown() && view.getVisibility() == 0 && width > 0 && height > 0 && view.getGlobalVisibleRect(rect);
        Rect rect2 = new Rect();
        try {
            WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
            if (windowManager == null || windowManager.getDefaultDisplay() == null) {
                i2 = 0;
                i3 = 0;
            } else {
                windowManager.getDefaultDisplay().getRectSize(rect2);
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                i2 = displayMetrics.widthPixels;
                try {
                    i3 = displayMetrics.heightPixels;
                } catch (Exception e) {
                    i3 = 0;
                }
            }
        } catch (Exception e2) {
            i2 = 0;
        }
        if (z && !rect2.isEmpty() && !rect.intersect(rect2)) {
            z = false;
        }
        float fMax = z ? Math.max(0, rect.width()) : 0;
        float fMax2 = z ? Math.max(0, rect.height()) : 0;
        float f = fMax * fMax2;
        float f2 = width;
        float f3 = height;
        float f4 = f2 * f3;
        if (i2 <= 0 || i3 <= 0) {
            DisplayMetrics displayMetrics2 = this.mContext.getResources().getDisplayMetrics();
            int i5 = displayMetrics2.widthPixels;
            i3 = displayMetrics2.heightPixels;
            i2 = i5;
        }
        float f5 = i2 * i3;
        fArr[0] = f2;
        fArr[1] = f3;
        fArr[2] = fMax;
        fArr[3] = fMax2;
        fArr[4] = f4 > 0.0f ? (f * 100.0f) / f4 : 0.0f;
        fArr[5] = f5 > 0.0f ? (f * 100.0f) / f5 : 0.0f;
        fArr[6] = z ? 1.0f : 0.0f;
    }

    @Override // com.tapsdk.tapad.internal.runtime.ViewRenderer
    public void removeChild(int i, int i2) {
        View view = this.mViewHandles.get(i);
        View view2 = this.mViewHandles.get(i2);
        if (!(view instanceof ViewGroup) || view2 == null) {
            return;
        }
        ((ViewGroup) view).removeView(view2);
        suspendImages(view2);
        ProviderModalLayerOrder providerModalLayerOrder = this.mProviderModalLayerOrder;
        if (providerModalLayerOrder != null) {
            providerModalLayerOrder.reconcile();
        }
    }

    public void resumeWebCreatives() {
        for (int i = 0; i < this.mViewHandles.size(); i++) {
            View viewValueAt = this.mViewHandles.valueAt(i);
            if (viewValueAt instanceof DirichletCreativeView) {
                ((DirichletCreativeView) viewValueAt).onHostResume();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0049 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:19:0x004b A[Catch: Exception -> 0x008b, TryCatch #0 {Exception -> 0x008b, blocks: (B:9:0x0025, B:11:0x002c, B:13:0x0032, B:17:0x0045, B:23:0x0059, B:28:0x0069, B:32:0x006f, B:34:0x0085, B:26:0x0064, B:19:0x004b, B:21:0x0051), top: B:40:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x0051 A[Catch: Exception -> 0x008b, TryCatch #0 {Exception -> 0x008b, blocks: (B:9:0x0025, B:11:0x002c, B:13:0x0032, B:17:0x0045, B:23:0x0059, B:28:0x0069, B:32:0x006f, B:34:0x0085, B:26:0x0064, B:19:0x004b, B:21:0x0051), top: B:40:0x0025 }] */
    @Override // com.tapsdk.tapad.internal.runtime.ViewRenderer
    public void setImage(int i, String str) {
        float f;
        View view = this.mViewHandles.get(i);
        ViewInfo viewInfo = this.mViewInfos.get(i);
        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            boolean z = true;
            clearImageBinding(i, imageView, true);
            if (str == null || str.isEmpty()) {
                imageView.invalidate();
                return;
            }
            try {
                MechanicalImageLoader.Options.Builder builder = MechanicalImageLoader.Options.builder();
                if (viewInfo != null) {
                    float f2 = viewInfo.blurRadius;
                    if (f2 > 0.0f) {
                        int iMax = Math.max(1, Math.min(25, Math.round(f2)));
                        builder.blur(iMax, iMax >= 25 ? 4 : 1);
                    } else if (viewInfo != null) {
                        f = viewInfo.cornerRadius;
                        if (f > 0.0f) {
                            builder.cornerRadiusPx(dp2px(f));
                        }
                    }
                } else if (viewInfo != null) {
                    f = viewInfo.cornerRadius;
                    if (f > 0.0f) {
                        builder.cornerRadiusPx(dp2px(f));
                    }
                }
                MechanicalImageLoader.Options optionsBuild = builder.build();
                int i2 = viewInfo == null ? -1 : viewInfo.imageOnReady;
                if (viewInfo == null || !viewInfo.preloadImage) {
                    z = false;
                }
                ImageBinding imageBinding = new ImageBinding(i, imageView, str, optionsBuild, i2, z);
                this.mImageBindings.put(i, imageBinding);
                imageBinding.bind();
                if (isImageLoadDeferred(i)) {
                    traceImageVisibility("visibility_defer", i, str);
                }
            } catch (Exception e) {
            }
        }
    }

    @Override // com.tapsdk.tapad.internal.runtime.ViewRenderer
    public void setLayout(int i, float f, float f2, float f3, float f4) {
        View view = this.mViewHandles.get(i);
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f3 <= 0.0f ? -1 : dp2px(f3), f4 > 0.0f ? dp2px(f4) : -1);
            layoutParams.leftMargin = dp2px(f);
            layoutParams.topMargin = dp2px(f2);
            view.setLayoutParams(layoutParams);
        }
    }

    @Override // com.tapsdk.tapad.internal.runtime.ViewRenderer
    public void setOnClick(int i, final Runnable runnable) {
        View view = this.mViewHandles.get(i);
        if (view != null) {
            if (runnable != null) {
                view.setClickable(true);
                view.setFocusable(true);
                view.setImportantForAccessibility(0);
                view.setOnClickListener(new View.OnClickListener() { // from class: com.tapsdk.tapad.internal.runtime.plugin.DefaultViewRenderer$$ExternalSyntheticLambda7
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        DefaultViewRenderer.lambda$setOnClick$3(runnable, view2);
                    }
                });
                return;
            }
            view.setOnClickListener(null);
            ViewInfo viewInfo = this.mViewInfos.get(i);
            boolean z = viewInfo != null && viewInfo.inputBarrier;
            view.setClickable(z);
            view.setFocusable(false);
            view.setImportantForAccessibility(z ? 2 : 0);
        }
    }

    @Override // com.tapsdk.tapad.internal.runtime.ViewRenderer
    public void setOnTouch(int i, ViewRenderer.TouchCallback touchCallback) {
        setOnTouch(i, touchCallback, 0);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:204:0x02c4  */
    /* JADX WARN: Code duplicated, block: B:408:0x059d  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.tapsdk.tapad.internal.runtime.ViewRenderer
    public void setStyle(int i, String str, String str2) {
        byte b;
        int i2;
        View view = this.mViewHandles.get(i);
        ViewInfo viewInfo = this.mViewInfos.get(i);
        int i3 = this.mViewTypes.get(i, -1);
        if (view == 0) {
            return;
        }
        if (view instanceof RewardExitGuardNativeSurface) {
            RewardExitGuardNativeSurface rewardExitGuardNativeSurface = (RewardExitGuardNativeSurface) view;
            if ("exitGuardSnapshot".equals(str)) {
                rewardExitGuardNativeSurface.renderExitGuardPayload(str2);
            } else if ("exitGuardCallbackToken".equals(str)) {
                final int callbackToken = parseCallbackToken(str2);
                rewardExitGuardNativeSurface.setExitGuardClickAction(callbackToken >= 0 ? new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.DefaultViewRenderer$$ExternalSyntheticLambda12
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m293lambda$setStyle$2$comtapsdktapadinternalruntimepluginDefaultViewRenderer(callbackToken);
                    }
                } : null);
                return;
            }
        }
        if (viewInfo == null) {
            viewInfo = new ViewInfo();
            this.mViewInfos.put(i, viewInfo);
        }
        if (str.startsWith("animate:")) {
            applyPropertyAnimation(view, str.substring(8), str2);
            return;
        }
        int i4 = 2;
        boolean z = true;
        switch (str.hashCode()) {
            case -1929738004:
                if (!str.equals("providerAttributionSlot")) {
                    b = -1;
                } else {
                    b = 0;
                }
                break;
            case -1877911644:
                if (!str.equals("scaleType")) {
                    b = -1;
                } else {
                    b = 1;
                }
                break;
            case -1724158635:
                if (!str.equals("transition")) {
                    b = -1;
                } else {
                    b = 2;
                }
                break;
            case -1609594047:
                if (!str.equals("enabled")) {
                    b = -1;
                } else {
                    b = 3;
                }
                break;
            case -1604936949:
                if (!str.equals("exitGuardSnapshot")) {
                    b = -1;
                } else {
                    b = 4;
                }
                break;
            case -1570830997:
                if (!str.equals("transitionMotion")) {
                    b = -1;
                } else {
                    b = 5;
                }
                break;
            case -1463054684:
                if (!str.equals("modalLayer")) {
                    b = -1;
                } else {
                    b = 6;
                }
                break;
            case -1428201511:
                if (!str.equals("blurRadius")) {
                    b = -1;
                } else {
                    b = 7;
                }
                break;
            case -1221029593:
                if (!str.equals("height")) {
                    b = -1;
                } else {
                    b = 8;
                }
                break;
            case -1138606139:
                if (!str.equals("borderRadiusTopRight")) {
                    b = -1;
                } else {
                    b = 9;
                }
                break;
            case -1073431728:
                if (!str.equals("borderRadiusBottomLeft")) {
                    b = -1;
                } else {
                    b = 10;
                }
                break;
            case -1048676502:
                if (!str.equals("webCreativeMediaMuted")) {
                    b = -1;
                } else {
                    b = 11;
                }
                break;
            case -987906986:
                if (!str.equals("pivotX")) {
                    b = -1;
                } else {
                    b = 12;
                }
                break;
            case -987906985:
                if (!str.equals("pivotY")) {
                    b = -1;
                } else {
                    b = cc.k;
                }
                break;
            case -934437708:
                if (!str.equals("resize")) {
                    b = -1;
                } else {
                    b = cc.l;
                }
                break;
            case -908189618:
                if (!str.equals("scaleX")) {
                    b = -1;
                } else {
                    b = cc.m;
                }
                break;
            case -908189617:
                if (!str.equals("scaleY")) {
                    b = -1;
                } else {
                    b = cc.n;
                }
                break;
            case -892765235:
                if (!str.equals("exitGuardCallbackToken")) {
                    b = -1;
                } else {
                    b = 17;
                }
                break;
            case -806339567:
                if (!str.equals("padding")) {
                    b = -1;
                } else {
                    b = 18;
                }
                break;
            case -740003543:
                if (!str.equals("imageOnReady")) {
                    b = -1;
                } else {
                    b = 19;
                }
                break;
            case -554281187:
                if (!str.equals("relayout")) {
                    b = -1;
                } else {
                    b = 20;
                }
                break;
            case -198712601:
                if (!str.equals("debugDump")) {
                    b = -1;
                } else {
                    b = 21;
                }
                break;
            case -40300674:
                if (!str.equals("rotation")) {
                    b = -1;
                } else {
                    b = 22;
                }
                break;
            case 89650992:
                if (!str.equals("gradient")) {
                    b = -1;
                } else {
                    b = 23;
                }
                break;
            case 92909918:
                if (!str.equals("alpha")) {
                    b = -1;
                } else {
                    b = 24;
                }
                break;
            case 109250890:
                if (!str.equals("scale")) {
                    b = -1;
                } else {
                    b = 25;
                }
                break;
            case 113126854:
                if (!str.equals("width")) {
                    b = -1;
                } else {
                    b = 26;
                }
                break;
            case 132869317:
                if (!str.equals("webCreativePackageConfig")) {
                    b = -1;
                } else {
                    b = 27;
                }
                break;
            case 301795127:
                if (!str.equals("appIconLayer")) {
                    b = -1;
                } else {
                    b = 28;
                }
                break;
            case 547785484:
                if (!str.equals("debugKey")) {
                    b = -1;
                } else {
                    b = 29;
                }
                break;
            case 582710545:
                if (!str.equals("providerMediaSlot")) {
                    b = -1;
                } else {
                    b = 30;
                }
                break;
            case 653225101:
                if (!str.equals("inputBarrier")) {
                    b = -1;
                } else {
                    b = 31;
                }
                break;
            case 722830999:
                if (!str.equals("borderColor")) {
                    b = -1;
                } else {
                    b = 32;
                }
                break;
            case 741115130:
                if (!str.equals("borderWidth")) {
                    b = -1;
                } else {
                    b = 33;
                }
                break;
            case 807451173:
                if (!str.equals("providerActionSlot")) {
                    b = -1;
                } else {
                    b = 34;
                }
                break;
            case 1071466814:
                if (!str.equals("borderRadiusTopLeft")) {
                    b = -1;
                } else {
                    b = 35;
                }
                break;
            case 1072404439:
                if (!str.equals("clipToOutline")) {
                    b = -1;
                } else {
                    b = 36;
                }
                break;
            case 1089015795:
                if (!str.equals("borderRadiusBottomRight")) {
                    b = -1;
                } else {
                    b = 37;
                }
                break;
            case 1090721135:
                if (!str.equals("clipChildren")) {
                    b = -1;
                } else {
                    b = 38;
                }
                break;
            case 1118509956:
                if (!str.equals("animation")) {
                    b = -1;
                } else {
                    b = 39;
                }
                break;
            case 1287124693:
                if (!str.equals("backgroundColor")) {
                    b = -1;
                } else {
                    b = 40;
                }
                break;
            case 1349188574:
                if (!str.equals("borderRadius")) {
                    b = -1;
                } else {
                    b = 41;
                }
                break;
            case 1575890881:
                if (!str.equals("interactionOwner")) {
                    b = -1;
                } else {
                    b = 42;
                }
                break;
            case 1579395282:
                if (!str.equals("preloadImage")) {
                    b = -1;
                } else {
                    b = 43;
                }
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                if ((view instanceof ViewGroup) && ("1".equals(str2) || Boolean.parseBoolean(str2))) {
                    view.setTag(R.id.tapad_dirichlet_provider_attribution_slot_tag, Boolean.TRUE);
                    this.mProviderAttributionSlots.register((ViewGroup) view);
                } else {
                    view.setTag(R.id.tapad_dirichlet_provider_attribution_slot_tag, null);
                    this.mProviderAttributionSlots.unregister(view);
                }
                break;
            case 1:
                viewInfo.scaleType = str2;
                applyScaleType(view, str2);
                break;
            case 2:
                applyTransitionStyle(view, str2);
                break;
            case 3:
                if (!"1".equals(str2) && !Boolean.parseBoolean(str2)) {
                    z = false;
                }
                view.setEnabled(z);
                break;
            case 4:
            case 17:
            case 28:
                break;
            case 5:
                view.setTag(R.id.tapad_dirichlet_transition_motion_tag, str2);
                break;
            case 6:
                if (!"1".equals(str2) && !Boolean.parseBoolean(str2)) {
                    z = false;
                }
                viewInfo.modalLayer = z;
                ProviderModalLayerOrder providerModalLayerOrder = this.mProviderModalLayerOrder;
                if (providerModalLayerOrder != null) {
                    providerModalLayerOrder.register(view, z);
                }
                break;
            case 7:
                viewInfo.blurRadius = parseFiniteFloatOrDefault(str2, 0.0f);
                break;
            case 8:
            case 26:
                applySizeComponent(view, str, str2);
                break;
            case 9:
                viewInfo.cornerRadiusTopRight = parseFiniteFloatOrDefault(str2, -1.0f);
                updateBackground(view, viewInfo);
                break;
            case 10:
                viewInfo.cornerRadiusBottomLeft = parseFiniteFloatOrDefault(str2, -1.0f);
                updateBackground(view, viewInfo);
                break;
            case 11:
                if (view instanceof DirichletCreativeView) {
                    ((DirichletCreativeView) view).setWebMediaMuted(Boolean.parseBoolean(str2));
                }
                break;
            case 12:
                view.setPivotX(dp2px(parseFiniteFloatOrDefault(str2, 0.0f)));
                break;
            case 13:
                view.setPivotY(dp2px(parseFiniteFloatOrDefault(str2, 0.0f)));
                break;
            case 14:
                applyResize(view, str2);
                break;
            case 15:
                view.setScaleX(parseFiniteFloatOrDefault(str2, 1.0f));
                break;
            case 16:
                view.setScaleY(parseFiniteFloatOrDefault(str2, 1.0f));
                break;
            case 18:
                applyPadding(view, str2);
                break;
            case 19:
                viewInfo.imageOnReady = parseCallbackToken(str2);
                ImageBinding imageBinding = this.mImageBindings.get(i);
                if (imageBinding != null) {
                    imageBinding.onReadyCallback = viewInfo.imageOnReady;
                }
                break;
            case 20:
                applyRelayout(view, str2);
                break;
            case 21:
                logDebugDump(i, str2);
                break;
            case 22:
                view.setRotation(parseFiniteFloatOrDefault(str2, 0.0f));
                break;
            case 23:
                parseGradient(str2, viewInfo);
                updateBackground(view, viewInfo);
                break;
            case 24:
                view.setAlpha(parseFiniteFloatOrDefault(str2, 1.0f));
                break;
            case 25:
                float finiteFloatOrDefault = parseFiniteFloatOrDefault(str2, 1.0f);
                view.setScaleX(finiteFloatOrDefault);
                view.setScaleY(finiteFloatOrDefault);
                break;
            case 27:
                if (view instanceof DirichletCreativeView) {
                    ((DirichletCreativeView) view).setPackageConfig(str2);
                }
                break;
            case 29:
                view.setTag(R.id.tapad_dirichlet_debug_key_tag, str2);
                break;
            case 30:
                if ("1".equals(str2) || Boolean.parseBoolean(str2)) {
                    view.setTag(R.id.tapad_dirichlet_provider_media_slot_tag, Boolean.TRUE);
                    this.mProviderMediaSlots.register(view);
                } else {
                    view.setTag(R.id.tapad_dirichlet_provider_media_slot_tag, null);
                    this.mProviderMediaSlots.unregister(view);
                }
                break;
            case 31:
                if (!"1".equals(str2) && !Boolean.parseBoolean(str2)) {
                    z = false;
                }
                viewInfo.inputBarrier = z;
                if (!view.hasOnClickListeners()) {
                    view.setClickable(viewInfo.inputBarrier);
                    view.setFocusable(false);
                    view.setImportantForAccessibility(viewInfo.inputBarrier ? 2 : 0);
                }
                break;
            case 32:
                viewInfo.borderColor = parseColor(str2);
                updateBackground(view, viewInfo);
                break;
            case 33:
                viewInfo.borderWidth = parseFiniteFloatOrDefault(str2, 0.0f);
                updateBackground(view, viewInfo);
                break;
            case 34:
                if (str2 == null || str2.isEmpty() || "0".equals(str2) || "false".equalsIgnoreCase(str2)) {
                    view.setTag(R.id.tapad_dirichlet_provider_action_slot_tag, null);
                    view.setTag(R.id.tapad_dirichlet_provider_action_role_tag, null);
                    view.setTag(R.id.tapad_dirichlet_provider_action_callback_tag, null);
                    this.mProviderActionSlots.unregister(view);
                } else {
                    String[] strArrSplit = str2.split(":", 2);
                    String str3 = strArrSplit.length > 0 ? strArrSplit[0] : ProviderInteractionViews.ROLE_CREATIVE;
                    if (strArrSplit.length > 1) {
                        try {
                            i2 = Integer.parseInt(strArrSplit[1]);
                        } catch (NumberFormatException e) {
                            i2 = -1;
                        }
                    } else {
                        i2 = -1;
                    }
                    view.setTag(R.id.tapad_dirichlet_provider_action_slot_tag, Boolean.TRUE);
                    view.setTag(R.id.tapad_dirichlet_provider_action_role_tag, str3);
                    view.setTag(R.id.tapad_dirichlet_provider_action_callback_tag, Integer.valueOf(i2));
                    this.mProviderActionSlots.register(view);
                }
                break;
            case 35:
                viewInfo.cornerRadiusTopLeft = parseFiniteFloatOrDefault(str2, -1.0f);
                updateBackground(view, viewInfo);
                break;
            case 36:
                if (!"true".equals(str2) && !"1".equals(str2)) {
                    z = false;
                }
                view.setClipToOutline(z);
                break;
            case 37:
                viewInfo.cornerRadiusBottomRight = parseFiniteFloatOrDefault(str2, -1.0f);
                updateBackground(view, viewInfo);
                break;
            case 38:
                if (!"true".equals(str2) && !"1".equals(str2)) {
                    z = false;
                }
                viewInfo.clipChildren = z;
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    viewGroup.setClipChildren(z);
                    viewGroup.setClipToPadding(viewInfo.clipChildren);
                }
                break;
            case 39:
                applyNamedAnimation(view, str2);
                break;
            case 40:
                viewInfo.backgroundColor = parseColor(str2);
                updateBackground(view, viewInfo);
                break;
            case 41:
                viewInfo.cornerRadius = parseFiniteFloatOrDefault(str2, 0.0f);
                updateBackground(view, viewInfo);
                break;
            case 42:
                view.setTag(R.id.tapad_dirichlet_core_action_tag, "core".equals(str2) ? Boolean.TRUE : 0);
                break;
            case 43:
                if (!"1".equals(str2) && !Boolean.parseBoolean(str2)) {
                    z = false;
                }
                viewInfo.preloadImage = z;
                ImageBinding imageBinding2 = this.mImageBindings.get(i);
                if (imageBinding2 != null) {
                    boolean z2 = viewInfo.preloadImage;
                    imageBinding2.preload = z2;
                    if (z2) {
                        startImageIfEligible(i);
                    } else if (!isEffectivelyVisible(view)) {
                        suspendImages(view);
                    }
                }
                break;
            default:
                if (view instanceof DirichletLottieView) {
                    DirichletLottieView dirichletLottieView = (DirichletLottieView) view;
                    switch (str.hashCode()) {
                        case -1287102942:
                            if (!str.equals("lottieAutoplay")) {
                                i4 = -1;
                            } else {
                                i4 = 0;
                            }
                            break;
                        case 467886819:
                            if (!str.equals("lottieLoop")) {
                                i4 = -1;
                            } else {
                                i4 = 1;
                            }
                            break;
                        case 567224044:
                            if (!str.equals("lottieProgress")) {
                                i4 = -1;
                            }
                            break;
                        case 1539122512:
                            if (!str.equals("lottieUrl")) {
                                i4 = -1;
                            } else {
                                i4 = 3;
                            }
                            break;
                        case 1626074088:
                            if (!str.equals("lottieSpeed")) {
                                i4 = -1;
                            } else {
                                i4 = 4;
                            }
                            break;
                        default:
                            i4 = -1;
                            break;
                    }
                    try {
                        switch (i4) {
                            case 0:
                                if (!"true".equals(str2) && !"1".equals(str2)) {
                                    z = false;
                                }
                                dirichletLottieView.setAutoplay(z);
                                break;
                            case 1:
                                if (!"true".equals(str2) && !"1".equals(str2)) {
                                    z = false;
                                }
                                dirichletLottieView.setLooping(z);
                                break;
                            case 2:
                                dirichletLottieView.setProgress(Float.parseFloat(str2));
                                break;
                            case 3:
                                dirichletLottieView.setUrl(str2);
                                break;
                            case 4:
                                dirichletLottieView.setSpeed(Float.parseFloat(str2));
                                break;
                        }
                    } catch (NumberFormatException e2) {
                        return;
                    }
                }
                if (i3 >= 0) {
                    delegateSetStyle(view, i3, str, str2);
                }
                break;
        }
    }

    @Override // com.tapsdk.tapad.internal.runtime.ViewRenderer
    public void setText(int i, String str) {
        View view = this.mViewHandles.get(i);
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (textView.getTag(R.id.tapad_dirichlet_drawable_left_tag) != null) {
                this.mTextManager.applyTextWithDrawable(textView, str);
            } else {
                textView.setText(str);
            }
        }
    }

    @Override // com.tapsdk.tapad.internal.runtime.ViewRenderer
    public void showView(int i) {
        View view = this.mViewHandles.get(i);
        if (view != null) {
            view.setVisibility(0);
            this.mProviderActionSlots.onVisibilityChanged(view);
            ViewInfo viewInfo = this.mViewInfos.get(i);
            if (viewInfo != null && viewInfo.modalLayer) {
                raiseRendererModalBranch(view);
            }
            ProviderModalLayerOrder providerModalLayerOrder = this.mProviderModalLayerOrder;
            if (providerModalLayerOrder != null) {
                providerModalLayerOrder.reconcile();
            }
            activateVisibleImages(view);
        }
    }

    public DefaultViewRenderer(Context context, ViewGroup viewGroup, DirichletRuntime dirichletRuntime, int i, int i2) {
        this.mViewHandles = new SparseArray<>();
        this.mViewInfos = new SparseArray<>();
        this.mViewTypes = new SparseIntArray();
        this.mMountedNativeViews = new SparseArray<>();
        this.mImageBindings = new SparseArray<>();
        this.mViewIds = new HashMap();
        this.mHandleGenerator = new AtomicInteger(1);
        this.mProviderMediaSlots = new ProviderMediaSlots();
        this.mProviderActionSlots = new ProviderActionSlots();
        this.mProviderAttributionSlots = new ProviderAttributionSlots();
        this.mRunningAnimators = new HashMap();
        this.mMeasurePaint = new TextPaint(1);
        this.mPopups = new SparseArray<>();
        this.mOverlays = new SparseArray<>();
        this.mContext = context;
        this.mRootView = viewGroup;
        this.mDensity = context.getResources().getDisplayMetrics().density;
        this.mRuntime = dirichletRuntime;
        this.mInstanceId = i;
        this.mSurfaceId = i2;
        ContainerViewManager containerViewManager = new ContainerViewManager(context);
        this.mContainerManager = containerViewManager;
        TextViewManager textViewManager = new TextViewManager(context);
        this.mTextManager = textViewManager;
        ImageViewManager imageViewManager = new ImageViewManager(context);
        this.mImageManager = imageViewManager;
        VideoContainerViewManager videoContainerViewManager = new VideoContainerViewManager(context);
        this.mVideoManager = videoContainerViewManager;
        LinearContainerViewManager linearContainerViewManager = new LinearContainerViewManager(context);
        this.mLinearManager = linearContainerViewManager;
        CanvasViewManager canvasViewManager = new CanvasViewManager();
        this.mCanvasManager = canvasViewManager;
        ViewManagerRegistry viewManagerRegistry = ViewManagerRegistry.getInstance();
        viewManagerRegistry.register(containerViewManager);
        viewManagerRegistry.register(textViewManager);
        viewManagerRegistry.register(imageViewManager);
        viewManagerRegistry.register(videoContainerViewManager);
        viewManagerRegistry.register(linearContainerViewManager);
        viewManagerRegistry.register(canvasViewManager);
    }

    @Override // com.tapsdk.tapad.internal.runtime.ViewRenderer
    public void setOnTouch(int i, final ViewRenderer.TouchCallback touchCallback, int i2) {
        View view = this.mViewHandles.get(i);
        if (view != null) {
            if (touchCallback == null) {
                view.setOnTouchListener(null);
                return;
            }
            final int scaledTouchSlop = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            final boolean z = i2 == 1;
            final float[] fArr = {0.0f, 0.0f};
            final boolean[] zArr = {false};
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.tapsdk.tapad.internal.runtime.plugin.DefaultViewRenderer$$ExternalSyntheticLambda13
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    return DefaultViewRenderer.lambda$setOnTouch$4(fArr, zArr, scaledTouchSlop, touchCallback, z, view2, motionEvent);
                }
            });
        }
    }
}
