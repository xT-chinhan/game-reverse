package com.kwad.sdk.api.loader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
class ResourcesManager {
    private static final String DEFAULT_RESOURCES = "android.content.res.Resources";
    private static final String HW_RESOURCES = "android.content.res.HwResources";
    private static final String MIUI_RESOURCES = "android.content.res.MiuiResources";
    private static final String MIUI_RESOURCES_IMPL = "android.content.res.MiuiResourcesImpl";
    private static final String NUBIA_RESOURCES = "android.content.res.NubiaResources";
    private static final String VIVO_RESOURCES = "android.content.res.VivoResources";
    private static Map<String, Resources> sResourcesCache = new HashMap();
    private static final Object sResourcesCacheLock = new Object();

    ResourcesManager() {
    }

    static Resources getOrCreateResources(Context context, Resources resources, String str) throws Exception {
        Resources resourcesCreateResources;
        synchronized (sResourcesCacheLock) {
            resourcesCreateResources = sResourcesCache.get(str);
            if (resourcesCreateResources == null) {
                resourcesCreateResources = createResources(context, resources, str);
                if (resourcesCreateResources != null) {
                    sResourcesCache.put(str, resources);
                } else {
                    throw new RuntimeException("Can not createResources for " + str);
                }
            }
        }
        return resourcesCreateResources;
    }

    public static void addOverlayPath(AssetManager assetManager, String str) {
        try {
            ApiReflect.on(assetManager).call("addOverlayPath", new Class[]{String.class}, str);
        } catch (Throwable unused) {
            ApiReflect.on(assetManager).call("addAssetPath", new Class[]{String.class}, str);
        }
    }

    public static int addAssetPathAsSharedLibrary(AssetManager assetManager, String str) {
        try {
            ApiReflect.on(assetManager).call("addAssetPathAsSharedLibrary", new Class[]{String.class}, str);
        } catch (Throwable unused) {
            ApiReflect.on(assetManager).call("addAssetPath", new Class[]{String.class}, str);
        }
        return 0;
    }

