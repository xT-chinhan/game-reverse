package com.tapsdk.tapad.internal.ui.views.playable;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tapsdk.tapad.internal.runtime.web.DirichletCreativeWebBridge;
import com.tapsdk.tapad.internal.utils.ActivityUtil;

/* JADX INFO: loaded from: classes3.dex */
public class MRAIDWebView extends WebView {
    private DirichletCreativeWebBridge creativeBridge;
    private MRAIDInterface mraidInterface;
    private OnPageFinishedListener onPageFinishedListener;
    private long pageLoadStartedElapsedMs;
    RestoreWebSettings restoreWebSettings;
    private TelemetryListener telemetryListener;

    public interface OnPageFinishedListener {
        void onPageFinished();
    }

    public interface SoundStateCallback {
        void onStateReceived(boolean z);
    }

    public interface TelemetryListener {
        void onMraidApiCall(String str, String str2);

        void onMraidAudioVolumeChange(double d, double d2);

        void onMraidExposureChange(double d, double d2);

        void onMraidReady(String str);

        void onPageError(int i, String str, String str2);

        void onPageFinished(String str, long j);

        void onPageStarted(String str);
    }

    public MRAIDWebView(Context context) {
        super(context);
        this.pageLoadStartedElapsedMs = -1L;
        initView(context);
    }

    private String getMraidJavaScript() {
        return "(function() {if (typeof mraid !== 'undefined') return;window.mraid = {};var state = 'loading';var isViewable = true;var listeners = {};var exposurePercentage = 0.0;var audioVolume = 1.0;window.MRAID_ENV = JSON.parse(Android.getEnvironmentDetails());mraid.getState = function() { return state; };mraid.isViewable = function() { return isViewable; };mraid.addEventListener = function(event, listener) {if (!listeners[event]) listeners[event] = [];listeners[event].push(listener);};mraid.removeEventListener = function(event, listener) {if (listeners[event]) {var index = listeners[event].indexOf(listener);if (index !== -1) listeners[event].splice(index, 1);}};mraid.fireEvent = function(event, args) {if (listeners[event]) {listeners[event].forEach(function(listener) {try { listener(args); } catch(e) { console.log('MRAID event error:', e); }});}};mraid.close = function() {Android.close();};mraid.open = function(url) {Android.open(url);};mraid.expand = function(url) {Android.expand(url || null);};mraid.getExpandProperties = function() {return JSON.parse(Android.getExpandProperties());};mraid.setExpandProperties = function(properties) {Android.setExpandProperties(JSON.stringify(properties));};mraid.getPlacementType = function() {return 'inline';};mraid.getVersion = function() {if (state === 'loading') return null;return '3.0';};mraid.playVideo = function(url) {Android.playVideo(url);};mraid.storePicture = function(url) {Android.storePicture(url);};mraid.unload = function() {Android.unload();};mraid.getLocation = function() {var loc = Android.getLocation();return loc === '-1' ? null : JSON.parse(loc);};mraid.getExposure = function() {return {exposedPercentage: exposurePercentage, visibleRectangle: null, occlusionRectangles: null};};mraid.getAudioVolume = function() {return audioVolume;};mraid.supports = function(feature) {var supportedFeatures = ['sms', 'tel', 'calendar', 'storePicture', 'inlineVideo', 'location'];if (feature === 'vpaid') return false;return supportedFeatures.indexOf(feature) !== -1;};mraid.fireReadyEvent = function() {state = 'default';mraid.fireEvent('ready');};mraid.fireExposureChangeEvent = function(percentage) {exposurePercentage = percentage;Android.onExposureChange(percentage);mraid.fireEvent('exposureChange', {exposedPercentage: percentage});};mraid.fireAudioVolumeChangeEvent = function(volume) {audioVolume = volume;Android.onAudioVolumeChange(volume * 100);mraid.fireEvent('audioVolumeChange', {volumePercentage: volume * 100});};console.log('MRAID 3.0 initialized with environment:', window.MRAID_ENV);window.super_html = window.super_html || {};window.super_html_channel = 'applovin';window.super_html.download = function() {console.log('[super_html] download called - showing toast');if (typeof Android !== 'undefined' && typeof Android.superHtmlDownload === 'function') {Android.superHtmlDownload();} else {console.log('[super_html] original download method');}};window.super_html.game_ready = function() {console.log('[super_html] game_ready called - showing toast');if (typeof Android !== 'undefined' && typeof Android.superHtmlGameReady === 'function') {Android.superHtmlGameReady();} else {console.log('[super_html] original game_ready method');}if (typeof window.super_boot_engine === 'function') {window.super_boot_engine();}};window.super_html.is_hide_download = function(parameter) {console.log('[super_html] is_hide_download called with parameter:', parameter);if (typeof Android !== 'undefined' && typeof Android.superHtmlIsHideDownload === 'function') {if (parameter !== undefined) {return Android.superHtmlIsHideDownload(String(parameter));} else {return Android.superHtmlIsHideDownload();}} else {console.log('[super_html] original is_hide_download method');return false;}};window.super_html.game_end = function() {console.log('[super_html] game_end called - showing toast');if (typeof Android !== 'undefined' && typeof Android.superHtmlGameEnd === 'function') {Android.superHtmlGameEnd();} else {console.log('[super_html] original game_end method');}};console.log('[WebView] super_html methods overridden with toast notifications');(function() {var originalGameEnd = window.gameEnd;window.gameEnd = function() {console.log('[Window] gameEnd called - 透传模式');if (typeof Android !== 'undefined' && typeof Android.onGameEnd === 'function') {Android.onGameEnd();}if (typeof originalGameEnd === 'function') {return originalGameEnd.apply(this, arguments);}};})();(function() {var originalInstall = window.install;window.install = function() {console.log('[Window] install called - 透传模式');if (typeof Android !== 'undefined' && typeof Android.onInstall === 'function') {Android.onInstall();}if (typeof originalInstall === 'function') {return true}};})();(function() {var originalGameReady = window.gameReady;window.gameReady = function() {console.log('[Window] gameReady called - 透传模式');if (typeof Android !== 'undefined' && typeof Android.onGameReady === 'function') {Android.onGameReady();}if (typeof originalGameReady === 'function') {return originalGameReady.apply(this, arguments);}};})();(function() {var originalRenderFail = window.renderFail;window.renderFail = function() {console.log('[Window] renderFail called - 透传模式');if (typeof Android !== 'undefined' && typeof Android.onRenderFail === 'function') {Android.onRenderFail();}if (typeof originalRenderFail === 'function') {return originalRenderFail.apply(this, arguments);}};})();(function() {var originalGameClose = window.gameClose;window.gameClose = function() {console.log('[Window] gameClose called - 透传模式');if (typeof Android !== 'undefined' && typeof Android.onGameClose === 'function') {Android.onGameClose();}if (typeof originalGameClose === 'function') {return originalGameClose.apply(this, arguments);}};})();(function() {var originalGameRetry = window.gameRetry;window.gameRetry = function() {console.log('[Window] gameRetry called - 透传模式');if (typeof Android !== 'undefined' && typeof Android.onGameRetry === 'function') {Android.onGameRetry();}if (typeof originalGameRetry === 'function') {return originalGameRetry.apply(this, arguments);}};})();console.log('[WebView] Window game methods monitoring enabled (透传模式)');})();";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void injectMRAIDJS() {
        evaluateJavascript(getMraidJavaScript(), new ValueCallback() { // from class: com.tapsdk.tapad.internal.ui.views.playable.MRAIDWebView$$ExternalSyntheticLambda0
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                this.f$0.m391lambda$injectMRAIDJS$0$comtapsdktapadinternaluiviewsplayableMRAIDWebView((String) obj);
            }
        });
    }

