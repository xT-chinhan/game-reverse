package com.byazt.fvm;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 464, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
public abstract class oa extends fs {
    public PluginValueSet n;

    public abstract l a();

    public abstract q cd();

    public abstract int cp();

    public abstract int cy();

    public abstract int d();

    public abstract String fs();

    public abstract com.byazt.nq.l h();

    public abstract int hd();

    public abstract String hu();

    public abstract List<d> k();

    public abstract d l();

    public abstract void m();

    public abstract x n(Activity activity);

    public abstract x n(Dialog dialog, Integer[] numArr);

    public abstract void n(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.byazt.dc.n nVar, com.byazt.he.q qVar);

    public abstract void n(Activity activity, com.byazt.lr.n nVar);

    public abstract void n(ViewGroup viewGroup, View view, com.byazt.dc.n nVar);

    public abstract void n(ViewGroup viewGroup, List<View> list, List<View> list2, View view, com.byazt.dc.n nVar);

    public abstract void n(ViewGroup viewGroup, List<View> list, List<View> list2, com.byazt.dc.n nVar);

    public abstract void n(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, com.byazt.dc.n nVar);

    public abstract void n(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view, com.byazt.dc.n nVar);

    public abstract void n(com.byazt.dc.q qVar);

    public abstract void n(com.byazt.dc.qg qgVar);

    public abstract void n(com.byazt.dc.s sVar);

    public abstract void n(com.byazt.mi.s sVar);

    public abstract void n(String str);

    public abstract String oa();

    public abstract Map<String, Object> ou();

    public abstract View py();

    public abstract void qg(Activity activity);

    public abstract void qg(Dialog dialog, Integer[] numArr);

    public abstract String rv();

    public abstract d sz();

    public abstract int tj();

    public abstract s um();

    public abstract Bitmap w();

    public abstract void wm();

    public abstract String x();

    public PluginValueSet p_() {
        PluginValueSet pluginValueSet = this.n;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetN = n();
        this.n = pluginValueSetN;
        return pluginValueSetN;
    }

