package com.byazt.tb;

import android.text.TextUtils;
import com.byazt.sd.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_MILLISECOND, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c implements com.byazt.mc.hn {
    public com.byazt.pv.hn uc;
    public int pr = 0;
    public int hw = 0;
    public int hn = 0;
    public boolean x = false;
    public com.byazt.wt.pr.hw c = new com.byazt.wt.pr.hw() { // from class: com.byazt.tb.c.1
        @Override // com.byazt.wt.pr.hw
        public void pr() {
            if (com.byazt.sd.zo.nt().y() || c.this.x || c.this.uc == null || c.this.uc.ho == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("ad_load_id", c.this.uc.pr);
                jSONObject.putOpt("ad_show_id", c.this.uc.hw());
                jSONObject.putOpt("node_line_name", "ad_node_line");
                c cVar = c.this;
                cVar.pr(cVar.uc.hw(), jSONObject);
                c cVar2 = c.this;
                cVar2.pr(jSONObject, cVar2.uc);
                com.byazt.mn.x.pr(jSONObject, c.this.uc, c.this.uc.aj, "ad_show");
            } catch (Throwable th) {
            }
        }

        @Override // com.byazt.wt.pr.hw
        public void hw() {
        }

        @Override // com.byazt.wt.pr.hw
        public void hn() {
        }

        @Override // com.byazt.wt.pr.hw
        public void x() {
        }
    };

    @Override // com.byazt.mc.hn
    public void pr(com.byazt.pv.hn hnVar, com.byazt.ewt.zo zoVar) {
        com.byazt.mn.x.pr(zoVar);
        com.byazt.mn.hw hwVar = new com.byazt.mn.hw("ad_show", "created", zoVar != null ? zoVar.pr() : System.currentTimeMillis());
        hnVar.aj.add(hwVar);
        com.byazt.mn.hn.pr(hwVar, hnVar.ho, hnVar);
    }

    @Override // com.byazt.mc.hn
    public void hw(com.byazt.pv.hn hnVar, com.byazt.ewt.zo zoVar) {
        com.byazt.mn.x.pr(zoVar);
        if (pr() && !this.x) {
            this.uc = hnVar;
            com.byazt.sd.zo.nt().hn().pr(this.c);
        }
        this.pr++;
        com.byazt.mn.hw hwVar = new com.byazt.mn.hw("ad_show", "started", zoVar != null ? zoVar.pr() : System.currentTimeMillis());
        hnVar.aj.add(hwVar);
        com.byazt.mn.hn.pr(hwVar, hnVar.ho, hnVar);
    }

    @Override // com.byazt.mc.hn
    public void x(com.byazt.pv.hn hnVar, com.byazt.ewt.zo zoVar) {
        com.byazt.mn.hw hwVar = new com.byazt.mn.hw("ad_show", "visibled", zoVar != null ? zoVar.pr() : System.currentTimeMillis(), hnVar.hn);
        hnVar.aj.add(hwVar);
        com.byazt.mn.hn.pr(hwVar, hnVar.ho, hnVar);
    }

    @Override // com.byazt.mc.hn
    public void c(com.byazt.pv.hn hnVar, com.byazt.ewt.zo zoVar) {
        com.byazt.mn.hw hwVar = new com.byazt.mn.hw("ad_show", "invisibled", zoVar != null ? zoVar.pr() : System.currentTimeMillis(), hnVar.hn);
        hnVar.aj.add(hwVar);
        com.byazt.mn.hn.pr(hwVar, hnVar.ho, hnVar);
    }

    @Override // com.byazt.mc.hn
    public void hn(com.byazt.pv.hn hnVar, com.byazt.ewt.zo zoVar) {
        com.byazt.mn.x.pr(zoVar);
        if (pr() && !this.x) {
            this.uc = hnVar;
            com.byazt.sd.zo.nt().hn().pr(this.c);
        }
        boolean zMo = a.hw().mo();
        if (!hnVar.x || zMo) {
            com.byazt.mn.hw hwVar = new com.byazt.mn.hw("ad_show", "showed", zoVar != null ? zoVar.pr() : System.currentTimeMillis());
            hwVar.pr(hnVar.c);
            this.hw++;
            hnVar.aj.add(hwVar);
            com.byazt.mn.hn.pr(hwVar, hnVar.ho, hnVar);
            if (this.hw > 1) {
                hnVar.nt = 1;
            }
        }
    }

    @Override // com.byazt.mc.hn
    public void uc(com.byazt.pv.hn hnVar, com.byazt.ewt.zo zoVar) {
        com.byazt.mn.x.pr(zoVar);
        if (pr() && !this.x) {
            this.uc = hnVar;
            com.byazt.sd.zo.nt().hn().pr(this.c);
        }
        com.byazt.mn.hw hwVar = new com.byazt.mn.hw("ad_show", "clicked", zoVar != null ? zoVar.pr() : System.currentTimeMillis());
        hnVar.aj.add(hwVar);
        com.byazt.mn.hn.pr(hwVar, hnVar.ho, hnVar);
        this.hn++;
        if (this.hw == 0) {
            hnVar.nt = 2;
        }
    }

    @Override // com.byazt.mc.hn
    public void fw(com.byazt.pv.hn hnVar, com.byazt.ewt.zo zoVar) {
        if (this.x) {
            return;
        }
        this.x = true;
        com.byazt.sd.zo.nt().hn().hw(this.c);
        com.byazt.mn.hw hwVar = new com.byazt.mn.hw("ad_show", "end", zoVar != null ? zoVar.pr() : System.currentTimeMillis(), hnVar.hw);
        hnVar.aj.add(hwVar);
        com.byazt.mn.hn.pr(hwVar, hnVar.ho, hnVar);
        pr(hnVar);
    }

    private void pr(com.byazt.pv.hn hnVar) {
        if (hnVar == null || hnVar.ho == null) {
            return;
        }
        com.byazt.mn.x.pr(hnVar.aj);
        Iterator<com.byazt.mn.hw> it = hnVar.aj.iterator();
        while (it.hasNext()) {
            it.next();
        }
        if ((this.hw == 0 && this.hn == 0 && this.pr == 0) || !pr()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("ad_load_id", hnVar.pr);
            jSONObject.putOpt("ad_show_id", hnVar.hw());
            pr(hnVar.hw(), jSONObject);
            pr(jSONObject, hnVar);
            com.byazt.mn.x.pr(hnVar.aj, hnVar, "ad_node_line", jSONObject);
            com.byazt.mn.x.pr(com.byazt.mn.pr.pr("ad_show") + hnVar.hw(), hnVar.yb);
            com.byazt.qd.hw.x(hnVar.hw());
        } catch (Throwable th) {
        }
    }

    private boolean pr() {
        return a.hw().hh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        Object objX = com.byazt.qd.hw.x(str, 0);
        Object objX2 = com.byazt.qd.hw.x(str, 1);
        Object objX3 = com.byazt.qd.hw.x(str, 2);
        Object objX4 = com.byazt.qd.hw.x(str, 3);
        try {
            if (objX instanceof JSONObject) {
                jSONObject.putOpt("key_element_info", objX);
            }
            if (objX2 instanceof JSONArray) {
                jSONObject.putOpt("no_action_array", objX2);
            }
            if (objX3 instanceof JSONObject) {
                jSONObject.putOpt("motion_info", objX3);
            }
            if (objX4 instanceof JSONObject) {
                jSONObject.putOpt("ad_user_interact_data", objX4);
            }
        } catch (JSONException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(JSONObject jSONObject, com.byazt.pv.hn hnVar) {
        if (hnVar == null || jSONObject == null) {
            return;
        }
        try {
            jSONObject.putOpt("has_send_show_event", Integer.valueOf(hnVar.c));
            jSONObject.putOpt("has_send_click_event", Integer.valueOf(hnVar.uc));
            jSONObject.putOpt("send_show_event_result", Integer.valueOf(hnVar.fw));
            jSONObject.putOpt("send_click_event_result", Integer.valueOf(hnVar.zo));
        } catch (Exception e) {
        }
    }
}
