package pe.oxxo.documents.infra.adaptador;

import org.springframework.data.repository.CrudRepository;
import pe.oxxo.documents.infra.entity.DocumentsEntity;

public interface DocumentsCrudRepositoryPostgresql extends CrudRepository<DocumentsEntity, Integer> {
}
