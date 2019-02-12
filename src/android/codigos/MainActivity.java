package android.codigos;

import android.app.Activity;
import android.codigos.objetos.ItemListView;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends Activity implements OnItemClickListener {

    private ListView listView;
    private AdapterListView adapterListView;
    private ArrayList<ItemListView> itens;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //carrega o layout onde contem o ListView
        setContentView(R.layout.main);

        //Pega a referencia do ListView
        listView = (ListView) findViewById(R.id.list);
        //Define o Listener quando alguem clicar no item.
        listView.setOnItemClickListener(this);

        createListView();
    }

    private void createListView() {
        //Criamos nossa lista que preenchera o ListView
        itens = new ArrayList<ItemListView>();
        ItemListView item1 = new ItemListView("Guilherme Biff", R.drawable.biff);
        ItemListView item2 = new ItemListView("Lucas Volgarini", R.drawable.volgarini);
        ItemListView item3 = new ItemListView("Eduardo Ricoldi", R.drawable.ricoldi);
        ItemListView item4 = new ItemListView("Felipe Panngo", R.drawable.panngo);

        itens.add(item1);
        itens.add(item2);
        itens.add(item3);
        itens.add(item4);

        //Cria o adapter
        adapterListView = new AdapterListView(this, itens);

        //Define o Adapter
        listView.setAdapter(adapterListView);
        //Cor quando a lista é selecionada para ralagem.
        listView.setCacheColorHint(Color.TRANSPARENT);
    }

    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        //Pega o item que foi selecionado.
        ItemListView item = adapterListView.getItem(arg2);
        //Demostração
        Toast.makeText(this, "Você Clicou em: " + item.getTexto(), Toast.LENGTH_LONG).show();
    }
}
