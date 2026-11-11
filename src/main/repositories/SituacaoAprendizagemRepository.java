package main.repositories;

import main.models.SituacaoAprendizagem;
import main.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface SituacaoAprendizagemRepository extends JpaRepository<SituacaoAprendizagem, Long> {
    List<Usuario> findByInstrutorId(Long instrutorId);
    List<SituacaoAprendizagem> findByCompartilhadaTrue();
}
