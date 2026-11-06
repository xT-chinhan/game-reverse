package com.tapsdk.tapad.internal.download.m.d;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tapsdk.tapad.internal.download.core.cause.EndCause;
import com.tapsdk.tapad.internal.download.core.cause.ResumeFailedCause;
import com.tapsdk.tapad.internal.download.f;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    private static final String c = "CallbackDispatcher";
    private final com.tapsdk.tapad.internal.download.c a;
    private final Handler b;

    /* JADX INFO: renamed from: com.tapsdk.tapad.internal.download.m.d.a$a, reason: collision with other inner class name */
    class RunnableC0608a implements Runnable {
        final /* synthetic */ Collection a;
        final /* synthetic */ Exception b;

        RunnableC0608a(Collection collection, Exception exc) {
            this.a = collection;
            this.b = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (f fVar : this.a) {
                fVar.n().a(fVar, EndCause.ERROR, this.b);
            }
        }
    }

    class b implements Runnable {
        final /* synthetic */ Collection a;
        final /* synthetic */ Collection b;
        final /* synthetic */ Collection c;

        b(Collection collection, Collection collection2, Collection collection3) {
            this.a = collection;
            this.b = collection2;
            this.c = collection3;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (f fVar : this.a) {
                fVar.n().a(fVar, EndCause.COMPLETED, (Exception) null);
            }
            for (f fVar2 : this.b) {
                fVar2.n().a(fVar2, EndCause.SAME_TASK_BUSY, (Exception) null);
            }
            for (f fVar3 : this.c) {
                fVar3.n().a(fVar3, EndCause.FILE_BUSY, (Exception) null);
            }
        }
    }

    class c implements Runnable {
        final /* synthetic */ Collection a;

        c(Collection collection) {
            this.a = collection;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (f fVar : this.a) {
                fVar.n().a(fVar, EndCause.CANCELED, (Exception) null);
            }
        }
    }

    static class d implements com.tapsdk.tapad.internal.download.c {
        private final Handler a;

        /* JADX INFO: renamed from: com.tapsdk.tapad.internal.download.m.d.a$d$a, reason: collision with other inner class name */
        class RunnableC0609a implements Runnable {
            final /* synthetic */ com.tapsdk.tapad.internal.download.f a;
            final /* synthetic */ int b;
            final /* synthetic */ long c;

            RunnableC0609a(com.tapsdk.tapad.internal.download.f fVar, int i, long j) {
                this.a = fVar;
                this.b = i;
                this.c = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.n().c(this.a, this.b, this.c);
            }
        }

        class b implements Runnable {
            final /* synthetic */ com.tapsdk.tapad.internal.download.f a;
            final /* synthetic */ EndCause b;
            final /* synthetic */ Exception c;

            b(com.tapsdk.tapad.internal.download.f fVar, EndCause endCause, Exception exc) {
                this.a = fVar;
                this.b = endCause;
                this.c = exc;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.n().a(this.a, this.b, this.c);
            }
        }

        class c implements Runnable {
            final /* synthetic */ com.tapsdk.tapad.internal.download.f a;

            c(com.tapsdk.tapad.internal.download.f fVar) {
                this.a = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.n().a(this.a);
            }
        }

        /* JADX INFO: renamed from: com.tapsdk.tapad.internal.download.m.d.a$d$d, reason: collision with other inner class name */
        class RunnableC0610d implements Runnable {
            final /* synthetic */ com.tapsdk.tapad.internal.download.f a;
            final /* synthetic */ Map b;

            RunnableC0610d(com.tapsdk.tapad.internal.download.f fVar, Map map) {
                this.a = fVar;
                this.b = map;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.n().a(this.a, this.b);
            }
        }

        class e implements Runnable {
            final /* synthetic */ com.tapsdk.tapad.internal.download.f a;
            final /* synthetic */ int b;
            final /* synthetic */ Map c;

            e(com.tapsdk.tapad.internal.download.f fVar, int i, Map map) {
                this.a = fVar;
                this.b = i;
                this.c = map;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.n().b(this.a, this.b, this.c);
            }
        }

        class f implements Runnable {
            final /* synthetic */ com.tapsdk.tapad.internal.download.f a;
            final /* synthetic */ com.tapsdk.tapad.internal.download.core.breakpoint.c b;
            final /* synthetic */ ResumeFailedCause c;

            f(com.tapsdk.tapad.internal.download.f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar, ResumeFailedCause resumeFailedCause) {
                this.a = fVar;
                this.b = cVar;
                this.c = resumeFailedCause;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.n().a(this.a, this.b, this.c);
            }
        }

        class g implements Runnable {
            final /* synthetic */ com.tapsdk.tapad.internal.download.f a;
            final /* synthetic */ com.tapsdk.tapad.internal.download.core.breakpoint.c b;

            g(com.tapsdk.tapad.internal.download.f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar) {
                this.a = fVar;
                this.b = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.n().a(this.a, this.b);
            }
        }

        class h implements Runnable {
            final /* synthetic */ com.tapsdk.tapad.internal.download.f a;
            final /* synthetic */ int b;
            final /* synthetic */ Map c;

            h(com.tapsdk.tapad.internal.download.f fVar, int i, Map map) {
                this.a = fVar;
                this.b = i;
                this.c = map;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.n().a(this.a, this.b, this.c);
            }
        }

        class i implements Runnable {
            final /* synthetic */ com.tapsdk.tapad.internal.download.f a;
            final /* synthetic */ int b;
            final /* synthetic */ int c;
            final /* synthetic */ Map d;

            i(com.tapsdk.tapad.internal.download.f fVar, int i, int i2, Map map) {
                this.a = fVar;
                this.b = i;
                this.c = i2;
                this.d = map;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.n().a(this.a, this.b, this.c, this.d);
            }
        }

        class j implements Runnable {
            final /* synthetic */ com.tapsdk.tapad.internal.download.f a;
            final /* synthetic */ int b;
            final /* synthetic */ long c;

            j(com.tapsdk.tapad.internal.download.f fVar, int i, long j) {
                this.a = fVar;
                this.b = i;
                this.c = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.n().b(this.a, this.b, this.c);
            }
        }

        class k implements Runnable {
            final /* synthetic */ com.tapsdk.tapad.internal.download.f a;
            final /* synthetic */ int b;
            final /* synthetic */ long c;

            k(com.tapsdk.tapad.internal.download.f fVar, int i, long j) {
                this.a = fVar;
                this.b = i;
                this.c = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.n().a(this.a, this.b, this.c);
            }
        }

        d(Handler handler) {
            this.a = handler;
        }

        @Override // com.tapsdk.tapad.internal.download.c
        public void a(com.tapsdk.tapad.internal.download.f fVar) {
            com.tapsdk.tapad.internal.download.m.c.a(a.c, "taskStart: " + fVar.b());
            b(fVar);
            if (fVar.y()) {
                this.a.post(new c(fVar));
            } else {
                fVar.n().a(fVar);
            }
        }

        @Override // com.tapsdk.tapad.internal.download.c
        public void a(com.tapsdk.tapad.internal.download.f fVar, int i2, int i3, Map<String, List<String>> map) {
            com.tapsdk.tapad.internal.download.m.c.a(a.c, "<----- finish connection task(" + fVar.b() + ") block(" + i2 + ") code[" + i3 + "]" + map);
            if (fVar.y()) {
                this.a.post(new i(fVar, i2, i3, map));
            } else {
                fVar.n().a(fVar, i2, i3, map);
            }
        }

        @Override // com.tapsdk.tapad.internal.download.c
        public void a(com.tapsdk.tapad.internal.download.f fVar, int i2, long j2) {
            if (fVar.o() > 0) {
                com.tapsdk.tapad.internal.download.f.c.a(fVar, SystemClock.uptimeMillis());
            }
            if (fVar.y()) {
                this.a.post(new k(fVar, i2, j2));
            } else {
                fVar.n().a(fVar, i2, j2);
            }
        }

        @Override // com.tapsdk.tapad.internal.download.c
        public void a(com.tapsdk.tapad.internal.download.f fVar, int i2, Map<String, List<String>> map) {
            com.tapsdk.tapad.internal.download.m.c.a(a.c, "-----> start connection task(" + fVar.b() + ") block(" + i2 + ") " + map);
            if (fVar.y()) {
                this.a.post(new h(fVar, i2, map));
            } else {
                fVar.n().a(fVar, i2, map);
            }
        }

        @Override // com.tapsdk.tapad.internal.download.c
        public void a(com.tapsdk.tapad.internal.download.f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar) {
            com.tapsdk.tapad.internal.download.m.c.a(a.c, "downloadFromBreakpoint: " + fVar.b());
            b(fVar, cVar);
            if (fVar.y()) {
                this.a.post(new g(fVar, cVar));
            } else {
                fVar.n().a(fVar, cVar);
            }
        }

        @Override // com.tapsdk.tapad.internal.download.c
        public void a(com.tapsdk.tapad.internal.download.f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar, ResumeFailedCause resumeFailedCause) {
            com.tapsdk.tapad.internal.download.m.c.a(a.c, "downloadFromBeginning: " + fVar.b());
            b(fVar, cVar, resumeFailedCause);
            if (fVar.y()) {
                this.a.post(new f(fVar, cVar, resumeFailedCause));
            } else {
                fVar.n().a(fVar, cVar, resumeFailedCause);
            }
        }

        @Override // com.tapsdk.tapad.internal.download.c
        public void a(com.tapsdk.tapad.internal.download.f fVar, EndCause endCause, Exception exc) {
            if (endCause == EndCause.ERROR) {
                com.tapsdk.tapad.internal.download.m.c.a(a.c, "taskEnd: " + fVar.b() + " " + endCause + " " + exc);
            }
            b(fVar, endCause, exc);
            if (fVar.y()) {
                this.a.post(new b(fVar, endCause, exc));
            } else {
                fVar.n().a(fVar, endCause, exc);
            }
        }

        @Override // com.tapsdk.tapad.internal.download.c
        public void a(com.tapsdk.tapad.internal.download.f fVar, Map<String, List<String>> map) {
            com.tapsdk.tapad.internal.download.m.c.a(a.c, "-----> start trial task(" + fVar.b() + ") " + map);
            if (fVar.y()) {
                this.a.post(new RunnableC0610d(fVar, map));
            } else {
                fVar.n().a(fVar, map);
            }
        }

        void b(com.tapsdk.tapad.internal.download.f fVar) {
            com.tapsdk.tapad.internal.download.d dVarG = com.tapsdk.tapad.internal.download.i.j().g();
            if (dVarG != null) {
                dVarG.a(fVar);
            }
        }

        @Override // com.tapsdk.tapad.internal.download.c
        public void b(com.tapsdk.tapad.internal.download.f fVar, int i2, long j2) {
            com.tapsdk.tapad.internal.download.m.c.a(a.c, "fetchStart: " + fVar.b());
            if (fVar.y()) {
                this.a.post(new j(fVar, i2, j2));
            } else {
                fVar.n().b(fVar, i2, j2);
            }
        }

        @Override // com.tapsdk.tapad.internal.download.c
        public void b(com.tapsdk.tapad.internal.download.f fVar, int i2, Map<String, List<String>> map) {
            com.tapsdk.tapad.internal.download.m.c.a(a.c, "<----- finish trial task(" + fVar.b() + ") code[" + i2 + "]" + map);
            if (fVar.y()) {
                this.a.post(new e(fVar, i2, map));
            } else {
                fVar.n().b(fVar, i2, map);
            }
        }

        void b(com.tapsdk.tapad.internal.download.f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar) {
            com.tapsdk.tapad.internal.download.d dVarG = com.tapsdk.tapad.internal.download.i.j().g();
            if (dVarG != null) {
                dVarG.a(fVar, cVar);
            }
        }

        void b(com.tapsdk.tapad.internal.download.f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar, ResumeFailedCause resumeFailedCause) {
            com.tapsdk.tapad.internal.download.d dVarG = com.tapsdk.tapad.internal.download.i.j().g();
            if (dVarG != null) {
                dVarG.a(fVar, cVar, resumeFailedCause);
            }
        }

        void b(com.tapsdk.tapad.internal.download.f fVar, EndCause endCause, Exception exc) {
            com.tapsdk.tapad.internal.download.d dVarG = com.tapsdk.tapad.internal.download.i.j().g();
            if (dVarG != null) {
                dVarG.a(fVar, endCause, exc);
            }
        }

        @Override // com.tapsdk.tapad.internal.download.c
        public void c(com.tapsdk.tapad.internal.download.f fVar, int i2, long j2) {
            com.tapsdk.tapad.internal.download.m.c.a(a.c, "fetchEnd: " + fVar.b());
            if (fVar.y()) {
                this.a.post(new RunnableC0609a(fVar, i2, j2));
            } else {
                fVar.n().c(fVar, i2, j2);
            }
        }
    }

    public a() {
        Handler handler = new Handler(Looper.getMainLooper());
        this.b = handler;
        this.a = new d(handler);
    }

    a(Handler handler, com.tapsdk.tapad.internal.download.c cVar) {
        this.b = handler;
        this.a = cVar;
    }

    public com.tapsdk.tapad.internal.download.c a() {
        return this.a;
    }

    public void a(Collection<f> collection) {
        if (collection.size() <= 0) {
            return;
        }
        com.tapsdk.tapad.internal.download.m.c.a(c, "endTasksWithCanceled canceled[" + collection.size() + "]");
        Iterator<f> it = collection.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!next.y()) {
                next.n().a(next, EndCause.CANCELED, (Exception) null);
                it.remove();
            }
        }
        this.b.post(new c(collection));
    }

    public void a(Collection<f> collection, Exception exc) {
        if (collection.size() <= 0) {
            return;
        }
        com.tapsdk.tapad.internal.download.m.c.a(c, "endTasksWithError error[" + collection.size() + "] realCause: " + exc);
        Iterator<f> it = collection.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!next.y()) {
                next.n().a(next, EndCause.ERROR, exc);
                it.remove();
            }
        }
        this.b.post(new RunnableC0608a(collection, exc));
    }

    public void a(Collection<f> collection, Collection<f> collection2, Collection<f> collection3) {
        if (collection.size() == 0 && collection2.size() == 0 && collection3.size() == 0) {
            return;
        }
        com.tapsdk.tapad.internal.download.m.c.a(c, "endTasks completed[" + collection.size() + "] sameTask[" + collection2.size() + "] fileBusy[" + collection3.size() + "]");
        if (collection.size() > 0) {
            Iterator<f> it = collection.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (!next.y()) {
                    next.n().a(next, EndCause.COMPLETED, (Exception) null);
                    it.remove();
                }
            }
        }
        if (collection2.size() > 0) {
            Iterator<f> it2 = collection2.iterator();
            while (it2.hasNext()) {
                f next2 = it2.next();
                if (!next2.y()) {
                    next2.n().a(next2, EndCause.SAME_TASK_BUSY, (Exception) null);
                    it2.remove();
                }
            }
        }
        if (collection3.size() > 0) {
            Iterator<f> it3 = collection3.iterator();
            while (it3.hasNext()) {
                f next3 = it3.next();
                if (!next3.y()) {
                    next3.n().a(next3, EndCause.FILE_BUSY, (Exception) null);
                    it3.remove();
                }
            }
        }
        if (collection.size() == 0 && collection2.size() == 0 && collection3.size() == 0) {
            return;
        }
        this.b.post(new b(collection, collection2, collection3));
    }

    public boolean a(f fVar) {
        long jO = fVar.o();
        return jO <= 0 || SystemClock.uptimeMillis() - f.c.a(fVar) >= jO;
    }
}
