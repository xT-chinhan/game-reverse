package com.byazt.ye;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.text.TextUtils;
import com.byazt.gx.cp;
import com.byazt.gx.rv;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 985, 19})
public class n {
    public static Map<String, Integer> n = new HashMap();
    public LinkedHashMap<String, Integer> qg;

    static {
        List<String> listN = cp.n();
        if (listN == null || listN.size() <= 0) {
            return;
        }
        Iterator<String> it = listN.iterator();
        while (it.hasNext()) {
            n.put(it.next(), 0);
        }
    }

    public n() {
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        this.qg = linkedHashMap;
        linkedHashMap.put(Zeus.getAppApplication().getApplicationInfo().sourceDir, 0);
    }

    public AssetManager n(AssetManager assetManager, String str, boolean z) {
        AssetManager assetManagerN;
        if (str.endsWith(".frro")) {
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor updateAssetManager skip frro. ".concat(String.valueOf(str)));
            return assetManager;
        }
        if (rv.n()) {
            if (rv.w()) {
                assetManagerN = s(assetManager, str, z);
                if (!cp.n(assetManagerN, str)) {
                    assetManagerN = qg(assetManager, str, z);
                }
            } else {
                assetManagerN = qg(assetManager, str, z);
            }
        } else {
            assetManagerN = n(assetManager, str);
        }
        synchronized (this.qg) {
            this.qg.put(str, 0);
        }
        return assetManagerN;
    }

    private AssetManager qg(AssetManager assetManager, String str, boolean z) {
        String str2 = "addAssetPath";
        String str3 = z ? "addAssetPathAsSharedLibrary" : "addAssetPath";
        if (rv.hd() && !z && str.startsWith("/product/overlay/")) {
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

    private AssetManager s(AssetManager assetManager, String str, boolean z) {
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
                                if (rv.q()) {
                                    iIntValue = ((Integer) MethodUtils.invokeMethod(assetManager, "addAssetPathNative", new Object[]{str}, new Class[]{String.class})).intValue();
                                } else if (rv.cp()) {
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
                if (!rv.a()) {
                    ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely failed, sourceDir = ".concat(String.valueOf(str)), th);
                }
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely failed, sourceDir = ".concat(String.valueOf(str)), th);
            }
            return assetManager;
        }
    }

    private AssetManager n(AssetManager assetManager, String str) {
        AssetManager assetManager2;
        List<String> listN = cp.n(assetManager);
        ArrayList<String> arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        for (String str2 : listN) {
            if (!n.containsKey(str2) && !this.qg.containsKey(str2) && !str2.equals(str)) {
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
            synchronized (this.qg) {
                for (Map.Entry<String, Integer> entry : this.qg.entrySet()) {
                    if (!n.containsKey(entry.getKey())) {
                        sb.append(entry.getKey());
                        qg(assetManager2, entry.getKey(), false);
                    }
                }
            }
            if (!sb.toString().contains(Zeus.getAppApplication().getApplicationInfo().sourceDir)) {
                qg(assetManager2, Zeus.getAppApplication().getApplicationInfo().sourceDir, false);
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager lost host path : " + n.containsKey(Zeus.getAppApplication().getApplicationInfo().sourceDir));
            }
            sb.append(str);
            qg(assetManager2, str, false);
            if (!arrayList.isEmpty()) {
                for (String str3 : arrayList) {
                    sb.append(str3);
                    qg(assetManager2, str3, false);
                }
            }
            if (rv.l() && !sb.toString().toLowerCase().contains("webview")) {
                try {
                    Resources resources = Zeus.getAppApplication().getResources();
                    String str4 = Zeus.getAppApplication().createPackageContext(resources.getString(resources.getIdentifier("android:string/config_webViewPackageName", "string", "android")), 0).getApplicationInfo().sourceDir;
                    if (!TextUtils.isEmpty(str4)) {
                        qg(assetManager2, str4, false);
                    }
                } catch (Exception e) {
                    ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager appendAsset webview failed.", e);
                }
            }
            assetManager = assetManager2;
        } catch (Exception e2) {
            ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager failed.", e2);
            qg(assetManager, str, false);
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
