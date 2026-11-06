package com.bytedance.sdk.openadsdk.mediation.bridge.init;

import android.util.SparseArray;
import com.byazt.cp.n;
import com.byazt.vx.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.comm.constants.ErrorCode;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 55, 56, 57, 58, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FFMPEG_LOG_LEVEL, 59, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_VIDEO_DIFF_THRESHOLD})
public class AdnManagerConfig {
    private static volatile Function<SparseArray<Object>, Object> l;
    private static volatile Function<SparseArray<Object>, Object> n;
    private static volatile Function<SparseArray<Object>, Object> q;
    private static volatile Function<SparseArray<Object>, Object> qg;
    private static volatile Function<SparseArray<Object>, Object> s;
    private static volatile Function<SparseArray<Object>, Object> w;
    private static volatile Function<SparseArray<Object>, Object> x;

    public static boolean initAdnManager(String str, String str2) {
        return n(str, str2);
    }

    public static Function<SparseArray<Object>, Object> getAdapterManager(String str) {
        if (str == null) {
            return null;
        }
        str.hashCode();
        switch (str) {
            case "sigmob":
                return l;
            case "xiaomi":
                return x;
            case "ks":
                return s;
            case "gdt":
                return qg;
            case "baidu":
                return n;
            case "unity":
                return w;
            case "mintegral":
                return q;
            default:
                return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0084  */
    private static boolean n(String str, String str2) {
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
                            s = function;
                            return true;
                        case "gdt":
                            qg = function;
                            return true;
                        case "baidu":
                            n = function;
                            return true;
                        case "mintegral":
                            q = function;
                            return true;
                        case "sigmob":
                            l = function;
                            return true;
                        case "unity":
                            w = function;
                            return true;
                        case "xiaomi":
                            x = function;
                            return true;
                        default:
                            return true;
                    }
                }
            }
        } catch (Throwable th) {
            w.n(th);
        }
        return false;
    }
}
