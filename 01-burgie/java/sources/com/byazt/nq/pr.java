package com.byazt.nq;

import android.util.SparseArray;
import com.byazt.ca.ho;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTC;
import com.bytedance.sdk.openadsdk.TTILog;
import com.bytedance.sdk.openadsdk.TTM;
import java.lang.reflect.Method;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1373, 37})
public class pr {

    /* JADX INFO: renamed from: com.byazt.nq.pr$pr, reason: collision with other inner class name */
    public interface InterfaceC0144pr {
        void hn(String str, String str2);

        void hw(String str, String str2);

        void pr();

        void pr(String str, String str2);

        void pr(String str, String str2, Throwable th);

        void pr(String str, Throwable th);

        void x(String str, String str2);
    }

    public static void pr(Object obj) {
        try {
            if (hw(obj)) {
                Function function = (Function) obj;
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(-99999987, -8999924);
                sparseArray.put(-99999985, Object.class);
                Object objApply = function.apply(sparseArray);
                if (objApply != null) {
                    SparseArray sparseArray2 = new SparseArray();
                    sparseArray2.put(-99999987, -8999923);
                    sparseArray2.put(-99999985, String.class);
                    pr(function, objApply, (String) function.apply(sparseArray2), true);
                    return;
                }
                return;
            }
            if (obj != null) {
                pr(null, obj, x(obj), false);
            }
        } catch (Throwable th) {
            new StringBuilder("register object  ").append(obj).append(" failed for: ").append(th.getMessage());
        }
    }

    private static String x(Object obj) {
        TTC ttc;
        if (obj == null) {
            return "";
        }
        if (obj instanceof Class) {
            ttc = (TTC) ((Class) obj).getAnnotation(TTC.class);
        } else {
            ttc = (TTC) obj.getClass().getAnnotation(TTC.class);
        }
        if (ttc == null) {
            return "";
        }
        return ttc.value();
    }

