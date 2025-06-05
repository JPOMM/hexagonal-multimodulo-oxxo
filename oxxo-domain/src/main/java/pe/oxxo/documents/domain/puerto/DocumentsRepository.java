package pe.oxxo.documents.domain.puerto;

import pe.oxxo.documents.domain.model.Documents;


public interface DocumentsRepository {

    Documents saveDocuments(Documents documents);
}
