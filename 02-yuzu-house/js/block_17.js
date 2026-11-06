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
  const $ = (id) => document.getElementById(id), dock = $("puppetFrameDock"), room = $("petRoom"), toggle = $("petControlsToggle"), toolbox = toggle.parentElement, key = "yuzu-live-filters-v1";
  const specs = [["warm", "暖光", 0, 100, 0], ["cool", "冷光", 0, 100, 0], ["contrast", "对比度", 60, 145, 100], ["saturation", "饱和度", 0, 180, 100], ["brightness", "亮度", 75, 125, 100], ["soft", "朦胧柔光", 0, 100, 0]], defaults = Object.fromEntries(specs.map((s) => [s[0], s[4]]));
  function normalize(value = {}) {
    return Object.fromEntries(specs.map(([id, label, min, max, base]) => {
      const n = Number(value[id]);
      return [id, Math.round(Number.isFinite(n) ? Math.max(min, Math.min(max, n)) : base)];
    }));
  }
  let values = __spreadValues({}, defaults), queued = 0;
  try {
    values = normalize(JSON.parse(localStorage.getItem(key) || "{}"));
  } catch (e) {
  }
  const head = document.createElement("div");
  head.className = "pet-tools-head";
  toolbox.prepend(head);
  const open = document.createElement("button");
  open.id = "liveFilterOpen";
  open.type = "button";
  open.textContent = "滤镜";
  open.hidden = true;
  open.setAttribute("aria-expanded", "false");
  open.setAttribute("aria-controls", "liveFilterPanel");
  head.append(open, toggle);
  const panel = document.createElement("section");
  panel.id = "liveFilterPanel";
  panel.hidden = true;
  panel.setAttribute("aria-label", "滤镜调试");
  panel.innerHTML = '<header><h3>滤镜调试</h3><button type="button" id="liveFilterClose" aria-label="收起滤镜">×</button></header><div class="live-filter-grid">' + specs.map(([id, label, min, max, base]) => "<label><span>" + label + '</span><output id="lf-' + id + '-value">' + base + '%</output><input id="lf-' + id + '" type="range" min="' + min + '" max="' + max + '" value="' + base + '" step="1" aria-label="' + label + '"></label>').join("") + '</div><footer><span>只影响人物 · 自动记住</span><button type="button" id="liveFilterReset">恢复原色</button></footer>';
  document.body.append(panel);
  const svg = document.createElementNS("http://www.w3.org/2000/svg", "svg");
  svg.setAttribute("class", "live-filter-defs");
  svg.setAttribute("aria-hidden", "true");
  svg.innerHTML = '<defs><filter id="yuzu-live-grade" x="-10%" y="-10%" width="120%" height="120%" color-interpolation-filters="sRGB"><feColorMatrix id="lf-temperature" in="SourceGraphic" type="matrix" result="temperature"/><feColorMatrix id="lf-grade-saturation" in="temperature" type="saturate" values="1" result="saturated"/><feComponentTransfer in="saturated" result="graded"><feFuncR id="lf-contrast-r" type="linear" slope="1" intercept="0"/><feFuncG id="lf-contrast-g" type="linear" slope="1" intercept="0"/><feFuncB id="lf-contrast-b" type="linear" slope="1" intercept="0"/><feFuncA type="identity"/></feComponentTransfer><feGaussianBlur id="lf-soft-radius" in="graded" stdDeviation="0" result="mist"/><feBlend in="graded" in2="mist" mode="screen" result="glow"/><feComposite id="lf-soft-mix" in="graded" in2="glow" operator="arithmetic" k1="0" k2="1" k3="0" k4="0"/></filter></defs>';
  document.body.append(svg);
  function visible(show) {
    panel.hidden = !show;
    open.setAttribute("aria-expanded", String(show));
    if (show) {
      toolbox.classList.add("collapsed");
      toggle.textContent = "展开操作";
      toggle.setAttribute("aria-expanded", "false");
    }
  }
  function sync() {
    var _a;
    const state = (_a = window.CottonPetHost) == null ? void 0 : _a.getStatus(), live = (state == null ? void 0 : state.active) && state.mode === "live";
    open.hidden = !live;
    if (!live) visible(false);
    const altered = specs.some((s) => values[s[0]] !== s[4]);
    dock.style.filter = live && altered ? "url(#yuzu-live-grade)" : "";
    return live;
  }
  function apply() {
    queued = 0;
    const w = values.warm / 100, c = values.cool / 100, b = values.brightness / 100, contrast = values.contrast / 100, soft = values.soft / 100;
    $("lf-temperature").setAttribute("values", [1 + w * 0.13 - c * 0.07, 0, 0, 0, 0, 0, 1 + w * 0.02 + c * 0.015, 0, 0, 0, 0, 0, 1 - w * 0.13 + c * 0.14, 0, 0, 0, 0, 0, 1, 0].join(" "));
    $("lf-grade-saturation").setAttribute("values", String(values.saturation / 100));
    for (const channel of ["r", "g", "b"]) {
      $("lf-contrast-" + channel).setAttribute("slope", String(contrast * b));
      $("lf-contrast-" + channel).setAttribute("intercept", String((0.5 - 0.5 * contrast) * b));
    }
    $("lf-soft-radius").setAttribute("stdDeviation", String(soft * 6));
    $("lf-soft-mix").setAttribute("k2", String(1 - soft * 0.45));
    $("lf-soft-mix").setAttribute("k3", String(soft * 0.45));
    for (const [id] of specs) {
      $("lf-" + id).value = values[id];
      $("lf-" + id + "-value").textContent = values[id] + "%";
    }
    sync();
  }
  function store() {
    try {
      localStorage.setItem(key, JSON.stringify(values));
    } catch (e) {
    }
  }
  function set(value, save = true) {
    values = normalize(__spreadValues(__spreadValues({}, values), value));
    if (queued) cancelAnimationFrame(queued);
    apply();
    if (save) store();
    return __spreadValues({}, values);
  }
  open.onclick = () => visible(panel.hidden);
  $("liveFilterClose").onclick = () => visible(false);
  $("liveFilterReset").onclick = () => set(defaults);
  toggle.addEventListener("click", () => {
    if (!toolbox.classList.contains("collapsed")) visible(false);
  });
  for (const [id] of specs) $("lf-" + id).addEventListener("input", function() {
    values = normalize(__spreadProps(__spreadValues({}, values), { [id]: this.value }));
    $("lf-" + id + "-value").textContent = values[id] + "%";
    if (!queued) queued = requestAnimationFrame(apply);
    store();
  });
  window.addEventListener("cotton-pet-state-change", sync);
  apply();
  window.CottonLiveFilters = Object.freeze({ set, reset: () => set(defaults), getStatus: () => {
    var _a, _b;
    return { values: __spreadValues({}, values), defaults: __spreadValues({}, defaults), active: !!(((_a = window.CottonPetHost) == null ? void 0 : _a.getStatus().active) && ((_b = window.CottonPetHost) == null ? void 0 : _b.getStatus().mode) === "live"), panelOpen: !panel.hidden, applied: dock.style.filter !== "", softGlow: { radius: values.soft * 0.06, mix: values.soft * 45e-4, preservesSharpBase: true }, scope: "character-only" };
  } });
})();
(function() {
  "use strict";
  const $ = (id) => document.getElementById(id), dialog = $("petBackgroundDialog"), key = "yuzu-foreground-v1";
  const layer = document.createElement("div");
  layer.id = "petForeground";
  layer.setAttribute("aria-hidden", "true");
  const image = document.createElement("img");
  image.alt = "";
  image.draggable = false;
  layer.append(image);
  document.body.append(layer);
  const style = document.createElement("style");
  style.textContent = "#petForeground{position:fixed;top:0;right:0;bottom:0;left:0;inset:0;z-index:1103;pointer-events:none;overflow:hidden;display:none}#petForeground img{position:absolute;left:50%;top:50%;width:100%;height:100%;object-fit:contain;transform-origin:center;max-width:none}#petForegroundSettings{border-top:1px solid #dde3d8;margin-top:18px;padding-top:14px}#petForegroundSettings h4{margin:0 0 10px;font-size:15px}#petForegroundSettings .fg-actions{display:flex;gap:8px;flex-wrap:wrap}#petForegroundSettings label{display:flex;gap:8px;align-items:center;margin-top:12px}#petForegroundSettings input[type=range]{min-width:0;flex:1;accent-color:#9eb3ad}#petForegroundSettings output{min-width:42px;text-align:right}#petForegroundSettings p{font-size:11px;line-height:1.6}#petForegroundSettings [hidden]{display:none!important}";
  document.head.append(style);
  const box = document.createElement("section");
  box.id = "petForegroundSettings";
  box.innerHTML = '<h4>前景遮挡</h4><div class="fg-actions"><button type="button" id="fgImport">导入遮挡图片</button><button type="button" id="fgRemove" hidden>移除</button></div><input type="file" id="fgFile" accept="image/png,image/jpeg,image/webp,image/gif,image/avif" hidden><div id="fgOptions" hidden><label><input type="checkbox" id="fgEnabled">显示在人物前面</label><label>大小<input type="range" id="fgScale" min="10" max="400" value="100"><output id="fgScaleValue">100%</output></label><label>左右<input type="range" id="fgX" min="-100" max="100" value="0"><output id="fgXValue">0%</output></label><label>上下<input type="range" id="fgY" min="-100" max="100" value="0"><output id="fgYValue">0%</output></label></div><p id="fgStatus" role="status">支持透明图片；空白处可以露出人物。仅在当前房间显示。</p>';
  dialog.insertBefore(box, $("petBackgroundStatus"));
  const initial = () => ({ image: "", enabled: false, scale: 100, x: 0, y: 0 }), clamp = (v, a, b, d) => Number.isFinite(Number(v)) ? Math.max(a, Math.min(b, Number(v))) : d;
  function normalize(v) {
    return { image: typeof (v == null ? void 0 : v.image) === "string" && /^data:image\/(png|jpeg|webp);base64,/.test(v.image) ? v.image : "", enabled: !!(v == null ? void 0 : v.enabled), scale: clamp(v == null ? void 0 : v.scale, 10, 400, 100), x: clamp(v == null ? void 0 : v.x, -100, 100, 0), y: clamp(v == null ? void 0 : v.y, -100, 100, 0) };
  }
  let value = initial();
  try {
    value = normalize(JSON.parse(localStorage.getItem(key)));
  } catch (e) {
  }
  function sync() {
    const host = window.CottonPetHost.getStatus();
    layer.style.display = host.active && !host.floating && value.enabled && value.image ? "block" : "none";
    if (image.getAttribute("src") !== value.image) {
      if (value.image) image.src = value.image;
      else image.removeAttribute("src");
    }
    image.style.transform = "translate(calc(-50% + ".concat(value.x, "vw),calc(-50% + ").concat(value.y, "vh)) scale(").concat(value.scale / 100, ")");
    $("fgOptions").hidden = $("fgRemove").hidden = !value.image;
    $("fgEnabled").checked = value.enabled;
    for (const [id, k] of [["fgScale", "scale"], ["fgX", "x"], ["fgY", "y"]]) {
      $(id).value = value[k];
      $(id + "Value").textContent = value[k] + "%";
    }
  }
  function save() {
    sync();
    try {
      localStorage.setItem(key, JSON.stringify(value));
      $("fgStatus").textContent = "已保存前景；人物操作不受遮挡图片影响。";
    } catch (e) {
      $("fgStatus").textContent = "本次已应用，浏览器空间不足，无法记住这张图片。";
    }
  }
  let importing = false;
  async function importImage(file) {
    if (importing) throw new Error("图片正在读取，请稍候");
    if (!file || !/^image\/(png|jpeg|webp|gif|avif)$/.test(file.type)) throw new Error("请选择图片文件");
    if (file.size > 20 * 1024 * 1024) throw new Error("请选择小于20MB的图片");
    importing = true;
    const url = URL.createObjectURL(file);
    try {
      const source = new Image();
      source.src = url;
      await source.decode();
      const ratio = Math.min(1, 1600 / Math.max(source.naturalWidth, source.naturalHeight)), canvas = document.createElement("canvas");
      canvas.width = Math.max(1, Math.round(source.naturalWidth * ratio));
      canvas.height = Math.max(1, Math.round(source.naturalHeight * ratio));
      canvas.getContext("2d").drawImage(source, 0, 0, canvas.width, canvas.height);
      value = __spreadProps(__spreadValues({}, initial()), { image: canvas.toDataURL("image/webp", 0.92), enabled: true });
      save();
      return { width: canvas.width, height: canvas.height };
    } finally {
      importing = false;
      URL.revokeObjectURL(url);
    }
  }
  $("fgImport").onclick = () => $("fgFile").click();
  $("fgFile").onchange = async function() {
    try {
      if (this.files[0]) await importImage(this.files[0]);
    } catch (e) {
      $("fgStatus").textContent = e.message || "图片无法读取";
    } finally {
      this.value = "";
    }
  };
  $("fgRemove").onclick = () => {
    value = initial();
    save();
  };
  $("fgEnabled").onchange = function() {
    value.enabled = this.checked;
    save();
  };
  for (const [id, k] of [["fgScale", "scale"], ["fgX", "x"], ["fgY", "y"]]) $(id).oninput = function() {
    value[k] = Number(this.value);
    save();
  };
  window.addEventListener("cotton-pet-state-change", sync);
  for (const id of ["petFloat", "petExpand"]) $(id).addEventListener("click", sync);
  sync();
  if (window.COTTON_QA) window.CottonForegroundQA = { importImage, get: () => structuredClone(value), restore: (v) => {
    value = normalize(v);
    save();
  } };
})();
(function() {
  "use strict";
  const $ = (id) => document.getElementById(id), frame = $("cottonFrame"), host = window.CottonPetHost, MAX = 6;
  let pets = [], selected = null, serial = 0, last = 0, lastPaint = 0, choosing = false;
  const style = document.createElement("style");
  style.textContent = "body.multiple-pets #petActor,body.multiple-pets #puppetFrameDock.pet-dock{display:none!important}.multi-pet{position:fixed;z-index:1102;touch-action:none;cursor:grab}.multi-pet canvas{display:block;width:100%;height:100%;pointer-events:none}.multi-pet.dragging{cursor:grabbing}.multi-pet-tools{position:absolute;left:50%;top:0;transform:translateX(-50%);display:flex;gap:5px;align-items:center;white-space:nowrap;background:#faf8f0e8;padding:4px 7px;border:1px solid #d8e3d5;border-radius:12px;font-size:11px;color:#758a7d}.multi-pet:not(.selected) .multi-pet-tools{display:none}.multi-pet-tools button{border:0;border-radius:50%;width:25px;height:25px;background:#e7eddf;color:#778a76;cursor:pointer}.multi-pet.selected:after{content:'';position:absolute;bottom:0;left:25%;width:50%;height:4px;border-radius:100%;background:#a4b5a050;pointer-events:none}#petAdd{background:#e5eddf;color:#758b71}#petChoice{width:440px;max-width:calc(100vw - 24px);width:min(440px,calc(100vw - 24px));max-height:calc(100vh - 30px);max-height:calc(100dvh - 30px);overflow:auto;box-sizing:border-box;padding:18px;border:1px solid #dce3d4;border-radius:22px;background:#faf9f1;color:#748672;font:13px sans-serif}#petChoice::backdrop{background:#52615166}#petChoice header{display:flex;justify-content:space-between;align-items:center}#petChoice h3{font:21px YuzuPop,sans-serif;margin:0}#petChoice button{font:inherit;color:inherit;border:1px solid #dce3d4;border-radius:13px;background:#edf1e7;padding:9px;cursor:pointer}#petChoiceGrid{display:grid;grid-template-columns:1fr 1fr;gap:10px;margin-top:14px}#petChoiceGrid button{display:flex;flex-direction:column;align-items:center;gap:5px}#petChoiceGrid canvas{width:100%;height:140px;object-fit:contain}#petChoiceGrid strong{font-size:14px}#petChoice p{line-height:1.7}#petPickLabel{grid-column:1/-1;display:flex;align-items:center;gap:10px;font-size:12px;color:#7c9285;padding:3px}#petPick{min-width:0;flex:1;border:1px solid #d9e2d3;border-radius:10px;background:#fffdf5;padding:8px;color:inherit;font:inherit}#petSideRail{position:fixed;right:12px;right:max(12px,env(safe-area-inset-right));top:42%;z-index:1110;display:flex;align-items:center;justify-content:center}#petSideRail[hidden]{display:none!important}#petSideRail #petAdd{width:42px;height:42px;min-height:42px;padding:0;border:1px solid #d8e2d2;border-radius:14px;background:#f6f8efed;color:#82967c;font:26px sans-serif;cursor:pointer;box-shadow:0 2px 8px #65755c0c}#petSideRail #petAdd:disabled{opacity:.45;cursor:default}#petSideRail.inline{position:static;flex:none;margin-left:4px}#petSideRail.inline #petAdd{width:38px;height:38px;min-height:38px;border-radius:11px;font-size:24px}#petPickLabel #petPick{flex:1;width:0}#petPickLabel{gap:8px}";
  document.head.append(style);
  const layer = document.createElement("div");
  layer.id = "multiplePetLayer";
  document.body.append(layer);
  const add = document.createElement("button");
  add.id = "petAdd";
  add.type = "button";
  add.textContent = "＋";
  add.setAttribute("aria-label", "添加桌宠");
  add.title = "添加桌宠";
  const rail = document.createElement("aside");
  rail.id = "petSideRail";
  rail.setAttribute("aria-label", "桌宠侧栏");
  rail.append(add);
  document.body.append(rail);
  const pickLabel = document.createElement("div");
  pickLabel.id = "petPickLabel";
  pickLabel.innerHTML = '当前桌宠<select id="petPick" aria-label="选择当前桌宠"></select>';
  $("petControlsPanel").insertBefore(pickLabel, $("petSizeControl"));
  const floatAdd = add;
  const dialog = document.createElement("dialog");
  dialog.id = "petChoice";
  dialog.setAttribute("aria-label", "选择桌宠套装");
  dialog.innerHTML = '<header><h3>选择桌宠套装</h3><button type="button" id="petChoiceClose" aria-label="关闭套装选择">×</button></header><p id="petChoiceHint">选择一套搭配，添加一个桌宠。每只都能单独拖动、摸摸和调整大小。</p><div id="petChoiceGrid"></div><button type="button" id="petRemoveSelected" style="margin-top:14px">移除当前桌宠</button>';
  document.body.append(dialog);
  const bound = (v, a, b) => Math.max(a, Math.min(b, v)), seconds = () => performance.now() / 1e3, active = () => host.getStatus().active && host.getStatus().mode === "pet";
  function size(p) {
    var _a;
    if (host.getStatus().nativeOverlay) return ((_a = window.CottonNativePetFrames) == null ? void 0 : _a.size(p.id)) || { w: innerWidth * 0.94, h: innerHeight * 0.94 };
    return { w: Math.min(225, innerWidth * 0.54) * p.scale, h: Math.min(280, innerHeight * 0.38) * p.scale };
  }
  function ground(p) {
    return Math.min(innerHeight - 175, 90 + (innerHeight - 230) * 0.77) - size(p).h * 0.94;
  }
  function place(p) {
    const s = size(p);
    const native = host.getStatus().nativeOverlay, placement = [native, p.x, p.y, s.w, s.h, devicePixelRatio].join(":");
    if (p.placement === placement) return;
    p.placement = placement;
    Object.assign(p.node.style, { left: (native ? (innerWidth - s.w) / 2 : p.x) + "px", top: (native ? (innerHeight - s.h) / 2 : p.y) + "px", width: s.w + "px", height: s.h + "px" });
    const ratio = Math.min(960 / Math.max(1, s.w), 1280 / Math.max(1, s.h), Math.max(Math.min(3, devicePixelRatio || 1), 384 / Math.max(1, s.w), 480 / Math.max(1, s.h))), w = native ? 384 : Math.round(s.w * ratio), h = native ? 498 : Math.round(s.h * ratio);
    if (p.canvas.width !== w || p.canvas.height !== h) {
      p.canvas.width = w;
      p.canvas.height = h;
    }
  }
  function select(p) {
    selected = p;
    for (const item of pets) item.node.classList.toggle("selected", item === p);
    $("petPick").value = String(p.id);
    $("petSize").value = Math.round(p.scale * 100);
    $("petSizeValue").textContent = Math.round(p.scale * 100) + "%";
    $("petSit").textContent = p.action === "sit" ? "站起来" : "坐一会儿";
    document.dispatchEvent(new Event("cotton-pet-selection"));
  }
  function placeAdd() {
    const inline = active() && !host.getStatus().floating && !document.querySelector(".pet-toolbox").classList.contains("collapsed");
    if (inline) pickLabel.append(rail);
    else document.body.append(rail);
    rail.classList.toggle("inline", inline);
  }
  function refresh() {
    pickLabel.hidden = add.hidden = floatAdd.hidden = !active();
    $("petPick").replaceChildren(...pets.map((p) => {
      const o = document.createElement("option");
      o.value = p.id;
      o.textContent = p.name;
      return o;
    }));
    add.disabled = floatAdd.disabled = false;
    add.title = pets.length >= MAX ? "管理桌宠（最多6只）" : "添加桌宠";
    add.setAttribute("aria-label", pets.length >= MAX ? "管理桌宠（最多6只）" : "添加桌宠");
    rail.hidden = !active();
    if (selected) select(selected);
    placeAdd();
    document.dispatchEvent(new Event("cotton-pet-list"));
  }
  function clear() {
    var _a;
    for (const p of pets) {
      p.node.remove();
      (_a = window.CottonMusic) == null ? void 0 : _a.releasePetVoice(p.profileKey);
    }
    pets = [];
    selected = null;
    document.body.classList.remove("multiple-pets");
    refresh();
  }
  function remove(p) {
    var _a;
    (_a = window.CottonMusic) == null ? void 0 : _a.releasePetVoice(p.profileKey);
    p.node.remove();
    pets = pets.filter((item) => item !== p);
    if (!pets.length) {
      host.close();
      clear();
      return;
    }
    if (selected === p) selected = pets.at(-1);
    refresh();
  }
  function react(p, action, duration) {
    p.action = action;
    p.changed = seconds();
    p.until = p.changed + duration;
    if (p === selected) $("petSit").textContent = action === "sit" ? "站起来" : "坐一会儿";
  }
  function spawn(value, name, profileRef) {
    if (pets.length >= MAX) return false;
    if (!active()) host.open("pet");
    const p = { id: ++serial, value: structuredClone(value), name, scale: host.getStatus().petScale || 1, x: 0, y: 0, action: "idle", changed: seconds(), until: 0, next: seconds() + 4 + Math.random() * 3, dest: 0, drag: null, gaze: { x: 0, y: 0 }, node: document.createElement("div"), canvas: document.createElement("canvas") };
    p.profileKey = petProfileKey(value, name, profileRef);
    p.voice = petProfiles.voice(p.profileKey);
    p.node.className = "multi-pet";
    p.node.setAttribute("aria-label", name + "桌宠，可以拖动和摸摸");
    p.node.append(p.canvas);
    layer.append(p.node);
    const s = size(p);
    p.x = bound((innerWidth - s.w) / 2 + [-1, 1, 0][pets.length % 3] * Math.min(s.w * 0.65, innerWidth * 0.24), 0, Math.max(0, innerWidth - s.w));
    p.y = ground(p);
    pets.push(p);
    document.body.classList.add("multiple-pets");
    p.node.onpointerdown = (e) => {
      if (e.button !== 0 || e.target.closest("button")) return;
      select(p);
      p.node.setPointerCapture(e.pointerId);
      p.drag = { id: e.pointerId, x: e.clientX, y: e.clientY, left: p.x, top: p.y, moved: false, start: performance.now() };
    };
    p.node.onpointermove = (e) => {
      if (!p.drag || p.drag.id !== e.pointerId) return;
      const dx = e.clientX - p.drag.x, dy = e.clientY - p.drag.y;
      if (performance.now() - p.drag.start >= 100 && Math.hypot(dx, dy) > 3) p.drag.moved = true;
      if (p.drag.moved) {
        p.x = p.drag.left + dx;
        p.y = p.drag.top + dy;
        if (p.action !== "lift") react(p, "lift", 3600);
        p.node.classList.add("dragging");
        place(p);
      }
    };
    const release = (e) => {
      var _a;
      if (!p.drag || p.drag.id !== e.pointerId) return;
      const moved = p.drag.moved;
      p.drag = null;
      p.node.classList.remove("dragging");
      const tapped = !moved && e.type === "pointerup";
      if (tapped && p.action === "sit") {
        p.tapAt = seconds();
        p.until = Math.max(p.until, p.tapAt + 0.7);
      } else react(p, tapped ? "pet" : "idle", tapped ? 0.55 : 0.3);
      if (tapped) (_a = window.CottonMusic) == null ? void 0 : _a.petVoice(p.voice, p.profileKey);
      p.next = seconds() + 5;
      if (moved) {
        p.pinned = true;
        p.settle = 0;
      }
    };
    p.node.onpointerup = p.node.onpointercancel = release;
    p.node.onlostpointercapture = (e) => {
      if (p.drag) release(e);
    };
    place(p);
    selected = p;
    refresh();
    return p.id;
  }
  function choose() {
    const child = frame.contentWindow;
    if (!(child == null ? void 0 : child.CottonClosetSlots) || !(child == null ? void 0 : child.CottonPetPainter)) return;
    choosing = true;
    $("petChoiceGrid").replaceChildren();
    $("petRemoveSelected").hidden = !selected;
    for (const [index, look] of child.CottonClosetSlots.getStatus().slots.entries()) {
      const b = document.createElement("button"), canvas = document.createElement("canvas"), name = document.createElement("strong");
      b.type = "button";
      b.disabled = pets.length >= MAX;
      b.setAttribute("aria-label", "添加" + look.name + "桌宠");
      canvas.width = 230;
      canvas.height = 260;
      child.CottonPetPainter.paint(canvas, look, { action: "idle", x: 0, y: 0, age: 0 }, seconds());
      name.textContent = look.name;
      b.append(canvas, name);
      b.onclick = () => {
        var _a;
        dialog.close();
        choosing = false;
        spawn(look, look.name, "slot_" + (((_a = look.slotId) == null ? void 0 : _a.startsWith("default-")) ? look.slotId.slice(8) : look.slotId || index));
      };
      $("petChoiceGrid").append(b);
    }
    $("petChoiceHint").textContent = "从换装保存的套装中选择（" + pets.length + " / " + MAX + "只）。每只保留独立搭配和大小。";
    dialog.showModal();
  }
  $("bPet").onclick = () => {
    var _a, _b;
    if (active() && pets.length) {
      if (host.getStatus().floating) $("petExpand").click();
      return;
    }
    const value = (_b = (_a = frame.contentWindow) == null ? void 0 : _a.CottonWardrobe) == null ? void 0 : _b.getOutfit();
    if (value) spawn(value, "当前搭配", "current");
  };
  add.onclick = floatAdd.onclick = choose;
  $("petRemoveSelected").onclick = () => {
    const p = selected;
    dialog.close();
    if (p) remove(p);
  };
  $("petChoiceClose").onclick = () => dialog.close();
  dialog.addEventListener("close", () => choosing = false);
  $("petPick").onchange = function() {
    const p = pets.find((p2) => String(p2.id) === this.value);
    if (p) select(p);
  };
  window.addEventListener("keydown", (e) => {
    if (e.key === "Escape" && dialog.open) {
      e.preventDefault();
      e.stopImmediatePropagation();
      dialog.close();
    }
  }, true);
  const oldSit = $("petSit").onclick, oldSize = $("petSize").oninput;
  $("petSit").onclick = () => {
    if (!pets.length) return oldSit();
    react(selected, selected.action === "sit" ? "idle" : "sit", 7);
    selected.next = seconds() + 8;
  };
  $("petSize").oninput = function() {
    oldSize.call(this);
    if (!selected || !pets.length) return;
    const old = size(selected);
    selected.scale = Number(this.value) / 100;
    const s = size(selected);
    selected.x += (old.w - s.w) / 2;
    selected.y += (old.h - s.h) * 0.15;
    place(selected);
  };
  function followTouchPets(e) {
    if (!active()) return;
    for (const p of pets) {
      const r = p.node.getBoundingClientRect();
      p.gaze = { x: bound((e.clientX - r.left - r.width * 0.5) / Math.max(80, r.width), -1, 1), y: bound((e.clientY - r.top - r.height * 0.35) / Math.max(90, r.height), -1, 1) };
    }
  }
  document.addEventListener("pointermove", followTouchPets, { passive: true });
  document.addEventListener("touchmove", (e) => {
    if (e.touches[0]) followTouchPets(e.touches[0]);
  }, { passive: true });
  $("petControlsToggle").addEventListener("click", refresh);
  window.addEventListener("cotton-pet-state-change", () => {
    if (!active()) clear();
    refresh();
  });
  for (const id of ["petFloat", "petExpand"]) $(id).addEventListener("click", () => {
    for (const p of pets) place(p);
    refresh();
  });
  let previousViewport = { w: innerWidth, h: innerHeight };
  window.addEventListener("resize", () => {
    for (const p of pets) place(p);
    previousViewport = { w: innerWidth, h: innerHeight };
  });
  function tick(ms, background) {
    var _a, _b, _c, _d;
    const now = ms / 1e3, dt = Math.min(0.05, now - last || 0);
    last = now;
    if (active() && pets.length && (!document.hidden || host.getStatus().nativeOverlay)) {
      const child = frame.contentWindow, music = !!((_a = child.CottonPetRender) == null ? void 0 : _a.getStatus().music), floating = host.getStatus().floating;
      for (const p of pets) {
        if (p.until && now > p.until && !p.drag) {
          p.action = host.getStatus().nativeOverlay && p.nativeWalking ? "walk" : "idle";
          p.until = p.action === "walk" ? Infinity : 0;
        }
        if (!p.drag && !floating && p.settle > now) p.y += (ground(p) - p.y) * (1 - Math.exp(-dt * 12));
        if (!p.drag && !p.pinned && !host.getStatus().nativeOverlay && !choosing && !music && p.action === "idle" && now > p.next) {
          p.next = now + 4.5 + Math.random() * 5;
          if (Math.random() < 0.35) react(p, "sit", 3.5 + Math.random() * 3);
          else {
            p.dest = Math.random() * Math.max(0, innerWidth - size(p).w);
            react(p, "walk", 7);
          }
        }
        if (p.action === "walk" && !p.drag && !host.getStatus().nativeOverlay) {
          if (music) p.action = "idle";
          else {
            const d = p.dest - p.x;
            p.x += Math.sign(d) * Math.min(Math.abs(d), dt * 24);
            if (Math.abs(d) < 1) p.action = "idle";
          }
        }
        place(p);
        if (ms - lastPaint > 32) (_c = child.CottonPetPainter) == null ? void 0 : _c.paint(p.canvas, p.value, __spreadProps(__spreadValues({ active: true, mode: "pet", action: ((_b = p.nativeLift || host.getStatus().nativeLift) == null ? void 0 : _b.dragging) ? "lift" : p.action, age: now - p.changed, petAge: p.action === "sit" && Number.isFinite(p.tapAt) ? now - p.tapAt : null, lift: host.getStatus().nativeOverlay && (p.nativeLift || host.getStatus().nativeLift) ? __spreadProps(__spreadValues({}, p.nativeLift || host.getStatus().nativeLift), { size: 230 * p.scale }) : { x: p.x, y: p.y, size: size(p).w, dragging: !!p.drag && p.drag.moved } }, p.gaze), { roll: 0, pitch: 0, music, relation: p.reaction ? { kind: p.reaction.kind, age: now - (p.reaction.until - 1.8), duration: 1.8 } : null }), now);
        if (host.getStatus().nativeOverlay && ((_d = window.CottonNativePetFrames || window.YuzuAndroid) == null ? void 0 : _d.petFrame) && ms - (p.lastNativeFrame || 0) > (window.CottonNativePetFrames ? 33 : 100)) {
          p.lastNativeFrame = ms;
          p.nativeCanvas = p.nativeCanvas || document.createElement("canvas");
          const c = p.nativeCanvas;
          c.width = 384;
          c.height = 498;
          const g = c.getContext("2d");
          g.clearRect(0, 0, c.width, c.height);
          g.drawImage(p.canvas, 0, 0, c.width, c.height);
          (window.CottonNativePetFrames || window.YuzuAndroid).petFrame(p.id, c.toDataURL("image/png").split(",")[1], p.scale);
        } else if (!host.getStatus().nativeOverlay) p.nativeLift = null;
      }
      if (floating) host.placeFloatingMenu();
      socialTick(now);
      if (ms - lastPaint > 32) lastPaint = ms;
    }
    if (!background) requestAnimationFrame(tick);
  }
  requestAnimationFrame(tick);
  refresh();
  window.addEventListener("cotton-pet-center", () => {
    if (selected) {
      selected.drag = null;
      selected.action = "idle";
      selected.pinned = false;
      selected.next = seconds() + 5;
      selected.x = (innerWidth - size(selected).w) / 2;
      selected.y = (innerHeight - size(selected).h) / 2;
      place(selected);
    }
  });
  window.addEventListener("cotton-pet-reset", () => {
    for (const p of pets) {
      p.scale = 1;
      p.pinned = false;
      p.drag = null;
      p.node.classList.remove("dragging");
      p.action = "idle";
      p.until = 0;
      p.next = seconds() + 5;
      p.x = (innerWidth - size(p).w) / 2;
      p.y = ground(p);
      place(p);
    }
    refresh();
  });
  window.CottonMultiplePets = { getLayout: () => pets.map((p) => ({ id: p.id, scale: p.scale })), nativePosition(id, x, y) {
    const p = pets.find((p2) => p2.id === id);
    if (p) {
      p.x = Number(x) || 0;
      p.y = Number(y) || 0;
    }
  }, nativeGaze(id, x, y) {
    const p = pets.find((p2) => p2.id === id);
    if (p) p.gaze = { x: bound(Number(x) || 0, -1, 1), y: bound(Number(y) || 0, -1, 1) };
  }, backgroundTick() {
    if (host.getStatus().nativeOverlay && performance.now() - lastPaint > 85) tick(performance.now(), true);
  }, nativeWalk(id, walking) {
    var _a;
    const p = pets.find((v) => v.id === id);
    if (!p) return;
    p.nativeWalking = !!walking;
    if (!((_a = p.nativeLift) == null ? void 0 : _a.dragging)) {
      if (p.action !== (walking ? "walk" : "idle")) react(p, walking ? "walk" : "idle", walking ? Infinity : 0.1);
      else if (walking) p.until = Infinity;
    }
  }, nativeInput(id, x, y, dragging, tap) {
    var _a;
    const p = pets.find((p2) => p2.id === id);
    if (!p) return;
    select(p);
    p.nativeLift = { x, y, dragging: !!dragging };
    if (dragging) react(p, "lift", 3600);
    else if (tap) {
      if (p.action === "sit") {
        p.tapAt = seconds();
        p.until = Math.max(p.until, p.tapAt + 0.7);
      } else react(p, "pet", 0.55);
      (_a = window.CottonMusic) == null ? void 0 : _a.petVoice(p.voice, p.profileKey);
    } else react(p, "idle", 0.2);
  }, removeNative(id) {
    const p = pets.find((p2) => p2.id === id);
    if (p) remove(p);
  }, getStatus: () => ({ count: pets.length, selected: selected == null ? void 0 : selected.id, choosing, pets: pets.map((p) => ({ id: p.id, name: p.name, scale: p.scale, action: p.action, x: p.x, y: p.y, profileKey: p.profileKey, voice: p.voice ? __spreadValues({}, p.voice) : null, reaction: p.reaction ? __spreadValues({}, p.reaction) : null, outfit: structuredClone(p.value) })) }) };
  if (window.COTTON_QA) window.CottonMultiplePetsQA = { spawn, remove: (id) => {
    const p = pets.find((p2) => p2.id === id);
    if (p) remove(p);
  }, react: (id, kind) => {
    const p = pets.find((p2) => p2.id === id);
    if (p) react(p, kind, 5);
  }, select: (id) => {
    const p = pets.find((p2) => p2.id === id);
    if (p) select(p);
  }, position: (id, x, y) => {
    const p = pets.find((p2) => p2.id === id);
    if (p) {
      p.x = x;
      p.y = y;
      p.next = seconds() + 60;
      p.action = "idle";
      place(p);
    }
  }, clear };
  const petProfiles = (() => {
    const key = "yuzu-pet-profiles-v1";
    let data = { voices: {}, relations: {} };
    try {
      const d = JSON.parse(localStorage.getItem(key));
      if (d && typeof d === "object") {
        for (const k of ["voices", "relations"]) if (d[k] && typeof d[k] === "object" && !Array.isArray(d[k])) data[k] = d[k];
      }
    } catch (e) {
    }
    const own = (obj, k) => Object.hasOwn(obj, k) ? obj[k] : null, save = () => {
      try {
        localStorage.setItem(key, JSON.stringify(data));
      } catch (e) {
      }
    };
    return { voice: (id) => own(data.voices, id) ? CottonSynth.normalizeVoice(data.voices[id]) : null, setVoice: (id, v) => {
      if (v) data.voices[id] = CottonSynth.normalizeVoice(v);
      else delete data.voices[id];
      save();
    }, relation: (a, b) => {
      const v = own(data.relations, JSON.stringify([a, b])), kind = typeof v === "string" ? v : v == null ? void 0 : v.kind;
      return ["like", "sweat", "angry"].includes(kind) ? kind : "none";
    }, text: (a, b) => {
      const v = own(data.relations, JSON.stringify([a, b]));
      return typeof (v == null ? void 0 : v.text) === "string" ? v.text.slice(0, 60) : "";
    }, setRelation: (a, b, v, text = "") => {
      const k = JSON.stringify([a, b]);
      if (["like", "sweat", "angry"].includes(v)) data.relations[k] = { kind: v, text: String(text).slice(0, 60) };
      else delete data.relations[k];
      save();
    } };
  })();
  function petProfileKey(value, name, ref) {
    if (!ref) {
      let h = 2166136261;
      for (const c of JSON.stringify([name, value])) h = Math.imul(h ^ c.charCodeAt(0), 16777619);
      ref = "look_" + (h >>> 0).toString(36);
    }
    let n = 1;
    while (pets.some((p) => p.profileKey === ref + ":" + n)) n++;
    return ref + ":" + n;
  }
  const petIcons = { sweat: '<path d="M13 3c0 5-7 7-7 13a6 6 0 0 0 12 0c0-5-2-9-5-13Z"/>', voice: '<path d="M4 9v6h4l5 4V5L8 9H4zm12-1c3 2 3 6 0 8m3-11c5 4 5 10 0 14"/>', network: '<circle cx="6" cy="6" r="3"/><circle cx="18" cy="8" r="3"/><circle cx="11" cy="19" r="3"/><path d="m9 7 6 1M7 9l3 7m6-5-4 5"/>', none: '<circle cx="12" cy="12" r="9"/><path d="m6 18 12-12"/>', like: '<path d="M12 20S2 14 3 8c1-5 7-5 9-1 2-4 8-4 9 1 1 6-9 12-9 12Z"/>', angry: '<path d="M8 3v5H3m13-5v5h5M3 16h5v5m13-5h-5v5M6 6l3 3m9-3-3 3M6 18l3-3m9 3-3-3"/>', soft: '<path d="M4 15c3-11 13-11 16 0M7 15c2-6 8-6 10 0M10 19h4"/>', bright: '<circle cx="12" cy="12" r="4"/><path d="M12 2v3m0 14v3M2 12h3m14 0h3M5 5l2 2m10 10 2 2M5 19l2-2M17 7l2-2"/>', tiny: '<path d="m12 3 2.6 5.7L21 10l-4.5 4.4 1 6.3-5.5-3-5.5 3 1-6.3L3 10l6.4-1.3Z"/>' };
  const icon = (k) => '<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="1.7" stroke-linecap="round" stroke-linejoin="round" aria-hidden="true">' + petIcons[k] + "</svg>";
  const socialStyle = document.createElement("style");
  socialStyle.textContent = "\n#petPersonalityRail{position:fixed;left:20px;left:max(20px,env(safe-area-inset-left));top:max(76px,calc(env(safe-area-inset-top) + 58px));z-index:1112;display:flex;gap:9px}#petPersonalityRail[hidden]{display:none}.pet-social-panel button{width:42px;height:42px;padding:10px;display:grid;align-items:center;justify-items:center;place-items:center;border:1px solid #dce4d7;border-radius:14px;color:#82947e;background:#f9fbf3ed;cursor:pointer;box-shadow:0 3px 10px #65755c0c}.pet-social-panel button svg{width:100%;height:100%}#petPersonalityRail button:hover,.pet-social-panel button:hover{background:#e9f0df}.pet-social-panel{position:fixed;top:0;right:0;bottom:0;left:0;inset:0;margin:auto;width:340px;max-width:calc(100vw - 32px);width:min(340px,calc(100vw - 32px));box-sizing:border-box;max-height:calc(100vh - 40px);max-height:calc(100dvh - 40px);overflow:auto;border:1px solid #dce4d7;border-radius:23px;padding:20px;background:#fbfaf3;color:#748673;font:13px YuzuPop,sans-serif;box-shadow:0 16px 60px #46513f26}.pet-social-panel::backdrop{background:#4f5b4930}.pet-social-panel header{display:flex;align-items:center;justify-content:space-between;gap:12px;margin-bottom:14px}.pet-social-panel h3{font-size:19px;margin:0}.pet-social-panel .pet-close{width:29px;height:29px;padding:4px;box-shadow:none;font:22px sans-serif}.pet-icon-row{display:flex;gap:9px;margin:13px 0}.pet-icon-row button[aria-pressed=true]{background:#e5eddb;border-color:#96ae8e;color:#65825d;box-shadow:0 0 0 2px #dde8d3}.pet-social-panel label{display:flex;align-items:center;gap:10px;margin:12px 0}.pet-social-panel label span{width:42px;flex:none}.pet-social-panel input{flex:1;min-width:0;accent-color:#9caf89}.pet-social-panel output{width:36px;text-align:right;font:11px sans-serif}.pet-social-panel select{min-width:0;flex:1;padding:8px;border:1px solid #dce4d7;border-radius:11px;color:inherit;background:#fffdf6;font:inherit}.pet-social-panel details{margin-top:14px}.pet-social-panel summary{cursor:pointer;font-size:12px;color:#97a18e}.pet-relation-pop{position:absolute;top:3%;left:calc(50% - 17px);width:34px;height:34px;pointer-events:none;animation:petFeeling 1.8s ease-out forwards;filter:drop-shadow(0 2px 2px #fff9)}.pet-relation-pop svg{width:100%;height:100%;fill:#f1afc6;stroke:#d98fa8;stroke-width:1.7;stroke-linecap:round;stroke-linejoin:round}.pet-relation-pop.angry svg{fill:none;stroke:#d08b7c;stroke-width:2.7}@keyframes petFeeling{0%{opacity:0;transform:translateY(8px) scale(.6)}16%{opacity:1;transform:translateY(-8px) scale(1.12)}30%,75%{opacity:1;transform:translateY(-12px) scale(1)}100%{opacity:0;transform:translateY(-25px) scale(.94)}}\n@media(min-width:760px){.pet-social-panel{left:20px;right:auto;margin:auto 0;}}.pet-relation-row{display:flex;align-items:center;gap:8px;padding:12px 0;border-top:1px solid #e5e9dd}.pet-relation-row:first-child{border-top:0}.pet-relation-name{flex:1;min-width:0;overflow-wrap:anywhere;font-size:14px}.pet-relation-choices{display:flex;gap:5px}.pet-social-panel .pet-relation-choices button{width:49px;height:56px;padding:7px 5px;gap:3px;border-radius:12px;box-shadow:none;font:11px YuzuPop,sans-serif}.pet-relation-choices button svg{width:21px;height:21px}.pet-relation-choices button[aria-pressed=true]{background:#e5eddb;border-color:#96ae8e;color:#65825d}.pet-relation-choices button[data-kind=like][aria-pressed=true]{background:#f6e4eb;border-color:#ddb3c3;color:#be8da1}.pet-relation-choices button[data-kind=angry][aria-pressed=true]{background:#f5e6df;border-color:#d7b4a4;color:#bd8e78}.pet-relation-empty{color:#98a28f;margin:14px 0}.pet-social-panel h3{overflow-wrap:anywhere}@media(prefers-reduced-motion:reduce){.pet-relation-pop{animation-timing-function:linear}}";
  socialStyle.textContent += "\n#petRelationsPanel .pet-close{border:0;background:transparent;box-shadow:none;transform:translateY(-8px)}#petRelationsPanel .pet-close:hover{background:transparent}#petRelationsPanel header{margin-bottom:22px}\n#petRelationPair{display:flex;align-items:center;justify-content:center;gap:10px;padding:5px 0 16px}.pet-social-panel .pet-relation-avatar{width:94px;height:auto;padding:0;display:flex;flex-direction:column;gap:7px;flex:none;background:transparent;border:0;box-shadow:none;border-radius:0;font:12px YuzuPop,sans-serif;min-width:0}.pet-social-panel .pet-relation-avatar:hover{background:transparent}.pet-relation-avatar canvas{display:block;box-sizing:border-box;width:88px;height:88px;background:#fffdf8;border:0;border-radius:50%}.pet-relation-avatar span{display:block;width:100%;text-align:center;overflow:hidden;text-overflow:ellipsis;white-space:nowrap}.pet-relation-arrow{font:27px sans-serif;color:#98a58d;padding-bottom:24px}.pet-social-panel #petRelationSwap{width:32px;height:32px;flex:none;padding:4px;background:transparent;border:0;box-shadow:none;margin-bottom:24px;color:#93a18b}#petRelationPicker{display:flex;gap:10px;flex-wrap:wrap;justify-content:center;padding:12px 0;margin:0 0 12px;border-top:1px solid #e5e9dd;border-bottom:1px solid #e5e9dd}#petRelationPicker[hidden]{display:none}#petRelationPicker .pet-relation-avatar{width:70px}#petRelationPicker canvas{width:62px;height:62px}.pet-attitudes{display:flex;justify-content:center;gap:26px;margin:8px 0 21px}.pet-social-panel .pet-attitudes button{width:53px;height:53px;padding:10px;border:1px solid transparent;background:transparent;box-shadow:none;border-radius:16px;color:#cc95aa}.pet-attitudes button[data-kind=sweat]{color:#80b5c8}.pet-attitudes button[data-kind=angry]{color:#cc9287}.pet-attitudes button[aria-pressed=true]{border-color:currentColor;background:#f6e9ed}.pet-attitudes button[data-kind=sweat][aria-pressed=true]{background:#e8f2f5}.pet-attitudes button[data-kind=angry][aria-pressed=true]{background:#f5e9e4}#petRelationMore{margin-top:4px}#petRelationMore[hidden]{display:none}#petRelationMore summary{display:flex;align-items:center;justify-content:center;gap:5px;list-style:none;font-size:12px;padding:8px}#petRelationMore summary::-webkit-details-marker{display:none}#petRelationMore summary svg{width:17px;height:17px;stroke:currentColor;stroke-width:1.7;fill:none}#petRelationMore[open] summary svg{transform:rotate(180deg)}#petExistingRelations{max-height:230px;overflow:auto;padding-top:8px}.pet-social-panel .pet-existing-relation{width:100%;height:57px;padding:5px 16px;border:0;border-top:1px solid #e7ebdf;border-radius:0;background:transparent;box-shadow:none;display:flex;justify-content:center;gap:19px}.pet-existing-relation canvas{width:43px;height:43px;border:0;border-radius:50%;background:#fffdf8}.pet-existing-feeling{display:block;width:25px;height:25px;color:#cc95aa}.pet-existing-feeling.sweat{color:#80b5c8}.pet-existing-feeling.angry{color:#cc9287}#petExistingRelations .pet-relation-empty{text-align:center}.pet-relation-pop{top:-3%;left:calc(50% - 28px);width:56px;height:43px;box-sizing:border-box;padding:8px 15px;background:#fffaf7;border:2px solid #d9bdc8;border-radius:16px;filter:drop-shadow(0 2px 3px #8a7b7b16)}.pet-relation-pop:after{content:'';position:absolute;width:9px;height:9px;left:17px;bottom:-7px;transform:rotate(45deg);background:#fffaf7;border-bottom:2px solid #d9bdc8;border-right:2px solid #d9bdc8}.pet-relation-pop svg{position:relative;z-index:1;display:block;fill:none}.pet-relation-pop.sweat svg{fill:none;stroke:#80b5c8;stroke-width:2}.pet-relation-pop.like svg{fill:#f1c0d0}.pet-relation-pop.angry svg{stroke:#cf9286}@media(max-width:370px){#petRelationPair{gap:7px}.pet-social-panel .pet-relation-avatar{width:80px}.pet-relation-avatar canvas{width:75px;height:75px}.pet-attitudes{gap:20px}}\n";
  socialStyle.textContent += ".pet-social-panel #petRelationAdd{width:70px;height:70px;flex:none;border:0;border-radius:50%;background:#eff3e7;color:#91a18a;font:34px sans-serif;padding:0;margin-bottom:23px;box-shadow:none}";
  socialStyle.textContent += ".pet-attitudes{gap:14px}.pet-social-panel .pet-attitudes .pet-relation-save{width:38px;height:38px;padding:8px;align-self:center;margin-left:2px;background:#e5eddb;color:#78946d;border:1px solid #c6d6b9;border-radius:12px;box-shadow:none}.pet-attitudes .pet-relation-save:disabled{opacity:.4;cursor:default}";
  socialStyle.textContent += "#petRelationPicker{border:1px solid #d8dfd1;border-radius:13px;padding:14px 8px}.pet-relation-avatar.relation-editing{position:relative;padding-bottom:19px}.relation-editing i{position:absolute;bottom:-4px;left:0;right:0;font:22px sans-serif;font-style:normal;color:#9aaa8e}#petRelationMessage{box-sizing:border-box;width:100%;margin:-6px 0 16px;padding:10px 12px;border:1px solid #d9e2d1;border-radius:12px;background:#fffdf7;color:#788b70;font:13px YuzuPop,sans-serif}#petRelationMessage[hidden]{display:none}.pet-social-panel .pet-attitudes button[data-kind]{height:66px;padding:7px 10px}.pet-attitudes button[data-kind] svg{display:block;width:30px;height:30px;margin:auto}.pet-attitudes button[data-kind] span{display:block;font:11px YuzuPop,sans-serif;margin-top:4px}.pet-relation-pop.with-text{width:156px;height:auto;min-height:62px;left:calc(50% - 78px);padding:8px 12px;text-align:center}.pet-relation-pop.with-text svg{width:25px;height:25px;margin:0 auto 4px}.pet-relation-pop.with-text span{display:block;font:12px YuzuPop,sans-serif;line-height:1.45;color:#8c7c82;overflow-wrap:break-word;word-break:break-all}";
  document.head.append(socialStyle);
  const personalityRail = document.createElement("aside");
  personalityRail.id = "petPersonalityRail";
  personalityRail.setAttribute("aria-label", "角色声音与关系");
  for (const [k, label] of [["voice", "捏声音"], ["network", "关系网"]]) {
    const b = $("bVoiceOpen").cloneNode(true);
    b.id = k === "voice" ? "petVoiceOpen" : "petRelationsOpen";
    b.title = label;
    b.setAttribute("aria-label", label);
    if (k === "network") b.innerHTML = icon(k) + "关系网";
    personalityRail.append(b);
  }
  document.body.append(personalityRail);
  function socialDialog(id, title) {
    const d = document.createElement("dialog");
    d.id = id;
    d.className = "pet-social-panel";
    d.setAttribute("aria-label", title);
    d.innerHTML = '<header><h3></h3><button type="button" class="pet-close" aria-label="关闭">×</button></header>';
    d.querySelector("button").onclick = () => d.close();
    d.addEventListener("click", (e) => {
      if (e.target === d) {
        const r = d.getBoundingClientRect();
        if (e.clientX < r.left || e.clientX > r.right || e.clientY < r.top || e.clientY > r.bottom) d.close();
      }
    });
    document.body.append(d);
    return d;
  }
  const voicePanel = socialDialog("petVoicePanel", "角色声音"), relationPanel = socialDialog("petRelationsPanel", "角色关系");
  const presetVoices = { soft: { pitch: -3, size: 0.87, softness: 0.95, brightness: 0.26, breath: 0.36, vibrato: 0.3, glide: 0.82, echo: 0.16 }, bright: { pitch: 1, size: 1.04, softness: 0.3, brightness: 0.75, breath: 0.03, vibrato: 0.08, glide: 0.12, echo: 0.12 }, tiny: { pitch: 4, size: 1.38, softness: 0.8, brightness: 0.58, breath: 0.14, vibrato: 0.14, glide: 0.4, echo: 0.2 } };
  const voiceRow = document.createElement("div");
  voiceRow.className = "pet-icon-row";
  voicePanel.append(voiceRow);
  function assignVoice(value) {
    var _a;
    if (!selected) return;
    selected.voice = value ? CottonSynth.normalizeVoice(value) : null;
    petProfiles.setVoice(selected.profileKey, selected.voice);
    if (!value) (_a = window.CottonMusic) == null ? void 0 : _a.releasePetVoice(selected.profileKey);
    updateVoice();
  }
  function previewPetVoice() {
    var _a;
    if (selected) (_a = window.CottonMusic) == null ? void 0 : _a.petVoice(selected.voice, selected.profileKey);
  }
  for (const [k, label] of [["none", "沿用当前声音"], ["soft", "柔软"], ["bright", "清亮"], ["tiny", "小小"]]) {
    const b = document.createElement("button");
    b.type = "button";
    b.dataset.voice = k;
    b.title = label;
    b.setAttribute("aria-label", label);
    b.innerHTML = icon(k);
    b.onclick = () => {
      assignVoice(presetVoices[k] || null);
      previewPetVoice();
    };
    voiceRow.append(b);
  }
  const voiceSliders = [], extra = document.createElement("details");
  extra.innerHTML = "<summary>更多</summary>";
  for (const [i, [key, label, min, max, step, scale]] of [["pitch", "音高", -12, 12, 0.5, 1], ["size", "声线", 65, 160, 1, 100], ["softness", "柔软", 0, 100, 1, 100], ["brightness", "明亮", 0, 100, 1, 100], ["breath", "气声", 0, 100, 1, 100], ["vibrato", "颤音", 0, 100, 1, 100], ["glide", "滑音", 0, 100, 1, 100], ["echo", "回响", 0, 100, 1, 100]].entries()) {
    const row = document.createElement("label"), span = document.createElement("span"), input = document.createElement("input"), out = document.createElement("output");
    span.textContent = label;
    Object.assign(input, { type: "range", min, max, step, id: "petVoice_" + key });
    input.setAttribute("aria-label", label);
    row.append(span, input, out);
    (i < 3 ? voicePanel : extra).append(row);
    input.oninput = () => {
      const shape = (selected == null ? void 0 : selected.voice) || window.CottonMusic.getStatus().voice;
      assignVoice(__spreadProps(__spreadValues({}, shape), { [key]: Number(input.value) / scale }));
    };
    input.onchange = previewPetVoice;
    voiceSliders.push({ key, input, out, scale });
  }
  voicePanel.append(extra);
  function updateVoice() {
    if (!selected) return;
    voicePanel.querySelector("h3").textContent = selected.name;
    const shape = selected.voice || window.CottonMusic.getStatus().voice;
    for (const { key, input, out, scale } of voiceSliders) {
      input.value = shape[key] * scale;
      out.textContent = key === "pitch" ? shape[key].toFixed(1) : Math.round(shape[key] * scale);
    }
    for (const b of voiceRow.children) b.setAttribute("aria-pressed", b.dataset.voice === "none" ? String(!selected.voice) : String(!!selected.voice && JSON.stringify(selected.voice) === JSON.stringify(CottonSynth.normalizeVoice(presetVoices[b.dataset.voice]))));
  }
  const portraitCache = /* @__PURE__ */ new WeakMap();
  function portrait(p) {
    let saved = portraitCache.get(p);
    if (!saved) {
      const full = document.createElement("canvas");
      full.width = 360;
      full.height = 450;
      frame.contentWindow.CottonPetPainter.paint(full, p.value, { action: "idle", age: 0, x: 0, y: 0 }, 0);
      saved = document.createElement("canvas");
      saved.width = saved.height = 180;
      saved.getContext("2d").drawImage(full, 35, 0, 290, 290, 0, 0, 180, 180);
      portraitCache.set(p, saved);
    }
    const c = document.createElement("canvas");
    c.width = c.height = 180;
    c.getContext("2d").drawImage(saved, 0, 0);
    c.setAttribute("aria-hidden", "true");
    return c;
  }
  let relationTargetId = null, relationPickerSide = null, relationDraft = null;
  const relationPair = document.createElement("div");
  relationPair.id = "petRelationPair";
  const relationPicker = document.createElement("div");
  relationPicker.id = "petRelationPicker";
  relationPicker.hidden = true;
  const relationChoices = document.createElement("div");
  relationChoices.className = "pet-attitudes";
  const relationMessage = document.createElement("input");
  relationMessage.id = "petRelationMessage";
  relationMessage.type = "text";
  relationMessage.maxLength = 60;
  relationMessage.placeholder = "碰面时想说的话";
  relationMessage.setAttribute("aria-label", "关系自定义对话");
  const relationMore = document.createElement("details");
  relationMore.id = "petRelationMore";
  relationMore.innerHTML = '<summary aria-label="展开已有关系"><span>已有关系</span><svg viewBox="0 0 24 24" aria-hidden="true"><path d="m7 9 5 5 5-5"/></svg></summary><div id="petExistingRelations"></div>';
  relationPanel.append(relationPair, relationPicker, relationChoices, relationMessage, relationMore);
  const relationNames = { none: "无关系", like: "喜欢", sweat: "尴尬", angry: "生气" };
  function setRelationship(a, b, kind, text = "") {
    if (!a || !b || a === b) return;
    petProfiles.setRelation(a.profileKey, b.profileKey, kind, text);
    relationDraft = null;
    updateRelations();
  }
  function avatarButton(p, side) {
    const b = document.createElement("button");
    b.type = "button";
    b.className = "pet-relation-avatar";
    b.dataset.side = side;
    b.setAttribute("aria-label", (side === "from" ? "选择发起角色：" : "选择对方角色：") + p.name);
    b.title = p.name;
    b.append(portrait(p));
    const name = document.createElement("span");
    name.textContent = p.name;
    b.append(name);
    if (relationPickerSide === side) {
      b.classList.add("relation-editing");
      const marker = document.createElement("i");
      marker.textContent = "↓";
      marker.setAttribute("aria-hidden", "true");
      b.append(marker);
    }
    b.onclick = () => {
      relationPickerSide = relationPickerSide === side ? null : side;
      updateRelations();
    };
    return b;
  }
  let returnToRelations = null;
  function relationAddButton() {
    const b = add.cloneNode(true);
    b.id = "petRelationAdd";
    b.hidden = false;
    b.disabled = false;
    b.setAttribute("aria-label", "添加桌宠");
    b.title = "添加桌宠";
    b.onclick = () => {
      returnToRelations = { source: selected == null ? void 0 : selected.id, ids: pets.map((p) => p.id) };
      relationPanel.close();
      choose();
    };
    return b;
  }
  dialog.addEventListener("close", () => {
    if (!returnToRelations) return;
    const back = returnToRelations;
    returnToRelations = null;
    queueMicrotask(() => {
      if (!active() || !pets.length) return;
      const source = pets.find((p) => p.id === back.source);
      if (source) select(source);
      const added = pets.find((p) => !back.ids.includes(p.id));
      if (added && added !== selected) relationTargetId = added.id;
      relationPickerSide = null;
      updateRelations();
      if (!relationPanel.open) relationPanel.showModal();
    });
  });
  function updateRelations() {
    if (!selected) return;
    relationPanel.querySelector("h3").textContent = "关系网";
    const target = pets.find((p) => p.id === relationTargetId && p !== selected) || pets.find((p) => p !== selected);
    relationTargetId = (target == null ? void 0 : target.id) || null;
    relationPair.replaceChildren();
    relationChoices.replaceChildren();
    relationPicker.replaceChildren();
    relationPicker.hidden = true;
    relationMessage.hidden = true;
    if (!target) {
      relationPair.append(avatarButton(selected, "from"));
      const arrow2 = document.createElement("span");
      arrow2.className = "pet-relation-arrow";
      arrow2.textContent = "→";
      relationPair.append(arrow2, relationAddButton());
      relationMore.hidden = true;
      return;
    }
    const arrow = document.createElement("span");
    arrow.className = "pet-relation-arrow";
    arrow.textContent = "→";
    arrow.setAttribute("aria-label", "对");
    const swap = document.createElement("button");
    swap.id = "petRelationSwap";
    swap.type = "button";
    swap.setAttribute("aria-label", "切换反向关系");
    swap.title = "切换方向";
    swap.innerHTML = '<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="1.8" stroke-linecap="round" stroke-linejoin="round"><path d="M4 8h15l-4-4M20 16H5l4 4"/></svg>';
    swap.onclick = () => {
      relationPickerSide = null;
      relationTargetId = selected.id;
      select(target);
    };
    relationPair.append(avatarButton(selected, "from"), arrow, avatarButton(target, "to"), swap);
    if (relationPickerSide) {
      relationPicker.hidden = false;
      for (const p of pets.filter((p2) => relationPickerSide === "from" ? p2 !== target : p2 !== selected)) {
        const b = avatarButton(p, "pick");
        b.title = p.name;
        b.setAttribute("aria-label", "选择" + p.name);
        b.onclick = () => {
          const side = relationPickerSide;
          relationPickerSide = null;
          if (side === "from") {
            select(p);
          } else {
            relationTargetId = p.id;
            updateRelations();
          }
        };
        relationPicker.append(b);
      }
      if (relationPickerSide === "to") relationPicker.append(relationAddButton());
    }
    const current = petProfiles.relation(selected.profileKey, target.profileKey), draftKey = selected.id + ":" + target.id;
    if ((relationDraft == null ? void 0 : relationDraft.key) !== draftKey) relationDraft = { key: draftKey, kind: current, text: petProfiles.text(selected.profileKey, target.profileKey) };
    for (const kind of ["like", "sweat", "angry"]) {
      const b = document.createElement("button");
      b.type = "button";
      b.dataset.kind = kind;
      b.title = relationNames[kind];
      b.setAttribute("aria-label", relationNames[kind]);
      b.setAttribute("aria-pressed", String(relationDraft.kind === kind));
      b.innerHTML = icon(kind);
      const caption = document.createElement("span");
      caption.textContent = relationNames[kind];
      b.append(caption);
      b.onclick = () => {
        relationDraft.kind = relationDraft.kind === kind ? "none" : kind;
        updateRelations();
      };
      relationChoices.append(b);
    }
    const save = document.createElement("button"), removing = relationDraft.kind === "none" && current !== "none", label = removing ? "移除关系" : current === "none" ? "添加关系" : relationDraft.kind === current ? "已保存" : "保存关系";
    save.id = "petRelationCommit";
    save.type = "button";
    save.className = "pet-relation-save";
    save.title = label;
    save.setAttribute("aria-label", label);
    const changed = () => relationDraft.kind !== current || relationDraft.text !== petProfiles.text(selected.profileKey, target.profileKey);
    save.disabled = !changed();
    relationMessage.hidden = relationDraft.kind === "none";
    relationMessage.value = relationDraft.text;
    relationMessage.oninput = () => {
      relationDraft.text = relationMessage.value;
      save.disabled = !changed();
      save.title = save.disabled ? "已保存" : "保存关系";
      save.setAttribute("aria-label", save.title);
    };
    save.innerHTML = '<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="1.8" stroke-linecap="round" stroke-linejoin="round" aria-hidden="true"><path d="' + (removing ? "M5 12h14" : current === "none" ? "M12 5v14M5 12h14" : "m5 12 4 4L19 6") + '"/></svg>';
    save.onclick = () => setRelationship(selected, target, relationDraft.kind, relationDraft.text);
    relationChoices.append(save);
    const existing = $("petExistingRelations");
    existing.replaceChildren();
    let count = 0;
    for (const a of pets) for (const b of pets) {
      if (a === b) continue;
      const kind = petProfiles.relation(a.profileKey, b.profileKey);
      if (kind === "none") continue;
      count++;
      const row = document.createElement("button");
      row.type = "button";
      row.className = "pet-existing-relation";
      row.setAttribute("aria-label", a.name + "对" + b.name + "：" + relationNames[kind]);
      row.append(portrait(a));
      const mid = document.createElement("span");
      mid.textContent = "→";
      row.append(mid, portrait(b));
      const feeling = document.createElement("span");
      feeling.className = "pet-existing-feeling " + kind;
      feeling.innerHTML = icon(kind);
      row.append(feeling);
      row.title = a.name + " → " + b.name + " · " + relationNames[kind];
      row.onclick = () => {
        relationTargetId = b.id;
        relationPickerSide = null;
        select(a);
      };
      existing.append(row);
    }
    relationMore.hidden = false;
    relationMore.querySelector("summary span").textContent = "已有关系" + (count ? " · " + count : "");
    if (!count) {
      const empty = document.createElement("p");
      empty.className = "pet-relation-empty";
      empty.textContent = "暂无关系";
      existing.append(empty);
    }
  }
  $("petVoiceOpen").onclick = () => {
    if (selected) {
      relationPanel.close();
      updateVoice();
      voicePanel.showModal();
    }
  };
  $("petRelationsOpen").onclick = () => {
    if (selected) {
      voicePanel.close();
      relationPickerSide = null;
      updateRelations();
      relationPanel.showModal();
    }
  };
  function updateSocial() {
    personalityRail.hidden = !active() || !selected;
    if (!active() || !selected) {
      voicePanel.close();
      relationPanel.close();
    } else {
      updateVoice();
      updateRelations();
    }
  }
  document.addEventListener("cotton-pet-selection", updateSocial);
  document.addEventListener("cotton-pet-list", updateSocial);
  window.addEventListener("cotton-voice-shape", updateVoice);
  updateSocial();
  let petContacts = /* @__PURE__ */ new Set();
  function socialTick(now) {
    var _a, _b;
    const next = /* @__PURE__ */ new Set();
    for (const p of pets) {
      if (p.reaction && p.reaction.until <= now) {
        p.reaction = null;
        (_a = p.node.querySelector(".pet-relation-pop")) == null ? void 0 : _a.remove();
      }
    }
    for (let i = 0; i < pets.length; i++) for (let j = i + 1; j < pets.length; j++) {
      const a = pets[i], b = pets[j], sa = size(a), sb = size(b);
      if (a.x + sa.w * 0.8 < b.x + sb.w * 0.2 || b.x + sb.w * 0.8 < a.x + sa.w * 0.2 || a.y + sa.h * 0.96 < b.y + sb.h * 0.12 || b.y + sb.h * 0.96 < a.y + sa.h * 0.12) continue;
      const pair = a.id + ":" + b.id;
      next.add(pair);
      if (petContacts.has(pair)) continue;
      for (const [from, to] of [[a, b], [b, a]]) {
        const kind = petProfiles.relation(from.profileKey, to.profileKey);
        if (kind === "none") continue;
        from.reaction = { kind, target: to.id, until: now + 1.8, count: (from.reactionCount || 0) + 1 };
        from.reactionCount = from.reaction.count;
        (_b = from.node.querySelector(".pet-relation-pop")) == null ? void 0 : _b.remove();
        const pop = document.createElement("span");
        pop.className = "pet-relation-pop " + kind;
        pop.setAttribute("role", "status");
        pop.setAttribute("aria-label", relationNames[kind]);
        pop.innerHTML = icon(kind);
        const text = petProfiles.text(from.profileKey, to.profileKey);
        if (text) {
          pop.classList.add("with-text");
          const words = document.createElement("span");
          words.textContent = text;
          pop.append(words);
        }
        from.node.append(pop);
      }
    }
    petContacts = next;
  }
  window.CottonPetProfiles = { setVoice: (id, value) => {
    var _a;
    const p = pets.find((p2) => p2.id === id);
    if (!p) return false;
    p.voice = value ? CottonSynth.normalizeVoice(value) : null;
    petProfiles.setVoice(p.profileKey, p.voice);
    if (!value) (_a = window.CottonMusic) == null ? void 0 : _a.releasePetVoice(p.profileKey);
    updateSocial();
    return true;
  }, setRelation: (a, b, kind, text = "") => setRelationship(pets.find((p) => p.id === a), pets.find((p) => p.id === b), kind, text), getRelations: () => pets.flatMap((a) => pets.filter((b) => b !== a).map((b) => ({ from: a.id, to: b.id, kind: petProfiles.relation(a.profileKey, b.profileKey), text: petProfiles.text(a.profileKey, b.profileKey) }))) };
})();
(function() {
  "use strict";
  function sync() {
    document.getElementById("cottonFrame").contentWindow.postMessage({ channel: "cotton-theatre-parent", type: "tear-setting", payload: { enabled: true } }, "*");
  }
  window.addEventListener("cotton-pet-state-change", sync);
  document.getElementById("cottonFrame").addEventListener("load", sync);
  sync();
})();
