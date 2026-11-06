package com.bytedance.sdk.component.x.xr.ms.xr;

import com.bytedance.sdk.component.x.ms.xr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms<T extends com.bytedance.sdk.component.x.ms.xr> extends com.bytedance.sdk.component.x.xr.ms.ms {
    public com.bytedance.sdk.component.x.ms.ka ah;
    private Queue<T> d = new ConcurrentLinkedQueue();
    private Queue<String> ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public com.bytedance.sdk.component.x.xr.d.xr.ms f1571ms;
    public String xr;

    public ms(com.bytedance.sdk.component.x.xr.d.xr.ms msVar, Queue<String> queue, String str, com.bytedance.sdk.component.x.ms.ka kaVar) {
        this.f1571ms = msVar;
        this.ka = queue;
        this.ah = kaVar;
        this.xr = str;
    }

    public void xr(T t) {
        if (this.d == null || t == null || !ms(t)) {
            return;
        }
        this.d.offer(t);
    }

    @Override // com.bytedance.sdk.component.x.xr.ms.ms
    public List<com.bytedance.sdk.component.x.ms.xr> xr(int i, com.bytedance.sdk.component.x.ms.xr xrVar, boolean z, List<String> list, String str) {
        ArrayList arrayList = new ArrayList();
        this.d.size();
        do {
            T tPoll = this.d.poll();
            if (tPoll == null) {
                break;
            }
            arrayList.add(tPoll);
        } while (arrayList.size() != this.f1571ms.xr());
        return arrayList;
    }

    private void xr(int i, List<T> list, int i2) {
        com.bytedance.sdk.component.x.ms.xr xrVar;
        int size = this.d.size();
        if ((i == -1 || i == 200 || i == 509 || i == -3) && list != null && list.size() != 0 && size != 0) {
            HashMap map = new HashMap();
            for (T t : this.d) {
                if (t != null) {
                    map.put(t.ah(), t);
                }
            }
            for (T t2 : list) {
                if (t2 != null && (xrVar = (com.bytedance.sdk.component.x.ms.xr) map.get(t2.ah())) != null) {
                    this.d.remove(xrVar);
                }
            }
        }
        this.d.size();
    }

    public com.bytedance.sdk.component.x.xr.ms.xr ms(int i, List<T> list, int i2) {
        com.bytedance.sdk.component.x.xr.ms.xr xrVar = new com.bytedance.sdk.component.x.xr.ms.xr();
        if (list != null && list.size() != 0 && list.get(0) != null && ms(list.get(0))) {
            xr(i, list, i2);
            xrVar.ms(true);
            return xrVar;
        }
        xrVar.ms(false);
        return xrVar;
    }

    @Override // com.bytedance.sdk.component.x.xr.ms.ms
    public boolean xr(int i, String str, com.bytedance.sdk.component.x.ms.xr xrVar) {
        int size = this.d.size();
        int iMs = this.f1571ms.ms();
        com.bytedance.sdk.component.x.xr.ah.ms.xr(i);
        return size >= iMs;
    }

    @Override // com.bytedance.sdk.component.x.xr.ms.ms
    public boolean ms(String str) {
        return this.d.size() > 0;
    }
}
