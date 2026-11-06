package com.byazt.wt;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.Window;
import com.byazt.hg.of;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 37})
public class pr implements Application.ActivityLifecycleCallbacks {
    public volatile Application.ActivityLifecycleCallbacks c;
    public volatile WeakReference<Activity> ho;
    public Handler nt;
    public volatile hw uc;
    public volatile InterfaceC0225pr x;
    public volatile WeakReference<Activity> yb;
    public static boolean pr = false;
    public static long hw = 0;
    public static long hn = 0;
    public final AtomicBoolean fw = new AtomicBoolean(false);
    public final AtomicBoolean zo = new AtomicBoolean(false);
    public final HashSet<Integer> aj = new HashSet<>();
    public volatile CopyOnWriteArrayList<WeakReference<com.byazt.dj.pr>> vk = new CopyOnWriteArrayList<>();
    public volatile CopyOnWriteArrayList<hw> w = new CopyOnWriteArrayList<>();
    public volatile CopyOnWriteArrayList<InterfaceC0225pr> k = new CopyOnWriteArrayList<>();
    public final ArrayList<String> m = new ArrayList<>();
    public SparseArray<Set<Runnable>> g = new SparseArray<>();

    public interface hw {
        void hn();

        void hw();

        void pr();

        void x();
    }

    /* JADX INFO: renamed from: com.byazt.wt.pr$pr, reason: collision with other inner class name */
    public interface InterfaceC0225pr {
        void hw(String str, Window window);

        void pr();

        void pr(String str, Window window);
    }

