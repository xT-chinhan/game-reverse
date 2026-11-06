package com.byazt.imu;

import com.byazt.si.d;
import com.byazt.si.j;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1664, 18})
public class l implements j {
    public static int n;
    public String l;
    public boolean q;
    public long qg = 0;
    public long s;

    public l() {
        n++;
        this.l = "image_request_" + n;
    }

    @Override // com.byazt.si.j
    public void n(String str, d dVar) {
        if (!this.q) {
            dVar.qg();
            dVar.s();
            dVar.q();
            this.q = true;
        }
        this.qg = System.currentTimeMillis();
        s(str, dVar);
    }

    @Override // com.byazt.si.j
    public void qg(String str, d dVar) {
        this.s += System.currentTimeMillis() - this.qg;
        s(str, dVar);
    }

    private String s(String str, d dVar) {
        com.byazt.gxb.n nVarA;
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
                if (!(dVar instanceof com.byazt.gxb.s) || (nVarA = ((com.byazt.gxb.s) dVar).a()) == null) {
                    return "失败";
                }
                Throwable thS = nVarA.s();
                return "失败：code:" + nVarA.n() + ", msg:" + nVarA.qg() + ", exception:" + (thS != null ? thS.getMessage() : "null \r\n");
            case "check_duplicate":
                return "检查重复请求";
            case "memory_cache":
                return "查询Bitmap内存缓存";
            case "net_request":
                return "请求网络";
            case "generate_key":
                return "生成KEY:" + dVar.x();
            case "cache_policy":
                return "查询缓存策略";
            default:
                return str;
        }
    }
}
