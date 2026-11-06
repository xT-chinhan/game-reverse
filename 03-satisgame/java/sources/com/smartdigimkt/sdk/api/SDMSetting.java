package com.smartdigimkt.sdk.api;

import android.location.Location;
import com.smartdigimkt.q2.g;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.w3.a;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public class SDMSetting {
    public void deniedUploadDeviceInfo(String... strArr) {
        a aVar = SDKContext.getInstance().p;
        if (aVar == null || strArr == null || strArr.length == 0) {
            return;
        }
        Collections.addAll(aVar.a, strArr);
    }

    public void setDebug(boolean z) {
        SDKContext.getInstance().D = z;
    }

    public void setDelayInspectTime(long j) {
        if (j < 0) {
            return;
        }
        g.h = j;
    }

    public void setEnableGetDeviceInfoInBg(boolean z) {
        g.e = z;
    }

    public void setEnableGetRunningAppProcesses(boolean z) {
        g.f = z;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a A[Catch: all -> 0x001d, TRY_LEAVE, TryCatch #0 {all -> 0x001d, blocks: (B:4:0x000a, B:6:0x0010, B:7:0x001a), top: B:11:0x000a }] */
    public void setExcludePkgList(List<String> list) {
        com.smartdigimkt.u3.a aVar = SDKContext.getInstance().r;
        aVar.a = list;
        if (list != null) {
            try {
                if (list.isEmpty()) {
                    aVar.b = null;
                } else {
                    aVar.b = new JSONArray((Collection) aVar.a);
                }
            } catch (Throwable unused) {
            }
        } else {
            aVar.b = null;
        }
    }

    public void setInspectInterval(long j) {
        if (j < 0) {
            return;
        }
        g.g = j;
    }

    public void setLocation(Location location) {
        g.b = location;
    }

    public void setPersonalizedAdStatus(int i) {
        g.a = i;
    }

    public void setUserDeviceInfo(SDMUserDeviceInfo sDMUserDeviceInfo) {
        g.d = sDMUserDeviceInfo;
        Objects.toString(sDMUserDeviceInfo);
    }

    public void setWxAppId(String str) {
        SDKContext.getInstance().i = str;
    }

    public void setWxInstallStatus(boolean z) {
        g.c = z ? 1 : 2;
    }

    public void undeniedUploadDeviceInfo(String... strArr) {
        a aVar = SDKContext.getInstance().p;
        if (aVar != null) {
            for (String str : strArr) {
                aVar.a.remove(str);
            }
        }
    }
}
