package com.byazt.pch;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, AVMDLDataLoader.KeyIsMarkedFileIOSpeed, 5})
public abstract class q implements Function<SparseArray<Object>, Object> {
    public PluginValueSet n;

    public abstract int n(com.byazt.pe.q qVar);

    public abstract Object n(int i, PluginValueSet pluginValueSet);

    public abstract Map<String, Object> n();

    public abstract void n(int i);

    public abstract void n(Activity activity, List<l> list, int i, int i2, Function<SparseArray<Object>, Object> function);

    public abstract void n(Context context);

    public abstract void n(Context context, n nVar, com.byazt.pe.n nVar2, Function<SparseArray<Object>, Object> function);

    public abstract void n(Context context, n nVar, com.byazt.pe.s sVar, Function<SparseArray<Object>, Object> function);

    public abstract void n(Context context, int[] iArr);

    public abstract void n(com.byazt.xmw.s sVar);

    public abstract void n(com.byazt.zq.q qVar);

    public abstract void n(String str);

    public abstract void n(Map<String, Object> map);

    public PluginValueSet qg() {
        PluginValueSet pluginValueSet = this.n;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetS = s();
        this.n = pluginValueSetS;
        return pluginValueSetS;
    }

    private PluginValueSet s() {
        return com.byazt.qvu.n.n().qg();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetQg = com.byazt.qvu.n.n(sparseArray).qg();
        int iIntValue = pluginValueSetQg.intValue(-99999987);
        pluginValueSetQg.objectValue(-99999985, Class.class);
        switch (iIntValue) {
            case -99999986:
                return qg().sparseArray();
            case 270024:
                return n();
            case 271043:
                return n(pluginValueSetQg.intValue(0), com.byazt.qvu.n.n((SparseArray<Object>) pluginValueSetQg.objectValue(1, SparseArray.class)).qg());
            case 271050:
                n((Map<String, Object>) pluginValueSetQg.objectValue(0, Map.class));
                return null;
            default:
                switch (iIntValue) {
                    case 270013:
                        Activity activity = (Activity) pluginValueSetQg.objectValue(0, Activity.class);
                        List arrayList = (List) pluginValueSetQg.objectValue(1, List.class);
                        if (arrayList == null) {
                            arrayList = new ArrayList(0);
                        }
                        ArrayList arrayList2 = new ArrayList();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            arrayList2.add(new l((Function) it.next()));
                        }
                        n(activity, arrayList2, pluginValueSetQg.intValue(2), pluginValueSetQg.intValue(3), (Function) pluginValueSetQg.objectValue(4, Function.class));
                        return null;
                    case 270014:
                        n(new com.byazt.xmw.s((SparseArray) pluginValueSetQg.objectValue(0, SparseArray.class)));
                        return null;
                    case 270015:
                        n((String) pluginValueSetQg.objectValue(0, String.class));
                        return null;
                    case 270016:
                        n(new com.byazt.zq.q((SparseArray) pluginValueSetQg.objectValue(0, SparseArray.class)));
                        return null;
                    case 270017:
                        n((Context) pluginValueSetQg.objectValue(0, Context.class));
                        return null;
                    case 270018:
                        n((Context) pluginValueSetQg.objectValue(0, Context.class), (int[]) pluginValueSetQg.objectValue(1, int[].class));
                        return null;
                    case 270019:
                        n(pluginValueSetQg.intValue(0));
                        return null;
                    case 270020:
                        return Integer.class.cast(Integer.valueOf(n(new com.byazt.pe.q((Function) pluginValueSetQg.objectValue(0, Function.class)))));
                    case 270021:
                        Context context = (Context) pluginValueSetQg.objectValue(0, Context.class);
                        Function<SparseArray<Object>, Object> function = (Function) pluginValueSetQg.objectValue(3, Function.class);
                        n(context, new n((SparseArray) pluginValueSetQg.objectValue(1, SparseArray.class), null), new com.byazt.pe.s((Function) pluginValueSetQg.objectValue(2, Function.class)), function);
                        return null;
                    case 270022:
                        Context context2 = (Context) pluginValueSetQg.objectValue(0, Context.class);
                        Function<SparseArray<Object>, Object> function2 = (Function) pluginValueSetQg.objectValue(3, Function.class);
                        n(context2, new n((SparseArray) pluginValueSetQg.objectValue(1, SparseArray.class), null), new com.byazt.pe.n((Function) pluginValueSetQg.objectValue(2, Function.class)), function2);
                        return null;
                    default:
                        return null;
                }
        }
    }
}
