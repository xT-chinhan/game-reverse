package com.byazt.mr;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 25, 5})
public class uc implements Function<SparseArray<Object>, Object> {
    public Function<SparseArray<Object>, Object> pr;

    public uc(Function<SparseArray<Object>, Object> function) {
        this.pr = com.byazt.ij.pr.hw;
        this.pr = function == null ? com.byazt.ij.pr.hw : function;
    }

    public String pr() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 241103);
        sparseArray.put(-99999985, String.class);
        return (String) this.pr.apply(sparseArray);
    }

    public String hw() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 241104);
        sparseArray.put(-99999985, String.class);
        return (String) this.pr.apply(sparseArray);
    }

    public boolean hn() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 241105);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    public List<uc> x() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 241108);
        sparseArray.put(-99999985, List.class);
        List arrayList = (List) this.pr.apply(sparseArray);
        if (arrayList == null) {
            arrayList = new ArrayList(0);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new uc(com.byazt.ul.hn.pr(it.next())));
        }
        return arrayList2;
    }

    public boolean uc() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 241107);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    public boolean fw() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 241106);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    public void pr(uc ucVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, ucVar);
        sparseArray.put(-99999987, 241101);
        sparseArray.put(-99999985, Void.class);
        this.pr.apply(sparseArray);
    }

    public void pr(boolean z) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, Boolean.valueOf(z));
        sparseArray.put(-99999987, 241102);
        sparseArray.put(-99999985, Void.class);
        this.pr.apply(sparseArray);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
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
                return new SparseArray();
            case 241101:
                pr(new uc((Function) pluginValueSetHw.objectValue(0, Function.class)));
                return null;
            case 241102:
                pr(pluginValueSetHw.booleanValue(0));
                return null;
            case 241103:
                return pr();
            case 241104:
                return hw();
            case 241105:
                return Boolean.class.cast(Boolean.valueOf(hn()));
            case 241106:
                return Boolean.class.cast(Boolean.valueOf(fw()));
            case 241107:
                return Boolean.class.cast(Boolean.valueOf(uc()));
            case 241108:
                return x();
            default:
                return null;
        }
    }
}
