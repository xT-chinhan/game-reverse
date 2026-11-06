package com.byazt.ej;

import android.graphics.SurfaceTexture;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, AVMDLDataLoader.KeyIsIsDownloadSource, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv implements x, Function {
    public volatile Function n;
    public volatile x qg;

    public rv(x xVar) {
        this.qg = xVar;
    }

    public rv(Function function) {
        this.n = function;
    }

    @Override // com.byazt.ej.x
    public long a() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 28);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Long) objApply).longValue();
        }
        return 0L;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                Object cyVar = sparseArray.get(1);
                if (cyVar != null) {
                    cyVar = new cy((Function) cyVar);
                }
                this.qg.n((k) cyVar);
                return null;
            case 2:
                this.qg.qg(((Boolean) sparseArray.get(1)).booleanValue());
                return null;
            case 3:
                this.qg.qg(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 4:
                this.qg.n(((Boolean) sparseArray.get(1)).booleanValue(), ((Long) sparseArray.get(2)).longValue(), ((Boolean) sparseArray.get(3)).booleanValue());
                return null;
            case 5:
                this.qg.qg();
                return null;
            case 6:
                this.qg.s();
                return null;
            case 7:
                this.qg.q();
                return null;
            case 8:
                this.qg.x();
                return null;
            case 9:
                this.qg.l();
                return null;
            case 10:
                this.qg.w();
                return null;
            case 11:
                this.qg.n(((Long) sparseArray.get(1)).longValue());
                return null;
            case 12:
                return Boolean.valueOf(this.qg.fs());
            case 13:
                this.qg.n(((Boolean) sparseArray.get(1)).booleanValue());
                return null;
            case 14:
                this.qg.n((SurfaceHolder) sparseArray.get(1));
                return null;
            case 15:
                return this.qg.m();
            case 16:
                this.qg.n((SurfaceTexture) sparseArray.get(1));
                return null;
            case 17:
                return this.qg.hu();
            case 18:
                return Boolean.valueOf(this.qg.k());
            case 19:
                return Boolean.valueOf(this.qg.sz());
            case 20:
                return Boolean.valueOf(this.qg.cp());
            case 21:
                return Integer.valueOf(this.qg.hd());
            case 22:
                return Integer.valueOf(this.qg.cd());
            case 23:
                return Boolean.valueOf(this.qg.tj());
            case 24:
                return Boolean.valueOf(this.qg.d());
            case 25:
                return Boolean.valueOf(this.qg.oa());
            case 26:
                return Long.valueOf(this.qg.cy());
            case 27:
                return Integer.valueOf(this.qg.um());
            case 28:
                return Long.valueOf(this.qg.a());
            case 29:
                return Long.valueOf(this.qg.py());
            case 30:
                this.qg.s(((Boolean) sparseArray.get(1)).booleanValue());
                return null;
            case 31:
                return Boolean.valueOf(this.qg.ou());
            case 32:
                Object fsVar = sparseArray.get(1);
                if (fsVar != null) {
                    fsVar = new fs((Function) fsVar);
                }
                this.qg.n((x.n) fsVar);
                return null;
            case 33:
                Object fsVar2 = sparseArray.get(1);
                if (fsVar2 != null) {
                    fsVar2 = new fs((Function) fsVar2);
                }
                this.qg.qg((x.n) fsVar2);
                return null;
            case 34:
                this.qg.n(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 35:
                return Integer.valueOf(this.qg.wm());
            case 36:
                this.qg.n(((Float) sparseArray.get(1)).floatValue());
                return null;
            case 37:
                return this.qg.h();
            case 38:
                Object szVar = sparseArray.get(1);
                if (szVar != null) {
                    szVar = new sz((Function) szVar);
                }
                this.qg.n((oa) szVar);
                return null;
            default:
                return null;
        }
    }

    @Override // com.byazt.ej.x
    public int cd() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 22);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.ej.x
    public boolean cp() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 20);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.ej.x
    public long cy() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 26);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Long) objApply).longValue();
        }
        return 0L;
    }

    @Override // com.byazt.ej.x
    public boolean d() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 24);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    public boolean equals(Object obj) {
        Object obj2;
        if (obj == null) {
            return false;
        }
        if (this.n != null) {
            obj2 = this.n;
        } else {
            if (this.qg == null) {
                return super.equals(obj);
            }
            obj2 = this.qg;
        }
        return obj.equals(obj2);
    }

    @Override // com.byazt.ej.x
    public boolean fs() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.ej.x
    public String h() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 37);
        return (String) this.n.apply(sparseArray);
    }

    public int hashCode() {
        Object obj;
        if (this.n != null) {
            obj = this.n;
        } else {
            if (this.qg == null) {
                return super.hashCode();
            }
            obj = this.qg;
        }
        return obj.hashCode();
    }

    @Override // com.byazt.ej.x
    public int hd() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 21);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.ej.x
    public SurfaceTexture hu() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        return (SurfaceTexture) this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.x
    public boolean k() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 18);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.ej.x
    public void l() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.x
    public SurfaceHolder m() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        return (SurfaceHolder) this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.x
    public void n(float f) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 36);
        sparseArray.put(1, Float.valueOf(f));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.x
    public void n(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 34);
        sparseArray.put(1, Integer.valueOf(i));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.x
    public void n(long j) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        sparseArray.put(1, Long.valueOf(j));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.x
    public void n(SurfaceTexture surfaceTexture) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        sparseArray.put(1, surfaceTexture);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.x
    public void n(SurfaceHolder surfaceHolder) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        sparseArray.put(1, surfaceHolder);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.x
    public void n(k kVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        if (kVar != null) {
            kVar = new cy(kVar);
        }
        sparseArray.put(1, kVar);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.x
    public void n(oa oaVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 38);
        if (oaVar != null) {
            oaVar = new sz(oaVar);
        }
        sparseArray.put(1, oaVar);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.x
    public void n(x.n nVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 32);
        if (nVar != null) {
            nVar = new fs(nVar);
        }
        sparseArray.put(1, nVar);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.x
    public void n(boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        sparseArray.put(1, Boolean.valueOf(z));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.x
    public void n(boolean z, long j, boolean z2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, Boolean.valueOf(z));
        sparseArray.put(2, Long.valueOf(j));
        sparseArray.put(3, Boolean.valueOf(z2));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.x
    public boolean oa() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 25);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.ej.x
    public boolean ou() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 31);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.ej.x
    public long py() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 29);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Long) objApply).longValue();
        }
        return 0L;
    }

    @Override // com.byazt.ej.x
    public void q() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.x
    public void qg() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.x
    public void qg(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, Integer.valueOf(i));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.x
    public void qg(x.n nVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 33);
        if (nVar != null) {
            nVar = new fs(nVar);
        }
        sparseArray.put(1, nVar);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.x
    public void qg(boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, Boolean.valueOf(z));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.x
    public void s() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.x
    public void s(boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 30);
        sparseArray.put(1, Boolean.valueOf(z));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.x
    public boolean sz() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 19);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.ej.x
    public boolean tj() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 23);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.ej.x
    public int um() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 27);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.ej.x
    public void w() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.x
    public int wm() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 35);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.ej.x
    public void x() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        this.n.apply(sparseArray);
    }
}
