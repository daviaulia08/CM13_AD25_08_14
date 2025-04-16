import java.util.Scanner;

public class MainBank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Bank[] nasabah = {
            new Bank("16030927", "Wallace", "Mei Mei", "082-458-264-3263", "wallace@gmail.com"),
            new Bank("16101617", "Darius", "Susanti", "081-357-843-0547", "darius@pt.org"),
            new Bank("16240401", "Fuller", "Rosalia", "085-556-712-7062", "fuller@mail.com"),
            new Bank("16275255", "Maria", "Krabela", "082-267-223-0234", "maria@gmail.com"),
            new Bank("16101617", "Gery", "Fatimah", "083-683-416-8323", "gery@gery.com")
        };

        ServiceTransaksi service = new ServiceTransaksi(10);
        service.tambah(new Transaksi("Tr001", "16030927", 500000, 100000, 400000, "23-04-2024", "Debit"));
        service.tambah(new Transaksi("Tr002", "16101617", 500000, 100000, 600000, "23-04-2024", "Kredit"));
        service.tambah(new Transaksi("Tr003", "16240401", 500000, 300000, 200000, "23-04-2024", "Debit"));
        service.tambah(new Transaksi("Tr004", "16275255", 500000, 150000, 650000, "23-04-2024", "Kredit"));
        service.tambah(new Transaksi("Tr005", "16101617", 500000, 200000, 700000, "23-04-2024", "Kredit"));

        int pilih;
        do {
            System.out.println("================POLINEMA BANK================");
            System.out.println("BANK MENU:");
            System.out.println("1. Data Norek");
            System.out.println("2. Data transaksi");
            System.out.println("3. Search Data by Email");
            System.out.println("4. Max Debit/Kredit");
            System.out.println("5. Sort by Final Saldo ASC");
            System.out.println("6. exit");
            System.out.print("Chose Menu(1-6): ");
            pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {
                case 1 -> {
                    System.out.printf("%-15s %-10s %-10s %-17s %-20s\n", "No Rekening", "Nama", "Nama Ibu", "Nohp", "email");
                    for (Bank b : nasabah) {
                        b.display();
                    }
                }
                case 2 -> {
                    System.out.printf("%-10s %-15s %-10s %-13s %-12s %-15s %-10s\n",
                        "Kode", "No Rekening", "Saldo", "Debit/Kredit", "final Saldo", "Tanggal Transaksi", "Type");
                    service.tampil();
                }
                case 3 -> {
                    System.out.print("Masukkan email yang dicari: ");
                    String email = sc.nextLine();
                    service.cariByEmail(email, nasabah);
                }
                case 4 -> {
                    System.out.println("Menampilkan Transaksi dengan Debit/Kredit Tertinggi:");
                    service.tampilMaxDebitKredit();
                }
                case 5 -> {
                    service.sortFinalSaldoAsc();
                    System.out.println("Data setelah diurutkan berdasarkan saldo akhir (ASC):");
                    System.out.printf("%-10s %-15s %-10s %-13s %-12s %-15s %-10s\n",
                        "Kode", "No Rekening", "Saldo", "Debit/Kredit", "final Saldo", "Tanggal Transaksi", "Type");
                    service.tampil();
                }
            }
        } while (pilih != 6);
    }
}
