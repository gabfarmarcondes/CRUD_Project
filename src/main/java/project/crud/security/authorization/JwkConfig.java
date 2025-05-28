package project.crud.security.authorization;

import com.nimbusds.jose.jwk.*;
import com.nimbusds.jose.jwk.source.*;
import com.nimbusds.jose.proc.SecurityContext;
import org.bouncycastle.util.io.pem.PemReader;

import java.io.FileReader;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwkConfig {

    @Bean
    public JWKSource<SecurityContext> jwkSource() throws Exception {
        RSAPublicKey publicKey = loadPublicKey("src/main/resources/keys/public_key.pem");
        RSAPrivateKey privateKey = loadPrivateKey("src/main/resources/keys/private_key.pem");

        RSAKey rsaKey = new RSAKey.Builder(publicKey)
                .privateKey(privateKey)
                .keyID(UUID.randomUUID().toString())
                .build();

        JWKSet jwkSet = new JWKSet(rsaKey);
        return new ImmutableJWKSet<>(jwkSet);
    }

    private RSAPrivateKey loadPrivateKey(String filepath) throws Exception {
        try (PemReader pemReader = new PemReader(new FileReader(filepath))) {
            byte[] content = pemReader.readPemObject().getContent();
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(content);
            KeyFactory kf = KeyFactory.getInstance("RSA");
            return (RSAPrivateKey) kf.generatePrivate(spec);
        }
    }

    private RSAPublicKey loadPublicKey(String filepath) throws Exception {
        try (PemReader pemReader = new PemReader(new FileReader(filepath))) {
            byte[] content = pemReader.readPemObject().getContent();
            X509EncodedKeySpec spec = new X509EncodedKeySpec(content);
            KeyFactory kf = KeyFactory.getInstance("RSA");
            return (RSAPublicKey) kf.generatePublic(spec);
        }
    }
}
