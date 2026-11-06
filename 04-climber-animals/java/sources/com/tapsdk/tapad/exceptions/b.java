package com.tapsdk.tapad.exceptions;

import com.tapsdk.tapad.constants.Constants;
import com.tapsdk.tapad.constants.ErrorCodeEnum;
import com.tapsdk.tapad.internal.AdType;
import com.tapsdk.tapad.internal.CommonListener;
import com.tapsdk.tapad.internal.tracker.experiment.f;
import com.tapsdk.tapad.internal.tracker.experiment.g;
import com.tapsdk.tapad.model.entities.TrackBackData;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    private static final String a = "extra_param_track_back_data";

    public static TrackBackData a(String str) {
        if (str != null && str.length() >= 58) {
            int iIndexOf = str.indexOf(a) + 27 + 1;
            try {
                JSONObject jSONObject = new JSONObject(iIndexOf < str.length() ? str.substring(iIndexOf) : "");
                return new TrackBackData(jSONObject.getString("request_id"), jSONObject.getString(Constants.Bidding.REQ_UUID), jSONObject.getLong("space_id"));
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static String a(TrackBackData trackBackData) {
        String string;
        StringBuilder sb = new StringBuilder("extra_param_track_back_data:");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.Bidding.REQ_UUID, trackBackData.requestUUID);
            jSONObject.put("request_id", trackBackData.requestId);
            jSONObject.put("space_id", trackBackData.spaceId);
            string = jSONObject.toString();
        } catch (Exception unused) {
            string = "";
        }
        if (string.length() <= 0) {
            return "";
        }
        sb.append(string);
        return sb.toString();
    }

    public static void a(Throwable th, CommonListener commonListener, long j, AdType adType) {
        com.tapsdk.tapad.internal.tracker.experiment.h.a aVar = new com.tapsdk.tapad.internal.tracker.experiment.h.a();
        aVar.a(j).a(adType.name()).a(10).b("1");
        if (th instanceof com.tapsdk.tapad.internal.network.b.a) {
            com.tapsdk.tapad.internal.network.b.a aVar2 = (com.tapsdk.tapad.internal.network.b.a) th;
            TrackBackData trackBackData = aVar2.d;
            if (trackBackData != null) {
                String str = trackBackData.requestId;
                if (str != null && str.length() > 0) {
                    aVar.d(aVar2.d.requestId);
                }
                String str2 = aVar2.d.requestUUID;
                if (str2 != null && str2.length() > 0) {
                    aVar.e(aVar2.d.requestUUID);
                }
            }
            aVar.c(aVar2.b);
            aVar.a(Integer.valueOf(aVar2.a));
            if (commonListener != null) {
                String message = th.getMessage();
                if (aVar2.d != null) {
                    message = message + " " + a(aVar2.d);
                }
                commonListener.onError(aVar2.a, message);
            }
        } else if (!(th instanceof d)) {
            if (commonListener != null) {
                commonListener.onError(ErrorCodeEnum.COMMON_UNKOWN_ERROR.getCode(), th != null ? th.getMessage() : "");
                return;
            }
            return;
        } else {
            d dVar = (d) th;
            aVar.d(dVar.c).e(dVar.e).a(Integer.valueOf(dVar.a)).c(dVar.b);
            if (commonListener != null) {
                commonListener.onError(ErrorCodeEnum.COMMON_PARAM_INTERERROR.getCode(), ErrorCodeEnum.COMMON_PARAM_INTERERROR.getDesc());
            }
        }
        f.b().a(g.b).a(aVar);
    }
}
