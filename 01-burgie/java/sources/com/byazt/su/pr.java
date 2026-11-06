package com.byazt.su;

import android.webkit.JavascriptInterface;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE, 37})
public abstract class pr {
    public final String hw;
    public final Object pr;

    public pr(Object obj, String str) {
        this.pr = obj;
        this.hw = str;
    }

    public Object pr() {
        return this.pr;
    }

    public String hw() {
        return this.hw;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0023 A[Catch: Exception -> 0x003a, TryCatch #0 {Exception -> 0x003a, blocks: (B:4:0x0003, B:6:0x0006, B:7:0x000a, B:9:0x000d, B:10:0x0018, B:12:0x002f, B:11:0x0023), top: B:17:0x0003 }] */
    private Object pr(String str, Object... objArr) {
        Method declaredMethod;
        if (objArr == null) {
            declaredMethod = this.pr.getClass().getDeclaredMethod(str, new Class[0]);
        } else {
            try {
                if (objArr.length <= 0) {
                    declaredMethod = this.pr.getClass().getDeclaredMethod(str, new Class[0]);
                } else {
                    Class<?>[] clsArr = new Class[objArr.length];
                    for (int i = 0; i < objArr.length; i++) {
                        clsArr[i] = objArr[i].getClass();
                    }
                    declaredMethod = this.pr.getClass().getDeclaredMethod(str, clsArr);
                }
            } catch (Exception e) {
                return null;
            }
        }
        declaredMethod.setAccessible(true);
        return declaredMethod.invoke(this.pr, objArr);
    }

    @JavascriptInterface
    public Object invokeMethod(String str) {
        return pr("invokeMethod", str);
    }

    @JavascriptInterface
    public String adInfo() {
        Object objPr = pr("adInfo", new Object[0]);
        return objPr != null ? objPr.toString() : "";
    }

    @JavascriptInterface
    public String appInfo() {
        Object objPr = pr("appInfo", new Object[0]);
        return objPr != null ? objPr.toString() : "";
    }

    @JavascriptInterface
    public String getTemplateInfo() {
        Object objPr = pr("getTemplateInfo", new Object[0]);
        return objPr != null ? objPr.toString() : "";
    }

    @JavascriptInterface
    public void renderDidFinish(String str) {
        pr("renderDidFinish", str);
    }

    @JavascriptInterface
    public void adAnalysisData(String str) {
        pr("adAnalysisData", str);
    }

    @JavascriptInterface
    public void muteVideo(String str) {
        pr("muteVideo", str);
    }

    @JavascriptInterface
    public void dynamicTrack(String str) {
        pr("dynamicTrack", str);
    }

    @JavascriptInterface
    public void changeVideoState(String str) {
        pr("changeVideoState", str);
    }

    @JavascriptInterface
    public void clickEvent(String str) {
        pr("clickEvent", str);
    }

    @JavascriptInterface
    public void skipVideo() {
        pr("skipVideo", new Object[0]);
    }

    @JavascriptInterface
    public String getCurrentVideoState() {
        Object objPr = pr("getCurrentVideoState", new Object[0]);
        return objPr != null ? objPr.toString() : "";
    }

    @JavascriptInterface
    public void initRenderFinish() {
        pr("initRenderFinish", new Object[0]);
    }

    @JavascriptInterface
    public void requestPauseVideo(String str) {
        pr("requestPauseVideo", str);
    }

    @JavascriptInterface
    public String getData(String str) {
        Object objPr = pr("getData", str);
        return objPr != null ? objPr.toString() : "";
    }

    @JavascriptInterface
    public String sendNetworkSwitch(String str) {
        Object objPr = pr("sendNetworkSwitch", str);
        return objPr != null ? objPr.toString() : "";
    }

    @JavascriptInterface
    public int getNetOperatorType() {
        Object objPr = pr("getNetOperatorType", new Object[0]);
        if (objPr instanceof Integer) {
            return ((Integer) objPr).intValue();
        }
        return -3;
    }

    @JavascriptInterface
    public void readPercent(String str) {
        pr("readPercent", str);
    }

    @JavascriptInterface
    public void getUrl(String str) {
        pr("getUrl", str);
    }

    @JavascriptInterface
    public void readHtml(String str, String str2) {
        pr("readHtml", str, str2);
    }
}
