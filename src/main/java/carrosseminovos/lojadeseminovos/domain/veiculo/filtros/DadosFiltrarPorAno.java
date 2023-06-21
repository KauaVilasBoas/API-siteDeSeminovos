package carrosseminovos.lojadeseminovos.domain.veiculo.filtros;

import jakarta.validation.constraints.NotBlank;

public record DadosFiltrarPorAno(@NotBlank String ano) {
}
