package com.byazt.fa;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.hls.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT, 8})
public class s implements com.byazt.vr.q {
    public com.byazt.jeb.s l;
    public final com.byazt.vr.q n;
    public com.byazt.vr.qg q;
    public final q qg;
    public final Queue<String> s;

    @Override // com.byazt.vr.q
    public List<com.byazt.vr.n> n(int i, com.byazt.vr.n nVar, boolean z, List<String> list) {
        return null;
    }

    public s(Context context, com.byazt.vr.qg qgVar, com.byazt.jeb.s sVar, com.byazt.vf.n nVar) {
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.s = concurrentLinkedQueue;
        this.q = qgVar;
        this.l = sVar;
        this.n = new l(concurrentLinkedQueue, this.q, nVar);
        this.qg = new q(context, this.q, nVar);
    }

    @Override // com.byazt.vr.q
    public synchronized void n(com.byazt.vr.n nVar, int i, boolean z) {
        if (z) {
            try {
                if (!com.byazt.hls.q.l(nVar) || !this.l.n(nVar)) {
                    this.n.n(nVar, i, true);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (nVar != null) {
            this.qg.n(nVar, i, z);
        }
    }

    @Override // com.byazt.vr.q
    public synchronized qg n(int i, List<com.byazt.vr.n> list, int i2) {
        qg qgVarN;
        try {
            Iterator<com.byazt.vr.n> it = list.iterator();
            while (it.hasNext()) {
                this.s.remove(it.next().w());
            }
        } catch (Throwable th) {
            qg qgVar = new qg();
            qgVar.n(false);
            qgVar.n("sending exception:" + th.getMessage());
            x.n("remove", th);
        }
        try {
            this.n.n(i, list, i2);
        } catch (Throwable th2) {
            qg qgVar2 = new qg();
            qgVar2.n(false);
            qgVar2.n("mem exception:" + th2.getMessage());
            x.n("mem handleResult", th2);
        }
        try {
            qgVarN = this.qg.n(i, list, i2);
        } catch (Exception e) {
            qg qgVar3 = new qg();
            qgVar3.n(false);
            qgVar3.n("db exception:" + e.getMessage());
            x.n("db handleResult", e);
            qgVarN = qgVar3;
        }
        return qgVarN;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.byazt.vr.q
    public synchronized List<com.byazt.vr.n> n(int i, com.byazt.vr.n nVar, boolean z, String str) {
        List list;
        List<com.byazt.vr.n> listN;
        boolean z2;
        List<com.byazt.vr.n> listN2 = this.n.n(i, nVar, z, (List<String>) null);
        if (listN2 != null && listN2.size() != 0) {
            int size = listN2.size();
            x.n("_ms", "memory final get :".concat(String.valueOf(size)));
            if (com.byazt.hls.q.n(i) && (listN = this.qg.n((com.byazt.vr.n) listN2.get(0), size, i, z)) != null && listN.size() != 0) {
                list = listN2;
                list = listN2;
                list = listN2;
                listN.size();
                HashMap map = new HashMap();
                for (com.byazt.vr.n nVar2 : listN) {
                    map.put(nVar2.w(), nVar2);
                }
                ArrayList arrayList = new ArrayList(this.s);
                arrayList.size();
                for (com.byazt.vr.n nVar3 : listN) {
                    Iterator it = arrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z2 = false;
                            break;
                        }
                        if (TextUtils.equals(nVar3.w(), (String) it.next())) {
                            x.n(" duplicate delete ");
                            z2 = true;
                            break;
                        }
                    }
                    if (z2) {
                        map.remove(nVar3.w());
                    }
                }
                for (com.byazt.vr.n nVar4 : listN2) {
                    map.put(nVar4.w(), nVar4);
                }
                listN2.clear();
                Set setKeySet = map.keySet();
                map.size();
                Iterator it2 = setKeySet.iterator();
                while (it2.hasNext()) {
                    listN2.add(map.get((String) it2.next()));
                }
                listN.clear();
                list = listN2;
            }
        } else {
            ArrayList<String> arrayList2 = new ArrayList(this.s);
            int size2 = arrayList2.size();
            List<com.byazt.vr.n> listN3 = this.qg.n(i, nVar, z, arrayList2);
            if (listN3 != null && listN3.size() != 0) {
                listN3.size();
                HashMap map2 = new HashMap();
                for (com.byazt.vr.n nVar5 : listN3) {
                    map2.put(nVar5.w(), nVar5);
                }
                if (size2 != 0) {
                    for (String str2 : arrayList2) {
                        if (map2.get(str2) != null) {
                            map2.remove(str2);
                        }
                    }
                }
                listN3.clear();
                Set setKeySet2 = map2.keySet();
                map2.size();
                Iterator it3 = setKeySet2.iterator();
                while (it3.hasNext()) {
                    listN3.add(map2.get((String) it3.next()));
                }
            }
            list = listN3;
        }
        if (list != null && !list.isEmpty()) {
            x.n("_ms", " get total:" + list.size());
            Iterator it4 = list.iterator();
            while (it4.hasNext()) {
                this.s.offer(((com.byazt.vr.n) it4.next()).w());
            }
            return list;
        }
        return new ArrayList();
    }

    @Override // com.byazt.vr.q
    public synchronized boolean n(int i, String str, com.byazt.vr.n nVar) {
        if (this.n.n(i, str, nVar)) {
            x.s("_opt", "cacheManager check result : memory meet ".concat(String.valueOf(str)));
            return true;
        }
        if (!com.byazt.hls.q.n(i) || !this.qg.n(i, str, nVar)) {
            return false;
        }
        x.s("_opt", "cacheManager check result : db meet ".concat(String.valueOf(str)));
        return true;
    }

    @Override // com.byazt.vr.q
    public int n() {
        return this.n.n();
    }

    @Override // com.byazt.vr.q
    public int qg() {
        return this.qg.qg();
    }

    @Override // com.byazt.vr.q
    public synchronized List<com.byazt.vr.n> n(int i) {
        List<com.byazt.vr.n> listN = this.qg.n(i, new ArrayList(this.s));
        if (listN != null && !listN.isEmpty()) {
            for (com.byazt.vr.n nVar : listN) {
                if (nVar != null && nVar.w() != null) {
                    this.s.offer(nVar.w());
                }
            }
            return listN;
        }
        return new ArrayList();
    }
}
