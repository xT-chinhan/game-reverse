package com.byazt.wel;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.byazt.ol.TTDownloadField;
import com.byazt.tuy.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1813, 37})
public class pr {
    public WeakReference<Activity> c;
    public volatile boolean fw;
    public final List<InterfaceC0223pr> hn;
    public hn hw;
    public Application pr;
    public volatile int uc;
    public int x;
    public final Application.ActivityLifecycleCallbacks zo;

    public interface hn {
    }

    /* JADX INFO: renamed from: com.byazt.wel.pr$pr, reason: collision with other inner class name */
    public interface InterfaceC0223pr {
        void hn();

        void hw();
    }

    public static pr pr() {
        return hw.pr;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 1813, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE})
    private static class hw {
        public static final pr pr = new pr();
    }

    private pr() {
        this.hn = new ArrayList();
        this.uc = -1;
        this.fw = false;
        this.zo = new Application.ActivityLifecycleCallbacks() { // from class: com.byazt.wel.pr.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                pr.this.c = new WeakReference(activity);
                int i = pr.this.x;
                pr.this.x = activity != null ? activity.hashCode() : i;
                pr.this.fw = false;
                if (i == 0) {
                    pr.this.c();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                int i = pr.this.x;
                pr.this.fw = false;
                pr.this.x = activity != null ? activity.hashCode() : i;
                if (i == 0) {
                    pr.this.c();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                pr.this.fw = true;
                if (pr.this.x == 0 && activity != null) {
                    pr.this.x = activity.hashCode();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                if (activity != null && activity.hashCode() == pr.this.x) {
                    pr.this.x = 0;
                    pr.this.uc();
                }
                pr.this.fw = false;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }
        };
    }

    public void pr(Context context) {
        if (this.pr == null && (context instanceof Application)) {
            synchronized (this) {
                if (this.pr == null) {
                    Application application = (Application) context;
                    this.pr = application;
                    application.registerActivityLifecycleCallbacks(this.zo);
                }
            }
        }
    }

    public void pr(hn hnVar) {
        this.hw = hnVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public boolean hw() {
        int i = this.uc;
        ?? r0 = i;
        if (i == -1) {
            ?? Fw = fw();
            this.uc = Fw;
            r0 = Fw;
        }
        return r0 == 1;
    }

    public boolean hn() {
        return hw() && !this.fw;
    }

    public void pr(InterfaceC0223pr interfaceC0223pr) {
        if (interfaceC0223pr == null) {
            return;
        }
        synchronized (this.hn) {
            if (!this.hn.contains(interfaceC0223pr)) {
                this.hn.add(interfaceC0223pr);
            }
        }
    }

    public void hw(InterfaceC0223pr interfaceC0223pr) {
        synchronized (this.hn) {
            this.hn.remove(interfaceC0223pr);
        }
    }

    private Object[] x() {
        Object[] array;
        synchronized (this.hn) {
            if (this.hn.size() <= 0) {
                array = null;
            } else {
                array = this.hn.toArray();
            }
        }
        return array;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.uc = 1;
        Object[] objArrX = x();
        if (objArrX != null) {
            for (Object obj : objArrX) {
                ((InterfaceC0223pr) obj).hw();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uc() {
        this.uc = 0;
        Object[] objArrX = x();
        if (objArrX != null) {
            for (Object obj : objArrX) {
                ((InterfaceC0223pr) obj).hn();
            }
        }
    }

    private boolean fw() {
        try {
            Application application = this.pr;
            if (application == null) {
                return false;
            }
            application.getSystemService(TTDownloadField.TT_ACTIVITY);
            return TextUtils.equals(application.getPackageName(), uc.x(application));
        } catch (Throwable th) {
            return false;
        }
    }
}
