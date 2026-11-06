package com.smartdigimkt.k;

import android.database.Cursor;
import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements Runnable {
    public final /* synthetic */ o a;

    public h(o oVar) {
        this.a = oVar;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0055 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x0056  */
    /* JADX WARN: Code duplicated, block: B:25:0x0068  */
    /* JADX WARN: Code duplicated, block: B:27:0x007a  */
    /* JADX WARN: Code duplicated, block: B:29:0x009e  */
    /* JADX WARN: Code duplicated, block: B:30:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:33:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:34:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:36:0x00ec  */
    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList;
        Cursor cursorQuery;
        String packageName;
        int i;
        com.smartdigimkt.b3.f fVar;
        boolean zEquals;
        long jCurrentTimeMillis;
        int i2;
        com.smartdigimkt.z2.g gVar = this.a.b;
        synchronized (gVar) {
            arrayList = new ArrayList();
            try {
                cursorQuery = gVar.a().query("download_task", null, "status = 5 AND is_upload_installed_agentevent != 1 AND download_end_timestamp >= " + (System.currentTimeMillis() - com.anythink.core.e.i.f), null, null, null, "download_start_timestamp");
                while (cursorQuery.moveToNext()) {
                    try {
                        arrayList.add(com.smartdigimkt.z2.g.a(cursorQuery));
                    } catch (Throwable th) {
                        th = th;
                        try {
                            th.getMessage();
                            if (cursorQuery != null) {
                            }
                            if (arrayList.size() == 0) {
                                return;
                            }
                            arrayList.size();
                            packageName = this.a.a.getPackageName();
                            i = 0;
                            while (i < arrayList.size()) {
                                fVar = (com.smartdigimkt.b3.f) arrayList.get(i);
                                if (com.smartdigimkt.n.b.b(this.a.a, fVar.f)) {
                                    zEquals = TextUtils.equals(packageName, com.smartdigimkt.n.b.a(this.a.a, fVar.f));
                                    String str = fVar.c;
                                    String str2 = fVar.H;
                                    String str3 = fVar.J;
                                    String str4 = fVar.I;
                                    String str5 = fVar.u;
                                    String str6 = fVar.d;
                                    String str7 = fVar.f;
                                    jCurrentTimeMillis = 0;
                                    if (fVar.A > 0) {
                                        jCurrentTimeMillis = System.currentTimeMillis() - fVar.A;
                                    }
                                    if (zEquals) {
                                        i2 = 2;
                                    } else {
                                        i2 = 3;
                                    }
                                    com.smartdigimkt.f3.c cVar = new com.smartdigimkt.f3.c(null, null);
                                    cVar.a = "1004713";
                                    cVar.b = str;
                                    cVar.c = str2;
                                    cVar.l = str3;
                                    cVar.m = str4;
                                    cVar.n = str5;
                                    cVar.o = str6;
                                    cVar.p = str7;
                                    cVar.q = String.valueOf(jCurrentTimeMillis);
                                    cVar.r = String.valueOf(2);
                                    cVar.s = String.valueOf(i2);
                                    com.smartdigimkt.n3.k.a(cVar);
                                    fVar.C = 1;
                                    this.a.b.a(fVar);
                                } else {
                                    i = i;
                                    arrayList = arrayList;
                                }
                                i++;
                                arrayList = arrayList;
                            }
                        } catch (Throwable th2) {
                            if (cursorQuery == null) {
                                throw th2;
                            }
                            cursorQuery.close();
                            throw th2;
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                cursorQuery = null;
            }
            cursorQuery.close();
        }
        if (arrayList.size() == 0) {
            return;
        }
        arrayList.size();
        packageName = this.a.a.getPackageName();
        i = 0;
        while (i < arrayList.size()) {
            fVar = (com.smartdigimkt.b3.f) arrayList.get(i);
            if (com.smartdigimkt.n.b.b(this.a.a, fVar.f)) {
                zEquals = TextUtils.equals(packageName, com.smartdigimkt.n.b.a(this.a.a, fVar.f));
                String str8 = fVar.c;
                String str9 = fVar.H;
                String str10 = fVar.J;
                String str11 = fVar.I;
                String str12 = fVar.u;
                String str13 = fVar.d;
                String str14 = fVar.f;
                jCurrentTimeMillis = 0;
                if (fVar.A > 0) {
                    jCurrentTimeMillis = System.currentTimeMillis() - fVar.A;
                }
                if (zEquals) {
                    i2 = 2;
                } else {
                    i2 = 3;
                }
                com.smartdigimkt.f3.c cVar2 = new com.smartdigimkt.f3.c(null, null);
                cVar2.a = "1004713";
                cVar2.b = str8;
                cVar2.c = str9;
                cVar2.l = str10;
                cVar2.m = str11;
                cVar2.n = str12;
                cVar2.o = str13;
                cVar2.p = str14;
                cVar2.q = String.valueOf(jCurrentTimeMillis);
                cVar2.r = String.valueOf(2);
                cVar2.s = String.valueOf(i2);
                com.smartdigimkt.n3.k.a(cVar2);
                fVar.C = 1;
                this.a.b.a(fVar);
            } else {
                i = i;
                arrayList = arrayList;
            }
            i++;
            arrayList = arrayList;
        }
    }
}
