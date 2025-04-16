package CM13;

public class Tarnsaksi {
    String kodeTransaksi, norek, tanggal, tipe;
    double saldo, debitKredit, finalSaldo;

    Transaksi(String kodeTransaksi, String norek, double saldo, double debitKredit, double finalSaldo, String tanggal, String tipe) {
        this.kodeTransaksi = kodeTransaksi;
        this.norek = norek;
        this.saldo = saldo;
        this.debitKredit = debitKredit;
        this.finalSaldo = finalSaldo;
        this.tanggal = tanggal;
        this.tipe = tipe;
    }

    void tampilDataTransaksi() {
        System.out.printf("%-10s %-15s %-10.1f %-13.1f %-12.1f %-15s %-10s\n", 
            kodeTransaksi, norek, saldo, debitKredit, finalSaldo, tanggal, tipe);
    }
}


