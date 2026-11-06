package com.smartdigimkt.k;

import java.io.File;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements Runnable {
    public final /* synthetic */ Runnable a;
    public final /* synthetic */ o b;

    public g(o oVar, com.smartdigimkt.j.n nVar) {
        this.b = oVar;
        this.a = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            ArrayList arrayListD = this.b.b.d();
            if (arrayListD.size() == 0) {
                Runnable runnable = this.a;
                if (runnable != null) {
                    runnable.run();
                    return;
                }
                return;
            }
            arrayListD.size();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < arrayListD.size(); i++) {
                com.smartdigimkt.b3.f fVar = (com.smartdigimkt.b3.f) arrayListD.get(i);
                String str = fVar.w;
                File file = new File(str);
                if (file.exists()) {
                    arrayList.add(file);
                }
                int i2 = fVar.x;
                for (int i3 = 0; i3 < i2; i3++) {
                    if (new File(com.smartdigimkt.n.c.a(i3, str)).exists()) {
                        arrayList.add(file);
                    }
                }
            }
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                File file2 = (File) arrayList.get(i4);
                file2.getName();
                file2.delete();
            }
            this.b.b.c();
            Runnable runnable2 = this.a;
            if (runnable2 != null) {
                runnable2.run();
            }
        } catch (Throwable th) {
            th.getMessage();
            Runnable runnable3 = this.a;
            if (runnable3 != null) {
                runnable3.run();
            }
        }
    }
}
