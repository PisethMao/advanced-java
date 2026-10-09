package org.example.allnewfeaturesinjava27.keystore;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.KeyStore;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Arrays;

public class KeyStoreCreationInstantDemo {
    void main() throws Exception {
        char[] password = "demo-password-123".toCharArray();
        Path file = Path.of("demo-keys.p12");
        String alias = "api-aes-key";
        try {
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(null, password);
            KeyGenerator generator = KeyGenerator.getInstance("AES");
            generator.init(256);
            SecretKey secretKey = generator.generateKey();
            KeyStore.PasswordProtection protection = new KeyStore.PasswordProtection(password);
            try {
                keyStore.setEntry(
                        alias,
                        new KeyStore.SecretKeyEntry(secretKey),
                        protection
                );
            } finally {
                protection.destroy();
            }
            try (OutputStream out = Files.newOutputStream(file)) {
                keyStore.store(out, password);
            }
            KeyStore restored = KeyStore.getInstance("PKCS12");
            try (InputStream in = Files.newInputStream(file)) {
                restored.load(in, password);
            }
            Instant created = restored.getCreationInstant(alias);
            if (created == null) {
                IO.println("Alias not found");
                return;
            }
            long ageDays = Duration.between(
                    created,
                    Instant.now()
            ).toDays();
            IO.println("Alias: " + alias);
            IO.println("Created UTC: " + created);
            IO.println("Created Cambodia: " + created.atZone(ZoneId.of("Asia/Phnom_Penh")));
            IO.println("Age (days): " + ageDays);
        } finally {
            Arrays.fill(password, '\0');
        }
    }
}

