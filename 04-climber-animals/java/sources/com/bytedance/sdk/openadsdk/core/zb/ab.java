package com.bytedance.sdk.openadsdk.core.zb;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.sdk.openadsdk.core.ch;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class ab {

    public interface ms {
        void ms();

        void ms(String str);

        void ms(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms() {
        com.bytedance.sdk.openadsdk.core.jw.ms msVarD = ch.ub().d();
        if (msVarD == null) {
            return;
        }
        msVarD.ms((Application.ActivityLifecycleCallbacks) null);
    }

    public void ms(final ms msVar) {
        com.bytedance.sdk.openadsdk.core.jw.ms msVarD;
        if (msVar == null || (msVarD = ch.ub().d()) == null) {
            return;
        }
        msVarD.ms(new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.sdk.openadsdk.core.zb.ab.1
            private WeakReference<Object> ah;

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                ab.this.ms();
                msVar.ms("create");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                ab.this.ms();
                msVar.ms("start");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                ab.this.ms();
                msVar.ms();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                this.ah = new WeakReference<>(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                ab.this.ms();
                msVar.ms(ms(activity));
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                ab.this.ms();
                msVar.ms("destroy");
            }

            private boolean ms(Activity activity) {
                WeakReference<Object> weakReference;
                return (activity == null || (weakReference = this.ah) == null || activity != weakReference.get()) ? false : true;
            }
        });
    }
}
