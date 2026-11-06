var __defProp = Object.defineProperty;
var __defProps = Object.defineProperties;
var __getOwnPropDescs = Object.getOwnPropertyDescriptors;
var __getOwnPropSymbols = Object.getOwnPropertySymbols;
var __hasOwnProp = Object.prototype.hasOwnProperty;
var __propIsEnum = Object.prototype.propertyIsEnumerable;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __spreadValues = (a, b) => {
  for (var prop in b || (b = {}))
    if (__hasOwnProp.call(b, prop))
      __defNormalProp(a, prop, b[prop]);
  if (__getOwnPropSymbols)
    for (var prop of __getOwnPropSymbols(b)) {
      if (__propIsEnum.call(b, prop))
        __defNormalProp(a, prop, b[prop]);
    }
  return a;
};
var __spreadProps = (a, b) => __defProps(a, __getOwnPropDescs(b));
(function() {
  "use strict";
  var _a;
  const rows = [["blink", "眨眼"], ["mouth", "张嘴"], ["smile", "大笑"], ["sad", "悲伤"], ["angry", "生气"]], defaults = () => ({ enabled: true, items: Object.fromEntries(rows.map(([key]) => [key, { sensitivity: 100 }])) }), direct = Object.fromEntries(rows.map(([key]) => [key, false]));
  let settings = defaults();
  try {
    const old = JSON.parse(localStorage.getItem("yuzu-expression-controls-v1"));
    if (old) {
      settings.enabled = old.enabled !== false;
      for (const [key] of rows) if ((_a = old.items) == null ? void 0 : _a[key]) {
        const value = Number(old.items[key].sensitivity);
        settings.items[key] = { sensitivity: old.items[key].enabled === false ? 0 : Number.isFinite(value) ? Math.max(0, Math.min(200, value)) : 100 };
      }
    }
  } catch (e) {
  }
  const box = document.createElement("dialog");
  box.id = "expressionControls";
  box.innerHTML = '<header><h3>开关及调试</h3><button type="button" id="expressionClose" aria-label="关闭开关及调试">×</button></header><small class="adjust-scroll-hint">可下滑</small><label class="expression-master"><input id="expressionMaster" type="checkbox">开启表情检测</label><div id="expressionRows"></div><button type="button" id="expressionReset">恢复默认灵敏度</button>';
  document.body.append(box);
  box.setAttribute("aria-label", "开关及调试");
  const openButton = document.createElement("button");
  openButton.id = "petExpressions";
  openButton.type = "button";
  openButton.textContent = "开关及调试";
  document.getElementById("petCamera").after(openButton);
  openButton.onclick = () => box.showModal();
  box.querySelector("#expressionClose").onclick = () => box.close();
  const preview = document.getElementById("petShowCamera");
  document.querySelector("#petRoom .pet-controls").append(preview);
  const master = box.querySelector("#expressionMaster");
  master.checked = settings.enabled;
  function store() {
    try {
      localStorage.setItem("yuzu-expression-controls-v1", JSON.stringify(settings));
    } catch (e) {
    }
    for (const el of box.querySelectorAll("[data-setting]")) el.disabled = !settings.enabled;
  }
  for (const [key, label] of rows) {
    const line = document.createElement("div");
    line.className = "expression-row";
    line.innerHTML = '<label for="sensitivity_' + key + '">' + label + '</label><input data-setting id="sensitivity_' + key + '" type="range" min="0" max="200" step="5" aria-label="' + label + '灵敏度"><output></output><input class="expression-direct" id="trigger_' + key + '" type="checkbox" aria-label="直接触发' + label + '" title="直接触发' + label + '">';
    const check = line.querySelector(".expression-direct"), range = line.querySelector("input[type=range]"), output = line.querySelector("output");
    range.value = settings.items[key].sensitivity;
    output.textContent = range.value + "%";
    check.onchange = () => {
      direct[key] = check.checked;
    };
    range.oninput = () => {
      settings.items[key].sensitivity = Number(range.value);
      output.textContent = range.value + "%";
      store();
    };
    box.querySelector("#expressionRows").append(line);
  }
  master.onchange = () => {
    settings.enabled = master.checked;
    store();
  };
  box.querySelector("#expressionReset").onclick = () => {
    for (const [key] of rows) {
      settings.items[key].sensitivity = 100;
      box.querySelector("#sensitivity_" + key).value = 100;
      box.querySelector("#sensitivity_" + key).nextElementSibling.textContent = "100%";
    }
    store();
  };
  function clearDirect() {
    for (const [key] of rows) {
      direct[key] = false;
      box.querySelector("#trigger_" + key).checked = false;
    }
  }
  function filter(raw) {
    const value = __spreadProps(__spreadValues({}, raw), { tracking: {} });
    for (const [key] of rows) {
      const item = settings.items[key], forced = direct[key], enabled = forced || settings.enabled && item.sensitivity > 0, gain = item.sensitivity / 100, keys = key === "blink" ? ["blink", "blinkLeft", "blinkRight"] : key === "mouth" ? ["mouth", "mouthX", "mouthForm"] : [key];
      value.tracking[key] = enabled;
      for (const k of keys) {
        if (forced) value[k] = k === "mouthX" || k === "mouthForm" ? 0 : 1;
        else if (k in value || !enabled) value[k] = enabled ? Math.max(k === "mouthX" || k === "mouthForm" ? -1 : 0, Math.min(1, (Number(value[k]) || 0) * gain)) : 0;
      }
    }
    return value;
  }
  window.addEventListener("cotton-pet-state-change", () => {
    var _a2;
    if (!((_a2 = window.CottonPetHost) == null ? void 0 : _a2.isActive())) clearDirect();
  });
  const camera = document.getElementById("petCamera");
  function sync() {
    openButton.hidden = camera.hidden;
    if (camera.hidden) {
      box.close();
      clearDirect();
    }
  }
  new MutationObserver(sync).observe(camera, { attributes: true, attributeFilter: ["hidden"] });
  sync();
  store();
  window.CottonExpressionControls = { filter, getSettings: () => structuredClone(settings), clearDirect };
})();
(function() {
  "use strict";
  let settings = { head: 100, body: 100, hair: 100, ears: 100, wings: 100, highlight: 100 };
  try {
    const saved = JSON.parse(localStorage.getItem("yuzu-motion-amplitude-v1") || "{}");
    for (const k of Object.keys(settings)) if (Number.isFinite(saved[k])) settings[k] = Math.max(0, Math.min(200, saved[k]));
  } catch (e) {
  }
  const rows = [["head", "头部"], ["body", "身体"], ["hair", "头发"], ["ears", "耳朵"], ["wings", "翅膀"], ["highlight", "高光"]], box = document.getElementById("expressionControls"), section = document.createElement("section");
  section.className = "motion-amplitudes";
  section.innerHTML = "<h4>动画幅度</h4>";
  for (const [key, label] of rows) {
    const line = document.createElement("label");
    line.className = "expression-row";
    line.innerHTML = "<span>" + label + '</span><input type="range" min="0" max="200" step="5" aria-label="' + label + '动画幅度"><output></output>';
    const slider = line.querySelector("input"), output = line.querySelector("output");
    slider.value = settings[key];
    output.textContent = settings[key] + "%";
    slider.oninput = () => {
      settings[key] = Number(slider.value);
      output.textContent = slider.value + "%";
      try {
        localStorage.setItem("yuzu-motion-amplitude-v1", JSON.stringify(settings));
      } catch (e) {
      }
    };
    section.append(line);
  }
  box.append(section);
  window.CottonMotionControls = { getSettings: () => __spreadValues({}, settings) };
})();
(function() {
  "use strict";
  const $ = (id) => document.getElementById(id), frame = $("cottonFrame");
  let nativeSaveMessage = "";
  async function save(blob, name) {
    if (window.CottonAndroidExports) {
      showExportNotice(/^(image\/|video\/)/.test(blob.type) ? "正在保存到相册…" : "请选择文件保存位置…", true);
      const result = await window.CottonAndroidExports.saveBlob(blob, name);
      nativeSaveMessage = result.message;
      return;
    }
    const a = document.createElement("a"), url = URL.createObjectURL(blob);
    a.href = url;
    a.download = name;
    document.body.append(a);
    a.click();
    a.remove();
    setTimeout(() => URL.revokeObjectURL(url), 5e3);
  }
  const entry = $("bMeme");
  const root = document.createElement("section");
  root.id = "memeRoom";
  root.hidden = true;
  root.setAttribute("aria-label", "meme表情制作");
  root.innerHTML = '<header><h2>meme表情</h2><button type="button" id="memeClose" aria-label="关闭表情制作">×</button></header><div class="meme-layout"><div class="meme-preview"><canvas id="memeCanvas" width="768" height="768" aria-label="表情包角色预览"></canvas></div><aside><label>模板分类<select id="memeCategory" aria-label="模板分类"><option value="dance">舞蹈类</option><option value="meme" selected>表情包类</option></select></label><label>动作模板<select id="memeMotion" aria-label="动作模板"></select></label><label>表情<select id="memeFace" aria-label="表情"><option value="outfit">当前装扮</option><option value="happy">开心</option><option value="sad">委屈</option><option value="angry">生气</option><option value="surprise">惊讶</option><option value="closed">闭眼</option></select></label><button id="memePlay" type="button">暂停动作</button><label class="meme-speed">动作速度 <output id="memeSpeedValue">1.5×</output><input id="memeSpeed" aria-label="动作速度" type="range" min="0.5" max="2.5" step="0.1" value="1.5"></label><label>背景<select id="memeBackground" aria-label="表情包背景"><option value="transparent">透明底</option><option value="solid">纯色</option><option value="green">绿幕</option><option value="custom">自行导入</option></select></label><input id="memeColor" aria-label="表情包背景颜色" type="color" value="#f5dfe3" hidden><input id="memeFile" type="file" accept="image/png,image/jpeg,image/webp" hidden><button id="memeImport" type="button" hidden>导入背景</button><label>导出大小<select id="memeQuality" aria-label="表情包体积"><option value="small" selected>适配表情包</option><option value="normal">标准 · 日常分享</option><option value="large">大体积 · 更清晰</option></select></label><button id="memeBatch" type="button">一键导出</button><button id="memePNG" type="button">导出当前表情 PNG · 图片</button><button id="memeGIF" type="button">导出动作 GIF · 动图</button><button id="memeLayers" type="button">导出装扮拆分 ZIP · 文件</button><button id="memeMP4" type="button" title="MP4视频不支持透明，透明底会填充奶白色">导出动作 MP4 · 视频</button><p id="memeStatus" role="status">方格仅用于预览，透明底导出保留真实透明。</p></aside></div>';
  document.body.append(root);
  const quality = () => ({ small: { size: 240, png: 512, fps: 12, bitrate: 15e5 }, normal: { size: 320, png: 768, fps: 18, bitrate: 3e6 }, large: { size: 480, png: 1024, fps: 24, bitrate: 5e6 } })[$("memeQuality").value];
  const exportNotice = document.createElement("div");
  exportNotice.id = "memeExportNotice";
  exportNotice.hidden = true;
  exportNotice.setAttribute("role", "status");
  exportNotice.setAttribute("aria-live", "polite");
  root.append(exportNotice);
  let noticeTimer = 0;
  function showExportNotice(text, waiting) {
    clearTimeout(noticeTimer);
    exportNotice.textContent = text;
    exportNotice.hidden = false;
    exportNotice.classList.toggle("waiting", waiting);
    if (!waiting) noticeTimer = setTimeout(() => {
      exportNotice.hidden = true;
    }, text.includes("失败") ? 5e3 : 3e3);
  }
  const motionNames = { sway: "轻摇节拍", step: "小步踏拍", wave: "招手问好", twist: "左右扭扭", swing: "摆手律动", hop: "元气蹦跳", elastic: "软弹节拍", flip: "转身小舞", breath: "呼吸律动", sidestep: "横步摇摆", paw: "猫爪摇摇", disco: "指尖迪斯科", waltz: "小小华尔兹", penguin: "企鹅踏步", nod: "点头打拍", starjump: "星星跳跃", rocket: "举手应援", shuffle: "踢腿踏拍", groove: "全身律动", still: "静静站好", ribbonstep: "丝带摇摆", heeltap: "踮脚点拍", heartbounce: "爱心蹦蹦", bowbeat: "鞠躬谢幕" };
  const defaultFaces = { wave: "happy", swing: "happy", hop: "happy", paw: "happy", disco: "happy", starjump: "happy", rocket: "happy", groove: "happy", ribbonstep: "happy", heartbounce: "happy", bowbeat: "happy" };
  function populateMotions() {
    const select = $("memeMotion");
    select.replaceChildren();
    select.disabled = false;
    $("memeGIF").disabled = false;
    if ($("memeCategory").value === "meme") {
      const option = document.createElement("option");
      option.value = "peace-selfie";
      option.textContent = "贴贴比耶";
      select.append(option);
      const fingers = document.createElement("option");
      fingers.value = "cry-fingers";
      fingers.textContent = "哭哭对手指";
      select.append(fingers);
      const grin = document.createElement("option");
      grin.value = "grin-laugh";
      grin.textContent = "露齿笑";
      select.append(grin);
      const take = document.createElement("option");
      take.value = "take-it";
      take.textContent = "拿来吧";
      select.append(take);
      const love = document.createElement("option");
      love.value = "love-cheeks";
      love.textContent = "喜欢";
      select.append(love);
      const talk = document.createElement("option");
      talk.value = "talk-bubbles";
      talk.textContent = "说话";
      select.append(talk);
      const peek = document.createElement("option");
      peek.value = "peek-head";
      peek.textContent = "探头";
      select.append(peek);
      const punch = document.createElement("option");
      punch.value = "angry-punch";
      punch.textContent = "生气";
      select.append(punch);
      const menace = document.createElement("option");
      menace.value = "menace";
      menace.textContent = "杀意";
      select.append(menace);
      const confused = document.createElement("option");
      confused.value = "confused";
      confused.textContent = "疑惑";
      select.append(confused);
      const sweat = document.createElement("option");
      sweat.value = "sweat-drop";
      sweat.textContent = "无语";
      select.append(sweat);
      const overload = document.createElement("option");
      overload.value = "overload";
      overload.textContent = "过载";
      select.append(overload);
      const listening = document.createElement("option");
      listening.value = "nod-listen";
      listening.textContent = "认真听";
      select.append(listening);
      const phone = document.createElement("option");
      phone.value = "phone-play";
      phone.textContent = "玩手机";
      select.append(phone);
      const taunt = document.createElement("option");
      taunt.value = "taunt";
      taunt.textContent = "挑衅";
      select.append(taunt);
      const thinking = document.createElement("option");
      thinking.value = "thinking";
      thinking.textContent = "想一想";
      select.append(thinking);
      const begging = document.createElement("option");
      begging.value = "begging";
      begging.textContent = "乞讨";
      select.append(begging);
      const call = document.createElement("option");
      call.value = "call";
      call.textContent = "打call";
      select.append(call);
      const hug = document.createElement("option");
      hug.value = "hug";
      hug.textContent = "抱抱";
      select.append(hug);
      const pat = document.createElement("option");
      pat.value = "pat";
      pat.textContent = "摸摸";
      select.append(pat);
      const received = document.createElement("option");
      received.value = "received";
      received.textContent = "收到";
      select.append(received);
      const sleepy = document.createElement("option");
      sleepy.value = "sleepy";
      sleepy.textContent = "好困";
      select.append(sleepy);
      const wow = document.createElement("option");
      wow.value = "wow";
      wow.textContent = "惊喜";
      select.append(wow);
      const badLaugh = document.createElement("option");
      badLaugh.value = "bad-laugh";
      badLaugh.textContent = "坏笑";
      select.append(badLaugh);
      const musicListen = document.createElement("option");
      musicListen.value = "music-listen";
      musicListen.textContent = "听歌";
      select.append(musicListen);
      const shakeNo = document.createElement("option");
      shakeNo.value = "shake-no";
      shakeNo.textContent = "摇头";
      select.append(shakeNo);
      const chinThink = document.createElement("option");
      chinThink.value = "chin-think";
      chinThink.textContent = "思考";
      select.append(chinThink);
      const me = document.createElement("option");
      me.value = "me";
      me.textContent = "我吗";
      select.append(me);
      const fine = document.createElement("option");
      fine.value = "im-fine";
      fine.textContent = "我没事";
      select.append(fine);
      const satisfied = document.createElement("option");
      satisfied.value = "satisfied";
      satisfied.textContent = "满足";
      select.append(satisfied);
      const bigCry = document.createElement("option");
      bigCry.value = "big-cry";
      bigCry.textContent = "大哭";
      select.append(bigCry);
      const notAngry = document.createElement("option");
      notAngry.value = "not-angry";
      notAngry.textContent = "没有生气";
      select.append(notAngry);
      const lickScreen = document.createElement("option");
      lickScreen.value = "lick-screen";
      lickScreen.textContent = "舔屏";
      select.append(lickScreen);
      const knock = document.createElement("option");
      knock.value = "knock";
      knock.textContent = "敲敲";
      select.append(knock);
      const melancholy = document.createElement("option");
      melancholy.value = "melancholy";
      melancholy.textContent = "忧郁";
      select.append(melancholy);
      const smart = document.createElement("option");
      smart.value = "smart";
      smart.textContent = "聪明";
      select.append(smart);
      const afraid = document.createElement("option");
      afraid.value = "afraid";
      afraid.textContent = "害怕";
      select.append(afraid);
      const heartHeart = document.createElement("option");
      heartHeart.value = "heart-heart";
      heartHeart.textContent = "心心";
      select.append(heartHeart);
      const yell = document.createElement("option");
      yell.value = "yell";
      yell.textContent = "大叫";
      select.append(yell);
      const please = document.createElement("option");
      please.value = "please";
      please.textContent = "求求";
      select.append(please);
      $("memeFace").value = "outfit";
      $("memeStatus").textContent = "贴贴比耶";
    } else {
      for (const m of api().motions) {
        const option = document.createElement("option");
        option.value = m.id;
        option.textContent = motionNames[m.id] || m.name;
        select.append(option);
      }
      select.value = "ribbonstep";
      $("memeFace").value = defaultFaces[select.value] || "outfit";
      $("memeStatus").textContent = "方格仅用于预览，透明底导出保留真实透明。";
    }
    time = 0;
    $("memeFace").dispatchEvent(new Event("change", { bubbles: true }));
  }
  let active = false, playing = true, time = 0, last = 0, raf = 0, image = null, busy = false;
  const canvas = $("memeCanvas"), preview = root.querySelector(".meme-preview"), api = () => {
    var _a;
    return (_a = frame.contentWindow) == null ? void 0 : _a.CottonMemeRenderer;
  };
  function paint(target = canvas, background2 = false, frameTime = time) {
    const render = api();
    if (!render) return;
    render.render(target, frameTime, { motion: $("memeMotion").value, face: $("memeFace").value });
    if (background2 && $("memeBackground").value !== "transparent") {
      const g = target.getContext("2d");
      g.save();
      g.globalCompositeOperation = "destination-over";
      const kind = $("memeBackground").value;
      if (kind === "custom" && image) {
        const scale = Math.max(target.width / image.width, target.height / image.height), w = image.width * scale, h = image.height * scale;
        g.drawImage(image, (target.width - w) / 2, (target.height - h) / 2, w, h);
      } else {
        g.fillStyle = kind === "green" ? "#00ff00" : $("memeColor").value;
        g.fillRect(0, 0, target.width, target.height);
      }
      g.restore();
    }
  }
  function loop(now) {
    if (!active) return;
    if (document.hidden) {
      last = now;
      raf = requestAnimationFrame(loop);
      return;
    }
    if (playing) {
      time += Math.min(0.05, (now - last) / 1e3 || 0) * Number($("memeSpeed").value);
    }
    last = now;
    if (!busy && playing) paint();
    raf = requestAnimationFrame(loop);
  }
  function background() {
    const kind = $("memeBackground").value;
    $("memeColor").hidden = kind !== "solid";
    $("memeImport").hidden = kind !== "custom";
    preview.style.backgroundImage = kind === "transparent" ? "conic-gradient(#e2e5e3 25%,#fff 0 50%,#e2e5e3 0 75%,#fff 0)" : kind === "custom" && image ? 'url("' + image.src + '")' : "none";
    preview.style.backgroundSize = kind === "transparent" ? "24px 24px" : "cover";
    preview.style.backgroundPosition = "center";
    preview.style.backgroundColor = kind === "green" ? "#00ff00" : kind === "solid" ? $("memeColor").value : "#f7f4ed";
  }
  entry.onclick = () => {
    if (!api()) return;
    CottonPetHost.close();
    active = true;
    playing = true;
    time = 0;
    last = performance.now();
    $("memePlay").textContent = "暂停动作";
    root.hidden = false;
    $("menu").inert = true;
    $("puppetFrameDock").style.visibility = "hidden";
    $("memeCategory").value = "meme";
    $("memeCategory").dispatchEvent(new Event("change", { bubbles: true }));
    background();
    raf = requestAnimationFrame(loop);
    $("memeClose").focus();
  };
  function close() {
    active = false;
    cancelAnimationFrame(raf);
    root.hidden = true;
    $("menu").inert = false;
    $("puppetFrameDock").style.visibility = "";
    entry.focus();
  }
  $("memeClose").onclick = close;
  document.addEventListener("keydown", (e) => {
    if (e.key === "Escape" && active) close();
  });
  $("memeSpeed").oninput = () => {
    $("memeSpeedValue").textContent = Number($("memeSpeed").value).toFixed(1) + "×";
  };
  $("memePlay").onclick = () => {
    playing = !playing;
    $("memePlay").textContent = playing ? "暂停动作" : "继续动作";
  };
  $("memeCategory").onchange = () => {
    populateMotions();
    paint();
  };
  $("memeMotion").onchange = () => {
    var _a;
    time = 0;
    playing = true;
    $("memePlay").textContent = "暂停动作";
    const motion = $("memeMotion").value;
    if (motion === "call") {
      $("memeSpeed").value = "1.3";
      $("memeSpeed").dispatchEvent(new Event("input"));
    }
    if (motion === "received" || motion === "knock") {
      $("memeSpeed").value = "1.5";
      $("memeSpeed").dispatchEvent(new Event("input"));
    }
    if (motion === "wow") {
      $("memeSpeed").value = "1.8";
      $("memeSpeed").dispatchEvent(new Event("input"));
    }
    $("memeFace").value = ["call", "take-it", "love-cheeks", "peek-head"].includes(motion) ? "happy" : motion === "cry-fingers" ? "sad" : motion === "angry-punch" ? "angry" : motion === "confused" ? "surprise" : defaultFaces[motion] || "outfit";
    $("memeFace").dispatchEvent(new Event("change", { bubbles: true }));
    $("memeStatus").textContent = ((_a = $("memeMotion").selectedOptions[0]) == null ? void 0 : _a.textContent) || "";
    paint();
  };
  $("memeFace").onchange = () => paint();
  $("memeBackground").onchange = background;
  $("memeColor").oninput = background;
  $("memeImport").onclick = () => $("memeFile").click();
  $("memeFile").onchange = async function() {
    const file = this.files[0];
    this.value = "";
    if (!file) return;
    let url;
    try {
      if (!/^image\/(png|jpeg|webp)$/.test(file.type) || file.size > 20 * 1024 * 1024) throw Error("请选择20MB以内的PNG、JPG或WebP图片");
      url = URL.createObjectURL(file);
      const next = new Image();
      next.src = url;
      await next.decode();
      const c = document.createElement("canvas"), scale = Math.min(1, 1600 / Math.max(next.width, next.height));
      c.width = Math.round(next.width * scale);
      c.height = Math.round(next.height * scale);
      c.getContext("2d").drawImage(next, 0, 0, c.width, c.height);
      const ready = new Image();
      ready.src = c.toDataURL("image/png");
      await ready.decode();
      image = ready;
      background();
      $("memeStatus").textContent = "背景已导入";
    } catch (e) {
      $("memeStatus").textContent = e.message;
    } finally {
      if (url) URL.revokeObjectURL(url);
    }
  };
  async function exportFile(split) {
    if (busy) return;
    busy = true;
    nativeSaveMessage = "";
    root.setAttribute("aria-busy", "true");
    $("memeStatus").textContent = "正在导出…";
    showExportNotice("正在导出…", true);
    const resume = playing, locked = [...root.querySelectorAll("button,select,input")].map((el) => [el, el.disabled]);
    for (const [el] of locked) el.disabled = true;
    playing = false;
    try {
      await new Promise((resolve) => requestAnimationFrame(() => requestAnimationFrame(resolve)));
      await api().ready;
      if (split === "mp4") {
        if ($("memeBackground").value === "custom" && !image) throw Error("请先导入背景图片");
        const motion = $("memeMotion").value, rate = Number($("memeSpeed").value), duration = (motion === "knock" ? 2.4 : ["sleepy", "melancholy"].includes(motion) ? 6 : motion === "music-listen" ? 2 : ["please", "afraid", "im-fine", "me", "hug", "wow", "bad-laugh"].includes(motion) ? 4.5 : 3) / rate;
        const blob = await api().mp4((c, offset) => paint(c, true, offset * rate), { duration, size: quality().png, fps: quality().fps, bitrate: quality().bitrate, opaque: $("memeBackground").value === "transparent" });
        await save(blob, "柚松屋-meme动作.mp4");
        $("memeStatus").textContent = "已导出MP4视频";
      } else if (split === "gif") {
        if ($("memeBackground").value === "custom" && !image) throw Error("请先导入背景图片");
        $("memeStatus").textContent = "正在生成动作…";
        const origin = ["please", "yell", "heart-heart", "afraid", "smart", "melancholy", "knock", "lick-screen", "not-angry", "big-cry", "satisfied", "im-fine", "me", "chin-think", "bad-laugh", "music-listen", "wow", "sleepy", "received", "hug", "begging", "peek-head", "angry-punch", "menace"].includes($("memeMotion").value) ? 0 : time, rate = Number($("memeSpeed").value);
        const blob = await api().gif((c, offset) => paint(c, true, origin + offset * rate), { duration: ($("memeMotion").value === "knock" ? 2.4 : $("memeMotion").value === "sleepy" || $("memeMotion").value === "melancholy" ? 6 : $("memeMotion").value === "music-listen" ? 2 : ["please", "afraid", "im-fine", "me", "hug", "wow", "bad-laugh"].includes($("memeMotion").value) ? 4.5 : 3) / rate, frames: $("memeMotion").value === "please" ? 75 : ["yell", "heart-heart"].includes($("memeMotion").value) ? 50 : $("memeMotion").value === "afraid" ? 75 : ["smart", "melancholy", "knock"].includes($("memeMotion").value) ? 80 : $("memeMotion").value === "lick-screen" ? 90 : $("memeMotion").value === "not-angry" ? 45 : $("memeMotion").value === "big-cry" ? 60 : $("memeMotion").value === "satisfied" ? 40 : $("memeMotion").value === "sleepy" ? 60 : $("memeMotion").value === "chin-think" ? 40 : $("memeMotion").value === "music-listen" ? 45 : ["im-fine", "me", "wow", "bad-laugh"].includes($("memeMotion").value) ? 45 : 30, loop: true, size: quality().size });
        await save(blob, "柚松屋-meme动作.gif");
        $("memeStatus").textContent = "已按当前速度导出GIF";
      } else if (split) {
        $("memeStatus").textContent = "正在整理当前装扮图层…";
        const result = await api().layers();
        await save(result.blob, "柚松屋-当前装扮拆分.zip");
        $("memeStatus").textContent = "已导出 " + result.count + " 张透明图层，附合成图和图层说明";
      } else {
        if ($("memeBackground").value === "custom" && !image) throw Error("请先导入背景图片");
        const c = document.createElement("canvas");
        c.width = c.height = quality().png;
        paint(c, true);
        await save(await api().png(c), "柚松屋-meme表情.png");
        $("memeStatus").textContent = $("memeBackground").value === "transparent" ? "已导出真实透明 PNG" : "已连同背景导出 PNG";
      }
    } catch (e) {
      $("memeStatus").textContent = e.message.includes("取消") ? e.message : "导出失败：" + e.message;
    } finally {
      if (nativeSaveMessage) $("memeStatus").textContent = nativeSaveMessage;
      showExportNotice($("memeStatus").textContent, false);
      root.removeAttribute("aria-busy");
      busy = false;
      playing = resume;
      last = performance.now();
      for (const [el, disabled] of locked) el.disabled = disabled;
    }
  }
  const batch = document.createElement("dialog");
  batch.id = "memeBatchDialog";
  batch.innerHTML = '<header><h3>一键导出表情包</h3><button type="button" id="memeBatchClose" aria-label="关闭批量导出">×</button></header><label>格式<select id="memeBatchFormat"><option value="gif">GIF · 动图</option><option value="png">PNG · 图片</option></select></label><label><input id="memeBatchAll" type="checkbox" checked>全选</label><div id="memeBatchItems"></div><p id="memeBatchProgress" role="status"></p><footer><button id="memeBatchCancel" type="button">取消</button><button id="memeBatchConfirm" type="button">确定导出</button></footer>';
  document.body.append(batch);
  let batchCancelled = false, batchRunning = false;
  const batchStyle = document.createElement("style");
  batchStyle.textContent = "#memeBatchDialog{box-sizing:border-box;width:360px;max-width:calc(100vw - 24px);max-height:85vh;overflow-y:auto;background:#faf9f2;border:1px solid #d6dfd0;border-radius:22px;padding:20px;color:#74856d;font:14px YuzuPop,sans-serif}#memeBatchDialog header,#memeBatchDialog footer{display:flex;justify-content:space-between;gap:8px}#memeBatchDialog button,#memeBatchDialog select{padding:8px 12px;border:1px solid #d9e0d1;border-radius:10px;color:inherit;background:#e8eedf;font:inherit}#memeBatchItems{display:grid;grid-template-columns:1fr 1fr;gap:8px;max-height:43vh;overflow-y:scroll;scrollbar-width:thin;padding:12px 0}#memeBatchItems label{font-size:12px;display:flex;align-items:center;gap:6px}#memeBatchDialog::backdrop{background:#46534766}";
  document.head.append(batchStyle);
  $("memeBatch").onclick = () => {
    if (busy) return;
    const oldCategory = $("memeCategory").value, oldMotion = $("memeMotion").value;
    $("memeCategory").value = "meme";
    populateMotions();
    const options = [...$("memeMotion").options].map((o) => ({ id: o.value, name: o.textContent }));
    $("memeCategory").value = oldCategory;
    populateMotions();
    $("memeMotion").value = oldMotion;
    $("memeBatchItems").replaceChildren();
    for (const o of options) {
      const label = document.createElement("label"), input = document.createElement("input");
      input.type = "checkbox";
      input.checked = true;
      input.value = o.id;
      input.dataset.label = o.name;
      label.append(input, document.createTextNode(o.name));
      $("memeBatchItems").append(label);
    }
    $("memeBatchAll").checked = true;
    $("memeBatchProgress").textContent = "按当前装扮、背景和导出大小，合并保存为一个文件。";
    batch.showModal();
  };
  $("memeBatchAll").onchange = function() {
    for (const input of $("memeBatchItems").querySelectorAll("input")) input.checked = this.checked;
  };
  $("memeBatchClose").onclick = $("memeBatchCancel").onclick = () => {
    if (batchRunning) {
      batchCancelled = true;
      $("memeBatchProgress").textContent = "正在停止，当前表情生成后取消…";
    } else batch.close();
  };
  batch.addEventListener("cancel", (e) => {
    if (batchRunning) {
      e.preventDefault();
      batchCancelled = true;
    }
  });
  $("memeBatchConfirm").onclick = async () => {
    if (busy) return;
    const chosen = [...$("memeBatchItems").querySelectorAll("input:checked")];
    if (!chosen.length) {
      $("memeBatchProgress").textContent = "请至少选择一个表情包";
      return;
    }
    busy = batchRunning = true;
    batchCancelled = false;
    const original = { category: $("memeCategory").value, motion: $("memeMotion").value, face: $("memeFace").value, speed: $("memeSpeed").value, time, playing };
    playing = false;
    const locked = [...root.querySelectorAll("button,input,select"), ...batch.querySelectorAll("input,select,#memeBatchConfirm")].map((el) => [el, el.disabled]);
    for (const [el] of locked) el.disabled = true;
    const format = $("memeBatchFormat").value, files = [];
    let bytes = 0;
    try {
      await api().ready;
      $("memeCategory").value = "meme";
      populateMotions();
      for (let i = 0; i < chosen.length; i++) {
        if (batchCancelled) throw Error("已取消批量导出");
        const item = chosen[i];
        $("memeMotion").value = item.value;
        $("memeFace").value = "outfit";
        $("memeBatchProgress").textContent = "正在导出 " + (i + 1) + " / " + chosen.length + " · " + item.dataset.label;
        await new Promise((resolve) => setTimeout(resolve, 0));
        const rate = Number(original.speed), duration = (["sleepy", "melancholy"].includes(item.value) ? 6 : ["please", "afraid", "im-fine", "me", "hug", "wow", "bad-laugh"].includes(item.value) ? 4.5 : item.value === "knock" ? 2.4 : item.value === "music-listen" ? 2 : 3) / rate;
        let blob;
        if (format === "png") {
          const c = document.createElement("canvas");
          c.width = c.height = quality().png;
          paint(c, true, 0.8);
          blob = await api().png(c);
          c.width = c.height = 1;
        } else blob = await api().gif((c, offset) => paint(c, true, offset * rate), { duration, size: quality().size, frames: Math.min(90, Math.ceil(duration * quality().fps)), loop: true });
        bytes += blob.size;
        if (bytes > 150 * 1024 * 1024) throw Error("总文件超过150MB，请减少勾选或改用小体积");
        files.push({ name: item.dataset.label + "." + format, blob });
      }
      if (batchCancelled) throw Error("已取消批量导出");
      $("memeBatchProgress").textContent = "正在整理文件…";
      await save(await api().zip(files), "柚松屋-表情包合集.zip");
      $("memeBatchProgress").textContent = "已导出 " + files.length + " 个表情包";
      showExportNotice(nativeSaveMessage || $("memeBatchProgress").textContent, false);
    } catch (e) {
      $("memeBatchProgress").textContent = e.message || "批量导出失败";
    } finally {
      $("memeCategory").value = original.category;
      populateMotions();
      $("memeMotion").value = original.motion;
      $("memeFace").value = original.face;
      $("memeSpeed").value = original.speed;
      time = original.time;
      playing = original.playing;
      busy = batchRunning = false;
      last = performance.now();
      for (const [el, disabled] of locked) el.disabled = disabled;
    }
  };
  window.CottonMemeBatch = { getStatus: () => ({ running: batchRunning, count: $("memeBatchItems").querySelectorAll("input:checked").length }), quality };
  $("memePNG").onclick = () => exportFile(false);
  $("memeLayers").onclick = () => exportFile(true);
  $("memeGIF").onclick = () => exportFile("gif");
  $("memeMP4").onclick = () => exportFile("mp4");
})();
(function() {
  "use strict";
  var _a, _b, _c;
  const popup = document.createElement("dialog");
  popup.id = "themeSelectDialog";
  popup.setAttribute("aria-label", "选择选项");
  popup.innerHTML = '<header><h3></h3><button type="button" aria-label="关闭选项">×</button></header><input type="search" placeholder="找一找" aria-label="搜索选项"><div class="theme-choice-list" role="listbox"></div>';
  document.body.append(popup);
  let current = null;
  const search = popup.querySelector("input"), list = popup.querySelector(".theme-choice-list");
  function close() {
    popup.close();
    if (current) {
      current.button.setAttribute("aria-expanded", "false");
      current.button.focus();
    }
  }
  popup.querySelector("header button").onclick = close;
  popup.addEventListener("cancel", () => current == null ? void 0 : current.button.setAttribute("aria-expanded", "false"));
  popup.addEventListener("click", (e) => {
    if (e.target === popup) close();
  });
  function choices() {
    list.replaceChildren();
    if (!current) return;
    const needle = search.value.trim().toLowerCase();
    for (const option of current.select.options) {
      if (option.hidden || needle && !option.textContent.toLowerCase().includes(needle)) continue;
      const button = document.createElement("button");
      button.type = "button";
      button.setAttribute("role", "option");
      button.setAttribute("aria-selected", String(option.selected));
      button.disabled = option.disabled;
      const label = document.createElement("span");
      label.textContent = option.textContent;
      const check = document.createElement("span");
      check.textContent = option.selected ? "✓" : "";
      check.setAttribute("aria-hidden", "true");
      button.append(label, check);
      button.onclick = () => {
        current.select.value = option.value;
        current.select.dispatchEvent(new Event("input", { bubbles: true }));
        current.select.dispatchEvent(new Event("change", { bubbles: true }));
        current.sync();
        close();
      };
      list.append(button);
    }
    if (!list.children.length) {
      const empty = document.createElement("p");
      empty.textContent = "没有找到这个选项";
      list.append(empty);
    }
  }
  search.oninput = choices;
  for (const select of document.querySelectorAll("#petPick,#memeCategory,#memeMotion,#memeFace,#memeBackground,#partImportMode,#partImportType,#partImportTemplate")) {
    const title = select.getAttribute("aria-label") || ((_c = (_b = (_a = select.closest("label")) == null ? void 0 : _a.firstChild) == null ? void 0 : _b.textContent) == null ? void 0 : _c.trim()) || "选择选项", button = document.createElement("button");
    button.type = "button";
    button.className = "theme-select-button";
    button.setAttribute("aria-label", title);
    button.setAttribute("aria-haspopup", "dialog");
    button.setAttribute("aria-expanded", "false");
    const wrap = document.createElement("span");
    wrap.className = "theme-select-wrap";
    select.before(wrap);
    wrap.append(select, button);
    select.hidden = true;
    const sync = () => {
      var _a2;
      button.textContent = ((_a2 = select.selectedOptions[0]) == null ? void 0 : _a2.textContent) || "请选择";
      button.disabled = select.disabled;
    };
    sync();
    select.addEventListener("change", sync);
    if (select.id === "petPick") document.addEventListener("cotton-pet-selection", sync);
    new MutationObserver(sync).observe(select, { childList: true, subtree: true, attributes: true, attributeFilter: ["disabled", "selected"] });
    button.onclick = () => {
      var _a2;
      current = { select, button, sync };
      popup.querySelector("h3").textContent = title;
      search.value = "";
      search.hidden = select.options.length < 10;
      choices();
      button.setAttribute("aria-expanded", "true");
      popup.showModal();
      (_a2 = popup.querySelector("[aria-selected=true]")) == null ? void 0 : _a2.focus();
    };
  }
})();
