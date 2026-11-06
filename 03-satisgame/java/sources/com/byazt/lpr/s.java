package com.byazt.lpr;

import android.util.SparseArray;
import com.byazt.tk.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTC;
import com.bytedance.sdk.openadsdk.TTILog;
import com.bytedance.sdk.openadsdk.TTM;
import java.lang.reflect.Method;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SIDX_AUDIO_WINDOW_SIZE, 8})
public class s {

    public interface n {
        void n();

        void n(String str, String str2);

        void n(String str, String str2, Throwable th);

        void n(String str, Throwable th);

        void q(String str, String str2);

        void qg(String str, String str2);

        void s(String str, String str2);
    }

    public static void n(Object obj) {
        try {
            if (!qg(obj)) {
                if (obj != null) {
                    n(null, obj, q(obj), false);
                    return;
                }
                return;
            }
            Function function = (Function) obj;
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, -8999924);
            sparseArray.put(-99999985, Object.class);
            Object objApply = function.apply(sparseArray);
            if (objApply != null) {
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(-99999987, -8999923);
                sparseArray2.put(-99999985, String.class);
                n(function, objApply, (String) function.apply(sparseArray2), true);
            }
        } catch (Throwable th) {
            new StringBuilder("register object  ").append(obj);
            th.getMessage();
        }
    }

    private static String q(Object obj) {
        TTC ttc;
        if (obj == null) {
            return "";
        }
        if (obj instanceof Class) {
            ttc = (TTC) ((Class) obj).getAnnotation(TTC.class);
        } else {
            ttc = (TTC) obj.getClass().getAnnotation(TTC.class);
        }
        return ttc == null ? "" : ttc.value();
    }

    public static boolean qg(Object obj) {
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
        } catch (Exception unused) {
        }
    }

    private static void n(Function<SparseArray<Object>, Object> function, Object obj, String str, boolean z) {
        if (obj == null) {
            return;
        }
        str.hashCode();
        if (str.equals("log")) {
            n(function, obj, z);
        } else if (str.equals("net")) {
            qg(function, obj, z);
        }
        new StringBuilder("register object  ").append(obj);
    }

    private static void n(Function<SparseArray<Object>, Object> function, Object obj, boolean z) {
        try {
            if (z) {
                com.byazt.lq.qg.n((n) new qg(function), true);
            } else if (obj instanceof TTILog) {
                com.byazt.lq.qg.n((n) new qg(obj), true);
            }
        } catch (Throwable unused) {
        }
    }

    private static void qg(Function<SparseArray<Object>, Object> function, Object obj, boolean z) {
        if (k.s()) {
            com.byazt.dh.s sVar = new com.byazt.dh.s();
            com.byazt.dh.s.n = sVar;
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
                            sVar.n(num.intValue(), method);
                        }
                    } else {
                        TTM ttm = (TTM) method.getAnnotation(TTM.class);
                        if (ttm != null) {
                            method.setAccessible(true);
                            sVar.n(ttm.value(), method);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
            sVar.n(obj);
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SIDX_AUDIO_WINDOW_SIZE, 782})
    public static class qg implements n {
        public Object n;
        public Function qg;

        public qg(Object obj) {
            this.n = obj;
        }

        public qg(Function<SparseArray<Object>, Object> function) {
            this.qg = function;
        }

        @Override // com.byazt.lpr.s.n
        public void n(String str, String str2) {
            if (this.qg != null) {
                n(-8999900, str, str2, null);
            }
            Object obj = this.n;
            if (obj != null) {
                ((TTILog) obj).v(str, str2);
            }
        }

        @Override // com.byazt.lpr.s.n
        public void qg(String str, String str2) {
            if (this.qg != null) {
                n(-8999901, str, str2, null);
            }
            Object obj = this.n;
            if (obj != null) {
                ((TTILog) obj).d(str, str2);
            }
        }

        @Override // com.byazt.lpr.s.n
        public void s(String str, String str2) {
            if (this.qg != null) {
                n(-8999902, str, str2, null);
            }
            Object obj = this.n;
            if (obj != null) {
                ((TTILog) obj).i(str, str2);
            }
        }

        @Override // com.byazt.lpr.s.n
        public void q(String str, String str2) {
            if (this.qg != null) {
                n(-8999905, str, str2, null);
            }
            Object obj = this.n;
            if (obj != null) {
                ((TTILog) obj).e(str, str2);
            }
        }

        @Override // com.byazt.lpr.s.n
        public void n(String str, String str2, Throwable th) {
            if (this.qg != null) {
                n(-8999905, str, str2, th);
            }
            Object obj = this.n;
            if (obj != null) {
                ((TTILog) obj).e(str, str2, th);
            }
        }

        @Override // com.byazt.lpr.s.n
        public void n(String str, Throwable th) {
            if (this.qg != null) {
                n(-8999905, str, null, th);
            }
            Object obj = this.n;
            if (obj != null) {
                ((TTILog) obj).e(str, th);
            }
        }

        @Override // com.byazt.lpr.s.n
        public void n() {
            if (this.qg != null) {
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(-99999987, -8999907);
                sparseArray.put(-99999985, Void.class);
                this.qg.apply(sparseArray);
            }
            Object obj = this.n;
            if (obj != null) {
                ((TTILog) obj).flush();
            }
        }

        private void n(int i, String str, String str2, Throwable th) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, Integer.valueOf(i));
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(-8999920, str);
            sparseArray.put(-8999921, str2);
            sparseArray.put(-8999922, th);
            this.qg.apply(sparseArray);
        }
    }

    public static void s(Object obj) {
        String strQ = "";
        try {
            if (qg(obj)) {
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(-99999987, -8999923);
                sparseArray.put(-99999985, String.class);
                strQ = (String) ((Function) obj).apply(sparseArray);
            } else {
                TTC ttc = (TTC) obj.getClass().getAnnotation(TTC.class);
                if (ttc != null) {
                    strQ = q(ttc);
                }
            }
        } catch (Throwable unused) {
        }
        strQ.hashCode();
        if (strQ.equals("net")) {
            com.byazt.dh.s.n = null;
        }
    }

    public static com.byazt.dh.qg n(String str) {
        str.hashCode();
        if (str.equals("net")) {
            return com.byazt.dh.s.n;
        }
        return null;
    }
}
