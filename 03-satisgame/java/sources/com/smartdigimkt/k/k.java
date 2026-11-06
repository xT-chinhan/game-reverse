package com.smartdigimkt.k;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements Runnable {
    public final /* synthetic */ List a;
    public final /* synthetic */ int b;
    public final /* synthetic */ com.smartdigimkt.j.b c;
    public final /* synthetic */ o d;

    public k(o oVar, ArrayList arrayList, int i, com.smartdigimkt.j.b bVar) {
        this.d = oVar;
        this.a = arrayList;
        this.b = i;
        this.c = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList;
        int i;
        ArrayList arrayList2 = new ArrayList();
        com.smartdigimkt.z2.g gVar = this.d.b;
        List list = this.a;
        int i2 = this.b;
        synchronized (gVar) {
            arrayList = new ArrayList();
            Cursor cursorQuery = null;
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("status IN (");
                for (int i3 = 0; i3 < list.size(); i3++) {
                    sb.append(list.get(i3));
                    if (i3 != list.size() - 1) {
                        sb.append(",");
                    }
                }
                sb.append(")");
                sb.append(" AND ");
                sb.append("download_start_timestamp");
                sb.append(" > ");
                sb.append(System.currentTimeMillis());
                sb.append(" - ");
                sb.append("offer_cache_time");
                if (i2 > 0) {
                    sb.append(" AND ");
                    sb.append(com.smartdigimkt.z2.f.b);
                    sb.append(" = ");
                    sb.append(i2);
                }
                cursorQuery = gVar.a().query("download_task", null, sb.toString(), null, null, null, "download_start_timestamp");
                while (cursorQuery.moveToNext()) {
                    arrayList.add(com.smartdigimkt.z2.g.a(cursorQuery));
                }
            } catch (Throwable th) {
                try {
                    th.getMessage();
                    if (cursorQuery != null) {
                    }
                } catch (Throwable th2) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th2;
                }
            }
            cursorQuery.close();
        }
        if (arrayList.size() > 0) {
            for (i = 0; i < arrayList.size(); i++) {
                arrayList2.add(o.a(this.d, (com.smartdigimkt.b3.f) arrayList.get(i)));
            }
        }
        com.smartdigimkt.j.b bVar = this.c;
        if (bVar != null) {
            bVar.a(arrayList2);
        }
    }
}