    public WeakReference<Activity> pr() {
        return this.ho;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (this.c != null) {
            this.c.onActivityCreated(activity, bundle);
        }
        Iterator<InterfaceC0225pr> it = this.k.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private Handler c() {
        if (this.nt == null) {
            if (com.byazt.sd.a.hw().jb()) {
                this.nt = com.byazt.ca.aj.hn();
            } else {
                this.nt = com.byazt.ca.aj.hw();
            }
        }
        return this.nt;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(final Activity activity) {
        final String name = activity.getClass().getName();
        final Window window = activity.getWindow();
        com.byazt.ca.aj.hw().post(new Runnable() { // from class: com.byazt.wt.pr.1
            @Override // java.lang.Runnable
            public void run() {
                pr.this.pr(activity, name, window);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(Activity activity, String str, Window window) {
        if (this.zo.get()) {
            hn(true);
        }
        if (this.fw.get()) {
            hw(true);
        }
        if (!this.m.contains(activity.toString())) {
            this.m.add(activity.toString());
            this.fw.set(false);
            com.byazt.sf.pr.pr().pr(true);
            com.byazt.kk.pr.hn();
            com.byazt.z.hw.c();
        }
        if (this.yb != null && this.yb.get() != null && this.yb.get() == activity) {
            zo();
        }
        if (this.x != null) {
            this.x.pr(str, window);
        }
        if (this.c != null) {
            this.c.onActivityStarted(activity);
        }
        for (InterfaceC0225pr interfaceC0225pr : this.k) {
            if (interfaceC0225pr != null) {
                interfaceC0225pr.pr(str, window);
            }
        }
        er.c(activity);
    }

    private void hw(boolean z) {
        try {
            if (z) {
                if (this.uc != null) {
                    this.uc.hw();
                }
                for (hw hwVar : this.w) {
                    if (hwVar != null) {
                        hwVar.hw();
                    }
                }
                return;
            }
            if (this.uc != null) {
                this.uc.pr();
            }
            for (hw hwVar2 : this.w) {
                if (hwVar2 != null) {
                    hwVar2.pr();
                }
            }
        } catch (Exception e) {
        }
    }

    private void hn(boolean z) {
        try {
            if (z) {
                if (this.uc != null) {
                    this.uc.hn();
                }
                for (hw hwVar : this.w) {
                    if (hwVar != null) {
                        hwVar.hn();
                    }
                }
                return;
            }
            if (this.uc != null) {
                this.uc.x();
            }
            for (hw hwVar2 : this.w) {
                if (hwVar2 != null) {
                    hwVar2.x();
                }
            }
        } catch (Exception e) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(final Activity activity) {
        c().post(new Runnable() { // from class: com.byazt.wt.pr.3
            @Override // java.lang.Runnable
            public void run() {
                pr.this.hw(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(final Activity activity) {
        if (activity != null && this.aj.add(Integer.valueOf(activity.hashCode()))) {
            this.zo.set(false);
        }
        if (this.x != null) {
            this.x.pr();
        }
        if (this.c != null) {
            this.c.onActivityResumed(activity);
        }
        for (InterfaceC0225pr interfaceC0225pr : this.k) {
            if (interfaceC0225pr != null) {
                interfaceC0225pr.pr();
            }
        }
        com.byazt.ry.pr.pr(com.byazt.sd.a.getContext(), Integer.parseInt("1371"));
        if (!pr) {
            hw = System.currentTimeMillis();
            pr = true;
        }
        this.ho = new WeakReference<>(activity);
        if (activity != null) {
            com.byazt.sf.pr.pr().pr(activity.getClass().getName());
        }
        if (!com.byazt.sd.zo.nt().y()) {
            if (activity != null && activity.getComponentName() != null) {
                com.byazt.wt.hw.pr().pr(activity.getComponentName().getClassName());
            }
            if (activity != null && activity.getIntent() != null) {
                m.pr().pr(activity.getIntent());
            }
        }
        com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.wt.pr.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.byazt.ua.fw.pr(activity);
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(final Activity activity) {
        c().post(new Runnable() { // from class: com.byazt.wt.pr.5
            @Override // java.lang.Runnable
            public void run() {
                pr.this.hn(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hn(final Activity activity) {
        if (this.c != null) {
            this.c.onActivityPaused(activity);
        }
        Iterator<InterfaceC0225pr> it = this.k.iterator();
        while (it.hasNext()) {
            it.next();
        }
        if (!com.byazt.sd.zo.nt().y() && activity != null && activity.getComponentName() != null) {
            com.byazt.wt.hw.pr().hn(activity.getComponentName().getClassName());
        }
        com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.wt.pr.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.byazt.ua.fw.hw(activity);
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(final Activity activity) {
        final String name = activity.getClass().getName();
        final Window window = activity.getWindow();
        c().post(new Runnable() { // from class: com.byazt.wt.pr.7
            @Override // java.lang.Runnable
            public void run() {
                pr.this.hw(activity, name, window);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(Activity activity, String str, Window window) {
        if (this.m.contains(activity.toString())) {
            this.m.remove(activity.toString());
            if (this.m.size() == 0) {
                this.fw.set(true);
                com.byazt.sf.pr.pr().pr(false);
                com.byazt.kk.pr.hw();
                com.byazt.z.hw.x();
                hw(false);
            }
        }
        this.yb = new WeakReference<>(activity);
        if (this.x != null) {
            this.x.hw(str, window);
        }
        if (this.c != null) {
            this.c.onActivityStopped(activity);
        }
        for (InterfaceC0225pr interfaceC0225pr : this.k) {
            if (interfaceC0225pr != null) {
                interfaceC0225pr.hw(str, window);
            }
        }
        fw();
        ((com.byazt.vkw.lb) com.byazt.zs.uc.pr("kv_store_factory")).pr();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(final Activity activity) {
        c().post(new Runnable() { // from class: com.byazt.wt.pr.8
            @Override // java.lang.Runnable
            public void run() {
                pr.this.x(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(final Activity activity) {
        if (activity != null) {
            this.aj.remove(Integer.valueOf(activity.hashCode()));
            if (this.aj.size() == 0) {
                this.zo.set(true);
                hn(false);
            }
        }
        if (this.c != null) {
            this.c.onActivityDestroyed(activity);
        }
        Iterator<InterfaceC0225pr> it = this.k.iterator();
        while (it.hasNext()) {
            it.next();
        }
        if (this.vk != null && this.vk.size() > 0) {
            for (WeakReference<com.byazt.dj.pr> weakReference : this.vk) {
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().pr(activity);
                }
            }
        }
        if (this.ho != null && this.ho.get() == activity) {
            this.ho = null;
        }
        com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.wt.pr.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.byazt.ua.fw.hn(activity);
                } catch (Throwable th) {
                }
            }
        });
        if (activity != null) {
            int iHashCode = activity.hashCode();
            synchronized (this.g) {
                Set<Runnable> set = this.g.get(iHashCode);
                if (set != null) {
                    for (Runnable runnable : set) {
                        if (runnable != null) {
                            runnable.run();
                        }
                    }
                    this.g.remove(iHashCode);
                }
            }
        }
    }

    public boolean hw() {
        return uc();
    }

    public boolean pr(boolean z) {
        Activity activity;
        Window window;
        WeakReference<Activity> weakReference = this.ho;
        if (weakReference == null || (activity = weakReference.get()) == null || (window = activity.getWindow()) == null) {
            return z;
        }
        return window.getDecorView().hasWindowFocus();
    }

    private boolean uc() {
        Function<SparseArray<Object>, Object> functionIe = com.byazt.sd.zo.nt().ie();
        if (functionIe != null) {
            try {
                Object objApply = functionIe.apply(com.byazt.xi.hw.pr().pr(2).pr(Boolean.class).hw());
                return objApply != null && ((Boolean) objApply).booleanValue();
            } catch (Exception e) {
            }
        }
        return this.fw.get();
    }

    public boolean pr(Activity activity) {
        if (activity == null || !this.aj.contains(Integer.valueOf(activity.hashCode()))) {
            return false;
        }
        return true;
    }

    private void fw() {
        if (!com.byazt.sd.zo.nt().y() && hw()) {
            com.byazt.xlm.c.hn(new com.byazt.xlm.fw("reportSdkUseTime") { // from class: com.byazt.wt.pr.10
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    pr.pr = false;
                    pr.hn = System.currentTimeMillis();
                    if (com.byazt.sd.lb.hw.get()) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                    com.byazt.xk.hw.pr().pr(pr.hw / 1000, pr.hn / 1000, i);
                    com.byazt.sd.lb.hw.set(false);
                }
            });
        }
    }

    private void zo() {
        com.byazt.zq.c cVarHn = com.byazt.sd.hw.hn();
        long jHw = cVarHn.hw("save_jump_success_time", 0L);
        if (jHw <= 0) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - jHw;
        String strHw = cVarHn.hw("save_jump_success_ad_tag", "");
        String strHw2 = cVarHn.hw("save_dpl_success_materialmeta", "");
        String strHw3 = cVarHn.hw("save_download_open_app_success_meta", "");
        if (TextUtils.isEmpty(strHw) || TextUtils.isEmpty(strHw2)) {
            if (!TextUtils.isEmpty(strHw3)) {
                cVarHn.pr("save_download_open_app_success_meta");
                pr(strHw3, jCurrentTimeMillis);
                return;
            }
            return;
        }
        cVarHn.pr("save_dpl_success_materialmeta");
        of ofVarPr = null;
        try {
            ofVarPr = com.byazt.sd.pr.pr(new JSONObject(strHw2));
        } catch (JSONException e) {
        }
        if (ofVarPr != null) {
            pr(jCurrentTimeMillis, ofVarPr);
            pr(jCurrentTimeMillis, ofVarPr, strHw);
        }
    }

    private void pr(String str, long j) {
        of ofVarPr;
        try {
            ofVarPr = com.byazt.sd.pr.pr(new JSONObject(str));
        } catch (JSONException e) {
            ofVarPr = null;
        }
        if (ofVarPr != null) {
            pr(j, ofVarPr);
        }
    }

    private void pr(long j, of ofVar) {
        if (ofVar.ob() && ofVar.tn() >= 0) {
            boolean z = j >= ((long) ofVar.tn()) * 1000;
            com.byazt.rkl.hw hwVar = (com.byazt.rkl.hw) com.byazt.sd.cz.pr(ofVar.cz(), com.byazt.rkl.hw.class);
            if (hwVar != null) {
                hwVar.pr(z ? 5 : 6, null);
            }
            if (z) {
                com.byazt.pj.pr.pr(ofVar, 4);
            }
        }
    }

    private void pr(final long j, final of ofVar, final String str) {
        if (com.byazt.sd.zo.nt().y()) {
            return;
        }
        com.byazt.zp.zo.hw(new Runnable() { // from class: com.byazt.wt.pr.2
            @Override // java.lang.Runnable
            public void run() {
                long j2 = j;
                if (j2 >= 86400000 || j2 <= 0) {
                    return;
                }
                com.byazt.pj.pr.pr(j2, str, ofVar);
            }
        });
    }

    public void pr(InterfaceC0225pr interfaceC0225pr) {
        this.x = interfaceC0225pr;
    }

    public void pr(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.c = activityLifecycleCallbacks;
    }

    public void pr(com.byazt.dj.pr prVar) {
        this.vk.add(new WeakReference<>(prVar));
    }

    public boolean hw(com.byazt.dj.pr prVar) {
        return this.vk.remove(new WeakReference(prVar));
    }

    public void pr(hw hwVar) {
        if (!this.w.contains(hwVar)) {
            this.w.add(hwVar);
        }
    }

    public void hw(InterfaceC0225pr interfaceC0225pr) {
        if (!this.k.contains(interfaceC0225pr)) {
            this.k.add(interfaceC0225pr);
        }
    }

    public void hw(hw hwVar) {
        if (hwVar != null) {
            this.w.remove(hwVar);
        }
    }

    public void hn(hw hwVar) {
        this.uc = hwVar;
    }

    public void hn() {
        if (this.x != null) {
            this.x = null;
        }
    }

    public boolean pr(Activity activity, Runnable runnable) {
        boolean zAdd;
        if (activity == null) {
            return false;
        }
        int iHashCode = activity.hashCode();
        synchronized (this.g) {
            Set<Runnable> hashSet = this.g.get(iHashCode);
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.g.put(iHashCode, hashSet);
            }
            zAdd = hashSet.add(runnable);
        }
        return zAdd;
    }

    public void x() {
        com.byazt.wt.hw.pr().hw();
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, MediaPlayer.MEDIA_PLAYER_OPTION_ADVANCE_CHECK_BUFFERING_END})
    public static abstract class hn implements InterfaceC0225pr {
        @Override // com.byazt.wt.pr.InterfaceC0225pr
        public void pr(String str, Window window) {
        }

        @Override // com.byazt.wt.pr.InterfaceC0225pr
        public void pr() {
        }

        @Override // com.byazt.wt.pr.InterfaceC0225pr
        public void hw(String str, Window window) {
        }
    }
}
