package com.tapsdk.tapad.internal.download.m.i;

import com.tapsdk.tapad.internal.download.core.cause.EndCause;
import com.tapsdk.tapad.internal.download.core.cause.ResumeFailedCause;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class f implements com.tapsdk.tapad.internal.download.c {
    final com.tapsdk.tapad.internal.download.c[] a;

    public static class a {
        private List<com.tapsdk.tapad.internal.download.c> a = new ArrayList();

        public a a(com.tapsdk.tapad.internal.download.c cVar) {
            if (cVar != null && !this.a.contains(cVar)) {
                this.a.add(cVar);
            }
            return this;
        }

        public f a() {
            List<com.tapsdk.tapad.internal.download.c> list = this.a;
            return new f((com.tapsdk.tapad.internal.download.c[]) list.toArray(new com.tapsdk.tapad.internal.download.c[list.size()]));
        }

        public boolean b(com.tapsdk.tapad.internal.download.c cVar) {
            return this.a.remove(cVar);
        }
    }

    f(com.tapsdk.tapad.internal.download.c[] cVarArr) {
        this.a = cVarArr;
    }

    @Override // com.tapsdk.tapad.internal.download.c
    public void a(com.tapsdk.tapad.internal.download.f fVar) {
        for (com.tapsdk.tapad.internal.download.c cVar : this.a) {
            cVar.a(fVar);
        }
    }

    @Override // com.tapsdk.tapad.internal.download.c
    public void a(com.tapsdk.tapad.internal.download.f fVar, int i, int i2, Map<String, List<String>> map) {
        for (com.tapsdk.tapad.internal.download.c cVar : this.a) {
            cVar.a(fVar, i, i2, map);
        }
    }

    @Override // com.tapsdk.tapad.internal.download.c
    public void a(com.tapsdk.tapad.internal.download.f fVar, int i, long j) {
        for (com.tapsdk.tapad.internal.download.c cVar : this.a) {
            cVar.a(fVar, i, j);
        }
    }

    @Override // com.tapsdk.tapad.internal.download.c
    public void a(com.tapsdk.tapad.internal.download.f fVar, int i, Map<String, List<String>> map) {
        for (com.tapsdk.tapad.internal.download.c cVar : this.a) {
            cVar.a(fVar, i, map);
        }
    }

    @Override // com.tapsdk.tapad.internal.download.c
    public void a(com.tapsdk.tapad.internal.download.f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar) {
        for (com.tapsdk.tapad.internal.download.c cVar2 : this.a) {
            cVar2.a(fVar, cVar);
        }
    }

    @Override // com.tapsdk.tapad.internal.download.c
    public void a(com.tapsdk.tapad.internal.download.f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar, ResumeFailedCause resumeFailedCause) {
        for (com.tapsdk.tapad.internal.download.c cVar2 : this.a) {
            cVar2.a(fVar, cVar, resumeFailedCause);
        }
    }

    @Override // com.tapsdk.tapad.internal.download.c
    public void a(com.tapsdk.tapad.internal.download.f fVar, EndCause endCause, Exception exc) {
        for (com.tapsdk.tapad.internal.download.c cVar : this.a) {
            cVar.a(fVar, endCause, exc);
        }
    }

    @Override // com.tapsdk.tapad.internal.download.c
    public void a(com.tapsdk.tapad.internal.download.f fVar, Map<String, List<String>> map) {
        for (com.tapsdk.tapad.internal.download.c cVar : this.a) {
            cVar.a(fVar, map);
        }
    }

    public boolean a(com.tapsdk.tapad.internal.download.c cVar) {
        for (com.tapsdk.tapad.internal.download.c cVar2 : this.a) {
            if (cVar2 == cVar) {
                return true;
            }
        }
        return false;
    }

    public int b(com.tapsdk.tapad.internal.download.c cVar) {
        int i = 0;
        while (true) {
            com.tapsdk.tapad.internal.download.c[] cVarArr = this.a;
            if (i >= cVarArr.length) {
                return -1;
            }
            if (cVarArr[i] == cVar) {
                return i;
            }
            i++;
        }
    }

    @Override // com.tapsdk.tapad.internal.download.c
    public void b(com.tapsdk.tapad.internal.download.f fVar, int i, long j) {
        for (com.tapsdk.tapad.internal.download.c cVar : this.a) {
            cVar.b(fVar, i, j);
        }
    }

    @Override // com.tapsdk.tapad.internal.download.c
    public void b(com.tapsdk.tapad.internal.download.f fVar, int i, Map<String, List<String>> map) {
        for (com.tapsdk.tapad.internal.download.c cVar : this.a) {
            cVar.b(fVar, i, map);
        }
    }

    @Override // com.tapsdk.tapad.internal.download.c
    public void c(com.tapsdk.tapad.internal.download.f fVar, int i, long j) {
        for (com.tapsdk.tapad.internal.download.c cVar : this.a) {
            cVar.c(fVar, i, j);
        }
    }
}
