package com.byazt.ptr;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.hcx.m;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 950, 20})
public class hn {
    public static final String pr = "tt_derive" + File.separator + "lottie" + File.separator + "anim_img";
    public static final String hw = "tt_derive" + File.separator + "lottie" + File.separator + "anim_video";

    public interface pr<T> {
        void pr(T t);
    }

    public static String pr(Context context) {
        return com.byazt.ca.fw.pr(context, com.byazt.bg.pr.pr().hn().vk(), pr).getAbsolutePath();
    }

    public static String hw(Context context) {
        return com.byazt.ca.fw.pr(context, com.byazt.bg.pr.pr().hn().vk(), hw).getAbsolutePath();
    }

    public static void pr(String str, Context context, final pr<File> prVar) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        final String strPr = pr(context);
        final String strHw = com.byazt.ca.c.hw(str);
        com.byazt.tf.hn.pr(str, strPr, strHw).pr(new com.byazt.hcx.fw() { // from class: com.byazt.ptr.hn.1
            @Override // com.byazt.hcx.fw
            public void pr(m mVar) {
                if (prVar != null) {
                    File file = new File(strPr, strHw);
                    if (file.exists()) {
                        prVar.pr(file);
                    }
                }
            }

            @Override // com.byazt.hcx.fw
            public void pr(int i, String str2, Throwable th) {
                if (prVar != null) {
                    th.getMessage();
                }
            }
        });
    }
}
