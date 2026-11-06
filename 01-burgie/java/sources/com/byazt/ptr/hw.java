package com.byazt.ptr;

import android.text.TextUtils;
import com.byazt.hcx.m;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 950, 13})
public class hw {

    public interface pr {
        void pr(m mVar);

        void pr(Throwable th);
    }

    public static void pr(String str, File file, String str2, final pr prVar) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.tf.hn.pr(str, file.getAbsolutePath(), str2).pr(new com.byazt.hcx.fw() { // from class: com.byazt.ptr.hw.1
            @Override // com.byazt.hcx.fw
            public void pr(m mVar) {
                pr prVar2 = prVar;
                if (prVar2 != null) {
                    prVar2.pr(mVar);
                }
            }

            @Override // com.byazt.hcx.fw
            public void pr(int i, String str3, Throwable th) {
                pr prVar2 = prVar;
                if (prVar2 != null) {
                    prVar2.pr(th);
                }
            }
        });
    }
}
