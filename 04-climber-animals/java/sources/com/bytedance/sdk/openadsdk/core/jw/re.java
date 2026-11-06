package com.bytedance.sdk.openadsdk.core.jw;

import android.content.Context;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.component.panglearmor.SoftDecTool;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import com.bytedance.sdk.openadsdk.core.nw.vy;
import com.umeng.analytics.pro.bv;
import com.umeng.ccg.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class re {
    public static int ah = 2;
    private static int d = 300;
    private static volatile com.bytedance.sdk.component.panglearmor.xr.d.ms ka = null;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static int f2728ms = 0;
    public static int xr = 1;

    public static void ms() {
        x();
        d();
        if (com.bytedance.sdk.openadsdk.core.re.xr().vm()) {
            ka();
            ah();
            ab();
            ch();
        }
    }

    static class ms implements com.bytedance.sdk.component.panglearmor.x {
        ms() {
        }

        @Override // com.bytedance.sdk.component.panglearmor.x
        public void ms(long j, boolean z) {
            com.bytedance.sdk.openadsdk.core.t.u.ms().ms(10001, j, Boolean.valueOf(z), (String) null);
        }

        @Override // com.bytedance.sdk.component.panglearmor.x
        public void ms(String str, JSONObject jSONObject) {
            if (TextUtils.isEmpty(str) || jSONObject == null || jSONObject.length() <= 0) {
                return;
            }
            re.ms(jSONObject.toString(), str);
        }
    }

    public static void ms(Context context) {
        com.bytedance.sdk.component.panglearmor.ab.ms msVarMs = new com.bytedance.sdk.component.panglearmor.ab.ms(context, com.bytedance.sdk.openadsdk.core.g.ms(context), "6923").ms(true);
        msVarMs.ms(new ms());
        com.bytedance.sdk.component.panglearmor.c.ms(msVarMs.ms());
    }

    public static JSONArray xr() {
        UsbAccessory[] accessoryList = ((UsbManager) com.bytedance.sdk.openadsdk.core.re.getContext().getSystemService("usb")).getAccessoryList();
        JSONArray jSONArray = new JSONArray();
        if (accessoryList != null) {
            for (UsbAccessory usbAccessory : accessoryList) {
                if (usbAccessory != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("manufacturer", usbAccessory.getManufacturer());
                        jSONObject.put("model", usbAccessory.getModel());
                        jSONObject.put(com.anythink.basead.c.b.a.f, usbAccessory.getDescription());
                        jSONObject.put("uri", usbAccessory.getUri());
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        com.bytedance.sdk.component.utils.sl.ms(e);
                    }
                }
            }
        }
        return jSONArray;
    }

    public static void ah() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArrayXr = xr();
            if (jSONArrayXr.length() > 0) {
                jSONObject.put("usb", jSONArrayXr);
            }
            JSONObject jSONObject2 = new JSONObject();
            ClassLoader classLoader = Class.forName("com.bytedance.sdk.openadsdk.TTFileProvider").getClassLoader();
            if (classLoader != null) {
                jSONObject2.put("loader", classLoader.getClass().getName());
                for (Class<? super Object> superclass = classLoader.getClass().getSuperclass(); superclass != null && !superclass.getName().equals("java.lang.Object"); superclass = superclass.getSuperclass()) {
                    if (superclass.getName().equals("dalvik.system.BaseDexClassLoader")) {
                        ms(classLoader, superclass, jSONObject2);
                        break;
                    }
                }
            }
            jSONObject.put("control", jSONObject2);
        } catch (Throwable unused) {
        }
        if (jSONObject.length() > 0) {
            ms(jSONObject.toString(), "pangle_check");
        }
    }

    private static void ms(ClassLoader classLoader, Class<?> cls, JSONObject jSONObject) throws Exception {
        Field declaredField = cls.getDeclaredField("pathList");
        declaredField.setAccessible(true);
        Object obj = declaredField.get(classLoader);
        if (obj != null) {
            Field declaredField2 = obj.getClass().getDeclaredField("dexElements");
            declaredField2.setAccessible(true);
            Object[] objArr = (Object[]) declaredField2.get(obj);
            if (objArr != null) {
                jSONObject.put("size", objArr.length);
                StringBuilder sb = new StringBuilder();
                for (Object obj2 : objArr) {
                    Field declaredField3 = obj2.getClass().getDeclaredField("dexFile");
                    declaredField3.setAccessible(true);
                    Object obj3 = declaredField3.get(obj2);
                    if (obj3 != null && !obj3.toString().startsWith("/data/app")) {
                        sb.append(obj3).append(";");
                    }
                }
                jSONObject.put("dexPathList", sb);
            }
        }
    }

    public static void ms(final String str, final String str2) {
        com.bytedance.sdk.openadsdk.core.t.u.ms().xr(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.jw.re.1
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() {
                return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms(str2).xr(str);
            }
        }, str2);
    }

    public static String d() {
        try {
            return com.bytedance.sdk.component.panglearmor.c.xr();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
            return ms(th);
        }
    }

    public static void ms(MotionEvent motionEvent) {
        try {
            com.bytedance.sdk.component.panglearmor.c.ms(motionEvent);
        } catch (Throwable unused) {
        }
    }

    public static String ms(String str, long j, int i, boolean z) {
        try {
            return com.bytedance.sdk.component.panglearmor.c.ms(str, j, i, z);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void ms(long j, int i) {
        try {
            com.bytedance.sdk.component.panglearmor.c.ms(j, i);
        } catch (Throwable unused) {
        }
    }

    public static int ms(String str) {
        int i = f2728ms;
        if (str == null || str.isEmpty()) {
            return ah;
        }
        int iIndexOf = str.indexOf("_");
        if (iIndexOf <= 0) {
            return ah;
        }
        String strSubstring = str.substring(0, iIndexOf);
        String strSubstring2 = str.substring(iIndexOf + 1);
        int iIndexOf2 = strSubstring2.indexOf("_");
        if (iIndexOf2 <= 0) {
            return ah;
        }
        String strSubstring3 = strSubstring2.substring(0, iIndexOf2);
        String strSubstring4 = strSubstring2.substring(iIndexOf2 + 1);
        long jLongValue = Long.valueOf(strSubstring).longValue() - Long.valueOf(strSubstring3).longValue();
        try {
            if (!com.bytedance.sdk.component.panglearmor.d.ms(strSubstring3 + "_" + com.bytedance.sdk.openadsdk.core.t.ah(), strSubstring4)) {
                return ah;
            }
            if (Math.abs(jLongValue) > d) {
                i = xr;
            }
            return i;
        } catch (Throwable unused) {
            return f2728ms;
        }
    }

    public static void ka() {
        String[] strArrCz = com.bytedance.sdk.openadsdk.core.re.xr().cz();
        if (strArrCz == null || strArrCz.length <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArrCz) {
            try {
                Class.forName(str);
                arrayList.add(str);
            } catch (ClassNotFoundException unused) {
            }
        }
        if (arrayList.size() > 0) {
            ms(arrayList);
        }
    }

    public static boolean c() {
        try {
            return com.bytedance.sdk.component.panglearmor.d.ms(com.bytedance.sdk.openadsdk.core.re.xr().ch());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
            return false;
        }
    }

    public static String ms(Throwable th) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("stts", 3);
            jSONObject.put("exception:", th.toString());
            jSONObject.put("stacktrace:", Arrays.toString(th.getStackTrace()));
            jSONObject.put("cause:", String.valueOf(th.getCause()));
            return Base64.encodeToString(jSONObject.toString().getBytes("UTF-8"), 0);
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.sl.ms(th2);
            return "eyJzdHRzIjozfQ==";
        }
    }

    private static void ms(final List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.t.u.ms().xr(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.jw.re.2
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("clz", list.toString());
                return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("pangle_clz_found").xr(jSONObject.toString());
            }
        }, "pangle_clz_found");
    }

    public static void ab() {
        com.bytedance.sdk.openadsdk.core.t.u.ms().xr(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.jw.re.3
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("board", Build.BOARD + "#" + com.bytedance.sdk.component.panglearmor.c.ms("ro.product.board", "unknown"));
                jSONObject.put("model", Build.MODEL + "#" + com.bytedance.sdk.component.panglearmor.c.ms("ro.product.model", "unknown"));
                jSONObject.put(bv.y, Build.VERSION.RELEASE + "#" + com.bytedance.sdk.component.panglearmor.c.ms("ro.build.version.release", "unknown"));
                jSONObject.put("vendor", Build.MANUFACTURER + "#" + com.bytedance.sdk.component.panglearmor.c.ms("ro.product.manufacturer", "unknown"));
                jSONObject.put("rom_version", Build.DISPLAY + "#" + com.bytedance.sdk.component.panglearmor.c.ms("ro.build.display.id", "unknown"));
                jSONObject.put("compiling_time", Build.TIME + "#" + (Long.parseLong(com.bytedance.sdk.component.panglearmor.c.ms("ro.build.date.utc", "-1")) * 1000));
                return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("pangle_build_pick").xr(jSONObject.toString());
            }
        }, "pangle_build_pick");
    }

    public static void ms(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.t.u.ms().xr(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.jw.re.4
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("har_automatic").xr(jSONObject.toString());
            }
        }, "har_automatic");
    }

    public static void xr(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.w.ah ahVar;
        if (jSONObject == null || com.bytedance.sdk.openadsdk.core.re.ms(AVMDLDataLoader.KeyIsStoRingBufferSizeKB) == null || (ahVar = (com.bytedance.sdk.openadsdk.core.w.ah) AutoService.ms(com.bytedance.sdk.openadsdk.core.w.ah.class)) == null || !ahVar.d()) {
            return;
        }
        ahVar.ah();
        ahVar.ms("antispam_handhold", jSONObject, new com.bytedance.sdk.openadsdk.core.w.ab() { // from class: com.bytedance.sdk.openadsdk.core.jw.re.5
            @Override // com.bytedance.sdk.openadsdk.core.w.ab
            protected ValueSet ms(int i, com.bytedance.sdk.openadsdk.core.w.x xVar) {
                Result resultAh = xVar.ah();
                if (resultAh == null) {
                    return null;
                }
                resultAh.isSuccess();
                ValueSet valueSetValues = resultAh.values();
                if (!resultAh.isSuccess() || valueSetValues == null) {
                    return null;
                }
                JSONObject jSONObject2 = (JSONObject) valueSetValues.objectValue(2, JSONObject.class);
                if (jSONObject2 != null) {
                    Object[] objArr = new Object[2];
                    try {
                        JSONArray jSONArray = jSONObject2.getJSONArray("probability");
                        if (jSONArray.length() == 1) {
                            SoftDecTool.ua(jSONArray.optDouble(0), System.currentTimeMillis());
                            Object[] objArr2 = new Object[2];
                            Double.valueOf(SoftDecTool.acs);
                        }
                    } catch (JSONException unused) {
                    }
                }
                return valueSetValues;
            }
        });
    }

    public static void ms(int i, final int i2) {
        if (com.bytedance.sdk.component.panglearmor.c.d() != null && com.bytedance.sdk.openadsdk.core.ch.ub().ka()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            boolean zXr = com.bytedance.sdk.component.panglearmor.xr.ka.ms().xr();
            boolean z = ((long) (i - 1)) % com.bytedance.sdk.component.panglearmor.xr.ka.ms().ka() == 0;
            boolean z2 = jCurrentTimeMillis - com.bytedance.sdk.component.panglearmor.xr.d.ms().d() > com.bytedance.sdk.component.panglearmor.xr.ka.ms().d();
            boolean zAh = com.bytedance.sdk.component.panglearmor.xr.d.ms().ah();
            com.bytedance.sdk.component.panglearmor.xr.ka.ms();
            com.bytedance.sdk.component.panglearmor.xr.ka.ms();
            com.bytedance.sdk.component.panglearmor.xr.ka.ms();
            com.bytedance.sdk.component.panglearmor.xr.ka.ms();
            double d2 = SoftDecTool.acs;
            long j = SoftDecTool.act;
            if (z && z2 && zXr && !zAh) {
                if (ka == null) {
                    ka = new com.bytedance.sdk.component.panglearmor.xr.d.ms() { // from class: com.bytedance.sdk.openadsdk.core.jw.re.6
                        @Override // com.bytedance.sdk.component.panglearmor.xr.d.ms
                        public void ms(JSONObject jSONObject) {
                            if (jSONObject != null) {
                                try {
                                    jSONObject.put(a.j, i2);
                                } catch (JSONException unused) {
                                }
                                re.xr(jSONObject);
                                re.ms(jSONObject);
                            }
                        }
                    };
                    com.bytedance.sdk.component.panglearmor.xr.d.ms().ms(ka);
                }
                com.bytedance.sdk.component.ch.ab.xr(new com.bytedance.sdk.component.ch.ny("har") { // from class: com.bytedance.sdk.openadsdk.core.jw.re.7
                    @Override // java.lang.Runnable
                    public void run() {
                        com.bytedance.sdk.component.panglearmor.xr.d.ms().xr();
                    }
                });
            }
        }
    }

    public static String x() {
        vy vyVarNy = ny();
        com.bytedance.sdk.openadsdk.core.ul.ms.ms().ms(vyVarNy);
        if (vyVarNy != null) {
            String string = vyVarNy.toString();
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
        }
        return null;
    }

    public static vy ny() {
        vy vyVarMs;
        try {
            if (!com.bytedance.sdk.openadsdk.core.re.xr().pn() || (vyVarMs = com.bytedance.sdk.openadsdk.core.pc.ms.ms(com.bytedance.sdk.openadsdk.core.re.getContext()).ms()) == null) {
                return null;
            }
            return vyVarMs;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void ch() {
        Context context = com.bytedance.sdk.openadsdk.core.re.getContext();
        if (context != null) {
            JSONObject jSONObject = new JSONObject();
            com.bytedance.sdk.openadsdk.core.pc.ms.ah ahVarMs = com.bytedance.sdk.openadsdk.core.pc.ms.ah.ms(context);
            try {
                jSONObject.put("access_perm", com.bytedance.sdk.openadsdk.core.i.xr.ms(context, com.kuaishou.weapon.p0.g.b));
                jSONObject.put("change_perm", com.bytedance.sdk.openadsdk.core.i.xr.ms(context, "android.permission.CHANGE_NETWORK_STATE"));
                jSONObject.put("sim", com.bytedance.sdk.openadsdk.core.pc.ms.ka.ms());
                jSONObject.put("network", ahVarMs.ms());
                ms(jSONObject.toString(), "uaid_info");
            } catch (Throwable unused) {
            }
        }
    }

    public static String hi() {
        return com.bytedance.sdk.component.panglearmor.c.ah();
    }
}
