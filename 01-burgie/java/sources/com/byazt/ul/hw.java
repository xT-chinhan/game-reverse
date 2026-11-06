package com.byazt.ul;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTC;
import com.bytedance.sdk.openadsdk.TTILog;
import com.bytedance.sdk.openadsdk.TTM;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1847, 13})
public class hw extends com.byazt.f.pr {
    public Object hw;
    public TTILog pr;

    public hw(Object obj) {
        if (obj instanceof TTILog) {
            this.pr = (TTILog) obj;
        }
        this.hw = obj;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:49:0x00a8 A[RETURN] */
    @Override // com.byazt.f.pr
    public <T> T applyFunction(int i, ValueSet valueSet, Class<T> cls) {
        String strStringValue = valueSet.stringValue(-8999920, "");
        String strStringValue2 = valueSet.stringValue(-8999921, "");
        Throwable th = (Throwable) valueSet.objectValue(-8999922, Throwable.class);
        switch (i) {
            case -8999924:
                T t = (T) this.hw;
                if (t == null) {
                    return null;
                }
                return t;
            case -8999923:
                Object obj = this.hw;
                if (obj != null) {
                    T t2 = (T) hw(obj);
                    if (cls.isInstance(t2)) {
                        return t2;
                    }
                    return null;
                }
                return null;
            case -8999909:
                TTM ttm = (TTM) ((Method) valueSet.objectValue(-8999925, Method.class)).getAnnotation(TTM.class);
                T t3 = ttm == null ? null : (T) Integer.valueOf(ttm.value());
                if (cls.isInstance(t3)) {
                    return t3;
                }
                return null;
            case -8999908:
                TTILog tTILog = this.pr;
                if (tTILog != null) {
                    tTILog.forceLogSharding();
                }
                return null;
            case -8999907:
                TTILog tTILog2 = this.pr;
                if (tTILog2 != null) {
                    tTILog2.flush();
                }
                return null;
            case -8999906:
                TTILog tTILog3 = this.pr;
                if (tTILog3 != null) {
                    tTILog3.e(strStringValue, strStringValue2, th);
                }
                return null;
            case -8999905:
                TTILog tTILog4 = this.pr;
                if (tTILog4 != null) {
                    tTILog4.e(strStringValue, strStringValue2);
                }
                return null;
            case -8999904:
                TTILog tTILog5 = this.pr;
                if (tTILog5 != null) {
                    tTILog5.w(strStringValue, strStringValue2, th);
                }
                return null;
            case -8999903:
                TTILog tTILog6 = this.pr;
                if (tTILog6 != null) {
                    tTILog6.w(strStringValue, strStringValue2);
                }
                return null;
            case -8999902:
                TTILog tTILog7 = this.pr;
                if (tTILog7 != null) {
                    tTILog7.i(strStringValue, strStringValue2);
                }
                return null;
            case -8999901:
                TTILog tTILog8 = this.pr;
                if (tTILog8 != null) {
                    tTILog8.d(strStringValue, strStringValue2);
                }
                return null;
            case -8999900:
                TTILog tTILog9 = this.pr;
                if (tTILog9 != null) {
                    tTILog9.v(strStringValue, strStringValue2);
                }
                return null;
            default:
                return null;
        }
    }

    @Override // com.byazt.f.pr
    public SparseArray<Object> get() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999978, Boolean.TRUE);
        return sparseArray;
    }

    private static String hw(Object obj) {
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

    public static boolean pr(Object obj) {
        if (obj != null) {
            try {
                return ((TTC) obj.getClass().getAnnotation(TTC.class)) != null;
            } catch (Exception e) {
            }
        }
        return false;
    }
}
