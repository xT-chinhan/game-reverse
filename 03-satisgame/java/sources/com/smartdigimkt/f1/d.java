package com.smartdigimkt.f1;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.anythink.core.common.f.i;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.smartdigimkt.e1.e;
import com.smartdigimkt.h0.g;
import com.smartdigimkt.q3.f;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.t2.k;
import com.smartdigimkt.t2.u;
import com.smartdigimkt.z2.q;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static volatile d c;
    public final Context a;
    public final ConcurrentHashMap b = new ConcurrentHashMap(3);

    public d(Context context) {
        this.a = context.getApplicationContext();
    }

    public static d a(Context context) {
        if (c == null) {
            synchronized (d.class) {
                if (c == null) {
                    c = new d(context);
                }
            }
        }
        return c;
    }

    public final void b(com.smartdigimkt.a3.a aVar) {
        this.b.remove(aVar.b + aVar.j);
    }

    public final void a(com.smartdigimkt.a3.a aVar, com.smartdigimkt.d3.c cVar, e eVar, com.smartdigimkt.e1.c cVar2) {
        if (this.b.contains(aVar.b + aVar.j) && ((Boolean) this.b.get(aVar.b + aVar.j)).booleanValue()) {
            cVar2.a(null, new g(com.anythink.core.common.inner.b.b.g, com.anythink.core.common.inner.b.b.w));
            return;
        }
        this.b.put(aVar.b + aVar.j, Boolean.TRUE);
        f fVarA = f.a();
        a aVar2 = new a(this, aVar, cVar, eVar, cVar2);
        fVarA.getClass();
        String name = Thread.currentThread().getName();
        fVarA.a.getClass();
        if (TextUtils.equals(name, com.smartdigimkt.q3.b.a(6))) {
            aVar2.run();
            return;
        }
        com.smartdigimkt.q3.e eVar2 = new com.smartdigimkt.q3.e(aVar2);
        Long.valueOf(System.currentTimeMillis() / 1000).intValue();
        fVarA.a(eVar2, 6);
    }

    public final boolean a(com.smartdigimkt.b3.b bVar, com.smartdigimkt.a3.a aVar, com.smartdigimkt.e1.c cVar) {
        String str;
        int i = bVar.z;
        if (i == 2) {
            str = "Unsupported ad protocol: Vast.";
        } else if (i == 1) {
            str = "Unsupported ad protocol: Mraid.";
        } else {
            if (TextUtils.isEmpty(bVar.l0)) {
                return false;
            }
            str = "Unsupported MTG template protocol.";
        }
        b(aVar);
        com.smartdigimkt.t2.e eVarA = com.smartdigimkt.t2.e.a();
        Context context = this.a;
        String str2 = aVar.j;
        eVarA.getClass();
        f.a().c(new com.smartdigimkt.t2.c(eVarA, context, str2));
        if (cVar != null) {
            cVar.a(bVar, new g(com.anythink.core.common.inner.b.b.i, str));
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0061 A[Catch: all -> 0x0065, PHI: r2
      0x0061: PHI (r2v3 android.database.Cursor) = (r2v2 android.database.Cursor), (r2v6 android.database.Cursor) binds: [B:19:0x005f, B:16:0x005b] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0065, blocks: (B:13:0x0056, B:20:0x0061), top: B:37:0x001f }] */
    public final com.smartdigimkt.b3.b a(com.smartdigimkt.a3.a aVar) {
        com.smartdigimkt.b3.b bVarA;
        Cursor cursorQuery;
        u uVar;
        com.smartdigimkt.t2.e eVarA = com.smartdigimkt.t2.e.a();
        Context context = this.a;
        String str = aVar.j;
        if (eVarA.a == null) {
            eVarA.a = q.a(com.smartdigimkt.z2.d.a(context.getApplicationContext()));
        }
        q qVar = eVarA.a;
        synchronized (qVar) {
            bVarA = null;
            try {
                try {
                    cursorQuery = qVar.a().query(i.a.a, new String[]{i.a.g, i.a.h}, "bid_id=?", new String[]{str}, null, null, null);
                    if (cursorQuery != null) {
                        try {
                            if (cursorQuery.getCount() > 0) {
                                cursorQuery.moveToNext();
                                uVar = new u(cursorQuery.getString(0), cursorQuery.getLong(1));
                                cursorQuery.close();
                                cursorQuery.close();
                            }
                        } catch (Throwable unused) {
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                        }
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            } catch (Throwable unused2) {
                cursorQuery = null;
            }
            uVar = null;
        }
        if (uVar != null && !TextUtils.isEmpty(uVar.a)) {
            try {
                bVarA = a(aVar, new JSONObject(uVar.a), uVar.a, false);
                bVarA.g0 = uVar.b;
            } catch (Throwable unused3) {
            }
            if (bVarA != null) {
                a(bVarA, aVar);
            }
        }
        return bVarA;
    }

    public static com.smartdigimkt.b3.b a(com.smartdigimkt.a3.a aVar, JSONObject jSONObject, String str, boolean z) {
        try {
            return k.a(aVar.j, jSONObject, str, aVar.k, z);
        } catch (Throwable th) {
            com.smartdigimkt.h3.b bVar = aVar.z;
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0075 A[Catch: Exception -> 0x0096, TryCatch #0 {Exception -> 0x0096, blocks: (B:13:0x0039, B:16:0x0042, B:18:0x0051, B:20:0x0055, B:24:0x0064, B:26:0x006a, B:28:0x006f, B:34:0x0084, B:30:0x0075, B:32:0x007c, B:21:0x005b, B:38:0x008e), top: B:52:0x0039 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x007c A[Catch: Exception -> 0x0096, TryCatch #0 {Exception -> 0x0096, blocks: (B:13:0x0039, B:16:0x0042, B:18:0x0051, B:20:0x0055, B:24:0x0064, B:26:0x006a, B:28:0x006f, B:34:0x0084, B:30:0x0075, B:32:0x007c, B:21:0x005b, B:38:0x008e), top: B:52:0x0039 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0083  */
    public final void a(com.smartdigimkt.b3.b bVar, com.smartdigimkt.a3.a aVar) {
        byte[] bArr;
        int i;
        int i2;
        if (aVar != null) {
            bVar.x = aVar.g;
            bVar.L = aVar.i;
            bVar.M = aVar.h;
            com.smartdigimkt.w2.b bVarE = SDKContext.getInstance().e();
            if (bVarE != null && bVarE.a()) {
                bVarE.fillDataFetchStatus(this.a, bVar, aVar);
            } else {
                bVar.D = 0;
            }
            String str = bVar.B;
            if (!TextUtils.isEmpty(str)) {
                int i3 = com.smartdigimkt.i1.e.a;
                HashMap map = com.smartdigimkt.i1.f.a;
                try {
                    int length = str.length();
                    int i4 = MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME;
                    if (length < 259) {
                        i4 = length;
                    }
                    char[] cArr = new char[i4];
                    int i5 = ((length >> 2) * 3) + 3;
                    bArr = new byte[i5];
                    int i6 = 0;
                    int iA = 0;
                    int i7 = 0;
                    while (i6 < length) {
                        int i8 = i6 + 256;
                        if (i8 <= length) {
                            str.getChars(i6, i8, cArr, i7);
                            i = i7 + 256;
                        } else {
                            str.getChars(i6, length, cArr, i7);
                            i = (length - i6) + i7;
                        }
                        int i9 = i7;
                        while (i7 < i) {
                            char c2 = cArr[i7];
                            if (c2 != '=') {
                                byte[] bArr2 = com.smartdigimkt.i1.f.d;
                                if (c2 < bArr2.length && bArr2[c2] != 127) {
                                    i2 = i9 + 1;
                                    cArr[i9] = c2;
                                    if (i2 == 4) {
                                        iA += com.smartdigimkt.i1.f.a(cArr, bArr, iA);
                                        i9 = 0;
                                    } else {
                                        i9 = i2;
                                    }
                                }
                            } else {
                                i2 = i9 + 1;
                                cArr[i9] = c2;
                                if (i2 == 4) {
                                    iA += com.smartdigimkt.i1.f.a(cArr, bArr, iA);
                                    i9 = 0;
                                } else {
                                    i9 = i2;
                                }
                            }
                            i7++;
                        }
                        i6 = i8;
                        i7 = i9;
                    }
                    if (iA != i5) {
                        byte[] bArr3 = new byte[iA];
                        System.arraycopy(bArr, 0, bArr3, 0, iA);
                        bArr = bArr3;
                    }
                } catch (Exception unused) {
                    bArr = null;
                }
                bVar.B = (bArr == null || bArr.length <= 0) ? null : new String(bArr);
            }
            if (aVar.k == 67) {
                com.smartdigimkt.u2.c.a(this.a).a(bVar.a, bVar.g0);
                com.smartdigimkt.u2.b.a(this.a).a(bVar.b, bVar.g0);
            }
            String str2 = com.smartdigimkt.f0.e.g;
            com.smartdigimkt.f0.d.a.getClass();
        }
    }
}
