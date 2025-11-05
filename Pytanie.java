package com.example.pytania;


import com.google.gson.annotations.SerializedName;

public class Pytanie {
    @SerializedName("pytanie")
    String pytanie;
    @SerializedName("odp1")
    String odpowiedz1;
    @SerializedName("odp2")
    String odpowiedz2;
    @SerializedName("odp3")
    String odpowiedz3;
    @SerializedName("ok")

    String ok;

    public Pytanie(String pytanie, String odpowiedz1, String odpowiedz2, String odpowiedz3, String ok) {
        this.pytanie = pytanie;
        this.odpowiedz1 = odpowiedz1;
        this.odpowiedz2 = odpowiedz2;
        this.odpowiedz3 = odpowiedz3;
        this.ok = ok;
    }

    public String getPytanie() {
        return pytanie;
    }

    public void setPytanie(String pytanie) {
        this.pytanie = pytanie;
    }

    public String getOdpowiedz1() {
        return odpowiedz1;
    }

    public void setOdpowiedz1(String odpowiedz1) {
        this.odpowiedz1 = odpowiedz1;
    }

    public String getOdpowiedz2() {
        return odpowiedz2;
    }

    public void setOdpowiedz2(String odpowiedz2) {
        this.odpowiedz2 = odpowiedz2;
    }

    public String getOdpowiedz3() {
        return odpowiedz3;
    }

    public void setOdpowiedz3(String odpowiedz3) {
        this.odpowiedz3 = odpowiedz3;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }
}
