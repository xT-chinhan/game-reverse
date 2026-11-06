package com.byazt.pj;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 115, 62})
public class fw {

    public interface pr {
        void pr(long j);

        void pr(String str);

        void pr(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr() {
        com.byazt.wt.pr prVarHn = com.byazt.sd.zo.nt().hn();
        if (prVarHn == null) {
            return;
        }
        prVarHn.pr((Application.ActivityLifecycleCallbacks) null);
    }

    public void pr(final pr prVar) {
        com.byazt.wt.pr prVarHn;
        if (prVar == null || (prVarHn = com.byazt.sd.zo.nt().hn()) == null) {
            return;
        }
        prVarHn.pr(new Application.ActivityLifecycleCallbacks() { // from class: com.byazt.pj.fw.1
            public WeakReference<Object> hn;
            public long x;

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                fw.this.pr();
                prVar.pr("create");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                fw.this.pr();
                prVar.pr(TrackAction.START);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                fw.this.pr();
                prVar.pr(System.currentTimeMillis() - this.x);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                this.hn = new WeakReference<>(activity);
                this.x = System.currentTimeMillis();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                fw.this.pr();
                prVar.pr(pr(activity));
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                fw.this.pr();
                prVar.pr("destroy");
            }

            private boolean pr(Activity activity) {
                WeakReference<Object> weakReference;
                return (activity == null || (weakReference = this.hn) == null || activity != weakReference.get()) ? false : true;
            }
        });
    }
}
