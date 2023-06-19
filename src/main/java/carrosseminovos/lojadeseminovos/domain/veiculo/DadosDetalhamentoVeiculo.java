package carrosseminovos.lojadeseminovos.domain.veiculo;

import java.util.List;

public record DadosDetalhamentoVeiculo(String marca, String modelo, String anoFabEMod, String versao, String cambio, String qtdePortas, String combustivel, Integer km, String placa, Double preco, String descricao, List<String> urlFotos) {
}
