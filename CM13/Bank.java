package CM13;


public class Bank {

    String norek;
    String nama;
    String namaIbu;
    String nohp;
    String email;

    public Bank() {

    }

    public Bank(String norek, String nama, String namaIbu, String nohp, String email) {
        this.norek = norek;
        this.nama = nama;
        this.namaIbu = namaIbu;
        this.nohp = nohp;
        this.email = email;
    }

    void tampilDataNorek() {
        System.out.printf("%-15s %-10s %-10s %-17s %-20s\n", norek, nama, namaIbu, nohp, email);
    }

}