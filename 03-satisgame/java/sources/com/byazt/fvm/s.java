package com.byazt.fvm;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 464, 8})
public abstract class s implements Function<SparseArray<Object>, Object> {
    public PluginValueSet n;

    public abstract String fs();

    public abstract Map<String, String> l();

    public abstract String n();

    public abstract String q();

    public abstract String qg();

    public abstract String rv();

    public abstract String s();

    public abstract String w();

    public abstract String x();

    public PluginValueSet tj() {
        PluginValueSet pluginValueSet = this.n;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetCp = cp();
        this.n = pluginValueSetCp;
        return pluginValueSetCp;
    }

    private PluginValueSet cp() {
        com.byazt.qvu.n nVarN = com.byazt.qvu.n.n();
        nVarN.n(250001, new Supplier<String>() { // from class: com.byazt.fvm.s.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public String get() {
                return s.this.n();
            }
        });
        nVarN.n(250002, new Supplier<String>() { // from class: com.byazt.fvm.s.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public String get() {
                return s.this.qg();
            }
        });
        nVarN.n(250003, new Supplier<String>() { // from class: com.byazt.fvm.s.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public String get() {
                return s.this.s();
            }
        });
        nVarN.n(250004, new Supplier<String>() { // from class: com.byazt.fvm.s.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public String get() {
                return s.this.q();
            }
        });
        nVarN.n(250006, new Supplier<Map<String, String>>() { // from class: com.byazt.fvm.s.5
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Map<String, String> get() {
                return s.this.l();
            }
        });
        nVarN.n(250005, new Supplier<String>() { // from class: com.byazt.fvm.s.6
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public String get() {
                return s.this.w();
            }
        });
        nVarN.n(250007, new Supplier<String>() { // from class: com.byazt.fvm.s.7
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public String get() {
                return s.this.x();
            }
        });
        nVarN.n(250008, new Supplier<String>() { // from class: com.byazt.fvm.s.8
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public String get() {
                return s.this.rv();
            }
        });
        nVarN.n(250009, new Supplier<String>() { // from class: com.byazt.fvm.s.9
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public String get() {
                return s.this.fs();
            }
        });
        return nVarN.qg();
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetQg = com.byazt.qvu.n.n(sparseArray).qg();
        int iIntValue = pluginValueSetQg.intValue(-99999987);
        pluginValueSetQg.objectValue(-99999985, Class.class);
        if (iIntValue != -99999986) {
            return null;
        }
        return tj().sparseArray();
    }
}
