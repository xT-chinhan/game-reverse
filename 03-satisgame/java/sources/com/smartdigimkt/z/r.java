package com.smartdigimkt.z;

import android.text.TextUtils;
import com.smartdigimkt.sdk.core.SDKContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class r implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ com.smartdigimkt.b3.c b;
    public final /* synthetic */ com.smartdigimkt.h0.m c;

    public r(int i, com.smartdigimkt.b3.c cVar, com.smartdigimkt.h0.m mVar) {
        this.a = i;
        this.b = cVar;
        this.c = mVar;
    }

    /* JADX WARN: Code duplicated, block: B:115:0x018e A[Catch: all -> 0x02ed, TRY_LEAVE, TryCatch #5 {all -> 0x02ed, blocks: (B:113:0x018a, B:115:0x018e), top: B:277:0x018a }] */
    /* JADX WARN: Code duplicated, block: B:117:0x0191  */
    /* JADX WARN: Code duplicated, block: B:124:0x019d  */
    /* JADX WARN: Code duplicated, block: B:127:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:128:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:131:0x01ad A[Catch: all -> 0x02ea, TryCatch #3 {all -> 0x02ea, blocks: (B:129:0x01a7, B:131:0x01ad, B:133:0x01b7, B:135:0x01bd, B:146:0x01f5, B:148:0x01fa, B:141:0x01d0), top: B:273:0x01a7 }] */
    /* JADX WARN: Code duplicated, block: B:133:0x01b7 A[Catch: all -> 0x02ea, TryCatch #3 {all -> 0x02ea, blocks: (B:129:0x01a7, B:131:0x01ad, B:133:0x01b7, B:135:0x01bd, B:146:0x01f5, B:148:0x01fa, B:141:0x01d0), top: B:273:0x01a7 }] */
    /* JADX WARN: Code duplicated, block: B:135:0x01bd A[Catch: all -> 0x02ea, TryCatch #3 {all -> 0x02ea, blocks: (B:129:0x01a7, B:131:0x01ad, B:133:0x01b7, B:135:0x01bd, B:146:0x01f5, B:148:0x01fa, B:141:0x01d0), top: B:273:0x01a7 }] */
    /* JADX WARN: Code duplicated, block: B:136:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:146:0x01f5 A[Catch: all -> 0x02ea, TryCatch #3 {all -> 0x02ea, blocks: (B:129:0x01a7, B:131:0x01ad, B:133:0x01b7, B:135:0x01bd, B:146:0x01f5, B:148:0x01fa, B:141:0x01d0), top: B:273:0x01a7 }] */
    /* JADX WARN: Code duplicated, block: B:148:0x01fa A[Catch: all -> 0x02ea, TRY_LEAVE, TryCatch #3 {all -> 0x02ea, blocks: (B:129:0x01a7, B:131:0x01ad, B:133:0x01b7, B:135:0x01bd, B:146:0x01f5, B:148:0x01fa, B:141:0x01d0), top: B:273:0x01a7 }] */
    /* JADX WARN: Code duplicated, block: B:152:0x021c  */
    /* JADX WARN: Code duplicated, block: B:153:0x0222  */
    /* JADX WARN: Code duplicated, block: B:155:0x0226 A[Catch: all -> 0x02e8, TryCatch #1 {all -> 0x02e8, blocks: (B:150:0x0212, B:174:0x025b, B:176:0x0263, B:182:0x02a8, B:155:0x0226, B:171:0x0252, B:178:0x029d, B:181:0x02a5, B:186:0x02cd, B:188:0x02d3, B:191:0x02e4), top: B:269:0x0212 }] */
    /* JADX WARN: Code duplicated, block: B:156:0x0231  */
    /* JADX WARN: Code duplicated, block: B:159:0x0237  */
    /* JADX WARN: Code duplicated, block: B:160:0x023a  */
    /* JADX WARN: Code duplicated, block: B:162:0x023e  */
    /* JADX WARN: Code duplicated, block: B:163:0x0241  */
    /* JADX WARN: Code duplicated, block: B:165:0x0245  */
    /* JADX WARN: Code duplicated, block: B:166:0x0248  */
    /* JADX WARN: Code duplicated, block: B:168:0x024c  */
    /* JADX WARN: Code duplicated, block: B:169:0x024f  */
    /* JADX WARN: Code duplicated, block: B:171:0x0252 A[Catch: all -> 0x02e8, TryCatch #1 {all -> 0x02e8, blocks: (B:150:0x0212, B:174:0x025b, B:176:0x0263, B:182:0x02a8, B:155:0x0226, B:171:0x0252, B:178:0x029d, B:181:0x02a5, B:186:0x02cd, B:188:0x02d3, B:191:0x02e4), top: B:269:0x0212 }] */
    /* JADX WARN: Code duplicated, block: B:174:0x025b A[Catch: all -> 0x02e8, TryCatch #1 {all -> 0x02e8, blocks: (B:150:0x0212, B:174:0x025b, B:176:0x0263, B:182:0x02a8, B:155:0x0226, B:171:0x0252, B:178:0x029d, B:181:0x02a5, B:186:0x02cd, B:188:0x02d3, B:191:0x02e4), top: B:269:0x0212 }] */
    /* JADX WARN: Code duplicated, block: B:175:0x0261  */
    /* JADX WARN: Code duplicated, block: B:177:0x0287  */
    /* JADX WARN: Code duplicated, block: B:189:0x02e1  */
    /* JADX WARN: Code duplicated, block: B:191:0x02e4 A[Catch: all -> 0x02e8, TRY_LEAVE, TryCatch #1 {all -> 0x02e8, blocks: (B:150:0x0212, B:174:0x025b, B:176:0x0263, B:182:0x02a8, B:155:0x0226, B:171:0x0252, B:178:0x029d, B:181:0x02a5, B:186:0x02cd, B:188:0x02d3, B:191:0x02e4), top: B:269:0x0212 }] */
    /* JADX WARN: Code duplicated, block: B:202:0x0302  */
    /* JADX WARN: Code duplicated, block: B:203:0x0306  */
    /* JADX WARN: Code duplicated, block: B:204:0x030a  */
    /* JADX WARN: Code duplicated, block: B:205:0x030e  */
    /* JADX WARN: Code duplicated, block: B:206:0x0312  */
    /* JADX WARN: Code duplicated, block: B:207:0x0316  */
    /* JADX WARN: Code duplicated, block: B:208:0x031a  */
    /* JADX WARN: Code duplicated, block: B:209:0x031e  */
    /* JADX WARN: Code duplicated, block: B:210:0x0322  */
    /* JADX WARN: Code duplicated, block: B:211:0x0325  */
    /* JADX WARN: Code duplicated, block: B:212:0x0328  */
    /* JADX WARN: Code duplicated, block: B:213:0x032b  */
    /* JADX WARN: Code duplicated, block: B:214:0x032e  */
    /* JADX WARN: Code duplicated, block: B:215:0x0331  */
    /* JADX WARN: Code duplicated, block: B:216:0x0334  */
    /* JADX WARN: Code duplicated, block: B:217:0x0337  */
    /* JADX WARN: Code duplicated, block: B:218:0x033a  */
    /* JADX WARN: Code duplicated, block: B:219:0x033d  */
    /* JADX WARN: Code duplicated, block: B:220:0x0340  */
    /* JADX WARN: Code duplicated, block: B:221:0x0343  */
    /* JADX WARN: Code duplicated, block: B:222:0x0346  */
    /* JADX WARN: Code duplicated, block: B:223:0x0349  */
    /* JADX WARN: Code duplicated, block: B:224:0x034c  */
    /* JADX WARN: Code duplicated, block: B:225:0x034f  */
    /* JADX WARN: Code duplicated, block: B:226:0x0352  */
    /* JADX WARN: Code duplicated, block: B:227:0x0355  */
    /* JADX WARN: Code duplicated, block: B:228:0x0358  */
    /* JADX WARN: Code duplicated, block: B:229:0x035b  */
    /* JADX WARN: Code duplicated, block: B:230:0x035e  */
    /* JADX WARN: Code duplicated, block: B:231:0x0361  */
    /* JADX WARN: Code duplicated, block: B:232:0x0364  */
    /* JADX WARN: Code duplicated, block: B:233:0x0367  */
    /* JADX WARN: Code duplicated, block: B:234:0x036a  */
    /* JADX WARN: Code duplicated, block: B:235:0x036d  */
    /* JADX WARN: Code duplicated, block: B:242:0x0384  */
    /* JADX WARN: Code duplicated, block: B:245:0x0393  */
    /* JADX WARN: Code duplicated, block: B:246:0x0394 A[Catch: all -> 0x039f, TRY_LEAVE, TryCatch #6 {all -> 0x039f, blocks: (B:243:0x038d, B:246:0x0394), top: B:279:0x038d }] */
    /* JADX WARN: Code duplicated, block: B:250:0x03ab  */
    /* JADX WARN: Code duplicated, block: B:252:0x03b1  */
    /* JADX WARN: Code duplicated, block: B:254:0x03b8  */
    /* JADX WARN: Code duplicated, block: B:267:0x0379 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:288:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:289:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:290:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        String str3;
        String str4;
        com.smartdigimkt.f4.m mVar;
        String str5;
        String[] strArr;
        String[] strArr2;
        boolean z;
        long jCurrentTimeMillis;
        ArrayList arrayList;
        ArrayList arrayList2;
        com.smartdigimkt.h0.b bVar;
        int i;
        boolean z2;
        boolean z3;
        int length;
        boolean z4;
        int i2;
        ArrayList arrayList3;
        String str6;
        int i3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        com.smartdigimkt.h0.b bVar2;
        int i4;
        boolean zA;
        String strA;
        char c;
        LinkedHashMap linkedHashMap;
        String str7;
        String str8;
        ArrayList arrayList6;
        com.smartdigimkt.b3.c cVar;
        com.smartdigimkt.b3.b bVar3;
        JSONObject jSONObject;
        r rVar = this;
        Thread.currentThread().getName();
        com.smartdigimkt.b3.c cVar2 = rVar.b;
        if (cVar2 instanceof com.smartdigimkt.e3.a) {
            com.smartdigimkt.e3.a aVar = (com.smartdigimkt.e3.a) cVar2;
            com.smartdigimkt.b3.e eVar = cVar2.w;
            boolean zA2 = eVar != null ? s.a(eVar, rVar.a) : false;
            if (rVar.a == 8) {
                String str9 = aVar.S;
                if (!TextUtils.isEmpty(str9)) {
                    new com.smartdigimkt.f4.k(str9, rVar.c.b, zA2).a(0, (com.smartdigimkt.a4.b) null);
                }
            }
            com.smartdigimkt.f4.j jVar = new com.smartdigimkt.f4.j(rVar.a, aVar, rVar.c.b);
            com.smartdigimkt.g4.d dVar = jVar.d;
            if (!TextUtils.isEmpty(dVar instanceof com.smartdigimkt.g4.h ? ((com.smartdigimkt.g4.h) dVar).c : "")) {
                String str10 = rVar.c.d;
                try {
                    if (!TextUtils.isEmpty(str10) && (jSONObject = jVar.r) != null) {
                        jSONObject.put("scenario", str10);
                    }
                } catch (Throwable unused) {
                }
                jVar.a(0, (com.smartdigimkt.a4.b) null);
            }
        } else {
            int i5 = rVar.a;
            com.smartdigimkt.b3.l lVar = (com.smartdigimkt.b3.l) cVar2;
            com.smartdigimkt.h0.m mVar2 = rVar.c;
            com.smartdigimkt.b3.n nVar = lVar.W;
            if (nVar != null) {
                LinkedHashMap linkedHashMapA = com.smartdigimkt.r4.k.a(nVar.a);
                HashMap map = mVar2.p ? new HashMap() : linkedHashMapA;
                try {
                    switch (i5) {
                        case 1:
                            strArr2 = nVar.f;
                            strArr = strArr2;
                            break;
                        case 2:
                            strArr2 = nVar.g;
                            strArr = strArr2;
                            break;
                        case 3:
                            strArr2 = nVar.h;
                            strArr = strArr2;
                            break;
                        case 4:
                            strArr2 = nVar.i;
                            strArr = strArr2;
                            break;
                        case 5:
                            strArr2 = nVar.j;
                            strArr = strArr2;
                            break;
                        case 6:
                            strArr2 = nVar.o;
                            strArr = strArr2;
                            break;
                        case 7:
                            strArr2 = nVar.p;
                            strArr = strArr2;
                            break;
                        case 8:
                            strArr2 = nVar.d;
                            strArr = strArr2;
                            break;
                        case 9:
                            strArr2 = nVar.e;
                            strArr = strArr2;
                            break;
                        case 10:
                            strArr2 = nVar.b;
                            strArr = strArr2;
                            break;
                        case 11:
                            strArr2 = nVar.k;
                            strArr = strArr2;
                            break;
                        case 12:
                            strArr2 = nVar.m;
                            strArr = strArr2;
                            break;
                        case 13:
                            strArr2 = nVar.n;
                            strArr = strArr2;
                            break;
                        case 14:
                            strArr2 = nVar.l;
                            strArr = strArr2;
                            break;
                        case 15:
                            strArr2 = nVar.t;
                            strArr = strArr2;
                            break;
                        case 16:
                            strArr2 = nVar.u;
                            strArr = strArr2;
                            break;
                        case 17:
                            strArr2 = nVar.v;
                            strArr = strArr2;
                            break;
                        case 18:
                            strArr2 = nVar.q;
                            strArr = strArr2;
                            break;
                        case 19:
                            strArr2 = nVar.r;
                            strArr = strArr2;
                            break;
                        case 20:
                            strArr2 = nVar.w;
                            strArr = strArr2;
                            break;
                        case 21:
                            strArr2 = nVar.s;
                            strArr = strArr2;
                            break;
                        case 22:
                        default:
                            strArr = null;
                            break;
                        case 23:
                            strArr2 = nVar.x;
                            strArr = strArr2;
                            break;
                        case 24:
                            strArr2 = nVar.y;
                            strArr = strArr2;
                            break;
                        case 25:
                            strArr2 = nVar.z;
                            strArr = strArr2;
                            break;
                        case 26:
                            strArr2 = nVar.A;
                            strArr = strArr2;
                            break;
                        case 27:
                            strArr2 = nVar.B;
                            strArr = strArr2;
                            break;
                        case 28:
                            strArr2 = nVar.D;
                            strArr = strArr2;
                            break;
                        case 29:
                            strArr2 = nVar.C;
                            strArr = strArr2;
                            break;
                        case 30:
                            strArr2 = nVar.E;
                            strArr = strArr2;
                            break;
                        case 31:
                            strArr2 = nVar.F;
                            strArr = strArr2;
                            break;
                        case 32:
                            com.smartdigimkt.h0.n nVar2 = mVar2.h;
                            HashMap map2 = nVar.G;
                            if (nVar2 == null || map2 == null) {
                                strArr = null;
                            } else {
                                strArr2 = (String[]) map2.get(Integer.valueOf(nVar2.g));
                                strArr = strArr2;
                            }
                            break;
                        case 33:
                            strArr2 = nVar.H;
                            strArr = strArr2;
                            break;
                        case 34:
                            strArr2 = nVar.I;
                            strArr = strArr2;
                            break;
                        case 35:
                            strArr2 = nVar.p0;
                            strArr = strArr2;
                            break;
                        case 36:
                            strArr2 = nVar.c;
                            strArr = strArr2;
                            break;
                    }
                    if (strArr != null) {
                        boolean z5 = (i5 == 8 || i5 == 9) ? lVar.w.Z : false;
                        boolean z6 = i5 == 8 || i5 == 9 || i5 == 24 || i5 == 10 || i5 == 36;
                        ArrayList arrayList7 = z6 ? new ArrayList() : null;
                        ArrayList arrayList8 = z6 ? new ArrayList() : null;
                        LinkedHashMap linkedHashMap2 = z6 ? new LinkedHashMap() : null;
                        try {
                            try {
                                if (i5 == 8) {
                                    z = z6;
                                    jCurrentTimeMillis = mVar2.n;
                                    if (jCurrentTimeMillis > 0) {
                                    }
                                    arrayList = new ArrayList();
                                    arrayList2 = new ArrayList();
                                    str2 = "";
                                    bVar = mVar2.i;
                                    if (bVar != null) {
                                        i = bVar.c;
                                    } else {
                                        i = 0;
                                    }
                                    if (i5 != 9 && i == 1001) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    str = "scenario";
                                    if (i5 == 9) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                    length = strArr.length;
                                    z4 = z5;
                                    i2 = 0;
                                    while (i2 < length) {
                                        int i6 = length;
                                        str6 = strArr[i2];
                                        if (TextUtils.isEmpty(str6)) {
                                            i3 = i2;
                                            arrayList4 = arrayList2;
                                        } else {
                                            arrayList5 = arrayList2;
                                            bVar2 = mVar2.i;
                                            if (bVar2 != null) {
                                                i4 = bVar2.c;
                                            } else {
                                                i4 = 0;
                                            }
                                            i3 = i2;
                                            try {
                                                if (i5 == 9 && i4 == 1001) {
                                                    zA = com.smartdigimkt.c0.k.a(str6);
                                                    boolean zB = com.smartdigimkt.c0.k.b(str6);
                                                    if (!zA || zB) {
                                                        arrayList4 = arrayList5;
                                                    }
                                                    nVar = nVar;
                                                    mVar2 = mVar2;
                                                    z4 = z4;
                                                    arrayList2 = arrayList4;
                                                    arrayList8 = arrayList8;
                                                    linkedHashMap2 = linkedHashMap2;
                                                    strArr = strArr;
                                                    linkedHashMapA = linkedHashMapA;
                                                    i2 = i3 + 1;
                                                    lVar = lVar;
                                                    length = i6;
                                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                                }
                                                strA = com.smartdigimkt.c0.k.a(str6, mVar2, j, lVar, z3, linkedHashMap2);
                                                if (TextUtils.isEmpty(strA)) {
                                                    str8 = strA;
                                                    linkedHashMap = linkedHashMap2;
                                                    c = 24;
                                                } else {
                                                    c = 24;
                                                    if (i5 == 24) {
                                                        linkedHashMap = linkedHashMap2;
                                                        strA = com.smartdigimkt.c0.k.a(strA, "__DP_RESULT__", "0", linkedHashMap);
                                                    } else {
                                                        linkedHashMap = linkedHashMap2;
                                                    }
                                                    if (i5 == 18) {
                                                        str7 = "1";
                                                    } else if (i5 == 19) {
                                                        str7 = "2";
                                                    } else if (i5 == 20) {
                                                        str7 = "3";
                                                    } else if (i5 == 21) {
                                                        str7 = "4";
                                                    } else {
                                                        str7 = null;
                                                    }
                                                    if (str7 != null) {
                                                        strA = com.smartdigimkt.c0.k.a(strA, "__DLD_PHASE__", str7, linkedHashMap);
                                                    }
                                                    str8 = strA;
                                                }
                                                if (z) {
                                                    arrayList6 = arrayList8;
                                                    arrayList6.add(str8);
                                                } else {
                                                    arrayList6 = arrayList8;
                                                }
                                                arrayList8 = arrayList6;
                                                linkedHashMap2 = linkedHashMap;
                                                com.smartdigimkt.f4.l lVar2 = new com.smartdigimkt.f4.l(i5, str8, lVar, map, mVar2.a);
                                                z4 = z4;
                                                lVar2.r = z4;
                                                lVar2.a(0, (com.smartdigimkt.a4.b) null);
                                                arrayList4 = arrayList5;
                                                nVar = nVar;
                                                mVar2 = mVar2;
                                                z4 = z4;
                                                arrayList2 = arrayList4;
                                                arrayList8 = arrayList8;
                                                linkedHashMap2 = linkedHashMap2;
                                                strArr = strArr;
                                                linkedHashMapA = linkedHashMapA;
                                                i2 = i3 + 1;
                                                lVar = lVar;
                                                length = i6;
                                                jCurrentTimeMillis = jCurrentTimeMillis;
                                            } catch (Throwable th) {
                                                th = th;
                                                th.printStackTrace();
                                                switch (i5) {
                                                    case 1:
                                                        str3 = nVar.M;
                                                        str4 = str3;
                                                        break;
                                                    case 2:
                                                        str3 = nVar.N;
                                                        str4 = str3;
                                                        break;
                                                    case 3:
                                                        str3 = nVar.O;
                                                        str4 = str3;
                                                        break;
                                                    case 4:
                                                        str3 = nVar.P;
                                                        str4 = str3;
                                                        break;
                                                    case 5:
                                                        str3 = nVar.Q;
                                                        str4 = str3;
                                                        break;
                                                    case 6:
                                                        str3 = nVar.V;
                                                        str4 = str3;
                                                        break;
                                                    case 7:
                                                        str3 = nVar.W;
                                                        str4 = str3;
                                                        break;
                                                    case 8:
                                                        str3 = nVar.K;
                                                        str4 = str3;
                                                        break;
                                                    case 9:
                                                        str3 = nVar.L;
                                                        str4 = str3;
                                                        break;
                                                    case 10:
                                                        str3 = nVar.J;
                                                        str4 = str3;
                                                        break;
                                                    case 11:
                                                        str3 = nVar.R;
                                                        str4 = str3;
                                                        break;
                                                    case 12:
                                                        str3 = nVar.T;
                                                        str4 = str3;
                                                        break;
                                                    case 13:
                                                        str3 = nVar.U;
                                                        str4 = str3;
                                                        break;
                                                    case 14:
                                                        str3 = nVar.S;
                                                        str4 = str3;
                                                        break;
                                                    case 15:
                                                        str3 = nVar.a0;
                                                        str4 = str3;
                                                        break;
                                                    case 16:
                                                        str3 = nVar.b0;
                                                        str4 = str3;
                                                        break;
                                                    case 17:
                                                        str3 = nVar.c0;
                                                        str4 = str3;
                                                        break;
                                                    case 18:
                                                        str3 = nVar.X;
                                                        str4 = str3;
                                                        break;
                                                    case 19:
                                                        str3 = nVar.Y;
                                                        str4 = str3;
                                                        break;
                                                    case 20:
                                                        str3 = nVar.d0;
                                                        str4 = str3;
                                                        break;
                                                    case 21:
                                                        str3 = nVar.Z;
                                                        str4 = str3;
                                                        break;
                                                    case 22:
                                                    case 32:
                                                    default:
                                                        str4 = str2;
                                                        break;
                                                    case 23:
                                                        str3 = nVar.e0;
                                                        str4 = str3;
                                                        break;
                                                    case 24:
                                                        str3 = nVar.f0;
                                                        str4 = str3;
                                                        break;
                                                    case 25:
                                                        str3 = nVar.g0;
                                                        str4 = str3;
                                                        break;
                                                    case 26:
                                                        str3 = nVar.h0;
                                                        str4 = str3;
                                                        break;
                                                    case 27:
                                                        str3 = nVar.i0;
                                                        str4 = str3;
                                                        break;
                                                    case 28:
                                                        str3 = nVar.k0;
                                                        str4 = str3;
                                                        break;
                                                    case 29:
                                                        str3 = nVar.j0;
                                                        str4 = str3;
                                                        break;
                                                    case 30:
                                                        str3 = nVar.l0;
                                                        str4 = str3;
                                                        break;
                                                    case 31:
                                                        str3 = nVar.m0;
                                                        str4 = str3;
                                                        break;
                                                    case 33:
                                                        str3 = nVar.n0;
                                                        str4 = str3;
                                                        break;
                                                    case 34:
                                                        str3 = nVar.o0;
                                                        str4 = str3;
                                                        break;
                                                    case 35:
                                                        str3 = nVar.q0;
                                                        str4 = str3;
                                                        break;
                                                }
                                                if (!TextUtils.isEmpty(str4)) {
                                                    try {
                                                        if (new JSONObject(str4).length() > 0) {
                                                            mVar = new com.smartdigimkt.f4.m(i5, lVar, str4, linkedHashMapA);
                                                            str5 = mVar2.d;
                                                            try {
                                                                if (!TextUtils.isEmpty(str5)) {
                                                                    ((com.smartdigimkt.g4.k) mVar.d).c.put(str, str5);
                                                                }
                                                            } catch (Throwable unused2) {
                                                            }
                                                            mVar.a(0, (com.smartdigimkt.a4.b) null);
                                                        }
                                                    } catch (Throwable unused3) {
                                                    }
                                                }
                                                rVar = this;
                                                if (rVar.a == 21) {
                                                    cVar = rVar.b;
                                                    if (cVar instanceof com.smartdigimkt.b3.b) {
                                                        bVar3 = (com.smartdigimkt.b3.b) cVar;
                                                        if (bVar3.j0 == 1) {
                                                            return;
                                                        } else {
                                                            return;
                                                        }
                                                    }
                                                }
                                            }
                                            if (z2) {
                                                arrayList.add(str6);
                                            }
                                            if (z) {
                                                arrayList7.add(str6);
                                            }
                                            strArr = strArr;
                                            nVar = nVar;
                                            linkedHashMapA = linkedHashMapA;
                                            long j = jCurrentTimeMillis;
                                            jCurrentTimeMillis = jCurrentTimeMillis;
                                            mVar2 = mVar2;
                                            lVar = lVar;
                                        }
                                        if (TextUtils.isEmpty(str6) && z2) {
                                            arrayList4.add(str6);
                                        }
                                        nVar = nVar;
                                        mVar2 = mVar2;
                                        z4 = z4;
                                        arrayList2 = arrayList4;
                                        arrayList8 = arrayList8;
                                        linkedHashMap2 = linkedHashMap2;
                                        strArr = strArr;
                                        linkedHashMapA = linkedHashMapA;
                                        i2 = i3 + 1;
                                        lVar = lVar;
                                        length = i6;
                                        jCurrentTimeMillis = jCurrentTimeMillis;
                                    }
                                    nVar = nVar;
                                    linkedHashMapA = linkedHashMapA;
                                    mVar2 = mVar2;
                                    lVar = lVar;
                                    LinkedHashMap linkedHashMap3 = linkedHashMap2;
                                    arrayList3 = arrayList2;
                                    ArrayList arrayList9 = arrayList8;
                                    if (!z && arrayList7 != null && !arrayList7.isEmpty()) {
                                        com.smartdigimkt.n3.k.a(lVar, mVar2.a, i5, arrayList7, arrayList9, linkedHashMap3);
                                    }
                                    if (z2) {
                                        com.smartdigimkt.n3.k.a(lVar, arrayList, arrayList3);
                                    }
                                } else {
                                    z = z6;
                                }
                                length = strArr.length;
                                z4 = z5;
                                i2 = 0;
                                while (i2 < length) {
                                    int i7 = length;
                                    str6 = strArr[i2];
                                    if (TextUtils.isEmpty(str6)) {
                                        arrayList5 = arrayList2;
                                        bVar2 = mVar2.i;
                                        if (bVar2 != null) {
                                            i4 = bVar2.c;
                                        } else {
                                            i4 = 0;
                                        }
                                        i3 = i2;
                                        if (i5 == 9) {
                                            zA = com.smartdigimkt.c0.k.a(str6);
                                            boolean zB2 = com.smartdigimkt.c0.k.b(str6);
                                            if (!zA) {
                                            }
                                            arrayList4 = arrayList5;
                                        }
                                        if (z2) {
                                            arrayList.add(str6);
                                        }
                                        if (z) {
                                            arrayList7.add(str6);
                                        }
                                        strArr = strArr;
                                        nVar = nVar;
                                        linkedHashMapA = linkedHashMapA;
                                        long j2 = jCurrentTimeMillis;
                                        jCurrentTimeMillis = jCurrentTimeMillis;
                                        mVar2 = mVar2;
                                        lVar = lVar;
                                        strA = com.smartdigimkt.c0.k.a(str6, mVar2, j2, lVar, z3, linkedHashMap2);
                                        if (TextUtils.isEmpty(strA)) {
                                            str8 = strA;
                                            linkedHashMap = linkedHashMap2;
                                            c = 24;
                                        } else {
                                            c = 24;
                                            if (i5 == 24) {
                                                linkedHashMap = linkedHashMap2;
                                                strA = com.smartdigimkt.c0.k.a(strA, "__DP_RESULT__", "0", linkedHashMap);
                                            } else {
                                                linkedHashMap = linkedHashMap2;
                                            }
                                            if (i5 == 18) {
                                                str7 = "1";
                                            } else if (i5 == 19) {
                                                str7 = "2";
                                            } else if (i5 == 20) {
                                                str7 = "3";
                                            } else if (i5 == 21) {
                                                str7 = "4";
                                            } else {
                                                str7 = null;
                                            }
                                            if (str7 != null) {
                                                strA = com.smartdigimkt.c0.k.a(strA, "__DLD_PHASE__", str7, linkedHashMap);
                                            }
                                            str8 = strA;
                                        }
                                        if (z) {
                                            arrayList6 = arrayList8;
                                            arrayList6.add(str8);
                                        } else {
                                            arrayList6 = arrayList8;
                                        }
                                        arrayList8 = arrayList6;
                                        linkedHashMap2 = linkedHashMap;
                                        com.smartdigimkt.f4.l lVar3 = new com.smartdigimkt.f4.l(i5, str8, lVar, map, mVar2.a);
                                        z4 = z4;
                                        lVar3.r = z4;
                                        lVar3.a(0, (com.smartdigimkt.a4.b) null);
                                        arrayList4 = arrayList5;
                                        nVar = nVar;
                                        mVar2 = mVar2;
                                        z4 = z4;
                                        arrayList2 = arrayList4;
                                        arrayList8 = arrayList8;
                                        linkedHashMap2 = linkedHashMap2;
                                        strArr = strArr;
                                        linkedHashMapA = linkedHashMapA;
                                        i2 = i3 + 1;
                                        lVar = lVar;
                                        length = i7;
                                        jCurrentTimeMillis = jCurrentTimeMillis;
                                    } else {
                                        i3 = i2;
                                        arrayList4 = arrayList2;
                                    }
                                    if (TextUtils.isEmpty(str6)) {
                                    }
                                    nVar = nVar;
                                    mVar2 = mVar2;
                                    z4 = z4;
                                    arrayList2 = arrayList4;
                                    arrayList8 = arrayList8;
                                    linkedHashMap2 = linkedHashMap2;
                                    strArr = strArr;
                                    linkedHashMapA = linkedHashMapA;
                                    i2 = i3 + 1;
                                    lVar = lVar;
                                    length = i7;
                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                }
                                nVar = nVar;
                                linkedHashMapA = linkedHashMapA;
                                mVar2 = mVar2;
                                lVar = lVar;
                                LinkedHashMap linkedHashMap4 = linkedHashMap2;
                                arrayList3 = arrayList2;
                                ArrayList arrayList10 = arrayList8;
                                if (!z) {
                                }
                                if (z2) {
                                    com.smartdigimkt.n3.k.a(lVar, arrayList, arrayList3);
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                nVar = nVar;
                                linkedHashMapA = linkedHashMapA;
                                mVar2 = mVar2;
                                lVar = lVar;
                                th.printStackTrace();
                                switch (i5) {
                                    case 1:
                                        str3 = nVar.M;
                                        str4 = str3;
                                        break;
                                    case 2:
                                        str3 = nVar.N;
                                        str4 = str3;
                                        break;
                                    case 3:
                                        str3 = nVar.O;
                                        str4 = str3;
                                        break;
                                    case 4:
                                        str3 = nVar.P;
                                        str4 = str3;
                                        break;
                                    case 5:
                                        str3 = nVar.Q;
                                        str4 = str3;
                                        break;
                                    case 6:
                                        str3 = nVar.V;
                                        str4 = str3;
                                        break;
                                    case 7:
                                        str3 = nVar.W;
                                        str4 = str3;
                                        break;
                                    case 8:
                                        str3 = nVar.K;
                                        str4 = str3;
                                        break;
                                    case 9:
                                        str3 = nVar.L;
                                        str4 = str3;
                                        break;
                                    case 10:
                                        str3 = nVar.J;
                                        str4 = str3;
                                        break;
                                    case 11:
                                        str3 = nVar.R;
                                        str4 = str3;
                                        break;
                                    case 12:
                                        str3 = nVar.T;
                                        str4 = str3;
                                        break;
                                    case 13:
                                        str3 = nVar.U;
                                        str4 = str3;
                                        break;
                                    case 14:
                                        str3 = nVar.S;
                                        str4 = str3;
                                        break;
                                    case 15:
                                        str3 = nVar.a0;
                                        str4 = str3;
                                        break;
                                    case 16:
                                        str3 = nVar.b0;
                                        str4 = str3;
                                        break;
                                    case 17:
                                        str3 = nVar.c0;
                                        str4 = str3;
                                        break;
                                    case 18:
                                        str3 = nVar.X;
                                        str4 = str3;
                                        break;
                                    case 19:
                                        str3 = nVar.Y;
                                        str4 = str3;
                                        break;
                                    case 20:
                                        str3 = nVar.d0;
                                        str4 = str3;
                                        break;
                                    case 21:
                                        str3 = nVar.Z;
                                        str4 = str3;
                                        break;
                                    case 22:
                                    case 32:
                                    default:
                                        str4 = str2;
                                        break;
                                    case 23:
                                        str3 = nVar.e0;
                                        str4 = str3;
                                        break;
                                    case 24:
                                        str3 = nVar.f0;
                                        str4 = str3;
                                        break;
                                    case 25:
                                        str3 = nVar.g0;
                                        str4 = str3;
                                        break;
                                    case 26:
                                        str3 = nVar.h0;
                                        str4 = str3;
                                        break;
                                    case 27:
                                        str3 = nVar.i0;
                                        str4 = str3;
                                        break;
                                    case 28:
                                        str3 = nVar.k0;
                                        str4 = str3;
                                        break;
                                    case 29:
                                        str3 = nVar.j0;
                                        str4 = str3;
                                        break;
                                    case 30:
                                        str3 = nVar.l0;
                                        str4 = str3;
                                        break;
                                    case 31:
                                        str3 = nVar.m0;
                                        str4 = str3;
                                        break;
                                    case 33:
                                        str3 = nVar.n0;
                                        str4 = str3;
                                        break;
                                    case 34:
                                        str3 = nVar.o0;
                                        str4 = str3;
                                        break;
                                    case 35:
                                        str3 = nVar.q0;
                                        str4 = str3;
                                        break;
                                }
                                if (!TextUtils.isEmpty(str4)) {
                                    if (new JSONObject(str4).length() > 0) {
                                        mVar = new com.smartdigimkt.f4.m(i5, lVar, str4, linkedHashMapA);
                                        str5 = mVar2.d;
                                        if (!TextUtils.isEmpty(str5)) {
                                            ((com.smartdigimkt.g4.k) mVar.d).c.put(str, str5);
                                        }
                                        mVar.a(0, (com.smartdigimkt.a4.b) null);
                                    }
                                }
                                rVar = this;
                                if (rVar.a == 21) {
                                    cVar = rVar.b;
                                    if (cVar instanceof com.smartdigimkt.b3.b) {
                                        bVar3 = (com.smartdigimkt.b3.b) cVar;
                                        if (bVar3.j0 == 1) {
                                            return;
                                        } else {
                                            return;
                                        }
                                    }
                                }
                            }
                            bVar = mVar2.i;
                            if (bVar != null) {
                                i = bVar.c;
                            } else {
                                i = 0;
                            }
                            if (i5 != 9) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            str = "scenario";
                            if (i5 == 9) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            str = "scenario";
                        }
                        jCurrentTimeMillis = System.currentTimeMillis();
                        arrayList = new ArrayList();
                        arrayList2 = new ArrayList();
                        str2 = "";
                    } else {
                        str = "scenario";
                        str2 = "";
                        nVar = nVar;
                        linkedHashMapA = linkedHashMapA;
                        mVar2 = mVar2;
                        lVar = lVar;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    str = "scenario";
                    str2 = "";
                }
                switch (i5) {
                    case 1:
                        str3 = nVar.M;
                        str4 = str3;
                        break;
                    case 2:
                        str3 = nVar.N;
                        str4 = str3;
                        break;
                    case 3:
                        str3 = nVar.O;
                        str4 = str3;
                        break;
                    case 4:
                        str3 = nVar.P;
                        str4 = str3;
                        break;
                    case 5:
                        str3 = nVar.Q;
                        str4 = str3;
                        break;
                    case 6:
                        str3 = nVar.V;
                        str4 = str3;
                        break;
                    case 7:
                        str3 = nVar.W;
                        str4 = str3;
                        break;
                    case 8:
                        str3 = nVar.K;
                        str4 = str3;
                        break;
                    case 9:
                        str3 = nVar.L;
                        str4 = str3;
                        break;
                    case 10:
                        str3 = nVar.J;
                        str4 = str3;
                        break;
                    case 11:
                        str3 = nVar.R;
                        str4 = str3;
                        break;
                    case 12:
                        str3 = nVar.T;
                        str4 = str3;
                        break;
                    case 13:
                        str3 = nVar.U;
                        str4 = str3;
                        break;
                    case 14:
                        str3 = nVar.S;
                        str4 = str3;
                        break;
                    case 15:
                        str3 = nVar.a0;
                        str4 = str3;
                        break;
                    case 16:
                        str3 = nVar.b0;
                        str4 = str3;
                        break;
                    case 17:
                        str3 = nVar.c0;
                        str4 = str3;
                        break;
                    case 18:
                        str3 = nVar.X;
                        str4 = str3;
                        break;
                    case 19:
                        str3 = nVar.Y;
                        str4 = str3;
                        break;
                    case 20:
                        str3 = nVar.d0;
                        str4 = str3;
                        break;
                    case 21:
                        str3 = nVar.Z;
                        str4 = str3;
                        break;
                    case 22:
                    case 32:
                    default:
                        str4 = str2;
                        break;
                    case 23:
                        str3 = nVar.e0;
                        str4 = str3;
                        break;
                    case 24:
                        str3 = nVar.f0;
                        str4 = str3;
                        break;
                    case 25:
                        str3 = nVar.g0;
                        str4 = str3;
                        break;
                    case 26:
                        str3 = nVar.h0;
                        str4 = str3;
                        break;
                    case 27:
                        str3 = nVar.i0;
                        str4 = str3;
                        break;
                    case 28:
                        str3 = nVar.k0;
                        str4 = str3;
                        break;
                    case 29:
                        str3 = nVar.j0;
                        str4 = str3;
                        break;
                    case 30:
                        str3 = nVar.l0;
                        str4 = str3;
                        break;
                    case 31:
                        str3 = nVar.m0;
                        str4 = str3;
                        break;
                    case 33:
                        str3 = nVar.n0;
                        str4 = str3;
                        break;
                    case 34:
                        str3 = nVar.o0;
                        str4 = str3;
                        break;
                    case 35:
                        str3 = nVar.q0;
                        str4 = str3;
                        break;
                }
                if (!TextUtils.isEmpty(str4)) {
                    if (new JSONObject(str4).length() > 0) {
                        mVar = new com.smartdigimkt.f4.m(i5, lVar, str4, linkedHashMapA);
                        str5 = mVar2.d;
                        if (!TextUtils.isEmpty(str5)) {
                            ((com.smartdigimkt.g4.k) mVar.d).c.put(str, str5);
                        }
                        mVar.a(0, (com.smartdigimkt.a4.b) null);
                    }
                }
                rVar = this;
            }
        }
        if (rVar.a == 21) {
            cVar = rVar.b;
            if (cVar instanceof com.smartdigimkt.b3.b) {
                bVar3 = (com.smartdigimkt.b3.b) cVar;
                if (bVar3.j0 == 1 || !com.smartdigimkt.r4.k.b(SDKContext.getInstance().d().getApplicationContext(), bVar3.m)) {
                    return;
                }
                com.smartdigimkt.t2.j jVarA = com.smartdigimkt.t2.j.a();
                jVarA.getClass();
                if (bVar3.f0 == 1) {
                    int i8 = bVar3.o;
                    if (i8 == 1 || i8 == 4) {
                        com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.t2.i(jVarA, bVar3));
                    }
                }
            }
        }
    }
}
