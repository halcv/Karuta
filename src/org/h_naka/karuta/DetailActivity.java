package org.h_naka.karuta;

import android.os.Bundle;
import android.content.Intent;
import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.CheckBox;
import android.view.View.OnClickListener;
import android.view.View;

public class DetailActivity extends Activity implements OnClickListener {

    private Button m_backButton;
    private TextView m_author1TextView;
    private TextView m_author2TextView;
    private TextView m_top1TextView;
    private TextView m_top2TextView;
    private TextView m_bottom1TextView;
    private TextView m_bottom2TextView;
    private TextView m_kimariji1TextView;
    private TextView m_kimariji2TextView;
    private TextView m_translation1TextView;
    private TextView m_translation2TextView;
    private CheckBox m_learnCheck;
    private Detail m_detail;
    private Intent m_intent;
    
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail);

        initInstance();
        setInterface();
        m_learnCheck.setChecked(getIntent().getBooleanExtra("LEARN",false));
        setResultParam();
        m_detail.dispKarutaDetail();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
        case R.id.backButton:
            setResultParam();
            finish();
            break;
        case R.id.learnCheck:
            setResultParam();
        }
    }
    
    private void initInstance() {
        m_intent = new Intent(this,MainActivity.class);
        m_backButton = (Button)findViewById(R.id.backButton);
        m_author1TextView = (TextView)findViewById(R.id.author1TextView);
        m_author2TextView = (TextView)findViewById(R.id.author2TextView);
        m_top1TextView = (TextView)findViewById(R.id.top1TextView);
        m_top2TextView = (TextView)findViewById(R.id.top2TextView);
        m_bottom1TextView = (TextView)findViewById(R.id.bottom1TextView);
        m_bottom2TextView = (TextView)findViewById(R.id.bottom2TextView);
        m_kimariji1TextView = (TextView)findViewById(R.id.kimariji1TextView);
        m_kimariji2TextView = (TextView)findViewById(R.id.kimariji2TextView);
        m_translation1TextView = (TextView)findViewById(R.id.translation1TextView);
        m_translation2TextView = (TextView)findViewById(R.id.translation2TextView);
        m_learnCheck = (CheckBox)findViewById(R.id.learnCheck);

        m_detail = new Detail(this,getIntent().getIntExtra("POSITION",-1));
    }
    
    private void setResultParam() {
        m_intent.putExtra("LEARN",m_learnCheck.isChecked());
        setResult(0,m_intent);
    }
    
    private void setInterface() {
        m_backButton.setOnClickListener(this);
        m_learnCheck.setOnClickListener(this);
    }

    public TextView getAuthor1TextView() {
        return m_author1TextView;
    }

    public TextView getAuthor2TextView() {
        return m_author2TextView;
    }

    public TextView getTop1TextView() {
        return m_top1TextView;
    }

    public TextView getTop2TextView() {
        return m_top2TextView;
    }

    public TextView getBottom1TextView() {
        return m_bottom1TextView;
    }

    public TextView getBottom2TextView() {
        return m_bottom2TextView;
    }

    public TextView getKimariji1TextView() {
        return m_kimariji1TextView;
    }

    public TextView getKimariji2TextView() {
        return m_kimariji2TextView;
    }

    public TextView getTranslation1TextView() {
        return m_translation1TextView;
    }

    public TextView getTranslation2TextView() {
        return m_translation2TextView;
    }
}
