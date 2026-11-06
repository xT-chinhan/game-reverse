package com.byazt.nq;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1068, 19})
public abstract class n implements Function<SparseArray<Object>, Object> {
    public PluginValueSet n;

    public abstract String cp();

    public abstract String cy();

    public abstract String d();

    public abstract String fs();

    public abstract String hd();

    public abstract String k();

    public abstract String l();

    public abstract Map<String, String> n();

    public abstract String oa();

    public abstract String q();

    public abstract String qg();

    public abstract String rv();

    public abstract String s();

    public abstract String sz();

    public abstract String tj();

    public abstract String w();

    public abstract int x();

    public PluginValueSet cd() {
        PluginValueSet pluginValueSet = this.n;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetUm = um();
        this.n = pluginValueSetUm;
        return pluginValueSetUm;
    }

    private PluginValueSet um() {
        com.byazt.qvu.n nVarN = com.byazt.qvu.n.n();
        nVarN.n(271006, new Supplier<Map<String, String>>() { // from class: com.byazt.nq.n.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Map<String, String> get() {
                return n.this.n();
            }
        });
        nVarN.n(271007, new Supplier<String>() { // from class: com.byazt.nq.n.10
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public String get() {
                return n.this.qg();
            }
        });
        nVarN.n(271008, new Supplier<String>() { // from class: com.byazt.nq.n.11
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public String get() {
                return n.this.s();
            }
        });
        nVarN.n(271009, new Supplier<String>() { // from class: com.byazt.nq.n.12
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public String get() {
                return n.this.q();
            }
        });
        nVarN.n(271010, new Supplier<String>() { // from class: com.byazt.nq.n.13
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public String get() {
                return n.this.l();
            }
        });
        nVarN.n(271011, new Supplier<String>() { // from class: com.byazt.nq.n.14
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public String get() {
                return n.this.w();
            }
        });
        nVarN.n(271012, new Supplier<Integer>() { // from class: com.byazt.nq.n.15
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(n.this.x());
            }
        });
        nVarN.n(271013, new Supplier<String>() { // from class: com.byazt.nq.n.16
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public String get() {
                return n.this.fs();
            }
        });
        nVarN.n(271014, new Supplier<String>() { // from class: com.byazt.nq.n.17
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public String get() {
                return n.this.rv();
            }
        });
        nVarN.n(271015, new Supplier<String>() { // from class: com.byazt.nq.n.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public String get() {
                return n.this.tj();
            }
        });
        nVarN.n(271016, new Supplier<String>() { // from class: com.byazt.nq.n.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public String get() {
                return n.this.cp();
            }
        });
        nVarN.n(271017, new Supplier<String>() { // from class: com.byazt.nq.n.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public String get() {
                return n.this.d();
            }
        });
        nVarN.n(271018, new Supplier<String>() { // from class: com.byazt.nq.n.5
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public String get() {
                return n.this.oa();
            }
        });
        nVarN.n(271019, new Supplier<String>() { // from class: com.byazt.nq.n.6
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public String get() {
                return n.this.sz();
            }
        });
        nVarN.n(271020, new Supplier<String>() { // from class: com.byazt.nq.n.7
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public String get() {
                return n.this.k();
            }
        });
        nVarN.n(271051, new Supplier<String>() { // from class: com.byazt.nq.n.8
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public String get() {
                return n.this.cy();
            }
        });
        nVarN.n(271052, new Supplier<String>() { // from class: com.byazt.nq.n.9
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public String get() {
                return n.this.hd();
            }
        });
        return nVarN.qg();
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray != null && com.byazt.qvu.n.n(sparseArray).qg().intValue(-99999987) == -99999986) {
            return cd().sparseArray();
        }
        return null;
    }
}
