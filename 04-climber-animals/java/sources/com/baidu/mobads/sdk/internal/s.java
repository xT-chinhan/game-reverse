package com.baidu.mobads.sdk.internal;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class s {
    private static volatile s a;
    private List<aa.a> b = new CopyOnWriteArrayList();

    private s() {
    }

    public static s a() {
        if (a == null) {
            synchronized (s.class) {
                if (a == null) {
                    a = new s();
                }
            }
        }
        return a;
    }

    public void a(aa.a aVar) {
        if (aVar == null || this.b.contains(aVar)) {
            return;
        }
        this.b.add(aVar);
    }

    public void a(int i) {
        for (aa.a aVar : this.b) {
            if (i == 1) {
                aVar.onSuccess();
            } else if (i == 2) {
                aVar.onFailure();
            }
            b(aVar);
        }
    }

    private void b(aa.a aVar) {
        if (this.b.contains(aVar)) {
            this.b.remove(aVar);
        }
    }
}
