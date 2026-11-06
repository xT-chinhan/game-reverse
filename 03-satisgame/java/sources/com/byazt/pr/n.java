package com.byazt.pr;

import android.os.RemoteException;
import com.byazt.ry.cp;
import com.byazt.ry.q;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.plugin.PluginManager;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1943, 19})
public class n extends com.byazt.ry.s.n {
    public static volatile n n;

    public static n qg() {
        if (n == null) {
            synchronized (n.class) {
                if (n == null) {
                    n = new n();
                }
            }
        }
        return n;
    }

    @Override // com.byazt.ry.s
    public boolean n(String str) {
        return PluginManager.getInstance().checkPluginInstalled(str);
    }

    @Override // com.byazt.ry.s
    public int qg(String str) {
        return PluginManager.getInstance().getPlugin(str).getVersion();
    }

    @Override // com.byazt.ry.s
    public boolean n(String str, String str2) {
        GlobalParam.getInstance().getReporter().n("zeus_stage_plugin_install", "start install pkg:" + str + ", path:" + str2);
        return PluginManager.getInstance().syncInstall(str, new File(str2));
    }

    @Override // com.byazt.ry.s
    public void n(int i, q qVar) throws RemoteException {
        Zeus.registerPluginStateListener(new s(qVar, i));
    }

    @Override // com.byazt.ry.s
    public void n(int i) throws RemoteException {
        ZeusPluginStateListener next;
        List<ZeusPluginStateListener> listS = cp.n().s();
        Iterator<ZeusPluginStateListener> it = listS.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if ((next instanceof s) && ((s) next).n() == i) {
                break;
            }
        }
        if (next != null) {
            listS.remove(next);
        }
    }
}
