package pe.oxxo.documents.infra.adaptador;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pe.oxxo.documents.domain.model.Documents;
import pe.oxxo.documents.domain.puerto.DocumentsRepository;
import pe.oxxo.documents.infra.entity.DocumentsEntity;
import pe.oxxo.documents.infra.mapper.DocumentsMapper;


@Repository
@AllArgsConstructor
public class DocumentsRepositoryPostgresql  implements DocumentsRepository {

    private DocumentsMapper documentsMapper;

    private final DocumentsCrudRepositoryPostgresql documentsCrudRepositoryPostgresql;

    @Override
    public Documents saveDocuments(Documents documents) {
        DocumentsEntity documentsEntity = this.documentsMapper.toDocumentsEntity(documents);
        return this.documentsMapper.toDocuments(this.documentsCrudRepositoryPostgresql.save(documentsEntity));
    }
}
