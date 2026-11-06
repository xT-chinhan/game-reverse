package com.byazt.qza;

import android.webkit.JavascriptInterface;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_TIME_BAR_PERCENTAGE, 19})
public abstract class n {
    public final Object n;
    public final String qg;

    public n(Object obj, String str) {
        this.n = obj;
        this.qg = str;
    }

    public Object n() {
        return this.n;
    }

    public String qg() {
        return this.qg;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0022 A[Catch: Exception -> 0x0039, TryCatch #0 {Exception -> 0x0039, blocks: (B:4:0x0003, B:6:0x0006, B:7:0x0009, B:9:0x000c, B:10:0x0017, B:12:0x002e, B:11:0x0022), top: B:16:0x0003 }] */
    private Object n(String str, Object... objArr) {
        Method declaredMethod;
        if (objArr != null) {
            try {
                if (objArr.length > 0) {
                    Class<?>[] clsArr = new Class[objArr.length];
                    for (int i = 0; i < objArr.length; i++) {
                        clsArr[i] = objArr[i].getClass();
                    }
                    declaredMethod = this.n.getClass().getDeclaredMethod(str, clsArr);
                } else {
                    declaredMethod = this.n.getClass().getDeclaredMethod(str, new Class[0]);
                }
            } catch (Exception unused) {
                return null;
            }
        } else {
            declaredMethod = this.n.getClass().getDeclaredMethod(str, new Class[0]);
        }
        declaredMethod.setAccessible(true);
        return declaredMethod.invoke(this.n, objArr);
    }

    @JavascriptInterface
    public Object invokeMethod(String str) {
        return n("invokeMethod", str);
    }

    @JavascriptInterface
    public String adInfo() {
        Object objN = n("adInfo", new Object[0]);
        return objN != null ? objN.toString() : "";
    }

    @JavascriptInterface
    public String appInfo() {
        Object objN = n("appInfo", new Object[0]);
        return objN != null ? objN.toString() : "";
    }

    @JavascriptInterface
    public String getTemplateInfo() {
        Object objN = n("getTemplateInfo", new Object[0]);
        return objN != null ? objN.toString() : "";
    }

    @JavascriptInterface
    public void renderDidFinish(String str) {
        n("renderDidFinish", str);
    }

    @JavascriptInterface
    public void adAnalysisData(String str) {
        n("adAnalysisData", str);
    }

    @JavascriptInterface
    public void muteVideo(String str) {
        n("muteVideo", str);
    }

    @JavascriptInterface
    public void dynamicTrack(String str) {
        n("dynamicTrack", str);
    }

    @JavascriptInterface
    public void changeVideoState(String str) {
        n("changeVideoState", str);
    }

    @JavascriptInterface
    public void clickEvent(String str) {
        n("clickEvent", str);
    }

    @JavascriptInterface
    public void skipVideo() {
        n("skipVideo", new Object[0]);
    }

    @JavascriptInterface
    public String getCurrentVideoState() {
        Object objN = n("getCurrentVideoState", new Object[0]);
        return objN != null ? objN.toString() : "";
    }

    @JavascriptInterface
    public void initRenderFinish() {
        n("initRenderFinish", new Object[0]);
    }

    @JavascriptInterface
    public void requestPauseVideo(String str) {
        n("requestPauseVideo", str);
    }

    @JavascriptInterface
    public String getData(String str) {
        Object objN = n("getData", str);
        return objN != null ? objN.toString() : "";
    }

    @JavascriptInterface
    public String sendNetworkSwitch(String str) {
        Object objN = n("sendNetworkSwitch", str);
        return objN != null ? objN.toString() : "";
    }

    @JavascriptInterface
    public int getNetOperatorType() {
        Object objN = n("getNetOperatorType", new Object[0]);
        if (objN instanceof Integer) {
            return ((Integer) objN).intValue();
        }
        return -3;
    }

    @JavascriptInterface
    public void readPercent(String str) {
        n("readPercent", str);
    }

    @JavascriptInterface
    public void getUrl(String str) {
        n("getUrl", str);
    }

    @JavascriptInterface
    public void readHtml(String str, String str2) {
        n("readHtml", str, str2);
    }
}
