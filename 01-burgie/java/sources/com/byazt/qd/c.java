package com.byazt.qd;

import android.text.TextUtils;
import com.byazt.sd.a;
import com.byazt.sd.zo;
import com.byazt.tb.vk;
import com.byazt.vkw.rc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 224, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public static String pr = null;
    public static AtomicBoolean hw = new AtomicBoolean(false);
    public static String c = "tt_csj_node_line_app_exit";
    public static AtomicBoolean hn = new AtomicBoolean(false);
    public static com.byazt.wt.pr.hw x = new com.byazt.wt.pr.hw() { // from class: com.byazt.qd.c.1
        @Override // com.byazt.wt.pr.hw
        public void pr() {
            if (zo.nt().y()) {
                return;
            }
            c.pr(c.pr);
        }

        @Override // com.byazt.wt.pr.hw
        public void hw() {
            int i;
            if (zo.nt().y()) {
                return;
            }
            if (c.hn.get()) {
                c.hn.set(false);
                i = 1;
            } else {
                i = 2;
            }
            c.pr(c.pr, i);
        }

        @Override // com.byazt.wt.pr.hw
        public void hn() {
            if (zo.nt().y()) {
                return;
            }
            c.pr(2);
        }

        @Override // com.byazt.wt.pr.hw
        public void x() {
            if (zo.nt().y()) {
                return;
            }
            c.hw(c.pr, 1);
        }
    };

    public static void pr(int i) {
        if (hw.get()) {
            return;
        }
        if (TextUtils.isEmpty(pr)) {
            pr = hn();
        }
        com.byazt.dc.uc ucVarPr = pr();
        ucVarPr.hw(pr, com.byazt.zb.pr.x());
        ucVarPr.pr(pr, new vk());
        pr(pr, i == 1 ? com.byazt.mk.hn.fw().c() : System.currentTimeMillis(), i);
        if (i == 1) {
            if (!zo.nt().hn().hw()) {
                pr(pr, 1);
            } else {
                pr(pr);
            }
        }
    }

    public static void pr(String str, long j, int i) {
        hw.set(true);
        if (i == 2) {
            hn.set(true);
        }
        com.byazt.dc.uc ucVarPr = pr();
        if (ucVarPr != null) {
            com.byazt.ewt.zo zoVar = new com.byazt.ewt.zo(j);
            zoVar.pr("source", Integer.valueOf(i));
            ucVarPr.pr(str, com.byazt.tq.uc.STARTED, zoVar);
        }
    }

    public static void pr(String str, int i) {
        com.byazt.dc.uc ucVarPr = pr();
        if (ucVarPr != null) {
            com.byazt.ewt.zo zoVar = new com.byazt.ewt.zo(System.currentTimeMillis());
            zoVar.pr("source", Integer.valueOf(i));
            ucVarPr.pr(str, com.byazt.tq.uc.FOREGROUNDED, zoVar);
        }
    }

    public static void pr(String str) {
        com.byazt.dc.uc ucVarPr = pr();
        if (ucVarPr != null) {
            ucVarPr.pr(str, com.byazt.tq.uc.BACKGROUNDED);
        }
    }

    public static void hw(String str, int i) {
        com.byazt.dc.uc ucVarPr = pr();
        if (ucVarPr != null) {
            com.byazt.ewt.zo zoVar = new com.byazt.ewt.zo(System.currentTimeMillis());
            zoVar.pr("source", Integer.valueOf(i));
            ucVarPr.pr(str, com.byazt.tq.uc.END, zoVar);
        }
        hw.set(false);
        String string = UUID.randomUUID().toString();
        pr = string;
        hn(string);
    }

    public static com.byazt.dc.uc pr() {
        return (com.byazt.dc.uc) com.byazt.ewt.c.pr(4);
    }

    public static void hw() {
        if (a.hw().hh()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("l_type", "app");
                jSONObject.putOpt("type", "end");
                jSONObject.putOpt("ts", Long.valueOf(System.currentTimeMillis()));
                jSONObject.putOpt("source", 2);
                hw(com.byazt.zb.pr.x()).pr(com.byazt.mn.pr.pr("app") + pr, jSONObject.toString());
            } catch (Throwable th) {
            }
        }
        hw(pr, 2);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001d  */
    private static String hn() {
        String string;
        rc rcVar = (rc) com.byazt.zs.uc.pr("m_d_s");
        if (rcVar == null) {
            string = null;
        } else {
            Object objPr = rcVar.pr(2);
            if (objPr instanceof String) {
                string = (String) objPr;
                if (TextUtils.isEmpty(string)) {
                    string = UUID.randomUUID().toString();
                    rcVar.pr(2, string);
                }
            } else {
                string = UUID.randomUUID().toString();
                rcVar.pr(2, string);
            }
        }
        if (TextUtils.isEmpty(string)) {
            return UUID.randomUUID().toString();
        }
        return string;
    }

    private static void hn(String str) {
        rc rcVar = (rc) com.byazt.zs.uc.pr("m_d_s");
        if (rcVar != null) {
            rcVar.pr(2, str);
        }
    }

    public static com.byazt.zq.hn hw(String str) {
        return com.byazt.qn.x.pr(str, c);
    }
}
