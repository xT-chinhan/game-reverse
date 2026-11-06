package com.byazt.mr;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 25, 108})
public abstract class m extends zo {
    public PluginValueSet pr;

    public abstract int a();

    public abstract Bitmap aj();

    public abstract int cz();

    public abstract Map<String, Object> g();

    public abstract String h_();

    public abstract void hn();

    public abstract int ho();

    public abstract com.byazt.wd.x hw();

    public abstract void hw(Activity activity);

    public abstract void hw(Dialog dialog, Integer[] numArr);

    public abstract String i_();

    public abstract k lb();

    public abstract int m();

    public abstract hn nl();

    public abstract int nt();

    public abstract x ny();

    public abstract View pr();

    public abstract fw pr(Activity activity);

    public abstract fw pr(Dialog dialog, Integer[] numArr);

    public abstract void pr(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.byazt.ti.pr prVar, com.byazt.mt.pr prVar2);

    public abstract void pr(Activity activity, com.byazt.rz.pr prVar);

    public abstract void pr(ViewGroup viewGroup, View view, com.byazt.ti.pr prVar);

    public abstract void pr(ViewGroup viewGroup, List<View> list, List<View> list2, View view, com.byazt.ti.pr prVar);

    public abstract void pr(ViewGroup viewGroup, List<View> list, List<View> list2, com.byazt.ti.pr prVar);

    public abstract void pr(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, com.byazt.ti.pr prVar);

    public abstract void pr(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view, com.byazt.ti.pr prVar);

    public abstract void pr(com.byazt.rkl.hn hnVar);

    public abstract void pr(com.byazt.ti.hn hnVar);

    public abstract void pr(com.byazt.ti.hw hwVar);

    public abstract void pr(String str);

    public abstract List<k> qa();

    public abstract k r_();

    public abstract c rc();

    public abstract String vk();

    public abstract String x();

    public abstract String yb();

    public abstract void z();

    public PluginValueSet s_() {
        PluginValueSet pluginValueSet = this.pr;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetC = c();
        this.pr = pluginValueSetC;
        return pluginValueSetC;
    }

