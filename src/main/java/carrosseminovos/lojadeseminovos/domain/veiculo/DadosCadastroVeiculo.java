package carrosseminovos.lojadeseminovos.domain.veiculo;

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
        String qtdePortas,
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
        List<String> urlFotos
) {
}
