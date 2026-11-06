package com.mcto.sspsdk.internal;

import android.content.Context;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class f6 implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;

    public f6(Context context, String str) {
        this.a = context;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.a;
        String str = this.b;
        File fileB = ij.b(context);
        if (!fileB.exists()) {
            fileB.mkdirs();
        }
        File file = new File(fileB, str.hashCode() + ".ttf");
        File file2 = new File(file.getAbsolutePath() + ".tmp");
        if (file2.exists()) {
            file2.delete();
        }
        try {
            try {
                h6.a(file2, this.b);
                if (!file2.renameTo(file)) {
                    throw new IOException("重命名失败");
                }
                file.getAbsolutePath();
                if (file2.exists()) {
                    file2.delete();
                }
                h6.a.remove(this.b);
            } catch (Exception e) {
                r9.a("ssp_font", "字体下载失败：" + e.getMessage(), null);
                if (file2.exists()) {
                    file2.delete();
                }
                h6.a.remove(this.b);
            }
        } catch (Throwable th) {
            if (file2.exists()) {
                file2.delete();
            }
            h6.a.remove(this.b);
            throw th;
        }
    }
}
