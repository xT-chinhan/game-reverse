package com.byazt.p000do;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.byazt.ry.fs;
import com.byazt.ry.l;
import com.byazt.vx.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1635, 19})
public class n extends l.n {
    public static volatile n qg;
    public final HashMap<ComponentName, IBinder> s = new HashMap<>();
    public final HashMap<ComponentName, qg> q = new HashMap<>();
    public final C0155n<Intent> l = new C0155n<>();
    public final HashMap<ComponentName, com.byazt.qr.n> w = new HashMap<>();
    public final HashSet<ComponentName> x = new HashSet<>();
    public final HashSet<ComponentName> fs = new HashSet<>();
    public final List<Runnable> rv = new ArrayList();
    public final Handler n = new Handler(Looper.getMainLooper());

    @Override // com.byazt.ry.l.n, android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    @com.byazt.cp.n(n = {0, 1, 1635, 226})
    class qg extends HashSet<fs> {
        public qg() {
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (super.contains(obj)) {
                return true;
            }
            if (!(obj instanceof fs)) {
                return false;
            }
            Iterator<fs> it = iterator();
            while (it.hasNext()) {
                try {
                    if (it.next().n() == ((fs) obj).n()) {
                        return true;
                    }
                } catch (RemoteException e) {
                    w.n(e);
                }
            }
            return false;
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            fs fsVar;
            if (super.remove(obj)) {
                return true;
            }
            Iterator it = iterator();
            while (it.hasNext()) {
                fsVar = (fs) it.next();
                try {
                    if (fsVar.n() == ((fs) obj).n()) {
                        return super.remove(fsVar);
                    }
                } catch (RemoteException e) {
                    w.n(e);
                }
            }
            fsVar = null;
            return super.remove(fsVar);
        }
    }

