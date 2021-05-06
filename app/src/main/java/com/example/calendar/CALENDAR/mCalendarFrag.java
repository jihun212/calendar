package com.example.calendar.CALENDAR;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.calendar.R;


public class mCalendarFrag extends Fragment {

    //public static final int REQUEST_CODE_MENU = 101;
    private int year;
    private int month;
    String[] items;

    mCalendarFrag(int y, int m) {
        year = y;
        month = m;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View calView = inflater.inflate(R.layout.fragment_m_calendar, container, false);

        CalendarData cal = new CalendarData();  // 달력 데이터 객체 생성
        cal.setCalendar(year, month); // 주어진 년,월 데이터를 토대로 객체에 달력 데이터 주입

        items = cal.StringConverter(); // 생성된 달력 데이터를 문자열 배열에 삽입


        GridView gView = calView.findViewById(R.id.mCalendarGridView);// calView 에 들어갈 그리드뷰 생성
        CalendarBaseAdapter adapt = new CalendarBaseAdapter(getActivity(),android.R.layout.simple_list_item_1,items);// base 어댑터 생성

        gView.setAdapter(adapt);// 그리드뷰에 어댑터 적용

//        gView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View v,
//                                    int position, long id) {
//                if(items[position].equals("")){}    //터치한 부분이 빈칸일 경우 아무 행동도 하지 않게 함
//                else {
//                    String mon_STR = (month < 10 ? "0" + month : "" + month);
//                    String dat_STR = (Integer.parseInt(items[position]) < 10 ? "0" + items[position] : items[position]);
//
//                    String Key = year + mon_STR + dat_STR;
//                    Intent intent = new Intent(getActivity(), scheduleActivity.class);
//                    intent.putExtra("KeyDATA",Key);
//                    startActivityForResult(intent, REQUEST_CODE_MENU);
//                }
//            }
//        });

        return calView;// 최종적으로 해당 뷰를 반환
    }


}
