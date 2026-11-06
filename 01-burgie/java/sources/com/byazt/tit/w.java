package com.byazt.tit;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_400, 109})
public class w implements nt {
    @Override // com.byazt.tit.nt
    /* JADX INFO: renamed from: hw, reason: merged with bridge method [inline-methods] */
    public Number pr(JSONObject jSONObject, Object[] objArr) {
        if (objArr == null || objArr.length < 3) {
            return null;
        }
        Number numberPr = pr(objArr[0]);
        int iPr = pr(objArr[1], 0);
        boolean zPr = pr(objArr[2], false);
        if (numberPr == null) {
            return null;
        }
        return pr(numberPr, iPr, zPr);
    }

    public Number pr(Number number, int i, boolean z) {
        BigDecimal scale;
        if (number == null) {
            return null;
        }
        int iMax = Math.max(i, 0);
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(number.doubleValue());
        if (z) {
            scale = bigDecimalValueOf.setScale(iMax, RoundingMode.HALF_UP);
        } else {
            scale = bigDecimalValueOf.setScale(iMax, RoundingMode.DOWN);
        }
        if (iMax == 0 || scale.stripTrailingZeros().scale() <= 0) {
            return Long.valueOf(scale.longValue());
        }
        return Double.valueOf(scale.doubleValue());
    }

    private Number pr(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (!(obj instanceof String)) {
            return null;
        }
        try {
            return Double.valueOf(Double.parseDouble((String) obj));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private int pr(Object obj, int i) {
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        if (obj instanceof String) {
            try {
                return Integer.parseInt((String) obj);
            } catch (NumberFormatException e) {
                return i;
            }
        }
        return i;
    }

    private boolean pr(Object obj, boolean z) {
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        if (obj instanceof String) {
            return Boolean.parseBoolean((String) obj);
        }
        return z;
    }
}
