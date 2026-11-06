package com.byazt.ts;

import android.app.Notification;
import android.os.RemoteException;
import com.byazt.auw.DownloadInfo;
import com.byazt.fn.nl;
import com.byazt.fn.s;
import com.byazt.fn.z;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, 108})
public class m extends com.byazt.lj.aj.pr {
    public static final String pr = m.class.getSimpleName();
    public final com.byazt.lj.m hw = new nt(true);

    @Override // com.byazt.lj.aj
    public void pr(com.byazt.auw.pr prVar) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return;
        }
        mVar.hw(com.byazt.tuy.fw.pr(prVar));
    }

    @Override // com.byazt.lj.aj
    public void pr(int i) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return;
        }
        mVar.pr(i);
    }

    @Override // com.byazt.lj.aj
    public void pr(int i, boolean z) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return;
        }
        mVar.pr(i, z);
    }

    @Override // com.byazt.lj.aj
    public boolean hw(int i) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return false;
        }
        return mVar.hw(i);
    }

    @Override // com.byazt.lj.aj
    public void hn(int i) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return;
        }
        mVar.hn(i);
    }

    @Override // com.byazt.lj.aj
    public void x(int i) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return;
        }
        mVar.x(i);
    }

    @Override // com.byazt.lj.aj
    public void pr() throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return;
        }
        mVar.pr();
    }

    @Override // com.byazt.lj.aj
    public long c(int i) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return 0L;
        }
        return mVar.c(i);
    }

    @Override // com.byazt.lj.aj
    public int uc(int i) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return 0;
        }
        return mVar.uc(i);
    }

    @Override // com.byazt.lj.aj
    public boolean fw(int i) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return false;
        }
        return mVar.fw(i);
    }

    @Override // com.byazt.lj.aj
    public DownloadInfo zo(int i) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return null;
        }
        return mVar.zo(i);
    }

    @Override // com.byazt.lj.aj
    public List<DownloadInfo> pr(String str) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return null;
        }
        return mVar.pr(str);
    }

    @Override // com.byazt.lj.aj
    public List<com.byazt.auw.hw> aj(int i) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return null;
        }
        return mVar.aj(i);
    }

    @Override // com.byazt.lj.aj
    public int pr(String str, String str2) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return 0;
        }
        return mVar.pr(str, str2);
    }

    @Override // com.byazt.lj.aj
    public DownloadInfo hw(String str, String str2) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return null;
        }
        return mVar.hw(str, str2);
    }

    @Override // com.byazt.lj.aj
    public List<DownloadInfo> hw(String str) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return null;
        }
        return mVar.hw(str);
    }

    @Override // com.byazt.lj.aj
    public List<DownloadInfo> hn(String str) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return null;
        }
        return mVar.hn(str);
    }

    @Override // com.byazt.lj.aj
    public List<DownloadInfo> x(String str) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return null;
        }
        return mVar.c(str);
    }

    @Override // com.byazt.lj.aj
    public List<DownloadInfo> hw() throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return null;
        }
        return mVar.x();
    }

    @Override // com.byazt.lj.aj
    public void pr(List<String> list) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return;
        }
        mVar.pr(list);
    }

    @Override // com.byazt.lj.aj
    public void hw(List<String> list) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar != null) {
            mVar.hw(list);
        }
    }

    @Override // com.byazt.lj.aj
    public void hw(int i, boolean z) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return;
        }
        mVar.hw(i, z);
    }

    @Override // com.byazt.lj.aj
    public void hn(int i, boolean z) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return;
        }
        mVar.hw(i, z);
    }

    @Override // com.byazt.lj.aj
    public void vk(int i) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return;
        }
        mVar.vk(i);
    }

    @Override // com.byazt.lj.aj
    public void pr(int i, int i2, com.byazt.fn.aj ajVar, int i3, boolean z) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return;
        }
        mVar.hw(i, i2, com.byazt.tuy.fw.pr(ajVar), com.byazt.tuy.uc.c(i3), z);
    }

    @Override // com.byazt.lj.aj
    public void hw(int i, int i2, com.byazt.fn.aj ajVar, int i3, boolean z) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return;
        }
        mVar.pr(i, i2, com.byazt.tuy.fw.pr(ajVar), com.byazt.tuy.uc.c(i3), z);
    }

    @Override // com.byazt.lj.aj
    public void pr(int i, int i2, com.byazt.fn.aj ajVar, int i3, boolean z, boolean z2) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return;
        }
        mVar.pr(i, i2, com.byazt.tuy.fw.pr(ajVar), com.byazt.tuy.uc.c(i3), z, z2);
    }

    @Override // com.byazt.lj.aj
    public boolean pr(DownloadInfo downloadInfo) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return false;
        }
        return mVar.pr(downloadInfo);
    }

    @Override // com.byazt.lj.aj
    public void pr(int i, Notification notification) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return;
        }
        mVar.pr(i, notification);
    }

    @Override // com.byazt.lj.aj
    public void pr(boolean z) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return;
        }
        mVar.pr(true, z);
    }

    @Override // com.byazt.lj.aj
    public boolean uc() throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return false;
        }
        return mVar.hw();
    }

    @Override // com.byazt.lj.aj
    public void pr(int i, long j) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return;
        }
        mVar.pr(i, j);
    }

    @Override // com.byazt.lj.aj
    public boolean hn() throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return false;
        }
        return mVar.hn();
    }

    @Override // com.byazt.lj.aj
    public List<DownloadInfo> c(String str) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return null;
        }
        return mVar.x(str);
    }

    @Override // com.byazt.lj.aj
    public boolean w(int i) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return false;
        }
        return mVar.k(i);
    }

    @Override // com.byazt.lj.aj
    public void k(int i) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return;
        }
        mVar.w(i);
    }

    @Override // com.byazt.lj.aj
    public boolean x() throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return false;
        }
        return mVar.c();
    }

    @Override // com.byazt.lj.aj
    public void x(int i, boolean z) throws RemoteException {
        com.byazt.lj.x.pr().hw(i, z);
    }

    @Override // com.byazt.lj.aj
    public int m(int i) throws RemoteException {
        return com.byazt.lj.x.pr().hw(i);
    }

    @Override // com.byazt.lj.aj
    public void pr(com.byazt.auw.hw hwVar) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return;
        }
        mVar.pr(hwVar);
    }

    @Override // com.byazt.lj.aj
    public boolean hw(DownloadInfo downloadInfo) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return false;
        }
        return mVar.hn(downloadInfo);
    }

    @Override // com.byazt.lj.aj
    public boolean g(int i) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return false;
        }
        return mVar.g(i);
    }

    @Override // com.byazt.lj.aj
    public void ho(int i) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return;
        }
        mVar.ho(i);
    }

    @Override // com.byazt.lj.aj
    public void pr(int i, int i2, long j) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return;
        }
        mVar.pr(i, i2, j);
    }

    @Override // com.byazt.lj.aj
    public void pr(int i, int i2, int i3, long j) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return;
        }
        mVar.pr(i, i2, i3, j);
    }

    @Override // com.byazt.lj.aj
    public void pr(int i, int i2, int i3, int i4) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return;
        }
        mVar.pr(i, i2, i3, i4);
    }

    @Override // com.byazt.lj.aj
    public boolean nt(int i) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return false;
        }
        return mVar.nt(i);
    }

    @Override // com.byazt.lj.aj
    public void c() throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return;
        }
        mVar.uc();
    }

    @Override // com.byazt.lj.aj
    public void pr(int i, List<com.byazt.auw.hw> list) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return;
        }
        mVar.hw(i, list);
    }

    @Override // com.byazt.lj.aj
    public void hw(int i, List<com.byazt.auw.hw> list) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return;
        }
        mVar.pr(i, list);
    }

    @Override // com.byazt.lj.aj
    public void pr(s sVar) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return;
        }
        mVar.pr(com.byazt.tuy.fw.pr(sVar));
    }

    @Override // com.byazt.lj.aj
    public void pr(int i, int i2) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return;
        }
        mVar.pr(i, i2);
    }

    @Override // com.byazt.lj.aj
    public z yb(int i) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return null;
        }
        return com.byazt.tuy.fw.pr(mVar.yb(i));
    }

    @Override // com.byazt.lj.aj
    public nl lb(int i) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return null;
        }
        return com.byazt.tuy.fw.pr(mVar.lb(i));
    }

    @Override // com.byazt.lj.aj
    public void pr(int i, z zVar) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return;
        }
        mVar.pr(i, com.byazt.tuy.fw.pr(zVar));
    }

    @Override // com.byazt.lj.aj
    public com.byazt.fn.fw qa(int i) throws RemoteException {
        com.byazt.lj.m mVar = this.hw;
        if (mVar == null) {
            return null;
        }
        return com.byazt.tuy.fw.pr(mVar.qa(i));
    }
}
