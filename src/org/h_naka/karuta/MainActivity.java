package org.h_naka.karuta;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.ListView;
import android.widget.CheckBox;
import android.content.SharedPreferences;

public class MainActivity extends Activity {

    private final int REQUEST_CODE = 100;
    
    private ListView m_listView;
    private KarutaList m_karutaList;
    private CheckBox m_authorCheck;
    private CheckBox m_topCheck;
    private CheckBox m_bottomCheck;
    private CheckBox m_kimarijiCheck;
    private int m_position;
    
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

        initInstance();
        initInterface();
        
        m_karutaList.initKaruta(m_authorCheck.isChecked(),
                                m_topCheck.isChecked(),
                                m_bottomCheck.isChecked(),
                                m_kimarijiCheck.isChecked());
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data) {
        if (requestCode == REQUEST_CODE) {
            boolean isLearn = data.getBooleanExtra("LEARN",false);
            saveLearnState(m_position,isLearn);
            m_karutaList.setLearnState(m_position,isLearn);
        }
    }
    
    private void initInstance() {
        m_listView = (ListView)findViewById(R.id.listView);
        m_listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);         
        m_karutaList = new KarutaList(this);
        m_authorCheck = (CheckBox)findViewById(R.id.authorCheck);
        m_topCheck = (CheckBox)findViewById(R.id.topCheck);
        m_bottomCheck = (CheckBox)findViewById(R.id.bottomCheck);
        m_kimarijiCheck = (CheckBox)findViewById(R.id.kimarijiCheck);
    }

    private void initInterface() {
        m_authorCheck.setOnClickListener(m_karutaList);
        m_topCheck.setOnClickListener(m_karutaList);
        m_bottomCheck.setOnClickListener(m_karutaList);
        m_kimarijiCheck.setOnClickListener(m_karutaList);
        m_listView.setOnItemClickListener(m_karutaList);
    }
    
    public ListView getListView() {
        return m_listView;
    }

    public KarutaList getKarutaList() {
        return m_karutaList;
    }

    public void goDetailActivity(int pos,boolean isLearn) {
        m_position = pos;
        Intent intent = new Intent(this,DetailActivity.class);
        intent.putExtra("POSITION",pos);
        intent.putExtra("LEARN",isLearn);
        startActivityForResult(intent,REQUEST_CODE);
    }

	public SharedPreferences  getSharedPreferences(){
		SharedPreferences sp = getSharedPreferences("Karuta",MODE_PRIVATE);
		return sp;
	}

	private void saveLearnState(int pos,boolean isLearn) {
		SharedPreferences sp = getSharedPreferences("Karuta",MODE_PRIVATE);
		SharedPreferences.Editor editor = sp.edit();
        String temp = "learn" + Integer.toString(pos);
        editor.putBoolean(temp,isLearn);
		editor.commit();
	}
}
