package com.example.ss.expandablelistexamples;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends Activity {

    String[] groups = new String[] { "Зима", "Весна", "Лето", "Осень" };

    String[] winterMonths = new String[] { "Декабрь", "Январь", "Февраль" };
    String[] springMonths = new String[] { "Март", "Апрель", "Май" };
    String[] summerMonths = new String[] { "Июнь", "Июль", "Август" };
    String[] autumnMonths = new String[] { "Сентябрь", "Октябрь", "Ноябрь" };

    String[][] allMonths = new String[][] {
            new String[] { "Декабрь", "Январь", "Февр"},
            new String[] { "Март", "Апрель", "Май" },
            new String[] { "Июнь", "Июль", "Август"},
            new String[] { "Сентябрь", "Октябрь", "Ноябрь"}
    };


    // коллекция для групп
    ArrayList<Map<String, String>> groupData;

    // коллекция для элементов одной группы
    ArrayList<Map<String, String>> childDataItem;

    // общая коллекция для коллекций элементов
    ArrayList<ArrayList<Map<String, String>>> childData;
    // в итоге получится childData = ArrayList<childDataItem>

    // список атрибутов группы или элемента
    Map<String, String> temp;

    ExpandableListView expListView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // заполняем коллекцию групп из массива с названиями групп
        groupData = new ArrayList<Map<String, String>>();
        for (String group : groups) {
            // заполняем список атрибутов для каждой группы
            temp = new HashMap<String, String>();
            temp.put("groupName", group); // время года
            groupData.add(temp);
        }

        // список атрибутов групп для чтения
        String groupFrom[] = new String[] { "groupName" };
        // список ID view-элементов, в которые будет помещены аттрибуты групп
        int groupTo[] = new int[] { android.R.id.text1 };

        // создаем коллекцию для коллекций элементов
        childData = new ArrayList<ArrayList<Map<String, String>>>();

        for (String[] season: allMonths) {
            childDataItem = new ArrayList<Map<String, String>>();
            for (String month : season) {
                temp = new HashMap<String, String>();
                temp.put("monthName", month);
                childDataItem.add(temp);
            }
            childData.add(childDataItem);
        }

//        //1)
//        // создаем коллекцию элементов для первой группы
//        childDataItem = new ArrayList<Map<String, String>>();
//        // заполняем список аттрибутов для каждого элемента
//        for (String month : winterMonths) {
//            temp = new HashMap<String, String>();
//            temp.put("monthName", month); // название месяца
//            childDataItem.add(temp);
//        }
//        // добавляем в коллекцию коллекций
//        childData.add(childDataItem);
//
//        //2)
//        // создаем коллекцию элементов для второй группы
//        childDataItem = new ArrayList<Map<String, String>>();
//        for (String month : springMonths) {
//            temp = new HashMap<String, String>();
//            temp.put("monthName", month);
//            childDataItem.add(temp);
//        }
//        childData.add(childDataItem);
//
//        //3)
//        // создаем коллекцию элементов для третьей группы
//        childDataItem = new ArrayList<Map<String, String>>();
//        for (String month : summerMonths) {
//            temp = new HashMap<String, String>();
//            temp.put("monthName", month);
//            childDataItem.add(temp);
//        }
//        childData.add(childDataItem);
//
//        //4)
//        // создаем коллекцию элементов для четвертой группы
//        childDataItem = new ArrayList<Map<String, String>>();
//        for (String month : autumnMonths) {
//            temp = new HashMap<String, String>();
//            temp.put("monthName", month);
//            childDataItem.add(temp);
//        }
//        childData.add(childDataItem);

        // список аттрибутов элементов для чтения

        String childFrom[] = new String[] { "monthName" };
        // список ID view-элементов, в которые будет помещены аттрибуты
        // элементов
        int childTo[] = new int[] { android.R.id.text1 };

        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
                this, groupData,
                android.R.layout.simple_expandable_list_item_1, groupFrom,
                groupTo, childData, android.R.layout.simple_list_item_2,
                childFrom, childTo);

        expListView = (ExpandableListView) findViewById(R.id.expListView);
        expListView.setAdapter(adapter);
    }
}
