package com.byazt.ot;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.Window;
import com.byazt.gct.pk;
import com.byazt.nf.rv;
import com.byazt.uq.x;
import com.byazt.vf.um;
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
@com.byazt.cp.n(n = {0, 1, 50, 19})
public class n implements Application.ActivityLifecycleCallbacks {
    public static boolean n = false;
    public static long qg;
    public static long s;
    public Handler cy;
    public volatile WeakReference<Activity> hd;
    public volatile WeakReference<Activity> k;
    public volatile Application.ActivityLifecycleCallbacks l;
    public volatile InterfaceC0287n q;
    public volatile qg w;
    public final AtomicBoolean x = new AtomicBoolean(false);
    public final AtomicBoolean fs = new AtomicBoolean(false);
    public final HashSet<Integer> rv = new HashSet<>();
    public volatile CopyOnWriteArrayList<WeakReference<com.byazt.twc.n>> tj = new CopyOnWriteArrayList<>();
    public volatile CopyOnWriteArrayList<qg> cp = new CopyOnWriteArrayList<>();
    public volatile CopyOnWriteArrayList<InterfaceC0287n> d = new CopyOnWriteArrayList<>();
    public final ArrayList<String> oa = new ArrayList<>();
    public SparseArray<Set<Runnable>> sz = new SparseArray<>();

    /* JADX INFO: renamed from: com.byazt.ot.n$n, reason: collision with other inner class name */
    public interface InterfaceC0287n {
        void n();

        void n(String str, Window window);

        void qg(String str, Window window);
    }

    public interface qg {
        void n();

        void q();

        void qg();

        void s();
    }

    @com.byazt.cp.n(n = {0, 1, 50, 829})
    public static abstract class s implements InterfaceC0287n {
        @Override // com.byazt.ot.n.InterfaceC0287n
        public void n() {
        }

        @Override // com.byazt.ot.n.InterfaceC0287n
        public void n(String str, Window window) {
        }

