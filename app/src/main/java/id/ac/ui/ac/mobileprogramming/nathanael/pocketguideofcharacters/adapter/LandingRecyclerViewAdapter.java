package id.ac.ui.ac.mobileprogramming.nathanael.pocketguideofcharacters.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.ac.ui.ac.mobileprogramming.nathanael.pocketguideofcharacters.R;
import id.ac.ui.ac.mobileprogramming.nathanael.pocketguideofcharacters.activities.ViewCharacterActivity;
import id.ac.ui.ac.mobileprogramming.nathanael.pocketguideofcharacters.holder.LandingCardViewHolder;
import id.ac.ui.ac.mobileprogramming.nathanael.pocketguideofcharacters.models.TheCharacter;

public class LandingRecyclerViewAdapter extends RecyclerView.Adapter<LandingCardViewHolder> {


    private Context context;
    private List<TheCharacter> characterList;

    public LandingRecyclerViewAdapter(Context context, List<TheCharacter> characterList) {
        this.context = context;
        this.characterList = characterList;
    }

    @NonNull
    @Override
    public LandingCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.single_card, parent, false);
        return new LandingCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LandingCardViewHolder holder, final int position) {
        holder.age_placement.setText(characterList.get(position).getAge());
        holder.name_placement.setText(characterList.get(position).getName());
        holder.the_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ViewCharacterActivity.class);
                intent.putExtra("id", characterList.get(position).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return characterList.size();
    }
}
