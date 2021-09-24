package com.example.pruebalab;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CategoriaAdapter extends RecyclerView.Adapter<CategoriaAdapter.CategoriaViewHolder> {
    private List<Categoria> listaCategorias;
    ActivityCategoria activityCategoria;

    public CategoriaAdapter(List<Categoria> listaCategorias, ActivityCategoria activityCategoria) {
        this.listaCategorias = listaCategorias;
        this.activityCategoria = activityCategoria;
    }

    @Override
    public CategoriaViewHolder onCreateViewHolder(ViewGroup pr, int tipo) {
        View view = LayoutInflater.from(pr.getContext()).inflate(R.layout.fila_cat,pr,false);
        CategoriaViewHolder categoriaViewHolder =  new CategoriaViewHolder(view);
        categoriaViewHolder.adapter=this;
        return categoriaViewHolder;
    }
    @Override
    public void onBindViewHolder(CategoriaViewHolder categoriaHolder, final int position) {
        Categoria categoria = listaCategorias.get(position);
        categoriaHolder.nombreCategoria.setText(categoria.nombre);
        categoriaHolder.nombreCategoria.setTag(position);
        //categoriaHolder.cardCategoria.setCardBackgroundColor(categoria.color);
        categoriaHolder.cardCategoria.setCardBackgroundColor(Color.parseColor(categoria.color));
    }
    @Override
    public int getItemCount() {return listaCategorias.size();}

    private void devolverCategoria(final int position) {
        Intent intent = new Intent();
        intent.putExtra("id",listaCategorias.get(position).id);
        intent.putExtra("nombre",listaCategorias.get(position).nombre);
        intent.putExtra("color",listaCategorias.get(position).color);
        activityCategoria.setResult(Activity.RESULT_OK,intent);
        activityCategoria.finish();
    }

    public static class CategoriaViewHolder extends RecyclerView.ViewHolder{
        CategoriaAdapter adapter;
        CardView cardCategoria;
        TextView nombreCategoria;

        public CategoriaViewHolder(View view) {
            super(view);
            cardCategoria = view.findViewById(R.id.cardCategoria);
            nombreCategoria = view.findViewById(R.id.nombreCategoria);
            this.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    adapter.devolverCategoria((int)nombreCategoria.getTag());
                }
            });
        }

    }

}
