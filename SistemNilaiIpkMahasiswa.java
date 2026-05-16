import java.util.ArrayList;

public class SistemNilaiIpkMahasiswa {

    static ArrayList<mahasiswa> data = new ArrayList
    static Scanner input = new Scanner(System.in);
    
    static void isiData() {

        data.add(new Mahasiswa("250101001", "Mamat", 3.6));
        data.add(new Mahasiswa("250101002", "Slamet", 3.2));
        data.add(new Mahasiswa("250101003", "Citra", 3.8));
        data.add(new Mahasiswa("250101004", "Dewi", 2.9));
        data.add(new Mahasiswa("250101005", "Eka", 3.4));
        data.add(new Mahasiswa("250101006", "Fajar", 3.7));
        data.add(new Mahasiswa("250101007", "Gina", 3.1));
        data.add(new Mahasiswa("250101008", "Hardi", 2.8));
        data.add(new Mahasiswa("250101009", "Indah", 3.9));
        data.add(new Mahasiswa("250101010", "Joko", 3.0));
        data.add(new Mahasiswa("250101011", "Kiki", 3.5));
        data.add(new Mahasiswa("250101012", "Lina", 3.3));
        data.add(new Mahasiswa("250101013", "Maya", 2.7));
        data.add(new Mahasiswa("250101014", "Nina", 3.6));
        data.add(new Mahasiswa("250101015", "Oki", 3.2));
        data.add(new Mahasiswa("250101016", "Putra", 3.8));
        data.add(new Mahasiswa("250101017", "Qori", 3.1));
        data.add(new Mahasiswa("250101018", "Rina", 2.9));
        data.add(new Mahasiswa("250101019", "Santi", 3.7));
        data.add(new Mahasiswa("250101020", "Tono", 3.4));
        data.add(new Mahasiswa("250101021", "Umar", 3.0));
        data.add(new Mahasiswa("250101022", "Vina", 3.6));
        data.add(new Mahasiswa("250101023", "Wawan", 3.2));
        data.add(new Mahasiswa("250101024", "Xena", 3.9));
        data.add(new Mahasiswa("250101025", "Yani", 2.8));
        data.add(new Mahasiswa("250101026", "Zaki", 3.5));
        data.add(new Mahasiswa("250101027", "Alya", 3.3));
        data.add(new Mahasiswa("250101028", "Bagas", 2.7));
        data.add(new Mahasiswa("250101029", "Abdul", 3.8));
        data.add(new Mahasiswa("250101030", "Yana", 3.1));
}
    // Tambahankan Data
    static void tambahData() {
        System.out.print("NPM: ");
        String npm = input.nextLine();
        System.out.print("Nama Lengkap: ");
        String nama = input.nextLine(); 
        System.out.print("IPK: ");
        double ipk = input.nextDouble();
        input.nextLine();

        data.add(new Mahasiswa(npm, nama, ipk));
        System.out.println("Data berhasil ditambahkan\n");
    }

    // Tampilkan Data
    static void tampilData(){
        System.out.println("\n=== DATA MAHASISWA  ===");
        for (Mahasiswa m : data){
            if (m.status.equals("aktif")) {
                System.out.println(m.npm + " | " + m.nama + " | " + m.ipk + " | " + m.kategori);
            }
        }
    }
    // Edit Data
   static void editData() {
        System.out.printl("Masukkan NPM");
        String npm = input.nextLine();

        for (Mahasiswa m : data) {
            if (m.npm.equals(npm)) && m .status.equals("aktif") {
                System.out.print("Nama Lengkap baru: ");
                m.nama = input.nextLine();
                System.out.print("IPK baru: ");
                m.ipk = input.nextDouble();
                input.nextLine();

                if (m.ipk >= 3.7) m.kategori = "A";
                else if (m.ipk >= 3.0) m.kategori = "B";
                else m.kategori = "C";
                
                System.out.println("Data berhasil diupdate\n");
                return;
                
            }
        }
        System.out.println("Data tidak ditemukan\n");
   }
   // Hapus Data
    static void hapusData() {
        System.out.print("Masukkan NPM: ");
        String npm = input.nextLine();

        for (Mahasiswa m : data) {
            if (m.npm.equals(npm) && m.status.equals("aktif")) {
                m.status = "nonaktif";
                System.out.println("Data berhasil dihapus\n");
                return;
            }
        }
        System.out.println("Data tidak ditemukan\n");
    }
    

//Searching 
    static void cariNama() {
        System.out.print("Masukkan Nama Lengkap");
        String Nama = input.nextline();
        boolean ditemukan = false;

        for (Mahasiswa m : data) {
            if (m.nama.equalsIgnoresCase(nama) && m.status.equals("aktif")) {
                System.out.println("Data ditemukan: " + m.npm + " | " + m.nama + "|" + m.ipk " | " + m.kategori);
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Data tidak ditemukan");
        }
    }

    static void binarySearchNPM() {
        bubbleSortNPM();

        System.out.print("Masukkan NPM: ");
        String cari = input.nextline();

        int low = 0;
        int high = data.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = data.get(mid).npm.compareTo(cari);

            if (cmp == 0) {
                if (data.get(mid).status.equals("Aktif")) {
                    System.out.println("Data ditemukan: " + data.get(mid).nama + " (" + data.get(mid).ipk + ")");
                } else {
                    System.out.println("Data ditemukan tetapi berstatus nonaktif");
                }
                return;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Data tidak ditemukan");
    }
}
