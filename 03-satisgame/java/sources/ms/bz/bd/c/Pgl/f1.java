package ms.bz.bd.c.Pgl;

import android.text.TextUtils;
import android.view.Display;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class f1 {
    private static f1 n;
    private String fs;
    private int l = 1;
    private long q;
    private long qg;
    private String rv;
    private long s;
    private boolean tj;
    private long w;
    private String x;

    private f1() {
    }

    public static Object n(Object obj, String str) {
        Field field;
        try {
            Method declaredMethod = Class.class.getDeclaredMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a4344c", new byte[]{119, 51, 84, 100, 14, 119, 110, 20, 112, 97, 116, 16, 73, 69, 7, 112}), String.class);
            if (declaredMethod == null || (field = (Field) declaredMethod.invoke(obj.getClass(), str)) == null) {
                return null;
            }
            field.setAccessible(true);
            return field.get(obj);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String n(Display[] displayArr) {
        try {
            StringBuilder sb = new StringBuilder();
            for (Display display : displayArr) {
                Object objN = n(display, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "08aa5e", new byte[]{44, 21, 5, 27, 15, 96, 3, 24, 51, 58, 32, 61, 23, 59, 11, 127, 54}));
                if (objN != null && !sb.toString().contains(objN.toString())) {
                    sb.append(objN);
                    sb.append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "bca9a4", new byte[]{40}));
                }
            }
            if (sb.length() > 0) {
                return sb.toString();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static f1 n() {
        if (n == null) {
            n = new f1();
        }
        return n;
    }

    public static String qg(Display[] displayArr) {
        try {
            StringBuilder sb = new StringBuilder();
            for (Display display : displayArr) {
                StringBuilder sb2 = new StringBuilder();
                Object objN = n(display, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d54154", new byte[]{120, 19, 78, 86, 26, 47, 102, 13, 76, 111, 115, 56}));
                sb2.append(n(objN, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "56baef", new byte[]{43, 35, 31, 16, 72, 65, 55, 20, 56, 48, 35, 49, com.anythink.core.common.r.a.c.c, 20, 87, 116}))).append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c203c0", new byte[]{62}));
                sb2.append(n(objN, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "fb8772", new byte[]{113, 108, 74, 68, 27}))).append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "6feb69", new byte[]{107}));
                sb2.append(n(objN, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "682a7c", new byte[]{41, 59, 76, 16}))).append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "8f658b", new byte[]{101}));
                sb2.append(n(objN, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "351619", new byte[]{54, 46, 82, 71})));
                if (!sb.toString().contains(sb2.toString())) {
                    if (sb.length() > 0) {
                        sb.append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "0c5cbc", new byte[]{122}));
                    }
                    sb.append((CharSequence) sb2);
                }
            }
            if (sb.length() > 0) {
                return sb.toString();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public final void n(int i) {
        if (this.l != i) {
            this.w = System.currentTimeMillis() / 1000;
        }
        this.l = i;
    }

    public final void n(long j) {
        this.qg = j;
        this.x = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "823206", new byte[]{40, 52, 68});
    }

    public final void n(String str) {
        this.fs = str;
    }

    public final boolean q() {
        return this.qg > 0 || this.s > 0 || this.w > 0;
    }

    public final void qg() {
        this.tj = true;
    }

    public final void qg(long j) {
        this.s = j;
        this.x = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a29db5", new byte[]{98, 53, 71, 31, 75, 39});
    }

    public final void qg(String str) {
        this.rv = str;
    }

    public final JSONObject s() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f68e89", new byte[]{118, 32}), this.qg);
            jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1dc446", new byte[]{50, 114}), this.s);
            jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c654a6", new byte[]{118, 57}), this.l);
            jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "834938", new byte[]{45, 37}), this.w);
            jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1eeb91", new byte[]{35, 102, 18}), this.tj ? 1 : 0);
            jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "92be12", new byte[]{37, 52}), this.x);
            if (!TextUtils.isEmpty(this.fs)) {
                jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1f8a34", new byte[]{48, 111}), this.fs);
            }
            if (!TextUtils.isEmpty(this.rv)) {
                jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "6f5e4a", new byte[]{35, 109}), this.rv);
            }
            this.q = System.currentTimeMillis();
            jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f1eeb7", new byte[]{116, 39}), this.q / 1000);
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
