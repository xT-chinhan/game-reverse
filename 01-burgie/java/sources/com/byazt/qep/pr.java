package com.byazt.qep;

import android.os.RemoteException;
import com.byazt.ae.w;
import com.byazt.ae.x;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.plugin.PluginManager;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1973, 37})
public class pr extends com.byazt.ae.hn.pr {
    public static volatile pr pr;

    public static pr hw() {
        if (pr == null) {
            synchronized (pr.class) {
                if (pr == null) {
                    pr = new pr();
                }
            }
        }
        return pr;
    }

    @Override // com.byazt.ae.hn
    public boolean pr(String str) {
        return PluginManager.getInstance().checkPluginInstalled(str);
    }

    @Override // com.byazt.ae.hn
    public int hw(String str) {
        return PluginManager.getInstance().getPlugin(str).getVersion();
    }

    @Override // com.byazt.ae.hn
    public boolean pr(String str, String str2) {
        GlobalParam.getInstance().getReporter().pr("zeus_stage_plugin_install", "start install pkg:" + str + ", path:" + str2);
        return PluginManager.getInstance().syncInstall(str, new File(str2));
    }

    @Override // com.byazt.ae.hn
    public void pr(int i, x xVar) throws RemoteException {
        Zeus.registerPluginStateListener(new hn(xVar, i));
    }

    @Override // com.byazt.ae.hn
    public void pr(int i) throws RemoteException {
        ZeusPluginStateListener next;
        List<ZeusPluginStateListener> listHn = w.pr().hn();
        Iterator<ZeusPluginStateListener> it = listHn.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if ((next instanceof hn) && ((hn) next).pr() == i) {
                break;
            }
        }
        if (next != null) {
            listHn.remove(next);
        }
    }
}
