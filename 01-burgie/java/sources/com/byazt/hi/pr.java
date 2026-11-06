package com.byazt.hi;

import com.byazt.hh.pr;
import com.byazt.nn.fw;
import com.byazt.vkw.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1378, 37})
public abstract class pr<T extends com.byazt.hh.pr> extends com.byazt.ie.pr {
    public Queue<String> c;
    public k fw;
    public com.byazt.vkw.pr hn;
    public String hw;
    public com.byazt.hh.uc pr;
    public int uc;
    public Queue<T> x = new ConcurrentLinkedQueue();

    public pr(com.byazt.hh.uc ucVar, Queue<String> queue, String str, com.byazt.vkw.pr prVar) {
        this.hw = null;
        this.uc = -1;
        this.pr = ucVar;
        this.c = queue;
        this.hn = prVar;
        this.hw = str;
        k kVar = (k) com.byazt.zs.uc.pr("csj_settings", prVar);
        this.fw = kVar;
        this.uc = kVar.m();
    }

    public void hw(T t) {
        if (this.x != null && t != null && pr(t)) {
            if (this.uc > 0 && this.x.size() > this.uc) {
                this.x.poll();
            }
            this.x.offer(t);
        }
    }

    @Override // com.byazt.ie.pr
    public List<com.byazt.hh.pr> hw(int i, com.byazt.hh.pr prVar, boolean z, List<String> list, String str) {
        ArrayList arrayList = new ArrayList();
        fw.pr("_ms", "mem cacheSize:" + this.x.size());
        do {
            T tPoll = this.x.poll();
            if (tPoll == null) {
                break;
            }
            tPoll.hw(tPoll.aj() + 1);
            arrayList.add(tPoll);
        } while (arrayList.size() != this.pr.pr());
        return arrayList;
    }

    private void hw(int i, List<T> list, int i2) {
        com.byazt.hh.pr prVar;
        int size = this.x.size();
        if ((i == -1 || i == 200 || i == 509 || i == -3) && list != null && list.size() != 0 && size != 0) {
            HashMap map = new HashMap();
            for (T t : this.x) {
                if (t != null) {
                    map.put(t.uc(), t);
                }
            }
            for (T t2 : list) {
                if (t2 != null && (prVar = (com.byazt.hh.pr) map.get(t2.uc())) != null) {
                    this.x.remove(prVar);
                }
            }
        }
        fw.pr("_msg", i + "handle result memory size：" + size + " " + this.x.size());
    }

    public com.byazt.ie.hw pr(int i, List<T> list, int i2) {
        com.byazt.ie.hw hwVar = new com.byazt.ie.hw();
        if (list != null && list.size() != 0 && list.get(0) != null && pr(list.get(0))) {
            hw(i, list, i2);
            hwVar.pr(true);
            return hwVar;
        }
        hwVar.pr(false);
        return hwVar;
    }

    @Override // com.byazt.ie.pr
    public boolean hw(int i, String str, com.byazt.hh.pr prVar) {
        int size = this.x.size();
        int iHw = this.pr.hw();
        fw.pr(str + " checkEventComeMeet --> " + this.hw + " cacheQueueSize:" + size + " MaxCacheCount:" + iHw + " message:" + com.byazt.nn.x.hw(i));
        return size >= iHw;
    }

    @Override // com.byazt.ie.pr
    public boolean pr(String str) {
        int size = this.x.size();
        fw.pr(str + " checkFlushMeet --> " + this.hw + " cacheQueueSize:" + size);
        return size > 0;
    }

    public int pr() {
        return this.x.size();
    }
}
