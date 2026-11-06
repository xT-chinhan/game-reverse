package com.byazt.qam;

import com.byazt.sd.lb;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1745, 5})
public abstract class uc {
    public static final String pr = uc.class.getSimpleName();
    public final Set<String> hw = new HashSet(1);

    public abstract void pr();

    public abstract void pr(String str);

    public synchronized boolean hw(String str) {
        return true;
    }

    public final synchronized boolean pr(String str, int i) {
        try {
            if (i == 0) {
                return pr(str, x.GRANTED);
            }
            return pr(str, x.DENIED);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.byazt.qam.uc$5, reason: invalid class name */
    @com.byazt.vzx.pr(pr = {0, 1, 1745, 73})
    static /* synthetic */ class AnonymousClass5 {
        public static final /* synthetic */ int[] pr;

        static {
            int[] iArr = new int[x.values().length];
            pr = iArr;
            try {
                iArr[x.GRANTED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                pr[x.DENIED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                pr[x.NOT_FOUND.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public final synchronized boolean pr(final String str, x xVar) {
        this.hw.remove(str);
        switch (AnonymousClass5.pr[xVar.ordinal()]) {
            case 1:
                if (this.hw.isEmpty()) {
                    lb.uc().post(new Runnable() { // from class: com.byazt.qam.uc.1
                        @Override // java.lang.Runnable
                        public void run() {
                            uc.this.pr();
                        }
                    });
                    return true;
                }
                break;
            case 2:
                lb.uc().post(new Runnable() { // from class: com.byazt.qam.uc.2
                    @Override // java.lang.Runnable
                    public void run() {
                        uc.this.pr(str);
                    }
                });
                return true;
            case 3:
                if (hw(str)) {
                    if (this.hw.isEmpty()) {
                        lb.uc().post(new Runnable() { // from class: com.byazt.qam.uc.3
                            @Override // java.lang.Runnable
                            public void run() {
                                uc.this.pr();
                            }
                        });
                        return true;
                    }
                } else {
                    lb.uc().post(new Runnable() { // from class: com.byazt.qam.uc.4
                        @Override // java.lang.Runnable
                        public void run() {
                            uc.this.pr(str);
                        }
                    });
                    return true;
                }
        }
        return false;
    }

    public final synchronized void pr(String[] strArr) {
        Collections.addAll(this.hw, strArr);
    }
}
