package com.tapsdk.tapad.internal.tracker.experiment;

import android.app.Application;
import android.os.HandlerThread;
import io.reactivex.subjects.PublishSubject;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class e extends HandlerThread {
    private d a;
    private a b;

    public interface a {
        void a();
    }

    public e(String str) {
        super(str, 1);
    }

    void a(Application application, PublishSubject<com.tapsdk.tapad.internal.tracker.experiment.entities.c> publishSubject, Map<String, com.tapsdk.tapad.internal.tracker.experiment.i.a> map) {
        if (application != null) {
            this.a.a(publishSubject);
            this.a.a(map);
            this.a.a(application);
        }
    }

    void a(ExpTdsTrackerConfig expTdsTrackerConfig, Map<String, String> map) {
        this.a.a(expTdsTrackerConfig, map);
    }

    public void a(a aVar) {
        this.b = aVar;
    }

    @Override // android.os.HandlerThread
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        this.a = new d(getLooper());
        a aVar = this.b;
        if (aVar != null) {
            aVar.a();
        }
    }
}
