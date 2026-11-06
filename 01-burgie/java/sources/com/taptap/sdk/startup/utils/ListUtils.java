package com.taptap.sdk.startup.utils;

import com.taptap.sdk.db.constant.Common;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ListUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JL\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\u00042\u0006\u0010\u0006\u001a\u0002H\u00052!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u0011H\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\b¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/taptap/sdk/startup/utils/ListUtils;", "", "()V", "updateOrInsert", "", "E", "element", "selector", "Lkotlin/Function1;", "Lkotlin/ParameterName;", Common.System.NAME, "e", "", "(Ljava/util/List;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ListUtils {
    public static final ListUtils INSTANCE = new ListUtils();

    private ListUtils() {
    }

    public final <E> List<E> updateOrInsert(List<? extends E> list, E e, Function1<? super E, Boolean> selector) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int index$iv = 0;
        Iterator<? extends E> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                Object item$iv = it.next();
                if (selector.invoke(item$iv).booleanValue()) {
                    break;
                }
                index$iv++;
            } else {
                index$iv = -1;
                break;
            }
        }
        int index = index$iv;
        if (index >= 0) {
            List<E> mutableList = CollectionsKt.toMutableList((Collection) list);
            mutableList.set(index, e);
            return mutableList;
        }
        return CollectionsKt.plus((Collection<? extends E>) list, e);
    }
}
