package com.anythink.core.common.t.a.b.a.b;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.AdError;
import com.anythink.core.common.l.e.i;
import com.anythink.core.common.l.s;
import com.anythink.core.e.d;
import com.varbto.utils.anr.AnrHandler;
import com.varbto.utils.api.MediationUtilsManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String e = "ANRReportPrefs";
    private static final String f = "last_anr_report_date";
    private static final String g = "anr_report_count";
    private List<File> d;
    private final String b = "a";
    private List<String> c = new ArrayList();
    private i.a h = new i.a() { // from class: com.anythink.core.common.t.a.b.a.b.a.1
        @Override // com.anythink.core.common.l.e.i.a
        public final void a(Throwable th) {
        }

        @Override // com.anythink.core.common.l.e.i.a
        public final void a(Object obj) {
            try {
                if (a.this.d == null || a.this.d.isEmpty() || a.this.d.get(0) == null) {
                    return;
                }
                MediationUtilsManager.getInstance(a.this.a).markAnrFileSent(((File) a.this.d.get(0)).getName(), 1);
            } catch (Throwable unused) {
            }
        }
    };
    private s i = new s() { // from class: com.anythink.core.common.t.a.b.a.b.a.2
        @Override // com.anythink.core.common.l.s
        public final void onLoadCanceled(int i) {
        }

        @Override // com.anythink.core.common.l.s
        public final void onLoadError(int i, String str, AdError adError) {
        }

        @Override // com.anythink.core.common.l.s
        public final void onLoadStart(int i) {
        }

        @Override // com.anythink.core.common.l.s
        public final void onLoadFinish(int i, Object obj) {
            try {
                if (a.this.d == null || a.this.d.isEmpty() || a.this.d.get(0) == null) {
                    return;
                }
                MediationUtilsManager.getInstance(a.this.a).markAnrFileSent(((File) a.this.d.get(0)).getName(), 1);
            } catch (Throwable unused) {
            }
        }
    };
    private Context a = com.anythink.core.common.d.s.b().g();

    public final void a() {
        long jCurrentTimeMillis;
        if (com.anythink.core.common.d.s.b().a()) {
            try {
                AnrHandler anrHandler = MediationUtilsManager.getInstance(this.a).getAnrHandler();
                if (anrHandler == null) {
                    return;
                }
                List<File> anrFileList = anrHandler.getAnrFileList("1");
                this.d = anrFileList;
                if (anrFileList != null && !anrFileList.isEmpty()) {
                    File file = this.d.get(0);
                    jCurrentTimeMillis = System.currentTimeMillis();
                    try {
                        String strA = a(file);
                        String name = file.getName();
                        try {
                            if (!TextUtils.isEmpty(name)) {
                                jCurrentTimeMillis = Long.parseLong(name);
                            }
                        } catch (Throwable unused) {
                        }
                        this.c.add(strA);
                    } catch (Throwable unused2) {
                    }
                }
                return;
            } catch (Throwable unused3) {
                jCurrentTimeMillis = 0;
            }
            long j = jCurrentTimeMillis;
            com.anythink.core.e.b bVarB = d.a(this.a).b(com.anythink.core.common.d.s.b().p());
            if (bVarB != null) {
                if (bVarB.aS() == 2) {
                    com.anythink.core.common.l.e.a aVar = new com.anythink.core.common.l.e.a(this.c, j);
                    aVar.a(1, bVarB.w());
                    aVar.a(this.h);
                    return;
                }
                new com.anythink.core.common.l.a(this.a, bVarB.x(), this.c, j).a(0, this.i);
                return;
            }
            new com.anythink.core.common.l.a(this.a, 0, this.c, j).a(0, this.i);
        }
    }

    private static String a(File file) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), Charset.forName("UTF-8")));
        try {
            char[] cArr = new char[8192];
            while (true) {
                int i = bufferedReader.read(cArr);
                if (i != -1) {
                    sb.append(cArr, 0, i);
                } else {
                    bufferedReader.close();
                    return sb.toString();
                }
            }
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
