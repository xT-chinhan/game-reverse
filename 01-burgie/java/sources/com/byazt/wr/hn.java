package com.byazt.wr;

import android.content.Context;
import android.view.View;
import com.byazt.af.aj;
import com.byazt.ea.w;
import com.byazt.hg.of;
import com.byazt.hg.qa;
import com.byazt.hg.y;
import com.byazt.sd.a;
import com.byazt.xlm.fw;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_OFFER_SEND_TIME, 20})
public class hn {
    public com.byazt.rx.pr c;
    public pr hn;
    public Context hw;
    public of pr;
    public boolean x = true;
    public boolean uc = false;
    public int fw = 0;
    public boolean zo = false;
    public int aj = -1;

    public hn(Context context, of ofVar) {
        this.hw = context;
        this.pr = ofVar;
    }

    public void pr(pr prVar) {
        pr(prVar, this.pr);
    }

    public void pr(pr prVar, aj ajVar) {
        this.hn = prVar;
        if (prVar == null) {
            return;
        }
        prVar.pr(this.hw);
        prVar.pr(ajVar);
        prVar.pr(this.x);
    }

    public void pr(boolean z) {
        this.x = z;
    }

    public void pr(com.byazt.rx.pr prVar) {
        this.c = prVar;
    }

    public void hw(boolean z) {
        this.uc = z;
    }

    public void pr(int i) {
        this.fw = i;
    }

    public void hw(int i) {
        this.aj = i;
    }

    public void hn(boolean z) {
        this.zo = z;
    }

    public boolean x(boolean z) {
        pr prVar = this.hn;
        if (prVar == null) {
            return true;
        }
        prVar.hw(z || this.zo);
        pr prVar2 = this.hn;
        if (prVar2 instanceof hw) {
            hw hwVar = (hw) prVar2;
            hwVar.hn(this.uc);
            hwVar.pr(this.fw);
        }
        int i = this.aj;
        if (i == 1) {
            this.hn.x = 4;
            return true;
        }
        if (i == 0) {
            return false;
        }
        return this.hn.pr();
    }

    public void pr(String str, com.byazt.rx.hw hwVar) {
        if (this.pr == null) {
            return;
        }
        pr((com.byazt.hg.x) null, str, hwVar);
    }

