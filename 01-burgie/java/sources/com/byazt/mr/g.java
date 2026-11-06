package com.byazt.mr;

import android.app.Activity;
import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 25, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF})
public abstract class g extends zo {
    public PluginValueSet pr;

    public abstract com.byazt.wd.x aj();

    public abstract void c();

    public abstract x hn();

    public abstract int hw();

    public abstract View pr();

    public abstract fw pr(Activity activity);

    public abstract void pr(int i);

    public abstract void pr(Activity activity, com.byazt.rz.pr prVar);

    public abstract void pr(Dialog dialog, Integer[] numArr);

    public abstract void pr(com.byazt.qh.hn hnVar);

    public abstract void pr(com.byazt.qh.hw hwVar);

    public abstract void pr(com.byazt.qh.pr prVar);

    public abstract void pr(com.byazt.rkl.hn hnVar);

    public abstract void pr(String str);

    public abstract void pr(JSONObject jSONObject);

    public abstract void pr(boolean z);

    public abstract void uc();

    public abstract String vk();

    public abstract void w();

    public abstract int x();

    public abstract Map<String, Object> zo();

    public PluginValueSet m() {
        PluginValueSet pluginValueSet = this.pr;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetFw = fw();
        this.pr = pluginValueSetFw;
        return pluginValueSetFw;
    }

    private PluginValueSet fw() {
        com.byazt.ij.pr prVarPr = com.byazt.ij.pr.pr();
        prVarPr.pr(150001, new Supplier<View>() { // from class: com.byazt.mr.g.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public View get() {
                return g.this.pr();
            }
        });
        prVarPr.pr(150002, new Supplier<Integer>() { // from class: com.byazt.mr.g.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(g.this.hw());
            }
        });
        prVarPr.pr(150003, new Supplier<x>() { // from class: com.byazt.mr.g.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public x get() {
                return g.this.hn();
            }
        });
        prVarPr.pr(150004, new Supplier<Integer>() { // from class: com.byazt.mr.g.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(g.this.x());
            }
        });
        prVarPr.pr(150005, new Supplier<Map<String, Object>>() { // from class: com.byazt.mr.g.5
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return g.this.zo();
            }
        });
        return prVarPr.hw();
    }

    @Override // com.byazt.mr.zo, java.util.function.Function
    /* JADX INFO: renamed from: pr */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetHw = com.byazt.ij.pr.pr(sparseArray).hw();
        switch (pluginValueSetHw.intValue(-99999987)) {
            case -99999986:
                return m().sparseArray();
            case 150101:
                pr(new com.byazt.qh.hw((Function) pluginValueSetHw.objectValue(0, Function.class)));
                return null;
            case 150102:
                pr(new com.byazt.qh.pr((Function) pluginValueSetHw.objectValue(0, Function.class)));
                return null;
            case 150103:
                pr(new com.byazt.rkl.hn((Function) pluginValueSetHw.objectValue(0, Function.class)));
                return null;
            case 150104:
                c();
                return null;
            case 150105:
                uc();
                return null;
            case 150106:
                pr((Activity) pluginValueSetHw.objectValue(0, Activity.class), new com.byazt.rz.pr((Function) pluginValueSetHw.objectValue(1, Function.class)));
                return null;
            case 150107:
                Dialog dialog = (Dialog) pluginValueSetHw.objectValue(0, Dialog.class);
                Integer[] numArr = (Integer[]) pluginValueSetHw.arrayValue(1, Integer.class);
                if (numArr == null) {
                    numArr = new Integer[0];
                }
                pr(dialog, numArr);
                return null;
            case 150108:
                return pr((Activity) pluginValueSetHw.objectValue(0, Activity.class));
            case 150109:
                pluginValueSetHw.objectValue(0, Activity.class);
                return null;
            case 150110:
                pr(pluginValueSetHw.intValue(0));
                return null;
            case 150111:
                pr(new com.byazt.qh.hn((Function) pluginValueSetHw.objectValue(0, Function.class)));
                return null;
            case 150112:
                pr(pluginValueSetHw.booleanValue(0));
                return null;
            case 150113:
                return aj();
            case 150114:
                pr((String) pluginValueSetHw.objectValue(0, String.class));
                return null;
            case 150115:
                pr((JSONObject) pluginValueSetHw.objectValue(0, JSONObject.class));
                return null;
            case 150116:
                w();
                return null;
            default:
                return super.apply(sparseArray);
        }
    }
}
