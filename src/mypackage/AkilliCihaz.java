/*
 *
 * @author Emirhan ŞENSOY - emirhan.sensoy@ogr.sakarya.edu.tr
 * @since 18 Nisan 2021 Pazar, 14:07:51
 *
 */

package mypackage;

public class AkilliCihaz
{
    private final IAlgilayici algilayici;
    private final IEyleyici eyleyici;
    private final IAgArayuzu agArayuzu;
    private final IEkran ekran;
    private final ISubject publisher;

    private static final int SICAKLIK_GORUNTULEME = 1;
    private static final int SOGUTUCU_AC = 2;
    private static final int SOGUTUCU_KAPAT = 3;
    private static final int CIKIS = 4;

    public AkilliCihaz(ISubject publisher)
    {
        algilayici = new Algilayici();
        eyleyici = new Eyleyici();
        agArayuzu = new AgArayuzu();
        ekran = new Ekran();
        this.publisher = publisher;
    }

    public void calistir()
    {
        String kullaniciAdi;
        String sifre;

        int sayac = 0;

        while(true)
        {
            ekran.mesajGoruntule("Kullanıcı Adı..:");
            kullaniciAdi = ekran.veriAl();
            ekran.mesajGoruntule("Şifre..:");
            sifre = ekran.veriAl();

            IAkilliCihazBilgiSistemi akilliCihazBilgiSistemi = new AkilliCihazBilgiSistemi.AkilliCihazBilgiSistemiBuilder(new PostgreSQLSurucu()).build();
            KullaniciHesabi kullaniciHesabi = this.kullaniciDogrulama(kullaniciAdi, sifre, akilliCihazBilgiSistemi);

            if(kullaniciHesabi != null)
            {
                Araclar.bekle(700);
                publisher.notify("Giriş yapıldı.");
                System.out.println("---Hoşgeldin " + kullaniciHesabi.getAd() + "---");
                islemSecimi();
                break;
            }
            else
            {
                if(sayac == 2)
                {
                    System.out.println("3 defa hatalı giriş yaptınız.\nLütfen yetkili servisimiz ile iletişime geçiniz...");
                    break;
                }
                System.out.println("Kullanıcı adı veya şifrenizi yanlış girdiniz.\nLütfen tekrar deneyiniz.");
            }
            sayac++;

            Araclar.bekle(700);
        }
    }

    private KullaniciHesabi kullaniciDogrulama(String kullaniciAdi, String sifre, IAkilliCihazBilgiSistemi akilliCihazBilgiSistemi)
    {
        return akilliCihazBilgiSistemi.kullaniciDogrula(kullaniciAdi,sifre);
    }

    private void islemSecimi()
    {
        int secim;
        do
        {
            secim = anaMenuyuGoster();

            switch (secim)
            {
                case SICAKLIK_GORUNTULEME -> {
                    IIslem sicaklikGoruntuleme = new SicaklikGoruntuleme.SicaklikGoruntulemeBuilder(ekran, algilayici, agArayuzu).build();
                    sicaklikGoruntuleme.islemYap();
                    publisher.notify("Sıcaklık görüntülendi.");
                }
                case SOGUTUCU_AC -> {
                    IIslem sogutucuAc = new SogutucuAc.SogutucuAcBuilder(ekran, eyleyici, agArayuzu).build();
                    sogutucuAc.islemYap();
                    publisher.notify("Soğutucu aç çalıştırıldı.");
                }
                case SOGUTUCU_KAPAT -> {
                    IIslem sogutucuKapat = new SogutucuKapat.SogutucuKapatBuilder(ekran, eyleyici, agArayuzu).build();
                    sogutucuKapat.islemYap();
                    publisher.notify("Soğutucu kapat çalıştırıldı.");
                }
                case CIKIS -> {
                    ekran.mesajGoruntule("Çıkış yapılıyor...");
                    publisher.notify("Çıkış yapıldı.");
                }
                default -> {
                    Araclar.bekle(200);
                    ekran.mesajGoruntule("1-4 arasında bir sayı girmelisiniz.");
                    Araclar.bekle(600);
                }
            }
        }
        while(secim != 4);
    }

    private int anaMenuyuGoster()
    {
        ekran.mesajGoruntule("**********************************************");
        ekran.mesajGoruntule("Ana Menü");
        ekran.mesajGoruntule("1-Sıcaklık Görüntüle");
        ekran.mesajGoruntule("2-Soğutucuyu Aç");
        ekran.mesajGoruntule("3-Soğutucuyu Kapat");
        ekran.mesajGoruntule("4-Çıkış");
        ekran.mesajGoruntule("**********************************************");
        ekran.mesajGoruntule("Seçiminiz..: ");
        return Integer.parseInt(ekran.veriAl());
    }
}
