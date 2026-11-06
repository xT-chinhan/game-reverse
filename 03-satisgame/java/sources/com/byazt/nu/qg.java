package com.byazt.nu;

import android.text.TextUtils;
import com.byazt.qk.oa;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1243, 26})
public class qg {

    public interface n {
        void n(oa oaVar);

        void n(Throwable th);
    }

    public static void n(String str, File file, String str2, final n nVar) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.phf.s.n(str, file.getAbsolutePath(), str2).n(new com.byazt.qk.x() { // from class: com.byazt.nu.qg.1
            @Override // com.byazt.qk.x
            public void n(oa oaVar) {
                n nVar2 = nVar;
                if (nVar2 != null) {
                    nVar2.n(oaVar);
                }
            }

            @Override // com.byazt.qk.x
            public void n(int i, String str3, Throwable th) {
                n nVar2 = nVar;
                if (nVar2 != null) {
                    nVar2.n(th);
                }
            }
        });
    }
}
