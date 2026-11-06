package com.tapsdk.tapad.internal.tracker.experiment;

import android.app.Application;
import io.reactivex.subjects.PublishSubject;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    static e e;
    private ExpTdsTrackerConfig a;
    private String b;
    private com.tapsdk.tapad.internal.tracker.experiment.i.a c;
    private AtomicBoolean d = new AtomicBoolean(false);

    class a implements e.a {
        final /* synthetic */ Application a;
        final /* synthetic */ PublishSubject b;
        final /* synthetic */ Map c;

        a(Application application, PublishSubject publishSubject, Map map) {
            this.a = application;
            this.b = publishSubject;
            this.c = map;
        }

        @Override // com.tapsdk.tapad.internal.tracker.experiment.e.a
        public void a() {
            c.e.a(this.a, this.b, this.c);
            c.this.d.set(true);
        }
    }

    static {
        e eVar = new e("TdsTracker_Thread");
        e = eVar;
        eVar.start();
    }

    public c(ExpTdsTrackerConfig expTdsTrackerConfig, Application application, PublishSubject<com.tapsdk.tapad.internal.tracker.experiment.entities.c> publishSubject, Map<String, com.tapsdk.tapad.internal.tracker.experiment.i.a> map) {
        this.a = expTdsTrackerConfig;
        e.a(new a(application, publishSubject, map));
    }

    public void a(com.tapsdk.tapad.internal.tracker.experiment.h.c cVar) {
        try {
            e.a(this.a, cVar.a());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
