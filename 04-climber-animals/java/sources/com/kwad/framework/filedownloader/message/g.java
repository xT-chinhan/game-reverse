package com.kwad.framework.filedownloader.message;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class g {
    private final e.b aoL;
    private final List<a> aoN = new ArrayList();

    g(int i, e.b bVar) {
        this.aoL = bVar;
        for (int i2 = 0; i2 < 5; i2++) {
            this.aoN.add(new a(i2));
        }
    }

    public final void u(MessageSnapshot messageSnapshot) {
        a aVar = null;
        try {
            synchronized (this.aoN) {
                int id = messageSnapshot.getId();
                for (a aVar2 : this.aoN) {
                    if (aVar2.aoO.contains(Integer.valueOf(id))) {
                        aVar = aVar2;
                        break;
                    }
                }
                if (aVar == null) {
                    int size = 0;
                    for (a aVar3 : this.aoN) {
                        if (aVar3.aoO.size() <= 0) {
                            aVar = aVar3;
                            break;
                        } else if (size == 0 || aVar3.aoO.size() < size) {
                            size = aVar3.aoO.size();
                            aVar = aVar3;
                        }
                    }
                }
                if (aVar != null) {
                    aVar.bU(id);
                }
            }
            if (aVar != null) {
                aVar.u(messageSnapshot);
            }
        } catch (Throwable th) {
            if (aVar != null) {
                aVar.u(messageSnapshot);
            }
            throw th;
        }
    }

    public class a {
        private final List<Integer> aoO = new ArrayList();
        private final Executor aoP;

        public a(int i) {
            this.aoP = com.kwad.framework.filedownloader.f.b.r(1, "Flow-" + i);
        }

        public final void bU(int i) {
            this.aoO.add(Integer.valueOf(i));
        }

        public final void u(final MessageSnapshot messageSnapshot) {
            this.aoP.execute(new Runnable() { // from class: com.kwad.framework.filedownloader.message.g.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    g.this.aoL.r(messageSnapshot);
                    try {
                        a.this.aoO.remove(Integer.valueOf(messageSnapshot.getId()));
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }
}
