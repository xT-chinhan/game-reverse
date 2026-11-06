package com.onevcat.uniwebview;

import android.webkit.PermissionRequest;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class B extends D {
    public B(String webViewName, PermissionRequest request) {
        Intrinsics.checkNotNullParameter(webViewName, "webViewName");
        Intrinsics.checkNotNullParameter(request, "request");
        String[] resources = request.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "request.resources");
        ArrayList arrayList = new ArrayList(resources.length);
        int length = resources.length;
        int i = 0;
        while (true) {
            String str = "";
            if (i >= length) {
                break;
            }
            String str2 = resources[i];
            if (str2 != null) {
                int iHashCode = str2.hashCode();
                if (iHashCode != -1660821873) {
                    if (iHashCode != 968612586) {
                        if (iHashCode != 1069496794) {
                            if (iHashCode == 1233677653 && str2.equals("android.webkit.resource.MIDI_SYSEX")) {
                                str = "MIDI_SYSEX";
                            }
                        } else if (str2.equals("android.webkit.resource.PROTECTED_MEDIA_ID")) {
                            str = "PROTECTED_MEDIA_ID";
                        }
                    } else if (str2.equals("android.webkit.resource.AUDIO_CAPTURE")) {
                        str = "AUDIO";
                    }
                } else if (str2.equals("android.webkit.resource.VIDEO_CAPTURE")) {
                    str = "VIDEO";
                }
            }
            arrayList.add(str);
            i++;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        String scheme = request.getOrigin().getScheme();
        Pair pair = TuplesKt.to("protocol", scheme == null ? "" : scheme);
        String host = request.getOrigin().getHost();
        String string = new JSONObject(MapsKt.mapOf(pair, TuplesKt.to("host", host != null ? host : ""), TuplesKt.to("port", Integer.valueOf(request.getOrigin().getPort())), TuplesKt.to("resources", arrayList2))).toString();
        Intrinsics.checkNotNullExpressionValue(string, "obj.toString()");
        super(webViewName, "RequestMediaCapturePermission", string);
    }
}
