package com.anythink.core.common.e;

import android.content.ContentValues;
import android.database.Cursor;
import com.anythink.core.common.h.be;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class n extends c<be> {
    private static n b;
    private final String a;

    public static class a {
        public static final String a = "offer_action_record";
        public static final String b = "adsource_id";
        public static final String c = "type";
        public static final String d = "unit_id";
        public static final String e = "click_count";
        public static final String f = "show_count";
        public static final String g = "expire_time";
        public static final String h = "CREATE TABLE IF NOT EXISTS offer_action_record(adsource_id TEXT ,type INTEGER ,unit_id TEXT ,click_count INTEGER ,show_count INTEGER ,expire_time INTEGER )";
    }

    private n(d dVar) {
        super(dVar);
        this.a = n.class.getName();
    }

    public static n a(d dVar) {
        if (b == null) {
            synchronized (n.class) {
                if (b == null) {
                    b = new n(dVar);
                }
            }
        }
        return b;
    }

    public final synchronized void a(int i, String str, int i2, int i3) {
        be beVarA = a(i, str);
        if (beVarA != null) {
            beVarA.b(beVarA.d() + i2);
            beVarA.a(beVarA.c() + i3);
            a(beVarA);
        }
    }

    public final synchronized void a(int i, String str, long j) {
        be beVarA = a(i, str);
        if (beVarA != null) {
            beVarA.a(j);
            a(beVarA);
        }
    }

    public final synchronized List<be> a(int i) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = c().query(a.a, null, "type = ? and expire_time > ?", new String[]{String.valueOf(i), String.valueOf(System.currentTimeMillis())}, null, null, null);
                if (cursorQuery != null && cursorQuery.getCount() > 0) {
                    while (cursorQuery.moveToNext()) {
                        be beVar = new be(i, cursorQuery.getString(cursorQuery.getColumnIndex("unit_id")));
                        beVar.b(cursorQuery.getInt(cursorQuery.getColumnIndex(a.e)));
                        beVar.a(cursorQuery.getInt(cursorQuery.getColumnIndex("show_count")));
                        beVar.a(cursorQuery.getLong(cursorQuery.getColumnIndex(a.g)));
                        arrayList.add(beVar);
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (Exception unused) {
            if (cursorQuery != null) {
            }
        } catch (OutOfMemoryError unused2) {
            System.gc();
            if (cursorQuery != null) {
            }
        } catch (Throwable unused3) {
            if (cursorQuery != null) {
            }
        }
        return arrayList;
    }

    public final synchronized List<be> a(List<String> list, int i) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        b(list.size());
        Cursor cursorQuery = null;
        try {
            try {
                String[] strArr = new String[list.size() + 2];
                list.toArray(strArr);
                strArr[list.size()] = String.valueOf(i);
                strArr[list.size() + 1] = String.valueOf(System.currentTimeMillis());
                cursorQuery = c().query(a.a, null, "adsource_id IN (" + b(list.size()) + ") and type = ? and expire_time > ?", strArr, null, null, null);
                if (cursorQuery != null && cursorQuery.getCount() > 0) {
                    while (cursorQuery.moveToNext()) {
                        be beVar = new be(i, cursorQuery.getString(cursorQuery.getColumnIndex("unit_id")));
                        beVar.b(cursorQuery.getInt(cursorQuery.getColumnIndex(a.e)));
                        beVar.a(cursorQuery.getInt(cursorQuery.getColumnIndex("show_count")));
                        beVar.a(cursorQuery.getLong(cursorQuery.getColumnIndex(a.g)));
                        arrayList.add(beVar);
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (Exception unused) {
            if (cursorQuery != null) {
            }
        } catch (OutOfMemoryError unused2) {
            System.gc();
            if (cursorQuery != null) {
            }
        } catch (Throwable unused3) {
            if (cursorQuery != null) {
            }
        }
        return arrayList;
    }

    private static String b(int i) {
        if (i <= 0) {
            throw new RuntimeException("No placeholders");
        }
        StringBuilder sb = new StringBuilder((i * 2) - 1);
        sb.append("?");
        for (int i2 = 1; i2 < i; i2++) {
            sb.append(",?");
        }
        return sb.toString();
    }

    private synchronized long a(be beVar) {
        if (d() == null || beVar == null) {
            return -1L;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("type", Integer.valueOf(beVar.e()));
            contentValues.put("unit_id", beVar.a());
            contentValues.put(a.e, Integer.valueOf(beVar.d()));
            contentValues.put("show_count", Integer.valueOf(beVar.c()));
            contentValues.put(a.g, Long.valueOf(beVar.b()));
            return d().update(a.a, contentValues, "type = ? and unit_id = ?", new String[]{String.valueOf(beVar.e()), beVar.a()});
        } catch (Exception unused) {
            return -1L;
        }
    }

    private synchronized long b(String str, int i, String str2) {
        if (d() == null) {
            return -1L;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("adsource_id", str);
            contentValues.put("type", Integer.valueOf(i));
            contentValues.put("unit_id", str2);
            be beVarA = a(i, str2);
            if (beVarA != null) {
                contentValues.put(a.e, Integer.valueOf(beVarA.d()));
                contentValues.put("show_count", Integer.valueOf(beVarA.c()));
                contentValues.put(a.g, Long.valueOf(beVarA.b()));
            } else {
                contentValues.put(a.e, (Integer) 0);
                contentValues.put("show_count", (Integer) 0);
                contentValues.put(a.g, (Integer) (-1));
            }
            return d().insert(a.a, null, contentValues);
        } catch (Exception unused) {
            return -1L;
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0071 A[Catch: all -> 0x0080, PHI: r1
      0x0071: PHI (r1v5 android.database.Cursor) = (r1v3 android.database.Cursor), (r1v4 android.database.Cursor), (r1v6 android.database.Cursor) binds: [B:18:0x0068, B:22:0x006f, B:29:0x007d] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #0 {, blocks: (B:10:0x005b, B:14:0x0062, B:23:0x0071, B:26:0x0078, B:27:0x007b, B:21:0x006c), top: B:39:0x0002, inners: #3 }] */
    private synchronized be a(int i, String str) {
        Cursor cursorQuery;
        try {
            cursorQuery = c().query(a.a, null, "type=? and unit_id = ?", new String[]{String.valueOf(i), str}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        cursorQuery.moveToNext();
                        be beVar = new be(i, str);
                        beVar.b(cursorQuery.getInt(cursorQuery.getColumnIndex(a.e)));
                        beVar.a(cursorQuery.getInt(cursorQuery.getColumnIndex("show_count")));
                        beVar.a(cursorQuery.getLong(cursorQuery.getColumnIndex(a.g)));
                        cursorQuery.close();
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return beVar;
                    }
                } catch (Exception unused) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                } catch (OutOfMemoryError unused2) {
                    try {
                        System.gc();
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
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
                    return null;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        } catch (Exception unused4) {
            cursorQuery = null;
        } catch (OutOfMemoryError unused5) {
            cursorQuery = null;
        } catch (Throwable unused6) {
            cursorQuery = null;
        }
    }

    private boolean b(int i, String str) {
        Cursor cursorQuery = c().query(a.a, null, "type = ? and unit_id = ?", new String[]{String.valueOf(i), str}, null, null, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.close();
            return true;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return false;
    }

    private boolean c(String str, int i, String str2) {
        Cursor cursorQuery = c().query(a.a, null, "adsource_id = ? and type = ? and unit_id = ?", new String[]{str, String.valueOf(i), str2}, null, null, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.close();
            return true;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return false;
    }

    public final synchronized void a(String str, int i, String str2) {
        boolean z = false;
        Cursor cursorQuery = c().query(a.a, null, "adsource_id = ? and type = ? and unit_id = ?", new String[]{str, String.valueOf(i), str2}, null, null, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.close();
            z = true;
        } else if (cursorQuery != null) {
            cursorQuery.close();
        }
        if (!z) {
            b(str, i, str2);
        }
    }
}
