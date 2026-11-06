package com.byazt.dx;

/* JADX INFO: loaded from: classes.dex */
public enum a {
    AUTOMATIC,
    HARDWARE,
    SOFTWARE;

    /* JADX INFO: renamed from: com.byazt.dx.a$1, reason: invalid class name */
    @com.byazt.vzx.pr(pr = {0, 1, 229, 425})
    static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] pr;

        static {
            int[] iArr = new int[a.values().length];
            pr = iArr;
            try {
                iArr[a.HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                pr[a.SOFTWARE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                pr[a.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public boolean pr(int i, boolean z, int i2) {
        switch (AnonymousClass1.pr[ordinal()]) {
            case 1:
                return false;
            case 2:
                return true;
            default:
                return (z && i < 28) || i2 > 4 || i <= 25;
        }
    }
}
