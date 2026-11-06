package com.byazt.wl;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.byazt.nf.rv;
import com.byazt.qit.x;
import com.byazt.tk.hd;
import com.byazt.vf.oa;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 888, 8})
public class s {
    public final Queue<qg> n;
    public final com.byazt.hsi.s q;
    public int qg;
    public final AtomicBoolean s;

    public interface qg {
        void n() throws Exception;
    }

    @com.byazt.cp.n(n = {0, 1, 888, 546})
    private static class n {
        public static final s n = new s();
    }

    private s() {
        this.n = new ConcurrentLinkedQueue();
        this.s = new AtomicBoolean(false);
        com.byazt.hsi.s sVar = new com.byazt.hsi.s() { // from class: com.byazt.wl.s.1
            public final long qg = com.byazt.hsi.q.n();

            @Override // com.byazt.hsi.s
            public void n(Context context, Intent intent, boolean z, int i) {
                if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                    if (!com.byazt.vyf.s.cy().lh()) {
                        if (s.this.qg == 0 && i != 0) {
                            s.this.n.size();
                            s.this.qg();
                        }
                        s.this.qg = i;
                        return;
                    }
                    s.this.n(this);
                }
            }

            @Override // com.byazt.hsi.s
            public long n() {
                return this.qg;
            }
        };
        this.q = sVar;
        ((oa) com.byazt.qp.q.n("device_info_new")).n(sVar);
        this.qg = hd.s(rv.getContext());
    }

    public static s n() {
        return n.n;
    }

    public void n(qg qgVar) {
        if (com.byazt.vyf.s.cy().lh()) {
            n(this.q);
        } else {
            if (this.s.get()) {
                return;
            }
            this.qg = 0;
            this.n.offer(qgVar);
            this.n.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg() {
        while (!this.n.isEmpty()) {
            qg qgVarPoll = this.n.poll();
            if (qgVarPoll != null) {
                qg(qgVarPoll);
            }
        }
    }

    private void qg(final qg qgVar) {
        com.byazt.qit.l.qg(new x("pl download retry") { // from class: com.byazt.wl.s.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    qgVar.n();
                } catch (Exception e) {
                    s.this.n(qgVar, e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(qg qgVar, Exception exc) {
        Log.getStackTraceString(exc);
    }

    public void n(com.byazt.hsi.s sVar) {
        this.s.set(true);
        ((oa) com.byazt.qp.q.n("device_info_new")).qg(sVar);
        this.n.clear();
    }
}
