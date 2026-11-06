package com.byazt.cl;

import android.content.Context;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.byazt.ehw.l;
import com.byazt.nf.rv;
import com.byazt.vf.k;
import com.byazt.vf.oa;
import com.byazt.vf.x;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.smartdigimkt.sdk.api.SDMAdConst;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1321, 8})
public class s {
    public static int n = 0;
    public static int q = 300;
    public static int qg = 1;
    public static int s = 2;

    public static void n() {
        cp();
        x();
        if (rv.qg().ei()) {
            fs();
            w();
            tj();
            oa();
        }
    }

    public static x qg() {
        return (x) com.byazt.qp.q.n("armor_service");
    }

    public static k s() {
        return (k) com.byazt.qp.q.n("encrypt_service");
    }

    public static JSONObject n(String str) {
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        try {
            try {
                k kVarS = s();
                String strS = kVarS != null ? kVarS.s(str) : null;
                if (!TextUtils.isEmpty(strS)) {
                    jSONObject.put("message", strS);
                    jSONObject.put("cypher", 3);
                } else {
                    jSONObject.put("message", str);
                    jSONObject.put("cypher", 0);
                }
            } catch (Throwable unused) {
                jSONObject.put("message", str);
                jSONObject.put("cypher", 0);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
        return jSONObject;
    }

    public static void q() {
        qg();
    }

    public static JSONArray l() {
        UsbAccessory[] accessoryList = ((UsbManager) rv.getContext().getSystemService("usb")).getAccessoryList();
        JSONArray jSONArray = new JSONArray();
        if (accessoryList != null) {
            for (UsbAccessory usbAccessory : accessoryList) {
                if (usbAccessory != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("manufacturer", usbAccessory.getManufacturer());
                        jSONObject.put("model", usbAccessory.getModel());
                        jSONObject.put(SDMAdConst.NETWORK_CUSTOM_KEY.DESC, usbAccessory.getDescription());
                        jSONObject.put(ContentProviderManager.PROVIDER_URI, usbAccessory.getUri());
                        jSONArray.put(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
            }
        }
        return jSONArray;
    }

    public static void w() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArrayL = l();
            if (jSONArrayL.length() > 0) {
                jSONObject.put("usb", jSONArrayL);
            }
            JSONObject jSONObject2 = new JSONObject();
            ClassLoader classLoader = Class.forName("com.bytedance.sdk.openadsdk.TTFileProvider").getClassLoader();
            if (classLoader != null) {
                jSONObject2.put("loader", classLoader.getClass().getName());
                for (Class<? super Object> superclass = classLoader.getClass().getSuperclass(); superclass != null && !superclass.getName().equals("java.lang.Object"); superclass = superclass.getSuperclass()) {
                    if (superclass.getName().equals("dalvik.system.BaseDexClassLoader")) {
                        n(classLoader, superclass, jSONObject2);
                        break;
                    }
                }
            }
            jSONObject.put("control", jSONObject2);
        } catch (Throwable unused) {
        }
        if (jSONObject.length() > 0) {
            n(jSONObject, "pangle_check");
        }
    }

    private static void n(ClassLoader classLoader, Class<?> cls, JSONObject jSONObject) throws Exception {
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

    public static void n(JSONObject jSONObject, String str) {
        com.byazt.eji.s.n().n(str, jSONObject);
    }

    public static String x() {
        try {
            return qg().n();
        } catch (Throwable th) {
            return n(th);
        }
    }

    public static int qg(String str) {
        int i = n;
        if (str == null || str.isEmpty()) {
            return s;
        }
        int iIndexOf = str.indexOf("_");
        if (iIndexOf <= 0) {
            return s;
        }
        String strSubstring = str.substring(0, iIndexOf);
        String strSubstring2 = str.substring(iIndexOf + 1);
        int iIndexOf2 = strSubstring2.indexOf("_");
        if (iIndexOf2 <= 0) {
            return s;
        }
        String strSubstring3 = strSubstring2.substring(0, iIndexOf2);
        String strSubstring4 = strSubstring2.substring(iIndexOf2 + 1);
        long jLongValue = Long.valueOf(strSubstring).longValue() - Long.valueOf(strSubstring3).longValue();
        try {
            x xVarQg = qg();
            if (xVarQg != null && !xVarQg.n(strSubstring3 + "_" + l.n(), strSubstring4)) {
                return s;
            }
            if (Math.abs(jLongValue) > q) {
                i = qg;
            }
            return i;
        } catch (Throwable unused) {
            return n;
        }
    }

    public static void fs() {
        String[] strArrSl = rv.qg().sl();
        if (strArrSl == null || strArrSl.length <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArrSl) {
            try {
                Class.forName(str);
                arrayList.add(str);
            } catch (ClassNotFoundException unused) {
            }
        }
        if (arrayList.size() > 0) {
            n(arrayList);
        }
    }

    public static boolean rv() {
        String strA = rv.qg().a();
        try {
            x xVarQg = qg();
            if (xVarQg != null) {
                return xVarQg.n(strA);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String n(Throwable th) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("stts", 3);
            jSONObject.put("exception:", th.toString());
            jSONObject.put("stacktrace:", Arrays.toString(th.getStackTrace()));
            jSONObject.put("cause:", String.valueOf(th.getCause()));
            return Base64.encodeToString(jSONObject.toString().getBytes("UTF-8"), 0);
        } catch (Throwable unused) {
            return "eyJzdHRzIjozfQ==";
        }
    }

    private static void n(final List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        com.byazt.eji.s.n().n("pangle_clz_found", new com.byazt.rs.n() { // from class: com.byazt.cl.s.1
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("clz", list.toString());
                return jSONObject2;
            }
        });
    }

    public static void tj() {
        com.byazt.eji.s.n().n("pangle_build_pick", new com.byazt.rs.n() { // from class: com.byazt.cl.s.2
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                x xVarQg = s.qg();
                if (xVarQg != null) {
                    jSONObject2.put("board", Build.BOARD + "#" + xVarQg.qg("ro.product.board", "unknown"));
                    jSONObject2.put("model", Build.MODEL + "#" + xVarQg.qg("ro.product.model", "unknown"));
                    jSONObject2.put("os_version", Build.VERSION.RELEASE + "#" + xVarQg.qg("ro.build.version.release", "unknown"));
                    jSONObject2.put("vendor", Build.MANUFACTURER + "#" + xVarQg.qg("ro.product.manufacturer", "unknown"));
                    jSONObject2.put("rom_version", Build.DISPLAY + "#" + xVarQg.qg("ro.build.display.id", "unknown"));
                    jSONObject2.put("compiling_time", Build.TIME + "#" + (Long.parseLong(xVarQg.qg("ro.build.date.utc", "-1")) * 1000));
                }
                return jSONObject2;
            }
        });
    }

    public static void n(int i, int i2) {
        x xVarQg = qg();
        if (xVarQg == null) {
            return;
        }
        xVarQg.n(i, i2, com.byazt.vyf.s.cy().q());
    }

    public static String cp() {
        com.byazt.eq.qg qgVarD = d();
        com.byazt.xf.n.n().n(qgVarD);
        if (qgVarD != null) {
            String string = qgVarD.toString();
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
        }
        return null;
    }

    public static com.byazt.eq.qg d() {
        com.byazt.eq.qg qgVarN;
        try {
            if (!rv.qg().ba() || (qgVarN = com.byazt.eq.n.n(rv.getContext()).n()) == null) {
                return null;
            }
            return qgVarN;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void oa() {
        Context context = rv.getContext();
        if (context != null) {
            JSONObject jSONObject = new JSONObject();
            com.byazt.tv.s sVarN = com.byazt.tv.s.n(context);
            try {
                jSONObject.put("access_perm", com.byazt.af.s.n(context, "android.permission.ACCESS_NETWORK_STATE"));
                jSONObject.put("change_perm", com.byazt.af.s.n(context, "android.permission.CHANGE_NETWORK_STATE"));
                jSONObject.put("sim", ((oa) com.byazt.qp.q.n("device_info_new")).lh());
                jSONObject.put("network", sVarN.n());
                n(jSONObject, "uaid_info");
            } catch (Throwable unused) {
            }
        }
    }

    public static String sz() {
        x xVarQg = qg();
        return xVarQg != null ? xVarQg.qg() : "";
    }
}
