import java.util.Scanner;

public class MainCinema {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int jumlahPenonton;

        // Membuat objek Film
        Film film1 = new Film("Superhero Returns", "Action", "10:00", 55000);
        Film film2 = new Film("Haunted Mansion", "Horror", "15:00", 60000);
        Film film3 = new Film("Love in Paris", "Romance", "20:00", 45000);

        // Membuat objek Studio
        Studio studio1 = new Studio(1, 60, film1);
        Studio studio2 = new Studio(2, 60, film2);
        Studio studio3 = new Studio(3, 60, film3);

        // Memasukkan jumlah penonton
        System.out.print("Masukkan jumlah penonton: ");
        while (true) {
            jumlahPenonton = input.nextInt();
            input.nextLine();
            if (jumlahPenonton > 0) break;
            System.out.println("Jumlah penonton harus lebih dari 0. Coba lagi!");
            System.out.print("Masukkan jumlah penonton: ");
        }

        // Array untuk menyimpan data penonton dan tiket
        Penonton[] daftarPenonton = new Penonton[jumlahPenonton];
        Tiket[] daftarTiket = new Tiket[jumlahPenonton];

        for (int i = 0; i < jumlahPenonton; i++) {
            System.out.print("\nMasukkan nama penonton ke-" + (i + 1) + ": ");
            String namaPenonton = input.nextLine();
            daftarPenonton[i] = new Penonton(namaPenonton);

            System.out.println("Pilih film yang ingin ditonton:");
            System.out.println("1. Superhero Returns");
            System.out.println("2. Haunted Mansion");
            System.out.println("3. Love in Paris");
            System.out.print("Pilihan: ");
            int pilihFilm = input.nextInt();
            input.nextLine();

            Film filmDipilih;
            Studio studioDipilih;

            switch (pilihFilm) {
                case 1:
                    filmDipilih = film1;
                    studioDipilih = studio1;
                    break;
                case 2:
                    filmDipilih = film2;
                    studioDipilih = studio2;
                    break;
                case 3:
                    filmDipilih = film3;
                    studioDipilih = studio3;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Default ke Superhero Returns.");
                    filmDipilih = film1;
                    studioDipilih = studio1;
            }

            System.out.print("Masukkan nomor kursi: ");
            int nomorKursi = input.nextInt();
            input.nextLine();

            while (nomorKursi <= 0 || nomorKursi > studioDipilih.kapasitasKursi) {
                System.out.println("Nomor kursi di luar jangkauan! Coba lagi.");
                System.out.print("Masukkan nomor kursi: ");
                nomorKursi = input.nextInt();
                input.nextLine();
            }

            daftarTiket[i] = new Tiket(i + 1, filmDipilih, studioDipilih, nomorKursi, daftarPenonton[i]);
        }

        int totalHarga = 0;
        System.out.println("\n====== Daftar Tiket yang Dibeli ======");
        for (int i = 0; i < jumlahPenonton; i++) {
            daftarTiket[i].displayInfo();
            System.out.println("----------------------------------------");
            totalHarga += daftarTiket[i].hargaTiket;
        }

        System.out.println("Total harga semua tiket: Rp " + totalHarga);
        input.close();
    }
 {
    
}
}
