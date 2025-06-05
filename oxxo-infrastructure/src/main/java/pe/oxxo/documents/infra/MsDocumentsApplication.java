package pe.oxxo.documents.infra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "pe.oxxo.documents")
public class MsDocumentsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsDocumentsApplication.class, args);
    }

}

