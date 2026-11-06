package com.smartdigimkt.i3;

import android.graphics.Bitmap;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements Runnable {
    public final /* synthetic */ o a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ l d;
    public final /* synthetic */ m e;

    public j(m mVar, o oVar, int i, int i2, l lVar) {
        this.e = mVar;
        this.a = oVar;
        this.b = i;
        this.c = i2;
        this.d = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bitmap bitmapA = this.e.a(this.a, this.b, this.c);
        if (bitmapA != null && !bitmapA.isRecycled()) {
            this.e.a(this.a.b, bitmapA, this.b, this.c);
            if (this.d != null) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(this.d);
                this.e.e.put(this.a.b, linkedList);
            }
            m.a(this.e, this.a.b, bitmapA);
            return;
        }
        m mVar = this.e;
        o oVar = this.a;
        int i = this.b;
        int i2 = this.c;
        l lVar = this.d;
        synchronized (mVar.e) {
            if (mVar.e.containsKey(oVar.b)) {
                LinkedList linkedList2 = (LinkedList) mVar.e.get(oVar.b);
                if (linkedList2 != null && lVar != null && !linkedList2.contains(lVar)) {
                    linkedList2.add(lVar);
                }
            } else {
                if (lVar != null) {
                    LinkedList linkedList3 = new LinkedList();
                    linkedList3.add(lVar);
                    mVar.e.put(oVar.b, linkedList3);
                }
                com.smartdigimkt.k3.b bVar = new com.smartdigimkt.k3.b(oVar);
                bVar.l = new k(mVar, i, i2, oVar);
                bVar.c();
            }
        }
    }
}
