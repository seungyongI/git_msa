package org.example.domain;

import java.util.Date;

public class Movie {
    private int M_id;
    private String M_name;
    private String genre;
    private Date release_date;
    private String Synopsis;

    public Movie(int m_id, String m_name, String genre, Date release_date, String synopsis) {
        M_id = m_id;
        M_name = m_name;
        this.genre = genre;
        this.release_date = release_date;
        Synopsis = synopsis;
    }

    public int getM_id() {
        return M_id;
    }

    public void setM_id(int m_id) {
        M_id = m_id;
    }

    public String getM_name() {
        return M_name;
    }

    public void setM_name(String m_name) {
        M_name = m_name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public String getSynopsis() {
        return Synopsis;
    }

    public void setSynopsis(String synopsis) {
        Synopsis = synopsis;
    }
}