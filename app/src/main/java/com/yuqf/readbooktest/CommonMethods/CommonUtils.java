package com.yuqf.readbooktest.CommonMethods;

import com.yuqf.readbooktest.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CommonUtils {
    public static List<HashMap<String, Object>> getData() {
        String key1 = "title";
        String key2 = "info";
        String key3 = "img";

        List<HashMap<String, Object>> mapList = new ArrayList<>();
        HashMap<String, Object> map1 = initMapObj(key1, key2, key3, "山丘之王", "人族英雄，技能：风暴之锤、天神下凡，相当厉害，但是腿短，跑得慢！",
                R.drawable.c1);
        HashMap<String, Object> map2 = initMapObj(key1, key2, key3, "精灵女王", "精灵族英雄，技能：毒镖、闪烁、飞镖、女王幻象，后期超神能力。",
                R.drawable.c2);
        HashMap<String, Object> map3 = initMapObj(key1, key2, key3, "精灵老鹿", "精灵族英雄，技能：荆棘光环、召唤树人、束缚、全体回血，辅助英雄，略差劲。",
                R.drawable.c3);
        HashMap<String, Object> map4 = initMapObj(key1, key2, key3, "兽族牛头人酋长", "兽族老牛头，技能：耐久光环、冲击波，强力英雄。",
                R.drawable.c4);
        HashMap<String, Object> map5 = initMapObj(key1, key2, key3, "兽族剑圣", "兽族灵魂级英雄，相当强悍，有起死回生之能力。", R.drawable.c5);
        HashMap<String, Object> map6 = initMapObj(key1, key2, key3, "亡灵死亡骑士", "亡灵英雄，超强的补给辅助能力，战术执行的核心。", R.drawable.c6);
        mapList.add(map1);
        mapList.add(map2);
        mapList.add(map3);
        mapList.add(map4);
        mapList.add(map5);
        mapList.add(map6);
        return mapList;
    }

    private static HashMap<String, Object> initMapObj(String key1, String key2, String key3, String value1, String value2,
                                                      int imgid) {
        HashMap<String, Object> map = new HashMap<>();
        map.put(key1, value1);
        map.put(key2, value2);
        map.put(key3, imgid);
        return map;
    }
}
