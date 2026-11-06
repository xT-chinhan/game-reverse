package com.tapsdk.tapad.group.config;

import com.qq.e.comm.managers.setting.GlobalSetting;
import com.tapsdk.tapad.a;
import com.tapsdk.tapad.group.AdNetworkType;
import com.tapsdk.tapad.lib_csjadapter.BuildConfig;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class AdNetworkCapabilityDetector {
    private static final AdNetworkType[] KNOWN_NETWORKS = {AdNetworkType.AD_TAP, AdNetworkType.AD_TT, AdNetworkType.AD_GDT, AdNetworkType.AD_IQY, AdNetworkType.AD_BD};
    private static final String METHOD_ACTUAL_PARTNER_VERSION = "dirichletActualPartnerVersion";
    private static final String METHOD_ADAPTER_VERSION_RULE = "dirichletAdapterVersionRule";
    private static final String METHOD_CAPABILITY_MASK = "dirichletCapabilityMask";
    private static final String METHOD_PARTNER_VERSION_RULE = "dirichletPartnerVersionRule";
    private static final String METHOD_PINNED_PARTNER_VERSION = "dirichletPinnedPartnerVersion";
    private static final String METHOD_PLATFORM_SUPPORTED = "dirichletPlatformSupported";
    static final String REASON_ADAPTER_NOT_PACKAGED = "adapter_not_packaged";
    static final String REASON_AVAILABLE = "available";
    static final String REASON_ENTRY_POINT_NOT_FOUND = "entry_point_not_found";
    static final String REASON_SDK_NOT_PACKAGED = "sdk_not_packaged";
    static final String REASON_UNSUPPORTED_NETWORK = "unsupported_network";
    public static final int SCHEMA_VERSION = 1;

    /* JADX INFO: renamed from: com.tapsdk.tapad.group.config.AdNetworkCapabilityDetector$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tapsdk$tapad$group$AdNetworkType;

        static {
            int[] iArr = new int[AdNetworkType.values().length];
            $SwitchMap$com$tapsdk$tapad$group$AdNetworkType = iArr;
            try {
                iArr[AdNetworkType.AD_TAP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$tapsdk$tapad$group$AdNetworkType[AdNetworkType.AD_TT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$tapsdk$tapad$group$AdNetworkType[AdNetworkType.AD_GDT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$tapsdk$tapad$group$AdNetworkType[AdNetworkType.AD_IQY.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$tapsdk$tapad$group$AdNetworkType[AdNetworkType.AD_BD.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public static final class Capability {
        private final String actualPartnerVersion;
        private final boolean adapterPresent;
        private final String adapterVersion;
        private final int adapterVersionRule;
        private final int capabilityMask;
        private final boolean entryPointPresent;
        private final AdNetworkType networkType;
        private final int partnerVersionRule;
        private final String pinnedPartnerVersion;
        private final boolean platformSupported;
        private final boolean registryMetadataPresent;
        private final boolean sdkPresent;
        private final String unavailableReason;

        public Capability(AdNetworkType adNetworkType, boolean z, boolean z2, boolean z3, boolean z4, String str, int i, int i2, int i3, String str2, String str3, boolean z5, String str4) {
            this.networkType = adNetworkType;
            this.adapterPresent = z;
            this.sdkPresent = z2;
            this.entryPointPresent = z3;
            this.registryMetadataPresent = z4;
            this.adapterVersion = str;
            this.adapterVersionRule = i;
            this.partnerVersionRule = i2;
            this.capabilityMask = i3;
            this.pinnedPartnerVersion = str2;
            this.actualPartnerVersion = str3;
            this.platformSupported = z5;
            this.unavailableReason = str4;
        }

        public String getActualPartnerVersion() {
            return this.actualPartnerVersion;
        }

        public String getAdapterVersion() {
            return this.adapterVersion;
        }

        public AdNetworkType getNetworkType() {
            return this.networkType;
        }

        public String getUnavailableReason() {
            return this.unavailableReason;
        }

        public boolean isAdapterPresent() {
            return this.adapterPresent;
        }

        public boolean isAvailable() {
            return this.adapterPresent && this.sdkPresent && this.entryPointPresent;
        }

        public boolean isSdkPresent() {
            return this.sdkPresent;
        }

        public AdapterRegistryNativeBridge.Fact toRegistryFact(boolean z, String str) {
            int i = this.adapterPresent ? 35 : 33;
            if (this.sdkPresent) {
                i |= 4;
            }
            if (this.entryPointPresent && this.registryMetadataPresent) {
                i |= 8;
            }
            if (this.platformSupported) {
                i |= 16;
            }
            int i2 = i;
            AdNetworkType adNetworkType = this.networkType;
            return new AdapterRegistryNativeBridge.Fact(adNetworkType == null ? 0 : adNetworkType.getValue(), i2, z ? 0 : this.adapterVersionRule, this.partnerVersionRule, this.capabilityMask, this.adapterVersion, str, this.pinnedPartnerVersion, this.actualPartnerVersion);
        }
    }

    public interface ClassInspector {
        default boolean hasStaticMethod(String str, String str2) {
            return false;
        }

        default boolean invokeStaticBoolean(String str, String str2, boolean z) {
            return z;
        }

        default int invokeStaticInt(String str, String str2, int i) {
            return i;
        }

        default String invokeStaticString(String str, String str2) {
            return "";
        }

        boolean isClassPresent(String str);

        String readStaticString(String str, String str2);
    }

    public static final class NetworkSpec {
        final String adapterMarkerClassName;
        final String adapterPackageName;
        final String adapterVersionFieldName;
        final String managerHolderClassName;
        final String vendorSdkClassName;

        public NetworkSpec(String str, String str2, String str3, String str4, String str5) {
            this.adapterPackageName = str;
            this.adapterMarkerClassName = str2;
            this.adapterVersionFieldName = str3;
            this.vendorSdkClassName = str4;
            this.managerHolderClassName = str5;
        }
    }

    public static final class ReflectionClassInspector implements ClassInspector {
        private final ClassLoader classLoader;

        public ReflectionClassInspector(ClassLoader classLoader) {
            this.classLoader = classLoader;
        }

        private Object invokeStatic(String str, String str2) {
            try {
                Method method = Class.forName(str, false, this.classLoader).getMethod(str2, null);
                if (Modifier.isStatic(method.getModifiers()) && method.getParameterTypes().length == 0) {
                    return method.invoke(null, null);
                }
                return null;
            } catch (LinkageError | ReflectiveOperationException | SecurityException e) {
                return null;
            }
        }

        @Override // com.tapsdk.tapad.group.config.AdNetworkCapabilityDetector.ClassInspector
        public boolean hasStaticMethod(String str, String str2) {
            try {
                Method method = Class.forName(str, false, this.classLoader).getMethod(str2, null);
                return Modifier.isStatic(method.getModifiers()) && method.getParameterTypes().length == 0;
            } catch (LinkageError | ReflectiveOperationException | SecurityException e) {
                return false;
            }
        }

        @Override // com.tapsdk.tapad.group.config.AdNetworkCapabilityDetector.ClassInspector
        public boolean invokeStaticBoolean(String str, String str2, boolean z) {
            Object objInvokeStatic = invokeStatic(str, str2);
            return objInvokeStatic instanceof Boolean ? ((Boolean) objInvokeStatic).booleanValue() : z;
        }

        @Override // com.tapsdk.tapad.group.config.AdNetworkCapabilityDetector.ClassInspector
        public int invokeStaticInt(String str, String str2, int i) {
            Object objInvokeStatic = invokeStatic(str, str2);
            return objInvokeStatic instanceof Number ? ((Number) objInvokeStatic).intValue() : i;
        }

        @Override // com.tapsdk.tapad.group.config.AdNetworkCapabilityDetector.ClassInspector
        public String invokeStaticString(String str, String str2) {
            Object objInvokeStatic = invokeStatic(str, str2);
            return objInvokeStatic == null ? "" : String.valueOf(objInvokeStatic);
        }

        @Override // com.tapsdk.tapad.group.config.AdNetworkCapabilityDetector.ClassInspector
        public boolean isClassPresent(String str) {
            try {
                Class.forName(str, false, this.classLoader);
                return true;
            } catch (ClassNotFoundException | LinkageError | SecurityException e) {
                return false;
            }
        }

        @Override // com.tapsdk.tapad.group.config.AdNetworkCapabilityDetector.ClassInspector
        public String readStaticString(String str, String str2) {
            try {
                Object obj = Class.forName(str, false, this.classLoader).getField(str2).get(null);
                return obj == null ? "" : String.valueOf(obj);
            } catch (LinkageError | ReflectiveOperationException | SecurityException e) {
                return "";
            }
        }
    }

    private AdNetworkCapabilityDetector() {
    }

    public static Capability detect(AdNetworkType adNetworkType) {
        return detect(adNetworkType, new ReflectionClassInspector(AdNetworkCapabilityDetector.class.getClassLoader()));
    }

    public static Map<AdNetworkType, Capability> detectAll() {
        return detectAll(new ReflectionClassInspector(AdNetworkCapabilityDetector.class.getClassLoader()));
    }

    public static String getAdapterPackageName(AdNetworkType adNetworkType) {
        NetworkSpec networkSpec = getNetworkSpec(adNetworkType);
        return networkSpec == null ? "" : networkSpec.adapterPackageName;
    }

    public static String getManagerHolderClassName(AdNetworkType adNetworkType) {
        NetworkSpec networkSpec = getNetworkSpec(adNetworkType);
        return networkSpec == null ? "" : networkSpec.managerHolderClassName;
    }

    private static NetworkSpec getNetworkSpec(AdNetworkType adNetworkType) {
        if (adNetworkType == null) {
            return null;
        }
        switch (AnonymousClass1.$SwitchMap$com$tapsdk$tapad$group$AdNetworkType[adNetworkType.ordinal()]) {
            case 1:
                return new NetworkSpec("com.tapsdk.tapad.lib_tapadadapter", "com.tapsdk.tapad.BuildConfig", "SDK_VERSION_NAME", "com.tapsdk.tapad.lib_tapadadapter.TapTapADNManagerHolder", "com.tapsdk.tapad.lib_tapadadapter.TapTapADNManagerHolder");
            case 2:
                return optionalNetworkSpec(BuildConfig.LIBRARY_PACKAGE_NAME, "CSJ", "com.bytedance.sdk.openadsdk.TTAdSdk");
            case 3:
                return optionalNetworkSpec(com.tapsdk.tapad.lib_gdtadapter.BuildConfig.LIBRARY_PACKAGE_NAME, "GDT", "com.qq.e.comm.managers.GDTAdSdk");
            case 4:
                return optionalNetworkSpec(com.tapsdk.tapad.lib_iqyadapter.BuildConfig.LIBRARY_PACKAGE_NAME, "IQY", "com.mcto.sspsdk.QySdk");
            case 5:
                return optionalNetworkSpec("com.tapsdk.tapad.lib_bdadapter", GlobalSetting.BD_SDK_WRAPPER, "com.baidu.mobads.sdk.api.AdSettings");
            default:
                return null;
        }
    }

    private static boolean hasRegistryMetadata(ClassInspector classInspector, String str) {
        return classInspector.hasStaticMethod(str, METHOD_ADAPTER_VERSION_RULE) && classInspector.hasStaticMethod(str, METHOD_PARTNER_VERSION_RULE) && classInspector.hasStaticMethod(str, METHOD_CAPABILITY_MASK) && classInspector.hasStaticMethod(str, METHOD_PINNED_PARTNER_VERSION) && classInspector.hasStaticMethod(str, METHOD_ACTUAL_PARTNER_VERSION) && classInspector.hasStaticMethod(str, METHOD_PLATFORM_SUPPORTED);
    }

    private static boolean isVersionRule(int i) {
        return i >= 0 && i <= 4;
    }

    private static NetworkSpec optionalNetworkSpec(String str, String str2, String str3) {
        return new NetworkSpec(str, a.a(str, ".BuildConfig"), "VERSION_NAME", str3, str + ".Tap" + str2 + "ManagerHolder");
    }

    public static Capability detect(AdNetworkType adNetworkType, ClassInspector classInspector) {
        String staticString;
        NetworkSpec networkSpec = getNetworkSpec(adNetworkType);
        if (networkSpec != null) {
            boolean zIsClassPresent = classInspector.isClassPresent(networkSpec.adapterMarkerClassName);
            boolean zIsClassPresent2 = classInspector.isClassPresent(networkSpec.vendorSdkClassName);
            if (zIsClassPresent) {
                staticString = classInspector.readStaticString(networkSpec.adapterMarkerClassName, networkSpec.adapterVersionFieldName);
            } else {
                staticString = "";
            }
            if (!zIsClassPresent) {
                return new Capability(adNetworkType, false, zIsClassPresent2, false, false, staticString, 0, 0, 63, "", "", false, REASON_ADAPTER_NOT_PACKAGED);
            }
            if (zIsClassPresent2) {
                if (!classInspector.isClassPresent(networkSpec.managerHolderClassName)) {
                    return new Capability(adNetworkType, true, true, false, false, staticString, 0, 0, 63, "", "", false, REASON_ENTRY_POINT_NOT_FOUND);
                }
                boolean zHasRegistryMetadata = hasRegistryMetadata(classInspector, networkSpec.managerHolderClassName);
                int iInvokeStaticInt = zHasRegistryMetadata ? classInspector.invokeStaticInt(networkSpec.managerHolderClassName, METHOD_ADAPTER_VERSION_RULE, -1) : -1;
                int iInvokeStaticInt2 = zHasRegistryMetadata ? classInspector.invokeStaticInt(networkSpec.managerHolderClassName, METHOD_PARTNER_VERSION_RULE, -1) : -1;
                boolean z = zHasRegistryMetadata && isVersionRule(iInvokeStaticInt) && isVersionRule(iInvokeStaticInt2);
                return new Capability(adNetworkType, true, true, true, z, staticString, z ? iInvokeStaticInt : 0, z ? iInvokeStaticInt2 : 0, zHasRegistryMetadata ? classInspector.invokeStaticInt(networkSpec.managerHolderClassName, METHOD_CAPABILITY_MASK, 0) : 63, classInspector.invokeStaticString(networkSpec.managerHolderClassName, METHOD_PINNED_PARTNER_VERSION), classInspector.invokeStaticString(networkSpec.managerHolderClassName, METHOD_ACTUAL_PARTNER_VERSION), z && classInspector.invokeStaticBoolean(networkSpec.managerHolderClassName, METHOD_PLATFORM_SUPPORTED, false), REASON_AVAILABLE);
            }
            return new Capability(adNetworkType, true, false, false, false, staticString, 0, 0, 63, "", "", false, REASON_SDK_NOT_PACKAGED);
        }
        return new Capability(adNetworkType, false, false, false, false, "", 0, 0, 63, "", "", false, REASON_UNSUPPORTED_NETWORK);
    }

    public static Map<AdNetworkType, Capability> detectAll(ClassInspector classInspector) {
        EnumMap enumMap = new EnumMap(AdNetworkType.class);
        for (AdNetworkType adNetworkType : KNOWN_NETWORKS) {
            enumMap.put(adNetworkType, detect(adNetworkType, classInspector));
        }
        return Collections.unmodifiableMap(enumMap);
    }
}
