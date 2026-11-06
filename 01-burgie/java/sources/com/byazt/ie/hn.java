package com.byazt.ie;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.nn.fw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 585, 20})
public class hn implements com.byazt.hh.x {
    public com.byazt.av.hn c;
    public final Queue<String> hn;
    public final x hw;
    public final com.byazt.hh.x pr;
    public com.byazt.hh.hw x;

    public hn(Context context, com.byazt.hh.hw hwVar, com.byazt.av.hn hnVar, com.byazt.vkw.pr prVar) {
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.hn = concurrentLinkedQueue;
        this.x = hwVar;
        this.c = hnVar;
        this.pr = new c(concurrentLinkedQueue, hwVar, prVar);
        this.hw = new x(context, this.x, prVar);
    }

    @Override // com.byazt.hh.x
    public synchronized void pr(com.byazt.hh.pr prVar, int i, boolean z) {
        if (z) {
            try {
                if (!com.byazt.nn.x.c(prVar) || !this.c.pr(prVar)) {
                    this.pr.pr(prVar, i, true);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (prVar != null) {
            this.hw.pr(prVar, i, z);
        }
    }

    @Override // com.byazt.hh.x
    public synchronized hw pr(int i, List<com.byazt.hh.pr> list, int i2) {
        hw hwVarPr;
        try {
            Iterator<com.byazt.hh.pr> it = list.iterator();
            while (it.hasNext()) {
                this.hn.remove(it.next().uc());
            }
        } catch (Throwable th) {
            hw hwVar = new hw();
            hwVar.pr(false);
            hwVar.pr("sending exception:" + th.getMessage());
            fw.pr("remove", th);
        }
        try {
            this.pr.pr(i, list, i2);
        } catch (Throwable th2) {
            hw hwVar2 = new hw();
            hwVar2.pr(false);
            hwVar2.pr("mem exception:" + th2.getMessage());
            fw.pr("mem handleResult", th2);
        }
        try {
            hwVarPr = this.hw.pr(i, list, i2);
        } catch (Exception e) {
            hw hwVar3 = new hw();
            hwVar3.pr(false);
            hwVar3.pr("db exception:" + e.getMessage());
            fw.pr("db handleResult", e);
            hwVarPr = hwVar3;
        }
        return hwVarPr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.byazt.hh.x
    public synchronized List<com.byazt.hh.pr> pr(int i, com.byazt.hh.pr prVar, boolean z, String str) {
        List<com.byazt.hh.pr> list;
        List<com.byazt.hh.pr> listPr;
        boolean z2;
        List<com.byazt.hh.pr> listPr2 = this.pr.pr(i, prVar, z, (List<String>) null);
        if (listPr2 != 0 && listPr2.size() != 0) {
            int size = listPr2.size();
            fw.pr("_ms", "memory final get :".concat(String.valueOf(size)));
            if (com.byazt.nn.x.pr(i) && (listPr = this.hw.pr((com.byazt.hh.pr) listPr2.get(0), size, i, z)) != null && listPr.size() != 0) {
                listPr.size();
                HashMap map = new HashMap();
                for (com.byazt.hh.pr prVar2 : listPr) {
                    map.put(prVar2.uc(), prVar2);
                }
                ArrayList arrayList = new ArrayList(this.hn);
                arrayList.size();
                for (com.byazt.hh.pr prVar3 : listPr) {
                    Iterator it = arrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z2 = false;
                            break;
                        }
                        if (TextUtils.equals(prVar3.uc(), (String) it.next())) {
                            fw.pr(" duplicate delete ");
                            z2 = true;
                            break;
                        }
                    }
                    if (z2) {
                        map.remove(prVar3.uc());
                    }
                }
                for (com.byazt.hh.pr prVar4 : listPr2) {
                    map.put(prVar4.uc(), prVar4);
                }
                listPr2.clear();
                Set setKeySet = map.keySet();
                map.size();
                Iterator it2 = setKeySet.iterator();
                while (it2.hasNext()) {
                    listPr2.add(map.get((String) it2.next()));
                }
                listPr.clear();
            }
            list = listPr2;
        } else {
            ArrayList<String> arrayList2 = new ArrayList(this.hn);
            int size2 = arrayList2.size();
            List<com.byazt.hh.pr> listPr3 = this.hw.pr(i, prVar, z, arrayList2);
            if (listPr3 != 0 && listPr3.size() != 0) {
                listPr3.size();
                HashMap map2 = new HashMap();
                for (com.byazt.hh.pr prVar5 : listPr3) {
                    map2.put(prVar5.uc(), prVar5);
                }
                if (size2 != 0) {
                    for (String str2 : arrayList2) {
                        if (map2.get(str2) != null) {
                            map2.remove(str2);
                        }
                    }
                }
                listPr3.clear();
                Set setKeySet2 = map2.keySet();
                map2.size();
                Iterator it3 = setKeySet2.iterator();
                while (it3.hasNext()) {
                    listPr3.add(map2.get((String) it3.next()));
                }
            }
            list = listPr3;
        }
        if (list != null && !list.isEmpty()) {
            fw.pr("_ms", " get total:" + list.size());
            Iterator<com.byazt.hh.pr> it4 = list.iterator();
            while (it4.hasNext()) {
                this.hn.offer(it4.next().uc());
            }
            return list;
        }
        return new ArrayList();
    }

    @Override // com.byazt.hh.x
    public List<com.byazt.hh.pr> pr(int i, com.byazt.hh.pr prVar, boolean z, List<String> list) {
        return null;
    }

    @Override // com.byazt.hh.x
    public synchronized boolean pr(int i, String str, com.byazt.hh.pr prVar) {
        if (this.pr.pr(i, str, prVar)) {
            fw.hn("_opt", "cacheManager check result : memory meet ".concat(String.valueOf(str)));
            return true;
        }
        if (com.byazt.nn.x.pr(i) && this.hw.pr(i, str, prVar)) {
            fw.hn("_opt", "cacheManager check result : db meet ".concat(String.valueOf(str)));
            return true;
        }
        return false;
    }

    @Override // com.byazt.hh.x
    public int pr() {
        return this.pr.pr();
    }

    @Override // com.byazt.hh.x
    public int hw() {
        return this.hw.hw();
    }

    @Override // com.byazt.hh.x
    public synchronized List<com.byazt.hh.pr> pr(int i) {
        List<com.byazt.hh.pr> listPr = this.hw.pr(i, new ArrayList(this.hn));
        if (listPr != null && !listPr.isEmpty()) {
            for (com.byazt.hh.pr prVar : listPr) {
                if (prVar != null && prVar.uc() != null) {
                    this.hn.offer(prVar.uc());
                }
            }
            return listPr;
        }
        return new ArrayList();
    }
}
