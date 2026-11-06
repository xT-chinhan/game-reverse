package com.byazt.ph;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_DEFAULT_CODEC_ID, 109})
public class w {
    public static int pr(fw fwVar) {
        return (int) fwVar.pr.pr().hw();
    }

    public static byte[] pr(int i) {
        return new byte[]{(byte) (i >> 0), (byte) (i >> 8), (byte) (i >> 16), (byte) (i >> 24)};
    }

    public static int pr(byte[] bArr, int i, int i2, zo zoVar) {
        if (i >= 2130706432) {
            int iPr = zoVar.pr(i);
            byte[] bArrPr = pr(iPr);
            bArr[i2] = bArrPr[0];
            bArr[i2 + 1] = bArrPr[1];
            bArr[i2 + 2] = bArrPr[2];
            bArr[i2 + 3] = bArrPr[3];
            return iPr;
        }
        return i;
    }

    public static void pr(byte[] bArr, zo zoVar) throws IOException {
        hw hwVar = new hw(bArr, zoVar);
        hwVar.hw(new ByteArrayInputStream(bArr));
        while (hwVar.hn() != 1) {
        }
    }

    public static void pr(String str, byte[] bArr, zo zoVar) throws Throwable {
        if (TextUtils.isEmpty(str) || !zoVar.pr(str)) {
            return;
        }
        if (str.equals("AndroidManifest.xml")) {
            pr(bArr, zoVar);
            return;
        }
        if ((str.endsWith(".xml") && str.startsWith("res/")) || TextUtils.equals(str, "AndroidManifest.xml")) {
            pr(bArr, zoVar);
        } else if (str.equals("resources.arsc")) {
            new pr(bArr, zoVar).pr();
        }
    }

    public static void pr(int i, byte[] bArr, int[] iArr, int i2, HashMap<Integer, Integer> map) {
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
