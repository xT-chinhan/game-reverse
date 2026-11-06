package com.byazt.ug;

import android.net.Uri;
import android.text.TextUtils;
import com.byazt.hj.DownloadModel;
import com.byazt.ho.BaseConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_QCOM_LOW_LATENCY, 13})
public class w {
    public final ConcurrentHashMap<String, String> n;
    public final ConcurrentHashMap<String, String> qg;

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_QCOM_LOW_LATENCY, 108})
    public static class n {
        public static w n = new w();
    }

    public static w n() {
        return n.n;
    }

    private w() {
        this.n = new ConcurrentHashMap<>();
        this.qg = new ConcurrentHashMap<>();
    }

    public void n(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || this.qg.containsKey(str2)) {
            return;
        }
        this.qg.put(str2, str);
    }

    public String n(String str) {
        if (TextUtils.isEmpty(str) || this.qg.isEmpty() || !this.qg.containsKey(str)) {
            return null;
        }
        String strS = s(str);
        if (this.n.containsValue(strS)) {
            for (Map.Entry<String, String> entry : this.n.entrySet()) {
                if (TextUtils.equals(entry.getValue(), strS)) {
                    String str2 = this.qg.get(entry.getKey());
                    this.qg.put(str, str2);
                    if (!this.n.containsKey(str)) {
                        this.n.put(str, strS);
                    }
                    return str2;
                }
            }
        }
        return this.qg.get(str);
    }

    public String n(DownloadModel downloadModel) {
        String strS = s(downloadModel.getDownloadUrl());
        if (strS == null || TextUtils.isEmpty(strS)) {
            return null;
        }
        String strL = com.byazt.ta.w.l(strS + downloadModel.getPackageName());
        this.qg.put(downloadModel.getDownloadUrl(), strL);
        return strL;
    }

    private String s(String str) {
        try {
            Uri uri = Uri.parse(str);
            String scheme = uri.getScheme();
            String lastPathSegment = uri.getLastPathSegment();
            if (TextUtils.equals(BaseConstants.SCHEME_HTTPS, scheme) && lastPathSegment.endsWith(".apk")) {
                this.n.put(str, lastPathSegment);
                return lastPathSegment;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public void qg(String str) {
        Iterator<Map.Entry<String, String>> it = this.qg.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            if (TextUtils.equals(next.getValue(), str)) {
                it.remove();
                this.n.remove(next.getKey());
            }
        }
    }
}
