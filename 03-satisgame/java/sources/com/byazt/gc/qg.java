package com.byazt.gc;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.byazt.ry.l;
import com.byazt.ry.s;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.service.client.ServiceManagerNative;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 884, 26})
public class qg {
    public static s w;
    public static final Object n = new Object();
    public static final Object qg = new Object();
    public static final Object s = new Object();
    public static final Map<String, Boolean> q = new ConcurrentHashMap();
    public static final Map<String, l> l = new ConcurrentHashMap();

    public static l n(String str) {
        Boolean bool = q.get(str);
        if (bool == null || !bool.booleanValue()) {
            l.remove(str);
        }
        Map<String, l> map = l;
        if (map.get(str) == null) {
            synchronized (qg) {
                l lVar = (l) n("service", str);
                if (lVar == null) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVER, "getServiceManager failed!!!");
                    return null;
                }
                map.put(str, lVar);
            }
        }
        return map.get(str);
    }

    public static s n() {
        Boolean bool = q.get("main");
        if (bool == null || !bool.booleanValue()) {
            w = null;
        }
        if (w == null) {
            synchronized (s) {
                s sVar = (s) n(AbsServerManager.PACKAGE_QUERY_BINDER, "main");
                if (sVar == null) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVER, "getPackageManager failed!!!");
                    return null;
                }
                w = sVar;
            }
        }
        return w;
    }

    private static IBinder n(Uri uri, String str) {
        Bundle bundleCall = Zeus.getAppApplication().getContentResolver().call(uri, AbsServerManager.METHOD_QUERY_BINDER, str, (Bundle) null);
        if (bundleCall != null) {
            bundleCall.setClassLoader(AbsServerManager.class.getClassLoader());
            n nVar = (n) bundleCall.getParcelable(AbsServerManager.BUNDLE_BINDER);
            if (nVar != null) {
                return nVar.n();
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0066  */
    private static IInterface n(String str, final String str2) {
        if (!Zeus.hasInit()) {
            throw new RuntimeException("generateServerManager 请先初始化Zeus, processName:".concat(String.valueOf(str2)));
        }
        ProviderInfo providerInfo = Zeus.getServerManagerHashMap().get(str2);
        if (providerInfo == null) {
            throw new RuntimeException("宿主中没有找对对应进程的serverManager ".concat(String.valueOf(str2)));
        }
        final IBinder iBinderN = n(Uri.parse("content://" + providerInfo.authority), str);
        if (iBinderN == null || !iBinderN.isBinderAlive()) {
            return null;
        }
        try {
            byte b = 0;
            iBinderN.linkToDeath(new IBinder.DeathRecipient() { // from class: com.byazt.gc.qg.1
                @Override // android.os.IBinder.DeathRecipient
                public void binderDied() {
                    qg.q.put(str2, Boolean.FALSE);
                    ZeusLogger.w(ZeusLogger.TAG_SERVER, "generateServerManager binderDied.");
                    HashMap<ServiceConnection, HashSet<ComponentName>> map = ServiceManagerNative.getInstance().process2ConnAndService.get(iBinderN);
                    if (map != null) {
                        for (ServiceConnection serviceConnection : map.keySet()) {
                            Iterator<ComponentName> it = map.get(serviceConnection).iterator();
                            while (it.hasNext()) {
                                serviceConnection.onServiceDisconnected(it.next());
                            }
                        }
                    }
                }
            }, 0);
            q.put(str2, Boolean.TRUE);
            int iHashCode = str.hashCode();
            if (iHashCode != -807062458) {
                if (iHashCode == 1984153269 && str.equals("service")) {
                    b = 1;
                } else {
                    b = -1;
                }
            } else if (!str.equals(AbsServerManager.PACKAGE_QUERY_BINDER)) {
                b = -1;
            }
            if (b == 0) {
                return s.n.n(iBinderN);
            }
            if (b != 1) {
                return null;
            }
            return l.n.n(iBinderN);
        } catch (RemoteException e) {
            ZeusLogger.errReport(ZeusLogger.TAG_SERVER, "generateServerManager failed.", e);
            return null;
        }
    }
}
