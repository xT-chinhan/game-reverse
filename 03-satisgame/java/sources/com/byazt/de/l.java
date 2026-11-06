package com.byazt.de;

import android.text.TextUtils;
import com.byazt.oi.tj;
import com.byazt.vf.hu;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 842, 18})
public class l {
    public static String n;
    public static AtomicBoolean qg = new AtomicBoolean(false);
    public static String l = "tt_csj_node_line_app_exit";
    public static AtomicBoolean s = new AtomicBoolean(false);
    public static com.byazt.ot.n.qg q = new com.byazt.ot.n.qg() { // from class: com.byazt.de.l.1
        @Override // com.byazt.ot.n.qg
        public void n() {
            if (com.byazt.vyf.s.cy().lh()) {
                return;
            }
            l.n(l.n);
        }

        @Override // com.byazt.ot.n.qg
        public void qg() {
            int i;
            if (com.byazt.vyf.s.cy().lh()) {
                return;
            }
            if (l.s.get()) {
                l.s.set(false);
                i = 1;
            } else {
                i = 2;
            }
            l.n(l.n, i);
        }

        @Override // com.byazt.ot.n.qg
        public void s() {
            if (com.byazt.vyf.s.cy().lh()) {
                return;
            }
            l.n(2);
        }

        @Override // com.byazt.ot.n.qg
        public void q() {
            if (com.byazt.vyf.s.cy().lh()) {
                return;
            }
            l.qg(l.n, 1);
        }
    };

    public static void n(int i) {
        if (qg.get()) {
            return;
        }
        if (TextUtils.isEmpty(n)) {
            n = qg();
        }
        com.byazt.id.w wVarN = n();
        wVarN.qg(n, com.byazt.vgx.s.q());
        wVarN.n(n, new tj());
        n(n, i == 1 ? com.byazt.wb.s.x().l() : System.currentTimeMillis(), i);
        if (i == 1) {
            if (com.byazt.vyf.s.cy().s().qg()) {
                n(n);
            } else {
                n(n, 1);
            }
        }
    }

    public static void n(String str, long j, int i) {
        qg.set(true);
        if (i == 2) {
            s.set(true);
        }
        com.byazt.id.w wVarN = n();
        if (wVarN != null) {
            com.byazt.bok.w wVar = new com.byazt.bok.w(j);
            wVar.n("source", Integer.valueOf(i));
            wVarN.n(str, com.byazt.hes.w.STARTED, wVar);
        }
    }

    public static void n(String str, int i) {
        com.byazt.id.w wVarN = n();
        if (wVarN != null) {
            com.byazt.bok.w wVar = new com.byazt.bok.w(System.currentTimeMillis());
            wVar.n("source", Integer.valueOf(i));
            wVarN.n(str, com.byazt.hes.w.FOREGROUNDED, wVar);
        }
    }

    public static void n(String str) {
        com.byazt.id.w wVarN = n();
        if (wVarN != null) {
            wVarN.n(str, com.byazt.hes.w.BACKGROUNDED);
        }
    }

    public static void qg(String str, int i) {
        com.byazt.id.w wVarN = n();
        if (wVarN != null) {
            com.byazt.bok.w wVar = new com.byazt.bok.w(System.currentTimeMillis());
            wVar.n("source", Integer.valueOf(i));
            wVarN.n(str, com.byazt.hes.w.END, wVar);
        }
        qg.set(false);
        String string = UUID.randomUUID().toString();
        n = string;
        s(string);
    }

    public static com.byazt.id.w n() {
        return (com.byazt.id.w) com.byazt.bok.s.n(4);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001c  */
    private static String qg() {
        String string;
        hu huVar = (hu) com.byazt.qp.q.n("m_d_s");
        if (huVar != null) {
            Object objN = huVar.n(2);
            if (objN instanceof String) {
                string = (String) objN;
                if (TextUtils.isEmpty(string)) {
                    string = UUID.randomUUID().toString();
                    huVar.n(2, string);
                }
            } else {
                string = UUID.randomUUID().toString();
                huVar.n(2, string);
            }
        } else {
            string = null;
        }
        return TextUtils.isEmpty(string) ? UUID.randomUUID().toString() : string;
    }

    private static void s(String str) {
        hu huVar = (hu) com.byazt.qp.q.n("m_d_s");
        if (huVar != null) {
            huVar.n(2, str);
        }
    }

    public static com.byazt.gwu.s qg(String str) {
        return com.byazt.lk.l.n(str, l);
    }
}