    static /* synthetic */ void lambda$getGameSoundState$1(SoundStateCallback soundStateCallback, String str) {
        boolean zEquals = "true".equals(str);
        if (soundStateCallback != null) {
            soundStateCallback.onStateReceived(zEquals);
        }
    }

    private void printWebSettings(boolean z, String str) {
        WebSettings settings = getSettings();
        settings.getJavaScriptEnabled();
        settings.getDomStorageEnabled();
        settings.getMediaPlaybackRequiresUserGesture();
        settings.getMixedContentMode();
    }

    private void setupWebView(Context context) {
        printWebSettings(true, "setupWebView");
        WebSettings settings = getSettings();
        this.restoreWebSettings = new RestoreWebSettings.Builder().withEnableJavaScript(settings.getJavaScriptEnabled()).withEnableDomStorage(settings.getDomStorageEnabled()).withMediaPlaybackRequiresUserGesture(settings.getMediaPlaybackRequiresUserGesture()).withMixContentMode(settings.getMixedContentMode()).build();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setMixedContentMode(0);
        printWebSettings(false, "setupWebView");
        CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
        MRAIDInterface mRAIDInterface = new MRAIDInterface(ActivityUtil.getActivity(context));
        this.mraidInterface = mRAIDInterface;
        mRAIDInterface.setTelemetryListener(this.telemetryListener);
        addJavascriptInterface(this.mraidInterface, "Android");
        setWebViewClient(new WebViewClient() { // from class: com.tapsdk.tapad.internal.ui.views.playable.MRAIDWebView.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                MRAIDWebView.this.injectMRAIDJS();
                long j = MRAIDWebView.this.pageLoadStartedElapsedMs;
                long jMax = j >= 0 ? Math.max(0L, SystemClock.elapsedRealtime() - j) : 0L;
                TelemetryListener telemetryListener = MRAIDWebView.this.telemetryListener;
                if (telemetryListener != null) {
                    telemetryListener.onPageFinished(str, jMax);
                }
                if (MRAIDWebView.this.creativeBridge != null) {
                    MRAIDWebView.this.creativeBridge.onPageFinished();
                }
                if (MRAIDWebView.this.onPageFinishedListener != null) {
                    MRAIDWebView.this.onPageFinishedListener.onPageFinished();
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                MRAIDWebView.this.pageLoadStartedElapsedMs = SystemClock.elapsedRealtime();
                TelemetryListener telemetryListener = MRAIDWebView.this.telemetryListener;
                if (telemetryListener != null) {
                    telemetryListener.onPageStarted(str);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                TelemetryListener telemetryListener = MRAIDWebView.this.telemetryListener;
                if (telemetryListener != null) {
                    telemetryListener.onPageError(i, str, str2);
                }
            }
        });
    }

    public void getGameSoundState(final SoundStateCallback soundStateCallback) {
        evaluateJavascript("window.isGameMuted();", new ValueCallback() { // from class: com.tapsdk.tapad.internal.ui.views.playable.MRAIDWebView$$ExternalSyntheticLambda1
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                MRAIDWebView.lambda$getGameSoundState$1(soundStateCallback, (String) obj);
            }
        });
    }

