package com.example.ss.expandablelistexamples;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ExpandableListView;

public class CustomExpandableListViewActivity extends Activity {
    private ExpandableListView exListView;

    Garage garage = createGarage();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_expandable_list_view);

        exListView = findViewById(R.id.expandableListView1);
        AutoListAdapter adapter = new AutoListAdapter(this, this, garage);
        exListView.setAdapter(adapter);

        adapter.addCompany("VW", R.drawable.volkswagen_64);
    }

    private Garage createGarage() {
        Garage garage = new Garage();

        Company audi = new Company("Audi", R.drawable.audi_64);
        audi.addCar(new Car("A4", R.drawable.a4));
        audi.addCar(new Car("A6", R.drawable.a6));
        audi.addCar(new Car("A8", R.drawable.a8));
        garage.addCompany(audi);

        Company mercedes = new Company("Mercedes", R.drawable.mercedes_benz_64);
        mercedes.addCar(new Car("S 600", R.drawable.s600));
        mercedes.addCar(new Car("E 350", R.drawable.e350));
        mercedes.addCar(new Car("C 200", R.drawable.c200));
        garage.addCompany(mercedes);

        Company toyota = new Company("Toyota", R.drawable.toyota_64);
        toyota.addCar(new Car("Camry", R.drawable.camry));
        toyota.addCar(new Car("Corolla", R.drawable.corolla));
        toyota.addCar(new Car("Celica", R.drawable.celica));
        garage.addCompany(toyota);

        Company honda = new Company("Honda", R.drawable.honda_64);
        honda.addCar(new Car("Accord", R.drawable.accord));
        honda.addCar(new Car("Civic", R.drawable.civic));
        garage.addCompany(honda);

        return garage;
    }
}
