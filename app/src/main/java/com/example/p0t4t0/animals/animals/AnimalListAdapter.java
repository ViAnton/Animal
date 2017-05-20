package com.example.p0t4t0.animals.animals;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.p0t4t0.animals.R;

import java.util.ArrayList;
import java.util.List;

public class AnimalListAdapter extends BaseAdapter {

    private List<Animal> mAnimals;

    public AnimalListAdapter() {
        this.mAnimals = new ArrayList<>();
    }

    public void setAnimals(List<Animal> list) {
        mAnimals.clear();
        mAnimals.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mAnimals.size();
    }

    @Override
    public Animal getItem(int position) {
        return mAnimals.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;

        if (itemView == null) {
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.animal_list_item,
                            parent, false);

            itemView.setTag(new ViewHolder(itemView));
        }

        bindView(itemView, position);
        return itemView;
    }

    private void bindView(View itemView, int position) {
        ViewHolder holder = (ViewHolder) itemView.getTag();
        Animal animal = mAnimals.get(position);

        holder.mAnimalSpies.setText(animal.getSpies());
        holder.mAnimalWeight.setText(String.valueOf(animal.getWeight()));
        holder.mAnimalName.setText(animal.getName());
    }

    private static class ViewHolder {
        TextView mAnimalSpies;
        TextView mAnimalName;
        TextView mAnimalWeight;

        ViewHolder(View view) {
            mAnimalSpies = (TextView) view.findViewById(R.id.animal_spies);
            mAnimalName = (TextView) view.findViewById(R.id.animal_name);
            mAnimalWeight = (TextView) view.findViewById(R.id.animal_weight);
        }
    }
}
