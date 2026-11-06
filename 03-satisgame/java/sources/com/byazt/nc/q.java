package com.byazt.nc;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SIDX_INFOS, 5})
public class q {
    public static Function<SparseArray<Object>, Object> n;

    public static void n(Function<SparseArray<Object>, Object> function) {
        n = function;
    }

    public static String n() {
        Function<SparseArray<Object>, Object> function = n;
        if (function != null) {
            Object objApply = function.apply(com.byazt.of.qg.n().n(AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh1).n(String.class).qg());
            if (objApply instanceof String) {
                return objApply.toString();
            }
        }
        return null;
    }

    public static String qg() {
        Function<SparseArray<Object>, Object> function = n;
        if (function != null) {
            Object objApply = function.apply(com.byazt.of.qg.n().n(AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh2).n(String.class).qg());
            if (objApply instanceof String) {
                return objApply.toString();
            }
        }
        return null;
    }

    public static String s() {
        Function<SparseArray<Object>, Object> function = n;
        if (function != null) {
            Object objApply = function.apply(com.byazt.of.qg.n().n(AVMDLDataLoader.KeyIsStoMaxIdleTimeSec).n(String.class).qg());
            if (objApply instanceof String) {
                return objApply.toString();
            }
        }
        return null;
    }
}