    /* JADX INFO: renamed from: com.byazt.do.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 1635, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    class C0155n<T> extends HashMap<fs, T> {
        public C0155n() {
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            if (super.containsKey(obj)) {
                return true;
            }
            if (!(obj instanceof fs)) {
                return false;
            }
            Iterator<fs> it = keySet().iterator();
            while (it.hasNext()) {
                try {
                    if (it.next().n() == ((fs) obj).n()) {
                        return true;
                    }
                } catch (RemoteException e) {
                    w.n(e);
                }
            }
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public T remove(Object obj) {
            fs next;
            T t = (T) super.remove(obj);
            if (t != null) {
                return t;
            }
            Iterator<fs> it = keySet().iterator();
            while (it.hasNext()) {
                next = it.next();
                try {
                    if (next.n() == ((fs) obj).n()) {
                        return (T) super.remove(next);
                    }
                } catch (RemoteException e) {
                    w.n(e);
                }
            }
            next = null;
            return (T) super.remove(next);
        }
    }

    public static n qg() {
        if (qg == null) {
            synchronized (n.class) {
                if (qg == null) {
                    qg = new n();
                }
            }
        }
        return qg;
    }

    private n() {
    }

    public void s() {
        for (Runnable runnable : this.rv) {
            if (runnable != null) {
                this.n.post(runnable);
            }
        }
        this.rv.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ComponentName n(final Intent intent, final String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return qg(intent, str);
        }
        this.n.post(new Runnable() { // from class: com.byazt.do.n.1
            @Override // java.lang.Runnable
            public void run() {
                n.this.qg(intent, str);
            }
        });
        return intent.getComponent();
    }

    @Override // com.byazt.ry.l
    public ComponentName startService(final Intent intent, final String str) {
        if (Zeus.hasInit()) {
            Plugin plugin = Zeus.getPlugin(str);
            if (plugin.isLoaded()) {
                return n(intent, str);
            }
            plugin.addStartServicePluginPendingTask(new Plugin.n() { // from class: com.byazt.do.n.2
                @Override // com.bytedance.pangle.plugin.Plugin.n
                public void n(int i) throws RemoteException {
                    n.this.n(intent, str);
                }
            });
        } else {
            this.rv.add(new Runnable() { // from class: com.byazt.do.n.3
                @Override // java.lang.Runnable
                public void run() {
                    n.this.qg(intent, str);
                }
            });
        }
        return intent.getComponent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ComponentName qg(Intent intent, String str) {
        ComponentName component = intent.getComponent();
        if (!this.w.containsKey(component)) {
            com.byazt.qr.n nVarS = s(intent, str);
            if (nVarS == null) {
                return component;
            }
            this.w.put(component, nVarS);
            this.x.add(component);
        }
        com.byazt.qr.n nVar = this.w.get(component);
        if (nVar != null) {
            nVar.onStartCommand(intent, 0, 0);
        }
        return component;
    }

    private com.byazt.qr.n s(Intent intent, String str) {
        com.byazt.qr.n nVarQ = q(intent, str);
        if (nVarQ != null) {
            nVarQ.onCreate();
        }
        return nVarQ;
    }

    private com.byazt.qr.n q(Intent intent, String str) {
        boolean zLoadPlugin;
        ComponentName component = intent.getComponent();
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        try {
            zLoadPlugin = Zeus.loadPlugin(str);
            try {
                com.byazt.qr.n nVar = (com.byazt.qr.n) plugin.mClassLoader.loadClass(component.getClassName()).newInstance();
                nVar.attach(plugin);
                return nVar;
            } catch (Exception e) {
                e = e;
                ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "newServiceInstance failed! loadPlugin = ".concat(String.valueOf(zLoadPlugin)), e);
                return null;
            }
        } catch (Exception e2) {
            e = e2;
            zLoadPlugin = false;
        }
    }

    @Override // com.byazt.ry.l
    public boolean stopService(final Intent intent, String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            qg().n(intent.getComponent());
            return true;
        }
        this.n.post(new Runnable() { // from class: com.byazt.do.n.4
            @Override // java.lang.Runnable
            public void run() {
                n.qg().n(intent.getComponent());
            }
        });
        return true;
    }

    public synchronized boolean n(ComponentName componentName) {
        if (!this.w.containsKey(componentName)) {
            return false;
        }
        this.fs.add(componentName);
        return qg(componentName);
    }

    private boolean qg(ComponentName componentName) {
        if (!this.x.contains(componentName)) {
            if (this.q.get(componentName) != null) {
                return false;
            }
            s(componentName);
            return true;
        }
        if (!this.fs.contains(componentName) || this.q.containsKey(componentName)) {
            return false;
        }
        s(componentName);
        return true;
    }

    private void s(ComponentName componentName) {
        com.byazt.qr.n nVarRemove = this.w.remove(componentName);
        this.fs.remove(componentName);
        this.s.remove(componentName);
        this.x.remove(componentName);
        if (nVarRemove != null) {
            nVarRemove.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n(final Intent intent, final fs fsVar, final int i, final String str) throws RemoteException {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return qg(intent, fsVar, i, str);
        }
        this.n.post(new Runnable() { // from class: com.byazt.do.n.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    n.this.qg(intent, fsVar, i, str);
                } catch (RemoteException e) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "bindService failed", e);
                }
            }
        });
        return true;
    }

    @Override // com.byazt.ry.l
    public boolean bindService(final Intent intent, final fs fsVar, final int i, final String str) throws RemoteException {
        if (Zeus.hasInit()) {
            Plugin plugin = Zeus.getPlugin(str);
            if (plugin.isLoaded()) {
                return n(intent, fsVar, i, str);
            }
            if (Zeus.loadPlugin(str)) {
                n(intent, fsVar, i, str);
                return true;
            }
            plugin.addBindServicePluginPendingTask(new Plugin.n() { // from class: com.byazt.do.n.6
                @Override // com.bytedance.pangle.plugin.Plugin.n
                public void n(int i2) throws RemoteException {
                    n.this.n(intent, fsVar, i, str);
                }
            });
            return true;
        }
        this.rv.add(new Runnable() { // from class: com.byazt.do.n.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    n.this.qg(intent, fsVar, i, str);
                } catch (RemoteException e) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "pending bindService failed", e);
                }
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean qg(Intent intent, fs fsVar, int i, String str) throws RemoteException {
        ComponentName component = intent.getComponent();
        if (!this.w.containsKey(component)) {
            com.byazt.qr.n nVarS = s(intent, str);
            if (nVarS == null) {
                return false;
            }
            this.w.put(component, nVarS);
        }
        com.byazt.qr.n nVar = this.w.get(component);
        if (!this.s.containsKey(component)) {
            this.s.put(component, nVar.onBind(intent));
        }
        IBinder iBinder = this.s.get(component);
        if (iBinder != null) {
            if (this.q.containsKey(component)) {
                if (!this.q.get(component).contains(fsVar)) {
                    this.q.get(component).add(fsVar);
                    this.l.put(fsVar, intent);
                    fsVar.n(component, iBinder);
                }
            } else {
                qg qgVar = new qg();
                qgVar.add(fsVar);
                this.q.put(component, qgVar);
                this.l.put(fsVar, intent);
                fsVar.n(component, iBinder);
            }
        }
        return true;
    }

    @Override // com.byazt.ry.l
    public void unbindService(final fs fsVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            n(fsVar);
        } else {
            this.n.post(new Runnable() { // from class: com.byazt.do.n.8
                @Override // java.lang.Runnable
                public void run() {
                    n.this.n(fsVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void n(fs fsVar) {
        for (ComponentName componentName : this.q.keySet()) {
            qg qgVar = this.q.get(componentName);
            if (qgVar.contains(fsVar)) {
                qgVar.remove(fsVar);
                Intent intentRemove = this.l.remove(fsVar);
                if (qgVar.size() == 0) {
                    this.q.remove(componentName);
                    com.byazt.qr.n nVar = this.w.get(componentName);
                    if (nVar != null) {
                        nVar.onUnbind(intentRemove);
                    }
                }
                qg(componentName);
                return;
            }
        }
    }
}
