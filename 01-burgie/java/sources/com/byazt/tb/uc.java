package com.byazt.tb;

import com.byazt.hg.of;
import com.byazt.is.k;
import com.byazt.sd.a;
import com.byazt.sd.y;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_MILLISECOND, 5})
public class uc implements com.byazt.mc.hn {
    public com.byazt.yl.hw c;
    public com.byazt.pv.hn hw;
    public volatile boolean hn = false;
    public volatile boolean x = false;
    public com.byazt.wt.pr.hw pr = new com.byazt.wt.pr.hw() { // from class: com.byazt.tb.uc.1
        @Override // com.byazt.wt.pr.hw
        public void pr() {
            if (!com.byazt.sd.zo.nt().y() && !uc.this.hn) {
                uc.this.x();
            }
        }

        @Override // com.byazt.wt.pr.hw
        public void hw() {
            if (!com.byazt.sd.zo.nt().y() && !uc.this.hn && uc.this.x) {
                uc.this.hn();
            }
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
    }

    @Override // com.byazt.mc.hn
    public void hw(com.byazt.pv.hn hnVar, com.byazt.ewt.zo zoVar) {
    }

    @Override // com.byazt.mc.hn
    public void x(com.byazt.pv.hn hnVar, com.byazt.ewt.zo zoVar) {
    }

    @Override // com.byazt.mc.hn
    public void c(com.byazt.pv.hn hnVar, com.byazt.ewt.zo zoVar) {
    }

    @Override // com.byazt.mc.hn
    public void hn(com.byazt.pv.hn hnVar, com.byazt.ewt.zo zoVar) {
        com.byazt.mn.x.pr(zoVar);
        if (!this.hn) {
            this.hw = hnVar;
            pr();
            if (this.x) {
                com.byazt.sd.zo.nt().hn().pr(this.pr);
                hn();
            }
        }
    }

    @Override // com.byazt.mc.hn
    public void uc(com.byazt.pv.hn hnVar, com.byazt.ewt.zo zoVar) {
    }

    @Override // com.byazt.mc.hn
    public void fw(com.byazt.pv.hn hnVar, com.byazt.ewt.zo zoVar) {
        com.byazt.mn.x.pr(zoVar);
        if (this.hn) {
            return;
        }
        this.hn = true;
        com.byazt.sd.zo.nt().hn().hw(this.pr);
        x();
        this.c = null;
    }

    private void pr() {
        int i;
        boolean z;
        com.byazt.pv.hn hnVar = this.hw;
        if (hnVar == null || hnVar.ho == null) {
            return;
        }
        of ofVar = this.hw.ho;
        k kVarIa = a.hw().ia();
        com.byazt.qe.hw hwVarP = ofVar.p();
        String strZ = ofVar.z();
        com.byazt.ak.x xVarFw = com.byazt.ak.x.fw();
        boolean zHn = xVarFw.hn();
        int iZo = xVarFw.zo();
        boolean zX = xVarFw.x();
        int i2 = 0;
        if (kVarIa != null && hwVarP != null) {
            int iA = hwVarP.a();
            if (iA <= 0) {
                iA = ls.k(ofVar);
            }
            boolean zHn2 = kVarIa.hn(iA);
            boolean zHw = hw();
            this.x = zHn2 && zHw && zHn && zX;
            z = zHw;
            i = 0;
            i2 = iA;
        } else {
            i = kVarIa != null ? 2 : 1;
            z = false;
        }
        pr(i2, strZ, zHn, zX, z, i, iZo);
    }

    private void pr(int i, String str, boolean z, boolean z2, boolean z3, int i2, int i3) {
        JSONObject jSONObjectPr = com.byazt.ak.hw.pr(str);
        if (jSONObjectPr == null) {
            return;
        }
        try {
            jSONObjectPr.put("pitaya_init_success", com.byazt.ba.x.hw());
            jSONObjectPr.put("pkg_state", i3);
            jSONObjectPr.put("ext_plugin_code", y.hw());
            jSONObjectPr.put("setting_delay", a.hw().yn());
            jSONObjectPr.put("last_setting_time", com.byazt.wt.zo.hn());
            jSONObjectPr.put("empty_type", i2);
            jSONObjectPr.put("ad_type", i);
            jSONObjectPr.put("is_enable", z);
            jSONObjectPr.put("can_request_and_dl_ext", a.hw().v());
            jSONObjectPr.put("has_update", z2);
            if (com.byazt.sd.hn.sInitSuccessTime > 0) {
                jSONObjectPr.put("delt_init", System.currentTimeMillis() - com.byazt.sd.hn.sInitSuccessTime);
            } else {
                jSONObjectPr.put("delt_init", 0);
            }
            jSONObjectPr.put("can_collect_sensor_event", z3);
            jSONObjectPr.put("package_version", com.byazt.ak.x.fw().c());
            if (this.hw.ho != null) {
                jSONObjectPr.put("aspect_ratio", this.hw.ho.oq());
            }
        } catch (Exception e) {
        }
    }

    private boolean hw() {
        return com.byazt.ca.x.pr(a.getContext()).pr(15) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hn() {
        if (this.hw == null) {
            return;
        }
        if (this.c == null) {
            this.c = new com.byazt.yl.hw();
        }
        this.c.pr(false, false, true, this.hw.ho);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        com.byazt.yl.hw hwVar = this.c;
        if (hwVar != null) {
            hwVar.pr();
        }
    }
}
