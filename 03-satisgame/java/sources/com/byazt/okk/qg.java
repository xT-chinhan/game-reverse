package com.byazt.okk;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 52, 26})
public class qg {

    public interface n {
        void n(long j);

        void n(String str);

        void n(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        com.byazt.ot.n nVarS = com.byazt.vyf.s.cy().s();
        if (nVarS == null) {
            return;
        }
        nVarS.n((Application.ActivityLifecycleCallbacks) null);
    }

    public void n(final n nVar) {
        com.byazt.ot.n nVarS;
        if (nVar == null || (nVarS = com.byazt.vyf.s.cy().s()) == null) {
            return;
        }
        nVarS.n(new Application.ActivityLifecycleCallbacks() { // from class: com.byazt.okk.qg.1
            public long q;
            public WeakReference<Object> s;

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                qg.this.n();
                nVar.n("create");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                qg.this.n();
                nVar.n("start");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                qg.this.n();
                nVar.n(System.currentTimeMillis() - this.q);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                this.s = new WeakReference<>(activity);
                this.q = System.currentTimeMillis();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                qg.this.n();
                nVar.n(n(activity));
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                qg.this.n();
                nVar.n("destroy");
            }

            private boolean n(Activity activity) {
                WeakReference<Object> weakReference;
                return (activity == null || (weakReference = this.s) == null || activity != weakReference.get()) ? false : true;
            }
        });
    }
}
