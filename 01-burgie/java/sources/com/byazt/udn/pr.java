package com.byazt.udn;

import com.byazt.tuy.uc;
import com.mar.sdk.MARCode;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1254, 37})
public class pr {
    public final Map<String, x> hn;
    public final Map<String, hn> hw;
    public int pr;

    public void pr(String str, hn hnVar) {
        synchronized (this.hw) {
            this.hw.put(str, hnVar);
        }
    }

    public void pr(int i) {
        this.pr = i;
    }

    public hn pr(String str, List<com.byazt.auw.hn> list) {
        hn hnVarRemove;
        synchronized (this.hw) {
            hnVarRemove = this.hw.remove(str);
        }
        if (hnVarRemove != null) {
            if (uc.pr(hnVarRemove.zo(), list)) {
                try {
                    hnVarRemove.x();
                } catch (InterruptedException e) {
                }
                if (hnVarRemove.uc() && hnVarRemove.c()) {
                    return hnVarRemove;
                }
            }
            try {
                hnVarRemove.hn();
                return null;
            } catch (Throwable th) {
                return null;
            }
        }
        return null;
    }

    public boolean pr(String str) {
        hn hnVar = this.hw.get(str);
        if (hnVar == null) {
            return false;
        }
        if (hnVar.fw()) {
            return true;
        }
        return hnVar.uc() && hnVar.c();
    }

    public x hw(String str, List<com.byazt.auw.hn> list) {
        x xVarRemove;
        synchronized (this.hn) {
            xVarRemove = this.hn.remove(str);
        }
        if (xVarRemove != null) {
            if (uc.pr(xVarRemove.uc(), list)) {
                try {
                    xVarRemove.c();
                } catch (InterruptedException e) {
                }
                if (xVarRemove.zo() && xVarRemove.fw()) {
                    return xVarRemove;
                }
            }
            try {
                xVarRemove.x();
                return null;
            } catch (Throwable th) {
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: com.byazt.udn.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 1254, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    private static final class C0205pr {
        public static final pr pr = new pr();
    }

    public static pr pr() {
        return C0205pr.pr;
    }

    private pr() {
        this.hw = new HashMap();
        this.hn = new LinkedHashMap(3);
        this.pr = 3;
    }
}
