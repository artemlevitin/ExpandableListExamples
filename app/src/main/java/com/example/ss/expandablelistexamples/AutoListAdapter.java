package com.example.ss.expandablelistexamples;
 
import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AutoListAdapter extends BaseExpandableListAdapter
{
	public Context context;
    private LayoutInflater vi;
    Garage garage;
    
    public AutoListAdapter(Context context, Activity activity, Garage garage) 
    {
        this.context = context;
        this.garage = garage;
        vi = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    
    public void addCompany(String title, int imageId)
    {
        garage.addCompany(new Company(title, imageId));
        this.notifyDataSetChanged();
    }

    @Override
    public String getChild(int groupPosition, int childPosition) {
        Car car = garage.companies.get(groupPosition).cars.get(childPosition);
        return car.model;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return garage.companies.get(groupPosition).cars.size();
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) 
    {
    		View resultView = vi.inflate(R.layout.child_item, null);
    		TextView text = (TextView)resultView.findViewById(R.id.text1);
    		ImageView imageView = (ImageView)resultView.findViewById(R.id.image1);
    		
    		Car car = garage.companies.get(groupPosition).cars.get(childPosition);
    		text.setText(car.model);
    		imageView.setImageResource(car.imageId);

    		return resultView;
    }

    @Override
    public String getGroup(int groupPosition) {
        return garage.companies.get(groupPosition).title;
    }

    @Override
    public int getGroupCount() {
        return garage.companies.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) 
    {
    	View resultView = vi.inflate(R.layout.group_item, null);
		TextView text = (TextView)resultView.findViewById(R.id.text1);
		ImageView imageView = (ImageView)resultView.findViewById(R.id.image1);
		
		Company company = garage.companies.get(groupPosition);
		
		text.setText(company.title);
		imageView.setImageResource(company.imageId);

		return resultView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

} 