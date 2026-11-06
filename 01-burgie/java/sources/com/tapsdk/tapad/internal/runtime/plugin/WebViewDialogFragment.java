package com.tapsdk.tapad.internal.runtime.plugin;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Insets;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.tapsdk.tapad.internal.AdType;
import com.tapsdk.tapad.internal.network.utils.HttpUtil;
import com.tapsdk.tapad.internal.platform.AndroidLifecycleHost;
import com.tapsdk.tapad.internal.runtime.DirichletRuntime;
import com.tapsdk.tapad.internal.runtime.plugin.download.WebViewDownloadController;
import com.tapsdk.tapad.model.entities.DynamicHeader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class WebViewDialogFragment extends DialogFragment {
    private static final String ARG_AD_TYPE = "ad_type";
    private static final String ARG_APK_MD5 = "apk_md5";
    private static final String ARG_APK_SIZE = "apk_size";
    private static final String ARG_APK_VERIFY_TYPE = "apk_verify_type";
    private static final String ARG_APP_NAME = "app_name";
    private static final String ARG_INSTANCE_ID = "instance_id";
    private static final String ARG_LANDING_HEADERS = "landing_headers";
    private static final String ARG_PACKAGE_NAME = "package_name";
    private static final String ARG_REQUEST_ID = "request_id";
    private static final String ARG_SESSION_ID = "session_id";
    private static final String ARG_SURFACE_ID = "surface_id";
    private static final String ARG_TITLE = "title";
    private static final String ARG_TRACK_ID = "track_id";
    private static final String ARG_TRACK_LANDING = "track_landing";
    private static final String ARG_URL = "url";
    private static final int OPEN_MINI_PROGRAM_MODE_INNER_WEB = 2;
    private static final String TAG = "WebViewDialog";
    private static final String WEIXIN = "weixin";
    private AdType mAdType;
    private ImageView mBackBtn;
    private ImageView mCloseBtn;
    private WebViewDownloadController mDownloadController;
    private boolean mInteractionCloseSent;
    private boolean mLandingCloseSent;
    private boolean mLandingLoadSent;
    private long mLoadStartedAtMs;
    private long mOpenStartedAtMs;
    private ProgressBar mProgressBar;
    private boolean mTrackLanding;
    private WebView mWebView;
    private String mLandingUrl = "";
    private String mRequestId = "";
    private String mTrackId = "";
    private int mSessionId = -1;
    private int mInstanceId = -1;
    private int mSurfaceId = -1;
    private String mPackageName = "";
    private String mAppName = "";
    private String mApkMd5 = "";
    private long mApkSize = -1;
    private int mApkVerifyType = -1;
    private final List<DynamicHeader> mLandingHeaders = new ArrayList();

    public static void applySafeAreaInsets(View view, int i, int i2, int i3, int i4) {
        if (view == null || !(view.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        int iMax = Math.max(0, i);
        int iMax2 = Math.max(0, i2);
        int iMax3 = Math.max(0, i3);
        int iMax4 = Math.max(0, i4);
        if (layoutParams.leftMargin == iMax && layoutParams.topMargin == iMax2 && layoutParams.rightMargin == iMax3 && layoutParams.bottomMargin == iMax4) {
            return;
        }
        layoutParams.setMargins(iMax, iMax2, iMax3, iMax4);
        view.setLayoutParams(layoutParams);
    }

    private int dp(int i) {
        return (int) ((i * getActivity().getResources().getDisplayMetrics().density) + 0.5f);
    }

    private long elapsedSince(long j) {
        if (j <= 0) {
            return 0L;
        }
        return Math.max(0L, System.currentTimeMillis() - j);
    }

    private void installSafeAreaInsets(View view) {
        view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.tapsdk.tapad.internal.runtime.plugin.WebViewDialogFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnApplyWindowInsetsListener
            public final WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                return WebViewDialogFragment.lambda$installSafeAreaInsets$3(view2, windowInsets);
            }
        });
        view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.tapsdk.tapad.internal.runtime.plugin.WebViewDialogFragment.3
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                view2.removeOnAttachStateChangeListener(this);
                view2.requestApplyInsets();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
            }
        });
    }

    static /* synthetic */ WindowInsets lambda$installSafeAreaInsets$3(View view, WindowInsets windowInsets) {
        int[] iArrResolveSafeAreaInsets = resolveSafeAreaInsets(windowInsets);
        applySafeAreaInsets(view, iArrResolveSafeAreaInsets[0], iArrResolveSafeAreaInsets[1], iArrResolveSafeAreaInsets[2], iArrResolveSafeAreaInsets[3]);
        return windowInsets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadBlankPage() {
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.loadUrl("about:blank");
        }
    }

    public static void loadInitialUrl(WebView webView, String str, List<DynamicHeader> list) {
        Map<String, String> mapConvertDynamicHeaderListToHeaderMap = HttpUtil.convertDynamicHeaderListToHeaderMap(list);
        if (mapConvertDynamicHeaderListToHeaderMap.isEmpty()) {
            webView.loadUrl(str);
        } else {
            webView.loadUrl(str, mapConvertDynamicHeaderListToHeaderMap);
        }
    }

    public static WebViewDialogFragment newInstance(String str, String str2) {
        return newInstance(str, str2, "", "", false, null, -1, -1, -1, null, "", "", "", -1L, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: notifyInteractionClosed, reason: merged with bridge method [inline-methods] */
    public void m307lambda$onDismiss$4$comtapsdktapadinternalruntimepluginWebViewDialogFragment() {
        int i;
        if (this.mSessionId <= 0 || this.mInteractionCloseSent) {
            return;
        }
        this.mInteractionCloseSent = true;
        long jElapsedSince = elapsedSince(this.mOpenStartedAtMs);
        int i2 = jElapsedSince > 2147483647L ? Integer.MAX_VALUE : (int) jElapsedSince;
        DirichletRuntime dirichletRuntime = DirichletRuntime.getInstance();
        int i3 = this.mInstanceId;
        if (i3 <= 0 || (i = this.mSurfaceId) <= 0) {
            dirichletRuntime.triggerInteractionEvent(4, this.mSessionId, i2);
        } else {
            dirichletRuntime.triggerInteractionEvent(i3, i, 4, this.mSessionId, i2);
        }
    }

    private void notifyLandingPageClosed() {
        if (this.mLandingCloseSent) {
            return;
        }
        this.mLandingCloseSent = true;
        AndroidLifecycleHost.getInstance().recordLandingClosed(this.mRequestId, this.mTrackId, this.mLandingUrl, this.mTrackLanding, elapsedSince(this.mOpenStartedAtMs));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyLandingPageLoaded(String str) {
        if (this.mLandingLoadSent || TextUtils.isEmpty(str) || "about:blank".equals(str)) {
            return;
        }
        this.mLandingLoadSent = true;
        AndroidLifecycleHost.getInstance().recordLandingLoaded(this.mRequestId, this.mTrackId, str, this.mTrackLanding, elapsedSince(this.mLoadStartedAtMs));
    }

    public static int[] resolveSafeAreaInsets(WindowInsets windowInsets) {
        if (windowInsets == null) {
            return new int[]{0, 0, 0, 0};
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            Insets insets = windowInsets.getInsets(WindowInsets.Type.systemBars() | WindowInsets.Type.displayCutout());
            return new int[]{insets.left, insets.top, insets.right, insets.bottom};
        }
        int iMax = Math.max(0, windowInsets.getSystemWindowInsetLeft());
        int iMax2 = Math.max(0, windowInsets.getSystemWindowInsetTop());
        int iMax3 = Math.max(0, windowInsets.getSystemWindowInsetRight());
        int iMax4 = Math.max(0, windowInsets.getSystemWindowInsetBottom());
        if (i >= 28 && windowInsets.getDisplayCutout() != null) {
            iMax = Math.max(iMax, windowInsets.getDisplayCutout().getSafeInsetLeft());
            iMax2 = Math.max(iMax2, windowInsets.getDisplayCutout().getSafeInsetTop());
            iMax3 = Math.max(iMax3, windowInsets.getDisplayCutout().getSafeInsetRight());
            iMax4 = Math.max(iMax4, windowInsets.getDisplayCutout().getSafeInsetBottom());
        }
        return new int[]{iMax, iMax2, iMax3, iMax4};
    }

    private void trackInnerBrowserAction(String str) {
        int i;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith("https://") || str.startsWith("http://")) {
            i = 3;
        } else {
            i = str.startsWith(WEIXIN) ? 4 : 2;
        }
        dispatchInteractionEvent(6, i, str);
    }

    public WebView createWebView(Activity activity) {
        return new WebView(activity);
    }

    public void dispatchInteractionEvent(int i, int i2) {
        dispatchInteractionEvent(i, i2, null);
    }

    public boolean handleUrlLoading(WebView webView, String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        if (str.startsWith(WEIXIN)) {
            notifyMiniProgramSchemeIntercepted();
        }
        trackInnerBrowserAction(str);
        if (str.startsWith("https://") || str.startsWith("http://")) {
            webView.loadUrl(str);
            return true;
        }
        openExternalUrl(str);
        return true;
    }

    /* JADX INFO: renamed from: lambda$onCreateView$0$com-tapsdk-tapad-internal-runtime-plugin-WebViewDialogFragment, reason: not valid java name */
    /* synthetic */ void m304lambda$onCreateView$0$comtapsdktapadinternalruntimepluginWebViewDialogFragment(View view) {
        WebView webView = this.mWebView;
        if (webView == null || !webView.canGoBack()) {
            dismissAllowingStateLoss();
        } else {
            this.mWebView.goBack();
        }
    }

    /* JADX INFO: renamed from: lambda$onCreateView$1$com-tapsdk-tapad-internal-runtime-plugin-WebViewDialogFragment, reason: not valid java name */
    /* synthetic */ void m305lambda$onCreateView$1$comtapsdktapadinternalruntimepluginWebViewDialogFragment(View view) {
        dismissAllowingStateLoss();
    }

    /* JADX INFO: renamed from: lambda$onCreateView$2$com-tapsdk-tapad-internal-runtime-plugin-WebViewDialogFragment, reason: not valid java name */
    /* synthetic */ void m306lambda$onCreateView$2$comtapsdktapadinternalruntimepluginWebViewDialogFragment(String str, String str2, String str3, String str4, long j) {
        WebViewDownloadController webViewDownloadController = this.mDownloadController;
        if (webViewDownloadController != null) {
            webViewDownloadController.handleDownloadStart(str, str2, str3, str4, j);
        }
    }

    public void notifyMiniProgramSchemeIntercepted() {
        dispatchInteractionEvent(3, 2);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(2, R.style.Theme.DeviceDefault.NoActionBar);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mLandingUrl = arguments.getString("url", "");
            this.mRequestId = arguments.getString("request_id", "");
            this.mTrackId = arguments.getString(ARG_TRACK_ID, "");
            this.mPackageName = arguments.getString("package_name", "");
            this.mAppName = arguments.getString("app_name", "");
            this.mApkMd5 = arguments.getString(ARG_APK_MD5, "");
            this.mApkSize = arguments.getLong("apk_size", -1L);
            this.mApkVerifyType = arguments.getInt(ARG_APK_VERIFY_TYPE, -1);
            this.mTrackLanding = arguments.getBoolean(ARG_TRACK_LANDING, false);
            this.mSessionId = arguments.getInt("session_id", -1);
            this.mInstanceId = arguments.getInt("instance_id", -1);
            this.mSurfaceId = arguments.getInt("surface_id", -1);
            ArrayList parcelableArrayList = arguments.getParcelableArrayList(ARG_LANDING_HEADERS);
            if (parcelableArrayList != null) {
                this.mLandingHeaders.clear();
                this.mLandingHeaders.addAll(parcelableArrayList);
            }
            this.mAdType = AdType.fromWireName(arguments.getString(ARG_AD_TYPE, ""));
        }
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(getActivity());
        frameLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        LinearLayout linearLayout = new LinearLayout(getActivity());
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-1);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        RelativeLayout relativeLayout = new RelativeLayout(getActivity());
        relativeLayout.setBackgroundColor(-1);
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, dp(48)));
        ImageView imageView = new ImageView(getActivity());
        this.mBackBtn = imageView;
        imageView.setImageResource(com.tapsdk.tapad.R.drawable.tapad_dirichlet_ic_back);
        this.mBackBtn.setContentDescription("返回落地页");
        ImageView imageView2 = this.mBackBtn;
        ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER;
        imageView2.setScaleType(scaleType);
        this.mBackBtn.setPadding(dp(10), 0, dp(20), 0);
        this.mBackBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tapsdk.tapad.internal.runtime.plugin.WebViewDialogFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m304lambda$onCreateView$0$comtapsdktapadinternalruntimepluginWebViewDialogFragment(view);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dp(60), -1);
        layoutParams.addRule(9);
        this.mBackBtn.setLayoutParams(layoutParams);
        relativeLayout.addView(this.mBackBtn);
        ImageView imageView3 = new ImageView(getActivity());
        this.mCloseBtn = imageView3;
        imageView3.setImageResource(com.tapsdk.tapad.R.drawable.tapad_dirichlet_ic_close);
        this.mCloseBtn.setContentDescription("关闭落地页");
        this.mCloseBtn.setScaleType(scaleType);
        this.mCloseBtn.setPadding(dp(20), 0, dp(10), 0);
        this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tapsdk.tapad.internal.runtime.plugin.WebViewDialogFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m305lambda$onCreateView$1$comtapsdktapadinternalruntimepluginWebViewDialogFragment(view);
            }
        });
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dp(60), -1);
        layoutParams2.addRule(11);
        this.mCloseBtn.setLayoutParams(layoutParams2);
        relativeLayout.addView(this.mCloseBtn);
        View view = new View(getActivity());
        view.setBackgroundColor(Color.parseColor("#EBEFF0"));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) (getActivity().getResources().getDisplayMetrics().density * 1.5f));
        layoutParams3.addRule(12);
        view.setLayoutParams(layoutParams3);
        relativeLayout.addView(view);
        linearLayout.addView(relativeLayout);
        ProgressBar progressBar = new ProgressBar(getActivity(), null, R.attr.progressBarStyleHorizontal);
        this.mProgressBar = progressBar;
        progressBar.setMax(100);
        this.mProgressBar.setProgress(0);
        this.mProgressBar.setLayoutParams(new LinearLayout.LayoutParams(-1, dp(3)));
        linearLayout.addView(this.mProgressBar);
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        try {
            this.mWebView = createWebView(getActivity());
            this.mWebView.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
            this.mWebView.setBackgroundColor(-1);
            WebSettings settings = this.mWebView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
            settings.setAllowContentAccess(true);
            settings.setAllowFileAccess(false);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setMixedContentMode(2);
            settings.setSupportZoom(true);
            settings.setBuiltInZoomControls(true);
            settings.setDisplayZoomControls(false);
            this.mWebView.removeJavascriptInterface("accessibility");
            this.mWebView.removeJavascriptInterface("accessibilityTraversal");
            this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.tapsdk.tapad.internal.runtime.plugin.WebViewDialogFragment.1
                @Override // android.webkit.WebViewClient
                public void onPageFinished(WebView webView, String str) {
                    super.onPageFinished(webView, str);
                    WebViewDialogFragment.this.notifyLandingPageLoaded(str);
                }

                @Override // android.webkit.WebViewClient
                public void onReceivedError(WebView webView, int i, String str, String str2) {
                    super.onReceivedError(webView, i, str, str2);
                    WebViewDialogFragment.this.loadBlankPage();
                }

                @Override // android.webkit.WebViewClient
                public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                    super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                    if (webResourceRequest == null || webResourceRequest.isForMainFrame()) {
                        if (webResourceResponse != null) {
                            webResourceResponse.getStatusCode();
                        }
                        WebViewDialogFragment.this.loadBlankPage();
                    }
                }

                @Override // android.webkit.WebViewClient
                public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                    super.onReceivedSslError(webView, sslErrorHandler, sslError);
                    Objects.toString(sslError);
                    WebViewDialogFragment.this.loadBlankPage();
                }

                @Override // android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    return WebViewDialogFragment.this.handleUrlLoading(webView, str);
                }

                @Override // android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                    Uri url = webResourceRequest != null ? webResourceRequest.getUrl() : null;
                    return WebViewDialogFragment.this.handleUrlLoading(webView, url != null ? url.toString() : null);
                }

                @Override // android.webkit.WebViewClient
                public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                    super.onReceivedError(webView, webResourceRequest, webResourceError);
                    if (webResourceRequest == null || webResourceRequest.isForMainFrame()) {
                        if (webResourceError != null && Build.VERSION.SDK_INT >= 23) {
                            String.valueOf(webResourceError.getDescription());
                            webResourceError.getErrorCode();
                        }
                        WebViewDialogFragment.this.loadBlankPage();
                    }
                }
            });
            this.mWebView.setWebChromeClient(new WebChromeClient() { // from class: com.tapsdk.tapad.internal.runtime.plugin.WebViewDialogFragment.2
                @Override // android.webkit.WebChromeClient
                public void onProgressChanged(WebView webView, int i) {
                    if (WebViewDialogFragment.this.mProgressBar != null) {
                        WebViewDialogFragment.this.mProgressBar.setProgress(i);
                        WebViewDialogFragment.this.mProgressBar.setVisibility(i < 100 ? 0 : 8);
                    }
                }
            });
            this.mWebView.setDownloadListener(new DownloadListener() { // from class: com.tapsdk.tapad.internal.runtime.plugin.WebViewDialogFragment$$ExternalSyntheticLambda4
                @Override // android.webkit.DownloadListener
                public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    this.f$0.m306lambda$onCreateView$2$comtapsdktapadinternalruntimepluginWebViewDialogFragment(str, str2, str3, str4, j);
                }
            });
            linearLayout.addView(this.mWebView);
            installSafeAreaInsets(linearLayout);
            this.mDownloadController = new WebViewDownloadController(getActivity(), frameLayout, this.mPackageName, this.mAppName, this.mApkMd5, this.mApkSize, this.mApkVerifyType, this.mInstanceId, this.mSurfaceId, this.mSessionId);
            return frameLayout;
        } catch (RuntimeException e) {
            this.mProgressBar.setVisibility(8);
            installSafeAreaInsets(linearLayout);
            return frameLayout;
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onDestroyView() {
        notifyLandingPageClosed();
        WebViewDownloadController webViewDownloadController = this.mDownloadController;
        if (webViewDownloadController != null) {
            webViewDownloadController.destroy();
            this.mDownloadController = null;
        }
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.stopLoading();
            this.mWebView.destroy();
            this.mWebView = null;
        }
        super.onDestroyView();
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.plugin.WebViewDialogFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m307lambda$onDismiss$4$comtapsdktapadinternalruntimepluginWebViewDialogFragment();
            }
        });
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onStart() {
        super.onStart();
        Activity activity = getActivity();
        Dialog dialog = getDialog();
        if (activity == null || activity.isDestroyed() || dialog == null || dialog.getWindow() == null) {
            return;
        }
        Window window = dialog.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            attributes.layoutInDisplayCutoutMode = i >= 30 ? 3 : 1;
        }
        window.setAttributes(attributes);
        window.setBackgroundDrawable(new ColorDrawable(-1));
        window.getDecorView().setBackgroundColor(-1);
        window.clearFlags(1024);
        window.clearFlags(TTAdConstant.KEY_CLICK_AREA);
        window.addFlags(256);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(ViewCompat.MEASURED_STATE_MASK);
        if (i >= 30) {
            window.setDecorFitsSystemWindows(false);
            WindowInsetsController insetsController = window.getInsetsController();
            if (insetsController != null) {
                insetsController.show(WindowInsets.Type.statusBars());
                insetsController.setSystemBarsAppearance(0, 8);
            }
        } else {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility() | 1792;
            int i2 = systemUiVisibility & (-5);
            if (i >= 23) {
                i2 = systemUiVisibility & (-8197);
            }
            decorView.setSystemUiVisibility(i2);
        }
        window.getDecorView().requestApplyInsets();
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (this.mWebView == null || TextUtils.isEmpty(this.mLandingUrl)) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.mOpenStartedAtMs = jCurrentTimeMillis;
        this.mLoadStartedAtMs = jCurrentTimeMillis;
        loadInitialUrl(this.mWebView, this.mLandingUrl, this.mLandingHeaders);
    }

    public void openExternalUrl(String str) {
        Activity activity = getActivity();
        if (activity == null || activity.isDestroyed()) {
            return;
        }
        AndroidLifecycleHost androidLifecycleHost = AndroidLifecycleHost.getInstance();
        long jBeginDeepLinkJump = androidLifecycleHost.beginDeepLinkJump(this.mRequestId, this.mTrackId, str, this.mTrackLanding);
        boolean z = false;
        try {
            Intent uri = Intent.parseUri(str, 1);
            uri.addCategory("android.intent.category.BROWSABLE");
            uri.setComponent(null);
            uri.setSelector(null);
            uri.addFlags(270532608);
            activity.startActivity(uri);
        } catch (Exception e) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.addFlags(C.ENCODING_PCM_MU_LAW);
                activity.startActivity(intent);
            } catch (Exception e2) {
            }
        }
        z = true;
        if (z) {
            androidLifecycleHost.confirmDeepLinkJump(jBeginDeepLinkJump);
        } else {
            androidLifecycleHost.cancelDeepLinkJump(jBeginDeepLinkJump);
        }
    }

    public static WebViewDialogFragment newInstance(String str, String str2, String str3, String str4, boolean z) {
        return newInstance(str, str2, str3, str4, z, null, -1, -1, -1, null, "", "", "", -1L, -1);
    }

    public void dispatchInteractionEvent(int i, int i2, String str) {
        int i3;
        if (this.mSessionId <= 0) {
            return;
        }
        DirichletRuntime dirichletRuntime = DirichletRuntime.getInstance();
        int i4 = this.mInstanceId;
        if (i4 <= 0 || (i3 = this.mSurfaceId) <= 0) {
            dirichletRuntime.triggerInteractionEvent(i, this.mSessionId, i2, str);
        } else {
            dirichletRuntime.triggerInteractionEvent(i4, i3, i, this.mSessionId, i2, str);
        }
    }

    public static WebViewDialogFragment newInstance(String str, String str2, String str3, String str4, boolean z, List<DynamicHeader> list, int i, int i2, int i3, AdType adType, String str5, String str6, String str7, long j, int i4) {
        WebViewDialogFragment webViewDialogFragment = new WebViewDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        bundle.putString("title", str2);
        bundle.putString("request_id", str3);
        bundle.putString(ARG_TRACK_ID, str4);
        bundle.putBoolean(ARG_TRACK_LANDING, z);
        bundle.putInt("session_id", i);
        bundle.putInt("instance_id", i2);
        bundle.putInt("surface_id", i3);
        if (list != null && !list.isEmpty()) {
            bundle.putParcelableArrayList(ARG_LANDING_HEADERS, new ArrayList<>(list));
        }
        if (adType != null) {
            bundle.putString(ARG_AD_TYPE, adType.name());
        }
        bundle.putString("package_name", str5 != null ? str5 : "");
        bundle.putString("app_name", str6 != null ? str6 : "");
        bundle.putString(ARG_APK_MD5, str7 != null ? str7 : "");
        bundle.putLong("apk_size", j);
        bundle.putInt(ARG_APK_VERIFY_TYPE, i4);
        webViewDialogFragment.setArguments(bundle);
        return webViewDialogFragment;
    }
}
