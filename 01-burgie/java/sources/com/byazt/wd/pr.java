package com.byazt.wd;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AE_SRC_PEAK, 37})
public abstract class pr implements Function<SparseArray<Object>, Object> {
    public PluginValueSet pr;

    public abstract String aj();

    public abstract String c();

    public abstract int fw();

    public abstract String g();

    public abstract String hn();

    public abstract String ho();

    public abstract String hw();

    public abstract String k();

    public abstract String m();

    public abstract String nt();

    public abstract Map<String, String> pr();

    public abstract String uc();

    public abstract String vk();

    public abstract String w();

    public abstract String x();

    public abstract String yb();

    public abstract String zo();

    public PluginValueSet lb() {
        PluginValueSet pluginValueSet = this.pr;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetQa = qa();
        this.pr = pluginValueSetQa;
        return pluginValueSetQa;
    }

    private PluginValueSet qa() {
        com.byazt.ij.pr prVarPr = com.byazt.ij.pr.pr();
        prVarPr.pr(271006, new Supplier<Map<String, String>>() { // from class: com.byazt.wd.pr.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Map<String, String> get() {
                return pr.this.pr();
            }
        });
        prVarPr.pr(271007, new Supplier<String>() { // from class: com.byazt.wd.pr.10
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public String get() {
                return pr.this.hw();
            }
        });
        prVarPr.pr(271008, new Supplier<String>() { // from class: com.byazt.wd.pr.11
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public String get() {
                return pr.this.hn();
            }
        });
        prVarPr.pr(271009, new Supplier<String>() { // from class: com.byazt.wd.pr.12
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public String get() {
                return pr.this.x();
            }
        });
        prVarPr.pr(271010, new Supplier<String>() { // from class: com.byazt.wd.pr.13
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public String get() {
                return pr.this.c();
            }
        });
        prVarPr.pr(271011, new Supplier<String>() { // from class: com.byazt.wd.pr.14
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public String get() {
                return pr.this.uc();
            }
        });
        prVarPr.pr(271012, new Supplier<Integer>() { // from class: com.byazt.wd.pr.15
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(pr.this.fw());
            }
        });
        prVarPr.pr(271013, new Supplier<String>() { // from class: com.byazt.wd.pr.16
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public String get() {
                return pr.this.zo();
            }
        });
        prVarPr.pr(271014, new Supplier<String>() { // from class: com.byazt.wd.pr.17
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public String get() {
                return pr.this.aj();
            }
        });
        prVarPr.pr(271015, new Supplier<String>() { // from class: com.byazt.wd.pr.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public String get() {
                return pr.this.vk();
            }
        });
        prVarPr.pr(271016, new Supplier<String>() { // from class: com.byazt.wd.pr.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public String get() {
                return pr.this.w();
            }
        });
        prVarPr.pr(271017, new Supplier<String>() { // from class: com.byazt.wd.pr.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public String get() {
                return pr.this.k();
            }
        });
        prVarPr.pr(271018, new Supplier<String>() { // from class: com.byazt.wd.pr.5
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public String get() {
                return pr.this.m();
            }
        });
        prVarPr.pr(271019, new Supplier<String>() { // from class: com.byazt.wd.pr.6
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public String get() {
                return pr.this.g();
            }
        });
        prVarPr.pr(271020, new Supplier<String>() { // from class: com.byazt.wd.pr.7
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public String get() {
                return pr.this.ho();
            }
        });
        prVarPr.pr(271051, new Supplier<String>() { // from class: com.byazt.wd.pr.8
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public String get() {
                return pr.this.nt();
            }
        });
        prVarPr.pr(271052, new Supplier<String>() { // from class: com.byazt.wd.pr.9
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public String get() {
                return pr.this.yb();
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
        switch (com.byazt.ij.pr.pr(sparseArray).hw().intValue(-99999987)) {
            case -99999986:
                return lb().sparseArray();
            default:
                return null;
        }
    }
}
