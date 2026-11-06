package com.byazt.wee;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.byazt.ae.c;
import com.byazt.ae.zo;
import com.byazt.dea.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.mar.sdk.MARCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 699, 37})
public class pr extends c.pr {
    public static volatile pr hw;
    public final HashMap<ComponentName, IBinder> hn = new HashMap<>();
    public final HashMap<ComponentName, hw> x = new HashMap<>();
    public final C0222pr<Intent> c = new C0222pr<>();
    public final HashMap<ComponentName, com.byazt.zbu.pr> uc = new HashMap<>();
    public final HashSet<ComponentName> fw = new HashSet<>();
    public final HashSet<ComponentName> zo = new HashSet<>();
    public final List<Runnable> aj = new ArrayList();
    public final Handler pr = new Handler(Looper.getMainLooper());

    @com.byazt.vzx.pr(pr = {0, 1, 699, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE})
    class hw extends HashSet<zo> {
        public hw() {
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (super.contains(obj)) {
                return true;
            }
            if (!(obj instanceof zo)) {
                return false;
            }
            Iterator<zo> it = iterator();
            while (it.hasNext()) {
                try {
                    if (it.next().pr() == ((zo) obj).pr()) {
                        return true;
                    }
                } catch (RemoteException e) {
                    uc.pr(e);
                }
            }
            return false;
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (super.remove(obj)) {
                return true;
            }
            Object obj2 = null;
            Iterator it = iterator();
            while (it.hasNext()) {
                zo zoVar = (zo) it.next();
                try {
                    if (zoVar.pr() == ((zo) obj).pr()) {
                        obj2 = zoVar;
                        break;
                    }
                } catch (RemoteException e) {
                    uc.pr(e);
                }
            }
            return super.remove(obj2);
        }
    }

