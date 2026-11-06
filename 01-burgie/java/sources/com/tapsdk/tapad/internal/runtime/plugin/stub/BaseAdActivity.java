package com.tapsdk.tapad.internal.runtime.plugin.stub;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.DisplayCutout;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.window.OnBackInvokedCallback;
import com.byazt.ewn.AbsServerManager;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.tapsdk.tapad.constants.Constants;
import com.tapsdk.tapad.internal.AdType;
import com.tapsdk.tapad.internal.IoniaPlaybackSource;
import com.tapsdk.tapad.internal.ionia.IoniaIdentityManager;
import com.tapsdk.tapad.internal.runtime.DirichletRuntime;
import com.tapsdk.tapad.internal.runtime.SurfaceSession;
import com.tapsdk.tapad.internal.runtime.WasmModule;
import com.tapsdk.tapad.internal.runtime.fallback.AndroidFallbackPlatform;
import com.tapsdk.tapad.internal.runtime.fallback.AndroidFallbackViewRenderer;
import com.tapsdk.tapad.internal.runtime.fallback.FallbackPresentationController;
import com.tapsdk.tapad.internal.runtime.plugin.AdCallbackListener;
import com.tapsdk.tapad.internal.runtime.plugin.DefaultViewRenderer;
import com.tapsdk.tapad.internal.runtime.plugin.ProviderActionSlots;
import com.tapsdk.tapad.internal.runtime.plugin.ProviderInteractionViews;
import com.tapsdk.tapad.internal.runtime.plugin.SurfaceWindowFocus;
import com.tapsdk.tapad.internal.runtime.plugin.WebViewDialogFragment;
import com.tapsdk.tapad.internal.runtime.plugin.utils.SystemBarUtils;
import com.tapsdk.tapad.model.entities.DynamicHeader;
import com.taptap.sdk.compliance.constants.BundleKey;
import com.taptap.sdk.db.biz.iap.lib2plus.BillingClientConstants;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseAdActivity extends Activity implements SurfaceSession.CallbackHandler {
    public static final String EXTRA_INSTANCE_ID = "instance_id";
    public static final String EXTRA_SURFACE_ID = "surface_id";
    private static final int MAX_VIEWPORT_READY_ATTEMPTS = 120;
    private static final float SAFE_AREA_EPSILON_DP = 0.5f;
    private static final String TAG = "BaseAdActivity";
    private static final long VIEWPORT_READY_RETRY_MS = 16;
    private static final int VIEWPORT_READY_STABLE_FRAMES = 2;
    private static final long VIEWPORT_RESIZE_DEBOUNCE_MS = 64;
    private static final int VIEWPORT_SIZE_EPSILON_PX = 2;
    private Object mAdImpl;
    private Object mBackInvokedCallback;
    private AdCallbackListener mCallbackListener;
    protected FrameLayout mContainer;
    private boolean mCorePresentationCommitted;
    private boolean mCoreRuntimeFailed;
    private FallbackPresentationController mFallbackController;
    private byte[] mFallbackDisplaySnapshot;
    private boolean mFallbackTakeoverStarted;
    private boolean mFallbackTerminalDelivered;
    private boolean mHasRenderedSurface;
    private boolean mIoniaPlaybackWindowOpen;
    private WasmModule mModule;
    private ProviderActionSlots mProviderActionSlots;
    private ProviderActionSlots.Listener mProviderActionSlotsListener;
    private boolean mProviderActionUpdateScheduled;
    private boolean mProviderSurfaceBound;
    private ProviderInteractionViews mRegisteredProviderInteractionViews;
    private int mRenderGeneration;
    private boolean mRenderScheduled;
    protected DefaultViewRenderer mRenderer;
    private boolean mSurfaceRenderEntry;
    private Runnable mSurfaceRenderInvoke;
    private boolean mSurfaceStarted;
    private SurfaceWindowFocus mSurfaceWindowFocus;
    protected int mSurfaceId = -1;
    protected int mInstanceId = -1;
    private String mWasmFunction = "ad_render";
    private AdActivityConfig mConfig = new AdActivityConfig();
    private int mLastRenderedWidthPx = -1;
    private int mLastRenderedHeightPx = -1;
    private float[] mLastRenderedSafeAreaDp = null;
    private final Runnable mViewportResizeRender = new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.stub.BaseAdActivity$$ExternalSyntheticLambda13
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.m322lambda$new$0$comtapsdktapadinternalruntimepluginstubBaseAdActivity();
        }
    };
    private final Runnable mProviderActionUpdate = new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.stub.BaseAdActivity$$ExternalSyntheticLambda14
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.refreshProviderActionViews();
        }
    };
    private final View.OnLayoutChangeListener mViewportLayoutListener = new View.OnLayoutChangeListener() { // from class: com.tapsdk.tapad.internal.runtime.plugin.stub.BaseAdActivity$$ExternalSyntheticLambda15
        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.f$0.m323lambda$new$1$comtapsdktapadinternalruntimepluginstubBaseAdActivity(view, i, i2, i3, i4, i5, i6, i7, i8);
        }
    };

    public static class AdActivityConfig {
        public boolean hideStatusBar = true;
        public boolean hideNavigationBar = true;
        public boolean enableNotchSupport = true;
        public boolean keepScreenOn = true;
        public int statusBarColor = ViewCompat.MEASURED_STATE_MASK;
        public int navigationBarColor = ViewCompat.MEASURED_STATE_MASK;
        public int containerBackgroundColor = ViewCompat.MEASURED_STATE_MASK;
        public AdType adType = null;
        public String surfaceKind = null;

        public static AdActivityConfig fullscreenDefault() {
            AdActivityConfig adActivityConfig = new AdActivityConfig();
            adActivityConfig.hideStatusBar = true;
            adActivityConfig.hideNavigationBar = true;
            adActivityConfig.containerBackgroundColor = ViewCompat.MEASURED_STATE_MASK;
            return adActivityConfig;
        }

        public static AdActivityConfig interstitialDefault() {
            AdActivityConfig adActivityConfig = new AdActivityConfig();
            adActivityConfig.hideStatusBar = true;
            adActivityConfig.hideNavigationBar = true;
            adActivityConfig.containerBackgroundColor = 0;
            return adActivityConfig;
        }

        public AdActivityConfig setContainerBackgroundColor(int i) {
            this.containerBackgroundColor = i;
            return this;
        }

        public AdActivityConfig setEnableNotchSupport(boolean z) {
            this.enableNotchSupport = z;
            return this;
        }

        public AdActivityConfig setHideNavigationBar(boolean z) {
            this.hideNavigationBar = z;
            return this;
        }

        public AdActivityConfig setHideStatusBar(boolean z) {
            this.hideStatusBar = z;
            return this;
        }

        public AdActivityConfig setKeepScreenOn(boolean z) {
            this.keepScreenOn = z;
            return this;
        }

        public AdActivityConfig setNavigationBarColor(int i) {
            this.navigationBarColor = i;
            return this;
        }

        public AdActivityConfig setStatusBarColor(int i) {
            this.statusBarColor = i;
            return this;
        }
    }

    public static final class Api33BackCompat {
        private Api33BackCompat() {
        }

        public static Object register(Activity activity, final Runnable runnable) {
            Objects.requireNonNull(runnable);
            OnBackInvokedCallback onBackInvokedCallback = new OnBackInvokedCallback() { // from class: com.tapsdk.tapad.internal.runtime.plugin.stub.BaseAdActivity$Api33BackCompat$$ExternalSyntheticLambda0
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    runnable.run();
                }
            };
            activity.getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, onBackInvokedCallback);
            return onBackInvokedCallback;
        }

        public static void unregister(Activity activity, Object obj) {
            activity.getOnBackInvokedDispatcher().unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: beginFallbackTakeover, reason: merged with bridge method [inline-methods] */
    public void m318lambda$beginFallbackTakeover$7$comtapsdktapadinternalruntimepluginstubBaseAdActivity(final String str, final String str2) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            runOnUiThread(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.stub.BaseAdActivity$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m318lambda$beginFallbackTakeover$7$comtapsdktapadinternalruntimepluginstubBaseAdActivity(str, str2);
                }
            });
            return;
        }
        if (this.mFallbackTakeoverStarted || this.mFallbackTerminalDelivered || isSurfaceGone()) {
            return;
        }
        this.mCoreRuntimeFailed = true;
        if (this.mCorePresentationCommitted) {
            deliverFallbackTerminal(2, 0, str, "Core failed after presentation commit");
            return;
        }
        SurfaceSession live = DirichletRuntime.getInstance().surfaceSessions().getLive(this.mSurfaceId);
        byte[] bArrFallbackDisplaySpecCopy = live == null ? null : live.fallbackDisplaySpecCopy();
        if (bArrFallbackDisplaySpecCopy == null || bArrFallbackDisplaySpecCopy.length == 0 || this.mContainer == null) {
            deliverFallbackTerminal(2, 0, str, str2);
            return;
        }
        this.mFallbackTakeoverStarted = true;
        this.mFallbackDisplaySnapshot = bArrFallbackDisplaySpecCopy;
        dispatchFallbackLifecycle("onFallbackTakeoverStarted");
        DirichletRuntime dirichletRuntime = DirichletRuntime.getInstance();
        DefaultViewRenderer defaultViewRenderer = this.mRenderer;
        if (defaultViewRenderer != null) {
            stopObservingProviderActionSlots();
            dirichletRuntime.detachSurfaceRenderer(this.mSurfaceId, defaultViewRenderer);
            defaultViewRenderer.destroy();
            this.mRenderer = null;
        }
        this.mContainer.removeAllViews();
        try {
            FallbackPresentationController fallbackPresentationController = new FallbackPresentationController(this.mInstanceId, this.mSurfaceId, new AndroidFallbackViewRenderer(this.mContainer), new FallbackPresentationController.TerminalListener() { // from class: com.tapsdk.tapad.internal.runtime.plugin.stub.BaseAdActivity$$ExternalSyntheticLambda2
                @Override // com.tapsdk.tapad.internal.runtime.fallback.FallbackPresentationController.TerminalListener
                public final void onTerminal(FallbackPresentationController.TerminalResult terminalResult) {
                    this.f$0.m319lambda$beginFallbackTakeover$8$comtapsdktapadinternalruntimepluginstubBaseAdActivity(str, str2, terminalResult);
                }
            }, AndroidFallbackPlatform.systemClock(), AndroidFallbackPlatform.mainDispatcher(), AndroidFallbackPlatform.mainScheduler());
            this.mFallbackController = fallbackPresentationController;
            fallbackPresentationController.start(bArrFallbackDisplaySpecCopy);
        } catch (Throwable th) {
            deliverFallbackTerminal(2, 0, str, th.getClass().getSimpleName());
        }
    }

    private void bindProviderFullscreenSurface() {
        ViewGroup viewGroup;
        if (this.mProviderSurfaceBound) {
            return;
        }
        Object obj = this.mAdImpl;
        if (obj instanceof FullscreenProviderHost) {
            FullscreenProviderHost fullscreenProviderHost = (FullscreenProviderHost) obj;
            DefaultViewRenderer defaultViewRenderer = this.mRenderer;
            if (defaultViewRenderer == null || this.mContainer == null) {
                fullscreenProviderHost.onFullscreenSurfaceBindFailed("Provider renderer is unavailable");
                return;
            }
            boolean zEquals = MediationConstant.RIT_TYPE_INTERSTITIAL.equals(fullscreenProviderHost.providerSurfaceFormat());
            View viewFirstView = zEquals ? firstView(defaultViewRenderer, "interstitial.media.provider", "interstitial.media.image") : firstVisible(defaultViewRenderer.getProviderMediaSlots().snapshot());
            ViewParent parent = viewFirstView == null ? null : viewFirstView.getParent();
            if (viewFirstView instanceof ViewGroup) {
                viewGroup = (ViewGroup) viewFirstView;
            } else {
                viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            }
            if (viewGroup == null) {
                if (isCoreOwnedH5BrowseReward(defaultViewRenderer, zEquals)) {
                    this.mProviderSurfaceBound = true;
                    return;
                } else {
                    fullscreenProviderHost.onFullscreenSurfaceBindFailed("Provider media slot is unavailable");
                    return;
                }
            }
            ProviderActionSlots providerActionSlots = defaultViewRenderer.getProviderActionSlots();
            ProviderInteractionViews providerInteractionViewsBuildProviderInteractionViews = buildProviderInteractionViews(defaultViewRenderer, this.mContainer, viewFirstView, zEquals);
            View viewFirstVisible = firstVisible(providerInteractionViewsBuildProviderInteractionViews.getCreativeViews());
            Iterator<View> it = providerInteractionViewsBuildProviderInteractionViews.allViews().iterator();
            while (it.hasNext()) {
                ProviderInteractionOwnership.transfer(it.next());
            }
            try {
                fullscreenProviderHost.bindFullscreenSurface(this, this.mContainer, viewGroup, viewFirstVisible, providerInteractionViewsBuildProviderInteractionViews, defaultViewRenderer.getProviderAttributionSlots());
                this.mRegisteredProviderInteractionViews = providerInteractionViewsBuildProviderInteractionViews;
                this.mProviderSurfaceBound = true;
                observeProviderActionSlots(providerActionSlots);
            } catch (Throwable th) {
                fullscreenProviderHost.onFullscreenSurfaceBindFailed(th.getMessage() == null ? th.getClass().getSimpleName() : th.getMessage());
            }
        }
    }

    public static WebViewDialogFragment buildInternalWebViewDialog(JSONObject jSONObject, AdType adType, int i, int i2) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString(BreakpointSQLiteKey.URL, "");
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        String strOptString2 = jSONObject.optString(Constants.Bidding.REQUEST_ID, jSONObject.optString("requestId", ""));
        String strOptString3 = jSONObject.optString("track_id", jSONObject.optString("trackId", ""));
        int iOptInt = jSONObject.optInt("sessionId", -1);
        int iOptInt2 = jSONObject.optInt("instanceId", i);
        int iOptInt3 = jSONObject.optInt("surfaceId", i2);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("android_download");
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = jSONObject;
        }
        return WebViewDialogFragment.newInstance(strOptString, jSONObject.optString(BundleKey.TITLE, ""), strOptString2, strOptString3, jSONObject.optBoolean("track_landing", false), readDynamicHeaders(jSONObject.optJSONArray("landing_headers")), iOptInt, iOptInt2, iOptInt3, adType, jSONObjectOptJSONObject.optString("package_name", jSONObjectOptJSONObject.optString(BillingClientConstants.PACKAGE_NAME, "")), jSONObjectOptJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, jSONObjectOptJSONObject.optString("appName", "")), jSONObjectOptJSONObject.optString("apk_md5", jSONObjectOptJSONObject.optString("apkMd5", "")), jSONObjectOptJSONObject.has(com.tapsdk.tapad.group.constants.Constants.APK_SIZE_FIELD) ? jSONObjectOptJSONObject.optLong(com.tapsdk.tapad.group.constants.Constants.APK_SIZE_FIELD, -1L) : jSONObjectOptJSONObject.optLong("apkSize", -1L), jSONObjectOptJSONObject.has("apk_verify_type") ? jSONObjectOptJSONObject.optInt("apk_verify_type", -1) : jSONObjectOptJSONObject.optInt("apkVerifyType", -1));
    }

    public static ProviderInteractionViews buildProviderInteractionViews(DefaultViewRenderer defaultViewRenderer, View view, View view2, boolean z) {
        return defaultViewRenderer.getProviderActionSlots().snapshot(view);
    }

    private FrameLayout createActivityRoot() {
        Object obj = this.mAdImpl;
        if (obj instanceof FullscreenProviderHost) {
            try {
                FrameLayout frameLayoutCreateFullscreenRoot = ((FullscreenProviderHost) obj).createFullscreenRoot(this);
                if (frameLayoutCreateFullscreenRoot != null) {
                    return frameLayoutCreateFullscreenRoot;
                }
            } catch (Throwable th) {
            }
        }
        return new FrameLayout(this);
    }

    private void debounceViewportResizeRender() {
        FrameLayout frameLayout = this.mContainer;
        if (frameLayout == null || !this.mSurfaceRenderEntry) {
            return;
        }
        frameLayout.removeCallbacks(this.mViewportResizeRender);
        this.mContainer.postDelayed(this.mViewportResizeRender, 64L);
    }

    private void deliverFallbackTerminal(int i, int i2, String str, String str2) {
        if (this.mFallbackTerminalDelivered) {
            return;
        }
        this.mFallbackTerminalDelivered = true;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("outcome", i);
            jSONObject.put("terminal_reason", i2);
            if (str == null) {
                str = "";
            }
            jSONObject.put("fault_kind", str);
            if (str2 == null) {
                str2 = "";
            }
            jSONObject.put("detail", str2);
            if (DirichletRuntime.getInstance().dispatchSurfaceCallback(this.mSurfaceId, "onFallbackTerminal", jSONObject.toString())) {
                return;
            }
            finish();
        } catch (Throwable th) {
            finish();
        }
    }

    private void dispatchFallbackLifecycle(String str) {
        if (this.mFallbackTerminalDelivered) {
            return;
        }
        DirichletRuntime.getInstance().dispatchSurfaceCallback(this.mSurfaceId, str, "{}");
    }

    private void dispatchUnifiedEvent(Runnable runnable) {
        if (!this.mCoreRuntimeFailed && hasUnifiedDispatch() && DirichletRuntime.getInstance().isInstanceLive(this.mInstanceId)) {
            runnable.run();
        }
    }

    public static void enableEdgeToEdge(Window window) {
        if (window == null) {
            return;
        }
        try {
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                window.setDecorFitsSystemWindows(false);
            }
            if (i >= 28) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.layoutInDisplayCutoutMode = i >= 30 ? 3 : 1;
                window.setAttributes(attributes);
            }
        } catch (Exception e) {
        }
    }

    private boolean expectsLandscapeSurface() {
        AdActivityConfig adActivityConfig = this.mConfig;
        String str = adActivityConfig != null ? adActivityConfig.surfaceKind : null;
        if (TextUtils.isEmpty(str)) {
            return (this instanceof LandscapeActivity) || (this instanceof LandscapeTranslucentActivity);
        }
        return str.toUpperCase(Locale.US).contains("LANDSCAPE");
    }

    private boolean expectsPortraitSurface() {
        AdActivityConfig adActivityConfig = this.mConfig;
        String str = adActivityConfig != null ? adActivityConfig.surfaceKind : null;
        if (TextUtils.isEmpty(str)) {
            return (this instanceof PortraitActivity) || (this instanceof PortraitTranslucentActivity);
        }
        return str.toUpperCase(Locale.US).contains("PORTRAIT");
    }

    private void failSurfaceRender(String str) {
        m318lambda$beginFallbackTakeover$7$comtapsdktapadinternalruntimepluginstubBaseAdActivity("viewport_unavailable", str);
    }

    public static void finishActivitiesForInstance(int i) {
        if (i < 0) {
            return;
        }
        DirichletRuntime.getInstance().surfaceSessions().finishSurfacesForInstance(i);
    }

    private static View firstView(DefaultViewRenderer defaultViewRenderer, String... strArr) {
        for (String str : strArr) {
            View viewFindViewByDebugKey = defaultViewRenderer.findViewByDebugKey(str);
            if (viewFindViewByDebugKey != null) {
                return viewFindViewByDebugKey;
            }
        }
        return null;
    }

    private static View firstVisible(List<View> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (View view : list) {
            if (view != null && view.getVisibility() == 0) {
                return view;
            }
        }
        return list.get(0);
    }

    private float[] getSafeAreaDp() {
        float f;
        float fMax;
        float fMax2;
        float fMax3;
        WindowInsets rootWindowInsets;
        float f2 = getResources().getDisplayMetrics().density;
        float fMax4 = 0.0f;
        try {
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                WindowInsets windowInsets = getWindowManager().getCurrentWindowMetrics().getWindowInsets();
                AdActivityConfig adActivityConfig = this.mConfig;
                float[] safeAreaDp = toSafeAreaDp(windowInsets, f2, adActivityConfig.hideStatusBar, adActivityConfig.hideNavigationBar);
                fMax3 = Math.max(0.0f, safeAreaDp[0]);
                try {
                    fMax = Math.max(0.0f, safeAreaDp[1]);
                    try {
                        fMax2 = Math.max(0.0f, safeAreaDp[2]);
                        try {
                            fMax4 = Math.max(0.0f, safeAreaDp[3]);
                        } catch (Exception e) {
                            f = fMax4;
                            fMax4 = fMax3;
                            fMax3 = fMax4;
                            fMax4 = f;
                            return new float[]{fMax3, fMax, fMax2, fMax4};
                        }
                    } catch (Exception e2) {
                        f = 0.0f;
                        fMax2 = 0.0f;
                        fMax4 = fMax3;
                        fMax3 = fMax4;
                        fMax4 = f;
                        return new float[]{fMax3, fMax, fMax2, fMax4};
                    }
                } catch (Exception e3) {
                    f = 0.0f;
                    fMax = 0.0f;
                    fMax2 = 0.0f;
                }
            } else {
                fMax3 = 0.0f;
                fMax = 0.0f;
                fMax2 = 0.0f;
            }
            if (i >= 23 && (rootWindowInsets = getWindow().getDecorView().getRootWindowInsets()) != null) {
                AdActivityConfig adActivityConfig2 = this.mConfig;
                float[] safeAreaDp2 = toSafeAreaDp(rootWindowInsets, f2, adActivityConfig2.hideStatusBar, adActivityConfig2.hideNavigationBar);
                float fMax5 = Math.max(fMax3, safeAreaDp2[0]);
                try {
                    float fMax6 = Math.max(fMax, safeAreaDp2[1]);
                    try {
                        float fMax7 = Math.max(fMax2, safeAreaDp2[2]);
                        try {
                            fMax4 = Math.max(fMax4, safeAreaDp2[3]);
                            fMax = fMax6;
                            fMax2 = fMax7;
                            fMax3 = fMax5;
                        } catch (Exception e4) {
                            f = fMax4;
                            fMax4 = fMax5;
                            fMax = fMax6;
                            fMax2 = fMax7;
                            fMax3 = fMax4;
                            fMax4 = f;
                        }
                    } catch (Exception e5) {
                        f = fMax4;
                        fMax4 = fMax5;
                        fMax = fMax6;
                    }
                } catch (Exception e6) {
                    f = fMax4;
                    fMax4 = fMax5;
                }
            }
        } catch (Exception e7) {
            f = 0.0f;
            fMax = 0.0f;
            fMax2 = 0.0f;
        }
        return new float[]{fMax3, fMax, fMax2, fMax4};
    }

    private float[] getViewportSizeDp() {
        float f = getResources().getDisplayMetrics().density;
        FrameLayout frameLayout = this.mContainer;
        int width = frameLayout != null ? frameLayout.getWidth() : 0;
        FrameLayout frameLayout2 = this.mContainer;
        int height = frameLayout2 != null ? frameLayout2.getHeight() : 0;
        if (width <= 0 || height <= 0) {
            if (Build.VERSION.SDK_INT >= 30) {
                Rect bounds = getWindowManager().getCurrentWindowMetrics().getBounds();
                int iWidth = bounds.width();
                height = bounds.height();
                width = iWidth;
            } else {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
                float f2 = displayMetrics.density;
                int i = displayMetrics.widthPixels;
                height = displayMetrics.heightPixels;
                f = f2;
                width = i;
            }
        }
        return new float[]{width / f, height / f};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleBackRequest() {
        FallbackPresentationController fallbackPresentationController = this.mFallbackController;
        if (fallbackPresentationController != null) {
            fallbackPresentationController.close();
        }
    }

    private void handleOrientationForOreoTranslucentActivity() {
        if (Build.VERSION.SDK_INT != 26) {
            return;
        }
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            ActivityInfo activityInfo = (ActivityInfo) declaredField.get(this);
            if (activityInfo != null && activityInfo.screenOrientation != -1) {
                activityInfo.screenOrientation = -1;
            }
            declaredField.setAccessible(false);
        } catch (Exception e) {
        }
    }

    private boolean hasRenderedViewportChanged(int i, int i2, float[] fArr) {
        if (Math.abs(i - this.mLastRenderedWidthPx) >= 2 || Math.abs(i2 - this.mLastRenderedHeightPx) >= 2) {
            return true;
        }
        return !safeAreaEquals(fArr, this.mLastRenderedSafeAreaDp);
    }

    private boolean hasUnifiedDispatch() {
        WasmModule wasmModule = this.mModule;
        return wasmModule != null && wasmModule.hasFunction("wasm_dispatch_envelope");
    }

    private static String intentToJson(Intent intent) {
        JSONObject jSONObject = new JSONObject();
        if (intent == null) {
            return jSONObject.toString();
        }
        try {
            putJson(jSONObject, "action", intent.getAction());
            putJson(jSONObject, "type", intent.getType());
            putJson(jSONObject, AbsServerManager.PACKAGE_QUERY_BINDER, intent.getPackage());
            if (intent.getData() != null) {
                putJson(jSONObject, "data", intent.getData().toString());
            }
            if (intent.getExtras() != null) {
                jSONObject.put("hasExtras", true);
            }
        } catch (Throwable th) {
        }
        return jSONObject.toString();
    }

    private String ioniaTriggerCorrelationId() {
        return ((IoniaPlaybackSource) this.mAdImpl).ioniaTriggerCorrelationId();
    }

    private String ioniaWindowKey() {
        return ((IoniaPlaybackSource) this.mAdImpl).ioniaWindowKey();
    }

    public static boolean isCoreOwnedH5BrowseReward(DefaultViewRenderer defaultViewRenderer, boolean z) {
        return (z || defaultViewRenderer == null || defaultViewRenderer.findViewByDebugKey("reward.h5_browse.webview") == null) ? false : true;
    }

    private boolean isIoniaPlaybackSurface() {
        return this.mAdImpl instanceof IoniaPlaybackSource;
    }

    private boolean isViewportReadyForRender(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return false;
        }
        if (expectsLandscapeSurface()) {
            return i > i2;
        }
        return !expectsPortraitSurface() || i2 >= i;
    }

    private void notifyIoniaPlaybackClose() {
        if (this.mIoniaPlaybackWindowOpen && isIoniaPlaybackSurface()) {
            IoniaIdentityManager.getInstance().onAdPlaybackCloseAsync(ioniaWindowKey(), ioniaTriggerCorrelationId());
            this.mIoniaPlaybackWindowOpen = false;
        }
    }

    private void notifyIoniaPlaybackShow() {
        if (!isIoniaPlaybackSurface() || this.mIoniaPlaybackWindowOpen) {
            return;
        }
        IoniaIdentityManager.getInstance().onAdPlaybackShowAsync(ioniaWindowKey(), ioniaTriggerCorrelationId());
        this.mIoniaPlaybackWindowOpen = true;
    }

    private void observeProviderActionSlots(ProviderActionSlots providerActionSlots) {
        stopObservingProviderActionSlots();
        if (providerActionSlots == null) {
            return;
        }
        this.mProviderActionSlots = providerActionSlots;
        ProviderActionSlots.Listener listener = new ProviderActionSlots.Listener() { // from class: com.tapsdk.tapad.internal.runtime.plugin.stub.BaseAdActivity$$ExternalSyntheticLambda11
            @Override // com.tapsdk.tapad.internal.runtime.plugin.ProviderActionSlots.Listener
            public final void onSlotsChanged(List list) {
                this.f$0.m324lambda$observeProviderActionSlots$11$comtapsdktapadinternalruntimepluginstubBaseAdActivity(list);
            }
        };
        this.mProviderActionSlotsListener = listener;
        providerActionSlots.addListener(listener);
    }

    private static String permissionsToJson(String[] strArr, int[] iArr) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        int length = strArr != null ? strArr.length : 0;
        int i = 0;
        while (i < length) {
            JSONObject jSONObject2 = new JSONObject();
            int i2 = (iArr == null || i >= iArr.length) ? -1 : iArr[i];
            try {
                jSONObject2.put("permission", strArr[i]);
                jSONObject2.put("grantResult", i2);
                jSONObject2.put("granted", i2 == 0);
                jSONArray.put(jSONObject2);
            } catch (Throwable th) {
            }
            i++;
        }
        try {
            jSONObject.put("permissions", jSONArray);
        } catch (Throwable th2) {
        }
        return jSONObject.toString();
    }

    private static void putJson(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (str2 != null) {
            jSONObject.put(str, str2);
        }
    }

    private static List<DynamicHeader> readDynamicHeaders(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("valueList");
                ArrayList arrayList2 = new ArrayList(jSONArrayOptJSONArray != null ? jSONArrayOptJSONArray.length() : 0);
                if (jSONArrayOptJSONArray != null) {
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        Object objOpt = jSONArrayOptJSONArray.opt(i2);
                        if (objOpt instanceof String) {
                            arrayList2.add((String) objOpt);
                        }
                    }
                }
                arrayList.add(new DynamicHeader(jSONObjectOptJSONObject.optString(Common.System.NAME, ""), arrayList2, jSONObjectOptJSONObject.optInt("mode", 0)));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshProviderActionViews() {
        this.mProviderActionUpdateScheduled = false;
        ProviderActionSlots providerActionSlots = this.mProviderActionSlots;
        if (!this.mProviderSurfaceBound || providerActionSlots == null || !(this.mAdImpl instanceof FullscreenProviderHost) || isSurfaceGone()) {
            return;
        }
        FullscreenProviderHost fullscreenProviderHost = (FullscreenProviderHost) this.mAdImpl;
        boolean zEquals = MediationConstant.RIT_TYPE_INTERSTITIAL.equals(fullscreenProviderHost.providerSurfaceFormat());
        ProviderInteractionViews providerInteractionViewsBuildProviderInteractionViews = buildProviderInteractionViews(this.mRenderer, this.mContainer, zEquals ? firstView(this.mRenderer, "interstitial.media.provider", "interstitial.media.image") : firstVisible(this.mRenderer.getProviderMediaSlots().snapshot()), zEquals);
        if (providerInteractionViewsBuildProviderInteractionViews.sameViews(this.mRegisteredProviderInteractionViews)) {
            return;
        }
        Iterator<View> it = providerInteractionViewsBuildProviderInteractionViews.allViews().iterator();
        while (it.hasNext()) {
            ProviderInteractionOwnership.transfer(it.next());
        }
        try {
            if (fullscreenProviderHost.updateFullscreenInteractionViews(providerInteractionViewsBuildProviderInteractionViews)) {
                this.mRegisteredProviderInteractionViews = providerInteractionViewsBuildProviderInteractionViews;
            }
            providerInteractionViewsBuildProviderInteractionViews.allViews().size();
        } catch (Throwable th) {
        }
    }

    private void registerBackInvokedCallback() {
        if (Build.VERSION.SDK_INT < 33 || this.mBackInvokedCallback != null) {
            return;
        }
        this.mBackInvokedCallback = Api33BackCompat.register(this, new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.stub.BaseAdActivity$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.handleBackRequest();
            }
        });
    }

    private void requestSurfaceRender(String str) {
        if (this.mContainer == null || this.mSurfaceRenderInvoke == null || isSurfaceGone()) {
            return;
        }
        if (this.mHasRenderedSurface) {
            int width = this.mContainer.getWidth();
            int height = this.mContainer.getHeight();
            if (!isViewportReadyForRender(width, height) || !hasRenderedViewportChanged(width, height, getSafeAreaDp())) {
                return;
            }
        }
        if (this.mRenderScheduled) {
            return;
        }
        scheduleRenderWhenViewportReady(this.mSurfaceRenderInvoke, str);
    }

    private boolean safeAreaEquals(float[] fArr, float[] fArr2) {
        if (fArr == fArr2) {
            return true;
        }
        if (fArr == null || fArr2 == null || fArr.length < 4 || fArr2.length < 4) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (Math.abs(fArr[i] - fArr2[i]) > SAFE_AREA_EPSILON_DP) {
                return false;
            }
        }
        return true;
    }

    private void scheduleProviderActionUpdate() {
        FrameLayout frameLayout;
        if (!this.mProviderSurfaceBound || this.mProviderActionUpdateScheduled || !(this.mAdImpl instanceof FullscreenProviderHost) || (frameLayout = this.mContainer) == null) {
            return;
        }
        this.mProviderActionUpdateScheduled = true;
        frameLayout.post(this.mProviderActionUpdate);
    }

    private void scheduleRenderWhenViewportReady(final Runnable runnable, final String str) {
        if (this.mContainer == null || runnable == null) {
            return;
        }
        this.mRenderScheduled = true;
        final int i = this.mRenderGeneration + 1;
        this.mRenderGeneration = i;
        final int[] iArr = {0};
        final int[] iArr2 = {0};
        final int[] iArr3 = {-1};
        final int[] iArr4 = {-1};
        final float[][] fArr = {null};
        final Runnable[] runnableArr = new Runnable[1];
        runnableArr[0] = new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.stub.BaseAdActivity$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m329lambda$scheduleRenderWhenViewportReady$5$comtapsdktapadinternalruntimepluginstubBaseAdActivity(i, iArr3, iArr4, fArr, iArr2, str, runnable, iArr, runnableArr);
            }
        };
        getWindow().getDecorView().post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.stub.BaseAdActivity$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m330lambda$scheduleRenderWhenViewportReady$6$comtapsdktapadinternalruntimepluginstubBaseAdActivity(runnableArr);
            }
        });
    }

    private void stopObservingProviderActionSlots() {
        FrameLayout frameLayout = this.mContainer;
        if (frameLayout != null) {
            frameLayout.removeCallbacks(this.mProviderActionUpdate);
        }
        this.mProviderActionUpdateScheduled = false;
        ProviderActionSlots providerActionSlots = this.mProviderActionSlots;
        ProviderActionSlots.Listener listener = this.mProviderActionSlotsListener;
        if (providerActionSlots != null && listener != null) {
            providerActionSlots.removeListener(listener);
        }
        this.mProviderActionSlots = null;
        this.mProviderActionSlotsListener = null;
        this.mRegisteredProviderInteractionViews = null;
    }

    public static float[] toSafeAreaDp(WindowInsets windowInsets, float f, boolean z, boolean z2) {
        float fMax;
        float fMax2;
        float fMax3;
        DisplayCutout displayCutout;
        if (windowInsets == null) {
            return new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            int iDisplayCutout = WindowInsets.Type.displayCutout() | WindowInsets.Type.captionBar();
            if (!z) {
                iDisplayCutout |= WindowInsets.Type.statusBars();
            }
            if (!z2) {
                iDisplayCutout |= WindowInsets.Type.navigationBars();
            }
            Insets insets = windowInsets.getInsets(iDisplayCutout);
            return new float[]{insets.top / f, insets.right / f, insets.bottom / f, insets.left / f};
        }
        float fMax4 = 0.0f;
        if (i < 28 || (displayCutout = windowInsets.getDisplayCutout()) == null) {
            fMax = 0.0f;
            fMax2 = 0.0f;
            fMax3 = 0.0f;
        } else {
            fMax4 = displayCutout.getSafeInsetTop() / f;
            fMax2 = displayCutout.getSafeInsetRight() / f;
            fMax3 = displayCutout.getSafeInsetBottom() / f;
            fMax = displayCutout.getSafeInsetLeft() / f;
        }
        if (!z) {
            fMax4 = Math.max(fMax4, windowInsets.getSystemWindowInsetTop() / f);
        }
        if (!z2) {
            fMax2 = Math.max(fMax2, windowInsets.getSystemWindowInsetRight() / f);
            fMax3 = Math.max(fMax3, windowInsets.getSystemWindowInsetBottom() / f);
            fMax = Math.max(fMax, windowInsets.getSystemWindowInsetLeft() / f);
        }
        return new float[]{fMax4, fMax2, fMax3, fMax};
    }

    private void unregisterBackInvokedCallback() {
        Object obj;
        if (Build.VERSION.SDK_INT < 33 || (obj = this.mBackInvokedCallback) == null) {
            return;
        }
        Api33BackCompat.unregister(this, obj);
        this.mBackInvokedCallback = null;
    }

    public void applySystemBarConfig() {
        AdActivityConfig adActivityConfig = this.mConfig;
        boolean z = adActivityConfig.hideStatusBar;
        if (z && adActivityConfig.hideNavigationBar) {
            if (isTranslucentWindow()) {
                SystemBarUtils.setupTranslucentAdActivity(this, this.mConfig.enableNotchSupport);
                return;
            } else {
                SystemBarUtils.setupFullscreenAdActivity(this, this.mConfig.enableNotchSupport, false);
                return;
            }
        }
        if (z) {
            SystemBarUtils.hideStatusBar(this, adActivityConfig.enableNotchSupport);
            AdActivityConfig adActivityConfig2 = this.mConfig;
            if (adActivityConfig2.hideNavigationBar) {
                return;
            }
            SystemBarUtils.setNavigationBarColor(this, adActivityConfig2.navigationBarColor);
            return;
        }
        if (adActivityConfig.hideNavigationBar) {
            SystemBarUtils.hideNavigationBar(this, adActivityConfig.enableNotchSupport);
            SystemBarUtils.setStatusBarColor(this, this.mConfig.statusBarColor);
        } else {
            SystemBarUtils.setStatusBarColor(this, adActivityConfig.statusBarColor);
            SystemBarUtils.setNavigationBarColor(this, this.mConfig.navigationBarColor);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mIoniaPlaybackWindowOpen && isIoniaPlaybackSurface()) {
            IoniaIdentityManager.getInstance().recordAdPlaybackMotionEventAsync(ioniaWindowKey(), ioniaTriggerCorrelationId(), motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.tapsdk.tapad.internal.runtime.SurfaceSession.CallbackHandler
    public void finishSurface() {
        runOnUiThread(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.stub.BaseAdActivity$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m320lambda$finishSurface$10$comtapsdktapadinternalruntimepluginstubBaseAdActivity();
            }
        });
    }

    public int getContainerBackgroundColor() {
        return this.mConfig.containerBackgroundColor;
    }

    public void handleNativeCallback(final String str, final String str2) {
        if (DirichletRuntime.getInstance().isInstanceLive(this.mInstanceId)) {
            runOnUiThread(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.stub.BaseAdActivity$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m321lambda$handleNativeCallback$9$comtapsdktapadinternalruntimepluginstubBaseAdActivity(str, str2);
                }
            });
        }
    }

    @Override // com.tapsdk.tapad.internal.runtime.SurfaceSession.CallbackHandler
    public boolean isSurfaceGone() {
        return isFinishing() || isDestroyed();
    }

    public boolean isTranslucentWindow() {
        return false;
    }

    /* JADX INFO: renamed from: lambda$beginFallbackTakeover$8$com-tapsdk-tapad-internal-runtime-plugin-stub-BaseAdActivity, reason: not valid java name */
    /* synthetic */ void m319lambda$beginFallbackTakeover$8$comtapsdktapadinternalruntimepluginstubBaseAdActivity(String str, String str2, FallbackPresentationController.TerminalResult terminalResult) {
        deliverFallbackTerminal(FallbackTerminalSettlement.settle(this.mFallbackDisplaySnapshot, terminalResult.getReason().getStableCode()), terminalResult.getReason().getStableCode(), str, str2);
    }

    /* JADX INFO: renamed from: lambda$finishSurface$10$com-tapsdk-tapad-internal-runtime-plugin-stub-BaseAdActivity, reason: not valid java name */
    /* synthetic */ void m320lambda$finishSurface$10$comtapsdktapadinternalruntimepluginstubBaseAdActivity() {
        if (isSurfaceGone()) {
            return;
        }
        finish();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:57:0x00a9  */
    /* JADX INFO: renamed from: lambda$handleNativeCallback$9$com-tapsdk-tapad-internal-runtime-plugin-stub-BaseAdActivity, reason: not valid java name */
    /* synthetic */ void m321lambda$handleNativeCallback$9$comtapsdktapadinternalruntimepluginstubBaseAdActivity(String str, String str2) {
        str.getClass();
        switch (str) {
            case "onError":
                if (!this.mFallbackTakeoverStarted) {
                    onError(str2);
                    break;
                }
                break;
            case "onRewardVerify":
                onRewardVerify(str2);
                break;
            case "onProviderSurfaceReady":
            case "onProviderInterstitialSurfaceReady":
                bindProviderFullscreenSurface();
                break;
            case "onVideoComplete":
                onVideoComplete();
                break;
            case "onAdClick":
                onAdClick();
                break;
            case "onAdClose":
                onAdClose();
                break;
            case "onCoreRuntimeFatal":
                m318lambda$beginFallbackTakeover$7$comtapsdktapadinternalruntimepluginstubBaseAdActivity("wasm_trap", str2);
                break;
            case "onFallbackTerminal":
                finish();
                break;
            case "onCorePresentationCommitted":
                this.mCorePresentationCommitted = true;
                break;
            case "onSkippedVideo":
                onSkippedVideo();
                break;
            case "onAdShow":
                this.mCorePresentationCommitted = true;
                onAdShow();
                break;
            case "open_internal_webview":
                openInternalWebView(str2);
                break;
        }
    }

    /* JADX INFO: renamed from: lambda$new$0$com-tapsdk-tapad-internal-runtime-plugin-stub-BaseAdActivity, reason: not valid java name */
    /* synthetic */ void m322lambda$new$0$comtapsdktapadinternalruntimepluginstubBaseAdActivity() {
        requestSurfaceRender("viewport resize");
    }

    /* JADX INFO: renamed from: lambda$new$1$com-tapsdk-tapad-internal-runtime-plugin-stub-BaseAdActivity, reason: not valid java name */
    /* synthetic */ void m323lambda$new$1$comtapsdktapadinternalruntimepluginstubBaseAdActivity(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (this.mSurfaceRenderEntry && this.mHasRenderedSurface && this.mContainer != null) {
            int i9 = i3 - i;
            int i10 = i4 - i2;
            int i11 = i7 - i5;
            int i12 = i8 - i6;
            if (i9 <= 0 || i10 <= 0) {
                return;
            }
            if (!(i9 == i11 && i10 == i12) && isViewportReadyForRender(i9, i10) && hasRenderedViewportChanged(i9, i10, getSafeAreaDp())) {
                debounceViewportResizeRender();
            }
        }
    }

    /* JADX INFO: renamed from: lambda$observeProviderActionSlots$11$com-tapsdk-tapad-internal-runtime-plugin-stub-BaseAdActivity, reason: not valid java name */
    /* synthetic */ void m324lambda$observeProviderActionSlots$11$comtapsdktapadinternalruntimepluginstubBaseAdActivity(List list) {
        scheduleProviderActionUpdate();
    }

    /* JADX INFO: renamed from: lambda$onCreate$2$com-tapsdk-tapad-internal-runtime-plugin-stub-BaseAdActivity, reason: not valid java name */
    /* synthetic */ void m325lambda$onCreate$2$comtapsdktapadinternalruntimepluginstubBaseAdActivity(boolean z) {
        DirichletRuntime.getInstance().triggerSurfaceWindowFocusChanged(this.mInstanceId, this.mSurfaceId, z);
    }

    /* JADX INFO: renamed from: lambda$onCreate$3$com-tapsdk-tapad-internal-runtime-plugin-stub-BaseAdActivity, reason: not valid java name */
    /* synthetic */ void m326lambda$onCreate$3$comtapsdktapadinternalruntimepluginstubBaseAdActivity(final boolean z) {
        dispatchUnifiedEvent(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.stub.BaseAdActivity$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m325lambda$onCreate$2$comtapsdktapadinternalruntimepluginstubBaseAdActivity(z);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onCreate$4$com-tapsdk-tapad-internal-runtime-plugin-stub-BaseAdActivity, reason: not valid java name */
    /* synthetic */ void m327lambda$onCreate$4$comtapsdktapadinternalruntimepluginstubBaseAdActivity(String str) {
        if (isFinishing() || isDestroyed() || !DirichletRuntime.getInstance().isInstanceLive(this.mInstanceId)) {
            finish();
            return;
        }
        float[] viewportSizeDp = getViewportSizeDp();
        float f = viewportSizeDp[0];
        float f2 = viewportSizeDp[1];
        float[] safeAreaDp = getSafeAreaDp();
        float f3 = safeAreaDp[0];
        float f4 = safeAreaDp[1];
        float f5 = safeAreaDp[2];
        float f6 = safeAreaDp[3];
        if ("ad_render".equals(str)) {
            this.mModule.callVoid("ad_render_surface_with_safe_area", Integer.valueOf(this.mInstanceId), Integer.valueOf(this.mSurfaceId), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(safeAreaDp[0]), Float.valueOf(safeAreaDp[1]), Float.valueOf(safeAreaDp[2]), Float.valueOf(safeAreaDp[3]));
        } else if ("ad_render_interstitial".equals(str)) {
            this.mModule.callVoid("ad_render_interstitial_with_safe_area", Integer.valueOf(this.mInstanceId), Integer.valueOf(this.mSurfaceId), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(safeAreaDp[0]), Float.valueOf(safeAreaDp[1]), Float.valueOf(safeAreaDp[2]), Float.valueOf(safeAreaDp[3]));
        } else {
            this.mModule.callVoid(str, Integer.valueOf(this.mInstanceId), Integer.valueOf(this.mSurfaceId), Float.valueOf(f), Float.valueOf(f2));
        }
    }

    /* JADX INFO: renamed from: lambda$onWindowFocusChanged$15$com-tapsdk-tapad-internal-runtime-plugin-stub-BaseAdActivity, reason: not valid java name */
    /* synthetic */ void m328lambda$onWindowFocusChanged$15$comtapsdktapadinternalruntimepluginstubBaseAdActivity(boolean z) {
        DirichletRuntime.getInstance().triggerWindowFocusChanged(this.mInstanceId, this.mSurfaceId, z);
    }

    /* JADX INFO: renamed from: lambda$scheduleRenderWhenViewportReady$5$com-tapsdk-tapad-internal-runtime-plugin-stub-BaseAdActivity, reason: not valid java name */
    /* synthetic */ void m329lambda$scheduleRenderWhenViewportReady$5$comtapsdktapadinternalruntimepluginstubBaseAdActivity(int i, int[] iArr, int[] iArr2, float[][] fArr, int[] iArr3, String str, Runnable runnable, int[] iArr4, Runnable[] runnableArr) {
        if (i != this.mRenderGeneration) {
            return;
        }
        if (isSurfaceGone() || !DirichletRuntime.getInstance().isInstanceLive(this.mInstanceId)) {
            this.mRenderScheduled = false;
            return;
        }
        FrameLayout frameLayout = this.mContainer;
        if (frameLayout == null) {
            this.mRenderScheduled = false;
            return;
        }
        int width = frameLayout.getWidth();
        int height = frameLayout.getHeight();
        float[] safeAreaDp = getSafeAreaDp();
        boolean zIsViewportReadyForRender = isViewportReadyForRender(width, height);
        if (zIsViewportReadyForRender && width == iArr[0] && height == iArr2[0] && safeAreaEquals(safeAreaDp, fArr[0])) {
            iArr3[0] = iArr3[0] + 1;
        } else if (zIsViewportReadyForRender) {
            iArr3[0] = 1;
            iArr[0] = width;
            iArr2[0] = height;
            fArr[0] = safeAreaDp;
        } else {
            iArr3[0] = 0;
            iArr[0] = width;
            iArr2[0] = height;
            fArr[0] = safeAreaDp;
        }
        if (!zIsViewportReadyForRender || iArr3[0] < 2) {
            int i2 = iArr4[0];
            if (i2 < 120) {
                iArr4[0] = i2 + 1;
                frameLayout.postDelayed(runnableArr[0], 16L);
                return;
            }
            this.mRenderScheduled = false;
            StringBuilder sbAppend = new StringBuilder("surface viewport did not settle for ").append(str).append(", surfaceId=").append(this.mSurfaceId).append(", instanceId=").append(this.mInstanceId).append(", viewport=").append(width).append("x").append(height).append(", surfaceKind=");
            AdActivityConfig adActivityConfig = this.mConfig;
            String string = sbAppend.append(adActivityConfig != null ? adActivityConfig.surfaceKind : null).toString();
            if (this.mHasRenderedSurface) {
                return;
            }
            failSurfaceRender(string);
            return;
        }
        this.mRenderScheduled = false;
        this.mHasRenderedSurface = true;
        this.mLastRenderedWidthPx = width;
        this.mLastRenderedHeightPx = height;
        this.mLastRenderedSafeAreaDp = safeAreaDp;
        float f = safeAreaDp[0];
        float f2 = safeAreaDp[1];
        float f3 = safeAreaDp[2];
        float f4 = safeAreaDp[3];
        AdActivityConfig adActivityConfig2 = this.mConfig;
        if (adActivityConfig2 != null) {
            String str2 = adActivityConfig2.surfaceKind;
        }
        runnable.run();
    }

    /* JADX INFO: renamed from: lambda$scheduleRenderWhenViewportReady$6$com-tapsdk-tapad-internal-runtime-plugin-stub-BaseAdActivity, reason: not valid java name */
    /* synthetic */ void m330lambda$scheduleRenderWhenViewportReady$6$comtapsdktapadinternalruntimepluginstubBaseAdActivity(Runnable[] runnableArr) {
        FrameLayout frameLayout = this.mContainer;
        if (frameLayout == null) {
            this.mRenderScheduled = false;
        } else {
            frameLayout.post(runnableArr[0]);
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(final int i, final int i2, final Intent intent) {
        super.onActivityResult(i, i2, intent);
        dispatchUnifiedEvent(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.stub.BaseAdActivity$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                DirichletRuntime.getInstance().triggerActivityResult(i, i2, BaseAdActivity.intentToJson(intent));
            }
        });
    }

    public void onAdClick() {
    }

    public void onAdClose() {
        finish();
    }

    public void onAdShow() {
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        handleBackRequest();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        applySystemBarConfig();
        final int i = configuration != null ? configuration.orientation : 0;
        final int i2 = configuration != null ? configuration.screenWidthDp : 0;
        final int i3 = configuration != null ? configuration.screenHeightDp : 0;
        dispatchUnifiedEvent(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.stub.BaseAdActivity$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                DirichletRuntime.getInstance().triggerConfigurationChanged(i, i2, i3);
            }
        });
        debounceViewportResizeRender();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        handleOrientationForOreoTranslucentActivity();
        super.onCreate(bundle);
        registerBackInvokedCallback();
        this.mSurfaceId = getIntent().getIntExtra(EXTRA_SURFACE_ID, -1);
        this.mInstanceId = getIntent().getIntExtra(EXTRA_INSTANCE_ID, -1);
        SurfaceSession live = DirichletRuntime.getInstance().surfaceSessions().getLive(this.mSurfaceId);
        if (this.mSurfaceId >= 0 && live != null) {
            this.mInstanceId = live.instanceId();
            this.mModule = live.module();
            this.mAdImpl = live.adImpl();
            this.mWasmFunction = live.wasmFunction();
            this.mConfig = live.config() != null ? live.config() : new AdActivityConfig();
            this.mCallbackListener = live.callbackListener();
        }
        requestWindowFeature(1);
        if (this.mConfig.keepScreenOn) {
            getWindow().addFlags(128);
        }
        applySystemBarConfig();
        enableEdgeToEdge(getWindow());
        DirichletRuntime dirichletRuntime = DirichletRuntime.getInstance();
        if (this.mSurfaceId < 0 || (i = this.mInstanceId) < 0 || this.mModule == null || !dirichletRuntime.isInstanceLive(i)) {
            dirichletRuntime.destroySurfaceSessionFromActivity(this.mSurfaceId);
            finish();
            return;
        }
        dirichletRuntime.surfaceSessions().registerCallbackHandler(this.mSurfaceId, this);
        FrameLayout frameLayoutCreateActivityRoot = createActivityRoot();
        this.mContainer = frameLayoutCreateActivityRoot;
        frameLayoutCreateActivityRoot.setBackgroundColor(getContainerBackgroundColor());
        setContentView(this.mContainer);
        this.mContainer.addOnLayoutChangeListener(this.mViewportLayoutListener);
        if ("ad_render_interstitial".equals(this.mWasmFunction)) {
            this.mSurfaceWindowFocus = new SurfaceWindowFocus(this.mContainer, new SurfaceWindowFocus.Listener() { // from class: com.tapsdk.tapad.internal.runtime.plugin.stub.BaseAdActivity$$ExternalSyntheticLambda18
                @Override // com.tapsdk.tapad.internal.runtime.plugin.SurfaceWindowFocus.Listener
                public final void onFocusChanged(boolean z) {
                    this.f$0.m326lambda$onCreate$3$comtapsdktapadinternalruntimepluginstubBaseAdActivity(z);
                }
            });
        }
        this.mRenderer = new DefaultViewRenderer(this, this.mContainer, dirichletRuntime, this.mInstanceId, this.mSurfaceId);
        if ("ad_render_interstitial".equals(this.mWasmFunction) && (this.mAdImpl instanceof FullscreenProviderHost)) {
            this.mRenderer.enableProviderContentModalOrdering();
        }
        dirichletRuntime.attachSurfaceRenderer(this.mSurfaceId, this.mRenderer);
        this.mSurfaceStarted = true;
        if (this.mModule == null) {
            finish();
            return;
        }
        final String str = this.mWasmFunction;
        if (str == null) {
            str = "ad_render";
        }
        boolean z = "ad_render".equals(str) || "ad_render_interstitial".equals(str);
        Runnable runnable = new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.stub.BaseAdActivity$$ExternalSyntheticLambda19
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m327lambda$onCreate$4$comtapsdktapadinternalruntimepluginstubBaseAdActivity(str);
            }
        };
        if (!z) {
            this.mContainer.post(runnable);
            return;
        }
        this.mSurfaceRenderEntry = true;
        this.mSurfaceRenderInvoke = runnable;
        requestSurfaceRender("initial");
    }

    @Override // android.app.Activity
    public void onDestroy() {
        WasmModule wasmModule;
        SurfaceWindowFocus surfaceWindowFocus = this.mSurfaceWindowFocus;
        if (surfaceWindowFocus != null) {
            surfaceWindowFocus.close();
            this.mSurfaceWindowFocus = null;
        }
        unregisterBackInvokedCallback();
        stopObservingProviderActionSlots();
        FallbackPresentationController fallbackPresentationController = this.mFallbackController;
        if (fallbackPresentationController != null) {
            fallbackPresentationController.destroy();
            this.mFallbackController = null;
        }
        super.onDestroy();
        notifyIoniaPlaybackClose();
        this.mRenderGeneration++;
        this.mRenderScheduled = false;
        FrameLayout frameLayout = this.mContainer;
        if (frameLayout != null) {
            frameLayout.removeCallbacks(this.mViewportResizeRender);
            this.mContainer.removeOnLayoutChangeListener(this.mViewportLayoutListener);
        }
        DirichletRuntime dirichletRuntime = DirichletRuntime.getInstance();
        boolean zIsInstanceLive = dirichletRuntime.isInstanceLive(this.mInstanceId);
        if (this.mSurfaceStarted && !this.mCoreRuntimeFailed && zIsInstanceLive && (wasmModule = this.mModule) != null && wasmModule.hasFunction("wasm_dispatch_envelope")) {
            dirichletRuntime.triggerDestroy(this.mInstanceId, this.mSurfaceId);
        } else {
            Object obj = this.mAdImpl;
            if (obj instanceof FullscreenProviderHost) {
                ((FullscreenProviderHost) obj).onFullscreenCoreUnavailable();
            }
        }
        DefaultViewRenderer defaultViewRenderer = this.mRenderer;
        if (defaultViewRenderer != null) {
            dirichletRuntime.detachSurfaceRenderer(this.mSurfaceId, defaultViewRenderer);
            defaultViewRenderer.destroy();
            this.mRenderer = null;
        }
        dirichletRuntime.surfaceSessions().unregisterCallbackHandler(this.mSurfaceId, this);
        dirichletRuntime.destroySurfaceSessionFromActivity(this.mSurfaceId);
        IoniaIdentityManager.getInstance().onSelfRenderedSurfaceClosed();
        this.mContainer = null;
        this.mModule = null;
        this.mAdImpl = null;
        this.mCallbackListener = null;
        this.mSurfaceRenderInvoke = null;
        this.mFallbackDisplaySnapshot = null;
    }

    public void onError(String str) {
        finish();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        dispatchUnifiedEvent(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.stub.BaseAdActivity$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                DirichletRuntime.getInstance().triggerMemoryPressure(80);
            }
        });
    }

    @Override // android.app.Activity
    public void onNewIntent(final Intent intent) {
        super.onNewIntent(intent);
        dispatchUnifiedEvent(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.stub.BaseAdActivity$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                DirichletRuntime.getInstance().triggerNewIntent(BaseAdActivity.intentToJson(intent));
            }
        });
    }

    @Override // android.app.Activity
    public void onPause() {
        WasmModule wasmModule;
        super.onPause();
        notifyIoniaPlaybackClose();
        FallbackPresentationController fallbackPresentationController = this.mFallbackController;
        if (fallbackPresentationController != null) {
            fallbackPresentationController.pause();
            return;
        }
        DefaultViewRenderer defaultViewRenderer = this.mRenderer;
        if (defaultViewRenderer != null) {
            defaultViewRenderer.pauseWebCreatives();
        }
        DirichletRuntime dirichletRuntime = DirichletRuntime.getInstance();
        if (dirichletRuntime.isInstanceLive(this.mInstanceId) && !this.mCoreRuntimeFailed && (wasmModule = this.mModule) != null && wasmModule.hasFunction("wasm_dispatch_envelope")) {
            dirichletRuntime.triggerPause(this.mInstanceId, this.mSurfaceId);
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(final int i, final String[] strArr, final int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        dispatchUnifiedEvent(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.stub.BaseAdActivity$$ExternalSyntheticLambda20
            @Override // java.lang.Runnable
            public final void run() {
                DirichletRuntime.getInstance().triggerPermissionResult(i, BaseAdActivity.permissionsToJson(strArr, iArr));
            }
        });
    }

    @Override // android.app.Activity
    public void onResume() {
        WasmModule wasmModule;
        super.onResume();
        applySystemBarConfig();
        FallbackPresentationController fallbackPresentationController = this.mFallbackController;
        if (fallbackPresentationController != null) {
            notifyIoniaPlaybackShow();
            fallbackPresentationController.resume();
            return;
        }
        DirichletRuntime dirichletRuntime = DirichletRuntime.getInstance();
        int i = this.mInstanceId;
        if (i >= 0 && !dirichletRuntime.isInstanceLive(i)) {
            finish();
            return;
        }
        DefaultViewRenderer defaultViewRenderer = this.mRenderer;
        if (defaultViewRenderer != null) {
            dirichletRuntime.attachSurfaceRenderer(this.mSurfaceId, defaultViewRenderer);
            this.mRenderer.resumeWebCreatives();
        }
        if (!this.mCoreRuntimeFailed && (wasmModule = this.mModule) != null && wasmModule.hasFunction("wasm_dispatch_envelope")) {
            dirichletRuntime.triggerResume(this.mInstanceId, this.mSurfaceId);
        }
        notifyIoniaPlaybackShow();
    }

    public void onRewardVerify(String str) {
    }

    public void onSkippedVideo() {
    }

    @Override // com.tapsdk.tapad.internal.runtime.SurfaceSession.CallbackHandler
    public void onSurfaceCallback(String str, String str2) {
        handleNativeCallback(str, str2);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(final int i) {
        super.onTrimMemory(i);
        dispatchUnifiedEvent(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.stub.BaseAdActivity$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                DirichletRuntime.getInstance().triggerMemoryPressure(i);
            }
        });
    }

    public void onVideoComplete() {
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(final boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            applySystemBarConfig();
        }
        if (this.mSurfaceWindowFocus == null) {
            dispatchUnifiedEvent(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.stub.BaseAdActivity$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m328lambda$onWindowFocusChanged$15$comtapsdktapadinternalruntimepluginstubBaseAdActivity(z);
                }
            });
        }
    }

    public void openInternalWebView(String str) {
        AdActivityConfig adActivityConfig = this.mConfig;
        InternalWebViewCallbackActuator.open(this, str, adActivityConfig != null ? adActivityConfig.adType : null, this.mInstanceId, this.mSurfaceId);
    }
}
