package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    private  String[] titles={"桌子","苹果","蛋糕","线衣","猕猴桃","围巾"};
    private  String[] prices={"1800kg","10元/kg","300元","350元","10元/kg","280元"};
    private int[] icons={
            R.drawable.table,R.drawable.apple,R.drawable.cake,
            R.drawable.wireclothes,R.drawable.kiwifruit,R.drawable.scarf};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initData();
        initView();



    }

    private void initView() {
        RecyclerView lv_Goods=findViewById(R.id.lv_goods);
        lv_Goods.setLayoutManager(new LinearLayoutManager(this));
        lv_Goods.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        MyAdapter adapter=new MyAdapter(goods);
        lv_Goods.setAdapter(adapter);
        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Goods good=goods.get(position);
                Toast.makeText(RecyclerViewActivity.this,good.toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
//        lv_Goods.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//            @Override
//            public void onItemClick(AdapterView<?>parent, View view, int position, long id){
//                Goods good=(Goods)parent.getItemAtPosition(position);
//                Toast.makeText(RecyclerViewActivity.this,good.toString(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }
    private List<Goods> goods;
    private void initData(){
        goods = new ArrayList<>();
        for (int i=0;i<titles.length;i++){
            goods.add(new Goods(titles[i],prices[i],icons[i]));
        }


    }
}
