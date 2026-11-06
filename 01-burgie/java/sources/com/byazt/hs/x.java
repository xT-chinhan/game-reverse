package com.byazt.hs;

import android.util.SparseArray;
import com.byazt.sd.a;
import com.byazt.sd.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_SDK_DNS_IP, 121})
public class x implements Function<SparseArray<Object>, Object> {
    public static volatile x pr = null;

    private x() {
    }

    public static x pr() {
        if (pr == null) {
            pr = new x();
        }
        return pr;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        PluginValueSet pluginValueSetHw = com.byazt.ij.pr.pr(sparseArray).hw();
        int iIntValue = pluginValueSetHw.intValue(-99999987);
        if (iIntValue == 10001) {
            zo.nt().aj(pluginValueSetHw.booleanValue(1));
        } else {
            if (iIntValue == 10002) {
                return Boolean.valueOf(zo.nt().od());
            }
            if (iIntValue == 10003) {
                a.pr().pr((Function<SparseArray<Object>, Object>) pluginValueSetHw.objectValue(0, Function.class));
            } else if (iIntValue == 10004) {
                Function<SparseArray<Object>, Object> function = (Function) pluginValueSetHw.objectValue(0, Function.class);
                String str = (String) pluginValueSetHw.objectValue(1, String.class);
                String str2 = (String) pluginValueSetHw.objectValue(2, String.class);
                String str3 = (String) pluginValueSetHw.objectValue(3, String.class);
                String str4 = (String) pluginValueSetHw.objectValue(4, String.class);
                HashMap map = new HashMap();
                map.put("adtype", str2);
                map.put("rit", str);
                map.put("image_mode", str3);
                map.put("preview_extra", str4);
                a.pr().pr(map, function);
            } else {
                if (iIntValue == 10005) {
                    com.byazt.ij.pr prVarPr = com.byazt.ij.pr.pr();
                    prVarPr.pr(0, zo.nt().mw());
                    prVarPr.pr(1, zo.nt().sv());
                    prVarPr.pr(2, zo.nt().gu());
                    prVarPr.pr(3, zo.nt().d());
                    prVarPr.pr(4, zo.nt().pq());
                    return prVarPr.hw().sparseArray();
                }
                if (iIntValue == 10006) {
                    a.pr().pr((Map<String, Object>) pluginValueSetHw.objectValue(0, Map.class), (Function<SparseArray<Object>, Object>) pluginValueSetHw.objectValue(1, Function.class));
                } else if (iIntValue == 10007) {
                    zo.nt().pr((zo.hn) null);
                } else if (iIntValue == 10008) {
                    return Boolean.valueOf(zo.nt().v());
                }
            }
        }
        return null;
    }
}
