package com.tapsdk.tapad.internal.runtime.bundle;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class BundleId {
    public static final String CORE = "core";
    private static final String MEDIATION_CORE_STORAGE = "core_mediation";
    public static final String STYLE = "style";
    private static final Pattern VALID = Pattern.compile("[a-z0-9_-]+");

    private BundleId() {
    }

    public static boolean isValid(String str) {
        return (str == null || str.isEmpty() || !VALID.matcher(str).matches()) ? false : true;
    }

    public static String storageId(String str) {
        return storageIdForProduct(str, 2);
    }

    public static String storageIdForProduct(String str, int i) {
        return ("core".equals(str) && i == 2) ? MEDIATION_CORE_STORAGE : str;
    }

    public static boolean usesIsolatedRegistry() {
        return usesIsolatedRegistryForProduct(2);
    }

    public static boolean usesIsolatedRegistryForProduct(int i) {
        return i == 2;
    }
}
