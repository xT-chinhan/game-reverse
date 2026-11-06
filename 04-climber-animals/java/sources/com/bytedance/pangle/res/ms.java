package com.bytedance.pangle.res;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.text.TextUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.util.hi;
import com.bytedance.pangle.util.ny;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static Map<String, Integer> f674ms = new HashMap();
    private LinkedHashMap<String, Integer> xr;

    static {
        List<String> listMs = hi.ms();
        if (listMs == null || listMs.size() <= 0) {
            return;
        }
        Iterator<String> it = listMs.iterator();
        while (it.hasNext()) {
            f674ms.put(it.next(), 0);
        }
    }

    public ms() {
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        this.xr = linkedHashMap;
        linkedHashMap.put(Zeus.getAppApplication().getApplicationInfo().sourceDir, 0);
    }

    public AssetManager ms(AssetManager assetManager, String str, boolean z) {
        AssetManager assetManagerMs;
        if (str.endsWith(".frro")) {
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor updateAssetManager skip frro. ".concat(String.valueOf(str)));
            return assetManager;
        }
        if (ny.ms()) {
            if (ny.ab()) {
                assetManagerMs = ah(assetManager, str, z);
                if (!hi.ms(assetManagerMs, str)) {
                    assetManagerMs = xr(assetManager, str, z);
                }
            } else {
                assetManagerMs = xr(assetManager, str, z);
            }
        } else {
            assetManagerMs = ms(assetManager, str);
        }
        synchronized (this.xr) {
            this.xr.put(str, 0);
        }
        return assetManagerMs;
    }

    private AssetManager xr(AssetManager assetManager, String str, boolean z) {
        String str2 = "addAssetPath";
        String str3 = z ? "addAssetPathAsSharedLibrary" : "addAssetPath";
        if (ny.qv() && !z && str.startsWith("/product/overlay/")) {
            str3 = "addOverlayPath";
        }
        Method accessibleMethod = MethodUtils.getAccessibleMethod(AssetManager.class, str3, String.class);
        if (accessibleMethod == null && z) {
            accessibleMethod = MethodUtils.getAccessibleMethod(AssetManager.class, "addAssetPath", String.class);
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor AssetManager.addAssetPath() invoke addAssetPathAsSharedLibrary failed. use addAssetPath.");
        } else {
            str2 = str3;
        }
        if (accessibleMethod != null) {
            int i = 3;
            while (true) {
                int i2 = i - 1;
                if (i < 0) {
                    break;
                }
                try {
                    int iIntValue = ((Integer) accessibleMethod.invoke(assetManager, str)).intValue();
                    if (iIntValue != 0) {
                        ZeusLogger.i(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.addAssetPath() success, cookie = " + iIntValue + ", path = " + str);
                        break;
                    }
                    ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.addAssetPath() failed, cookie = " + iIntValue + " " + str);
                } catch (Exception e) {
                    ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.addAssetPath() failed. asSharedLibrary = " + z + ", methodName = " + str2, e);
                }
                i = i2;
            }
        } else {
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor reflect AssetManager.addAssetPath() failed. addAssetPathMethod == null. asSharedLibrary = " + z + " methodName:" + str2);
        }
        return assetManager;
    }

    private AssetManager ah(AssetManager assetManager, String str, boolean z) {
        int i = 3;
        Throwable th = null;
        int i2 = 3;
        loop0: while (true) {
            int i3 = i2 - 1;
            if (i2 >= 0) {
                try {
                    synchronized (assetManager) {
                        int iIntValue = 0;
                        for (int i4 = 0; i4 < i; i4++) {
                            try {
                                if (ny.ka()) {
                                    iIntValue = ((Integer) MethodUtils.invokeMethod(assetManager, "addAssetPathNative", new Object[]{str}, new Class[]{String.class})).intValue();
                                } else if (ny.sl()) {
                                    iIntValue = ((Integer) MethodUtils.invokeMethod(assetManager, "addAssetPathNative", new Object[]{str, Boolean.valueOf(z)}, new Class[]{String.class, Boolean.TYPE})).intValue();
                                }
                                if (iIntValue != 0) {
                                    break loop0;
                                }
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                        if (iIntValue == 0) {
                            ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.appendAssetPathSafely() failed, cookie = " + iIntValue + " " + str);
                        } else {
                            Object field = FieldUtils.readField(assetManager, "mStringBlocks");
                            int length = field != null ? Array.getLength(field) : 0;
                            int iIntValue2 = ((Integer) MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new Object[0])).intValue();
                            Object objNewInstance = Array.newInstance(field.getClass().getComponentType(), iIntValue2);
                            for (int i5 = 0; i5 < iIntValue2; i5++) {
                                if (i5 < length) {
                                    Array.set(objNewInstance, i5, Array.get(field, i5));
                                } else {
                                    Array.set(objNewInstance, i5, MethodUtils.invokeConstructor(field.getClass().getComponentType(), new Object[]{Long.valueOf(((Long) MethodUtils.invokeMethod(assetManager, "getNativeStringBlock", new Object[]{Integer.valueOf(i5)}, new Class[]{Integer.TYPE})).longValue()), Boolean.TRUE}, new Class[]{Long.TYPE, Boolean.TYPE}));
                                }
                            }
                            FieldUtils.writeField(assetManager, "mStringBlocks", objNewInstance);
                            ZeusLogger.d(ZeusLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely success, sourceDir = ".concat(String.valueOf(str)));
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    i2 = i3;
                    i = 3;
                }
            }
            if (th != null) {
                if (!ny.nw()) {
                    ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely failed, sourceDir = ".concat(String.valueOf(str)), th);
                }
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely failed, sourceDir = ".concat(String.valueOf(str)), th);
            }
            return assetManager;
        }
    }

    private AssetManager ms(AssetManager assetManager, String str) {
        AssetManager assetManager2;
        List<String> listMs = hi.ms(assetManager);
        ArrayList<String> arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        for (String str2 : listMs) {
            if (!f674ms.containsKey(str2) && !this.xr.containsKey(str2) && !str2.equals(str)) {
                arrayList.add(str2);
            }
        }
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager, runtimeAdditionalAssets path = ".concat(String.valueOf(str)));
        try {
            if (assetManager.getClass().getName().equals("android.content.res.BaiduAssetManager")) {
                assetManager2 = (AssetManager) Class.forName("android.content.res.BaiduAssetManager").getConstructor(new Class[0]).newInstance(new Object[0]);
            } else {
                assetManager2 = (AssetManager) AssetManager.class.newInstance();
            }
            ZeusLogger.i(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager = ".concat(String.valueOf(assetManager2)));
            synchronized (this.xr) {
                for (Map.Entry<String, Integer> entry : this.xr.entrySet()) {
                    if (!f674ms.containsKey(entry.getKey())) {
                        sb.append(entry.getKey());
                        xr(assetManager2, entry.getKey(), false);
                    }
                }
            }
            if (!sb.toString().contains(Zeus.getAppApplication().getApplicationInfo().sourceDir)) {
                xr(assetManager2, Zeus.getAppApplication().getApplicationInfo().sourceDir, false);
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager lost host path : " + f674ms.containsKey(Zeus.getAppApplication().getApplicationInfo().sourceDir));
            }
            sb.append(str);
            xr(assetManager2, str, false);
            if (!arrayList.isEmpty()) {
                for (String str3 : arrayList) {
                    sb.append(str3);
                    xr(assetManager2, str3, false);
                }
            }
            if (ny.c() && !sb.toString().toLowerCase().contains("webview")) {
                try {
                    Resources resources = Zeus.getAppApplication().getResources();
                    String str4 = Zeus.getAppApplication().createPackageContext(resources.getString(resources.getIdentifier("android:string/config_webViewPackageName", "string", "android")), 0).getApplicationInfo().sourceDir;
                    if (!TextUtils.isEmpty(str4)) {
                        xr(assetManager2, str4, false);
                    }
                } catch (Exception e) {
                    ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager appendAsset webview failed.", e);
                }
            }
            assetManager = assetManager2;
        } catch (Exception e2) {
            ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager failed.", e2);
            xr(assetManager, str, false);
        }
        try {
            MethodUtils.invokeMethod(assetManager, "ensureStringBlocks", new Object[0]);
            ZeusLogger.i(ZeusLogger.TAG_LOAD, "AssetManagerProcessor ensureStringBlocks");
        } catch (Exception e3) {
            ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "AssetManagerProcessor ensureStringBlocks failed.", e3);
        }
        return assetManager;
    }
}
