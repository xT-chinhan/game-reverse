package com.byazt.od;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.byazt.hg.of;
import com.byazt.sd.cz;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import com.umeng.analytics.pro.d;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_PAD_HELLO, 50})
@com.byazt.qa.hw
public class vk implements com.byazt.lf.hn {

    @com.byazt.qa.pr(hw = "ALL", pr = "is_from_video_layout")
    public boolean aj;

    @com.byazt.qa.pr(hw = "ALL", pr = "is_open_web_page")
    public boolean c;

    @com.byazt.qa.pr(hw = "ALL", pr = "pip_controller")
    public com.byazt.ga.hw fw;

    @com.byazt.qa.pr(hw = "ALL", pr = BreakpointSQLiteKey.URL)
    public String hn;

    @com.byazt.qa.pr(hw = "ALL", pr = d.R)
    public Context hw;

    @com.byazt.qa.pr(hw = "ALL", pr = "material_meta")
    public of pr;

    @com.byazt.qa.pr(hw = "ALL", pr = "convert_from_landing_page")
    public boolean uc;

    @com.byazt.qa.pr(hw = "CONTEXT", pr = "event_tag")
    public String vk;

    @com.byazt.qa.pr(hw = "ALL", pr = "interaction_type")
    public int x;

    @com.byazt.qa.pr(hw = "ALL", pr = "open_video_detail_page_direct")
    public boolean zo;

    @Override // com.byazt.lf.hn
    public boolean pr(Map<String, Object> map, final Map<String, Object> map2, final com.byazt.hws.pr prVar) {
        if (this.c) {
            return true;
        }
        if (this.uc) {
            prVar.pr(map2, (com.byazt.rs.pr) null);
            return true;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("ext", this.pr.B_());
            jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.pr.c()));
            jSONObject.putOpt("req_id", this.pr.ny());
            jSONObject.putOpt("uchain", Boolean.TRUE);
        } catch (JSONException e) {
        }
        com.byazt.xk.hw.pr().pr("landing_page", "native", 0, jSONObject);
        if (this.x == 2) {
            boolean zPr = pr();
            if (zPr) {
                prVar.pr(map2);
            } else {
                prVar.pr(map2, (com.byazt.rs.pr) null);
            }
            return zPr;
        }
        com.byazt.ga.hw hwVar = this.fw;
        if (hwVar != null && new com.byazt.ov.hw(hwVar).pr(new HashMap())) {
            prVar.pr(map2);
            return true;
        }
        Intent intent = new Intent(this.hw, com.byazt.lx.pr.pr(this.zo, this.pr, this.aj, map2));
        if (!(this.hw instanceof Activity)) {
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
        }
        intent.putExtra("is_outer_click", true);
        intent.putExtra("event_tag", this.vk);
        of ofVar = this.pr;
        if (ofVar != null) {
            intent.putExtra("get_phone_num_status", ofVar.fw());
        }
        if (map == null) {
            com.byazt.ca.ho.hw("UChain_LP", "param == null");
            map = new HashMap<>();
        }
        map.putAll(map2);
        map.remove(d.R);
        map.remove("activity_type");
        Object objRemove = map.remove("landing_page_source");
        ls.pr(map, this.pr);
        int i = -1;
        if (!(objRemove == null || TextUtils.isEmpty(objRemove.toString()))) {
            try {
                i = Integer.parseInt(objRemove.toString());
            } catch (Exception e2) {
            }
        }
        intent.putExtra("landing_page_source", i);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && !"log_extra".equals(key)) {
                intent.putExtra(key, value.toString());
            }
        }
        intent.putExtra("web_dl_factors", com.byazt.lx.hw.hw(map2));
        com.byazt.ca.pr.pr(this.hw, intent, new com.byazt.ca.pr.InterfaceC0030pr() { // from class: com.byazt.od.vk.1
            @Override // com.byazt.ca.pr.InterfaceC0030pr
            public void pr() {
                prVar.pr(map2);
                map2.put("is_open_web_page", Boolean.TRUE);
            }

            @Override // com.byazt.ca.pr.InterfaceC0030pr
            public void pr(Throwable th) {
                prVar.pr(map2, (com.byazt.rs.pr) null);
                cz.x(vk.this.pr.cz(), of.class);
            }
        });
        return true;
    }

    private boolean pr() {
        if (!com.byazt.ca.yb.pr(this.hn)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        try {
            intent.setData(Uri.parse(this.hn));
            if (!(this.hw instanceof Activity)) {
                intent.addFlags(C.ENCODING_PCM_MU_LAW);
            }
            com.byazt.ca.pr.pr(this.hw, intent, null);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
