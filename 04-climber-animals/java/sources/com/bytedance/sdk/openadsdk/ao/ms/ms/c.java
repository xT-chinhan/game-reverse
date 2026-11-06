package com.bytedance.sdk.openadsdk.ao.ms.ms;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.FilterWord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements FilterWord, Function<SparseArray<Object>, Object> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f1677ms;
    private FilterWord xr;

    public c(FilterWord filterWord) {
        this.xr = filterWord;
        this.f1677ms = com.bykv.ms.ms.ms.ms.xr.ah;
    }

    public c(Function<SparseArray<Object>, Object> function) {
        this.f1677ms = function == null ? com.bykv.ms.ms.ms.ms.xr.ah : function;
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public String getId() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 241103);
        sparseArray.put(-99999985, String.class);
        return (String) this.f1677ms.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public String getName() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 241104);
        sparseArray.put(-99999985, String.class);
        return (String) this.f1677ms.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public boolean getIsSelected() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 241105);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.f1677ms.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public List<FilterWord> getOptions() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 241108);
        sparseArray.put(-99999985, List.class);
        List arrayList = (List) this.f1677ms.apply(sparseArray);
        if (arrayList == null) {
            arrayList = new ArrayList(0);
        }
        ArrayList arrayList2 = new ArrayList();
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(new c(ao.ms(it.next())));
            }
        }
        return arrayList2;
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public boolean isValid() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 241107);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.f1677ms.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public boolean hasSecondOptions() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 241106);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.f1677ms.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public void addOption(FilterWord filterWord) {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 241101);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new c(filterWord));
        this.f1677ms.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public void setIsSelected(boolean z) {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 241102);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, Boolean.valueOf(z));
        this.f1677ms.apply(sparseArray);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.xr == null) {
            return null;
        }
        ValueSet valueSetXr = com.bykv.ms.ms.ms.ms.xr.ms(sparseArray).xr();
        switch (valueSetXr.intValue(-99999987)) {
            case 241101:
                this.xr.addOption(new c(ao.ms(valueSetXr.objectValue(0, Object.class))));
                return null;
            case 241102:
                this.xr.setIsSelected(valueSetXr.booleanValue(0));
                return null;
            case 241103:
                return this.xr.getId();
            case 241104:
                return this.xr.getName();
            case 241105:
                return Boolean.class.cast(Boolean.valueOf(this.xr.getIsSelected()));
            case 241106:
                return Boolean.class.cast(Boolean.valueOf(this.xr.hasSecondOptions()));
            case 241107:
                return Boolean.class.cast(Boolean.valueOf(this.xr.isValid()));
            case 241108:
                return this.xr.getOptions();
            default:
                return null;
        }
    }
}
