package com.example.yourdestination.ui.favourites;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yourdestination.R;
import com.example.yourdestination.ui.destination.DestinationModel;

import java.util.ArrayList;
import java.util.List;

public class FavouritesFragment extends Fragment {

    //    private DestinationViewModel galleryViewModel;
    FavouriteAdapterClass destinationAdapterClass;
    List<DestinationModel> destinationModelClassList;
    RecyclerView placeListRecyclerView;
    View root;

    String[] items = {"rara Lake", "Tilicho Lake", "Poon Hill", "Mardi Himal", "Annapurna Base Camp",
            "Gosaikunda", "Lumbini", "Pokhara", "Illam Tea Garden", "Palpa"};
    int[] img = {R.drawable.rara,R.drawable.tilicholake, R.drawable.poonhill,
            R.drawable.mardihimal, R.drawable.annapurna,R.drawable.gosaikunda, R.drawable.lumbini, R.drawable.pokhara,
            R.drawable.illamtea, R.drawable.palpa};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
       /* galleryViewModel =
                ViewModelProviders.of(this).get(DestinationViewModel.class);*/
        root = inflater.inflate(R.layout.fragment_destination, container, false);
        placeListRecyclerView = root.findViewById(R.id.list_view);

        destinationModelClassList = new ArrayList<>();

        for (int i = 0; i < img.length; i++) {
            destinationModelClassList.add(new DestinationModel(items[i], img[i]));
        }


        destinationAdapterClass = new FavouriteAdapterClass(getActivity(), destinationModelClassList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        placeListRecyclerView.setLayoutManager(layoutManager);
        placeListRecyclerView.setHasFixedSize(true);
        placeListRecyclerView.setAdapter(destinationAdapterClass);
        destinationAdapterClass.notifyDataSetChanged();


//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,items);
//        placelist.setAdapter(adapter);

//        placelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                Toast.makeText(getActivity(),"Selected",Toast.LENGTH_SHORT).show();
//            }
//        });
        /*galleryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                placelist.setText(s);
            }
        });*/
        return root;
    }
}