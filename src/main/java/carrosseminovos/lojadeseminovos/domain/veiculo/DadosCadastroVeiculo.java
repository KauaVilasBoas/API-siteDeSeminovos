package carrosseminovos.lojadeseminovos.domain.veiculo;

import carrosseminovos.lojadeseminovos.domain.veiculo.foto.DadosFoto;
import carrosseminovos.lojadeseminovos.domain.veiculo.foto.Foto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DadosCadastroVeiculo(
        @NotBlank
        String marca,
        @NotBlank
        String modelo,
        @NotBlank
        String anoFabEMod,
        @NotBlank
        String versao,
        @NotBlank
        String cambio,
        Integer qtdePortas,
        @NotBlank
        String combustivel,
        @NotNull
        Integer km,
        @NotBlank
        String placa,
        @NotNull
        Double preco,
        @NotBlank
        String descricao,
        @NotNull
        @Valid
        List<DadosFoto> urlFotos
) {
}
