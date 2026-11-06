package com.bytedance.pangle.ab;

import android.os.RemoteException;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.ch;
import com.bytedance.pangle.d;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.plugin.PluginManager;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends com.bytedance.pangle.ah.ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile ms f610ms;

    public static ms xr() {
        if (f610ms == null) {
            synchronized (ms.class) {
                if (f610ms == null) {
                    f610ms = new ms();
                }
            }
        }
        return f610ms;
    }

    @Override // com.bytedance.pangle.ah
    public boolean ms(String str) {
        return PluginManager.getInstance().checkPluginInstalled(str);
    }

    @Override // com.bytedance.pangle.ah
    public int xr(String str) {
        return PluginManager.getInstance().getPlugin(str).getVersion();
    }

    @Override // com.bytedance.pangle.ah
    public boolean ms(String str, String str2) {
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_PLUGIN_INSTALL, "start install pkg:" + str + ", path:" + str2);
        return PluginManager.getInstance().syncInstall(str, new File(str2));
    }

    @Override // com.bytedance.pangle.ah
    public void ms(int i, d dVar) throws RemoteException {
        Zeus.registerPluginStateListener(new ah(dVar, i));
    }

    @Override // com.bytedance.pangle.ah
    public void ms(int i) throws RemoteException {
        ZeusPluginStateListener next;
        List<ZeusPluginStateListener> listAh = ch.ms().ah();
        Iterator<ZeusPluginStateListener> it = listAh.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if ((next instanceof ah) && ((ah) next).ms() == i) {
                break;
            }
        }
        if (next != null) {
            listAh.remove(next);
        }
    }
}
