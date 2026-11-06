package com.byazt.jp;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPEN_TIME, 13})
public class w {
    public Map<String, String> fs;
    public final String n = MediationConstant.TAG;
    public String qg = "";
    public String s = "";
    public String q = "";
    public int l = 0;
    public String w = "";
    public String x = "";

    public void n(Map<String, String> map) {
        this.fs = new HashMap();
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                if (!w(entry.getKey())) {
                    com.byazt.tk.k.qg(MediationConstant.TAG, "流量分组" + entry.getKey() + "字段存在不合法输入");
                } else if (!w(entry.getValue())) {
                    com.byazt.tk.k.qg(MediationConstant.TAG, "流量分组" + entry.getKey() + "字段的值" + entry.getValue() + "存在不合法输入");
                } else {
                    this.fs.put(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public Map<String, String> n() {
        return this.fs;
    }

    public String qg() {
        return this.qg;
    }

    public void n(String str) {
        if (w(str)) {
            this.qg = str;
        } else {
            com.byazt.tk.k.qg(MediationConstant.TAG, "流量分组user_id字段存在不合法输入");
        }
    }

    public String s() {
        return this.s;
    }

    public void qg(String str) {
        if (w(str)) {
            this.s = str;
        } else {
            com.byazt.tk.k.qg(MediationConstant.TAG, "流量分组channer字段存在不合法输入");
        }
    }

    public String q() {
        return this.q;
    }

    public void s(String str) {
        if (w(str)) {
            this.q = str;
        } else {
            com.byazt.tk.k.qg(MediationConstant.TAG, "流量分组sub_channer字段存在不合法输入");
        }
    }

    public int l() {
        return this.l;
    }

    public void n(int i) {
        this.l = i;
    }

    public String w() {
        return this.w;
    }

    public void q(String str) {
        if (w(str)) {
            this.w = str;
        } else {
            com.byazt.tk.k.qg(MediationConstant.TAG, "流量分组gender字段存在不合法输入");
        }
    }

    public String x() {
        return this.x;
    }

    public void l(String str) {
        if (w(str)) {
            this.x = str;
        } else {
            com.byazt.tk.k.qg(MediationConstant.TAG, "流量分组user_value_group字段存在不合法输入");
        }
    }

    public boolean equals(Object obj) {
        boolean z;
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            w wVar = (w) obj;
            boolean z2 = l() == wVar.l() && TextUtils.equals(x(), wVar.x()) && TextUtils.equals(qg(), wVar.qg()) && TextUtils.equals(s(), wVar.s()) && TextUtils.equals(q(), wVar.q()) && TextUtils.equals(w(), wVar.w());
            Map<String, String> mapN = wVar.n();
            Map<String, String> map = this.fs;
            if (map == null || mapN == null) {
                z = map == null && mapN == null;
            } else {
                if (map.size() == mapN.size()) {
                    Iterator<String> it = this.fs.keySet().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            String next = it.next();
                            if (TextUtils.isEmpty(next) || TextUtils.equals(this.fs.get(next), mapN.get(next))) {
                            }
                        }
                    }
                }
            }
            if (z2 && z) {
                return true;
            }
        }
        return false;
    }

    public static boolean w(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("[A-Za-z0-9-_]{1,100}");
    }
}
