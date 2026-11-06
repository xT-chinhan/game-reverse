package com.bytedance.sdk.openadsdk.core.ka.d;

import android.content.ContentValues;
import android.database.Cursor;
import com.anythink.core.common.e.n;
import com.bytedance.sdk.openadsdk.core.re;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements ms {
    @Override // com.bytedance.sdk.openadsdk.core.ka.d.ms
    public void ms(String str, ka.xr xrVar, boolean z, long j, ka.ms msVar) {
        if (msVar.ah() <= 0) {
            return;
        }
        Cursor cursorQuery = com.bytedance.sdk.openadsdk.core.multipro.ms.ms.query(re.getContext(), "meta_cache", null, "rit =?", new String[]{str}, null, null, "create_time ASC");
        if (cursorQuery != null) {
            if (msVar.ah() > 0 && cursorQuery.getCount() >= msVar.ah()) {
                cursorQuery.moveToFirst();
                com.bytedance.sdk.openadsdk.core.multipro.ms.ms.delete(re.getContext(), "meta_cache", "rit=? AND uuid=?", new String[]{str, cursorQuery.getString(cursorQuery.getColumnIndex("uuid"))});
            }
            cursorQuery.close();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("rit", str);
        contentValues.put("uuid", xrVar.ka);
        contentValues.put("create_time", Long.valueOf(xrVar.f2784ms));
        contentValues.put("meta_data", xrVar.ah);
        contentValues.put("save_version", Integer.valueOf(xrVar.d));
        contentValues.put(n.a.g, Long.valueOf(xrVar.xr));
        contentValues.put("slot_type", msVar.ms());
        contentValues.put("is_using", Integer.valueOf(z ? 1 : 0));
        contentValues.put("priority", Long.valueOf(j));
        com.bytedance.sdk.openadsdk.core.multipro.ms.ms.insert(re.getContext(), "meta_cache", contentValues);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.d.ms
    public ka.xr ms(String str, ka.ms msVar, long j) {
        Cursor cursorMs = ms(msVar, str);
        if (cursorMs == null) {
            return null;
        }
        while (cursorMs.moveToNext()) {
            try {
                String string = cursorMs.getString(cursorMs.getColumnIndex("meta_data"));
                long j2 = cursorMs.getLong(cursorMs.getColumnIndex("create_time"));
                long j3 = cursorMs.getLong(cursorMs.getColumnIndex(n.a.g));
                if (j <= 0 || j2 >= j) {
                    ka.xr xrVar = new ka.xr(string, j2, j3, cursorMs.getString(cursorMs.getColumnIndex("uuid")));
                    cursorMs.close();
                    return xrVar;
                }
            } catch (Throwable th) {
                cursorMs.close();
                throw th;
            }
        }
        cursorMs.close();
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.d.ms
    public ka.xr ms(String str, ka.ms msVar, long j, List<String> list) {
        Cursor cursorMs = ms(msVar, str);
        if (cursorMs == null) {
            return null;
        }
        while (cursorMs.moveToNext()) {
            try {
                String string = cursorMs.getString(cursorMs.getColumnIndex("uuid"));
                if (string == null || list == null || !list.contains(string)) {
                    ka.xr xrVar = new ka.xr(cursorMs.getString(cursorMs.getColumnIndex("meta_data")), cursorMs.getLong(cursorMs.getColumnIndex("create_time")), cursorMs.getLong(cursorMs.getColumnIndex(n.a.g)), string);
                    cursorMs.close();
                    return xrVar;
                }
            } catch (Throwable th) {
                cursorMs.close();
                throw th;
            }
        }
        cursorMs.close();
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.d.ms
    public void ms(String str) {
        com.bytedance.sdk.openadsdk.core.multipro.ms.ms.delete(re.getContext(), "meta_cache", "rit =?", new String[]{str});
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.d.ms
    public void ms(ka.ms msVar) {
        com.bytedance.sdk.openadsdk.core.multipro.ms.ms.delete(re.getContext(), "meta_cache", "slot_type =?", new String[]{msVar.ms()});
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.d.ms
    public void ms(String str, ka.ms msVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (msVar.xr()) {
            com.bytedance.sdk.openadsdk.core.multipro.ms.ms.delete(re.getContext(), "meta_cache", "rit =? AND (save_version!=? OR expire_time <?)", new String[]{str, "6923", String.valueOf(jCurrentTimeMillis)});
        } else {
            com.bytedance.sdk.openadsdk.core.multipro.ms.ms.delete(re.getContext(), "meta_cache", "rit =? AND expire_time <?", new String[]{str, String.valueOf(jCurrentTimeMillis)});
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.d.ms
    public void ms(String str, String str2) {
        com.bytedance.sdk.openadsdk.core.multipro.ms.ms.delete(re.getContext(), "meta_cache", "rit =? AND uuid =?", new String[]{str, str2});
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.d.ms
    public void xr(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_using", (Integer) 0);
        com.bytedance.sdk.openadsdk.core.multipro.ms.ms.update(re.getContext(), "meta_cache", contentValues, "rit =?", new String[]{str});
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.d.ms
    public void ms(String str, String str2, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_using", Boolean.valueOf(z));
        com.bytedance.sdk.openadsdk.core.multipro.ms.ms.update(re.getContext(), "meta_cache", contentValues, "rit =? AND uuid =?", new String[]{str, str2});
    }

    private Cursor ms(ka.ms msVar, String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i = AnonymousClass1.f2785ms[msVar.d().ordinal()];
        if (i == 1) {
            return msVar.xr() ? com.bytedance.sdk.openadsdk.core.multipro.ms.ms.query(re.getContext(), "meta_cache", null, "expire_time >? AND rit =? AND save_version =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str, "6923"}, null, null, "create_time DESC") : com.bytedance.sdk.openadsdk.core.multipro.ms.ms.query(re.getContext(), "meta_cache", null, "expire_time >? AND rit =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str}, null, null, "create_time DESC");
        }
        if (i != 2) {
            return msVar.xr() ? com.bytedance.sdk.openadsdk.core.multipro.ms.ms.query(re.getContext(), "meta_cache", null, "expire_time >? AND rit =? AND save_version =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str, "6923"}, null, null, null) : com.bytedance.sdk.openadsdk.core.multipro.ms.ms.query(re.getContext(), "meta_cache", null, "expire_time >? AND rit =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str}, null, null, null);
        }
        return msVar.xr() ? com.bytedance.sdk.openadsdk.core.multipro.ms.ms.query(re.getContext(), "meta_cache", null, "expire_time >? AND rit =? AND save_version =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str, "6923"}, null, null, "priority DESC") : com.bytedance.sdk.openadsdk.core.multipro.ms.ms.query(re.getContext(), "meta_cache", null, "expire_time >? AND rit =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str}, null, null, "priority DESC");
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.ka.d.xr$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        static final /* synthetic */ int[] f2785ms;

        static {
            int[] iArr = new int[ka.ms.xr.values().length];
            f2785ms = iArr;
            try {
                iArr[ka.ms.xr.TimeLast.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2785ms[ka.ms.xr.CustomPriority.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
