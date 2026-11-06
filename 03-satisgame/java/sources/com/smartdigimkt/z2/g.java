package com.smartdigimkt.z2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.byazt.q.AdBaseConstants;
import com.google.android.gms.common.internal.ImagesContract;
import com.smartdigimkt.sdk.api.SDMAdConst;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends b {
    public static volatile g b;

    public g(d dVar) {
        super(dVar);
    }

    public static g a(Context context) {
        if (b == null) {
            synchronized (g.class) {
                if (b == null) {
                    b = new g(d.a(context));
                }
            }
        }
        return b;
    }

    public final boolean b(com.smartdigimkt.b3.f fVar) {
        SQLiteDatabase sQLiteDatabaseA;
        synchronized (this) {
            sQLiteDatabaseA = this.a.a();
        }
        Cursor cursorQuery = sQLiteDatabaseA.query("download_task", new String[]{com.anythink.core.e.l.a.aA}, "unique_id = ?", new String[]{fVar.a}, null, null, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.close();
            return true;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return false;
    }

    public final synchronized void c() {
        try {
            b().delete("download_task", "download_start_timestamp <= " + System.currentTimeMillis() + " - offer_cache_time", null);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public final synchronized ArrayList d() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            cursorQuery = a().query("download_task", null, "download_start_timestamp <= " + System.currentTimeMillis() + " - offer_cache_time", null, null, null, "download_start_timestamp");
            while (cursorQuery.moveToNext()) {
                arrayList.add(a(cursorQuery));
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
        return arrayList;
    }

    public final synchronized void a(com.smartdigimkt.b3.f fVar) {
        try {
            if (TextUtils.isEmpty(fVar.a)) {
                return;
            }
            SQLiteDatabase sQLiteDatabaseB = b();
            ContentValues contentValues = new ContentValues();
            contentValues.put(com.anythink.core.e.l.a.aA, fVar.a);
            contentValues.put(AdBaseConstants.MARKET_OPEN_CLICK_ID, fVar.b);
            contentValues.put("request_id", fVar.c);
            contentValues.put("offer_id", fVar.d);
            contentValues.put("pkg_name", fVar.f);
            contentValues.put(ImagesContract.URL, fVar.e);
            contentValues.put("title", fVar.g);
            contentValues.put("deeplink_click_action", fVar.h);
            contentValues.put(SDMAdConst.NETWORK_CUSTOM_KEY.ICON_URL, fVar.q);
            contentValues.put("deeplink_url", fVar.r);
            contentValues.put(com.anythink.core.common.f.k.a.c, fVar.w);
            contentValues.put(f.a, Integer.valueOf(fVar.n));
            contentValues.put("enable_use_webview_ua", Integer.valueOf(fVar.i));
            contentValues.put("download_type", Integer.valueOf(fVar.j));
            contentValues.put("notification_type", Integer.valueOf(fVar.k));
            contentValues.put("int_open_switch", Integer.valueOf(fVar.l));
            contentValues.put("int_open_time", Integer.valueOf(fVar.m));
            contentValues.put("offer_source_type", Integer.valueOf(fVar.s));
            contentValues.put("part_count", Integer.valueOf(fVar.x));
            contentValues.put("enable_part_download", Integer.valueOf(fVar.y ? 1 : 0));
            contentValues.put("download_start_timestamp", Long.valueOf(fVar.z));
            contentValues.put("download_end_timestamp", Long.valueOf(fVar.A));
            contentValues.put("status", Integer.valueOf(fVar.B));
            contentValues.put("is_upload_installed_agentevent", Integer.valueOf(fVar.C));
            contentValues.put("placement_id", fVar.H);
            contentValues.put("ad_source_id", fVar.I);
            contentValues.put("network_firm_id", fVar.J);
            contentValues.put(NotificationCompat.CATEGORY_PROGRESS, Long.valueOf(fVar.K));
            contentValues.put("file_size", Long.valueOf(fVar.L));
            contentValues.put(f.b, Integer.valueOf(fVar.o));
            contentValues.put(f.c, Integer.valueOf(fVar.p));
            contentValues.put("offer_cache_time", Long.valueOf(fVar.M));
            contentValues.put("app_name", fVar.t);
            contentValues.put("downloading_scene", Integer.valueOf(fVar.D));
            contentValues.put("recover_download_scene", Integer.valueOf(fVar.E));
            contentValues.put("download_failed_scene_list", fVar.F);
            contentValues.put("dsp_id", fVar.F);
            contentValues.put("action_offer_download_tk", fVar.G);
            contentValues.put(SDMAdConst.NETWORK_CUSTOM_KEY.APP_FUNCTION_URL, fVar.v);
            if (b(fVar)) {
                sQLiteDatabaseB.update("download_task", contentValues, "unique_id = ?", new String[]{fVar.a});
            } else {
                sQLiteDatabaseB.insertOrThrow("download_task", null, contentValues);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public final synchronized com.smartdigimkt.b3.f a(String str) {
        Cursor cursorQuery;
        try {
            com.smartdigimkt.b3.f fVar = new com.smartdigimkt.b3.f();
            cursorQuery = a().query("download_task", null, "download_start_timestamp > " + System.currentTimeMillis() + " - offer_cache_time AND unique_id = '" + str + "'", null, null, null, "download_start_timestamp");
            try {
                if (cursorQuery.moveToFirst()) {
                    fVar = a(cursorQuery);
                }
                cursorQuery.close();
                return fVar;
            } catch (Throwable th) {
                th = th;
                try {
                    th.getMessage();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            cursorQuery = null;
        }
    }

    public static com.smartdigimkt.b3.f a(Cursor cursor) {
        com.smartdigimkt.b3.f fVar = new com.smartdigimkt.b3.f();
        try {
            int columnIndex = cursor.getColumnIndex(com.anythink.core.e.l.a.aA);
            if (columnIndex >= 0) {
                fVar.a = cursor.getString(columnIndex);
                int columnIndex2 = cursor.getColumnIndex(AdBaseConstants.MARKET_OPEN_CLICK_ID);
                if (columnIndex2 >= 0) {
                    fVar.b = cursor.getString(columnIndex2);
                    int columnIndex3 = cursor.getColumnIndex("request_id");
                    if (columnIndex3 >= 0) {
                        fVar.c = cursor.getString(columnIndex3);
                        int columnIndex4 = cursor.getColumnIndex("offer_id");
                        if (columnIndex4 >= 0) {
                            fVar.d = cursor.getString(columnIndex4);
                            int columnIndex5 = cursor.getColumnIndex(ImagesContract.URL);
                            if (columnIndex5 >= 0) {
                                fVar.e = cursor.getString(columnIndex5);
                                int columnIndex6 = cursor.getColumnIndex("pkg_name");
                                if (columnIndex6 >= 0) {
                                    fVar.f = cursor.getString(columnIndex6);
                                    int columnIndex7 = cursor.getColumnIndex("title");
                                    if (columnIndex7 >= 0) {
                                        fVar.g = cursor.getString(columnIndex7);
                                        int columnIndex8 = cursor.getColumnIndex("deeplink_click_action");
                                        if (columnIndex8 >= 0) {
                                            fVar.h = cursor.getString(columnIndex8);
                                            int columnIndex9 = cursor.getColumnIndex(SDMAdConst.NETWORK_CUSTOM_KEY.ICON_URL);
                                            if (columnIndex9 >= 0) {
                                                fVar.q = cursor.getString(columnIndex9);
                                                int columnIndex10 = cursor.getColumnIndex("deeplink_url");
                                                if (columnIndex10 >= 0) {
                                                    fVar.r = cursor.getString(columnIndex10);
                                                    int columnIndex11 = cursor.getColumnIndex(com.anythink.core.common.f.k.a.c);
                                                    if (columnIndex11 >= 0) {
                                                        fVar.w = cursor.getString(columnIndex11);
                                                        int columnIndex12 = cursor.getColumnIndex("placement_id");
                                                        if (columnIndex12 >= 0) {
                                                            fVar.H = cursor.getString(columnIndex12);
                                                            int columnIndex13 = cursor.getColumnIndex("ad_source_id");
                                                            if (columnIndex13 >= 0) {
                                                                fVar.I = cursor.getString(columnIndex13);
                                                                int columnIndex14 = cursor.getColumnIndex("network_firm_id");
                                                                if (columnIndex14 >= 0) {
                                                                    fVar.J = cursor.getString(columnIndex14);
                                                                    int columnIndex15 = cursor.getColumnIndex("app_name");
                                                                    if (columnIndex15 >= 0) {
                                                                        fVar.t = cursor.getString(columnIndex15);
                                                                        int columnIndex16 = cursor.getColumnIndex("download_failed_scene_list");
                                                                        if (columnIndex16 >= 0) {
                                                                            fVar.F = cursor.getString(columnIndex16);
                                                                            int columnIndex17 = cursor.getColumnIndex("dsp_id");
                                                                            if (columnIndex17 >= 0) {
                                                                                fVar.u = cursor.getString(columnIndex17);
                                                                                int columnIndex18 = cursor.getColumnIndex("action_offer_download_tk");
                                                                                if (columnIndex18 >= 0) {
                                                                                    fVar.G = cursor.getString(columnIndex18);
                                                                                    int columnIndex19 = cursor.getColumnIndex(SDMAdConst.NETWORK_CUSTOM_KEY.APP_FUNCTION_URL);
                                                                                    if (columnIndex19 >= 0) {
                                                                                        fVar.v = cursor.getString(columnIndex19);
                                                                                        int columnIndex20 = cursor.getColumnIndex(f.a);
                                                                                        if (columnIndex20 >= 0) {
                                                                                            fVar.n = cursor.getInt(columnIndex20);
                                                                                            int columnIndex21 = cursor.getColumnIndex("enable_use_webview_ua");
                                                                                            if (columnIndex21 >= 0) {
                                                                                                fVar.i = cursor.getInt(columnIndex21);
                                                                                                int columnIndex22 = cursor.getColumnIndex("download_type");
                                                                                                if (columnIndex22 >= 0) {
                                                                                                    fVar.j = cursor.getInt(columnIndex22);
                                                                                                    int columnIndex23 = cursor.getColumnIndex("notification_type");
                                                                                                    if (columnIndex23 >= 0) {
                                                                                                        fVar.k = cursor.getInt(columnIndex23);
                                                                                                        int columnIndex24 = cursor.getColumnIndex("int_open_switch");
                                                                                                        if (columnIndex24 >= 0) {
                                                                                                            fVar.l = cursor.getInt(columnIndex24);
                                                                                                            int columnIndex25 = cursor.getColumnIndex("int_open_time");
                                                                                                            if (columnIndex25 >= 0) {
                                                                                                                fVar.m = cursor.getInt(columnIndex25);
                                                                                                                int columnIndex26 = cursor.getColumnIndex("offer_source_type");
                                                                                                                if (columnIndex26 >= 0) {
                                                                                                                    fVar.s = cursor.getInt(columnIndex26);
                                                                                                                    int columnIndex27 = cursor.getColumnIndex("part_count");
                                                                                                                    if (columnIndex27 >= 0) {
                                                                                                                        fVar.x = cursor.getInt(columnIndex27);
                                                                                                                        int columnIndex28 = cursor.getColumnIndex("enable_part_download");
                                                                                                                        if (columnIndex28 >= 0) {
                                                                                                                            boolean z = true;
                                                                                                                            if (cursor.getInt(columnIndex28) != 1) {
                                                                                                                                z = false;
                                                                                                                            }
                                                                                                                            fVar.y = z;
                                                                                                                            int columnIndex29 = cursor.getColumnIndex("download_start_timestamp");
                                                                                                                            if (columnIndex29 >= 0) {
                                                                                                                                fVar.z = cursor.getLong(columnIndex29);
                                                                                                                                int columnIndex30 = cursor.getColumnIndex("download_end_timestamp");
                                                                                                                                if (columnIndex30 >= 0) {
                                                                                                                                    fVar.A = cursor.getLong(columnIndex30);
                                                                                                                                    int columnIndex31 = cursor.getColumnIndex("status");
                                                                                                                                    if (columnIndex31 >= 0) {
                                                                                                                                        fVar.B = cursor.getInt(columnIndex31);
                                                                                                                                        int columnIndex32 = cursor.getColumnIndex("is_upload_installed_agentevent");
                                                                                                                                        if (columnIndex32 >= 0) {
                                                                                                                                            fVar.C = cursor.getInt(columnIndex32);
                                                                                                                                            int columnIndex33 = cursor.getColumnIndex(NotificationCompat.CATEGORY_PROGRESS);
                                                                                                                                            if (columnIndex33 >= 0) {
                                                                                                                                                fVar.K = cursor.getLong(columnIndex33);
                                                                                                                                                int columnIndex34 = cursor.getColumnIndex("file_size");
                                                                                                                                                if (columnIndex34 >= 0) {
                                                                                                                                                    fVar.L = cursor.getLong(columnIndex34);
                                                                                                                                                    int columnIndex35 = cursor.getColumnIndex(f.b);
                                                                                                                                                    if (columnIndex35 >= 0) {
                                                                                                                                                        fVar.o = cursor.getInt(columnIndex35);
                                                                                                                                                        int columnIndex36 = cursor.getColumnIndex(f.c);
                                                                                                                                                        if (columnIndex36 >= 0) {
                                                                                                                                                            fVar.p = cursor.getInt(columnIndex36);
                                                                                                                                                            int columnIndex37 = cursor.getColumnIndex("offer_cache_time");
                                                                                                                                                            if (columnIndex37 >= 0) {
                                                                                                                                                                fVar.M = cursor.getLong(columnIndex37);
                                                                                                                                                                int columnIndex38 = cursor.getColumnIndex("downloading_scene");
                                                                                                                                                                if (columnIndex38 >= 0) {
                                                                                                                                                                    fVar.D = cursor.getInt(columnIndex38);
                                                                                                                                                                    int columnIndex39 = cursor.getColumnIndex("recover_download_scene");
                                                                                                                                                                    if (columnIndex39 >= 0) {
                                                                                                                                                                        fVar.E = cursor.getInt(columnIndex39);
                                                                                                                                                                        return fVar;
                                                                                                                                                                    }
                                                                                                                                                                    throw new IllegalArgumentException("columnIndex must >= 0.");
                                                                                                                                                                }
                                                                                                                                                                throw new IllegalArgumentException("columnIndex must >= 0.");
                                                                                                                                                            }
                                                                                                                                                            throw new IllegalArgumentException("columnIndex must >= 0.");
                                                                                                                                                        }
                                                                                                                                                        throw new IllegalArgumentException("columnIndex must >= 0.");
                                                                                                                                                    }
                                                                                                                                                    throw new IllegalArgumentException("columnIndex must >= 0.");
                                                                                                                                                }
                                                                                                                                                throw new IllegalArgumentException("columnIndex must >= 0.");
                                                                                                                                            }
                                                                                                                                            throw new IllegalArgumentException("columnIndex must >= 0.");
                                                                                                                                        }
                                                                                                                                        throw new IllegalArgumentException("columnIndex must >= 0.");
                                                                                                                                    }
                                                                                                                                    throw new IllegalArgumentException("columnIndex must >= 0.");
                                                                                                                                }
                                                                                                                                throw new IllegalArgumentException("columnIndex must >= 0.");
                                                                                                                            }
                                                                                                                            throw new IllegalArgumentException("columnIndex must >= 0.");
                                                                                                                        }
                                                                                                                        throw new IllegalArgumentException("columnIndex must >= 0.");
                                                                                                                    }
                                                                                                                    throw new IllegalArgumentException("columnIndex must >= 0.");
                                                                                                                }
                                                                                                                throw new IllegalArgumentException("columnIndex must >= 0.");
                                                                                                            }
                                                                                                            throw new IllegalArgumentException("columnIndex must >= 0.");
                                                                                                        }
                                                                                                        throw new IllegalArgumentException("columnIndex must >= 0.");
                                                                                                    }
                                                                                                    throw new IllegalArgumentException("columnIndex must >= 0.");
                                                                                                }
                                                                                                throw new IllegalArgumentException("columnIndex must >= 0.");
                                                                                            }
                                                                                            throw new IllegalArgumentException("columnIndex must >= 0.");
                                                                                        }
                                                                                        throw new IllegalArgumentException("columnIndex must >= 0.");
                                                                                    }
                                                                                    throw new IllegalArgumentException("columnIndex must >= 0.");
                                                                                }
                                                                                throw new IllegalArgumentException("columnIndex must >= 0.");
                                                                            }
                                                                            throw new IllegalArgumentException("columnIndex must >= 0.");
                                                                        }
                                                                        throw new IllegalArgumentException("columnIndex must >= 0.");
                                                                    }
                                                                    throw new IllegalArgumentException("columnIndex must >= 0.");
                                                                }
                                                                throw new IllegalArgumentException("columnIndex must >= 0.");
                                                            }
                                                            throw new IllegalArgumentException("columnIndex must >= 0.");
                                                        }
                                                        throw new IllegalArgumentException("columnIndex must >= 0.");
                                                    }
                                                    throw new IllegalArgumentException("columnIndex must >= 0.");
                                                }
                                                throw new IllegalArgumentException("columnIndex must >= 0.");
                                            }
                                            throw new IllegalArgumentException("columnIndex must >= 0.");
                                        }
                                        throw new IllegalArgumentException("columnIndex must >= 0.");
                                    }
                                    throw new IllegalArgumentException("columnIndex must >= 0.");
                                }
                                throw new IllegalArgumentException("columnIndex must >= 0.");
                            }
                            throw new IllegalArgumentException("columnIndex must >= 0.");
                        }
                        throw new IllegalArgumentException("columnIndex must >= 0.");
                    }
                    throw new IllegalArgumentException("columnIndex must >= 0.");
                }
                throw new IllegalArgumentException("columnIndex must >= 0.");
            }
            throw new IllegalArgumentException("columnIndex must >= 0.");
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
