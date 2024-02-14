Nama: Muhammad Rafi Zia Ulhaq<br>
NPM: 2206814551<br>
Kelas: Pemrograman Lanjut B<br>

# Module 1

### Reflection 1
Dalam tugas ini saya sudah menerapkan beberapa prinsip *clean code* seperti penamaan variabel, *method*, dan *class* yang deskriptif serta sesuai dengan fungsinya. Hal ini dilakukan untuk memudahkan pembacaan dan pemahaman kode. Di samping itu saya juga menerapkan aturan penamaan seperti camelCase untuk variabel dan *method*. Penggunaan komentar yang jelas dan informatif juga diterapkan untuk menjelaskan bagian-bagian kode yang kompleks. Selain itu, saya juga sudah mengimplementasikan *unit test* dan *functional test* untuk mengecek apakah program sudah berjalan dengan semestinya. Namun ada beberapa hal yang ingin saya tingkatkan dari tugas ini seperti adanya validasi input dari pengguna atau sumber eksternal untuk mencegah serangan XSS dan CSRF.
### Reflection 2
1. *Unit test* membantu saya memverifikasi bahwa setiap komponen atau fungsi dalam kode bekerja sesuai yang diharapkan. Terkait dengan banyaknya *unit test* yang harus dilakukan, menurut saya tidak ada aturan baku mengenai jumlahnya. Namun, *unit test* harus mencakup semua kasus uji yang mungkin. Mengenai *code coverage*, menurut saya 100% tidak menjamin bahwa kode tidak memiliki *bug*. Cakupan kode 100% hanya menunjukkan bahwa semua baris kode telah dijalankan selama pengujian, tetapi tidak menjamin bahwa semua kemungkinan kasus uji telah diuji.
2. Dalam situasi tersebut perlu dipertimbangkan apakah akan terjadi duplikasi kode. Duplikasi kode dapat mengurangi kebersihan dan kualitas kode karena dapat menyebabkan kesulitan dalam pemeliharaan dan meningkatkan kompleksitas. Lebih baik mempertimbangkan untuk mengekstrak bagian yang serupa dari kedua *class functional test* ke dalam *method* atau *class* terpisah untuk digunakan kembali di kedua *class functional test* tersebut. Dengan cara ini, duplikasi kode dapat dikurangi, meningkatkan keterbacaan dan pemeliharaan kode, sehingga meningkatkan kebersihan dan kualitas kode secara keseluruhan.

# Module 2

### Reflection
Dalam tugas ini salah satu *code quality issue(s)* yang saya temukan adalah *code coverage* yang sangat minim. Saya menemukan beberapa bagian kode yang tidak diuji dengan baik atau bahkan tidak diuji sama sekali. Untuk meningkatkan cakupan pengujian kode, saya menulis lebih banyak unit tes, termasuk pengujian untuk kasus-kasus batas dan skenario yang berbeda.
Saya merasa bahwa penerapan CI/CD workflows (GitHub)/pipelines (GitLab) saat ini sudah memenuhi definisi CI/CD dengan baik. Hal ini terlihat dari proses otomatis yang menjalankan rangkaian pengujian secara terus-menerus setiap kali ada perubahan kode. Selain itu, integrasi dengan alat analisis kualitas kode seperti Sonarcloud juga membantu memastikan bahwa kode yang dihasilkan memenuhi standar kualitas yang diharapkan secara konsisten.