package com.byazt.ja;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SUB, 19})
public class n implements Application.ActivityLifecycleCallbacks {
    public static volatile boolean n = false;
    public InterfaceC0206n q;
    public int qg = 0;
    public volatile WeakReference<Activity> s;

    /* JADX INFO: renamed from: com.byazt.ja.n$n, reason: collision with other inner class name */
    public interface InterfaceC0206n {
        void n();

        void qg();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public Boolean n() {
        return Boolean.valueOf(n);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.qg++;
        n = false;
        InterfaceC0206n interfaceC0206n = this.q;
        if (interfaceC0206n != null) {
            interfaceC0206n.qg();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.s = new WeakReference<>(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int i = this.qg - 1;
        this.qg = i;
        if (i == 0) {
            n = true;
            InterfaceC0206n interfaceC0206n = this.q;
            if (interfaceC0206n != null) {
                interfaceC0206n.n();
            }
        }
    }

    public void n(InterfaceC0206n interfaceC0206n) {
        this.q = interfaceC0206n;
    }

    public Activity qg() {
        if (this.s == null) {
            return null;
        }
        return this.s.get();
    }
}
