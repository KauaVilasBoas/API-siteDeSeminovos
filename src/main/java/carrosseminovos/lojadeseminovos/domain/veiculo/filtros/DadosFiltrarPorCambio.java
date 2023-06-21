package carrosseminovos.lojadeseminovos.domain.veiculo.filtros;

import jakarta.validation.constraints.NotBlank;

public record DadosFiltrarPorCambio(@NotBlank String cambio) {
}
