package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.support.v4.view.InputDeviceCompat;
import com.umeng.analytics.pro.cc;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class r0 {
    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hw(Context context, String str, String str2) {
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
                hw(context, str + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "677c00", new byte[]{104})) + str3, str2 + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "5e5874", new byte[]{107})) + str3);
            }
            return true;
        } catch (Exception e) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "5ee050", new byte[]{39, 102, cc.n});
            return false;
        }
    }

    public static void pr() {
        pbls.pr(65537, new k0());
        pbls.pr(65538, new l0());
        pbls.pr(65539, new m0());
        pbls.pr(InputDeviceCompat.SOURCE_TRACKBALL, new n0());
        pbls.pr(65541, new o0());
        pbls.pr(65542, new p0());
        pbls.pr(65543, new q0());
        l1 l1Var = new l1();
        pbls.pr(196609, l1Var);
        pbls.pr(196610, l1Var);
        pbls.pr(196611, l1Var);
        pbla i1Var = pblg.pr() ? new i1() : new pblh();
        pbla.pr(i1Var);
        pbls.pr(131073, i1Var);
        pbls.pr(131074, i1Var);
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "8209b5", new byte[]{44, 38, 70, 67, 73, cc.l, 52, 20, 76, 104, 39, 49, 68, 72, 79, 98, 56, 31, 96, 122, 58, 112, 74, 94, 29});
        i1Var.getClass();
    }
}
