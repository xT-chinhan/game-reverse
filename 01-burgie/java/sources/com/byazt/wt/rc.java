package com.byazt.wt;

import android.content.Context;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import com.bumptech.glide.load.Key;
import com.byazt.hg.j;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.umeng.analytics.pro.an;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 91})
public class rc {
    public static int pr = 0;
    public static int hw = 1;
    public static int hn = 2;
    public static int x = TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX;
    public static volatile com.byazt.vkw.fw.pr c = null;

    public static void pr() {
        w();
        fw();
        if (com.byazt.sd.a.hw().na()) {
            zo();
            uc();
            vk();
            m();
        }
    }

    public static com.byazt.vkw.fw hw() {
        return (com.byazt.vkw.fw) com.byazt.zs.uc.pr("armor_service");
    }

    public static com.byazt.vkw.nt hn() {
        return (com.byazt.vkw.nt) com.byazt.zs.uc.pr("encrypt_service");
    }

    public static JSONObject pr(String str) {
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        try {
            com.byazt.vkw.nt ntVarHn = hn();
            String strHn = ntVarHn != null ? ntVarHn.hn(str) : null;
            if (!TextUtils.isEmpty(strHn)) {
                jSONObject.put("message", strHn);
                jSONObject.put("cypher", 3);
            } else {
                jSONObject.put("message", str);
                jSONObject.put("cypher", 0);
            }
        } catch (Throwable th) {
            try {
                jSONObject.put("message", str);
                jSONObject.put("cypher", 0);
            } catch (Throwable th2) {
                th2.getMessage();
            }
        }
        return jSONObject;
    }

