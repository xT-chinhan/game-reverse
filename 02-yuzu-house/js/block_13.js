(function() {
  "use strict";
  const scenes = [{ "id": "cream", "name": "奶油帷幕", "palette": ["#fbfaef", "#bdde93", "#e6eed5", "#fed0d6", "#a9bd8d", "#edf5db"], "svg": '<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 440 260" preserveAspectRatio="none"><rect width="440" height="260" fill="#fbfaef"/><path d="M25 216V91q0-73 73-73h244q73 0 73 73v125Z" fill="#fed0d6"/><path d="M44 215V96q0-58 58-58h236q58 0 58 58v119Z" fill="#fffdf7"/><path d="M67 205V100q0-39 39-39h228q39 0 39 39v105" fill="none" stroke="#b1c792" stroke-width="2"/><path d="M96 62v140" stroke="#edf5dc" stroke-width="2"/><path d="M122 62v140" stroke="#edf5dc" stroke-width="2"/><path d="M148 62v140" stroke="#edf5dc" stroke-width="2"/><path d="M174 62v140" stroke="#edf5dc" stroke-width="2"/><path d="M200 62v140" stroke="#edf5dc" stroke-width="2"/><path d="M226 62v140" stroke="#edf5dc" stroke-width="2"/><path d="M252 62v140" stroke="#edf5dc" stroke-width="2"/><path d="M278 62v140" stroke="#edf5dc" stroke-width="2"/><path d="M304 62v140" stroke="#edf5dc" stroke-width="2"/><path d="M330 62v140" stroke="#edf5dc" stroke-width="2"/><path d="M45 32h350v27q-25 23-50 0-25 23-50 0-25 23-50 0-25 23-50 0-25 23-50 0-25 23-50 0-25 23-50 0Z" fill="#bdde93"/><path d="M47 101q-25-22-27 0 4 16 27 0 25-21 27 0-2 18-27 0Zm-4 5-12 26 16-6 5-20 12 25 10 1-17-27Z" fill="#e4f6a9"/><circle cx="47" cy="102" r="6" fill="#ff82a2"/><path d="M393 101q-25-22-27 0 4 16 27 0 25-21 27 0-2 18-27 0Zm-4 5-12 26 16-6 5-20 12 25 10 1-17-27Z" fill="#e4f6a9"/><circle cx="393" cy="102" r="6" fill="#ff82a2"/><rect x="28" y="155" width="62" height="47" rx="5" fill="#afc88f"/><rect x="32" y="142" width="54" height="31" rx="4" fill="#e4f6a9"/><path d="M35 149h48m-48 7h48" stroke="#fffdf7" stroke-width="2"/><rect x="25" y="174" width="68" height="13" rx="2" fill="#fbfaef"/><rect x="35" y="174" width="4" height="8" fill="#98b77b"/><rect x="43" y="174" width="4" height="8" fill="#98b77b"/><rect x="58" y="174" width="4" height="8" fill="#98b77b"/><rect x="66" y="174" width="4" height="8" fill="#98b77b"/><rect x="74" y="174" width="4" height="8" fill="#98b77b"/><path d="M34 201v15m48-15v15M368 171v40m-12 5 12-7 12 7" fill="none" stroke="#ff82a2" stroke-width="3"/><path d="m347 144 44 4-5 30-43-4Z" fill="#fed0d6"/><path d="m351 152 30 3m-31 4 24 3m-25 4 29 3" stroke="#fffdf7" stroke-width="2"/><path d="M116 100v21l10-3v-21l-10 3" fill="none" stroke="#b28f9a" stroke-width="2"/><ellipse cx="113" cy="122" rx="5" ry="3" fill="#b28f9a"/><path d="M317 113v21l10-3v-21l-10 3" fill="none" stroke="#b28f9a" stroke-width="2"/><ellipse cx="314" cy="135" rx="5" ry="3" fill="#b28f9a"/><rect y="217" width="440" height="43" fill="#edf5db"/><path d="M0 219h440M0 247h440" stroke="#a9bd8d" stroke-width="2"/><path d="M50 232h340" stroke="#fbfaef" stroke-width="17"/><path d="M66 224v16" stroke="#cadbad"/><path d="M88 224v16" stroke="#cadbad"/><path d="M110 224v16" stroke="#cadbad"/><path d="M132 224v16" stroke="#cadbad"/><path d="M154 224v16" stroke="#cadbad"/><path d="M176 224v16" stroke="#cadbad"/><path d="M198 224v16" stroke="#cadbad"/><path d="M220 224v16" stroke="#cadbad"/><path d="M242 224v16" stroke="#cadbad"/><path d="M264 224v16" stroke="#cadbad"/><path d="M286 224v16" stroke="#cadbad"/><path d="M308 224v16" stroke="#cadbad"/><path d="M330 224v16" stroke="#cadbad"/><path d="M352 224v16" stroke="#cadbad"/><path d="M374 224v16" stroke="#cadbad"/><rect x="76" y="224" width="6" height="10" fill="#ff82a2"/><rect x="98" y="224" width="6" height="10" fill="#ff82a2"/><rect x="142" y="224" width="6" height="10" fill="#ff82a2"/><rect x="164" y="224" width="6" height="10" fill="#ff82a2"/><rect x="186" y="224" width="6" height="10" fill="#ff82a2"/><rect x="230" y="224" width="6" height="10" fill="#ff82a2"/><rect x="252" y="224" width="6" height="10" fill="#ff82a2"/><rect x="296" y="224" width="6" height="10" fill="#ff82a2"/><rect x="318" y="224" width="6" height="10" fill="#ff82a2"/><rect x="340" y="224" width="6" height="10" fill="#ff82a2"/></svg>' }, { "id": "lilac", "name": "雾蓝月光", "palette": ["#f4f9f9", "#a0cbd2", "#dcebed", "#f7e8e5", "#96b9c1", "#d7e4e4"], "svg": '<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 440 260" preserveAspectRatio="none"><rect width="440" height="260" fill="#f4f9f9"/><rect x="13" y="17" width="414" height="197" rx="38" fill="#bad9df"/><path d="M28 202V60q0-28 28-28h328q28 0 28 28v142" fill="none" stroke="#f8f4ef" stroke-width="2"/><path d="M31 23v65m71-65v34m236-34v53m69-53v94" stroke="#96b9c1" stroke-width="1.5"/><circle cx="79" cy="91" r="36" fill="#f8e7dc"/><circle cx="95" cy="77" r="33" fill="#bad9df"/><path d="M32 84l2.56 5.44 5.44 2.56-5.44 2.56-2.56 5.44-2.56-5.44-5.44-2.56 5.44-2.56Z" fill="#fcf2e8"/><path d="M102 60l1.6 3.4000000000000004 3.4000000000000004 1.6-3.4000000000000004 1.6-1.6 3.4000000000000004-1.6-3.4000000000000004-3.4000000000000004-1.6 3.4000000000000004-1.6Z" fill="#fcf2e8"/><path d="M339 71l3.52 7.48 7.48 3.52-7.48 3.52-3.52 7.48-3.52-7.48-7.48-3.52 7.48-3.52Z" fill="#fcf2e8"/><path d="M407 116l2.24 4.760000000000001 4.760000000000001 2.24-4.760000000000001 2.24-2.24 4.760000000000001-2.24-4.760000000000001-4.760000000000001-2.24 4.760000000000001-2.24Z" fill="#fcf2e8"/><path d="M143 104l1.28 2.72 2.72 1.28-2.72 1.28-1.28 2.72-1.28-2.72-2.72-1.28 2.72-1.28Z" fill="#fcf2e8"/><path d="M284 43l1.6 3.4000000000000004 3.4000000000000004 1.6-3.4000000000000004 1.6-1.6 3.4000000000000004-1.6-3.4000000000000004-3.4000000000000004-1.6 3.4000000000000004-1.6Z" fill="#fcf2e8"/><path d="M367 151l1.28 2.72 2.72 1.28-2.72 1.28-1.28 2.72-1.28-2.72-2.72-1.28 2.72-1.28Z" fill="#fcf2e8"/><path d="M119 153l1.28 2.72 2.72 1.28-2.72 1.28-1.28 2.72-1.28-2.72-2.72-1.28 2.72-1.28Z" fill="#fcf2e8"/><path d="m159 67 29-16 30 20 39-11m-100 0 31 18m132 38 28-17 25 18" fill="none" stroke="#d9e9e9" stroke-width="1.5"/><circle cx="159" cy="67" r="2.5" fill="#fff4e8"/><circle cx="188" cy="51" r="2.5" fill="#fff4e8"/><circle cx="218" cy="71" r="2.5" fill="#fff4e8"/><circle cx="257" cy="60" r="2.5" fill="#fff4e8"/><circle cx="188" cy="78" r="2.5" fill="#fff4e8"/><circle cx="320" cy="116" r="2.5" fill="#fff4e8"/><circle cx="348" cy="99" r="2.5" fill="#fff4e8"/><circle cx="373" cy="117" r="2.5" fill="#fff4e8"/><path d="M0 211v-41q5-13 20-10 1-24 24-24 21 0 25 21 21-8 31 9 21-4 26 17v28Z" fill="#f7eeeb"/><path d="M314 211v-25q6-24 29-18 8-21 28-11 5-30 30-28 28 1 28 27l11 6v49Z" fill="#f7e8e5"/><path d="M9 191h69m277 4h75" stroke="#a6c8ce" stroke-width="2"/><path d="m351 181-14 31m14-31 18 31m-18-31v31" stroke="#87abb4" stroke-width="3" stroke-linecap="round"/><path d="m325 158 50-21 10 20-50 21Z" fill="#9dc5cd"/><path d="m373 137 8-4 13 26-9 4Z" fill="#e8d3ca"/><path d="m322 158 6-3 11 23-6 3Z" fill="#fcf1e8"/><rect y="217" width="440" height="43" fill="#d7e4e4"/><path d="M0 219h440m-440 27h440" stroke="#9dbcc4" stroke-width="1.5"/><circle cx="33" cy="235" r="6" fill="#f6e8df"/><circle cx="36" cy="233" r="5" fill="#d7e4e4"/><circle cx="95" cy="235" r="6" fill="#f6e8df"/><circle cx="98" cy="233" r="5" fill="#d7e4e4"/><circle cx="157" cy="235" r="6" fill="#f6e8df"/><circle cx="160" cy="233" r="5" fill="#d7e4e4"/><circle cx="219" cy="235" r="6" fill="#f6e8df"/><circle cx="222" cy="233" r="5" fill="#d7e4e4"/><circle cx="281" cy="235" r="6" fill="#f6e8df"/><circle cx="284" cy="233" r="5" fill="#d7e4e4"/><circle cx="343" cy="235" r="6" fill="#f6e8df"/><circle cx="346" cy="233" r="5" fill="#d7e4e4"/><circle cx="405" cy="235" r="6" fill="#f6e8df"/><circle cx="408" cy="233" r="5" fill="#d7e4e4"/></svg>' }, { "id": "mint", "name": "薄荷乐队", "palette": ["#f3f9f8", "#a0cbd2", "#d4e7e8", "#f7e8e5", "#8fb8bf", "#d7e7e5"], "svg": '<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 440 260" preserveAspectRatio="none"><rect width="440" height="260" fill="#f3f9f8"/><rect x="87" y="48" width="43" height="148" rx="20" fill="#d4e7e8"/><path d="M96 67v107m12-114v119m12-109v104" stroke="#f3f9f8" stroke-width="2"/><rect x="143" y="48" width="43" height="148" rx="20" fill="#d4e7e8"/><path d="M152 67v107m12-114v119m12-109v104" stroke="#f3f9f8" stroke-width="2"/><rect x="199" y="48" width="43" height="148" rx="20" fill="#d4e7e8"/><path d="M208 67v107m12-114v119m12-109v104" stroke="#f3f9f8" stroke-width="2"/><rect x="255" y="48" width="43" height="148" rx="20" fill="#d4e7e8"/><path d="M264 67v107m12-114v119m12-109v104" stroke="#f3f9f8" stroke-width="2"/><rect x="311" y="48" width="43" height="148" rx="20" fill="#d4e7e8"/><path d="M320 67v107m12-114v119m12-109v104" stroke="#f3f9f8" stroke-width="2"/><path d="M64 170V93l15-8m-15 73-9 15M365 178v-70l-13-13" fill="none" stroke="#8fb8bf" stroke-width="3" stroke-linecap="round"/><rect x="72" y="79" width="16" height="8" rx="4" fill="#8fb8bf"/><rect x="342" y="89" width="16" height="8" rx="4" fill="#8fb8bf"/><path d="m220 58 3.5999999999999996 8.16 8.399999999999999 3.84-8.399999999999999 3.5999999999999996-3.5999999999999996 8.399999999999999-3.5999999999999996-8.399999999999999-8.399999999999999-3.5999999999999996 8.399999999999999-3.84Z" fill="#f7e8e5"/><path d="M0 12h75q-5 101-38 122l16 82H0Zm440 0h-75q5 101 38 122l-16 82h53Z" fill="#a0cbd2"/><path d="M17 30q3 76 17 94M42 31q-1 50-13 77m394-78q-3 76-17 94m-8-93q1 50 13 77" fill="none" stroke="#8fb8bf" stroke-width="2"/><path d="M10 134h29m362 0h29" stroke="#f7e8e5" stroke-width="6" stroke-linecap="round"/><path d="M0 0h440v28q-36 23-73 0-37 23-74 0-37 23-73 0-37 23-74 0-37 23-73 0Q36 51 0 28Z" fill="#a0cbd2"/><path d="M83 18h274" stroke="#8fb8bf" stroke-width="3" stroke-linecap="round"/><path d="M105 18v13" stroke="#8fb8bf" stroke-width="2"/><rect x="95" y="29" width="20" height="11" rx="4" fill="#8fb8bf"/><rect x="99" y="36" width="12" height="4" rx="2" fill="#f7e8e5"/><path d="M161 18v13" stroke="#8fb8bf" stroke-width="2"/><rect x="151" y="29" width="20" height="11" rx="4" fill="#8fb8bf"/><rect x="155" y="36" width="12" height="4" rx="2" fill="#f7e8e5"/><path d="M279 18v13" stroke="#8fb8bf" stroke-width="2"/><rect x="269" y="29" width="20" height="11" rx="4" fill="#8fb8bf"/><rect x="273" y="36" width="12" height="4" rx="2" fill="#f7e8e5"/><path d="M335 18v13" stroke="#8fb8bf" stroke-width="2"/><rect x="325" y="29" width="20" height="11" rx="4" fill="#8fb8bf"/><rect x="329" y="36" width="12" height="4" rx="2" fill="#f7e8e5"/><rect x="17" y="148" width="37" height="69" rx="7" fill="#8fb8bf"/><circle cx="35.5" cy="168" r="8" fill="#fff8f3"/><circle cx="35.5" cy="196" r="13" fill="#fff8f3"/><circle cx="35.5" cy="196" r="5" fill="#8fb8bf"/><rect x="386" y="148" width="37" height="69" rx="7" fill="#8fb8bf"/><circle cx="404.5" cy="168" r="8" fill="#fff8f3"/><circle cx="404.5" cy="196" r="13" fill="#fff8f3"/><circle cx="404.5" cy="196" r="5" fill="#8fb8bf"/><rect y="217" width="440" height="43" fill="#d7e7e5"/><path d="M0 219h440m-440 26h440" stroke="#8fb8bf" stroke-width="1.5"/><path d="M58 226h324" stroke="#f3f9f8" stroke-width="3" stroke-linecap="round"/><rect x="16" y="242" width="10" height="5" rx="2.5" fill="#fff6ef"/><rect x="72" y="242" width="10" height="5" rx="2.5" fill="#fff6ef"/><rect x="128" y="242" width="10" height="5" rx="2.5" fill="#fff6ef"/><rect x="184" y="242" width="10" height="5" rx="2.5" fill="#fff6ef"/><rect x="240" y="242" width="10" height="5" rx="2.5" fill="#fff6ef"/><rect x="296" y="242" width="10" height="5" rx="2.5" fill="#fff6ef"/><rect x="352" y="242" width="10" height="5" rx="2.5" fill="#fff6ef"/><rect x="408" y="242" width="10" height="5" rx="2.5" fill="#fff6ef"/></svg>' }, { "id": "peach", "name": "蜜桃小剧场", "palette": ["#ffffff", "#F5C7C9", "#fceeef", "#B9D9EA", "#cf9ca4", "#fae3e4"], "svg": '<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 440 260" preserveAspectRatio="none"><rect width="440" height="260" fill="#ffffff"/><rect x="18" y="10" width="404" height="207" rx="13" fill="#F5C7C9"/><rect x="38" y="37" width="364" height="180" rx="7" fill="#ffffff"/><path d="M56 213V59h328v154" fill="none" stroke="#f9dddf" stroke-width="2"/><path d="M16 11h408v32H16Z" fill="#F5C7C9"/><circle cx="33" cy="26" r="4" fill="#EFE4D4"/><path d="M58 29c-9-5-6-11 0-6 6-5 9 1 0 6Z" fill="#EFE4D4"/><circle cx="83" cy="26" r="4" fill="#EFE4D4"/><path d="M108 29c-9-5-6-11 0-6 6-5 9 1 0 6Z" fill="#EFE4D4"/><circle cx="133" cy="26" r="4" fill="#EFE4D4"/><path d="M158 29c-9-5-6-11 0-6 6-5 9 1 0 6Z" fill="#EFE4D4"/><circle cx="183" cy="26" r="4" fill="#EFE4D4"/><path d="M208 29c-9-5-6-11 0-6 6-5 9 1 0 6Z" fill="#EFE4D4"/><circle cx="233" cy="26" r="4" fill="#EFE4D4"/><path d="M258 29c-9-5-6-11 0-6 6-5 9 1 0 6Z" fill="#EFE4D4"/><circle cx="283" cy="26" r="4" fill="#EFE4D4"/><path d="M308 29c-9-5-6-11 0-6 6-5 9 1 0 6Z" fill="#EFE4D4"/><circle cx="333" cy="26" r="4" fill="#EFE4D4"/><path d="M358 29c-9-5-6-11 0-6 6-5 9 1 0 6Z" fill="#EFE4D4"/><circle cx="383" cy="26" r="4" fill="#EFE4D4"/><path d="M408 29c-9-5-6-11 0-6 6-5 9 1 0 6Z" fill="#EFE4D4"/><path d="M21 43h34v173H21Zm364 0h34v173h-34Z" fill="#ffffff"/><path d="M30 54v150m376-150v150" stroke="#f8d5d6" stroke-width="2"/><path d="M57 43h116Q137 99 73 121l35 91H57Zm326 0H267q36 56 100 78l-35 91h51Z" fill="#fae6e7"/><path d="M73 120h17m260 0h17" stroke="#cf9ca4" stroke-width="4" stroke-linecap="round"/><path d="M107 74q113 61 226 0" fill="none" stroke="#F8819B" stroke-width="1.5"/><path d="m120 82 2 17 12-10Z" fill="#B9D9EA"/><path d="m159 97 2 17 12-10Z" fill="#B9D9EA"/><path d="m198 105 2 17 12-10Z" fill="#B9D9EA"/><path d="m237 105 2 17 12-10Z" fill="#B9D9EA"/><path d="m276 97 2 17 12-10Z" fill="#B9D9EA"/><path d="m315 82 2 17 12-10Z" fill="#B9D9EA"/><path d="M68 146q16 9 32 0v21q-16 27-32 0Z" fill="#ffffff"/><path d="M74 157h5m10 0h5m-18 9q8 9 16 0" stroke="#cf9ca4" stroke-width="2" stroke-linecap="round" fill="none"/><path d="M340 151q16-7 32 0v20q-16 27-32 0Z" fill="#f6aeb9"/><path d="M346 161h5m10 0h5m-18 16q8-8 16 0" stroke="#ffffff" stroke-width="2" stroke-linecap="round" fill="none"/><rect x="105" y="185" width="25" height="31" rx="3" fill="#B9D9EA"/><path d="M110 197h15m-15 6h15" stroke="#ffffff" stroke-width="2"/><rect x="310" y="192" width="23" height="24" rx="3" fill="#f8d5d6"/><path d="M321 198l1.92 4.08 4.08 1.92-4.08 1.92-1.92 4.08-1.92-4.08-4.08-1.92 4.08-1.92Z" fill="#ffffff"/><rect y="217" width="440" height="43" fill="#fae3e4"/><path d="M0 219h440m-440 28h440" stroke="#cf9ca4" stroke-width="2"/><path d="M0 225h14v12h14v10h-14v-10h-14Z" fill="#ffffff"/><path d="M28 225h14v12h14v10h-14v-10h-14Z" fill="#ffffff"/><path d="M56 225h14v12h14v10h-14v-10h-14Z" fill="#ffffff"/><path d="M84 225h14v12h14v10h-14v-10h-14Z" fill="#ffffff"/><path d="M112 225h14v12h14v10h-14v-10h-14Z" fill="#ffffff"/><path d="M140 225h14v12h14v10h-14v-10h-14Z" fill="#ffffff"/><path d="M168 225h14v12h14v10h-14v-10h-14Z" fill="#ffffff"/><path d="M196 225h14v12h14v10h-14v-10h-14Z" fill="#ffffff"/><path d="M224 225h14v12h14v10h-14v-10h-14Z" fill="#ffffff"/><path d="M252 225h14v12h14v10h-14v-10h-14Z" fill="#ffffff"/><path d="M280 225h14v12h14v10h-14v-10h-14Z" fill="#ffffff"/><path d="M308 225h14v12h14v10h-14v-10h-14Z" fill="#ffffff"/><path d="M336 225h14v12h14v10h-14v-10h-14Z" fill="#ffffff"/><path d="M364 225h14v12h14v10h-14v-10h-14Z" fill="#ffffff"/><path d="M392 225h14v12h14v10h-14v-10h-14Z" fill="#ffffff"/><path d="M420 225h14v12h14v10h-14v-10h-14Z" fill="#ffffff"/></svg>', "variants": [{ "id": "sky", "name": "奶粉浅蓝", "svg": '<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 440 260" preserveAspectRatio="none"><rect width="440" height="260" fill="#ffffff"/><rect x="18" y="10" width="404" height="207" rx="13" fill="#F5C7C9"/><rect x="38" y="37" width="364" height="180" rx="7" fill="#ffffff"/><path d="M56 213V59h328v154" fill="none" stroke="#f9dddf" stroke-width="2"/><path d="M16 11h408v32H16Z" fill="#F5C7C9"/><circle cx="33" cy="26" r="4" fill="#EFE4D4"/><path d="M58 29c-9-5-6-11 0-6 6-5 9 1 0 6Z" fill="#EFE4D4"/><circle cx="83" cy="26" r="4" fill="#EFE4D4"/><path d="M108 29c-9-5-6-11 0-6 6-5 9 1 0 6Z" fill="#EFE4D4"/><circle cx="133" cy="26" r="4" fill="#EFE4D4"/><path d="M158 29c-9-5-6-11 0-6 6-5 9 1 0 6Z" fill="#EFE4D4"/><circle cx="183" cy="26" r="4" fill="#EFE4D4"/><path d="M208 29c-9-5-6-11 0-6 6-5 9 1 0 6Z" fill="#EFE4D4"/><circle cx="233" cy="26" r="4" fill="#EFE4D4"/><path d="M258 29c-9-5-6-11 0-6 6-5 9 1 0 6Z" fill="#EFE4D4"/><circle cx="283" cy="26" r="4" fill="#EFE4D4"/><path d="M308 29c-9-5-6-11 0-6 6-5 9 1 0 6Z" fill="#EFE4D4"/><circle cx="333" cy="26" r="4" fill="#EFE4D4"/><path d="M358 29c-9-5-6-11 0-6 6-5 9 1 0 6Z" fill="#EFE4D4"/><circle cx="383" cy="26" r="4" fill="#EFE4D4"/><path d="M408 29c-9-5-6-11 0-6 6-5 9 1 0 6Z" fill="#EFE4D4"/><path d="M21 43h34v173H21Zm364 0h34v173h-34Z" fill="#ffffff"/><path d="M30 54v150m376-150v150" stroke="#f8d5d6" stroke-width="2"/><path d="M57 43h116Q137 99 73 121l35 91H57Zm326 0H267q36 56 100 78l-35 91h51Z" fill="#fae6e7"/><path d="M73 120h17m260 0h17" stroke="#cf9ca4" stroke-width="4" stroke-linecap="round"/><path d="M107 74q113 61 226 0" fill="none" stroke="#F8819B" stroke-width="1.5"/><path d="m120 82 2 17 12-10Z" fill="#B9D9EA"/><path d="m159 97 2 17 12-10Z" fill="#B9D9EA"/><path d="m198 105 2 17 12-10Z" fill="#B9D9EA"/><path d="m237 105 2 17 12-10Z" fill="#B9D9EA"/><path d="m276 97 2 17 12-10Z" fill="#B9D9EA"/><path d="m315 82 2 17 12-10Z" fill="#B9D9EA"/><path d="M68 146q16 9 32 0v21q-16 27-32 0Z" fill="#ffffff"/><path d="M74 157h5m10 0h5m-18 9q8 9 16 0" stroke="#cf9ca4" stroke-width="2" stroke-linecap="round" fill="none"/><path d="M340 151q16-7 32 0v20q-16 27-32 0Z" fill="#f6aeb9"/><path d="M346 161h5m10 0h5m-18 16q8-8 16 0" stroke="#ffffff" stroke-width="2" stroke-linecap="round" fill="none"/><rect x="105" y="185" width="25" height="31" rx="3" fill="#B9D9EA"/><path d="M110 197h15m-15 6h15" stroke="#ffffff" stroke-width="2"/><rect x="310" y="192" width="23" height="24" rx="3" fill="#f8d5d6"/><path d="M321 198l1.92 4.08 4.08 1.92-4.08 1.92-1.92 4.08-1.92-4.08-4.08-1.92 4.08-1.92Z" fill="#ffffff"/><rect y="217" width="440" height="43" fill="#fae3e4"/><path d="M0 219h440m-440 28h440" stroke="#cf9ca4" stroke-width="2"/><path d="M0 225h14v12h14v10h-14v-10h-14Z" fill="#ffffff"/><path d="M28 225h14v12h14v10h-14v-10h-14Z" fill="#ffffff"/><path d="M56 225h14v12h14v10h-14v-10h-14Z" fill="#ffffff"/><path d="M84 225h14v12h14v10h-14v-10h-14Z" fill="#ffffff"/><path d="M112 225h14v12h14v10h-14v-10h-14Z" fill="#ffffff"/><path d="M140 225h14v12h14v10h-14v-10h-14Z" fill="#ffffff"/><path d="M168 225h14v12h14v10h-14v-10h-14Z" fill="#ffffff"/><path d="M196 225h14v12h14v10h-14v-10h-14Z" fill="#ffffff"/><path d="M224 225h14v12h14v10h-14v-10h-14Z" fill="#ffffff"/><path d="M252 225h14v12h14v10h-14v-10h-14Z" fill="#ffffff"/><path d="M280 225h14v12h14v10h-14v-10h-14Z" fill="#ffffff"/><path d="M308 225h14v12h14v10h-14v-10h-14Z" fill="#ffffff"/><path d="M336 225h14v12h14v10h-14v-10h-14Z" fill="#ffffff"/><path d="M364 225h14v12h14v10h-14v-10h-14Z" fill="#ffffff"/><path d="M392 225h14v12h14v10h-14v-10h-14Z" fill="#ffffff"/><path d="M420 225h14v12h14v10h-14v-10h-14Z" fill="#ffffff"/></svg>', "palette": ["#ffffff", "#F5C7C9", "#fceeef", "#B9D9EA", "#cf9ca4", "#fae3e4"], "swatches": ["#F5C7C9", "#FFFFFF", "#B9D9EA", "#F8819B"], "referenceColors": ["#F5C7C9", "#B9D9EA", "#EFE4D4", "#F8819B"] }] }], byId = Object.fromEntries(scenes.map((s) => [s.id, s])), preview = new URLSearchParams(location.search).get("stagepreview"), reduced = matchMedia("(prefers-reduced-motion: reduce)");
  let selected = "cream", back = null, raf = 0, lastMerge = -Infinity, streak = 0, lastGlow = -Infinity, lastRibbon = -Infinity, glow = null, ribbon = null, serial = 0, glows = 0, ribbons = 0;
  try {
    selected = preview && byId[preview] ? preview : localStorage.getItem("yuzu-stage-scene") || "cream";
  } catch (e) {
  }
  if (!byId[selected]) selected = "cream";
  const pinkVariants = byId.peach.variants || [];
  let selectedPink = new URLSearchParams(location.search).get("pinkpalette") || "sky";
  if (!preview) try {
    selectedPink = localStorage.getItem("yuzu-pink-palette") || selectedPink;
  } catch (e) {
  }
  if (!pinkVariants.some((v) => v.id === selectedPink)) selectedPink = "sky";
  if (!preview) try {
    if (localStorage.getItem("yuzu-pink-choice34") !== "sky") {
      selected = "peach";
      localStorage.setItem("yuzu-pink-choice34", "sky");
    }
    localStorage.setItem("yuzu-pink-palette", "sky");
  } catch (e) {
  }
  const canvas = document.createElement("canvas");
  canvas.id = "yuzuStageParty";
  canvas.setAttribute("aria-hidden", "true");
  document.body.append(canvas);
  const ctx = canvas.getContext("2d");
  const choices = document.createElement("section");
  choices.className = "stage-options";
  choices.setAttribute("aria-label", "舞台布景");
  choices.innerHTML = '<h3>舞台布景</h3><div class="stage-option-grid">' + scenes.map((s) => '<button type="button" data-scene="' + s.id + '" aria-label="舞台：' + s.name + '">' + s.svg + "<span>" + s.name + "</span></button>").join("") + "</div>";
  document.querySelector(".audio-more").before(choices);
  choices.querySelectorAll("button").forEach((b) => b.onclick = () => setTheme(b.dataset.scene));
  const pinkChoices = document.createElement("div");
  pinkChoices.className = "stage-pink-options";
  pinkChoices.hidden = true;
  function active() {
    return CottonTheatre.getStatus().scene === "play" && !["set", "up", "win", "codexPanel"].some((id) => document.getElementById(id).classList.contains("on"));
  }
  function position() {
    if (!back) return;
    const stage = document.getElementById("puppet").getBoundingClientRect(), base = back.parentElement.getBoundingClientRect(), height = Math.max(stage.height, document.getElementById("board").getBoundingClientRect().top - stage.top - 7);
    Object.assign(back.style, { left: stage.left - base.left + "px", top: stage.top - base.top + "px", width: stage.width + "px", height: height + "px" });
    back.style.setProperty("--stage-art-height", stage.height + "px");
  }
  function resize() {
    const d = Math.min(2, devicePixelRatio || 1);
    canvas.width = Math.round(innerWidth * d);
    canvas.height = Math.round(innerHeight * d);
    ctx.setTransform(d, 0, 0, d, 0, 0);
    position();
  }
  function setTheme(id) {
    if (!byId[id]) return false;
    selected = id;
    const art = id === "peach" ? pinkVariants.find((v) => v.id === selectedPink) || byId[id] : byId[id];
    if (back) {
      back.style.setProperty("--stage-paper", art.palette[0]);
      back.innerHTML = art.svg + '<div class="stage-audience" aria-hidden="true"><svg viewBox="0 0 440 90" preserveAspectRatio="none"><path d="M0 24h440M0 68h440" stroke="' + art.palette[2] + '" fill="none"/>' + [24, 80, 136, 192, 248, 304, 360, 416].map((x) => '<path d="M' + (x - 16) + ' 77v-6q0-11 16-11t16 11v6Z" fill="' + art.palette[2] + '"/><circle cx="' + x + '" cy="55" r="9" fill="' + art.palette[2] + '"/>').join("") + "</svg></div>";
    }
    choices.querySelectorAll("[data-scene]").forEach((b) => b.setAttribute("aria-pressed", String(b.dataset.scene === id)));
    pinkChoices.querySelectorAll("button").forEach((b) => b.setAttribute("aria-pressed", String(b.dataset.pinkPalette === selectedPink)));
    document.body.dataset.stageScene = id;
    document.body.dataset.pinkPalette = selectedPink;
    if (!preview) try {
      localStorage.setItem("yuzu-stage-scene", id);
    } catch (e) {
    }
    if (preview && parent !== window) parent.postMessage({ channel: "yuzu-stage-theme", id, name: byId[id].name }, "*");
    return true;
  }
  function setPinkPalette(id) {
    if (!pinkVariants.some((v) => v.id === id)) return false;
    selectedPink = id;
    if (!preview) try {
      localStorage.setItem("yuzu-pink-palette", id);
    } catch (e) {
    }
    return setTheme("peach");
  }
  function mount() {
    const base = document.getElementById("cottonBackdropBase");
    if (!base) {
      requestAnimationFrame(mount);
      return;
    }
    back = document.createElement("div");
    back.id = "yuzuStageBackdrop";
    back.setAttribute("aria-hidden", "true");
    base.append(back);
    setTheme(selected);
    new ResizeObserver(resize).observe(document.getElementById("puppet"));
    resize();
  }
  function reset() {
    streak = 0;
    lastMerge = -Infinity;
    glow = ribbon = null;
    lastGlow = lastRibbon = -Infinity;
    if (raf) cancelAnimationFrame(raf);
    raf = 0;
    ctx.clearRect(0, 0, innerWidth, innerHeight);
    document.body.dataset.stageFlow = "0";
  }
  function start(kind, now) {
    if (reduced.matches || !active()) return;
    const fx = { at: now, life: kind === "glow" ? 2600 : 2100, seed: serial++ };
    if (kind === "glow") {
      glow = fx;
      glows++;
      lastGlow = now;
    } else {
      ribbon = fx;
      ribbons++;
      lastRibbon = now;
    }
    document.body.dataset.stageParty = kind;
    if (!raf) raf = requestAnimationFrame(draw);
  }
  function merge(now) {
    if (!active()) {
      reset();
      return;
    }
    streak = now - lastMerge <= 2200 ? streak + 1 : 1;
    lastMerge = now;
    document.body.dataset.stageFlow = String(streak);
    if (streak >= 3 && now - lastGlow >= 6e3) start("glow", now);
    if (streak >= 5 && now - lastRibbon >= 6500) start("ribbon", now);
  }
  function draw(now) {
    raf = 0;
    ctx.clearRect(0, 0, innerWidth, innerHeight);
    if (!active() || reduced.matches) {
      glow = ribbon = null;
      return;
    }
    const a = document.getElementById("puppet").getBoundingClientRect(), w = a.width, h = Math.max(a.height, document.getElementById("board").getBoundingClientRect().top - a.top - 7);
    ctx.save();
    ctx.beginPath();
    ctx.rect(a.left, a.top, w, h);
    ctx.clip();
    ctx.translate(a.left, a.top);
    const colors = ["#e8b8ca", "#b8cdb7", "#c4b9df", "#edcf9d", "#acd3d0"];
    if (glow) {
      const q = (now - glow.at) / glow.life;
      if (q >= 1) glow = null;
      else {
        ctx.globalAlpha = Math.min(1, (1 - q) * 5);
        for (let i = 0; i < 10; i++) {
          const right = i >= 5, j = i % 5, x = w * (right ? 0.76 + j * 0.045 : 0.06 + j * 0.045), y = h * (0.91 + j % 2 * 0.035), wave = Math.sin((now - glow.at) / 190 + j * 0.7) * 0.36;
          ctx.save();
          ctx.translate(x, y);
          ctx.rotate(wave * (right ? -1 : 1));
          ctx.strokeStyle = "#f8f4e9";
          ctx.lineWidth = 10;
          ctx.lineCap = "round";
          ctx.beginPath();
          ctx.moveTo(0, -4);
          ctx.lineTo(0, -h * 0.18);
          ctx.stroke();
          ctx.strokeStyle = colors[i % 5];
          ctx.lineWidth = 6;
          ctx.stroke();
          ctx.strokeStyle = "#8e9f8b";
          ctx.lineWidth = 5;
          ctx.beginPath();
          ctx.moveTo(0, 3);
          ctx.lineTo(0, -7);
          ctx.stroke();
          ctx.restore();
        }
      }
    }
    if (ribbon) {
      const q = (now - ribbon.at) / ribbon.life;
      if (q >= 1) ribbon = null;
      else {
        ctx.globalAlpha = Math.min(1, (1 - q) * 5);
        for (let i = 0; i < 8; i++) {
          const right = i % 2, x = (right ? w + 12 : -12) + (right ? -1 : 1) * w * (0.09 + 0.05 * (i >> 1)) * Math.sin(q * Math.PI * 0.8), y = h * (-0.15 + q * 1.35) + (i >> 1) * h * 0.09;
          ctx.save();
          ctx.translate(x, y);
          ctx.rotate((right ? -0.3 : 0.3) + Math.sin(q * 8 + i) * 0.1);
          ctx.strokeStyle = colors[i % 5];
          ctx.lineWidth = 4 + i % 2;
          ctx.lineCap = "butt";
          ctx.beginPath();
          for (let k = 0; k <= 15; k++) {
            const yy = k * 5, xx = Math.sin(k * 0.58 + q * 8 + i) * 7;
            k ? ctx.lineTo(xx, yy) : ctx.moveTo(xx, yy);
          }
          ctx.stroke();
          ctx.restore();
        }
        for (let i = 0; i < 14; i++) {
          const x = w * (0.04 + i * 37 % 93 / 100), y = h * (-0.2 + q * 1.5) - i * 13 % 47;
          ctx.save();
          ctx.translate(x, y);
          ctx.rotate(q * 4 + i);
          ctx.fillStyle = colors[i % 5];
          ctx.fillRect(-2, -4, 4, 8);
          ctx.restore();
        }
      }
    }
    ctx.restore();
    if (glow || ribbon) raf = requestAnimationFrame(draw);
    else delete document.body.dataset.stageParty;
  }
  window.addEventListener("resize", resize);
  window.addEventListener("cotton-shake-frame", position);
  window.addEventListener("cotton-game", (e) => {
    const d = e.detail || {};
    if (["home", "play", "reset"].includes(d.type)) {
      reset();
      requestAnimationFrame(position);
    }
    if (d.type === "merge") merge(performance.now());
  });
  for (const id of ["set", "up", "win", "codexPanel"]) new MutationObserver(() => {
    if (!active()) reset();
  }).observe(document.getElementById(id), { attributes: true, attributeFilter: ["class"] });
  window.CottonStage = Object.freeze({ setTheme, setPinkPalette, preview() {
    const now = performance.now();
    start("glow", now);
    start("ribbon", now);
  }, getStatus: () => ({ selected, pinkPalette: selectedPink, pinkPalettes: pinkVariants.map((v) => ({ id: v.id, name: v.name })), name: byId[selected].name, scenes: scenes.map((s) => ({ id: s.id, name: s.name })), streak, glows, ribbons, activeGlow: !!glow, activeRibbon: !!ribbon, maxGapMs: 2200, glowAt: 3, ribbonAt: 5, layer: "clipped-stage-background", reducedMotion: reduced.matches }) });
  if (preview) {
    window.addEventListener("message", (e) => {
      var _a, _b;
      if (e.source !== parent || ((_a = e.data) == null ? void 0 : _a.channel) !== "yuzu-stage-preview") return;
      if (e.data.type === "theme") setTheme((_b = e.data.payload) == null ? void 0 : _b.id);
      if (e.data.type === "demo") CottonStage.preview();
    });
    const launch = () => {
      if (!CottonTheatre.getStatus().ready) {
        setTimeout(launch, 80);
        return;
      }
      CottonGame.start();
    };
    setTimeout(launch, 100);
  }
  setTheme(selected);
  mount();
})();
