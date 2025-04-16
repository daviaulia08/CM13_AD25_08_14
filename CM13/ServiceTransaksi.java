package CM13;

[11.26, 16/4/2025] davi TI: public class ServiceTransaksi {
    Transaksi[] list;
    int idx;

    ServiceTransaksi(int capacity) {
        list = new Transaksi[capacity];
        idx = 0;
    }

    void tambah(Transaksi t) {
        if (idx < list.length) {
            list[idx++] = t;
        }
    }

    void tampil() {
        for (int i = 0; i < idx; i++) {
            list[i].tampilDataTransaksi();
        }
    }

    void cariEmail(String email, Bank[] banks) {
        for (int i = 0; i < idx; i++) {
            for (Bank b : banks) {
                if (list[i].norek.equals(b.norek) && b.email.equalsIgnoreCase(email)) {
                    list[i].tampilDataTransaksi();
                }
            }
        }
    }

    void tampilMaxDebitKredit() {
        if (idx == 0) return;
        Transaksi result = list[0];
        for (int i = 1; i < idx; i++) {
            if (list[i].debitKredit > result.debitKredit) {
                result = list[i];
            }
        }
        System.out.println("Kode Transaksi  : " + result.kodeTransaksi);
        System.out.println("No Rekening      : " + result.norek);
        System.out.println("Saldo            : " + result.saldo);
        System.out.println("Debit/Kredit     : " + result.debitKredit);
        System.out.println("Saldo Akhir      : " + result.finalSaldo);
        System.out.println("Tanggal Transaksi: " + result.tanggal);
        System.out.println("Type             : " + result.tipe);
    }

    void sortFinalSaldoAsc() {
        for (int i = 0; i < idx - 1; i++) {
            for (int j = 0; j < idx - i - 1; j++) {
                if (list[j].finalSaldo > list[j + 1].finalSaldo) {
                    Transaksi temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    void hitungFinalSaldo() {
        for (int i = 0; i < idx; i++) {
            if (list[i].tipe.equalsIgnoreCase("Kredit")) {
                list[i].finalSaldo = list[i].saldo + list[i].debitKredit;
            } else if (list[i].tipe.equalsIgnoreCase("Debit")) {
                list[i].finalSaldo = list[i].saldo - list[i].debitKredit;
            }
        }
    }
}


