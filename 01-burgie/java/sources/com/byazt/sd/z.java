package com.byazt.sd;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.C;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 23, 110})
public class z extends com.byazt.qe.x implements Serializable, Function<SparseArray<Object>, Object> {
    public int hw;
    public final com.byazt.qe.x pr;

    public z(com.byazt.qe.x xVar) {
        super(null);
        this.hw = 0;
        this.pr = xVar;
    }

    public final com.byazt.qe.x g() {
        return this.pr;
    }

    @Override // com.byazt.qe.x
    public boolean pr() {
        com.byazt.qe.x xVar = this.pr;
        if (xVar == null) {
            return super.pr() && com.byazt.qam.c.pr().pr(a.getContext(), "android.permission.ACCESS_COARSE_LOCATION") && com.byazt.qam.c.pr().pr(a.getContext(), "android.permission.ACCESS_FINE_LOCATION");
        }
        return xVar.pr() && com.byazt.qam.c.pr().pr(a.getContext(), "android.permission.ACCESS_COARSE_LOCATION") && com.byazt.qam.c.pr().pr(a.getContext(), "android.permission.ACCESS_FINE_LOCATION");
    }

    @Override // com.byazt.qe.x
    public com.byazt.qe.hn aj() {
        com.byazt.qe.x xVar = this.pr;
        if (xVar == null) {
            return super.aj();
        }
        return xVar.aj();
    }

    @Override // com.byazt.qe.x
    public boolean hw() {
        com.byazt.qe.x xVar = this.pr;
        if (xVar == null) {
            return super.hw();
        }
        return xVar.hw();
    }

    @Override // com.byazt.qe.x
    public boolean hn() {
        com.byazt.qe.x xVar = this.pr;
        if (xVar == null) {
            return super.hn();
        }
        return xVar.hn() && com.byazt.qam.c.pr().pr(a.getContext(), "android.permission.READ_PHONE_STATE");
    }

    @Override // com.byazt.qe.x
    public String vk() {
        com.byazt.qe.x xVar = this.pr;
        if (xVar == null) {
            return super.vk();
        }
        return xVar.vk();
    }

    @Override // com.byazt.qe.x
    public boolean x() {
        com.byazt.qe.x xVar = this.pr;
        if (xVar == null) {
            return super.x();
        }
        return xVar.x() && com.byazt.qam.c.pr().pr(a.getContext(), "android.permission.ACCESS_WIFI_STATE");
    }

    @Override // com.byazt.qe.x
    public String w() {
        com.byazt.qe.x xVar = this.pr;
        if (xVar == null) {
            return super.w();
        }
        return xVar.w();
    }

    @Override // com.byazt.qe.x
    public boolean c() {
        if (this.pr == null) {
            return super.c();
        }
        Context context = a.getContext();
        if (context == null) {
            return super.c();
        }
        boolean zPr = com.byazt.qam.c.pr().pr(context, "android.permission.WRITE_EXTERNAL_STORAGE");
        boolean zC = this.pr.c();
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int i = applicationInfo.targetSdkVersion;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            if (i < 30) {
                return zPr && zC && pr(applicationInfo);
            }
            return zC;
        }
        if (i2 == 29) {
            return zPr && zC && pr(applicationInfo);
        }
        return zC && zPr;
    }

    private boolean pr(ApplicationInfo applicationInfo) {
        try {
            if (this.hw == 0) {
                Field declaredField = ApplicationInfo.class.getDeclaredField("privateFlags");
                declaredField.setAccessible(true);
                this.hw = ((Integer) declaredField.get(applicationInfo)).intValue();
            }
            return (this.hw & C.ENCODING_PCM_A_LAW) != 0;
        } catch (Throwable th) {
            com.byazt.xk.hw.pr().pr("hasLegacyStorage", th);
            return false;
        }
    }

    @Override // com.byazt.qe.x
    public String k() {
        com.byazt.qe.x xVar = this.pr;
        if (xVar == null) {
            return super.k();
        }
        return xVar.k();
    }

    @Override // com.byazt.qe.x
    public boolean uc() {
        com.byazt.qe.x xVar = this.pr;
        if (xVar == null) {
            return super.uc();
        }
        return xVar.uc();
    }

    @Override // com.byazt.qe.x
    public String ho() {
        com.byazt.qe.x xVar = this.pr;
        if (xVar == null) {
            return super.ho();
        }
        return xVar.ho();
    }

    @Override // com.byazt.qe.x
    public Map<String, Object> nt() {
        com.byazt.qe.x xVar = this.pr;
        if (xVar == null) {
            return super.nt();
        }
        return xVar.nt();
    }

    @Override // com.byazt.qe.x
    public boolean zo() {
        com.byazt.qe.x xVar = this.pr;
        if (xVar == null) {
            return super.zo();
        }
        return xVar.zo();
    }

    @Override // com.byazt.qe.x
    public boolean fw() {
        return false;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        switch (((Integer) sparseArray.get(-99999987)).intValue()) {
            case 262101:
                return Boolean.valueOf(pr());
            case 262102:
                com.byazt.qe.hn hnVarAj = aj();
                if (hnVarAj == null) {
                    return null;
                }
                double dPr = hnVarAj.pr();
                return com.byazt.ij.pr.pr().pr(262001, dPr).pr(262002, hnVarAj.hw()).hw().sparseArray();
            case 262103:
                return Boolean.valueOf(hw());
            case 262104:
                return Boolean.valueOf(hn());
            case 262105:
                return vk();
            case 262106:
                return Boolean.valueOf(x());
            case 262107:
                return w();
            case 262108:
                return Boolean.valueOf(c());
            case 262109:
                return k();
            case 262110:
                return Boolean.valueOf(uc());
            case 262111:
                return Boolean.valueOf(fw());
            case 262112:
                return ho();
            case 262113:
            case 262114:
            case 262115:
            case 262116:
            case 262117:
            case 262118:
            default:
                return null;
            case 262119:
                return nt();
            case 262120:
                return Boolean.valueOf(zo());
        }
    }
}
