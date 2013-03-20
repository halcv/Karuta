package org.h_naka.karuta;

import java.util.List;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.CheckBox;

public class KarutaAdapter extends ArrayAdapter<KarutaData> {
    private LayoutInflater m_layoutInflater;
    private MainActivity m_activity;
    
	public KarutaAdapter(Context context, int textViewResourceId,List<KarutaData> objects) {
		super(context, textViewResourceId, objects);
        m_activity = (MainActivity)context;
        m_layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        if (convertView == null) {
            convertView = m_layoutInflater.inflate(R.layout.list,null);
        }

        KarutaData item = (KarutaData)getItem(position);

        TextView authorText = (TextView)convertView.findViewById(R.id.authorText);
        TextView topText = (TextView)convertView.findViewById(R.id.topText);
        TextView bottomText = (TextView)convertView.findViewById(R.id.bottomText);
        TextView kimarijiText = (TextView)convertView.findViewById(R.id.kimarijiText);
        CheckBox learnCheck = (CheckBox)convertView.findViewById(R.id.learnCheck);
        
        String out = "";
        if (m_activity.getKarutaList().isAuthorCheck()) {
            out = item.getAuthor();
        }
        authorText.setText(out);

        out = "";
        if (m_activity.getKarutaList().isTopCheck()) {
            out = item.getTop();
        }
        topText.setText(out);

        out = "";
        if (m_activity.getKarutaList().isBottomCheck()) {
            out = item.getBottom();
        }
        bottomText.setText(out);

        out = "";
        if (m_activity.getKarutaList().isKimarijiCheck()) {
            out = item.getKimariji();
        }
        kimarijiText.setText(out);

        learnCheck.setChecked(item.getIsLearn());
        
        return convertView;
    }

}
