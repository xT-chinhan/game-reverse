package com.bytedance.sdk.openadsdk.x;

import com.bytedance.sdk.component.c.ny;
import com.bytedance.sdk.component.c.t;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;

/* JADX INFO: loaded from: classes2.dex */
public class ah implements t {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static int f4304ms;
    private long ah;
    private boolean d;
    private String ka;
    private long xr = 0;

    public ah() {
        f4304ms++;
        this.ka = "image_request_" + f4304ms;
    }

    @Override // com.bytedance.sdk.component.c.t
    @ATSMethod(1)
    public void ms(String str, ny nyVar) {
        if (!this.d) {
            nyVar.xr();
            nyVar.ah();
            nyVar.d();
            this.d = true;
        }
        this.xr = System.currentTimeMillis();
        ah(str, nyVar);
    }

    @Override // com.bytedance.sdk.component.c.t
    @ATSMethod(2)
    public void xr(String str, ny nyVar) {
        this.ah += System.currentTimeMillis() - this.xr;
        ah(str, nyVar);
    }

    private String ah(String str, ny nyVar) {
        com.bytedance.sdk.component.c.ah.ms msVarY;
        if (str == null) {
            return str;
        }
        str.hashCode();
        switch (str) {
            case "success":
                return "成功";
            case "raw_cache":
                return "查询RAW内存缓存";
            case "image_type":
                return "判断图片类型：";
            case "disk_cache":
                return "查询文件缓存";
            case "decode":
                return "解码";
            case "failed":
                if (!(nyVar instanceof com.bytedance.sdk.component.c.ah.ah) || (msVarY = ((com.bytedance.sdk.component.c.ah.ah) nyVar).y()) == null) {
                    return "失败";
                }
                Throwable thAh = msVarY.ah();
                return "失败：code:" + msVarY.ms() + ", msg:" + msVarY.xr() + ", exception:" + (thAh != null ? thAh.getMessage() : "null \r\n");
            case "check_duplicate":
                return "检查重复请求";
            case "memory_cache":
                return "查询Bitmap内存缓存";
            case "net_request":
                return "请求网络";
            case "generate_key":
                return "生成KEY:" + nyVar.ab();
            case "cache_policy":
                return "查询缓存策略";
            default:
                return str;
        }
    }
}