    public void initView(Context context) {
        setupWebView(context);
    }

    /* JADX INFO: renamed from: lambda$injectMRAIDJS$0$com-tapsdk-tapad-internal-ui-views-playable-MRAIDWebView, reason: not valid java name */
    /* synthetic */ void m391lambda$injectMRAIDJS$0$comtapsdktapadinternaluiviewsplayableMRAIDWebView(String str) {
        TelemetryListener telemetryListener = this.telemetryListener;
        if (telemetryListener != null) {
            telemetryListener.onMraidReady("3.0");
        }
    }

    public void muteGameSound() {
        evaluateJavascript("window.forceMuted(true);", null);
    }

    public void onBackPressed() {
        MRAIDInterface mRAIDInterface = this.mraidInterface;
        if (mRAIDInterface != null) {
            mRAIDInterface.close();
        }
    }

    public void onDestroy() {
        printWebSettings(true, "onDestroy");
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(this.restoreWebSettings.enableJavaScript);
        settings.setDomStorageEnabled(this.restoreWebSettings.enableDomStorage);
        settings.setMediaPlaybackRequiresUserGesture(this.restoreWebSettings.mediaPlaybackRequiresUserGesture);
        settings.setMixedContentMode(this.restoreWebSettings.mixContentMode);
        CookieManager.getInstance().setAcceptThirdPartyCookies(this, false);
        DirichletCreativeWebBridge dirichletCreativeWebBridge = this.creativeBridge;
        if (dirichletCreativeWebBridge != null) {
            dirichletCreativeWebBridge.detach();
            this.creativeBridge = null;
        }
        printWebSettings(false, "onDestroy");
        destroy();
    }

    @Override // android.webkit.WebView
    public void onPause() {
        super.onPause();
        evaluateJavascript("if(typeof mraid !== 'undefined') { mraid.fireEvent('viewableChange', {viewable: false}); }", null);
    }

    @Override // android.webkit.WebView
    public void onResume() {
        super.onResume();
        evaluateJavascript("if(typeof mraid !== 'undefined') { mraid.fireEvent('viewableChange', {viewable: true}); }", null);
    }

    public void setDirichletCreativeBridge(DirichletCreativeWebBridge dirichletCreativeWebBridge) {
        DirichletCreativeWebBridge dirichletCreativeWebBridge2 = this.creativeBridge;
        if (dirichletCreativeWebBridge2 != null) {
            dirichletCreativeWebBridge2.detach();
        }
        this.creativeBridge = dirichletCreativeWebBridge;
        if (dirichletCreativeWebBridge != null) {
            dirichletCreativeWebBridge.attach(this);
        }
    }

    public void setGameLifeCircleInterface(GameLifeCircleInterface gameLifeCircleInterface) {
        MRAIDInterface mRAIDInterface = this.mraidInterface;
        if (mRAIDInterface != null) {
            mRAIDInterface.setGameLifeCircleInterface(gameLifeCircleInterface);
        }
    }

    public void setOnPageFinishedListener(OnPageFinishedListener onPageFinishedListener) {
        this.onPageFinishedListener = onPageFinishedListener;
    }

    public void setTelemetryListener(TelemetryListener telemetryListener) {
        this.telemetryListener = telemetryListener;
        MRAIDInterface mRAIDInterface = this.mraidInterface;
        if (mRAIDInterface != null) {
            mRAIDInterface.setTelemetryListener(telemetryListener);
        }
    }

    public void unMuteGameSound() {
        evaluateJavascript("window.forceMuted(false);", null);
    }

    public MRAIDWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pageLoadStartedElapsedMs = -1L;
        initView(context);
    }

    public MRAIDWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pageLoadStartedElapsedMs = -1L;
        initView(context);
    }

    public MRAIDWebView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.pageLoadStartedElapsedMs = -1L;
        initView(context);
    }
}
