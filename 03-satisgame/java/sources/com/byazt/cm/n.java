package com.byazt.cm;

import com.byazt.hls.x;
import com.byazt.vf.cp;
import com.byazt.vr.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1849, 19})
public abstract class n<T extends com.byazt.vr.n> extends com.byazt.fa.n {
    public Queue<String> l;
    public com.byazt.vr.w n;
    public Queue<T> q = new ConcurrentLinkedQueue();
    public String qg;
    public com.byazt.vf.n s;
    public int w;
    public cp x;

    public n(com.byazt.vr.w wVar, Queue<String> queue, String str, com.byazt.vf.n nVar) {
        this.w = -1;
        this.n = wVar;
        this.l = queue;
        this.s = nVar;
        this.qg = str;
        cp cpVar = (cp) com.byazt.qp.q.n("csj_settings", nVar);
        this.x = cpVar;
        this.w = cpVar.oa();
    }

    public void qg(T t) {
        if (this.q == null || t == null || !n(t)) {
            return;
        }
        if (this.w > 0 && this.q.size() > this.w) {
            this.q.poll();
        }
        this.q.offer(t);
    }

    @Override // com.byazt.fa.n
    public List<com.byazt.vr.n> qg(int i, com.byazt.vr.n nVar, boolean z, List<String> list, String str) {
        ArrayList arrayList = new ArrayList();
        x.n("_ms", "mem cacheSize:" + this.q.size());
        do {
            T tPoll = this.q.poll();
            if (tPoll == null) {
                break;
            }
            tPoll.qg(tPoll.rv() + 1);
            arrayList.add(tPoll);
        } while (arrayList.size() != this.n.n());
        return arrayList;
    }

    private void qg(int i, List<T> list, int i2) {
        com.byazt.vr.n nVar;
        int size = this.q.size();
        if ((i == -1 || i == 200 || i == 509 || i == -3) && list != null && list.size() != 0 && size != 0) {
            HashMap map = new HashMap();
            for (T t : this.q) {
                if (t != null) {
                    map.put(t.w(), t);
                }
            }
            for (T t2 : list) {
                if (t2 != null && (nVar = (com.byazt.vr.n) map.get(t2.w())) != null) {
                    try {
                        this.q.remove(nVar);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        x.n("_msg", i + "handle result memory size：" + size + " " + this.q.size());
    }

    public com.byazt.fa.qg n(int i, List<T> list, int i2) {
        com.byazt.fa.qg qgVar = new com.byazt.fa.qg();
        if (list != null && list.size() != 0 && list.get(0) != null && n(list.get(0))) {
            qg(i, list, i2);
            qgVar.n(true);
            return qgVar;
        }
        qgVar.n(false);
        return qgVar;
    }

    @Override // com.byazt.fa.n
    public boolean qg(int i, String str, com.byazt.vr.n nVar) {
        int size = this.q.size();
        int iQg = this.n.qg();
        x.n(str + " checkEventComeMeet --> " + this.qg + " cacheQueueSize:" + size + " MaxCacheCount:" + iQg + " message:" + com.byazt.hls.q.qg(i));
        return size >= iQg;
    }

    @Override // com.byazt.fa.n
    public boolean n(String str) {
        int size = this.q.size();
        x.n(str + " checkFlushMeet --> " + this.qg + " cacheQueueSize:" + size);
        return size > 0;
    }

    public int n() {
        return this.q.size();
    }
}
