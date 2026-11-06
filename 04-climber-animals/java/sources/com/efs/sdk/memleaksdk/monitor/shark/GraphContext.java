package com.efs.sdk.memleaksdk.monitor.shark;

import com.anythink.core.common.e.f;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.aq, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0086\u0002J\u001e\u0010\t\u001a\u0004\u0018\u0001H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\b\u001a\u00020\u0005H\u0086\u0002¢\u0006\u0002\u0010\u000bJ'\u0010\f\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\b\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\n0\u000e¢\u0006\u0002\u0010\u000fJ\u0011\u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u0005H\u0086\u0002J$\u0010\u0012\u001a\u00020\u0011\"\u0004\b\u0000\u0010\n2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u0002H\nH\u0086\u0002¢\u0006\u0002\u0010\u0014R\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/GraphContext;", "", "()V", "store", "", "", "contains", "", f.a.b, "get", "T", "(Ljava/lang/String;)Ljava/lang/Object;", "getOrPut", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "minusAssign", "", "set", f.a.d, "(Ljava/lang/String;Ljava/lang/Object;)V", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final class GraphContext {
    private final Map<String, Object> a = new LinkedHashMap();

    public final <T> T a(String key, Function0<? extends T> defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        Map<String, Object> map = this.a;
        T t = (T) map.get(key);
        if (t != null) {
            return t;
        }
        T tInvoke = defaultValue.invoke();
        map.put(key, tInvoke);
        return tInvoke;
    }
}