    private PluginValueSet c() {
        com.byazt.ij.pr prVarPr = com.byazt.ij.pr.pr();
        prVarPr.pr(140001, new Supplier<k>() { // from class: com.byazt.mr.m.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public k get() {
                return m.this.r_();
            }
        });
        prVarPr.pr(140002, new Supplier<Bitmap>() { // from class: com.byazt.mr.m.11
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Bitmap get() {
                return m.this.aj();
            }
        });
        prVarPr.pr(140003, new Supplier<String>() { // from class: com.byazt.mr.m.12
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public String get() {
                return m.this.vk();
            }
        });
        prVarPr.pr(140004, new Supplier<String>() { // from class: com.byazt.mr.m.13
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public String get() {
                return m.this.h_();
            }
        });
        prVarPr.pr(140018, new Supplier<String>() { // from class: com.byazt.mr.m.14
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public String get() {
                return m.this.i_();
            }
        });
        prVarPr.pr(140005, new Supplier<Integer>() { // from class: com.byazt.mr.m.15
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(m.this.m());
            }
        });
        prVarPr.pr(140006, new Supplier<Integer>() { // from class: com.byazt.mr.m.16
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(m.this.ho());
            }
        });
        prVarPr.pr(140007, new Supplier<Integer>() { // from class: com.byazt.mr.m.17
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(m.this.nt());
            }
        });
        prVarPr.pr(140008, new Supplier<String>() { // from class: com.byazt.mr.m.18
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public String get() {
                return m.this.yb();
            }
        });
        prVarPr.pr(140009, new Supplier<k>() { // from class: com.byazt.mr.m.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public k get() {
                return m.this.lb();
            }
        });
        prVarPr.pr(140010, new Supplier<List<k>>() { // from class: com.byazt.mr.m.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public List<k> get() {
                return m.this.qa();
            }
        });
        prVarPr.pr(140011, new Supplier<Integer>() { // from class: com.byazt.mr.m.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(m.this.a());
            }
        });
        prVarPr.pr(140012, new Supplier<Integer>() { // from class: com.byazt.mr.m.5
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(m.this.cz());
            }
        });
        prVarPr.pr(140013, new Supplier<x>() { // from class: com.byazt.mr.m.6
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public x get() {
                return m.this.ny();
            }
        });
        prVarPr.pr(140014, new Supplier<hn>() { // from class: com.byazt.mr.m.7
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public hn get() {
                return m.this.nl();
            }
        });
        prVarPr.pr(140015, new Supplier<c>() { // from class: com.byazt.mr.m.8
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public c get() {
                return m.this.rc();
            }
        });
        prVarPr.pr(140016, new Supplier<View>() { // from class: com.byazt.mr.m.9
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public View get() {
                return m.this.pr();
            }
        });
        prVarPr.pr(140017, new Supplier<Map<String, Object>>() { // from class: com.byazt.mr.m.10
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return m.this.g();
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
                return s_().sparseArray();
            case 140101:
                return pr((Activity) pluginValueSetHw.objectValue(0, Activity.class));
            case 140102:
                Dialog dialog = (Dialog) pluginValueSetHw.objectValue(0, Dialog.class);
                Integer[] numArr = (Integer[]) pluginValueSetHw.arrayValue(1, Integer.class);
                if (numArr == null) {
                    numArr = new Integer[0];
                }
                return pr(dialog, numArr);
            case 140103:
                pr((ViewGroup) pluginValueSetHw.objectValue(0, ViewGroup.class), (View) pluginValueSetHw.objectValue(1, View.class), new com.byazt.ti.pr((Function) pluginValueSetHw.objectValue(2, Function.class)));
                return null;
            case 140104:
                pr((ViewGroup) pluginValueSetHw.objectValue(0, ViewGroup.class), (List) pluginValueSetHw.objectValue(1, List.class), (List) pluginValueSetHw.objectValue(2, List.class), new com.byazt.ti.pr((Function) pluginValueSetHw.objectValue(3, Function.class)));
                return null;
            case 140105:
                pr((ViewGroup) pluginValueSetHw.objectValue(0, ViewGroup.class), (List) pluginValueSetHw.objectValue(1, List.class), (List) pluginValueSetHw.objectValue(2, List.class), (View) pluginValueSetHw.objectValue(3, View.class), new com.byazt.ti.pr((Function) pluginValueSetHw.objectValue(4, Function.class)));
                return null;
            case 140106:
                pr((ViewGroup) pluginValueSetHw.objectValue(0, ViewGroup.class), (List) pluginValueSetHw.objectValue(1, List.class), (List) pluginValueSetHw.objectValue(2, List.class), (List) pluginValueSetHw.objectValue(3, List.class), (View) pluginValueSetHw.objectValue(4, View.class), new com.byazt.ti.pr((Function) pluginValueSetHw.objectValue(5, Function.class)));
                return null;
            case 140107:
                pr((ViewGroup) pluginValueSetHw.objectValue(0, ViewGroup.class), (List<View>) pluginValueSetHw.objectValue(1, List.class), (List<View>) pluginValueSetHw.objectValue(2, List.class), (List<View>) pluginValueSetHw.objectValue(3, List.class), (List<View>) pluginValueSetHw.objectValue(4, List.class), (View) pluginValueSetHw.objectValue(5, View.class), new com.byazt.ti.pr((Function) pluginValueSetHw.objectValue(6, Function.class)));
                return null;
            case 140108:
                pr(new com.byazt.rkl.hn((Function) pluginValueSetHw.objectValue(0, Function.class)));
                return null;
            case 140109:
                hw((Activity) pluginValueSetHw.objectValue(0, Activity.class));
                return null;
            case 140110:
                z();
                return null;
            case 140111:
                pr(new com.byazt.ti.hn((Function) pluginValueSetHw.objectValue(0, Function.class)));
                return null;
            case 140112:
                pr((Activity) pluginValueSetHw.objectValue(0, Activity.class), new com.byazt.rz.pr((Function) pluginValueSetHw.objectValue(1, Function.class)));
                return null;
            case 140113:
                Dialog dialog2 = (Dialog) pluginValueSetHw.objectValue(0, Dialog.class);
                Integer[] numArr2 = (Integer[]) pluginValueSetHw.arrayValue(1, Integer.class);
                if (numArr2 == null) {
                    numArr2 = new Integer[0];
                }
                hw(dialog2, numArr2);
                return null;
            case 140114:
                hn();
                return null;
            case 140115:
                pluginValueSetHw.objectValue(0, Activity.class);
                return null;
            case 140116:
                return hw();
            case 140117:
                pr((Activity) pluginValueSetHw.objectValue(0, Activity.class), (ViewGroup) pluginValueSetHw.objectValue(1, ViewGroup.class), (List<View>) pluginValueSetHw.objectValue(2, List.class), (List<View>) pluginValueSetHw.objectValue(3, List.class), (List<View>) pluginValueSetHw.objectValue(4, List.class), new com.byazt.ti.pr((Function) pluginValueSetHw.objectValue(5, Function.class)), new com.byazt.mt.pr((Function) pluginValueSetHw.objectValue(6, Function.class)));
                return null;
            case 140118:
                pr((String) pluginValueSetHw.objectValue(0, String.class));
                return null;
            case 140119:
                pr(new com.byazt.ti.hw((Function) pluginValueSetHw.objectValue(0, Function.class)));
                return null;
            default:
                return super.apply(sparseArray);
        }
    }
}
