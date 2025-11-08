#!/bin/bash
# ---------------------------------------------
# Mikroservisleri Arka Planda Başlatma Betiği
# ---------------------------------------------

# Proje adları ve JAR yolları
ORDER_JAR="./order/target/order-0.0.1-SNAPSHOT.jar"
FOURTH_JAR="./product/target/product-0.0.1-SNAPSHOT.jar"
USER_JAR="./user/target/user-0.0.1-SNAPSHOT.jar"
AUTH_JAR="./auth/target/auth-0.0.1-SNAPSHOT.jar"

mkdir -p logs
rm -f logs/*.log

start_service() {
    SERVICE_NAME=$1
    JAR_PATH=$2
    LOG_FILE="logs/${SERVICE_NAME}.log"

    if [ ! -f "$JAR_PATH" ]; then
        echo "❌ HATA: ${SERVICE_NAME} JAR dosyası bulunamadı: ${JAR_PATH}"
        echo "Lütfen önce tüm servisleri Maven ile paketleyin: mvn clean package"
        return 1
    fi

    echo "▶️ ${SERVICE_NAME} başlatılıyor... (Log: ${LOG_FILE})"
    # nohup: Çıkış yapsanız bile çalışmaya devam et
    # > log.txt 2>&1: stdout ve stderr'yi log dosyasına yönlendir
    # &: Arka planda çalıştır
    nohup java -jar "$JAR_PATH" > "$LOG_FILE" 2>&1 &
    echo "   PID: $!" # İşlem ID'sini (PID) yazdır
}

# Tüm servisleri başlat
start_service "Order-Service" "$ORDER_JAR"
start_service "User-Service" "$USER_JAR"
start_service "Auth-Service" "$AUTH_JAR"
start_service "Fourth-Service" "$FOURTH_JAR"

echo "--------------------------------------------------------"
echo "Tüm başlatma komutları gönderildi."

# Servislerin başlaması için kısa bir bekleme
sleep 5

echo "--------------------------------------------------------"
echo "Çalışan Java işlemleri (PID, Kullanıcı, Komut):"
pgrep -f "java -jar" | xargs -r ps -f -o pid,user,cmd | grep -E "(order|user|auth|fourth)"
echo "--------------------------------------------------------"
echo "Logları kontrol etmek için: tail -f logs/Order-Service.log"