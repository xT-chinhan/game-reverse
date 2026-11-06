package com.byazt.nu;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.qk.oa;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1243, 8})
public class s {
    public static final String n = "tt_derive" + File.separator + "lottie" + File.separator + "anim_img";
    public static final String qg = "tt_derive" + File.separator + "lottie" + File.separator + "anim_video";

    public interface n<T> {
        void n(T t);
    }

    public static String n(Context context) {
        return com.byazt.tk.x.n(context, com.byazt.gkj.n.n().s().tj(), n).getAbsolutePath();
    }

    public static String qg(Context context) {
        return com.byazt.tk.x.n(context, com.byazt.gkj.n.n().s().tj(), qg).getAbsolutePath();
    }

    public static void n(String str, Context context, final n<File> nVar) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        final String strN = n(context);
        final String strQg = com.byazt.tk.l.qg(str);
        com.byazt.phf.s.n(str, strN, strQg).n(new com.byazt.qk.x() { // from class: com.byazt.nu.s.1
            @Override // com.byazt.qk.x
            public void n(oa oaVar) {
                if (nVar != null) {
                    File file = new File(strN, strQg);
                    if (file.exists()) {
                        nVar.n(file);
                    }
                }
            }

            @Override // com.byazt.qk.x
            public void n(int i, String str2, Throwable th) {
                if (nVar != null) {
                    th.getMessage();
                }
            }
        });
    }
}
