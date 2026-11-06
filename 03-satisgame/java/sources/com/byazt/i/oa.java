package com.byazt.i;

import android.app.Notification;
import android.os.RemoteException;
import com.byazt.je.ae;
import com.byazt.je.hu;
import com.byazt.je.ln;
import com.byazt.wm.DownloadInfo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_COST_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
public class oa extends com.byazt.xv.rv.n {
    public static final String n = "oa";
    public final com.byazt.xv.oa qg = new cy(true);

    @Override // com.byazt.xv.rv
    public void n(com.byazt.wm.n nVar) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return;
        }
        oaVar.qg(com.byazt.ta.x.n(nVar));
    }

    @Override // com.byazt.xv.rv
    public void n(int i) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return;
        }
        oaVar.n(i);
    }

    @Override // com.byazt.xv.rv
    public void n(int i, boolean z) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return;
        }
        oaVar.n(i, z);
    }

    @Override // com.byazt.xv.rv
    public boolean qg(int i) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return false;
        }
        return oaVar.qg(i);
    }

    @Override // com.byazt.xv.rv
    public void s(int i) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return;
        }
        oaVar.s(i);
    }

    @Override // com.byazt.xv.rv
    public void q(int i) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return;
        }
        oaVar.q(i);
    }

    @Override // com.byazt.xv.rv
    public void n() throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return;
        }
        oaVar.n();
    }

    @Override // com.byazt.xv.rv
    public long l(int i) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return 0L;
        }
        return oaVar.l(i);
    }

    @Override // com.byazt.xv.rv
    public int w(int i) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return 0;
        }
        return oaVar.w(i);
    }

    @Override // com.byazt.xv.rv
    public boolean x(int i) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return false;
        }
        return oaVar.x(i);
    }

    @Override // com.byazt.xv.rv
    public DownloadInfo fs(int i) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return null;
        }
        return oaVar.fs(i);
    }

    @Override // com.byazt.xv.rv
    public List<DownloadInfo> n(String str) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return null;
        }
        return oaVar.n(str);
    }

    @Override // com.byazt.xv.rv
    public List<com.byazt.wm.qg> rv(int i) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return null;
        }
        return oaVar.rv(i);
    }

    @Override // com.byazt.xv.rv
    public int n(String str, String str2) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return 0;
        }
        return oaVar.n(str, str2);
    }

    @Override // com.byazt.xv.rv
    public DownloadInfo qg(String str, String str2) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return null;
        }
        return oaVar.qg(str, str2);
    }

    @Override // com.byazt.xv.rv
    public List<DownloadInfo> qg(String str) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return null;
        }
        return oaVar.qg(str);
    }

    @Override // com.byazt.xv.rv
    public List<DownloadInfo> s(String str) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return null;
        }
        return oaVar.s(str);
    }

    @Override // com.byazt.xv.rv
    public List<DownloadInfo> q(String str) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return null;
        }
        return oaVar.l(str);
    }

    @Override // com.byazt.xv.rv
    public List<DownloadInfo> qg() throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return null;
        }
        return oaVar.q();
    }

    @Override // com.byazt.xv.rv
    public void n(List<String> list) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return;
        }
        oaVar.n(list);
    }

    @Override // com.byazt.xv.rv
    public void qg(List<String> list) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar != null) {
            oaVar.qg(list);
        }
    }

    @Override // com.byazt.xv.rv
    public void qg(int i, boolean z) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return;
        }
        oaVar.qg(i, z);
    }

    @Override // com.byazt.xv.rv
    public void s(int i, boolean z) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return;
        }
        oaVar.qg(i, z);
    }

    @Override // com.byazt.xv.rv
    public void tj(int i) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return;
        }
        oaVar.tj(i);
    }

    @Override // com.byazt.xv.rv
    public void n(int i, int i2, com.byazt.je.rv rvVar, int i3, boolean z) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return;
        }
        oaVar.qg(i, i2, com.byazt.ta.x.n(rvVar), com.byazt.ta.w.l(i3), z);
    }

    @Override // com.byazt.xv.rv
    public void qg(int i, int i2, com.byazt.je.rv rvVar, int i3, boolean z) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return;
        }
        oaVar.n(i, i2, com.byazt.ta.x.n(rvVar), com.byazt.ta.w.l(i3), z);
    }

    @Override // com.byazt.xv.rv
    public void n(int i, int i2, com.byazt.je.rv rvVar, int i3, boolean z, boolean z2) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return;
        }
        oaVar.n(i, i2, com.byazt.ta.x.n(rvVar), com.byazt.ta.w.l(i3), z, z2);
    }

    @Override // com.byazt.xv.rv
    public boolean n(DownloadInfo downloadInfo) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return false;
        }
        return oaVar.n(downloadInfo);
    }

    @Override // com.byazt.xv.rv
    public void n(int i, Notification notification) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return;
        }
        oaVar.n(i, notification);
    }

    @Override // com.byazt.xv.rv
    public void n(boolean z) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return;
        }
        oaVar.n(true, z);
    }

    @Override // com.byazt.xv.rv
    public boolean w() throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return false;
        }
        return oaVar.qg();
    }

    @Override // com.byazt.xv.rv
    public void n(int i, long j) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return;
        }
        oaVar.n(i, j);
    }

    @Override // com.byazt.xv.rv
    public boolean s() throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return false;
        }
        return oaVar.s();
    }

    @Override // com.byazt.xv.rv
    public List<DownloadInfo> l(String str) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return null;
        }
        return oaVar.q(str);
    }

    @Override // com.byazt.xv.rv
    public boolean cp(int i) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return false;
        }
        return oaVar.d(i);
    }

    @Override // com.byazt.xv.rv
    public void d(int i) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return;
        }
        oaVar.cp(i);
    }

    @Override // com.byazt.xv.rv
    public boolean q() throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return false;
        }
        return oaVar.l();
    }

    @Override // com.byazt.xv.rv
    public void q(int i, boolean z) throws RemoteException {
        com.byazt.xv.q.n().qg(i, z);
    }

    @Override // com.byazt.xv.rv
    public int oa(int i) throws RemoteException {
        return com.byazt.xv.q.n().qg(i);
    }

    @Override // com.byazt.xv.rv
    public void n(com.byazt.wm.qg qgVar) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return;
        }
        oaVar.n(qgVar);
    }

    @Override // com.byazt.xv.rv
    public boolean qg(DownloadInfo downloadInfo) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return false;
        }
        return oaVar.s(downloadInfo);
    }

    @Override // com.byazt.xv.rv
    public boolean sz(int i) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return false;
        }
        return oaVar.sz(i);
    }

    @Override // com.byazt.xv.rv
    public void k(int i) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return;
        }
        oaVar.k(i);
    }

    @Override // com.byazt.xv.rv
    public void n(int i, int i2, long j) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return;
        }
        oaVar.n(i, i2, j);
    }

    @Override // com.byazt.xv.rv
    public void n(int i, int i2, int i3, long j) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return;
        }
        oaVar.n(i, i2, i3, j);
    }

    @Override // com.byazt.xv.rv
    public void n(int i, int i2, int i3, int i4) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return;
        }
        oaVar.n(i, i2, i3, i4);
    }

    @Override // com.byazt.xv.rv
    public boolean cy(int i) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return false;
        }
        return oaVar.cy(i);
    }

    @Override // com.byazt.xv.rv
    public void l() throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return;
        }
        oaVar.w();
    }

    @Override // com.byazt.xv.rv
    public void n(int i, List<com.byazt.wm.qg> list) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return;
        }
        oaVar.qg(i, list);
    }

    @Override // com.byazt.xv.rv
    public void qg(int i, List<com.byazt.wm.qg> list) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return;
        }
        oaVar.n(i, list);
    }

    @Override // com.byazt.xv.rv
    public void n(ae aeVar) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return;
        }
        oaVar.n(com.byazt.ta.x.n(aeVar));
    }

    @Override // com.byazt.xv.rv
    public void n(int i, int i2) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return;
        }
        oaVar.n(i, i2);
    }

    @Override // com.byazt.xv.rv
    public hu hd(int i) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return null;
        }
        return com.byazt.ta.x.n(oaVar.hd(i));
    }

    @Override // com.byazt.xv.rv
    public ln cd(int i) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return null;
        }
        return com.byazt.ta.x.n(oaVar.cd(i));
    }

    @Override // com.byazt.xv.rv
    public void n(int i, hu huVar) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return;
        }
        oaVar.n(i, com.byazt.ta.x.n(huVar));
    }

    @Override // com.byazt.xv.rv
    public com.byazt.je.x um(int i) throws RemoteException {
        com.byazt.xv.oa oaVar = this.qg;
        if (oaVar == null) {
            return null;
        }
        return com.byazt.ta.x.n(oaVar.um(i));
    }
}
