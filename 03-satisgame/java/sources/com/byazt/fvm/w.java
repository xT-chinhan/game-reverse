package com.byazt.fvm;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 464, 13})
public class w implements Function<SparseArray<Object>, Object> {
    public Function<SparseArray<Object>, Object> n;

    public w(Function<SparseArray<Object>, Object> function) {
        this.n = com.byazt.qvu.n.qg;
        this.n = function == null ? com.byazt.qvu.n.qg : function;
    }

    public String n() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 241103);
        sparseArray.put(-99999985, String.class);
        return (String) this.n.apply(sparseArray);
    }

    public String qg() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 241104);
        sparseArray.put(-99999985, String.class);
        return (String) this.n.apply(sparseArray);
    }

    public boolean s() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 241105);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.n.apply(sparseArray)).booleanValue();
    }

    public List<w> q() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 241108);
        sparseArray.put(-99999985, List.class);
        List arrayList = (List) this.n.apply(sparseArray);
        if (arrayList == null) {
            arrayList = new ArrayList(0);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new w(com.byazt.mp.s.n(it.next())));
        }
        return arrayList2;
    }

    public boolean w() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 241107);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.n.apply(sparseArray)).booleanValue();
    }

    public boolean x() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 241106);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.n.apply(sparseArray)).booleanValue();
    }

    public void n(w wVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, wVar);
        sparseArray.put(-99999987, 241101);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    public void n(boolean z) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, Boolean.valueOf(z));
        sparseArray.put(-99999987, 241102);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
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
        if (iIntValue != -99999986) {
            switch (iIntValue) {
                case 241101:
                    n(new w((Function) pluginValueSetQg.objectValue(0, Function.class)));
                    return null;
                case 241102:
                    n(pluginValueSetQg.booleanValue(0));
                    return null;
                case 241103:
                    return n();
                case 241104:
                    return qg();
                case 241105:
                    return Boolean.class.cast(Boolean.valueOf(s()));
                case 241106:
                    return Boolean.class.cast(Boolean.valueOf(x()));
                case 241107:
                    return Boolean.class.cast(Boolean.valueOf(w()));
                case 241108:
                    return q();
                default:
                    return null;
            }
        }
        return new SparseArray();
    }
}