    private PluginValueSet n() {
        com.byazt.qvu.n nVarN = com.byazt.qvu.n.n();
        nVarN.n(140001, new Supplier<d>() { // from class: com.byazt.fvm.oa.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public d get() {
                return oa.this.l();
            }
        });
        nVarN.n(140002, new Supplier<Bitmap>() { // from class: com.byazt.fvm.oa.11
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Bitmap get() {
                return oa.this.w();
            }
        });
        nVarN.n(140003, new Supplier<String>() { // from class: com.byazt.fvm.oa.12
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public String get() {
                return oa.this.x();
            }
        });
        nVarN.n(140004, new Supplier<String>() { // from class: com.byazt.fvm.oa.13
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public String get() {
                return oa.this.fs();
            }
        });
        nVarN.n(140018, new Supplier<String>() { // from class: com.byazt.fvm.oa.14
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public String get() {
                return oa.this.rv();
            }
        });
        nVarN.n(140005, new Supplier<Integer>() { // from class: com.byazt.fvm.oa.15
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(oa.this.tj());
            }
        });
        nVarN.n(140006, new Supplier<Integer>() { // from class: com.byazt.fvm.oa.16
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(oa.this.cp());
            }
        });
        nVarN.n(140007, new Supplier<Integer>() { // from class: com.byazt.fvm.oa.17
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(oa.this.d());
            }
        });
        nVarN.n(140008, new Supplier<String>() { // from class: com.byazt.fvm.oa.18
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public String get() {
                return oa.this.oa();
            }
        });
        nVarN.n(140009, new Supplier<d>() { // from class: com.byazt.fvm.oa.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public d get() {
                return oa.this.sz();
            }
        });
        nVarN.n(140010, new Supplier<List<d>>() { // from class: com.byazt.fvm.oa.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public List<d> get() {
                return oa.this.k();
            }
        });
        nVarN.n(140011, new Supplier<Integer>() { // from class: com.byazt.fvm.oa.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(oa.this.cy());
            }
        });
        nVarN.n(140012, new Supplier<Integer>() { // from class: com.byazt.fvm.oa.5
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(oa.this.hd());
            }
        });
        nVarN.n(140013, new Supplier<q>() { // from class: com.byazt.fvm.oa.6
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public q get() {
                return oa.this.cd();
            }
        });
        nVarN.n(140014, new Supplier<s>() { // from class: com.byazt.fvm.oa.7
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public s get() {
                return oa.this.um();
            }
        });
        nVarN.n(140015, new Supplier<l>() { // from class: com.byazt.fvm.oa.8
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public l get() {
                return oa.this.a();
            }
        });
        nVarN.n(140016, new Supplier<View>() { // from class: com.byazt.fvm.oa.9
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public View get() {
                return oa.this.py();
            }
        });
        nVarN.n(140017, new Supplier<Map<String, Object>>() { // from class: com.byazt.fvm.oa.10
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return oa.this.ou();
            }
        });
        return nVarN.qg();
    }

    @Override // com.byazt.fvm.fs, java.util.function.Function
    /* JADX INFO: renamed from: n */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetQg = com.byazt.qvu.n.n(sparseArray).qg();
        int iIntValue = pluginValueSetQg.intValue(-99999987);
        if (iIntValue != -99999986) {
            switch (iIntValue) {
                case 140101:
                    return n((Activity) pluginValueSetQg.objectValue(0, Activity.class));
                case 140102:
                    Dialog dialog = (Dialog) pluginValueSetQg.objectValue(0, Dialog.class);
                    Integer[] numArr = (Integer[]) pluginValueSetQg.arrayValue(1, Integer.class);
                    if (numArr == null) {
                        numArr = new Integer[0];
                    }
                    return n(dialog, numArr);
                case 140103:
                    n((ViewGroup) pluginValueSetQg.objectValue(0, ViewGroup.class), (View) pluginValueSetQg.objectValue(1, View.class), new com.byazt.dc.n((Function) pluginValueSetQg.objectValue(2, Function.class)));
                    return null;
                case 140104:
                    n((ViewGroup) pluginValueSetQg.objectValue(0, ViewGroup.class), (List) pluginValueSetQg.objectValue(1, List.class), (List) pluginValueSetQg.objectValue(2, List.class), new com.byazt.dc.n((Function) pluginValueSetQg.objectValue(3, Function.class)));
                    return null;
                case 140105:
                    n((ViewGroup) pluginValueSetQg.objectValue(0, ViewGroup.class), (List) pluginValueSetQg.objectValue(1, List.class), (List) pluginValueSetQg.objectValue(2, List.class), (View) pluginValueSetQg.objectValue(3, View.class), new com.byazt.dc.n((Function) pluginValueSetQg.objectValue(4, Function.class)));
                    return null;
                case 140106:
                    n((ViewGroup) pluginValueSetQg.objectValue(0, ViewGroup.class), (List) pluginValueSetQg.objectValue(1, List.class), (List) pluginValueSetQg.objectValue(2, List.class), (List) pluginValueSetQg.objectValue(3, List.class), (View) pluginValueSetQg.objectValue(4, View.class), new com.byazt.dc.n((Function) pluginValueSetQg.objectValue(5, Function.class)));
                    return null;
                case 140107:
                    n((ViewGroup) pluginValueSetQg.objectValue(0, ViewGroup.class), (List<View>) pluginValueSetQg.objectValue(1, List.class), (List<View>) pluginValueSetQg.objectValue(2, List.class), (List<View>) pluginValueSetQg.objectValue(3, List.class), (List<View>) pluginValueSetQg.objectValue(4, List.class), (View) pluginValueSetQg.objectValue(5, View.class), new com.byazt.dc.n((Function) pluginValueSetQg.objectValue(6, Function.class)));
                    return null;
                case 140108:
                    n(new com.byazt.mi.s((Function) pluginValueSetQg.objectValue(0, Function.class)));
                    return null;
                case 140109:
                    qg((Activity) pluginValueSetQg.objectValue(0, Activity.class));
                    return null;
                case 140110:
                    wm();
                    return null;
                case 140111:
                    n(new com.byazt.dc.s((Function) pluginValueSetQg.objectValue(0, Function.class)));
                    return null;
                case 140112:
                    n((Activity) pluginValueSetQg.objectValue(0, Activity.class), new com.byazt.lr.n((Function) pluginValueSetQg.objectValue(1, Function.class)));
                    return null;
                case 140113:
                    Dialog dialog2 = (Dialog) pluginValueSetQg.objectValue(0, Dialog.class);
                    Integer[] numArr2 = (Integer[]) pluginValueSetQg.arrayValue(1, Integer.class);
                    if (numArr2 == null) {
                        numArr2 = new Integer[0];
                    }
                    qg(dialog2, numArr2);
                    return null;
                case 140114:
                    m();
                    return null;
                case 140115:
                    pluginValueSetQg.objectValue(0, Activity.class);
                    return null;
                case 140116:
                    return h();
                case 140117:
                    n((Activity) pluginValueSetQg.objectValue(0, Activity.class), (ViewGroup) pluginValueSetQg.objectValue(1, ViewGroup.class), (List<View>) pluginValueSetQg.objectValue(2, List.class), (List<View>) pluginValueSetQg.objectValue(3, List.class), (List<View>) pluginValueSetQg.objectValue(4, List.class), new com.byazt.dc.n((Function) pluginValueSetQg.objectValue(5, Function.class)), new com.byazt.he.q((Function) pluginValueSetQg.objectValue(6, Function.class)));
                    return null;
                case 140118:
                    n((String) pluginValueSetQg.objectValue(0, String.class));
                    return null;
                case 140119:
                    n(new com.byazt.dc.qg((Function) pluginValueSetQg.objectValue(0, Function.class)));
                    return null;
                case 140120:
                    n(new com.byazt.dc.q((Function) pluginValueSetQg.objectValue(0, Function.class)));
                    return null;
                default:
                    return super.apply(sparseArray);
            }
        }
        return p_().sparseArray();
    }
}
