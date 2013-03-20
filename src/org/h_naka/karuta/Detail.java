package org.h_naka.karuta;

public class Detail {
    private DetailActivity m_activity;
    private int m_position;
    public Detail(DetailActivity activity,int pos) {
        m_activity = activity;
        m_position = pos;
    }

    public void dispKarutaDetail() {
        if (m_position != -1) {
            String [] data = m_activity.getResources().getStringArray(R.array.karutaList);
            String [] karuta = data[m_position].split(",");

            String out;
            out = "【" + m_activity.getResources().getString(R.string.author) + "】";
            m_activity.getAuthor1TextView().setText(out);

            out = karuta[6] + "\n" + "（" + karuta[7] + "）";
            m_activity.getAuthor2TextView().setText(out);

            out = "【" + m_activity.getResources().getString(R.string.top) + "】";
            m_activity.getTop1TextView().setText(out);

            out = karuta[0] + "\n" + "（" + karuta[1] + "）";
            m_activity.getTop2TextView().setText(out);

            out = "【" + m_activity.getResources().getString(R.string.bottom) + "】";
            m_activity.getBottom1TextView().setText(out);

            out = karuta[2] + "\n" + "（" + karuta[3] + "）";
            m_activity.getBottom2TextView().setText(out);
            
            out = "【" + m_activity.getResources().getString(R.string.kimariji) + "】";
            m_activity.getKimariji1TextView().setText(out);
            
            out = karuta[5];
            m_activity.getKimariji2TextView().setText(out);
            
            out = "【" + m_activity.getResources().getString(R.string.translation) + "】";
            m_activity.getTranslation1TextView().setText(out);

            out = karuta[4];
            m_activity.getTranslation2TextView().setText(out);
        }
    }
}