    private static Resources createResources(Context context, Resources resources, String str) throws Exception {
        AssetManager assetManager = (AssetManager) ApiReflect.onClass((Class<?>) AssetManager.class).create().get();
        ApiReflect.on(assetManager).call("addAssetPath", new Class[]{String.class}, str);
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        try {
            Object obj = ApiReflect.on(applicationInfo).get("resourceDirs");
            if (obj != null && obj.getClass().isArray()) {
                Object[] objArr = (Object[]) obj;
                if (objArr.length > 0) {
                    for (Object obj2 : objArr) {
                        if (obj2 instanceof String) {
                            addOverlayPath(assetManager, (String) obj2);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            if (applicationInfo.sharedLibraryFiles != null && applicationInfo.sharedLibraryFiles.length > 0) {
                for (String str2 : applicationInfo.sharedLibraryFiles) {
                    if (str2 != null && str2.endsWith(".apk")) {
                        addAssetPathAsSharedLibrary(assetManager, str2);
                    }
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return newResources(context, assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
    }

    private static Resources newResources(Context context, AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration) throws Exception {
        Resources resources = context.getResources();
        if (!isMiUi(resources)) {
            if (!isMiUi2(resources)) {
                if (!isHuaWei(resources)) {
                    if (!isVivo(resources)) {
                        if (!isNubia(resources)) {
                            if (!isNotRawResources(resources)) {
                                return new Resources(assetManager, displayMetrics, configuration);
                            }
                            return AdaptationResourcesCompat.createResources(resources, assetManager);
                        }
                        return NubiaResourcesCompat.createResources(resources, assetManager);
                    }
                    return VivoResourcesCompat.createResources(context, resources, assetManager);
                }
                return HuaWeiResourcesCompat.createResources(resources, assetManager);
            }
            return MiUi2ResourcesCompat.createResources(resources, assetManager);
        }
        return MiUiResourcesCompat.createResources(resources, assetManager);
    }

    private static boolean isMiUi(Resources resources) {
        return MIUI_RESOURCES.equals(resources.getClass().getName());
    }

    private static boolean isMiUi2(Resources resources) {
        return MIUI_RESOURCES_IMPL.equals(resources.getClass().getName());
    }

    private static boolean isVivo(Resources resources) {
        return VIVO_RESOURCES.equals(resources.getClass().getName());
    }

    private static boolean isNubia(Resources resources) {
        return NUBIA_RESOURCES.equals(resources.getClass().getName());
    }

    private static boolean isHuaWei(Resources resources) {
        return HW_RESOURCES.equals(resources.getClass().getName());
    }

    private static boolean isNotRawResources(Resources resources) {
        return !DEFAULT_RESOURCES.equals(resources.getClass().getName());
    }

    private static final class MiUiResourcesCompat {
        private MiUiResourcesCompat() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Resources createResources(Resources resources, AssetManager assetManager) throws Exception {
            try {
                try {
                    return createMiuiResources(resources, assetManager);
                } catch (Exception unused) {
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            } catch (Exception unused2) {
                return AdaptationResourcesCompat.createResources(resources, assetManager);
            }
        }

        private static Resources createMiuiResources(Resources resources, AssetManager assetManager) throws Exception {
            Resources resources2 = (Resources) ApiReflect.onClass(ResourcesManager.MIUI_RESOURCES).create(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).get();
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    private static final class MiUi2ResourcesCompat {
        private MiUi2ResourcesCompat() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Resources createResources(Resources resources, AssetManager assetManager) throws Exception {
            try {
                return createMiui2Resources(resources, assetManager);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    return AdaptationResourcesCompat.createResources(resources, assetManager);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        private static Resources createMiui2Resources(Resources resources, AssetManager assetManager) throws Exception {
            Resources resources2 = (Resources) ApiReflect.onClass(ResourcesManager.MIUI_RESOURCES_IMPL).create(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).get();
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    private static final class HuaWeiResourcesCompat {
        private HuaWeiResourcesCompat() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Resources createResources(Resources resources, AssetManager assetManager) throws Exception {
            try {
                return createHuaWeiResources(resources, assetManager);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    return AdaptationResourcesCompat.createResources(resources, assetManager);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        private static Resources createHuaWeiResources(Resources resources, AssetManager assetManager) throws Exception {
            Resources resources2 = (Resources) ApiReflect.onClass(ResourcesManager.HW_RESOURCES).create(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).get();
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    private static final class VivoResourcesCompat {
        private VivoResourcesCompat() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Resources createResources(Context context, Resources resources, AssetManager assetManager) throws Exception {
            try {
                return createVivoResources(context, resources, assetManager);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    return AdaptationResourcesCompat.createResources(resources, assetManager);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        private static Resources createVivoResources(Context context, Resources resources, AssetManager assetManager) throws Exception {
            Resources resources2 = (Resources) ApiReflect.onClass(ResourcesManager.VIVO_RESOURCES).create(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).get();
            if (resources2 == null) {
                throw new RuntimeException("Can not create Resources");
            }
            try {
                ApiReflect.on(resources2).call("init", new Class[]{String.class}, context.getPackageName());
            } catch (ApiReflect.ReflectException e) {
                e.printStackTrace();
            }
            try {
                ApiReflect.on(resources2).set("mThemeValues", ApiReflect.on(resources).get("mThemeValues"));
            } catch (ApiReflect.ReflectException e2) {
                e2.printStackTrace();
            }
            return resources2;
        }
    }

    private static final class NubiaResourcesCompat {
        private NubiaResourcesCompat() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Resources createResources(Resources resources, AssetManager assetManager) throws Exception {
            try {
                return createNubiaResources(resources, assetManager);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    return AdaptationResourcesCompat.createResources(resources, assetManager);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        private static Resources createNubiaResources(Resources resources, AssetManager assetManager) throws Exception {
            Resources resources2 = (Resources) ApiReflect.onClass(ResourcesManager.NUBIA_RESOURCES).create(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).get();
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    private static final class AdaptationResourcesCompat {
        private AdaptationResourcesCompat() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Resources createResources(Resources resources, AssetManager assetManager) throws Exception {
            try {
                Resources resources2 = (Resources) ApiReflect.onClass(resources.getClass()).create(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).get();
                if (resources2 != null) {
                    return resources2;
                }
                throw new RuntimeException("Can not create Resources");
            } catch (Exception unused) {
                return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            }
        }
    }
}
