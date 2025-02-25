package Praktikum1;

import java.util.Scanner;

public class Mainnyoba {
    public static void main(String[] args) {
        Scanner sytr = new Scanner(System.in);
        int jumlahPenonton;

        // Membuat objek Film
        Film film1 = new Film("13 Bom di Jakarta", "Action", "10:00", 55000);
        Film film2 = new Film("Wicked", "Fantasy", "15:00", 60000);
        Film film3 = new Film("John Wick", "Crime", "20:00", 55000);

        // Membuat objek Studio
        Studio studio1 = new Studio(1, 60, film1);
        Studio studio2 = new Studio(2, 60, film2);
        Studio studio3 = new Studio(3, 60, film3);

        // Memasukkan jumlah penonton
        System.out.print("Masukkan jumlah penonton: ");
        while (true) {
            jumlahPenonton = sytr.nextInt();
            sytr.nextLine();
            if (jumlahPenonton > 0) break;
            System.out.println("Jumlah penonton harus lebih dari 0. Coba lagi!");
            System.out.print("Masukkan jumlah penonton: ");
        }

        // Array untuk menyimpan data penonton dan tiket
        Penonton[] daftarPenonton = new Penonton[jumlahPenonton];
        Tiket[] daftarTiket = new Tiket[jumlahPenonton];

        for (int i = 0; i < jumlahPenonton; i++) {
            System.out.print("\nMasukkan nama penonton ke-" + (i + 1) + ": ");
            String namaPenonton = sytr.nextLine();
            daftarPenonton[i] = new Penonton(namaPenonton);

            System.out.println("\nPilih film:");
            System.out.println("1. 13 Bom di Jakarta");
            System.out.println("2. Wicked");
            System.out.println("3. John Wick");
            System.out.print("Pilihan: ");
            int pilihFilm = sytr.nextInt();
            sytr.nextLine();

            Film filmPilih;
            Studio studioPilih;

            switch (pilihFilm) {
                case 1:
                    filmPilih = film1;
                    studioPilih = studio1;
                    break;
                case 2:
                    filmPilih = film2;
                    studioPilih = studio2;
                    break;
                case 3:
                    filmPilih = film3;
                    studioPilih = studio3;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Default ke 13 Bom di Jakarta.");
                    filmPilih = film1;
                    studioPilih = studio1;
            }

            System.out.print("\nMasukkan nomor kursi: ");
            int nomorKursi = sytr.nextInt();
            sytr.nextLine();

            while (nomorKursi <= 0 || nomorKursi > studioPilih.kapasitasKursi) {
                System.out.println("Nomor kursi di luar jangkauan!.");
                System.out.print("Masukkan nomor kursi: ");
                nomorKursi = sytr.nextInt();
                sytr.nextLine();
            }

            daftarTiket[i] = new Tiket(i + 1, filmPilih, studioPilih, nomorKursi, daftarPenonton[i]);
        }

        int totalHarga = 0;
        System.out.println("\n====== Daftar Tiket yang Dibeli ======");
        for (int i = 0; i < jumlahPenonton; i++) {
            daftarTiket[i].displayInfo();
            System.out.println("---------------------------------------");
            totalHarga += daftarTiket[i].hargaTiket;
        }

        System.out.println("Total harga tiket: Rp " + totalHarga);
        sytr.close();
    }
 {
    
}
}
