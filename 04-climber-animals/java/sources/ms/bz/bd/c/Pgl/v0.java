package ms.bz.bd.c.Pgl;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.umeng.analytics.pro.ek;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public final class v0 {
    public static void ms() {
        pbly.ms(65537, new o0());
        pbly.ms(65538, new p0());
        pbly.ms(65539, new q0());
        pbly.ms(InputDeviceCompat.SOURCE_TRACKBALL, new r0());
        pbly.ms(65541, new s0());
        pbly.ms(65542, new t0());
        pbly.ms(65543, new u0());
        r1 r1Var = new r1();
        pbly.ms(196609, r1Var);
        pbly.ms(196610, r1Var);
        pbly.ms(196611, r1Var);
        pblw o1Var = pbli.ms() ? new o1() : new pblj();
        pblw.ms(o1Var);
        pbly.ms(131073, o1Var);
        pbly.ms(131074, o1Var);
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "30f38f", new byte[]{39, 36, ek.n, 73, 19, 93, com.anythink.core.common.s.a.c.c, 22, 26, 98, 44, 51, 18, 66, 21, 49, 51, 29, 54, 112, 49, 114, 28, 84, 71});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean xr(Context context, String str, String str2) {
        try {
            String[] list = context.getAssets().list(str);
            if (list.length <= 0) {
                try {
                    throw null;
                } catch (Throwable th) {
                    throw th;
                }
            }
            new File(str2).mkdirs();
            for (String str3 : list) {
                xr(context, str + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "590b88", new byte[]{107})) + str3, str2 + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "8c506d", new byte[]{102})) + str3);
            }
            return true;
        } catch (Exception unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "9e93c8", new byte[]{43, 102, 76});
            return false;
        }
    }
}
