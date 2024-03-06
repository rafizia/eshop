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

# Module 3

### Reflection
Prinsip SOLID yang saya terapkan dalam proyek ini adalah prinsip _Single Responsibility Principle (SRP)_, _Interface Segregation Principle (ISP)_, dan _Dependency Inversion Principle (DIP)_. Prinsip _Single Responsibility Principle (SRP)_ saya terapkan dengan memisahkan dua Controller yang terdapat dalam proyek ini yaitu CarController dan ProductController menjadi dua file berbeda, sehingga tiap Controller hanya bertanggung jawab pada satu aspek fungsionalitas aplikasi. Selanjutnya prinsip _Interface Segregation Principle (ISP)_ saya terapkan dengan memisahkan interface CarService.java menjadi unit-unit kecil seperti CarCreateService.java, CarDeletionService.java, CarFindService.java, dan CarUpdateService.java. Pemisahan ini bertujuan agar class-class yang terdapat dalam aplikasi hanya perlu mengetahui method-method yang benar-benar dibutuhkannya, tanpa harus dibebani dengan method-method yang tidak relevan. Kemudian prinsip _Dependency Inversion Principle (DIP)_ saya terapkan dengan menggunakan interface-interface CarService sebelumnya sehingga controller tidak lagi bergantung pada implementasi spesifik CarServiceImpl, melainkan hanya bergantung pada abstraksi dari CarService yang didefinisikan oleh interface.<br>

Menerapkan prinsip SOLID dalam sebuah proyek menghasilkan desain perangkat lunak yang terstruktur, mudah dipelihara, dan mudah diperluas. Sebagai contoh, kita dapat menerapkan _Single Responsibility Principle (SRP)_ dengan memisahkan class-class ke dalam unit-unit yang bertanggung jawab atas satu aspek fungsionalitas saja, seperti memisahkan kelas CarController dan ProductController. Dengan menerapkan prinsip-prinsip SOLID ini secara konsisten, proyek perangkat lunak akan memiliki desain yang lebih modular, mudah dipahami, dan lebih mudah dikelola serta diperluas seiring waktu.<br>

Sebaliknya dengan mengabaikan prinsip-prinsip ini dapat menghasilkan kode yang sulit untuk diuji, sulit diperbaiki, dan sulit untuk diadaptasi dengan kebutuhan baru. Hal Ini dapat mengurangi kualitas keseluruhan dari basis kode dan dapat meningkatkan biaya pemeliharaan serta mengurangi kecepatan pengembangan dalam jangka panjang. Contohnya tanpa menerapkan prinsip _Single Responsibility Principle_, sebuah class dapat mengambil lebih banyak tanggung jawab daripada yang seharusnya, membuatnya sulit untuk dipahami, diubah, atau diperbaiki tanpa mempengaruhi komponen lain dari proyek.

# Module 4

### Reflection
Menurut saya, TDD sangat berguna karena saya harus memikirkan desain dan struktur kode sebelum memulai penulisan kode sebenarnya, yang pada gilirannya meningkatkan kualitas kode secara keseluruhan. Namun masih banyak kekurangan pada penerapan TDD pada kode saya. Untuk memperbaiki kekurangan ini, saya perlu menggunakan lebih banyak waktu dalam membuat sebuah tes, sehingga saya dapat membuat tes yang lebih efektif dan efisien.

Mengenai prinsip F.I.R.S.T dalam tes, saya merasa bahwa terdapat beberapa hal dimana tes yang saya lakukan bisa lebih baik. Misalnya, saya perlu fokus pada peningkatan kecepatan eksekusi tes untuk mendukung siklus pengembangan yang lebih cepat. Dengan menerapkan prinsip F.I.R.S.T dengan lebih ketat, saya berharap dapat meningkatkan efektivitas tes saya secara signifikan sehingga dapat meningkatkan kualitas perangkat lunak yang saya kembangkan.