    public void pr(com.byazt.hg.x xVar, final String str, final String str2, final com.byazt.rx.hw hwVar) {
        of ofVar = this.pr;
        if (ofVar == null) {
            return;
        }
        if (xVar != null || ofVar.cb() != 2 || (this.hn instanceof c)) {
            pr(xVar, str, hwVar);
        } else {
            com.byazt.xlm.c.hw(new fw("tt_download_check") { // from class: com.byazt.wr.hn.1
                @Override // java.lang.Runnable
                public void run() {
                    hn.this.pr(a.pr().pr(hn.this.pr, str2), str, hwVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(com.byazt.hg.x xVar, String str, com.byazt.rx.hw hwVar) {
        String strXy;
        String strHn;
        String strPr;
        com.byazt.wt.c.pr prVarHw = hw(str, hwVar);
        try {
            if (xVar != null) {
                com.byazt.hg.uc ucVarLb = this.pr.lb();
                if (ucVarLb != null) {
                    xVar.pr(ucVarLb.x());
                    xVar.pr(ucVarLb.hn());
                }
                strXy = xVar.zo();
                strHn = xVar.pr();
                strPr = xVar.x();
            } else {
                strXy = this.pr.xy();
                strHn = com.byazt.ri.c.hn(this.pr);
                y yVarMo = this.pr.mo();
                if (yVarMo == null) {
                    strPr = "";
                } else {
                    strPr = yVarMo.pr();
                }
            }
            if (w.aj(this.pr)) {
                if (!w.pr(this.hw, this.pr, strHn)) {
                    of ofVar = this.pr;
                    pr(ofVar, str, w.hw(this.hw, ofVar, strHn), 0, "");
                }
            } else {
                com.byazt.pj.pr.hw(this.pr, str, "pop_up", pr());
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("dialog_title", strHn);
            jSONObject.put("dialog_icon_url", strPr);
            jSONObject.put("dialog_app_description", this.pr.jv());
            String strPr2 = pr(strXy);
            hw(str);
            com.byazt.rx.pr prVar = this.c;
            if (prVar != null) {
                prVar.pr();
            }
            if (w.pr(this.hw, this.pr, strHn)) {
                pr(str, prVarHw, strPr2, strPr, jSONObject);
            } else {
                com.byazt.wt.c.pr(this.hw, this.pr.x(), strPr2, jSONObject.toString(), prVarHw, this.pr);
            }
        } catch (JSONException e) {
        }
    }

    private String pr(String str) {
        int iK = qa.k(this.pr);
        try {
            if (iK == 4) {
                JSONObject jSONObject = new JSONObject(str);
                jSONObject.put("ugen_url", qa.g(this.pr));
                jSONObject.put("ugen_md5", qa.ho(this.pr));
                jSONObject.put("download_num", hw(this.pr.cu()));
                com.byazt.hg.c cVarHo = this.pr.ho();
                if (cVarHo == null) {
                    return jSONObject.toString();
                }
                jSONObject.put("app_size", hn(cVarHo.fw()));
                jSONObject.put("comment_num", pr(cVarHo.uc()));
                return jSONObject.toString();
            }
            if (iK == 3) {
                JSONObject jSONObject2 = new JSONObject(str);
                jSONObject2.put("hand_icon_url", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/ugeno-source/download_hand_tap.json");
                return jSONObject2.toString();
            }
            return str;
        } catch (JSONException e) {
            return str;
        }
    }

    private void hw(final String str) {
        if (qa.k(this.pr) != 4) {
            return;
        }
        TTDelegateActivity.pr(new com.byazt.sa.fw() { // from class: com.byazt.wr.hn.2
            @Override // com.byazt.sa.fw
            public void pr(int i, String str2) {
                hn.this.pr(str, 1, str2);
                TTDelegateActivity.pr((com.byazt.sa.fw) null);
            }

            @Override // com.byazt.sa.fw
            public void pr(com.byazt.ik.hn<View> hnVar) {
                hn.this.pr(str, 0, "");
                TTDelegateActivity.pr((com.byazt.sa.fw) null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(String str, int i, String str2) {
        JSONObject jSONObjectPr = pr();
        try {
            jSONObjectPr.put("ugen_dl_render_fail_msg", str2);
            jSONObjectPr.put("ugen_dl_render_fail", i);
        } catch (Exception e) {
        }
        com.byazt.pj.pr.hw(this.pr, str, "pop_up", jSONObjectPr);
    }

    public String pr(long j) {
        if (j >= 100000000) {
            return String.format("%d亿+", Long.valueOf(j / 100000000));
        }
        if (j >= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            return String.format("%d万+", Long.valueOf(j / ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT));
        }
        if (j > 0) {
            return String.valueOf(j);
        }
        return "-";
    }

    public String hw(long j) {
        if (j >= 100000000) {
            return String.format("%d亿+", Long.valueOf(Math.round(j / 1.0E8d)));
        }
        if (j >= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            return String.format("%d万+", Long.valueOf(Math.round(j / 10000.0d)));
        }
        if (j > 0) {
            return String.valueOf(j);
        }
        return "-";
    }

    public String hn(long j) {
        return j <= 0 ? "-" : String.format("%.1fMB", Double.valueOf((j / 1024.0d) / 1024.0d));
    }

    private void pr(String str, com.byazt.wt.c.pr prVar, String str2, String str3, JSONObject jSONObject) throws JSONException {
        jSONObject.put("is_easy_dl_dialog_pop_up_style", true);
        com.byazt.wt.c.pr(this.hw, this.pr.x(), w.pr(this.hw, str2, this.pr, str3), jSONObject.toString(), prVar, hn(str), this.pr);
    }

    private com.byazt.sa.fw hn(final String str) {
        return new com.byazt.sa.fw() { // from class: com.byazt.wr.hn.3
            @Override // com.byazt.sa.fw
            public void pr(int i, String str2) {
                hn hnVar = hn.this;
                hnVar.pr(hnVar.pr, str, 6, i, str2);
                TTDelegateActivity.pr((com.byazt.sa.fw) null);
            }

            @Override // com.byazt.sa.fw
            public void pr(com.byazt.ik.hn<View> hnVar) {
                hn hnVar2 = hn.this;
                hnVar2.pr(hnVar2.pr, str, 5, 0, "");
                TTDelegateActivity.pr((com.byazt.sa.fw) null);
            }
        };
    }

    private com.byazt.wt.c.pr hw(final String str, final com.byazt.rx.hw hwVar) {
        return new com.byazt.wt.c.pr() { // from class: com.byazt.wr.hn.4
            @Override // com.byazt.wt.c.pr
            public void pr() {
                com.byazt.rx.hw hwVar2 = hwVar;
                if (hwVar2 != null) {
                    hwVar2.pr();
                }
                if (hn.this.c != null) {
                    hn.this.c.hn();
                    hn.this.c.hw();
                }
                uc.hw = true;
                com.byazt.pj.pr.hw(hn.this.pr, str, "pop_up_download", hn.this.pr());
            }

            @Override // com.byazt.wt.c.pr
            public void hw() {
            }

            @Override // com.byazt.wt.c.pr
            public void hn() {
                com.byazt.pj.pr.hw(hn.this.pr, str, "pop_up_cancel", hn.this.pr());
                if (hn.this.c != null) {
                    hn.this.c.hw();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(of ofVar, String str, int i, int i2, String str2) {
        JSONObject jSONObjectPr = pr();
        if (6 == i) {
            try {
                jSONObjectPr.put("easy_dl_render_fail_code", i2);
                if (ofVar != null) {
                    String strHn = ofVar.eu().hn();
                    jSONObjectPr.put("easy_dl_render_fail_msg", str2);
                    jSONObjectPr.put("easy_dl_render_fail_dsl", x(strHn));
                }
            } catch (Exception e) {
            }
        }
        jSONObjectPr.put("show_easy_dl_dialog_code", i);
        com.byazt.pj.pr.hw(this.pr, str, "pop_up", jSONObjectPr);
    }

    private String x(String str) {
        com.byazt.zq.hn hnVarPr = com.byazt.sd.hw.pr();
        if (hnVarPr == null) {
            return null;
        }
        return hnVarPr.hw(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject pr() {
        JSONObject jSONObject = new JSONObject();
        int iHw = -2;
        try {
            pr prVar = this.hn;
            if (prVar != null) {
                iHw = prVar.hw();
            }
            jSONObject.put("download_type", iHw);
        } catch (Exception e) {
        }
        return jSONObject;
    }
}
