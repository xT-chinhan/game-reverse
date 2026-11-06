package com.byazt.ewn;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.byazt.ae.c;
import com.byazt.ae.hn;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.service.client.ServiceManagerNative;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 160, 13})
public class hw {
    public static hn uc;
    public static final Object pr = new Object();
    public static final Object hw = new Object();
    public static final Object hn = new Object();
    public static final Map<String, Boolean> x = new ConcurrentHashMap();
    public static final Map<String, c> c = new ConcurrentHashMap();

    public static c pr(String str) {
        Boolean bool = x.get(str);
        if (bool == null || !bool.booleanValue()) {
            c.remove(str);
        }
        Map<String, c> map = c;
        if (map.get(str) == null) {
            synchronized (hw) {
                c cVar = (c) pr("service", str);
                if (cVar == null) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVER, "getServiceManager failed!!!");
                    return null;
                }
                map.put(str, cVar);
            }
        }
        return map.get(str);
    }

    public static hn pr() {
        Boolean bool = x.get("main");
        if (bool == null || !bool.booleanValue()) {
            uc = null;
        }
        if (uc == null) {
            synchronized (hn) {
                hn hnVar = (hn) pr(AbsServerManager.PACKAGE_QUERY_BINDER, "main");
                if (hnVar == null) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVER, "getPackageManager failed!!!");
                    return null;
                }
                uc = hnVar;
            }
        }
        return uc;
    }

    private static IBinder pr(Uri uri, String str) {
        Bundle bundleCall = Zeus.getAppApplication().getContentResolver().call(uri, AbsServerManager.METHOD_QUERY_BINDER, str, (Bundle) null);
        if (bundleCall != null) {
            bundleCall.setClassLoader(AbsServerManager.class.getClassLoader());
            pr prVar = (pr) bundleCall.getParcelable(AbsServerManager.BUNDLE_BINDER);
            if (prVar != null) {
                return prVar.pr();
            }
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:12:0x004b  */
    private static IInterface pr(String str, final String str2) {
        if (!Zeus.hasInit()) {
            throw new RuntimeException("generateServerManager 请先初始化Zeus, processName:".concat(String.valueOf(str2)));
        }
        ProviderInfo providerInfo = Zeus.getServerManagerHashMap().get(str2);
        if (providerInfo == null) {
            throw new RuntimeException("宿主中没有找对对应进程的serverManager ".concat(String.valueOf(str2)));
        }
        final IBinder iBinderPr = pr(Uri.parse("content://" + providerInfo.authority), str);
        if (iBinderPr != null && iBinderPr.isBinderAlive()) {
            try {
                byte b = 0;
                iBinderPr.linkToDeath(new IBinder.DeathRecipient() { // from class: com.byazt.ewn.hw.1
                    @Override // android.os.IBinder.DeathRecipient
                    public void binderDied() {
                        hw.x.put(str2, Boolean.FALSE);
                        ZeusLogger.w(ZeusLogger.TAG_SERVER, "generateServerManager binderDied.");
                        HashMap<ServiceConnection, HashSet<ComponentName>> map = ServiceManagerNative.getInstance().process2ConnAndService.get(iBinderPr);
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
                x.put(str2, Boolean.TRUE);
                switch (str.hashCode()) {
                    case -807062458:
                        if (!str.equals(AbsServerManager.PACKAGE_QUERY_BINDER)) {
                        }
                        break;
                    case 1984153269:
                        b = !str.equals("service") ? (byte) -1 : (byte) 1;
                        break;
                    default:
                        break;
                }
                switch (b) {
                    case 0:
                        return hn.pr.pr(iBinderPr);
                    case 1:
                        return c.pr.pr(iBinderPr);
                    default:
                        return null;
                }
            } catch (RemoteException e) {
                ZeusLogger.errReport(ZeusLogger.TAG_SERVER, "generateServerManager failed.", e);
                return null;
            }
        }
        return null;
    }
}
