package carrosseminovos.lojadeseminovos.domain.veiculo;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoVeiculo(@NotNull Long id, String marca, String modelo, String anoFabEMod, String versao, String cambio, Integer qtdePortas, String combustivel, Integer km, String placa, Double preco,
                                      String descricao) {
}
