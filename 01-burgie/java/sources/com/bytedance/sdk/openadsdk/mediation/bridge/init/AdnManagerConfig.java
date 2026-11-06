package com.bytedance.sdk.openadsdk.mediation.bridge.init;

import android.util.SparseArray;
import com.byazt.dea.uc;
import com.byazt.vzx.pr;
import com.qq.e.comm.constants.ErrorCode;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@pr(pr = {0, 78, 79, 80, 81, 232, 82, 593})
public class AdnManagerConfig {
    private static volatile Function<SparseArray<Object>, Object> c;
    private static volatile Function<SparseArray<Object>, Object> fw;
    private static volatile Function<SparseArray<Object>, Object> hn;
    private static volatile Function<SparseArray<Object>, Object> hw;
    private static volatile Function<SparseArray<Object>, Object> pr;
    private static volatile Function<SparseArray<Object>, Object> uc;
    private static volatile Function<SparseArray<Object>, Object> x;

    public static boolean initAdnManager(String str, String str2) {
        return pr(str, str2);
    }

    public static Function<SparseArray<Object>, Object> getAdapterManager(String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
            case "baidu":
                return pr;
            case "gdt":
                return hw;
            case "ks":
                return hn;
            case "mintegral":
                return x;
            case "sigmob":
                return c;
            case "unity":
                return uc;
            case "xiaomi":
                return fw;
            default:
                return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:11:0x003e  */
    private static boolean pr(String str, String str2) {
        if (str2 == null) {
            return false;
        }
        try {
            Object objNewInstance = Class.forName(str).newInstance();
            if (objNewInstance instanceof Function) {
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(-99999987, Integer.valueOf(ErrorCode.PrivateError.LOAD_TIME_OUT));
                sparseArray.put(-99999985, Object.class);
                Object objApply = ((Function) objNewInstance).apply(sparseArray);
                if (objApply instanceof Function) {
                    Function<SparseArray<Object>, Object> function = (Function) objApply;
                    switch (str2) {
                        case "ks":
                            hn = function;
                            return true;
                        case "gdt":
                            hw = function;
                            return true;
                        case "baidu":
                            pr = function;
                            return true;
                        case "mintegral":
                            x = function;
                            return true;
                        case "sigmob":
                            c = function;
                            return true;
                        case "unity":
                            uc = function;
                            return true;
                        case "xiaomi":
                            fw = function;
                            return true;
                        default:
                            return true;
                    }
                }
            }
        } catch (Throwable th) {
            uc.pr(th);
        }
        return false;
    }
}