        @Override // com.byazt.ot.n.InterfaceC0287n
        public void qg(String str, Window window) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public WeakReference<Activity> n() {
        return this.k;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (this.l != null) {
            this.l.onActivityCreated(activity, bundle);
        }
        Iterator<InterfaceC0287n> it = this.d.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private Handler l() {
        if (this.cy == null) {
            if (rv.qg().em()) {
                this.cy = com.byazt.tk.rv.s();
            } else {
                this.cy = com.byazt.tk.rv.qg();
            }
        }
        return this.cy;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(final Activity activity) {
        final String name = activity.getClass().getName();
        final Window window = activity.getWindow();
        com.byazt.tk.rv.qg().post(new Runnable() { // from class: com.byazt.ot.n.1
            @Override // java.lang.Runnable
            public void run() {
                n.this.n(activity, name, window);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Activity activity, String str, Window window) {
        if (this.fs.get()) {
            s(true);
        }
        if (this.x.get()) {
            qg(true);
        }
        if (!this.oa.contains(activity.toString())) {
            this.oa.add(activity.toString());
            this.x.set(false);
            com.byazt.yq.n.n().n(true);
            com.byazt.qc.n.s();
            com.byazt.na.qg.l();
        }
        if (this.hd != null && this.hd.get() != null && this.hd.get() == activity) {
            fs();
            rv();
        }
        if (this.q != null) {
            this.q.n(str, window);
        }
        if (this.l != null) {
            this.l.onActivityStarted(activity);
        }
        for (InterfaceC0287n interfaceC0287n : this.d) {
            if (interfaceC0287n != null) {
                interfaceC0287n.n(str, window);
            }
        }
        com.byazt.okk.s.l(activity);
    }

    private void qg(boolean z) {
        try {
            if (z) {
                if (this.w != null) {
                    this.w.qg();
                }
                for (qg qgVar : this.cp) {
                    if (qgVar != null) {
                        qgVar.qg();
                    }
                }
                return;
            }
            if (this.w != null) {
                this.w.n();
            }
            for (qg qgVar2 : this.cp) {
                if (qgVar2 != null) {
                    qgVar2.n();
                }
            }
        } catch (Exception unused) {
        }
    }

    private void s(boolean z) {
        try {
            if (z) {
                if (this.w != null) {
                    this.w.s();
                }
                for (qg qgVar : this.cp) {
                    if (qgVar != null) {
                        qgVar.s();
                    }
                }
                return;
            }
            if (this.w != null) {
                this.w.q();
            }
            for (qg qgVar2 : this.cp) {
                if (qgVar2 != null) {
                    qgVar2.q();
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(final Activity activity) {
        l().post(new Runnable() { // from class: com.byazt.ot.n.3
            @Override // java.lang.Runnable
            public void run() {
                n.this.qg(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(final Activity activity) {
        if (activity != null && this.rv.add(Integer.valueOf(activity.hashCode()))) {
            this.fs.set(false);
        }
        if (this.q != null) {
            this.q.n();
        }
        if (this.l != null) {
            this.l.onActivityResumed(activity);
        }
        for (InterfaceC0287n interfaceC0287n : this.d) {
            if (interfaceC0287n != null) {
                interfaceC0287n.n();
            }
        }
        com.byazt.two.n.q();
        if (!n) {
            qg = System.currentTimeMillis();
            n = true;
        }
        this.k = new WeakReference<>(activity);
        if (activity != null) {
            com.byazt.yq.n.n().n(activity.getClass().getName());
        }
        if (!com.byazt.vyf.s.cy().lh()) {
            if (activity != null && activity.getComponentName() != null) {
                com.byazt.ot.qg.n().n(activity.getComponentName().getClassName());
            }
            if (activity != null && activity.getIntent() != null) {
                l.n().n(activity.getIntent());
            }
        }
        com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.ot.n.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    x.n(activity);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(final Activity activity) {
        l().post(new Runnable() { // from class: com.byazt.ot.n.5
            @Override // java.lang.Runnable
            public void run() {
                n.this.s(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(final Activity activity) {
        if (this.l != null) {
            this.l.onActivityPaused(activity);
        }
        Iterator<InterfaceC0287n> it = this.d.iterator();
        while (it.hasNext()) {
            it.next();
        }
        if (!com.byazt.vyf.s.cy().lh() && activity != null && activity.getComponentName() != null) {
            com.byazt.ot.qg.n().s(activity.getComponentName().getClassName());
        }
        com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.ot.n.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    x.qg(activity);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(final Activity activity) {
        final String name = activity.getClass().getName();
        final Window window = activity.getWindow();
        l().post(new Runnable() { // from class: com.byazt.ot.n.7
            @Override // java.lang.Runnable
            public void run() {
                n.this.qg(activity, name, window);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(Activity activity, String str, Window window) {
        if (this.oa.contains(activity.toString())) {
            this.oa.remove(activity.toString());
            if (this.oa.size() == 0) {
                this.x.set(true);
                com.byazt.yq.n.n().n(false);
                com.byazt.qc.n.qg();
                com.byazt.na.qg.q();
                qg(false);
            }
        }
        this.hd = new WeakReference<>(activity);
        if (this.q != null) {
            this.q.qg(str, window);
        }
        if (this.l != null) {
            this.l.onActivityStopped(activity);
        }
        for (InterfaceC0287n interfaceC0287n : this.d) {
            if (interfaceC0287n != null) {
                interfaceC0287n.qg(str, window);
            }
        }
        x();
        ((um) com.byazt.qp.q.n("kv_store_factory")).n();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(final Activity activity) {
        l().post(new Runnable() { // from class: com.byazt.ot.n.8
            @Override // java.lang.Runnable
            public void run() {
                n.this.q(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(final Activity activity) {
        if (activity != null) {
            this.rv.remove(Integer.valueOf(activity.hashCode()));
            if (this.rv.size() == 0) {
                this.fs.set(true);
                s(false);
            }
        }
        if (this.l != null) {
            this.l.onActivityDestroyed(activity);
        }
        Iterator<InterfaceC0287n> it = this.d.iterator();
        while (it.hasNext()) {
            it.next();
        }
        if (this.tj != null && this.tj.size() > 0) {
            for (WeakReference<com.byazt.twc.n> weakReference : this.tj) {
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().n(activity);
                }
            }
        }
        if (this.k != null && this.k.get() == activity) {
            this.k = null;
        }
        com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.ot.n.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    x.s(activity);
                } catch (Throwable unused) {
                }
            }
        });
        if (activity != null) {
            int iHashCode = activity.hashCode();
            synchronized (this.sz) {
                Set<Runnable> set = this.sz.get(iHashCode);
                if (set != null) {
                    for (Runnable runnable : set) {
                        if (runnable != null) {
                            runnable.run();
                        }
                    }
                    this.sz.remove(iHashCode);
                }
            }
        }
    }

    public boolean qg() {
        return w();
    }

    public boolean n(boolean z) {
        Activity activity;
        Window window;
        WeakReference<Activity> weakReference = this.k;
        return (weakReference == null || (activity = weakReference.get()) == null || (window = activity.getWindow()) == null) ? z : window.getDecorView().hasWindowFocus();
    }

    private boolean w() {
        Function<SparseArray<Object>, Object> functionB = com.byazt.vyf.s.cy().b();
        if (functionB != null) {
            try {
                Object objApply = functionB.apply(com.byazt.of.qg.n().n(2).n(Boolean.class).qg());
                return objApply != null && ((Boolean) objApply).booleanValue();
            } catch (Exception unused) {
            }
        }
        return this.x.get();
    }

    public boolean n(Activity activity) {
        return activity != null && this.rv.contains(Integer.valueOf(activity.hashCode()));
    }

    private void x() {
        if (!com.byazt.vyf.s.cy().lh() && qg()) {
            com.byazt.qit.l.s(new com.byazt.qit.x("reportSdkUseTime") { // from class: com.byazt.ot.n.10
                @Override // java.lang.Runnable
                public void run() {
                    n.n = false;
                    n.s = System.currentTimeMillis();
                    com.byazt.eji.s.n().n(n.qg / 1000, n.s / 1000, !com.byazt.vyf.l.qg.get() ? 1 : 0);
                    com.byazt.vyf.l.qg.set(false);
                }
            });
        }
    }

    private void fs() {
        pk pkVarN;
        com.byazt.gwu.l lVarS = com.byazt.ikv.n.s();
        long jQg = lVarS.qg("save_jump_success_time", 0L);
        if (jQg <= 0) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - jQg;
        String strQg = lVarS.qg("save_jump_success_ad_tag", "");
        String strQg2 = lVarS.qg("save_dpl_success_materialmeta", "");
        String strQg3 = lVarS.qg("save_download_open_app_success_meta", "");
        if (TextUtils.isEmpty(strQg) || TextUtils.isEmpty(strQg2)) {
            if (TextUtils.isEmpty(strQg3)) {
                return;
            }
            lVarS.n("save_download_open_app_success_meta");
            n(strQg3, jCurrentTimeMillis);
            return;
        }
        lVarS.n("save_dpl_success_materialmeta");
        try {
            pkVarN = com.byazt.vgx.qg.n(new JSONObject(strQg2));
        } catch (JSONException unused) {
            pkVarN = null;
        }
        if (pkVarN != null) {
            n(jCurrentTimeMillis, pkVarN);
            n(jCurrentTimeMillis, pkVarN, strQg);
        }
    }

    private void rv() {
        pk pkVarN;
        com.byazt.gwu.l lVarS = com.byazt.ikv.n.s();
        long jQg = lVarS.qg("save_jump_saas_success_time", 0L);
        if (jQg <= 0) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - jQg;
        String strQg = lVarS.qg("save_saas_success_materialmeta", "");
        if (TextUtils.isEmpty(strQg)) {
            return;
        }
        try {
            pkVarN = com.byazt.vgx.qg.n(new JSONObject(strQg));
        } catch (JSONException unused) {
            pkVarN = null;
        }
        n(jCurrentTimeMillis, pkVarN);
        lVarS.n("save_jump_saas_success_time", 0L);
        lVarS.n("save_saas_success_materialmeta");
    }

    private void n(String str, long j) {
        pk pkVarN;
        try {
            pkVarN = com.byazt.vgx.qg.n(new JSONObject(str));
        } catch (JSONException unused) {
            pkVarN = null;
        }
        if (pkVarN != null) {
            n(j, pkVarN);
        }
    }

    private void n(long j, pk pkVar) {
        if (pkVar != null && pkVar.hy() && pkVar.ii() >= 0) {
            boolean z = j >= ((long) pkVar.ii()) * 1000;
            com.byazt.mi.qg qgVar = (com.byazt.mi.qg) com.byazt.ikv.qg.n(pkVar.py(), com.byazt.mi.qg.class);
            if (qgVar != null) {
                qgVar.n(z ? 5 : 6, null);
            }
            if (z) {
                com.byazt.hm.n.n(pkVar, 4);
            }
        }
    }

    private void n(final long j, final pk pkVar, final String str) {
        if (com.byazt.vyf.s.cy().lh()) {
            return;
        }
        com.byazt.ag.qg.qg(new Runnable() { // from class: com.byazt.ot.n.2
            @Override // java.lang.Runnable
            public void run() {
                long j2 = j;
                if (j2 >= 86400000 || j2 <= 0) {
                    return;
                }
                com.byazt.hm.n.n(j2, str, pkVar);
            }
        });
    }

    public void n(InterfaceC0287n interfaceC0287n) {
        this.q = interfaceC0287n;
    }

    public void n(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.l = activityLifecycleCallbacks;
    }

    public void n(com.byazt.twc.n nVar) {
        this.tj.add(new WeakReference<>(nVar));
    }

    public boolean qg(com.byazt.twc.n nVar) {
        return this.tj.remove(new WeakReference(nVar));
    }

    public void n(qg qgVar) {
        if (this.cp.contains(qgVar)) {
            return;
        }
        this.cp.add(qgVar);
    }

    public void qg(InterfaceC0287n interfaceC0287n) {
        if (this.d.contains(interfaceC0287n)) {
            return;
        }
        this.d.add(interfaceC0287n);
    }

    public void qg(qg qgVar) {
        if (qgVar != null) {
            this.cp.remove(qgVar);
        }
    }

    public void s(qg qgVar) {
        this.w = qgVar;
    }

    public void s() {
        if (this.q != null) {
            this.q = null;
        }
    }

    public boolean n(Activity activity, Runnable runnable) {
        boolean zAdd;
        if (activity == null) {
            return false;
        }
        int iHashCode = activity.hashCode();
        synchronized (this.sz) {
            Set<Runnable> hashSet = this.sz.get(iHashCode);
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.sz.put(iHashCode, hashSet);
            }
            zAdd = hashSet.add(runnable);
        }
        return zAdd;
    }

    public void q() {
        com.byazt.ot.qg.n().qg();
    }
}
