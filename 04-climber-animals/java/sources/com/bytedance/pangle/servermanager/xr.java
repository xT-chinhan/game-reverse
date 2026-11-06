package com.bytedance.pangle.servermanager;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.core.app.NotificationCompat;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ah;
import com.bytedance.pangle.ka;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.service.client.ServiceManagerNative;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    private static ah c;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final Object f683ms = new Object();
    private static final Object xr = new Object();
    private static final Object ah = new Object();
    private static final Map<String, Boolean> d = new ConcurrentHashMap();
    private static final Map<String, ka> ka = new ConcurrentHashMap();

    public static ka ms(String str) {
        Boolean bool = d.get(str);
        if (bool == null || !bool.booleanValue()) {
            ka.remove(str);
        }
        Map<String, ka> map = ka;
        if (map.get(str) == null) {
            synchronized (xr) {
                ka kaVar = (ka) ms(NotificationCompat.CATEGORY_SERVICE, str);
                if (kaVar == null) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVER, "getServiceManager failed!!!");
                    return null;
                }
                map.put(str, kaVar);
            }
        }
        return map.get(str);
    }

    public static ah ms() {
        Boolean bool = d.get("main");
        if (bool == null || !bool.booleanValue()) {
            c = null;
        }
        if (c == null) {
            synchronized (ah) {
                ah ahVar = (ah) ms("package", "main");
                if (ahVar == null) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVER, "getPackageManager failed!!!");
                    return null;
                }
                c = ahVar;
            }
        }
        return c;
    }

    private static IBinder ms(Uri uri, String str) {
        Bundle bundleCall = Zeus.getAppApplication().getContentResolver().call(uri, "query_binder", str, (Bundle) null);
        if (bundleCall != null) {
            bundleCall.setClassLoader(AbsServerManager.class.getClassLoader());
            ms msVar = (ms) bundleCall.getParcelable("binder");
            if (msVar != null) {
                return msVar.ms();
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0066  */
    private static IInterface ms(String str, final String str2) {
        if (!Zeus.hasInit()) {
            throw new RuntimeException("generateServerManager 请先初始化Zeus, processName:".concat(String.valueOf(str2)));
        }
        ProviderInfo providerInfo = Zeus.getServerManagerHashMap().get(str2);
        if (providerInfo == null) {
            throw new RuntimeException("宿主中没有找对对应进程的serverManager ".concat(String.valueOf(str2)));
        }
        final IBinder iBinderMs = ms(Uri.parse("content://" + providerInfo.authority), str);
        if (iBinderMs == null || !iBinderMs.isBinderAlive()) {
            return null;
        }
        try {
            byte b = 0;
            iBinderMs.linkToDeath(new IBinder.DeathRecipient() { // from class: com.bytedance.pangle.servermanager.xr.1
                @Override // android.os.IBinder.DeathRecipient
                public void binderDied() {
                    xr.d.put(str2, Boolean.FALSE);
                    ZeusLogger.w(ZeusLogger.TAG_SERVER, "generateServerManager binderDied.");
                    HashMap<ServiceConnection, HashSet<ComponentName>> map = ServiceManagerNative.getInstance().process2ConnAndService.get(iBinderMs);
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
            d.put(str2, Boolean.TRUE);
            int iHashCode = str.hashCode();
            if (iHashCode != -807062458) {
                if (iHashCode == 1984153269 && str.equals(NotificationCompat.CATEGORY_SERVICE)) {
                    b = 1;
                } else {
                    b = -1;
                }
            } else if (!str.equals("package")) {
                b = -1;
            }
            if (b == 0) {
                return ah.ms.ms(iBinderMs);
            }
            if (b != 1) {
                return null;
            }
            return ka.ms.ms(iBinderMs);
        } catch (RemoteException e) {
            ZeusLogger.errReport(ZeusLogger.TAG_SERVER, "generateServerManager failed.", e);
            return null;
        }
    }
}
