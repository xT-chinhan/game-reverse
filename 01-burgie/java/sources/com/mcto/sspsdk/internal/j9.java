package com.mcto.sspsdk.internal;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/* JADX INFO: loaded from: classes2.dex */
public final class j9 {
    public final File a;
    public final File b;
    public long c;
    public int d;

    public j9() {
        this.c = 0L;
        this.d = 0;
        Context context = jd.a;
        File file = context == null ? null : new File(context.getCacheDir(), ".issp_log");
        if (file == null) {
            return;
        }
        if (file.exists() || file.mkdirs()) {
            File file2 = new File(file, "cupid_ssp_ad_1.log");
            this.a = file2;
            File file3 = new File(file, "cupid_ssp_ad_2.log");
            this.b = file3;
            long length = file2.length();
            this.c = length;
            long length2 = file3.length();
            if (length2 < length) {
                this.c = length2;
                this.d = 1;
            }
        }
    }

    public final void a(String str) {
        boolean z;
        long j = this.c;
        if (j > 2048000) {
            z = false;
            this.d ^= 1;
            this.c = str.length();
        } else {
            this.c = j + ((long) str.length());
            z = true;
        }
        File file = this.d == 1 ? this.b : this.a;
        if (file == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, z));
            try {
                bufferedWriter.write(str);
                bufferedWriter.flush();
                bufferedWriter.close();
            } catch (Throwable th) {
                try {
                    bufferedWriter.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Exception e) {
            r9.a("ssp_sdk", "ssp_log_file", e);
        }
    }
}
