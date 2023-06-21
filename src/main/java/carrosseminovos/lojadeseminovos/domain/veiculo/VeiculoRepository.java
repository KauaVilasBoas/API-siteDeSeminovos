package carrosseminovos.lojadeseminovos.domain.veiculo;

import carrosseminovos.lojadeseminovos.domain.veiculo.filtros.DadosFiltrarPorCambio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    List<Veiculo> findAllByCambioEquals(String cambio);

}
