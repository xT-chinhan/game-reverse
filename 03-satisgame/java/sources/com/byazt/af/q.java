package com.byazt.af;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.util.SparseArray;
import com.anythink.china.b.c;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SAVED_HOST_TIME, 5})
public class q extends com.byazt.zq.q implements Serializable, Function<SparseArray<Object>, Object> {
    public final com.byazt.zq.q n;
    public int qg;

    @Override // com.byazt.zq.q
    public boolean sz() {
        return false;
    }

    public q(com.byazt.zq.q qVar) {
        super(null);
        this.qg = 0;
        this.n = qVar;
    }

    @Override // com.byazt.zq.q
    public boolean n() {
        com.byazt.zq.q qVar = this.n;
        if (qVar == null) {
            if (super.n() && x.n().n(com.byazt.nf.rv.getContext(), "android.permission.ACCESS_COARSE_LOCATION") && x.n().n(com.byazt.nf.rv.getContext(), "android.permission.ACCESS_FINE_LOCATION")) {
                return true;
            }
        } else if (qVar.n() && x.n().n(com.byazt.nf.rv.getContext(), "android.permission.ACCESS_COARSE_LOCATION") && x.n().n(com.byazt.nf.rv.getContext(), "android.permission.ACCESS_FINE_LOCATION")) {
            return true;
        }
        return false;
    }

    @Override // com.byazt.zq.q
    public com.byazt.zq.s qg() {
        com.byazt.zq.q qVar = this.n;
        if (qVar == null) {
            return super.qg();
        }
        return qVar.qg();
    }

    @Override // com.byazt.zq.q
    public boolean s() {
        com.byazt.zq.q qVar = this.n;
        if (qVar == null) {
            return super.s();
        }
        return qVar.s();
    }

    @Override // com.byazt.zq.q
    public boolean q() {
        com.byazt.zq.q qVar = this.n;
        if (qVar == null) {
            return super.q();
        }
        return qVar.q() && x.n().n(com.byazt.nf.rv.getContext(), c.a);
    }

    @Override // com.byazt.zq.q
    public String l() {
        com.byazt.zq.q qVar = this.n;
        if (qVar == null) {
            return super.l();
        }
        return qVar.l();
    }

    @Override // com.byazt.zq.q
    public boolean w() {
        com.byazt.zq.q qVar = this.n;
        if (qVar == null) {
            return super.w();
        }
        return qVar.w() && x.n().n(com.byazt.nf.rv.getContext(), "android.permission.ACCESS_WIFI_STATE");
    }

    @Override // com.byazt.zq.q
    public String x() {
        com.byazt.zq.q qVar = this.n;
        if (qVar == null) {
            return super.x();
        }
        return qVar.x();
    }

    @Override // com.byazt.zq.q
    public boolean fs() {
        if (this.n == null) {
            return super.fs();
        }
        Context context = com.byazt.nf.rv.getContext();
        if (context == null) {
            return super.fs();
        }
        boolean zN = x.n().n(context, c.b);
        boolean zFs = this.n.fs();
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int i = applicationInfo.targetSdkVersion;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            if (i < 30) {
                return zN && zFs && n(applicationInfo);
            }
            return zFs;
        }
        if (i2 == 29) {
            return zN && zFs && n(applicationInfo);
        }
        return zFs && zN;
    }

    private boolean n(ApplicationInfo applicationInfo) {
        try {
            if (this.qg == 0) {
                Field declaredField = ApplicationInfo.class.getDeclaredField("privateFlags");
                declaredField.setAccessible(true);
                this.qg = ((Integer) declaredField.get(applicationInfo)).intValue();
            }
            return (this.qg & C.ENCODING_PCM_A_LAW) != 0;
        } catch (Throwable th) {
            com.byazt.eji.s.n().n("hasLegacyStorage", th);
            return false;
        }
    }

    @Override // com.byazt.zq.q
    public String rv() {
        com.byazt.zq.q qVar = this.n;
        if (qVar == null) {
            return super.rv();
        }
        return qVar.rv();
    }

    @Override // com.byazt.zq.q
    public boolean tj() {
        com.byazt.zq.q qVar = this.n;
        if (qVar == null) {
            return super.tj();
        }
        return qVar.tj();
    }

    @Override // com.byazt.zq.q
    public String cp() {
        com.byazt.zq.q qVar = this.n;
        if (qVar == null) {
            return super.cp();
        }
        return qVar.cp();
    }

    @Override // com.byazt.zq.q
    public Map<String, Object> d() {
        com.byazt.zq.q qVar = this.n;
        if (qVar == null) {
            return super.d();
        }
        return qVar.d();
    }

    @Override // com.byazt.zq.q
    public boolean oa() {
        com.byazt.zq.q qVar = this.n;
        if (qVar == null) {
            return super.oa();
        }
        return qVar.oa();
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        int iIntValue = ((Integer) sparseArray.get(-99999987)).intValue();
        switch (iIntValue) {
            case 262101:
                return Boolean.valueOf(n());
            case 262102:
                com.byazt.zq.s sVarQg = qg();
                if (sVarQg == null) {
                    return null;
                }
                double dN = sVarQg.n();
                return com.byazt.qvu.n.n().n(262001, dN).n(262002, sVarQg.qg()).qg().sparseArray();
            case 262103:
                return Boolean.valueOf(s());
            case 262104:
                return Boolean.valueOf(q());
            case 262105:
                return l();
            case 262106:
                return Boolean.valueOf(w());
            case 262107:
                return x();
            case 262108:
                return Boolean.valueOf(fs());
            case 262109:
                return rv();
            case 262110:
                return Boolean.valueOf(tj());
            case 262111:
                return Boolean.valueOf(sz());
            case 262112:
                return cp();
            default:
                switch (iIntValue) {
                    case 262119:
                        return d();
                    case 262120:
                        return Boolean.valueOf(oa());
                    default:
                        return null;
                }
        }
    }
}
