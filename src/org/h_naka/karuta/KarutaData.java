package org.h_naka.karuta;

public class KarutaData {
    private String m_author;
    private String m_top;
    private String m_bottom;
    private String m_kimariji;
    private boolean m_isLearn;
    
    public KarutaData(String author,String top,String bottom,String kimariji,boolean isLearn) {
        m_author = author;
        m_top = top;
        m_bottom = bottom;
        m_kimariji = kimariji;
        m_isLearn = isLearn;
    }

    public void setAuthor(String author) {
        m_author = author;
    }

    public String getAuthor() {
        return m_author;
    }

    public void setTop(String top) {
        m_top = top;
    }

    public String getTop() {
        return m_top;
    }

    public void setBottom(String bottom) {
        m_bottom = bottom;
    }

    public String getBottom() {
        return m_bottom;
    }

    public void setKimariji(String kimariji) {
        m_kimariji = kimariji;
    }

    public String getKimariji() {
        return m_kimariji;
    }

    public void setIsLearn(boolean isLearn) {
        m_isLearn = isLearn;
    }

    public boolean getIsLearn() {
        return m_isLearn;
    }
}
