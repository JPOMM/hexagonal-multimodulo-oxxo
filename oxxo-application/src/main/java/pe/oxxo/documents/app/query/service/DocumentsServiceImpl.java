package pe.oxxo.documents.app.query.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.oxxo.documents.domain.model.Documents;
import pe.oxxo.documents.domain.puerto.DocumentsRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DocumentsServiceImpl implements DocumentsService {

    private final DocumentsRepository documentsRepository;

    @Override
    public Documents save(Documents documents) {
        Optional.ofNullable(documents.getId())
                .ifPresentOrElse(
                        id -> documents.setDateUpdated(LocalDateTime.now()),
                        () -> {
                            LocalDateTime now = LocalDateTime.now();
                            documents.setDateCreated(now);
                            documents.setDateUpdated(now);
                        }
                );
        return documentsRepository.saveDocuments(documents);
    }
}
