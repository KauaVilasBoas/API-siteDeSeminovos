package carrosseminovos.lojadeseminovos.domain.veiculo.foto;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FotoRepository extends JpaRepository<Foto, Long> {

    List<Foto> findAllByVeiculoId(Long id);

}
