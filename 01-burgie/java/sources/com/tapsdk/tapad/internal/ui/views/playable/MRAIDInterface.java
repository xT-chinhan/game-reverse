package com.tapsdk.tapad.internal.ui.views.playable;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import com.bytedance.android.live.base.api.push.ILivePush;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class MRAIDInterface {
    private static final String TAG = "MRAIDInterface";
    private final Activity activity;
    private double currentExposurePercentage;
    private double currentVolumePercentage = 1.0d;
    private GameLifeCircleInterface gameLifeCircleInterface;
    private MRAIDWebView.TelemetryListener telemetryListener;

    public MRAIDInterface(Activity activity) {
        this.activity = activity;
    }

    static /* synthetic */ void lambda$showToast$5(String str) {
    }

    static /* synthetic */ void lambda$storePicture$2() {
    }

    private void reportApiCall(String str, String str2) {
        MRAIDWebView.TelemetryListener telemetryListener = this.telemetryListener;
        if (telemetryListener != null) {
            telemetryListener.onMraidApiCall(str, str2);
        }
    }

    @JavascriptInterface
    public void close() {
        reportApiCall(ILivePush.ClickType.CLOSE, null);
        this.activity.runOnUiThread(new Runnable() { // from class: com.tapsdk.tapad.internal.ui.views.playable.MRAIDInterface$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m387lambda$close$4$comtapsdktapadinternaluiviewsplayableMRAIDInterface();
            }
        });
    }

    @JavascriptInterface
    public void expand(String str) {
        reportApiCall("expand", str);
        if (str == null || str.isEmpty()) {
            return;
        }
        open(str);
    }

    @JavascriptInterface
    public double getCurrentAudioVolume() {
        return 1.0d;
    }

    @JavascriptInterface
    public String getEnvironmentDetails() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", "3.0");
            jSONObject.put("sdk", "PlayableDemo");
            jSONObject.put("sdkVersion", "1.0");
            return jSONObject.toString();
        } catch (JSONException e) {
            return "{}";
        }
    }

    @JavascriptInterface
    public String getExpandProperties() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("width", this.activity.getResources().getDisplayMetrics().widthPixels);
            jSONObject.put("height", this.activity.getResources().getDisplayMetrics().heightPixels);
            jSONObject.put("useCustomClose", false);
            jSONObject.put("isModal", true);
            return jSONObject.toString();
        } catch (JSONException e) {
            return "{}";
        }
    }

    @JavascriptInterface
    public String getLocation() {
        return "-1";
    }

    public void handleMraidUrl(String str) {
        if (str.startsWith("mraid://close")) {
            close();
        }
    }

    /* JADX INFO: renamed from: lambda$close$4$com-tapsdk-tapad-internal-ui-views-playable-MRAIDInterface, reason: not valid java name */
    /* synthetic */ void m387lambda$close$4$comtapsdktapadinternaluiviewsplayableMRAIDInterface() {
        this.activity.finish();
    }

    /* JADX INFO: renamed from: lambda$open$0$com-tapsdk-tapad-internal-ui-views-playable-MRAIDInterface, reason: not valid java name */
    /* synthetic */ void m388lambda$open$0$comtapsdktapadinternaluiviewsplayableMRAIDInterface(String str) {
        try {
            this.activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (Exception e) {
            Toast.makeText(this.activity, "无法打开链接", 0).show();
        }
    }

    /* JADX INFO: renamed from: lambda$playVideo$1$com-tapsdk-tapad-internal-ui-views-playable-MRAIDInterface, reason: not valid java name */
    /* synthetic */ void m389lambda$playVideo$1$comtapsdktapadinternaluiviewsplayableMRAIDInterface(String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), "video/*");
            this.activity.startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this.activity, "无法播放视频", 0).show();
        }
    }

    /* JADX INFO: renamed from: lambda$unload$3$com-tapsdk-tapad-internal-ui-views-playable-MRAIDInterface, reason: not valid java name */
    /* synthetic */ void m390lambda$unload$3$comtapsdktapadinternaluiviewsplayableMRAIDInterface() {
        this.activity.finish();
    }

    @JavascriptInterface
    public void onAudioVolumeChange(float f) {
        double d = this.currentVolumePercentage;
        double d2 = f;
        this.currentVolumePercentage = d2;
        MRAIDWebView.TelemetryListener telemetryListener = this.telemetryListener;
        if (telemetryListener != null) {
            telemetryListener.onMraidAudioVolumeChange(d2, d);
        }
    }

    @JavascriptInterface
    public void onExposureChange(float f) {
        double d = this.currentExposurePercentage;
        double d2 = f;
        this.currentExposurePercentage = d2;
        MRAIDWebView.TelemetryListener telemetryListener = this.telemetryListener;
        if (telemetryListener != null) {
            telemetryListener.onMraidExposureChange(d2, d);
        }
    }

    @JavascriptInterface
    public void onGameClose() {
        showToast("🚪 监听到游戏关闭调用");
    }

    @JavascriptInterface
    public void onGameEnd() {
        showToast("🎮 监听到游戏结束调用");
        GameLifeCircleInterface gameLifeCircleInterface = this.gameLifeCircleInterface;
        if (gameLifeCircleInterface != null) {
            gameLifeCircleInterface.onGameEnd();
        }
    }

    @JavascriptInterface
    public void onGameReady() {
        showToast("🎯 监听到游戏准备就绪调用");
        GameLifeCircleInterface gameLifeCircleInterface = this.gameLifeCircleInterface;
        if (gameLifeCircleInterface != null) {
            gameLifeCircleInterface.onGameReady();
        }
    }

    @JavascriptInterface
    public void onGameRetry() {
        showToast("🔄 监听到游戏重试调用");
    }

    @JavascriptInterface
    public void onInstall() {
        showToast("📱 监听到安装游戏调用");
        GameLifeCircleInterface gameLifeCircleInterface = this.gameLifeCircleInterface;
        if (gameLifeCircleInterface != null) {
            gameLifeCircleInterface.onGameInstalled();
        }
    }

    @JavascriptInterface
    public void onRenderFail() {
        showToast("❌ 监听到渲染失败调用");
        GameLifeCircleInterface gameLifeCircleInterface = this.gameLifeCircleInterface;
        if (gameLifeCircleInterface != null) {
            gameLifeCircleInterface.onRenderFailed();
        }
    }

    @JavascriptInterface
    public void open(final String str) {
        reportApiCall("open", str);
        this.activity.runOnUiThread(new Runnable() { // from class: com.tapsdk.tapad.internal.ui.views.playable.MRAIDInterface$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m388lambda$open$0$comtapsdktapadinternaluiviewsplayableMRAIDInterface(str);
            }
        });
    }

    @JavascriptInterface
    public void playVideo(final String str) {
        reportApiCall("playVideo", str);
        this.activity.runOnUiThread(new Runnable() { // from class: com.tapsdk.tapad.internal.ui.views.playable.MRAIDInterface$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m389lambda$playVideo$1$comtapsdktapadinternaluiviewsplayableMRAIDInterface(str);
            }
        });
    }

    @JavascriptInterface
    public void setExpandProperties(String str) {
    }

    public void setGameLifeCircleInterface(GameLifeCircleInterface gameLifeCircleInterface) {
        this.gameLifeCircleInterface = gameLifeCircleInterface;
    }

    public void setTelemetryListener(MRAIDWebView.TelemetryListener telemetryListener) {
        this.telemetryListener = telemetryListener;
    }

    @JavascriptInterface
    public void showToast(final String str) {
        this.activity.runOnUiThread(new Runnable() { // from class: com.tapsdk.tapad.internal.ui.views.playable.MRAIDInterface$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                MRAIDInterface.lambda$showToast$5(str);
            }
        });
    }

    @JavascriptInterface
    public void storePicture(String str) {
        this.activity.runOnUiThread(new Runnable() { // from class: com.tapsdk.tapad.internal.ui.views.playable.MRAIDInterface$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MRAIDInterface.lambda$storePicture$2();
            }
        });
    }

    @JavascriptInterface
    public void superHtmlDownload() {
        showToast("游戏下载");
        GameLifeCircleInterface gameLifeCircleInterface = this.gameLifeCircleInterface;
        if (gameLifeCircleInterface != null) {
            gameLifeCircleInterface.onGameInstalled();
        }
    }

    @JavascriptInterface
    public void superHtmlGameEnd() {
        showToast("游戏结束");
        GameLifeCircleInterface gameLifeCircleInterface = this.gameLifeCircleInterface;
        if (gameLifeCircleInterface != null) {
            gameLifeCircleInterface.onGameReady();
        }
    }

    @JavascriptInterface
    public void superHtmlGameReady() {
        showToast("游戏准备就绪");
        GameLifeCircleInterface gameLifeCircleInterface = this.gameLifeCircleInterface;
        if (gameLifeCircleInterface != null) {
            gameLifeCircleInterface.onGameReady();
        }
    }

    @JavascriptInterface
    public void unload() {
        reportApiCall("unload", null);
        this.activity.runOnUiThread(new Runnable() { // from class: com.tapsdk.tapad.internal.ui.views.playable.MRAIDInterface$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m390lambda$unload$3$comtapsdktapadinternaluiviewsplayableMRAIDInterface();
            }
        });
    }
}
