package com.mcto.sspsdk.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;
import java.io.File;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class e6 implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;
    public final /* synthetic */ TextView c;

    public e6(Context context, TextView textView, String str) {
        this.a = context;
        this.b = str;
        this.c = textView;
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
        if (file.exists()) {
            file.setLastModified(System.currentTimeMillis());
        }
        if (!file.exists() || file.length() <= 512 || file.getName().endsWith(".tmp")) {
            String str2 = this.b;
            Context context2 = this.a;
            Set set = h6.a;
            if (set.contains(str2)) {
                return;
            }
            set.add(str2);
            zg.a.a(new f6(context2, str2));
            return;
        }
        try {
            Typeface typefaceCreateFromFile = Typeface.createFromFile(file);
            file.getName();
            kh.a.a(new d6(this, typefaceCreateFromFile));
            new Thread(new g6(this.a)).start();
        } catch (Exception e) {
            r9.a("ssp_font", "字体加载失败：" + e.getMessage(), null);
            file.delete();
        }
    }
}
