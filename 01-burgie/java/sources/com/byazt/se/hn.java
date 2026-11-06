package com.byazt.se;

import android.content.Context;
import android.os.Process;
import com.byazt.vlj.zo;
import com.byazt.wf.ho;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.umeng.analytics.pro.an;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RENDER_STALL_THRESHOLD, 20})
public abstract class hn {
    public x c;
    public com.byazt.vlj.c hn = zo.pr().hn();
    public Context hw;
    public com.byazt.vlj.hn pr;
    public hw x;

    public hn(com.byazt.vlj.hn hnVar, Context context, hw hwVar, x xVar) {
        this.pr = hnVar;
        this.hw = context;
        this.x = hwVar;
        this.c = xVar;
    }

    public com.byazt.lee.pr pr(com.byazt.lee.pr prVar) {
        if (prVar == null) {
            prVar = new com.byazt.lee.pr();
        }
        hw(prVar);
        c(prVar);
        return prVar;
    }

    public void hw(com.byazt.lee.pr prVar) {
        hw hwVar;
        if (hw() && (hwVar = this.x) != null) {
            prVar.pr(hwVar);
        }
        prVar.pr(zo.uc());
        hw hwVar2 = this.x;
        prVar.pr("is_background", Boolean.valueOf((hwVar2 == null || !hwVar2.hn()) && !com.byazt.wf.pr.pr(this.hw)));
        prVar.pr("pid", Integer.valueOf(Process.myPid()));
        prVar.pr(an.Z, Integer.valueOf(this.c.pr()));
        prVar.pr(this.hn.c());
        prVar.hw(zo.aj());
        prVar.pr(zo.vk(), zo.w());
        prVar.pr(this.hn.uc());
        prVar.pr(ho.pr(this.hw));
        if (pr()) {
            x(prVar);
        }
        prVar.pr(this.hn.x());
        String strFw = zo.fw();
        if (strFw != null) {
            prVar.pr("business", strFw);
        }
        if (zo.zo()) {
            prVar.pr("is_mp", (Object) 1);
        }
        prVar.hn(zo.hw().pr());
        prVar.pr("crash_uuid", UUID.randomUUID().toString());
    }

    public void hn(com.byazt.lee.pr prVar) {
        Map<String, Object> mapPr = zo.pr().pr();
        if (mapPr == null) {
            return;
        }
        if (mapPr.containsKey("app_version")) {
            prVar.pr("crash_version", mapPr.get("app_version"));
        }
        if (mapPr.containsKey(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME)) {
            prVar.pr("app_version", mapPr.get(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME));
        }
        if (mapPr.containsKey("version_code")) {
            try {
                prVar.pr("crash_version_code", Integer.valueOf(Integer.parseInt(mapPr.get("version_code").toString())));
            } catch (Exception e) {
                prVar.pr("crash_version_code", mapPr.get("version_code"));
            }
        }
        if (mapPr.containsKey("update_version_code")) {
            try {
                prVar.pr("crash_update_version_code", Integer.valueOf(Integer.parseInt(mapPr.get("update_version_code").toString())));
            } catch (Exception e2) {
                prVar.pr("crash_update_version_code", mapPr.get("update_version_code"));
            }
        }
    }

    private void c(com.byazt.lee.pr prVar) {
        List<com.byazt.vlj.pr> listPr = zo.hw().pr(this.pr);
        if (listPr != null) {
            JSONObject jSONObject = new JSONObject();
            Iterator<com.byazt.vlj.pr> it = listPr.iterator();
            while (it.hasNext()) {
                Map<? extends String, ? extends String> mapPr = it.next().pr(this.pr);
                if (mapPr != null) {
                    try {
                        for (String str : mapPr.keySet()) {
                            jSONObject.put(str, mapPr.get(str));
                        }
                    } catch (Throwable th) {
                    }
                }
            }
            prVar.pr(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, jSONObject);
        }
    }

    public void x(com.byazt.lee.pr prVar) {
        prVar.hw(com.byazt.sds.x.pr(zo.c().hn(), zo.c().x()));
    }

    public boolean pr() {
        return true;
    }

    public boolean hw() {
        return true;
    }
}