    public static void x() {
        hw();
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_TIMER_VERSION})
    public static class pr implements com.byazt.vkw.fw.hw {
        @Override // com.byazt.vkw.fw.hw
        public void pr(long j, boolean z) {
            com.byazt.xk.hw.pr().pr(10001, j, Boolean.valueOf(z), (String) null);
        }

        @Override // com.byazt.vkw.fw.hw
        public void pr(String str, JSONObject jSONObject) {
            if (!TextUtils.isEmpty(str) && jSONObject != null && jSONObject.length() > 0) {
                rc.pr(jSONObject, str);
            }
        }

        @Override // com.byazt.vkw.fw.hw
        public long pr() {
            return hn.hn();
        }
    }

    public static JSONArray c() {
        UsbAccessory[] accessoryList = ((UsbManager) com.byazt.sd.a.getContext().getSystemService("usb")).getAccessoryList();
        JSONArray jSONArray = new JSONArray();
        if (accessoryList != null) {
            for (UsbAccessory usbAccessory : accessoryList) {
                if (usbAccessory != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("manufacturer", usbAccessory.getManufacturer());
                        jSONObject.put("model", usbAccessory.getModel());
                        jSONObject.put("desc", usbAccessory.getDescription());
                        jSONObject.put(ContentProviderManager.PROVIDER_URI, usbAccessory.getUri());
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                    }
                }
            }
        }
        return jSONArray;
    }

    public static void uc() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArrayC = c();
            if (jSONArrayC.length() > 0) {
                jSONObject.put("usb", jSONArrayC);
            }
            JSONObject jSONObject2 = new JSONObject();
            ClassLoader classLoader = Class.forName("com.bytedance.sdk.openadsdk.TTFileProvider").getClassLoader();
            if (classLoader != null) {
                jSONObject2.put("loader", classLoader.getClass().getName());
                for (Class<? super Object> superclass = classLoader.getClass().getSuperclass(); superclass != null && !superclass.getName().equals("java.lang.Object"); superclass = superclass.getSuperclass()) {
                    if (superclass.getName().equals("dalvik.system.BaseDexClassLoader")) {
                        pr(classLoader, superclass, jSONObject2);
                        break;
                    }
                }
            }
            jSONObject.put("control", jSONObject2);
        } catch (Throwable th) {
        }
        if (jSONObject.length() > 0) {
            pr(jSONObject, "pangle_check");
        }
    }

    private static void pr(ClassLoader classLoader, Class<?> cls, JSONObject jSONObject) throws Exception {
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

    public static void pr(JSONObject jSONObject, String str) {
        com.byazt.xk.hw.pr().pr(str, jSONObject);
    }

    public static String fw() {
        try {
            return hw().pr();
        } catch (Throwable th) {
            return pr(th);
        }
    }

    public static void pr(MotionEvent motionEvent) {
        try {
            hw().pr(motionEvent);
        } catch (Throwable th) {
        }
    }

    public static String pr(String str, long j, int i, boolean z) {
        try {
            return hw().pr(str, j, i, z);
        } catch (Throwable th) {
            return null;
        }
    }

    public static void pr(long j, int i) {
        try {
            hw().pr(j, i);
        } catch (Throwable th) {
        }
    }

    public static int hw(String str) {
        int i = pr;
        if (str == null || str.isEmpty()) {
            return hn;
        }
        int iIndexOf = str.indexOf("_");
        if (iIndexOf <= 0) {
            return hn;
        }
        String strSubstring = str.substring(0, iIndexOf);
        String strSubstring2 = str.substring(iIndexOf + 1);
        int iIndexOf2 = strSubstring2.indexOf("_");
        if (iIndexOf2 <= 0) {
            return hn;
        }
        String strSubstring3 = strSubstring2.substring(0, iIndexOf2);
        String strSubstring4 = strSubstring2.substring(iIndexOf2 + 1);
        long jLongValue = Long.valueOf(strSubstring).longValue() - Long.valueOf(strSubstring3).longValue();
        try {
            com.byazt.vkw.fw fwVarHw = hw();
            if (fwVarHw != null && !fwVarHw.pr(strSubstring3 + "_" + nt.pr(), strSubstring4)) {
                return hn;
            }
            if (Math.abs(jLongValue) > x) {
                i = hw;
            }
            return i;
        } catch (Throwable th) {
            return pr;
        }
    }

    public static void zo() {
        String[] strArrRq = com.byazt.sd.a.hw().rq();
        if (strArrRq != null && strArrRq.length > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : strArrRq) {
                try {
                    Class.forName(str);
                    arrayList.add(str);
                } catch (ClassNotFoundException e) {
                }
            }
            if (arrayList.size() > 0) {
                pr(arrayList);
            }
        }
    }

    public static boolean aj() {
        String strA = com.byazt.sd.a.hw().a();
        try {
            com.byazt.vkw.fw fwVarHw = hw();
            if (fwVarHw == null) {
                return false;
            }
            return fwVarHw.pr(strA);
        } catch (Throwable th) {
            return false;
        }
    }

    public static String pr(Throwable th) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("stts", 3);
            jSONObject.put("exception:", th.toString());
            jSONObject.put("stacktrace:", Arrays.toString(th.getStackTrace()));
            jSONObject.put("cause:", String.valueOf(th.getCause()));
            return Base64.encodeToString(jSONObject.toString().getBytes(Key.STRING_CHARSET_NAME), 0);
        } catch (Throwable th2) {
            return "eyJzdHRzIjozfQ==";
        }
    }

    private static void pr(final List<String> list) {
        if (list != null && list.size() > 0) {
            com.byazt.xk.hw.pr().pr("pangle_clz_found", new com.byazt.ttf.pr() { // from class: com.byazt.wt.rc.1
                @Override // com.byazt.ttf.pr
                public JSONObject pr(JSONObject jSONObject) throws JSONException {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("clz", list.toString());
                    return jSONObject2;
                }
            });
        }
    }

    public static void vk() {
        com.byazt.xk.hw.pr().pr("pangle_build_pick", new com.byazt.ttf.pr() { // from class: com.byazt.wt.rc.2
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                com.byazt.vkw.fw fwVarHw = rc.hw();
                jSONObject2.put("board", Build.BOARD + "#" + fwVarHw.hw("ro.product.board", "unknown"));
                jSONObject2.put("model", Build.MODEL + "#" + fwVarHw.hw("ro.product.model", "unknown"));
                jSONObject2.put(an.y, Build.VERSION.RELEASE + "#" + fwVarHw.hw("ro.build.version.release", "unknown"));
                jSONObject2.put("vendor", Build.MANUFACTURER + "#" + fwVarHw.hw("ro.product.manufacturer", "unknown"));
                jSONObject2.put("rom_version", Build.DISPLAY + "#" + fwVarHw.hw("ro.build.display.id", "unknown"));
                jSONObject2.put("compiling_time", Build.TIME + "#" + (Long.parseLong(fwVarHw.hw("ro.build.date.utc", "-1")) * 1000));
                return jSONObject2;
            }
        });
    }

    public static void pr(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        com.byazt.xk.hw.pr().pr("har_automatic", new com.byazt.ttf.pr() { // from class: com.byazt.wt.rc.3
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject2) throws JSONException {
                return jSONObject;
            }
        });
    }

    public static void hw(JSONObject jSONObject) {
        com.byazt.r.hn hnVar;
        if (jSONObject == null || !com.byazt.ba.x.hw() || (hnVar = (com.byazt.r.hn) com.byazt.zs.uc.pr("pitaya_new")) == null) {
            return;
        }
        hnVar.pr("antispam_handhold", jSONObject, false, -1L, new com.byazt.la.w() { // from class: com.byazt.wt.rc.4
            @Override // com.byazt.la.w
            public void pr(String str, boolean z, long j, com.byazt.la.hn hnVar2, JSONObject jSONObject2, com.byazt.la.aj ajVar) {
                if (z && jSONObject2 != null) {
                    Object[] objArr = {"predict result ", jSONObject2};
                    try {
                        JSONArray jSONArray = jSONObject2.getJSONArray("probability");
                        if (jSONArray == null) {
                            return;
                        }
                        com.byazt.vkw.fw fwVarHw = rc.hw();
                        if (jSONArray.length() == 1 && fwVarHw != null) {
                            fwVarHw.pr(jSONArray.optDouble(0), System.currentTimeMillis());
                            return;
                        }
                        return;
                    } catch (JSONException e) {
                        return;
                    }
                }
                Object[] objArr2 = {"predict error ", hnVar2};
            }
        });
    }

    public static void pr(int i, final int i2) {
        final com.byazt.vkw.fw fwVarHw = hw();
        if (fwVarHw != null && fwVarHw.hw() != null && com.byazt.sd.zo.nt().x() && fwVarHw.hw(i)) {
            if (c == null) {
                c = new com.byazt.vkw.fw.pr() { // from class: com.byazt.wt.rc.5
                    @Override // com.byazt.vkw.fw.pr
                    public void pr(JSONObject jSONObject) {
                        if (jSONObject != null) {
                            try {
                                jSONObject.put("scene", i2);
                            } catch (JSONException e) {
                            }
                            rc.hw(jSONObject);
                            rc.pr(jSONObject);
                        }
                    }
                };
                fwVarHw.pr(c);
            }
            com.byazt.xlm.c.hw(new com.byazt.xlm.fw("har") { // from class: com.byazt.wt.rc.6
                @Override // java.lang.Runnable
                public void run() {
                    fwVarHw.x();
                }
            });
        }
    }

    public static String w() {
        j jVarK = k();
        com.byazt.vq.pr.pr().pr(jVarK);
        if (jVarK == null) {
            return null;
        }
        String string = jVarK.toString();
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string;
    }

    public static j k() {
        j jVarPr;
        try {
            if (com.byazt.sd.a.hw().sq() && (jVarPr = com.byazt.lk.pr.pr(com.byazt.sd.a.getContext()).pr()) != null) {
                return jVarPr;
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    public static void m() {
        Context context = com.byazt.sd.a.getContext();
        if (context != null) {
            JSONObject jSONObject = new JSONObject();
            com.byazt.mx.hn hnVarPr = com.byazt.mx.hn.pr(context);
            try {
                jSONObject.put("access_perm", com.byazt.qam.hw.pr(context, "android.permission.ACCESS_NETWORK_STATE"));
                jSONObject.put("change_perm", com.byazt.qam.hw.pr(context, "android.permission.CHANGE_NETWORK_STATE"));
                jSONObject.put("sim", ((com.byazt.vkw.g) com.byazt.zs.uc.pr("device_info_new")).y());
                jSONObject.put("network", hnVarPr.pr());
                pr(jSONObject, "uaid_info");
            } catch (Throwable th) {
            }
        }
    }

    public static String g() {
        com.byazt.vkw.fw fwVarHw = hw();
        return fwVarHw != null ? fwVarHw.hn() : "";
    }
}
