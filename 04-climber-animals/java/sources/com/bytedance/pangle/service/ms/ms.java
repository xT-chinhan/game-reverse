package com.bytedance.pangle.service.ms;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ka;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.x;
import com.bytedance.sdk.openadsdk.api.ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends ka.ms {
    private static volatile ms xr;
    private final HashMap<ComponentName, IBinder> ah = new HashMap<>();
    private final HashMap<ComponentName, xr> d = new HashMap<>();
    private final C0226ms<Intent> ka = new C0226ms<>();
    private final HashMap<ComponentName, com.bytedance.pangle.service.ms> c = new HashMap<>();
    private final HashSet<ComponentName> ab = new HashSet<>();
    private final HashSet<ComponentName> x = new HashSet<>();
    private final List<Runnable> ny = new ArrayList();

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Handler f688ms = new Handler(Looper.getMainLooper());

    @Override // com.bytedance.pangle.ka.ms, android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    class xr extends HashSet<x> {
        xr() {
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (super.contains(obj)) {
                return true;
            }
            if (!(obj instanceof x)) {
                return false;
            }
            Iterator<x> it = iterator();
            while (it.hasNext()) {
                try {
                    if (it.next().ms() == ((x) obj).ms()) {
                        return true;
                    }
                } catch (RemoteException e) {
                    ab.ms(e);
                }
            }
            return false;
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            x xVar;
            if (super.remove(obj)) {
                return true;
            }
            Iterator it = iterator();
            while (it.hasNext()) {
                xVar = (x) it.next();
                try {
                    if (xVar.ms() == ((x) obj).ms()) {
                        return super.remove(xVar);
                    }
                } catch (RemoteException e) {
                    ab.ms(e);
                }
            }
            xVar = null;
            return super.remove(xVar);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.pangle.service.ms.ms$ms, reason: collision with other inner class name */
    class C0226ms<T> extends HashMap<x, T> {
        C0226ms() {
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            if (super.containsKey(obj)) {
                return true;
            }
            if (!(obj instanceof x)) {
                return false;
            }
            Iterator<x> it = keySet().iterator();
            while (it.hasNext()) {
                try {
                    if (it.next().ms() == ((x) obj).ms()) {
                        return true;
                    }
                } catch (RemoteException e) {
                    ab.ms(e);
                }
            }
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public T remove(Object obj) {
            x next;
            T t = (T) super.remove(obj);
            if (t != null) {
                return t;
            }
            Iterator<x> it = keySet().iterator();
            while (it.hasNext()) {
                next = it.next();
                try {
                    if (next.ms() == ((x) obj).ms()) {
                        return (T) super.remove(next);
                    }
                } catch (RemoteException e) {
                    ab.ms(e);
                }
            }
            next = null;
            return (T) super.remove(next);
        }
    }

    public static ms xr() {
        if (xr == null) {
            synchronized (ms.class) {
                if (xr == null) {
                    xr = new ms();
                }
            }
        }
        return xr;
    }

    private ms() {
    }

    public void ah() {
        for (Runnable runnable : this.ny) {
            if (runnable != null) {
                this.f688ms.post(runnable);
            }
        }
        this.ny.clear();
    }

    @Override // com.bytedance.pangle.ka
    public ComponentName startService(final Intent intent, final String str) {
        if (Zeus.hasInit()) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return ms(intent, str);
            }
            this.f688ms.post(new Runnable() { // from class: com.bytedance.pangle.service.ms.ms.1
                @Override // java.lang.Runnable
                public void run() {
                    ms.this.ms(intent, str);
                }
            });
        } else {
            this.ny.add(new Runnable() { // from class: com.bytedance.pangle.service.ms.ms.2
                @Override // java.lang.Runnable
                public void run() {
                    ms.this.ms(intent, str);
                }
            });
        }
        return intent.getComponent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ComponentName ms(Intent intent, String str) {
        ComponentName component = intent.getComponent();
        if (!this.c.containsKey(component)) {
            com.bytedance.pangle.service.ms msVarXr = xr(intent, str);
            if (msVarXr == null) {
                return component;
            }
            this.c.put(component, msVarXr);
            this.ab.add(component);
        }
        com.bytedance.pangle.service.ms msVar = this.c.get(component);
        if (msVar != null) {
            msVar.onStartCommand(intent, 0, 0);
        }
        return component;
    }

    private com.bytedance.pangle.service.ms xr(Intent intent, String str) {
        com.bytedance.pangle.service.ms msVarAh = ah(intent, str);
        if (msVarAh != null) {
            msVarAh.onCreate();
        }
        return msVarAh;
    }

    private com.bytedance.pangle.service.ms ah(Intent intent, String str) {
        boolean zLoadPlugin;
        ComponentName component = intent.getComponent();
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        try {
            zLoadPlugin = Zeus.loadPlugin(str);
            try {
                com.bytedance.pangle.service.ms msVar = (com.bytedance.pangle.service.ms) plugin.mClassLoader.loadClass(component.getClassName()).newInstance();
                msVar.attach(plugin);
                return msVar;
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

    @Override // com.bytedance.pangle.ka
    public boolean stopService(final Intent intent, String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            xr().ms(intent.getComponent());
            return true;
        }
        this.f688ms.post(new Runnable() { // from class: com.bytedance.pangle.service.ms.ms.3
            @Override // java.lang.Runnable
            public void run() {
                ms.xr().ms(intent.getComponent());
            }
        });
        return true;
    }

    public synchronized boolean ms(ComponentName componentName) {
        if (!this.c.containsKey(componentName)) {
            return false;
        }
        this.x.add(componentName);
        return xr(componentName);
    }

    private boolean xr(ComponentName componentName) {
        if (!this.ab.contains(componentName)) {
            if (this.d.get(componentName) != null) {
                return false;
            }
            ah(componentName);
            return true;
        }
        if (!this.x.contains(componentName) || this.d.containsKey(componentName)) {
            return false;
        }
        ah(componentName);
        return true;
    }

    private void ah(ComponentName componentName) {
        com.bytedance.pangle.service.ms msVarRemove = this.c.remove(componentName);
        this.x.remove(componentName);
        this.ah.remove(componentName);
        this.ab.remove(componentName);
        if (msVarRemove != null) {
            msVarRemove.onDestroy();
        }
    }

    @Override // com.bytedance.pangle.ka
    public boolean bindService(final Intent intent, final x xVar, final int i, final String str) throws RemoteException {
        if (Zeus.hasInit()) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return ms(intent, xVar, i, str);
            }
            this.f688ms.post(new Runnable() { // from class: com.bytedance.pangle.service.ms.ms.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ms.this.ms(intent, xVar, i, str);
                    } catch (RemoteException e) {
                        ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "bindService failed", e);
                    }
                }
            });
            return true;
        }
        this.ny.add(new Runnable() { // from class: com.bytedance.pangle.service.ms.ms.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ms.this.ms(intent, xVar, i, str);
                } catch (RemoteException e) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "pending bindService failed", e);
                }
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean ms(Intent intent, x xVar, int i, String str) throws RemoteException {
        ComponentName component = intent.getComponent();
        if (!this.c.containsKey(component)) {
            com.bytedance.pangle.service.ms msVarXr = xr(intent, str);
            if (msVarXr == null) {
                return false;
            }
            this.c.put(component, msVarXr);
        }
        com.bytedance.pangle.service.ms msVar = this.c.get(component);
        if (!this.ah.containsKey(component)) {
            this.ah.put(component, msVar.onBind(intent));
        }
        IBinder iBinder = this.ah.get(component);
        if (iBinder != null) {
            if (this.d.containsKey(component)) {
                if (!this.d.get(component).contains(xVar)) {
                    this.d.get(component).add(xVar);
                    this.ka.put(xVar, intent);
                    xVar.ms(component, iBinder);
                }
            } else {
                xr xrVar = new xr();
                xrVar.add(xVar);
                this.d.put(component, xrVar);
                this.ka.put(xVar, intent);
                xVar.ms(component, iBinder);
            }
        }
        return true;
    }

    @Override // com.bytedance.pangle.ka
    public void unbindService(final x xVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ms(xVar);
        } else {
            this.f688ms.post(new Runnable() { // from class: com.bytedance.pangle.service.ms.ms.6
                @Override // java.lang.Runnable
                public void run() {
                    ms.this.ms(xVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ms(x xVar) {
        for (ComponentName componentName : this.d.keySet()) {
            xr xrVar = this.d.get(componentName);
            if (xrVar.contains(xVar)) {
                xrVar.remove(xVar);
                Intent intentRemove = this.ka.remove(xVar);
                if (xrVar.size() == 0) {
                    this.d.remove(componentName);
                    com.bytedance.pangle.service.ms msVar = this.c.get(componentName);
                    if (msVar != null) {
                        msVar.onUnbind(intentRemove);
                    }
                }
                xr(componentName);
                return;
            }
        }
    }
}
