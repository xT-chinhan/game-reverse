package com.byazt.ms;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 238, MediaPlayer.MEDIA_PLAYER_OPTION_MASK_STREAM_OPENED_TIME})
public class TTDownloadEventModel {
    public JSONObject extJson;
    public String label;
    public JSONObject materialMeta;
    public String tag;

    public static TTDownloadEventModel builder() {
        return new TTDownloadEventModel();
    }

    public TTDownloadEventModel setMaterialMeta(JSONObject jSONObject) {
        this.materialMeta = jSONObject;
        return this;
    }

    public TTDownloadEventModel setTag(String str) {
        this.tag = str;
        return this;
    }

    public TTDownloadEventModel setLabel(String str) {
        this.label = str;
        return this;
    }

    public TTDownloadEventModel setExtJson(JSONObject jSONObject) {
        this.extJson = jSONObject;
        return this;
    }

    public String getTag() {
        return this.tag;
    }

    public String getLabel() {
        return this.label;
    }

    public JSONObject getExtJson() {
        return this.extJson;
    }

    public JSONObject getMaterialMeta() {
        return this.materialMeta;
    }
}
