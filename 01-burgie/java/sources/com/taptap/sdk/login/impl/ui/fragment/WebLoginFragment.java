package com.taptap.sdk.login.impl.ui.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.android.live.base.api.push.ILivePush;
import com.tapsdk.tapad.internal.runtime.view.ContainerViewManager;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.TapTapKit;
import com.taptap.sdk.kit.internal.extensions.UIExtKt;
import com.taptap.sdk.kit.internal.json.TapJson;
import com.taptap.sdk.kit.internal.utils.DeviceUtils;
import com.taptap.sdk.kit.internal.utils.PlatformXUA;
import com.taptap.sdk.kit.internal.utils.TapDensityUtilsKt;
import com.taptap.sdk.login.R;
import com.taptap.sdk.login.impl.data.model.LoginRequest;
import com.taptap.sdk.login.impl.data.model.LoginResponse;
import com.taptap.sdk.login.impl.data.model.Orientation;
import com.taptap.sdk.login.impl.ui.activity.TapTapLoginActivity;
import com.taptap.sdk.login.impl.utils.CodeUtil;
import com.taptap.sdk.login.impl.utils.WebViewUriProvider;
import com.taptap.sdk.login.impl.webview.jsbridge.JavascriptInterfaceDelegate;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KTypeProjection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.modules.SerializersModule;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: WebLoginFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0013H\u0002J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001aH\u0002J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0006\u0010!\u001a\u00020\u0013J&\u0010\"\u001a\u0004\u0018\u00010\t2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u001a\u0010)\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\t2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010*\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010+\u001a\u00020\u0013H\u0002J\b\u0010,\u001a\u00020\u0013H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/taptap/sdk/login/impl/ui/fragment/WebLoginFragment;", "Landroid/app/Fragment;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "()V", "animatorSet", "Landroid/animation/AnimatorSet;", "callback", "Lcom/taptap/sdk/login/impl/ui/fragment/TapFragmentLoginCallback;", ILivePush.ClickType.CLOSE, "Landroid/view/View;", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "progressBar", "Landroid/widget/ProgressBar;", "request", "Lcom/taptap/sdk/login/impl/data/model/LoginRequest;", "webview", "Landroid/webkit/WebView;", "adjustLayoutByScreenOrientation", "", "view", "orientation", "Lcom/taptap/sdk/login/impl/data/model/Orientation;", "convertAsLoginResponse", "Lcom/taptap/sdk/login/impl/data/model/LoginResponse;", BreakpointSQLiteKey.URL, "", "endLoadingAnimation", "generateWebUrl", "initializeWebView", "onAnimationUpdate", "animation", "Landroid/animation/ValueAnimator;", "onBackPressed", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", ContainerViewManager.NAME, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "redirectToUrl", "startLoadingAnimation", "syncCookie", "Companion", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class WebLoginFragment extends Fragment implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String QUERY_KEY_CODE = "code";
    private static final String QUERY_KEY_ERROR = "error";
    private static final String QUERY_KEY_ID = "state";
    private static final String TAG = "WebLoginFragment";
    private AnimatorSet animatorSet;
    private TapFragmentLoginCallback callback;
    private View close;
    private final CoroutineScope mainScope = CoroutineScopeKt.MainScope();
    private ProgressBar progressBar;
    private LoginRequest request;
    private WebView webview;

    /* JADX INFO: compiled from: WebLoginFragment.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Orientation.values().length];
            try {
                iArr[Orientation.PORTRAIT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Orientation.LANDSCAPE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_webview_login, container, false);
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) throws JSONException {
        Orientation orientation;
        Intrinsics.checkNotNullParameter(view, "view");
        this.webview = (WebView) view.findViewById(R.id.webview);
        this.progressBar = (ProgressBar) view.findViewById(R.id.progress);
        this.close = view.findViewById(R.id.close);
        LoginRequest loginRequest = (LoginRequest) getArguments().getParcelable(TapTapLoginActivity.EXTRAS_REQUEST);
        if (loginRequest == null) {
            loginRequest = savedInstanceState != null ? (LoginRequest) savedInstanceState.getParcelable(TapTapLoginActivity.EXTRAS_REQUEST) : null;
        }
        this.request = loginRequest;
        if (loginRequest != null) {
            orientation = Orientation.INSTANCE.from(loginRequest.getScreenOrientation());
        } else {
            orientation = null;
        }
        adjustLayoutByScreenOrientation(view, orientation);
        View view2 = this.close;
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.taptap.sdk.login.impl.ui.fragment.WebLoginFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    WebLoginFragment.onViewCreated$lambda$1(this.f$0, view3);
                }
            });
        }
        WebView value = this.webview;
        if (value != null) {
            initializeWebView(value);
        }
        syncCookie();
        String url = generateWebUrl();
        if (url != null) {
            TapLogger.logi(TAG, "Loading web login url: " + url);
            WebView webView = this.webview;
            if (webView != null) {
                LoginRequest loginRequest2 = this.request;
                webView.loadUrl(url, MapsKt.mapOf(TuplesKt.to("X-SDK-UA", loginRequest2 != null ? loginRequest2.getInfo() : null)));
            }
        }
        startLoadingAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(WebLoginFragment this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TapFragmentLoginCallback tapFragmentLoginCallback = this$0.callback;
        if (tapFragmentLoginCallback != null) {
            tapFragmentLoginCallback.onCancel(this$0.request);
        }
        this$0.getActivity().finish();
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        ProgressBar progressBar = this.progressBar;
        if (progressBar == null) {
            return;
        }
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        progressBar.setProgress(((Integer) animatedValue).intValue());
    }

    private final void adjustLayoutByScreenOrientation(View view, Orientation orientation) {
        int[] screenSize = DeviceUtils.getDeviceSize(getActivity());
        int longerSide = RangesKt.coerceAtLeast(screenSize[0], screenSize[1]);
        switch (orientation == null ? -1 : WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()]) {
            case 1:
                View container = view.findViewById(R.id.container);
                if (container != null) {
                    ViewGroup.LayoutParams $this$adjustLayoutByScreenOrientation_u24lambda_u245_u24lambda_u244 = container.getLayoutParams();
                    if ($this$adjustLayoutByScreenOrientation_u24lambda_u245_u24lambda_u244 != null) {
                        $this$adjustLayoutByScreenOrientation_u24lambda_u245_u24lambda_u244.width = -1;
                        $this$adjustLayoutByScreenOrientation_u24lambda_u245_u24lambda_u244.height = ((int) (((double) longerSide) * 0.8d)) + TapDensityUtilsKt.getDip(38.0f);
                        container.setLayoutParams($this$adjustLayoutByScreenOrientation_u24lambda_u245_u24lambda_u244);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                    }
                }
                View container2 = view.findViewById(R.id.web_container);
                if (container2 != null) {
                    ViewGroup.LayoutParams layoutParams = container2.getLayoutParams();
                    if (layoutParams == null) {
                        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    }
                    ViewGroup.LayoutParams params$iv = (ViewGroup.MarginLayoutParams) layoutParams;
                    ViewGroup.MarginLayoutParams $this$adjustLayoutByScreenOrientation_u24lambda_u247_u24lambda_u246 = (ViewGroup.MarginLayoutParams) params$iv;
                    int margin = TapDensityUtilsKt.getDip(20.0f);
                    $this$adjustLayoutByScreenOrientation_u24lambda_u247_u24lambda_u246.topMargin = TapDensityUtilsKt.getDip(38.0f);
                    $this$adjustLayoutByScreenOrientation_u24lambda_u247_u24lambda_u246.bottomMargin = margin;
                    $this$adjustLayoutByScreenOrientation_u24lambda_u247_u24lambda_u246.leftMargin = margin;
                    $this$adjustLayoutByScreenOrientation_u24lambda_u247_u24lambda_u246.rightMargin = margin;
                    container2.setLayoutParams(params$iv);
                    container2.setClipToOutline(true);
                }
                View container3 = view.findViewById(R.id.close);
                if (container3 == null) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams2 = container3.getLayoutParams();
                if (layoutParams2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                }
                ViewGroup.LayoutParams params$iv2 = (FrameLayout.LayoutParams) layoutParams2;
                FrameLayout.LayoutParams $this$adjustLayoutByScreenOrientation_u24lambda_u249_u24lambda_u248 = (FrameLayout.LayoutParams) params$iv2;
                $this$adjustLayoutByScreenOrientation_u24lambda_u249_u24lambda_u248.gravity = 8388661;
                $this$adjustLayoutByScreenOrientation_u24lambda_u249_u24lambda_u248.setMargins(0, 0, TapDensityUtilsKt.getDip(20.0f), 0);
                container3.setLayoutParams(params$iv2);
                return;
            case 2:
                View container4 = view.findViewById(R.id.container);
                if (container4 != null) {
                    ViewGroup.LayoutParams $this$adjustLayoutByScreenOrientation_u24lambda_u2411_u24lambda_u2410 = container4.getLayoutParams();
                    if ($this$adjustLayoutByScreenOrientation_u24lambda_u2411_u24lambda_u2410 != null) {
                        $this$adjustLayoutByScreenOrientation_u24lambda_u2411_u24lambda_u2410.width = ((int) (((double) longerSide) * 0.6d)) + TapDensityUtilsKt.getDip(84.0f);
                        $this$adjustLayoutByScreenOrientation_u24lambda_u2411_u24lambda_u2410.height = -1;
                        container4.setLayoutParams($this$adjustLayoutByScreenOrientation_u24lambda_u2411_u24lambda_u2410);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                    }
                }
                View container5 = view.findViewById(R.id.web_container);
                if (container5 != null) {
                    ViewGroup.LayoutParams layoutParams3 = container5.getLayoutParams();
                    if (layoutParams3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    }
                    ViewGroup.LayoutParams params$iv3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                    ViewGroup.MarginLayoutParams $this$adjustLayoutByScreenOrientation_u24lambda_u2413_u24lambda_u2412 = (ViewGroup.MarginLayoutParams) params$iv3;
                    int yMargin = TapDensityUtilsKt.getDip(16.0f);
                    int xMargin = TapDensityUtilsKt.getDip(42.0f);
                    $this$adjustLayoutByScreenOrientation_u24lambda_u2413_u24lambda_u2412.topMargin = yMargin;
                    $this$adjustLayoutByScreenOrientation_u24lambda_u2413_u24lambda_u2412.bottomMargin = yMargin;
                    $this$adjustLayoutByScreenOrientation_u24lambda_u2413_u24lambda_u2412.leftMargin = xMargin;
                    $this$adjustLayoutByScreenOrientation_u24lambda_u2413_u24lambda_u2412.rightMargin = xMargin;
                    container5.setLayoutParams(params$iv3);
                    container5.setClipToOutline(true);
                }
                View container6 = view.findViewById(R.id.close);
                if (container6 == null) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams4 = container6.getLayoutParams();
                if (layoutParams4 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                }
                ViewGroup.LayoutParams params$iv4 = (FrameLayout.LayoutParams) layoutParams4;
                FrameLayout.LayoutParams $this$adjustLayoutByScreenOrientation_u24lambda_u2415_u24lambda_u2414 = (FrameLayout.LayoutParams) params$iv4;
                $this$adjustLayoutByScreenOrientation_u24lambda_u2415_u24lambda_u2414.gravity = 8388659;
                $this$adjustLayoutByScreenOrientation_u24lambda_u2415_u24lambda_u2414.setMargins(TapDensityUtilsKt.getDip(4.0f), TapDensityUtilsKt.getDip(16.0f), 0, 0);
                container6.setLayoutParams(params$iv4);
                return;
            default:
                return;
        }
    }

    private static final String generateWebUrl$getSessionId(String trackInfo) throws JSONException {
        JSONObject json = new JSONObject(trackInfo);
        String sessionId = json.getString("session_id");
        return sessionId;
    }

    private static final String generateWebUrl$getExtras(boolean z) {
        TapJson tapJson = TapJson.INSTANCE;
        Map mapMapOf = MapsKt.mapOf(TuplesKt.to("preapproved", Integer.valueOf(z ? 1 : 0)));
        try {
            Json json = tapJson.getJson();
            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Integer.TYPE))));
            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            return json.encodeToString(kSerializerSerializer, mapMapOf);
        } catch (Exception e) {
            TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
            return null;
        }
    }

    private static final String generateWebUrl$getInfo() {
        TapJson this_$iv = TapJson.INSTANCE;
        Map mapMapOf = MapsKt.mapOf(TuplesKt.to("device_id", Build.MANUFACTURER + ' ' + Build.MODEL));
        try {
            StringFormat $this$encodeToString$iv$iv = this_$iv.getJson();
            SerializersModule $this$serializer$iv$iv$iv = $this$encodeToString$iv$iv.getSerializersModule();
            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv, Reflection.typeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class))));
            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            return $this$encodeToString$iv$iv.encodeToString(kSerializerSerializer, mapMapOf);
        } catch (Exception e$iv) {
            TapLogger.loge$default(TapJson.TAG, null, e$iv, 2, null);
            return null;
        }
    }

    private final String generateWebUrl() throws JSONException {
        LoginRequest value = this.request;
        if (value == null) {
            return null;
        }
        WebViewUriProvider webViewUriProvider = WebViewUriProvider.INSTANCE;
        boolean zIsRND = TapTapKit.INSTANCE.isRND();
        LoginRequest loginRequest = this.request;
        String webviewUrl = webViewUriProvider.provide(zIsRND, loginRequest != null ? loginRequest.getRegionType() : null);
        Uri.Builder builder = Uri.parse(webviewUrl).buildUpon();
        LoginRequest loginRequest2 = this.request;
        builder.appendQueryParameter("client_id", loginRequest2 != null ? loginRequest2.getClientId() : null);
        builder.appendQueryParameter("redirect_uri", "tapoauth://authorize");
        builder.appendQueryParameter("response_type", "code");
        String sessionId = generateWebUrl$getSessionId(value.getTrackInfo());
        if (sessionId != null) {
            builder.appendQueryParameter("session_id", sessionId);
        }
        builder.appendQueryParameter("version", "4.10.9");
        builder.appendQueryParameter("platform", "android");
        builder.appendQueryParameter("theme_mode", UIExtKt.getThemeText());
        builder.appendQueryParameter("scope", CollectionsKt.joinToString$default(value.getScopes(), ",", null, null, 0, null, null, 62, null));
        builder.appendQueryParameter(QUERY_KEY_ID, value.getState());
        builder.appendQueryParameter("code_challenge", CodeUtil.INSTANCE.getCodeChallenge(value.getCodeVerifier()));
        builder.appendQueryParameter("code_challenge_method", value.getCodeChallengeMethod());
        builder.appendQueryParameter("extra", generateWebUrl$getExtras(value.getPreApproved()));
        builder.appendQueryParameter("info", generateWebUrl$getInfo());
        String phoneVerifyToken = value.getPhoneVerifyToken();
        if (phoneVerifyToken != null) {
            builder.appendQueryParameter("x_phone_verify_token", phoneVerifyToken);
        }
        String preferredLoginType = value.getPreferredLoginType();
        if (preferredLoginType != null) {
            builder.appendQueryParameter("x_login_type", preferredLoginType);
        }
        return builder.build().toString();
    }

    private final void initializeWebView(WebView webview) {
        webview.setDownloadListener(new DownloadListener() { // from class: com.taptap.sdk.login.impl.ui.fragment.WebLoginFragment$$ExternalSyntheticLambda1
            @Override // android.webkit.DownloadListener
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                WebLoginFragment.initializeWebView$lambda$20(this.f$0, str, str2, str3, str4, j);
            }
        });
        webview.setWebViewClient(new WebViewClient() { // from class: com.taptap.sdk.login.impl.ui.fragment.WebLoginFragment.initializeWebView.2
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url) {
                WebLoginFragment.this.endLoadingAnimation();
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (WebLoginFragment.this.getActivity() == null) {
                    TapFragmentLoginCallback tapFragmentLoginCallback = WebLoginFragment.this.callback;
                    if (tapFragmentLoginCallback != null) {
                        tapFragmentLoginCallback.onCancel(WebLoginFragment.this.request);
                    }
                    return false;
                }
                String str = url;
                if (str == null || str.length() == 0) {
                    return false;
                }
                String lowerCase = url.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                if (!StringsKt.startsWith$default(lowerCase, "tapoauth", false, 2, (Object) null)) {
                    return false;
                }
                TapFragmentLoginCallback tapFragmentLoginCallback2 = WebLoginFragment.this.callback;
                if (tapFragmentLoginCallback2 != null) {
                    tapFragmentLoginCallback2.onSuccess(WebLoginFragment.this.request, WebLoginFragment.this.convertAsLoginResponse(url));
                }
                return true;
            }
        });
        WebSettings $this$initializeWebView_u24lambda_u2421 = webview.getSettings();
        $this$initializeWebView_u24lambda_u2421.setAllowUniversalAccessFromFileURLs(false);
        $this$initializeWebView_u24lambda_u2421.setAllowFileAccessFromFileURLs(false);
        $this$initializeWebView_u24lambda_u2421.setAllowFileAccess(false);
        $this$initializeWebView_u24lambda_u2421.setJavaScriptEnabled(true);
        $this$initializeWebView_u24lambda_u2421.setSavePassword(false);
        $this$initializeWebView_u24lambda_u2421.setSaveFormData(false);
        $this$initializeWebView_u24lambda_u2421.setCacheMode(2);
        $this$initializeWebView_u24lambda_u2421.setUserAgentString(PlatformXUA.getTrackUA());
        webview.addJavascriptInterface(new JavascriptInterfaceDelegate(new Function1<String, Unit>() { // from class: com.taptap.sdk.login.impl.ui.fragment.WebLoginFragment.initializeWebView.4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String url) {
                WebLoginFragment.this.redirectToUrl(url);
            }
        }, new Function0<String>() { // from class: com.taptap.sdk.login.impl.ui.fragment.WebLoginFragment.initializeWebView.5
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                LoginRequest loginRequest = WebLoginFragment.this.request;
                if (loginRequest != null) {
                    return loginRequest.getInfo();
                }
                return null;
            }
        }, new Function0<String>() { // from class: com.taptap.sdk.login.impl.ui.fragment.WebLoginFragment.initializeWebView.6
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                LoginRequest loginRequest = WebLoginFragment.this.request;
                if (loginRequest != null) {
                    return loginRequest.getTrackInfo();
                }
                return null;
            }
        }), "urlResource");
        webview.setOverScrollMode(2);
        webview.setVerticalScrollBarEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initializeWebView$lambda$20(WebLoginFragment this$0, String url, String str, String str2, String str3, long j) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.redirectToUrl(url);
    }

    /* JADX INFO: renamed from: com.taptap.sdk.login.impl.ui.fragment.WebLoginFragment$redirectToUrl$1, reason: invalid class name */
    /* JADX INFO: compiled from: WebLoginFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.login.impl.ui.fragment.WebLoginFragment$redirectToUrl$1", f = "WebLoginFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $url;
        int label;
        final /* synthetic */ WebLoginFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, WebLoginFragment webLoginFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$url = str;
            this.this$0 = webLoginFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$url, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse(this.$url));
                        this.this$0.getActivity().startActivity(intent);
                        break;
                    } catch (Throwable th) {
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void redirectToUrl(String url) {
        BuildersKt__Builders_commonKt.launch$default(this.mainScope, null, null, new AnonymousClass1(url, this, null), 3, null);
    }

    private final void syncCookie() {
        CookieSyncManager.createInstance(getActivity());
        CookieManager $this$syncCookie_u24lambda_u2422 = CookieManager.getInstance();
        $this$syncCookie_u24lambda_u2422.setAcceptCookie(true);
        $this$syncCookie_u24lambda_u2422.setCookie("https://www.xdrnd.com/", "skip_captcha=1");
        $this$syncCookie_u24lambda_u2422.flush();
    }

    private final void startLoadingAnimation() {
        AnimatorSet $this$startLoadingAnimation_u24lambda_u2425 = new AnimatorSet();
        ValueAnimator $this$startLoadingAnimation_u24lambda_u2425_u24lambda_u2423 = ValueAnimator.ofInt(0, 20).setDuration(800L);
        $this$startLoadingAnimation_u24lambda_u2425_u24lambda_u2423.addUpdateListener(this);
        Unit unit = Unit.INSTANCE;
        ValueAnimator $this$startLoadingAnimation_u24lambda_u2425_u24lambda_u2424 = ValueAnimator.ofInt(20, 80).setDuration(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
        $this$startLoadingAnimation_u24lambda_u2425_u24lambda_u2424.addUpdateListener(this);
        Unit unit2 = Unit.INSTANCE;
        $this$startLoadingAnimation_u24lambda_u2425.playSequentially($this$startLoadingAnimation_u24lambda_u2425_u24lambda_u2423, $this$startLoadingAnimation_u24lambda_u2425_u24lambda_u2424);
        this.animatorSet = $this$startLoadingAnimation_u24lambda_u2425;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void endLoadingAnimation() {
        AnimatorSet animatorSet = this.animatorSet;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        final ProgressBar view = this.progressBar;
        if (view != null) {
            ValueAnimator $this$endLoadingAnimation_u24lambda_u2427_u24lambda_u2426 = ValueAnimator.ofInt(view.getProgress(), 100).setDuration(500L);
            $this$endLoadingAnimation_u24lambda_u2427_u24lambda_u2426.addUpdateListener(this);
            $this$endLoadingAnimation_u24lambda_u2427_u24lambda_u2426.addListener(new AnimatorListenerAdapter() { // from class: com.taptap.sdk.login.impl.ui.fragment.WebLoginFragment$endLoadingAnimation$1$1$1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    view.setVisibility(8);
                }
            });
            $this$endLoadingAnimation_u24lambda_u2427_u24lambda_u2426.start();
        }
    }

    public final void onBackPressed() {
        TapFragmentLoginCallback tapFragmentLoginCallback = this.callback;
        if (tapFragmentLoginCallback != null) {
            tapFragmentLoginCallback.onCancel(this.request);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LoginResponse convertAsLoginResponse(String url) {
        String str;
        Uri uri = Uri.parse(url);
        String queryParameter = uri.getQueryParameter(QUERY_KEY_ID);
        if (queryParameter != null) {
            str = queryParameter;
        } else {
            str = "";
        }
        return new LoginResponse(str, null, uri.getQueryParameter("code"), uri.getQueryParameter("error"), false, url);
    }

    /* JADX INFO: compiled from: WebLoginFragment.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/taptap/sdk/login/impl/ui/fragment/WebLoginFragment$Companion;", "", "()V", "QUERY_KEY_CODE", "", "QUERY_KEY_ERROR", "QUERY_KEY_ID", "TAG", "newInstance", "Lcom/taptap/sdk/login/impl/ui/fragment/WebLoginFragment;", "request", "Lcom/taptap/sdk/login/impl/data/model/LoginRequest;", "callback", "Lcom/taptap/sdk/login/impl/ui/fragment/TapFragmentLoginCallback;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final WebLoginFragment newInstance(LoginRequest request, TapFragmentLoginCallback callback) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(callback, "callback");
            WebLoginFragment $this$newInstance_u24lambda_u241 = new WebLoginFragment();
            Bundle $this$newInstance_u24lambda_u241_u24lambda_u240 = new Bundle();
            $this$newInstance_u24lambda_u241_u24lambda_u240.putParcelable(TapTapLoginActivity.EXTRAS_REQUEST, request);
            $this$newInstance_u24lambda_u241.setArguments($this$newInstance_u24lambda_u241_u24lambda_u240);
            $this$newInstance_u24lambda_u241.callback = callback;
            return $this$newInstance_u24lambda_u241;
        }
    }
}
