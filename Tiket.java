package PraktikumSatu;

public class Tiket {
    int nomorTiket;
    Film film;
    Studio studio;
    int nomorKursi;
    int hargaTiket;
    Penonton pembeli;

    public Tiket(int nomorTiket, Film film, Studio studio, int nomorKursi, Penonton pembeli) {
        this.nomorTiket = nomorTiket;
        this.film = film;
        this.studio = studio;
        this.nomorKursi = nomorKursi;
        this.pembeli = pembeli;
        this.hargaTiket = film.hargaTiket;
    }

    public void displayInfo() {
        System.out.println("No. Tiket    : #" + nomorTiket);
        System.out.println("Nama Penonton: " + pembeli.namaPenonton);
        System.out.println("Film         : " + film.judul);
        System.out.println("Genre        : " + film.genre);
        System.out.println("Jam Tayang   : " + film.jamTayang);
        System.out.println("Studio       : " + studio.nomorStudio);
        System.out.println("No. Kursi    : " + nomorKursi);
        System.out.println("Harga Tiket  : Rp " + hargaTiket);
    }
}
