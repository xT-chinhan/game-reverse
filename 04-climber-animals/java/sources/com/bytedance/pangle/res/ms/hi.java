package com.bytedance.pangle.res.ms;

import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class hi {
    static byte[] ms(int i) {
        return new byte[]{(byte) (i >> 0), (byte) (i >> 8), (byte) (i >> 16), (byte) (i >> 24)};
    }

    static int ms(ab abVar) {
        return (int) abVar.f676ms.ms().xr();
    }

    static int ms(byte[] bArr, int i, int i2, x xVar) {
        if (i < 2130706432) {
            return i;
        }
        int iMs = xVar.ms(i);
        byte[] bArrMs = ms(iMs);
        bArr[i2] = bArrMs[0];
        bArr[i2 + 1] = bArrMs[1];
        bArr[i2 + 2] = bArrMs[2];
        bArr[i2 + 3] = bArrMs[3];
        return iMs;
    }

    static void ms(byte[] bArr, x xVar) throws IOException {
        xr xrVar = new xr(bArr, xVar);
        xrVar.xr(new ByteArrayInputStream(bArr));
        while (xrVar.ah() != 1) {
        }
    }

    static void ms(String str, byte[] bArr, x xVar) throws Throwable {
        if (!TextUtils.isEmpty(str) && xVar.ms(str)) {
            if (str.equals("AndroidManifest.xml")) {
                ms(bArr, xVar);
                return;
            }
            if ((str.endsWith(".xml") && str.startsWith("res/")) || TextUtils.equals(str, "AndroidManifest.xml")) {
                ms(bArr, xVar);
            } else if (str.equals("resources.arsc")) {
                new ms(bArr, xVar).ms();
            }
        }
    }

    public static void ms(int i, byte[] bArr, int[] iArr, int i2, HashMap<Integer, Integer> map) {
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        int i3 = -1;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i4 * 5;
            int i6 = iArr[i5 + 1];
            if (map.containsKey(Integer.valueOf(i6))) {
                if (i3 == -1) {
                    i3 = i4;
                }
                int i7 = (i5 * 4) + i;
                map2.put(Integer.valueOf(i4), Arrays.copyOfRange(bArr, i7, i7 + 20));
                map3.put(Integer.valueOf(map.get(Integer.valueOf(i6)).intValue()), Integer.valueOf(i4));
            }
        }
        ArrayList arrayList = new ArrayList(map3.keySet());
        Collections.sort(arrayList);
        Iterator it = arrayList.iterator();
        int i8 = 0;
        while (it.hasNext()) {
            byte[] bArr2 = (byte[]) map2.get(Integer.valueOf(((Integer) map3.get((Integer) it.next())).intValue()));
            System.arraycopy(bArr2, 0, bArr, ((i8 + i3) * 5 * 4) + i, bArr2.length);
            i8++;
        }
    }
}
