package com.byazt.mo;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.FilterWord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1649, 13})
public final class w implements FilterWord, Function<SparseArray<Object>, Object> {
    public final Function<SparseArray<Object>, Object> n;
    public FilterWord qg;

    public w(FilterWord filterWord) {
        this.qg = filterWord;
        this.n = com.byazt.qvu.s.qg;
    }

    public w(Function<SparseArray<Object>, Object> function) {
        this.n = function == null ? com.byazt.qvu.s.qg : function;
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public String getId() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 241103);
        sparseArray.put(-99999985, String.class);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public String getName() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 241104);
        sparseArray.put(-99999985, String.class);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public boolean getIsSelected() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 241105);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.n.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public List<FilterWord> getOptions() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 241108);
        sparseArray.put(-99999985, List.class);
        List arrayList = (List) this.n.apply(sparseArray);
        if (arrayList == null) {
            arrayList = new ArrayList(0);
        }
        ArrayList arrayList2 = new ArrayList();
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(new w(k.n(it.next())));
            }
        }
        return arrayList2;
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public boolean isValid() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 241107);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.n.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public boolean hasSecondOptions() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 241106);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.n.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public void addOption(FilterWord filterWord) {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 241101);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new w(filterWord));
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public void setIsSelected(boolean z) {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 241102);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, Boolean.valueOf(z));
        this.n.apply(sparseArray);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.qg == null) {
            return null;
        }
        ValueSet valueSetQg = com.byazt.qvu.s.n(sparseArray).qg();
        switch (valueSetQg.intValue(-99999987)) {
            case 241101:
                this.qg.addOption(new w(k.n(valueSetQg.objectValue(0, Object.class))));
                return null;
            case 241102:
                this.qg.setIsSelected(valueSetQg.booleanValue(0));
                return null;
            case 241103:
                return this.qg.getId();
            case 241104:
                return this.qg.getName();
            case 241105:
                return Boolean.class.cast(Boolean.valueOf(this.qg.getIsSelected()));
            case 241106:
                return Boolean.class.cast(Boolean.valueOf(this.qg.hasSecondOptions()));
            case 241107:
                return Boolean.class.cast(Boolean.valueOf(this.qg.isValid()));
            case 241108:
                return this.qg.getOptions();
            default:
                return null;
        }
    }
}
