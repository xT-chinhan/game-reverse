package com.byazt.bw;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE, 37})
public class pr implements Application.ActivityLifecycleCallbacks {
    public static volatile boolean pr = false;
    public volatile WeakReference<Activity> hn;
    public int hw = 0;
    public InterfaceC0028pr x;

    /* JADX INFO: renamed from: com.byazt.bw.pr$pr, reason: collision with other inner class name */
    public interface InterfaceC0028pr {
        void hw();

        void pr();
    }

    public Boolean pr() {
        return Boolean.valueOf(pr);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.hw++;
        pr = false;
        InterfaceC0028pr interfaceC0028pr = this.x;
        if (interfaceC0028pr != null) {
            interfaceC0028pr.hw();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.hn = new WeakReference<>(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int i = this.hw - 1;
        this.hw = i;
        if (i == 0) {
            pr = true;
            InterfaceC0028pr interfaceC0028pr = this.x;
            if (interfaceC0028pr != null) {
                interfaceC0028pr.pr();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    public void pr(InterfaceC0028pr interfaceC0028pr) {
        this.x = interfaceC0028pr;
    }

    public Activity hw() {
        if (this.hn == null) {
            return null;
        }
        return this.hn.get();
    }
}
