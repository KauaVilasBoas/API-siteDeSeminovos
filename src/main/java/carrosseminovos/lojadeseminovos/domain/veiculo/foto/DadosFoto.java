package carrosseminovos.lojadeseminovos.domain.veiculo.foto;

import jakarta.validation.constraints.NotBlank;

public record DadosFoto(@NotBlank(message = "A URL não pode ser nula") String url) {
}
