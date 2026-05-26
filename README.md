SISTEM MANAJEMEN NILAI MAHASISWA

Deskripsi Singkat
Program ini adalah aplikasi berbasis Command Line Interface (CLI) 
untuk mengelola data nilai IPK mahasiswa. Program ini diimplementasikan 
menggunakan bahasa Java tanpa library tambahan untuk algoritma pencarian 
dan pengurutan, sesuai dengan instruksi UAS.

Fitur yang tersedia meliputi:
- CRUD Operations (dengan sistem Soft Delete)
- Searching: Linear Search (Nama, Kategori) & Binary Search (NPM)
- Sorting: Bubble Sort (NPM, IPK) & Selection Sort (Nama)
- Statistik Data
- File I/O untuk memuat dan menyimpan data secara permanen.

Persyaratan Sistem (Prerequisites):
- Java Development Kit (JDK) versi 8 atau lebih baru terinstal.
- Terminal, Command Prompt (CMD), atau PowerShell.

Cara Menjalankan Program via Visual Studio Code:
1. Pastikan ekstensi "Extension Pack for Java" sudah terinstal di VS Code.
2. Buka folder proyek ini melalui menu File > Open Folder.
3. Pilih folder projek ini yang ada file SistemNilaiIPKMahasiswa.java dan DataMahasiswa.txt.
4. Jalankan SistemNilaiIPKMahasiswa.java dengan mengklik tombol "Run" di kanan atas, atau klik kanan lalu pilih "Run Code"
5. Lakukan interaksi dengan program (mengetik pilihan menu/data) 
   melalui tab "Terminal" di bagian bawah layar.

Catatan Penggunaan:
1. Penyimpanan Data: Program akan membaca data dari file 
   "DataMahasiswa.txt". Jika file belum ada, program akan memulai 
   dengan data kosong.
2. Menyimpan Perubahan: Setiap kali Anda selesai menambah, mengubah, 
   atau menghapus data, PASTIKAN untuk keluar menggunakan menu 
   "13. Keluar dan Simpan" agar semua perubahan tersimpan ke dalam file teks. 
   Anda juga bisa menggunakan menu "12" untuk menyimpan kapan saja.
3. Input: Pastikan memasukkan tipe data yang sesuai pada setiap menu 
   (misalnya memasukkan angka pada menu pilihan) agar program berjalan lancar.

================================================================
