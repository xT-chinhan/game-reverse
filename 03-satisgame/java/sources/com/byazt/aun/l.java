package com.byazt.aun;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.byazt.tk.k;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 898, 18})
public class l {
    public static l qg;
    public Handler l;
    public com.byazt.ot.n.qg n = new com.byazt.ot.n.qg() { // from class: com.byazt.aun.l.2
        @Override // com.byazt.ot.n.qg
        public void q() {
        }

        @Override // com.byazt.ot.n.qg
        public void qg() {
        }

        @Override // com.byazt.ot.n.qg
        public void s() {
        }

        @Override // com.byazt.ot.n.qg
        public void n() {
            if (com.byazt.vyf.s.cy().lh()) {
                return;
            }
            com.byazt.ag.qg.l(new Runnable() { // from class: com.byazt.aun.l.2.1
                @Override // java.lang.Runnable
                public void run() {
                    for (String str : l.this.s.keySet()) {
                        com.byazt.gdj.l lVar = (com.byazt.gdj.l) l.this.s.get(str);
                        if (lVar != null && lVar.q() != null && lVar.q().q()) {
                            q.n().qg(str);
                        }
                    }
                }
            });
        }
    };
    public Map<String, com.byazt.gdj.l> s = new ConcurrentHashMap();
    public Map<String, List<com.byazt.gdj.qg>> q = new ConcurrentHashMap();

    private l() {
        if (com.byazt.rm.q.n() != null) {
            this.l = new Handler(com.byazt.rm.q.n().getLooper()) { // from class: com.byazt.aun.l.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    if (message.what == 1 && (message.obj instanceof String)) {
                        String str = (String) message.obj;
                        q.n().n(str);
                        com.byazt.gdj.l lVarN = l.this.n(str);
                        if (lVarN != null) {
                            l.this.qg(lVarN);
                        }
                    }
                }
            };
        }
        com.byazt.vyf.s.cy().s().n(this.n);
    }

    public static l n() {
        if (qg == null) {
            synchronized (l.class) {
                if (qg == null) {
                    qg = new l();
                }
            }
        }
        return qg;
    }

    public void n(String str, List<com.byazt.gdj.l> list) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        q();
        if (list != null) {
            for (com.byazt.gdj.l lVar : list) {
                if (lVar != null && !TextUtils.isEmpty(lVar.n())) {
                    this.s.put(lVar.n(), lVar);
                    qg(lVar);
                    n(lVar);
                }
            }
        }
    }

    private void n(final com.byazt.gdj.l lVar) {
        if (com.byazt.rm.q.n() == null) {
            return;
        }
        com.byazt.rm.q.n().post(new Runnable() { // from class: com.byazt.aun.l.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.byazt.gdj.l lVar2 = lVar;
                    if (lVar2 != null && lVar2.q() != null && lVar.q().q()) {
                        String strN = lVar.n();
                        com.byazt.gdj.x xVarQ = lVar.q();
                        long jQg = xVarQ.qg();
                        long jN = xVarQ.n();
                        if (jQg > 0 && jN > 0 && !TextUtils.isEmpty(strN)) {
                            long jCurrentTimeMillis = ((System.currentTimeMillis() / 1000) - jN) / jQg;
                            s.n(strN, jCurrentTimeMillis);
                            List<s.n> listQuery = s.query(strN, null, jCurrentTimeMillis, -1L);
                            if (listQuery != null && !listQuery.isEmpty()) {
                                q.n().n(lVar, listQuery);
                            }
                        }
                    }
                } catch (Throwable th) {
                    k.n("Tmee_TTFeatureSettings", "loadFeatureFromLocal error", th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(com.byazt.gdj.l lVar) {
        com.byazt.gdj.x xVarQ;
        if (lVar == null || this.l == null || com.byazt.vyf.s.cy().lh() || (xVarQ = lVar.q()) == null || xVarQ.s() <= 0 || "session".equals(xVarQ.getType())) {
            return;
        }
        String strN = lVar.n();
        this.l.removeMessages(1, strN);
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        messageObtain.obj = strN;
        this.l.sendMessageDelayed(messageObtain, xVarQ.s() * 1000);
    }

    private void q() {
        this.l.removeMessages(1);
    }

    public List<com.byazt.gdj.l> qg() {
        return new ArrayList(this.s.values());
    }

    public com.byazt.gdj.l n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.s.get(str);
    }

    public void qg(String str, List<com.byazt.gdj.qg> list) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (list == null || list.isEmpty()) {
            this.q.remove(str);
        } else {
            this.q.put(str, list);
        }
    }

    public List<com.byazt.gdj.qg> s() {
        ArrayList arrayList = new ArrayList();
        for (List<com.byazt.gdj.qg> list : this.q.values()) {
            if (list != null && !list.isEmpty()) {
                arrayList.addAll(list);
            }
        }
        return arrayList;
    }
}
