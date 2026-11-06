package com.bytedance.sdk.openadsdk.core.ka.d;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.nw.x;
import com.kwad.components.offline.api.explore.model.ExploreConstants;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class ka {
    private static final Map<String, AtomicBoolean> ah = new ConcurrentHashMap();

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    ms f2778ms;
    private final com.bytedance.sdk.openadsdk.core.ka.d.ms xr;

    public ka(int i) {
        this.f2778ms = ms(i);
        if (AnonymousClass1.f2779ms[this.f2778ms.ka.ordinal()] == 1) {
            this.xr = new ah();
        } else {
            this.xr = new com.bytedance.sdk.openadsdk.core.ka.d.xr();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.ka.d.ka$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        static final /* synthetic */ int[] f2779ms;

        static {
            int[] iArr = new int[ms.ah.values().length];
            f2779ms = iArr;
            try {
                iArr[ms.ah.KV.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2779ms[ms.ah.DB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public void ms(String str, xr xrVar, boolean z, long j) {
        try {
            this.xr.ms(str, xrVar, z, j, this.f2778ms);
        } catch (Throwable unused) {
        }
    }

    public xr ms(String str, boolean z, long j) {
        xr xrVarMs;
        try {
            synchronized (d(str)) {
                System.currentTimeMillis();
                xrVarMs = this.xr.ms(str, this.f2778ms, j);
                if (xrVarMs != null && xrVarMs.ms()) {
                    if (z) {
                        this.xr.ms(str, xrVarMs.ka, true);
                    }
                    System.currentTimeMillis();
                }
            }
            return xrVarMs;
        } catch (Throwable unused) {
            return null;
        }
    }

    public xr ms(String str, List<String> list) {
        xr xrVarMs;
        try {
            synchronized (d(str)) {
                System.currentTimeMillis();
                xrVarMs = this.xr.ms(str, this.f2778ms, 0L, list);
                if (xrVarMs != null && xrVarMs.ms()) {
                    System.currentTimeMillis();
                }
            }
            return xrVarMs;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void ms() {
        try {
            this.xr.ms(this.f2778ms);
        } catch (Throwable unused) {
        }
    }

    public void ms(String str) {
        try {
            this.xr.ms(str);
        } catch (Throwable unused) {
        }
    }

    public void xr(String str) {
        try {
            this.xr.ms(str, this.f2778ms);
        } catch (Throwable unused) {
        }
    }

    public void ah(String str) {
        try {
            if (d(str).compareAndSet(false, true)) {
                this.xr.xr(str);
            }
        } catch (Throwable unused) {
        }
    }

    public void ms(String str, String str2, boolean z) {
        try {
            synchronized (d(str)) {
                this.xr.ms(str, str2, z);
            }
        } catch (Throwable unused) {
        }
    }

    public void ms(String str, String str2) {
        try {
            synchronized (d(str)) {
                this.xr.ms(str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static class xr {
        public String ah;
        public int d = 6923;
        public String ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public long f2784ms;
        public long xr;

        public xr(String str, long j, long j2, String str2) {
            this.f2784ms = j;
            this.xr = j2;
            this.ah = str;
            this.ka = str2;
        }

        public boolean ms() {
            return (TextUtils.isEmpty(this.ah) || this.f2784ms == 0) ? false : true;
        }
    }

    public static class ms {
        private final boolean ah;
        private final xr c;
        private final int d;
        private final ah ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final String f2780ms;
        private final int xr;

        /* synthetic */ ms(C0294ms c0294ms, AnonymousClass1 anonymousClass1) {
            this(c0294ms);
        }

        public enum ah {
            KV,
            DB;

            public static ah ms(int i) {
                if (i == 1) {
                    return KV;
                }
                return DB;
            }
        }

        public enum xr {
            Random,
            TimeLast,
            CustomPriority;

            public static xr ms(int i) {
                if (i == 0) {
                    return Random;
                }
                if (i == 2) {
                    return CustomPriority;
                }
                return TimeLast;
            }
        }

        private ms(C0294ms c0294ms) {
            this.f2780ms = c0294ms.f2782ms;
            this.xr = c0294ms.xr;
            this.ah = c0294ms.ah;
            this.ka = c0294ms.ka;
            this.c = c0294ms.c;
            this.d = c0294ms.d;
        }

        public String ms() {
            return this.f2780ms;
        }

        public boolean xr() {
            return this.ah;
        }

        public int ah() {
            return this.d;
        }

        public xr d() {
            return this.c;
        }

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.ka.d.ka$ms$ms, reason: collision with other inner class name */
        public static class C0294ms {
            private int xr;

            /* JADX INFO: renamed from: ms, reason: collision with root package name */
            private String f2782ms = "Default";
            private boolean ah = true;
            private int d = 1;
            private ah ka = ah.DB;
            private xr c = xr.TimeLast;

            public C0294ms ms(String str) {
                this.f2782ms = str;
                return this;
            }

            public C0294ms ms(boolean z) {
                this.ah = z;
                return this;
            }

            public C0294ms ms(ah ahVar) {
                this.ka = ahVar;
                return this;
            }

            public C0294ms ms(xr xrVar) {
                this.c = xrVar;
                return this;
            }

            public C0294ms ms(int i) {
                this.d = i;
                return this;
            }

            public ms ms() {
                return new ms(this, null);
            }
        }
    }

    private ms ms(int i) {
        x.ms msVarAh;
        String str;
        if (i == 3 || i == 4) {
            msVarAh = x.ah();
            str = "Splash";
        } else if (i == 7) {
            msVarAh = x.ms();
            str = ExploreConstants.SCENE_REWARD;
        } else if (i != 8) {
            msVarAh = null;
            str = null;
        } else {
            msVarAh = x.xr();
            str = ExploreConstants.SCENE_FULL;
        }
        if (msVarAh == null) {
            return new ms.C0294ms().ms();
        }
        return new ms.C0294ms().ms(str).ms((i == 3 || i == 4) ? false : true).ms(ms.ah.ms(msVarAh.ka())).ms(ms.xr.ms(msVarAh.xr())).ms(msVarAh.ah()).ms();
    }

    private AtomicBoolean d(String str) {
        Map<String, AtomicBoolean> map = ah;
        if (!map.containsKey(str)) {
            map.put(str, new AtomicBoolean(false));
        }
        return map.get(str);
    }
}
