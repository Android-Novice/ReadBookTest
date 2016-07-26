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
        HashMap<String, Object> map1 = initMapObj(key1, key2, key3, "ɽ��֮��", "����Ӣ�ۣ����ܣ��籩֮���������·����൱�����������ȶ̣��ܵ�����",
                R.drawable.c1);
        HashMap<String, Object> map2 = initMapObj(key1, key2, key3, "����Ů��", "������Ӣ�ۣ����ܣ����ڡ���˸�����ڡ�Ů�����󣬺��ڳ���������",
                R.drawable.c2);
        HashMap<String, Object> map3 = initMapObj(key1, key2, key3, "������¹", "������Ӣ�ۣ����ܣ������⻷���ٻ����ˡ�������ȫ���Ѫ������Ӣ�ۣ��Բ��",
                R.drawable.c3);
        HashMap<String, Object> map4 = initMapObj(key1, key2, key3, "����ţͷ������", "������ţͷ�����ܣ��;ù⻷���������ǿ��Ӣ�ۡ�",
                R.drawable.c4);
        HashMap<String, Object> map5 = initMapObj(key1, key2, key3, "���彣ʥ", "������꼶Ӣ�ۣ��൱ǿ��������������֮������", R.drawable.c5);
        HashMap<String, Object> map6 = initMapObj(key1, key2, key3, "����������ʿ", "����Ӣ�ۣ���ǿ�Ĳ�������������ս��ִ�еĺ��ġ�", R.drawable.c6);
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
