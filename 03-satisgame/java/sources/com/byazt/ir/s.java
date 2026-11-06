package com.byazt.ir;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.text.TextUtils;
import com.byazt.rb.l;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DECODE_SECOND_VIDEO_FRAME_TIME, 8})
public class s {
    public static volatile s n;
    public Map<String, com.byazt.ws.n> s = new ConcurrentHashMap();
    public com.byazt.gwu.s qg = com.byazt.ri.n.q();

    private s() {
    }

    public static s n() {
        if (n == null) {
            synchronized (s.class) {
                if (n == null) {
                    n = new s();
                }
            }
        }
        return n;
    }

    private void qg(JSONObject jSONObject) {
        this.s.clear();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
            com.byazt.ws.n nVarN = com.byazt.ws.n.n(next, jSONObjectOptJSONObject);
            if (jSONObjectOptJSONObject != null && nVarN != null) {
                this.s.put(next, nVarN);
            }
        }
    }

    private void w() {
        String string = this.qg.getString("adn_init_config", null);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (!string.startsWith("[") && !string.startsWith("{")) {
            string = com.byazt.vy.n.qg(string, com.byazt.vy.qg.n());
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            qg(new JSONObject(string));
        } catch (Throwable unused) {
        }
    }

    public void n(final JSONObject jSONObject) {
        if (jSONObject != null) {
            qg(jSONObject);
            if (com.byazt.qt.qg.n().s()) {
                l.q(new Runnable() { // from class: com.byazt.ir.s.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String string = jSONObject.toString();
                        if (TextUtils.isEmpty(string)) {
                            return;
                        }
                        s.this.qg.n("adn_init_config", string);
                    }
                });
            } else {
                String string = jSONObject.toString();
                if (!TextUtils.isEmpty(string)) {
                    this.qg.n("adn_init_config", string);
                }
            }
        }
        s(jSONObject);
    }

    private void s(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        l.q(new Runnable() { // from class: com.byazt.ir.s.2
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.gi.qg.n().n(jSONObject);
            }
        });
    }

    public com.byazt.ws.n n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.s.size() == 0) {
            w();
        }
        return this.s.get(str);
    }

    public List<com.byazt.ws.n> qg() {
        if (this.s.size() == 0) {
            w();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, com.byazt.ws.n>> it = this.s.entrySet().iterator();
        while (it.hasNext()) {
            com.byazt.ws.n value = it.next().getValue();
            if (value != null && value.l()) {
                arrayList.add(value);
            }
        }
        return arrayList;
    }

    public Map<String, com.byazt.ws.n> s() {
        if (this.s.size() == 0) {
            w();
        }
        return new ConcurrentHashMap(this.s);
    }

    public boolean qg(String str) {
        com.byazt.ws.n nVar;
        if (this.s.size() == 0) {
            w();
        }
        Map<String, com.byazt.ws.n> map = this.s;
        return (map == null || (nVar = map.get(str)) == null || !nVar.l()) ? false : true;
    }

    public boolean q() {
        if (this.s.size() == 0) {
            w();
        }
        return this.s.isEmpty();
    }

    private Set<String> x() {
        HashSet hashSet = new HashSet();
        if (this.s.size() != 0) {
            for (Map.Entry<String, com.byazt.ws.n> entry : this.s.entrySet()) {
                com.byazt.ws.n value = entry.getValue();
                if (value != null && !value.l()) {
                    hashSet.add(entry.getKey());
                }
            }
        }
        return hashSet;
    }

    public synchronized void l() {
        Context context = com.byazt.qt.qg.getContext();
        if (context == null) {
            return;
        }
        Set<String> setX = x();
        if (setX.size() == 0) {
            return;
        }
        int i = context.getApplicationInfo().targetSdkVersion;
        com.byazt.rb.qg.qg("TTMediationSDK_SDK_Init", "------------------ 聚合 接入信息 start ---------------------");
        com.byazt.rb.qg.n("TTMediationSDK_SDK_Init", "当前接入的聚合 SDK版本是：" + com.byazt.sg.qg.n());
        List<String> listN = n(context);
        if (listN != null) {
            for (String str : setX) {
                if (!MediationConstant.ADN_UNITY.equals(str) && !MediationConstant.ADN_MINTEGRAL.equals(str) && !MediationConstant.ADN_XIAOMI.equals(str)) {
                    if (!listN.contains(str)) {
                        com.byazt.rb.qg.q("TTMediationSDK_SDK_Init", "未按要求接入三方广告sdk【" + str + "】，请检查接入配置");
                    } else {
                        com.byazt.rb.qg.qg("TTMediationSDK_SDK_Init", "已按要求接入三方广告sdk【" + str + "】");
                    }
                }
            }
        }
        com.byazt.rb.qg.qg("TTMediationSDK_SDK_Init", "------------------ GroMore 接入信息 end ---------------------");
        com.byazt.rb.qg.qg("TTMediationSDK_SDK_Init", "------------------ GroMore 版本信息 start ---------------------");
        for (String str2 : setX) {
            if (!TextUtils.equals(str2, MediationConstant.ADN_PANGLE) && !TextUtils.equals(str2, MediationConstant.ADN_UNITY) && !TextUtils.equals(str2, MediationConstant.ADN_MINTEGRAL)) {
                com.byazt.ju.q qVarN = com.byazt.ya.qg.n().n(str2);
                if (qVarN != null) {
                    qVarN.q();
                } else {
                    com.byazt.rb.qg.q("TTMediationSDK_InitChecker", "没有引入" + str2 + "Adapter,请检查相关引入情况");
                }
            }
        }
        com.byazt.rb.qg.qg("TTMediationSDK_SDK_Init", "------------------ GroMore 版本信息 end ---------------------");
    }

    private List<String> n(Context context) {
        List<ProviderInfo> listQueryContentProviders = context.getPackageManager().queryContentProviders(context.getApplicationInfo().processName, context.getApplicationInfo().uid, 131072);
        if (listQueryContentProviders == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        context.getPackageName();
        Iterator<ProviderInfo> it = listQueryContentProviders.iterator();
        while (it.hasNext()) {
            String str = it.next().name;
            str.hashCode();
            switch (str) {
                case "com.baidu.mobads.sdk.api.BdFileProvider":
                    arrayList.add("baidu");
                    break;
                case "com.mbridge.msdk.foundation.tools.MBFileProvider":
                    arrayList.add(MediationConstant.ADN_MINTEGRAL);
                    break;
                case "com.sigmob.sdk.SigmobFileProvider":
                case "com.sigmob.sdk.SigmobFileV4Provider":
                    arrayList.add(MediationConstant.ADN_SIGMOB);
                    break;
                case "com.tencent.klevin.utils.FileProvider":
                    arrayList.add(MediationConstant.ADN_KLEVIN);
                    break;
                case "com.bykv.vk.openvk.TTFileProvider":
                case "com.bytedance.sdk.openadsdk.TTFileProvider":
                    arrayList.add(MediationConstant.ADN_PANGLE);
                    break;
                case "com.kwad.sdk.api.proxy.app.AdSdkFileProvider":
                    arrayList.add(MediationConstant.ADN_KS);
                    break;
                case "com.unity":
                    arrayList.add(MediationConstant.ADN_UNITY);
                    break;
                case "com.qq.e.comm.GDTFileProvider":
                    arrayList.add(MediationConstant.ADN_GDT);
                    break;
            }
        }
        return arrayList;
    }
}
