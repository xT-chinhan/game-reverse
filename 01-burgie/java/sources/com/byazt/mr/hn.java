package com.byazt.mr;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 25, 20})
public abstract class hn implements Function<SparseArray<Object>, Object> {
    public PluginValueSet pr;

    public abstract String aj();

    public abstract Map<String, String> c();

    public abstract String fw();

    public abstract String hn();

    public abstract String hw();

    public abstract String pr();

    public abstract String uc();

    public abstract String x();

    public abstract String zo();

    public PluginValueSet vk() {
        PluginValueSet pluginValueSet = this.pr;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetW = w();
        this.pr = pluginValueSetW;
        return pluginValueSetW;
    }

    private PluginValueSet w() {
        com.byazt.ij.pr prVarPr = com.byazt.ij.pr.pr();
        prVarPr.pr(250001, new Supplier<String>() { // from class: com.byazt.mr.hn.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public String get() {
                return hn.this.pr();
            }
        });
        prVarPr.pr(250002, new Supplier<String>() { // from class: com.byazt.mr.hn.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public String get() {
                return hn.this.hw();
            }
        });
        prVarPr.pr(250003, new Supplier<String>() { // from class: com.byazt.mr.hn.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public String get() {
                return hn.this.hn();
            }
        });
        prVarPr.pr(250004, new Supplier<String>() { // from class: com.byazt.mr.hn.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public String get() {
                return hn.this.x();
            }
        });
        prVarPr.pr(250006, new Supplier<Map<String, String>>() { // from class: com.byazt.mr.hn.5
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Map<String, String> get() {
                return hn.this.c();
            }
        });
        prVarPr.pr(250005, new Supplier<String>() { // from class: com.byazt.mr.hn.6
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public String get() {
                return hn.this.uc();
            }
        });
        prVarPr.pr(250007, new Supplier<String>() { // from class: com.byazt.mr.hn.7
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public String get() {
                return hn.this.fw();
            }
        });
        prVarPr.pr(250008, new Supplier<String>() { // from class: com.byazt.mr.hn.8
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public String get() {
                return hn.this.zo();
            }
        });
        prVarPr.pr(250009, new Supplier<String>() { // from class: com.byazt.mr.hn.9
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public String get() {
                return hn.this.aj();
            }
        });
        return prVarPr.hw();
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetHw = com.byazt.ij.pr.pr(sparseArray).hw();
        int iIntValue = pluginValueSetHw.intValue(-99999987);
        pluginValueSetHw.objectValue(-99999985, Class.class);
        switch (iIntValue) {
            case -99999986:
                return vk().sparseArray();
            default:
                return null;
        }
    }
}
