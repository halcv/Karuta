package org.h_naka.karuta;
import java.util.List;
import java.util.ArrayList;
import android.content.SharedPreferences;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.CheckBox;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class KarutaList implements OnClickListener,OnItemClickListener {

    private final int LIST_MAX = 100;
    private MainActivity m_activity;
    private KarutaAdapter m_adapter;
    private List<KarutaData> m_list;
    private boolean m_isAuthor;
    private boolean m_isTop;
    private boolean m_isBottom;
    private boolean m_isKimariji;
    
    public KarutaList(MainActivity activity) {
        m_activity = activity;
        m_list = new ArrayList<KarutaData>();
        m_adapter = new KarutaAdapter(m_activity,-1,m_list);
        m_activity.getListView().setAdapter(m_adapter);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
        case R.id.authorCheck:
            m_isAuthor = ((CheckBox)v).isChecked();
            break;
        case R.id.topCheck:
            m_isTop = ((CheckBox)v).isChecked();
            break;
        case R.id.bottomCheck:
            m_isBottom = ((CheckBox)v).isChecked();
            break;
        case R.id.kimarijiCheck:
            m_isKimariji = ((CheckBox)v).isChecked();
            break;
        }
        m_adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent,View v,int pos,long id) {
        if (v.getId() == R.id.listLayout) {
            selectItem(pos);
        }
    }
    
    private void addKaruta(KarutaData karuta) {
        m_adapter.add(karuta);
    }

    public void initKaruta(boolean author,boolean top,boolean bottom,boolean kimariji) {
        m_isAuthor = author;
        m_isTop = top;
        m_isBottom = bottom;
        m_isKimariji = kimariji;

        boolean [] isLearn = new boolean[LIST_MAX];
        setSavedLearnState(isLearn);
        
        String [] data = m_activity.getResources().getStringArray(R.array.karutaList);
        for (int i = 0;i < data.length;i++) {
            String [] karuta = data[i].split(",");
            addKaruta(new KarutaData(karuta[6],karuta[1],karuta[3],karuta[5],isLearn[i]));
        }
    }

    private void setSavedLearnState(boolean [] isLearn) {
        SharedPreferences  sp = m_activity.getSharedPreferences();
        for (int i = 0;i < LIST_MAX;i++) {
            String temp = "learn" + Integer.toString(i);
            isLearn[i] = sp.getBoolean(temp,false);
        }
    }
    
    public boolean isAuthorCheck() {
        return m_isAuthor;
    }

    public boolean isTopCheck() {
        return m_isTop;
    }

    public boolean isBottomCheck() {
        return m_isBottom;
    }

    public boolean isKimarijiCheck() {
        return m_isKimariji;
    }

    private void selectItem(int pos) {
        KarutaData data = m_adapter.getItem(pos);
        m_activity.goDetailActivity(pos,data.getIsLearn());
    }

    public void setLearnState(int pos,boolean isLearn) {
        KarutaData data = m_adapter.getItem(pos);
        data.setIsLearn(isLearn);
        m_adapter.notifyDataSetChanged();
    }
}
