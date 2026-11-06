package com.bytedance.sdk.component.widget.web;

import android.webkit.JavascriptInterface;
import com.bytedance.sdk.component.utils.sl;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Object f1539ms;
    private final String xr;

    public ms(Object obj, String str) {
        this.f1539ms = obj;
        this.xr = str;
    }

    public Object ms() {
        return this.f1539ms;
    }

    public String xr() {
        return this.xr;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0022 A[Catch: Exception -> 0x0039, TryCatch #0 {Exception -> 0x0039, blocks: (B:4:0x0003, B:6:0x0006, B:7:0x0009, B:9:0x000c, B:10:0x0017, B:12:0x002e, B:11:0x0022), top: B:17:0x0003 }] */
    private Object ms(String str, Object... objArr) {
        Method declaredMethod;
        if (objArr != null) {
            try {
                if (objArr.length > 0) {
                    Class<?>[] clsArr = new Class[objArr.length];
                    for (int i = 0; i < objArr.length; i++) {
                        clsArr[i] = objArr[i].getClass();
                    }
                    declaredMethod = this.f1539ms.getClass().getDeclaredMethod(str, clsArr);
                } else {
                    declaredMethod = this.f1539ms.getClass().getDeclaredMethod(str, new Class[0]);
                }
            } catch (Exception e) {
                sl.xr("JavascriptInterfaceProxy", "invokeMethod name= ".concat(String.valueOf(str)), e);
                return null;
            }
        } else {
            declaredMethod = this.f1539ms.getClass().getDeclaredMethod(str, new Class[0]);
        }
        declaredMethod.setAccessible(true);
        return declaredMethod.invoke(this.f1539ms, objArr);
    }

    @JavascriptInterface
    public Object invokeMethod(String str) {
        return ms("invokeMethod", str);
    }

    @JavascriptInterface
    public String adInfo() {
        Object objMs = ms("adInfo", new Object[0]);
        return objMs != null ? objMs.toString() : "";
    }

    @JavascriptInterface
    public String appInfo() {
        Object objMs = ms("appInfo", new Object[0]);
        return objMs != null ? objMs.toString() : "";
    }

    @JavascriptInterface
    public String getTemplateInfo() {
        Object objMs = ms("getTemplateInfo", new Object[0]);
        return objMs != null ? objMs.toString() : "";
    }

    @JavascriptInterface
    public void renderDidFinish(String str) {
        ms("renderDidFinish", str);
    }

    @JavascriptInterface
    public void adAnalysisData(String str) {
        ms("adAnalysisData", str);
    }

    @JavascriptInterface
    public void muteVideo(String str) {
        ms("muteVideo", str);
    }

    @JavascriptInterface
    public void dynamicTrack(String str) {
        ms("dynamicTrack", str);
    }

    @JavascriptInterface
    public void changeVideoState(String str) {
        ms("changeVideoState", str);
    }

    @JavascriptInterface
    public void clickEvent(String str) {
        ms("clickEvent", str);
    }

    @JavascriptInterface
    public void skipVideo() {
        ms("skipVideo", new Object[0]);
    }

    @JavascriptInterface
    public String getCurrentVideoState() {
        Object objMs = ms("getCurrentVideoState", new Object[0]);
        return objMs != null ? objMs.toString() : "";
    }

    @JavascriptInterface
    public void initRenderFinish() {
        ms("initRenderFinish", new Object[0]);
    }

    @JavascriptInterface
    public void requestPauseVideo(String str) {
        ms("requestPauseVideo", str);
    }

    @JavascriptInterface
    public String getData(String str) {
        Object objMs = ms("getData", str);
        return objMs != null ? objMs.toString() : "";
    }

    @JavascriptInterface
    public String sendNetworkSwitch(String str) {
        Object objMs = ms("sendNetworkSwitch", str);
        return objMs != null ? objMs.toString() : "";
    }

    @JavascriptInterface
    public void readPercent(String str) {
        ms("readPercent", str);
    }

    @JavascriptInterface
    public void getUrl(String str) {
        ms("getUrl", str);
    }

    @JavascriptInterface
    public void readHtml(String str, String str2) {
        ms("readHtml", str, str2);
    }
}
