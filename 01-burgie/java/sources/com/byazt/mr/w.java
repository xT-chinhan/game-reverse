package com.byazt.mr;

import android.app.Activity;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 25, 109})
public abstract class w extends zo {
    public PluginValueSet pr;

    public abstract int c();

    public abstract com.byazt.wd.hn fw();

    public abstract int hw();

    public abstract void pr(Activity activity);

    public abstract void pr(Activity activity, Object obj, String str);

    public abstract void pr(com.byazt.rf.pr prVar);

    public abstract void pr(com.byazt.rkl.hn hnVar);

    public abstract long uc();

    public abstract Map<String, Object> x();

    public PluginValueSet aj() {
        PluginValueSet pluginValueSet = this.pr;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetPr = pr();
        this.pr = pluginValueSetPr;
        return pluginValueSetPr;
    }

    private PluginValueSet pr() {
        com.byazt.ij.pr prVarPr = com.byazt.ij.pr.pr();
        prVarPr.pr(130001, new Supplier<Integer>() { // from class: com.byazt.mr.w.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(w.this.hw());
            }
        });
        prVarPr.pr(130002, new Supplier<Map<String, Object>>() { // from class: com.byazt.mr.w.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return w.this.x();
            }
        });
        prVarPr.pr(130003, new Supplier<Integer>() { // from class: com.byazt.mr.w.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(w.this.c());
            }
        });
        prVarPr.pr(130004, new Supplier<Long>() { // from class: com.byazt.mr.w.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Long get() {
                return Long.valueOf(w.this.uc());
            }
        });
        return prVarPr.hw();
    }

    @Override // com.byazt.mr.zo, java.util.function.Function
    /* JADX INFO: renamed from: pr */
    public Object apply(SparseArray<Object> sparseArray) {
        com.byazt.rf.pr prVar;
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetHw = com.byazt.ij.pr.pr(sparseArray).hw();
        switch (pluginValueSetHw.intValue(-99999987)) {
            case -99999986:
                return aj().sparseArray();
            case 130101:
                Function function = (Function) pluginValueSetHw.objectValue(0, Function.class);
                if (pluginValueSetHw.intValue(1) == 1) {
                    prVar = new com.byazt.kw.pr(function);
                } else {
                    prVar = new com.byazt.rf.pr(function);
                }
                pr(prVar);
                return null;
            case 130102:
                pr(new com.byazt.rkl.hn((Function) pluginValueSetHw.objectValue(0, Function.class)));
                return null;
            case 130103:
                pr((Activity) pluginValueSetHw.objectValue(0, Activity.class));
                return null;
            case 130104:
                pr((Activity) pluginValueSetHw.objectValue(0, Activity.class), pluginValueSetHw.objectValue(1, Object.class), (String) pluginValueSetHw.objectValue(2, String.class));
                return null;
            case 130106:
                return fw();
            default:
                return super.apply(sparseArray);
        }
    }
}
