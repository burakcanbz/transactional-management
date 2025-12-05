#!/bin/bash

echo "Tüm çalışan Spring Boot servisleri aranıyor ve sonlandırılıyor..."

# Durdurulacak servislerin isim desenleri
SERVICE_PATTERNS="(order|user|product|auth|notification|inventory|gateway)"

PIDS=$(ps aux | grep "java -jar" | grep -E "$SERVICE_PATTERNS" | grep -v "grep" | awk '{print $2}' | tr '\n' ' ')

if [ -z "$PIDS" ]; then
    echo "✅ Şu anda çalışan Spring Boot servisi bulunamadı."
else
    echo "Aşağıdaki PID'ler sonlandırılıyor: $PIDS"
    kill -9 $PIDS

    echo "----------------------------------------------------"
    echo "✅ Tüm servisler başarıyla sonlandırma komutu aldı."
fi

sleep 2
echo "----------------------------------------------------"
echo "Kontrol:"
ps aux | grep "java -jar" | grep -E "$SERVICE_PATTERNS" | grep -v "grep"
echo "Eğer yukarıda PID görünmüyorsa, sonlandırma başarılıdır."