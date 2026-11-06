package com.bytedance.sdk.component.x.xr.ms;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes2.dex */
public class ah implements ka {
    private final Queue<String> ah;
    private com.bytedance.sdk.component.x.ms.ka d;
    private com.bytedance.sdk.component.x.xr.xr.ah.xr ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final ka f1559ms;
    private final d xr;

    @Override // com.bytedance.sdk.component.x.xr.ms.ka
    public List<com.bytedance.sdk.component.x.ms.xr> ms(int i, com.bytedance.sdk.component.x.ms.xr xrVar, boolean z, List<String> list) {
        return null;
    }

    public ah(com.bytedance.sdk.component.x.ms.ka kaVar, com.bytedance.sdk.component.x.xr.xr.ah.xr xrVar) {
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.ah = concurrentLinkedQueue;
        this.d = kaVar;
        this.ka = xrVar;
        this.f1559ms = new c(concurrentLinkedQueue, this.d);
        this.xr = new d(this.d);
    }

    @Override // com.bytedance.sdk.component.x.xr.ms.ka
    public synchronized void ms(com.bytedance.sdk.component.x.ms.xr xrVar) {
        if (!com.bytedance.sdk.component.x.xr.ah.ms.ny(xrVar, this.d) || !this.ka.d()) {
            this.f1559ms.ms(xrVar);
        }
        if (xrVar != null) {
            this.xr.ms(xrVar);
        }
    }

    @Override // com.bytedance.sdk.component.x.xr.ms.ka
    public synchronized xr ms(int i, List<com.bytedance.sdk.component.x.ms.xr> list, int i2) {
        xr xrVarMs;
        try {
            Iterator<com.bytedance.sdk.component.x.ms.xr> it = list.iterator();
            while (it.hasNext()) {
                this.ah.remove(it.next().ah());
            }
        } catch (Throwable th) {
            xr xrVar = new xr();
            xrVar.ms(false);
            xrVar.ms("sending exception:" + th.getMessage());
            com.bytedance.sdk.component.x.xr.ah.ah.ah(th.getMessage(), this.d);
        }
        try {
            this.f1559ms.ms(i, list, i2);
        } catch (Throwable th2) {
            xr xrVar2 = new xr();
            xrVar2.ms(false);
            xrVar2.ms("mem exception:" + th2.getMessage());
            com.bytedance.sdk.component.x.xr.ah.ah.ah(th2.getMessage(), this.d);
        }
        try {
            xrVarMs = this.xr.ms(i, list, i2);
        } catch (Exception e) {
            xr xrVar3 = new xr();
            xrVar3.ms(false);
            xrVar3.ms("db exception:" + e.getMessage());
            com.bytedance.sdk.component.x.xr.ah.ah.ah(e.getMessage(), this.d);
            xrVarMs = xrVar3;
        }
        return xrVarMs;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.component.x.xr.ms.ka
    public synchronized List<com.bytedance.sdk.component.x.ms.xr> ms(int i, com.bytedance.sdk.component.x.ms.xr xrVar, boolean z, String str) {
        List list;
        List<com.bytedance.sdk.component.x.ms.xr> listMs;
        boolean z2;
        List<com.bytedance.sdk.component.x.ms.xr> listMs2 = this.f1559ms.ms(i, xrVar, z, (List<String>) null);
        if (listMs2 != null && listMs2.size() != 0) {
            int size = listMs2.size();
            if (com.bytedance.sdk.component.x.xr.ah.ms.ms(i) && (listMs = this.xr.ms((com.bytedance.sdk.component.x.ms.xr) listMs2.get(0), size, i, z)) != null && listMs.size() != 0) {
                list = listMs2;
                list = listMs2;
                list = listMs2;
                listMs.size();
                HashMap map = new HashMap();
                for (com.bytedance.sdk.component.x.ms.xr xrVar2 : listMs) {
                    map.put(xrVar2.ah(), xrVar2);
                }
                ArrayList arrayList = new ArrayList(this.ah);
                arrayList.size();
                for (com.bytedance.sdk.component.x.ms.xr xrVar3 : listMs) {
                    Iterator it = arrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z2 = false;
                            break;
                        }
                        if (TextUtils.equals(xrVar3.ah(), (String) it.next())) {
                            z2 = true;
                            break;
                        }
                    }
                    if (z2) {
                        map.remove(xrVar3.ah());
                    }
                }
                for (com.bytedance.sdk.component.x.ms.xr xrVar4 : listMs2) {
                    map.put(xrVar4.ah(), xrVar4);
                }
                listMs2.clear();
                Set setKeySet = map.keySet();
                map.size();
                Iterator it2 = setKeySet.iterator();
                while (it2.hasNext()) {
                    listMs2.add(map.get((String) it2.next()));
                }
                listMs.clear();
                list = listMs2;
            }
        } else {
            ArrayList<String> arrayList2 = new ArrayList(this.ah);
            int size2 = arrayList2.size();
            List<com.bytedance.sdk.component.x.ms.xr> listMs3 = this.xr.ms(i, xrVar, z, arrayList2);
            if (listMs3 != null && listMs3.size() != 0) {
                listMs3.size();
                HashMap map2 = new HashMap();
                for (com.bytedance.sdk.component.x.ms.xr xrVar5 : listMs3) {
                    map2.put(xrVar5.ah(), xrVar5);
                }
                if (size2 != 0) {
                    for (String str2 : arrayList2) {
                        if (map2.get(str2) != null) {
                            map2.remove(str2);
                        }
                    }
                }
                listMs3.clear();
                Set setKeySet2 = map2.keySet();
                map2.size();
                Iterator it3 = setKeySet2.iterator();
                while (it3.hasNext()) {
                    listMs3.add(map2.get((String) it3.next()));
                }
            }
            list = listMs3;
        }
        if (list != null && !list.isEmpty()) {
            list.size();
            Iterator it4 = list.iterator();
            while (it4.hasNext()) {
                this.ah.offer(((com.bytedance.sdk.component.x.ms.xr) it4.next()).ah());
            }
            return list;
        }
        return new ArrayList();
    }

    @Override // com.bytedance.sdk.component.x.xr.ms.ka
    public synchronized boolean ms(int i, String str, com.bytedance.sdk.component.x.ms.xr xrVar) {
        if (this.f1559ms.ms(i, str, xrVar)) {
            com.bytedance.sdk.component.x.xr.ah.ah.xr("_opt", "cacheManager check result : memory meet ".concat(String.valueOf(str)), this.d);
            return true;
        }
        if (!com.bytedance.sdk.component.x.xr.ah.ms.ms(i) || !this.xr.ms(i, str, xrVar)) {
            return false;
        }
        com.bytedance.sdk.component.x.xr.ah.ah.xr("_opt", "cacheManager check result : db meet ".concat(String.valueOf(str)), this.d);
        return true;
    }
}
