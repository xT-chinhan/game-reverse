package com.smartdigimkt.u3;

import android.content.Context;
import android.database.Cursor;
import com.smartdigimkt.d0.s;
import com.smartdigimkt.h0.c;
import com.smartdigimkt.l1.e;
import com.smartdigimkt.o4.o;
import com.smartdigimkt.sdk.api.format.IMyOfferAdManager;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.z.e0;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements IMyOfferAdManager {
    public static volatile b a;

    @Override // com.smartdigimkt.sdk.api.format.IMyOfferAdManager
    public final boolean checkOffersOutOfCap(Context context, String str) {
        List<com.smartdigimkt.e3.a> list;
        if (context != null) {
            SDKContext.getInstance().a(context.getApplicationContext());
        }
        e eVarA = e.a(context);
        eVarA.getClass();
        com.smartdigimkt.p4.e eVarB = o.a().b(str);
        if (eVarB == null || (list = eVarB.D) == null || list.size() <= 0) {
            return false;
        }
        for (com.smartdigimkt.e3.a aVar : list) {
            c cVarA = eVarA.a(aVar);
            int i = aVar.c0;
            if (i == -1 || cVarA.d < i) {
                return false;
            }
        }
        return true;
    }

    @Override // com.smartdigimkt.sdk.api.format.IMyOfferAdManager
    public final String getDefaultOfferId(Context context, String str) {
        if (context != null) {
            SDKContext.getInstance().a(context.getApplicationContext());
        }
        com.smartdigimkt.l1.b bVarA = com.smartdigimkt.l1.b.a(context);
        bVarA.getClass();
        com.smartdigimkt.p4.e eVarB = o.a().b(str);
        if (eVarB == null) {
            return "";
        }
        List list = eVarB.D;
        ArrayList arrayList = new ArrayList();
        if (list == null || list.size() == 0) {
            return "";
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            com.smartdigimkt.e3.a aVar = (com.smartdigimkt.e3.a) list.get(size);
            e0 e0VarA = e0.a();
            int i = eVarB.m;
            com.smartdigimkt.e3.b bVar = eVarB.E;
            e0VarA.getClass();
            if (s.a(bVar, i, aVar)) {
                arrayList.add(e.a(bVarA.a).a(aVar));
            } else {
                list.remove(size);
            }
        }
        if (arrayList.size() == 0) {
            return "";
        }
        Collections.sort(arrayList, new com.smartdigimkt.l1.a());
        return ((c) arrayList.get(0)).a;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00e0 A[Catch: all -> 0x00e4, PHI: r0
      0x00e0: PHI (r0v9 android.database.Cursor) = 
      (r0v6 android.database.Cursor)
      (r0v7 android.database.Cursor)
      (r0v8 android.database.Cursor)
      (r0v12 android.database.Cursor)
     binds: [B:25:0x00cc, B:29:0x00d3, B:36:0x00de, B:22:0x00c8] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #2 {, blocks: (B:19:0x00c2, B:37:0x00e0, B:33:0x00d9, B:34:0x00dc, B:28:0x00d0), top: B:54:0x003a, inners: #3 }] */
    @Override // com.smartdigimkt.sdk.api.format.IMyOfferAdManager
    public final String getOutOfCapOfferIds(Context context) {
        ArrayList arrayList;
        Cursor cursorQuery;
        if (context != null) {
            SDKContext.getInstance().a(context.getApplicationContext());
        }
        e eVarA = e.a(context);
        eVarA.getClass();
        String str = ((SimpleDateFormat) e.d.get()).format(new Date(System.currentTimeMillis()));
        Context context2 = eVarA.a;
        if (com.smartdigimkt.g0.a.b == null) {
            com.smartdigimkt.g0.a.b = new com.smartdigimkt.g0.a(context2);
        }
        com.smartdigimkt.g0.a aVar = com.smartdigimkt.g0.a.b;
        synchronized (aVar) {
            arrayList = null;
            try {
                cursorQuery = com.smartdigimkt.g0.b.a(aVar.a).getReadableDatabase().query("my_offer_cap_pacing", null, "offer_cap <= show_num AND record_date = ? AND offer_cap  >= ?", new String[]{str, "0"}, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.getCount() > 0) {
                            ArrayList arrayList2 = new ArrayList();
                            while (cursorQuery.moveToNext()) {
                                c cVar = new c();
                                cVar.a = cursorQuery.getString(cursorQuery.getColumnIndex("offer_id"));
                                cVar.d = cursorQuery.getInt(cursorQuery.getColumnIndex("show_num"));
                                cVar.e = cursorQuery.getLong(cursorQuery.getColumnIndex("show_time"));
                                cVar.f = cursorQuery.getString(cursorQuery.getColumnIndex("record_date"));
                                cVar.b = cursorQuery.getInt(cursorQuery.getColumnIndex("offer_cap"));
                                cVar.c = cursorQuery.getLong(cursorQuery.getColumnIndex("offer_pacing"));
                                arrayList2.add(cVar);
                            }
                            cursorQuery.close();
                            cursorQuery.close();
                            arrayList = arrayList2;
                        }
                    } catch (Exception unused) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    } catch (OutOfMemoryError unused2) {
                        try {
                            System.gc();
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                        } catch (Throwable th) {
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            throw th;
                        }
                    } catch (Throwable unused3) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Exception unused4) {
                cursorQuery = null;
            } catch (OutOfMemoryError unused5) {
                cursorQuery = null;
            } catch (Throwable unused6) {
                cursorQuery = null;
            }
        }
        JSONArray jSONArray = new JSONArray();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                jSONArray.put(((c) it.next()).a);
            }
        }
        return jSONArray.toString();
    }

    @Override // com.smartdigimkt.sdk.api.format.IMyOfferAdManager
    public final void preloadTopOnOffer(Context context, String str, JSONObject jSONObject) {
        List list;
        com.smartdigimkt.e3.b bVar;
        if (context != null) {
            SDKContext.getInstance().a(context.getApplicationContext());
        }
        com.smartdigimkt.l1.b.a(context).getClass();
        com.smartdigimkt.p4.e eVarB = o.a().b(str);
        if (eVarB == null && jSONObject != null) {
            eVarB = com.smartdigimkt.p4.e.a(str, jSONObject);
            o.a().a(str, eVarB, null);
        }
        if (eVarB == null || (list = eVarB.D) == null || (bVar = eVarB.E) == null) {
            return;
        }
        e0.a().getClass();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            com.smartdigimkt.a3.a aVar = new com.smartdigimkt.a3.a();
            aVar.s = bVar;
            SDKContext.getInstance().getClass();
            aVar.m = -1;
            e0.a(str, true, (com.smartdigimkt.b3.c) list.get(i), aVar, null);
        }
    }
}