    /* JADX INFO: renamed from: com.byazt.wee.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 699, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    class C0222pr<T> extends HashMap<zo, T> {
        public C0222pr() {
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            if (super.containsKey(obj)) {
                return true;
            }
            if (!(obj instanceof zo)) {
                return false;
            }
            Iterator<zo> it = keySet().iterator();
            while (it.hasNext()) {
                try {
                    if (it.next().pr() == ((zo) obj).pr()) {
                        return true;
                    }
                } catch (RemoteException e) {
                    uc.pr(e);
                }
            }
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public T remove(Object obj) {
            zo next;
            T t = (T) super.remove(obj);
            if (t != null) {
                return t;
            }
            Iterator<zo> it = keySet().iterator();
            while (it.hasNext()) {
                next = it.next();
                try {
                    if (next.pr() == ((zo) obj).pr()) {
                        return (T) super.remove(next);
                    }
                } catch (RemoteException e) {
                    uc.pr(e);
                }
            }
            next = null;
            return (T) super.remove(next);
        }
    }

    public static pr hw() {
        if (hw == null) {
            synchronized (pr.class) {
                if (hw == null) {
                    hw = new pr();
                }
            }
        }
        return hw;
    }

    private pr() {
    }

    public void hn() {
        for (Runnable runnable : this.aj) {
            if (runnable != null) {
                this.pr.post(runnable);
            }
        }
        this.aj.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ComponentName pr(final Intent intent, final String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return hw(intent, str);
        }
        this.pr.post(new Runnable() { // from class: com.byazt.wee.pr.1
            @Override // java.lang.Runnable
            public void run() {
                pr.this.hw(intent, str);
            }
        });
        return intent.getComponent();
    }

    @Override // com.byazt.ae.c
    public ComponentName startService(final Intent intent, final String str) {
        if (Zeus.hasInit()) {
            Plugin plugin = Zeus.getPlugin(str);
            if (plugin.isLoaded()) {
                return pr(intent, str);
            }
            plugin.addStartServicePluginPendingTask(new Plugin.pr() { // from class: com.byazt.wee.pr.2
                @Override // com.bytedance.pangle.plugin.Plugin.pr
                public void pr(int i) throws RemoteException {
                    pr.this.pr(intent, str);
                }
            });
        } else {
            this.aj.add(new Runnable() { // from class: com.byazt.wee.pr.3
                @Override // java.lang.Runnable
                public void run() {
                    pr.this.hw(intent, str);
                }
            });
        }
        return intent.getComponent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ComponentName hw(Intent intent, String str) {
        ComponentName component = intent.getComponent();
        if (!this.uc.containsKey(component)) {
            com.byazt.zbu.pr prVarHn = hn(intent, str);
            if (prVarHn == null) {
                return component;
            }
            this.uc.put(component, prVarHn);
            this.fw.add(component);
        }
        com.byazt.zbu.pr prVar = this.uc.get(component);
        if (prVar != null) {
            prVar.onStartCommand(intent, 0, 0);
        }
        return component;
    }

    private com.byazt.zbu.pr hn(Intent intent, String str) {
        com.byazt.zbu.pr prVarX = x(intent, str);
        if (prVarX != null) {
            prVarX.onCreate();
        }
        return prVarX;
    }

    private com.byazt.zbu.pr x(Intent intent, String str) {
        boolean zLoadPlugin;
        ComponentName component = intent.getComponent();
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        try {
            zLoadPlugin = Zeus.loadPlugin(str);
            try {
                com.byazt.zbu.pr prVar = (com.byazt.zbu.pr) plugin.mClassLoader.loadClass(component.getClassName()).newInstance();
                prVar.attach(plugin);
                return prVar;
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

    @Override // com.byazt.ae.c
    public boolean stopService(final Intent intent, String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            hw().pr(intent.getComponent());
            return true;
        }
        this.pr.post(new Runnable() { // from class: com.byazt.wee.pr.4
            @Override // java.lang.Runnable
            public void run() {
                pr.hw().pr(intent.getComponent());
            }
        });
        return true;
    }

    public synchronized boolean pr(ComponentName componentName) {
        if (this.uc.containsKey(componentName)) {
            this.zo.add(componentName);
            return hw(componentName);
        }
        return false;
    }

    private boolean hw(ComponentName componentName) {
        if (!this.fw.contains(componentName)) {
            if (this.x.get(componentName) == null) {
                hn(componentName);
                return true;
            }
            return false;
        }
        if (this.zo.contains(componentName) && !this.x.containsKey(componentName)) {
            hn(componentName);
            return true;
        }
        return false;
    }

    private void hn(ComponentName componentName) {
        com.byazt.zbu.pr prVarRemove = this.uc.remove(componentName);
        this.zo.remove(componentName);
        this.hn.remove(componentName);
        this.fw.remove(componentName);
        if (prVarRemove != null) {
            prVarRemove.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pr(final Intent intent, final zo zoVar, final int i, final String str) throws RemoteException {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return hw(intent, zoVar, i, str);
        }
        this.pr.post(new Runnable() { // from class: com.byazt.wee.pr.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    pr.this.hw(intent, zoVar, i, str);
                } catch (RemoteException e) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "bindService failed", e);
                }
            }
        });
        return true;
    }

    @Override // com.byazt.ae.c
    public boolean bindService(final Intent intent, final zo zoVar, final int i, final String str) throws RemoteException {
        if (Zeus.hasInit()) {
            Plugin plugin = Zeus.getPlugin(str);
            if (plugin.isLoaded()) {
                return pr(intent, zoVar, i, str);
            }
            if (Zeus.loadPlugin(str)) {
                pr(intent, zoVar, i, str);
                return true;
            }
            plugin.addBindServicePluginPendingTask(new Plugin.pr() { // from class: com.byazt.wee.pr.6
                @Override // com.bytedance.pangle.plugin.Plugin.pr
                public void pr(int i2) throws RemoteException {
                    pr.this.pr(intent, zoVar, i, str);
                }
            });
            return true;
        }
        this.aj.add(new Runnable() { // from class: com.byazt.wee.pr.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    pr.this.hw(intent, zoVar, i, str);
                } catch (RemoteException e) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "pending bindService failed", e);
                }
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean hw(Intent intent, zo zoVar, int i, String str) throws RemoteException {
        ComponentName component = intent.getComponent();
        if (!this.uc.containsKey(component)) {
            com.byazt.zbu.pr prVarHn = hn(intent, str);
            if (prVarHn == null) {
                return false;
            }
            this.uc.put(component, prVarHn);
        }
        com.byazt.zbu.pr prVar = this.uc.get(component);
        if (!this.hn.containsKey(component)) {
            this.hn.put(component, prVar.onBind(intent));
        }
        IBinder iBinder = this.hn.get(component);
        if (iBinder != null) {
            if (this.x.containsKey(component)) {
                if (!this.x.get(component).contains(zoVar)) {
                    this.x.get(component).add(zoVar);
                    this.c.put(zoVar, intent);
                    zoVar.pr(component, iBinder);
                }
            } else {
                hw hwVar = new hw();
                hwVar.add(zoVar);
                this.x.put(component, hwVar);
                this.c.put(zoVar, intent);
                zoVar.pr(component, iBinder);
            }
        }
        return true;
    }

    @Override // com.byazt.ae.c
    public void unbindService(final zo zoVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            pr(zoVar);
        } else {
            this.pr.post(new Runnable() { // from class: com.byazt.wee.pr.8
                @Override // java.lang.Runnable
                public void run() {
                    pr.this.pr(zoVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void pr(zo zoVar) {
        for (ComponentName componentName : this.x.keySet()) {
            hw hwVar = this.x.get(componentName);
            if (hwVar.contains(zoVar)) {
                hwVar.remove(zoVar);
                Intent intentRemove = this.c.remove(zoVar);
                if (hwVar.size() == 0) {
                    this.x.remove(componentName);
                    com.byazt.zbu.pr prVar = this.uc.get(componentName);
                    if (prVar != null) {
                        prVar.onUnbind(intentRemove);
                    }
                }
                hw(componentName);
                return;
            }
        }
    }

    @Override // com.byazt.ae.c.pr, android.os.IInterface
    public IBinder asBinder() {
        return null;
    }
}
