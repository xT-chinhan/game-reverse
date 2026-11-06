package ms.bz.bd.c.Pgl;

import android.text.TextUtils;
import android.view.Display;
import com.umeng.analytics.pro.cc;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class f1 {
    private static f1 pr;
    private String aj;
    private int c = 1;
    private String fw;
    private long hn;
    private long hw;
    private long uc;
    private boolean vk;
    private long x;
    private String zo;

    private f1() {
    }

    public static String hw(Display[] displayArr) {
        try {
            StringBuilder sb = new StringBuilder();
            for (Display display : displayArr) {
                StringBuilder sb2 = new StringBuilder();
                Object objPr = pr(display, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d54154", new byte[]{120, 19, 78, 86, 26, 47, 102, cc.k, 76, 111, 115, 56}));
                sb2.append(pr(objPr, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "56baef", new byte[]{43, 35, 31, cc.n, 72, 65, 55, 20, 56, 48, 35, 49, 63, 20, 87, 116}))).append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c203c0", new byte[]{62}));
                sb2.append(pr(objPr, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "fb8772", new byte[]{113, 108, 74, 68, 27}))).append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "6feb69", new byte[]{107}));
                sb2.append(pr(objPr, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "682a7c", new byte[]{41, 59, 76, cc.n}))).append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "8f658b", new byte[]{101}));
                sb2.append(pr(objPr, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "351619", new byte[]{54, 46, 82, 71})));
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
        } catch (Exception e) {
            return null;
        }
    }

    public static Object pr(Object obj, String str) {
        Field field;
        try {
            Method declaredMethod = Class.class.getDeclaredMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a4344c", new byte[]{119, 51, 84, 100, cc.l, 119, 110, 20, 112, 97, 116, cc.n, 73, 69, 7, 112}), String.class);
            if (declaredMethod == null || (field = (Field) declaredMethod.invoke(obj.getClass(), str)) == null) {
                return null;
            }
            field.setAccessible(true);
            return field.get(obj);
        } catch (Throwable th) {
            return null;
        }
    }

    public static String pr(Display[] displayArr) {
        try {
            StringBuilder sb = new StringBuilder();
            for (Display display : displayArr) {
                Object objPr = pr(display, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "08aa5e", new byte[]{44, 21, 5, 27, cc.m, 96, 3, 24, 51, 58, 32, 61, 23, 59, 11, 127, 54}));
                if (objPr != null && !sb.toString().contains(objPr.toString())) {
                    sb.append(objPr);
                    sb.append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "bca9a4", new byte[]{40}));
                }
            }
            if (sb.length() > 0) {
                return sb.toString();
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static f1 pr() {
        if (pr == null) {
            pr = new f1();
        }
        return pr;
    }

    public final JSONObject hn() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f68e89", new byte[]{118, 32}), this.hw);
            jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1dc446", new byte[]{50, 114}), this.hn);
            jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c654a6", new byte[]{118, 57}), this.c);
            jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "834938", new byte[]{45, 37}), this.uc);
            jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1eeb91", new byte[]{35, 102, 18}), this.vk ? 1 : 0);
            jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "92be12", new byte[]{37, 52}), this.fw);
            if (!TextUtils.isEmpty(this.zo)) {
                jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1f8a34", new byte[]{48, 111}), this.zo);
            }
            if (!TextUtils.isEmpty(this.aj)) {
                jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "6f5e4a", new byte[]{35, 109}), this.aj);
            }
            this.x = System.currentTimeMillis();
            jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f1eeb7", new byte[]{116, 39}), this.x / 1000);
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public final void hw() {
        this.vk = true;
    }

    public final void hw(long j) {
        this.hn = j;
        this.fw = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a29db5", new byte[]{98, 53, 71, 31, 75, 39});
    }

    public final void hw(String str) {
        this.aj = str;
    }

    public final void pr(int i) {
        if (this.c != i) {
            this.uc = System.currentTimeMillis() / 1000;
        }
        this.c = i;
    }

    public final void pr(long j) {
        this.hw = j;
        this.fw = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "823206", new byte[]{40, 52, 68});
    }

    public final void pr(String str) {
        this.zo = str;
    }

    public final boolean x() {
        return this.hw > 0 || this.hn > 0 || this.uc > 0;
    }
}