    public static boolean hw(Object obj) {
        Boolean bool;
        if (obj == null || !(obj instanceof Function)) {
            return false;
        }
        try {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, -99999986);
            sparseArray.put(-99999985, SparseArray.class);
            SparseArray sparseArray2 = (SparseArray) ((Function) obj).apply(sparseArray);
            return (sparseArray2 == null || (bool = (Boolean) sparseArray2.get(-99999978)) == null || !bool.booleanValue()) ? false : true;
        } catch (Exception e) {
        }
        return false;
    }

    private static void pr(Function<SparseArray<Object>, Object> function, Object obj, String str, boolean z) {
        if (obj == null) {
            return;
        }
        switch (str) {
            case "net":
                hw(function, obj, z);
                break;
            case "log":
                pr(function, obj, z);
                break;
        }
        new StringBuilder("register object  ").append(obj).append(" successed~ ");
    }

    private static void pr(Function<SparseArray<Object>, Object> function, Object obj, boolean z) {
        try {
            if (z) {
                com.byazt.hs.hw.pr((InterfaceC0144pr) new hw(function), true);
            } else if (obj instanceof TTILog) {
                com.byazt.hs.hw.pr((InterfaceC0144pr) new hw(obj), true);
            }
        } catch (Throwable th) {
        }
    }

    private static void hw(Function<SparseArray<Object>, Object> function, Object obj, boolean z) {
        if (!ho.hn()) {
            return;
        }
        com.byazt.jys.hn hnVar = new com.byazt.jys.hn();
        com.byazt.jys.hn.pr = hnVar;
        try {
            for (Method method : obj.getClass().getDeclaredMethods()) {
                if (z) {
                    SparseArray<Object> sparseArray = new SparseArray<>();
                    sparseArray.put(-99999987, -8999909);
                    sparseArray.put(-99999985, Integer.class);
                    sparseArray.put(-8999925, method);
                    Integer num = (Integer) function.apply(sparseArray);
                    if (num != null) {
                        method.setAccessible(true);
                        hnVar.pr(num.intValue(), method);
                    }
                } else {
                    TTM ttm = (TTM) method.getAnnotation(TTM.class);
                    if (ttm != null) {
                        method.setAccessible(true);
                        hnVar.pr(ttm.value(), method);
                    }
                }
            }
        } catch (Throwable th) {
        }
        hnVar.pr(obj);
    }

    @com.byazt.vzx.pr(pr = {0, 1, 1373, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE})
    public static class hw implements InterfaceC0144pr {
        public Function hw;
        public Object pr;

        public hw(Object obj) {
            this.pr = obj;
        }

        public hw(Function<SparseArray<Object>, Object> function) {
            this.hw = function;
        }

        @Override // com.byazt.nq.pr.InterfaceC0144pr
        public void pr(String str, String str2) {
            if (this.hw != null) {
                pr(-8999900, str, str2, null);
            }
            Object obj = this.pr;
            if (obj != null) {
                ((TTILog) obj).v(str, str2);
            }
        }

        @Override // com.byazt.nq.pr.InterfaceC0144pr
        public void hw(String str, String str2) {
            if (this.hw != null) {
                pr(-8999901, str, str2, null);
            }
            Object obj = this.pr;
            if (obj != null) {
                ((TTILog) obj).d(str, str2);
            }
        }

        @Override // com.byazt.nq.pr.InterfaceC0144pr
        public void hn(String str, String str2) {
            if (this.hw != null) {
                pr(-8999902, str, str2, null);
            }
            Object obj = this.pr;
            if (obj != null) {
                ((TTILog) obj).i(str, str2);
            }
        }

        @Override // com.byazt.nq.pr.InterfaceC0144pr
        public void x(String str, String str2) {
            if (this.hw != null) {
                pr(-8999905, str, str2, null);
            }
            Object obj = this.pr;
            if (obj != null) {
                ((TTILog) obj).e(str, str2);
            }
        }

        @Override // com.byazt.nq.pr.InterfaceC0144pr
        public void pr(String str, String str2, Throwable th) {
            if (this.hw != null) {
                pr(-8999905, str, str2, th);
            }
            Object obj = this.pr;
            if (obj != null) {
                ((TTILog) obj).e(str, str2, th);
            }
        }

        @Override // com.byazt.nq.pr.InterfaceC0144pr
        public void pr(String str, Throwable th) {
            if (this.hw != null) {
                pr(-8999905, str, null, th);
            }
            Object obj = this.pr;
            if (obj != null) {
                ((TTILog) obj).e(str, th);
            }
        }

        @Override // com.byazt.nq.pr.InterfaceC0144pr
        public void pr() {
            if (this.hw != null) {
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(-99999987, -8999907);
                sparseArray.put(-99999985, Void.class);
                this.hw.apply(sparseArray);
            }
            Object obj = this.pr;
            if (obj != null) {
                ((TTILog) obj).flush();
            }
        }

        private void pr(int i, String str, String str2, Throwable th) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, Integer.valueOf(i));
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(-8999920, str);
            sparseArray.put(-8999921, str2);
            sparseArray.put(-8999922, th);
            this.hw.apply(sparseArray);
        }
    }

    public static void hn(Object obj) {
        String strX = "";
        try {
            if (hw(obj)) {
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(-99999987, -8999923);
                sparseArray.put(-99999985, String.class);
                strX = (String) ((Function) obj).apply(sparseArray);
            } else {
                TTC ttc = (TTC) obj.getClass().getAnnotation(TTC.class);
                if (ttc != null) {
                    strX = x(ttc);
                }
            }
        } catch (Throwable th) {
        }
        switch (strX) {
            case "net":
                com.byazt.jys.hn.pr = null;
                break;
        }
    }

    public static com.byazt.jys.hw pr(String str) {
        switch (str) {
            case "net":
                return com.byazt.jys.hn.pr;
            default:
                return null;
        }
    }
}
