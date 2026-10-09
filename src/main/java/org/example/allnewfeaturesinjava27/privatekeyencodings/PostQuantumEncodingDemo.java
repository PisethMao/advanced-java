package org.example.allnewfeaturesinjava27.privatekeyencodings;

import javax.crypto.KEM;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;

public class PostQuantumEncodingDemo {
    void main() throws Exception {
        KeyPairGenerator dsaGenerator = KeyPairGenerator.getInstance("ML-DSA-65");
        KeyPair dsaKeys = dsaGenerator.generateKeyPair();
        byte[] dsaEncoded = dsaKeys.getPrivate().getEncoded();
        IO.println("ML-DSA private key format: " + dsaKeys.getPrivate().getFormat());
        IO.println("ML-DSA encoded size: " + dsaEncoded.length + " bytes");
        KeyFactory dsaFactory = KeyFactory.getInstance("ML-DSA");
        PrivateKey restoredDsaKey = dsaFactory.generatePrivate(new PKCS8EncodedKeySpec(dsaEncoded));
        byte[] data = "Transaction TXN123: USD 100".getBytes(StandardCharsets.UTF_8);
        Signature signer = Signature.getInstance("ML-DSA");
        signer.initSign(restoredDsaKey);
        signer.update(data);
        byte[] signature = signer.sign();
        Signature verifier = Signature.getInstance("ML-DSA");
        verifier.initVerify(dsaKeys.getPublic());
        verifier.update(data);
        IO.println("ML-DSA verified: " + verifier.verify(signature));
        KeyPairGenerator kemGenerator = KeyPairGenerator.getInstance("ML-KEM-768");
        KeyPair kemKeys = kemGenerator.generateKeyPair();
        byte[] kemEncoded = kemKeys.getPrivate().getEncoded();
        IO.println("ML-KEM private key format: " + kemKeys.getPrivate().getFormat());
        IO.println("ML-KEM encoded size: " + kemEncoded.length + " bytes");
        KeyFactory kemFactory = KeyFactory.getInstance("ML-KEM");
        PrivateKey restoredKemKey = kemFactory.generatePrivate(new PKCS8EncodedKeySpec(kemEncoded));
        KEM kem = KEM.getInstance("ML-KEM");
        KEM.Encapsulated encapsulated = kem.newEncapsulator(kemKeys.getPublic()).encapsulate();
        SecretKey receiverSecret = kem.newDecapsulator(restoredKemKey)
                .decapsulate(encapsulated.encapsulation());
        boolean matchingSecrets = MessageDigest
                .isEqual(encapsulated.key().getEncoded(), receiverSecret.getEncoded());
        IO.println("ML-KEM shared secrets match: " + matchingSecrets);
    }
}

