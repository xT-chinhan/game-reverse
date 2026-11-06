package com.efs.sdk.memleaksdk.monitor.shark;

import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bs, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005J\u0016\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ProguardMapping;", "", "()V", "obfuscatedToClearNamesMap", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "addMapping", "", "obfuscatedName", "clearName", "deobfuscateClassName", "obfuscatedClassName", "deobfuscateFieldName", "obfuscatedClass", "obfuscatedField", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final class ProguardMapping {
    private final LinkedHashMap<String, String> a;

    public final String a(String obfuscatedClassName) {
        Intrinsics.checkNotNullParameter(obfuscatedClassName, "obfuscatedClassName");
        String str = this.a.get(obfuscatedClassName);
        return str != null ? str : obfuscatedClassName;
    }

    public final String a(String obfuscatedClass, String obfuscatedField) {
        Intrinsics.checkNotNullParameter(obfuscatedClass, "obfuscatedClass");
        Intrinsics.checkNotNullParameter(obfuscatedField, "obfuscatedField");
        String str = this.a.get(obfuscatedClass + '.' + obfuscatedField);
        return str != null ? str : obfuscatedField;
    }
}
